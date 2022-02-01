package com.tencent.rmonitor.fd.cluser;

import com.tencent.rmonitor.fd.data.FdCountable;
import com.tencent.rmonitor.fd.utils.FdLeakUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FdClusterItem
  implements Comparable<FdClusterItem>
{
  private final int a;
  private int b;
  private final Map<String, Integer> c = new HashMap();
  private List<FdCountable> d;
  
  public FdClusterItem(int paramInt)
  {
    this.a = paramInt;
    this.b = 0;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int a(FdClusterItem paramFdClusterItem)
  {
    return paramFdClusterItem.b - this.b;
  }
  
  public void a(String paramString)
  {
    this.b += 1;
    Object localObject2 = (Integer)this.c.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.c;
      localObject1 = Integer.valueOf(0);
      ((Map)localObject2).put(paramString, localObject1);
    }
    this.c.put(paramString, Integer.valueOf(((Integer)localObject1).intValue() + 1));
  }
  
  public int b()
  {
    return this.b;
  }
  
  public Map<String, Integer> c()
  {
    return this.c;
  }
  
  public List<FdCountable> d()
  {
    if (this.d == null) {
      this.d = FdLeakUtil.a(this.c);
    }
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FdStatisticItem{type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", count=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.cluser.FdClusterItem
 * JD-Core Version:    0.7.0.1
 */