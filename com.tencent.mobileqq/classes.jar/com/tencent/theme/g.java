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
  volatile boolean d;
  int e = 0;
  HashMap<String, Integer> f = new HashMap();
  HashSet<String> g = new HashSet();
  
  public g(SkinEngine paramSkinEngine, Resources paramResources)
  {
    this.a = paramResources;
    this.e = 0;
    this.b = paramSkinEngine;
    this.c = new g.a(this, null);
  }
  
  public Integer a(String paramString)
  {
    return (Integer)this.f.get(paramString);
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
  
  public boolean b()
  {
    if (!this.d)
    {
      h.a("SkinEngine", 1, "recordSuccess : false");
      return false;
    }
    if ((this.b.getRealRootPath() != null) && (this.e == 0))
    {
      h.a("SkinEngine", 1, "not default theme, but res size is 0");
      return false;
    }
    return this.d;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.g.contains(paramString);
  }
  
  public void c()
  {
    g.a locala = this.c;
    if (locala != null)
    {
      if (locala.getStatus() == AsyncTask.Status.PENDING)
      {
        h.a("SkinEngine", 1, "mRecordTask status is PENDING");
        e();
        this.c.execute(new Void[0]);
        return;
      }
      if (this.c.getStatus() == AsyncTask.Status.RUNNING)
      {
        h.a("SkinEngine", 1, "mRecordTask status is RUNNING");
        this.c.cancel(true);
        e();
        this.c = new g.a(this, null);
        this.c.execute(new Void[0]);
        return;
      }
      if (this.c.getStatus() == AsyncTask.Status.FINISHED)
      {
        h.a("SkinEngine", 1, "mRecordTask status is FINISHED");
        this.c = new g.a(this, null);
        e();
        this.c.execute(new Void[0]);
      }
    }
    else
    {
      this.c = new g.a(this, null);
      h.a("SkinEngine", 1, "mRecordTask is null");
      e();
      this.c.execute(new Void[0]);
    }
  }
  
  public void d()
  {
    new TypedValue();
    long l1 = SystemClock.uptimeMillis();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[record]start,  pid:");
    ((StringBuilder)localObject1).append(Process.myPid());
    h.d("SkinEngine", 2, ((StringBuilder)localObject1).toString(), null);
    this.e = 0;
    localObject1 = this.b.getThemeDirFile();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getThemeDirFile ： ");
    ((StringBuilder)localObject2).append(localObject1);
    h.a("SkinEngine", 1, ((StringBuilder)localObject2).toString());
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      localObject2 = ((File)localObject1).list();
      Object localObject3;
      if ((localObject2 != null) && (localObject2.length != 0))
      {
        int k = localObject2.length;
        int i = 0;
        for (;;)
        {
          int j = 0;
          if (i >= k) {
            break;
          }
          localObject3 = localObject2[i];
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject3);
          ((StringBuilder)localObject4).append("/");
          localObject4 = new File((File)localObject1, ((StringBuilder)localObject4).toString());
          if (((File)localObject4).exists())
          {
            localObject4 = ((File)localObject4).list();
            if (localObject4 != null)
            {
              int m = localObject4.length;
              while (j < m)
              {
                String str = localObject4[j];
                str = str.substring(str.lastIndexOf("/") + 1);
                SkinEngine localSkinEngine = this.b;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append((String)localObject3);
                localStringBuilder.append("/");
                int n = localSkinEngine.getDrawableDpi(localStringBuilder.toString());
                if (-1 != n)
                {
                  while (-2 == n)
                  {
                    this.g.add(str);
                    this.e += 1;
                  }
                  this.f.put(str, Integer.valueOf(n));
                  this.e += 1;
                }
                j += 1;
              }
              h.a("SkinEngine", 1, "record result success");
              this.d = true;
            }
          }
          i += 1;
        }
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("searchAll, allDrawable : ");
        if (localObject2 == null) {
          localObject1 = "null";
        } else {
          localObject1 = Integer.valueOf(localObject2.length);
        }
        ((StringBuilder)localObject3).append(localObject1);
        h.a("SkinEngine", 1, ((StringBuilder)localObject3).toString());
      }
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("searchAll, themeDir : ");
      ((StringBuilder)localObject2).append(localObject1);
      h.a("SkinEngine", 1, ((StringBuilder)localObject2).toString());
    }
    long l2 = SystemClock.uptimeMillis();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("record result : ");
    ((StringBuilder)localObject1).append(this.d);
    h.a("SkinEngine", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[record]end, mCacheEntry:");
    ((StringBuilder)localObject1).append(this.e);
    ((StringBuilder)localObject1).append(" pid:");
    ((StringBuilder)localObject1).append(Process.myPid());
    ((StringBuilder)localObject1).append(" touchCacheDuration:");
    ((StringBuilder)localObject1).append(l2 - l1);
    h.d("SkinEngine", 2, ((StringBuilder)localObject1).toString(), null);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("record finish : ");
    ((StringBuilder)localObject1).append(this.e);
    ((StringBuilder)localObject1).append(" map size : ");
    ((StringBuilder)localObject1).append(this.f.size());
    ((StringBuilder)localObject1).append("  color size : ");
    ((StringBuilder)localObject1).append(this.g.size());
    h.a("SkinEngine", 1, ((StringBuilder)localObject1).toString());
  }
  
  protected void e()
  {
    h.a("SkinEngine", 1, "start clear");
    this.f.clear();
    this.g.clear();
    this.e = 0;
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.theme.g
 * JD-Core Version:    0.7.0.1
 */