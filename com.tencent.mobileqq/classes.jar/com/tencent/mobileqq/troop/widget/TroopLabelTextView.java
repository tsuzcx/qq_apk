package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.ThemeImageWrapper.DrawInterface;

public class TroopLabelTextView
  extends TextView
  implements ThemeImageWrapper.DrawInterface
{
  protected int a;
  int b;
  public ThemeImageWrapper c;
  private Context d;
  private int e;
  private int f;
  private Bitmap g;
  private Paint h;
  private PorterDuffXfermode i;
  private Bitmap j;
  private Canvas k;
  
  public TroopLabelTextView(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
    this.a = paramInt1;
    setTextColor(paramInt2);
    setMaxLines(1);
    setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, ViewUtils.dip2px(16.0F));
    localLayoutParams.rightMargin = 4;
    paramInt2 = ViewUtils.dip2px(4.0F);
    int m = ViewUtils.dip2px(4.0F);
    int n = ViewUtils.dip2px(0.0F);
    int i1 = ViewUtils.dip2px(0.0F);
    setTextSize(1, 10.0F);
    if (paramInt3 == 2)
    {
      paramInt1 = ViewUtils.dip2px(10.0F);
    }
    else
    {
      paramInt1 = paramInt2;
      if (paramInt3 == 1)
      {
        setIncludeFontPadding(false);
        localLayoutParams.height = ViewUtils.dip2px(14.0F);
        paramInt1 = paramInt2;
      }
    }
    setLayoutParams(localLayoutParams);
    setPadding(paramInt1, n, m, i1);
    this.d = paramContext;
    this.e = paramInt3;
    this.b = ViewUtils.dip2px(2.0F);
    this.f = ViewUtils.dip2px(5.0F);
    a();
  }
  
  private void a()
  {
    this.c = new ThemeImageWrapper();
    this.c.setSupportMaskView(true);
    this.c.setMaskShape(ThemeImageWrapper.MODE_OTHER);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.c.onDraw(paramCanvas, this);
  }
  
  public float getExtraWidth()
  {
    return 12.0F;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((this.e == 2) && (this.g != null))
    {
      this.h.setXfermode(this.i);
      this.k.drawColor(this.a);
      this.k.drawBitmap(this.g, 0.0F, 0.0F, this.h);
      this.h.setXfermode(null);
      paramCanvas.drawBitmap(this.j, 0.0F, 0.0F, this.h);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3 + (getPaddingLeft() + getPaddingRight()), paramInt4);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    paramInt1 = this.e;
    if (paramInt1 == 1)
    {
      localGradientDrawable.setColor(this.a);
      localGradientDrawable.setCornerRadius(this.b);
      setBackgroundDrawable(localGradientDrawable);
      return;
    }
    if (paramInt1 == 0)
    {
      localGradientDrawable.setStroke(2, this.a);
      localGradientDrawable.setCornerRadius(getHeight() / 2);
      setBackgroundDrawable(localGradientDrawable);
    }
  }
  
  public void setColor(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    setTextColor(paramInt2);
  }
  
  public void setMaskImage(int paramInt)
  {
    try
    {
      this.g = BitmapFactory.decodeResource(getResources(), paramInt);
      this.j = Bitmap.createBitmap(this.g.getWidth(), this.g.getHeight(), Bitmap.Config.ARGB_8888);
      this.k = new Canvas(this.j);
      this.h = new Paint(1);
      this.i = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label78:
      break label78;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopLabelTextView", 2, "TroopLabelTextView setMaskImage OOM");
    }
  }
  
  public void superOnDraw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopLabelTextView
 * JD-Core Version:    0.7.0.1
 */