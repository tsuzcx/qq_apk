package com.tencent.mobileqq.filemanager.activity;

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
import anvu;
import atip;
import bmkd;
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
  private atip jdField_a_of_type_Atip;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TextView b;
  TextView c;
  
  public MPFileFailedView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, atip paramatip, int paramInt1, int paramInt2)
  {
    int k = 2131693817;
    int m = 2130844404;
    this.jdField_a_of_type_Atip = paramatip;
    this.c.setVisibility(8);
    int i = 2131693820;
    int n;
    int j;
    switch (paramInt1)
    {
    default: 
      k = 2131693796;
      if (paramInt2 == 1)
      {
        i = 2131693797;
        paramInt2 = 0;
        n = 2131693835;
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
        k = 2131693818;
        paramInt2 = 2131693834;
        m = 2130844409;
        j = 2131693818;
        i = 8;
        continue;
        k = 2131693819;
        paramInt2 = 2131693834;
        m = 2130844409;
        j = 2131693820;
        i = 0;
        continue;
        k = 2131693836;
        m = 2130844407;
        i = 8;
        paramInt2 = 2131693835;
        j = 2131693820;
        continue;
        k = 2131693796;
        if (paramInt2 == 1) {
          i = 2131693797;
        }
        for (;;)
        {
          n = 0;
          j = i;
          paramInt2 = 2131693835;
          i = n;
          break;
          if (paramInt2 == 0) {
            i = 2131693798;
          }
        }
        k = 2131693836;
        m = 2130844407;
        i = 8;
        paramInt2 = 2131693835;
        j = 2131693820;
        continue;
        i = 8;
        m = 2130844408;
        paramInt2 = 2131693835;
        j = 2131693817;
      }
    case 2110: 
      label157:
      m = 2130844409;
      if (paramInt2 == 1)
      {
        j = 2131693819;
        i = 2131693820;
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = paramInt2;
      paramInt2 = 2131693834;
      break label157;
      if (paramInt2 == 0)
      {
        j = 2131693818;
        i = 2131693808;
        paramInt2 = 8;
        continue;
        k = 2131694008;
        i = 8;
        j = 2131694008;
        paramInt2 = 2131693835;
        break label157;
        k = 2131693831;
        i = 8;
        j = 2131693831;
        paramInt2 = 2131693835;
        break label157;
        i = 8;
        m = 2130844408;
        paramInt2 = 2131693835;
        j = 2131693817;
        break label157;
        k = 2131691237;
        i = 8;
        m = 0;
        paramInt2 = 2131693835;
        j = 2131693820;
        break label157;
        if (paramInt2 != 0) {
          break;
        }
        i = 2131693798;
        break;
      }
      j = 2131693800;
      i = 2131693820;
      paramInt2 = 8;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Atip = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560940, null).findViewById(2131361798));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368344));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378618));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378619));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378627));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364031));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    anvu localanvu = (anvu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equalsIgnoreCase(getResources().getString(2131693834))) {
        break label97;
      }
      this.jdField_a_of_type_Long = localanvu.a().a(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Atip != null) {
        this.jdField_a_of_type_Atip.a(this.jdField_a_of_type_Long);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label97:
      if (localanvu.a().a()) {
        this.jdField_a_of_type_Long = localanvu.a().a(1);
      } else {
        this.jdField_a_of_type_Long = localanvu.a().a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileFailedView
 * JD-Core Version:    0.7.0.1
 */