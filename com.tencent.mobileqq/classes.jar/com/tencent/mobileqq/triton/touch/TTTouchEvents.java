package com.tencent.mobileqq.triton.touch;

import java.util.ArrayList;

public class TTTouchEvents
{
  public int action;
  public ArrayList<Touch> changedTouches = new ArrayList();
  public double timeStamp;
  public ArrayList<Touch> touches = new ArrayList();
  
  public TTTouchEvents copy()
  {
    TTTouchEvents localTTTouchEvents = new TTTouchEvents();
    localTTTouchEvents.action = this.action;
    localTTTouchEvents.timeStamp = this.timeStamp;
    localTTTouchEvents.touches.addAll(this.touches);
    localTTTouchEvents.changedTouches.addAll(this.changedTouches);
    return localTTTouchEvents;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.touch.TTTouchEvents
 * JD-Core Version:    0.7.0.1
 */