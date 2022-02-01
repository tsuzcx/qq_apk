package com.tencent.mobileqq.hotchat;

import java.util.ArrayList;
import java.util.Iterator;

public class HotChatSCMng$HotchatNotice
{
  String a;
  int b = -1;
  ArrayList<HotChatNote> c = new ArrayList();
  
  public void a()
  {
    this.b = -1;
    this.a = null;
    this.c.clear();
  }
  
  public String toString()
  {
    int j = this.c.size() * 100;
    int i;
    if (j > 2000)
    {
      i = 2000;
    }
    else
    {
      i = j;
      if (j < 100) {
        i = 100;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder(i);
    localStringBuilder.append("[");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c.size());
    localStringBuilder.append(",");
    if (this.c.size() > 0)
    {
      localStringBuilder.append("{");
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((HotChatNote)localIterator.next());
        localStringBuilder.append(",");
      }
      localStringBuilder.append("}");
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.HotChatSCMng.HotchatNotice
 * JD-Core Version:    0.7.0.1
 */