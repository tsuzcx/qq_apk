package com.tencent.mobileqq.vip.lianghao.view;

import actj;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import bbyp;
import bbyw;

public class RegisterLiangHaoPayFailLayoutView
  extends LinearLayout
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private bbyp jdField_a_of_type_Bbyp;
  private LiangHaoView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView;
  
  public RegisterLiangHaoPayFailLayoutView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RegisterLiangHaoPayFailLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RegisterLiangHaoPayFailLayoutView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOrientation(1);
    int i = actj.a(27.5F, getResources());
    setPadding(i, 0, i, 0);
    LayoutInflater.from(getContext()).inflate(2131561524, this, true);
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView = ((LiangHaoView)findViewById(2131369155));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369154);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bbyp.b(this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView.a);
  }
  
  public void setLiangHaoHelper(bbyp parambbyp)
  {
    this.jdField_a_of_type_Bbyp = parambbyp;
  }
  
  public void setUin(bbyw parambbyw)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView.setUin(parambbyw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoPayFailLayoutView
 * JD-Core Version:    0.7.0.1
 */