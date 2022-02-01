package com.tencent.mobileqq.vip.lianghao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.vip.lianghao.RegisterLiangHaoHelper;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoRsp;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoUinData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class RegisterLiangHaoChoiceLayoutView
  extends LinearLayout
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RegisterLiangHaoHelper jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper;
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
    if ((localLiangHaoView != null) && (localLiangHaoView.a != null) && (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper != null)) {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper.a(localLiangHaoView.a);
    }
  }
  
  public void a()
  {
    int i = 0;
    setOrientation(1);
    LayoutInflater.from(getContext()).inflate(2131562090, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370331);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370330));
    this.b = findViewById(2131370329);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[0] = ((LiangHaoView)findViewById(2131370334));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[1] = ((LiangHaoView)findViewById(2131370335));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[2] = ((LiangHaoView)findViewById(2131370336));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[3] = ((LiangHaoView)findViewById(2131370337));
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
  
  public void a(LiangHaoRsp paramLiangHaoRsp)
  {
    if ((paramLiangHaoRsp == null) || (paramLiangHaoRsp.a == null) || (paramLiangHaoRsp.a.size() == 0)) {
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView.length)
    {
      if (paramLiangHaoRsp.a.size() <= i) {
        ((ViewGroup)this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[i].getParent()).setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        LiangHaoUinData localLiangHaoUinData = (LiangHaoUinData)paramLiangHaoRsp.a.get(i);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[i].setUin(localLiangHaoUinData);
        ((ViewGroup)this.jdField_a_of_type_ArrayOfComTencentMobileqqVipLianghaoViewLiangHaoView[i].getParent()).setVisibility(0);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramLiangHaoRsp.c);
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
    RegisterLiangHaoHelper localRegisterLiangHaoHelper = this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper;
    if (localRegisterLiangHaoHelper == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = paramView.getId();
      if (i == 2131370331) {
        localRegisterLiangHaoHelper.a();
      } else if (i == 2131370338) {
        a(0);
      } else if (i == 2131370339) {
        a(1);
      } else if (i == 2131370340) {
        a(2);
      } else if (i == 2131370341) {
        a(3);
      } else if (i == 2131370329) {
        localRegisterLiangHaoHelper.b();
      }
    }
  }
  
  public void setLiangHaoHelper(RegisterLiangHaoHelper paramRegisterLiangHaoHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper = paramRegisterLiangHaoHelper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoChoiceLayoutView
 * JD-Core Version:    0.7.0.1
 */