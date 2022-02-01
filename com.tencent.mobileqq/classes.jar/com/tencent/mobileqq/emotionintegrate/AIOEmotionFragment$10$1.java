package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.QueryCallback;

class AIOEmotionFragment$10$1
  implements QueryCallback<Emoticon>
{
  AIOEmotionFragment$10$1(AIOEmotionFragment.10 param10, int paramInt1, QQAppInterface paramQQAppInterface, int paramInt2, String paramString) {}
  
  public void a(Emoticon paramEmoticon)
  {
    MarketFaceItemBuilder.a(this.a, this.e.a.b, this.b, paramEmoticon, this.c, this.d, this.e.a.C, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.10.1
 * JD-Core Version:    0.7.0.1
 */