package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qqguildsdk.callback.IGetChannelCategoryCallback;
import com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import java.util.ArrayList;
import java.util.List;

public abstract interface IGProChannelCategoryService
{
  public abstract void changeChannelCategoryName(String paramString1, long paramLong, String paramString2, IGetChannelCategoryCallback paramIGetChannelCategoryCallback);
  
  public abstract void createChannelCategory(String paramString1, String paramString2, IGetChannelCategoryCallback paramIGetChannelCategoryCallback);
  
  public abstract List<ICategoryInfo> getChannelCategoryList(String paramString);
  
  public abstract void removeChannelCategory(String paramString, long paramLong, boolean paramBoolean, IGetChannelCategoryCallback paramIGetChannelCategoryCallback);
  
  public abstract void setChannelCategory(String paramString1, String paramString2, long paramLong, IGetChannelCategoryCallback paramIGetChannelCategoryCallback);
  
  public abstract void setChannelCategoryInfo(String paramString, CategoryChannelSortInfo paramCategoryChannelSortInfo, ArrayList<CategoryChannelSortInfo> paramArrayList, IGetChannelCategoryCallback paramIGetChannelCategoryCallback);
  
  public abstract void setChannelCategoryOrder(String paramString, ArrayList<Long> paramArrayList, IGetChannelCategoryCallback paramIGetChannelCategoryCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.api.IGProChannelCategoryService
 * JD-Core Version:    0.7.0.1
 */