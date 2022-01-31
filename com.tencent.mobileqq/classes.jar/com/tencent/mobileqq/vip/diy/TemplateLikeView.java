package com.tencent.mobileqq.vip.diy;

import ajjy;
import amwq;
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
import baun;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.VoteViewV2;
import urk;
import vms;

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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131313489));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131303235));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131313499));
  }
  
  public int a()
  {
    return 2131496044;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.g == 1) {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131101333));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131101333));
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131101411));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131101411));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, amwq paramamwq, boolean paramBoolean3)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramamwq, paramBoolean3);
    paramamwq = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(ajjy.a(2131649022) + this.jdField_b_of_type_AndroidWidgetTextView.getText().toString()) + vms.a(getContext(), 30.0F)));
    paramamwq.width = this.jdField_c_of_type_Int;
    localLayoutParams.width = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramamwq);
    this.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    paramamwq = super.getLayoutParams();
    paramamwq.width = this.jdField_c_of_type_Int;
    super.setLayoutParams(paramamwq);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.invalidateSelf();
    }
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    urk.e("zhiqiang", "invalidateDrawable");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    urk.b("zhiqiang", "draw +++++++++++");
  }
  
  public void setContainerLayoutParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = paramInt4;
    this.jdField_a_of_type_Int = paramInt3;
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = this.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(ajjy.a(2131649024) + this.e) + vms.a(getContext(), 30.0F)));
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
      paramURLDrawable.setURLDrawableListener(new baun(this));
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramURLDrawable);
    this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.TemplateLikeView
 * JD-Core Version:    0.7.0.1
 */