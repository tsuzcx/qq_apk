package com.tencent.mobileqq.filemanager.activity;

import amqd;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aruy;
import bkok;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MPFileFailedView
  extends RelativeLayout
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aruy jdField_a_of_type_Aruy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TextView b;
  TextView c;
  
  public MPFileFailedView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, aruy paramaruy, int paramInt1, int paramInt2)
  {
    int k = 2131693916;
    int m = 2130844289;
    this.jdField_a_of_type_Aruy = paramaruy;
    this.c.setVisibility(8);
    int i = 2131693919;
    int n;
    int j;
    switch (paramInt1)
    {
    default: 
      k = 2131693895;
      if (paramInt2 == 1)
      {
        i = 2131693896;
        paramInt2 = 0;
        n = 2131693934;
        j = i;
        i = paramInt2;
        paramInt2 = n;
      }
      break;
    case 2001: 
    case 2003: 
    case 2002: 
    case 2004: 
    case 2107: 
    case 2109: 
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(m);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(k);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.b.setText(j);
        this.b.setVisibility(i);
        this.c.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setText(paramInt2);
        if (7 == paramInt1) {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        return this.jdField_a_of_type_AndroidWidgetLinearLayout;
        k = 2131693917;
        paramInt2 = 2131693933;
        m = 2130844294;
        j = 2131693917;
        i = 8;
        continue;
        k = 2131693918;
        paramInt2 = 2131693933;
        m = 2130844294;
        j = 2131693919;
        i = 0;
        continue;
        k = 2131693935;
        m = 2130844292;
        i = 8;
        paramInt2 = 2131693934;
        j = 2131693919;
        continue;
        k = 2131693895;
        if (paramInt2 == 1) {
          i = 2131693896;
        }
        for (;;)
        {
          n = 0;
          j = i;
          paramInt2 = 2131693934;
          i = n;
          break;
          if (paramInt2 == 0) {
            i = 2131693897;
          }
        }
        k = 2131693935;
        m = 2130844292;
        i = 8;
        paramInt2 = 2131693934;
        j = 2131693919;
        continue;
        i = 8;
        m = 2130844293;
        paramInt2 = 2131693934;
        j = 2131693916;
      }
    case 2110: 
      label157:
      m = 2130844294;
      if (paramInt2 == 1)
      {
        j = 2131693918;
        i = 2131693919;
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = paramInt2;
      paramInt2 = 2131693933;
      break label157;
      if (paramInt2 == 0)
      {
        j = 2131693917;
        i = 2131693907;
        paramInt2 = 8;
        continue;
        k = 2131694108;
        i = 8;
        j = 2131694108;
        paramInt2 = 2131693934;
        break label157;
        k = 2131693930;
        i = 8;
        j = 2131693930;
        paramInt2 = 2131693934;
        break label157;
        i = 8;
        m = 2130844293;
        paramInt2 = 2131693934;
        j = 2131693916;
        break label157;
        k = 2131691276;
        i = 8;
        m = 0;
        paramInt2 = 2131693934;
        j = 2131693919;
        break label157;
        if (paramInt2 != 0) {
          break;
        }
        i = 2131693897;
        break;
      }
      j = 2131693899;
      i = 2131693919;
      paramInt2 = 8;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aruy = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560820, null).findViewById(2131361798));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368368));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378382));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378383));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378391));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364055));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    amqd localamqd = (amqd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(8);
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equalsIgnoreCase(getResources().getString(2131693933))) {
        break label97;
      }
      this.jdField_a_of_type_Long = localamqd.a().a(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aruy != null) {
        this.jdField_a_of_type_Aruy.a(this.jdField_a_of_type_Long);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label97:
      if (localamqd.a().a()) {
        this.jdField_a_of_type_Long = localamqd.a().a(1);
      } else {
        this.jdField_a_of_type_Long = localamqd.a().a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileFailedView
 * JD-Core Version:    0.7.0.1
 */