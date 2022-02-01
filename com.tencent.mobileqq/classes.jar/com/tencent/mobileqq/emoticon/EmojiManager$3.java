package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class EmojiManager$3
  extends DownloadListener
{
  EmojiManager$3(EmojiManager paramEmojiManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    try
    {
      super.onDone(paramDownloadTask);
      Bundle localBundle = paramDownloadTask.a();
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEmoticonPackage.epId);
      int i = localBundle.getInt("businessType");
      if (paramDownloadTask.a() != 3) {}
      for (boolean bool = true;; bool = false)
      {
        long l1 = paramDownloadTask.h;
        long l2 = paramDownloadTask.g;
        this.a.a(localBundle, paramDownloadTask, bool, paramDownloadTask.jdField_a_of_type_Int, paramDownloadTask.d, l1 - l2, i);
        return;
      }
      return;
    }
    catch (Exception paramDownloadTask)
    {
      QLog.e(EmojiManager.a(), 1, "onDone failed", paramDownloadTask);
    }
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    int i;
    EmoticonPackage localEmoticonPackage;
    try
    {
      Object localObject = paramDownloadTask.a();
      i = ((Bundle)localObject).getInt(paramDownloadTask.c);
      localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
      if (localEmoticonPackage == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(EmojiManager.a(), 2, "emotionDownloadListener | onDoneFile epId=" + localEmoticonPackage.epId + ",task:" + paramDownloadTask);
      }
      EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.b(localEmoticonPackage, (int)paramDownloadTask.jdField_a_of_type_Long, (int)paramDownloadTask.b);
      if (i == 9)
      {
        localObject = ((Bundle)localObject).getString(paramDownloadTask.c + "emoticonId");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          EmojiManager.a(this.a, localEmoticonPackage.epId, (String)localObject, paramDownloadTask.jdField_a_of_type_Int);
        }
      }
      if (paramDownloadTask.jdField_a_of_type_Int != 0)
      {
        QLog.e(EmojiManager.a(), 1, "onDoneFile : ondone error , reportCode = " + paramDownloadTask.jdField_a_of_type_Int);
        if (EmojiManager.a(i)) {
          EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, i, -1, paramDownloadTask.jdField_a_of_type_Int);
        }
        VasReportUtils.a("emotionType", "emotionActionDownload", "10", localEmoticonPackage.epId, "", "", paramDownloadTask.jdField_a_of_type_Int + "", "", "", "");
        return;
      }
    }
    catch (Exception paramDownloadTask)
    {
      QLog.e(EmojiManager.a(), 1, "onDoneFile failed", paramDownloadTask);
      return;
    }
    if (EmojiManager.a(i)) {
      EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, i, 0, 0);
    }
    while ((localEmoticonPackage.jobType == 3) || (localEmoticonPackage.jobType == 5))
    {
      this.a.b(paramDownloadTask);
      return;
      if (i == 7) {
        this.a.a(paramDownloadTask);
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramDownloadTask.a().getSerializable("emoticonPackage");
    EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage);
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiManager.3
 * JD-Core Version:    0.7.0.1
 */