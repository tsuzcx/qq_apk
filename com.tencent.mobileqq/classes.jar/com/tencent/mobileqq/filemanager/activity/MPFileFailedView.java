package com.tencent.mobileqq.filemanager.activity;

import allz;
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
import aqic;
import biqi;
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
  private aqic jdField_a_of_type_Aqic;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TextView b;
  TextView c;
  
  public MPFileFailedView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, aqic paramaqic, int paramInt1, int paramInt2)
  {
    int k = 2131694532;
    int m = 2130843923;
    this.jdField_a_of_type_Aqic = paramaqic;
    this.c.setVisibility(8);
    int i = 2131694535;
    int n;
    int j;
    switch (paramInt1)
    {
    default: 
      k = 2131694511;
      if (paramInt2 == 1)
      {
        i = 2131694512;
        paramInt2 = 0;
        n = 2131694550;
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
        k = 2131694533;
        paramInt2 = 2131694549;
        m = 2130843928;
        j = 2131694533;
        i = 8;
        continue;
        k = 2131694534;
        paramInt2 = 2131694549;
        m = 2130843928;
        j = 2131694535;
        i = 0;
        continue;
        k = 2131694551;
        m = 2130843926;
        i = 8;
        paramInt2 = 2131694550;
        j = 2131694535;
        continue;
        k = 2131694511;
        if (paramInt2 == 1) {
          i = 2131694512;
        }
        for (;;)
        {
          n = 0;
          j = i;
          paramInt2 = 2131694550;
          i = n;
          break;
          if (paramInt2 == 0) {
            i = 2131694513;
          }
        }
        k = 2131694551;
        m = 2130843926;
        i = 8;
        paramInt2 = 2131694550;
        j = 2131694535;
        continue;
        i = 8;
        m = 2130843927;
        paramInt2 = 2131694550;
        j = 2131694532;
      }
    case 2110: 
      label157:
      m = 2130843928;
      if (paramInt2 == 1)
      {
        j = 2131694534;
        i = 2131694535;
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = paramInt2;
      paramInt2 = 2131694549;
      break label157;
      if (paramInt2 == 0)
      {
        j = 2131694533;
        i = 2131694523;
        paramInt2 = 8;
        continue;
        k = 2131694829;
        i = 8;
        j = 2131694829;
        paramInt2 = 2131694550;
        break label157;
        k = 2131694546;
        i = 8;
        j = 2131694546;
        paramInt2 = 2131694550;
        break label157;
        i = 8;
        m = 2130843927;
        paramInt2 = 2131694550;
        j = 2131694532;
        break label157;
        k = 2131691453;
        i = 8;
        m = 0;
        paramInt2 = 2131694550;
        j = 2131694535;
        break label157;
        if (paramInt2 != 0) {
          break;
        }
        i = 2131694513;
        break;
      }
      j = 2131694515;
      i = 2131694535;
      paramInt2 = 8;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aqic = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560686, null).findViewById(2131361798));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367934));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377567));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377568));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377576));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363797));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    allz localallz = (allz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equalsIgnoreCase(getResources().getString(2131694549))) {
        break label90;
      }
      this.jdField_a_of_type_Long = localallz.a().a(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aqic != null) {
        this.jdField_a_of_type_Aqic.a(this.jdField_a_of_type_Long);
      }
      return;
      label90:
      if (localallz.a().a()) {
        this.jdField_a_of_type_Long = localallz.a().a(1);
      } else {
        this.jdField_a_of_type_Long = localallz.a().a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileFailedView
 * JD-Core Version:    0.7.0.1
 */