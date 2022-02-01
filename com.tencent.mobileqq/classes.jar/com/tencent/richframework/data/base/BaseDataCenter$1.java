package com.tencent.richframework.data.base;

import androidx.lifecycle.MutableLiveData;
import com.tencent.richframework.data.idata.IDataConverter;
import java.util.Map;

class BaseDataCenter$1
  implements Runnable
{
  BaseDataCenter$1(BaseDataCenter paramBaseDataCenter, String paramString, Object paramObject, boolean paramBoolean, IDataConverter paramIDataConverter) {}
  
  public void run()
  {
    MutableLiveData localMutableLiveData = (MutableLiveData)this.this$0.e.get(this.a);
    Object localObject;
    if (localMutableLiveData == null)
    {
      localObject = new MutableLiveData();
      ((MutableLiveData)localObject).setValue(this.b);
    }
    else
    {
      localObject = localMutableLiveData;
      if (this.c)
      {
        localObject = localMutableLiveData.getValue();
        this.d.a(localObject, this.b);
        localMutableLiveData.setValue(localObject);
        localObject = localMutableLiveData;
      }
    }
    this.this$0.e.put(this.a, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.data.base.BaseDataCenter.1
 * JD-Core Version:    0.7.0.1
 */