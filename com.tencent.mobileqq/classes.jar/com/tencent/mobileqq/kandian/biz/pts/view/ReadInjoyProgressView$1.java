package com.tencent.mobileqq.kandian.biz.pts.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ReadInjoyProgressView$1
  extends NativeTextImp
{
  ReadInjoyProgressView$1(ReadInjoyProgressView paramReadInjoyProgressView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!TextUtils.isEmpty(getText()))
    {
      this.a.b.set(0.0F, 0.0F, getWidth(), getHeight());
      this.a.c.set(0.0F, 0.0F, getWidth() * ReadInjoyProgressView.a(this.a) / 100.0F, getHeight());
      this.a.a.setColor(Color.parseColor(ReadInjoyProgressView.b(this.a)));
      paramCanvas.drawRoundRect(this.a.b, AIOUtils.b(2.0F, getResources()), AIOUtils.b(2.0F, getResources()), this.a.a);
      this.a.a.setColor(Color.parseColor(ReadInjoyProgressView.c(this.a)));
      paramCanvas.drawRoundRect(this.a.c, AIOUtils.b(2.0F, getResources()), AIOUtils.b(2.0F, getResources()), this.a.a);
    }
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyProgressView.1
 * JD-Core Version:    0.7.0.1
 */