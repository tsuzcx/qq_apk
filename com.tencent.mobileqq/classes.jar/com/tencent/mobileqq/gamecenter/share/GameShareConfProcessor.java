package com.tencent.mobileqq.gamecenter.share;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameShareConfProcessor
  extends IQConfigProcessor<GameShareConfBean>
{
  private static GameShareConfBean jdField_a_of_type_ComTencentMobileqqGamecenterShareGameShareConfBean = null;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static GameShareConfBean a()
  {
    GameShareConfBean localGameShareConfBean = jdField_a_of_type_ComTencentMobileqqGamecenterShareGameShareConfBean;
    if (localGameShareConfBean != null) {
      return localGameShareConfBean;
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      ThreadManager.executeOnSubThread(new GameShareConfProcessor.1());
    }
    return GameShareConfBean.jdField_a_of_type_ComTencentMobileqqGamecenterShareGameShareConfBean;
  }
  
  public static void a()
  {
    jdField_a_of_type_ComTencentMobileqqGamecenterShareGameShareConfBean = null;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  @NonNull
  public GameShareConfBean a(int paramInt)
  {
    return new GameShareConfBean();
  }
  
  @Nullable
  public GameShareConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length != 0) && (paramArrayOfQConfItem[0] != null)) {
      paramArrayOfQConfItem = GameShareConfBean.a(paramArrayOfQConfItem[0].a);
    } else {
      paramArrayOfQConfItem = new GameShareConfBean();
    }
    jdField_a_of_type_ComTencentMobileqqGamecenterShareGameShareConfBean = paramArrayOfQConfItem;
    return paramArrayOfQConfItem;
  }
  
  public void a(GameShareConfBean paramGameShareConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onUpdate] newConf:");
      localStringBuilder.append(paramGameShareConfBean);
      QLog.d("GameShare.ConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<GameShareConfBean> clazz()
  {
    return GameShareConfBean.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReqFailed] failCode=");
      localStringBuilder.append(paramInt);
      QLog.d("GameShare.ConfProcessor", 2, localStringBuilder.toString());
    }
    QConfigManager.a().a(617);
  }
  
  public void onReqNoReceive()
  {
    QConfigManager.a().a(617);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqNoReceive: type=");
      localStringBuilder.append(type());
      localStringBuilder.append("curContent:");
      localStringBuilder.append(jdField_a_of_type_ComTencentMobileqqGamecenterShareGameShareConfBean);
      QLog.d("GameShare.ConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 617;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.share.GameShareConfProcessor
 * JD-Core Version:    0.7.0.1
 */