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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  private MPFileFailedView.MPFileFailedEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent = null;
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
    int k = 2131694309;
    int m = 2130844546;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent = paramMPFileFailedEvent;
    this.c.setVisibility(8);
    int i = 2131694312;
    int n;
    int j;
    switch (paramInt1)
    {
    default: 
      k = 2131694288;
      if (paramInt2 == 1)
      {
        i = 2131694289;
        paramInt2 = 0;
        n = 2131694327;
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
        k = 2131694310;
        paramInt2 = 2131694326;
        m = 2130844551;
        j = 2131694310;
        i = 8;
        continue;
        k = 2131694311;
        paramInt2 = 2131694326;
        m = 2130844551;
        j = 2131694312;
        i = 0;
        continue;
        k = 2131694328;
        m = 2130844549;
        i = 8;
        paramInt2 = 2131694327;
        j = 2131694312;
        continue;
        k = 2131694288;
        if (paramInt2 == 1) {
          i = 2131694289;
        }
        for (;;)
        {
          n = 0;
          j = i;
          paramInt2 = 2131694327;
          i = n;
          break;
          if (paramInt2 == 0) {
            i = 2131694290;
          }
        }
        k = 2131694328;
        m = 2130844549;
        i = 8;
        paramInt2 = 2131694327;
        j = 2131694312;
        continue;
        i = 8;
        m = 2130844550;
        paramInt2 = 2131694327;
        j = 2131694309;
      }
    case 2110: 
      label157:
      m = 2130844551;
      if (paramInt2 == 1)
      {
        j = 2131694311;
        i = 2131694312;
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = paramInt2;
      paramInt2 = 2131694326;
      break label157;
      if (paramInt2 == 0)
      {
        j = 2131694310;
        i = 2131694300;
        paramInt2 = 8;
        continue;
        k = 2131694510;
        i = 8;
        j = 2131694510;
        paramInt2 = 2131694327;
        break label157;
        k = 2131694323;
        i = 8;
        j = 2131694323;
        paramInt2 = 2131694327;
        break label157;
        i = 8;
        m = 2130844550;
        paramInt2 = 2131694327;
        j = 2131694309;
        break label157;
        k = 2131691471;
        i = 8;
        m = 0;
        paramInt2 = 2131694327;
        j = 2131694312;
        break label157;
        if (paramInt2 != 0) {
          break;
        }
        i = 2131694290;
        break;
      }
      j = 2131694292;
      i = 2131694312;
      paramInt2 = 8;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560971, null).findViewById(2131361799));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368755));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379106));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379107));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379115));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364233));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equalsIgnoreCase(getResources().getString(2131694326))) {
        break label98;
      }
      this.jdField_a_of_type_Long = localDataLineHandler.a().a(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent.a(this.jdField_a_of_type_Long);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label98:
      if (localDataLineHandler.a().a()) {
        this.jdField_a_of_type_Long = localDataLineHandler.a().a(1);
      } else {
        this.jdField_a_of_type_Long = localDataLineHandler.a().a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileFailedView
 * JD-Core Version:    0.7.0.1
 */