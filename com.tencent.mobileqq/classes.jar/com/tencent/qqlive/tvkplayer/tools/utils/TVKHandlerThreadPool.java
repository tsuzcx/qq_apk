package com.tencent.qqlive.tvkplayer.tools.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TVKHandlerThreadPool
{
  public static final int MAX_COUNT = 3;
  private static final int MAX_USE_SHARE_COUNT = 6;
  private static final String PRE_THREAD_POOL_NAME = "TVK_HandlerThreadPool";
  public static final String TAG = "TVKHandlerThreadPool";
  private static volatile HandlerThread sHandlerThread;
  private Map<HandlerThread, Handler> idleHandlerThreadSet = new HashMap();
  private int mShareThreadCount = 0;
  
  public static TVKHandlerThreadPool getInstance()
  {
    return TVKHandlerThreadPool.HOLDER.pool;
  }
  
  private static void initHandlerThread()
  {
    try
    {
      if (sHandlerThread == null)
      {
        sHandlerThread = new HandlerThread("TVK_ShareThreadPool");
        sHandlerThread.start();
      }
      else if (!sHandlerThread.isAlive())
      {
        sHandlerThread.start();
      }
      if (sHandlerThread.getLooper() == null) {
        try
        {
          sHandlerThread.quit();
          sHandlerThread = new HandlerThread("TVK_ShareThreadPool");
          sHandlerThread.start();
        }
        finally {}
      }
      return;
    }
    finally {}
  }
  
  public HandlerThread obtain(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return obtain(str, 5);
  }
  
  public HandlerThread obtain(String paramString, int paramInt)
  {
    if (!((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_use_handler_pool.getValue()).booleanValue())
    {
      paramString = new HandlerThread(paramString);
      paramString.start();
      return paramString;
    }
    String str = paramString;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        str = "TVK_HandlerThreadPool";
      }
      paramString = this.idleHandlerThreadSet.entrySet().iterator();
      Object localObject;
      if (paramString.hasNext())
      {
        localObject = (HandlerThread)((Map.Entry)paramString.next()).getKey();
        if (localObject != null)
        {
          ((Handler)this.idleHandlerThreadSet.get(localObject)).removeCallbacksAndMessages(null);
          this.idleHandlerThreadSet.remove(localObject);
          paramString = new StringBuilder();
          paramString.append("handlerThread obtain:");
          paramString.append(((HandlerThread)localObject).getName());
          TVKLogUtil.i("TVKHandlerThreadPool", paramString.toString());
          ((HandlerThread)localObject).setName(str);
          ((HandlerThread)localObject).setPriority(paramInt);
          paramString = (String)localObject;
          if (((HandlerThread)localObject).getLooper() == null)
          {
            ((HandlerThread)localObject).quit();
            paramString = new TVKHandlerThread(str, paramInt);
            paramString.start();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handlerThread obtain:");
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(" create");
            TVKLogUtil.i("TVKHandlerThreadPool", ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          paramString = new TVKHandlerThread(str, paramInt);
          paramString.start();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handlerThread obtain:");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(" create");
          TVKLogUtil.i("TVKHandlerThreadPool", ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        paramString = new TVKHandlerThread(str, paramInt);
        paramString.start();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handlerThread create:");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" create");
        TVKLogUtil.i("TVKHandlerThreadPool", ((StringBuilder)localObject).toString());
      }
      return paramString;
    }
    finally {}
  }
  
  public HandlerThread obtainShareThread(String paramString)
  {
    
    try
    {
      if (this.mShareThreadCount >= 6)
      {
        String str = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str = "";
        }
        paramString = obtain(str, 5);
        return paramString;
      }
      this.mShareThreadCount += 1;
      paramString = new StringBuilder();
      paramString.append("handlerThread obtainShareThread mShareThreadCount:");
      paramString.append(this.mShareThreadCount);
      TVKLogUtil.i("TVKHandlerThreadPool", paramString.toString());
      paramString = sHandlerThread;
      return paramString;
    }
    finally {}
  }
  
  public void quitThread(HandlerThread paramHandlerThread)
  {
    if (paramHandlerThread != null) {}
    try
    {
      if (paramHandlerThread.isAlive()) {
        paramHandlerThread.quit();
      }
      this.idleHandlerThreadSet.remove(paramHandlerThread);
      return;
    }
    finally {}
  }
  
  public void recycle(HandlerThread paramHandlerThread, Handler paramHandler)
  {
    if (paramHandlerThread == null) {
      return;
    }
    if (paramHandler != null) {
      paramHandler.removeCallbacksAndMessages(null);
    }
    try
    {
      if (paramHandlerThread.equals(sHandlerThread))
      {
        this.mShareThreadCount -= 1;
        paramHandlerThread = new StringBuilder();
        paramHandlerThread.append("handlerThread recycle mShareThreadCount:");
        paramHandlerThread.append(this.mShareThreadCount);
        TVKLogUtil.i("TVKHandlerThreadPool", paramHandlerThread.toString());
        return;
      }
      if (!((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_use_handler_pool.getValue()).booleanValue())
      {
        paramHandlerThread.quit();
        return;
      }
      label195:
      try
      {
        if (!this.idleHandlerThreadSet.containsKey(paramHandlerThread))
        {
          int i = this.idleHandlerThreadSet.size();
          if (i >= 3) {}
        }
      }
      finally {}
    }
    finally {}
    try
    {
      paramHandler = new Handler(paramHandlerThread.getLooper());
      this.idleHandlerThreadSet.put(paramHandlerThread, paramHandler);
      paramHandler = new StringBuilder();
      paramHandler.append("handlerThread obtain:");
      paramHandler.append(paramHandlerThread.getName());
      paramHandler.append("::recycle");
      TVKLogUtil.i("TVKHandlerThreadPool", paramHandler.toString());
    }
    catch (Exception paramHandler)
    {
      break label195;
    }
    paramHandler = new StringBuilder();
    paramHandler.append("handlerThread exception,just:");
    paramHandler.append(paramHandlerThread.getName());
    paramHandler.append("::quit");
    TVKLogUtil.i("TVKHandlerThreadPool", paramHandler.toString());
    paramHandlerThread.quit();
    break label312;
    paramHandler = new StringBuilder();
    paramHandler.append("handlerThread obtain:");
    paramHandler.append(paramHandlerThread.getName());
    paramHandler.append("::quit");
    TVKLogUtil.i("TVKHandlerThreadPool", paramHandler.toString());
    if (this.idleHandlerThreadSet.containsKey(paramHandlerThread)) {
      this.idleHandlerThreadSet.remove(paramHandlerThread);
    }
    paramHandlerThread.quit();
    label312:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKHandlerThreadPool
 * JD-Core Version:    0.7.0.1
 */