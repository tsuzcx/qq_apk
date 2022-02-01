package com.tencent.mobileqq.profilecommon.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.profilecard.api.IProfileHandlerApi;
import com.tencent.mobileqq.profilecommon.api.IProfileCommonService;
import com.tencent.mobileqq.profilecommon.handler.ProfileCommonHandler;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.profilecommon.processor.ProfileCommonProcessorFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

public class ProfileCommonServiceImpl
  implements IProfileCommonService
{
  private static final String TAG = "ProfileCommonServiceImpl";
  private AppRuntime appRuntime;
  private ProfileCommonProcessorFactory processorFactory;
  
  private ProfileCommonHandler getProfileCommonHandler(AppRuntime paramAppRuntime)
  {
    String str = ((IProfileHandlerApi)QRoute.api(IProfileHandlerApi.class)).getProfileCommonHandler();
    return (ProfileCommonHandler)((AppInterface)paramAppRuntime).getBusinessHandler(str);
  }
  
  public static ProfileCommonServiceImpl getProfileCommonService(AppRuntime paramAppRuntime)
  {
    return (ProfileCommonServiceImpl)paramAppRuntime.getRuntimeService(IProfileCommonService.class, "all");
  }
  
  public <T extends AbsProfileCommonProcessor> T getProcessor(Class<? extends AbsProfileCommonProcessor> paramClass)
  {
    return this.processorFactory.a(paramClass);
  }
  
  public AbsProfileCommonProcessor getProcessor(String paramString)
  {
    return this.processorFactory.a(paramString);
  }
  
  public ProfileCommonProcessorFactory getProcessorFactory()
  {
    return this.processorFactory;
  }
  
  public void getProfileDetailForLogin()
  {
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    localReqBody.rpt_uint64_uins.add(Long.valueOf(this.appRuntime.getLongAccountUin()));
    Object localObject = this.processorFactory.a().iterator();
    boolean bool = false;
    while (((Iterator)localObject).hasNext()) {
      bool |= ((AbsProfileCommonProcessor)((Iterator)localObject).next()).onGetProfileDetailRequestForLogin(localReqBody);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCommonServiceImpl", 2, String.format("getProfileDetailForLogin needRequest=%s", new Object[] { Boolean.valueOf(bool) }));
    }
    if (bool)
    {
      localObject = getProfileCommonHandler(this.appRuntime);
      ((ProfileCommonHandler)localObject).sendPbReq(((ProfileCommonHandler)localObject).makeOIDBPkg("OidbSvc.0x5eb_common", 1515, 22, localReqBody.toByteArray()));
    }
  }
  
  public void notifyProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCommonServiceImpl", 2, String.format("onProcessProfileModifyPush type=%s bytesValue=%s", new Object[] { Integer.valueOf(paramInt), Arrays.toString(paramByteStringMicro.toByteArray()) }));
    }
    Iterator localIterator = this.processorFactory.a().iterator();
    while (localIterator.hasNext())
    {
      AbsProfileCommonProcessor localAbsProfileCommonProcessor = (AbsProfileCommonProcessor)localIterator.next();
      try
      {
        localAbsProfileCommonProcessor.onProcessProfileModifyPush(paramInt, paramByteStringMicro);
      }
      catch (Exception localException)
      {
        QLog.e("ProfileCommonServiceImpl", 1, "onProcessProfileModifyPush fail.", localException);
      }
    }
  }
  
  public void notifyProfileModifyPushBegin(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCommonServiceImpl", 2, String.format("onProfileModifyPushBegin uin=%s", new Object[] { Long.valueOf(paramLong) }));
    }
    Iterator localIterator = this.processorFactory.a().iterator();
    while (localIterator.hasNext())
    {
      AbsProfileCommonProcessor localAbsProfileCommonProcessor = (AbsProfileCommonProcessor)localIterator.next();
      try
      {
        localAbsProfileCommonProcessor.onProcessProfileModifyPushBegin(paramLong);
      }
      catch (Exception localException)
      {
        QLog.e("ProfileCommonServiceImpl", 1, "onProfileModifyPushBegin fail.", localException);
      }
    }
  }
  
  public void notifyProfileModifyPushEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCommonServiceImpl", 2, "onProfileModifyPushEnd");
    }
    Iterator localIterator = this.processorFactory.a().iterator();
    while (localIterator.hasNext())
    {
      AbsProfileCommonProcessor localAbsProfileCommonProcessor = (AbsProfileCommonProcessor)localIterator.next();
      try
      {
        localAbsProfileCommonProcessor.onProcessProfileModifyPushEnd();
      }
      catch (Exception localException)
      {
        QLog.e("ProfileCommonServiceImpl", 1, "onProfileModifyPushEnd fail.", localException);
      }
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.appRuntime = paramAppRuntime;
    this.processorFactory = new ProfileCommonProcessorFactory(paramAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void responseGetProfileDetail(Bundle paramBundle, boolean paramBoolean, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCommonServiceImpl", 2, String.format("responseGetProfileDetail extras=%s success=%s udcUinData=%s", new Object[] { paramBundle, Boolean.valueOf(paramBoolean), paramUdcUinData }));
    }
    Object localObject = paramBundle.getString("processor_key");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = this.processorFactory.a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsProfileCommonProcessor localAbsProfileCommonProcessor = (AbsProfileCommonProcessor)((Iterator)localObject).next();
        try
        {
          localAbsProfileCommonProcessor.onGetProfileDetailResponse(paramBundle, paramBoolean, paramUdcUinData);
        }
        catch (Exception localException)
        {
          QLog.e("ProfileCommonServiceImpl", 1, "responseGetProfileDetail fail.", localException);
        }
      }
    }
    localObject = getProcessor((String)localObject);
    if (localObject != null) {
      try
      {
        ((AbsProfileCommonProcessor)localObject).onGetProfileDetailResponse(paramBundle, paramBoolean, paramUdcUinData);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("ProfileCommonServiceImpl", 1, "responseGetProfileDetail fail.", paramBundle);
      }
    }
  }
  
  public void responseSetProfileDetail(Bundle paramBundle, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCommonServiceImpl", 2, String.format("responseSetProfileDetail extras=%s success=%s", new Object[] { paramBundle, Boolean.valueOf(paramBoolean) }));
    }
    Object localObject = paramBundle.getString("processor_key");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = getProcessor((String)localObject);
      if (localObject != null) {
        try
        {
          ((AbsProfileCommonProcessor)localObject).onSetProfileDetailResponse(paramBundle, paramBoolean);
          return;
        }
        catch (Exception paramBundle)
        {
          QLog.e("ProfileCommonServiceImpl", 1, "responseSetProfileDetail fail.", paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.api.impl.ProfileCommonServiceImpl
 * JD-Core Version:    0.7.0.1
 */