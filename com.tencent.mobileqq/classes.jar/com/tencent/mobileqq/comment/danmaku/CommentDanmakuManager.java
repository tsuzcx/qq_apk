package com.tencent.mobileqq.comment.danmaku;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.comment.danmaku.data.CommentDanmaku;
import com.tencent.mobileqq.comment.danmaku.view.CommentDanmakuRender;
import com.tencent.mobileqq.danmaku.core.DanmakuManager;
import com.tencent.mobileqq.danmaku.core.DanmakuManager.IDanmakuListener;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext.Builder;
import com.tencent.mobileqq.danmaku.inject.VideoDanmakuConfig;
import com.tencent.mobileqq.danmaku.inject.VideoDanmakuConfig.ILogger;
import com.tencent.mobileqq.danmaku.inject.WindowConfig;
import com.tencent.mobileqq.danmaku.tool.ClickResult;
import com.tencent.mobileqq.danmaku.tool.TouchPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class CommentDanmakuManager
  implements DanmakuManager.IDanmakuListener
{
  private static final VideoDanmakuConfig.ILogger jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger = new CommentDanmakuManager.1();
  private static final String jdField_a_of_type_JavaLangString = CommentDanmakuManager.class.getSimpleName();
  private IDanmakuControlListener jdField_a_of_type_ComTencentMobileqqCommentDanmakuIDanmakuControlListener;
  private IPlayerTime jdField_a_of_type_ComTencentMobileqqCommentDanmakuIPlayerTime;
  private DanmakuManager jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager;
  private WindowConfig jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig;
  
  public BaseDanmaku a(CommentDanmaku paramCommentDanmaku)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) && (paramCommentDanmaku != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(-2147483647, paramCommentDanmaku);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig.b(paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.h();
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.b(paramLong);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig = DanmakuContext.a();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig.a(3);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig.c(7000);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig.f(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig.c(12.0F);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig.b(12.0F);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig.b(false);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectWindowConfig.d(true);
    DanmakuContext.Builder localBuilder = DanmakuContext.a();
    localBuilder.a(new CommentDanmakuManager.2(this));
    localBuilder.a(-4);
    localBuilder.a(new CommentDanmakuRender(paramContext));
    paramContext = localBuilder.a();
    VideoDanmakuConfig.a(jdField_a_of_type_ComTencentMobileqqDanmakuInjectVideoDanmakuConfig$ILogger);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager = new DanmakuManager(paramView, paramContext);
  }
  
  public void a(DanmuItemBean paramDanmuItemBean)
  {
    if ((paramDanmuItemBean != null) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null))
    {
      paramDanmuItemBean = new CommentDanmaku(paramDanmuItemBean);
      paramDanmuItemBean = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(-2147483647, paramDanmuItemBean);
      paramDanmuItemBean.e(true);
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(paramDanmuItemBean);
    }
  }
  
  public void a(IDanmakuControlListener paramIDanmakuControlListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuIDanmakuControlListener = paramIDanmakuControlListener;
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(this);
    }
  }
  
  public void a(IPlayerTime paramIPlayerTime)
  {
    this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuIPlayerTime = paramIPlayerTime;
  }
  
  public void a(BaseDanmaku paramBaseDanmaku, TouchPoint paramTouchPoint, ClickResult paramClickResult) {}
  
  public void a(List<BaseDanmaku> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "addDanmakuList danmakuList is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(paramList);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.d());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.g();
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.l();
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager = null;
    }
  }
  
  public void b(List<BaseDanmaku> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuIDanmakuControlListener != null) && (!b())) {
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuIDanmakuControlListener.b();
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a());
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.d();
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.e();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.c();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.b();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuIDanmakuControlListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqCommentDanmakuIDanmakuControlListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager
 * JD-Core Version:    0.7.0.1
 */