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
      paramString = ApiUtil.wrapCallbackOk("operateLivePusher", null);
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, paramString.toString());
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QMLog.e("MiniAppLivePusher", "setBGMPosition - JSONException:" + paramString);
      }
    }
  }
  
  private void doSnapShot(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("quality");
      bool1 = bool2;
      if (paramJSONObject != null)
      {
        bool1 = bool2;
        if (paramJSONObject.equalsIgnoreCase("compressed")) {
          bool1 = true;
        }
      }
    }
    takePhoto("operateLivePusher", bool1, paramRequestEvent);
  }
  
  private void doStartAudioRecord(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    Object localObject = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath("pcm");
    long l = paramJSONObject.optLong("maxDuration");
    QMLog.d("MiniAppLivePusher", "recordFile:" + (String)localObject);
    int i = this.livePusherJSAdapter.startDumpAudioData((String)localObject);
    QMLog.d("MiniAppLivePusher", "recordResult:" + i);
    JSONObject localJSONObject;
    if (i == 0) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramJSONObject = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath((String)localObject);
        ((JSONException)localObject).printStackTrace();
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          QMLog.d("MiniAppLivePusher", "recordFile transformed:" + paramJSONObject);
          localJSONObject.put("tempFilePath", paramJSONObject);
          this.tempAudioFilePath = paramJSONObject;
          paramJSONObject = ApiUtil.wrapCallbackOk("operateLivePusher", localJSONObject);
          paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, paramJSONObject.toString());
          this.handler.postDelayed(this.stopDumpRunnable, l);
          QMLog.d("MiniAppLivePusher", "recordResult:" + i);
          return;
        }
        catch (JSONException localJSONException1)
        {
          break label239;
        }
        localJSONException2 = localJSONException2;
        paramJSONObject = (JSONObject)localObject;
        localObject = localJSONException2;
      }
      label239:
      continue;
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
  }
  
  private void doStopAudioRecord(RequestEvent paramRequestEvent)
  {
    QMLog.d("MiniAppLivePusher", "stopDumpAudioData");
    this.handler.removeCallbacks(this.stopDumpRunnable);
    this.livePusherJSAdapter.stopDumpAudioData();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!TextUtils.isEmpty(this.tempAudioFilePath))
      {
        localJSONObject.put("tempFilePath", this.tempAudioFilePath);
        this.tempAudioFilePath = null;
      }
      for (;;)
      {
        localJSONObject = ApiUtil.wrapCallbackOk("operateLivePusher", localJSONObject);
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject.toString());
        return;
        localJSONObject.put("tempFilePath", "");
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
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
    if ((QMLog.isColorLevel()) && (paramJSONObject != null)) {
      QMLog.d("MiniAppLivePusher", "initLivePusher params = " + paramJSONObject.toString());
    }
    initPusherKeyList();
    this.livePusherJSAdapter = new TXLivePusherJSAdapter(getContext());
    this.livePusherJSAdapter.initLivePusher(this.tXCloudVideoView, paramJSONObject);
    setBGMNotifyListener(paramRequestEvent);
    setPushListener(paramRequestEvent);
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
    label334:
    for (;;)
    {
      try
      {
        QMLog.e("MiniAppLivePusher", "playBGM - download onDownloadSucceed:" + paramString2);
        if (this.needToStopDownloadBGM)
        {
          QMLog.e("MiniAppLivePusher", "playBGM - download onDownloadSucceed but needToStopDownloadBGM");
          return;
        }
        if (TextUtils.isEmpty(paramString3)) {
          break;
        }
        paramString2 = new File(paramString3);
        if ((paramString2.exists()) || (TextUtils.isEmpty(paramString1))) {
          break label334;
        }
        QMLog.e("MiniAppLivePusher", "file no exists, try to copy again.");
      }
      catch (JSONException paramString1)
      {
        File localFile;
        label248:
        paramString1.printStackTrace();
        return;
      }
      for (;;)
      {
        try
        {
          localFile = new File(paramString1);
          localObject = paramString2;
          if (localFile.exists())
          {
            localObject = paramString2;
            if (localFile.isFile())
            {
              localObject = paramString2;
              if (localFile.length() > 0L)
              {
                QMLog.w("MiniAppLivePusher", "download Succeed but target file not exists, try copy from download tmp file:" + paramString1 + ", length:" + localFile.length() + ", to:" + paramString3);
                localObject = FileUtils.createFile(paramString3);
                paramString2 = (String)localObject;
              }
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          continue;
        }
        try
        {
          if ((!FileUtils.copyFile(localFile, paramString2)) || (!paramString2.exists()) || (paramString2.length() != localFile.length())) {
            continue;
          }
          QMLog.i("MiniAppLivePusher", "copy from download tmp file:" + paramString1 + " success");
          localObject = paramString2;
          paramString2 = (String)localObject;
        }
        catch (Throwable localThrowable1)
        {
          QMLog.e("MiniAppLivePusher", "try copy from download tmp file exception! tmp file:" + paramString1, localThrowable1);
          break label248;
        }
      }
      this.downloadMap.remove(paramString4);
      operateLivePusher(paramString1, paramString3, paramJSONObject, paramString5, paramString2);
      return;
      Object localObject = paramString2;
      if (paramString2.exists())
      {
        paramString2.delete();
        localObject = paramString2;
      }
    }
  }
  
  private void operateLivePusher(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3, File paramFile)
  {
    if ((paramFile.exists()) && (paramFile.canRead()))
    {
      if (QMLog.isColorLevel()) {
        QMLog.d("MiniAppLivePusher", "download success BGMFilePath:" + paramString2);
      }
      paramJSONObject.put("BGMFilePath", paramString2);
      this.livePusherJSAdapter.operateLivePusher(paramString3, paramJSONObject);
      return;
    }
    QMLog.d("MiniAppLivePusher", "download failed, filepath not exists, tmpFile:" + paramString1);
  }
  
  /* Error */
  private static void saveJpeg(android.graphics.Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: new 597	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 599	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 602	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 605	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_1
    //   16: aload_0
    //   17: getstatic 611	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   20: bipush 100
    //   22: bipush 100
    //   24: invokestatic 617	java/lang/Math:min	(II)I
    //   27: aload_1
    //   28: invokevirtual 623	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 626	java/io/BufferedOutputStream:flush	()V
    //   36: aload_1
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 629	java/io/BufferedOutputStream:close	()V
    //   44: return
    //   45: astore_0
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 629	java/io/BufferedOutputStream:close	()V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: return
    //   60: astore_1
    //   61: goto -5 -> 56
    //   64: astore_0
    //   65: goto -17 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramBitmap	android.graphics.Bitmap
    //   0	68	1	paramFile	File
    // Exception table:
    //   from	to	target	type
    //   0	16	45	finally
    //   40	44	58	java/lang/Exception
    //   52	56	60	java/lang/Exception
    //   16	36	64	finally
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
    if (this.livePusherJSAdapter != null) {
      this.livePusherJSAdapter.enterBackground(false);
    }
    return true;
  }
  
  public boolean enterForeground()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppLivePusher", "enterForeground");
    }
    if (this.livePusherJSAdapter != null) {
      this.livePusherJSAdapter.enterForeground();
    }
    return true;
  }
  
  public void initLivePusherSettings(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if ((QMLog.isColorLevel()) && (paramJSONObject != null)) {
      QMLog.d("MiniAppLivePusher", "initLivePusherSettings json: " + paramJSONObject.toString());
    }
    initPusherView();
    initPusher(paramRequestEvent, paramJSONObject);
  }
  
  public void operateLivePusher(String paramString, RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    QMLog.d("MiniAppLivePusher", "operateLivePusher json: " + paramString);
    if (this.livePusherJSAdapter != null)
    {
      if ("playBGM".equals(paramString)) {
        doPlayBGM(paramString, paramRequestEvent, paramJSONObject);
      }
    }
    else {
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
  
  public void release()
  {
    this.handler.removeCallbacks(this.stopDumpRunnable);
    if (this.livePusherJSAdapter != null) {
      this.livePusherJSAdapter.unInitLivePusher();
    }
    ScreenOffOnListener.getInstance().unRegistListener();
  }
  
  public void setAtyRef(WeakReference<Activity> paramWeakReference)
  {
    this.atyRef = paramWeakReference;
  }
  
  public void takePhoto(String paramString, boolean paramBoolean, RequestEvent paramRequestEvent)
  {
    if (this.livePusherJSAdapter == null) {
      return;
    }
    this.livePusherJSAdapter.takePhoto(paramBoolean, new MiniAppLivePusher.4(this, paramString, paramRequestEvent));
  }
  
  public void updateLivePusherSetting(JSONObject paramJSONObject)
  {
    if ((QMLog.isColorLevel()) && (paramJSONObject != null)) {
      QMLog.d("MiniAppLivePusher", "updateLivePusherSetting params = " + paramJSONObject.toString());
    }
    if (this.livePusherJSAdapter != null) {
      this.livePusherJSAdapter.updateLivePusher(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePusher
 * JD-Core Version:    0.7.0.1
 */