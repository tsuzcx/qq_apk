package com.tencent.mobileqq.msgbackup.data;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import java.io.File;
import java.util.List;

public class MsgBackupDBHelper
{
  private MsgBackupEntityManagerFactory a;
  
  public MsgBackupDBHelper(String paramString)
  {
    this.a = new MsgBackupEntityManagerFactory(paramString);
  }
  
  public static void a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (Build.VERSION.SDK_INT >= 16)) {
      SQLiteDatabase.deleteDatabase(paramString);
    }
  }
  
  public int a()
  {
    return this.a.a("msg");
  }
  
  public String a()
  {
    return this.a.name;
  }
  
  public List<MsgBackupExtraEntity> a()
  {
    return this.a.a();
  }
  
  public List<MsgBackupResEntity> a(int paramInt1, int paramInt2)
  {
    return this.a.b(paramInt1, paramInt2);
  }
  
  public List<MsgBackupMsgEntity> a(long paramLong, int paramInt)
  {
    return this.a.a(paramLong, paramInt);
  }
  
  public List<MsgBackupResEntity> a(long paramLong1, long paramLong2)
  {
    return this.a.a(paramLong1, paramLong2);
  }
  
  public void a()
  {
    if (this.a.isOpen()) {
      this.a.close();
    }
  }
  
  public void a(List<MsgBackupMsgEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.a.b(paramList);
  }
  
  public int b()
  {
    return this.a.b("res");
  }
  
  public void b(List<MsgBackupResEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.a.c(paramList);
  }
  
  public void c(List<MsgBackupExtraEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.a.a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupDBHelper
 * JD-Core Version:    0.7.0.1
 */