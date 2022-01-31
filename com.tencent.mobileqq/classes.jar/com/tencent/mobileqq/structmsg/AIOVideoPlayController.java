package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class AIOVideoPlayController
{
  private static AIOVideoPlayController a;
  public boolean a;
  @Deprecated
  public boolean b;
  private boolean c;
  
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
  
  public void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    paramView = (PAVideoView)paramView.findViewById(2131362177);
    if (paramView != null) {
      paramView.a();
    }
  }
  
  public boolean a()
  {
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_gifplay.name(), null);
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
    QQAppInterface localQQAppInterface;
    boolean bool;
    if (a())
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface == null) {
        return false;
      }
      if (paramInt1 == 2)
      {
        if ((!NetworkUtils.isWifiConnected(paramContext)) || (!ReadInJoyHelper.g(localQQAppInterface))) {
          break label143;
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
          bool = ReadInJoyHelper.h(localQQAppInterface);
        } else {
          bool = ReadInJoyHelper.i(localQQAppInterface);
        }
      }
      else {
        label143:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AIOVideoPlayController
 * JD-Core Version:    0.7.0.1
 */