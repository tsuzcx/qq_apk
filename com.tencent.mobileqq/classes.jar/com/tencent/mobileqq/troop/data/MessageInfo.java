package com.tencent.mobileqq.troop.data;

public class MessageInfo
{
  public String a = null;
  public int b = -1;
  public MessageNavInfo c = new MessageNavInfo();
  
  public MessageInfo()
  {
    f();
  }
  
  public MessageInfo(MessageInfo paramMessageInfo)
  {
    if (paramMessageInfo != null)
    {
      this.c.a(paramMessageInfo.c);
      return;
    }
    f();
  }
  
  public static final boolean a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 == 11) {
      i = 30;
    }
    paramInt1 = paramInt2;
    if (paramInt2 == 11) {
      paramInt1 = 30;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    if ((i != 2) && (i != 16))
    {
      if (i >= paramInt1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (i + 1 >= paramInt1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public int a()
  {
    if (this.c.a()) {
      return this.c.a;
    }
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return a();
    }
    return c();
  }
  
  public MessageInfo a(MessageInfo paramMessageInfo)
  {
    if (paramMessageInfo != null) {
      this.c.b(paramMessageInfo.c);
    }
    return this;
  }
  
  public long b()
  {
    if (this.c.a()) {
      return this.c.b;
    }
    return -1L;
  }
  
  public int c()
  {
    if ((this.c.a()) && (MessageNavInfo.a(this.c.a))) {
      return this.c.a;
    }
    return 0;
  }
  
  public long d()
  {
    if ((this.c.a()) && (MessageNavInfo.a(this.c.a))) {
      return this.c.b;
    }
    return -1L;
  }
  
  public boolean e()
  {
    return this.c.a();
  }
  
  public void f()
  {
    this.c.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.MessageInfo
 * JD-Core Version:    0.7.0.1
 */