package com.tencent.mobileqq.nearby.redtouch;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.LikeRankingListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class Util
{
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMedalConfigChanged configOn:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" refresh parents");
      QLog.i("Q.redtouch.util", 2, ((StringBuilder)localObject).toString());
    }
    paramQQAppInterface = (LocalRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    Object localObject = paramQQAppInterface.a(10016);
    if (paramQQAppInterface.a((RedTouchItem)localObject))
    {
      ((RedTouchItem)localObject).isClosed = paramBoolean;
      paramQQAppInterface.d(10016);
    }
    localObject = paramQQAppInterface.a(10015);
    if (paramQQAppInterface.a((RedTouchItem)localObject))
    {
      ((RedTouchItem)localObject).isClosed = paramBoolean;
      paramQQAppInterface.d(10015);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("medal_wall_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    boolean bool2 = false;
    boolean bool3 = ((SharedPreferences)localObject).getBoolean("medal_switch_disable", false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("card.medalSwitchDisable=");
      ((StringBuilder)localObject).append(bool3);
      QLog.d("Q.redtouch.util", 2, ((StringBuilder)localObject).toString());
    }
    int i;
    if (SharedPreUtils.U(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin()) != 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (QLog.isColorLevel())) {
      QLog.d("Q.redtouch.util", 2, "medal config off");
    }
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLikeRankListConfigChanged configOn:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" refresh parents");
      QLog.i("Q.redtouch.util", 2, ((StringBuilder)localObject).toString());
    }
    paramQQAppInterface = (LocalRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    Object localObject = paramQQAppInterface.a(100601);
    if (paramQQAppInterface.a((RedTouchItem)localObject))
    {
      ((RedTouchItem)localObject).isClosed = paramBoolean;
      paramQQAppInterface.d(100601);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return ((LikeRankingListManager)paramQQAppInterface.getManager(QQManagerFactory.LIKE_RANKING_LIST_MANAGER)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.Util
 * JD-Core Version:    0.7.0.1
 */