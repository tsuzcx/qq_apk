package com.tencent.mobileqq.litelivesdk.framework.room;

public class RecordVideoStateManager
{
  private static RecordVideoStateManager a = new RecordVideoStateManager();
  private boolean b;
  
  public static RecordVideoStateManager a()
  {
    return a;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.room.RecordVideoStateManager
 * JD-Core Version:    0.7.0.1
 */