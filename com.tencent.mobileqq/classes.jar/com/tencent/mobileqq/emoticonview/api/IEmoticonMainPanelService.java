package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IEmoticonMainPanelService
  extends IRuntimeService
{
  public abstract IEmoticonMainPanelService.PanelBuilder newBuilder(Context paramContext, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService
 * JD-Core Version:    0.7.0.1
 */