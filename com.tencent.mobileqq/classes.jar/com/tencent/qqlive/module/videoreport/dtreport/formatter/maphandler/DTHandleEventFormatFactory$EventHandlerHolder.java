package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

class DTHandleEventFormatFactory$EventHandlerHolder
{
  private static DTAppEventMapHandler sAppOutEventHandler;
  private static DTBaseEventMapHandler sAudioMapHandler;
  private static DTBaseEventMapHandler sBizEventHandler;
  private static DTPageEventMapHandler sPageEventHandler;
  private static DTBaseElementEventMapHandler sViewEventHandler;
  
  static DTAppEventMapHandler getAppEventHandler()
  {
    if (sAppOutEventHandler == null) {
      switch (DTHandleEventFormatFactory.sElementFormatMode)
      {
      }
    }
    for (sAppOutEventHandler = new DTAppEventMapHandler();; sAppOutEventHandler = new DTNewsAppEventMapHandler()) {
      return sAppOutEventHandler;
    }
  }
  
  static DTBaseEventMapHandler getAudioEventMapHandler()
  {
    if (sAudioMapHandler == null) {
      switch (DTHandleEventFormatFactory.sElementFormatMode)
      {
      }
    }
    for (sAudioMapHandler = new DTBaseEventMapHandler();; sAudioMapHandler = new DTNewsAudioEventMapHandler()) {
      return sAudioMapHandler;
    }
  }
  
  static DTBaseEventMapHandler getBizEventHandler()
  {
    if (sBizEventHandler == null) {
      switch (DTHandleEventFormatFactory.sElementFormatMode)
      {
      }
    }
    for (sBizEventHandler = new DTBaseEventMapHandler();; sBizEventHandler = new DTBizEventMapHandler()) {
      return sBizEventHandler;
    }
  }
  
  static DTPageEventMapHandler getPageEventHandler()
  {
    if (sPageEventHandler == null) {
      switch (DTHandleEventFormatFactory.sElementFormatMode)
      {
      }
    }
    for (sPageEventHandler = new DTPageEventMapHandler();; sPageEventHandler = new DTNewsPageEventMapHandler()) {
      return sPageEventHandler;
    }
  }
  
  static DTBaseElementEventMapHandler getViewEventHandler()
  {
    if (sViewEventHandler == null) {
      switch (DTHandleEventFormatFactory.sElementFormatMode)
      {
      }
    }
    for (sViewEventHandler = new DTViewFlattenEventMapHandler();; sViewEventHandler = new DTNewsElementFlattenEventMapHandler()) {
      return sViewEventHandler;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory.EventHandlerHolder
 * JD-Core Version:    0.7.0.1
 */