package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IApolloDependApi
  extends QRouteApi
{
  public abstract void apolloCmEmojiDtReport(int paramInt);
  
  public abstract void onEmoticonNewIconShown(int paramInt);
  
  public abstract boolean shouldShowNewIcon(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IApolloDependApi
 * JD-Core Version:    0.7.0.1
 */