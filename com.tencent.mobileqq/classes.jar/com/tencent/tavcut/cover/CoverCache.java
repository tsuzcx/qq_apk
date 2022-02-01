package com.tencent.tavcut.cover;

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
    if (this.mCoverMap == null) {}
    do
    {
      return;
      Log.i("CoverCache", "addCover: " + paramInt);
      this.mCoverMap.putIfAbsent(Integer.valueOf(paramInt), paramBitmap);
    } while (this.mCoverListener == null);
    this.mCoverListener.onCover(paramInt, paramBitmap);
  }
  
  public int getCacheSize()
  {
    int i = 0;
    if (this.mCoverMap != null) {
      i = this.mCoverMap.size();
    }
    Log.i("CoverCache", "getCacheSize: " + i);
    return i;
  }
  
  public Bitmap getCover(int paramInt)
  {
    if (this.mCoverMap != null) {
      return (Bitmap)this.mCoverMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public Bitmap getCoverByTime(long paramLong)
  {
    if ((this.mProgressCoverMap != null) && (this.mProgressCoverMap.get(Long.valueOf(paramLong)) != null)) {
      return (Bitmap)this.mProgressCoverMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void release()
  {
    try
    {
      Log.i("CoverCache", "release: ");
      if (this.mCoverMap == null) {
        break label84;
      }
      Iterator localIterator = this.mCoverMap.values().iterator();
      while (localIterator.hasNext())
      {
        Bitmap localBitmap = (Bitmap)localIterator.next();
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
      }
      this.mCoverMap.clear();
    }
    finally {}
    this.mCoverMap = null;
    label84:
    this.mCoverListener = null;
  }
  
  void setClipCoverListener(CoverListener paramCoverListener)
  {
    this.mCoverListener = paramCoverListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.cover.CoverCache
 * JD-Core Version:    0.7.0.1
 */