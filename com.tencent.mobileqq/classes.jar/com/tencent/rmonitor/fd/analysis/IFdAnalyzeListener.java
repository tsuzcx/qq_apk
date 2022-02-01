package com.tencent.rmonitor.fd.analysis;

import com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult;
import com.tencent.rmonitor.fd.dump.IFdLeakDumpListener;

public abstract interface IFdAnalyzeListener
  extends IFdLeakDumpListener
{
  public abstract void a(FdLeakIssueResult paramFdLeakIssueResult);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.IFdAnalyzeListener
 * JD-Core Version:    0.7.0.1
 */