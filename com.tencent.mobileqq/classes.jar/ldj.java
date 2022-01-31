import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ldj
  implements Runnable
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public ldj(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity1, ReadInJoyFeedsActivity paramReadInJoyFeedsActivity2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramReadInJoyFeedsActivity2);
  }
  
  public void run()
  {
    if (WebProcessManager.c()) {}
    for (;;)
    {
      return;
      WebProcessManager localWebProcessManager;
      int i;
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        localWebProcessManager = (WebProcessManager)((ReadInJoyFeedsActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app.getManager(12);
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
          QLog.d("ReadInJoyBaseActivity", 2, "preloadToolProcessReport:" + localHashMap.toString());
        }
        StatisticCollector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.app.getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
      }
      catch (Exception localException)
      {
        label206:
        break label206;
      }
      if (i == 1) {
        localWebProcessManager.a(200);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyBaseActivity", 2, "enter folder preload web process");
        return;
        if (i == 2) {
          localWebProcessManager.a(201);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ldj
 * JD-Core Version:    0.7.0.1
 */