package com.tencent.mobileqq.qrscan.api.impl;

import android.util.Pair;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.mobileqq.qrscan.api.IChirpApi;

public class ChirpApiImpl
  implements IChirpApi
{
  ChirpWrapper chirp;
  
  public Pair<Integer, short[]> encode(String paramString)
  {
    ChirpWrapper localChirpWrapper = this.chirp;
    if (localChirpWrapper != null) {
      return localChirpWrapper.a(paramString);
    }
    return null;
  }
  
  public int init()
  {
    try
    {
      if (this.chirp == null) {
        this.chirp = new ChirpWrapper();
      }
      int i = this.chirp.a();
      return i;
    }
    finally {}
  }
  
  public boolean loadLibrary()
  {
    return ChirpWrapper.a();
  }
  
  public void release()
  {
    try
    {
      if (this.chirp != null)
      {
        this.chirp.a();
        this.chirp = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.impl.ChirpApiImpl
 * JD-Core Version:    0.7.0.1
 */