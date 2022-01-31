package com.tencent.mobileqq.filemanager.activity;

import alqo;
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
import aqml;
import biup;
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
  private aqml jdField_a_of_type_Aqml;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TextView b;
  TextView c;
  
  public MPFileFailedView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, aqml paramaqml, int paramInt1, int paramInt2)
  {
    int k = 2131694534;
    int m = 2130843995;
    this.jdField_a_of_type_Aqml = paramaqml;
    this.c.setVisibility(8);
    int i = 2131694537;
    int n;
    int j;
    switch (paramInt1)
    {
    default: 
      k = 2131694513;
      if (paramInt2 == 1)
      {
        i = 2131694514;
        paramInt2 = 0;
        n = 2131694552;
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
        k = 2131694535;
        paramInt2 = 2131694551;
        m = 2130844000;
        j = 2131694535;
        i = 8;
        continue;
        k = 2131694536;
        paramInt2 = 2131694551;
        m = 2130844000;
        j = 2131694537;
        i = 0;
        continue;
        k = 2131694553;
        m = 2130843998;
        i = 8;
        paramInt2 = 2131694552;
        j = 2131694537;
        continue;
        k = 2131694513;
        if (paramInt2 == 1) {
          i = 2131694514;
        }
        for (;;)
        {
          n = 0;
          j = i;
          paramInt2 = 2131694552;
          i = n;
          break;
          if (paramInt2 == 0) {
            i = 2131694515;
          }
        }
        k = 2131694553;
        m = 2130843998;
        i = 8;
        paramInt2 = 2131694552;
        j = 2131694537;
        continue;
        i = 8;
        m = 2130843999;
        paramInt2 = 2131694552;
        j = 2131694534;
      }
    case 2110: 
      label157:
      m = 2130844000;
      if (paramInt2 == 1)
      {
        j = 2131694536;
        i = 2131694537;
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = paramInt2;
      paramInt2 = 2131694551;
      break label157;
      if (paramInt2 == 0)
      {
        j = 2131694535;
        i = 2131694525;
        paramInt2 = 8;
        continue;
        k = 2131694831;
        i = 8;
        j = 2131694831;
        paramInt2 = 2131694552;
        break label157;
        k = 2131694548;
        i = 8;
        j = 2131694548;
        paramInt2 = 2131694552;
        break label157;
        i = 8;
        m = 2130843999;
        paramInt2 = 2131694552;
        j = 2131694534;
        break label157;
        k = 2131691454;
        i = 8;
        m = 0;
        paramInt2 = 2131694552;
        j = 2131694537;
        break label157;
        if (paramInt2 != 0) {
          break;
        }
        i = 2131694515;
        break;
      }
      j = 2131694517;
      i = 2131694537;
      paramInt2 = 8;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aqml = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560704, null).findViewById(2131361798));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367945));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377621));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377622));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377630));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363799));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    alqo localalqo = (alqo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equalsIgnoreCase(getResources().getString(2131694551))) {
        break label90;
      }
      this.jdField_a_of_type_Long = localalqo.a().a(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aqml != null) {
        this.jdField_a_of_type_Aqml.a(this.jdField_a_of_type_Long);
      }
      return;
      label90:
      if (localalqo.a().a()) {
        this.jdField_a_of_type_Long = localalqo.a().a(1);
      } else {
        this.jdField_a_of_type_Long = localalqo.a().a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileFailedView
 * JD-Core Version:    0.7.0.1
 */