package cooperation.qqcircle.report;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Map;

public class QCircleReportFirstLogin
{
  public static String FEED_ID = "feedid";
  public static String FIRST_LOGIN_SOURCE = "first login source";
  public static String FROM_OUTSIDE = "from";
  public static final int H5_PAGE_CONTENT = 10;
  public static final int H5_PAGE_USER = 5;
  public static final int H5_PAG_TAG = 15;
  public static String JUMP_FROM = "key_jump_from";
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
  public static String SHARE_ID = "shareuin";
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
    return RFApplication.getApplication().getApplicationContext().getSharedPreferences(paramString, paramInt);
  }
  
  public static void recordFirstLoginSource(Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get(SHARE_CATEGORY);
    String str2 = (String)paramMap.get(SHARE_ENTRANCE);
    String str3 = (String)paramMap.get(JUMP_FROM);
    paramMap = (String)paramMap.get(FROM_OUTSIDE);
    int i = 0;
    int m = 0;
    int j = 0;
    int k = 999;
    if ((str1 != null) && (str2 != null))
    {
      try
      {
        i = Integer.parseInt(str1);
        try
        {
          k = Integer.parseInt(str2);
          j = k;
        }
        catch (Exception paramMap) {}
        paramMap.printStackTrace();
      }
      catch (Exception paramMap)
      {
        i = 0;
      }
      if (((i == 2) || (i == 3)) && (j == 7))
      {
        i = 27;
      }
      else if ((i == 1) && (j == 7))
      {
        i = 26;
      }
      else
      {
        if (j == 10)
        {
          if (i == 5)
          {
            i = 30;
            break label317;
          }
          if (i == 6)
          {
            i = 31;
            break label317;
          }
          if (i == 7)
          {
            i = 32;
            break label317;
          }
        }
        i = (i - 1) * 5 + j;
      }
    }
    else if (str3 != null)
    {
      try
      {
        j = Integer.parseInt(str3);
        i = j;
      }
      catch (Exception paramMap)
      {
        paramMap.printStackTrace();
      }
      if (i != 3)
      {
        if (i != 4)
        {
          if ((i != 5) && (i != 9))
          {
            if (i != 20)
            {
              if (i != 24) {
                i = k;
              } else {
                i = 24;
              }
            }
            else {
              i = 20;
            }
          }
          else {
            i = 17;
          }
        }
        else {
          i = 18;
        }
      }
      else {
        i = 19;
      }
    }
    else
    {
      i = k;
      if (paramMap != null)
      {
        try
        {
          j = Integer.parseInt(paramMap);
        }
        catch (Exception paramMap)
        {
          paramMap.printStackTrace();
          j = m;
        }
        i = k;
        if (j == 10) {
          i = 16;
        }
      }
    }
    label317:
    paramMap = new StringBuilder();
    paramMap.append(i);
    paramMap.append("");
    firstLoginSource = paramMap.toString();
  }
  
  public void setIsReported(boolean paramBoolean)
  {
    isReported.edit().putString("", Boolean.toString(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportFirstLogin
 * JD-Core Version:    0.7.0.1
 */