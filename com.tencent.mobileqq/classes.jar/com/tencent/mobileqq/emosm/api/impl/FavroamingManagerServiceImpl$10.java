package com.tencent.mobileqq.emosm.api.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class FavroamingManagerServiceImpl$10
  implements Runnable
{
  FavroamingManagerServiceImpl$10(FavroamingManagerServiceImpl paramFavroamingManagerServiceImpl, Map paramMap) {}
  
  public void run()
  {
    FavroamingManagerServiceImpl.access$2200(this.this$0).clear();
    if (this.a != null) {
      FavroamingManagerServiceImpl.access$2200(this.this$0).putAll(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.10
 * JD-Core Version:    0.7.0.1
 */