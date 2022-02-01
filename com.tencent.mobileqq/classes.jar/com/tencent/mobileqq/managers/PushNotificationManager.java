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
  private QQAppInterface d;
  private int e = -1;
  private long f = 0L;
  private EntityManager g;
  private QConfPushBean h;
  
  public PushNotificationManager(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
    this.g = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    ThreadManager.executeOnSubThread(new PushNotificationManager.1(this, paramQQAppInterface));
  }
  
  private boolean a(SessionInfo paramSessionInfo)
  {
    Object localObject1;
    if (paramSessionInfo.a == 0) {
      localObject1 = paramSessionInfo.b;
    }
    for (;;)
    {
      break;
      if ((paramSessionInfo.a != 1) && (paramSessionInfo.a != 3000)) {
        localObject1 = "";
      } else {
        localObject1 = paramSessionInfo.b;
      }
    }
    Object localObject2;
    if ((QLog.isColorLevel()) && (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sessionInfo.curType=");
      ((StringBuilder)localObject2).append(paramSessionInfo.a);
      ((StringBuilder)localObject2).append(" uin==null sessionInfo.realTroopUin=");
      ((StringBuilder)localObject2).append(paramSessionInfo.d);
      QLog.d("PushNotificationManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("uin=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("mApp.getAccount()=");
      ((StringBuilder)localObject2).append(this.d.getAccount());
      QLog.d("PushNotificationManager", 2, ((StringBuilder)localObject2).toString());
    }
    try
    {
      localObject2 = this.g.query(PushSwitchGrayTipsInfo.class, true, "uin=? and toUin=?", new String[] { this.d.getAccount(), localObject1 }, null, null, null, null);
      if ((localObject2 != null) && (((List)localObject2).size() != 0))
      {
        paramSessionInfo = (PushSwitchGrayTipsInfo)((List)localObject2).get(0);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("pushSwitchGrayTipsInfo.lastShowTime=");
          ((StringBuilder)localObject1).append(paramSessionInfo.lastShowTime);
          ((StringBuilder)localObject1).append(" mTodayZeroTimeMillis=");
          ((StringBuilder)localObject1).append(this.f);
          QLog.d("PushNotificationManager", 2, ((StringBuilder)localObject1).toString());
        }
        if (paramSessionInfo.lastShowTime >= this.f) {
          return false;
        }
        paramSessionInfo.lastShowTime = this.f;
        paramSessionInfo.showCount += 1;
        this.g.update(paramSessionInfo);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PushNotificationManager", 2, "result == null || result.size() == 0");
      }
      paramSessionInfo = new PushSwitchGrayTipsInfo(this.d.getCurrentUin(), (String)localObject1, paramSessionInfo.a, this.f, 1);
      this.g.persistOrReplace(paramSessionInfo);
      return true;
    }
    finally {}
    for (;;)
    {
      throw paramSessionInfo;
    }
  }
  
  private int b()
  {
    Object localObject = Long.valueOf(System.currentTimeMillis());
    if ((this.e >= 0) && (((Long)localObject).longValue() - this.f < 86400000L))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mTodayHadShowCount=");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" mTodayZeroTimeMillis=");
        ((StringBuilder)localObject).append(this.f);
        QLog.d("PushNotificationManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      if (this.f == 0L) {
        this.f = SharedPreUtils.cb(this.d.getApplication(), this.d.getAccount());
      }
      if (((Long)localObject).longValue() - this.f > 86400000L)
      {
        this.f = TimeFormatterUtils.g(((Long)localObject).longValue());
        SharedPreUtils.i(this.d.getApplication(), this.d.getAccount(), this.f);
        SharedPreUtils.ac(this.d.getApplication(), this.d.getAccount(), 0);
        this.e = 0;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Today First Query, mTodayHadShowCount=");
          ((StringBuilder)localObject).append(this.e);
          ((StringBuilder)localObject).append(" mTodayZeroTimeMillis=");
          ((StringBuilder)localObject).append(this.f);
          QLog.d("PushNotificationManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.e = SharedPreUtils.cc(this.d.getApplication(), this.d.getAccount());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Query, mTodayHadShowCount=");
          ((StringBuilder)localObject).append(this.e);
          ((StringBuilder)localObject).append(" mTodayZeroTimeMillis=");
          ((StringBuilder)localObject).append(this.f);
          QLog.d("PushNotificationManager", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    return this.e;
  }
  
  private void b(SessionInfo paramSessionInfo, int paramInt)
  {
    Object localObject;
    if (paramSessionInfo.a == 0) {
      localObject = a().c();
    }
    for (String str = a().d();; str = a().f())
    {
      break;
      if ((paramSessionInfo.a != 1) && (paramSessionInfo.a != 3000))
      {
        str = "";
        localObject = str;
        break;
      }
      localObject = a().e();
    }
    UniteGrayTipParam localUniteGrayTipParam = new UniteGrayTipParam(paramSessionInfo.b, this.d.getCurrentAccountUin(), (String)localObject, paramSessionInfo.a, -5023, 655383, 0L);
    if (paramSessionInfo.a == 0) {
      localUniteGrayTipParam.j = (MessageCache.c() + 1L);
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
    paramSessionInfo.initGrayTipMsg(this.d, localUniteGrayTipParam);
    UniteGrayTipMsgUtil.a(this.d, paramSessionInfo);
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
    if (this.h == null)
    {
      this.h = new QConfPushBean();
      this.h.a(false);
      if (QLog.isColorLevel()) {
        QLog.d("PushNotificationManager", 2, "pushNotificationBean=null, general new bean");
      }
    }
    return this.h;
  }
  
  public void a(SessionInfo paramSessionInfo, int paramInt)
  {
    if (QQAppInterface.isNotificationEnabled() == 0)
    {
      if (a().a())
      {
        if (b() >= a().b())
        {
          if (QLog.isColorLevel()) {
            QLog.d("PushNotificationManager", 2, "getmTodayHadShowCount > showCount");
          }
          return;
        }
        if (a(paramSessionInfo))
        {
          this.e += 1;
          SharedPreUtils.ac(this.d.getApplication(), this.d.getAccount(), this.e);
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
    this.h = paramQConfPushBean;
  }
  
  public void onDestroy()
  {
    this.e = -1;
    this.f = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.PushNotificationManager
 * JD-Core Version:    0.7.0.1
 */