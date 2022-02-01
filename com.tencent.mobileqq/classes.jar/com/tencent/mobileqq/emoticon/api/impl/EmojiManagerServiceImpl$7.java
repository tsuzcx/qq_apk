package com.tencent.mobileqq.emoticon.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;

class EmojiManagerServiceImpl$7
  extends EmotionJsonDownloadListener
{
  EmojiManagerServiceImpl$7(EmojiManagerServiceImpl paramEmojiManagerServiceImpl, String paramString, Object paramObject) {}
  
  public void onJsonComplete(EmoticonPackage arg1, int paramInt, Bundle paramBundle)
  {
    if (???.epId.equals(this.jdField_a_of_type_JavaLangString)) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notify();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceImpl.7
 * JD-Core Version:    0.7.0.1
 */