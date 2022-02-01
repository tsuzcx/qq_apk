package com.tencent.qphone.base.util.log.processor;

public abstract interface IByteProcessor
{
  public static final int MAX_PROCESS_BUFFER = 2048;
  
  public abstract ProcessByteData handleData(ProcessByteData paramProcessByteData);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.processor.IByteProcessor
 * JD-Core Version:    0.7.0.1
 */