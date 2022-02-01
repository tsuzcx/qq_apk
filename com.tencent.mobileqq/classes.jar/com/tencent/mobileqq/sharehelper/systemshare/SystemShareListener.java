package com.tencent.mobileqq.sharehelper.systemshare;

import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardBaseOption.EventListener;
import com.tencent.mobileqq.statistics.ReportController;

public class SystemShareListener
  implements ForwardBaseOption.EventListener
{
  public void a(ForwardBaseOption paramForwardBaseOption)
  {
    ReportController.a(paramForwardBaseOption.at(), "0X800BA86");
  }
  
  public void b(ForwardBaseOption paramForwardBaseOption)
  {
    ReportController.a(paramForwardBaseOption.at(), "0X800BA87");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.systemshare.SystemShareListener
 * JD-Core Version:    0.7.0.1
 */