package com.tencent.mobileqq.guild.util.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

final class GulidLiveDataUtils$4
  implements Observer<R>
{
  GulidLiveDataUtils$4(MediatorLiveData paramMediatorLiveData, GulidLiveDataUtils.Function3 paramFunction3, LiveData paramLiveData1, LiveData paramLiveData2) {}
  
  public void onChanged(R paramR)
  {
    MediatorLiveData localMediatorLiveData = this.a;
    GulidLiveDataUtils.Function3 localFunction3 = this.b;
    Object localObject1 = this.c;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((LiveData)localObject1).getValue();
    }
    LiveData localLiveData = this.d;
    if (localLiveData != null) {
      localObject2 = localLiveData.getValue();
    }
    localMediatorLiveData.setValue(localFunction3.a(paramR, localObject1, localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.livedata.GulidLiveDataUtils.4
 * JD-Core Version:    0.7.0.1
 */