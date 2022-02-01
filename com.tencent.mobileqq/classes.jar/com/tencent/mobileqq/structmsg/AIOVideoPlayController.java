package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class AIOVideoPlayController
{
  private static AIOVideoPlayController jdField_a_of_type_ComTencentMobileqqStructmsgAIOVideoPlayController;
  private AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean jdField_a_of_type_ComTencentMobileqqConfigBusinessAIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean;
  public boolean a;
  @Deprecated
  public boolean b = false;
  private boolean c = false;
  
  private AIOVideoPlayController()
  {
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.executeOnSubThread(new AIOVideoPlayController.1(this));
  }
  
  public static AIOVideoPlayController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqStructmsgAIOVideoPlayController == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStructmsgAIOVideoPlayController == null) {
        jdField_a_of_type_ComTencentMobileqqStructmsgAIOVideoPlayController = new AIOVideoPlayController();
      }
      return jdField_a_of_type_ComTencentMobileqqStructmsgAIOVideoPlayController;
    }
    finally {}
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean != null) {
      return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean != null) {
      return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean.b;
    }
    return false;
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean != null) {
      return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean.c;
    }
    return false;
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean != null) {
      return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean.d;
    }
    return false;
  }
  
  public void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    paramView = (PAVideoView)paramView.findViewById(2131378571);
    if (paramView != null) {
      paramView.c();
    }
  }
  
  public void a(AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean paramAIOVideoPlayConfigBean)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean = paramAIOVideoPlayConfigBean;
  }
  
  public boolean a()
  {
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_gifplay.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayController", 2, "isAllowDPC(): parseConfig, aio_gifplay =" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 8) {}
      }
    }
    for (;;)
    {
      try
      {
        if (Integer.parseInt(localObject[7]) != 0) {
          continue;
        }
        this.c = false;
        if (Integer.parseInt(localObject[9]) != 0) {
          continue;
        }
        this.b = false;
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_Boolean = false;
        continue;
        this.b = true;
        continue;
      }
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayController", 2, "isAllowDPC(): mDPCAllow =" + this.c + ", mEnbleAutoPlayInNotPAAIO = " + this.b);
      }
      return this.c;
      this.c = true;
    }
  }
  
  public boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (a())
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface == null) {
        return false;
      }
      if (paramInt1 == 3)
      {
        if ((!NetworkUtils.isWifiConnected(paramContext)) || (!ReadInJoyHelper.e(localQQAppInterface))) {
          break label169;
        }
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayController", 2, "allowAutoPlay(): playType=" + paramInt1 + ", uinType = " + paramInt2 + ", result = " + bool + ", mDPCAllow = " + this.c);
      }
      return bool;
      if (paramInt1 == 1)
      {
        if (paramInt2 == 1) {
          bool = b();
        } else {
          bool = c();
        }
      }
      else if (paramInt1 == 2)
      {
        if (paramInt2 == 1) {
          bool = d();
        } else {
          bool = e();
        }
      }
      else {
        label169:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AIOVideoPlayController
 * JD-Core Version:    0.7.0.1
 */