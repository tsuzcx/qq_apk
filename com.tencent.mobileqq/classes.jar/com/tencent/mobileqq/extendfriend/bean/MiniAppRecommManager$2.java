package com.tencent.mobileqq.extendfriend.bean;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class MiniAppRecommManager$2
  implements MiniAppCmdInterface
{
  MiniAppRecommManager$2(MiniAppRecommManager paramMiniAppRecommManager, MiniAppRecommManager.OnMiniAppRequestListener paramOnMiniAppRequestListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.opt("data");
      if ((paramJSONObject instanceof MiniAppRecommInfo))
      {
        MiniAppRecommManager.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommManager, (MiniAppRecommInfo)paramJSONObject);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommManager.a(MiniAppRecommManager.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommManager));
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommManager$OnMiniAppRequestListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommManager$OnMiniAppRequestListener.a(true, MiniAppRecommManager.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommManager));
        }
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommManager$OnMiniAppRequestListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommManager$OnMiniAppRequestListener.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.MiniAppRecommManager.2
 * JD-Core Version:    0.7.0.1
 */