package com.tencent.mobileqq.flashshow.report.dc;

import android.content.Context;
import android.widget.Toast;
import com.tencent.biz.richframework.delegate.impl.RFApplication;

final class FSLpReportDc11002$2
  implements Runnable
{
  FSLpReportDc11002$2(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Context localContext = RFApplication.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FSLpReportDc11002report invalid pageId,actionType:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",subActionType:");
    localStringBuilder.append(this.b);
    Toast.makeText(localContext, localStringBuilder.toString(), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.2
 * JD-Core Version:    0.7.0.1
 */