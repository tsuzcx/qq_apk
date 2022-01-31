package com.tencent.mobileqq.minigame.ui;

import amgn;
import amkf;
import amkg;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bcuc;
import behj;
import beqb;
import beqv;
import betc;
import bfgl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class GameActivity1
  extends BaseActivity
{
  protected amgn mColorNoteController;
  private amkg mColorNoteServiceListenr;
  private beqv mUIProxy;
  
  private void initUIProxy(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent = (MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO");
    if (paramIntent != null) {
      ThreadManagerV2.excute(new GameActivity1.5(this), 16, null, true);
    }
    this.mUIProxy = beqb.a().a(paramIntent);
  }
  
  /* Error */
  private static byte[] packMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 72	com/tencent/qqmini/proxyimpl/MiniSdkUtil:convertSDK2QQConfig	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   6: astore_2
    //   7: invokestatic 78	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: iconst_0
    //   15: invokevirtual 82	android/os/Parcel:setDataPosition	(I)V
    //   18: aload_0
    //   19: astore_1
    //   20: aload_0
    //   21: aload_2
    //   22: getfield 88	com/tencent/mobileqq/mini/apkg/MiniAppConfig:config	Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;
    //   25: iconst_0
    //   26: invokevirtual 92	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   29: aload_0
    //   30: astore_1
    //   31: aload_0
    //   32: invokevirtual 96	android/os/Parcel:marshall	()[B
    //   35: astore_2
    //   36: aload_2
    //   37: astore_1
    //   38: aload_0
    //   39: ifnull +9 -> 48
    //   42: aload_0
    //   43: invokevirtual 99	android/os/Parcel:recycle	()V
    //   46: aload_2
    //   47: astore_1
    //   48: aload_1
    //   49: areturn
    //   50: astore_2
    //   51: aconst_null
    //   52: astore_0
    //   53: aload_0
    //   54: astore_1
    //   55: ldc 101
    //   57: iconst_1
    //   58: new 103	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   65: ldc 106
    //   67: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_2
    //   71: invokestatic 116	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   74: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_3
    //   84: astore_1
    //   85: aload_0
    //   86: ifnull -38 -> 48
    //   89: aload_0
    //   90: invokevirtual 99	android/os/Parcel:recycle	()V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_1
    //   99: ifnull +7 -> 106
    //   102: aload_1
    //   103: invokevirtual 99	android/os/Parcel:recycle	()V
    //   106: aload_0
    //   107: athrow
    //   108: astore_0
    //   109: goto -11 -> 98
    //   112: astore_2
    //   113: goto -60 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramMiniAppInfo	MiniAppInfo
    //   12	91	1	localObject1	java.lang.Object
    //   6	41	2	localObject2	java.lang.Object
    //   50	21	2	localThrowable1	Throwable
    //   112	1	2	localThrowable2	Throwable
    //   1	83	3	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   7	11	50	java/lang/Throwable
    //   7	11	95	finally
    //   13	18	108	finally
    //   20	29	108	finally
    //   31	36	108	finally
    //   55	83	108	finally
    //   13	18	112	java/lang/Throwable
    //   20	29	112	java/lang/Throwable
    //   31	36	112	java/lang/Throwable
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mUIProxy.onActivityResult(this, paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (!this.mUIProxy.onBackPressed(this)) {
      super.doOnBackPressed();
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    QLog.d("qqBaseActivity", 1, "--onConfigurationChanged-- screenWidthDp=" + paramConfiguration.screenWidthDp + ", screenHeightDp=" + paramConfiguration.screenHeightDp);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    behj.a(getApplicationContext());
    try
    {
      super.getIntent().putExtra("fling_action_key", 0);
      this.mNeedStatusTrans = false;
      bfgl.b(this);
      boolean bool = super.doOnCreate(paramBundle);
      RelativeLayout localRelativeLayout = new RelativeLayout(this);
      setContentView(localRelativeLayout);
      FrameLayout localFrameLayout = new FrameLayout(this);
      localRelativeLayout.addView(localFrameLayout, new RelativeLayout.LayoutParams(-1, -1));
      initUIProxy(getIntent());
      this.mUIProxy.onCreate(this, paramBundle, localFrameLayout);
      MiniSDKClientQIPCModule.registerModule();
      paramBundle = (MiniAppInfo)getIntent().getParcelableExtra("KEY_APPINFO");
      this.mColorNoteController = new amgn(this, false, true);
      this.mColorNoteController.a(this);
      this.mColorNoteController.a(new GameActivity1.1(this, paramBundle));
      this.mColorNoteController.a(new GameActivity1.2(this));
      this.mColorNoteController.a(new GameActivity1.3(this));
      this.mColorNoteServiceListenr = new GameActivity1.4(this);
      this.mColorNoteController.a(this.mColorNoteServiceListenr);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("qqBaseActivity", 1, "[MiniEng]禁用右滑关闭失败:" + localThrowable.getMessage());
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.mColorNoteController != null) {
      this.mColorNoteController.c();
    }
    this.mUIProxy.onDestroy(this);
    MiniSDKClientQIPCModule.unRegisterModule();
    QLog.i("qqBaseActivity", 1, "[MiniEng]doOnDestroy " + this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.mUIProxy.onBackPressed(this)) {
        return true;
      }
      super.doOnBackPressed();
      return false;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    betc.b("qqBaseActivity", "--doOnNewIntent");
    super.doOnNewIntent(paramIntent);
    initUIProxy(paramIntent);
    this.mUIProxy.onNewIntent(this, paramIntent);
  }
  
  public void doOnPause()
  {
    betc.b("qqBaseActivity", "doOnPause ");
    super.doOnPause();
    this.mUIProxy.onPause(this);
    if (this.mColorNoteController != null) {
      this.mColorNoteController.b();
    }
    amkf.a(this, 2, true);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.mUIProxy.onResume(this);
    bcuc.a(this);
    if (this.mColorNoteController != null) {
      this.mColorNoteController.a();
    }
    amkf.a(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    betc.b("qqBaseActivity", "doOnStart game");
    this.mUIProxy.onStart(this);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    ThreadManagerV2.excute(new GameActivity1.6(this), 16, null, true);
    this.mUIProxy.onStop(this);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    setActivityFullScreen(this);
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public amgn getColorNoteController()
  {
    return this.mColorNoteController;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.mUIProxy.onRequestPermissionsResult(this, paramInt, paramArrayOfString, paramArrayOfInt);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity1
 * JD-Core Version:    0.7.0.1
 */