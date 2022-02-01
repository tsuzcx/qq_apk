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
      if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
        sAppOutEventHandler = new DTAppEventMapHandler();
      } else {
        sAppOutEventHandler = new DTNewsAppEventMapHandler();
      }
    }
    return sAppOutEventHandler;
  }
  
  static DTBaseEventMapHandler getAudioEventMapHandler()
  {
    if (sAudioMapHandler == null) {
      if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
        sAudioMapHandler = new DTBaseEventMapHandler();
      } else {
        sAudioMapHandler = new DTNewsAudioEventMapHandler();
      }
    }
    return sAudioMapHandler;
  }
  
  static DTBaseEventMapHandler getBizEventHandler()
  {
    if (sBizEventHandler == null) {
      if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
        sBizEventHandler = new DTBaseEventMapHandler();
      } else {
        sBizEventHandler = new DTBizEventMapHandler();
      }
    }
    return sBizEventHandler;
  }
  
  static DTPageEventMapHandler getPageEventHandler()
  {
    if (sPageEventHandler == null) {
      if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
        sPageEventHandler = new DTPageEventMapHandler();
      } else {
        sPageEventHandler = new DTNewsPageEventMapHandler();
      }
    }
    return sPageEventHandler;
  }
  
  static DTBaseElementEventMapHandler getViewEventHandler()
  {
    if (sViewEventHandler == null) {
      if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
        sViewEventHandler = new DTViewFlattenEventMapHandler();
      } else {
        sViewEventHandler = new DTNewsElementFlattenEventMapHandler();
      }
    }
    return sViewEventHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory.EventHandlerHolder
 * JD-Core Version:    0.7.0.1
 */