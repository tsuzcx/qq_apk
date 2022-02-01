package com.tencent.viola.core;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.viola.adapter.IBridgeAdapter;
import com.tencent.viola.adapter.IHttpAdapter;
import com.tencent.viola.adapter.ILogAdapter;
import com.tencent.viola.adapter.VComponentAdapter;
import com.tencent.viola.adapter.VWebSocketAdapter;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.IReportDelegate;
import com.tencent.viola.commons.ViolaThread;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class ViolaSDKManager
{
  public static int KEEP_ALIVE_TIME = 0;
  public static TimeUnit KEEP_ALIVE_TIME_UNIT;
  public static int NUMBER_OF_CORES = 0;
  public static final String TAG = "ViolaSDKManager";
  private static List<String> instanceIdList = new ArrayList();
  private static AtomicInteger sInstanceId = new AtomicInteger(0);
  private static volatile ViolaSDKManager sManager;
  private AudioPlayerManager mAudioPlayerManager;
  private IBridgeAdapter mBridgeAdapter;
  private ViolaBridgeManager mBridgeMgr;
  private VComponentAdapter mComponentAdapter;
  private ArrayList<Integer> mCurrentInstanceHashcodeArray = new ArrayList();
  private SparseArray<WeakReference<ViolaInstance>> mCurrentViolaInstanceArray = new SparseArray();
  private ViolaDomManager mDomMgr;
  private ThreadPoolExecutor mExecutorService;
  private IHttpAdapter mHttpAdapter;
  private ILogAdapter mLogAdapter;
  private ViolaRenderManager mRenderMgr;
  private IReportDelegate mReportDelegate;
  private BlockingQueue<Runnable> mTaskQueue;
  private VWebSocketAdapter mWebsocketAdapter;
  
  private ViolaSDKManager()
  {
    this(new ViolaRenderManager());
  }
  
  private ViolaSDKManager(ViolaRenderManager paramViolaRenderManager)
  {
    this.mRenderMgr = paramViolaRenderManager;
    this.mDomMgr = new ViolaDomManager(this.mRenderMgr);
    this.mBridgeMgr = ViolaBridgeManager.getInstance();
    NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    KEEP_ALIVE_TIME = 1;
    KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    this.mTaskQueue = new LinkedBlockingQueue(100);
    this.mExecutorService = new ThreadPoolExecutor(NUMBER_OF_CORES, NUMBER_OF_CORES * 2, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, this.mTaskQueue, new NamedThreadFactory("violaThreadPool"));
  }
  
  public static String getCurInstanceId()
  {
    if ((instanceIdList != null) && (instanceIdList.size() > 0)) {
      return (String)instanceIdList.get(instanceIdList.size() - 1);
    }
    return null;
  }
  
  public static ViolaSDKManager getInstance()
  {
    if (sManager == null) {}
    try
    {
      if (sManager == null) {
        sManager = new ViolaSDKManager();
      }
      return sManager;
    }
    finally {}
  }
  
  public void addJsErrorCount()
  {
    if (getCurrentViolaInstance() != null) {
      getCurrentViolaInstance().addPageOpenJsErrorCount();
    }
  }
  
  public void addRunningJsErrorCount()
  {
    if (getCurrentViolaInstance() != null) {
      getCurrentViolaInstance().addRunningJsErrorCount();
    }
  }
  
  public void clearCurrentPageInstance(ViolaInstance paramViolaInstance)
  {
    if (paramViolaInstance != null)
    {
      int i = paramViolaInstance.hashCode();
      this.mCurrentViolaInstanceArray.remove(i);
      this.mCurrentInstanceHashcodeArray.remove(Integer.valueOf(paramViolaInstance.hashCode()));
    }
  }
  
  @Deprecated
  void createInstance(ViolaInstance paramViolaInstance, String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    if (paramViolaInstance != null)
    {
      registerInstanceAndId(paramViolaInstance);
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "";
      }
      ViolaLogUtils.e("ViolaSDKManager", "violaInstance createInstance start!");
      this.mBridgeMgr.createInstance(paramViolaInstance.getInstanceId(), paramString1, paramMap, str);
    }
  }
  
  void createInstanceJSSource(ViolaInstance paramViolaInstance, String paramString1, String paramString2, String paramString3)
  {
    ViolaLogUtils.d("debugForTimeCost", "createInstanceJSSource : " + System.currentTimeMillis());
    if (paramViolaInstance != null)
    {
      registerInstanceAndId(paramViolaInstance);
      String str = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        str = "";
      }
      this.mBridgeMgr.createInstanceBySource(paramViolaInstance.getInstanceId(), paramString1, paramString2, str);
    }
  }
  
  void destroyInstance(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.mAudioPlayerManager != null)
    {
      this.mAudioPlayerManager.release();
      this.mAudioPlayerManager = null;
    }
    if (instanceIdList != null)
    {
      instanceIdList.remove(paramString);
      ViolaLogUtils.d("ViolaSDKManager", "violaInstance destroy,instanceId=" + paramString);
    }
    ViolaBridgeManager localViolaBridgeManager = this.mBridgeMgr;
    if ((instanceIdList == null) || (instanceIdList.size() == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      localViolaBridgeManager.destroyInstance(paramString, bool);
      if (this.mRenderMgr != null) {
        this.mRenderMgr.destroyInstance(paramString);
      }
      if (this.mDomMgr == null) {
        break;
      }
      this.mDomMgr.destroyInstance(paramString);
      return;
    }
  }
  
  String generateInstanceId()
  {
    return String.valueOf(sInstanceId.incrementAndGet());
  }
  
  public AudioPlayerManager getAudioPlayerManager()
  {
    return this.mAudioPlayerManager;
  }
  
  public IBridgeAdapter getBridgeAdapter()
  {
    return this.mBridgeAdapter;
  }
  
  public VComponentAdapter getComponentAdapter()
  {
    return this.mComponentAdapter;
  }
  
  public ViolaInstance getCurrentViolaInstance()
  {
    if (this.mCurrentInstanceHashcodeArray.size() > 0)
    {
      int i = ((Integer)this.mCurrentInstanceHashcodeArray.get(this.mCurrentInstanceHashcodeArray.size() - 1)).intValue();
      WeakReference localWeakReference = (WeakReference)this.mCurrentViolaInstanceArray.get(i, null);
      if (localWeakReference != null) {
        return (ViolaInstance)localWeakReference.get();
      }
    }
    return null;
  }
  
  public ViolaDomManager getDomManager()
  {
    return this.mDomMgr;
  }
  
  public IHttpAdapter getHttpAdapter()
  {
    return this.mHttpAdapter;
  }
  
  public int getJsErrorCount()
  {
    if (getCurrentViolaInstance() != null) {
      return getCurrentViolaInstance().getPageOpenJsErrorCount();
    }
    return 0;
  }
  
  public ILogAdapter getLogAdapter()
  {
    return this.mLogAdapter;
  }
  
  public ViolaRenderManager getRenderManager()
  {
    return this.mRenderMgr;
  }
  
  public IReportDelegate getReportDelegate()
  {
    return this.mReportDelegate;
  }
  
  @Nullable
  public ViolaInstance getViolaInstance(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return this.mRenderMgr.getInstance(paramString);
  }
  
  public VWebSocketAdapter getWebSocketAdapter()
  {
    return this.mWebsocketAdapter;
  }
  
  void initScriptsFramework(String paramString1, ViolaSDKEngine.InitCallback paramInitCallback, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.mBridgeMgr.initFrameworkLocalPath(paramString1, paramInitCallback, paramString2);
  }
  
  void initScriptsFrameworkString(String paramString1, ViolaSDKEngine.InitCallback paramInitCallback, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    ViolaBridgeManager localViolaBridgeManager = this.mBridgeMgr;
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = new JSONObject().toString();
    }
    localViolaBridgeManager.initFrameworkString(paramString1, paramInitCallback, str);
  }
  
  public boolean isRenderJsEnd()
  {
    if (getCurrentViolaInstance() != null) {
      return getCurrentViolaInstance().isRenderJsEnd();
    }
    return false;
  }
  
  public boolean isViolaInstanceAlive(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return instanceIdList.contains(paramString);
  }
  
  public void postOnThreadPool(Runnable paramRunnable)
  {
    try
    {
      if (this.mExecutorService.getQueue().contains(paramRunnable))
      {
        ViolaLogUtils.d("ViolaSDKManager", "task already exist, return.");
        return;
      }
      ViolaLogUtils.d("ViolaSDKManager", "add task to queue.");
      this.mExecutorService.execute(paramRunnable);
      return;
    }
    catch (Exception paramRunnable)
    {
      ViolaLogUtils.e("ViolaSDKManager", "postOnThreadPool,error:" + paramRunnable.getMessage());
    }
  }
  
  public void postOnUiThread(Runnable paramRunnable)
  {
    this.mRenderMgr.postOnUiThread(ViolaThread.secure(paramRunnable));
  }
  
  @Deprecated
  public void postOnUiThread(Runnable paramRunnable, long paramLong)
  {
    this.mRenderMgr.postOnUiThreadDelay(ViolaThread.secure(paramRunnable), paramLong);
  }
  
  public void postOnUiThreadDelay(Runnable paramRunnable, long paramLong)
  {
    this.mRenderMgr.postOnUiThreadDelay(ViolaThread.secure(paramRunnable), paramLong);
  }
  
  public void registerComponents(List<Map<String, Object>> paramList)
  {
    this.mBridgeMgr.registerComponents(paramList);
  }
  
  public void registerInstanceAndId(ViolaInstance paramViolaInstance)
  {
    if ((paramViolaInstance == null) || (TextUtils.isEmpty(paramViolaInstance.getInstanceId()))) {}
    do
    {
      return;
      this.mRenderMgr.registerInstance(paramViolaInstance);
    } while ((instanceIdList == null) || (instanceIdList.contains(paramViolaInstance.getInstanceId())));
    instanceIdList.add(paramViolaInstance.getInstanceId());
  }
  
  public void registerModules(Map<String, Object> paramMap)
  {
    this.mBridgeMgr.registerModules(paramMap);
  }
  
  public void setAudioPlayerManager(AudioPlayerManager paramAudioPlayerManager)
  {
    this.mAudioPlayerManager = paramAudioPlayerManager;
  }
  
  public void setBridgeAdapter(IBridgeAdapter paramIBridgeAdapter)
  {
    this.mBridgeAdapter = paramIBridgeAdapter;
  }
  
  public void setCurrentViolaInstance(ViolaInstance paramViolaInstance)
  {
    if (paramViolaInstance != null)
    {
      this.mCurrentViolaInstanceArray.put(paramViolaInstance.hashCode(), new WeakReference(paramViolaInstance));
      if (!this.mCurrentInstanceHashcodeArray.contains(Integer.valueOf(paramViolaInstance.hashCode())))
      {
        if (this.mCurrentInstanceHashcodeArray.size() <= 0) {
          break label66;
        }
        this.mCurrentInstanceHashcodeArray.add(0, Integer.valueOf(paramViolaInstance.hashCode()));
      }
    }
    return;
    label66:
    this.mCurrentInstanceHashcodeArray.add(Integer.valueOf(paramViolaInstance.hashCode()));
  }
  
  void setInitConfig(InitConfig paramInitConfig)
  {
    this.mComponentAdapter = paramInitConfig.getComponentAdapter();
    this.mHttpAdapter = paramInitConfig.getHttpAdapter();
    this.mReportDelegate = paramInitConfig.getReportDelegate();
    this.mWebsocketAdapter = paramInitConfig.getWebsocketAdapter();
    this.mLogAdapter = paramInitConfig.getLogAdapter();
  }
  
  public void setReportDelegate(IReportDelegate paramIReportDelegate)
  {
    this.mReportDelegate = paramIReportDelegate;
  }
  
  public void setWebsocketAdapter(VWebSocketAdapter paramVWebSocketAdapter)
  {
    this.mWebsocketAdapter = paramVWebSocketAdapter;
  }
  
  void updateInstance(ViolaInstance paramViolaInstance, String paramString)
  {
    if (paramViolaInstance == null) {
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.mBridgeMgr.updateInstance(paramViolaInstance.getInstanceId(), str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.core.ViolaSDKManager
 * JD-Core Version:    0.7.0.1
 */