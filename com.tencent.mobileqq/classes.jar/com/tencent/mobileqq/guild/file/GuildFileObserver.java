package com.tencent.mobileqq.guild.file;

import com.tencent.mobileqq.app.BusinessObserver;

public class GuildFileObserver
  implements BusinessObserver
{
  public static int a;
  private static int b;
  
  static
  {
    int i = b;
    b = i + 1;
    a = i;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.file.GuildFileObserver
 * JD-Core Version:    0.7.0.1
 */