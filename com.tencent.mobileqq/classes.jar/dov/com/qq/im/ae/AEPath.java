package dov.com.qq.im.ae;

import android.os.Build;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import java.io.File;

public class AEPath
  extends AEPathBase
{
  private static final String d = AppConstants.SDCARD_ROOT + "/DCIM/Video/";
  private static final String e = AppConstants.SDCARD_ROOT + HardCodeUtil.a(2131700690);
  private static final String f = AppConstants.SDCARD_ROOT + HardCodeUtil.a(2131700691);
  private static final String g = AppConstants.SDCARD_ROOT + "/Camera/Video/";
  private static final String h = AppConstants.SDCARD_ROOT + "/DCIM/Camera/";
  
  public static String a()
  {
    String str = Build.MODEL.toUpperCase();
    if (str.contains("GN9000L")) {
      return e;
    }
    if ((str.contains("MX4")) || (str.contains("MX6")) || (str.contains("MX5")) || (str.contains("M355")) || (str.contains("M571C"))) {
      return d;
    }
    if (str.contains("M040")) {
      return g;
    }
    if ((str.contains("VIVO X7")) || (str.contains("VIVO X6A")) || (str.contains("VIVO XPLAY6")) || (str.contains("VIVO X5PRO")) || (str.contains("VIVO X9 PLUS")) || (str.contains("VIVO Y51A")) || (str.contains("VIVO X9I")) || (str.contains("VIVO X9")) || (str.contains("VIVO X6D"))) {
      return f;
    }
    return h;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    File localFile = new File(localStringBuilder.toString());
    paramString = localStringBuilder;
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    for (paramString = localStringBuilder;; paramString = new StringBuilder(paramString))
    {
      paramString.append(VidUtil.generateVid()).append(".mp4");
      if (!new File(paramString.toString()).exists()) {
        return paramString.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPath
 * JD-Core Version:    0.7.0.1
 */