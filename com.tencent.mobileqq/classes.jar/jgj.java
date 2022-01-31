import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.app.DeviceCapabilityExamination;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.videoeffect.VideoEffectTest.TestResultCallback;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class jgj
  implements VideoEffectTest.TestResultCallback
{
  public jgj(DeviceCapabilityExamination paramDeviceCapabilityExamination) {}
  
  public void a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceCapabilityExamination", 2, "testVideoEffectIfNeed onFinish result: " + paramInt + ", timeConsuming: " + paramLong + ", gpuVendor: " + paramString1 + ", gpuModel: " + paramString2);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("cpu", Build.HARDWARE);
    localHashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
    localHashMap.put("manufacturer", Build.MANUFACTURER);
    localHashMap.put("model", Build.MODEL);
    localHashMap.put("product", Build.PRODUCT);
    localHashMap.put("fingerprint", Build.FINGERPRINT);
    localHashMap.put("gpu_vendor", paramString1);
    localHashMap.put("gpu_model", paramString2);
    localHashMap.put("result", String.valueOf(paramInt));
    localHashMap.put("time_consuming", String.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("DeviceCapabilityExamination", 2, "testVideoEffectIfNeed reportByRoomId " + localHashMap);
    }
    StatisticCollector.a(BaseApplication.getContext()).a(this.a.a.getCurrentAccountUin(), "QAV_REPORT_VIDEO_EFFECT_TEST", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jgj
 * JD-Core Version:    0.7.0.1
 */