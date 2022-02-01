package cooperation.qzone.util;

import android.os.Build;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QzoneConfig;

public class gifCoderWnsConfig
{
  public static final int DEFAULT_DELAY;
  public static final int DEFAULT_GIF_MAX_DELAY = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_gif_max_speed", 20);
  public static final int DEFAULT_GIF_MIN_MULTIPLE_DELAY = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_gif_min_multiple_speed", 3);
  public static final int DEFAULT_GIF_SIZE_LIMIT;
  public static final int DEVICE_LEVEL_HIGH = 3;
  public static final int DEVICE_LEVEL_LOW = 1;
  public static final int DEVICE_LEVEL_MIDDLE = 2;
  private static int generateGifBlackList = -1;
  public static final int highDeviceGifSize;
  public static final int lowerDeviceGifSize = QzoneConfig.getInstance().getConfig("PhotoUpload", "createGifLowDeviceSize", 720);
  public static final int middleDeviceGifSize = QzoneConfig.getInstance().getConfig("PhotoUpload", "createGifMiddleDeviceSize", 720);
  
  static
  {
    highDeviceGifSize = QzoneConfig.getInstance().getConfig("PhotoUpload", "createGifHighDeviceSize", 720);
    DEFAULT_DELAY = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_gif_delay", 200);
    DEFAULT_GIF_SIZE_LIMIT = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_gif_size_limit", 64);
  }
  
  public static int getCurrentDeviceGifSize()
  {
    int i = getCurrentDeviceLevel();
    if (i == 1) {
      return lowerDeviceGifSize;
    }
    if (i == 2) {
      return middleDeviceGifSize;
    }
    if (i == 3) {
      return highDeviceGifSize;
    }
    return 720;
  }
  
  public static int getCurrentDeviceLevel()
  {
    if (((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(2, 2)) {
      return 3;
    }
    if (((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(1, 1)) {
      return 2;
    }
    return 1;
  }
  
  public static boolean isQzoneGenerateGifBlackList()
  {
    int i = generateGifBlackList;
    boolean bool = false;
    if (i >= 0)
    {
      if (i == 1) {
        bool = true;
      }
      return bool;
    }
    String[] arrayOfString = QzoneConfig.getInstance().getConfig("QZoneSetting", "GenerateGifBlackList", "X9007,MI 2C,A0001").split(",");
    int j = arrayOfString.length;
    i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (Build.MODEL.equalsIgnoreCase(str))
      {
        generateGifBlackList = 1;
        return true;
      }
      i += 1;
    }
    generateGifBlackList = 0;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.gifCoderWnsConfig
 * JD-Core Version:    0.7.0.1
 */