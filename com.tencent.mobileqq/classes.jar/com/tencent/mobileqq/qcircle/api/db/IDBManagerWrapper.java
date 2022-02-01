package com.tencent.mobileqq.qcircle.api.db;

import android.content.ContentValues;
import java.util.ArrayList;
import java.util.List;

public abstract interface IDBManagerWrapper
{
  public static final String TAG = "IDBManagerWrapper";
  
  public abstract void addCloseListener(IDBManagerWrapper.OnCloseListener paramOnCloseListener);
  
  public abstract void close();
  
  public abstract long dbDeleteData(String paramString);
  
  public abstract boolean dbInsertData(IDBCacheDataWrapper paramIDBCacheDataWrapper);
  
  public abstract boolean dbInsertData(IDBCacheDataWrapper paramIDBCacheDataWrapper, int paramInt);
  
  public abstract boolean dbInsertData(List<? extends IDBCacheDataWrapper> paramList);
  
  public abstract boolean dbInsertData(List<? extends IDBCacheDataWrapper> paramList, int paramInt);
  
  public abstract boolean dbInsertData(List<? extends IDBCacheDataWrapper> paramList, int paramInt, String paramString);
  
  public abstract List<IDBCacheDataWrapper> dbQueryData(String paramString1, String paramString2);
  
  public abstract List<IDBCacheDataWrapper> dbQueryData(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract IDBCacheDataWrapper dbQueryFirstData(String paramString1, String paramString2);
  
  public abstract IDBCacheDataWrapper dbQueryFirstData(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract boolean dbUpdateData(ContentValues paramContentValues, String paramString);
  
  public abstract boolean dbUpdateData(ContentValues paramContentValues, String paramString, String[] paramArrayOfString);
  
  public abstract boolean dbUpdateData(IDBCacheDataWrapper paramIDBCacheDataWrapper, String paramString);
  
  public abstract int deleteData(String paramString, String[] paramArrayOfString);
  
  public abstract int getCount(String paramString);
  
  public abstract boolean isClosed();
  
  public abstract ArrayList<? extends IDBCacheDataWrapper> queryData();
  
  public abstract boolean saveData(IDBCacheDataWrapper paramIDBCacheDataWrapper, int paramInt);
  
  public abstract int updateData(IDBCacheDataWrapper paramIDBCacheDataWrapper, String paramString, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
 * JD-Core Version:    0.7.0.1
 */