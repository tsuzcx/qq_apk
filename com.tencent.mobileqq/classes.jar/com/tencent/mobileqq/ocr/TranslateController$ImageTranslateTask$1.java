package com.tencent.mobileqq.ocr;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.ARCloudFileUploadCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class TranslateController$ImageTranslateTask$1
  implements ARCloudFileUpload.ARCloudFileUploadCallback
{
  TranslateController$ImageTranslateTask$1(TranslateController.ImageTranslateTask paramImageTranslateTask, ARCloudReqInfo paramARCloudReqInfo) {}
  
  public void a(int paramInt, String paramString, ARCloudRecogResult paramARCloudRecogResult)
  {
    Object localObject;
    label82:
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (paramARCloudRecogResult != null)
      {
        localObject = paramARCloudRecogResult.a;
        QLog.d("TranslateController", 2, "imageTranslate, retCode:" + paramInt + ",sessionId:" + paramString + ",result: " + localObject);
      }
    }
    else
    {
      int i = 0;
      if ((paramARCloudRecogResult == null) || (paramARCloudRecogResult.a == null)) {
        break label241;
      }
      paramString = paramARCloudRecogResult.a;
      i = 1;
      paramARCloudRecogResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.b;
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.a;
      paramString.c = paramARCloudRecogResult;
      if ((FileUtil.a((String)localObject)) && (!((String)localObject).equals(paramARCloudRecogResult))) {
        FileUtil.c((String)localObject);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController$ImageTranslateTask.this$0;
      if (paramInt != 0) {
        break label260;
      }
      bool = true;
      label149:
      TranslateController.a((TranslateController)localObject, bool, paramARCloudRecogResult, paramString);
      paramARCloudRecogResult = new HashMap();
      paramARCloudRecogResult.put("costTime", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.c));
      paramARCloudRecogResult.put("retCode", String.valueOf(paramInt));
      if (i == 0) {
        break label266;
      }
    }
    label260:
    label266:
    for (paramString = "1";; paramString = "0")
    {
      paramARCloudRecogResult.put("hasResult", paramString);
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "SCAN_IMAGE_TRANSLATE_COST", true, 0L, 0L, paramARCloudRecogResult, "", false);
      return;
      localObject = null;
      break;
      label241:
      paramString = new TranslateResult(2);
      paramString.b = 1002;
      break label82;
      bool = false;
      break label149;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateController.ImageTranslateTask.1
 * JD-Core Version:    0.7.0.1
 */