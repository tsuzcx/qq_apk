package com.tencent.rmonitor.fd;

import com.tencent.rmonitor.base.plugin.listener.IBaseListener;
import com.tencent.rmonitor.fd.analysis.IFdAnalyzeListener;

public abstract interface IFdLeakListener
  extends IBaseListener, IFdAnalyzeListener
{
  public abstract void dI_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.IFdLeakListener
 * JD-Core Version:    0.7.0.1
 */