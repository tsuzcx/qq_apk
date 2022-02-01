package com.tencent.mobileqq.guild.util.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

final class GulidLiveDataUtils$1
  implements Observer<R>
{
  GulidLiveDataUtils$1(MediatorLiveData paramMediatorLiveData, GulidLiveDataUtils.Function paramFunction, LiveData paramLiveData) {}
  
  public void onChanged(R paramR)
  {
    MediatorLiveData localMediatorLiveData = this.a;
    GulidLiveDataUtils.Function localFunction = this.b;
    Object localObject = this.c;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((LiveData)localObject).getValue();
    }
    localMediatorLiveData.setValue(localFunction.b(paramR, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.livedata.GulidLiveDataUtils.1
 * JD-Core Version:    0.7.0.1
 */