package com.tencent.mobileqq.vip.lianghao.view;

import aekt;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import bdxq;
import bdxx;

public class RegisterLiangHaoPayFailLayoutView
  extends LinearLayout
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private bdxq jdField_a_of_type_Bdxq;
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
    int i = aekt.a(27.5F, getResources());
    setPadding(i, 0, i, 0);
    LayoutInflater.from(getContext()).inflate(2131561715, this, true);
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView = ((LiangHaoView)findViewById(2131369387));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369386);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bdxq.b(this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView.a);
  }
  
  public void setLiangHaoHelper(bdxq parambdxq)
  {
    this.jdField_a_of_type_Bdxq = parambdxq;
  }
  
  public void setUin(bdxx parambdxx)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView.setUin(parambdxx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoPayFailLayoutView
 * JD-Core Version:    0.7.0.1
 */