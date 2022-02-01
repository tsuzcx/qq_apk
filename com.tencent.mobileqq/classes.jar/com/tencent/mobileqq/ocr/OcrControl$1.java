package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class OcrControl$1
  implements Runnable
{
  OcrControl$1(OcrControl paramOcrControl, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    if (OcrImageUtil.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = OcrImageUtil.a(new File(this.jdField_a_of_type_JavaLangString).getName(), false);
      if ((this.jdField_a_of_type_Boolean) && (OcrImageUtil.a(this.jdField_a_of_type_JavaLangString, (String)localObject)))
      {
        localARCloudReqFileInfo = new ARCloudReqFileInfo();
        localARCloudReqFileInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
        localARCloudReqFileInfo.jdField_a_of_type_Int = 0;
        localARCloudReqFileInfo.b = this.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "upload pic size:" + new File((String)localObject).length() / 1024L + "KB");
        }
        this.this$0.a(localARCloudReqFileInfo, this.b);
      }
    }
    while (OcrControl.a(this.this$0) == null)
    {
      ARCloudReqFileInfo localARCloudReqFileInfo;
      return;
      Object localObject = new ARCloudReqFileInfo();
      ((ARCloudReqFileInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((ARCloudReqFileInfo)localObject).jdField_a_of_type_Int = 0;
      ((ARCloudReqFileInfo)localObject).b = this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "upload pic size:" + new File(this.jdField_a_of_type_JavaLangString).length() / 1024L + "KB");
      }
      this.this$0.a((ARCloudReqFileInfo)localObject, this.b);
      return;
    }
    OcrControl.a(this.this$0).a(1, null, this.jdField_a_of_type_JavaLangString, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.1
 * JD-Core Version:    0.7.0.1
 */