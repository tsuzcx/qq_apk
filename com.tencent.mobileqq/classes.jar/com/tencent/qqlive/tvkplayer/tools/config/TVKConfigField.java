package com.tencent.qqlive.tvkplayer.tools.config;

public class TVKConfigField<T>
  extends TVKAbstractField
{
  private T mValue;
  
  public TVKConfigField(T paramT)
  {
    super(3);
    this.mValue = paramT;
  }
  
  public TVKConfigField(T paramT, int paramInt)
  {
    super(paramInt);
    this.mValue = paramT;
  }
  
  public T getValue()
  {
    return this.mValue;
  }
  
  public void setValue(T paramT)
  {
    this.mValue = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField
 * JD-Core Version:    0.7.0.1
 */