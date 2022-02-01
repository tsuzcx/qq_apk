package com.tencent.weiyun.poi;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.weiyun.WeiyunLiteGlobal;
import com.tencent.weiyun.cmd.CommandManager;
import com.tencent.weiyun.data.PoiItem;
import com.tencent.weiyun.utils.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class PoiManager
  implements Handler.Callback
{
  private static final int MSG_FETCH = 2;
  private static final int MSG_INIT = 1;
  private static final int NETWORK_REQ_LIMIT = 50;
  private static final String TAG = "PoiManager";
  private static Singleton<PoiManager, Void> sInstance = new PoiManager.2();
  private final Comparator<PoiItem> mComparator;
  private final Handler mHandler;
  private final HashSet<String> mPoiKeys;
  
  private PoiManager()
  {
    HandlerThread localHandlerThread = new HandlerThread("poi-fetcher");
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper(), this);
    this.mPoiKeys = new HashSet();
    this.mComparator = new PoiManager.1(this);
  }
  
  public static PoiManager getInstance()
  {
    return (PoiManager)sInstance.get(null);
  }
  
  private void performFetchPoi(List<PoiItem> paramList, PoiManager.IFetchPoiListener paramIFetchPoiListener)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject1 = paramList.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PoiItem)((Iterator)localObject1).next();
        if ((localObject2 == null) || ((((PoiItem)localObject2).longitude == 0.0D) && (((PoiItem)localObject2).latitude == 0.0D))) {
          ((Iterator)localObject1).remove();
        }
      }
      if (paramList.isEmpty())
      {
        if (paramIFetchPoiListener != null) {
          paramIFetchPoiListener.onSuccess(new ArrayList(0), true);
        }
        return;
      }
      paramList = new ArrayList(paramList);
      Collections.sort(paramList, this.mComparator);
      if (paramIFetchPoiListener != null)
      {
        localObject1 = PoiHelper.queryPoi(paramList);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          paramIFetchPoiListener.onSuccess((List)localObject1, paramList.isEmpty());
        }
      }
      boolean bool = paramList.isEmpty();
      while (!bool)
      {
        int j = paramList.size();
        int i = 50;
        if (j < 50) {
          i = paramList.size();
        }
        localObject1 = new PoiItem[i];
        localObject2 = paramList.iterator();
        j = 0;
        while ((j < i) && (((Iterator)localObject2).hasNext()))
        {
          localObject1[j] = ((PoiItem)((Iterator)localObject2).next());
          ((Iterator)localObject2).remove();
          j += 1;
        }
        bool = paramList.isEmpty();
        WeiyunLiteGlobal.getInstance().getCommandManager().fetchPOI(Arrays.asList((Object[])localObject1), new PoiManager.3(this, (PoiItem[])localObject1, paramIFetchPoiListener, bool));
      }
    }
  }
  
  public void cancelAll()
  {
    this.mHandler.removeMessages(2);
  }
  
  public void fetchPoi(List<PoiItem> paramList, PoiManager.IFetchPoiListener paramIFetchPoiListener)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Message.obtain(this.mHandler, 2, new Object[] { paramList, paramIFetchPoiListener }).sendToTarget();
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    if (???.what == 1)
    {
      HashSet localHashSet = PoiHelper.queryPoiKeys();
      synchronized (this.mPoiKeys)
      {
        this.mPoiKeys.addAll(localHashSet);
        return true;
      }
    }
    if (???.what == 2) {
      performFetchPoi((List)((Object[])(Object[])???.obj)[0], (PoiManager.IFetchPoiListener)((Object[])(Object[])???.obj)[1]);
    }
    return true;
  }
  
  public boolean hasCache(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 == 0.0D) && (paramDouble2 == 0.0D)) {
      return false;
    }
    String str = PoiHelper.generateKey(paramDouble1, paramDouble2);
    synchronized (this.mPoiKeys)
    {
      boolean bool = this.mPoiKeys.contains(str);
      return bool;
    }
  }
  
  public void init()
  {
    Message.obtain(this.mHandler, 1).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.poi.PoiManager
 * JD-Core Version:    0.7.0.1
 */