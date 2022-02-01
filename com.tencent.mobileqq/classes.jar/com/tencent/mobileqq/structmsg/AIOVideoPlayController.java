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
  private static AIOVideoPlayController c;
  public boolean a = false;
  @Deprecated
  public boolean b = false;
  private AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean d;
  private boolean e = false;
  
  private AIOVideoPlayController()
  {
    ThreadManager.executeOnSubThread(new AIOVideoPlayController.1(this));
  }
  
  public static AIOVideoPlayController a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new AIOVideoPlayController();
        }
      }
      finally {}
    }
    return c;
  }
  
  private boolean c()
  {
    AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean localAIOVideoPlayConfigBean = this.d;
    if (localAIOVideoPlayConfigBean != null) {
      return localAIOVideoPlayConfigBean.a;
    }
    return false;
  }
  
  private boolean d()
  {
    AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean localAIOVideoPlayConfigBean = this.d;
    if (localAIOVideoPlayConfigBean != null) {
      return localAIOVideoPlayConfigBean.b;
    }
    return false;
  }
  
  private boolean e()
  {
    AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean localAIOVideoPlayConfigBean = this.d;
    if (localAIOVideoPlayConfigBean != null) {
      return localAIOVideoPlayConfigBean.c;
    }
    return false;
  }
  
  private boolean f()
  {
    AIOVideoPlayConfigProcessor.AIOVideoPlayConfigBean localAIOVideoPlayConfigBean = this.d;
    if (localAIOVideoPlayConfigBean != null) {
      return localAIOVideoPlayConfigBean.d;
    }
    return false;
  }
  
  public void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    paramView = (PAVideoView)paramView.findViewById(2131446469);
    if (paramView != null) {
      paramView.d();
    }
  }
  
  public boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    boolean bool2 = b();
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
            bool1 = c();
            break label118;
          }
          bool1 = d();
          break label118;
        }
        if (paramInt1 == 2)
        {
          if (paramInt2 == 1)
          {
            bool1 = e();
            break label118;
          }
          bool1 = f();
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
      paramContext.append(this.e);
      QLog.d("AIOVideoPlayController", 2, paramContext.toString());
    }
    return bool1;
  }
  
  public boolean b()
  {
    Object localObject;
    if (!this.a)
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
        this.e = false;
      } else {
        this.e = true;
      }
      if (Integer.parseInt(localObject[9]) == 0) {
        this.b = false;
      } else {
        this.b = true;
      }
      this.a = true;
    }
    catch (Exception localException)
    {
      label140:
      break label140;
    }
    this.a = false;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isAllowDPC(): mDPCAllow =");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(", mEnbleAutoPlayInNotPAAIO = ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("AIOVideoPlayController", 2, ((StringBuilder)localObject).toString());
    }
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AIOVideoPlayController
 * JD-Core Version:    0.7.0.1
 */