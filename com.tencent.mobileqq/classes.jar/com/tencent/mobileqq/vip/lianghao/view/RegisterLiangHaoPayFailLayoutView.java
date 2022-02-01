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
  private LiangHaoView a;
  private View b;
  private RegisterLiangHaoHelper c;
  
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
    LayoutInflater.from(getContext()).inflate(2131628353, this, true);
    this.a = ((LiangHaoView)findViewById(2131437155));
    this.b = findViewById(2131437154);
    this.b.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.c.b(this.a.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setLiangHaoHelper(RegisterLiangHaoHelper paramRegisterLiangHaoHelper)
  {
    this.c = paramRegisterLiangHaoHelper;
  }
  
  public void setUin(LiangHaoUinData paramLiangHaoUinData)
  {
    this.a.setUin(paramLiangHaoUinData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoPayFailLayoutView
 * JD-Core Version:    0.7.0.1
 */