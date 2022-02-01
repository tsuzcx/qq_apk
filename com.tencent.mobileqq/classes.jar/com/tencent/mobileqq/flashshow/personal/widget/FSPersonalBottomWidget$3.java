package com.tencent.mobileqq.flashshow.personal.widget;

import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;

class FSPersonalBottomWidget$3
  implements Runnable
{
  FSPersonalBottomWidget$3(FSPersonalBottomWidget paramFSPersonalBottomWidget) {}
  
  public void run()
  {
    FSLpReportDc11001.a(new DataBuilder(this.this$0.getReportBean()).setActionType(11).setSubActionType(19).setThrActionType(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.FSPersonalBottomWidget.3
 * JD-Core Version:    0.7.0.1
 */