package com.tencent.richframework.data.base;

import com.tencent.richframework.data.idata.IDataCenter;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.data.idata.IDataWorker;
import java.util.Collection;

public abstract class BaseDataWorker
  implements IDataWorker
{
  private IDataCenter a;
  
  protected Collection<IDataDisplaySurface> a()
  {
    IDataCenter localIDataCenter = this.a;
    if (localIDataCenter != null) {
      return localIDataCenter.d();
    }
    return null;
  }
  
  public void a(IDataCenter paramIDataCenter)
  {
    this.a = paramIDataCenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.data.base.BaseDataWorker
 * JD-Core Version:    0.7.0.1
 */