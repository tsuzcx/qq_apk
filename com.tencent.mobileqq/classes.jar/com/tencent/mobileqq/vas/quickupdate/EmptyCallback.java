package com.tencent.mobileqq.vas.quickupdate;

import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.qphone.base.util.QLog;

public class EmptyCallback
  extends BaseUpdateCallback
{
  private void logError(String paramString1, long paramLong, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call empty method:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" with ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    QLog.e("EmptyCallback", 1, localStringBuilder.toString(), new Exception());
  }
  
  public boolean canUpdate(long paramLong, String paramString1, String paramString2)
  {
    logError("canUpdate", paramLong, paramString1);
    return false;
  }
  
  public boolean deleteFiles(long paramLong, String paramString)
  {
    logError("deleteFiles", paramLong, paramString);
    return true;
  }
  
  public void doOnCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    logError("_onCompleted", paramLong, paramString1);
  }
  
  public void doOnProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    logError("_onProgress", paramLong1, paramString1);
  }
  
  public void download(long paramLong, String paramString, QuickUpdateListener paramQuickUpdateListener, boolean paramBoolean)
  {
    logError("download", paramLong, paramString);
  }
  
  public long getBID()
  {
    return 0L;
  }
  
  public TagItemInfo getItemInfo(long paramLong, String paramString)
  {
    logError("getItemInfo", paramLong, paramString);
    return null;
  }
  
  public boolean isFileExists(long paramLong, String paramString)
  {
    logError("isFileExists", paramLong, paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.EmptyCallback
 * JD-Core Version:    0.7.0.1
 */