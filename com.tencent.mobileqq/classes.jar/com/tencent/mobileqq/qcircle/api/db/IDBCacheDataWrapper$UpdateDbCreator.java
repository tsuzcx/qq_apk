package com.tencent.mobileqq.qcircle.api.db;

public abstract interface IDBCacheDataWrapper$UpdateDbCreator<T extends IDBCacheDataWrapper>
  extends IDBCacheDataWrapper.RawDbCreator<T>
{
  public abstract boolean needEncrypt(int paramInt1, int paramInt2);
  
  public abstract String[] onUpdate(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.UpdateDbCreator
 * JD-Core Version:    0.7.0.1
 */