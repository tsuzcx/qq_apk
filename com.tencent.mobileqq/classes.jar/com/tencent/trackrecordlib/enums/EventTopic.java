package com.tencent.trackrecordlib.enums;

public enum EventTopic
{
  private int seq;
  
  static
  {
    EVENT_APP = new EventTopic("EVENT_APP", 1, 2);
    EVENT_UI_ACTION = new EventTopic("EVENT_UI_ACTION", 2, 3);
    EVENT_PAGE_CHANGE = new EventTopic("EVENT_PAGE_CHANGE", 3, 4);
    EVENT_TAG = new EventTopic("EVENT_TAG", 4, 5);
    EVENT_TRACE = new EventTopic("EVENT_TRACE", 5, 6);
    EVENT_CAL = new EventTopic("EVENT_CAL", 6, 7);
    EVENT_RDM_CRASH = new EventTopic("EVENT_RDM_CRASH", 7, 8);
    EVENT_QAPM_PERF = new EventTopic("EVENT_QAPM_PERF", 8, 9);
    EVENT_EXTERNAL_HEADER = new EventTopic("EVENT_EXTERNAL_HEADER", 9, 1000);
    EVENT_EXTERNAL_QAPM_SIGKILL = new EventTopic("EVENT_EXTERNAL_QAPM_SIGKILL", 10, 1001);
  }
  
  private EventTopic(int paramInt)
  {
    this.seq = paramInt;
  }
  
  public static EventTopic findEventTopic(int paramInt)
  {
    EventTopic[] arrayOfEventTopic = values();
    int j = arrayOfEventTopic.length;
    int i = 0;
    while (i < j)
    {
      EventTopic localEventTopic = arrayOfEventTopic[i];
      if (localEventTopic.getSeq() == paramInt) {
        return localEventTopic;
      }
      i += 1;
    }
    return null;
  }
  
  public int getSeq()
  {
    return this.seq;
  }
  
  public void setSeq(int paramInt)
  {
    this.seq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.enums.EventTopic
 * JD-Core Version:    0.7.0.1
 */