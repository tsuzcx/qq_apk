package com.tencent.mobileqq.hotpic;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Handler;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class PresenceInterfaceImpl
  implements HotVideoMongoliaRelativeLayout.PresenceInterface, VideoBaseItem.OnInnerStateChangeListener, VideoItemEventManager.onVideoItemEventListener
{
  public static final DiskStorageManager a;
  public static volatile boolean a;
  static boolean d = false;
  static boolean e = false;
  long jdField_a_of_type_Long = 0L;
  Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  HotVideoMongoliaRelativeLayout jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout;
  VideoBaseItem jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem;
  final Runnable jdField_a_of_type_JavaLangRunnable = new PresenceInterfaceImpl.1(this);
  WeakReference<HotPicPageView> jdField_a_of_type_JavaLangRefWeakReference;
  long jdField_b_of_type_Long = -1L;
  final Runnable jdField_b_of_type_JavaLangRunnable = new PresenceInterfaceImpl.2(this);
  boolean jdField_b_of_type_Boolean = false;
  boolean c = false;
  private boolean f = false;
  private volatile boolean g = true;
  private volatile boolean h = false;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ComTencentMobileqqHotpicDiskStorageManager = new DiskStorageManager(50);
  }
  
  public PresenceInterfaceImpl(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem = VideoBaseItem.a(paramContext, 1);
    this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(Dialog paramDialog)
  {
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog) {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    d = false;
    e = false;
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    d = paramBoolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return e;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  private void n()
  {
    TVK_SDKMgr.installPlugin(BaseApplicationImpl.getApplication(), new PresenceInterfaceImpl.9(this));
  }
  
  public void a()
  {
    g();
    e();
    this.c = true;
    this.h = false;
    this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
    VideoItemEventManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.getContext()).b(this);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setDownloadNetworkChange(2);
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if ((this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && (!a(localQQAppInterface)))
        {
          b();
          m();
        }
      }
    }
    while ((paramInt != 4) || (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null))
    {
      QQAppInterface localQQAppInterface;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setDownloadNetworkChange(1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      a(6, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a() != 6) {
      return;
    }
    a(5, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
  }
  
  public void a(int paramInt, View paramView)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (this.g) {
        this.g = false;
      }
      while (jdField_a_of_type_Boolean)
      {
        this.g = true;
        return;
        if ((!this.g) && (!this.h)) {
          return;
        }
      }
      HotVideoUtils.a();
      if (!HotVideoUtils.b())
      {
        jdField_a_of_type_Boolean = true;
        l();
        this.g = true;
        QLog.d("PresenceInterfaceImpl", 2, "start install isRunInstallTencentSDK");
        return;
      }
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
      for (paramInt = 1;; paramInt = 0)
      {
        localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if ((paramInt != 0) || (a((QQAppInterface)localObject))) {
          break;
        }
        DialogUtil.a(paramView.getContext(), 232, null, HardCodeUtil.a(2131708386), new PresenceInterfaceImpl.3(this, (QQAppInterface)localObject), new PresenceInterfaceImpl.4(this, (QQAppInterface)localObject)).show();
        return;
      }
      new PresenceInterfaceImpl.5(this).run();
      QLog.d("PresenceInterfaceImpl", 2, "onHandleUseOperations 0");
      return;
    case 1: 
      if (!this.f)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(null);
        label245:
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(3);
        d();
        return;
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject = (HotPicPageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramView == null) {
          break;
        }
      }
      break;
    }
    for (boolean bool = HotPicPageView.jdField_a_of_type_Boolean;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.jdField_a_of_type_Long, bool);
      this.f = false;
      break label245;
      if (!this.h) {
        break;
      }
      g();
      this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(4);
      paramView = new StringBuilder();
      paramView.append(HotVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.jdField_a_of_type_Long));
      paramView.append(" / ");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.b);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.a(paramView.toString());
      return;
      bool = this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
      if (bool)
      {
        paramView = "0X8007ED7";
        label412:
        if (bool)
        {
          if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
            this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
          }
          if (this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3) == 0) {
            break;
          }
        }
        if (bool) {
          break label563;
        }
      }
      label563:
      for (bool = true;; bool = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.a(bool);
        ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
        QLog.d("PresenceInterfaceImpl", 2, "you have press mute button here, Current MuteStatus is" + bool);
        if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
          break;
        }
        paramView = (HotPicPageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramView == null) {
          break;
        }
        paramView.setCommonMuteStatus(bool);
        return;
        paramView = "0X8007ED8";
        break label412;
      }
      if ((!this.h) || ((!this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.b()) && (!this.f))) {
        break;
      }
      paramView = new StringBuilder();
      long l = this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(4);
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.c == 4) {
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.b);
      }
      for (;;)
      {
        paramView.append(" / ");
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.b);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.a(paramView.toString());
        c();
        e();
        QLog.d("PresenceInterfaceImpl", 2, "current position is mVideoPlayControl.getCurrentPosition()" + this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a());
        return;
        paramView.append(HotVideoUtils.a(l));
      }
      g();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(3);
      d();
      return;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setProgress(this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.b());
      f();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(6);
      c();
      e();
      return;
      if ((!this.h) || (!this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.b())) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(5);
      c();
      e();
      return;
      if (!this.h) {
        break;
      }
      g();
      this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(5);
      return;
      if (!this.f)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(null);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(3);
        d();
        return;
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject = (HotPicPageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramView == null) {}
      }
      for (bool = HotPicPageView.jdField_a_of_type_Boolean;; bool = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.jdField_a_of_type_Long, bool);
        this.f = false;
        break;
      }
    }
  }
  
  public void a(int paramInt1, TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt2, int paramInt3, int paramInt4, String paramString, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(-11);
    new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a(HotVideoMongoliaRelativeLayout.jdField_a_of_type_JavaLangString, 100, 0, 1);
    if (QLog.isColorLevel()) {
      QLog.d("PresenceInterfaceImpl", 2, "onInnerError i:" + paramInt2 + "   i1:" + paramInt3 + "  i2:" + paramInt4 + "   s:" + paramString);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout = ((HotVideoMongoliaRelativeLayout)paramView);
    VideoItemEventManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.getContext()).a(this);
  }
  
  public void a(HotPicPageView paramHotPicPageView)
  {
    if (paramHotPicPageView == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHotPicPageView);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PresenceInterfaceImpl.10(this, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(paramBoolean);
  }
  
  boolean a()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.b();
    if (QLog.isColorLevel()) {
      QLog.d("PresenceInterfaceImpl", 2, "initDuration: duration=" + l);
    }
    this.jdField_b_of_type_Long = ((int)l);
    return l > 0L;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a() == 2) {
      a(4, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a() != 6) {
      return;
    }
    a(2, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      b();
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem != null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.b());
  }
  
  public void c()
  {
    if ((this.jdField_b_of_type_Long <= 0L) && (!a())) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem == null);
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
    } while (this.jdField_a_of_type_Long == 0L);
    int i = (int)(this.jdField_a_of_type_Long * 10000L / this.jdField_b_of_type_Long + 0.5D);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.a(i);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      b();
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
  }
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      File localFile = new File(HotVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.d));
      jdField_a_of_type_ComTencentMobileqqHotpicDiskStorageManager.a(localFile);
    }
    this.f = true;
    a(4, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.e();
    QLog.d("PresenceInterfaceImpl", 2, "onPlayComplete ok here localPlay value is " + paramBoolean);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  void f()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
  }
  
  public void g()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public void h()
  {
    b();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    }
    int i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
    Object localObject;
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem != null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout;
      if (i <= 0)
      {
        bool = true;
        ((HotVideoMongoliaRelativeLayout)localObject).a(bool);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        break label79;
      }
    }
    label79:
    do
    {
      return;
      bool = false;
      break;
      localObject = (HotPicPageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject == null);
    ((HotPicPageView)localObject).a(i);
  }
  
  public void j()
  {
    this.h = true;
    ThreadManager.getUIHandler().post(new PresenceInterfaceImpl.6(this));
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a() == 3) {
      a(1, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
    }
  }
  
  public void l()
  {
    int i = 1;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
    while (i != 0)
    {
      n();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697732), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299166));
      return;
      i = 0;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697729), new PresenceInterfaceImpl.7(this), new PresenceInterfaceImpl.8(this)).show();
  }
  
  void m()
  {
    a(DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getString(2131719378), new PresenceInterfaceImpl.11(this), new PresenceInterfaceImpl.12(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */