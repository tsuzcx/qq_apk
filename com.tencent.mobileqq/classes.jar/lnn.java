import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class lnn
  implements Runnable
{
  private QQAppInterface a;
  
  public lnn(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(int paramInt)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("param_totalMem", String.valueOf(DeviceInfoUtil.e()));
      localHashMap.put("param_availableMem", String.valueOf(DeviceInfoUtil.f()));
      localHashMap.put("param_cpuNum", String.valueOf(DeviceInfoUtil.b()));
      localHashMap.put("param_cpuFreq", String.valueOf(DeviceInfoUtil.a()));
      localHashMap.put("param_preloadLevel", String.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ReadInJoyWebProcessManager", 2, "preloadToolProcessReport:" + localHashMap.toString());
      }
      StatisticCollector.a(this.a.getApp()).a(this.a.getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.readinjoy.ReadInJoyWebProcessManager", 2, "Exception: " + localException);
    }
  }
  
  public void run()
  {
    if ((WebProcessManager.c()) || (this.a == null)) {}
    for (;;)
    {
      return;
      WebProcessManager localWebProcessManager = (WebProcessManager)this.a.getManager(12);
      if (localWebProcessManager != null)
      {
        int i = ReadInJoyUtils.f();
        if (ReadInJoyUtils.f()) {
          a(i);
        }
        if (i == 1) {
          localWebProcessManager.a(200);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.ReadInJoyWebProcessManager", 2, "enter folder preload web process");
          return;
          if (i == 2) {
            localWebProcessManager.a(201);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lnn
 * JD-Core Version:    0.7.0.1
 */