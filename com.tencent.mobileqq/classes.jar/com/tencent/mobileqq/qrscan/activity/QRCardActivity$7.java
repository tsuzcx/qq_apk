package com.tencent.mobileqq.qrscan.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.qrscan.QRCard;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

class QRCardActivity$7
  implements View.OnClickListener
{
  QRCardActivity$7(QRCardActivity paramQRCardActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof Integer))
    {
      Integer localInteger = (Integer)localObject;
      if (localInteger.intValue() == 0) {
        localObject = (String)((TextView)paramView.findViewById(2131365169)).getText();
      } else {
        localObject = null;
      }
      if (localInteger.intValue() == 1)
      {
        localObject = this.a;
        ((QRCardActivity)localObject).a((String)((QRCardActivity)localObject).a.d.get(this.a.h));
      }
      else
      {
        QRCardActivity.a(this.a, paramView.getContext(), localInteger.intValue(), null, (String)localObject);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.QRCardActivity.7
 * JD-Core Version:    0.7.0.1
 */