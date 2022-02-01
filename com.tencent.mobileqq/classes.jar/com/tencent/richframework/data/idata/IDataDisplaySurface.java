package com.tencent.richframework.data.idata;

import androidx.lifecycle.MutableLiveData;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

public abstract interface IDataDisplaySurface<T>
{
  public abstract MutableLiveData<UIStateData<List<T>>> a(Object... paramVarArgs);
  
  public abstract void b(Object... paramVarArgs);
  
  public abstract int c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.data.idata.IDataDisplaySurface
 * JD-Core Version:    0.7.0.1
 */