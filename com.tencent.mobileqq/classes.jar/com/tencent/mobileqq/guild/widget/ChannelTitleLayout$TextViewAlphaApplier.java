package com.tencent.mobileqq.guild.widget;

import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.tencent.mobileqq.guild.animate.Interpolators;
import com.tencent.qphone.base.util.QLog;

public class ChannelTitleLayout$TextViewAlphaApplier
{
  public final Interpolator a;
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  
  private ChannelTitleLayout$TextViewAlphaApplier(Interpolator paramInterpolator, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInterpolator;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
  }
  
  public static TextViewAlphaApplier a()
  {
    return new TextViewAlphaApplier(Interpolators.a(0.75F, 0.0F, 0.55F, 0.0F), 0, -16777216, 0, -1);
  }
  
  public static TextViewAlphaApplier b()
  {
    return new TextViewAlphaApplier(Interpolators.a(), -1, -16777216, ChannelTitleLayout.a(), -1);
  }
  
  public void a(TextView paramTextView, float paramFloat)
  {
    float f = this.a.getInterpolation(paramFloat);
    paramTextView.setTextColor(ColorUtils.blendARGB(this.b, this.c, f));
    paramTextView.setShadowLayer(1.0F, 0.0F, 4.0F, ColorUtils.blendARGB(this.d, this.e, f));
    QLog.d("ChannelTitleLayout", 4, new Object[] { "apply ", Float.valueOf(paramFloat), " -> ", Float.valueOf(f) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.ChannelTitleLayout.TextViewAlphaApplier
 * JD-Core Version:    0.7.0.1
 */