package com.tencent.rfw.barrage.core;

import android.util.SparseArray;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.util.RFWBarrageLogger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RFWBarrageFactory
{
  private RFWBarrageContext a;
  private final SparseArray<BlockingQueue<RFWBaseBarrage>> b = new SparseArray();
  private final BlockingQueue<RFWBaseBarrage> c = new LinkedBlockingQueue();
  
  public RFWBarrageFactory(RFWBarrageContext paramRFWBarrageContext)
  {
    this.a = paramRFWBarrageContext;
  }
  
  protected int a()
  {
    return 300;
  }
  
  public RFWBaseBarrage a(int paramInt, Object paramObject)
  {
    BlockingQueue localBlockingQueue = (BlockingQueue)this.b.get(paramInt);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null) {
      localObject = new LinkedBlockingQueue();
    }
    localObject = (RFWBaseBarrage)((BlockingQueue)localObject).poll();
    if (localObject == null)
    {
      localObject = this.a.b(paramInt);
      RFWBarrageLogger.a("RFWBarrageFactory", new Object[] { localObject, " is created " });
    }
    else
    {
      RFWBarrageLogger.a("RFWBarrageFactory", new Object[] { localObject, " is reused " });
    }
    ((RFWBaseBarrage)localObject).h();
    ((RFWBaseBarrage)localObject).a(paramObject);
    return localObject;
  }
  
  public void a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    if (paramRFWBaseBarrage == null) {
      return;
    }
    int i = paramRFWBaseBarrage.q();
    BlockingQueue localBlockingQueue = (BlockingQueue)this.b.get(i);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null)
    {
      localObject = new LinkedBlockingQueue();
      this.b.put(i, localObject);
    }
    if (a() > ((BlockingQueue)localObject).size()) {
      ((BlockingQueue)localObject).add(paramRFWBaseBarrage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWBarrageFactory
 * JD-Core Version:    0.7.0.1
 */