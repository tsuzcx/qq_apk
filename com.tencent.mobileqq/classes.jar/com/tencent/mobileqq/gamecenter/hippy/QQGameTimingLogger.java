package com.tencent.mobileqq.gamecenter.hippy;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QQGameTimingLogger
{
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private Map<String, Long> jdField_a_of_type_JavaUtilMap;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  
  public QQGameTimingLogger(String paramString1, String paramString2)
  {
    a(paramString1, paramString2);
  }
  
  public long a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      return ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramString)).longValue();
    }
    return 0L;
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (Long)((Map.Entry)localObject).getValue();
        localStringBuffer.append(str).append("=").append(localObject).append("| ");
      }
    }
    return localStringBuffer.toString();
  }
  
  public List<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(0)).longValue();
    int i = 1;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      long l = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue();
      String str = (String)this.jdField_b_of_type_JavaUtilArrayList.get(i);
      localArrayList.add(Long.valueOf(l - ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i - 1)).longValue()));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    for (;;)
    {
      a("begin");
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void a(String paramString)
  {
    long l = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
    this.jdField_b_of_type_JavaUtilArrayList.add(paramString);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(l));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    a();
  }
  
  public void b()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, this.jdField_b_of_type_JavaLangString + ": begin");
    long l2 = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(0)).longValue();
    int i = 1;
    long l1 = l2;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue();
      String str = (String)this.jdField_b_of_type_JavaUtilArrayList.get(i);
      long l3 = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i - 1)).longValue();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, this.jdField_b_of_type_JavaLangString + ":      " + (l1 - l3) + " ms, " + str);
      i += 1;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, this.jdField_b_of_type_JavaLangString + ": end, " + (l1 - l2) + " ms");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.QQGameTimingLogger
 * JD-Core Version:    0.7.0.1
 */