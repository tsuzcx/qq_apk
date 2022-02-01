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
    BaseChatPie localBaseChatPie = this.d.a.b();
    if (localBaseChatPie != null) {
      MarketFaceItemBuilder.a(this.a, localBaseChatPie.e, localBaseChatPie.i(), paramEmoticon, this.b, this.c, localBaseChatPie.aE(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.AIOEmoticonUIHelper.1.1
 * JD-Core Version:    0.7.0.1
 */