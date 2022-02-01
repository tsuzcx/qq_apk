package com.tencent.mobileqq.studymode;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class StudyModeSwitchDialogConfigProcessor
  extends IQConfigProcessor<StudyModeSwitchDialogConfigProcessor.Config>
{
  public static final StudyModeSwitchDialogConfigProcessor.Companion a = new StudyModeSwitchDialogConfigProcessor.Companion(null);
  
  @NotNull
  public StudyModeSwitchDialogConfigProcessor.Config a(int paramInt)
  {
    return new StudyModeSwitchDialogConfigProcessor.Config();
  }
  
  @Nullable
  public StudyModeSwitchDialogConfigProcessor.Config a(@Nullable QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyModeSwitchDialogConfigProcessor", 2, "onParsed");
    }
    StudyModeSwitchDialogConfigProcessor.Config localConfig = new StudyModeSwitchDialogConfigProcessor.Config();
    if (paramArrayOfQConfItem != null)
    {
      int i;
      if (paramArrayOfQConfItem.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i ^ 0x1) != 0)
      {
        paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfQConfItem, "confFiles[0].content");
        localConfig.a(paramArrayOfQConfItem);
      }
    }
    return localConfig;
  }
  
  public void a(@Nullable StudyModeSwitchDialogConfigProcessor.Config paramConfig) {}
  
  @NotNull
  public Class<StudyModeSwitchDialogConfigProcessor.Config> clazz()
  {
    return StudyModeSwitchDialogConfigProcessor.Config.class;
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
    return 619;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModeSwitchDialogConfigProcessor
 * JD-Core Version:    0.7.0.1
 */