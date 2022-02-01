package com.tencent.mobileqq.vas.updatesystem.callback;

public abstract interface QuickUpdateBusinessCallback
{
  public abstract boolean canUpdate(long paramLong, String paramString1, String paramString2);
  
  public abstract boolean deleteFiles(long paramLong, String paramString);
  
  public abstract TagItemInfo getItemInfo(long paramLong, String paramString);
  
  public abstract boolean isFileExists(long paramLong, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
 * JD-Core Version:    0.7.0.1
 */