package com.tencent.qqlive.module.videoreport.reportdata;

public class DataBuilderFactory
{
  public static IDataBuilder obtain()
  {
    return DataBuilderWithFormatter.getInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory
 * JD-Core Version:    0.7.0.1
 */