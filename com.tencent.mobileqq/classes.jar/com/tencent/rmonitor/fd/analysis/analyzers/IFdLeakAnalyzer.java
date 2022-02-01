package com.tencent.rmonitor.fd.analysis.analyzers;

import com.tencent.rmonitor.fd.analysis.data.FdLeakIssue;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;

public abstract interface IFdLeakAnalyzer
{
  public abstract FdLeakIssue a(FdLeakDumpResult paramFdLeakDumpResult);
  
  public abstract String a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.analyzers.IFdLeakAnalyzer
 * JD-Core Version:    0.7.0.1
 */