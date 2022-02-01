package com.tencent.mobileqq.danmaku.data;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.danmaku.DanmakuDependImp;
import com.tencent.mobileqq.danmaku.IDanmakuDepend;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.render.ViewDanmakuRender.ViewHolder;
import com.tencent.mobileqq.danmaku.tool.ClickResult;
import com.tencent.mobileqq.danmaku.tool.TouchPoint;

public class ViewDanmaku
  extends R2LDanmaku
{
  private ViewDanmakuRender.ViewHolder a;
  private boolean e = false;
  
  public ViewDanmaku(DanmakuContext paramDanmakuContext)
  {
    super(paramDanmakuContext);
  }
  
  public int a()
  {
    return -2147483647;
  }
  
  public ViewDanmakuRender.ViewHolder a()
  {
    return this.a;
  }
  
  public ClickResult a(TouchPoint paramTouchPoint)
  {
    if (this.a != null)
    {
      View localView = this.a.a(paramTouchPoint);
      if (localView != null) {
        DanmakuDependImp.a().a().a().post(new ViewDanmaku.1(this, localView));
      }
    }
    return super.a(paramTouchPoint);
  }
  
  public void a(ViewDanmakuRender.ViewHolder paramViewHolder)
  {
    this.a = paramViewHolder;
  }
  
  public void e()
  {
    super.e();
    this.e = false;
  }
  
  public void f(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean i()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.data.ViewDanmaku
 * JD-Core Version:    0.7.0.1
 */