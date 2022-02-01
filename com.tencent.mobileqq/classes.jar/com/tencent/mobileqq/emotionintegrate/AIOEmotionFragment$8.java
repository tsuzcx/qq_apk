package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.QueryCallback;

class AIOEmotionFragment$8
  implements QueryCallback<EmoticonPackage>
{
  AIOEmotionFragment$8(AIOEmotionFragment paramAIOEmotionFragment, QQAppInterface paramQQAppInterface) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null)
    {
      AIOEmotionFragment.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7);
      return;
    }
    MarketFaceItemBuilder.a(7, this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.b, this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.8
 * JD-Core Version:    0.7.0.1
 */