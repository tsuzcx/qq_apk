package com.tencent.mobileqq.vip.lianghao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import bijq;
import bijv;
import bijx;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class RegisterLiangHaoChoiceLayoutView
  extends LinearLayout
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bijq jdField_a_of_type_Bijq;
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
    if ((localLiangHaoView != null) && (localLiangHaoView.a != null) && (this.jdField_a_of_type_Bijq != null)) {
      this.jdField_a_of_type_Bijq.a(localLiangHaoView.a);
    }
  }
  
  public void a()
  {
    int i = 0;
    setOrientation(1);
    LayoutInflater.from(getContext()).inflate(2131562009, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369894);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369893));
    this.b = findViewById(2131369892);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[0] = ((LiangHaoView)findViewById(2131369897));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[1] = ((LiangHaoView)findViewById(2131369898));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[2] = ((LiangHaoView)findViewById(2131369899));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[3] = ((LiangHaoView)findViewById(2131369900));
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
  
  public void a(bijv parambijv)
  {
    if ((parambijv == null) || (parambijv.a == null) || (parambijv.a.size() == 0)) {
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView.length)
    {
      if (parambijv.a.size() <= i) {
        ((ViewGroup)this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[i].getParent()).setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        bijx localbijx = (bijx)parambijv.a.get(i);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[i].setUin(localbijx);
        ((ViewGroup)this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[i].getParent()).setVisibility(0);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambijv.c);
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
    bijq localbijq = this.jdField_a_of_type_Bijq;
    if (localbijq == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      case 2131369893: 
      case 2131369895: 
      case 2131369896: 
      case 2131369897: 
      case 2131369898: 
      case 2131369899: 
      case 2131369900: 
      default: 
        break;
      case 2131369892: 
        localbijq.b();
        break;
      case 2131369894: 
        localbijq.a();
        break;
      case 2131369901: 
        a(0);
        break;
      case 2131369902: 
        a(1);
        break;
      case 2131369903: 
        a(2);
        break;
      case 2131369904: 
        a(3);
      }
    }
  }
  
  public void setLiangHaoHelper(bijq parambijq)
  {
    this.jdField_a_of_type_Bijq = parambijq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoChoiceLayoutView
 * JD-Core Version:    0.7.0.1
 */