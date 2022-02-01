package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.qphone.base.util.QLog;

class SogouEmoji$2
  implements QueryCallback<Emoticon>
{
  SogouEmoji$2(SogouEmoji paramSogouEmoji, int paramInt, String paramString) {}
  
  public void a(Emoticon paramEmoticon)
  {
    if ((paramEmoticon == null) || (!paramEmoticon.hasEncryptKey()))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a(Integer.toString(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, true);
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func trySend ends, emotion has invalid key. Call func pullSingleEmojiKey");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a(paramEmoticon);
    } while (!QLog.isColorLevel());
    QLog.d("SogouEmoji", 2, "func trySend ends, everything is ok.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmoji.2
 * JD-Core Version:    0.7.0.1
 */