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
  private static MemoryReporter jdField_a_of_type_ComTencentMobileqqFlutterReportMemoryReporter;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  
  public static MemoryReporter a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFlutterReportMemoryReporter == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqFlutterReportMemoryReporter == null) {
          jdField_a_of_type_ComTencentMobileqqFlutterReportMemoryReporter = new MemoryReporter();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqFlutterReportMemoryReporter;
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreate pageUrl: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QFlutter.Reporter", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
    ((Message)localObject).obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    int i = paramMessage.what;
    String str = "";
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        paramMessage = this.jdField_a_of_type_JavaUtilMap;
        if (paramMessage != null)
        {
          QFlutterReporter.a(true, false, paramMessage, this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilMap = null;
          this.jdField_a_of_type_JavaLangString = "";
          return false;
        }
      }
      else if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        boolean bool;
        if (paramMessage.arg1 == 1) {
          bool = true;
        } else {
          bool = false;
        }
        QFlutterReporter.a(bool, true, this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_JavaLangString);
        if (!bool)
        {
          this.jdField_a_of_type_JavaUtilMap = null;
          this.jdField_a_of_type_JavaLangString = "";
          return false;
        }
      }
    }
    else
    {
      QLog.d("QFlutter.Reporter", 1, "init memory");
      if ((paramMessage.obj instanceof String)) {
        str = (String)paramMessage.obj;
      }
      paramMessage = str;
      if (TextUtils.isEmpty(str)) {
        paramMessage = "unknown";
      }
      this.jdField_a_of_type_JavaLangString = paramMessage;
      this.jdField_a_of_type_JavaUtilMap = DeviceInfoUtil.a(BaseApplicationImpl.getContext());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.report.MemoryReporter
 * JD-Core Version:    0.7.0.1
 */