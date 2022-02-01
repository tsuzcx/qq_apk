package com.tencent.mobileqq.kandian.biz.publisher;

import android.os.Handler;
import android.os.Message;
import com.tencent.widget.XListView;

class TroopBarPublishLocationSelectActivity$3
  extends Handler
{
  TroopBarPublishLocationSelectActivity$3(TroopBarPublishLocationSelectActivity paramTroopBarPublishLocationSelectActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1001) {
      return;
    }
    this.a.b.springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.TroopBarPublishLocationSelectActivity.3
 * JD-Core Version:    0.7.0.1
 */