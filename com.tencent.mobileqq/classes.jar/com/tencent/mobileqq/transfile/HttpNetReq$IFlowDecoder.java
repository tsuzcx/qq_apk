package com.tencent.mobileqq.transfile;

public abstract interface HttpNetReq$IFlowDecoder
{
  public abstract byte[] decode(byte[] paramArrayOfByte);
  
  public abstract boolean isFinish();
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpNetReq.IFlowDecoder
 * JD-Core Version:    0.7.0.1
 */