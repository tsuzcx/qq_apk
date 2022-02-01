package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;

public class QQSysAndEmojiConfProcessor
  extends IQConfigProcessor<QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean>
{
  public static QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean a()
  {
    ExpEntityInfo localExpEntityInfo = ABTestController.a().a(545);
    Object localObject2 = (QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean)localExpEntityInfo.b();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean)QConfigManager.b().b(545);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getConfBean, exp is ");
    localStringBuilder.append(localExpEntityInfo.d());
    localStringBuilder.append(", conf bean exist: ");
    boolean bool;
    if (localObject1 != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(", conf exp: ");
    if (localObject1 == null) {
      localObject2 = "null";
    } else {
      localObject2 = ((QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean)localObject1).a;
    }
    localStringBuilder.append((String)localObject2);
    QLog.i("QQSysAndEmojiConfProcessor", 1, localStringBuilder.toString());
    return localObject1;
  }
  
  public static void b()
  {
    ExpEntityInfo localExpEntityInfo = ABTestController.a().a(545);
    if (!TextUtils.isEmpty(localExpEntityInfo.d()))
    {
      localExpEntityInfo.h();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportABTestExposure, assignment=");
        localStringBuilder.append(localExpEntityInfo.d());
        QLog.i("QQSysAndEmojiConfProcessor", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static int c()
  {
    Object localObject = a();
    if (localObject != null)
    {
      int i = ((QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean)localObject).p;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("expGrpLineCnt=");
      ((StringBuilder)localObject).append(i);
      ABTestUtil.a("QQSysAndEmojiConfProcessor", ((StringBuilder)localObject).toString());
      return i;
    }
    return 3;
  }
  
  @NonNull
  public QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean a(int paramInt)
  {
    return new QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean();
  }
  
  @Nullable
  public QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean paramSystemAndEmojiConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQSysAndEmojiConfProcessor", 2, "QQSysAndEmojiConfProcessor onUpdate");
    }
    if (paramSystemAndEmojiConfBean != null) {
      QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean.a(paramSystemAndEmojiConfBean);
    }
    QQSysAndEmojiResMgr.getInstance().downloadEmoticonRes();
  }
  
  public Class<QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean> clazz()
  {
    return QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 545;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor
 * JD-Core Version:    0.7.0.1
 */