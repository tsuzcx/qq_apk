package com.tencent.tmdownloader.internal.storage;

import android.util.Log;
import java.util.ArrayList;

public class a
{
  protected static a a = null;
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  public void a(com.tencent.tmdownloader.internal.downloadservice.c paramc)
  {
    Log.i("DBManager", "addDownloadInfo di=" + paramc);
    Log.i("DBManager", "addDownloadInfo di.filename=" + paramc.j + ",mURL=" + paramc.b);
    com.tencent.tmdownloader.internal.storage.table.c.a(paramc);
  }
  
  public void a(String paramString)
  {
    com.tencent.tmdownloader.internal.storage.table.c.a(paramString);
    com.tencent.tmdownloader.internal.storage.table.b.a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    com.tencent.tmdownloader.internal.storage.table.b.a(paramString1, paramString2);
  }
  
  public void a(ArrayList<com.tencent.tmdownloader.internal.downloadservice.c> paramArrayList)
  {
    com.tencent.tmdownloader.internal.storage.table.c.a(paramArrayList);
  }
  
  public com.tencent.tmdownloader.internal.downloadservice.c b(String paramString)
  {
    return com.tencent.tmdownloader.internal.storage.table.c.b(paramString);
  }
  
  public ArrayList<com.tencent.tmdownloader.internal.downloadservice.c> b()
  {
    return com.tencent.tmdownloader.internal.storage.table.c.a();
  }
  
  public ArrayList<com.tencent.tmdownloader.internal.downloadservice.a.b> c()
  {
    return com.tencent.tmdownloader.internal.storage.table.c.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.a
 * JD-Core Version:    0.7.0.1
 */