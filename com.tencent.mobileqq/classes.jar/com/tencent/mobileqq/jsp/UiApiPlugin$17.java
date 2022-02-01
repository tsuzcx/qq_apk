package com.tencent.mobileqq.jsp;

import cooperation.qzone.mobilereport.MobileReportManager;

final class UiApiPlugin$17
  implements Runnable
{
  UiApiPlugin$17(String paramString1, String paramString2) {}
  
  public void run()
  {
    MobileReportManager.getInstance().reportH5DomainClick(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.17
 * JD-Core Version:    0.7.0.1
 */