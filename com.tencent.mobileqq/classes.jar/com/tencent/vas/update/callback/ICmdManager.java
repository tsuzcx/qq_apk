package com.tencent.vas.update.callback;

import com.tencent.vas.update.callback.listener.ICmdListener;

public abstract interface ICmdManager
{
  public abstract boolean sendPbRequest(String paramString1, String paramString2, ICmdListener paramICmdListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.callback.ICmdManager
 * JD-Core Version:    0.7.0.1
 */