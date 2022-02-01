package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl.ScenesRecommendManagerImpl;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class ScenesEmotionConfigProcessor
  extends IQConfigProcessor<ScenesEmotionConfigProcessor.ScencesEmotionConfigContent>
{
  @NonNull
  public ScenesEmotionConfigProcessor.ScencesEmotionConfigContent a(int paramInt)
  {
    return new ScenesEmotionConfigProcessor.ScencesEmotionConfigContent();
  }
  
  @Nullable
  public ScenesEmotionConfigProcessor.ScencesEmotionConfigContent a(QConfItem[] paramArrayOfQConfItem)
  {
    ScenesEmotionConfigProcessor.ScencesEmotionConfigContent localScencesEmotionConfigContent = new ScenesEmotionConfigProcessor.ScencesEmotionConfigContent();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onParsed confFiles.length = ");
      localStringBuilder.append(paramArrayOfQConfItem.length);
      QLog.d("ScencesEmotionConfigProcessor", 2, localStringBuilder.toString());
    }
    if (paramArrayOfQConfItem.length > 0)
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0];
      localScencesEmotionConfigContent.a = paramArrayOfQConfItem.a;
      localScencesEmotionConfigContent.b = paramArrayOfQConfItem.b;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfQConfItem = new StringBuilder();
      paramArrayOfQConfItem.append("onParsed taskId = ");
      paramArrayOfQConfItem.append(localScencesEmotionConfigContent.a);
      paramArrayOfQConfItem.append(" | content = ");
      paramArrayOfQConfItem.append(localScencesEmotionConfigContent.b);
      QLog.d("ScencesEmotionConfigProcessor", 2, paramArrayOfQConfItem.toString());
    }
    return localScencesEmotionConfigContent;
  }
  
  public void a(ScenesEmotionConfigProcessor.ScencesEmotionConfigContent paramScencesEmotionConfigContent)
  {
    if ((paramScencesEmotionConfigContent != null) && (paramScencesEmotionConfigContent.b != null))
    {
      try
      {
        String str = paramScencesEmotionConfigContent.b;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onUpdate content = ");
          localStringBuilder.append(paramScencesEmotionConfigContent.b);
          QLog.d("ScencesEmotionConfigProcessor", 2, localStringBuilder.toString());
        }
        paramScencesEmotionConfigContent = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(paramScencesEmotionConfigContent instanceof AppInterface)) {
          return;
        }
        paramScencesEmotionConfigContent = (AppInterface)paramScencesEmotionConfigContent;
        ScenesRecommendUtils.a(paramScencesEmotionConfigContent, str);
        ScenesRecommendManagerImpl.get(paramScencesEmotionConfigContent).loadConfigFromLoacl();
        return;
      }
      catch (Exception paramScencesEmotionConfigContent)
      {
        paramScencesEmotionConfigContent.printStackTrace();
        QLog.e("ScencesEmotionConfigProcessor", 2, "onUpdate has exception", paramScencesEmotionConfigContent);
        return;
      }
    }
    else
    {
      paramScencesEmotionConfigContent = new StringBuilder();
      paramScencesEmotionConfigContent.append("onUpdate has empty content newConf is null = ");
      paramScencesEmotionConfigContent.append(null);
      QLog.e("ScencesEmotionConfigProcessor", 2, paramScencesEmotionConfigContent.toString());
    }
  }
  
  public Class<ScenesEmotionConfigProcessor.ScencesEmotionConfigContent> clazz()
  {
    return ScenesEmotionConfigProcessor.ScencesEmotionConfigContent.class;
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
      QLog.d("ScencesEmotionConfigProcessor", 2, "migrateOldVersion");
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
      QLog.d("ScencesEmotionConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 621;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ScenesEmotionConfigProcessor
 * JD-Core Version:    0.7.0.1
 */