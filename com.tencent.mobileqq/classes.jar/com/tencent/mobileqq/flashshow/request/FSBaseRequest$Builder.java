package com.tencent.mobileqq.flashshow.request;

public abstract class FSBaseRequest$Builder<R extends FSBaseRequest>
{
  private boolean enableCache = false;
  protected R mRealRequest;
  
  public R build()
  {
    this.mRealRequest = createRealRequest();
    this.mRealRequest.setEnableCache(this.enableCache);
    return this.mRealRequest;
  }
  
  protected abstract R createRealRequest();
  
  public Builder<R> openCache()
  {
    this.enableCache = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.FSBaseRequest.Builder
 * JD-Core Version:    0.7.0.1
 */