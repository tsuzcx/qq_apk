package com.tencent.theme;

import android.content.res.Resources;
import android.os.AsyncTask.Status;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class g
{
  Resources a = null;
  SkinEngine b;
  g.a c = null;
  int d = 0;
  HashMap<String, Integer> e = new HashMap();
  HashSet<String> f = new HashSet();
  
  public g(SkinEngine paramSkinEngine, Resources paramResources)
  {
    this.a = paramResources;
    this.d = 0;
    this.b = paramSkinEngine;
    this.c = new g.a(this, null);
  }
  
  public Integer a(String paramString)
  {
    return (Integer)this.e.get(paramString);
  }
  
  public boolean a()
  {
    g.a locala = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (locala != null)
    {
      bool1 = bool2;
      if (locala.getStatus() == AsyncTask.Status.RUNNING) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    g.a locala = this.c;
    if (locala != null)
    {
      if (locala.getStatus() == AsyncTask.Status.PENDING)
      {
        d();
        this.c.execute(new Void[0]);
        return;
      }
      if (this.c.getStatus() == AsyncTask.Status.RUNNING)
      {
        this.c.cancel(true);
        d();
        this.c = new g.a(this, null);
        this.c.execute(new Void[0]);
        return;
      }
      if (this.c.getStatus() == AsyncTask.Status.FINISHED)
      {
        this.c = new g.a(this, null);
        d();
        this.c.execute(new Void[0]);
      }
    }
    else
    {
      this.c = new g.a(this, null);
      d();
      this.c.execute(new Void[0]);
    }
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.f.contains(paramString);
  }
  
  public void c()
  {
    new TypedValue();
    long l1 = SystemClock.uptimeMillis();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[record]start,  pid:");
    ((StringBuilder)localObject1).append(Process.myPid());
    h.d("SkinEngine", 2, ((StringBuilder)localObject1).toString(), null);
    this.d = 0;
    localObject1 = this.b.getThemeDirFile();
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      String[] arrayOfString = ((File)localObject1).list();
      if ((arrayOfString != null) && (arrayOfString.length != 0))
      {
        int k = arrayOfString.length;
        int i = 0;
        while (i < k)
        {
          String str1 = arrayOfString[i];
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str1);
          ((StringBuilder)localObject2).append("/");
          localObject2 = new File((File)localObject1, ((StringBuilder)localObject2).toString());
          if (((File)localObject2).exists())
          {
            localObject2 = ((File)localObject2).list();
            if (localObject2 != null)
            {
              int m = localObject2.length;
              int j = 0;
              while (j < m)
              {
                String str2 = localObject2[j];
                str2 = str2.substring(str2.lastIndexOf("/") + 1);
                SkinEngine localSkinEngine = this.b;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(str1);
                localStringBuilder.append("/");
                int n = localSkinEngine.getDrawableDpi(localStringBuilder.toString());
                if (-1 != n) {
                  if (-2 == n)
                  {
                    this.f.add(str2);
                    this.d += 1;
                  }
                  else
                  {
                    this.e.put(str2, Integer.valueOf(n));
                    this.d += 1;
                  }
                }
                j += 1;
              }
            }
          }
          i += 1;
        }
      }
    }
    long l2 = SystemClock.uptimeMillis();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[record]end, mCacheEntry:");
    ((StringBuilder)localObject1).append(this.d);
    ((StringBuilder)localObject1).append(" pid:");
    ((StringBuilder)localObject1).append(Process.myPid());
    ((StringBuilder)localObject1).append(" touchCacheDuration:");
    ((StringBuilder)localObject1).append(l2 - l1);
    h.d("SkinEngine", 2, ((StringBuilder)localObject1).toString(), null);
  }
  
  protected void d()
  {
    this.e.clear();
    this.d = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.g
 * JD-Core Version:    0.7.0.1
 */