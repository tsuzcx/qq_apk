package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bawz;
import com.tencent.mobileqq.widget.AutoBgFrameLayout;
import com.tencent.mobileqq.widget.RoundImageView;

public class SmallColorNoteItem
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AutoBgFrameLayout jdField_a_of_type_ComTencentMobileqqWidgetAutoBgFrameLayout;
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
  
  public SmallColorNoteItem(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    a(paramBoolean);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {}
    for (this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558808, null);; this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558807, null))
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131364723));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgFrameLayout = ((AutoBgFrameLayout)localView.findViewById(2131370921));
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)localView.findViewById(2131370922));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370932));
      this.b = ((TextView)localView.findViewById(2131370930));
      return;
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setVisibility(4);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new ViewGroup.LayoutParams(-1, paramInt1);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ((ViewGroup.LayoutParams)localObject).height = paramInt1;
    float f = 1.0F * paramInt1 / paramInt2;
    paramInt1 = (int)(bawz.a(getContext(), 6.0F) * f);
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt2 = 0;
      if (!this.jdField_a_of_type_Boolean) {
        break label291;
      }
      i = paramInt1;
      label73:
      ((RelativeLayout)localObject).setPadding(paramInt2, paramInt1, i, paramInt1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setmRadius((int)(bawz.a(getContext(), 3.0F) * f), false);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(bawz.a(getContext(), 20.0F) * f));
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(bawz.a(getContext(), 20.0F) * f));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize((int)(8.0F * f));
      this.b.setTextSize((int)(f * 6.0F));
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramInt1 = Math.max(bawz.a(getContext(), 2.0F), (int)(bawz.a(getContext(), 4.0F) * f));
      if (!this.jdField_a_of_type_Boolean) {
        break label297;
      }
      paramInt2 = 0;
      label224:
      ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt2;
      if (!this.jdField_a_of_type_Boolean) {
        break label302;
      }
      paramInt2 = paramInt1;
      label239:
      ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt2;
      localObject = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      if (!this.jdField_a_of_type_Boolean) {
        break label307;
      }
      paramInt2 = 0;
      label266:
      ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt2;
      if (!this.jdField_a_of_type_Boolean) {
        break label312;
      }
    }
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt1;
      return;
      paramInt2 = paramInt1;
      break;
      label291:
      i = 0;
      break label73;
      label297:
      paramInt2 = paramInt1;
      break label224;
      label302:
      paramInt2 = 0;
      break label239;
      label307:
      paramInt2 = paramInt1;
      break label266;
      label312:
      paramInt1 = 0;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setVisibility(0);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    if (this.b != null) {
      this.b.setVisibility(4);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.b != null) {
      this.b.setVisibility(0);
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
    if (this.b != null) {
      this.b.setText(paramString);
    }
  }
  
  public void setTitle(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.SmallColorNoteItem
 * JD-Core Version:    0.7.0.1
 */