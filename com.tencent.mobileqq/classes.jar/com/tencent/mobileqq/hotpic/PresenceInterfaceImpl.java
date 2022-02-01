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
  public static volatile boolean a = false;
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
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setDownloadNetworkChange(2);
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if ((this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && (!a(localQQAppInterface)))
        {
          b();
          m();
        }
      }
    }
    else if ((paramInt == 4) && (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setDownloadNetworkChange(1);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      a(6, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a() == 6) {
      a(5, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    int i = 1;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return;
    case 9: 
      if (!this.f)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(null);
      }
      else
      {
        localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
        if (localObject != null)
        {
          localObject = (HotPicPageView)((WeakReference)localObject).get();
          if (paramView != null)
          {
            bool = HotPicPageView.jdField_a_of_type_Boolean;
            break label111;
          }
        }
        bool = false;
        this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.jdField_a_of_type_Long, bool);
        this.f = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(3);
      d();
      return;
    case 8: 
      if (!this.h) {
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.b()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(5);
      c();
      e();
      return;
    case 7: 
      if (!this.h) {
        return;
      }
      g();
      this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(5);
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setProgress(this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.b());
      f();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(6);
      c();
      e();
      return;
    case 5: 
      g();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(3);
      d();
      return;
    case 4: 
      if (!this.h) {
        return;
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.b()) && (!this.f)) {
        return;
      }
      paramView = new StringBuilder();
      long l = this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(4);
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.c == 4) {
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.b);
      } else {
        paramView.append(HotVideoUtils.a(l));
      }
      paramView.append(" / ");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.b);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.a(paramView.toString());
      c();
      e();
      paramView = new StringBuilder();
      paramView.append("current position is mVideoPlayControl.getCurrentPosition()");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a());
      QLog.d("PresenceInterfaceImpl", 2, paramView.toString());
      return;
    case 3: 
      bool = this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
      if (bool) {
        paramView = "0X8007ED7";
      } else {
        paramView = "0X8007ED8";
      }
      if (bool)
      {
        if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
          this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
        }
        if (this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3) == 0) {
          return;
        }
      }
      bool ^= true;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.a(bool);
      ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
      paramView = new StringBuilder();
      paramView.append("you have press mute button here, Current MuteStatus is");
      paramView.append(bool);
      QLog.d("PresenceInterfaceImpl", 2, paramView.toString());
      paramView = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (paramView == null) {
        return;
      }
      paramView = (HotPicPageView)paramView.get();
      if (paramView == null) {
        return;
      }
      paramView.setCommonMuteStatus(bool);
      return;
    case 2: 
      if (!this.h) {
        return;
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
    case 1: 
      label111:
      if (!this.f)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(null);
      }
      else
      {
        localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
        if (localObject != null)
        {
          localObject = (HotPicPageView)((WeakReference)localObject).get();
          if (paramView != null)
          {
            bool = HotPicPageView.jdField_a_of_type_Boolean;
            break label779;
          }
        }
        bool = false;
        this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.jdField_a_of_type_Long, bool);
        this.f = false;
      }
      label779:
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(3);
      d();
      return;
    }
    if (this.g) {
      this.g = false;
    } else if ((!this.g) && (!this.h)) {
      return;
    }
    if (jdField_a_of_type_Boolean)
    {
      this.g = true;
      return;
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
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      paramInt = i;
    } else {
      paramInt = 0;
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((paramInt == 0) && (!a((QQAppInterface)localObject)))
    {
      DialogUtil.a(paramView.getContext(), 232, null, HardCodeUtil.a(2131708395), new PresenceInterfaceImpl.3(this, (QQAppInterface)localObject), new PresenceInterfaceImpl.4(this, (QQAppInterface)localObject)).show();
      return;
    }
    new PresenceInterfaceImpl.5(this).run();
    QLog.d("PresenceInterfaceImpl", 2, "onHandleUseOperations 0");
  }
  
  public void a(int paramInt1, TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt2, int paramInt3, int paramInt4, String paramString, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(-11);
    new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a(HotVideoMongoliaRelativeLayout.jdField_a_of_type_JavaLangString, 100, 0, 1);
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramTVK_IMediaPlayer.append("onInnerError i:");
      paramTVK_IMediaPlayer.append(paramInt2);
      paramTVK_IMediaPlayer.append("   i1:");
      paramTVK_IMediaPlayer.append(paramInt3);
      paramTVK_IMediaPlayer.append("  i2:");
      paramTVK_IMediaPlayer.append(paramInt4);
      paramTVK_IMediaPlayer.append("   s:");
      paramTVK_IMediaPlayer.append(paramString);
      QLog.d("PresenceInterfaceImpl", 2, paramTVK_IMediaPlayer.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initDuration: duration=");
      localStringBuilder.append(l);
      QLog.d("PresenceInterfaceImpl", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Long = ((int)l);
    return l > 0L;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a() == 2)
    {
      a(4, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a() == 6) {
      a(2, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      b();
    }
  }
  
  public boolean b()
  {
    VideoBaseItem localVideoBaseItem = this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem;
    return (localVideoBaseItem != null) && (localVideoBaseItem.b());
  }
  
  public void c()
  {
    if ((this.jdField_b_of_type_Long <= 0L) && (!a())) {
      return;
    }
    VideoBaseItem localVideoBaseItem = this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem;
    if (localVideoBaseItem == null) {
      return;
    }
    this.jdField_a_of_type_Long = localVideoBaseItem.a();
    long l = this.jdField_a_of_type_Long;
    if (l != 0L)
    {
      double d1 = l * 10000L / this.jdField_b_of_type_Long;
      Double.isNaN(d1);
      int i = (int)(d1 + 0.5D);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.a(i);
    }
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
      localObject = new File(HotVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.d));
      jdField_a_of_type_ComTencentMobileqqHotpicDiskStorageManager.a((File)localObject);
    }
    this.f = true;
    a(4, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.e();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPlayComplete ok here localPlay value is ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("PresenceInterfaceImpl", 2, ((StringBuilder)localObject).toString());
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem;
    if ((localObject != null) && (((VideoBaseItem)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout;
      boolean bool;
      if (i <= 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((HotVideoMongoliaRelativeLayout)localObject).a(bool);
    }
    localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (HotPicPageView)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
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
    int j = NetworkUtil.getNetworkType(BaseApplication.getContext());
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    if (i != 0)
    {
      n();
      localContext = this.jdField_a_of_type_AndroidContentContext;
      QQToast.a(localContext, localContext.getResources().getString(2131697738), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299168));
      return;
    }
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    DialogUtil.a(localContext, 232, null, localContext.getResources().getString(2131697735), new PresenceInterfaceImpl.7(this), new PresenceInterfaceImpl.8(this)).show();
  }
  
  void m()
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    a(DialogUtil.a(localContext, 232, null, localContext.getString(2131719096), new PresenceInterfaceImpl.11(this), new PresenceInterfaceImpl.12(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */