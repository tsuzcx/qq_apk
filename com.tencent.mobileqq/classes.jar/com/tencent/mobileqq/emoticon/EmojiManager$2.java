package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class EmojiManager$2
  extends DownloadListener
{
  EmojiManager$2(EmojiManager paramEmojiManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject = paramDownloadTask.a();
    int j = ((Bundle)localObject).getInt(paramDownloadTask.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(EmojiManager.a(), 2, "coverDownloadListener| onDone:epId=" + ((EmoticonPackage)localObject).epId + " task:" + paramDownloadTask + " localVersion=" + ((EmoticonPackage)localObject).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject).updateFlag);
    }
    int i = 0;
    if (paramDownloadTask.a() != 3)
    {
      i = EmosmUtils.a(paramDownloadTask.a);
      if (EmojiManager.a(j)) {
        EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject, j, -1, i);
      }
      EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject, i, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      long l1 = paramDownloadTask.h;
      long l2 = paramDownloadTask.g;
      this.a.a((EmoticonPackage)localObject, i, l1 - l2, paramDownloadTask.d);
      return;
      EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject, j, 0, 0);
    }
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    Object localObject = paramDownloadTask.a();
    int i = ((Bundle)localObject).getInt(paramDownloadTask.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(EmojiManager.a(), 2, "coverDownloadListener | onProgress:epId=" + ((EmoticonPackage)localObject).epId + paramDownloadTask);
    }
    if (EmojiManager.a(i)) {
      EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject, i, 0, 0);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiManager.2
 * JD-Core Version:    0.7.0.1
 */