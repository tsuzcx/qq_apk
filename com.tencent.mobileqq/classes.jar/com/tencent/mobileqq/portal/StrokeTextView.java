package com.tencent.mobileqq.portal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class StrokeTextView
  extends TextView
{
  private TextPaint a;
  private boolean b = false;
  private int c;
  private int d;
  private int e;
  private float f;
  private float g;
  private float h;
  private int i;
  
  public StrokeTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  @TargetApi(11)
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.a = getPaint();
    this.b = false;
    this.e = AIOUtils.b(2.0F, getResources());
    if (Build.VERSION.SDK_INT > 11) {
      setLayerType(1, null);
    }
  }
  
  private void a(int paramInt)
  {
    int k = 1;
    int j;
    try
    {
      Field localField = TextView.class.getDeclaredField("mCurTextColor");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      localField.setAccessible(false);
      j = 0;
    }
    catch (Throwable localThrowable)
    {
      j = k;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("innerSetTextColor, exception=");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.d("StrokeTextView", 2, localStringBuilder.toString());
        localThrowable.printStackTrace();
        j = k;
      }
    }
    if (j == 0)
    {
      this.a.setColor(paramInt);
      return;
    }
    this.b = false;
    setTextColor(this.c);
    setShadowLayer(this.f, this.g, this.h, this.i);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b)
    {
      a(this.d);
      this.a.setStrokeWidth(this.e);
      this.a.setStyle(Paint.Style.FILL_AND_STROKE);
      this.a.setShadowLayer(this.f, this.g, this.h, this.i);
      super.onDraw(paramCanvas);
      a(this.c);
      this.a.setStrokeWidth(0.0F);
      this.a.setStyle(Paint.Style.FILL_AND_STROKE);
      this.a.setFakeBoldText(false);
      this.a.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setInnerTextColor(int paramInt)
  {
    this.c = paramInt;
    setTextColor(paramInt);
  }
  
  public void setShadow(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.f = paramFloat1;
    this.g = paramFloat2;
    this.h = paramFloat3;
    this.i = paramInt;
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setStrokeEnable(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setStrokeSize(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setTextBold(boolean paramBoolean)
  {
    this.a.setFakeBoldText(paramBoolean);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    super.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.StrokeTextView
 * JD-Core Version:    0.7.0.1
 */