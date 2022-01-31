package com.tencent.mobileqq.gallery.presenter;

import adye;
import alvv;
import ampo;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import apsk;
import apsr;
import apss;
import apsx;
import apte;
import aptf;
import apue;
import apug;
import apul;
import auwv;
import auwy;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.widget.Gallery;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AIOGalleryBasePresenter
  extends aptf
  implements apsk
{
  private Handler a;
  public apte a;
  public apue a;
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
    if (this.jdField_a_of_type_Apte != null) {
      return this.jdField_a_of_type_Apte.a();
    }
    return -1;
  }
  
  public int a(long paramLong, int paramInt)
  {
    adye localadye = a();
    if (localadye != null) {
      return localadye.a(paramLong, paramInt);
    }
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apss != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apss.a(paramLong, paramInt1, paramInt2, paramString);
    }
    return -1;
  }
  
  public long a()
  {
    return 0L;
  }
  
  public adye a()
  {
    if (this.jdField_a_of_type_Apte != null) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Adye;
    }
    return null;
  }
  
  public alvv a()
  {
    if (this.jdField_a_of_type_Apte != null) {
      return this.jdField_a_of_type_Apte.a();
    }
    return null;
  }
  
  public Intent a(long paramLong, int paramInt)
  {
    adye localadye = a();
    if (localadye != null) {
      return localadye.a(paramLong, paramInt);
    }
    return null;
  }
  
  public Intent a(long paramLong, int paramInt1, int paramInt2)
  {
    adye localadye = a();
    if (localadye != null) {
      return localadye.a(paramLong, paramInt1, paramInt2);
    }
    return null;
  }
  
  public ImageButton a()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.jdField_a_of_type_AndroidWidgetImageButton;
    }
    return null;
  }
  
  public RelativeLayout a()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.a();
    }
    return null;
  }
  
  public apsr a()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apss != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apss.a();
    }
    return null;
  }
  
  public apsr a(int paramInt)
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.a(paramInt);
    }
    return null;
  }
  
  public apsr a(long paramLong)
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apss != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apss.a(paramLong);
    }
    return null;
  }
  
  public apsr a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apss != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apss.a(paramLong1, paramLong2);
    }
    return null;
  }
  
  public apsx a()
  {
    if (this.jdField_a_of_type_Apte != null) {
      return this.jdField_a_of_type_Apte.a();
    }
    return null;
  }
  
  public auwv a()
  {
    if (this.jdField_a_of_type_Apte != null) {
      return this.jdField_a_of_type_Apte.a();
    }
    return null;
  }
  
  public auwy a()
  {
    if (this.jdField_a_of_type_Apte != null) {
      return this.jdField_a_of_type_Apte.a();
    }
    return null;
  }
  
  public Gallery a()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.jdField_a_of_type_ComTencentWidgetGallery;
    }
    return null;
  }
  
  public List<ampo> a(long paramLong, List<DanmuItemBean> paramList)
  {
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.f();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.a(paramInt1, paramInt2);
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
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.b(paramInt, paramBoolean);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    adye localadye = a();
    if (localadye != null) {
      localadye.a(paramInt, paramBoolean, paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public void a(long paramLong)
  {
    adye localadye = a();
    if (localadye != null) {
      localadye.c(paramLong);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    adye localadye = a();
    if (localadye != null) {
      localadye.a(paramLong, paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apss != null)) {
      this.jdField_a_of_type_Apte.jdField_a_of_type_Apss.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3) {}
  
  public void a(long paramLong, int paramInt, Bundle paramBundle)
  {
    adye localadye = a();
    if (localadye != null) {
      localadye.a(paramLong, paramInt, paramBundle);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.a(paramLong1, paramLong2, paramString);
    }
  }
  
  public void a(apsr paramapsr)
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apss != null)) {
      this.jdField_a_of_type_Apte.jdField_a_of_type_Apss.a(paramapsr);
    }
  }
  
  public void a(apte paramapte)
  {
    this.jdField_a_of_type_Apte = paramapte;
  }
  
  public void a(aptf paramaptf)
  {
    if ((paramaptf instanceof apte)) {
      a((apte)paramaptf);
    }
  }
  
  public void a(apul paramapul)
  {
    super.a(paramapul);
    if ((paramapul instanceof apue)) {
      this.jdField_a_of_type_Apue = ((apue)paramapul);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    adye localadye = a();
    if (localadye != null) {
      localadye.a(paramString, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.b());
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Apte != null) {
      return this.jdField_a_of_type_Apte.b(paramInt);
    }
    return false;
  }
  
  public void aH_()
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
  
  public void aI_()
  {
    this.b = b();
    this.c = c();
  }
  
  public void aJ_()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.l();
    }
  }
  
  public void aK_()
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.n();
    }
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apss != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apss.a();
    }
    return 0;
  }
  
  public apsr b()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apss != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apss.b();
    }
    return null;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    adye localadye = a();
    if (localadye != null) {
      localadye.a(paramInt);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.a(paramInt, paramBoolean);
    }
  }
  
  public void b(long paramLong)
  {
    adye localadye = a();
    if (localadye != null) {
      localadye.d(paramLong);
    }
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    adye localadye = a();
    if (localadye != null) {
      localadye.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.a();
    }
    return false;
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apss != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apss.b();
    }
    return 0;
  }
  
  public void c(int paramInt) {}
  
  public void c(long paramLong)
  {
    adye localadye = a();
    if (localadye != null) {
      localadye.e(paramLong);
    }
  }
  
  public void c(long paramLong, int paramInt1, int paramInt2)
  {
    adye localadye = a();
    if (localadye != null) {
      localadye.b(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.b(paramBoolean);
    }
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.b();
    }
    return false;
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.c(paramBoolean);
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apss != null)) {
      return this.jdField_a_of_type_Apte.jdField_a_of_type_Apss.a();
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
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.b(paramBoolean);
    }
  }
  
  public boolean e()
  {
    adye localadye = a();
    if (localadye != null) {
      return localadye.asBinder().pingBinder();
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
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.f();
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null))
    {
      this.jdField_a_of_type_Apte.r();
      this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.c();
    }
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.jdField_a_of_type_Apug != null)) {
      this.jdField_a_of_type_Apte.jdField_a_of_type_Apug.g();
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.s();
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.t();
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.u();
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
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.v();
    }
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.w();
    }
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_Apte != null) {
      this.jdField_a_of_type_Apte.c(g());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter
 * JD-Core Version:    0.7.0.1
 */