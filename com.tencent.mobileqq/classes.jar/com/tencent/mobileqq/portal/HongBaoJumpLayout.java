package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class HongBaoJumpLayout
  extends View
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  public HongBaoJumpLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public HongBaoJumpLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public void a()
  {
    this.a = getResources().getDimensionPixelOffset(2131298299);
    this.b = getResources().getDimensionPixelOffset(2131298298);
    this.c = getResources().getDimensionPixelOffset(2131298296);
    this.d = getResources().getDimensionPixelOffset(2131298297);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongBaoJumpLayout
 * JD-Core Version:    0.7.0.1
 */