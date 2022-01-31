package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import beob;
import berb;
import berc;

public class CommonTextView
  extends TextView
  implements berc
{
  private beob jdField_a_of_type_Beob;
  private berb jdField_a_of_type_Berb;
  
  public CommonTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CommonTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void b(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Berb != null)
    {
      this.jdField_a_of_type_Berb.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Berb != null)
    {
      this.jdField_a_of_type_Berb.b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_Beob != null) {
      this.jdField_a_of_type_Beob.a(paramView, paramInt);
    }
  }
  
  public void setMosaicEffect(berb paramberb)
  {
    berb localberb = this.jdField_a_of_type_Berb;
    if (localberb != null) {
      localberb.a(null);
    }
    this.jdField_a_of_type_Berb = paramberb;
    if (paramberb != null) {
      paramberb.a(this);
    }
    invalidate();
  }
  
  public void setOnVisibilityChangedListener(beob parambeob)
  {
    this.jdField_a_of_type_Beob = parambeob;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CommonTextView
 * JD-Core Version:    0.7.0.1
 */