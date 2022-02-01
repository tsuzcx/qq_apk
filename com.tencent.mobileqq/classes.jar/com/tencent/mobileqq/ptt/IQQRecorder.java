package com.tencent.mobileqq.ptt;

import com.tencent.mobileqq.utils.RecordParams.RecorderParam;

public abstract interface IQQRecorder
{
  public abstract void a();
  
  public abstract void a(IQQRecorder.OnQQRecorderListener paramOnQQRecorderListener);
  
  public abstract void a(IQQRecorder.RecorderProcessorListener paramRecorderProcessorListener);
  
  public abstract void a(RecordParams.RecorderParam paramRecorderParam);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract void b(String paramString);
  
  public abstract boolean b();
  
  public abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.IQQRecorder
 * JD-Core Version:    0.7.0.1
 */