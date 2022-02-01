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
  private RegisterLiangHaoHelper a;
  private LiangHaoView[] b = new LiangHaoView[4];
  private TextView c;
  private View d;
  private View e;
  
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
    LiangHaoView localLiangHaoView = this.b[paramInt];
    if ((localLiangHaoView != null) && (localLiangHaoView.a != null))
    {
      RegisterLiangHaoHelper localRegisterLiangHaoHelper = this.a;
      if (localRegisterLiangHaoHelper != null) {
        localRegisterLiangHaoHelper.a(localLiangHaoView.a);
      }
    }
  }
  
  public void a()
  {
    setOrientation(1);
    LayoutInflater.from(getContext()).inflate(2131628350, this, true);
    this.d = findViewById(2131437153);
    this.c = ((TextView)findViewById(2131437152));
    this.e = findViewById(2131437151);
    LiangHaoView[] arrayOfLiangHaoView = this.b;
    LiangHaoView localLiangHaoView = (LiangHaoView)findViewById(2131437156);
    int i = 0;
    arrayOfLiangHaoView[0] = localLiangHaoView;
    this.b[1] = ((LiangHaoView)findViewById(2131437157));
    this.b[2] = ((LiangHaoView)findViewById(2131437158));
    this.b[3] = ((LiangHaoView)findViewById(2131437159));
    this.d.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    arrayOfLiangHaoView = this.b;
    int j = arrayOfLiangHaoView.length;
    while (i < j)
    {
      ((ViewGroup)arrayOfLiangHaoView[i].getParent()).setOnClickListener(this);
      i += 1;
    }
  }
  
  public void a(LiangHaoRsp paramLiangHaoRsp)
  {
    if ((paramLiangHaoRsp != null) && (paramLiangHaoRsp.f != null))
    {
      if (paramLiangHaoRsp.f.size() == 0) {
        return;
      }
      int i = 0;
      while (i < this.b.length)
      {
        if (paramLiangHaoRsp.f.size() <= i)
        {
          ((ViewGroup)this.b[i].getParent()).setVisibility(8);
        }
        else
        {
          LiangHaoUinData localLiangHaoUinData = (LiangHaoUinData)paramLiangHaoRsp.f.get(i);
          this.b[i].setUin(localLiangHaoUinData);
          ((ViewGroup)this.b[i].getParent()).setVisibility(0);
        }
        i += 1;
      }
      this.c.setText(paramLiangHaoRsp.e);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = this.b;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      localObject2.setEnabled(paramBoolean);
      ((ViewGroup)localObject2.getParent()).setEnabled(paramBoolean);
      i += 1;
    }
    this.d.setEnabled(paramBoolean);
    this.e.setEnabled(paramBoolean);
    localObject1 = this.e;
    float f;
    if (paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.5F;
    }
    ((View)localObject1).setAlpha(f);
  }
  
  public void onClick(View paramView)
  {
    RegisterLiangHaoHelper localRegisterLiangHaoHelper = this.a;
    if (localRegisterLiangHaoHelper != null)
    {
      int i = paramView.getId();
      if (i == 2131437153) {
        localRegisterLiangHaoHelper.a();
      } else if (i == 2131437160) {
        a(0);
      } else if (i == 2131437161) {
        a(1);
      } else if (i == 2131437162) {
        a(2);
      } else if (i == 2131437163) {
        a(3);
      } else if (i == 2131437151) {
        localRegisterLiangHaoHelper.c();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setLiangHaoHelper(RegisterLiangHaoHelper paramRegisterLiangHaoHelper)
  {
    this.a = paramRegisterLiangHaoHelper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoChoiceLayoutView
 * JD-Core Version:    0.7.0.1
 */