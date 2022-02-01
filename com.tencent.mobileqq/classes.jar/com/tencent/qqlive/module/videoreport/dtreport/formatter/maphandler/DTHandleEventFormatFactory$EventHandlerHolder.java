package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

class DTHandleEventFormatFactory$EventHandlerHolder
{
  private static volatile DTAppEventMapHandler sAppOutEventHandler;
  private static volatile DTBaseEventMapHandler sAudioMapHandler;
  private static volatile DTBaseEventMapHandler sBizEventHandler;
  private static volatile DTPageEventMapHandler sPageEventHandler;
  private static volatile DTBaseElementEventMapHandler sViewEventHandler;
  
  static DTAppEventMapHandler getAppEventHandler()
  {
    if (sAppOutEventHandler == null) {
      try
      {
        if (sAppOutEventHandler == null) {
          if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
            sAppOutEventHandler = new DTAppEventMapHandler();
          } else {
            sAppOutEventHandler = new DTNewsAppEventMapHandler();
          }
        }
      }
      finally {}
    }
    return sAppOutEventHandler;
  }
  
  static DTBaseEventMapHandler getAudioEventMapHandler()
  {
    if (sAudioMapHandler == null) {
      try
      {
        if (sAudioMapHandler == null) {
          if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
            sAudioMapHandler = new DTBaseEventMapHandler();
          } else {
            sAudioMapHandler = new DTNewsAudioEventMapHandler();
          }
        }
      }
      finally {}
    }
    return sAudioMapHandler;
  }
  
  static DTBaseEventMapHandler getBizEventHandler()
  {
    if (sBizEventHandler == null) {
      try
      {
        if (sBizEventHandler == null) {
          if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
            sBizEventHandler = new DTBaseBizEventMapHandler();
          } else {
            sBizEventHandler = new DTNewBizEventMapHandler();
          }
        }
      }
      finally {}
    }
    return sBizEventHandler;
  }
  
  static DTPageEventMapHandler getPageEventHandler()
  {
    if (sPageEventHandler == null) {
      try
      {
        if (sPageEventHandler == null) {
          if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
            sPageEventHandler = new DTPageEventMapHandler();
          } else {
            sPageEventHandler = new DTNewsPageEventMapHandler();
          }
        }
      }
      finally {}
    }
    return sPageEventHandler;
  }
  
  static DTBaseElementEventMapHandler getViewEventHandler()
  {
    if (sViewEventHandler == null) {
      try
      {
        if (sViewEventHandler == null) {
          if (DTHandleEventFormatFactory.sElementFormatMode != 2) {
            sViewEventHandler = new DTViewFlattenEventMapHandler();
          } else {
            sViewEventHandler = new DTNewsElementFlattenEventMapHandler();
          }
        }
      }
      finally {}
    }
    return sViewEventHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory.EventHandlerHolder
 * JD-Core Version:    0.7.0.1
 */