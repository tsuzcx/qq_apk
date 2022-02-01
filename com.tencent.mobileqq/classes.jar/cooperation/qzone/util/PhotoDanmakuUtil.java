package cooperation.qzone.util;

import android.os.Build;
import common.config.service.QzoneConfig;

public class PhotoDanmakuUtil
{
  private static final String TAG = "PhotoDanmakuUtil";
  private static final int cpuLevelLimit = QzoneConfig.getInstance().getConfig("QZoneSetting", "PictureViewerPhotoDanmakuCpuLevel", 1);
  private static PhotoDanmakuUtil instance;
  private static final String mPhotoDanmakuBlackList = QzoneConfig.getInstance().getConfig("QZoneSetting", "PictureViewerPhotoDanmakuBlackList", "");
  private static final int memoryLevelLimit = QzoneConfig.getInstance().getConfig("QZoneSetting", "PictureViewerPhotoDanmakuMemoryLevel", 1);
  private volatile boolean enableP2VFunc;
  private volatile String g_photoDanmakuBlacklist;
  private long phoneMemory = -1L;
  
  public PhotoDanmakuUtil()
  {
    if (this.phoneMemory == -1L) {
      this.phoneMemory = (QzoneHardwareRestriction.getTotalMem() / 1024L);
    }
  }
  
  public static PhotoDanmakuUtil getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new PhotoDanmakuUtil();
      }
      return instance;
    }
    finally {}
  }
  
  private boolean isBuildModelInList(String paramString)
  {
    try
    {
      String str = Build.MODEL;
      if ((str == null) || (str.length() == 0))
      {
        QZLog.i("PhotoDanmakuUtil", 1, "buildModel is empty, hide PhotoDanmaku .命中禁止大图浮层策略");
        return true;
      }
      if (QZLog.isColorLevel()) {
        QZLog.d("PhotoDanmakuUtil", 2, "buildModel is '" + str + "'");
      }
      if ((paramString == null) || (paramString.length() == 0)) {
        break label150;
      }
      str = "," + str + ",";
      if (("," + paramString + ",").contains(str))
      {
        QZLog.i("PhotoDanmakuUtil", 1, "命中禁止大图浮层策略");
        return true;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    return false;
    label150:
    return false;
  }
  
  public boolean isEnablePhotoDanmakuFunc()
  {
    if ((mPhotoDanmakuBlackList != null) && (!mPhotoDanmakuBlackList.equals(this.g_photoDanmakuBlacklist))) {
      if (isBuildModelInList(mPhotoDanmakuBlackList)) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      this.enableP2VFunc = bool;
      this.g_photoDanmakuBlacklist = mPhotoDanmakuBlackList;
      if ((!this.enableP2VFunc) || (!QzoneHardwareRestriction.meetHardwareRestriction(memoryLevelLimit, cpuLevelLimit))) {
        break;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.PhotoDanmakuUtil
 * JD-Core Version:    0.7.0.1
 */