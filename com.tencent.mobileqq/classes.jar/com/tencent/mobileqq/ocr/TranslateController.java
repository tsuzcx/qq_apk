package com.tencent.mobileqq.ocr;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;
import com.tencent.mobileqq.ocr.api.IOCRHandler;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import java.util.HashMap;

public class TranslateController
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ARCloudFileUpload jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload;
  private IOCRHandler jdField_a_of_type_ComTencentMobileqqOcrApiIOCRHandler;
  HashMap<String, TranslateController.ImageTranslateTask> jdField_a_of_type_JavaUtilHashMap;
  
  public TranslateController(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload = new ARCloudFileUpload(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a();
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("TranslateFileUpload_");
    paramQQAppInterface.append(System.currentTimeMillis());
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread(paramQQAppInterface.toString());
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqOcrApiIOCRHandler = ((IOCRHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOCRHandler.class, ""));
  }
  
  private void a(boolean paramBoolean, String paramString, TranslateResult arg3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOcrApiIOCRHandler != null)
    {
      if (??? != null) {
        ???.c = paramString;
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrApiIOCRHandler.notifyUI(2, paramBoolean, new Object[] { Integer.valueOf(2), ??? });
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    IOCRHandler localIOCRHandler = this.jdField_a_of_type_ComTencentMobileqqOcrApiIOCRHandler;
    if (localIOCRHandler != null) {
      localIOCRHandler.batchTranslate(paramString1, paramString2, paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateController
 * JD-Core Version:    0.7.0.1
 */