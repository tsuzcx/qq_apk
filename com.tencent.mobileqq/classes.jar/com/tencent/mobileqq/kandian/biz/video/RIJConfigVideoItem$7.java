package com.tencent.mobileqq.kandian.biz.video;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

final class RIJConfigVideoItem$7
  implements Runnable
{
  RIJConfigVideoItem$7(View paramView1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView2) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.a.setEnabled(true);
    this.a.getHitRect((Rect)localObject);
    ((Rect)localObject).left -= this.b;
    ((Rect)localObject).top -= this.c;
    ((Rect)localObject).right += this.d;
    ((Rect)localObject).bottom += this.e;
    localObject = new TouchDelegate((Rect)localObject, this.a);
    this.f.setTouchDelegate((TouchDelegate)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJConfigVideoItem.7
 * JD-Core Version:    0.7.0.1
 */