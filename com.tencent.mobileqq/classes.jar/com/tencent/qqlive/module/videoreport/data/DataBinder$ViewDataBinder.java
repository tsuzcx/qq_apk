package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.Nullable;
import android.view.View;

class DataBinder$ViewDataBinder
  implements DataBinder.IDataBinder
{
  @Nullable
  public DataEntity getDataEntity(Object paramObject)
  {
    return (DataEntity)((View)paramObject).getTag(2131369565);
  }
  
  public void setDataEntity(Object paramObject, DataEntity paramDataEntity)
  {
    ((View)paramObject).setTag(2131369565, paramDataEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.DataBinder.ViewDataBinder
 * JD-Core Version:    0.7.0.1
 */