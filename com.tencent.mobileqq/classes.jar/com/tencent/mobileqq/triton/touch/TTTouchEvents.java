package com.tencent.mobileqq.triton.touch;

import com.tencent.mobileqq.triton.utils.TritonKeep;
import java.util.ArrayList;

@TritonKeep
public class TTTouchEvents
{
  @TritonKeep
  public int action;
  @TritonKeep
  public ArrayList<Touch> changedTouches = new ArrayList();
  @TritonKeep
  public double timeStamp;
  @TritonKeep
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.touch.TTTouchEvents
 * JD-Core Version:    0.7.0.1
 */