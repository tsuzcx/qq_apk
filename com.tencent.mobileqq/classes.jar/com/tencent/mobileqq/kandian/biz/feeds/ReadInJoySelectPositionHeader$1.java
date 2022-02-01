package com.tencent.mobileqq.kandian.biz.feeds;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ReadInJoySelectPositionHeader$1
  implements View.OnClickListener
{
  ReadInJoySelectPositionHeader$1(ReadInJoySelectPositionHeader paramReadInJoySelectPositionHeader, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    Object localObject = ReadInJoyLogicEngine.a().j();
    if (localObject != null)
    {
      paramView = ((SelectPositionModule)localObject).c();
      if (((SelectPositionModule)localObject).a(paramView))
      {
        ((SelectPositionModule)localObject).c(paramView);
        if (ReadInJoySelectPositionHeader.a(this.b) != null) {
          ReadInJoySelectPositionHeader.a(this.b).a(paramView);
        }
      }
      else
      {
        if (paramView != null) {
          QQToast.makeText(this.a, String.format("你当前在%s，暂无本地频道。", new Object[] { paramView.cityGPS }), 0).show();
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onClick not in city white list gpsPosition = ");
          ((StringBuilder)localObject).append(paramView);
          QLog.i("ReadInJoySelectPositionHeader", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoySelectPositionHeader.1
 * JD-Core Version:    0.7.0.1
 */