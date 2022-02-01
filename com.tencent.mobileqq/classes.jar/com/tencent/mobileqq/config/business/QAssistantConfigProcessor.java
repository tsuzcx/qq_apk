package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qassistant.command.jump.QAssistantConfigUtils;
import com.tencent.mobileqq.qassistant.command.jump.QAssistantManager;
import com.tencent.qphone.base.util.QLog;

public class QAssistantConfigProcessor
  extends IQConfigProcessor<QAssistantConfigProcessor.QAssistantConfigContent>
{
  @NonNull
  public QAssistantConfigProcessor.QAssistantConfigContent a(int paramInt)
  {
    return new QAssistantConfigProcessor.QAssistantConfigContent();
  }
  
  @Nullable
  public QAssistantConfigProcessor.QAssistantConfigContent a(QConfItem[] paramArrayOfQConfItem)
  {
    QAssistantConfigProcessor.QAssistantConfigContent localQAssistantConfigContent = new QAssistantConfigProcessor.QAssistantConfigContent();
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfQConfItem.length);
    }
    if (paramArrayOfQConfItem.length > 0)
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0];
      localQAssistantConfigContent.jdField_a_of_type_Int = paramArrayOfQConfItem.jdField_a_of_type_Int;
      localQAssistantConfigContent.jdField_a_of_type_JavaLangString = paramArrayOfQConfItem.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed taskId = " + localQAssistantConfigContent.jdField_a_of_type_Int + " | content = " + localQAssistantConfigContent.jdField_a_of_type_JavaLangString);
    }
    return localQAssistantConfigContent;
  }
  
  public void a(QAssistantConfigProcessor.QAssistantConfigContent paramQAssistantConfigContent)
  {
    if ((paramQAssistantConfigContent != null) && (paramQAssistantConfigContent.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramQAssistantConfigContent.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("QAssistantConfigProcessor", 2, "onUpdate content = " + paramQAssistantConfigContent.jdField_a_of_type_JavaLangString);
        }
        QAssistantConfigUtils.a(localQQAppInterface, str);
        paramQAssistantConfigContent = (QAssistantManager)localQQAppInterface.getManager(QQManagerFactory.QASSISTANT_MANAGER);
        if (paramQAssistantConfigContent != null) {
          paramQAssistantConfigContent.a();
        }
        return;
      }
      catch (Exception paramQAssistantConfigContent)
      {
        paramQAssistantConfigContent.printStackTrace();
        QLog.e("QAssistantConfigProcessor", 2, "onUpdate has exception", paramQAssistantConfigContent);
        return;
      }
    }
    QLog.e("QAssistantConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
  }
  
  public Class<QAssistantConfigProcessor.QAssistantConfigContent> clazz()
  {
    return QAssistantConfigProcessor.QAssistantConfigContent.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public int type()
  {
    return 568;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QAssistantConfigProcessor
 * JD-Core Version:    0.7.0.1
 */