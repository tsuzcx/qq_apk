package com.tencent.mobileqq.vip.lianghao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import biaj;
import biaq;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class RegisterLiangHaoPayFailLayoutView
  extends LinearLayout
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private biaj jdField_a_of_type_Biaj;
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
    int i = AIOUtils.dp2px(27.5F, getResources());
    setPadding(i, 0, i, 0);
    LayoutInflater.from(getContext()).inflate(2131561957, this, true);
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView = ((LiangHaoView)findViewById(2131370060));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370059);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Biaj.b(this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setLiangHaoHelper(biaj parambiaj)
  {
    this.jdField_a_of_type_Biaj = parambiaj;
  }
  
  public void setUin(biaq parambiaq)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView.setUin(parambiaq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoPayFailLayoutView
 * JD-Core Version:    0.7.0.1
 */