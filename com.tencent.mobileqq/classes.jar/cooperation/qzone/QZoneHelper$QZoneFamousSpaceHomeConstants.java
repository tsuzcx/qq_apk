package cooperation.qzone;

public class QZoneHelper$QZoneFamousSpaceHomeConstants
{
  public static final String ACTION_URL = "https://h5.qzone.qq.com/vpage/cover/{uin}/vpage-index?screenWidth={screenWidth}&qua={qua}&_proxy=1&_wv=1029&bottom={bottom}";
  public static final String FAMOUS_SPACE_HOME_URL_PREFIX = "https://mp.qzone.qq.com/u/";
  
  public static String getFamousSpaceHomeActionUrl()
  {
    return LocalMultiProcConfig.getString("QzoneFamousSpaceSp", QZoneHelper.UserInfo.getInstance().qzone_uin, "https://h5.qzone.qq.com/vpage/cover/{uin}/vpage-index?screenWidth={screenWidth}&qua={qua}&_proxy=1&_wv=1029&bottom={bottom}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.QZoneFamousSpaceHomeConstants
 * JD-Core Version:    0.7.0.1
 */