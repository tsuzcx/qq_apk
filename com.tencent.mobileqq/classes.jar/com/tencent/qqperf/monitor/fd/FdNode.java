package com.tencent.qqperf.monitor.fd;

import java.util.HashMap;

class FdNode
  implements Comparable<FdNode>
{
  public HashMap<String, FdNode> a = new HashMap(10);
  public String b;
  public int c = 0;
  
  public FdNode() {}
  
  public FdNode(String paramString)
  {
    this.b = paramString;
  }
  
  public int a(FdNode paramFdNode)
  {
    return paramFdNode.c - this.c;
  }
  
  public FdNode a(String paramString)
  {
    return (FdNode)this.a.get(paramString);
  }
  
  public boolean a()
  {
    return this.a.isEmpty();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass())) {
      return ((FdNode)paramObject).b.equals(this.b);
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.b;
    if (str == null) {
      return 0;
    }
    return str.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FdNode{");
    localStringBuilder.append("text='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appearTimes=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.fd.FdNode
 * JD-Core Version:    0.7.0.1
 */