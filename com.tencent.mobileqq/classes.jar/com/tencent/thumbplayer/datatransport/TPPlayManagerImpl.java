package com.tencent.thumbplayer.datatransport;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.thumbplayer.adapter.player.TPUrlDataSource;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.composition.TPMediaComposition;
import com.tencent.thumbplayer.composition.TPMediaCompositionTrackClip;
import com.tencent.thumbplayer.composition.TPMediaDRMAsset;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication.OnGlobalEventChangeListener;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor.OnNetStatusChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class TPPlayManagerImpl
  implements ITPPlayManager, TPGlobalEventNofication.OnGlobalEventChangeListener, TPNetworkChangeMonitor.OnNetStatusChangeListener
{
  private static final int LOD_P2P_TIMES = 3;
  private static final String TAG = "TPThumbPlayer[TPPlayManagerImpl.java]";
  private static int TYPE_NOT_INIT = -1;
  private boolean loadProxySucc = false;
  private Context mContext;
  private ArrayList<TPDownloadParamData> mDownloadPramList;
  private ITPDownloadProxy mDownloadProxy;
  private String mFileID;
  private TPPlayManagerImpl.InnerProxyListener mInnerProxyListener;
  private boolean mIsDemuxer = false;
  private boolean mIsUseResourceLoader = false;
  private String mOriginUrl;
  private LinkedList<TPPlayManagerImpl.TPDefTaskModel> mPendingDefTaskQueue;
  private int mPlayID = -1;
  private ITPPlayListener mPlayListener;
  private ITPPlayerProxyListener mPlayerProxyListener = null;
  private int mServiceType = TYPE_NOT_INIT;
  private long mSkipEndTimeMs;
  private long mStartTimeMs;
  private HashMap<String, Integer> mTrackProxyUrlPlayIdMap;
  private TPVideoInfo mVideoInfo;
  private int tryLoadP2pTimes = 3;
  
  public TPPlayManagerImpl(Context paramContext)
  {
    this.mContext = paramContext;
    TPGlobalEventNofication.addEventListener(this);
    TPNetworkChangeMonitor.getInstance().addOnNetStatusChangeListener(this);
    this.mInnerProxyListener = new TPPlayManagerImpl.InnerProxyListener(this, null);
    this.mPlayListener = new TPPlayProxyListenerEmptyImpl("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.mTrackProxyUrlPlayIdMap = new HashMap();
    this.mDownloadPramList = new ArrayList();
  }
  
  private boolean addAudioTrack(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    paramString1 = new HashMap();
    paramString1.put("dl_param_data_transfer_mode", Integer.valueOf(1));
    paramString1 = new TPDownloadParam(localArrayList, 3, paramString1);
    return this.mDownloadProxy.setClipInfo(this.mPlayID, 2, paramString2, paramString1);
  }
  
  private TPDownloadParam convertDownloadParam(String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    return TPProxyUtils.convertProxyDownloadParams(paramString, paramTPDownloadParamData);
  }
  
  private List<ITPMediaTrackClip> getAssetClips(ITPMediaAsset paramITPMediaAsset)
  {
    if ((paramITPMediaAsset instanceof TPMediaComposition))
    {
      paramITPMediaAsset = ((TPMediaComposition)paramITPMediaAsset).getAllAVTracks();
      if (!TPCommonUtils.isEmpty(paramITPMediaAsset))
      {
        paramITPMediaAsset = (ITPMediaTrack)paramITPMediaAsset.get(0);
        if ((paramITPMediaAsset != null) && (!TPCommonUtils.isEmpty(paramITPMediaAsset.getAllTrackClips()))) {
          return paramITPMediaAsset.getAllTrackClips();
        }
      }
    }
    else if ((paramITPMediaAsset instanceof ITPMediaTrack))
    {
      paramITPMediaAsset = (ITPMediaTrack)paramITPMediaAsset;
      if (!TPCommonUtils.isEmpty(paramITPMediaAsset.getAllTrackClips())) {
        return paramITPMediaAsset.getAllTrackClips();
      }
    }
    else if ((paramITPMediaAsset instanceof ITPMediaTrackClip))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add((ITPMediaTrackClip)paramITPMediaAsset);
      return localArrayList;
    }
    return null;
  }
  
  private TPDownloadParamData getDownloadParamDataWithIndex(ArrayList<TPDownloadParamData> paramArrayList, int paramInt)
  {
    if ((TPCommonUtils.isEmpty(paramArrayList)) || (paramInt >= paramArrayList.size())) {
      return null;
    }
    return (TPDownloadParamData)paramArrayList.get(paramInt);
  }
  
  private String getFileId()
  {
    return this.mFileID;
  }
  
  private String getHttpValue(String paramString)
  {
    if (paramString == null) {}
    do
    {
      int i;
      do
      {
        return null;
        i = paramString.indexOf(':');
      } while ((i < 0) || (i + 1 >= paramString.length()));
      paramString = paramString.substring(i + 1);
    } while (paramString == null);
    return paramString.trim();
  }
  
  private void initProxy()
  {
    if (this.loadProxySucc) {}
    while (this.tryLoadP2pTimes <= 0) {
      return;
    }
    try
    {
      if (this.mServiceType == TYPE_NOT_INIT) {
        this.mServiceType = TPPlayerConfig.getProxyServiceType();
      }
      ITPProxyManagerAdapter localITPProxyManagerAdapter = TPProxyGlobalManager.getInstance().getPlayerProxy(this.mServiceType);
      if ((localITPProxyManagerAdapter != null) && (localITPProxyManagerAdapter.getDownloadProxy() != null))
      {
        this.mDownloadProxy = localITPProxyManagerAdapter.getDownloadProxy();
        this.mDownloadProxy.setUserData("qq_is_vip", Boolean.valueOf(TPPlayerConfig.isUserIsVip()));
        if (!TextUtils.isEmpty(TPPlayerConfig.getUserUin())) {
          this.mDownloadProxy.setUserData("user_uin", TPPlayerConfig.getUserUin());
        }
        if (!TextUtils.isEmpty(TPPlayerConfig.getAppVersionName(this.mContext))) {
          this.mDownloadProxy.setUserData("app_version_name", TPPlayerConfig.getAppVersionName(this.mContext));
        }
        if (TPPlayerConfig.getBuildNumber(this.mContext) != -1L) {
          this.mDownloadProxy.setUserData("app_version_code", String.valueOf(TPPlayerConfig.getBuildNumber(this.mContext)));
        }
        this.mDownloadProxy.setUserData("carrier_pesudo_code", TPPlayerConfig.getUserUpc());
        this.mDownloadProxy.setUserData("carrier_pesudo_state", Integer.valueOf(TPPlayerConfig.getUserUpcState()));
        this.mDownloadProxy.setUserData("external_network_ip", TPPlayerConfig.getOutNetIp());
        this.loadProxySucc = true;
        return;
      }
    }
    catch (Exception localException)
    {
      this.tryLoadP2pTimes -= 1;
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException);
      return;
    }
    this.tryLoadP2pTimes -= 1;
    TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p so load failed");
  }
  
  private boolean isInitDownloadProxyFailed()
  {
    return isInitDownloadProxyFailed(false);
  }
  
  private boolean isInitDownloadProxyFailed(boolean paramBoolean)
  {
    if (!TPPlayerConfig.isUseP2P()) {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "config set don't use p2p proxy!");
    }
    do
    {
      return true;
      if (paramBoolean) {
        this.tryLoadP2pTimes = 3;
      }
      initProxy();
    } while (!this.loadProxySucc);
    return false;
  }
  
  private boolean isQQVideoExpired(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("httpHeader"))
        {
          paramString = paramString.getString("httpHeader");
          Object localObject = null;
          if (!TextUtils.isEmpty(paramString))
          {
            String[] arrayOfString = paramString.split("\r\n");
            if (arrayOfString != null)
            {
              int i = 1;
              for (;;)
              {
                paramString = localObject;
                if (i < arrayOfString.length)
                {
                  paramString = arrayOfString[i];
                  if (paramString.startsWith("User-ReturnCode")) {
                    paramString = getHttpValue(paramString);
                  }
                }
                else
                {
                  if (TextUtils.isEmpty(paramString)) {
                    break;
                  }
                  if (!paramString.equals("-5103059"))
                  {
                    boolean bool = paramString.equals("-5103017");
                    if (!bool) {
                      break;
                    }
                  }
                  return true;
                }
                i += 1;
              }
            }
          }
        }
        return false;
      }
      catch (Exception paramString) {}
    }
  }
  
  private void pauseDownload(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.pauseDownload(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pause download failed, taskId:" + paramInt);
    }
  }
  
  private void reset()
  {
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "reset");
    this.mFileID = "";
    this.mOriginUrl = "";
    this.mVideoInfo = null;
    this.mStartTimeMs = 0L;
    this.mSkipEndTimeMs = 0L;
    this.mIsDemuxer = false;
    if (!TPCommonUtils.isEmpty(this.mDownloadPramList)) {
      this.mDownloadPramList.clear();
    }
  }
  
  private void resumeDownload(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.resumeDownload(this.mPlayID);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy resume download failed, taskId:" + paramInt);
    }
  }
  
  private void setPlayUserData()
  {
    this.mDownloadProxy.setUserData("dl_param_play_start_time", Long.valueOf(this.mStartTimeMs));
    this.mDownloadProxy.setUserData("dl_param_play_end_time", Long.valueOf(this.mSkipEndTimeMs));
  }
  
  private int startClipPlay(List<ITPMediaTrackClip> paramList, String paramString, ArrayList<TPDownloadParamData> paramArrayList)
  {
    if (TPCommonUtils.isEmpty(paramList))
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "clipList is empty, return");
      return -1;
    }
    int k = paramList.size();
    Object localObject1 = new HashMap();
    int j = 0;
    int i = 1;
    Object localObject2;
    if (j < k)
    {
      localObject2 = (ITPMediaTrackClip)paramList.get(j);
      if ((!(localObject2 instanceof TPMediaCompositionTrackClip)) || (!TPCommonUtils.isUrl(((TPMediaCompositionTrackClip)localObject2).getFilePath()))) {
        break label426;
      }
      ((HashMap)localObject1).put(localObject2, new TPPlayManagerImpl.TPDownloadSeqAndClipIndexMapping(i, j));
      i += 1;
    }
    label426:
    for (;;)
    {
      j += 1;
      break;
      if (TPCommonUtils.isEmpty((Map)localObject1))
      {
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "all urls is local file url, return");
        return -1;
      }
      i = this.mDownloadProxy.startClipPlay(paramString, ((HashMap)localObject1).size(), this.mInnerProxyListener);
      if (i > 0)
      {
        paramList = ((HashMap)localObject1).entrySet().iterator();
        while (paramList.hasNext())
        {
          paramString = (Map.Entry)paramList.next();
          localObject1 = (ITPMediaTrackClip)paramString.getKey();
          paramString = (TPPlayManagerImpl.TPDownloadSeqAndClipIndexMapping)paramString.getValue();
          if ((localObject1 instanceof TPMediaCompositionTrackClip))
          {
            localObject1 = (TPMediaCompositionTrackClip)localObject1;
            Object localObject3 = getDownloadParamDataWithIndex(paramArrayList, paramString.clipIndex);
            if (localObject3 == null)
            {
              TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "fatal err, paramData is null.");
              return -1;
            }
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "multi trackClipIndex:" + paramString.clipIndex + ", download seq:" + paramString.downloadSeq + ", clip.url:" + ((TPMediaCompositionTrackClip)localObject1).getUrl() + ", clip.getFilePath:" + ((TPMediaCompositionTrackClip)localObject1).getFilePath() + ", paramData.savePath:" + ((TPDownloadParamData)localObject3).getSavePath() + ", paramData.DownloadFileID:" + ((TPDownloadParamData)localObject3).getDownloadFileID());
            localObject2 = ((TPDownloadParamData)localObject3).getDownloadFileID();
            localObject3 = convertDownloadParam(((TPMediaCompositionTrackClip)localObject1).getFilePath(), (TPDownloadParamData)localObject3);
            if (this.mDownloadProxy.setClipInfo(i, paramString.downloadSeq, (String)localObject2, (TPDownloadParam)localObject3)) {
              ((TPMediaCompositionTrackClip)localObject1).setFilePath(this.mDownloadProxy.getClipPlayUrl(i, paramString.downloadSeq, 1));
            }
          }
        }
      }
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start clip play failed, cause : playId < 0");
      return i;
    }
  }
  
  private TPUrlDataSource startSwitchDefTask(long paramLong, String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    String str = null;
    TPUrlDataSource localTPUrlDataSource = new TPUrlDataSource(paramString);
    if (!TPCommonUtils.isUrl(paramString)) {
      return localTPUrlDataSource;
    }
    if (isInitDownloadProxyFailed()) {
      return localTPUrlDataSource;
    }
    if (this.mPendingDefTaskQueue == null) {
      this.mPendingDefTaskQueue = new LinkedList();
    }
    if (paramTPDownloadParamData != null) {}
    for (Object localObject = convertDownloadParam(paramString, paramTPDownloadParamData);; localObject = null)
    {
      if (paramTPDownloadParamData != null) {}
      try
      {
        str = paramTPDownloadParamData.getDownloadFileID();
        i = this.mDownloadProxy.startPlay(str, (TPDownloadParam)localObject, this.mInnerProxyListener);
        if (i <= 0) {
          break label224;
        }
        localObject = this.mDownloadProxy.getPlayUrl(i, 1);
        paramTPDownloadParamData = (TPDownloadParamData)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramTPDownloadParamData = paramString;
        }
        localTPUrlDataSource.setSelfPlayerUrl(paramTPDownloadParamData);
        paramTPDownloadParamData = this.mDownloadProxy.getPlayUrl(this.mPlayID, 0);
        if (!TextUtils.isEmpty(paramTPDownloadParamData)) {
          continue;
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          int i;
          TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramString, "p2p proxy switch def failed");
          continue;
          paramString = paramTPDownloadParamData;
        }
      }
      localTPUrlDataSource.setSystemPlayerUrl(paramString);
      this.mPendingDefTaskQueue.offer(new TPPlayManagerImpl.TPDefTaskModel(paramLong, i));
      TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
      return localTPUrlDataSource;
      label224:
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def failed, cause : playId < 0");
      return localTPUrlDataSource;
    }
  }
  
  private void stopDownload(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.stopPlay(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy stop play failed, taskID:" + paramInt);
    }
  }
  
  private void updateVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    if (isInitDownloadProxyFailed()) {}
    for (;;)
    {
      return;
      this.mVideoInfo = paramTPVideoInfo;
      if ((paramTPVideoInfo == null) || (paramTPVideoInfo.getDownloadPraramList() == null))
      {
        TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "video or downloadParamList is null, return");
        return;
      }
      if (this.mPlayID <= 0)
      {
        TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy not start, return");
        return;
      }
      paramTPVideoInfo = paramTPVideoInfo.getDownloadPraramList();
      int i = 0;
      while (i < paramTPVideoInfo.size())
      {
        TPDownloadParamData localTPDownloadParamData = (TPDownloadParamData)paramTPVideoInfo.get(i);
        TPDownloadParam localTPDownloadParam = convertDownloadParam(localTPDownloadParamData.getUrl(), localTPDownloadParamData);
        if (!this.mDownloadProxy.setClipInfo(this.mPlayID, localTPDownloadParamData.getClipNo(), localTPDownloadParamData.getDownloadFileID(), localTPDownloadParam)) {
          TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "setClipInfo failed, playID:" + this.mPlayID + ", clipNo:" + localTPDownloadParamData.getClipNo() + ", downloadFileID:" + localTPDownloadParamData.getDownloadFileID());
        }
        i += 1;
      }
    }
  }
  
  public String getPlayErrorCodeStr()
  {
    if (isInitDownloadProxyFailed()) {
      return null;
    }
    try
    {
      String str = this.mDownloadProxy.getPlayErrorCodeStr(this.mPlayID);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
    }
    return null;
  }
  
  public ITPPlayerProxyListener getTPPlayerProxyListener()
  {
    return this.mPlayerProxyListener;
  }
  
  public boolean hasWaitDefTask()
  {
    if (isInitDownloadProxyFailed()) {}
    while ((this.mPendingDefTaskQueue == null) || (this.mPendingDefTaskQueue.size() <= 0)) {
      return false;
    }
    return true;
  }
  
  public boolean isEnable()
  {
    return !isInitDownloadProxyFailed();
  }
  
  public void onEvent(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "onEvent eventId: " + paramInt1 + ", arg1: " + paramInt2 + ", arg2: " + paramInt3 + ", object" + paramObject);
    switch (paramInt1)
    {
    default: 
      return;
    case 100001: 
      pushEventByInner(13);
      return;
    }
    pushEventByInner(14);
  }
  
  public void onStatusChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", "onNetworkStatusChanged oldNetStatus: " + paramInt1 + ", netStatus: " + paramInt2);
    if (paramInt2 == 1)
    {
      pushEventByInner(1);
      pushEventByInner(10);
    }
    do
    {
      return;
      if (paramInt2 == 2)
      {
        pushEventByInner(2);
        pushEventByInner(9);
        return;
      }
    } while (paramInt2 != 3);
    pushEventByInner(2);
    pushEventByInner(10);
  }
  
  public void pauseDownload()
  {
    pauseDownload(this.mPlayID);
    Iterator localIterator;
    if (!TPCommonUtils.isEmpty(this.mPendingDefTaskQueue))
    {
      localIterator = this.mPendingDefTaskQueue.iterator();
      while (localIterator.hasNext())
      {
        TPPlayManagerImpl.TPDefTaskModel localTPDefTaskModel = (TPPlayManagerImpl.TPDefTaskModel)localIterator.next();
        if (localTPDefTaskModel != null) {
          pauseDownload(localTPDefTaskModel.proxyTaskID);
        }
      }
    }
    if (!TPCommonUtils.isEmpty(this.mTrackProxyUrlPlayIdMap))
    {
      localIterator = this.mTrackProxyUrlPlayIdMap.values().iterator();
      while (localIterator.hasNext()) {
        pauseDownload(((Integer)localIterator.next()).intValue());
      }
    }
  }
  
  public void playerSwitchDefComplete(long paramLong)
  {
    if (isInitDownloadProxyFailed()) {}
    for (;;)
    {
      return;
      try
      {
        if (!TPCommonUtils.isEmpty(this.mPendingDefTaskQueue))
        {
          for (TPPlayManagerImpl.TPDefTaskModel localTPDefTaskModel = (TPPlayManagerImpl.TPDefTaskModel)this.mPendingDefTaskQueue.peek(); (localTPDefTaskModel != null) && (localTPDefTaskModel.definitionID != paramLong); localTPDefTaskModel = (TPPlayManagerImpl.TPDefTaskModel)this.mPendingDefTaskQueue.peek())
          {
            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy definitionID:" + localTPDefTaskModel.definitionID + ", taskID:" + localTPDefTaskModel.proxyTaskID);
            stopDownload(localTPDefTaskModel.proxyTaskID);
            this.mPendingDefTaskQueue.removeFirst();
          }
          if (localTPDefTaskModel != null)
          {
            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy task id:" + localTPDefTaskModel.proxyTaskID);
            stopDownload(this.mPlayID);
            this.mPlayID = localTPDefTaskModel.proxyTaskID;
            this.mPendingDefTaskQueue.remove(localTPDefTaskModel);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException, "playerSwitchDefComplete exception");
      }
    }
  }
  
  public void pushEvent(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      paramInt = TPProxyEnumUtils.eventID2Inner(paramInt);
      pushEventByInner(paramInt);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localIllegalArgumentException);
    }
  }
  
  public void pushEventByInner(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.pushEvent(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pushEvent failed, event:" + paramInt);
    }
  }
  
  public void release()
  {
    stopDownload();
    TPNetworkChangeMonitor.getInstance().removeOnNetStatusChangeListener(this);
    TPGlobalEventNofication.removeEventListener(this);
    this.mPlayerProxyListener = null;
    this.mPlayListener = new TPPlayProxyListenerEmptyImpl("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.mInnerProxyListener = null;
    this.mDownloadProxy = null;
  }
  
  public void resumeDownload()
  {
    resumeDownload(this.mPlayID);
    Iterator localIterator;
    if (!TPCommonUtils.isEmpty(this.mPendingDefTaskQueue))
    {
      localIterator = this.mPendingDefTaskQueue.iterator();
      while (localIterator.hasNext())
      {
        TPPlayManagerImpl.TPDefTaskModel localTPDefTaskModel = (TPPlayManagerImpl.TPDefTaskModel)localIterator.next();
        if (localTPDefTaskModel != null) {
          resumeDownload(localTPDefTaskModel.proxyTaskID);
        }
      }
    }
    if (!TPCommonUtils.isEmpty(this.mTrackProxyUrlPlayIdMap))
    {
      localIterator = this.mTrackProxyUrlPlayIdMap.values().iterator();
      while (localIterator.hasNext()) {
        resumeDownload(((Integer)localIterator.next()).intValue());
      }
    }
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
    }
  }
  
  public void setIsActive(boolean paramBoolean)
  {
    TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setIsActive: " + paramBoolean);
    if (isInitDownloadProxyFailed()) {
      return;
    }
    for (;;)
    {
      try
      {
        ITPDownloadProxy localITPDownloadProxy = this.mDownloadProxy;
        int j = this.mPlayID;
        if (paramBoolean)
        {
          i = 101;
          localITPDownloadProxy.setPlayState(j, i);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
        return;
      }
      int i = 100;
    }
  }
  
  public void setIsUseResourceLoader(boolean paramBoolean)
  {
    this.mIsUseResourceLoader = paramBoolean;
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener) {}
  
  public void setPlayListener(ITPPlayListener paramITPPlayListener)
  {
    if (paramITPPlayListener == null)
    {
      this.mPlayListener = new TPPlayProxyListenerEmptyImpl("TPThumbPlayer[TPPlayManagerImpl.java]");
      return;
    }
    this.mPlayListener = paramITPPlayListener;
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    if (isInitDownloadProxyFailed()) {}
    do
    {
      do
      {
        return;
        if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 100))
        {
          this.mStartTimeMs = paramTPOptionalParam.getParamLong().value;
          return;
        }
      } while ((paramTPOptionalParam == null) || (paramTPOptionalParam.getKey() != 500));
      this.mSkipEndTimeMs = paramTPOptionalParam.getParamLong().value;
    } while (this.mPlayID <= 0);
    this.mDownloadProxy.setUserData("dl_param_play_end_time", Long.valueOf(this.mSkipEndTimeMs));
  }
  
  public void setProxyPlayState(int paramInt)
  {
    TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState: " + paramInt);
    if (isInitDownloadProxyFailed()) {}
    for (;;)
    {
      return;
      try
      {
        this.mDownloadProxy.setPlayState(this.mPlayID, paramInt);
        if (((paramInt != 5) && (paramInt != 0)) || (TPCommonUtils.isEmpty(this.mPendingDefTaskQueue))) {
          continue;
        }
        Iterator localIterator = this.mPendingDefTaskQueue.iterator();
        while (localIterator.hasNext())
        {
          TPPlayManagerImpl.TPDefTaskModel localTPDefTaskModel = (TPPlayManagerImpl.TPDefTaskModel)localIterator.next();
          if (localTPDefTaskModel != null)
          {
            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState definitionID:" + localTPDefTaskModel.definitionID + ", taskID:" + localTPDefTaskModel.proxyTaskID + ", state:" + paramInt);
            this.mDownloadProxy.setPlayState(localTPDefTaskModel.proxyTaskID, paramInt);
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      }
    }
  }
  
  public void setProxyServiceType(int paramInt)
  {
    this.mServiceType = paramInt;
  }
  
  public void setTPPlayerProxyListener(ITPPlayerProxyListener paramITPPlayerProxyListener)
  {
    this.mPlayerProxyListener = paramITPPlayerProxyListener;
  }
  
  public void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    if (paramTPVideoInfo == null)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, param is null ");
      return;
    }
    if (this.mVideoInfo != null) {
      updateVideoInfo(paramTPVideoInfo);
    }
    this.mVideoInfo = paramTPVideoInfo;
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, enter");
    this.mFileID = paramTPVideoInfo.getProxyFileID();
    if (!TPCommonUtils.isEmpty(this.mDownloadPramList)) {
      this.mDownloadPramList.clear();
    }
    this.mDownloadPramList.addAll(paramTPVideoInfo.getDownloadPraramList());
  }
  
  public void startDemuxer(String paramString1, String paramString2)
  {
    if ((!TPCommonUtils.isUrl(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new Exception("illegal argument.");
    }
    if (!this.mIsDemuxer)
    {
      if (!addAudioTrack(paramString1, paramString2)) {
        throw new Exception("setClipInfo err.");
      }
    }
    else
    {
      stopDownload(this.mPlayID);
      startDownloadPlay(this.mOriginUrl);
      if (!addAudioTrack(paramString1, paramString2)) {
        throw new Exception("setClipInfo err.");
      }
    }
    this.mIsDemuxer = true;
  }
  
  public String startDownLoadTrackUrl(int paramInt, String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    if (TextUtils.isEmpty(paramString))
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is empty");
      return paramString;
    }
    if (!TPCommonUtils.isUrl(paramString))
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is locol url, not need use proxy");
      return paramString;
    }
    if (isInitDownloadProxyFailed())
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz download proxy init failed");
      return paramString;
    }
    String str;
    int i;
    if (paramTPDownloadParamData != null)
    {
      str = paramString;
      try
      {
        paramTPDownloadParamData = TPProxyUtils.convertProxyDownloadParams(paramString, paramTPDownloadParamData);
        str = paramString;
        paramInt = this.mDownloadProxy.startPlay(TPCommonUtils.getMd5(paramString), paramTPDownloadParamData, this.mInnerProxyListener);
        if (paramInt <= 0) {
          break label202;
        }
        str = paramString;
        paramString = this.mDownloadProxy.getPlayUrl(paramInt, 1);
        str = paramString;
        this.mTrackProxyUrlPlayIdMap.put(paramString, Integer.valueOf(paramInt));
        return paramString;
      }
      catch (Throwable paramString)
      {
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed:" + paramString);
        return str;
      }
    }
    else
    {
      str = paramString;
      paramTPDownloadParamData = new ArrayList();
      str = paramString;
      paramTPDownloadParamData.add(paramString);
      i = 0;
      if (paramInt != 3) {
        break label215;
      }
      i = 10;
    }
    for (;;)
    {
      str = paramString;
      paramTPDownloadParamData = new TPDownloadParam(paramTPDownloadParamData, i, null);
      break;
      label202:
      str = paramString;
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId < 0");
      return paramString;
      label215:
      if (paramInt == 2) {
        i = 3;
      }
    }
  }
  
  public TPUrlDataSource startDownloadPlay(String paramString)
  {
    TPUrlDataSource localTPUrlDataSource = new TPUrlDataSource(paramString);
    if (!TPCommonUtils.isUrl(paramString)) {
      return localTPUrlDataSource;
    }
    if (isInitDownloadProxyFailed(true)) {
      return localTPUrlDataSource;
    }
    setPlayUserData();
    this.mOriginUrl = paramString;
    Object localObject2 = getDownloadParamDataWithIndex(this.mDownloadPramList, 0);
    Object localObject1;
    if ((this.mIsUseResourceLoader) && (localObject2 != null) && (((TPDownloadParamData)localObject2).getDlType() == 1))
    {
      localObject2 = new TPDownloadParamData(11);
      if (localObject2 == null) {
        break label318;
      }
      localObject1 = convertDownloadParam(paramString, (TPDownloadParamData)localObject2);
    }
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder().append("single url:").append(paramString).append(", paramData.savePath:");
        if (localObject2 == null) {
          break label323;
        }
        localObject3 = ((TPDownloadParamData)localObject2).getSavePath();
        localObject3 = localStringBuilder.append((String)localObject3).append(", paramData.DownloadFileID:");
        if (localObject2 == null) {
          break label331;
        }
        localObject2 = ((TPDownloadParamData)localObject2).getDownloadFileID();
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", (String)localObject2);
        this.mPlayID = this.mDownloadProxy.startPlay(getFileId(), (TPDownloadParam)localObject1, this.mInnerProxyListener);
        if (this.mPlayID > 0)
        {
          localObject2 = this.mDownloadProxy.getPlayUrl(this.mPlayID, 0);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = paramString;
          }
          TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "startDownloadPlay, playId:" + this.mPlayID);
          localTPUrlDataSource.setSelfPlayerUrl((String)localObject1);
          localObject1 = this.mDownloadProxy.getPlayUrl(this.mPlayID, 1);
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localTPUrlDataSource.setSystemPlayerUrl(paramString);
            break label315;
          }
        }
        else
        {
          TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId < 0");
        }
      }
      catch (Throwable paramString)
      {
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramString, "p2p proxy start play failed");
      }
      paramString = (String)localObject1;
      continue;
      break;
      label315:
      return localTPUrlDataSource;
      label318:
      localObject1 = null;
      continue;
      label323:
      Object localObject3 = "null";
      continue;
      label331:
      localObject2 = "null";
    }
  }
  
  public ITPMediaAsset startDownloadPlayByAsset(ITPMediaAsset paramITPMediaAsset)
  {
    if (isInitDownloadProxyFailed(true)) {}
    Object localObject;
    do
    {
      return paramITPMediaAsset;
      setPlayUserData();
      if ((paramITPMediaAsset instanceof TPMediaDRMAsset))
      {
        localObject = startDownloadPlay(((TPMediaDRMAsset)paramITPMediaAsset).getDrmPlayUrl());
        ((TPMediaDRMAsset)paramITPMediaAsset).setDrmPlayUrl(((TPUrlDataSource)localObject).getSelfPlayerUrl());
        return paramITPMediaAsset;
      }
      localObject = getAssetClips(paramITPMediaAsset);
    } while (TPCommonUtils.isEmpty((Collection)localObject));
    this.mPlayID = startClipPlay((List)localObject, getFileId(), this.mDownloadPramList);
    return paramITPMediaAsset;
  }
  
  public TPUrlDataSource startSwitchDefTask(long paramLong, String paramString, TPVideoInfo paramTPVideoInfo)
  {
    if (paramTPVideoInfo == null) {
      return new TPUrlDataSource(paramString);
    }
    TPDownloadParamData localTPDownloadParamData = null;
    if (paramTPVideoInfo.getDownloadPraramList() != null) {
      localTPDownloadParamData = (TPDownloadParamData)paramTPVideoInfo.getDownloadPraramList().get(0);
    }
    return startSwitchDefTask(paramLong, paramString, localTPDownloadParamData);
  }
  
  public ITPMediaAsset startSwitchDefTaskByAsset(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    if ((isInitDownloadProxyFailed()) || (paramITPMediaAsset == null)) {}
    do
    {
      return paramITPMediaAsset;
      if (this.mPendingDefTaskQueue == null) {
        this.mPendingDefTaskQueue = new LinkedList();
      }
    } while (paramTPVideoInfo == null);
    if ((paramITPMediaAsset instanceof ITPMediaDRMAsset)) {
      if (paramTPVideoInfo.getDownloadPraramList() == null) {
        break label206;
      }
    }
    label206:
    for (paramTPVideoInfo = (TPDownloadParamData)paramTPVideoInfo.getDownloadPraramList().get(0);; paramTPVideoInfo = null)
    {
      paramTPVideoInfo = startSwitchDefTask(paramLong, ((ITPMediaDRMAsset)paramITPMediaAsset).getDrmPlayUrl(), paramTPVideoInfo);
      ((TPMediaDRMAsset)paramITPMediaAsset).setDrmPlayUrl(paramTPVideoInfo.getSelfPlayerUrl());
      return paramITPMediaAsset;
      List localList = getAssetClips(paramITPMediaAsset);
      if ((TPCommonUtils.isEmpty(localList)) || (paramTPVideoInfo == null)) {
        break;
      }
      int i = startClipPlay(localList, paramTPVideoInfo.getProxyFileID(), paramTPVideoInfo.getDownloadPraramList());
      if (i > 0)
      {
        this.mPendingDefTaskQueue.offer(new TPPlayManagerImpl.TPDefTaskModel(paramLong, i));
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
        return paramITPMediaAsset;
      }
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch clip def failed, cause : playId < 0");
      return paramITPMediaAsset;
    }
  }
  
  public void stopDemuxer()
  {
    if (this.mIsDemuxer)
    {
      stopDownload(this.mPlayID);
      startDownloadPlay(this.mOriginUrl);
    }
    this.mIsDemuxer = false;
  }
  
  public void stopDownLoadTrackUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is empty");
      return;
    }
    if (isInitDownloadProxyFailed())
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz download proxy init failed");
      return;
    }
    if (!this.mTrackProxyUrlPlayIdMap.containsKey(paramString))
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return, coz mTrackProxyUrlPlayIdMap not contain current proxy url:" + paramString + ", or it is not proxy url");
      return;
    }
    int i = ((Integer)this.mTrackProxyUrlPlayIdMap.get(paramString)).intValue();
    try
    {
      this.mDownloadProxy.stopPlay(i);
      return;
    }
    catch (Exception paramString)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy stop play failed:" + paramString);
    }
  }
  
  public void stopDownload()
  {
    if (this.mPlayID < 0)
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload failed, coz playId:" + this.mPlayID + ", less than zero. maybe download proxy didn't started");
      return;
    }
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload, playId:" + this.mPlayID);
    stopDownload(this.mPlayID);
    Iterator localIterator;
    if (!TPCommonUtils.isEmpty(this.mPendingDefTaskQueue))
    {
      localIterator = this.mPendingDefTaskQueue.iterator();
      while (localIterator.hasNext())
      {
        TPPlayManagerImpl.TPDefTaskModel localTPDefTaskModel = (TPPlayManagerImpl.TPDefTaskModel)localIterator.next();
        if (localTPDefTaskModel != null) {
          stopDownload(localTPDefTaskModel.proxyTaskID);
        }
      }
      this.mPendingDefTaskQueue.clear();
    }
    if (!TPCommonUtils.isEmpty(this.mTrackProxyUrlPlayIdMap))
    {
      localIterator = this.mTrackProxyUrlPlayIdMap.values().iterator();
      while (localIterator.hasNext()) {
        stopDownload(((Integer)localIterator.next()).intValue());
      }
      this.mTrackProxyUrlPlayIdMap.clear();
    }
    this.mPlayID = -1;
    reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPPlayManagerImpl
 * JD-Core Version:    0.7.0.1
 */