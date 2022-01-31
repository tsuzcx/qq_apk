import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.av.config.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class kvz
{
  private static kvz jdField_a_of_type_Kvz;
  int jdField_a_of_type_Int = 0;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new kwa(this);
  lao jdField_a_of_type_Lao = null;
  
  public kvz(Context paramContext)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("ConfigManager", 1, "构造", new Throwable("打印调用栈"));
    }
  }
  
  public static kvz a(Context paramContext)
  {
    if (jdField_a_of_type_Kvz == null) {}
    try
    {
      if (jdField_a_of_type_Kvz == null)
      {
        jdField_a_of_type_Kvz = new kvz(paramContext);
        jdField_a_of_type_Kvz.b(paramContext);
      }
      return jdField_a_of_type_Kvz;
    }
    finally {}
  }
  
  public static lao a(Context paramContext)
  {
    return a(paramContext).b(paramContext);
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_Kvz != null)
      {
        jdField_a_of_type_Kvz.c(paramContext);
        jdField_a_of_type_Kvz = null;
      }
      return;
    }
    finally {}
  }
  
  lao b(Context paramContext)
  {
    try
    {
      if (this.jdField_a_of_type_Lao == null)
      {
        String str = ConfigInfo.getSharpConfigPayloadFromFile(paramContext);
        this.jdField_a_of_type_Int = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
        this.jdField_a_of_type_Lao = new lao(str);
        QLog.w("ConfigManager", 1, "getParser, Version[" + this.jdField_a_of_type_Int + "], data[\n" + str + "\n]");
      }
      paramContext = this.jdField_a_of_type_Lao;
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
      if (this.jdField_a_of_type_Lao == null) {
        return;
      }
      int i = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
      if ((this.jdField_a_of_type_Int != i) || (this.jdField_a_of_type_Lao.a()))
      {
        QLog.w("ConfigManager", 1, "reload, Version[" + this.jdField_a_of_type_Int + "->" + i + "]");
        this.jdField_a_of_type_Lao = null;
        this.jdField_a_of_type_Int = 0;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kvz
 * JD-Core Version:    0.7.0.1
 */