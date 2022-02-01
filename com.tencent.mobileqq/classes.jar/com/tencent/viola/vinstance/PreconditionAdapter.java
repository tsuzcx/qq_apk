package com.tencent.viola.vinstance;

public abstract interface PreconditionAdapter
{
  public abstract String getPageData();
  
  public abstract void init(Precondition paramPrecondition);
  
  public abstract void loadWormhole(Precondition paramPrecondition);
  
  public abstract void onInitError();
  
  public abstract void onInitSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.vinstance.PreconditionAdapter
 * JD-Core Version:    0.7.0.1
 */