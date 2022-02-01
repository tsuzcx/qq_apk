package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;

public class QIMDoodleConfigProcessor
  extends IQConfigProcessor<Object>
{
  public Class<Object> clazz()
  {
    return Object.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  @NonNull
  public Object migrateOldOrDefaultContent(int paramInt)
  {
    return new Object();
  }
  
  public int migrateOldVersion()
  {
    PtvTemplateManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    if (!PtvTemplateManager.a()) {
      return 0;
    }
    return SharedPreUtils.l(BaseApplicationImpl.getContext());
  }
  
  @Nullable
  public Object onParsed(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length == 0)) {
      return null;
    }
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onParsed, content:" + paramArrayOfQConfItem);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    PtvTemplateManager.a(localQQAppInterface).a(paramArrayOfQConfItem, localQQAppInterface);
    return new Object();
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onReqFailed");
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onReqNoReceive");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    PtvTemplateManager localPtvTemplateManager = PtvTemplateManager.a(localQQAppInterface);
    if (localPtvTemplateManager.b()) {
      localPtvTemplateManager.a(localQQAppInterface, null);
    }
  }
  
  public int onSend(int paramInt)
  {
    PtvTemplateManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    if (!PtvTemplateManager.a())
    {
      QLog.i("QIMDoodleConfigProcessor", 1, "config file not exist");
      QConfigManager.a().a(310, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public void onUpdate(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onUpdate");
    }
  }
  
  public int type()
  {
    return 310;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QIMDoodleConfigProcessor
 * JD-Core Version:    0.7.0.1
 */