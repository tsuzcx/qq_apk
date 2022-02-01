package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.QueryCallback;

class AIOEmoticonUIHelper$1$1
  implements QueryCallback<Emoticon>
{
  AIOEmoticonUIHelper$1$1(AIOEmoticonUIHelper.1 param1, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(Emoticon paramEmoticon)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqEmosmAIOEmoticonUIHelper$1.a.a();
    if (localBaseChatPie != null) {
      MarketFaceItemBuilder.a(this.jdField_a_of_type_Int, localBaseChatPie.a, localBaseChatPie.a(), paramEmoticon, this.b, this.jdField_a_of_type_JavaLangString, localBaseChatPie.a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.AIOEmoticonUIHelper.1.1
 * JD-Core Version:    0.7.0.1
 */