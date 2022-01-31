package com.tencent.mobileqq.redtouch;

import ahfy;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import mqq.os.MqqHandler;

public class VipBannerInfo
{
  public int a;
  public long a;
  public BusinessInfoCheckUpdate.AppInfo a;
  public String a;
  public int b;
  public long b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public static void a(Conversation paramConversation)
  {
    if ((paramConversation == null) || (paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(19) != 0)) {}
    SharedPreferences localSharedPreferences;
    MqqHandler localMqqHandler;
    RedTouchManager localRedTouchManager;
    do
    {
      do
      {
        return;
        localSharedPreferences = paramConversation.a().getSharedPreferences("mobileQQ", 0);
        localMqqHandler = paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a();
      } while (localMqqHandler == null);
      localRedTouchManager = (RedTouchManager)paramConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    } while (localRedTouchManager == null);
    ThreadManager.getFileThreadHandler().post(new ahfy(localRedTouchManager, localSharedPreferences, paramConversation, localMqqHandler));
  }
  
  public static void b(Conversation paramConversation)
  {
    if ((paramConversation != null) && (paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(19) != 0))
    {
      paramConversation = paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a();
      if (paramConversation != null)
      {
        paramConversation.removeMessages(9);
        paramConversation.sendEmptyMessage(9);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.VipBannerInfo
 * JD-Core Version:    0.7.0.1
 */