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
  private static final Object a = new Object();
  private static ILiveSDK b = null;
  
  private LiteSDKForImmutableProcess()
  {
    if (!QQVideoPlaySDKManager.isSDKReady()) {
      QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getContext(), this);
    }
  }
  
  public static ILiveSDK f()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new LiteSDKForImmutableProcess();
        }
      }
    }
    return b;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ((BusinessManager.a.b() != null) && (BusinessManager.a.b().a.equals(paramString1))) {
      RoomManager.a(BaseApplicationImpl.getContext(), paramString2);
    } else {
      BusinessManager.a.c(paramString1).a(new LiteSDKForImmutableProcess.1(this, paramString2));
    }
    return true;
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    LogInterface localLogInterface = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("======onSDKInited:  ");
    localStringBuilder.append(paramBoolean);
    localLogInterface.e("LiteSDKForImmutableProcess", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.LiteSDKForImmutableProcess
 * JD-Core Version:    0.7.0.1
 */