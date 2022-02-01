package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.Nullable;

class DataBinder$CommonDataBinder
  implements DataBinder.IDataBinder
{
  @Nullable
  public DataEntity getDataEntity(Object paramObject)
  {
    return GlobalDataStorage.getData(paramObject);
  }
  
  public void setDataEntity(Object paramObject, DataEntity paramDataEntity)
  {
    GlobalDataStorage.setData(paramObject, paramDataEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.DataBinder.CommonDataBinder
 * JD-Core Version:    0.7.0.1
 */