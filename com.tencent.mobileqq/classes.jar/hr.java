import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class hr
{
  public static HashMap<String, Integer> a = new HashMap();
  public static HashMap<String, Integer> b;
  
  static
  {
    a.put("actLbsSendPoiListFailure", Integer.valueOf(100));
    a.put("actLbsSendGetPidFailure", Integer.valueOf(100));
    a.put("actLbsPayBridgeFailure", Integer.valueOf(100));
    a.put("actLbsPoiListFailure", Integer.valueOf(10000));
    a.put("actLbsPackListFailure", Integer.valueOf(1000));
    a.put("actLbsGetPackFailure", Integer.valueOf(100));
    a.put("actLbsCaiShenResourceFailure", Integer.valueOf(100));
    b = new HashMap();
    b.put("actLbsSendPoiListFailure", Integer.valueOf(10000));
    b.put("actLbsSendGetPidFailure", Integer.valueOf(10000));
    b.put("actLbsPayBridgeFailure", Integer.valueOf(10000));
    b.put("actLbsPoiListFailure", Integer.valueOf(100000));
    b.put("actLbsPackListFailure", Integer.valueOf(10000));
    b.put("actLbsGetPackFailure", Integer.valueOf(10000));
    b.put("actLbsCaiShenResourceFailure", Integer.valueOf(10000));
  }
  
  public static void a(String paramString)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      if ((!TextUtils.isEmpty(str)) && (b(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "uploadSuccess " + paramString);
        }
        azmz.a(MobileQQ.sMobileQQ).a(str, paramString, false, 0L, 0L, localHashMap, null);
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      if ((!TextUtils.isEmpty(str)) && (a(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LbsPack", 2, "uploadFailure " + paramString + " " + paramInt);
        }
        azmz.a(MobileQQ.sMobileQQ).a(str, paramString, true, 0L, 0L, localHashMap, null);
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean a(String paramString)
  {
    paramString = (Integer)a.get(paramString);
    if (paramString == null) {
      return false;
    }
    return (int)(Math.random() * paramString.intValue()) == 1;
  }
  
  public static boolean b(String paramString)
  {
    paramString = (Integer)b.get(paramString);
    if (paramString == null) {
      return false;
    }
    return (int)(Math.random() * paramString.intValue()) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     hr
 * JD-Core Version:    0.7.0.1
 */