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
import ansr;
import asze;
import blzs;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
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
  private asze jdField_a_of_type_Asze;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TextView b;
  TextView c;
  
  public MPFileFailedView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, asze paramasze, int paramInt1, int paramInt2)
  {
    int k = 2131694107;
    int m = 2130844356;
    this.jdField_a_of_type_Asze = paramasze;
    this.c.setVisibility(8);
    int i = 2131694110;
    int n;
    int j;
    switch (paramInt1)
    {
    default: 
      k = 2131694086;
      if (paramInt2 == 1)
      {
        i = 2131694087;
        paramInt2 = 0;
        n = 2131694125;
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
        k = 2131694108;
        paramInt2 = 2131694124;
        m = 2130844361;
        j = 2131694108;
        i = 8;
        continue;
        k = 2131694109;
        paramInt2 = 2131694124;
        m = 2130844361;
        j = 2131694110;
        i = 0;
        continue;
        k = 2131694126;
        m = 2130844359;
        i = 8;
        paramInt2 = 2131694125;
        j = 2131694110;
        continue;
        k = 2131694086;
        if (paramInt2 == 1) {
          i = 2131694087;
        }
        for (;;)
        {
          n = 0;
          j = i;
          paramInt2 = 2131694125;
          i = n;
          break;
          if (paramInt2 == 0) {
            i = 2131694088;
          }
        }
        k = 2131694126;
        m = 2130844359;
        i = 8;
        paramInt2 = 2131694125;
        j = 2131694110;
        continue;
        i = 8;
        m = 2130844360;
        paramInt2 = 2131694125;
        j = 2131694107;
      }
    case 2110: 
      label157:
      m = 2130844361;
      if (paramInt2 == 1)
      {
        j = 2131694109;
        i = 2131694110;
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = paramInt2;
      paramInt2 = 2131694124;
      break label157;
      if (paramInt2 == 0)
      {
        j = 2131694108;
        i = 2131694098;
        paramInt2 = 8;
        continue;
        k = 2131694305;
        i = 8;
        j = 2131694305;
        paramInt2 = 2131694125;
        break label157;
        k = 2131694121;
        i = 8;
        j = 2131694121;
        paramInt2 = 2131694125;
        break label157;
        i = 8;
        m = 2130844360;
        paramInt2 = 2131694125;
        j = 2131694107;
        break label157;
        k = 2131691361;
        i = 8;
        m = 0;
        paramInt2 = 2131694125;
        j = 2131694110;
        break label157;
        if (paramInt2 != 0) {
          break;
        }
        i = 2131694088;
        break;
      }
      j = 2131694090;
      i = 2131694110;
      paramInt2 = 8;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Asze = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560880, null).findViewById(2131361799));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368525));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378673));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378674));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378682));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364130));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    ansr localansr = (ansr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equalsIgnoreCase(getResources().getString(2131694124))) {
        break label98;
      }
      this.jdField_a_of_type_Long = localansr.a().a(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Asze != null) {
        this.jdField_a_of_type_Asze.a(this.jdField_a_of_type_Long);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label98:
      if (localansr.a().a()) {
        this.jdField_a_of_type_Long = localansr.a().a(1);
      } else {
        this.jdField_a_of_type_Long = localansr.a().a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileFailedView
 * JD-Core Version:    0.7.0.1
 */