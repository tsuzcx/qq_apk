package com.tencent.rmonitor.fd.analysis.heap;

import com.tencent.rmonitor.fd.analysis.data.FdLeakIssue;
import java.util.List;

public abstract interface IFdHeapAnalyzeListener
{
  public abstract void a(int paramInt, String paramString, List<FdLeakIssue> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.heap.IFdHeapAnalyzeListener
 * JD-Core Version:    0.7.0.1
 */