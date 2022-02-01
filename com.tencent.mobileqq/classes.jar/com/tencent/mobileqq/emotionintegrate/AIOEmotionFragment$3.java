package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.QueryCallback;

class AIOEmotionFragment$3
  implements QueryCallback<EmoticonPackage>
{
  AIOEmotionFragment$3(AIOEmotionFragment paramAIOEmotionFragment, QQAppInterface paramQQAppInterface) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null)
    {
      AIOEmotionFragment.a(this.b, this.a, 32);
      return;
    }
    AIOEmotionFragment.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.3
 * JD-Core Version:    0.7.0.1
 */