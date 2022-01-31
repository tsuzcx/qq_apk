package com.tencent.plato.sdk.render;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.sdk.element.IElement.IProvider;
import com.tencent.plato.sdk.render.data.BlockElementData;
import com.tencent.plato.sdk.render.data.ElementItem;
import com.tencent.plato.sdk.utils.watcher.WatchListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PViewFactory
{
  private static final long MB = 1048576L;
  public static final String TAG = "PViewFactory";
  private static HandlerThread handlerThread;
  private static Map<String, IElement.IProvider> mElementProviders;
  private static Handler mHandler;
  private static Runnable mRunnable = new Runnable()
  {
    public void run()
    {
      PViewFactory.access$000();
      PViewFactory.access$100();
    }
  };
  private static WatchListener mWatchListener;
  private static HashMap<String, Class<? extends IPView>> modules = new HashMap();
  
  public static void createListener()
  {
    mWatchListener = new WatchListener();
    mWatchListener.initData();
    handlerThread = new HandlerThread("debug");
    handlerThread.start();
    mHandler = new Handler(handlerThread.getLooper());
    doNext();
  }
  
  public static IPView createView(IPlatoRuntime paramIPlatoRuntime, IPView paramIPView, ElementItem paramElementItem)
  {
    try
    {
      IPView localIPView = ((IElement.IProvider)mElementProviders.get(paramElementItem.getElementType())).createView();
      localIPView.init(paramIPlatoRuntime, paramIPView, paramElementItem);
      localIPView.updateRect((int)paramElementItem.getLayoutX(), (int)paramElementItem.getLayoutY(), (int)paramElementItem.getLayoutWidth(), (int)paramElementItem.getLayoutHeight());
      localIPView.setStyles(paramElementItem.getUIStyles());
      return localIPView;
    }
    catch (Exception paramIPView)
    {
      paramIPView = "createView error. " + Log.getStackTraceString(paramIPView);
      if (paramIPlatoRuntime != null) {
        paramIPlatoRuntime.onPlatoException(paramIPView);
      }
      PLog.e("PViewFactory", paramIPView);
    }
    return null;
  }
  
  public static IPView createView(IPlatoRuntime paramIPlatoRuntime, BlockElementData paramBlockElementData)
  {
    IPView localIPView = createView(paramIPlatoRuntime, null, paramBlockElementData);
    if (paramBlockElementData.mChildren == null) {}
    for (int i = 0;; i = paramBlockElementData.mChildren.size())
    {
      int j = 0;
      while (j < i)
      {
        localIPView.addChild(createView(paramIPlatoRuntime, (BlockElementData)paramBlockElementData.mChildren.get(j)), j);
        j += 1;
      }
    }
    return localIPView;
  }
  
  private static void doNext()
  {
    mHandler.postDelayed(mRunnable, 2000L);
  }
  
  public static void setProvider(Map<String, IElement.IProvider> paramMap)
  {
    mElementProviders = paramMap;
  }
  
  private static void showLog()
  {
    Object localObject = Runtime.getRuntime();
    float f = (float)(((Runtime)localObject).totalMemory() / 1048576L);
    localObject = String.format("已使用内存:%.1f M\t总共:%.1f M\n", new Object[] { Float.valueOf((float)((((Runtime)localObject).totalMemory() - ((Runtime)localObject).freeMemory()) / 1048576L)), Float.valueOf(f) });
    String str = String.format("平均请求时间:%dms\t 总共加载次数:%d\t已完成次数:%d\t取消次数:%d", new Object[] { Long.valueOf(mWatchListener.getAverageRequestTime()), Long.valueOf(mWatchListener.getTotalRequests()), Long.valueOf(mWatchListener.getCompletedRequests()), Long.valueOf(mWatchListener.getCancelledRequests()) });
    PLog.d("debug", "heapStr : " + (String)localObject);
    PLog.d("debug", "result : " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.render.PViewFactory
 * JD-Core Version:    0.7.0.1
 */