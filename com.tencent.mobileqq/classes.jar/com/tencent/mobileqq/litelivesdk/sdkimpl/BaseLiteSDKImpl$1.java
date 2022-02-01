package com.tencent.mobileqq.litelivesdk.sdkimpl;

import android.os.Bundle;
import com.tencent.ilive.base.bizmodule.BizModulesBuilder;
import com.tencent.ilive.base.bizmodule.BootBizModules;
import com.tencent.mobileqq.litelivesdk.framework.customizedmgr.CustomAudienceRoomBizModules;
import com.tencent.mobileqq.litelivesdk.framework.customizedmgr.DefaultAudienceRoomBizBootModules;

class BaseLiteSDKImpl$1
  implements BizModulesBuilder
{
  BaseLiteSDKImpl$1(BaseLiteSDKImpl paramBaseLiteSDKImpl) {}
  
  public BootBizModules build(Bundle paramBundle)
  {
    return new CustomAudienceRoomBizModules(new DefaultAudienceRoomBizBootModules());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.BaseLiteSDKImpl.1
 * JD-Core Version:    0.7.0.1
 */