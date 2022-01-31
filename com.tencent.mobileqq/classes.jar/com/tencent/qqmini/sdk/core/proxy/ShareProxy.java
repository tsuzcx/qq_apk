package com.tencent.qqmini.sdk.core.proxy;

import java.util.HashMap;

public abstract interface ShareProxy
{
  public abstract void onJsShareAppMessage(Object paramObject, AsyncResult paramAsyncResult);
  
  public abstract void onJsShareAppPictureMessage(Object paramObject, AsyncResult paramAsyncResult);
  
  public abstract void showShareMenuForInnerShareButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, HashMap<String, Integer> paramHashMap, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.ShareProxy
 * JD-Core Version:    0.7.0.1
 */