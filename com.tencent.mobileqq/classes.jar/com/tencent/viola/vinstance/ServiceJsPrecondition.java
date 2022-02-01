package com.tencent.viola.vinstance;

public class ServiceJsPrecondition
  extends Precondition
{
  public ServiceJsPrecondition(PreconditionAdapter paramPreconditionAdapter, Preconditor paramPreconditor)
  {
    super(paramPreconditionAdapter, paramPreconditor);
  }
  
  public void onProcess()
  {
    this.adapter.loadWormhole(this);
  }
  
  public void setResult(boolean paramBoolean, Object paramObject)
  {
    super.setResult(paramBoolean, paramObject);
    this.preconditor.setServiceJsCode((String)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.viola.vinstance.ServiceJsPrecondition
 * JD-Core Version:    0.7.0.1
 */