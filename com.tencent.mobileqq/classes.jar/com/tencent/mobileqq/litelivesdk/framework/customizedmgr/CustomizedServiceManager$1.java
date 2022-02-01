package com.tencent.mobileqq.litelivesdk.framework.customizedmgr;

import android.os.Bundle;
import com.tencent.ilive.base.bizmodule.BizModulesBuilder;
import com.tencent.ilive.base.bizmodule.BootBizModules;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules;
import java.util.Map;

class CustomizedServiceManager$1
  implements BizModulesBuilder
{
  CustomizedServiceManager$1(CustomizedServiceManager paramCustomizedServiceManager, int paramInt, Map paramMap) {}
  
  public BootBizModules build(Bundle paramBundle)
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 7) {
      try
      {
        paramBundle = new CustomAudienceRoomBizModules((BaseSDKPageBizBootModules)((Class)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i))).newInstance());
        return paramBundle;
      }
      catch (InstantiationException paramBundle)
      {
        paramBundle.printStackTrace();
        return null;
      }
      catch (IllegalAccessException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.customizedmgr.CustomizedServiceManager.1
 * JD-Core Version:    0.7.0.1
 */