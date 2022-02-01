package com.tencent.mobileqq.profilecard.bussiness.guide.report;

import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/guide/report/ProfileGuideReporter$Companion;", "", "()V", "REPORT_TYPE_CLICK", "", "REPORT_TYPE_EXPOSE", "report", "", "action", "", "r1", "reportProfileGuideFill", "guideId", "reportType", "reportProfileGuideUpdate", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProfileGuideReporter$Companion
{
  private final void report(String paramString, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, String.valueOf(paramInt), "", "", "");
  }
  
  public final void reportProfileGuideFill(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
      ((Companion)this).report("0X800B78C", paramInt1);
      return;
    }
    ((Companion)this).report("0X800B78D", paramInt1);
  }
  
  public final void reportProfileGuideUpdate(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
      ((Companion)this).report("0X800B78E", paramInt1);
      return;
    }
    ((Companion)this).report("0X800B78F", paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.guide.report.ProfileGuideReporter.Companion
 * JD-Core Version:    0.7.0.1
 */