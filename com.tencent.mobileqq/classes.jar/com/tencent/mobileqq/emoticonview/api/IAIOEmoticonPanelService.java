package com.tencent.mobileqq.emoticonview.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAIOEmoticonPanelService
  extends QRouteApi
{
  public abstract void destroyViewPool();
  
  public abstract void removeStickerMask(View paramView);
  
  public abstract void setOpenStartTime(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IAIOEmoticonPanelService
 * JD-Core Version:    0.7.0.1
 */