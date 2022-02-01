package com.tencent.mobileqq.ui.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQTextApi
  extends QRouteApi
{
  public abstract CharSequence buildQQText(CharSequence paramCharSequence);
  
  public abstract int getEmojiTypeEmoji();
  
  public abstract int getEmojiTypeSmall();
  
  public abstract int getEmojiTypeSystem();
  
  public abstract int getGrabEmotcation();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ui.api.IQQTextApi
 * JD-Core Version:    0.7.0.1
 */