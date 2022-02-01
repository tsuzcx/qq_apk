package com.tencent.mobileqq.qqlive.plugin;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.view.IQQGiftViewModule;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig.Builder;
import com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.util.GiftAnimDataUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QQLiveAnchorPluginGiftWrapper
  implements IQQLiveAnchorPluginGiftWrapper
{
  public static final String TAG = "QQLiveAnchor_GiftWrapper";
  private IQQGiftAnimationEngine giftAnimationEngine;
  private IQQGiftSDK giftSDK;
  private int mainPushCmd;
  private int subPushCmd;
  
  public QQLiveAnchorPluginGiftWrapper()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_GiftWrapper", 1, "create");
    }
  }
  
  public void destroy(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_GiftWrapper", 1, "destroy");
    }
    try
    {
      this.giftAnimationEngine.c();
      this.giftSDK.j();
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQLiveAnchor_GiftWrapper", 1, paramContext, new Object[0]);
    }
  }
  
  public View getBannerView(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_GiftWrapper", 1, "getBannerView");
    }
    paramContext = this.giftAnimationEngine;
    if (paramContext == null) {
      return null;
    }
    return paramContext.f();
  }
  
  public View getGiftAnimationView(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_GiftWrapper", 1, "getGiftAnimationView");
    }
    paramContext = this.giftAnimationEngine;
    if (paramContext == null) {
      return null;
    }
    return paramContext.e();
  }
  
  public int getGiftPushCmd()
  {
    return ((IQQLivePushCmdHelper)QRoute.api(IQQLivePushCmdHelper.class)).getHighPriorityPushCmd("1037");
  }
  
  public int getGiftPushSubCmd()
  {
    return ((IQQLivePushCmdHelper)QRoute.api(IQQLivePushCmdHelper.class)).getGiftPushSubCmd("1037");
  }
  
  public void init(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_GiftWrapper", 1, "init");
    }
    this.mainPushCmd = ((IQQLivePushCmdHelper)QRoute.api(IQQLivePushCmdHelper.class)).getHighPriorityPushCmd("1037");
    this.subPushCmd = ((IQQLivePushCmdHelper)QRoute.api(IQQLivePushCmdHelper.class)).getGiftPushSubCmd("1037");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cmd info， mainCmd=");
      ((StringBuilder)localObject).append(this.mainPushCmd);
      ((StringBuilder)localObject).append("， subCmd=");
      ((StringBuilder)localObject).append(this.subPushCmd);
      QLog.d("QQLiveAnchor_GiftWrapper", 1, ((StringBuilder)localObject).toString());
    }
    this.giftSDK = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(10001);
    if (!this.giftSDK.a())
    {
      localObject = QQGiftSDKConfig.a().a(10001).a("2ba343368f5483089089ae290adf298f").a();
      this.giftSDK.a(MobileQQ.sMobileQQ.waitAppRuntime(null), (QQGiftSDKConfig)localObject);
    }
    this.giftAnimationEngine = this.giftSDK.e().a(paramContext);
    this.giftAnimationEngine.a();
    this.giftAnimationEngine.a(new QQLiveAnchorPluginGiftWrapper.1(this));
  }
  
  public void receivePushMsg(int paramInt, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("receiveMsg: ");
      localStringBuilder.append(paramInt);
      QLog.d("QQLiveAnchor_GiftWrapper", 1, localStringBuilder.toString());
    }
    if (paramInt != this.mainPushCmd)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("cmd diff, ");
        paramArrayOfByte.append(this.mainPushCmd);
        paramArrayOfByte.append(" : ");
        paramArrayOfByte.append(paramInt);
        QLog.d("QQLiveAnchor_GiftWrapper", 1, paramArrayOfByte.toString());
      }
      return;
    }
    try
    {
      paramArrayOfByte = ((IQQLivePushCmdHelper)QRoute.api(IQQLivePushCmdHelper.class)).covertPushDataToGiftMessage(this.mainPushCmd, this.subPushCmd, paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLiveAnchor_GiftWrapper", 1, "giftMessage is null");
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("receive gift, start play: ");
          localStringBuilder.append(paramArrayOfByte.toString());
          QLog.d("QQLiveAnchor_GiftWrapper", 1, localStringBuilder.toString());
        }
        paramArrayOfByte = GiftAnimDataUtil.a(paramArrayOfByte);
        if (paramArrayOfByte == null)
        {
          QLog.e("QQLiveAnchor_GiftWrapper", 1, "receivePushMsg, anim is null");
          return;
        }
        this.giftAnimationEngine.b(paramArrayOfByte);
        return;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQLiveAnchor_GiftWrapper", 1, paramArrayOfByte, new Object[0]);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.plugin.QQLiveAnchorPluginGiftWrapper
 * JD-Core Version:    0.7.0.1
 */