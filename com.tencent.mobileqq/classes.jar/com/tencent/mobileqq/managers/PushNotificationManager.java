package com.tencent.mobileqq.managers;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.QConfPushBean;
import com.tencent.mobileqq.data.PushSwitchGrayTipsInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.manager.Manager;

public class PushNotificationManager
  implements Manager
{
  public static int a = 1;
  public static int b = 1;
  public static int c = 2;
  private long jdField_a_of_type_Long = 0L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QConfPushBean jdField_a_of_type_ComTencentMobileqqConfigBusinessQConfPushBean;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private int d = -1;
  
  public PushNotificationManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    ThreadManager.executeOnSubThread(new PushNotificationManager.1(this, paramQQAppInterface));
  }
  
  private int a()
  {
    Object localObject = Long.valueOf(System.currentTimeMillis());
    if ((this.d >= 0) && (((Long)localObject).longValue() - this.jdField_a_of_type_Long < 86400000L))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mTodayHadShowCount=");
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append(" mTodayZeroTimeMillis=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        QLog.d("PushNotificationManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = SharedPreUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      }
      if (((Long)localObject).longValue() - this.jdField_a_of_type_Long > 86400000L)
      {
        this.jdField_a_of_type_Long = TimeFormatterUtils.a(((Long)localObject).longValue());
        SharedPreUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_Long);
        SharedPreUtils.X(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
        this.d = 0;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Today First Query, mTodayHadShowCount=");
          ((StringBuilder)localObject).append(this.d);
          ((StringBuilder)localObject).append(" mTodayZeroTimeMillis=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
          QLog.d("PushNotificationManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.d = SharedPreUtils.aL(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Query, mTodayHadShowCount=");
          ((StringBuilder)localObject).append(this.d);
          ((StringBuilder)localObject).append(" mTodayZeroTimeMillis=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
          QLog.d("PushNotificationManager", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    return this.d;
  }
  
  private boolean a(SessionInfo paramSessionInfo)
  {
    Object localObject1;
    if (paramSessionInfo.jdField_a_of_type_Int == 0) {
      localObject1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      break;
      if ((paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000)) {
        localObject1 = "";
      } else {
        localObject1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      }
    }
    Object localObject2;
    if ((QLog.isColorLevel()) && (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sessionInfo.curType=");
      ((StringBuilder)localObject2).append(paramSessionInfo.jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append(" uin==null sessionInfo.realTroopUin=");
      ((StringBuilder)localObject2).append(paramSessionInfo.c);
      QLog.d("PushNotificationManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("uin=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("mApp.getAccount()=");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QLog.d("PushNotificationManager", 2, ((StringBuilder)localObject2).toString());
    }
    try
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(PushSwitchGrayTipsInfo.class, true, "uin=? and toUin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localObject1 }, null, null, null, null);
      if ((localObject2 != null) && (((List)localObject2).size() != 0))
      {
        paramSessionInfo = (PushSwitchGrayTipsInfo)((List)localObject2).get(0);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("pushSwitchGrayTipsInfo.lastShowTime=");
          ((StringBuilder)localObject1).append(paramSessionInfo.lastShowTime);
          ((StringBuilder)localObject1).append(" mTodayZeroTimeMillis=");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
          QLog.d("PushNotificationManager", 2, ((StringBuilder)localObject1).toString());
        }
        if (paramSessionInfo.lastShowTime >= this.jdField_a_of_type_Long) {
          return false;
        }
        paramSessionInfo.lastShowTime = this.jdField_a_of_type_Long;
        paramSessionInfo.showCount += 1;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramSessionInfo);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PushNotificationManager", 2, "result == null || result.size() == 0");
      }
      paramSessionInfo = new PushSwitchGrayTipsInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), (String)localObject1, paramSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long, 1);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramSessionInfo);
      return true;
    }
    finally {}
    for (;;)
    {
      throw paramSessionInfo;
    }
  }
  
  private void b(SessionInfo paramSessionInfo, int paramInt)
  {
    Object localObject;
    if (paramSessionInfo.jdField_a_of_type_Int == 0) {
      localObject = a().a();
    }
    for (String str = a().b();; str = a().d())
    {
      break;
      if ((paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000))
      {
        str = "";
        localObject = str;
        break;
      }
      localObject = a().c();
    }
    UniteGrayTipParam localUniteGrayTipParam = new UniteGrayTipParam(paramSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, paramSessionInfo.jdField_a_of_type_Int, -5023, 655383, 0L);
    if (paramSessionInfo.jdField_a_of_type_Int == 0) {
      localUniteGrayTipParam.jdField_a_of_type_Long = (MessageCache.a() + 1L);
    }
    int i = ((String)localObject).indexOf(str);
    if (i >= 0)
    {
      paramSessionInfo = new Bundle();
      paramSessionInfo.putInt("key_action", 40);
      paramSessionInfo.putString("textColor", "");
      paramSessionInfo.putString("image_resource", null);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      paramSessionInfo.putString("key_action_DATA", localStringBuilder.toString());
      localUniteGrayTipParam.a(i, str.length() + i, paramSessionInfo);
    }
    paramSessionInfo = new MessageForUniteGrayTip();
    paramSessionInfo.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localUniteGrayTipParam);
    UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo);
    ReportController.b(null, "dc00898", "", "", "0X8009ACE", "0X8009ACE", paramInt, paramInt, "", "", "", "");
    if (QLog.isColorLevel())
    {
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append("add gray tip =");
      paramSessionInfo.append((String)localObject);
      paramSessionInfo.append(" fromType=");
      paramSessionInfo.append(paramInt);
      QLog.d("PushNotificationManager", 2, paramSessionInfo.toString());
    }
  }
  
  public QConfPushBean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQConfPushBean == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQConfPushBean = new QConfPushBean();
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQConfPushBean.a(false);
      if (QLog.isColorLevel()) {
        QLog.d("PushNotificationManager", 2, "pushNotificationBean=null, general new bean");
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQConfPushBean;
  }
  
  public void a(SessionInfo paramSessionInfo, int paramInt)
  {
    if (QQAppInterface.isNotificationEnabled() == 0)
    {
      if (a().a())
      {
        if (a() >= a().a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("PushNotificationManager", 2, "getmTodayHadShowCount > showCount");
          }
          return;
        }
        if (a(paramSessionInfo))
        {
          this.d += 1;
          SharedPreUtils.X(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.d);
          b(paramSessionInfo, paramInt);
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append("isNotificationEnabled=");
      paramSessionInfo.append(QQAppInterface.isNotificationEnabled());
      QLog.d("PushNotificationManager", 2, paramSessionInfo.toString());
    }
  }
  
  public void a(QConfPushBean paramQConfPushBean)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQConfPushBean = paramQConfPushBean;
  }
  
  public void onDestroy()
  {
    this.d = -1;
    this.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.PushNotificationManager
 * JD-Core Version:    0.7.0.1
 */