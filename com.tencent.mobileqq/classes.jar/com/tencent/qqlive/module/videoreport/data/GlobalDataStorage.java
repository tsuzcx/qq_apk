package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.NonNull;

class GlobalDataStorage
{
  private static final VideoReportDataStorage<DataEntity> DATA_MAP = new VideoReportDataStorage();
  
  static DataEntity getData(@NonNull Object paramObject)
  {
    return (DataEntity)DATA_MAP.getData(paramObject);
  }
  
  static void setData(@NonNull Object paramObject, DataEntity paramDataEntity)
  {
    DATA_MAP.setData(paramObject, paramDataEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.GlobalDataStorage
 * JD-Core Version:    0.7.0.1
 */