package com.tencent.vas.update.callback;

import java.util.List;

public abstract interface IDbManager
{
  public abstract void deleteItem(int paramInt, String paramString);
  
  public abstract List<IDbManager.ItemInfo> selectAllItem(int paramInt);
  
  public abstract String selectItem(int paramInt, String paramString);
  
  public abstract void updateItem(int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.callback.IDbManager
 * JD-Core Version:    0.7.0.1
 */