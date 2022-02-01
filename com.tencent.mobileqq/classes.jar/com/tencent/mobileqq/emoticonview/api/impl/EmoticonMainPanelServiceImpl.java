package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import mqq.app.AppRuntime;

public class EmoticonMainPanelServiceImpl
  implements IEmoticonMainPanelService
{
  private AppRuntime mAppRuntime;
  
  public EmoticonMainPanelServiceImpl.PanelBuilder newBuilder(Context paramContext, int paramInt)
  {
    return new EmoticonMainPanelServiceImpl.PanelBuilder(this.mAppRuntime, paramContext, paramInt);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    this.mAppRuntime = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmoticonMainPanelServiceImpl
 * JD-Core Version:    0.7.0.1
 */