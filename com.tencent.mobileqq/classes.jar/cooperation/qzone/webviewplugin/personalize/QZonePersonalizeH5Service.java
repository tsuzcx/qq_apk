package cooperation.qzone.webviewplugin.personalize;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.webviewplugin.MapUtil;
import java.util.Map;

public class QZonePersonalizeH5Service
{
  public static final String AVATAR_SP_KEY = "key_personalize_prefix_19";
  public static final String CARDDECORATE_SP_KEY = "key_personalize_prefix_18";
  public static final String CUSTOM_VIP_KEY = "key_personalize_prefix_23";
  public static final String FACADE_SP_KEY = "key_personalize_prefix_20";
  public static final String FLOATOBJECT_SP_KEY = "key_personalize_prefix_21";
  private static final String KEY_PERSONALIZE_PREFIX = "key_personalize_prefix";
  public static final String NAVIDECO_SP_KEY = "key_personalize_prefix_22";
  private static final String QZONE_MALL_CLICK_TIME_MAP_KEY = "CTIME_MAP";
  private static final int mAvatarId = 19;
  private static final int mCardId = 18;
  private static final int mCustomVip = 23;
  private static final int mFacadeId = 20;
  private static final int mFloatObjectId = 21;
  private static final int mNaviDeco = 22;
  
  public static Map<Integer, Long> getCTime(Long paramLong)
  {
    return getCTimeByUin(paramLong.longValue());
  }
  
  private static Map<Integer, Long> getCTimeByUin(long paramLong)
  {
    Map localMap = MapUtil.stringToMap(LocalMultiProcConfig.getString("CTIME_MAP" + paramLong, ""));
    if (!localMap.containsKey(Integer.valueOf(0))) {
      localMap.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    return localMap;
  }
  
  public static void setCTime(Map<Integer, Long> paramMap, Long paramLong)
  {
    LocalMultiProcConfig.putString("CTIME_MAP" + paramLong, MapUtil.mapToString(paramMap));
  }
  
  public static void updateCTime(Integer paramInteger, Long paramLong)
  {
    Map localMap = getCTime(paramLong);
    localMap.put(paramInteger, Long.valueOf(System.currentTimeMillis() / 1000L));
    if (QLog.isColorLevel()) {
      QLog.d("QZonePersonalizeH5Service", 2, "updateCTime: " + paramInteger + "timestamp: " + System.currentTimeMillis() / 1000L);
    }
    setCTime(localMap, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZonePersonalizeH5Service
 * JD-Core Version:    0.7.0.1
 */