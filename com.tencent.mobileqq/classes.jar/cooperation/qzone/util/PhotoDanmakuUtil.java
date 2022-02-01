package cooperation.qzone.util;

import android.os.Build;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QzoneConfig;

public class PhotoDanmakuUtil
{
  private static final String TAG = "PhotoDanmakuUtil";
  private static final int cpuLevelLimit = QzoneConfig.getInstance().getConfig("QZoneSetting", "PictureViewerPhotoDanmakuCpuLevel", 1);
  private static PhotoDanmakuUtil instance;
  private static final String mPhotoDanmakuBlackList = QzoneConfig.getInstance().getConfig("QZoneSetting", "PictureViewerPhotoDanmakuBlackList", "");
  private static final int memoryLevelLimit = QzoneConfig.getInstance().getConfig("QZoneSetting", "PictureViewerPhotoDanmakuMemoryLevel", 1);
  private volatile boolean enableP2VFunc = false;
  private volatile String g_photoDanmakuBlacklist = null;
  private long phoneMemory = -1L;
  
  public PhotoDanmakuUtil()
  {
    if (this.phoneMemory == -1L) {
      this.phoneMemory = (((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).getTotalMem() / 1024L);
    }
  }
  
  public static PhotoDanmakuUtil getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new PhotoDanmakuUtil();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private boolean isBuildModelInList(String paramString)
  {
    try
    {
      String str = Build.MODEL;
      if ((str != null) && (str.length() != 0))
      {
        StringBuilder localStringBuilder;
        if (QZLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("buildModel is '");
          localStringBuilder.append(str);
          localStringBuilder.append("'");
          QZLog.d("PhotoDanmakuUtil", 2, localStringBuilder.toString());
        }
        if (paramString != null)
        {
          if (paramString.length() == 0) {
            return false;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(",");
          localStringBuilder.append(str);
          localStringBuilder.append(",");
          str = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(",");
          localStringBuilder.append(paramString);
          localStringBuilder.append(",");
          if (localStringBuilder.toString().contains(str))
          {
            QZLog.i("PhotoDanmakuUtil", 1, "命中禁止大图浮层策略");
            return true;
          }
        }
      }
      else
      {
        QZLog.i("PhotoDanmakuUtil", 1, "buildModel is empty, hide PhotoDanmaku .命中禁止大图浮层策略");
        return true;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    return false;
  }
  
  public boolean isEnablePhotoDanmakuFunc()
  {
    String str = mPhotoDanmakuBlackList;
    if ((str != null) && (!str.equals(this.g_photoDanmakuBlacklist)))
    {
      this.enableP2VFunc = (isBuildModelInList(mPhotoDanmakuBlackList) ^ true);
      this.g_photoDanmakuBlacklist = mPhotoDanmakuBlackList;
    }
    return (this.enableP2VFunc) && (((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(memoryLevelLimit, cpuLevelLimit));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.PhotoDanmakuUtil
 * JD-Core Version:    0.7.0.1
 */