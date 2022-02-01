package com.tencent.mtt.hippy.views.modal;

import com.tencent.mtt.hippy.uimanager.HippyViewEvent;

public class RequestCloseEvent
  extends HippyViewEvent
{
  public static final String EVENT_NAME = "onRequestClose";
  
  public RequestCloseEvent()
  {
    super("onRequestClose");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.modal.RequestCloseEvent
 * JD-Core Version:    0.7.0.1
 */