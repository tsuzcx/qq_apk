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
      AIOEmotionFragment.a(this.b, this.a, 7);
      return;
    }
    MarketFaceItemBuilder.a(7, this.b.getBaseActivity(), this.a, paramEmoticonPackage, this.b.E, this.b.C, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.8
 * JD-Core Version:    0.7.0.1
 */