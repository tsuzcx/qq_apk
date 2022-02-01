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
    if (QLog.isColorLevel())
    {
      if (paramARCloudRecogResult != null) {
        localObject = paramARCloudRecogResult.a;
      } else {
        localObject = null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("imageTranslate, retCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",sessionId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",result: ");
      localStringBuilder.append(localObject);
      QLog.d("TranslateController", 2, localStringBuilder.toString());
    }
    boolean bool = true;
    int i;
    if ((paramARCloudRecogResult != null) && (paramARCloudRecogResult.a != null))
    {
      paramString = paramARCloudRecogResult.a;
      i = 1;
    }
    else
    {
      paramString = new TranslateResult(2);
      paramString.b = 1002;
      i = 0;
    }
    paramARCloudRecogResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.b;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.a;
    paramString.c = paramARCloudRecogResult;
    if ((FileUtil.b((String)localObject)) && (!((String)localObject).equals(paramARCloudRecogResult))) {
      FileUtil.c((String)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController$ImageTranslateTask.this$0;
    if (paramInt != 0) {
      bool = false;
    }
    TranslateController.a((TranslateController)localObject, bool, paramARCloudRecogResult, paramString);
    paramARCloudRecogResult = new HashMap();
    paramARCloudRecogResult.put("costTime", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.c));
    paramARCloudRecogResult.put("retCode", String.valueOf(paramInt));
    if (i != 0) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    paramARCloudRecogResult.put("hasResult", paramString);
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "SCAN_IMAGE_TRANSLATE_COST", true, 0L, 0L, paramARCloudRecogResult, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateController.ImageTranslateTask.1
 * JD-Core Version:    0.7.0.1
 */