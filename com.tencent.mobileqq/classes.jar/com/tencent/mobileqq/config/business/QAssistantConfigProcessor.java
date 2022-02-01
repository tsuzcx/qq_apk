package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantConf;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qroute.QRoute;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onParsed confFiles.length = ");
      localStringBuilder.append(paramArrayOfQConfItem.length);
      QLog.d("QAssistantConfigProcessor", 2, localStringBuilder.toString());
    }
    if (paramArrayOfQConfItem.length > 0)
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0];
      localQAssistantConfigContent.a = paramArrayOfQConfItem.a;
      localQAssistantConfigContent.b = paramArrayOfQConfItem.b;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfQConfItem = new StringBuilder();
      paramArrayOfQConfItem.append("onParsed taskId = ");
      paramArrayOfQConfItem.append(localQAssistantConfigContent.a);
      paramArrayOfQConfItem.append(" | content = ");
      paramArrayOfQConfItem.append(localQAssistantConfigContent.b);
      QLog.d("QAssistantConfigProcessor", 2, paramArrayOfQConfItem.toString());
    }
    return localQAssistantConfigContent;
  }
  
  public void a(QAssistantConfigProcessor.QAssistantConfigContent paramQAssistantConfigContent)
  {
    if ((paramQAssistantConfigContent != null) && (paramQAssistantConfigContent.b != null))
    {
      try
      {
        String str = paramQAssistantConfigContent.b;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onUpdate content = ");
          localStringBuilder.append(paramQAssistantConfigContent.b);
          QLog.d("QAssistantConfigProcessor", 2, localStringBuilder.toString());
        }
        ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).updateQAssistantConfig(localQQAppInterface, str);
        paramQAssistantConfigContent = (IVoiceAssistantConf)localQQAppInterface.getRuntimeService(IVoiceAssistantConf.class, "");
        if (paramQAssistantConfigContent == null) {
          return;
        }
        paramQAssistantConfigContent.loadConfigFromLocal();
        return;
      }
      catch (Exception paramQAssistantConfigContent)
      {
        paramQAssistantConfigContent.printStackTrace();
        QLog.e("QAssistantConfigProcessor", 2, "onUpdate has exception", paramQAssistantConfigContent);
        return;
      }
    }
    else
    {
      paramQAssistantConfigContent = new StringBuilder();
      paramQAssistantConfigContent.append("onUpdate has empty content newConf is null = ");
      paramQAssistantConfigContent.append(null);
      QLog.e("QAssistantConfigProcessor", 2, paramQAssistantConfigContent.toString());
    }
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed, code = ");
      localStringBuilder.append(paramInt);
      QLog.d("QAssistantConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 568;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QAssistantConfigProcessor
 * JD-Core Version:    0.7.0.1
 */