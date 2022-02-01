package com.tencent.mobileqq.transfile.predownload.schedule;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Map;

public abstract class AbsPreDownloadConfig
{
  @NonNull
  public abstract List<String> cleanResOnVersionUpdate(int paramInt1, int paramInt2);
  
  public abstract Map<Integer, String> getBusinessEnglishName();
  
  public abstract Map<Integer, String> getBusinessName();
  
  public abstract Map<Integer, Integer> getBusinessPriority();
  
  public abstract int getVersion();
  
  public abstract List<Integer> getWhiteList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.schedule.AbsPreDownloadConfig
 * JD-Core Version:    0.7.0.1
 */