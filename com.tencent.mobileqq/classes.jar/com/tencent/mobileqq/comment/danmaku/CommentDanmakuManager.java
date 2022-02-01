package com.tencent.mobileqq.comment.danmaku;

import android.content.Context;
import android.view.View;
import com.tencent.common.danmaku.core.DanmakuManager;
import com.tencent.common.danmaku.core.DanmakuManager.IDanmakuListener;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.DanmakuContext.Builder;
import com.tencent.common.danmaku.inject.VideoDanmakuConfig;
import com.tencent.common.danmaku.inject.VideoDanmakuConfig.ILogger;
import com.tencent.common.danmaku.inject.WindowConfig;
import com.tencent.common.danmaku.tool.ClickResult;
import com.tencent.common.danmaku.tool.TouchPoint;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.comment.danmaku.data.CommentDanmaku;
import com.tencent.mobileqq.comment.danmaku.view.CommentDanmakuRender;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class CommentDanmakuManager
  implements DanmakuManager.IDanmakuListener
{
  private static final String a = "CommentDanmakuManager";
  private static final VideoDanmakuConfig.ILogger f = new CommentDanmakuManager.1();
  private DanmakuManager b;
  private IDanmakuControlListener c;
  private IPlayerTime d;
  private WindowConfig e;
  
  public BaseDanmaku a(CommentDanmaku paramCommentDanmaku)
  {
    DanmakuManager localDanmakuManager = this.b;
    if ((localDanmakuManager != null) && (paramCommentDanmaku != null)) {
      return localDanmakuManager.a(-2147483647, paramCommentDanmaku);
    }
    return null;
  }
  
  public void a()
  {
    IDanmakuControlListener localIDanmakuControlListener = this.c;
    if (localIDanmakuControlListener != null) {
      localIDanmakuControlListener.a();
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((WindowConfig)localObject).b(paramInt);
      localObject = this.b;
      if (localObject != null) {
        ((DanmakuManager)localObject).h();
      }
    }
  }
  
  public void a(long paramLong)
  {
    DanmakuManager localDanmakuManager = this.b;
    if (localDanmakuManager != null) {
      localDanmakuManager.b(paramLong);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.e = DanmakuContext.a();
    this.e.a(3);
    this.e.c(7000);
    this.e.f(8.0F);
    this.e.c(12.0F);
    this.e.b(12.0F);
    this.e.b(false);
    this.e.d(true);
    DanmakuContext.Builder localBuilder = DanmakuContext.k();
    localBuilder.a(new CommentDanmakuManager.2(this));
    localBuilder.a(-4);
    localBuilder.a(new CommentDanmakuRender(paramContext));
    paramContext = localBuilder.a();
    VideoDanmakuConfig.a(f);
    this.b = new DanmakuManager(paramView, paramContext);
  }
  
  public void a(BaseDanmaku paramBaseDanmaku, TouchPoint paramTouchPoint, ClickResult paramClickResult) {}
  
  public void a(DanmuItemBean paramDanmuItemBean)
  {
    if ((paramDanmuItemBean != null) && (this.b != null))
    {
      paramDanmuItemBean = new CommentDanmaku(paramDanmuItemBean);
      paramDanmuItemBean = this.b.a(-2147483647, paramDanmuItemBean);
      paramDanmuItemBean.e(true);
      this.b.b(paramDanmuItemBean);
    }
  }
  
  public void a(IDanmakuControlListener paramIDanmakuControlListener)
  {
    this.c = paramIDanmakuControlListener;
    paramIDanmakuControlListener = this.b;
    if (paramIDanmakuControlListener != null) {
      paramIDanmakuControlListener.a(this);
    }
  }
  
  public void a(IPlayerTime paramIPlayerTime)
  {
    this.d = paramIPlayerTime;
  }
  
  public void a(List<BaseDanmaku> paramList)
  {
    if ((this.c != null) && (!h())) {
      this.c.b();
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    DanmakuManager localDanmakuManager = this.b;
    if (localDanmakuManager != null) {
      localDanmakuManager.a();
    }
  }
  
  public void b(List<BaseDanmaku> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      DanmakuManager localDanmakuManager = this.b;
      if (localDanmakuManager != null) {
        localDanmakuManager.a(paramList);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 4, "addDanmakuList danmakuList is null");
    }
  }
  
  public void c()
  {
    DanmakuManager localDanmakuManager = this.b;
    if (localDanmakuManager != null)
    {
      localDanmakuManager.g();
      this.b.x();
      this.b = null;
    }
  }
  
  public void d()
  {
    DanmakuManager localDanmakuManager = this.b;
    if (localDanmakuManager != null)
    {
      localDanmakuManager.d();
      this.b.e();
    }
  }
  
  public boolean e()
  {
    DanmakuManager localDanmakuManager = this.b;
    return (localDanmakuManager != null) && (localDanmakuManager.n());
  }
  
  public void f()
  {
    DanmakuManager localDanmakuManager = this.b;
    if (localDanmakuManager != null) {
      localDanmakuManager.c();
    }
  }
  
  public void g()
  {
    DanmakuManager localDanmakuManager = this.b;
    if (localDanmakuManager != null) {
      localDanmakuManager.b();
    }
  }
  
  public boolean h()
  {
    DanmakuManager localDanmakuManager = this.b;
    return (localDanmakuManager != null) && (localDanmakuManager.i());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager
 * JD-Core Version:    0.7.0.1
 */