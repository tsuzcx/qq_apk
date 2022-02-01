package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public class DataBinder
{
  private static final DataBinder.IDataBinder DEFAULT_BINDER = new DataBinder.CommonDataBinder(null);
  private static final DataBinder.IDataBinder VIEW_BINDER = new DataBinder.ViewDataBinder(null);
  
  @Nullable
  public static DataEntity getDataEntity(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return with(paramObject).getDataEntity(paramObject);
  }
  
  static void setDataEntity(@Nullable Object paramObject, @Nullable DataEntity paramDataEntity)
  {
    if (paramObject == null) {
      return;
    }
    with(paramObject).setDataEntity(paramObject, paramDataEntity);
  }
  
  @NonNull
  private static DataBinder.IDataBinder with(Object paramObject)
  {
    if ((paramObject instanceof View)) {
      return VIEW_BINDER;
    }
    return DEFAULT_BINDER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.DataBinder
 * JD-Core Version:    0.7.0.1
 */