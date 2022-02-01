package com.tencent.mobileqq.danmaku.core;

import android.util.SparseArray;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.util.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DanmakuFactory
{
  private final SparseArray<BlockingQueue<BaseDanmaku>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private DanmakuContext jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext;
  private final BlockingQueue<BaseDanmaku> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
  
  public DanmakuFactory(DanmakuContext paramDanmakuContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext = paramDanmakuContext;
  }
  
  protected int a()
  {
    return 300;
  }
  
  public BaseDanmaku a(int paramInt, Object paramObject)
  {
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null) {
      localObject = new LinkedBlockingQueue();
    }
    localObject = (BaseDanmaku)((BlockingQueue)localObject).poll();
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.a(paramInt);
      Logger.a("DanmakuFactory", new Object[] { localObject, " is created " });
    }
    else
    {
      Logger.a("DanmakuFactory", new Object[] { localObject, " is reused " });
    }
    ((BaseDanmaku)localObject).e();
    ((BaseDanmaku)localObject).a(paramObject);
    return localObject;
  }
  
  public void a(BaseDanmaku paramBaseDanmaku)
  {
    int i = paramBaseDanmaku.a();
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null)
    {
      localObject = new LinkedBlockingQueue();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localObject);
    }
    if (a() > ((BlockingQueue)localObject).size()) {
      ((BlockingQueue)localObject).add(paramBaseDanmaku);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuFactory
 * JD-Core Version:    0.7.0.1
 */