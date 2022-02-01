package com.tencent.mobileqq.data.entitymanager.upgrade;

import android.database.sqlite.SQLiteDatabase;

public abstract interface IAfterDBUpgradeListener
{
  public abstract void afterDBUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.entitymanager.upgrade.IAfterDBUpgradeListener
 * JD-Core Version:    0.7.0.1
 */