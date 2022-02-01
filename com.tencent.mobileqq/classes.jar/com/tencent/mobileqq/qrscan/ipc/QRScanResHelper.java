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
  private static volatile QRScanResHelper jdField_a_of_type_ComTencentMobileqqQrscanIpcQRScanResHelper;
  HashSet<Object> jdField_a_of_type_JavaUtilHashSet = new HashSet(3);
  List<WeakReference<IQRScanIPCConst.IMiniResDownloadCallback>> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static QRScanResHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQrscanIpcQRScanResHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQrscanIpcQRScanResHelper == null) {
          jdField_a_of_type_ComTencentMobileqqQrscanIpcQRScanResHelper = new QRScanResHelper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQrscanIpcQRScanResHelper;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    QRScanSubQIPCModule.a().a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject2 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size() + 1);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      ((List)localObject2).addAll(this.jdField_a_of_type_JavaUtilList);
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
    Object localObject2 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size() + 1);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      ((List)localObject2).addAll(this.jdField_a_of_type_JavaUtilList);
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
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() != paramIMiniResDownloadCallback)) {
            break label122;
          }
          this.jdField_a_of_type_JavaUtilList.remove(i);
          break label122;
        }
      }
      if (paramIMiniResDownloadCallback != null) {
        this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramIMiniResDownloadCallback));
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
      boolean bool = this.jdField_a_of_type_JavaUtilHashSet.add(paramObject);
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.QRScanResHelper", 2, String.format("init deal=%b obj=%s", new Object[] { Boolean.valueOf(bool), paramObject }));
      }
      if (!bool) {
        return;
      }
      QRScanSubQIPCModule.a().a();
      QRScanSubQIPCModule.a().a(this);
      return;
    }
    finally {}
  }
  
  public void b(IQRScanIPCConst.IMiniResDownloadCallback paramIMiniResDownloadCallback)
  {
    int i;
    label100:
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() != paramIMiniResDownloadCallback)) {
            break label100;
          }
          this.jdField_a_of_type_JavaUtilList.remove(i);
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
      boolean bool = this.jdField_a_of_type_JavaUtilHashSet.remove(paramObject);
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.QRScanResHelper", 2, String.format("unInit deal=%b remove=%b obj=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_JavaUtilHashSet.isEmpty()), Boolean.valueOf(bool), paramObject }));
      }
      if (!bool) {
        return;
      }
      if (this.jdField_a_of_type_JavaUtilHashSet.isEmpty())
      {
        QRScanSubQIPCModule.a().a(null);
        a();
        QRScanSubQIPCModule.a().b();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ipc.QRScanResHelper
 * JD-Core Version:    0.7.0.1
 */