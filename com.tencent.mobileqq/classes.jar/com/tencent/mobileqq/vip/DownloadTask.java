package com.tencent.mobileqq.vip;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadTask
{
  public long A = 0L;
  public long B = 0L;
  public boolean C = true;
  public boolean D = false;
  public boolean E = false;
  public boolean F = false;
  public boolean G = false;
  public int H;
  public long I;
  public boolean J = false;
  public String K;
  public String L = "Vip";
  public boolean M = true;
  public boolean N = true;
  public byte O = 0;
  public boolean P = false;
  public boolean Q = false;
  public int R;
  public DownloadTask.ReportInfo S = new DownloadTask.ReportInfo();
  public boolean T = true;
  ArrayList<DownloadTask> U;
  Object V = new Object();
  private AtomicInteger W = new AtomicInteger(2);
  private AtomicBoolean X = new AtomicBoolean(false);
  private AtomicBoolean Y = new AtomicBoolean(false);
  private DownloadListener Z;
  public boolean a = false;
  private Bundle aa;
  private Map<String, String> ab;
  public String b = null;
  public int c = 0;
  public String d;
  public int e = 3;
  public List<String> f;
  public Map<String, File> g;
  public String h;
  public int i;
  public long j;
  public long k;
  public float l = 0.0F;
  public boolean m = false;
  public int n;
  public boolean o = true;
  public boolean p = true;
  public boolean q = true;
  public String r = null;
  public boolean s = false;
  public long t = 0L;
  public long u = 0L;
  public int v = 60000;
  public boolean w = false;
  public boolean x = false;
  public long y = 0L;
  public long z = 0L;
  
  public DownloadTask(String paramString, File paramFile)
  {
    this.f = new ArrayList();
    this.g = new HashMap();
    this.f.add(paramString);
    this.g.put(paramString, paramFile);
    this.b = paramString;
    this.n = 1;
  }
  
  public DownloadTask(List<String> paramList, Map<String, File> paramMap, String paramString)
  {
    if (paramList == null) {
      paramList = new ArrayList();
    }
    this.f = paramList;
    if (paramMap == null) {
      paramMap = new HashMap();
    }
    this.g = paramMap;
    this.b = paramString;
    this.n = 2;
  }
  
  public DownloadListener a()
  {
    return this.Z;
  }
  
  public void a(int paramInt)
  {
    this.W.set(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    this.j = paramLong1;
    this.k = paramLong2;
    this.i = paramInt;
    paramLong1 = this.k;
    float f1 = 100.0F;
    if (paramLong1 <= 0L)
    {
      f1 = 30.0F;
    }
    else
    {
      paramLong2 = this.j;
      if (paramLong1 >= paramLong2)
      {
        if (paramInt + 1 == this.f.size())
        {
          a(3);
          this.l = 100.0F;
        }
      }
      else {
        f1 = (float)paramLong1 * 100.0F / (float)paramLong2;
      }
    }
    this.l = ((paramInt * 100 + f1) / this.f.size());
  }
  
  public void a(Bundle paramBundle)
  {
    this.aa = paramBundle;
  }
  
  public void a(DownloadListener paramDownloadListener)
  {
    this.Z = paramDownloadListener;
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("DownloadTask.addDuplicateListenerTask,task.key=");
      ((StringBuilder)???).append(paramDownloadTask.b);
      QLog.d("DownloadTask", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.V)
    {
      if (this.U == null) {
        this.U = new ArrayList();
      }
      if (this.U.size() < 5)
      {
        this.U.add(paramDownloadTask);
      }
      else if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("DownloadTask.addDuplicateListenerTask, taskList.size() >= DUPLICATE_LIMIT,size=");
        paramDownloadTask.append(this.U.size());
        QLog.d("DownloadTask", 2, paramDownloadTask.toString());
      }
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      try
      {
        if (this.ab == null) {
          this.ab = new HashMap();
        }
        this.ab.put(paramString1, paramString2);
        return;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.X.set(paramBoolean);
  }
  
  public boolean a(byte paramByte)
  {
    int i1 = this.O;
    boolean bool = false;
    if (((byte)(i1 | 0x0) & paramByte) == paramByte) {
      bool = true;
    }
    return bool;
  }
  
  public Bundle b()
  {
    if (this.aa == null) {
      this.aa = new Bundle();
    }
    return this.aa;
  }
  
  public void b(int paramInt)
  {
    this.z = paramInt;
  }
  
  public boolean c()
  {
    return this.Y.get();
  }
  
  public void d()
  {
    this.u = 0L;
    this.Y.set(true);
  }
  
  public int e()
  {
    return this.W.get();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof DownloadTask)) && (((DownloadTask)paramObject).f.equals(this.f));
  }
  
  public boolean f()
  {
    return this.X.get();
  }
  
  public int g()
  {
    Bundle localBundle = this.aa;
    if (localBundle != null) {
      return localBundle.getInt("id");
    }
    return 0;
  }
  
  public Map<String, String> h()
  {
    return this.ab;
  }
  
  public boolean i()
  {
    boolean bool;
    if (a() != null) {
      bool = a().onStart(this);
    } else {
      bool = true;
    }
    int i1;
    label143:
    synchronized (this.V)
    {
      if ((this.U != null) && (this.T))
      {
        i1 = this.U.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.U.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label143;
          }
          localDownloadTask.a(e());
          localDownloadTask.c = this.c;
          localDownloadTask.l = this.l;
          localDownloadTask.a().onStart(localDownloadTask);
          break label143;
        }
      }
      return bool;
    }
  }
  
  public void j()
  {
    if (a() != null) {
      a().onProgress(this);
    }
    int i1;
    label141:
    synchronized (this.V)
    {
      if ((this.U != null) && (this.T))
      {
        i1 = this.U.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.U.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label141;
          }
          localDownloadTask.a(e());
          localDownloadTask.c = this.c;
          localDownloadTask.l = this.l;
          localDownloadTask.j = this.j;
          localDownloadTask.k = this.k;
          localDownloadTask.a().onProgress(localDownloadTask);
          break label141;
        }
      }
      return;
    }
  }
  
  public void k()
  {
    if (a() != null) {
      a().onCancel(this);
    }
    int i1;
    label125:
    synchronized (this.V)
    {
      if ((this.U != null) && (this.T))
      {
        i1 = this.U.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.U.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label125;
          }
          localDownloadTask.a(e());
          localDownloadTask.c = this.c;
          localDownloadTask.l = this.l;
          localDownloadTask.a().onCancel(localDownloadTask);
          break label125;
        }
      }
      return;
    }
  }
  
  public void l()
  {
    if (a() != null) {
      a().onPause(this);
    }
    int i1;
    label125:
    synchronized (this.V)
    {
      if ((this.U != null) && (this.T))
      {
        i1 = this.U.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.U.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label125;
          }
          localDownloadTask.a(e());
          localDownloadTask.c = this.c;
          localDownloadTask.l = this.l;
          localDownloadTask.a().onPause(localDownloadTask);
          break label125;
        }
      }
      return;
    }
  }
  
  public void m()
  {
    if (a() != null) {
      a().onDoneFile(this);
    }
    int i1;
    label125:
    synchronized (this.V)
    {
      if ((this.U != null) && (this.T))
      {
        i1 = this.U.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.U.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label125;
          }
          localDownloadTask.a(e());
          localDownloadTask.c = this.c;
          localDownloadTask.l = this.l;
          localDownloadTask.a().onDoneFile(localDownloadTask);
          break label125;
        }
      }
      return;
    }
  }
  
  public void n()
  {
    if (a() != null) {
      a().onDone(this);
    }
    int i1;
    label125:
    synchronized (this.V)
    {
      if ((this.U != null) && (this.T))
      {
        i1 = this.U.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.U.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label125;
          }
          localDownloadTask.a(e());
          localDownloadTask.c = this.c;
          localDownloadTask.l = this.l;
          localDownloadTask.a().onDone(localDownloadTask);
          break label125;
        }
      }
      return;
    }
  }
  
  public void o()
  {
    if (a() != null) {
      a().onNetWifi2Mobile();
    }
    int i1;
    label123:
    synchronized (this.V)
    {
      if ((this.U != null) && (this.T))
      {
        i1 = this.U.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.U.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label123;
          }
          localDownloadTask.a(e());
          localDownloadTask.c = this.c;
          localDownloadTask.l = this.l;
          localDownloadTask.a().onNetWifi2Mobile();
          break label123;
        }
      }
      return;
    }
  }
  
  public void p()
  {
    if (a() != null) {
      a().onNetWifi2None();
    }
    int i1;
    label123:
    synchronized (this.V)
    {
      if ((this.U != null) && (this.T))
      {
        i1 = this.U.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.U.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label123;
          }
          localDownloadTask.a(e());
          localDownloadTask.c = this.c;
          localDownloadTask.l = this.l;
          localDownloadTask.a().onNetWifi2None();
          break label123;
        }
      }
      return;
    }
  }
  
  public void q()
  {
    if (a() != null) {
      a().onNetMobile2None();
    }
    int i1;
    label123:
    synchronized (this.V)
    {
      if ((this.U != null) && (this.T))
      {
        i1 = this.U.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.U.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label123;
          }
          localDownloadTask.a(e());
          localDownloadTask.c = this.c;
          localDownloadTask.l = this.l;
          localDownloadTask.a().onNetMobile2None();
          break label123;
        }
      }
      return;
    }
  }
  
  public void r()
  {
    int i1;
    synchronized (this.V)
    {
      if (this.U != null)
      {
        i1 = this.U.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.U.get(i1);
          if (localDownloadTask != null) {
            localDownloadTask.a(null);
          }
        }
        else
        {
          this.U.clear();
          this.U = null;
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" key=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",urlList size=");
    localStringBuilder.append(this.f.size());
    localStringBuilder.append("|currentUrlIndex=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("|errCode=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|status=");
    localStringBuilder.append(this.W);
    localStringBuilder.append("|readSize=");
    localStringBuilder.append(this.k);
    localStringBuilder.append("|maxSize=");
    localStringBuilder.append(this.j);
    localStringBuilder.append("|percent=");
    localStringBuilder.append(this.l);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloadTask
 * JD-Core Version:    0.7.0.1
 */