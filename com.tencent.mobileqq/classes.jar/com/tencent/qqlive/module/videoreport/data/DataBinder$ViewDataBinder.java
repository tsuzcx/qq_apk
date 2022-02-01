package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.Nullable;
import android.view.View;

class DataBinder$ViewDataBinder
  implements DataBinder.IDataBinder
{
  @Nullable
  public DataEntity getDataEntity(Object paramObject)
  {
    if (!(paramObject instanceof View)) {
      return null;
    }
    try
    {
      paramObject = ((View)paramObject).getTag(2131436782);
      if ((paramObject instanceof DataEntity))
      {
        paramObject = (DataEntity)paramObject;
        return paramObject;
      }
      return null;
    }
    catch (Throwable paramObject) {}
    return null;
  }
  
  public void setDataEntity(Object paramObject, DataEntity paramDataEntity)
  {
    if (!(paramObject instanceof View)) {
      return;
    }
    try
    {
      ((View)paramObject).setTag(2131436782, paramDataEntity);
      return;
    }
    catch (Throwable paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.DataBinder.ViewDataBinder
 * JD-Core Version:    0.7.0.1
 */