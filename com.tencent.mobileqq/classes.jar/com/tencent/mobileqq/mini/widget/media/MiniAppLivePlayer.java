package com.tencent.mobileqq.mini.widget.media;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import bhnv;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.utils.ScreenOffOnListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.danmu.Barrage;
import com.tencent.mobileqq.mini.widget.media.live.TXJSAdapterError;
import com.tencent.mobileqq.mini.widget.media.live.TXLivePlayerJSAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppLivePlayer
  extends FrameLayout
  implements View.OnClickListener
{
  private static final String ON_LIVE_PLAYER_EVENT = "onLivePlayerEvent";
  private static final String ON_LIVE_PLAYER_FULLSCREENCHANGE = "onLivePlayerFullScreenChange";
  private static final String ON_LIVE_PLAYER_NETSTATUS = "onLivePlayerNetStatus";
  private static final String ON_LIVE_PLAYER_ON_AUDIO_VOLUME_NOTIFY = "onLivePlayerAudioVolumeNotify";
  private static final String TAG = "MiniAppLivePlayer";
  public static final String VIEW_TAG = "MiniAppLivePlayer";
  public WeakReference<Activity> atyRef;
  public List<Barrage> barrages;
  private int componentLayoutScrollY;
  public boolean customCache;
  public String data;
  public int direction = -1;
  public boolean enableDanmu;
  public boolean enablePlayGesture;
  public boolean enableProgressGesture = true;
  private final Handler handler = new Handler(Looper.getMainLooper());
  private boolean hasSetUp;
  public boolean hide;
  public int initialTime;
  boolean isBusyInChangeScreen = false;
  public boolean isFullScreen;
  private int lastNavBarVisibility = 8;
  long lastSmallScreenTime = -1L;
  private int lastTabBarVisibility = 8;
  public long livePlayerId;
  private TXLivePlayerJSAdapter livePlayerJsAdapter;
  public boolean loop;
  private Context mContext;
  private VideoGestureLayout mVideoGestureLayout;
  public boolean muted;
  public boolean needEvent;
  public int parentId;
  public String playBtnPosition;
  private ImageView play_status_img;
  public String poster;
  public JsRuntime serviceWebview;
  public boolean showCenterPlayBtn = true;
  public boolean showControlProgress;
  public boolean showDanmuBtn;
  public boolean showFullScreenBtn = true;
  public boolean showMuteBtn = true;
  public boolean showPlayBtn;
  public boolean showProgress = true;
  private ViewGroup.LayoutParams smallLayoutParams;
  private Object tXCloudVideoView;
  public String title;
  private View vdView;
  private VideoGestureRelativeLayout video_container;
  private FrameLayout video_pop_container;
  private View view;
  public WebviewContainer webviewContainer;
  public int webviewId;
  
  public MiniAppLivePlayer(@NonNull Context paramContext)
  {
    this(paramContext, null);
    setUpView(paramContext);
  }
  
  public MiniAppLivePlayer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setUpView(paramContext);
  }
  
  private void callBackFullScreenChange()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("livePlayerId", this.livePlayerId);
      localJSONObject.put("direction", "");
      localJSONObject.put("fullScreen", this.isFullScreen);
      this.serviceWebview.evaluateSubcribeJS("onLivePlayerFullScreenChange", localJSONObject.toString(), this.webviewId);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void cancelAvoidLockScreen()
  {
    if ((this.atyRef != null) && (this.atyRef.get() != null))
    {
      ((Activity)this.atyRef.get()).getWindow().clearFlags(128);
      ((Activity)this.atyRef.get()).getWindow().addFlags(1);
    }
  }
  
  private void enterFullScreenMode(Activity paramActivity)
  {
    int i = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = 5894;
      if (Build.VERSION.SDK_INT < 19) {
        break label64;
      }
      i |= 0x800;
    }
    for (;;)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
      return;
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      i = 1798;
      break;
      label64:
      i |= 0x1;
    }
  }
  
  private void initPlayerView()
  {
    this.tXCloudVideoView = bhnv.a("com.tencent.rtmp.ui.TXCloudVideoView", bhnv.a(new Class[] { Context.class }), new Object[] { getContext() });
    if (this.tXCloudVideoView == null)
    {
      QLog.e("MiniAppLivePlayer", 1, "tXCloudVideoView is null?! ");
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.vdView = ((View)this.tXCloudVideoView);
    this.vdView.setLayoutParams(localLayoutParams);
    this.vdView.setVisibility(0);
    this.video_pop_container.setVisibility(0);
    this.video_container.removeAllViews();
    this.video_container.addView(this.vdView);
    this.video_container.setBackgroundColor(-16777216);
    localLayoutParams = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.mContext, 100.0F), DisplayUtil.dip2px(this.mContext, 100.0F));
    localLayoutParams.gravity = 17;
    this.video_container.addView(this.mVideoGestureLayout, localLayoutParams);
  }
  
  /* Error */
  private static void saveJpeg(android.graphics.Bitmap paramBitmap, java.io.File paramFile)
  {
    // Byte code:
    //   0: new 345	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 347	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 350	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 353	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_1
    //   16: aload_0
    //   17: getstatic 359	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   20: bipush 100
    //   22: bipush 100
    //   24: invokestatic 365	java/lang/Math:min	(II)I
    //   27: aload_1
    //   28: invokevirtual 371	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 374	java/io/BufferedOutputStream:flush	()V
    //   36: aload_1
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 377	java/io/BufferedOutputStream:close	()V
    //   44: return
    //   45: astore_0
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 377	java/io/BufferedOutputStream:close	()V
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
    setTag("MiniAppLivePlayer");
    this.mContext = paramContext;
    this.view = LayoutInflater.from(paramContext).inflate(2131559270, null);
    this.video_container = ((VideoGestureRelativeLayout)this.view.findViewById(2131369057));
    this.video_container.setContentDescription("video_container");
    this.video_pop_container = ((FrameLayout)this.view.findViewById(2131379061));
    this.play_status_img = ((ImageView)this.view.findViewById(2131371756));
    this.play_status_img.setVisibility(8);
    this.video_container.setOnClickListener(this);
    this.mVideoGestureLayout = new VideoGestureLayout(this.mContext);
    this.mVideoGestureLayout.setContentDescription("VideoGestureLayout");
    addView(this.view);
  }
  
  public void changeState()
  {
    AppBrandTask.runTaskOnUiThread(new MiniAppLivePlayer.3(this));
  }
  
  public boolean enterBackground()
  {
    TXJSAdapterError localTXJSAdapterError = this.livePlayerJsAdapter.enterBackground(2);
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLivePlayer", 2, "enterBackground: " + localTXJSAdapterError);
    }
    return localTXJSAdapterError.errorCode == 0;
  }
  
  public boolean enterForeground()
  {
    TXJSAdapterError localTXJSAdapterError = this.livePlayerJsAdapter.enterForeground();
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLivePlayer", 2, "enterForeground: " + localTXJSAdapterError);
    }
    return localTXJSAdapterError.errorCode == 0;
  }
  
  public void fullScreen()
  {
    this.handler.post(new MiniAppLivePlayer.4(this));
  }
  
  public void initLivePlayerSettings(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLivePlayer", 2, "initLivePlayerSettings isFullScreen: " + this.isFullScreen);
    }
    if (this.isFullScreen) {
      return;
    }
    initPlayerView();
    this.livePlayerJsAdapter = new TXLivePlayerJSAdapter(getContext());
    this.livePlayerJsAdapter.initLivePlayer(this.tXCloudVideoView, paramJSONObject);
    this.livePlayerJsAdapter.setPlayListener(new MiniAppLivePlayer.1(this));
    this.livePlayerJsAdapter.setItxAudioVolumeEvaluationOuterListener(new MiniAppLivePlayer.2(this));
  }
  
  public boolean isFullScreen()
  {
    return this.isFullScreen;
  }
  
  boolean isFullScreenSize(int paramInt1, int paramInt2)
  {
    return (paramInt1 == DisplayUtil.getRealHeight(getContext())) && (paramInt2 == ImmersiveUtils.a());
  }
  
  public boolean isPlaying()
  {
    return (this.livePlayerJsAdapter != null) && (this.livePlayerJsAdapter.isPlaying());
  }
  
  public void onClick(View paramView) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.isFullScreen) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void operateLivePlayer(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    if (this.livePlayerJsAdapter == null) {
      return;
    }
    if ("requestFullScreen".equalsIgnoreCase(paramString))
    {
      fullScreen();
      this.webviewContainer.callbackJsEventOK("operateLivePlayer", null, paramInt);
      return;
    }
    if ("exitFullScreen".equalsIgnoreCase(paramString))
    {
      smallScreen();
      this.webviewContainer.callbackJsEventOK("operateLivePlayer", null, paramInt);
      return;
    }
    if ("snapshot".equalsIgnoreCase(paramString))
    {
      boolean bool2 = false;
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
      takePhoto("operateLivePlayer", bool1, paramInt);
      return;
    }
    this.livePlayerJsAdapter.operateLivePlayer(paramString, paramJSONObject);
    this.webviewContainer.callbackJsEventOK("operateLivePlayer", null, paramInt);
  }
  
  public void release()
  {
    if (this.livePlayerJsAdapter != null) {
      this.livePlayerJsAdapter.uninitLivePlayer();
    }
    cancelAvoidLockScreen();
    ScreenOffOnListener.getInstance().unRegistListener();
  }
  
  public void setAtyRef(WeakReference<Activity> paramWeakReference)
  {
    this.atyRef = paramWeakReference;
  }
  
  public void smallScreen()
  {
    this.handler.post(new MiniAppLivePlayer.5(this));
  }
  
  public void stop()
  {
    if (this.isFullScreen) {
      smallScreen();
    }
    if (this.livePlayerJsAdapter != null) {
      this.livePlayerJsAdapter.operateLivePlayer("stop", null);
    }
    cancelAvoidLockScreen();
  }
  
  public void takePhoto(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.livePlayerJsAdapter == null) {
      return;
    }
    QLog.e("MiniAppLivePlayer", 1, "takePhoto invoke");
    this.livePlayerJsAdapter.setSnapshotListener(new MiniAppLivePlayer.6(this, paramString, paramInt));
    this.livePlayerJsAdapter.takePhoto(paramBoolean);
  }
  
  public void updateLivePlayerSetting(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLivePlayer", 2, "updateLivePlayerSetting isFullScreen: " + this.isFullScreen);
    }
    if (this.isFullScreen) {}
    while (this.livePlayerJsAdapter == null) {
      return;
    }
    this.livePlayerJsAdapter.updateLivePlayer(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppLivePlayer
 * JD-Core Version:    0.7.0.1
 */