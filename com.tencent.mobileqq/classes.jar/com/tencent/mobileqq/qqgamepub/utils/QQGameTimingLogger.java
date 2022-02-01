package com.tencent.mobileqq.qqgamepub.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QQGameTimingLogger
{
  private String a;
  private String b;
  private CopyOnWriteArrayList<Pair<String, Long>> c;
  
  public QQGameTimingLogger(String paramString1, String paramString2)
  {
    a(paramString1, paramString2);
  }
  
  public void a()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.c;
    if (localCopyOnWriteArrayList == null) {
      this.c = new CopyOnWriteArrayList();
    } else {
      localCopyOnWriteArrayList.clear();
    }
    a("begin");
  }
  
  public void a(String paramString)
  {
    paramString = new Pair(paramString, Long.valueOf(SystemClock.elapsedRealtime()));
    this.c.add(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    a();
  }
  
  public long b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (((String)localPair.first).equals(paramString)) {
          return ((Long)localPair.second).longValue();
        }
      }
    }
    return 0L;
  }
  
  public void b()
  {
    String str = this.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(": begin");
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
    try
    {
      long l2 = ((Long)((Pair)this.c.get(0)).second).longValue();
      long l1 = l2;
      int i = 1;
      while (i < this.c.size())
      {
        l1 = ((Long)((Pair)this.c.get(i)).second).longValue();
        str = (String)((Pair)this.c.get(i)).first;
        long l3 = ((Long)((Pair)this.c.get(i - 1)).second).longValue();
        localObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b);
        localStringBuilder.append(":      ");
        localStringBuilder.append(l1 - l3);
        localStringBuilder.append(" ms, ");
        localStringBuilder.append(str);
        QLog.d((String)localObject, 1, localStringBuilder.toString());
        i += 1;
      }
      str = this.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(": end, ");
      ((StringBuilder)localObject).append(l1 - l2);
      ((StringBuilder)localObject).append(" ms");
      QLog.d(str, 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public String c()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Pair)localIterator.next();
      String str = (String)((Pair)localObject).first;
      localObject = (Long)((Pair)localObject).second;
      localStringBuffer.append(str);
      localStringBuffer.append("=");
      localStringBuffer.append(localObject);
      localStringBuffer.append("| ");
    }
    return localStringBuffer.toString();
  }
  
  public List<Long> d()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    while (i < this.c.size())
    {
      localArrayList.add(Long.valueOf(((Long)((Pair)this.c.get(i)).second).longValue() - ((Long)((Pair)this.c.get(i - 1)).second).longValue()));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.QQGameTimingLogger
 * JD-Core Version:    0.7.0.1
 */