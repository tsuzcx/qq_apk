package com.tencent.mobileqq.vip.diy;

import alpo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import apek;
import bdww;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.VoteViewV2;
import wsv;
import xod;

public class TemplateLikeView
  extends VoteViewV2
{
  protected int a;
  public ViewGroup a;
  protected TextView a;
  protected URLDrawable a;
  protected int b;
  public ViewGroup b;
  protected int c;
  protected int d;
  
  public TemplateLikeView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TemplateLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TemplateLikeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131380030));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131369132));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380040));
  }
  
  public int a()
  {
    return 2131561826;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.g == 1) {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131166975));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131166975));
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131167057));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131167057));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, apek paramapek, boolean paramBoolean3)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramapek, paramBoolean3);
    paramapek = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(alpo.a(2131715194) + this.jdField_b_of_type_AndroidWidgetTextView.getText().toString()) + xod.a(getContext(), 30.0F)));
    paramapek.width = this.jdField_c_of_type_Int;
    localLayoutParams.width = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramapek);
    this.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    paramapek = super.getLayoutParams();
    paramapek.width = this.jdField_c_of_type_Int;
    super.setLayoutParams(paramapek);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.invalidateSelf();
    }
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    wsv.e("zhiqiang", "invalidateDrawable");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    wsv.b("zhiqiang", "draw +++++++++++");
  }
  
  public void setContainerLayoutParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = paramInt4;
    this.jdField_a_of_type_Int = paramInt3;
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = this.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(alpo.a(2131715196) + this.e) + xod.a(getContext(), 30.0F)));
    this.d = paramInt2;
    localLayoutParams1.width = this.jdField_c_of_type_Int;
    localLayoutParams1.height = this.d;
    localLayoutParams2.width = this.jdField_c_of_type_Int;
    localLayoutParams2.height = this.d;
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams1);
    this.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams2);
  }
  
  public void setVoteContainerBackground(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    if ((paramURLDrawable != null) && (paramURLDrawable.getStatus() != 1)) {
      paramURLDrawable.setURLDrawableListener(new bdww(this));
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramURLDrawable);
    this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.TemplateLikeView
 * JD-Core Version:    0.7.0.1
 */