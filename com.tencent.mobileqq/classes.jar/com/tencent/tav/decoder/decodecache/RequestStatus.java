package com.tencent.tav.decoder.decodecache;

import java.util.concurrent.atomic.AtomicBoolean;

class RequestStatus
{
  private volatile AtomicBoolean finish = new AtomicBoolean(false);
  
  public boolean getFinish()
  {
    return this.finish.get();
  }
  
  public void setFinish(boolean paramBoolean)
  {
    this.finish.set(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.RequestStatus
 * JD-Core Version:    0.7.0.1
 */