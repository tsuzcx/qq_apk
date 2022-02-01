package com.tencent.mobileqq.richmediabrowser.presenter;

import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.RelativeLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive;
import com.tencent.mobileqq.richmediabrowser.BrowserDanmakuUtils;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserBaseView;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AIOBrowserBasePresenter
  extends BrowserBasePresenter
{
  private ImmersionHelper a;
  public AIOBrowserPresenter a;
  public AIOBrowserBaseView a;
  public ConcurrentHashMap<Long, Set<DanmuItemBean>> a;
  
  public AIOBrowserBasePresenter()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(paramLong, paramInt1, paramInt2, paramString);
    }
    return -1;
  }
  
  public long a()
  {
    return 0L;
  }
  
  public CommentDanmakuManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a();
    }
    return null;
  }
  
  public DCAIOPreview a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a();
    }
    return null;
  }
  
  public DCAIOPreviewProgressive a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a();
    }
    return null;
  }
  
  public ImmersionHelper a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper = new ImmersionHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper;
  }
  
  public RichMediaBrowserInfo a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a();
    }
    return null;
  }
  
  public RichMediaBrowserInfo a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(paramLong);
    }
    return null;
  }
  
  public RichMediaBrowserInfo a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(paramLong1, paramLong2);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.d();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a(paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle) {}
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a(paramLong1, paramLong2, paramString);
    }
  }
  
  public void a(AIOBrowserPresenter paramAIOBrowserPresenter)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter = paramAIOBrowserPresenter;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a());
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.b(paramInt);
    }
    return false;
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return BrowserDanmakuUtils.a(paramRichMediaBrowserInfo);
  }
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void back()
  {
    super.back();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.j();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBrowserBasePresenter", 0, "onDanmakuDrawFinish");
    }
    if ((b()) && (!a().a))
    {
      a().b();
      a().a();
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  @RequiresApi(api=11)
  public void d()
  {
    if (getContentView() != null) {
      getContentView().setAlpha(0.3F);
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.a();
    }
    return false;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView.a.setAlpha(0.3F);
    }
  }
  
  @RequiresApi(api=11)
  public void f()
  {
    if (getContentView() != null) {
      getContentView().setAlpha(1.0F);
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView.a.setAlpha(1.0F);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.f();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.k();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.l();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.m();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.n();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void setGalleryView(BrowserBaseView paramBrowserBaseView)
  {
    super.setGalleryView(paramBrowserBaseView);
    if ((paramBrowserBaseView instanceof AIOBrowserBaseView)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView = ((AIOBrowserBaseView)paramBrowserBaseView);
    }
  }
  
  public void setRelyPresenter(BasePresenter paramBasePresenter)
  {
    super.setRelyPresenter(paramBasePresenter);
    if ((paramBasePresenter instanceof AIOBrowserPresenter)) {
      a((AIOBrowserPresenter)paramBasePresenter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserBasePresenter
 * JD-Core Version:    0.7.0.1
 */