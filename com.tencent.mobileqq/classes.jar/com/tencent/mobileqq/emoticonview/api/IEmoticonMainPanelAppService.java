package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IEmoticonMainPanelAppService
  extends QRouteApi
{
  public abstract IEmoticonMainPanelApp createEmoticonMainPanelApp(AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService
 * JD-Core Version:    0.7.0.1
 */