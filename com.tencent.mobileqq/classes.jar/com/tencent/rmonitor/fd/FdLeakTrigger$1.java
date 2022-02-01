package com.tencent.rmonitor.fd;

import android.text.TextUtils;
import com.tencent.rmonitor.fd.analysis.FdAnalyzeListener;
import com.tencent.rmonitor.fd.analysis.IFdAnalyzeListener;
import com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult;
import com.tencent.rmonitor.fd.dump.FdLeakDumpHelper;
import com.tencent.rmonitor.fd.report.FdLeakReporter;
import com.tencent.rmonitor.fd.utils.LogUtils;

class FdLeakTrigger$1
  extends FdAnalyzeListener
{
  FdLeakTrigger$1(FdLeakTrigger paramFdLeakTrigger, IFdAnalyzeListener paramIFdAnalyzeListener)
  {
    super(paramIFdAnalyzeListener);
  }
  
  public void a(FdLeakIssueResult paramFdLeakIssueResult)
  {
    String str = FdLeakDumpHelper.a(paramFdLeakIssueResult.getFdDumpList(), true);
    if (TextUtils.isEmpty(str))
    {
      paramFdLeakIssueResult.setErrorCode(4);
      LogUtils.d("FdLeakTrigger", "zip dump files failed when analyzed");
    }
    else
    {
      FdLeakTrigger.a(this.a).a(paramFdLeakIssueResult, str);
    }
    super.a(paramFdLeakIssueResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.FdLeakTrigger.1
 * JD-Core Version:    0.7.0.1
 */