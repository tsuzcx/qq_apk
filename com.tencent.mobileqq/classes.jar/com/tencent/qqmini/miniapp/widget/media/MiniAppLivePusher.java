package com.tencent.qqmini.miniapp.widget.media;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.miniapp.R.id;
import com.tencent.qqmini.miniapp.R.layout;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ScreenOffOnListener;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.JarReflectUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppLivePusher
  extends FrameLayout
{
  private static final String ON_LIVE_PUSHER_BGM_COMPLETE = "onLivePusherBGMComplete";
  private static final String ON_LIVE_PUSHER_BGM_PROGRESS = "onLivePusherBGMProgress";
  private static final String ON_LIVE_PUSHER_BGM_START = "onLivePusherBGMStart";
  private static final String ON_LIVE_PUSHER_ERR = "onLivePusherError";
  private static final String ON_LIVE_PUSHER_EVENT = "onLivePusherEvent";
  private static final String ON_LIVE_PUSHER_NET_STATUS = "onLivePusherNetStatus";
  private static final String TAG = "MiniAppLivePusher";
  public WeakReference<Activity> atyRef;
  private Context context;
  public String data;
  private ConcurrentHashMap<String, String> downloadMap = new ConcurrentHashMap();
  private AtomicInteger downloadTaskId = new AtomicInteger(0);
  private Handler handler = new Handler(Looper.getMainLooper());
  private boolean hasSetUp = false;
  public long livePusherId;
  private TXLivePusherJSAdapter livePusherJSAdapter;
  private IMiniAppContext mMiniAppContext;
  public WeakReference<IMiniAppContext> miniAppContextRef;
  private boolean needToStopDownloadBGM = false;
  private FrameLayout pusherContainer;
  private ArrayList<String> pusherKeyList;
  private View rootView;
  private Runnable stopDumpRunnable = new MiniAppLivePusher.1(this);
  private Object tXCloudVideoView;
  private String tempAudioFilePath = null;
  public int webviewId;
  
  public MiniAppLivePusher(@NonNull IMiniAppContext paramIMiniAppContext)
  {
    this(paramIMiniAppContext, null);
    setUpView(paramIMiniAppContext.getContext());
  }
  
  public MiniAppLivePusher(@NonNull IMiniAppContext paramIMiniAppContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramIMiniAppContext.getContext(), paramAttributeSet);
    this.mMiniAppContext = paramIMiniAppContext;
    setUpView(paramIMiniAppContext.getContext());
  }
  
  private void doPlayBGM(String paramString, RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.needToStopDownloadBGM = false;
      String str1 = String.valueOf(this.downloadTaskId.getAndIncrement());
      String str2 = paramJSONObject.optString("url");
      this.downloadMap.put(str1, str2);
      String str3 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByUrl(str2);
      DownloaderProxy localDownloaderProxy = (DownloaderProxy)ProxyManager.get(DownloaderProxy.class);
      localDownloaderProxy.download(str2, null, str3, 60, new MiniAppLivePusher.5(this, str1, str2, paramRequestEvent, str3, paramJSONObject, paramString, localDownloaderProxy));
    }
    paramString = ApiUtil.wrapCallbackOk("operateLivePusher", null);
    paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, paramString.toString());
  }
  
  private void doSetBGMPosition(String paramString, RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("BGMPosition", paramJSONObject.getInt("position") * 1000);
      this.livePusherJSAdapter.operateLivePusher(paramString, paramJSONObject);
    }
    catch (JSONException paramString)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("setBGMPosition - JSONException:");
      paramJSONObject.append(paramString);
      QMLog.e("MiniAppLivePusher", paramJSONObject.toString());
    }
    paramString = ApiUtil.wrapCallbackOk("operateLivePusher", null);
    paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, paramString.toString());
  }
  
  private void doSnapShot(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("quality");
      if ((paramJSONObject != null) && (paramJSONObject.equalsIgnoreCase("compressed")))
      {
        bool = true;
        break label33;
      }
    }
    boolean bool = false;
    label33:
    takePhoto("operateLivePusher", bool, paramRequestEvent);
  }
  
  private void doStartAudioRecord(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    String str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath("pcm");
    long l = paramJSONObject.optLong("maxDuration");
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("recordFile:");
    paramJSONObject.append(str);
    QMLog.d("MiniAppLivePusher", paramJSONObject.toString());
    int i = this.livePusherJSAdapter.startDumpAudioData(str);
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("recordResult:");
    paramJSONObject.append(i);
    QMLog.d("MiniAppLivePusher", paramJSONObject.toString());
    if (i == 0)
    {
      JSONObject localJSONObject = new JSONObject();
      paramJSONObject = str;
      try
      {
        str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(str);
        paramJSONObject = str;
        StringBuilder localStringBuilder = new StringBuilder();
        paramJSONObject = str;
        localStringBuilder.append("recordFile transformed:");
        paramJSONObject = str;
        localStringBuilder.append(str);
        paramJSONObject = str;
        QMLog.d("MiniAppLivePusher", localStringBuilder.toString());
        paramJSONObject = str;
        localJSONObject.put("tempFilePath", str);
        paramJSONObject = str;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      this.tempAudioFilePath = paramJSONObject;
      paramJSONObject = ApiUtil.wrapCallbackOk("operateLivePusher", localJSONObject);
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, paramJSONObject.toString());
      this.handler.postDelayed(this.stopDumpRunnable, l);
    }
    else
    {
      if (i == -1)
      {
        paramJSONObject = ApiUtil.wrapCallbackFail("operateLivePusher", null, "LivePusher is recording");
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, paramJSONObject.toString());
        return;
      }
      if (i == -2)
      {
        paramJSONObject = ApiUtil.wrapCallbackFail("operateLivePusher", null, "LivePusher creates recordFile failed");
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, paramJSONObject.toString());
      }
      else if (i == -3)
      {
        paramJSONObject = ApiUtil.wrapCallbackFail("operateLivePusher", null, "LivePusher not support current format");
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, paramJSONObject.toString());
      }
      else
      {
        paramJSONObject = ApiUtil.wrapCallbackFail("operateLivePusher", null, "LivePusher starts recording fail");
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, paramJSONObject.toString());
      }
    }
    paramRequestEvent = new StringBuilder();
    paramRequestEvent.append("recordResult:");
    paramRequestEvent.append(i);
    QMLog.d("MiniAppLivePusher", paramRequestEvent.toString());
  }
  
  private void doStopAudioRecord(RequestEvent paramRequestEvent)
  {
    QMLog.d("MiniAppLivePusher", "stopDumpAudioData");
    this.handler.removeCallbacks(this.stopDumpRunnable);
    this.livePusherJSAdapter.stopDumpAudioData();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      boolean bool = TextUtils.isEmpty(this.tempAudioFilePath);
      if (!bool)
      {
        localJSONObject.put("tempFilePath", this.tempAudioFilePath);
        this.tempAudioFilePath = null;
      }
      else
      {
        localJSONObject.put("tempFilePath", "");
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    localJSONObject = ApiUtil.wrapCallbackOk("operateLivePusher", localJSONObject);
    paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
  }
  
  private void doStopBGM(String paramString, RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    this.needToStopDownloadBGM = true;
    this.livePusherJSAdapter.operateLivePusher(paramString, paramJSONObject);
    paramString = ApiUtil.wrapCallbackOk("operateLivePusher", null);
    paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, paramString.toString());
  }
  
  private void initPusher(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if ((QMLog.isColorLevel()) && (paramJSONObject != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initLivePusher params = ");
      localStringBuilder.append(paramJSONObject.toString());
      QMLog.d("MiniAppLivePusher", localStringBuilder.toString());
    }
    initPusherKeyList();
    this.livePusherJSAdapter = new TXLivePusherJSAdapter(getContext());
    this.livePusherJSAdapter.initLivePusher(this.tXCloudVideoView, paramJSONObject);
    setBGMNotifyListener(paramRequestEvent);
    setPushListener(paramRequestEvent);
    this.livePusherJSAdapter.updateHomeOrientation(this.mMiniAppContext);
  }
  
  private void initPusherKeyList()
  {
    if (this.pusherKeyList == null)
    {
      this.pusherKeyList = new ArrayList();
      this.pusherKeyList.add("pushUrl");
      this.pusherKeyList.add("mode");
      this.pusherKeyList.add("hide");
      this.pusherKeyList.add("autopush");
      this.pusherKeyList.add("muted");
      this.pusherKeyList.add("enableCamera");
      this.pusherKeyList.add("enableMic");
      this.pusherKeyList.add("enableAGC");
      this.pusherKeyList.add("enableANS");
      this.pusherKeyList.add("audioVolumeType");
      this.pusherKeyList.add("audioReverbType");
      this.pusherKeyList.add("devicePosition");
      this.pusherKeyList.add("focusMode");
      this.pusherKeyList.add("orientation");
      this.pusherKeyList.add("beauty");
      this.pusherKeyList.add("whiteness");
      this.pusherKeyList.add("aspect");
      this.pusherKeyList.add("videoWidth");
      this.pusherKeyList.add("videoHeight");
      this.pusherKeyList.add("minBitrate");
      this.pusherKeyList.add("maxBitrate");
      this.pusherKeyList.add("audioQuality");
      this.pusherKeyList.add("backgroundImage");
      this.pusherKeyList.add("backgroundMute");
      this.pusherKeyList.add("zoom");
      this.pusherKeyList.add("needEvent");
      this.pusherKeyList.add("needBGMEvent");
      this.pusherKeyList.add("watermarkImage");
      this.pusherKeyList.add("watermarkLeft");
      this.pusherKeyList.add("watermarkTop");
      this.pusherKeyList.add("watermarkWidth");
      this.pusherKeyList.add("debug");
      this.pusherKeyList.add("mirror");
      this.pusherKeyList.add("remoteMirror");
      this.pusherKeyList.add("localMirror");
      this.pusherKeyList.add("enableEarMonitor");
    }
  }
  
  private void initPusherView()
  {
    this.tXCloudVideoView = JarReflectUtil.creatSpecifiedObject("com.tencent.rtmp.ui.TXCloudVideoView", JarReflectUtil.getParamsClass(new Class[] { Context.class }), new Object[] { getContext() });
    if (this.tXCloudVideoView == null)
    {
      QMLog.e("MiniAppLivePusher", "tXCloudVideoView is null?! ");
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    View localView = (View)this.tXCloudVideoView;
    localView.setLayoutParams(localLayoutParams);
    localView.setVisibility(0);
    this.pusherContainer.removeAllViews();
    this.pusherContainer.addView(localView);
    this.pusherContainer.setBackgroundColor(-16777216);
    new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.context, 100.0F), DisplayUtil.dip2px(this.context, 100.0F)).gravity = 17;
  }
  
  private void onDownloadSucceed(String paramString1, String paramString2, String paramString3, String paramString4, JSONObject paramJSONObject, String paramString5)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("playBGM - download onDownloadSucceed:");
      ((StringBuilder)localObject1).append(paramString2);
      QMLog.e("MiniAppLivePusher", ((StringBuilder)localObject1).toString());
      if (this.needToStopDownloadBGM)
      {
        QMLog.e("MiniAppLivePusher", "playBGM - download onDownloadSucceed but needToStopDownloadBGM");
        return;
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        Object localObject2 = new File(paramString3);
        localObject1 = localObject2;
        String str;
        if (!((File)localObject2).exists())
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramString1))
          {
            QMLog.e("MiniAppLivePusher", "file no exists, try to copy again.");
            paramString2 = (String)localObject2;
            try
            {
              File localFile = new File(paramString1);
              paramString2 = (String)localObject2;
              localObject1 = localObject2;
              if (localFile.exists())
              {
                paramString2 = (String)localObject2;
                localObject1 = localObject2;
                if (localFile.isFile())
                {
                  paramString2 = (String)localObject2;
                  localObject1 = localObject2;
                  if (localFile.length() > 0L)
                  {
                    paramString2 = (String)localObject2;
                    localObject1 = new StringBuilder();
                    paramString2 = (String)localObject2;
                    ((StringBuilder)localObject1).append("download Succeed but target file not exists, try copy from download tmp file:");
                    paramString2 = (String)localObject2;
                    ((StringBuilder)localObject1).append(paramString1);
                    paramString2 = (String)localObject2;
                    ((StringBuilder)localObject1).append(", length:");
                    paramString2 = (String)localObject2;
                    ((StringBuilder)localObject1).append(localFile.length());
                    paramString2 = (String)localObject2;
                    ((StringBuilder)localObject1).append(", to:");
                    paramString2 = (String)localObject2;
                    ((StringBuilder)localObject1).append(paramString3);
                    paramString2 = (String)localObject2;
                    QMLog.w("MiniAppLivePusher", ((StringBuilder)localObject1).toString());
                    paramString2 = (String)localObject2;
                    localObject2 = FileUtils.createFile(paramString3);
                    paramString2 = (String)localObject2;
                    if (FileUtils.copyFile(localFile, (File)localObject2))
                    {
                      paramString2 = (String)localObject2;
                      if (((File)localObject2).exists())
                      {
                        paramString2 = (String)localObject2;
                        if (((File)localObject2).length() == localFile.length())
                        {
                          paramString2 = (String)localObject2;
                          localObject1 = new StringBuilder();
                          paramString2 = (String)localObject2;
                          ((StringBuilder)localObject1).append("copy from download tmp file:");
                          paramString2 = (String)localObject2;
                          ((StringBuilder)localObject1).append(paramString1);
                          paramString2 = (String)localObject2;
                          ((StringBuilder)localObject1).append(" success");
                          paramString2 = (String)localObject2;
                          QMLog.i("MiniAppLivePusher", ((StringBuilder)localObject1).toString());
                          localObject1 = localObject2;
                          break label443;
                        }
                      }
                    }
                    paramString2 = (String)localObject2;
                    localObject1 = localObject2;
                    if (((File)localObject2).exists())
                    {
                      paramString2 = (String)localObject2;
                      ((File)localObject2).delete();
                      localObject1 = localObject2;
                    }
                  }
                }
              }
            }
            catch (Throwable localThrowable)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("try copy from download tmp file exception! tmp file:");
              ((StringBuilder)localObject2).append(paramString1);
              QMLog.e("MiniAppLivePusher", ((StringBuilder)localObject2).toString(), localThrowable);
              str = paramString2;
            }
          }
        }
        label443:
        this.downloadMap.remove(paramString4);
        operateLivePusher(paramString1, paramString3, paramJSONObject, paramString5, str);
        return;
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void operateLivePusher(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3, File paramFile)
  {
    if ((paramFile.exists()) && (paramFile.canRead()))
    {
      if (QMLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("download success BGMFilePath:");
        paramString1.append(paramString2);
        QMLog.d("MiniAppLivePusher", paramString1.toString());
      }
      paramJSONObject.put("BGMFilePath", paramString2);
      this.livePusherJSAdapter.operateLivePusher(paramString3, paramJSONObject);
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("download failed, filepath not exists, tmpFile:");
    paramString2.append(paramString1);
    QMLog.d("MiniAppLivePusher", paramString2.toString());
  }
  
  /* Error */
  private static void saveJpeg(android.graphics.Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 600	java/io/BufferedOutputStream
    //   5: dup
    //   6: new 602	java/io/FileOutputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 605	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   14: invokespecial 608	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   17: astore_1
    //   18: aload_0
    //   19: getstatic 614	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   22: bipush 100
    //   24: bipush 100
    //   26: invokestatic 620	java/lang/Math:min	(II)I
    //   29: aload_1
    //   30: invokevirtual 626	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   33: pop
    //   34: aload_1
    //   35: invokevirtual 629	java/io/BufferedOutputStream:flush	()V
    //   38: aload_1
    //   39: invokevirtual 632	java/io/BufferedOutputStream:close	()V
    //   42: return
    //   43: astore_0
    //   44: goto +6 -> 50
    //   47: astore_0
    //   48: aload_2
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +7 -> 58
    //   54: aload_1
    //   55: invokevirtual 632	java/io/BufferedOutputStream:close	()V
    //   58: aload_0
    //   59: athrow
    //   60: astore_0
    //   61: return
    //   62: astore_1
    //   63: goto -5 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	paramBitmap	android.graphics.Bitmap
    //   0	66	1	paramFile	File
    //   1	48	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	38	43	finally
    //   2	18	47	finally
    //   38	42	60	java/lang/Exception
    //   54	58	62	java/lang/Exception
  }
  
  private void setBGMNotifyListener(RequestEvent paramRequestEvent)
  {
    this.livePusherJSAdapter.setBGMNotifyListener(new MiniAppLivePusher.3(this, paramRequestEvent));
  }
  
  private void setPushListener(RequestEvent paramRequestEvent)
  {
    this.livePusherJSAdapter.setPushListener(new MiniAppLivePusher.2(this, paramRequestEvent));
  }
  
  private void setUpView(Context paramContext)
  {
    if (this.hasSetUp) {
      return;
    }
    this.hasSetUp = true;
    setTag("MiniAppLivePusher");
    this.context = paramContext;
    this.rootView = LayoutInflater.from(paramContext).inflate(R.layout.mini_sdk_live_pusher_view, null);
    this.pusherContainer = ((FrameLayout)this.rootView.findViewById(R.id.pusher_container));
    addView(this.rootView);
  }
  
  public boolean enterBackground()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppLivePusher", "enterBackground");
    }
    TXLivePusherJSAdapter localTXLivePusherJSAdapter = this.livePusherJSAdapter;
    if (localTXLivePusherJSAdapter != null) {
      localTXLivePusherJSAdapter.enterBackground(false);
    }
    return true;
  }
  
  public boolean enterForeground()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppLivePusher", "enterForeground");
    }
    TXLivePusherJSAdapter localTXLivePusherJSAdapter = this.livePusherJSAdapter;
    if (localTXLivePusherJSAdapter != null) {
      localTXLivePusherJSAdapter.enterForeground();
    }
    return true;
  }
  
  public void initLivePusherSettings(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if ((QMLog.isColorLevel()) && (paramJSONObject != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initLivePusherSettings json: ");
      localStringBuilder.append(paramJSONObject.toString());
      QMLog.d("MiniAppLivePusher", localStringBuilder.toString());
    }
    initPusherView();
    initPusher(paramRequestEvent, paramJSONObject);
  }
  
  public void operateLivePusher(String paramString, RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("operateLivePusher json: ");
    localStringBuilder.append(paramString);
    QMLog.d("MiniAppLivePusher", localStringBuilder.toString());
    if (this.livePusherJSAdapter != null)
    {
      if ("playBGM".equals(paramString))
      {
        doPlayBGM(paramString, paramRequestEvent, paramJSONObject);
        return;
      }
      if ("stopBGM".equals(paramString))
      {
        doStopBGM(paramString, paramRequestEvent, paramJSONObject);
        return;
      }
      if ("setBGMPosition".equals(paramString))
      {
        doSetBGMPosition(paramString, paramRequestEvent, paramJSONObject);
        return;
      }
      if ("snapshot".equals(paramString))
      {
        doSnapShot(paramRequestEvent, paramJSONObject);
        return;
      }
      if (paramString.equalsIgnoreCase("startAudioRecord"))
      {
        doStartAudioRecord(paramRequestEvent, paramJSONObject);
        return;
      }
      if (paramString.equalsIgnoreCase("stopAudioRecord"))
      {
        doStopAudioRecord(paramRequestEvent);
        return;
      }
      this.livePusherJSAdapter.operateLivePusher(paramString, paramJSONObject);
      paramString = ApiUtil.wrapCallbackOk("operateLivePusher", null);
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, paramString.toString());
    }
  }
  
  public void release()
  {
    this.handler.removeCallbacks(this.stopDumpRunnable);
    TXLivePusherJSAdapter localTXLivePusherJSAdapter = this.livePusherJSAdapter;
    if (localTXLivePusherJSAdapter != null) {
      localTXLivePusherJSAdapter.unInitLivePusher();
    }
    ScreenOffOnListener.getInstance().unRegistListener();
  }
  
  public void setAtyRef(WeakReference<Activity> paramWeakReference)
  {
    this.atyRef = paramWeakReference;
  }
  
  public void takePhoto(String paramString, boolean paramBoolean, RequestEvent paramRequestEvent)
  {
    TXLivePusherJSAdapter localTXLivePusherJSAdapter = this.livePusherJSAdapter;
    if (localTXLivePusherJSAdapter == null) {
      return;
    }
    localTXLivePusherJSAdapter.takePhoto(paramBoolean, new MiniAppLivePusher.4(this, paramString, paramRequestEvent));
  }
  
  public void updateLivePusherSetting(JSONObject paramJSONObject)
  {
    if ((QMLog.isColorLevel()) && (paramJSONObject != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLivePusherSetting params = ");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QMLog.d("MiniAppLivePusher", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.livePusherJSAdapter;
    if (localObject != null) {
      ((TXLivePusherJSAdapter)localObject).updateLivePusher(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePusher
 * JD-Core Version:    0.7.0.1
 */