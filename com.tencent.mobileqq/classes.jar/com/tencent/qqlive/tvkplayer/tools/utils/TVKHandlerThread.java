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
    TVKLogUtil.i("TVKHandlerThread", "handlerThread create:" + paramString);
  }
  
  public boolean quit()
  {
    TVKLogUtil.i("TVKHandlerThread", "handlerThread quit:" + getName());
    return super.quit();
  }
  
  public void start()
  {
    if (!isAlive()) {
      super.start();
    }
    TVKLogUtil.i("TVKHandlerThread", "handlerThread start:" + getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKHandlerThread
 * JD-Core Version:    0.7.0.1
 */