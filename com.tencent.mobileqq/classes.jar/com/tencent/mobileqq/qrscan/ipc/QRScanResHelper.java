package com.tencent.mobileqq.qrscan.ipc;

import com.tencent.mobileqq.qrscan.IQRScanIPCConst;
import com.tencent.mobileqq.qrscan.IQRScanIPCConst.IMiniResDownloadCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

public class QRScanResHelper
  implements IQRScanIPCConst, IQRScanIPCConst.IMiniResDownloadCallback
{
  private static volatile QRScanResHelper c;
  List<WeakReference<IQRScanIPCConst.IMiniResDownloadCallback>> a = new ArrayList();
  HashSet<Object> b = new HashSet(3);
  
  public static QRScanResHelper a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new QRScanResHelper();
        }
      }
      finally {}
    }
    return c;
  }
  
  public void a(int paramInt)
  {
    QRScanSubQIPCModule.a().a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject2 = new ArrayList(this.a.size() + 1);
    synchronized (this.a)
    {
      ((List)localObject2).addAll(this.a);
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (IQRScanIPCConst.IMiniResDownloadCallback)((WeakReference)((Iterator)???).next()).get();
        if (localObject2 != null) {
          ((IQRScanIPCConst.IMiniResDownloadCallback)localObject2).a(paramInt1, paramInt2);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = new ArrayList(this.a.size() + 1);
    synchronized (this.a)
    {
      ((List)localObject2).addAll(this.a);
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (IQRScanIPCConst.IMiniResDownloadCallback)((WeakReference)((Iterator)???).next()).get();
        if (localObject2 != null) {
          ((IQRScanIPCConst.IMiniResDownloadCallback)localObject2).a(paramInt, paramBoolean);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void a(IQRScanIPCConst.IMiniResDownloadCallback paramIMiniResDownloadCallback)
  {
    int i;
    label122:
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        i = this.a.size() - 1;
        if (i >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.a.get(i);
          if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() != paramIMiniResDownloadCallback)) {
            break label122;
          }
          this.a.remove(i);
          break label122;
        }
      }
      if (paramIMiniResDownloadCallback != null) {
        this.a.add(new WeakReference(paramIMiniResDownloadCallback));
      }
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    try
    {
      boolean bool = this.b.add(paramObject);
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.QRScanResHelper", 2, String.format("init deal=%b obj=%s", new Object[] { Boolean.valueOf(bool), paramObject }));
      }
      if (!bool) {
        return;
      }
      QRScanSubQIPCModule.a().b();
      QRScanSubQIPCModule.a().a(this);
      return;
    }
    finally {}
  }
  
  public void b()
  {
    synchronized (this.a)
    {
      this.a.clear();
      return;
    }
  }
  
  public void b(IQRScanIPCConst.IMiniResDownloadCallback paramIMiniResDownloadCallback)
  {
    int i;
    label100:
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        i = this.a.size() - 1;
        if (i >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.a.get(i);
          if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() != paramIMiniResDownloadCallback)) {
            break label100;
          }
          this.a.remove(i);
          break label100;
        }
      }
      return;
    }
  }
  
  public void b(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    try
    {
      boolean bool = this.b.remove(paramObject);
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.QRScanResHelper", 2, String.format("unInit deal=%b remove=%b obj=%s", new Object[] { Boolean.valueOf(this.b.isEmpty()), Boolean.valueOf(bool), paramObject }));
      }
      if (!bool) {
        return;
      }
      if (this.b.isEmpty())
      {
        QRScanSubQIPCModule.a().a(null);
        b();
        QRScanSubQIPCModule.a().c();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ipc.QRScanResHelper
 * JD-Core Version:    0.7.0.1
 */