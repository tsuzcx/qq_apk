package com.tencent.mobileqq.troop.troopnotification.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;

class TroopRequestActivity$11
  extends Handler
{
  TroopRequestActivity$11(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        paramMessage = (String)paramMessage.obj;
        TextView localTextView = this.a.o;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessage);
        localStringBuilder.append("");
        localTextView.setText(localStringBuilder.toString());
        localTextView = this.a.o;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessage);
        localStringBuilder.append("");
        localTextView.setContentDescription(localStringBuilder.toString());
        this.a.o.setVisibility(0);
        return;
      }
      this.a.a(true);
      this.a.h();
      paramMessage = this.a;
      QQToast.a(paramMessage, paramMessage.getString(2131718739), 0).b(this.a.getTitleBarHeight());
      return;
    }
    this.a.h();
    paramMessage = this.a;
    QQToast.a(paramMessage, paramMessage.getString(2131718752), 0).b(this.a.getTitleBarHeight());
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.11
 * JD-Core Version:    0.7.0.1
 */