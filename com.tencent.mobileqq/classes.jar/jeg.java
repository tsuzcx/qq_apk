import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.app.DeviceCapabilityExamination;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.mediacodec.VideoEncTest.PlayerCallback;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class jeg
  implements VideoEncTest.PlayerCallback
{
  public jeg(DeviceCapabilityExamination paramDeviceCapabilityExamination) {}
  
  public void a(int paramInt1, String paramString, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5)
  {
    if (QLog.isColorLevel()) {
      QLog.w("DeviceCapabilityExamination", 2, "testHWCodecIfNeed onFinish resultCode: " + paramInt1 + ", codecName: " + paramString + ", colorFormat: " + paramInt2 + "(0x" + Integer.toHexString(paramInt2).toUpperCase() + "), delay: " + paramLong + ", ssim: " + paramInt3 + ", rate0: " + paramInt4 + ", rate1: " + paramInt5);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("cpu", Build.HARDWARE);
    localHashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
    localHashMap.put("manufacturer", Build.MANUFACTURER);
    localHashMap.put("model", Build.MODEL);
    localHashMap.put("product", Build.PRODUCT);
    localHashMap.put("fingerprint", Build.FINGERPRINT);
    localHashMap.put("codec_name", paramString);
    localHashMap.put("support_format", String.valueOf(paramInt2));
    localHashMap.put("delayms", String.valueOf(paramLong));
    localHashMap.put("result", String.valueOf(paramInt1));
    localHashMap.put("ssim", String.valueOf(paramInt3));
    localHashMap.put("ratedis0", String.valueOf(paramInt4));
    localHashMap.put("ratedis1", String.valueOf(paramInt5));
    StatisticCollector.a(BaseApplication.getContext()).a(this.a.a.getCurrentAccountUin(), "AV_HWCODEC_AVC_ENC", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jeg
 * JD-Core Version:    0.7.0.1
 */