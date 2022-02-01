package com.tencent.mobileqq.service;

import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

public class TextMsgTask
{
  private Long a;
  private int b;
  private int c;
  private ArrayList<String> d = new ArrayList();
  private String e;
  private Long f;
  private ToServiceMsg g;
  private DataLineMsgRecord h;
  
  public TextMsgTask(String paramString, Long paramLong, DataLineMsgRecord paramDataLineMsgRecord)
  {
    this.f = paramLong;
    this.e = paramString;
    this.a = Long.valueOf(0L);
    int i = 0;
    this.c = 0;
    this.b = ((this.e.length() + 160 - 1) / 160);
    while (i < this.e.length())
    {
      int k = i + 160;
      int j;
      if (k > this.e.length()) {
        j = this.e.length() - i;
      } else {
        j = 160;
      }
      this.d.add(this.e.substring(i, j + i));
      i = k;
    }
    this.h = paramDataLineMsgRecord;
  }
  
  public int a(StringBuffer paramStringBuffer)
  {
    if (this.d.isEmpty()) {
      return -1;
    }
    paramStringBuffer.append((String)this.d.remove(0));
    int i = this.c;
    this.c = (i + 1);
    return i;
  }
  
  public Long a()
  {
    return this.f;
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.g = paramToServiceMsg;
  }
  
  public DataLineMsgRecord b()
  {
    return this.h;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public ToServiceMsg e()
  {
    return this.g;
  }
  
  public boolean f()
  {
    return this.d.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.TextMsgTask
 * JD-Core Version:    0.7.0.1
 */