package com.tencent.thumbplayer.datatransport.resourceloader;

import android.os.Looper;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest;
import com.tencent.thumbplayer.api.resourceloader.TPAssetResourceLoadingContentInformationRequest;

public class TPAssetResourceLoadingRequest
  implements ITPAssetResourceLoadingRequest
{
  private TPAssetResourceLoadingContentInformationRequest mContentInformation;
  private boolean mIsCancelled = false;
  private boolean mIsFinished = false;
  private TPAssetResourceLoadingDataRequest mLoadingDataRequest;
  private int mRequestNum = 0;
  
  public TPAssetResourceLoadingRequest(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    this.mRequestNum = paramInt;
    this.mLoadingDataRequest = new TPAssetResourceLoadingDataRequest(paramLong1, paramLong2, paramBoolean);
    this.mLoadingDataRequest.setRequestNum(paramInt);
  }
  
  public void cancelRequest()
  {
    try
    {
      this.mIsCancelled = true;
      this.mLoadingDataRequest.release();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void finishLoading()
  {
    try
    {
      this.mIsFinished = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public TPAssetResourceLoadingContentInformationRequest getContentInformation()
  {
    return this.mContentInformation;
  }
  
  public int getDataReadyLength(long paramLong)
  {
    return this.mLoadingDataRequest.getDataReadyLength(paramLong);
  }
  
  public TPAssetResourceLoadingDataRequest getLoadingDataRequest()
  {
    return this.mLoadingDataRequest;
  }
  
  public boolean isCancelled()
  {
    try
    {
      boolean bool = this.mIsCancelled;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isFinished()
  {
    try
    {
      boolean bool = this.mIsFinished;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setContentInformation(TPAssetResourceLoadingContentInformationRequest paramTPAssetResourceLoadingContentInformationRequest)
  {
    this.mContentInformation = paramTPAssetResourceLoadingContentInformationRequest;
  }
  
  public void setDataWritePath(String paramString)
  {
    this.mLoadingDataRequest.setDataWritePath(paramString);
  }
  
  public void setDataWriteThreadLooper(Looper paramLooper)
  {
    this.mLoadingDataRequest.setDataWriteThreadLooper(paramLooper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.resourceloader.TPAssetResourceLoadingRequest
 * JD-Core Version:    0.7.0.1
 */