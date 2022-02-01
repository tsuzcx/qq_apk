package com.tencent.viola.core.dispatch;

public class ComponentAppearEvent
  implements IEvent
{
  public String event;
  public String ref;
  
  public ComponentAppearEvent(String paramString1, String paramString2)
  {
    this.event = paramString1;
    this.ref = paramString2;
  }
  
  public String getRef()
  {
    return this.ref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.dispatch.ComponentAppearEvent
 * JD-Core Version:    0.7.0.1
 */