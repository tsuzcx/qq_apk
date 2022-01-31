package com.tencent.mobileqq.mini.widget.media;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import bbjw;
import bhnv;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.utils.ScreenOffOnListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePusherJSAdapter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
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
  private boolean hasSetUp;
  public long livePusherId;
  private TXLivePusherJSAdapter livePusherJSAdapter;
  private boolean needToStopDownloadBGM;
  private FrameLayout pusherContainer;
  private ArrayList<String> pusherKeyList;
  private View rootView;
  public JsRuntime serviceWebview;
  private Runnable stopDumpRunnable = new MiniAppLivePusher.1(this);
  private Object tXCloudVideoView;
  private String tempAudioFilePath;
  public int webviewId;
  
  public MiniAppLivePusher(@NonNull Context paramContext)
  {
    this(paramContext, null);
    setUpView(paramContext);
  }
  
  public MiniAppLivePusher(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setUpView(paramContext);
  }
  
  private Bundle adaptJsonToBundle(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    if (paramJSONObject == null) {
      return localBundle;
    }
    if (this.pusherKeyList == null)
    {
      QLog.e("MiniAppLivePusher", 1, "adaptJsonToBundle - pusherKeyList is null");
      return localBundle;
    }
    Iterator localIterator = this.pusherKeyList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str.equalsIgnoreCase("pushUrl")) || (str.equalsIgnoreCase("orientation")) || (str.equalsIgnoreCase("backgroundImage")) || (str.equalsIgnoreCase("audioQuality")) || (str.equalsIgnoreCase("watermarkImage")) || (str.equalsIgnoreCase("audioVolumeType")) || (str.equalsIgnoreCase("localMirror")) || (str.equalsIgnoreCase("devicePosition"))) {
        try
        {
          localBundle.putString(str, paramJSONObject.getString(str));
        }
        catch (JSONException localJSONException1) {}
      } else if ((localJSONException1.equalsIgnoreCase("mode")) || (localJSONException1.equalsIgnoreCase("focusMode")) || (localJSONException1.equalsIgnoreCase("beauty")) || (localJSONException1.equalsIgnoreCase("whiteness")) || (localJSONException1.equalsIgnoreCase("aspect")) || (localJSONException1.equalsIgnoreCase("videoWidth")) || (localJSONException1.equalsIgnoreCase("videoHeight")) || (localJSONException1.equalsIgnoreCase("audioReverbType")) || (localJSONException1.equalsIgnoreCase("minBitrate")) || (localJSONException1.equalsIgnoreCase("maxBitrate"))) {
        try
        {
          localBundle.putInt(localJSONException1, paramJSONObject.getInt(localJSONException1));
        }
        catch (JSONException localJSONException2) {}
      } else if ((localJSONException2.equalsIgnoreCase("hide")) || (localJSONException2.equalsIgnoreCase("autopush")) || (localJSONException2.equalsIgnoreCase("muted")) || (localJSONException2.equalsIgnoreCase("enableCamera")) || (localJSONException2.equalsIgnoreCase("enableMic")) || (localJSONException2.equalsIgnoreCase("enableAGC")) || (localJSONException2.equalsIgnoreCase("enableANS")) || (localJSONException2.equalsIgnoreCase("backgroundMute")) || (localJSONException2.equalsIgnoreCase("zoom")) || (localJSONException2.equalsIgnoreCase("needEvent")) || (localJSONException2.equalsIgnoreCase("needBGMEvent")) || (localJSONException2.equalsIgnoreCase("debug")) || (localJSONException2.equalsIgnoreCase("mirror")) || (localJSONException2.equalsIgnoreCase("remoteMirror")) || (localJSONException2.equalsIgnoreCase("enableEarMonitor"))) {
        try
        {
          localBundle.putBoolean(localJSONException2, paramJSONObject.getBoolean(localJSONException2));
        }
        catch (JSONException localJSONException3) {}
      } else if ((localJSONException3.equalsIgnoreCase("watermarkLeft")) || (localJSONException3.equalsIgnoreCase("watermarkTop")) || (localJSONException3.equalsIgnoreCase("watermarkWidth"))) {
        try
        {
          localBundle.putDouble(localJSONException3, paramJSONObject.getDouble(localJSONException3));
        }
        catch (JSONException localJSONException4) {}
      }
    }
    return localBundle;
  }
  
  private void initPusher(JSONObject paramJSONObject)
  {
    if ((QLog.isColorLevel()) && (paramJSONObject != null)) {
      QLog.d("MiniAppLivePusher", 1, "initLivePusher params = " + paramJSONObject.toString());
    }
    initPusherKeyList();
    this.livePusherJSAdapter = new TXLivePusherJSAdapter(getContext());
    this.livePusherJSAdapter.initLivePusher(this.tXCloudVideoView, adaptJsonToBundle(paramJSONObject));
    this.livePusherJSAdapter.setBGMNotifyListener(new MiniAppLivePusher.2(this));
    this.livePusherJSAdapter.setPushListener(new MiniAppLivePusher.3(this));
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
    this.tXCloudVideoView = bhnv.a("com.tencent.rtmp.ui.TXCloudVideoView", bhnv.a(new Class[] { Context.class }), new Object[] { getContext() });
    if (this.tXCloudVideoView == null)
    {
      QLog.e("MiniAppLivePusher", 1, "tXCloudVideoView is null?! ");
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
  
  /* Error */
  private static void saveJpeg(android.graphics.Bitmap paramBitmap, java.io.File paramFile)
  {
    // Byte code:
    //   0: new 391	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 393	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 396	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 399	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_1
    //   16: aload_0
    //   17: getstatic 405	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   20: bipush 100
    //   22: bipush 100
    //   24: invokestatic 411	java/lang/Math:min	(II)I
    //   27: aload_1
    //   28: invokevirtual 417	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 420	java/io/BufferedOutputStream:flush	()V
    //   36: aload_1
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 423	java/io/BufferedOutputStream:close	()V
    //   44: return
    //   45: astore_0
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 423	java/io/BufferedOutputStream:close	()V
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
    //   0	68	1	paramFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   0	16	45	finally
    //   40	44	58	java/lang/Exception
    //   52	56	60	java/lang/Exception
    //   16	36	64	finally
  }
  
  private void setUpView(Context paramContext)
  {
    if (this.hasSetUp) {
      return;
    }
    this.hasSetUp = true;
    setTag("MiniAppLivePusher");
    this.context = paramContext;
    this.rootView = LayoutInflater.from(paramContext).inflate(2131559264, null);
    this.pusherContainer = ((FrameLayout)this.rootView.findViewById(2131372168));
    addView(this.rootView);
  }
  
  public boolean enterBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLivePusher", 2, "enterBackground");
    }
    if (this.livePusherJSAdapter != null) {
      this.livePusherJSAdapter.enterBackground(false);
    }
    return true;
  }
  
  public boolean enterForeground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLivePusher", 2, "enterForeground");
    }
    if (this.livePusherJSAdapter != null) {
      this.livePusherJSAdapter.enterForeground();
    }
    return true;
  }
  
  public void initLivePusherSettings(JSONObject paramJSONObject)
  {
    if ((QLog.isColorLevel()) && (paramJSONObject != null)) {
      QLog.d("MiniAppLivePusher", 2, "initLivePusherSettings json: " + paramJSONObject.toString());
    }
    initPusherView();
    initPusher(paramJSONObject);
  }
  
  public void operateLivePusher(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    QLog.d("MiniAppLivePusher", 2, "operateLivePusher json: " + paramString);
    if (this.livePusherJSAdapter != null)
    {
      if ("playBGM".equals(paramString))
      {
        if (paramJSONObject != null)
        {
          this.needToStopDownloadBGM = false;
          String str1 = String.valueOf(this.downloadTaskId.getAndIncrement());
          String str2 = paramJSONObject.optString("url");
          this.downloadMap.put(str1, str2);
          String str3 = MiniAppFileManager.getInstance().getTmpPathByUrl(str2);
          MiniappDownloadUtil.getInstance().download(str2, str3, true, new MiniAppLivePusher.5(this, str1, str2, str3, paramJSONObject, paramString), Downloader.DownloadMode.FastMode, null);
        }
        paramString = ApiUtil.wrapCallbackOk("operateLivePusher", null);
        this.serviceWebview.evaluateCallbackJs(paramInt, paramString.toString());
      }
    }
    else {
      return;
    }
    if ("stopBGM".equals(paramString))
    {
      this.needToStopDownloadBGM = true;
      this.livePusherJSAdapter.operateLivePusher(paramString, paramJSONObject);
      paramString = ApiUtil.wrapCallbackOk("operateLivePusher", null);
      this.serviceWebview.evaluateCallbackJs(paramInt, paramString.toString());
      return;
    }
    if ("setBGMPosition".equals(paramString)) {
      try
      {
        paramJSONObject.put("BGMPosition", paramJSONObject.getInt("position") * 1000);
        this.livePusherJSAdapter.operateLivePusher(paramString, paramJSONObject);
        paramString = ApiUtil.wrapCallbackOk("operateLivePusher", null);
        this.serviceWebview.evaluateCallbackJs(paramInt, paramString.toString());
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          QLog.e("MiniAppLivePusher", 1, "setBGMPosition - JSONException:" + paramString);
        }
      }
    }
    if ("snapshot".equals(paramString))
    {
      boolean bool1 = bool2;
      if (paramJSONObject != null)
      {
        paramString = paramJSONObject.optString("quality");
        bool1 = bool2;
        if (paramString != null)
        {
          bool1 = bool2;
          if (paramString.equalsIgnoreCase("compressed")) {
            bool1 = true;
          }
        }
      }
      takePhoto("operateLivePusher", bool1, paramInt);
      return;
    }
    if (paramString.equalsIgnoreCase("startAudioRecord"))
    {
      paramString = MiniAppFileManager.getInstance().getTmpPath("pcm");
      long l = paramJSONObject.optLong("maxDuration");
      QLog.d("MiniAppLivePusher", 2, "recordFile:" + paramString);
      int i = this.livePusherJSAdapter.startDumpAudioData(paramString);
      QLog.d("MiniAppLivePusher", 2, "recordResult:" + i);
      if (i == 0) {
        paramJSONObject = new JSONObject();
      }
      for (;;)
      {
        try
        {
          paramJSONObject.put("tempFilePath", paramString);
          this.tempAudioFilePath = paramString;
          paramString = ApiUtil.wrapCallbackOk("operateLivePusher", paramJSONObject);
          this.serviceWebview.evaluateCallbackJs(paramInt, paramString.toString());
          this.handler.postDelayed(this.stopDumpRunnable, l);
          QLog.d("MiniAppLivePusher", 2, "recordResult:" + i);
          return;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          continue;
        }
        if (i == -1)
        {
          paramString = ApiUtil.wrapCallbackFail("operateLivePusher", null, "LivePusher is recording");
          this.serviceWebview.evaluateCallbackJs(paramInt, paramString.toString());
          return;
        }
        if (i == -2)
        {
          paramString = ApiUtil.wrapCallbackFail("operateLivePusher", null, "LivePusher creates recordFile failed");
          this.serviceWebview.evaluateCallbackJs(paramInt, paramString.toString());
        }
        else if (i == -3)
        {
          paramString = ApiUtil.wrapCallbackFail("operateLivePusher", null, "LivePusher not support current format");
          this.serviceWebview.evaluateCallbackJs(paramInt, paramString.toString());
        }
        else
        {
          paramString = ApiUtil.wrapCallbackFail("operateLivePusher", null, "LivePusher starts recording fail");
          this.serviceWebview.evaluateCallbackJs(paramInt, paramString.toString());
        }
      }
    }
    if (paramString.equalsIgnoreCase("stopAudioRecord"))
    {
      QLog.d("MiniAppLivePusher", 2, "stopDumpAudioData");
      this.handler.removeCallbacks(this.stopDumpRunnable);
      this.livePusherJSAdapter.stopDumpAudioData();
      paramString = new JSONObject();
      try
      {
        if (!bbjw.a(this.tempAudioFilePath))
        {
          paramString.put("tempFilePath", this.tempAudioFilePath);
          this.tempAudioFilePath = null;
        }
        for (;;)
        {
          paramString = ApiUtil.wrapCallbackOk("operateLivePusher", paramString);
          this.serviceWebview.evaluateCallbackJs(paramInt, paramString.toString());
          return;
          paramString.put("tempFilePath", "");
        }
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
    this.livePusherJSAdapter.operateLivePusher(paramString, paramJSONObject);
    paramString = ApiUtil.wrapCallbackOk("operateLivePusher", null);
    this.serviceWebview.evaluateCallbackJs(paramInt, paramString.toString());
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
  
  public void takePhoto(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.livePusherJSAdapter == null) {
      return;
    }
    this.livePusherJSAdapter.takePhoto(paramBoolean, new MiniAppLivePusher.4(this, paramString, paramInt));
  }
  
  public void updateLivePusherSetting(JSONObject paramJSONObject)
  {
    if ((QLog.isColorLevel()) && (paramJSONObject != null)) {
      QLog.d("MiniAppLivePusher", 2, "updateLivePusherSetting params = " + paramJSONObject.toString());
    }
    if (this.livePusherJSAdapter != null) {
      this.livePusherJSAdapter.updateLivePusher(adaptJsonToBundle(paramJSONObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppLivePusher
 * JD-Core Version:    0.7.0.1
 */