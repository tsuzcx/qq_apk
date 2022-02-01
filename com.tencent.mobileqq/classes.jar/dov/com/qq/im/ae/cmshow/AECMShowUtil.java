package dov.com.qq.im.ae.cmshow;

import com.tencent.aekit.api.standard.GLCapabilities;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.util.AEQLog;
import org.light.DeviceSupportUtil;
import org.light.device.DeviceInstance;

public class AECMShowUtil
{
  public static String a()
  {
    if (!AEResUtil.b(AEResInfo.c))
    {
      AEQLog.d("AECMShowUtil", "[getLightAssetsDir]: LightBasePackage not exist, return asset path!");
      return "assets://camera/cmshow";
    }
    return AEResUtil.d();
  }
  
  public static void a()
  {
    try
    {
      GLCapabilities.init(false);
      AEQLog.b("AECMShowUtil", "init3DCapabilityChecker: init finish");
      return;
    }
    catch (Throwable localThrowable)
    {
      AEQLog.a("AECMShowUtil", "[init3DCapabilityChecker], error=", localThrowable);
    }
  }
  
  public static boolean a()
  {
    try
    {
      DeviceSupportUtil.init(a());
      AEQLog.a("AECMShowUtil", "[isCMShowSupported] 厘米秀设备屏蔽判断，设备名：" + DeviceInstance.getInstance().getDeviceName());
      boolean bool = DeviceSupportUtil.isAbilityDeviceSupport("3d.kapu");
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AEQLog.a("AECMShowUtil", "[isCMShowSupported], error=", localThrowable);
    }
    return false;
  }
  
  public static boolean b()
  {
    return (AEResUtil.b(AEResInfo.b)) && (AEResUtil.b(AEResInfo.c)) && (AEResUtil.b(AEResInfo.j)) && (AEResUtil.b(AEResInfo.k));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowUtil
 * JD-Core Version:    0.7.0.1
 */