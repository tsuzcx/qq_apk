package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.data.CustomEmotionData;
import java.util.List;

class EmojiManager$8
  extends FavEmoRoamingObserver
{
  EmojiManager$8(EmojiManager paramEmojiManager, Object paramObject) {}
  
  public void onUploadReq(List<CustomEmotionData> arg1)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiManager.8
 * JD-Core Version:    0.7.0.1
 */