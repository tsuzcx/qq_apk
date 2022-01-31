import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.av.config.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class lim
{
  private static lim jdField_a_of_type_Lim;
  int jdField_a_of_type_Int = 0;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new lin(this);
  lnc jdField_a_of_type_Lnc = null;
  
  public lim(Context paramContext)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("AVConfigManager", 1, "构造", new Throwable("打印调用栈"));
    }
  }
  
  public static lim a(Context paramContext)
  {
    if (jdField_a_of_type_Lim == null) {}
    try
    {
      if (jdField_a_of_type_Lim == null)
      {
        jdField_a_of_type_Lim = new lim(paramContext);
        jdField_a_of_type_Lim.b(paramContext);
      }
      return jdField_a_of_type_Lim;
    }
    finally {}
  }
  
  public static lnc a(Context paramContext)
  {
    return a(paramContext).b(paramContext);
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_Lim != null)
      {
        jdField_a_of_type_Lim.c(paramContext);
        jdField_a_of_type_Lim = null;
      }
      return;
    }
    finally {}
  }
  
  lnc b(Context paramContext)
  {
    try
    {
      if (this.jdField_a_of_type_Lnc == null)
      {
        String str = ConfigInfo.getSharpConfigPayloadFromFile(paramContext);
        this.jdField_a_of_type_Int = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
        this.jdField_a_of_type_Lnc = new lnc(str);
        QLog.w("AVConfigManager", 1, "getParser, Version[" + this.jdField_a_of_type_Int + "], data[\n" + str + "\n]");
      }
      paramContext = this.jdField_a_of_type_Lnc;
      return paramContext;
    }
    finally {}
  }
  
  public void b(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
    localIntentFilter.addAction("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD");
    paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  void c(Context paramContext)
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      paramContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public void d(Context paramContext)
  {
    try
    {
      if (this.jdField_a_of_type_Lnc == null) {
        return;
      }
      int i = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
      if ((this.jdField_a_of_type_Int != i) || (this.jdField_a_of_type_Lnc.a()))
      {
        QLog.w("AVConfigManager", 1, "reload, Version[" + this.jdField_a_of_type_Int + "->" + i + "]");
        this.jdField_a_of_type_Lnc = null;
        this.jdField_a_of_type_Int = 0;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lim
 * JD-Core Version:    0.7.0.1
 */