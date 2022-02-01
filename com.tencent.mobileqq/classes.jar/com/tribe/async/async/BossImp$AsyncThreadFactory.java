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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type_");
    localStringBuilder.append(this.type);
    localStringBuilder.append("_index");
    int i = this.index;
    this.index = (i + 1);
    localStringBuilder.append(i);
    return new Thread(paramRunnable, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.async.BossImp.AsyncThreadFactory
 * JD-Core Version:    0.7.0.1
 */