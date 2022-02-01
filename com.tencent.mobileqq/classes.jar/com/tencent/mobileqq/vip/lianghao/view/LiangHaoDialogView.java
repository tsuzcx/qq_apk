package com.tencent.mobileqq.vip.lianghao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import bijx;

public class LiangHaoDialogView
  extends LinearLayout
{
  public bijx a;
  private LiangHaoView a;
  
  public LiangHaoDialogView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LiangHaoDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LiangHaoDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOrientation(1);
    LayoutInflater.from(getContext()).inflate(2131562010, this, true);
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView = ((LiangHaoView)findViewById(2131369896));
  }
  
  public void a(bijx parambijx)
  {
    this.jdField_a_of_type_Bijx = parambijx;
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView.setUin(parambijx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.LiangHaoDialogView
 * JD-Core Version:    0.7.0.1
 */