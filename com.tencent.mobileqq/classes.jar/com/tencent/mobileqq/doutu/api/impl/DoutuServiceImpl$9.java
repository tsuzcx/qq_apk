package com.tencent.mobileqq.doutu.api.impl;

import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.persistence.EntityManager;

class DoutuServiceImpl$9
  implements Runnable
{
  DoutuServiceImpl$9(DoutuServiceImpl paramDoutuServiceImpl) {}
  
  public void run()
  {
    if (DoutuServiceImpl.access$400(this.this$0) != null) {
      DoutuServiceImpl.access$400(this.this$0).drop(DoutuData.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.impl.DoutuServiceImpl.9
 * JD-Core Version:    0.7.0.1
 */