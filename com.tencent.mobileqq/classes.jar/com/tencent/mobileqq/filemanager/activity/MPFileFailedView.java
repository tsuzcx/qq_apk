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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent = paramMPFileFailedEvent;
    this.c.setVisibility(8);
    int i = 2131694475;
    int j = 2131694291;
    int k = 2131694277;
    int m = 2130844452;
    if (paramInt1 != 1001)
    {
      if (paramInt1 != 1003) {
        if (paramInt1 != 1010)
        {
          if (paramInt1 != 1101)
          {
            if (paramInt1 != 2107)
            {
              if (paramInt1 == 2109) {
                break label304;
              }
              if (paramInt1 == 2110) {}
            }
            else
            {
              switch (paramInt1)
              {
              default: 
                if (paramInt2 == 1) {
                  paramInt2 = 2131694254;
                } else {
                  if (paramInt2 != 0) {
                    break;
                  }
                }
              case 2004: 
                for (;;)
                {
                  paramInt2 = 2131694255;
                  do
                  {
                    paramInt2 = 2131694277;
                    k = paramInt2;
                    paramInt2 = 0;
                    i = 2131694253;
                    j = 2131694292;
                    break label343;
                    if (paramInt2 == 1) {
                      break;
                    }
                  } while (paramInt2 != 0);
                }
              case 2003: 
                i = 2131694276;
                paramInt2 = 0;
                break;
              case 2002: 
                i = 2131694293;
                paramInt2 = 8;
                j = 2131694292;
                m = 2130844455;
                break;
              }
              paramInt2 = 8;
              i = 2131694275;
              k = 2131694275;
            }
            for (;;)
            {
              m = 2130844457;
              break;
              if (paramInt2 == 1)
              {
                paramInt2 = 0;
                i = 2131694276;
              }
              else if (paramInt2 == 0)
              {
                paramInt2 = 8;
                i = 2131694275;
                k = 2131694265;
              }
              else
              {
                paramInt2 = 8;
                i = 2131694257;
              }
            }
          }
          else
          {
            i = 2131691393;
            paramInt2 = 8;
            j = 2131694292;
            m = 0;
            break label343;
          }
        }
        else
        {
          paramInt2 = 8;
          j = 2131694292;
          k = 2131694475;
          break label343;
        }
      }
      label304:
      paramInt2 = 8;
      i = 2131694274;
      j = 2131694292;
      k = 2131694274;
      m = 2130844456;
    }
    else
    {
      paramInt2 = 8;
      i = 2131694288;
      j = 2131694292;
      k = 2131694288;
    }
    label343:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(m);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(i);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.b.setText(k);
    this.b.setVisibility(paramInt2);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setText(j);
    if (7 == paramInt1) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560846, null).findViewById(2131361802));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368487));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378476));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378477));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378485));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364150));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    Object localObject = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (paramView == localButton) {
      if (localButton.getText().toString().equalsIgnoreCase(getResources().getString(2131694291))) {
        this.jdField_a_of_type_Long = ((DataLineHandler)localObject).a().a(0);
      } else if (((DataLineHandler)localObject).a().a()) {
        this.jdField_a_of_type_Long = ((DataLineHandler)localObject).a().a(1);
      } else {
        this.jdField_a_of_type_Long = ((DataLineHandler)localObject).a().a(2);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent;
    if (localObject != null) {
      ((MPFileFailedView.MPFileFailedEvent)localObject).a(this.jdField_a_of_type_Long);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileFailedView
 * JD-Core Version:    0.7.0.1
 */