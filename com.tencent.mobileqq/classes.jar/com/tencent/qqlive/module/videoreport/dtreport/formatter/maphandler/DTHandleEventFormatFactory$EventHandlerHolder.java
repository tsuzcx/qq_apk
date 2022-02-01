package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

class DTHandleEventFormatFactory$EventHandlerHolder
{
  private static DTAppEventMapHandler sAppOutEventHandler;
  private static DTBaseEventMapHandler sEventDefaultMapHandler;
  private static DTPageEventMapHandler sPageEventHandler;
  private static DTViewFlattenEventMapHandler sViewFlattenEventHandler;
  private static DTViewNonFlattenEventMapHandler sViewNonFlattenEventHandler;
  
  static DTAppEventMapHandler getAppEventHandler()
  {
    if (sAppOutEventHandler == null) {
      sAppOutEventHandler = new DTAppEventMapHandler();
    }
    return sAppOutEventHandler;
  }
  
  static DTBaseEventMapHandler getEventDefaultMapHandler()
  {
    if (sEventDefaultMapHandler == null) {
      sEventDefaultMapHandler = new DTBaseEventMapHandler();
    }
    return sEventDefaultMapHandler;
  }
  
  static DTPageEventMapHandler getPageEventHandler()
  {
    if (sPageEventHandler == null) {
      sPageEventHandler = new DTPageEventMapHandler();
    }
    return sPageEventHandler;
  }
  
  static DTViewFlattenEventMapHandler getViewFlattenEventHandler()
  {
    if (sViewFlattenEventHandler == null) {
      sViewFlattenEventHandler = new DTViewFlattenEventMapHandler();
    }
    return sViewFlattenEventHandler;
  }
  
  static DTViewNonFlattenEventMapHandler getViewNonFlattenEventHandler()
  {
    if (sViewNonFlattenEventHandler == null) {
      sViewNonFlattenEventHandler = new DTViewNonFlattenEventMapHandler();
    }
    return sViewNonFlattenEventHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory.EventHandlerHolder
 * JD-Core Version:    0.7.0.1
 */