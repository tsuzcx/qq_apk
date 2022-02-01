package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;

class StructMsgItemLayoutBirthdayReminder$1
  extends RecyclerView.ItemDecoration
{
  StructMsgItemLayoutBirthdayReminder$1(StructMsgItemLayoutBirthdayReminder paramStructMsgItemLayoutBirthdayReminder, Context paramContext) {}
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getPaddingLeft();
    int k = paramRecyclerView.getWidth();
    int m = paramRecyclerView.getPaddingRight();
    int n = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < n - 1)
    {
      Object localObject1 = paramRecyclerView.getChildAt(i);
      Object localObject2 = (RecyclerView.LayoutParams)((View)localObject1).getLayoutParams();
      int i1 = ((View)localObject1).getBottom();
      int i2 = ((RecyclerView.LayoutParams)localObject2).bottomMargin;
      localObject1 = new Paint();
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setStrokeWidth(ViewUtils.dip2px(1.0F));
      ((Paint)localObject1).setColor(this.a.getResources().getColor(2131167469));
      localObject2 = new Path();
      float f1 = j;
      float f2 = i1 + i2;
      ((Path)localObject2).moveTo(f1, f2);
      ((Path)localObject2).lineTo(k - m, f2);
      ((Paint)localObject1).setPathEffect(new DashPathEffect(new float[] { 5.0F, 10.0F, 5.0F, 10.0F }, 0.0F));
      paramCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutBirthdayReminder.1
 * JD-Core Version:    0.7.0.1
 */