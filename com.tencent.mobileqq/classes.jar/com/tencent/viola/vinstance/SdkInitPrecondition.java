package com.tencent.viola.vinstance;

public class SdkInitPrecondition
  extends Precondition
{
  public SdkInitPrecondition(PreconditionAdapter paramPreconditionAdapter, Preconditor paramPreconditor)
  {
    super(paramPreconditionAdapter, paramPreconditor);
  }
  
  public void onProcess()
  {
    this.adapter.init(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.vinstance.SdkInitPrecondition
 * JD-Core Version:    0.7.0.1
 */