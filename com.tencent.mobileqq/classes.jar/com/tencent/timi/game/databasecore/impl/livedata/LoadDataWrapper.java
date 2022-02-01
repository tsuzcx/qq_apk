package com.tencent.timi.game.databasecore.impl.livedata;

import androidx.annotation.Nullable;

public class LoadDataWrapper<T>
{
  public int a;
  public String b;
  public int c;
  public T d;
  
  public LoadDataWrapper(int paramInt, T paramT)
  {
    this.d = paramT;
    this.c = paramInt;
  }
  
  public static <Q> LoadDataWrapper<Q> a(int paramInt, String paramString, Q paramQ)
  {
    paramQ = new LoadDataWrapper(3, paramQ);
    paramQ.a = paramInt;
    paramQ.b = paramString;
    return paramQ;
  }
  
  @Nullable
  public T a()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.databasecore.impl.livedata.LoadDataWrapper
 * JD-Core Version:    0.7.0.1
 */