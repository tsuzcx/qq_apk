package com.tencent.mobileqq.flashshow.viewmodel.barrage;

import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import java.lang.ref.WeakReference;
import java.util.List;

class FSBarrageViewModel$AsyncUpdateDataSource
  implements Runnable
{
  private WeakReference<FSBarrageViewModel> a;
  private List<RFWBaseBarrage> b;
  private int c;
  private long d;
  private boolean e;
  private int f;
  
  public FSBarrageViewModel$AsyncUpdateDataSource(FSBarrageViewModel paramFSBarrageViewModel)
  {
    this.a = new WeakReference(paramFSBarrageViewModel);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(List<RFWBaseBarrage> paramList)
  {
    this.b = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (FSBarrageViewModel)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[run] model should not be null.");
      return;
    }
    if (this.e)
    {
      FSBarrageViewModel.a((FSBarrageViewModel)localObject, this.b, this.c, this.d, this.f);
      return;
    }
    FSBarrageViewModel.a((FSBarrageViewModel)localObject, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.FSBarrageViewModel.AsyncUpdateDataSource
 * JD-Core Version:    0.7.0.1
 */