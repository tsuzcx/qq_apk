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
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

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
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MPFileFailedView.MPFileFailedEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent;
  TextView b;
  TextView c;
  
  public MPFileFailedView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, MPFileFailedView.MPFileFailedEvent paramMPFileFailedEvent, int paramInt1, int paramInt2)
  {
    int k = 2131427629;
    int m = 2130841647;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent = paramMPFileFailedEvent;
    this.c.setVisibility(8);
    int i = 2131427638;
    int n;
    int j;
    switch (paramInt1)
    {
    default: 
      k = 2131427647;
      if (paramInt2 == 1)
      {
        i = 2131427648;
        paramInt2 = 0;
        n = 2131427611;
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
        k = 2131427632;
        paramInt2 = 2131427636;
        m = 2130841652;
        j = 2131427632;
        i = 8;
        continue;
        k = 2131427637;
        paramInt2 = 2131427636;
        m = 2130841652;
        j = 2131427638;
        i = 0;
        continue;
        k = 2131427627;
        m = 2130841650;
        i = 8;
        paramInt2 = 2131427611;
        j = 2131427638;
        continue;
        k = 2131427647;
        if (paramInt2 == 1) {
          i = 2131427648;
        }
        for (;;)
        {
          n = 0;
          j = i;
          paramInt2 = 2131427611;
          i = n;
          break;
          if (paramInt2 == 0) {
            i = 2131427649;
          }
        }
        k = 2131427627;
        m = 2130841650;
        i = 8;
        paramInt2 = 2131427611;
        j = 2131427638;
        continue;
        i = 8;
        m = 2130841651;
        paramInt2 = 2131427611;
        j = 2131427629;
      }
    case 2110: 
      label157:
      m = 2130841652;
      if (paramInt2 == 1)
      {
        j = 2131427637;
        i = 2131427638;
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = paramInt2;
      paramInt2 = 2131427636;
      break label157;
      if (paramInt2 == 0)
      {
        j = 2131427632;
        i = 2131427662;
        paramInt2 = 8;
        continue;
        k = 2131434596;
        i = 8;
        j = 2131434596;
        paramInt2 = 2131427611;
        break label157;
        k = 2131427616;
        i = 8;
        j = 2131427616;
        paramInt2 = 2131427611;
        break label157;
        i = 8;
        m = 2130841651;
        paramInt2 = 2131427611;
        j = 2131427629;
        break label157;
        k = 2131427760;
        i = 8;
        m = 0;
        paramInt2 = 2131427611;
        j = 2131427638;
        break label157;
        if (paramInt2 != 0) {
          break;
        }
        i = 2131427649;
        break;
      }
      j = 2131427643;
      i = 2131427638;
      paramInt2 = 8;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2130970040, null).findViewById(2131368832));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363678));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362943));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367937));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368833));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368834));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equalsIgnoreCase(getResources().getString(2131427636))) {
        break label90;
      }
      this.jdField_a_of_type_Long = localDataLineHandler.a().a(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent.a(this.jdField_a_of_type_Long);
      }
      return;
      label90:
      if (localDataLineHandler.a().a()) {
        this.jdField_a_of_type_Long = localDataLineHandler.a().a(1);
      } else {
        this.jdField_a_of_type_Long = localDataLineHandler.a().a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileFailedView
 * JD-Core Version:    0.7.0.1
 */