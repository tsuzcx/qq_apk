package com.tencent.mobileqq.filemanager.activity;

import ajgm;
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
import anyg;
import bfhb;
import com.tencent.mobileqq.app.QQAppInterface;

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
  private anyg jdField_a_of_type_Anyg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TextView b;
  TextView c;
  
  public MPFileFailedView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, anyg paramanyg, int paramInt1, int paramInt2)
  {
    int k = 2131628722;
    int m = 2130843479;
    this.jdField_a_of_type_Anyg = paramanyg;
    this.c.setVisibility(8);
    int i = 2131628725;
    int n;
    int j;
    switch (paramInt1)
    {
    default: 
      k = 2131628701;
      if (paramInt2 == 1)
      {
        i = 2131628702;
        paramInt2 = 0;
        n = 2131628740;
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
        k = 2131628723;
        paramInt2 = 2131628739;
        m = 2130843484;
        j = 2131628723;
        i = 8;
        continue;
        k = 2131628724;
        paramInt2 = 2131628739;
        m = 2130843484;
        j = 2131628725;
        i = 0;
        continue;
        k = 2131628741;
        m = 2130843482;
        i = 8;
        paramInt2 = 2131628740;
        j = 2131628725;
        continue;
        k = 2131628701;
        if (paramInt2 == 1) {
          i = 2131628702;
        }
        for (;;)
        {
          n = 0;
          j = i;
          paramInt2 = 2131628740;
          i = n;
          break;
          if (paramInt2 == 0) {
            i = 2131628703;
          }
        }
        k = 2131628741;
        m = 2130843482;
        i = 8;
        paramInt2 = 2131628740;
        j = 2131628725;
        continue;
        i = 8;
        m = 2130843483;
        paramInt2 = 2131628740;
        j = 2131628722;
      }
    case 2110: 
      label157:
      m = 2130843484;
      if (paramInt2 == 1)
      {
        j = 2131628724;
        i = 2131628725;
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = paramInt2;
      paramInt2 = 2131628739;
      break label157;
      if (paramInt2 == 0)
      {
        j = 2131628723;
        i = 2131628713;
        paramInt2 = 8;
        continue;
        k = 2131629008;
        i = 8;
        j = 2131629008;
        paramInt2 = 2131628740;
        break label157;
        k = 2131628736;
        i = 8;
        j = 2131628736;
        paramInt2 = 2131628740;
        break label157;
        i = 8;
        m = 2130843483;
        paramInt2 = 2131628740;
        j = 2131628722;
        break label157;
        k = 2131625824;
        i = 8;
        m = 0;
        paramInt2 = 2131628740;
        j = 2131628725;
        break label157;
        if (paramInt2 != 0) {
          break;
        }
        i = 2131628703;
        break;
      }
      j = 2131628705;
      i = 2131628725;
      paramInt2 = 8;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Anyg = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131494938, null).findViewById(2131296262));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131302182));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131311234));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131311235));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131311243));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298187));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    ajgm localajgm = (ajgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equalsIgnoreCase(getResources().getString(2131628739))) {
        break label90;
      }
      this.jdField_a_of_type_Long = localajgm.a().a(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Anyg != null) {
        this.jdField_a_of_type_Anyg.a(this.jdField_a_of_type_Long);
      }
      return;
      label90:
      if (localajgm.a().a()) {
        this.jdField_a_of_type_Long = localajgm.a().a(1);
      } else {
        this.jdField_a_of_type_Long = localajgm.a().a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileFailedView
 * JD-Core Version:    0.7.0.1
 */