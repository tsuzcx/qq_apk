package com.tencent.mobileqq.structmsg;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StructMsgForHypertext$2
  implements View.OnClickListener
{
  StructMsgForHypertext$2(StructMsgForHypertext paramStructMsgForHypertext) {}
  
  public void onClick(View paramView)
  {
    new StructMsgClickHandler(null, paramView, this.a.message).a("web", this.a.mSourceUrl, null, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.mMsgServiceID);
    localStringBuilder.append("");
    ReportController.b(null, "CliOper", "", "", "0X800567C", "0X800567C", 0, 0, localStringBuilder.toString(), "", "", "");
    ReportController.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForHypertext.2
 * JD-Core Version:    0.7.0.1
 */