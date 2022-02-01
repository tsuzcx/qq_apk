package com.tencent.upload.network.session;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import com.tencent.upload.network.route.IUploadRouteStrategy;
import com.tencent.upload.network.route.RouteFactory;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.UploadLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SessionPool
  implements IUploadSessionCallback
{
  private static final int CLOSE_WAIT_TIME = 240000;
  private static final int MSG_CLOSE_POOL = 110000;
  private static final int MSG_REBUILD_SESSIONS = 110001;
  private static final String TAG = "SessionPool";
  private static final Map<String, String> sSessionIdMap = new HashMap();
  private volatile boolean mClosed = false;
  private UploadRoute mCurrentRoute;
  private List<IUploadSession> mDetectingSession;
  private Const.FileType mFileType;
  private boolean mInited;
  private int mLastErrorCode = 0;
  private SessionPool.PoolStateListener mListener;
  private UploadConfiguration.NetworkStateObserver mNetworkStateObserver;
  private int mPoolInitSize;
  private int mRouteFailTimes = 0;
  private IUploadRouteStrategy mRouteStrategy;
  private BlockingQueue<IUploadSession> mSessionQueue;
  private HandlerThread mThread;
  private Handler mWorkHandler;
  private String oldIp;
  
  public SessionPool(Const.FileType paramFileType)
  {
    this.mFileType = paramFileType;
  }
  
  private boolean changeRoute(int paramInt)
  {
    this.mClosed = false;
    this.mInited = false;
    UploadLog.d(getTag(), "do change route.");
    cleanSessions();
    if (this.mRouteStrategy == null) {
      this.mRouteStrategy = RouteFactory.createRouteStrategy(this.mFileType);
    }
    if (isNetworkAvailable())
    {
      UploadRoute localUploadRoute = this.mRouteStrategy.next(this.mCurrentRoute, paramInt);
      if (localUploadRoute == null)
      {
        UploadLog.d("SessionPool", "changeRoute get next route null");
        return false;
      }
      createSession(localUploadRoute);
      UploadLog.d("SessionPool", "changeRoute get next route !");
    }
    else
    {
      UploadLog.d("SessionPool", "changeRoute network is not available return");
    }
    return true;
  }
  
  private void createSession(int paramInt, UploadRoute paramUploadRoute)
  {
    try
    {
      Object localObject1 = getTag();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("createSession num: ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" route:");
      ((StringBuilder)localObject2).append(paramUploadRoute);
      UploadLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
      this.mCurrentRoute = paramUploadRoute.clone();
      int i = 0;
      while (i < paramInt)
      {
        localObject1 = new UploadSession(this.mThread.getLooper(), this, this.mFileType);
        if (((UploadSession)localObject1).open(paramUploadRoute))
        {
          localObject2 = getTag();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("createSession open success !! id:");
          localStringBuilder.append(localObject1.hashCode());
          UploadLog.d((String)localObject2, localStringBuilder.toString());
          this.mDetectingSession.add(localObject1);
        }
        else
        {
          UploadLog.e(getTag(), "createSession open fail !!");
        }
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramUploadRoute;
    }
  }
  
  private void createSession(UploadRoute paramUploadRoute)
  {
    if (paramUploadRoute == null)
    {
      String str = getTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create session route == ");
      localStringBuilder.append(paramUploadRoute);
      UploadLog.d(str, localStringBuilder.toString());
      return;
    }
    createSession(this.mPoolInitSize, paramUploadRoute);
  }
  
  public static String getSessionIdByPath(String paramString)
  {
    return (String)sSessionIdMap.get(paramString);
  }
  
  private String getTag()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SessionPool-");
    localStringBuilder.append(this.mFileType);
    return localStringBuilder.toString();
  }
  
  private void initHandler(Looper paramLooper)
  {
    if (paramLooper != null)
    {
      this.mWorkHandler = new SessionPool.WorkThreadHandler(this, paramLooper);
      return;
    }
    throw new IllegalArgumentException("initHandler Exception looper == null !!");
  }
  
  private void initNetworkListener()
  {
    this.mNetworkStateObserver = new SessionPool.1(this);
    UploadConfiguration.registerNetworkStateObserver(this.mNetworkStateObserver);
  }
  
  private void initSessions()
  {
    this.mInited = false;
    this.mRouteStrategy = RouteFactory.createRouteStrategy(this.mFileType);
    if (isNetworkAvailable())
    {
      createSession(this.mRouteStrategy.reset());
      return;
    }
    UploadLog.d("SessionPool", "initSessions network is not available !");
  }
  
  private static boolean isInVaildServer(int paramInt)
  {
    return (paramInt == Const.UploadRetCode.EINPROGRESS.getCode()) || (paramInt == Const.UploadRetCode.EAGAIN.getCode());
  }
  
  private static boolean isNetworkAvailable()
  {
    return UploadConfiguration.isNetworkAvailable();
  }
  
  public static boolean isNetworkUnavailable(int paramInt)
  {
    Object localObject1 = UploadConfiguration.getNetworkUnavailableRetCode();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("check network unavailable code, retCodeList:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(", targetCode:");
    ((StringBuilder)localObject2).append(paramInt);
    UploadLog.i("SessionPool", ((StringBuilder)localObject2).toString());
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split(",");
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i].trim();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(String.valueOf(paramInt))))
          {
            UploadLog.i("SessionPool", "check network unavailable: true");
            return true;
          }
          i += 1;
        }
      }
    }
    UploadLog.i("SessionPool", "check network unavailable: false");
    return false;
  }
  
  private boolean isSessionValid(IUploadSession paramIUploadSession)
  {
    return (paramIUploadSession != null) && (paramIUploadSession.getState() == IUploadSession.SessionState.ESTABLISHED);
  }
  
  private boolean needChangeNextRoute(int paramInt)
  {
    Object localObject = UploadConfiguration.getChangeRouteRetCode();
    String str = getTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("check needChangeNextRoute, retCodeList:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", targetCode:");
    localStringBuilder.append(paramInt);
    UploadLog.i(str, localStringBuilder.toString());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          str = localObject[i].trim();
          if ((!TextUtils.isEmpty(str)) && (str.equals(String.valueOf(paramInt))))
          {
            UploadLog.i(getTag(), "check needChangeNextRoute: true");
            return true;
          }
          i += 1;
        }
      }
    }
    UploadLog.i(getTag(), "check needChangeNextRoute: false");
    return false;
  }
  
  public static void recordSessionId(String paramString1, String paramString2)
  {
    sSessionIdMap.put(paramString1, paramString2);
  }
  
  private void setPoolInitSize()
  {
    int i = SessionPool.2.$SwitchMap$com$tencent$upload$utils$Const$FileType[this.mFileType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        this.mPoolInitSize = 1;
        return;
      }
      this.mPoolInitSize = 2;
      return;
    }
    this.mPoolInitSize = 2;
  }
  
  public void allIpFailed()
  {
    SessionPool.PoolStateListener localPoolStateListener = this.mListener;
    if (localPoolStateListener != null) {
      localPoolStateListener.allIpFailed(this);
    }
  }
  
  public void cleanSessions()
  {
    Object localObject1 = getTag();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("cleanSessions --- ");
    ((StringBuilder)localObject2).append(this.mSessionQueue.size());
    UploadLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = this.mSessionQueue.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IUploadSession)((Iterator)localObject1).next();
      if (isSessionValid((IUploadSession)localObject2)) {
        ((IUploadSession)localObject2).close();
      }
    }
    this.mSessionQueue.clear();
  }
  
  public void close()
  {
    if (this.mClosed) {
      return;
    }
    UploadLog.d("SessionPool", "close session pool");
    this.mClosed = true;
    this.mSessionQueue.clear();
  }
  
  public int getIdleSessionSize()
  {
    return this.mSessionQueue.size();
  }
  
  public Const.FileType getPoolType()
  {
    return this.mFileType;
  }
  
  public IUploadRouteStrategy getmRouteStrategy()
  {
    return this.mRouteStrategy;
  }
  
  public void init()
  {
    UploadLog.d("SessionPool", "SessionPool init.");
    this.mThread = new HandlerThread(getTag());
    this.mThread.start();
    initHandler(this.mThread.getLooper());
    this.mSessionQueue = new LinkedBlockingQueue(6);
    this.mDetectingSession = new LinkedList();
    initNetworkListener();
    setPoolInitSize();
    initSessions();
  }
  
  protected void invalidate()
  {
    this.mClosed = false;
  }
  
  public boolean isReady()
  {
    return (this.mInited) || (this.mSessionQueue.size() > 0);
  }
  
  public void notifyIdle()
  {
    String str = getTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyIdle --- mSessionQueue size:");
    localStringBuilder.append(this.mSessionQueue.size());
    localStringBuilder.append(" mDetectingSession size:");
    localStringBuilder.append(this.mDetectingSession.size());
    UploadLog.d(str, localStringBuilder.toString());
    if ((this.mSessionQueue.size() == 0) && (this.mDetectingSession.size() == 0)) {
      this.mListener.onSessionPoolError(this, Const.UploadRetCode.NO_SESSION.getCode());
    }
  }
  
  public void offer(IUploadSession paramIUploadSession)
  {
    String str = getTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("offer session --- id:");
    localStringBuilder.append(paramIUploadSession.hashCode());
    UploadLog.d(str, localStringBuilder.toString());
    if ((paramIUploadSession.getState() == IUploadSession.SessionState.ESTABLISHED) && (!this.mSessionQueue.contains(paramIUploadSession))) {
      this.mSessionQueue.offer(paramIUploadSession);
    }
    notifyIdle();
  }
  
  public void onOpenFailed(IUploadSession paramIUploadSession, int paramInt, String paramString)
  {
    if (paramIUploadSession != null) {
      try
      {
        if (this.mDetectingSession.contains(paramIUploadSession))
        {
          paramString = new StringBuilder();
          paramString.append("[connect] ");
          paramString.append(getTag());
          paramString = paramString.toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("failed to open session:");
          localStringBuilder.append(paramIUploadSession.hashCode());
          UploadLog.i(paramString, localStringBuilder.toString());
          this.mDetectingSession.remove(paramIUploadSession);
          paramString = new StringBuilder();
          paramString.append("[connect] ");
          paramString.append(getTag());
          paramString = paramString.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onOpenFailed remove from mDetectingSession, current size:");
          localStringBuilder.append(this.mDetectingSession.size());
          UploadLog.i(paramString, localStringBuilder.toString());
          if ((paramIUploadSession.getUploadRoute().isDuplicate(this.mCurrentRoute)) && (this.mSessionQueue.size() == 0) && (this.mDetectingSession.size() == 0)) {
            if (isNetworkAvailable())
            {
              paramIUploadSession = this.mRouteStrategy.next(this.mCurrentRoute, 0);
              if (paramIUploadSession == null)
              {
                paramIUploadSession = new StringBuilder();
                paramIUploadSession.append("[connect] ");
                paramIUploadSession.append(getTag());
                paramIUploadSession = paramIUploadSession.toString();
                paramString = new StringBuilder();
                paramString.append("all ip failed, mCurrentRoute:");
                paramString.append(this.mCurrentRoute);
                UploadLog.i(paramIUploadSession, paramString.toString());
                allIpFailed();
                return;
              }
              createSession(paramIUploadSession);
            }
            else
            {
              paramIUploadSession = new StringBuilder();
              paramIUploadSession.append("[connect] ");
              paramIUploadSession.append(getTag());
              UploadLog.w(paramIUploadSession.toString(), "network is not available !!");
            }
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public void onOpenSucceed(IUploadSession paramIUploadSession)
  {
    if (paramIUploadSession != null) {
      try
      {
        if (this.mDetectingSession.contains(paramIUploadSession))
        {
          notify();
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[connect] ");
          ((StringBuilder)localObject).append(getTag());
          localObject = ((StringBuilder)localObject).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("session is ready --- id:");
          localStringBuilder.append(paramIUploadSession.hashCode());
          UploadLog.i((String)localObject, localStringBuilder.toString());
          this.mDetectingSession.remove(paramIUploadSession);
          this.mSessionQueue.offer(paramIUploadSession);
          if ((this.mSessionQueue.size() == 1) && (!this.mInited))
          {
            paramIUploadSession = new StringBuilder();
            paramIUploadSession.append("[connect] ");
            paramIUploadSession.append(getTag());
            UploadLog.i(paramIUploadSession.toString(), "sessionPool is inited now !");
            this.mInited = true;
            this.mListener.onSessionPoolRestore(this.mFileType);
          }
          else if (this.mSessionQueue.size() > 0)
          {
            this.mInited = true;
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public void onSessionClosed(IUploadSession paramIUploadSession)
  {
    if (paramIUploadSession == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[connect] ");
    ((StringBuilder)localObject).append(getTag());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSessionClosed ! Session:");
    localStringBuilder.append(paramIUploadSession.hashCode());
    UploadLog.w((String)localObject, localStringBuilder.toString());
    this.mSessionQueue.remove(paramIUploadSession);
    notifyIdle();
  }
  
  public void onSessionError(IUploadSession paramIUploadSession, int paramInt, String paramString)
  {
    if (paramIUploadSession == null) {
      return;
    }
    try
    {
      boolean bool = isNetworkAvailable();
      this.mLastErrorCode = paramInt;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[connect] ");
      ((StringBuilder)localObject).append(getTag());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSessionError ! Session:");
      localStringBuilder.append(paramIUploadSession.hashCode());
      localStringBuilder.append(" errCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" errMsg=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" networkAvailable=");
      localStringBuilder.append(bool);
      UploadLog.w((String)localObject, localStringBuilder.toString());
      this.mSessionQueue.remove(paramIUploadSession);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[connect] ");
      ((StringBuilder)localObject).append(getTag());
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("remove session ");
      localStringBuilder.append(paramIUploadSession.hashCode());
      localStringBuilder.append(" queue size: ");
      localStringBuilder.append(this.mSessionQueue.size());
      UploadLog.w((String)localObject, localStringBuilder.toString());
      if (needChangeNextRoute(paramInt))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[connect] ");
        ((StringBuilder)localObject).append(getTag());
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[dochangeRoute] errCode=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" errMsg=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" currentRoute=");
        localStringBuilder.append(paramIUploadSession.getUploadRoute().toString());
        UploadLog.w((String)localObject, localStringBuilder.toString());
        if (changeRoute(6))
        {
          paramIUploadSession = new StringBuilder();
          paramIUploadSession.append("[connect] ");
          paramIUploadSession.append(getTag());
          UploadLog.i(paramIUploadSession.toString(), "changeRoute success");
        }
        else
        {
          paramIUploadSession = new StringBuilder();
          paramIUploadSession.append("[connect] ");
          paramIUploadSession.append(getTag());
          UploadLog.i(paramIUploadSession.toString(), "changeRoute failed, allIpFailed");
          allIpFailed();
        }
      }
      else
      {
        if ((paramInt == Const.UploadRetCode.EINPROGRESS.getCode()) || (paramInt == Const.UploadRetCode.EAGAIN.getCode()) || (paramInt == Const.UploadRetCode.EHOSTUNREACH.getCode()) || (paramInt == Const.UploadRetCode.ENETUNREACH.getCode()) || (paramInt == Const.UploadRetCode.ENETDOWN.getCode()) || (paramInt == Const.UploadRetCode.ETIMEDOUT.getCode()) || (paramInt == Const.UploadRetCode.ECONNABORTED.getCode())) {
          break label720;
        }
        if ((paramInt == 30100) || (paramInt == Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode())) {
          break label649;
        }
        paramString = new StringBuilder();
        paramString.append("[connect] ");
        paramString.append(getTag());
        paramString = paramString.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reconnect session: ");
        ((StringBuilder)localObject).append(paramIUploadSession.hashCode());
        UploadLog.i(paramString, ((StringBuilder)localObject).toString());
        paramIUploadSession.close();
        paramIUploadSession.open(paramIUploadSession.getUploadRoute());
        this.mDetectingSession.add(paramIUploadSession);
      }
      return;
      label649:
      paramIUploadSession = new StringBuilder();
      paramIUploadSession.append("[connect] ");
      paramIUploadSession.append(getTag());
      paramIUploadSession = paramIUploadSession.toString();
      paramString = new StringBuilder();
      paramString.append("errCode=");
      paramString.append(paramInt);
      paramString.append(" 网络不可用 !");
      UploadLog.w(paramIUploadSession, paramString.toString());
      return;
      label720:
      paramIUploadSession = new StringBuilder();
      paramIUploadSession.append("[connect] ");
      paramIUploadSession.append(getTag());
      paramIUploadSession = paramIUploadSession.toString();
      paramString = new StringBuilder();
      paramString.append("errCode=");
      paramString.append(paramInt);
      paramString.append(" 网络异常 !");
      UploadLog.w(paramIUploadSession, paramString.toString());
      return;
    }
    finally {}
  }
  
  public IUploadSession poll()
  {
    try
    {
      if ((this.mSessionQueue.size() == 0) || (((IUploadSession)this.mSessionQueue.peek()).isExpired()))
      {
        if (this.mSessionQueue.size() > 0)
        {
          IUploadSession localIUploadSession1 = (IUploadSession)this.mSessionQueue.poll();
          if (localIUploadSession1.isExpired())
          {
            localIUploadSession1.close();
            this.mSessionQueue.remove(localIUploadSession1);
          }
        }
        else
        {
          UploadLog.d(getTag(), "queue size == 0");
        }
        UploadLog.d(getTag(), "create one session !");
        createSession(1, this.mCurrentRoute);
        UploadLog.d(getTag(), "wait 30s start...");
        try
        {
          wait(30000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("poll exception ");
          localStringBuilder.append(localInterruptedException);
          UploadLog.d("SessionPool", localStringBuilder.toString());
        }
        UploadLog.d(getTag(), "wait 30s end...");
      }
      IUploadSession localIUploadSession2 = (IUploadSession)this.mSessionQueue.poll();
      return localIUploadSession2;
    }
    finally {}
  }
  
  public void rebuildSessions()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getTag());
    ((StringBuilder)localObject).append(" rebuildSessions");
    UploadLog.d("SessionPool", ((StringBuilder)localObject).toString());
    localObject = this.mWorkHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(110001);
      localObject = this.mWorkHandler;
      ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(110001), 1000L);
    }
  }
  
  public void registerListener(SessionPool.PoolStateListener paramPoolStateListener)
  {
    this.mListener = paramPoolStateListener;
  }
  
  public void removeCloseTimer()
  {
    Handler localHandler = this.mWorkHandler;
    if (localHandler != null) {
      localHandler.removeMessages(110000);
    }
  }
  
  public void reset()
  {
    if ((isInVaildServer(this.mLastErrorCode)) && (changeRoute(0))) {
      return;
    }
    this.mClosed = false;
    cleanSessions();
    UploadLog.d(getTag(), "reset session pool");
    initSessions();
  }
  
  public void reset(UploadRoute paramUploadRoute)
  {
    cleanSessions();
    this.mClosed = false;
    this.mInited = false;
    createSession(this.mPoolInitSize, paramUploadRoute);
    String str = getTag();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reset session pool with redirect route: ");
    localStringBuilder.append(paramUploadRoute);
    UploadLog.d(str, localStringBuilder.toString());
  }
  
  public void saveRoute(UploadRoute paramUploadRoute)
  {
    this.mLastErrorCode = 0;
    if ((TextUtils.isEmpty(this.oldIp)) || (!paramUploadRoute.getIp().equalsIgnoreCase(this.oldIp)))
    {
      Object localObject = getTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("save recent route: ");
      localStringBuilder.append(paramUploadRoute);
      UploadLog.d((String)localObject, localStringBuilder.toString());
      this.oldIp = paramUploadRoute.getIp();
      localObject = this.mRouteStrategy;
      if (localObject != null) {
        ((IUploadRouteStrategy)localObject).save(paramUploadRoute);
      }
    }
  }
  
  public void setCloseTimer()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getTag());
    ((StringBuilder)localObject).append(" setCloseTimer");
    UploadLog.d("SessionPool", ((StringBuilder)localObject).toString());
    localObject = this.mWorkHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(110000);
      localObject = this.mWorkHandler;
      ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(110000), 240000L);
    }
  }
  
  protected void setPoolInitSize(int paramInt)
  {
    this.mPoolInitSize = paramInt;
  }
  
  public void unregisterListener(SessionPool.PoolStateListener paramPoolStateListener)
  {
    if (this.mListener == paramPoolStateListener) {
      this.mListener = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.session.SessionPool
 * JD-Core Version:    0.7.0.1
 */