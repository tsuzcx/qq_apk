package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class SogouEmoji$1
  extends EmotionJsonDownloadListener
{
  SogouEmoji$1(SogouEmoji paramSogouEmoji) {}
  
  public void onJsonComplete(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    super.onJsonComplete(paramEmoticonPackage, paramInt, paramBundle);
    if ((paramEmoticonPackage != null) && (paramInt == 0))
    {
      paramBundle = paramBundle.getBundle("jsonReqParams");
      if (paramBundle != null)
      {
        paramInt = paramBundle.getInt(SogouEmoji.a);
        paramBundle = paramBundle.getString(SogouEmoji.b);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("func onEmojiJsonBack begins, taskId:");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(",packId:");
          localStringBuilder.append(paramEmoticonPackage.epId);
          QLog.d("SogouEmoji", 2, localStringBuilder.toString());
        }
        boolean bool = this.a.h.b(paramInt);
        if (bool) {
          this.a.a(paramEmoticonPackage.epId, paramBundle, false);
        }
        if (QLog.isColorLevel())
        {
          paramEmoticonPackage = new StringBuilder();
          paramEmoticonPackage.append("func onEmojiJsonBack ends, isTaskExist:");
          paramEmoticonPackage.append(bool);
          QLog.d("SogouEmoji", 2, paramEmoticonPackage.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmoji.1
 * JD-Core Version:    0.7.0.1
 */