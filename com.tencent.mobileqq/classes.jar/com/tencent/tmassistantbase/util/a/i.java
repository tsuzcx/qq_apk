package com.tencent.tmassistantbase.util.a;

import com.tencent.tmassistant.st.SDKReportManager2;

class i
  implements Runnable
{
  i(h paramh) {}
  
  public void run()
  {
    SDKReportManager2.getInstance().postReport(2001, "hook_am");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.i
 * JD-Core Version:    0.7.0.1
 */