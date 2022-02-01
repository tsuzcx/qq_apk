package com.tencent.mobileqq.transfile.predownload.schedule;

import java.util.Comparator;

class PreDownloadScheduler$MyComparator
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (PreDownloadItem)paramObject1;
    paramObject2 = (PreDownloadItem)paramObject2;
    if (paramObject1.businessPriority > paramObject2.businessPriority) {
      return -1;
    }
    if (paramObject1.businessPriority < paramObject2.businessPriority) {
      return 1;
    }
    if (paramObject1.innerPriority > paramObject2.innerPriority) {
      return -1;
    }
    if (paramObject1.innerPriority < paramObject2.innerPriority) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler.MyComparator
 * JD-Core Version:    0.7.0.1
 */