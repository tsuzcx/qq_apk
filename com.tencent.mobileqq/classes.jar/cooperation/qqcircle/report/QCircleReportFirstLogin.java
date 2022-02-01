package cooperation.qqcircle.report;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Map;
import mqq.app.MobileQQ;

public class QCircleReportFirstLogin
{
  public static String FEED_ID = "feedid";
  public static String FIRST_LOGIN_SOURCE = "first login source";
  public static String FROM_OUTSIDE;
  public static final int H5_PAGE_CONTENT = 10;
  public static final int H5_PAGE_USER = 5;
  public static final int H5_PAG_TAG = 15;
  public static String JUMP_FROM;
  public static final int QQTAB_SEARCH = 27;
  public static final int QQ_AIO_CONTENT = 6;
  public static final int QQ_AIO_TAG = 11;
  public static final int QQ_AIO_USER = 1;
  public static final int QQ_GROUP_ROBOT_DETAIL = 30;
  public static final int QQ_GROUP_ROBOT_TAGPAGE = 31;
  public static final int QQ_GROUP_ROBOT_UPDTE = 32;
  public static final int QQ_GROUP_UPDATE = 24;
  public static final int QQ_KANDIAN = 22;
  public static final int QQ_SEARCH = 23;
  public static final int QQ_SEARCH_ICON = 26;
  public static final int QZONE_CONTENT = 7;
  public static final int QZONE_TAG = 12;
  public static final int QZONE_USER = 2;
  public static String SHARE_CATEGORY = "sharecategory";
  public static String SHARE_ENTRANCE = "shareentrance";
  public static String SHARE_ID;
  public static final int TICKET_INVIET = 16;
  public static final int UNKNOWN = 999;
  public static final int WECHAT_AIO_CONTENT = 8;
  public static final int WECHAT_AIO_TAG = 13;
  public static final int WECHAT_AIO_USER = 3;
  public static final int WECHAT_MOMENTS_CONTENT = 9;
  public static final int WECHAT_MOMENTS_TAG = 14;
  public static final int WECHAT_MOMENTS_USER = 4;
  public static final int WEWORLD_ACTIVE_TAB = 19;
  public static final int WEWORLD_AIO_ARK = 20;
  public static final int WEWORLD_MEGPAGE = 18;
  public static final int WEWORLD_PROFILE = 17;
  public static final int WEWORLD_PUB_MSG = 21;
  public static boolean firstEnterQCircle = false;
  public static String firstLoginSource = "";
  public static SharedPreferences isReported = getSharedPreferences("isReported", 0);
  
  static
  {
    JUMP_FROM = "key_jump_from";
    FROM_OUTSIDE = "from";
    SHARE_ID = "shareuin";
  }
  
  public static FeedCloudCommon.Entry getFirstLoginEntry()
  {
    FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
    localEntry.key.set("FIRST_LOGIN_SOURCE");
    localEntry.value.set(getFirstLoginSource());
    return localEntry;
  }
  
  public static String getFirstLoginSource()
  {
    return firstLoginSource;
  }
  
  public static SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return MobileQQ.sMobileQQ.getApplicationContext().getSharedPreferences(paramString, paramInt);
  }
  
  public static void recordFirstLoginSource(Map<String, String> paramMap)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    String str1 = (String)paramMap.get(SHARE_CATEGORY);
    String str2 = (String)paramMap.get(SHARE_ENTRANCE);
    String str3 = (String)paramMap.get(JUMP_FROM);
    paramMap = (String)paramMap.get(FROM_OUTSIDE);
    if ((str1 != null) && (str2 != null)) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt(str1);
        paramMap.printStackTrace();
      }
      catch (Exception paramMap)
      {
        try
        {
          j = Integer.parseInt(str2);
          k = j;
          j = i;
          m = (j - 1) * 5 + k;
          if (((j != 2) && (j != 3)) || (k != 7)) {
            break label150;
          }
          i = 27;
          firstLoginSource = i + "";
          return;
        }
        catch (Exception paramMap)
        {
          int m;
          break label141;
        }
        paramMap = paramMap;
        i = 0;
      }
      label141:
      j = i;
      continue;
      label150:
      if ((j == 1) && (k == 7))
      {
        i = 26;
        continue;
      }
      i = m;
      if (k != 10) {
        continue;
      }
      if (j == 5)
      {
        i = 30;
        continue;
      }
      if (j == 6)
      {
        i = 31;
        continue;
      }
      i = m;
      if (j != 7) {
        continue;
      }
      i = 32;
      continue;
      if (str3 != null)
      {
        try
        {
          j = Integer.parseInt(str3);
          i = j;
        }
        catch (Exception paramMap)
        {
          for (;;)
          {
            paramMap.printStackTrace();
          }
          i = 19;
        }
        switch (i)
        {
        }
      }
      label288:
      while (paramMap == null)
      {
        i = 999;
        break;
        break;
        i = 18;
        break;
        i = 17;
        break;
        i = 20;
        break;
        i = 24;
        break;
      }
      try
      {
        i = Integer.parseInt(paramMap);
        if (i != 10) {
          break label288;
        }
        i = 16;
      }
      catch (Exception paramMap)
      {
        for (;;)
        {
          paramMap.printStackTrace();
          i = j;
        }
      }
    }
  }
  
  public void setIsReported(boolean paramBoolean)
  {
    isReported.edit().putString("", Boolean.toString(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportFirstLogin
 * JD-Core Version:    0.7.0.1
 */