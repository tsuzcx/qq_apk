import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class mjr
  implements Runnable
{
  private WeakReference a;
  
  public mjr(ReadinjoyTabFrame paramReadinjoyTabFrame)
  {
    this.a = new WeakReference(paramReadinjoyTabFrame);
  }
  
  public void run()
  {
    ReadinjoyTabFrame localReadinjoyTabFrame;
    if ((this.a != null) && (this.a.get() != null))
    {
      localReadinjoyTabFrame = (ReadinjoyTabFrame)this.a.get();
      localWebProcessManager = (WebProcessManager)localReadinjoyTabFrame.a.getManager(12);
      if (localWebProcessManager != null)
      {
        i = ReadInJoyUtils.f();
        if (!ReadInJoyUtils.f()) {}
      }
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("param_totalMem", String.valueOf(DeviceInfoUtil.e()));
      localHashMap.put("param_availableMem", String.valueOf(DeviceInfoUtil.f()));
      localHashMap.put("param_cpuNum", String.valueOf(DeviceInfoUtil.b()));
      localHashMap.put("param_cpuFreq", String.valueOf(DeviceInfoUtil.a()));
      localHashMap.put("param_preloadLevel", String.valueOf(i));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "preloadToolProcessReport:" + localHashMap.toString());
      }
      StatisticCollector.a(localReadinjoyTabFrame.a()).a(localReadinjoyTabFrame.a.getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("Q.readinjoy.4tab", 2, "", localException);
        continue;
        if (i == 2) {
          localWebProcessManager.a(201);
        }
      }
    }
    if (i == 1)
    {
      localWebProcessManager.a(200);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "enter folder preload web process");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mjr
 * JD-Core Version:    0.7.0.1
 */