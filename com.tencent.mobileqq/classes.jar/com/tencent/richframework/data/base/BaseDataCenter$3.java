package com.tencent.richframework.data.base;

import androidx.lifecycle.Observer;
import com.tencent.richframework.data.idata.IDataConverter;

class BaseDataCenter$3
  extends DataObserverWrapper<S>
{
  BaseDataCenter$3(BaseDataCenter paramBaseDataCenter, Observer paramObserver, Object paramObject, IDataConverter paramIDataConverter)
  {
    super(paramObserver);
  }
  
  public void onChanged(S paramS)
  {
    Object localObject = this.a;
    if (localObject != null) {
      this.b.a(localObject, paramS);
    }
    super.onChanged(paramS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.data.base.BaseDataCenter.3
 * JD-Core Version:    0.7.0.1
 */