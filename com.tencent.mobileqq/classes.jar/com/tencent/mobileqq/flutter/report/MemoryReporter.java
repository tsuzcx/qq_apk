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
  private static MemoryReporter a;
  private Map<String, Integer> b;
  private Handler c = new Handler(ThreadManager.getSubThreadLooper(), this);
  private String d;
  
  public static MemoryReporter a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new MemoryReporter();
        }
      }
      finally {}
    }
    return a;
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
    this.c.removeCallbacksAndMessages(null);
    Object localObject = this.c.obtainMessage(0);
    ((Message)localObject).obj = paramString;
    this.c.sendMessage((Message)localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 2, "onPagePause");
    }
    this.c.removeCallbacksAndMessages(null);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 1, "onDestroy");
    }
    if (paramBoolean) {
      this.c.sendEmptyMessageDelayed(2, 2000L);
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
        paramMessage = this.b;
        if (paramMessage != null)
        {
          QFlutterReporter.a(true, false, paramMessage, this.d);
          this.b = null;
          this.d = "";
          return false;
        }
      }
      else if (this.b != null)
      {
        boolean bool;
        if (paramMessage.arg1 == 1) {
          bool = true;
        } else {
          bool = false;
        }
        QFlutterReporter.a(bool, true, this.b, this.d);
        if (!bool)
        {
          this.b = null;
          this.d = "";
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
      this.d = paramMessage;
      this.b = DeviceInfoUtil.b(BaseApplicationImpl.getContext());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.report.MemoryReporter
 * JD-Core Version:    0.7.0.1
 */