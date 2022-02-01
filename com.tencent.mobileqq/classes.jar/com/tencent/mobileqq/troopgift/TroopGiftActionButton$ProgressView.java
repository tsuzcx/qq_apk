package com.tencent.mobileqq.troopgift;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;
import org.json.JSONObject;

class TroopGiftActionButton$ProgressView
  extends View
{
  private Paint b = new Paint();
  private RectF c;
  private int d;
  
  public TroopGiftActionButton$ProgressView(TroopGiftActionButton paramTroopGiftActionButton, Context paramContext)
  {
    super(paramContext);
    this.b.setAntiAlias(true);
    this.b.setColor(Color.parseColor(TroopGiftActionButton.a(paramTroopGiftActionButton).optString("buttonColor")));
    this.b.setStrokeWidth(DisplayUtil.a(getContext(), 3.0F));
    this.b.setStyle(Paint.Style.STROKE);
    this.c = new RectF();
    this.c.left = (DisplayUtil.a(getContext(), 3.0F) / 2);
    this.c.top = (DisplayUtil.a(getContext(), 3.0F) / 2);
    this.c.right = (DisplayUtil.a(getContext(), 68.0F) - DisplayUtil.a(getContext(), 3.0F) / 2);
    this.c.bottom = (DisplayUtil.a(getContext(), 68.0F) - DisplayUtil.a(getContext(), 3.0F) / 2);
    a(0);
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.c, -90.0F, -(100 - this.d) * 360 / 100, false, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftActionButton.ProgressView
 * JD-Core Version:    0.7.0.1
 */