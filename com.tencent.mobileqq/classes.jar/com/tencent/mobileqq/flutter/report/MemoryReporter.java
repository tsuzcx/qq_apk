package com.tencent.mobileqq.flutter.report;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class MemoryReporter
  implements Handler.Callback
{
  private static MemoryReporter jdField_a_of_type_ComTencentMobileqqFlutterReportMemoryReporter = null;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  
  public static MemoryReporter a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFlutterReportMemoryReporter == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqFlutterReportMemoryReporter == null) {
        jdField_a_of_type_ComTencentMobileqqFlutterReportMemoryReporter = new MemoryReporter();
      }
      return jdField_a_of_type_ComTencentMobileqqFlutterReportMemoryReporter;
    }
    finally {}
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 2, "onPagePause");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 2, "onCreate pageUrl: " + paramString);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
    localMessage.obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 2, "onFirstFrameRendered");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    if (paramBoolean) {}
    for (;;)
    {
      localMessage.arg1 = i;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 2000L);
      return;
      i = 0;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 1, "onDestroy");
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 2000L);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return false;
        QLog.d("QFlutter.Reporter", 1, "init memory");
        String str = "";
        if ((paramMessage.obj instanceof String)) {
          str = (String)paramMessage.obj;
        }
        paramMessage = str;
        if (TextUtils.isEmpty(str)) {
          paramMessage = "unknown";
        }
        this.jdField_a_of_type_JavaLangString = paramMessage;
        this.jdField_a_of_type_JavaUtilMap = DeviceInfoUtil.a(BaseApplicationImpl.getContext());
        return false;
      } while (this.jdField_a_of_type_JavaUtilMap == null);
      if (paramMessage.arg1 == 1) {}
      for (boolean bool = true;; bool = false)
      {
        QFlutterReporter.a(bool, true, this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_JavaLangString);
        if (bool) {
          break;
        }
        this.jdField_a_of_type_JavaUtilMap = null;
        this.jdField_a_of_type_JavaLangString = "";
        return false;
      }
    } while (this.jdField_a_of_type_JavaUtilMap == null);
    QFlutterReporter.a(true, false, this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilMap = null;
    this.jdField_a_of_type_JavaLangString = "";
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.report.MemoryReporter
 * JD-Core Version:    0.7.0.1
 */