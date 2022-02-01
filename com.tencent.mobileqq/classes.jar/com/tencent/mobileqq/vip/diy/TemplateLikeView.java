package com.tencent.mobileqq.vip.diy;

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
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.widget.VoteViewV2;

public class TemplateLikeView
  extends VoteViewV2
{
  protected int a;
  protected ViewGroup a;
  protected TextView a;
  protected URLDrawable a;
  protected int b;
  protected ViewGroup b;
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
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131380997));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131369739));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381004));
  }
  
  protected int a()
  {
    return 2131562036;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    TextView localTextView;
    if (this.g == 1)
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null)
      {
        localTextView.setTextColor(getContext().getResources().getColor(2131167138));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131167138));
      }
    }
    else
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null)
      {
        localTextView.setTextColor(getContext().getResources().getColor(2131167222));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131167222));
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, NewVoteAnimHelper paramNewVoteAnimHelper, boolean paramBoolean3)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramNewVoteAnimHelper, paramBoolean3);
    paramNewVoteAnimHelper = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
    float f = this.jdField_a_of_type_Int + this.jdField_b_of_type_Int;
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetTextView.getPaint();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131714619));
    localStringBuilder.append(this.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
    this.jdField_c_of_type_Int = ((int)(f + localTextPaint.measureText(localStringBuilder.toString()) + UIUtils.a(getContext(), 30.0F)));
    paramInt1 = this.jdField_c_of_type_Int;
    paramNewVoteAnimHelper.width = paramInt1;
    localLayoutParams.width = paramInt1;
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramNewVoteAnimHelper);
    this.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    paramNewVoteAnimHelper = super.getLayoutParams();
    paramNewVoteAnimHelper.width = this.jdField_c_of_type_Int;
    super.setLayoutParams(paramNewVoteAnimHelper);
    paramNewVoteAnimHelper = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (paramNewVoteAnimHelper != null) {
      paramNewVoteAnimHelper.invalidateSelf();
    }
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    SLog.e("zhiqiang", "invalidateDrawable");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    SLog.b("zhiqiang", "draw +++++++++++");
  }
  
  public void setContainerLayoutParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = paramInt4;
    this.jdField_a_of_type_Int = paramInt3;
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = this.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
    float f = this.jdField_a_of_type_Int + this.jdField_b_of_type_Int;
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetTextView.getPaint();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131714621));
    localStringBuilder.append(this.e);
    this.jdField_c_of_type_Int = ((int)(f + localTextPaint.measureText(localStringBuilder.toString()) + UIUtils.a(getContext(), 30.0F)));
    this.d = paramInt2;
    paramInt1 = this.jdField_c_of_type_Int;
    localLayoutParams1.width = paramInt1;
    paramInt2 = this.d;
    localLayoutParams1.height = paramInt2;
    localLayoutParams2.width = paramInt1;
    localLayoutParams2.height = paramInt2;
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams1);
    this.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams2);
  }
  
  public void setVoteContainerBackground(URLDrawable paramURLDrawable)
  {
    URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localURLDrawable != null) {
      localURLDrawable.setURLDrawableListener(null);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    if ((paramURLDrawable != null) && (paramURLDrawable.getStatus() != 1)) {
      paramURLDrawable.setURLDrawableListener(new TemplateLikeView.1(this));
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramURLDrawable);
    this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.TemplateLikeView
 * JD-Core Version:    0.7.0.1
 */