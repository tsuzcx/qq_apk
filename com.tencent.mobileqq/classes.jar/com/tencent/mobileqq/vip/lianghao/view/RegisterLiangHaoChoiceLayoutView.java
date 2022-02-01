package com.tencent.mobileqq.vip.lianghao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import biaj;
import biao;
import biaq;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class RegisterLiangHaoChoiceLayoutView
  extends LinearLayout
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private biaj jdField_a_of_type_Biaj;
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
    if ((localLiangHaoView != null) && (localLiangHaoView.a != null) && (this.jdField_a_of_type_Biaj != null)) {
      this.jdField_a_of_type_Biaj.a(localLiangHaoView.a);
    }
  }
  
  public void a()
  {
    int i = 0;
    setOrientation(1);
    LayoutInflater.from(getContext()).inflate(2131561954, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370058);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370057));
    this.b = findViewById(2131370056);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[0] = ((LiangHaoView)findViewById(2131370061));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[1] = ((LiangHaoView)findViewById(2131370062));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[2] = ((LiangHaoView)findViewById(2131370063));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[3] = ((LiangHaoView)findViewById(2131370064));
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
  
  public void a(biao parambiao)
  {
    if ((parambiao == null) || (parambiao.a == null) || (parambiao.a.size() == 0)) {
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView.length)
    {
      if (parambiao.a.size() <= i) {
        ((ViewGroup)this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[i].getParent()).setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        biaq localbiaq = (biaq)parambiao.a.get(i);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[i].setUin(localbiaq);
        ((ViewGroup)this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[i].getParent()).setVisibility(0);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambiao.c);
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
    biaj localbiaj = this.jdField_a_of_type_Biaj;
    if (localbiaj == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      case 2131370057: 
      case 2131370059: 
      case 2131370060: 
      case 2131370061: 
      case 2131370062: 
      case 2131370063: 
      case 2131370064: 
      default: 
        break;
      case 2131370056: 
        localbiaj.b();
        break;
      case 2131370058: 
        localbiaj.a();
        break;
      case 2131370065: 
        a(0);
        break;
      case 2131370066: 
        a(1);
        break;
      case 2131370067: 
        a(2);
        break;
      case 2131370068: 
        a(3);
      }
    }
  }
  
  public void setLiangHaoHelper(biaj parambiaj)
  {
    this.jdField_a_of_type_Biaj = parambiaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoChoiceLayoutView
 * JD-Core Version:    0.7.0.1
 */