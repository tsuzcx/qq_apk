package com.tencent.mobileqq.guild.util.livedata;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

public class GulidLiveDataUtils
{
  public static <R, S> LiveData<Pair<R, S>> a(LiveData<R> paramLiveData, LiveData<S> paramLiveData1)
  {
    return a(paramLiveData, paramLiveData1, new GulidLiveDataUtils.3());
  }
  
  public static <R, S, T, U> LiveData<U> a(@Nullable LiveData<R> paramLiveData, @Nullable LiveData<S> paramLiveData1, @Nullable LiveData<T> paramLiveData2, GulidLiveDataUtils.Function3<R, S, T, U> paramFunction3)
  {
    MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    if (paramLiveData != null) {
      localMediatorLiveData.addSource(paramLiveData, new GulidLiveDataUtils.4(localMediatorLiveData, paramFunction3, paramLiveData1, paramLiveData2));
    }
    if (paramLiveData1 != null) {
      localMediatorLiveData.addSource(paramLiveData1, new GulidLiveDataUtils.5(localMediatorLiveData, paramFunction3, paramLiveData, paramLiveData2));
    }
    if (paramLiveData2 != null) {
      localMediatorLiveData.addSource(paramLiveData2, new GulidLiveDataUtils.6(localMediatorLiveData, paramFunction3, paramLiveData, paramLiveData1));
    }
    return localMediatorLiveData;
  }
  
  public static <R, S, T> LiveData<T> a(LiveData<R> paramLiveData, LiveData<S> paramLiveData1, GulidLiveDataUtils.Function<R, S, T> paramFunction)
  {
    MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    if (paramLiveData != null) {
      localMediatorLiveData.addSource(paramLiveData, new GulidLiveDataUtils.1(localMediatorLiveData, paramFunction, paramLiveData1));
    }
    if (paramLiveData1 != null) {
      localMediatorLiveData.addSource(paramLiveData1, new GulidLiveDataUtils.2(localMediatorLiveData, paramFunction, paramLiveData));
    }
    return localMediatorLiveData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.livedata.GulidLiveDataUtils
 * JD-Core Version:    0.7.0.1
 */