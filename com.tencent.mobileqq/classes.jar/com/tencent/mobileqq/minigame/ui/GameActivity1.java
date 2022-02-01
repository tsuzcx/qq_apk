package com.tencent.mobileqq.minigame.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.GdtManager.Params;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.smallscreen.IServiceSyncListener;
import com.tencent.mobileqq.mini.appbrand.ui.MiniBaseActivity;
import com.tencent.mobileqq.mini.ui.MiniAIOEntryView;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin.AddColorSignListener;
import com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import org.json.JSONObject;

public class GameActivity1
  extends MiniBaseActivity
{
  private String colorNoteQueryPath;
  private ColorNotePlugin.AddColorSignListener mAddColorSingListener;
  protected IColorNoteController mColorNoteController;
  private IServiceSyncListener mColorNoteServiceListenr;
  private RelativeLayout mRoot;
  private IUIProxy mUIProxy;
  private MiniAIOEntryView miniAIOEntryView;
  private long onCreateTime;
  
  private void initUIProxy(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QMLog.e("qqBaseActivity", "Failed to initUIProxy, intent is null");
      return;
    }
    paramIntent = (MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO");
    if (paramIntent != null) {
      ThreadManagerV2.excute(new GameActivity1.5(this), 16, null, true);
    }
    this.mUIProxy = AppLoaderFactory.g().getMiniAppEnv().getUIProxy(paramIntent);
  }
  
  /* Error */
  private static byte[] packMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 102	com/tencent/qqmini/proxyimpl/MiniSdkUtil:a	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   4: astore_2
    //   5: invokestatic 108	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: iconst_0
    //   13: invokevirtual 112	android/os/Parcel:setDataPosition	(I)V
    //   16: aload_1
    //   17: astore_0
    //   18: aload_1
    //   19: aload_2
    //   20: getfield 118	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   23: iconst_0
    //   24: invokevirtual 122	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   27: aload_1
    //   28: astore_0
    //   29: aload_1
    //   30: invokevirtual 126	android/os/Parcel:marshall	()[B
    //   33: astore_2
    //   34: aload_1
    //   35: ifnull +7 -> 42
    //   38: aload_1
    //   39: invokevirtual 129	android/os/Parcel:recycle	()V
    //   42: aload_2
    //   43: areturn
    //   44: astore_1
    //   45: goto +68 -> 113
    //   48: astore_2
    //   49: goto +12 -> 61
    //   52: astore_1
    //   53: aconst_null
    //   54: astore_0
    //   55: goto +58 -> 113
    //   58: astore_2
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: new 131	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   70: astore_3
    //   71: aload_1
    //   72: astore_0
    //   73: aload_3
    //   74: ldc 134
    //   76: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_1
    //   81: astore_0
    //   82: aload_3
    //   83: aload_2
    //   84: invokestatic 144	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   87: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: astore_0
    //   93: ldc 45
    //   95: iconst_1
    //   96: aload_3
    //   97: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_1
    //   104: ifnull +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 129	android/os/Parcel:recycle	()V
    //   111: aconst_null
    //   112: areturn
    //   113: aload_0
    //   114: ifnull +7 -> 121
    //   117: aload_0
    //   118: invokevirtual 129	android/os/Parcel:recycle	()V
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramMiniAppInfo	MiniAppInfo
    //   8	31	1	localParcel	android.os.Parcel
    //   44	1	1	localObject1	Object
    //   52	1	1	localObject2	Object
    //   60	62	1	localObject3	Object
    //   4	39	2	localObject4	Object
    //   48	1	2	localThrowable1	Throwable
    //   58	26	2	localThrowable2	Throwable
    //   70	27	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	16	44	finally
    //   18	27	44	finally
    //   29	34	44	finally
    //   63	71	44	finally
    //   73	80	44	finally
    //   82	91	44	finally
    //   93	103	44	finally
    //   11	16	48	java/lang/Throwable
    //   18	27	48	java/lang/Throwable
    //   29	34	48	java/lang/Throwable
    //   5	9	52	finally
    //   5	9	58	java/lang/Throwable
  }
  
  public static void setActivityFullScreen(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null) {
        paramActivity.getDecorView().setSystemUiVisibility(23075586);
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    IUIProxy localIUIProxy = this.mUIProxy;
    if (localIUIProxy != null) {
      localIUIProxy.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    IUIProxy localIUIProxy = this.mUIProxy;
    boolean bool;
    if (localIUIProxy != null) {
      bool = localIUIProxy.onBackPressed(this);
    } else {
      bool = false;
    }
    if ((!bool) && (!moveTaskToBack(false))) {
      finish();
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--onConfigurationChanged-- screenWidthDp=");
    localStringBuilder.append(paramConfiguration.screenWidthDp);
    localStringBuilder.append(", screenHeightDp=");
    localStringBuilder.append(paramConfiguration.screenHeightDp);
    QLog.d("qqBaseActivity", 1, localStringBuilder.toString());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.onCreateTime = System.currentTimeMillis();
    MiniSDK.init(getApplicationContext());
    try
    {
      super.getIntent().putExtra("fling_action_key", 0);
    }
    catch (Throwable localThrowable1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[MiniEng]禁用右滑关闭失败:");
      ((StringBuilder)localObject).append(localThrowable1.getMessage());
      QLog.e("qqBaseActivity", 1, ((StringBuilder)localObject).toString());
    }
    this.mNeedStatusTrans = false;
    try
    {
      DisplayUtil.setActivityTransparent(this);
    }
    catch (Throwable localThrowable2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setActivityTransparent fail:");
      ((StringBuilder)localObject).append(localThrowable2.getMessage());
      QLog.e("qqBaseActivity", 1, ((StringBuilder)localObject).toString());
    }
    boolean bool = super.doOnCreate(paramBundle);
    Object localObject = new RelativeLayout(this);
    this.mRoot = ((RelativeLayout)localObject);
    setContentView((View)localObject);
    FrameLayout localFrameLayout = new FrameLayout(this);
    ((RelativeLayout)localObject).addView(localFrameLayout, new RelativeLayout.LayoutParams(-1, -1));
    MiniSDKClientQIPCModule.a();
    initUIProxy(getIntent());
    localObject = this.mUIProxy;
    if (localObject == null)
    {
      QMLog.e("qqBaseActivity", "Failed to start GameActivity, UIProxy is null!");
      finish();
      return false;
    }
    ((IUIProxy)localObject).onAttachActivity(this, paramBundle, localFrameLayout);
    this.mUIProxy.onIntentUpdate(getIntent());
    paramBundle = (MiniAppInfo)getIntent().getParcelableExtra("KEY_APPINFO");
    this.mColorNoteController = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.mColorNoteController.init(this, false, true);
    this.mColorNoteController.attachToActivity(this);
    this.mColorNoteController.setServiceInfo(new GameActivity1.1(this, paramBundle));
    this.mColorNoteController.setOnColorNoteAnimFinishListener(new GameActivity1.2(this));
    this.mColorNoteController.setOnColorNoteCurdListener(new GameActivity1.3(this, paramBundle));
    this.mColorNoteServiceListenr = new GameActivity1.4(this);
    this.mColorNoteController.setServiceSyncListener(this.mColorNoteServiceListenr);
    GdtManager.a().a(this, new GdtManager.Params());
    getSharedPreferences("sdk_conf", 4).edit().putInt("usersdk", 1).apply();
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.mColorNoteController;
    if (localObject != null) {
      ((IColorNoteController)localObject).onDestroy();
    }
    localObject = this.mUIProxy;
    if (localObject != null) {
      ((IUIProxy)localObject).onDetachActivity(this);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MiniEng]doOnDestroy ");
    ((StringBuilder)localObject).append(this);
    QLog.i("qqBaseActivity", 1, ((StringBuilder)localObject).toString());
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = this.mUIProxy;
      boolean bool;
      if (paramKeyEvent != null) {
        bool = paramKeyEvent.onBackPressed(this);
      } else {
        bool = false;
      }
      if (bool) {
        return true;
      }
      if (!moveTaskToBack(false)) {
        finish();
      }
      return false;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    QMLog.i("qqBaseActivity", "--doOnNewIntent");
    super.doOnNewIntent(paramIntent);
    initUIProxy(paramIntent);
    IUIProxy localIUIProxy = this.mUIProxy;
    if (localIUIProxy == null)
    {
      QMLog.e("qqBaseActivity", "Failed to start GameActivity, UIProxy is null!");
      finish();
      return;
    }
    localIUIProxy.onIntentUpdate(paramIntent);
  }
  
  protected void doOnPause()
  {
    QMLog.i("qqBaseActivity", "doOnPause ");
    super.doOnPause();
    Object localObject = this.mUIProxy;
    if (localObject != null) {
      ((IUIProxy)localObject).onMiniPause();
    }
    localObject = this.mColorNoteController;
    if (localObject != null) {
      ((IColorNoteController)localObject).onPause();
    }
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, true);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Object localObject = this.mUIProxy;
    if (localObject != null) {
      ((IUIProxy)localObject).onMiniResume();
    }
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(this);
    localObject = this.mColorNoteController;
    if (localObject != null) {
      ((IColorNoteController)localObject).onResume();
    }
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    QMLog.i("qqBaseActivity", "doOnStart game");
    IUIProxy localIUIProxy = this.mUIProxy;
    if (localIUIProxy != null) {
      localIUIProxy.onMiniStart();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    ThreadManagerV2.excute(new GameActivity1.6(this), 16, null, true);
    IUIProxy localIUIProxy = this.mUIProxy;
    if (localIUIProxy != null) {
      localIUIProxy.onMiniStop();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    setActivityFullScreen(this);
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  protected void doRefreshMiniBadge(Bundle paramBundle)
  {
    super.doRefreshMiniBadge(paramBundle);
    if (this.mUIProxy != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_appid", paramBundle.getString("miniAppID"));
      localBundle.putInt("KEY_BADGE_COUNT", paramBundle.getInt("param_proc_badge_count"));
      this.mUIProxy.onRefreshMiniBadge(this, localBundle);
    }
  }
  
  public IColorNoteController getColorNoteController()
  {
    return this.mColorNoteController;
  }
  
  public long getStartTime()
  {
    return this.onCreateTime;
  }
  
  public void hideMiniAIOEntrance()
  {
    MiniAIOEntryView localMiniAIOEntryView = this.miniAIOEntryView;
    if (localMiniAIOEntryView != null)
    {
      localMiniAIOEntryView.setVisibility(8);
      this.miniAIOEntryView.onDestroy();
      this.miniAIOEntryView = null;
    }
  }
  
  public void onProcessForeGround(Bundle paramBundle)
  {
    QMLog.i("qqBaseActivity", "onProcessForeGround");
    super.onProcessForeGround(paramBundle);
  }
  
  public void onRefreshMiniBadge(Bundle paramBundle)
  {
    QMLog.i("qqBaseActivity", "onRefreshMiniBadge");
    super.onRefreshMiniBadge(paramBundle);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    IUIProxy localIUIProxy = this.mUIProxy;
    if (localIUIProxy != null) {
      localIUIProxy.onRequestPermissionsResult(this, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void setColorNoteQueryPath(String paramString)
  {
    this.colorNoteQueryPath = paramString;
  }
  
  public void setColorSignAddListener(ColorNotePlugin.AddColorSignListener paramAddColorSignListener)
  {
    this.mAddColorSingListener = paramAddColorSignListener;
  }
  
  public boolean showMiniAIOEntrance(JSONObject paramJSONObject)
  {
    int j = -10;
    int i;
    if (paramJSONObject != null)
    {
      float f = 0.0F;
      if (Build.VERSION.SDK_INT >= 17)
      {
        localObject = new DisplayMetrics();
        ((WindowManager)getSystemService("window")).getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject);
        f = ((DisplayMetrics)localObject).density;
      }
      j = (int)(paramJSONObject.optInt("x", -10) * f + 0.5F);
      i = (int)(f * paramJSONObject.optInt("y", -10) + 0.5F);
      paramJSONObject = paramJSONObject.optString("style");
    }
    else
    {
      paramJSONObject = "";
      i = -10;
    }
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = j;
    ((RelativeLayout.LayoutParams)localObject).topMargin = i;
    if ((j >= 0) && (i >= 0))
    {
      MiniAIOEntryView localMiniAIOEntryView = this.miniAIOEntryView;
      if (localMiniAIOEntryView == null)
      {
        this.miniAIOEntryView = new MiniAIOEntryView(this, paramJSONObject);
        this.mRoot.addView(this.miniAIOEntryView, (ViewGroup.LayoutParams)localObject);
      }
      else
      {
        localMiniAIOEntryView.setMiniAIOStyle(paramJSONObject);
        this.miniAIOEntryView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.mRoot.requestLayout();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity1
 * JD-Core Version:    0.7.0.1
 */