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
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;

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
    if (jdField_a_of_type_ComTencentMobileqqStructmsgAIOVideoPlayController == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqStructmsgAIOVideoPlayController == null) {
          jdField_a_of_type_ComTencentMobileqqStructmsgAIOVideoPlayController = new AIOVideoPlayController();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqStructmsgAIOVideoPlayController;
  }
  
  private boolean b()
  {
    AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean localAIOVideoPlayConfigBean = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean;
    if (localAIOVideoPlayConfigBean != null) {
      return localAIOVideoPlayConfigBean.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  private boolean c()
  {
    AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean localAIOVideoPlayConfigBean = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean;
    if (localAIOVideoPlayConfigBean != null) {
      return localAIOVideoPlayConfigBean.b;
    }
    return false;
  }
  
  private boolean d()
  {
    AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean localAIOVideoPlayConfigBean = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean;
    if (localAIOVideoPlayConfigBean != null) {
      return localAIOVideoPlayConfigBean.c;
    }
    return false;
  }
  
  private boolean e()
  {
    AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean localAIOVideoPlayConfigBean = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessAIOVideoPlayConfigProcessor$AIOVideoPlayConfigBean;
    if (localAIOVideoPlayConfigBean != null) {
      return localAIOVideoPlayConfigBean.d;
    }
    return false;
  }
  
  public void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    paramView = (PAVideoView)paramView.findViewById(2131377982);
    if (paramView != null) {
      paramView.c();
    }
  }
  
  public boolean a()
  {
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_gifplay.name(), null);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isAllowDPC(): parseConfig, aio_gifplay =");
        localStringBuilder.append((String)localObject);
        QLog.d("AIOVideoPlayController", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 8) {}
      }
    }
    try
    {
      if (Integer.parseInt(localObject[7]) == 0) {
        this.c = false;
      } else {
        this.c = true;
      }
      if (Integer.parseInt(localObject[9]) == 0) {
        this.b = false;
      } else {
        this.b = true;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    catch (Exception localException)
    {
      label140:
      break label140;
    }
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isAllowDPC(): mDPCAllow =");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", mEnbleAutoPlayInNotPAAIO = ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("AIOVideoPlayController", 2, ((StringBuilder)localObject).toString());
    }
    return this.c;
  }
  
  public boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    boolean bool2 = a();
    boolean bool1 = true;
    if (bool2)
    {
      if ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime() == null) {
        return false;
      }
      if (paramInt1 == 3)
      {
        if ((NetworkUtils.isWifiConnected(paramContext)) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getVideoStructMsgPlaySwitch())) {
          break label118;
        }
      }
      else
      {
        if (paramInt1 == 1)
        {
          if (paramInt2 == 1)
          {
            bool1 = b();
            break label118;
          }
          bool1 = c();
          break label118;
        }
        if (paramInt1 == 2)
        {
          if (paramInt2 == 1)
          {
            bool1 = d();
            break label118;
          }
          bool1 = e();
          break label118;
        }
      }
    }
    bool1 = false;
    label118:
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("allowAutoPlay(): playType=");
      paramContext.append(paramInt1);
      paramContext.append(", uinType = ");
      paramContext.append(paramInt2);
      paramContext.append(", result = ");
      paramContext.append(bool1);
      paramContext.append(", mDPCAllow = ");
      paramContext.append(this.c);
      QLog.d("AIOVideoPlayController", 2, paramContext.toString());
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AIOVideoPlayController
 * JD-Core Version:    0.7.0.1
 */