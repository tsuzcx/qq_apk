package com.tencent.qqlive.module.videoreport.dtreport.api;

public abstract interface IDTVisitProvider
{
  public abstract String getActiveInfo();
  
  public abstract String getCallFrom();
  
  public abstract String getCallScheme();
  
  public abstract int getStartType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.api.IDTVisitProvider
 * JD-Core Version:    0.7.0.1
 */