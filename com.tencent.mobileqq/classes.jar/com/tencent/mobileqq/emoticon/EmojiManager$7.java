package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;

class EmojiManager$7
  extends EmotionJsonDownloadListener
{
  EmojiManager$7(EmojiManager paramEmojiManager, String paramString, Object paramObject) {}
  
  public void a(EmoticonPackage arg1, int paramInt, Bundle paramBundle)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiManager.7
 * JD-Core Version:    0.7.0.1
 */