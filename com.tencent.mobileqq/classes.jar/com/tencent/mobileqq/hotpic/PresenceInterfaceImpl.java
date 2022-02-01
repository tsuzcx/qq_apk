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
  public static volatile boolean a = false;
  public static final DiskStorageManager b = new DiskStorageManager(50);
  static boolean n = false;
  static boolean o = false;
  HotVideoMongoliaRelativeLayout c;
  VideoBaseItem d;
  Handler e = new Handler();
  Context f;
  WeakReference<HotPicPageView> g;
  long h = 0L;
  long i = -1L;
  final Runnable j = new PresenceInterfaceImpl.1(this);
  final Runnable k = new PresenceInterfaceImpl.2(this);
  boolean l = false;
  boolean m = false;
  private boolean p = false;
  private volatile boolean q = true;
  private volatile boolean r = false;
  private AudioManager s;
  
  public PresenceInterfaceImpl(Context paramContext)
  {
    this.d = VideoBaseItem.a(paramContext, 1);
    this.d.a(this);
    this.f = paramContext;
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
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    n = paramBoolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return o;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    n = false;
    o = false;
    a = false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    o = paramBoolean;
  }
  
  private void p()
  {
    TVK_SDKMgr.installPlugin(BaseApplicationImpl.getApplication(), new PresenceInterfaceImpl.9(this));
  }
  
  public void a()
  {
    h();
    f();
    this.m = true;
    this.r = false;
    this.d.a();
    VideoItemEventManager.a(this.c.getContext()).b(this);
    this.e.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.d.e != null)
      {
        this.d.e.setDownloadNetworkChange(2);
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if ((this.d.e.isPlaying()) && (!a(localQQAppInterface)))
        {
          b();
          o();
        }
      }
    }
    else if ((paramInt == 4) && (this.d.e != null)) {
      this.d.e.setDownloadNetworkChange(1);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      a(6, this.c);
      return;
    }
    if (this.d.c() == 6) {
      a(5, this.c);
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    int i1 = 1;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return;
    case 9: 
      if (!this.p)
      {
        this.d.a(null);
      }
      else
      {
        localObject = this.g;
        if (localObject != null)
        {
          localObject = (HotPicPageView)((WeakReference)localObject).get();
          if (paramView != null)
          {
            bool = HotPicPageView.o;
            break label111;
          }
        }
        bool = false;
        this.d.a(this.c.f.d, bool);
        this.p = false;
      }
      this.c.b(3);
      e();
      return;
    case 8: 
      if (!this.r) {
        return;
      }
      if (!this.d.h()) {
        return;
      }
      this.d.g();
      this.c.b(5);
      d();
      f();
      return;
    case 7: 
      if (!this.r) {
        return;
      }
      h();
      this.d.g();
      this.c.b(5);
      return;
    case 6: 
      this.c.h.setProgress(this.d.f());
      g();
      this.c.b(6);
      d();
      f();
      return;
    case 5: 
      h();
      this.c.b(3);
      e();
      return;
    case 4: 
      if (!this.r) {
        return;
      }
      if ((!this.d.h()) && (!this.p)) {
        return;
      }
      paramView = new StringBuilder();
      long l1 = this.d.d();
      this.d.g();
      this.c.b(4);
      if (this.d.g == 4) {
        paramView.append(this.c.f.b);
      } else {
        paramView.append(HotVideoUtils.a(l1));
      }
      paramView.append(" / ");
      paramView.append(this.c.f.b);
      this.c.a(paramView.toString());
      d();
      f();
      paramView = new StringBuilder();
      paramView.append("current position is mVideoPlayControl.getCurrentPosition()");
      paramView.append(this.d.d());
      QLog.d("PresenceInterfaceImpl", 2, paramView.toString());
      return;
    case 3: 
      bool = this.d.b();
      if (bool) {
        paramView = "0X8007ED7";
      } else {
        paramView = "0X8007ED8";
      }
      if (bool)
      {
        if (this.s == null) {
          this.s = ((AudioManager)this.f.getSystemService("audio"));
        }
        if (this.s.getStreamVolume(3) == 0) {
          return;
        }
      }
      bool ^= true;
      this.c.a(bool);
      ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
      paramView = new StringBuilder();
      paramView.append("you have press mute button here, Current MuteStatus is");
      paramView.append(bool);
      QLog.d("PresenceInterfaceImpl", 2, paramView.toString());
      paramView = this.g;
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
      if (!this.r) {
        return;
      }
      h();
      this.d.g();
      this.c.b(4);
      paramView = new StringBuilder();
      paramView.append(HotVideoUtils.a(this.d.j));
      paramView.append(" / ");
      paramView.append(this.c.f.b);
      this.c.a(paramView.toString());
      return;
    case 1: 
      label111:
      if (!this.p)
      {
        this.d.a(null);
      }
      else
      {
        localObject = this.g;
        if (localObject != null)
        {
          localObject = (HotPicPageView)((WeakReference)localObject).get();
          if (paramView != null)
          {
            bool = HotPicPageView.o;
            break label779;
          }
        }
        bool = false;
        this.d.a(this.c.f.d, bool);
        this.p = false;
      }
      label779:
      this.c.b(3);
      e();
      return;
    }
    if (this.q) {
      this.q = false;
    } else if ((!this.q) && (!this.r)) {
      return;
    }
    if (a)
    {
      this.q = true;
      return;
    }
    HotVideoUtils.a();
    if (!HotVideoUtils.b())
    {
      a = true;
      n();
      this.q = true;
      QLog.d("PresenceInterfaceImpl", 2, "start install isRunInstallTencentSDK");
      return;
    }
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      paramInt = i1;
    } else {
      paramInt = 0;
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((paramInt == 0) && (!a((QQAppInterface)localObject)))
    {
      DialogUtil.a(paramView.getContext(), 232, null, HardCodeUtil.a(2131906183), new PresenceInterfaceImpl.3(this, (QQAppInterface)localObject), new PresenceInterfaceImpl.4(this, (QQAppInterface)localObject)).show();
      return;
    }
    new PresenceInterfaceImpl.5(this).run();
    QLog.d("PresenceInterfaceImpl", 2, "onHandleUseOperations 0");
  }
  
  public void a(int paramInt1, TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt2, int paramInt3, int paramInt4, String paramString, Object paramObject)
  {
    this.c.b(-11);
    new QQToastNotifier(this.f).notifyUser(HotVideoMongoliaRelativeLayout.a, 100, 0, 1);
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
    this.c = ((HotVideoMongoliaRelativeLayout)paramView);
    VideoItemEventManager.a(this.c.getContext()).a(this);
  }
  
  public void a(HotPicPageView paramHotPicPageView)
  {
    if (paramHotPicPageView == null) {
      return;
    }
    this.g = new WeakReference(paramHotPicPageView);
  }
  
  public void a(String paramString)
  {
    this.e.post(new PresenceInterfaceImpl.10(this, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
  }
  
  public void b()
  {
    if (this.d.c() == 2)
    {
      a(4, this.c);
      return;
    }
    if (this.d.c() == 6) {
      a(2, this.c);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      b();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      b();
    }
  }
  
  boolean c()
  {
    long l1 = this.d.e();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initDuration: duration=");
      localStringBuilder.append(l1);
      QLog.d("PresenceInterfaceImpl", 2, localStringBuilder.toString());
    }
    this.i = ((int)l1);
    return l1 > 0L;
  }
  
  public void d()
  {
    if ((this.i <= 0L) && (!c())) {
      return;
    }
    VideoBaseItem localVideoBaseItem = this.d;
    if (localVideoBaseItem == null) {
      return;
    }
    this.h = localVideoBaseItem.d();
    long l1 = this.h;
    if (l1 != 0L)
    {
      double d1 = l1 * 10000L / this.i;
      Double.isNaN(d1);
      int i1 = (int)(d1 + 0.5D);
      this.c.a(i1);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localObject = new File(HotVideoUtils.a(this.c.f.g));
      b.a((File)localObject);
    }
    this.p = true;
    a(4, this.c);
    this.c.e();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPlayComplete ok here localPlay value is ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("PresenceInterfaceImpl", 2, ((StringBuilder)localObject).toString());
  }
  
  public void e()
  {
    this.e.postDelayed(this.j, 100L);
  }
  
  public void f()
  {
    this.e.removeCallbacks(this.j);
  }
  
  void g()
  {
    this.l = true;
    this.e.postDelayed(this.k, 100L);
  }
  
  public void h()
  {
    this.l = false;
    this.e.removeCallbacks(this.k);
  }
  
  public boolean i()
  {
    VideoBaseItem localVideoBaseItem = this.d;
    return (localVideoBaseItem != null) && (localVideoBaseItem.h());
  }
  
  public void j()
  {
    b();
  }
  
  public void k()
  {
    if (this.s == null) {
      this.s = ((AudioManager)this.f.getSystemService("audio"));
    }
    int i1 = this.s.getStreamVolume(3);
    Object localObject = this.d;
    if ((localObject != null) && (((VideoBaseItem)localObject).e != null))
    {
      localObject = this.c;
      boolean bool;
      if (i1 <= 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((HotVideoMongoliaRelativeLayout)localObject).a(bool);
    }
    localObject = this.g;
    if (localObject == null) {
      return;
    }
    localObject = (HotPicPageView)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((HotPicPageView)localObject).a(i1);
  }
  
  public void l()
  {
    this.r = true;
    ThreadManager.getUIHandler().post(new PresenceInterfaceImpl.6(this));
  }
  
  public void m()
  {
    if (this.d.c() == 3) {
      a(1, this.c);
    }
  }
  
  public void n()
  {
    int i2 = NetworkUtil.getNetworkType(BaseApplication.getContext());
    int i1 = 1;
    if (i2 != 1) {
      i1 = 0;
    }
    if (i1 != 0)
    {
      p();
      localContext = this.f;
      QQToast.makeText(localContext, localContext.getResources().getString(2131895511), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299920));
      return;
    }
    Context localContext = this.f;
    DialogUtil.a(localContext, 232, null, localContext.getResources().getString(2131895508), new PresenceInterfaceImpl.7(this), new PresenceInterfaceImpl.8(this)).show();
  }
  
  void o()
  {
    Context localContext = this.f;
    a(DialogUtil.a(localContext, 232, null, localContext.getString(2131916632), new PresenceInterfaceImpl.11(this), new PresenceInterfaceImpl.12(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */