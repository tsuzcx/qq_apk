package cooperation.qzone.util;

public class QZoneLogTags
{
  public static final String FEEDS_TAG = "Feeds";
  public static String LOG_TAG_FEEDALERT;
  public static String LOG_TAG_NAVIGATOR;
  public static String LOG_TAG_PERSION_CARD = "QZoneCardLogic" + LOG_TAG_SEPERATOR;
  public static String LOG_TAG_PERSONALIZE;
  public static String LOG_TAG_SEPERATOR = ".";
  public static String LOG_TAG_SUB_ACCOUNT_PUSH;
  public static String LOG_TAG_SUB_ACCOUNT_REQUEST;
  public static String LOG_TAG_TRACE_VIEW;
  public static String LOG_TAG_UNDEALCOUNT = "UndealCount" + LOG_TAG_SEPERATOR;
  public static String LOG_TAG_ZEBRAALBUM;
  
  static
  {
    LOG_TAG_NAVIGATOR = "NavigatorBar" + LOG_TAG_SEPERATOR;
    LOG_TAG_ZEBRAALBUM = "ZebraAlbum" + LOG_TAG_SEPERATOR;
    LOG_TAG_PERSONALIZE = "QZonePersonalize" + LOG_TAG_SEPERATOR;
    LOG_TAG_FEEDALERT = "FeedAlert" + LOG_TAG_SEPERATOR;
    LOG_TAG_TRACE_VIEW = "QzonePerformanceTracer" + LOG_TAG_SEPERATOR;
    LOG_TAG_SUB_ACCOUNT_PUSH = "QZoneSubAccountPush" + LOG_TAG_SEPERATOR;
    LOG_TAG_SUB_ACCOUNT_REQUEST = "QZoneSubAccountRequest" + LOG_TAG_SEPERATOR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.QZoneLogTags
 * JD-Core Version:    0.7.0.1
 */