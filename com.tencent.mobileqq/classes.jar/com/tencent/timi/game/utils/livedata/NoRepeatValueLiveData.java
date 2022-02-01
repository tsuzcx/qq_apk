package com.tencent.timi.game.utils.livedata;

public class NoRepeatValueLiveData<T>
  extends BetterLiveData<T>
{
  public NoRepeatValueLiveData() {}
  
  public NoRepeatValueLiveData(T paramT)
  {
    super(paramT);
  }
  
  public void postValue(T paramT)
  {
    Object localObject = getValue();
    if (paramT != localObject)
    {
      if ((paramT != null) && (paramT.equals(localObject))) {
        return;
      }
      super.postValue(paramT);
    }
  }
  
  public void setValue(T paramT)
  {
    Object localObject = getValue();
    if (paramT != localObject)
    {
      if ((paramT != null) && (paramT.equals(localObject))) {
        return;
      }
      super.setValue(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.livedata.NoRepeatValueLiveData
 * JD-Core Version:    0.7.0.1
 */