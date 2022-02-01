package com.tencent.mobileqq.vip.lianghao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vip.lianghao.RegisterLiangHaoHelper;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoUinData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class RegisterLiangHaoPayFailLayoutView
  extends LinearLayout
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private RegisterLiangHaoHelper jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper;
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
    int i = Utils.a(27.5F, getResources());
    setPadding(i, 0, i, 0);
    LayoutInflater.from(getContext()).inflate(2131562093, this, true);
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView = ((LiangHaoView)findViewById(2131370333));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370332);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper.b(this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setLiangHaoHelper(RegisterLiangHaoHelper paramRegisterLiangHaoHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper = paramRegisterLiangHaoHelper;
  }
  
  public void setUin(LiangHaoUinData paramLiangHaoUinData)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView.setUin(paramLiangHaoUinData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoPayFailLayoutView
 * JD-Core Version:    0.7.0.1
 */