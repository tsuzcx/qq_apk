import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.app.DeviceCapabilityExamination;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class lgu
  implements mxo
{
  public lgu(DeviceCapabilityExamination paramDeviceCapabilityExamination) {}
  
  public void a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (AudioHelper.e()) {
      QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed onFinish result: " + paramInt + ", timeConsuming: " + paramLong + ", gpuVendor: " + paramString1 + ", gpuModel: " + paramString2);
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
    if (AudioHelper.e()) {
      QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed reportByRoomId " + localHashMap);
    }
    azri.a(BaseApplication.getContext()).a(this.a.a.getCurrentAccountUin(), "QAV_REPORT_VIDEO_EFFECT_TEST", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lgu
 * JD-Core Version:    0.7.0.1
 */