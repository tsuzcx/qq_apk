package com.tencent.mobileqq.kandian.biz.push.activity;

import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.widget.XListView.DrawFinishedListener;

class ReadInJoyMessagesActivity$2
  implements XListView.DrawFinishedListener
{
  ReadInJoyMessagesActivity$2(ReadInJoyMessagesActivity paramReadInJoyMessagesActivity) {}
  
  public void drawFinished()
  {
    if ((!this.a.a) && (this.a.b))
    {
      this.a.a = true;
      PublicTracker.a("subscribe_tab_cost", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyMessagesActivity.2
 * JD-Core Version:    0.7.0.1
 */