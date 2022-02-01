package com.tencent.mobileqq.service;

import java.util.HashMap;

public class TextMsgPush
{
  private Long a;
  private Long b;
  private HashMap<Integer, String> c = new HashMap();
  
  public TextMsgPush(Long paramLong1, Long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public void a(int paramInt, String paramString)
  {
    this.c.put(Integer.valueOf(paramInt), paramString);
  }
  
  public boolean a()
  {
    return this.c.size() == this.a.longValue();
  }
  
  public String b()
  {
    String str = new String();
    if (!a()) {
      return str;
    }
    int i = 0;
    while (i < this.c.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append((String)this.c.get(Integer.valueOf(i)));
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.TextMsgPush
 * JD-Core Version:    0.7.0.1
 */