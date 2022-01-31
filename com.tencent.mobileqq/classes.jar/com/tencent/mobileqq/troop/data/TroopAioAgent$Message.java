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
  public boolean c;
  public int d;
  
  public static Message a(int paramInt1, long paramLong, int paramInt2)
  {
    Message localMessage = new Message();
    localMessage.jdField_a_of_type_Int = TroopAioAgent.jdField_a_of_type_Int;
    if ((paramInt1 == 1) || (paramInt1 == 20) || (paramInt1 == 15) || (paramInt1 == 10)) {
      localMessage.jdField_a_of_type_Long = paramLong;
    }
    for (;;)
    {
      localMessage.c = paramInt1;
      localMessage.d = paramInt2;
      return localMessage;
      localMessage.b = paramLong;
    }
  }
  
  public long a()
  {
    if ((this.c == 1) || (this.c == 20) || (this.c == 15)) {
      return this.jdField_a_of_type_Long;
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioAgent.Message
 * JD-Core Version:    0.7.0.1
 */