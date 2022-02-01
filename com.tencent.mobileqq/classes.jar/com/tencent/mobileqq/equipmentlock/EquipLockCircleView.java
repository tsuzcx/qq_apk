package com.tencent.mobileqq.equipmentlock;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class EquipLockCircleView
  extends View
{
  public EquipLockCircleView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Paint localPaint = new Paint();
    localPaint.setColor(getResources().getColor(2131167026));
    paramCanvas.drawCircle(AIOUtils.dp2px(3.0F, getResources()), getHeight() / 2, AIOUtils.dp2px(2.0F, getResources()), localPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.EquipLockCircleView
 * JD-Core Version:    0.7.0.1
 */