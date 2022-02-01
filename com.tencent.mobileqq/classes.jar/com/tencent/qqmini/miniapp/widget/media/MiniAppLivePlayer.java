package com.tencent.qqmini.miniapp.widget.media;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
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
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.TabBar;
import com.tencent.qqmini.sdk.widget.media.danmu.Barrage;
import java.lang.ref.WeakReference;
import java.util.HashMap;
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
      IMiniAppContext localIMiniAppContext;
      if (this.miniAppContextRef != null) {
        localIMiniAppContext = (IMiniAppContext)this.miniAppContextRef.get();
      } else {
        localIMiniAppContext = null;
      }
      if (localIMiniAppContext != null) {
        localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onLivePlayerFullScreenChange", localJSONObject.toString(), this.webviewId));
      }
      this.baseRuntime.getJsService().evaluateSubscribeJS("onLivePlayerFullScreenChange", localJSONObject.toString(), this.webviewId);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void cancelAvoidLockScreen()
  {
    WeakReference localWeakReference = this.atyRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      ((Activity)this.atyRef.get()).getWindow().clearFlags(128);
      ((Activity)this.atyRef.get()).getWindow().addFlags(1);
    }
  }
  
  private void enterFullScreenMode(Activity paramActivity)
  {
    int i = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
    if (Build.VERSION.SDK_INT >= 21) {
      i = 5894;
    } else if (Build.VERSION.SDK_INT >= 16) {
      i = 1798;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      i |= 0x800;
    } else {
      i |= 0x1;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
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
  
  private void onPlayEvent(int paramInt, Bundle paramBundle, RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject2 = null;
    JSONObject localJSONObject1 = null;
    if (2028 == paramInt) {
      try
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("livePlayerId", this.livePlayerId);
        localJSONObject2.put("errCode", paramInt);
        paramBundle = paramBundle.get("EVT_GET_METADATA");
        if ((paramBundle instanceof HashMap)) {
          localJSONObject2.put("errMsg", new JSONObject((HashMap)paramBundle));
        }
        paramBundle = localJSONObject1;
        if (this.miniAppContextRef != null) {
          paramBundle = (IMiniAppContext)this.miniAppContextRef.get();
        }
        if (paramBundle != null) {
          paramBundle.performAction(ServiceSubscribeEvent.obtain("onLivePlayerMetadata", localJSONObject2.toString(), this.webviewId));
        }
        paramRequestEvent.jsService.evaluateSubscribeJS("onLivePlayerMetadata", localJSONObject2.toString(), this.webviewId);
        paramBundle = new StringBuilder();
        paramBundle.append("operate start evaluateSubcribeJS onLivePlayerMetadata = ");
        paramBundle.append(localJSONObject2.toString());
        QMLog.e("MiniAppLivePlayer", paramBundle.toString());
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONObject1.put("livePlayerId", this.livePlayerId);
      localJSONObject1.put("errCode", paramInt);
      localJSONObject1.put("errMsg", paramBundle.get("EVT_MSG"));
      paramBundle = localJSONObject2;
      if (this.miniAppContextRef != null) {
        paramBundle = (IMiniAppContext)this.miniAppContextRef.get();
      }
      if (paramBundle != null) {
        paramBundle.performAction(ServiceSubscribeEvent.obtain("onLivePlayerEvent", localJSONObject1.toString(), this.webviewId));
      }
      paramRequestEvent.jsService.evaluateSubscribeJS("onLivePlayerEvent", localJSONObject1.toString(), this.webviewId);
      paramBundle = new StringBuilder();
      paramBundle.append("operate start evaluateSubcribeJS onLivePlayerEvent = ");
      paramBundle.append(localJSONObject1.toString());
      QMLog.e("MiniAppLivePlayer", paramBundle.toString());
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  /* Error */
  private static void saveJpeg(android.graphics.Bitmap paramBitmap, java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 421	java/io/BufferedOutputStream
    //   5: dup
    //   6: new 423	java/io/FileOutputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 426	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   14: invokespecial 429	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   17: astore_1
    //   18: aload_0
    //   19: getstatic 435	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   22: bipush 100
    //   24: bipush 100
    //   26: invokestatic 441	java/lang/Math:min	(II)I
    //   29: aload_1
    //   30: invokevirtual 447	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   33: pop
    //   34: aload_1
    //   35: invokevirtual 450	java/io/BufferedOutputStream:flush	()V
    //   38: aload_1
    //   39: invokevirtual 453	java/io/BufferedOutputStream:close	()V
    //   42: return
    //   43: astore_0
    //   44: goto +6 -> 50
    //   47: astore_0
    //   48: aload_2
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +7 -> 58
    //   54: aload_1
    //   55: invokevirtual 453	java/io/BufferedOutputStream:close	()V
    //   58: aload_0
    //   59: athrow
    //   60: astore_0
    //   61: return
    //   62: astore_1
    //   63: goto -5 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	paramBitmap	android.graphics.Bitmap
    //   0	66	1	paramFile	java.io.File
    //   1	48	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	38	43	finally
    //   2	18	47	finally
    //   38	42	60	java/lang/Exception
    //   54	58	62	java/lang/Exception
  }
  
  private void setRequestedOrientation(Activity paramActivity)
  {
    int i = this.direction;
    if ((i != -90) && (i != 270))
    {
      if (i == 0)
      {
        paramActivity.setRequestedOrientation(1);
        return;
      }
      if ((i != 180) && (i != -180))
      {
        paramActivity.setRequestedOrientation(0);
        return;
      }
      paramActivity.setRequestedOrientation(9);
      return;
    }
    paramActivity.setRequestedOrientation(8);
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
  
  public void doSmallScreen(Activity paramActivity, AppBrandPageContainer paramAppBrandPageContainer)
  {
    paramAppBrandPageContainer = paramAppBrandPageContainer.getShowingPage();
    if (paramAppBrandPageContainer != null)
    {
      if (paramAppBrandPageContainer.getNavBar() != null) {
        paramAppBrandPageContainer.getNavBar().setVisibility(this.lastNavBarVisibility);
      }
      if (paramAppBrandPageContainer.getTabBar() != null) {
        paramAppBrandPageContainer.getTabBar().setVisibility(this.lastTabBarVisibility);
      }
    }
    paramActivity.getWindow().clearFlags(1024);
    paramActivity.setRequestedOrientation(1);
    if (Build.VERSION.SDK_INT >= 16) {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
    }
    if (paramAppBrandPageContainer != null) {
      try
      {
        int i = paramAppBrandPageContainer.getNavBar().getStatusNavigationBarTextStyle();
        if (i == -1) {
          ImmersiveUtils.setStatusTextColor(false, paramActivity.getWindow());
        } else if (i == -16777216) {
          ImmersiveUtils.setStatusTextColor(true, paramActivity.getWindow());
        }
      }
      catch (Exception paramActivity)
      {
        QMLog.e("MiniAppLivePlayer", "smallScreen: ", paramActivity);
      }
    }
    this.lastSmallScreenTime = System.currentTimeMillis();
    this.isBusyInChangeScreen = true;
    this.handler.postDelayed(new MiniAppLivePlayer.6(this), 200L);
  }
  
  public boolean enterBackground()
  {
    TXJSAdapterError localTXJSAdapterError = this.livePlayerJsAdapter.enterBackground(2);
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterBackground: ");
      localStringBuilder.append(localTXJSAdapterError);
      QMLog.d("MiniAppLivePlayer", localStringBuilder.toString());
    }
    return localTXJSAdapterError.errorCode == 0;
  }
  
  public boolean enterForeground()
  {
    TXJSAdapterError localTXJSAdapterError = this.livePlayerJsAdapter.enterForeground();
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterForeground: ");
      localStringBuilder.append(localTXJSAdapterError);
      QMLog.d("MiniAppLivePlayer", localStringBuilder.toString());
    }
    return localTXJSAdapterError.errorCode == 0;
  }
  
  public void fullScreen()
  {
    this.handler.post(new MiniAppLivePlayer.4(this));
  }
  
  public void initLivePlayerSettings(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initLivePlayerSettings isFullScreen: ");
      localStringBuilder.append(this.isFullScreen);
      QMLog.d("MiniAppLivePlayer", localStringBuilder.toString());
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
    TXLivePlayerJSAdapter localTXLivePlayerJSAdapter = this.livePlayerJsAdapter;
    return (localTXLivePlayerJSAdapter != null) && (localTXLivePlayerJSAdapter.isPlaying());
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
    TXLivePlayerJSAdapter localTXLivePlayerJSAdapter = this.livePlayerJsAdapter;
    if (localTXLivePlayerJSAdapter != null) {
      localTXLivePlayerJSAdapter.uninitLivePlayer();
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
    TXLivePlayerJSAdapter localTXLivePlayerJSAdapter = this.livePlayerJsAdapter;
    if (localTXLivePlayerJSAdapter != null) {
      localTXLivePlayerJSAdapter.operateLivePlayer("stop", null);
    }
    cancelAvoidLockScreen();
  }
  
  public void takePhoto(String paramString, boolean paramBoolean, RequestEvent paramRequestEvent)
  {
    if (this.livePlayerJsAdapter == null) {
      return;
    }
    QMLog.e("MiniAppLivePlayer", "takePhoto invoke");
    this.livePlayerJsAdapter.setSnapshotListener(new MiniAppLivePlayer.7(this, paramString, paramRequestEvent));
    this.livePlayerJsAdapter.takePhoto(paramBoolean);
  }
  
  public void updateLivePlayerSetting(JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLivePlayerSetting isFullScreen: ");
      ((StringBuilder)localObject).append(this.isFullScreen);
      QMLog.d("MiniAppLivePlayer", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.livePlayerJsAdapter;
    if (localObject == null) {
      return;
    }
    ((TXLivePlayerJSAdapter)localObject).updateLivePlayer(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer
 * JD-Core Version:    0.7.0.1
 */