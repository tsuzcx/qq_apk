package cooperation.qzone.report.lp;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class QZoneLoginReportHelper
{
  public static final String KEY_LOGIN_FROM_MQQ = "login_from_mqq";
  public static final int LOGIN_FROM_ACTIVATE_FRIEND = 24;
  public static final int LOGIN_FROM_AIO_FEED_CARD = 3;
  public static final int LOGIN_FROM_AIO_SHARE = 4;
  public static final int LOGIN_FROM_EXTEND_FEED = 23;
  public static final int LOGIN_FROM_FRIEND_PROFILE = 2;
  public static final int LOGIN_FROM_LEBA_TAB = 1;
  public static final int LOGIN_FROM_MQQ_PUSH = 13;
  public static final int LOGIN_FROM_MQQ_SEARCH = 12;
  public static final int LOGIN_FROM_MY_ALBUM = 5;
  public static final int LOGIN_FROM_MY_FAV = 6;
  public static final int LOGIN_FROM_PUBLIC_ACCOUNT_BTM_MY_ALBUM = 11;
  public static final int LOGIN_FROM_PUBLIC_ACCOUNT_BTM_VIEW_FRIEND_FEEDS = 10;
  public static final int LOGIN_FROM_PUBLIC_ACCOUNT_OTHER_MSG = 8;
  public static final int LOGIN_FROM_PUBLIC_ACCOUNT_VIEW_FRIEND_FEEDS_MSG = 9;
  public static final int LOGIN_FROM_QUN_ALBUM = 14;
  public static final int LOGIN_FROM_SIMPLE_MODE = 27;
  public static final int PA_TYPE_BTM_VIEW_FRIEND_FEEDS = 11;
  public static final int PA_TYPE_BTM_VIEW_MY_ALBUM = 12;
  public static final int PA_TYPE_VIEW_FRIEND_FEEDS_MSG = 8;
  
  private static void addLoginInfo(Intent paramIntent, int paramInt)
  {
    if ((paramIntent == null) || (paramInt <= 0)) {
      return;
    }
    paramIntent.putExtra("login_from_mqq", paramInt);
  }
  
  public static void handleLoginFromIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    do
    {
      return;
      i = paramIntent.getIntExtra("login_from_mqq", 0);
    } while (i == 0);
    paramIntent = new LpReportInfo_pf00034(i);
    LpReportManager.getInstance().reportToPF00034(paramIntent);
  }
  
  public static void handleLoginToMyAlbum(Intent paramIntent, int paramInt)
  {
    if ((paramIntent == null) || (paramInt <= 0)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
      setLoginFromMyAlbum(paramIntent);
      return;
    }
    setLoginFromSearch(paramIntent);
  }
  
  public static boolean needAddLoginFromAIOFeedCard(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    return paramString.equals("mqqChat.QzoneCard");
  }
  
  public static boolean needAddLoginFromAIOFeedShare(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    return paramString.equals("mqqChat");
  }
  
  public static boolean needAddLoginFromFriendProfile(Intent paramIntent, String paramString, int paramInt)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString))) {}
    while (paramInt != 5) {
      return false;
    }
    return true;
  }
  
  public static boolean needAddLoginFromLebaTab(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString))) {}
    while ((!paramString.startsWith("com.qzone")) || (!paramString.endsWith("QZoneFriendFeedActivity"))) {
      return false;
    }
    return true;
  }
  
  public static boolean needAddLoginFromQunAlbum(Intent paramIntent, int paramInt)
  {
    if (paramIntent == null) {}
    while (paramInt != 7) {
      return false;
    }
    return true;
  }
  
  public static void reportLoginFromActivateFriend()
  {
    LpReportInfo_pf00034 localLpReportInfo_pf00034 = new LpReportInfo_pf00034(24);
    LpReportManager.getInstance().reportToPF00034(localLpReportInfo_pf00034);
  }
  
  public static void reportLoginFromExtendFriend()
  {
    LpReportInfo_pf00034 localLpReportInfo_pf00034 = new LpReportInfo_pf00034(23);
    LpReportManager.getInstance().reportToPF00034(localLpReportInfo_pf00034);
  }
  
  public static void reportLoginFromMQQPublicAccount(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramString);
        if (i <= 0) {
          break;
        }
        switch (i)
        {
        case 8: 
          paramString = new LpReportInfo_pf00034(i);
          LpReportManager.getInstance().reportToPF00034(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e(LpReportInfo_pf00034.TAG, 1, paramString, new Object[0]);
        return;
      }
      int i = 9;
      continue;
      i = 10;
      continue;
      i = 11;
      continue;
      i = 8;
    }
  }
  
  public static void reportLoginFromMQQPush()
  {
    LpReportInfo_pf00034 localLpReportInfo_pf00034 = new LpReportInfo_pf00034(13);
    LpReportManager.getInstance().reportToPF00034(localLpReportInfo_pf00034);
  }
  
  public static void reportLoginFromMQQSearchH5()
  {
    LpReportInfo_pf00034 localLpReportInfo_pf00034 = new LpReportInfo_pf00034(12);
    LpReportManager.getInstance().reportToPF00034(localLpReportInfo_pf00034);
  }
  
  public static void reportLoginFromQQAio()
  {
    LpReportInfo_pf00034 localLpReportInfo_pf00034 = new LpReportInfo_pf00034(26);
    LpReportManager.getInstance().reportToPF00034(localLpReportInfo_pf00034);
  }
  
  public static void reportLoginFromQZoneMsgBox()
  {
    LpReportInfo_pf00034 localLpReportInfo_pf00034 = new LpReportInfo_pf00034(16);
    LpReportManager.getInstance().reportToPF00034(localLpReportInfo_pf00034);
  }
  
  public static void reportLoginFromQunAlbum()
  {
    LpReportInfo_pf00034 localLpReportInfo_pf00034 = new LpReportInfo_pf00034(14);
    LpReportManager.getInstance().reportToPF00034(localLpReportInfo_pf00034);
  }
  
  public static void reportLoginFromSimpleMode()
  {
    LpReportInfo_pf00034 localLpReportInfo_pf00034 = new LpReportInfo_pf00034(27);
    LpReportManager.getInstance().reportToPF00034(localLpReportInfo_pf00034);
  }
  
  public static void setLoginFromAIOFeedCard(Intent paramIntent)
  {
    addLoginInfo(paramIntent, 3);
  }
  
  public static void setLoginFromAIOFeedShare(Intent paramIntent)
  {
    addLoginInfo(paramIntent, 4);
  }
  
  public static void setLoginFromFriendProfile(Intent paramIntent)
  {
    addLoginInfo(paramIntent, 2);
  }
  
  public static void setLoginFromLebaTab(Intent paramIntent)
  {
    addLoginInfo(paramIntent, 1);
  }
  
  public static void setLoginFromMyAlbum(Intent paramIntent)
  {
    addLoginInfo(paramIntent, 5);
  }
  
  public static void setLoginFromMyFav(Intent paramIntent)
  {
    addLoginInfo(paramIntent, 6);
  }
  
  public static void setLoginFromSearch(Intent paramIntent)
  {
    addLoginInfo(paramIntent, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.report.lp.QZoneLoginReportHelper
 * JD-Core Version:    0.7.0.1
 */