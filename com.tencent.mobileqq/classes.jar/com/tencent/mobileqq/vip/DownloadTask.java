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
  public byte a;
  public float a;
  public int a;
  public long a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  public DownloadTask.ReportInfo a;
  Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public List a;
  public Map a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(2);
  public boolean a;
  public int b;
  public long b;
  public String b;
  private Map jdField_b_of_type_JavaUtilMap;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e = true;
  public long f;
  public String f;
  public boolean f;
  public long g;
  public boolean g = true;
  public long h;
  public boolean h;
  public long i;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  public boolean m = true;
  public boolean n = true;
  public boolean o;
  public boolean p;
  public boolean q = true;
  
  public DownloadTask(String paramString, File paramFile)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_f_of_type_JavaLangString = "Vip";
    this.jdField_a_of_type_Byte = 0;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo = new DownloadTask.ReportInfo();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramFile);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_Int = 1;
  }
  
  public DownloadTask(List paramList, Map paramMap, String paramString)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_f_of_type_JavaLangString = "Vip";
    this.jdField_a_of_type_Byte = 0;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo = new DownloadTask.ReportInfo();
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      if (paramMap == null) {
        break label163;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap = paramMap;
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_d_of_type_Int = 2;
      return;
      paramList = new ArrayList();
      break;
      label163:
      paramMap = new HashMap();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public Bundle a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public DownloadListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  }
  
  public Map a()
  {
    return this.jdField_b_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    this.jdField_d_of_type_Long = 0L;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    float f1 = 100.0F;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Int = paramInt;
    if (this.jdField_b_of_type_Long <= 0L) {
      f1 = 30.0F;
    }
    for (;;)
    {
      this.jdField_a_of_type_Float = ((f1 + paramInt * 100) / this.jdField_a_of_type_JavaUtilList.size());
      return;
      if (this.jdField_b_of_type_Long >= this.jdField_a_of_type_Long)
      {
        if (paramInt + 1 == this.jdField_a_of_type_JavaUtilList.size())
        {
          a(3);
          this.jdField_a_of_type_Float = 100.0F;
        }
      }
      else {
        f1 = 100.0F * (float)this.jdField_b_of_type_Long / (float)this.jdField_a_of_type_Long;
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = paramDownloadListener;
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloadTask", 2, "DownloadTask.addDuplicateListenerTask,task.key=" + paramDownloadTask.jdField_a_of_type_JavaLangString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < 5) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramDownloadTask);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("DownloadTask", 2, "DownloadTask.addDuplicateListenerTask, taskList.size() >= DUPLICATE_LIMIT,size=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_b_of_type_JavaUtilMap == null) {
          this.jdField_b_of_type_JavaUtilMap = new HashMap();
        }
        this.jdField_b_of_type_JavaUtilMap.put(paramString1, paramString2);
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean a(byte paramByte)
  {
    return ((byte)(this.jdField_a_of_type_Byte | 0x0) & paramByte) == paramByte;
  }
  
  public int b()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("id");
    }
    return i1;
  }
  
  public void b()
  {
    if (a() != null) {
      a().onProgress(this);
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.q))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label135;
            }
            localDownloadTask.a(a());
            localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
            localDownloadTask.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
            localDownloadTask.a().onProgress(localDownloadTask);
          }
        }
      }
      return;
      label135:
      i1 -= 1;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_f_of_type_Long = paramInt;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void c()
  {
    if (a() != null) {
      a().onCancel(this);
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.q))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label119;
            }
            localDownloadTask.a(a());
            localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onCancel(localDownloadTask);
          }
        }
      }
      return;
      label119:
      i1 -= 1;
    }
  }
  
  public boolean c()
  {
    boolean bool;
    if (a() != null) {
      bool = a().onStart(this);
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.q))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label137;
            }
            localDownloadTask.a(a());
            localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onStart(localDownloadTask);
          }
        }
      }
      return bool;
      bool = true;
      continue;
      label137:
      i1 -= 1;
    }
  }
  
  public void d()
  {
    if (a() != null) {
      a().onDoneFile(this);
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.q))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label119;
            }
            localDownloadTask.a(a());
            localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onDoneFile(localDownloadTask);
          }
        }
      }
      return;
      label119:
      i1 -= 1;
    }
  }
  
  public void e()
  {
    if (a() != null) {
      a().onDone(this);
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.q))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label119;
            }
            localDownloadTask.a(a());
            localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onDone(localDownloadTask);
          }
        }
      }
      return;
      label119:
      i1 -= 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof DownloadTask)) && (((DownloadTask)paramObject).jdField_a_of_type_JavaUtilList.equals(this.jdField_a_of_type_JavaUtilList));
  }
  
  public void f()
  {
    if (a() != null) {
      a().onNetWifi2Mobile();
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.q))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label117;
            }
            localDownloadTask.a(a());
            localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onNetWifi2Mobile();
          }
        }
      }
      return;
      label117:
      i1 -= 1;
    }
  }
  
  public void g()
  {
    if (a() != null) {
      a().onNetWifi2None();
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.q))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label117;
            }
            localDownloadTask.a(a());
            localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onNetWifi2None();
          }
        }
      }
      return;
      label117:
      i1 -= 1;
    }
  }
  
  public void h()
  {
    if (a() != null) {
      a().onNetMobile2None();
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.q))
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i1 >= 0)
          {
            DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
            if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
              break label117;
            }
            localDownloadTask.a(a());
            localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
            localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
            localDownloadTask.a().onNetMobile2None();
          }
        }
      }
      return;
      label117:
      i1 -= 1;
    }
  }
  
  public void i()
  {
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          break label72;
        }
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if (localDownloadTask == null) {
            break label75;
          }
          localDownloadTask.a(null);
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
      label72:
      return;
      label75:
      i1 -= 1;
    }
  }
  
  public String toString()
  {
    return " key=" + this.jdField_a_of_type_JavaLangString + ",urlList size=" + this.jdField_a_of_type_JavaUtilList.size() + "|currentUrlIndex=" + this.jdField_c_of_type_Int + "|errCode=" + this.jdField_a_of_type_Int + "|status=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger + "|readSize=" + this.jdField_b_of_type_Long + "|maxSize=" + this.jdField_a_of_type_Long + "|percent=" + this.jdField_a_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloadTask
 * JD-Core Version:    0.7.0.1
 */