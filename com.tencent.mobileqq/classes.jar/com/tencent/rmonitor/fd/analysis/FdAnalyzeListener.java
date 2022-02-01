package com.tencent.rmonitor.fd.analysis;

import com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;

public class FdAnalyzeListener
  implements IFdAnalyzeListener
{
  private final IFdAnalyzeListener a;
  
  public FdAnalyzeListener(IFdAnalyzeListener paramIFdAnalyzeListener)
  {
    this.a = paramIFdAnalyzeListener;
  }
  
  public void a(int paramInt)
  {
    IFdAnalyzeListener localIFdAnalyzeListener = this.a;
    if (localIFdAnalyzeListener != null) {
      localIFdAnalyzeListener.a(paramInt);
    }
  }
  
  public void a(int paramInt, FdLeakDumpResult paramFdLeakDumpResult)
  {
    IFdAnalyzeListener localIFdAnalyzeListener = this.a;
    if (localIFdAnalyzeListener != null) {
      localIFdAnalyzeListener.a(paramInt, paramFdLeakDumpResult);
    }
  }
  
  public void a(FdLeakIssueResult paramFdLeakIssueResult)
  {
    IFdAnalyzeListener localIFdAnalyzeListener = this.a;
    if (localIFdAnalyzeListener != null) {
      localIFdAnalyzeListener.a(paramFdLeakIssueResult);
    }
  }
  
  public void b()
  {
    IFdAnalyzeListener localIFdAnalyzeListener = this.a;
    if (localIFdAnalyzeListener != null) {
      localIFdAnalyzeListener.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.FdAnalyzeListener
 * JD-Core Version:    0.7.0.1
 */