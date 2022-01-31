package com.tencent.mobileqq.hotpic;

import adhp;
import adhq;
import adhs;
import adht;
import adhu;
import adhv;
import adhx;
import adhz;
import adia;
import adib;
import adic;
import adid;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Handler;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
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
  static boolean d;
  static boolean e;
  final float jdField_a_of_type_Float = 1.777778F;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  public Handler a;
  public HotVideoMongoliaRelativeLayout a;
  public VideoBaseItem a;
  public final Runnable a;
  public WeakReference a;
  long b;
  public final Runnable b;
  public boolean b;
  public boolean c = false;
  private boolean f;
  private volatile boolean g = true;
  private volatile boolean h;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqHotpicDiskStorageManager = new DiskStorageManager(50);
  }
  
  public PresenceInterfaceImpl(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangRunnable = new adhp(this);
    this.jdField_b_of_type_JavaLangRunnable = new adhu(this);
    this.jdField_b_of_type_Boolean = false;
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
    TVK_SDKMgr.installPlugin(BaseApplicationImpl.getApplication(), new adid(this));
  }
  
  public void a()
  {
    d();
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
          d();
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
        DialogUtil.a(paramView.getContext(), 232, null, "非Wi-Fi下播放可能会消耗流量，是否确认播放？", new adhv(this, (QQAppInterface)localObject), new adhx(this, (QQAppInterface)localObject)).show();
        return;
      }
      new adhz(this).run();
      QLog.d("PresenceInterfaceImpl", 2, "onHandleUseOperations 0");
      return;
    case 1: 
      if (!this.f)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(null);
        label242:
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(3);
        f();
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
      break label242;
      if (!this.h) {
        break;
      }
      i();
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
        label409:
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
          break label560;
        }
      }
      label560:
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
        paramView.a(bool);
        return;
        paramView = "0X8007ED8";
        break label409;
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
        e();
        g();
        QLog.d("PresenceInterfaceImpl", 2, "current position is mVideoPlayControl.getCurrentPosition()" + this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a());
        return;
        paramView.append(HotVideoUtils.a(l));
      }
      i();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(3);
      f();
      return;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setProgress(this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.b());
      h();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(6);
      e();
      g();
      return;
      if ((!this.h) || (!this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.b())) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(5);
      e();
      g();
      return;
      if (!this.h) {
        break;
      }
      i();
      this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(5);
      return;
      if (!this.f)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a(null);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(3);
        f();
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
    new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext).a("网络错误，请稍后重试", 100, 0, 1);
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
    this.jdField_a_of_type_AndroidOsHandler.post(new adhq(this, paramString));
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
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d();
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem != null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.b());
  }
  
  public void c()
  {
    i();
    g();
    this.c = true;
    this.h = false;
    this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a();
    VideoItemEventManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.getContext()).b(this);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      d();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a() == 2) {
      a(4, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqHotpicVideoBaseItem.a() != 6) {
      return;
    }
    a(2, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
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
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  void h()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
  }
  
  public void i()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public void j()
  {
    this.h = true;
    ThreadManager.getUIHandler().post(new adia(this));
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430792), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131558448));
      return;
      i = 0;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430790), new adib(this), new adic(this)).show();
  }
  
  void m()
  {
    a(DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getString(2131437367), new adhs(this), new adht(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */