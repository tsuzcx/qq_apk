package com.tencent.mobileqq.qqlive.api.impl.gift;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftEntranceService;
import com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qlive.config_center_svr.config_center_svr.nano.VerifyGiftReq;

public class QQLiveGiftEntranceServiceImpl
  implements IQQLiveGiftEntranceService
{
  public static final int EPANEL_GAME = 2;
  public static final int EPANEL_NONE = 0;
  public static final int EPANEL_VIDEO = 1;
  protected static final String NEED_SHOW_GIFT_ICON = "trpc.qlive.config_center_svr.ConfigCenterSvr";
  protected static final String NEED_SHOW_GIFT_ICON_METHOD = "VerifyGift";
  public static final int ROOM_TYPE_GAME = 1;
  public static final int ROOM_TYPE_OTHER = 0;
  private static final String TAG = "QQLiveGiftEntranceServiceImpl";
  private IQQLiveSDK sdkImpl;
  
  public void destroy() {}
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.sdkImpl = paramIQQLiveSDK;
  }
  
  public void needShowGiftIcon(long paramLong, int paramInt1, int paramInt2, String paramString, OnQueryGiftIconCallback paramOnQueryGiftIconCallback)
  {
    IQQLiveSsoModule localIQQLiveSsoModule = (IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module");
    if (localIQQLiveSsoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQLiveGiftEntranceServiceImpl", 4, "get IQQLiveRoomPushService null");
      }
      return;
    }
    VerifyGiftReq localVerifyGiftReq = new VerifyGiftReq();
    localVerifyGiftReq.a = String.valueOf(paramLong);
    if (paramInt1 == 0) {
      localVerifyGiftReq.b = 1;
    } else if (paramInt1 == 1) {
      localVerifyGiftReq.b = 2;
    } else {
      localVerifyGiftReq.b = 0;
    }
    localVerifyGiftReq.c = paramInt2;
    localVerifyGiftReq.d = paramString;
    localIQQLiveSsoModule.a("trpc.qlive.config_center_svr.ConfigCenterSvr", "VerifyGift", VerifyGiftReq.toByteArray(localVerifyGiftReq), new QQLiveGiftEntranceServiceImpl.1(this, paramOnQueryGiftIconCallback));
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.gift.QQLiveGiftEntranceServiceImpl
 * JD-Core Version:    0.7.0.1
 */