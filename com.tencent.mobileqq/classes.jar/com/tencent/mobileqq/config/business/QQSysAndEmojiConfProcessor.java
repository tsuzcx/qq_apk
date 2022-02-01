package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;

public class QQSysAndEmojiConfProcessor
  extends IQConfigProcessor<QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean>
{
  public static int a()
  {
    ExpEntityInfo localExpEntityInfo = ABTestController.a().a(545);
    Object localObject = (QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean)localExpEntityInfo.a();
    localExpEntityInfo.a();
    if (localObject != null)
    {
      int i = ((QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean)localObject).a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("expGrpLineCnt=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("expInfo:");
      ((StringBuilder)localObject).append(localExpEntityInfo.a());
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
      QLog.d("QQSysAndEmojiConfProcessor", 2, "QQSysAndEmojiConfProcessor onUpdate");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor
 * JD-Core Version:    0.7.0.1
 */