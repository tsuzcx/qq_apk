package com.tencent.mobileqq.studymode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class StudyModePushConfigProcessor
  extends IQConfigProcessor<StudyModePushConfigProcessor.StudyModePushConfigBean>
{
  public static StudyModePushConfigProcessor.StudyModePushConfigBean a()
  {
    return (StudyModePushConfigProcessor.StudyModePushConfigBean)QConfigManager.a().a(615);
  }
  
  @NonNull
  public StudyModePushConfigProcessor.StudyModePushConfigBean a(int paramInt)
  {
    return new StudyModePushConfigProcessor.StudyModePushConfigBean();
  }
  
  @Nullable
  public StudyModePushConfigProcessor.StudyModePushConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StudyModePushConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return StudyModePushConfigProcessor.StudyModePushConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(StudyModePushConfigProcessor.StudyModePushConfigBean paramStudyModePushConfigBean) {}
  
  public Class<StudyModePushConfigProcessor.StudyModePushConfigBean> clazz()
  {
    return StudyModePushConfigProcessor.StudyModePushConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    return 615;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModePushConfigProcessor
 * JD-Core Version:    0.7.0.1
 */