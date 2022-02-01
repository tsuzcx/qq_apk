package com.tencent.mobileqq.flashshow.personal.widget;

import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;

class FSPersonalBottomWidget$2
  implements Runnable
{
  FSPersonalBottomWidget$2(FSPersonalBottomWidget paramFSPersonalBottomWidget) {}
  
  public void run()
  {
    FSLpReportDc11001.a(new DataBuilder(this.this$0.getReportBean()).setActionType(11).setSubActionType(21).setThrActionType(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.FSPersonalBottomWidget.2
 * JD-Core Version:    0.7.0.1
 */