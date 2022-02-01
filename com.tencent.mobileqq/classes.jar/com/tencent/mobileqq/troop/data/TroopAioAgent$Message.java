package com.tencent.mobileqq.troop.data;

public final class TroopAioAgent$Message
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public int c;
  public int d;
  
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
    localMessage.jdField_a_of_type_Int = TroopAioAgent.jdField_a_of_type_Int;
    a(paramInt1, paramLong, localMessage);
    localMessage.c = paramInt1;
    localMessage.d = paramInt2;
    return localMessage;
  }
  
  public static void a(int paramInt, long paramLong, Message paramMessage)
  {
    if (a(paramInt))
    {
      paramMessage.jdField_a_of_type_Long = paramLong;
      return;
    }
    paramMessage.b = paramLong;
  }
  
  private static boolean a(int paramInt)
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
    return a(this.c, this.jdField_a_of_type_Long, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioAgent.Message
 * JD-Core Version:    0.7.0.1
 */