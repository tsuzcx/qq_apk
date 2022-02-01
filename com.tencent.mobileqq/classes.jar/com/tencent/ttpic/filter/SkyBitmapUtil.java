package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkyBitmapUtil
{
  public static final String BACK = "back";
  public static final String BOTTOM = "bottom";
  public static final String FRONT = "front";
  public static final String LEFT = "left";
  private static final int MAX = 2;
  public static final String RIGHT = "right";
  public static final String TOP = "top";
  private ConcurrentLinkedQueue<Integer> countQueue = new ConcurrentLinkedQueue();
  private String dir;
  private ExecutorService mExecutor;
  private Map<Integer, HashMap<String, Bitmap>> map = new HashMap();
  private final String suffix = ".png";
  
  public SkyBitmapUtil(String paramString)
  {
    this.dir = paramString;
    this.mExecutor = Executors.newScheduledThreadPool(6);
  }
  
  private void releaseOne()
  {
    int i = ((Integer)this.countQueue.poll()).intValue();
    Iterator localIterator = ((HashMap)this.map.get(Integer.valueOf(i))).values().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (BitmapUtils.isLegal(localBitmap)) {
        localBitmap.recycle();
      }
    }
    this.map.remove(Integer.valueOf(i));
  }
  
  public void clear()
  {
    this.mExecutor.shutdownNow();
    while (!this.map.isEmpty()) {
      releaseOne();
    }
  }
  
  public void decode(int paramInt, List<String> paramList)
  {
    Object localObject2 = (HashMap)this.map.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashMap(6);
      this.map.put(Integer.valueOf(paramInt), localObject1);
      this.countQueue.add(Integer.valueOf(paramInt));
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (String)paramList.next();
      if (!((HashMap)localObject1).containsKey(localObject2))
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.dir);
        ((StringBuilder)localObject3).append(paramInt);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(".png");
        localObject3 = ((StringBuilder)localObject3).toString();
        this.mExecutor.execute(new SkyBitmapUtil.1(this, (String)localObject3, (String)localObject2, (HashMap)localObject1));
      }
    }
  }
  
  public HashMap<String, Bitmap> getBitmap(int paramInt)
  {
    while (this.map.size() > 2) {
      releaseOne();
    }
    return (HashMap)this.map.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.SkyBitmapUtil
 * JD-Core Version:    0.7.0.1
 */