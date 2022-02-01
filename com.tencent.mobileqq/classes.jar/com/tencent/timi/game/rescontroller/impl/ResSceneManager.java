package com.tencent.timi.game.rescontroller.impl;

import com.tencent.timi.game.utils.Logger;
import java.util.concurrent.ConcurrentHashMap;

public class ResSceneManager
{
  private ConcurrentHashMap<String, String> a = new ConcurrentHashMap();
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      if (this.a.contains(paramString1))
      {
        paramString2 = (String)this.a.get(paramString1);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryResAvaliable:");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" curScene:");
        localStringBuilder.append(paramString2);
        Logger.a("TimiGameResSceneManager", 4, localStringBuilder.toString());
        return paramString2;
      }
      paramString2 = new StringBuilder();
      paramString2.append("queryResAvaliable:");
      paramString2.append(paramString1);
      paramString2.append(" Avaliable");
      Logger.a("TimiGameResSceneManager", 4, paramString2.toString());
      return null;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unregistRes:");
      localStringBuilder.append(paramString);
      Logger.a("TimiGameResSceneManager", 4, localStringBuilder.toString());
      if (this.a.contains(paramString)) {
        this.a.remove(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registRes:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" scene:");
      localStringBuilder.append(paramString2);
      Logger.a("TimiGameResSceneManager", 4, localStringBuilder.toString());
      this.a.put(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.rescontroller.impl.ResSceneManager
 * JD-Core Version:    0.7.0.1
 */