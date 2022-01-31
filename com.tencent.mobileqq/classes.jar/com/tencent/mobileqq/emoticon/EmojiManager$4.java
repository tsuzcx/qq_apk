package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import anqz;
import anvx;
import anzr;
import askf;
import bbwu;
import bbwz;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;

public class EmojiManager$4
  implements Runnable
{
  public EmojiManager$4(anvx paramanvx, boolean paramBoolean, String paramString, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject1;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = anzr.c.replace("[epId]", this.jdField_a_of_type_JavaLangString);
      localObject2 = this.this$0.a().a((String)localObject1);
      if ((localObject2 == null) || (((bbwu)localObject2).b())) {
        break label102;
      }
    }
    label102:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label107;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson|epId is in downloading:" + this.jdField_a_of_type_JavaLangString);
      }
      return;
      localObject1 = anqz.a(this.jdField_a_of_type_JavaLangString);
      break;
    }
    label107:
    Object localObject3 = this.this$0.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson|emoPackage is not exist:" + this.jdField_a_of_type_JavaLangString);
      }
      localObject2 = new EmoticonPackage();
      ((EmoticonPackage)localObject2).epId = this.jdField_a_of_type_JavaLangString;
      ((EmoticonPackage)localObject2).status = 0;
      if (this.jdField_a_of_type_Int != 0) {
        break label382;
      }
      ((EmoticonPackage)localObject2).aio = true;
    }
    for (;;)
    {
      this.this$0.a().a((EmoticonPackage)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson epId:" + ((EmoticonPackage)localObject2).epId);
      }
      localObject1 = new bbwu((String)localObject1, new File(anzr.r.replace("[epId]", this.jdField_a_of_type_JavaLangString)));
      localObject3 = new Bundle();
      ((Bundle)localObject3).putInt("jsonType", this.b);
      ((Bundle)localObject3).putSerializable("emoticonPackage", (Serializable)localObject2);
      ((Bundle)localObject3).putBoolean("isSmallEmotion", this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        ((Bundle)localObject3).putBundle("jsonReqParams", this.jdField_a_of_type_AndroidOsBundle);
      }
      ((bbwu)localObject1).e = this.this$0.e;
      ((bbwu)localObject1).n = true;
      this.this$0.a().a((bbwu)localObject1, this.this$0.jdField_a_of_type_Bbwt, (Bundle)localObject3);
      return;
      label382:
      if (this.jdField_a_of_type_Int == 1) {
        ((EmoticonPackage)localObject2).kandian = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiManager.4
 * JD-Core Version:    0.7.0.1
 */