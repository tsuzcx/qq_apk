package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import mqq.app.AppRuntime;

public class EmoticonMainPanelAppServiceImpl
  implements IEmoticonMainPanelAppService
{
  public IEmoticonMainPanelApp createEmoticonMainPanelApp(AppRuntime paramAppRuntime)
  {
    return new QQEmoticonMainPanelApp(paramAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmoticonMainPanelAppServiceImpl
 * JD-Core Version:    0.7.0.1
 */