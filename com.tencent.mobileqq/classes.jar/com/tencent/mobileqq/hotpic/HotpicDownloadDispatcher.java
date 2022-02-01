package com.tencent.mobileqq.hotpic;

import android.util.SparseArray;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class HotpicDownloadDispatcher
  implements URLDrawable.DownloadListener
{
  boolean a = false;
  int b = 1;
  SparseArray<URLDrawable> c = new SparseArray();
  volatile int d = 0;
  boolean e = false;
  private Object f = new Object();
  private LinkedList<URLDrawable> g = new LinkedList();
  private Set<Integer> h = new HashSet();
  private HotPicPageView i;
  
  public HotpicDownloadDispatcher(HotPicPageView paramHotPicPageView)
  {
    this.i = paramHotPicPageView;
    if (this.i.m == 0)
    {
      b(true);
      return;
    }
    b(false);
  }
  
  private void c()
  {
    try
    {
      synchronized (this.f)
      {
        this.d -= 1;
        while ((this.d < this.b) && (this.g.size() > 0))
        {
          Object localObject3 = (URLDrawable)this.g.removeFirst();
          if (((URLDrawable)localObject3).getStatus() != 1) {
            if (((URLDrawable)localObject3).getStatus() == 2)
            {
              ((URLDrawable)localObject3).restartDownload();
              this.d += 1;
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("handlerNext,restartDownload, current ");
                ((StringBuilder)localObject3).append(this.d);
                QLog.i("HotPicManager.Panel.HotpicDownloadDispatcher", 2, ((StringBuilder)localObject3).toString());
              }
            }
            else
            {
              ((URLDrawable)localObject3).startDownload();
              this.d += 1;
            }
          }
        }
        if ((this.d == 0) && (this.g.size() == 0) && (this.i != null) && (this.a)) {
          this.i.n();
        }
        return;
      }
      throw localObject2;
    }
    finally {}
    for (;;) {}
  }
  
  public void a()
  {
    try
    {
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, URLDrawable paramURLDrawable)
  {
    this.c.put(paramInt, paramURLDrawable);
    paramURLDrawable.startDownload();
    a(paramURLDrawable, paramInt);
  }
  
  public void a(URLDrawable paramURLDrawable, int paramInt)
  {
    label176:
    for (;;)
    {
      try
      {
        synchronized (this.f)
        {
          if (this.h.contains(Integer.valueOf(paramInt))) {
            return;
          }
          this.h.add(Integer.valueOf(paramInt));
          paramURLDrawable.setDownloadListener(this);
          if (this.d >= this.b)
          {
            if (!this.g.contains(paramURLDrawable))
            {
              paramURLDrawable.setAutoDownload(false);
              this.g.addFirst(paramURLDrawable);
              int j = this.g.size();
              if (!this.e) {
                break label176;
              }
              paramInt = 20;
              if (j > paramInt)
              {
                paramURLDrawable = (URLDrawable)this.g.removeLast();
                paramURLDrawable.setAutoDownload(true);
                paramURLDrawable.setDownloadListener(null);
              }
            }
          }
          else
          {
            if (paramURLDrawable.getStatus() == 2) {
              paramURLDrawable.restartDownload();
            }
            this.d += 1;
          }
          return;
        }
        paramInt = 15;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b()
  {
    synchronized (this.f)
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext()) {
        ((URLDrawable)localIterator.next()).setDownloadListener(null);
      }
      this.g.clear();
      int j = 0;
      while (j < this.c.size())
      {
        ((URLDrawable)this.c.valueAt(0)).setDownloadListener(null);
        j += 1;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a = true;
      int j;
      if (this.a) {
        j = 3;
      } else {
        j = 4;
      }
      this.b = j;
      return;
    }
    this.a = false;
    this.b = 1;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.c.remove(paramInt);
    this.h.remove(Integer.valueOf(paramInt));
    c();
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    int j = (int)paramLong;
    this.c.remove(j);
    this.h.remove(Integer.valueOf(j));
    this.i.b(j);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotpicDownloadDispatcher
 * JD-Core Version:    0.7.0.1
 */