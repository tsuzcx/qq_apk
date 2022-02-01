package com.tencent.qqlive.module.videoreport.dtreport.api;

abstract interface IDTVisitProvider
{
  public abstract String getActiveInfo();
  
  public abstract String getCallFrom();
  
  public abstract String getCallScheme();
  
  @IDTVisitProvider.StartType
  public abstract int getStartType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.api.IDTVisitProvider
 * JD-Core Version:    0.7.0.1
 */