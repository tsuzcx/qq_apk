package com.tencent.qqlive.tvkplayer.tools.utils;

import android.os.HandlerThread;

public class TVKHandlerThread
  extends HandlerThread
{
  public static final String TAG = "TVKHandlerThread";
  
  public TVKHandlerThread(String paramString)
  {
    super(paramString);
  }
  
  public TVKHandlerThread(String paramString, int paramInt)
  {
    super(paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handlerThread create:");
    localStringBuilder.append(paramString);
    TVKLogUtil.i("TVKHandlerThread", localStringBuilder.toString());
  }
  
  public boolean quit()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handlerThread quit:");
    localStringBuilder.append(getName());
    TVKLogUtil.i("TVKHandlerThread", localStringBuilder.toString());
    return super.quit();
  }
  
  public void start()
  {
    if (!isAlive()) {
      super.start();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handlerThread start:");
    localStringBuilder.append(getName());
    TVKLogUtil.i("TVKHandlerThread", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKHandlerThread
 * JD-Core Version:    0.7.0.1
 */