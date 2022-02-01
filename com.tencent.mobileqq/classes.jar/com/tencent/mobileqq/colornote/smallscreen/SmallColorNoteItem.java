package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.colornote.layout.AutoBgFrameLayout;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.RoundImageView;

public class SmallColorNoteItem
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AutoBgFrameLayout jdField_a_of_type_ComTencentMobileqqColornoteLayoutAutoBgFrameLayout;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  
  public SmallColorNoteItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SmallColorNoteItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public SmallColorNoteItem(Context paramContext, boolean paramBoolean, ViewGroup paramViewGroup)
  {
    super(paramContext);
    a(paramBoolean, paramViewGroup);
  }
  
  private void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558885, paramViewGroup, false);
    } else {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558884, paramViewGroup, false);
    }
    paramViewGroup = this.jdField_a_of_type_AndroidViewView;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131365204));
    this.jdField_a_of_type_ComTencentMobileqqColornoteLayoutAutoBgFrameLayout = ((AutoBgFrameLayout)paramViewGroup.findViewById(2131371964));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)paramViewGroup.findViewById(2131371965));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371975));
    this.b = ((TextView)paramViewGroup.findViewById(2131371973));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    RoundImageView localRoundImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
    if (localRoundImageView != null) {
      localRoundImageView.setVisibility(4);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new ViewGroup.LayoutParams(-1, paramInt1);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ((ViewGroup.LayoutParams)localObject).height = paramInt1;
    float f = paramInt1 * 1.0F / paramInt2;
    paramInt1 = (int)(DisplayUtil.a(getContext(), 6.0F) * f);
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (this.jdField_a_of_type_Boolean) {
      paramInt2 = 0;
    } else {
      paramInt2 = paramInt1;
    }
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = paramInt1;
    } else {
      i = 0;
    }
    ((RelativeLayout)localObject).setPadding(paramInt2, paramInt1, i, paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setmRadius((int)(DisplayUtil.a(getContext(), 3.0F) * f), false);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = ((int)(DisplayUtil.a(getContext(), 20.0F) * f));
    ((RelativeLayout.LayoutParams)localObject).width = ((int)(DisplayUtil.a(getContext(), 20.0F) * f));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize((int)(8.0F * f));
    this.b.setTextSize((int)(6.0F * f));
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    paramInt1 = Math.max(DisplayUtil.a(getContext(), 2.0F), (int)(f * DisplayUtil.a(getContext(), 4.0F)));
    if (this.jdField_a_of_type_Boolean) {
      paramInt2 = 0;
    } else {
      paramInt2 = paramInt1;
    }
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt2;
    if (this.jdField_a_of_type_Boolean) {
      paramInt2 = paramInt1;
    } else {
      paramInt2 = 0;
    }
    ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt2;
    localObject = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    if (this.jdField_a_of_type_Boolean) {
      paramInt2 = 0;
    } else {
      paramInt2 = paramInt1;
    }
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt2;
    if (!this.jdField_a_of_type_Boolean) {
      paramInt1 = 0;
    }
    ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt1;
  }
  
  public void b()
  {
    RoundImageView localRoundImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
    if (localRoundImageView != null) {
      localRoundImageView.setVisibility(0);
    }
  }
  
  public void c()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(4);
    }
    localTextView = this.b;
    if (localTextView != null) {
      localTextView.setVisibility(4);
    }
  }
  
  public void d()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    localTextView = this.b;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAttachLeft(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setSubTitle(String paramString)
  {
    TextView localTextView = this.b;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setTitle(String paramString)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.SmallColorNoteItem
 * JD-Core Version:    0.7.0.1
 */