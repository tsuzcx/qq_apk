package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

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
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfQConfItem.length);
    }
    if (paramArrayOfQConfItem.length > 0)
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0];
      localScencesEmotionConfigContent.jdField_a_of_type_Int = paramArrayOfQConfItem.jdField_a_of_type_Int;
      localScencesEmotionConfigContent.jdField_a_of_type_JavaLangString = paramArrayOfQConfItem.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onParsed taskId = " + localScencesEmotionConfigContent.jdField_a_of_type_Int + " | content = " + localScencesEmotionConfigContent.jdField_a_of_type_JavaLangString);
    }
    return localScencesEmotionConfigContent;
  }
  
  public void a(ScenesEmotionConfigProcessor.ScencesEmotionConfigContent paramScencesEmotionConfigContent)
  {
    if ((paramScencesEmotionConfigContent != null) && (paramScencesEmotionConfigContent.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramScencesEmotionConfigContent.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("ScencesEmotionConfigProcessor", 2, "onUpdate content = " + paramScencesEmotionConfigContent.jdField_a_of_type_JavaLangString);
        }
        ScenesRecommendUtils.a(localQQAppInterface, str);
        ScenesRecommendManager.a(localQQAppInterface).a();
        return;
      }
      catch (Exception paramScencesEmotionConfigContent)
      {
        paramScencesEmotionConfigContent.printStackTrace();
        QLog.e("ScencesEmotionConfigProcessor", 2, "onUpdate has exception", paramScencesEmotionConfigContent);
        return;
      }
    }
    QLog.e("ScencesEmotionConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
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
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public int type()
  {
    return 621;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ScenesEmotionConfigProcessor
 * JD-Core Version:    0.7.0.1
 */