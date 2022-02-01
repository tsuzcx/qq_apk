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
  ArrayList<DownloadTask> jdField_a_of_type_JavaUtilArrayList;
  public List<String> a;
  public Map<String, File> a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(2);
  public boolean a;
  public int b;
  public long b;
  public String b;
  private Map<String, String> jdField_b_of_type_JavaUtilMap;
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
  public boolean e;
  public int f;
  public long f;
  public String f;
  public boolean f;
  public int g;
  public long g;
  public boolean g;
  public long h;
  public boolean h;
  public long i;
  public boolean i = true;
  public boolean j = false;
  public boolean k = false;
  public boolean l = false;
  public boolean m = false;
  public boolean n = false;
  public boolean o = true;
  public boolean p = true;
  public boolean q = false;
  public boolean r = false;
  public boolean s = true;
  
  public DownloadTask(String paramString, File paramFile)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 60000;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
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
  
  public DownloadTask(List<String> paramList, Map<String, File> paramMap, String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 60000;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_f_of_type_JavaLangString = "Vip";
    this.jdField_a_of_type_Byte = 0;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo = new DownloadTask.ReportInfo();
    if (paramList == null) {
      paramList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (paramMap == null) {
      paramMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_Int = 2;
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
  
  public Map<String, String> a()
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
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Int = paramInt;
    paramLong1 = this.jdField_b_of_type_Long;
    float f1 = 100.0F;
    if (paramLong1 <= 0L)
    {
      f1 = 30.0F;
    }
    else
    {
      paramLong2 = this.jdField_a_of_type_Long;
      if (paramLong1 >= paramLong2)
      {
        if (paramInt + 1 == this.jdField_a_of_type_JavaUtilList.size())
        {
          a(3);
          this.jdField_a_of_type_Float = 100.0F;
        }
      }
      else {
        f1 = (float)paramLong1 * 100.0F / (float)paramLong2;
      }
    }
    this.jdField_a_of_type_Float = ((paramInt * 100 + f1) / this.jdField_a_of_type_JavaUtilList.size());
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
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("DownloadTask.addDuplicateListenerTask,task.key=");
      ((StringBuilder)???).append(paramDownloadTask.jdField_a_of_type_JavaLangString);
      QLog.d("DownloadTask", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < 5)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramDownloadTask);
      }
      else if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("DownloadTask.addDuplicateListenerTask, taskList.size() >= DUPLICATE_LIMIT,size=");
        paramDownloadTask.append(this.jdField_a_of_type_JavaUtilArrayList.size());
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
        if (this.jdField_b_of_type_JavaUtilMap == null) {
          this.jdField_b_of_type_JavaUtilMap = new HashMap();
        }
        this.jdField_b_of_type_JavaUtilMap.put(paramString1, paramString2);
        return;
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
    int i1 = this.jdField_a_of_type_Byte;
    boolean bool = false;
    if (((byte)(i1 | 0x0) & paramByte) == paramByte) {
      bool = true;
    }
    return bool;
  }
  
  public int b()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle != null) {
      return localBundle.getInt("id");
    }
    return 0;
  }
  
  public void b()
  {
    if (a() != null) {
      a().onProgress(this);
    }
    int i1;
    label141:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.s))
      {
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label141;
          }
          localDownloadTask.a(a());
          localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
          localDownloadTask.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
          localDownloadTask.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
          localDownloadTask.a().onProgress(localDownloadTask);
          break label141;
        }
      }
      return;
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
    int i1;
    label125:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.s))
      {
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label125;
          }
          localDownloadTask.a(a());
          localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
          localDownloadTask.a().onCancel(localDownloadTask);
          break label125;
        }
      }
      return;
    }
  }
  
  public boolean c()
  {
    boolean bool;
    if (a() != null) {
      bool = a().onStart(this);
    } else {
      bool = true;
    }
    int i1;
    label143:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.s))
      {
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label143;
          }
          localDownloadTask.a(a());
          localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
          localDownloadTask.a().onStart(localDownloadTask);
          break label143;
        }
      }
      return bool;
    }
  }
  
  public void d()
  {
    if (a() != null) {
      a().onPause(this);
    }
    int i1;
    label125:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.s))
      {
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label125;
          }
          localDownloadTask.a(a());
          localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
          localDownloadTask.a().onPause(localDownloadTask);
          break label125;
        }
      }
      return;
    }
  }
  
  public void e()
  {
    if (a() != null) {
      a().onDoneFile(this);
    }
    int i1;
    label125:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.s))
      {
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label125;
          }
          localDownloadTask.a(a());
          localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
          localDownloadTask.a().onDoneFile(localDownloadTask);
          break label125;
        }
      }
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof DownloadTask)) && (((DownloadTask)paramObject).jdField_a_of_type_JavaUtilList.equals(this.jdField_a_of_type_JavaUtilList));
  }
  
  public void f()
  {
    if (a() != null) {
      a().onDone(this);
    }
    int i1;
    label125:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.s))
      {
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label125;
          }
          localDownloadTask.a(a());
          localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
          localDownloadTask.a().onDone(localDownloadTask);
          break label125;
        }
      }
      return;
    }
  }
  
  public void g()
  {
    if (a() != null) {
      a().onNetWifi2Mobile();
    }
    int i1;
    label123:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.s))
      {
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label123;
          }
          localDownloadTask.a(a());
          localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
          localDownloadTask.a().onNetWifi2Mobile();
          break label123;
        }
      }
      return;
    }
  }
  
  public void h()
  {
    if (a() != null) {
      a().onNetWifi2None();
    }
    int i1;
    label123:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.s))
      {
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label123;
          }
          localDownloadTask.a(a());
          localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
          localDownloadTask.a().onNetWifi2None();
          break label123;
        }
      }
      return;
    }
  }
  
  public void i()
  {
    if (a() != null) {
      a().onNetMobile2None();
    }
    int i1;
    label123:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.s))
      {
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if ((localDownloadTask == null) || (localDownloadTask.a() == null)) {
            break label123;
          }
          localDownloadTask.a(a());
          localDownloadTask.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localDownloadTask.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
          localDownloadTask.a().onNetMobile2None();
          break label123;
        }
      }
      return;
    }
  }
  
  public void j()
  {
    int i1;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i1 >= 0)
        {
          DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if (localDownloadTask != null) {
            localDownloadTask.a(null);
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList = null;
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
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",urlList size=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
    localStringBuilder.append("|currentUrlIndex=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("|errCode=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|status=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
    localStringBuilder.append("|readSize=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("|maxSize=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("|percent=");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloadTask
 * JD-Core Version:    0.7.0.1
 */