package com.tencent.mobileqq.troop.navigatebar;

public final class AioAgent$Message
{
  public int a;
  public int b;
  public long c;
  public long d;
  public int e;
  public int f;
  public boolean g;
  public boolean h;
  public boolean i;
  
  public static long a(int paramInt, long paramLong1, long paramLong2)
  {
    if (a(paramInt)) {
      return paramLong1;
    }
    return paramLong2;
  }
  
  public static Message a(int paramInt1, long paramLong, int paramInt2)
  {
    Message localMessage = new Message();
    localMessage.a = AioAgent.A;
    a(paramInt1, paramLong, localMessage);
    localMessage.e = paramInt1;
    localMessage.f = paramInt2;
    return localMessage;
  }
  
  public static void a(int paramInt, long paramLong, Message paramMessage)
  {
    if (a(paramInt))
    {
      paramMessage.c = paramLong;
      return;
    }
    paramMessage.d = paramLong;
  }
  
  protected static boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 22)
      {
        bool1 = bool2;
        if (paramInt != 17)
        {
          bool1 = bool2;
          if (paramInt != 100)
          {
            bool1 = bool2;
            if (paramInt != 11)
            {
              if (paramInt == 10) {
                return true;
              }
              bool1 = false;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public long a()
  {
    return a(this.e, this.c, this.d);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Message:{");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("type: ");
    localStringBuilder2.append(this.a);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", id: ");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", shmsgseq: ");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", uniseq: ");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", navigateType: ");
    localStringBuilder2.append(this.e);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", unreadMsgCount: ");
    localStringBuilder2.append(this.f);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", isHongbao: ");
    localStringBuilder2.append(this.g);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", isSpecifyHongBao: ");
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", isToAllGiftMsg: ");
    localStringBuilder2.append(this.i);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("}");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.AioAgent.Message
 * JD-Core Version:    0.7.0.1
 */