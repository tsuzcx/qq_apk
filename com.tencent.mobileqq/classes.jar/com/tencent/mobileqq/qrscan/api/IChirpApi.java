package com.tencent.mobileqq.qrscan.api;

import android.util.Pair;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IChirpApi
  extends QRouteApi
{
  public abstract Pair<Integer, short[]> encode(String paramString);
  
  public abstract int init();
  
  public abstract boolean loadLibrary();
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.IChirpApi
 * JD-Core Version:    0.7.0.1
 */