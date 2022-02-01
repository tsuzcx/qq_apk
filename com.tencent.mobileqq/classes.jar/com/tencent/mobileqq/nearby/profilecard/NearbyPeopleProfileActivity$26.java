package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.util.ProfilePerformanceReport;

class NearbyPeopleProfileActivity$26
  implements OnDrawCompleteListener
{
  NearbyPeopleProfileActivity$26(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void b()
  {
    ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.a;
    if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.a()))
    {
      if (!localProfilePerformanceReport.a(1)) {
        localProfilePerformanceReport.b(1);
      }
      if ((!localProfilePerformanceReport.a(8)) && (localProfilePerformanceReport.a(5))) {
        localProfilePerformanceReport.b(8);
      }
      if ((!localProfilePerformanceReport.a(9)) && (localProfilePerformanceReport.a(6))) {
        localProfilePerformanceReport.b(9);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.26
 * JD-Core Version:    0.7.0.1
 */