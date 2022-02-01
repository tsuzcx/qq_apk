package com.tencent.mobileqq.persistence.bridge;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.data.entitymanager.upgrade.IOnDBUpgradeListener;

public class DefaultOnDBUpgradeCallback
  implements IOnDBUpgradeListener
{
  private boolean a = false;
  
  public boolean a()
  {
    return this.a;
  }
  
  public void onDBUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 36) {
      this.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.DefaultOnDBUpgradeCallback
 * JD-Core Version:    0.7.0.1
 */