package com.tencent.mobileqq.olympic.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionMgr.GetConfigListen;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.mobileqq.utils.configsp.ARPromotionConfigSP;
import com.tencent.qphone.base.util.QLog;

class PromotionRes$1
  implements PromotionMgr.GetConfigListen
{
  PromotionRes$1(PromotionRes paramPromotionRes, String paramString, AppInterface paramAppInterface) {}
  
  public void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    Object localObject1 = PromotionRes.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getRes, promotionConfigInfo[");
    ((StringBuilder)localObject2).append(paramPromotionConfigInfo);
    ((StringBuilder)localObject2).append("], activityID[");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("], isDestroyed[");
    ((StringBuilder)localObject2).append(PromotionRes.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes));
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (PromotionRes.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes)) {
      return;
    }
    localObject2 = null;
    if (paramPromotionConfigInfo != null)
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      if (localObject1 != null) {
        localObject1 = paramPromotionConfigInfo.getItem((String)localObject1);
      } else {
        localObject1 = paramPromotionConfigInfo.getActivityItem();
      }
      String str = PromotionRes.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes).getCurrentAccountUin();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("AR_PROMOTION_ENTRY_SHOWONCE");
      int i = UniformUtils.a(((StringBuilder)localObject2).toString());
      int j = ARPromotionConfigSP.b(str);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("AR_PROMOTION_ENTRY_SERVER_VERSION");
      int k = UniformUtils.a(((StringBuilder)localObject2).toString());
      boolean bool = false;
      if ((j != k) || (j == 0))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("AR_PROMOTION_ENTRY_SERVER_VERSION");
        UniformUtils.a(((StringBuilder)localObject2).toString(), j);
        i = 0;
      }
      if ((!paramPromotionConfigInfo.showOnce) || (i == 0))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("AR_PROMOTION_ENTRY_SHOWONCE");
        UniformUtils.a(((StringBuilder)localObject2).toString(), 0);
      }
      if ((!paramPromotionConfigInfo.showOnce) || (i == 0)) {
        bool = true;
      }
      PromotionRes.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes).a(bool, paramPromotionConfigInfo.showInTopView);
      localObject2 = localObject1;
      if (bool)
      {
        localObject2 = localObject1;
        if (paramPromotionConfigInfo.showOnce)
        {
          paramPromotionConfigInfo = new StringBuilder();
          paramPromotionConfigInfo.append(str);
          paramPromotionConfigInfo.append("AR_PROMOTION_ENTRY_SHOWONCE");
          UniformUtils.a(paramPromotionConfigInfo.toString(), 1);
          localObject2 = localObject1;
        }
      }
    }
    PromotionRes.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes, this.jdField_a_of_type_ComTencentCommonAppAppInterface, (PromotionConfigInfo.PromotionItem)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionRes.1
 * JD-Core Version:    0.7.0.1
 */