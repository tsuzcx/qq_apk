import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashMap;

public class ods
  extends QIPCModule
{
  private static volatile ods a;
  
  public ods(String paramString)
  {
    super(paramString);
  }
  
  public static ods a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ods("EcshopIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    try
    {
      if (!(BaseApplicationImpl.getApplication().peekAppRuntime() instanceof QQAppInterface)) {
        return null;
      }
      if (paramString.equals("reportToBeacon"))
      {
        oev.a(paramBundle.getString("key_report_event"), (HashMap)paramBundle.getSerializable("key_report_params"));
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("EcshopIPCModule", 1, paramString, new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ods
 * JD-Core Version:    0.7.0.1
 */