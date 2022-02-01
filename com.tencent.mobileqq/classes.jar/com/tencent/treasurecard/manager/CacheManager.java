package com.tencent.treasurecard.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.treasurecard.bean.TreasureCard;

public class CacheManager
{
  public static long a;
  private TreasureCard b;
  
  public TreasureCard a()
  {
    Object localObject = this.b;
    if (localObject != null) {
      return localObject;
    }
    this.b = new TreasureCard();
    localObject = ((TcSdkManager)TcSdkManager.b()).e();
    if (localObject != null)
    {
      localObject = ((Context)localObject).getSharedPreferences("treasurecard_sp", 4);
      this.b.a = ((SharedPreferences)localObject).getInt("treasurecard_state", -1);
    }
    return this.b;
  }
  
  public void a(int paramInt)
  {
    if (this.b == null) {
      this.b = new TreasureCard();
    }
    this.b.a = paramInt;
    Context localContext = ((TcSdkManager)TcSdkManager.b()).e();
    if (localContext != null) {
      localContext.getSharedPreferences("treasurecard_sp", 4).edit().putInt("treasurecard_state", this.b.a).apply();
    }
  }
  
  public void a(String paramString)
  {
    Context localContext = ((TcSdkManager)TcSdkManager.b()).e();
    if (localContext != null) {
      localContext.getSharedPreferences("treasurecard_sp", 4).edit().putString("pc_id", paramString).putLong("pc_id_update_time", System.currentTimeMillis()).apply();
    }
  }
  
  public String b()
  {
    Object localObject = ((TcSdkManager)TcSdkManager.b()).e();
    if (localObject == null) {
      return null;
    }
    localObject = ((Context)localObject).getSharedPreferences("treasurecard_sp", 4);
    long l = ((SharedPreferences)localObject).getLong("pc_id_update_time", 0L);
    if ((System.currentTimeMillis() - l) / 1000L > a) {
      return null;
    }
    return ((SharedPreferences)localObject).getString("pc_id", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.treasurecard.manager.CacheManager
 * JD-Core Version:    0.7.0.1
 */