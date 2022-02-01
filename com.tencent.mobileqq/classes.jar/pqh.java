import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class pqh
{
  public static String a()
  {
    if (TextUtils.isEmpty(pkh.a))
    {
      Object localObject2 = pqu.b();
      String str = pqu.c();
      if ((!((String)localObject2).equals("null")) && (!str.equals("null")))
      {
        pkh.a = "0," + (String)localObject2 + "," + str;
        return pkh.a;
      }
      Object localObject1 = localObject2;
      if (((String)localObject2).equals("null")) {
        localObject1 = "0";
      }
      localObject2 = str;
      if (str.equals("null")) {
        localObject2 = "0";
      }
      return "0," + (String)localObject1 + "," + (String)localObject2;
    }
    return pkh.a;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramQQAppInterface.getAccount());
    localHashMap.put("param_cpu", String.valueOf(DeviceInfoUtil.getCpuNumber()));
    localHashMap.put("param_totalMem", String.valueOf(DeviceInfoUtil.getSystemTotalMemory()));
    localHashMap.put("param_availableMem", String.valueOf(DeviceInfoUtil.getSystemAvaialbeMemory()));
    localHashMap.put("param_version", "8.4.10");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actUserDeviceInfoReport", true, 100L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqh
 * JD-Core Version:    0.7.0.1
 */