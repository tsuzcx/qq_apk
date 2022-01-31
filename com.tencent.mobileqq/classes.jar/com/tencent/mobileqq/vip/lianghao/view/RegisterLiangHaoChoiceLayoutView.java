package com.tencent.mobileqq.vip.lianghao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import bdxq;
import bdxv;
import bdxx;
import java.util.List;

public class RegisterLiangHaoChoiceLayoutView
  extends LinearLayout
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bdxq jdField_a_of_type_Bdxq;
  private LiangHaoView[] jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView = new LiangHaoView[4];
  private View b;
  
  public RegisterLiangHaoChoiceLayoutView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RegisterLiangHaoChoiceLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RegisterLiangHaoChoiceLayoutView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(int paramInt)
  {
    LiangHaoView localLiangHaoView = this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[paramInt];
    if ((localLiangHaoView != null) && (localLiangHaoView.a != null) && (this.jdField_a_of_type_Bdxq != null)) {
      this.jdField_a_of_type_Bdxq.a(localLiangHaoView.a);
    }
  }
  
  public void a()
  {
    int i = 0;
    setOrientation(1);
    LayoutInflater.from(getContext()).inflate(2131561712, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369385);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369384));
    this.b = findViewById(2131369383);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[0] = ((LiangHaoView)findViewById(2131369388));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[1] = ((LiangHaoView)findViewById(2131369389));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[2] = ((LiangHaoView)findViewById(2131369390));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[3] = ((LiangHaoView)findViewById(2131369391));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    LiangHaoView[] arrayOfLiangHaoView = this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView;
    int j = arrayOfLiangHaoView.length;
    while (i < j)
    {
      ((ViewGroup)arrayOfLiangHaoView[i].getParent()).setOnClickListener(this);
      i += 1;
    }
  }
  
  public void a(bdxv parambdxv)
  {
    if ((parambdxv == null) || (parambdxv.a == null) || (parambdxv.a.size() == 0)) {
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView.length)
    {
      if (parambdxv.a.size() <= i) {
        ((ViewGroup)this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[i].getParent()).setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        bdxx localbdxx = (bdxx)parambdxv.a.get(i);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[i].setUin(localbdxx);
        ((ViewGroup)this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[i].getParent()).setVisibility(0);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambdxv.c);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      localObject2.setEnabled(paramBoolean);
      ((ViewGroup)localObject2.getParent()).setEnabled(paramBoolean);
      i += 1;
    }
    this.jdField_a_of_type_AndroidViewView.setEnabled(paramBoolean);
    this.b.setEnabled(paramBoolean);
    localObject1 = this.b;
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.5F)
    {
      ((View)localObject1).setAlpha(f);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    bdxq localbdxq = this.jdField_a_of_type_Bdxq;
    if (localbdxq == null) {
      return;
    }
    switch (paramView.getId())
    {
    case 2131369384: 
    case 2131369386: 
    case 2131369387: 
    case 2131369388: 
    case 2131369389: 
    case 2131369390: 
    case 2131369391: 
    default: 
      return;
    case 2131369383: 
      localbdxq.b();
      return;
    case 2131369385: 
      localbdxq.a();
      return;
    case 2131369392: 
      a(0);
      return;
    case 2131369393: 
      a(1);
      return;
    case 2131369394: 
      a(2);
      return;
    }
    a(3);
  }
  
  public void setLiangHaoHelper(bdxq parambdxq)
  {
    this.jdField_a_of_type_Bdxq = parambdxq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoChoiceLayoutView
 * JD-Core Version:    0.7.0.1
 */