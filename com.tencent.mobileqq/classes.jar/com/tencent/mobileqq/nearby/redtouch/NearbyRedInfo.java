package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NearbyRedInfo
{
  public static HashMap<Integer, Integer> a = new HashMap();
  public int b = -1;
  public int c = 0;
  public String d = "";
  public List<String> e = new ArrayList();
  public long f = 0L;
  public int g;
  public int h;
  public String i = "";
  public String j = "";
  
  static
  {
    a.put(Integer.valueOf(11), Integer.valueOf(20));
    a.put(Integer.valueOf(3), Integer.valueOf(40));
    a.put(Integer.valueOf(5), Integer.valueOf(60));
    a.put(Integer.valueOf(0), Integer.valueOf(80));
    a.put(Integer.valueOf(-1), Integer.valueOf(100));
  }
  
  public void a(int paramInt)
  {
    Integer localInteger1 = (Integer)a.get(Integer.valueOf(paramInt));
    Integer localInteger2 = (Integer)a.get(Integer.valueOf(this.b));
    if ((localInteger1 != null) && (localInteger2 != null) && (localInteger1.compareTo(localInteger2) < 0)) {
      this.b = paramInt;
    }
  }
  
  public void a(String paramString)
  {
    int k = 0;
    try
    {
      int m = Integer.valueOf(paramString).intValue();
      k = m;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("NearbyRedInfo", 1, localNumberFormatException, new Object[0]);
      this.d = paramString;
    }
    this.c += k;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    if (paramBoolean) {
      this.e.clear();
    }
    this.e.add(paramString);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    if (paramBoolean) {
      this.e.clear();
    }
    this.e.addAll(paramList);
  }
  
  public void b(int paramInt)
  {
    this.c += paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[redType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", redNum=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", redTxt=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", redAppIdType=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.NearbyRedInfo
 * JD-Core Version:    0.7.0.1
 */