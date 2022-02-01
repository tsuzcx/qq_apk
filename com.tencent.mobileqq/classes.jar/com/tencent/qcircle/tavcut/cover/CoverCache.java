package com.tencent.qcircle.tavcut.cover;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class CoverCache
{
  private static final int MAX_SIZE = 64;
  private static final String TAG = "CoverCache";
  private CoverListener mCoverListener;
  private ConcurrentHashMap<Integer, Bitmap> mCoverMap = new ConcurrentHashMap(16);
  private ConcurrentHashMap<Integer, Bitmap> mProgressCoverMap = new ConcurrentHashMap(16);
  
  public void addCover(int paramInt, Bitmap paramBitmap)
  {
    if (this.mCoverMap == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addCover: ");
    ((StringBuilder)localObject).append(paramInt);
    Log.i("CoverCache", ((StringBuilder)localObject).toString());
    this.mCoverMap.putIfAbsent(Integer.valueOf(paramInt), paramBitmap);
    localObject = this.mCoverListener;
    if (localObject != null) {
      ((CoverListener)localObject).onCover(paramInt, paramBitmap);
    }
  }
  
  public int getCacheSize()
  {
    Object localObject = this.mCoverMap;
    int i;
    if (localObject != null) {
      i = ((ConcurrentHashMap)localObject).size();
    } else {
      i = 0;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCacheSize: ");
    ((StringBuilder)localObject).append(i);
    Log.i("CoverCache", ((StringBuilder)localObject).toString());
    return i;
  }
  
  public Bitmap getCover(int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = this.mCoverMap;
    if (localConcurrentHashMap != null) {
      return (Bitmap)localConcurrentHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public Bitmap getCoverByTime(long paramLong)
  {
    ConcurrentHashMap localConcurrentHashMap = this.mProgressCoverMap;
    if ((localConcurrentHashMap != null) && (localConcurrentHashMap.get(Long.valueOf(paramLong)) != null)) {
      return (Bitmap)this.mProgressCoverMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void release()
  {
    try
    {
      Log.i("CoverCache", "release: ");
      if (this.mCoverMap != null)
      {
        Iterator localIterator = this.mCoverMap.values().iterator();
        while (localIterator.hasNext())
        {
          Bitmap localBitmap = (Bitmap)localIterator.next();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            localBitmap.recycle();
          }
        }
        this.mCoverMap.clear();
        this.mCoverMap = null;
      }
      this.mCoverListener = null;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  void setClipCoverListener(CoverListener paramCoverListener)
  {
    this.mCoverListener = paramCoverListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.cover.CoverCache
 * JD-Core Version:    0.7.0.1
 */