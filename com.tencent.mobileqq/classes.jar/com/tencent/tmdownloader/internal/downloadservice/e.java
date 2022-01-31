package com.tencent.tmdownloader.internal.downloadservice;

import com.tencent.tmassistant.st.SDKReportManager2;

class e
  implements Runnable
{
  e(c paramc, String paramString) {}
  
  public void run()
  {
    SDKReportManager2.getInstance().postReport(8, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.e
 * JD-Core Version:    0.7.0.1
 */