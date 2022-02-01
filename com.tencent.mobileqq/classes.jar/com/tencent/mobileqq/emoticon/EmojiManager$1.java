package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class EmojiManager$1
  extends DownloadListener
{
  EmojiManager$1(EmojiManager paramEmojiManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Bundle localBundle;
    EmoticonPackage localEmoticonPackage;
    try
    {
      localBundle = paramDownloadTask.a();
      localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      if (localEmoticonPackage == null) {
        return;
      }
      if ((QLog.isColorLevel()) && (localEmoticonPackage != null)) {
        QLog.d(EmojiManager.a(), 2, "jsonDownloadListener : onDone epid = " + localEmoticonPackage.epId + ";task status = " + paramDownloadTask.a());
      }
      if (paramDownloadTask.a() != 3) {
        break label177;
      }
      boolean bool = localBundle.getBoolean("isSmallEmotion");
      String str = EmotionJsonUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDownloadTask, bool);
      if (str != null)
      {
        QLog.e(EmojiManager.a(), 1, "jsonDownloadListener : parse json error : = " + str);
        this.a.a(localEmoticonPackage, 11008, 0L, paramDownloadTask.d);
        return;
      }
    }
    catch (Exception paramDownloadTask)
    {
      QLog.e(EmojiManager.a(), 1, "json download fail", paramDownloadTask);
      return;
    }
    EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, 0, localBundle);
    return;
    label177:
    QLog.e(EmojiManager.a(), 1, "jsonDownloadListener : ondone error , reportCode = " + paramDownloadTask.a);
    EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, -1, localBundle);
    VasReportUtils.a("emotionType", "emotionActionDownload", "3", localEmoticonPackage.epId, "", "", paramDownloadTask.a + "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiManager.1
 * JD-Core Version:    0.7.0.1
 */