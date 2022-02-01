package com.tencent.mobileqq.litelivesdk.sdkimpl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.litelivesdk.api.IBusinessExpireObserver;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.room.RoomManager;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;

public class LiteSDKForImmutableProcess
  extends BaseLiteSDKImpl
  implements SDKInitListener
{
  private static ILiveSDK jdField_a_of_type_ComTencentMobileqqLitelivesdkApiILiveSDK = null;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  private LiteSDKForImmutableProcess()
  {
    if (!QQVideoPlaySDKManager.a()) {
      QQVideoPlaySDKManager.a(BaseApplicationImpl.getContext(), this);
    }
  }
  
  public static ILiveSDK a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLitelivesdkApiILiveSDK == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqLitelivesdkApiILiveSDK == null) {
        jdField_a_of_type_ComTencentMobileqqLitelivesdkApiILiveSDK = new LiteSDKForImmutableProcess();
      }
      return jdField_a_of_type_ComTencentMobileqqLitelivesdkApiILiveSDK;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ((BusinessManager.a.a() != null) && (BusinessManager.a.a().a.equals(paramString1))) {
      RoomManager.a(BaseApplicationImpl.getContext(), paramString2);
    }
    for (;;)
    {
      return true;
      BusinessManager.a.a(paramString1).a(new LiteSDKForImmutableProcess.1(this, paramString2));
    }
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    LogFactory.a().e("LiteSDKForImmutableProcess", "======onSDKInited:  " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.LiteSDKForImmutableProcess
 * JD-Core Version:    0.7.0.1
 */