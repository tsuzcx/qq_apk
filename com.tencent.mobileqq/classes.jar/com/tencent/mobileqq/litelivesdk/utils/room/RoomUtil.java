package com.tencent.mobileqq.litelivesdk.utils.room;

public class RoomUtil
{
  public static boolean a(int paramInt)
  {
    return paramInt == 5;
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt == 3) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.room.RoomUtil
 * JD-Core Version:    0.7.0.1
 */