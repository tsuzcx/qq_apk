package com.tencent.mobileqq.richmediabrowser.presenter;

import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmediabrowser.BrowserDanmakuUtils;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserBaseView;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.api.decorator.IDecoratorModel;
import com.tencent.richmediabrowser.api.decorator.IDecoratorPresenter;
import com.tencent.richmediabrowser.api.decorator.IDecoratorView;
import com.tencent.richmediabrowser.api.event.IActivityEvent;
import com.tencent.richmediabrowser.core.IBasePresenterBuilder;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AIOBrowserBasePresenter
  extends BasePresenter
  implements IDecoratorPresenter, IActivityEvent
{
  private ImmersionHelper a;
  public AIOBrowserPresenter a;
  public AIOBrowserBaseView a;
  public BrowserBasePresenter a;
  public ConcurrentHashMap<Long, Set<DanmuItemBean>> a;
  
  public AIOBrowserBasePresenter()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
    if ((localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null)) {
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
    AIOBrowserPresenter localAIOBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
    if (localAIOBrowserPresenter != null) {
      return localAIOBrowserPresenter.a();
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
    AIOBrowserPresenter localAIOBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
    if ((localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a();
    }
    return null;
  }
  
  public RichMediaBrowserInfo a(long paramLong)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
    if ((localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(paramLong);
    }
    return null;
  }
  
  public RichMediaBrowserInfo a(long paramLong1, long paramLong2)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
    if ((localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(paramLong1, paramLong2);
    }
    return null;
  }
  
  public void a()
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
    if (localAIOBrowserPresenter != null) {
      localAIOBrowserPresenter.d();
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
    if ((localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt3, Bundle paramBundle) {}
  
  public void a(AIOBrowserPresenter paramAIOBrowserPresenter)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter = paramAIOBrowserPresenter;
  }
  
  public void a(IDecoratorModel paramIDecoratorModel) {}
  
  public void a(IDecoratorView paramIDecoratorView)
  {
    if ((paramIDecoratorView instanceof AIOBrowserBaseView)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView = ((AIOBrowserBaseView)paramIDecoratorView);
    }
  }
  
  public void a(IBasePresenterBuilder paramIBasePresenterBuilder)
  {
    if ((paramIBasePresenterBuilder instanceof BrowserBasePresenter)) {
      this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter = ((BrowserBasePresenter)paramIBasePresenterBuilder);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
    if (localAIOBrowserPresenter != null) {
      localAIOBrowserPresenter.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
    return (localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOBrowserModel.a());
  }
  
  public boolean a(int paramInt)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
    if (localAIOBrowserPresenter != null) {
      return localAIOBrowserPresenter.b(paramInt);
    }
    return false;
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return BrowserDanmakuUtils.a(paramRichMediaBrowserInfo);
  }
  
  public void b() {}
  
  public void b(IBasePresenterBuilder paramIBasePresenterBuilder)
  {
    if ((paramIBasePresenterBuilder instanceof AIOBrowserPresenter)) {
      a((AIOBrowserPresenter)paramIBasePresenterBuilder);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
    if ((localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBrowserBasePresenter", 2, "onDanmakuDrawFinish");
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
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
    if (localObject != null) {
      ((AIOBrowserPresenter)localObject).j();
    }
    localObject = this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter;
    if (localObject != null) {
      ((BrowserBasePresenter)localObject).back();
    }
  }
  
  public boolean d()
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
    if ((localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserScene.a();
    }
    return false;
  }
  
  @RequiresApi(api=11)
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getContentView() != null) {
      this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getContentView().setAlpha(0.3F);
    }
  }
  
  public void f()
  {
    AIOBrowserBaseView localAIOBrowserBaseView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView;
    if ((localAIOBrowserBaseView != null) && (localAIOBrowserBaseView.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView.a.setAlpha(0.3F);
    }
  }
  
  @RequiresApi(api=11)
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getContentView() != null) {
      this.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getContentView().setAlpha(1.0F);
    }
  }
  
  public void h()
  {
    AIOBrowserBaseView localAIOBrowserBaseView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView;
    if ((localAIOBrowserBaseView != null) && (localAIOBrowserBaseView.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView.a.setAlpha(1.0F);
    }
  }
  
  public void i()
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
    if (localAIOBrowserPresenter != null) {
      localAIOBrowserPresenter.n();
    }
  }
  
  public void onDestroy()
  {
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserBasePresenter
 * JD-Core Version:    0.7.0.1
 */