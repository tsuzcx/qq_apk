package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.util.ProfilePerformanceReport;

class NearbyPeopleProfileActivity$26
  implements OnDrawCompleteListener
{
  NearbyPeopleProfileActivity$26(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void d()
  {
    ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.a;
    if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.a()))
    {
      if (!localProfilePerformanceReport.c(1)) {
        localProfilePerformanceReport.b(1);
      }
      if ((!localProfilePerformanceReport.c(8)) && (localProfilePerformanceReport.c(5))) {
        localProfilePerformanceReport.b(8);
      }
      if ((!localProfilePerformanceReport.c(9)) && (localProfilePerformanceReport.c(6))) {
        localProfilePerformanceReport.b(9);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.26
 * JD-Core Version:    0.7.0.1
 */