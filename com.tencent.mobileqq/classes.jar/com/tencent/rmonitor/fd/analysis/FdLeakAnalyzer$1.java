package com.tencent.rmonitor.fd.analysis;

import com.tencent.rmonitor.fd.analysis.data.FdLeakIssue;
import com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult;
import com.tencent.rmonitor.fd.analysis.heap.IFdHeapAnalyzeListener;
import java.util.Iterator;
import java.util.List;

class FdLeakAnalyzer$1
  implements IFdHeapAnalyzeListener
{
  FdLeakAnalyzer$1(FdLeakAnalyzer paramFdLeakAnalyzer, FdLeakIssueResult paramFdLeakIssueResult, IFdAnalyzeListener paramIFdAnalyzeListener) {}
  
  public void a(int paramInt, String paramString, List<FdLeakIssue> paramList)
  {
    this.a.setErrorCode(paramInt);
    this.a.setErrorMessage(paramString);
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (FdLeakIssue)paramString.next();
      FdLeakAnalyzer.a(this.c, this.a, paramList);
    }
    paramString = this.b;
    if (paramString != null) {
      paramString.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.FdLeakAnalyzer.1
 * JD-Core Version:    0.7.0.1
 */