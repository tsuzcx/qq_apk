package com.tencent.mobileqq.gallery.presenter;

import aejb;
import amlk;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import anga;
import aqmb;
import aqmi;
import aqmj;
import aqmo;
import aqnf;
import aqng;
import aqog;
import aqoi;
import aqon;
import avwo;
import avwr;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.widget.Gallery;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AIOGalleryBasePresenter
  extends aqng
  implements aqmb
{
  private Handler a;
  public aqnf a;
  public aqog a;
  public AIOGalleryBasePresenter.ImmersionTimerRunnable a;
  public ConcurrentHashMap<Integer, URLDrawable> a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public AIOGalleryBasePresenter()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      return this.jdField_a_of_type_Aqnf.a();
    }
    return -1;
  }
  
  public int a(long paramLong, int paramInt)
  {
    aejb localaejb = a();
    if (localaejb != null) {
      return localaejb.a(paramLong, paramInt);
    }
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj != null)) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj.a(paramLong, paramInt1, paramInt2, paramString);
    }
    return -1;
  }
  
  public long a()
  {
    return 0L;
  }
  
  public aejb a()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aejb;
    }
    return null;
  }
  
  public amlk a()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      return this.jdField_a_of_type_Aqnf.a();
    }
    return null;
  }
  
  public Intent a(long paramLong, int paramInt)
  {
    aejb localaejb = a();
    if (localaejb != null) {
      return localaejb.a(paramLong, paramInt);
    }
    return null;
  }
  
  public Intent a(long paramLong, int paramInt1, int paramInt2)
  {
    aejb localaejb = a();
    if (localaejb != null) {
      return localaejb.a(paramLong, paramInt1, paramInt2);
    }
    return null;
  }
  
  public ImageButton a()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.jdField_a_of_type_AndroidWidgetImageButton;
    }
    return null;
  }
  
  public RelativeLayout a()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.a();
    }
    return null;
  }
  
  public aqmi a()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj != null)) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj.a();
    }
    return null;
  }
  
  public aqmi a(int paramInt)
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.a(paramInt);
    }
    return null;
  }
  
  public aqmi a(long paramLong)
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj != null)) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj.a(paramLong);
    }
    return null;
  }
  
  public aqmi a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj != null)) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj.a(paramLong1, paramLong2);
    }
    return null;
  }
  
  public aqmo a()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      return this.jdField_a_of_type_Aqnf.a();
    }
    return null;
  }
  
  public avwo a()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      return this.jdField_a_of_type_Aqnf.a();
    }
    return null;
  }
  
  public avwr a()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      return this.jdField_a_of_type_Aqnf.a();
    }
    return null;
  }
  
  public Gallery a()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.jdField_a_of_type_ComTencentWidgetGallery;
    }
    return null;
  }
  
  public List<anga> a(long paramLong, List<DanmuItemBean> paramList)
  {
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.f();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramURLDrawable);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.b(paramInt, paramBoolean);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    aejb localaejb = a();
    if (localaejb != null) {
      localaejb.a(paramInt, paramBoolean, paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public void a(long paramLong)
  {
    aejb localaejb = a();
    if (localaejb != null) {
      localaejb.c(paramLong);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    aejb localaejb = a();
    if (localaejb != null) {
      localaejb.a(paramLong, paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj != null)) {
      this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3) {}
  
  public void a(long paramLong, int paramInt, Bundle paramBundle)
  {
    aejb localaejb = a();
    if (localaejb != null) {
      localaejb.a(paramLong, paramInt, paramBundle);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.a(paramLong1, paramLong2, paramString);
    }
  }
  
  public void a(aqmi paramaqmi)
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj != null)) {
      this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj.a(paramaqmi);
    }
  }
  
  public void a(aqnf paramaqnf)
  {
    this.jdField_a_of_type_Aqnf = paramaqnf;
  }
  
  public void a(aqng paramaqng)
  {
    if ((paramaqng instanceof aqnf)) {
      a((aqnf)paramaqng);
    }
  }
  
  public void a(aqon paramaqon)
  {
    super.a(paramaqon);
    if ((paramaqon instanceof aqog)) {
      this.jdField_a_of_type_Aqog = ((aqog)paramaqon);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    aejb localaejb = a();
    if (localaejb != null) {
      localaejb.a(paramString, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.b());
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      return this.jdField_a_of_type_Aqnf.b(paramInt);
    }
    return false;
  }
  
  public void aE_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryBasePresenter", 0, "onDanmakuDrawFinish");
    }
    if ((f()) && (!this.jdField_a_of_type_Boolean))
    {
      q();
      p();
    }
  }
  
  public void aF_()
  {
    this.b = b();
    this.c = c();
  }
  
  public void aG_()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.l();
    }
  }
  
  public void aH_()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.n();
    }
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj != null)) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj.a();
    }
    return 0;
  }
  
  public aqmi b()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj != null)) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj.b();
    }
    return null;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    aejb localaejb = a();
    if (localaejb != null) {
      localaejb.a(paramInt);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.a(paramInt, paramBoolean);
    }
  }
  
  public void b(long paramLong)
  {
    aejb localaejb = a();
    if (localaejb != null) {
      localaejb.d(paramLong);
    }
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    aejb localaejb = a();
    if (localaejb != null) {
      localaejb.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.a();
    }
    return false;
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj != null)) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj.b();
    }
    return 0;
  }
  
  public void c(int paramInt) {}
  
  public void c(long paramLong)
  {
    aejb localaejb = a();
    if (localaejb != null) {
      localaejb.e(paramLong);
    }
  }
  
  public void c(long paramLong, int paramInt1, int paramInt2)
  {
    aejb localaejb = a();
    if (localaejb != null) {
      localaejb.b(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.b(paramBoolean);
    }
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.b();
    }
    return false;
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.c(paramBoolean);
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj != null)) {
      return this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqmj.a();
    }
    return false;
  }
  
  public void e()
  {
    this.b = false;
    this.c = false;
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.b(paramBoolean);
    }
  }
  
  public boolean e()
  {
    aejb localaejb = a();
    if (localaejb != null) {
      return localaejb.asBinder().pingBinder();
    }
    return false;
  }
  
  @RequiresApi(api=11)
  public void f()
  {
    if (a() != null) {
      a().setAlpha(0.3F);
    }
    if (a() != null) {
      a().setAlpha(0.3F);
    }
  }
  
  public boolean f()
  {
    return false;
  }
  
  @RequiresApi(api=11)
  public void g()
  {
    if (a() != null) {
      a().setAlpha(1.0F);
    }
    if (a() != null) {
      a().setAlpha(1.0F);
    }
  }
  
  public boolean g()
  {
    return false;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.f();
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null))
    {
      this.jdField_a_of_type_Aqnf.r();
      this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.c();
    }
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi != null)) {
      this.jdField_a_of_type_Aqnf.jdField_a_of_type_Aqoi.g();
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.s();
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.t();
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.u();
    }
  }
  
  public void p()
  {
    if (!f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryBasePresenter", 0, "startImmersionTimer, immersion switch is not open");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryBasePresenter", 0, "startImmersionTimer");
    }
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter$ImmersionTimerRunnable = new AIOGalleryBasePresenter.ImmersionTimerRunnable(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter$ImmersionTimerRunnable, 5000L);
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryBasePresenter", 0, "removeImmersionTimer");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter$ImmersionTimerRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter$ImmersionTimerRunnable);
    }
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter$ImmersionTimerRunnable = null;
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.v();
    }
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.w();
    }
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_Aqnf != null) {
      this.jdField_a_of_type_Aqnf.c(g());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter
 * JD-Core Version:    0.7.0.1
 */