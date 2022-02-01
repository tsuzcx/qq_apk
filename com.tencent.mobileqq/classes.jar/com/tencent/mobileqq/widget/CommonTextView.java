package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class CommonTextView
  extends TextView
  implements MosaicEffect.IMosaicEffect
{
  private CommonTextView.onVisibilityChangedListener jdField_a_of_type_ComTencentMobileqqWidgetCommonTextView$onVisibilityChangedListener;
  private MosaicEffect jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
  
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
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect.b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCommonTextView$onVisibilityChangedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCommonTextView$onVisibilityChangedListener.a(paramView, paramInt);
    }
  }
  
  public void setMosaicEffect(MosaicEffect paramMosaicEffect)
  {
    MosaicEffect localMosaicEffect = this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
    if (localMosaicEffect != null) {
      localMosaicEffect.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect = paramMosaicEffect;
    if (paramMosaicEffect != null) {
      paramMosaicEffect.a(this);
    }
    invalidate();
  }
  
  public void setOnVisibilityChangedListener(CommonTextView.onVisibilityChangedListener paramonVisibilityChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCommonTextView$onVisibilityChangedListener = paramonVisibilityChangedListener;
  }
  
  public void superDrawMosaic(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void superOnDrawMosaic(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CommonTextView
 * JD-Core Version:    0.7.0.1
 */