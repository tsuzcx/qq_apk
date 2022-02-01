package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class OcrControl$5$2
  implements Runnable
{
  OcrControl$5$2(OcrControl.5 param5, ARCloudReqInfo paramARCloudReqInfo) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.a;
    Object localObject = new File(str).getParent();
    if (((IOCR)QRoute.api(IOCR.class)).getImageUtilOCRPATH().equals(localObject))
    {
      FileUtils.deleteFile(str);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("delete pic path:");
        ((StringBuilder)localObject).append(str);
        QLog.d("Q.ocr.control", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.5.2
 * JD-Core Version:    0.7.0.1
 */