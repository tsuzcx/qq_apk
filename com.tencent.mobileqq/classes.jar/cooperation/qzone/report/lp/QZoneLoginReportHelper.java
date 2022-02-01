package cooperation.qzone.report.lp;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;

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
    if (paramIntent != null)
    {
      if (paramInt <= 0) {
        return;
      }
      paramIntent.putExtra("login_from_mqq", paramInt);
    }
  }
  
  public static void handleLoginFromIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    int i = paramIntent.getIntExtra("login_from_mqq", 0);
    if (i == 0) {
      return;
    }
    paramIntent = new LpReportInfo_pf00034(i);
    LpReportManager.getInstance().reportToPF00034(paramIntent);
  }
  
  public static void handleLoginToMyAlbum(Intent paramIntent, int paramInt)
  {
    if (paramIntent != null)
    {
      if (paramInt <= 0) {
        return;
      }
      if (paramInt != 5)
      {
        if (paramInt != 12) {
          return;
        }
        setLoginFromSearch(paramIntent);
        return;
      }
      setLoginFromMyAlbum(paramIntent);
    }
  }
  
  public static boolean needAddLoginFromAIOFeedCard(Intent paramIntent, String paramString)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramString))) {
      return paramString.equals("mqqChat.QzoneCard");
    }
    return false;
  }
  
  public static boolean needAddLoginFromAIOFeedShare(Intent paramIntent, String paramString)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramString))) {
      return paramString.equals("mqqChat");
    }
    return false;
  }
  
  public static boolean needAddLoginFromFriendProfile(Intent paramIntent, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      bool1 = bool2;
      if (paramInt == 5) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean needAddLoginFromLebaTab(Intent paramIntent, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      bool1 = bool2;
      if (paramString.startsWith("com.qzone"))
      {
        bool1 = bool2;
        if (paramString.endsWith("QZoneFriendFeedActivity")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean needAddLoginFromQunAlbum(Intent paramIntent, int paramInt)
  {
    boolean bool = false;
    if (paramIntent == null) {
      return false;
    }
    if (paramInt == ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getChatSettingForTroopQZONEPHOTOCode()) {
      bool = true;
    }
    return bool;
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
      int j;
      try
      {
        j = Integer.parseInt(paramString);
        if (j > 0) {
          break label49;
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.e(LpReportInfo_pf00034.TAG, 1, paramString, new Object[0]);
        return;
      }
      paramString = new LpReportInfo_pf00034(i);
      LpReportManager.getInstance().reportToPF00034(paramString);
      return;
      label49:
      int i = 11;
      if (j != 8)
      {
        if (j != 11)
        {
          if (j != 12) {
            i = 8;
          }
        }
        else {
          i = 10;
        }
      }
      else {
        i = 9;
      }
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
  
  public static void reportLoginFromQZoneMsgFeed() {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.QZoneLoginReportHelper
 * JD-Core Version:    0.7.0.1
 */