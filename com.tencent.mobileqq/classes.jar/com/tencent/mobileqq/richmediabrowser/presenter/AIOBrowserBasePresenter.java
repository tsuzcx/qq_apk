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
  public AIOBrowserPresenter a;
  public AIOBrowserBaseView b;
  public BrowserBasePresenter c;
  public ConcurrentHashMap<Long, Set<DanmuItemBean>> d = new ConcurrentHashMap();
  private ImmersionHelper e;
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.a;
    if ((localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.b != null)) {
      return this.a.b.a(paramLong, paramInt1, paramInt2, paramString);
    }
    return -1;
  }
  
  public RichMediaBrowserInfo a(long paramLong)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.a;
    if ((localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.b != null)) {
      return this.a.b.b(paramLong);
    }
    return null;
  }
  
  public RichMediaBrowserInfo a(long paramLong1, long paramLong2)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.a;
    if ((localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.b != null)) {
      return this.a.b.a(paramLong1, paramLong2);
    }
    return null;
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.a;
    if ((localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.b != null)) {
      this.a.b.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt3, Bundle paramBundle) {}
  
  public void a(AIOBrowserPresenter paramAIOBrowserPresenter)
  {
    this.a = paramAIOBrowserPresenter;
  }
  
  public void a(IDecoratorModel paramIDecoratorModel) {}
  
  public void a(IDecoratorView paramIDecoratorView)
  {
    if ((paramIDecoratorView instanceof AIOBrowserBaseView)) {
      this.b = ((AIOBrowserBaseView)paramIDecoratorView);
    }
  }
  
  public void a(IBasePresenterBuilder paramIBasePresenterBuilder)
  {
    if ((paramIBasePresenterBuilder instanceof BrowserBasePresenter)) {
      this.c = ((BrowserBasePresenter)paramIBasePresenterBuilder);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.a;
    if (localAIOBrowserPresenter != null) {
      localAIOBrowserPresenter.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.a;
    return (localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.b != null) && (this.a.b.b());
  }
  
  public boolean a(int paramInt)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.a;
    if (localAIOBrowserPresenter != null) {
      return localAIOBrowserPresenter.b(paramInt);
    }
    return false;
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return BrowserDanmakuUtils.a(paramRichMediaBrowserInfo);
  }
  
  public CommentDanmakuManager b()
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.a;
    if (localAIOBrowserPresenter != null) {
      return localAIOBrowserPresenter.d();
    }
    return null;
  }
  
  public void b(int paramInt) {}
  
  public void b(IBasePresenterBuilder paramIBasePresenterBuilder)
  {
    if ((paramIBasePresenterBuilder instanceof AIOBrowserPresenter)) {
      a((AIOBrowserPresenter)paramIBasePresenterBuilder);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.a;
    if ((localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.a != null)) {
      this.a.a.a(paramBoolean);
    }
  }
  
  public void c()
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.a;
    if (localAIOBrowserPresenter != null) {
      localAIOBrowserPresenter.f();
    }
  }
  
  public long d()
  {
    return 0L;
  }
  
  public void e() {}
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBrowserBasePresenter", 2, "onDanmakuDrawFinish");
    }
    if ((h()) && (!g().a))
    {
      g().b();
      g().a();
    }
  }
  
  public ImmersionHelper g()
  {
    if (this.e == null) {
      this.e = new ImmersionHelper(this);
    }
    return this.e;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public boolean i()
  {
    return false;
  }
  
  public void j()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((AIOBrowserPresenter)localObject).l();
    }
    localObject = this.c;
    if (localObject != null) {
      ((BrowserBasePresenter)localObject).back();
    }
  }
  
  @RequiresApi(api=11)
  public void k()
  {
    if (this.c.getContentView() != null) {
      this.c.getContentView().setAlpha(0.3F);
    }
  }
  
  public void l()
  {
    AIOBrowserBaseView localAIOBrowserBaseView = this.b;
    if ((localAIOBrowserBaseView != null) && (localAIOBrowserBaseView.g != null)) {
      this.b.g.setAlpha(0.3F);
    }
  }
  
  @RequiresApi(api=11)
  public void m()
  {
    if (this.c.getContentView() != null) {
      this.c.getContentView().setAlpha(1.0F);
    }
  }
  
  public void n()
  {
    AIOBrowserBaseView localAIOBrowserBaseView = this.b;
    if ((localAIOBrowserBaseView != null) && (localAIOBrowserBaseView.g != null)) {
      this.b.g.setAlpha(1.0F);
    }
  }
  
  public boolean o()
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.a;
    if ((localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.a != null)) {
      return this.a.a.a();
    }
    return false;
  }
  
  public void onDestroy()
  {
    ConcurrentHashMap localConcurrentHashMap = this.d;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
  }
  
  public RichMediaBrowserInfo p()
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.a;
    if ((localAIOBrowserPresenter != null) && (localAIOBrowserPresenter.b != null)) {
      return this.a.b.a();
    }
    return null;
  }
  
  public void q()
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.a;
    if (localAIOBrowserPresenter != null) {
      localAIOBrowserPresenter.p();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserBasePresenter
 * JD-Core Version:    0.7.0.1
 */