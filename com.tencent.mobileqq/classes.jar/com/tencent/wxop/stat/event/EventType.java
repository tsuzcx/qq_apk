package com.tencent.wxop.stat.event;

public enum EventType
{
  private int a;
  
  static
  {
    ERROR = new EventType("ERROR", 2, 3);
    CUSTOM = new EventType("CUSTOM", 3, 1000);
    ADDITION = new EventType("ADDITION", 4, 1001);
    MONITOR_STAT = new EventType("MONITOR_STAT", 5, 1002);
    MTA_GAME_USER = new EventType("MTA_GAME_USER", 6, 1003);
    NETWORK_MONITOR = new EventType("NETWORK_MONITOR", 7, 1004);
  }
  
  private EventType(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final int a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.event.EventType
 * JD-Core Version:    0.7.0.1
 */