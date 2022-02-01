package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;

class EmojiManager$4
  implements Runnable
{
  EmojiManager$4(EmojiManager paramEmojiManager, boolean paramBoolean, String paramString, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject1;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = EmoticonUtils.smallEmoticonJsonUrl.replace("[epId]", this.jdField_a_of_type_JavaLangString);
      localObject2 = this.this$0.a().a((String)localObject1);
      if ((localObject2 == null) || (((DownloadTask)localObject2).b())) {
        break label98;
      }
    }
    label98:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label103;
      }
      if (QLog.isColorLevel()) {
        QLog.d(EmojiManager.a(), 2, "startDownloadEmosmJson|epId is in downloading:" + this.jdField_a_of_type_JavaLangString);
      }
      return;
      localObject1 = EmosmUtils.a(this.jdField_a_of_type_JavaLangString);
      break;
    }
    label103:
    Object localObject3 = this.this$0.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(EmojiManager.a(), 2, "startDownloadEmosmJson|emoPackage is not exist:" + this.jdField_a_of_type_JavaLangString);
      }
      localObject2 = new EmoticonPackage();
      ((EmoticonPackage)localObject2).epId = this.jdField_a_of_type_JavaLangString;
      ((EmoticonPackage)localObject2).status = 0;
      if (this.jdField_a_of_type_Int != 0) {
        break label370;
      }
      ((EmoticonPackage)localObject2).aio = true;
    }
    for (;;)
    {
      this.this$0.a().a((EmoticonPackage)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d(EmojiManager.a(), 2, "startDownloadEmosmJson epId:" + ((EmoticonPackage)localObject2).epId);
      }
      localObject1 = new DownloadTask((String)localObject1, new File(EmoticonUtils.emoticonJsonFilePath.replace("[epId]", this.jdField_a_of_type_JavaLangString)));
      localObject3 = new Bundle();
      ((Bundle)localObject3).putInt("jsonType", this.b);
      ((Bundle)localObject3).putSerializable("emoticonPackage", (Serializable)localObject2);
      ((Bundle)localObject3).putBoolean("isSmallEmotion", this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        ((Bundle)localObject3).putBundle("jsonReqParams", this.jdField_a_of_type_AndroidOsBundle);
      }
      ((DownloadTask)localObject1).e = this.this$0.e;
      ((DownloadTask)localObject1).n = true;
      this.this$0.a().a((DownloadTask)localObject1, this.this$0.a, (Bundle)localObject3);
      return;
      label370:
      if (this.jdField_a_of_type_Int == 1) {
        ((EmoticonPackage)localObject2).kandian = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiManager.4
 * JD-Core Version:    0.7.0.1
 */