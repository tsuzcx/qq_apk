package com.tencent.richframework.data.idata;

public abstract interface ILoadDataAsync<E>
{
  public abstract String getAttachInfoFromItemData(E paramE);
  
  public abstract void getListDataAsync(IDataCallBack<E> paramIDataCallBack, String paramString);
  
  public abstract int getPageCount();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.data.idata.ILoadDataAsync
 * JD-Core Version:    0.7.0.1
 */