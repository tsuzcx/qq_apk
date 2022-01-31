package cooperation.qzone.util;

import android.os.Build;
import common.config.service.QzoneConfig;

public class gifCoderWnsConfig
{
  public static final int a = QzoneConfig.getInstance().getConfig("PhotoUpload", "createGifLowDeviceSize", 720);
  public static final int b = QzoneConfig.getInstance().getConfig("PhotoUpload", "createGifMiddleDeviceSize", 720);
  public static final int c = QzoneConfig.getInstance().getConfig("PhotoUpload", "createGifHighDeviceSize", 720);
  public static final int d = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_gif_delay", 200);
  public static final int e = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_gif_size_limit", 64);
  public static final int f = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_gif_max_speed", 20);
  public static final int g = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_gif_min_multiple_speed", 3);
  private static int h = -1;
  
  public static int a()
  {
    int i = 2;
    if (QzoneHardwareRestriction.meetHardwareRestriction(2, 2)) {
      i = 3;
    }
    while (QzoneHardwareRestriction.meetHardwareRestriction(1, 1)) {
      return i;
    }
    return 1;
  }
  
  public static boolean a()
  {
    if (h >= 0) {
      return h == 1;
    }
    String[] arrayOfString = QzoneConfig.getInstance().getConfig("QZoneSetting", "GenerateGifBlackList", "X9007,MI 2C,A0001").split(",");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (Build.MODEL.equalsIgnoreCase(str))
      {
        h = 1;
        return true;
      }
      i += 1;
    }
    h = 0;
    return false;
  }
  
  public static int b()
  {
    int i = a();
    if (i == 1) {
      return a;
    }
    if (i == 2) {
      return b;
    }
    if (i == 3) {
      return c;
    }
    return 720;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.gifCoderWnsConfig
 * JD-Core Version:    0.7.0.1
 */