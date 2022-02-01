package com.tencent.mobileqq.guild.message;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class GuildMessageCache
{
  private ConcurrentHashMap<String, Object> a = new ConcurrentHashMap();
  private ArrayList<Object[]> b = new ArrayList();
  private ArrayList<Object[]> c = new ArrayList();
  
  public Object a(String paramString)
  {
    if (!this.a.containsKey(paramString)) {
      synchronized (this.a)
      {
        if (!this.a.containsKey(paramString)) {
          this.a.put(paramString, new Object());
        }
      }
    }
    return this.a.get(paramString);
  }
  
  public void a()
  {
    QLog.i("GuildMessageCache", 1, "clear.");
    synchronized (this.a)
    {
      this.a.clear();
      this.b.clear();
      e();
      return;
    }
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    this.b.add(paramArrayOfObject);
  }
  
  public List<Object[]> b()
  {
    return this.b;
  }
  
  public void b(Object[] paramArrayOfObject)
  {
    try
    {
      this.c.add(paramArrayOfObject);
      return;
    }
    finally
    {
      paramArrayOfObject = finally;
      throw paramArrayOfObject;
    }
  }
  
  public void c()
  {
    this.b.clear();
  }
  
  public List<Object[]> d()
  {
    try
    {
      ArrayList localArrayList = this.c;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e()
  {
    try
    {
      this.c.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildMessageCache
 * JD-Core Version:    0.7.0.1
 */