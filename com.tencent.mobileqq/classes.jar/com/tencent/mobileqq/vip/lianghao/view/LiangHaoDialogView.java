package com.tencent.mobileqq.vip.lianghao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import bdxx;

public class LiangHaoDialogView
  extends LinearLayout
{
  public bdxx a;
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
    LayoutInflater.from(getContext()).inflate(2131561713, this, true);
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView = ((LiangHaoView)findViewById(2131369387));
  }
  
  public void a(bdxx parambdxx)
  {
    this.jdField_a_of_type_Bdxx = parambdxx;
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewLiangHaoView.setUin(parambdxx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.LiangHaoDialogView
 * JD-Core Version:    0.7.0.1
 */