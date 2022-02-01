package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class SogouEmoji$1
  extends EmotionJsonDownloadListener
{
  SogouEmoji$1(SogouEmoji paramSogouEmoji) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    super.a(paramEmoticonPackage, paramInt, paramBundle);
    if ((paramEmoticonPackage != null) && (paramInt == 0))
    {
      paramBundle = paramBundle.getBundle("jsonReqParams");
      if (paramBundle != null)
      {
        paramInt = paramBundle.getInt(SogouEmoji.jdField_a_of_type_JavaLangString);
        paramBundle = paramBundle.getString(SogouEmoji.b);
        if (QLog.isColorLevel()) {
          QLog.d("SogouEmoji", 2, "func onEmojiJsonBack begins, taskId:" + paramInt + ",packId:" + paramEmoticonPackage.epId);
        }
        boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a(paramInt);
        if (bool) {
          this.a.a(paramEmoticonPackage.epId, paramBundle, false);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SogouEmoji", 2, "func onEmojiJsonBack ends, isTaskExist:" + bool);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmoji.1
 * JD-Core Version:    0.7.0.1
 */