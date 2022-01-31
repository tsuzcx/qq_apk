package com.tribe.async.async;

import java.util.concurrent.ThreadFactory;

class BossImp$AsyncThreadFactory
  implements ThreadFactory
{
  private int index;
  private String type;
  
  public BossImp$AsyncThreadFactory(String paramString)
  {
    this.type = paramString;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return new Thread("no_name");
    }
    StringBuilder localStringBuilder = new StringBuilder().append("type_").append(this.type).append("_index");
    int i = this.index;
    this.index = (i + 1);
    return new Thread(paramRunnable, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tribe.async.async.BossImp.AsyncThreadFactory
 * JD-Core Version:    0.7.0.1
 */