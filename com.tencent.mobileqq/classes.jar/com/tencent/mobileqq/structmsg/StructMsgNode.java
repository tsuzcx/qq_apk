package com.tencent.mobileqq.structmsg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StructMsgNode
{
  public String a;
  public String b;
  public Map<String, String> c;
  public List<StructMsgNode> d;
  public StructMsgNode e;
  public int f = 1;
  
  public StructMsgNode(String paramString, Map<String, String> paramMap)
  {
    this.b = paramString;
    this.c = paramMap;
  }
  
  public int a()
  {
    List localList = this.d;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public StructMsgNode a(int paramInt)
  {
    List localList = this.d;
    if ((localList != null) && (localList.size() > paramInt)) {
      return (StructMsgNode)this.d.get(paramInt);
    }
    return null;
  }
  
  public String a(String paramString)
  {
    Map localMap = this.c;
    if (localMap != null) {
      return (String)localMap.get(paramString);
    }
    return null;
  }
  
  public void a(StructMsgNode paramStructMsgNode)
  {
    if (this.d == null) {
      this.d = new ArrayList();
    }
    this.d.add(paramStructMsgNode);
  }
  
  public StructMsgNode b()
  {
    List localList = this.d;
    if (localList != null) {
      return a(localList.indexOf(this) + 1);
    }
    return null;
  }
  
  public StructMsgNode c()
  {
    return a(0);
  }
  
  public boolean d()
  {
    Map localMap = this.c;
    return (localMap != null) && (localMap.size() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgNode
 * JD-Core Version:    0.7.0.1
 */