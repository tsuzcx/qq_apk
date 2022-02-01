package com.tencent.mobileqq.studymode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class StudyModeConfigProcessor
  extends IQConfigProcessor<StudyModeConfigProcessor.StudyModeConfigBean>
{
  public static StudyModeConfigProcessor.StudyModeConfigBean a()
  {
    return (StudyModeConfigProcessor.StudyModeConfigBean)QConfigManager.a().a(610);
  }
  
  @NonNull
  public StudyModeConfigProcessor.StudyModeConfigBean a(int paramInt)
  {
    return new StudyModeConfigProcessor.StudyModeConfigBean();
  }
  
  @Nullable
  public StudyModeConfigProcessor.StudyModeConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StudyModeConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return StudyModeConfigProcessor.StudyModeConfigBean.a(paramArrayOfQConfItem);
    }
    return new StudyModeConfigProcessor.StudyModeConfigBean();
  }
  
  public void a(StudyModeConfigProcessor.StudyModeConfigBean paramStudyModeConfigBean) {}
  
  public Class<StudyModeConfigProcessor.StudyModeConfigBean> clazz()
  {
    return StudyModeConfigProcessor.StudyModeConfigBean.class;
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
    return 610;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModeConfigProcessor
 * JD-Core Version:    0.7.0.1
 */