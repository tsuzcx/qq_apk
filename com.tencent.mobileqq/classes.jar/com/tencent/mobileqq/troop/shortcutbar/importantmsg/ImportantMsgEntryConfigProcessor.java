package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class ImportantMsgEntryConfigProcessor
  extends IQConfigProcessor<ImportantMsgEntryConfig>
{
  @NonNull
  public ImportantMsgEntryConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type: ");
    localStringBuilder.append(paramInt);
    QLog.d("ImportantMsgEntryConfigProcessor", 2, localStringBuilder.toString());
    return new ImportantMsgEntryConfig();
  }
  
  @Nullable
  public ImportantMsgEntryConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return ImportantMsgEntryConfig.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(ImportantMsgEntryConfig paramImportantMsgEntryConfig) {}
  
  public Class<ImportantMsgEntryConfig> clazz()
  {
    return ImportantMsgEntryConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed, failCode = ");
    localStringBuilder.append(paramInt);
    QLog.d("ImportantMsgEntryConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 658;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgEntryConfigProcessor
 * JD-Core Version:    0.7.0.1
 */