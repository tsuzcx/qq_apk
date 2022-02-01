package com.tencent.mobileqq.guild.util.livedata;

import android.os.Looper;
import androidx.lifecycle.MediatorLiveData;

public class BetterLiveData<T>
  extends MediatorLiveData<T>
{
  public BetterLiveData() {}
  
  public BetterLiveData(T paramT)
  {
    setValue(paramT);
  }
  
  private void a(T paramT)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      super.setValue(paramT);
      return;
    }
    super.postValue(paramT);
  }
  
  public void postValue(T paramT)
  {
    a(paramT);
  }
  
  public void setValue(T paramT)
  {
    a(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.livedata.BetterLiveData
 * JD-Core Version:    0.7.0.1
 */