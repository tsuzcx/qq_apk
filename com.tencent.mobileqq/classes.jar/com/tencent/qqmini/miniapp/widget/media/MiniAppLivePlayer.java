package com.tencent.qqmini.miniapp.widget.media;

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
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterError;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.core.utils.ScreenOffOnListener;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.utils.JarReflectUtil;
import com.tencent.qqmini.sdk.widget.media.danmu.Barrage;
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
  private static final String ON_LIVE_PLAYER_META_DATA = "onLivePlayerMetadata";
  private static final String ON_LIVE_PLAYER_NETSTATUS = "onLivePlayerNetStatus";
  private static final String ON_LIVE_PLAYER_ON_AUDIO_VOLUME_NOTIFY = "onLivePlayerAudioVolumeNotify";
  private static final String TAG = "MiniAppLivePlayer";
  public static final String VIEW_TAG = "MiniAppLivePlayer";
  public WeakReference<Activity> atyRef;
  public List<Barrage> barrages;
  public BaseRuntime baseRuntime;
  private int componentLayoutScrollY = 0;
  public boolean customCache;
  public String data;
  public int direction = -1;
  public boolean enableDanmu = false;
  public boolean enablePlayGesture = false;
  public boolean enableProgressGesture = true;
  private final Handler handler = new Handler(Looper.getMainLooper());
  private boolean hasSetUp = false;
  public boolean hide;
  public int initialTime = 0;
  boolean isBusyInChangeScreen = false;
  public boolean isFullScreen;
  private int lastNavBarVisibility = 8;
  long lastSmallScreenTime = -1L;
  private int lastTabBarVisibility = 8;
  public long livePlayerId;
  private TXLivePlayerJSAdapter livePlayerJsAdapter;
  public boolean loop = false;
  private Context mContext;
  public WeakReference<IMiniAppContext> miniAppContextRef;
  public boolean muted = false;
  public boolean needEvent;
  public int parentId;
  public String playBtnPosition;
  private ImageView playStatusImg;
  public String poster;
  public boolean showCenterPlayBtn = true;
  public boolean showControlProgress;
  public boolean showDanmuBtn = false;
  public boolean showFullScreenBtn = true;
  public boolean showMuteBtn = true;
  public boolean showPlayBtn = false;
  public boolean showProgress = true;
  private ViewGroup.LayoutParams smallLayoutParams;
  private Object tXCloudVideoView;
  public String title;
  private View vdView;
  private VideoGestureRelativeLayout videoContainer;
  private FrameLayout videoPopContainer;
  private View view;
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
      if (this.miniAppContextRef != null) {}
      for (IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.miniAppContextRef.get();; localIMiniAppContext = null)
      {
        if (localIMiniAppContext != null) {
          localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onLivePlayerFullScreenChange", localJSONObject.toString(), this.webviewId));
        }
        this.baseRuntime.getJsService().evaluateSubscribeJS("onLivePlayerFullScreenChange", localJSONObject.toString(), this.webviewId);
        return;
      }
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
    this.tXCloudVideoView = JarReflectUtil.creatSpecifiedObject("com.tencent.rtmp.ui.TXCloudVideoView", JarReflectUtil.getParamsClass(new Class[] { Context.class }), new Object[] { getContext() });
    if (this.tXCloudVideoView == null)
    {
      QMLog.e("MiniAppLivePlayer", "tXCloudVideoView is null?! ");
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.vdView = ((View)this.tXCloudVideoView);
    this.vdView.setLayoutParams(localLayoutParams);
    this.vdView.setVisibility(0);
    this.videoPopContainer.setVisibility(0);
    this.videoContainer.removeAllViews();
    this.videoContainer.addView(this.vdView);
    this.videoContainer.setBackgroundColor(-16777216);
    this.videoContainer.setEnablePageGesture(false);
    this.videoContainer.setEnablePlayGesture(false);
    this.videoContainer.setEnableProgressGesture(false);
  }
  
  /* Error */
  private static void saveJpeg(android.graphics.Bitmap paramBitmap, java.io.File paramFile)
  {
    // Byte code:
    //   0: new 376	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 378	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 381	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 384	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_1
    //   16: aload_0
    //   17: getstatic 390	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   20: bipush 100
    //   22: bipush 100
    //   24: invokestatic 396	java/lang/Math:min	(II)I
    //   27: aload_1
    //   28: invokevirtual 402	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 405	java/io/BufferedOutputStream:flush	()V
    //   36: aload_1
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 408	java/io/BufferedOutputStream:close	()V
    //   44: return
    //   45: astore_0
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 408	java/io/BufferedOutputStream:close	()V
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
    this.view = LayoutInflater.from(paramContext).inflate(R.layout.mini_sdk_player_view, null);
    this.videoContainer = ((VideoGestureRelativeLayout)this.view.findViewById(R.id.layout_videolayout));
    this.videoContainer.setContentDescription("videoContainer");
    this.videoPopContainer = ((FrameLayout)this.view.findViewById(R.id.video_pop_container));
    this.playStatusImg = ((ImageView)this.view.findViewById(R.id.play_status_img));
    this.playStatusImg.setVisibility(8);
    this.videoContainer.setOnClickListener(this);
    addView(this.view);
  }
  
  public void changeState()
  {
    AppBrandTask.runTaskOnUiThread(new MiniAppLivePlayer.3(this));
  }
  
  public boolean enterBackground()
  {
    TXJSAdapterError localTXJSAdapterError = this.livePlayerJsAdapter.enterBackground(2);
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppLivePlayer", "enterBackground: " + localTXJSAdapterError);
    }
    return localTXJSAdapterError.errorCode == 0;
  }
  
  public boolean enterForeground()
  {
    TXJSAdapterError localTXJSAdapterError = this.livePlayerJsAdapter.enterForeground();
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppLivePlayer", "enterForeground: " + localTXJSAdapterError);
    }
    return localTXJSAdapterError.errorCode == 0;
  }
  
  public void fullScreen()
  {
    this.handler.post(new MiniAppLivePlayer.4(this));
  }
  
  public void initLivePlayerSettings(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppLivePlayer", "initLivePlayerSettings isFullScreen: " + this.isFullScreen);
    }
    initPlayerView();
    this.livePlayerJsAdapter = new TXLivePlayerJSAdapter(getContext());
    this.livePlayerJsAdapter.initLivePlayer(this.tXCloudVideoView, paramJSONObject);
    this.livePlayerJsAdapter.setPlayListener(new MiniAppLivePlayer.1(this, paramRequestEvent));
    this.livePlayerJsAdapter.setItxAudioVolumeEvaluationOuterListener(new MiniAppLivePlayer.2(this, paramRequestEvent));
  }
  
  public boolean isFullScreen()
  {
    return this.isFullScreen;
  }
  
  boolean isFullScreenSize(int paramInt1, int paramInt2)
  {
    return (paramInt1 == DisplayUtil.getRealHeight(getContext())) && (paramInt2 == ImmersiveUtils.getScreenWidth());
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
  
  public void operateLivePlayer(String paramString, RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if (this.livePlayerJsAdapter == null) {
      return;
    }
    if ("requestFullScreen".equalsIgnoreCase(paramString))
    {
      fullScreen();
      paramRequestEvent.ok();
      return;
    }
    if ("exitFullScreen".equalsIgnoreCase(paramString))
    {
      smallScreen();
      paramRequestEvent.ok();
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
      takePhoto("operateLivePlayer", bool1, paramRequestEvent);
      return;
    }
    this.livePlayerJsAdapter.operateLivePlayer(paramString, paramJSONObject);
    paramRequestEvent.ok();
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
    if (this.livePlayerJsAdapter != null) {
      this.livePlayerJsAdapter.operateLivePlayer("stop", null);
    }
    cancelAvoidLockScreen();
  }
  
  public void takePhoto(String paramString, boolean paramBoolean, RequestEvent paramRequestEvent)
  {
    if (this.livePlayerJsAdapter == null) {
      return;
    }
    QMLog.e("MiniAppLivePlayer", "takePhoto invoke");
    this.livePlayerJsAdapter.setSnapshotListener(new MiniAppLivePlayer.6(this, paramString, paramRequestEvent));
    this.livePlayerJsAdapter.takePhoto(paramBoolean);
  }
  
  public void updateLivePlayerSetting(JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniAppLivePlayer", "updateLivePlayerSetting isFullScreen: " + this.isFullScreen);
    }
    if (this.livePlayerJsAdapter == null) {
      return;
    }
    this.livePlayerJsAdapter.updateLivePlayer(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer
 * JD-Core Version:    0.7.0.1
 */