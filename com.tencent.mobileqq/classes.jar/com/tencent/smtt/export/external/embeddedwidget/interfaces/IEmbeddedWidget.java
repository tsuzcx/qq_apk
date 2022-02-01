package com.tencent.smtt.export.external.embeddedwidget.interfaces;

import android.webkit.ValueCallback;

public abstract interface IEmbeddedWidget
{
  public abstract void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback);
  
  public abstract long getWidgetId();
  
  public abstract void onClientError(IEmbeddedWidgetClient paramIEmbeddedWidgetClient);
  
  public abstract void setEventResponseType(IEmbeddedWidget.EventResponseType paramEventResponseType);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget
 * JD-Core Version:    0.7.0.1
 */