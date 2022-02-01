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
import anjx;
import assl;
import blja;
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
  private assl jdField_a_of_type_Assl;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TextView b;
  TextView c;
  
  public MPFileFailedView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, assl paramassl, int paramInt1, int paramInt2)
  {
    int k = 2131693800;
    int m = 2130844390;
    this.jdField_a_of_type_Assl = paramassl;
    this.c.setVisibility(8);
    int i = 2131693803;
    int n;
    int j;
    switch (paramInt1)
    {
    default: 
      k = 2131693779;
      if (paramInt2 == 1)
      {
        i = 2131693780;
        paramInt2 = 0;
        n = 2131693818;
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
        k = 2131693801;
        paramInt2 = 2131693817;
        m = 2130844395;
        j = 2131693801;
        i = 8;
        continue;
        k = 2131693802;
        paramInt2 = 2131693817;
        m = 2130844395;
        j = 2131693803;
        i = 0;
        continue;
        k = 2131693819;
        m = 2130844393;
        i = 8;
        paramInt2 = 2131693818;
        j = 2131693803;
        continue;
        k = 2131693779;
        if (paramInt2 == 1) {
          i = 2131693780;
        }
        for (;;)
        {
          n = 0;
          j = i;
          paramInt2 = 2131693818;
          i = n;
          break;
          if (paramInt2 == 0) {
            i = 2131693781;
          }
        }
        k = 2131693819;
        m = 2130844393;
        i = 8;
        paramInt2 = 2131693818;
        j = 2131693803;
        continue;
        i = 8;
        m = 2130844394;
        paramInt2 = 2131693818;
        j = 2131693800;
      }
    case 2110: 
      label157:
      m = 2130844395;
      if (paramInt2 == 1)
      {
        j = 2131693802;
        i = 2131693803;
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = paramInt2;
      paramInt2 = 2131693817;
      break label157;
      if (paramInt2 == 0)
      {
        j = 2131693801;
        i = 2131693791;
        paramInt2 = 8;
        continue;
        k = 2131693991;
        i = 8;
        j = 2131693991;
        paramInt2 = 2131693818;
        break label157;
        k = 2131693814;
        i = 8;
        j = 2131693814;
        paramInt2 = 2131693818;
        break label157;
        i = 8;
        m = 2130844394;
        paramInt2 = 2131693818;
        j = 2131693800;
        break label157;
        k = 2131691234;
        i = 8;
        m = 0;
        paramInt2 = 2131693818;
        j = 2131693803;
        break label157;
        if (paramInt2 != 0) {
          break;
        }
        i = 2131693781;
        break;
      }
      j = 2131693783;
      i = 2131693803;
      paramInt2 = 8;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Assl = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560909, null).findViewById(2131361798));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368270));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378460));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378461));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378469));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364005));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    anjx localanjx = (anjx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equalsIgnoreCase(getResources().getString(2131693817))) {
        break label97;
      }
      this.jdField_a_of_type_Long = localanjx.a().a(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Assl != null) {
        this.jdField_a_of_type_Assl.a(this.jdField_a_of_type_Long);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label97:
      if (localanjx.a().a()) {
        this.jdField_a_of_type_Long = localanjx.a().a(1);
      } else {
        this.jdField_a_of_type_Long = localanjx.a().a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileFailedView
 * JD-Core Version:    0.7.0.1
 */