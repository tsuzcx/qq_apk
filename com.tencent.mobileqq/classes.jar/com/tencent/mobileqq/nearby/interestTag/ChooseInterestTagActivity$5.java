package com.tencent.mobileqq.nearby.interestTag;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import java.util.List;

class ChooseInterestTagActivity$5
  extends Handler
{
  ChooseInterestTagActivity$5(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 4100: 
      ChooseInterestTagActivity.access$1502(this.a, false);
      return;
    case 4099: 
      ChooseInterestTagActivity.access$1600(this.a, HardCodeUtil.a(2131900032));
      ChooseInterestTagActivity.access$1700(this.a).setText("");
      ChooseInterestTagActivity.access$1700(this.a).setOnClickListener(null);
      return;
    case 4098: 
      ChooseInterestTagActivity.access$900(this.a).setVisibility(8);
      paramMessage = (List)paramMessage.obj;
      if (paramMessage != null) {
        ChooseInterestTagActivity.access$1002(this.a, paramMessage);
      }
      paramMessage = ChooseInterestTagActivity.access$1100(this.a);
      boolean bool = true;
      if (paramMessage == null)
      {
        paramMessage = this.a;
        ChooseInterestTagActivity.access$1102(paramMessage, new InterestTagAdapter(paramMessage, ChooseInterestTagActivity.access$000(paramMessage), ChooseInterestTagActivity.access$1000(this.a), ChooseInterestTagActivity.access$1200(this.a)));
        ChooseInterestTagActivity.access$1300(this.a).setAdapter(ChooseInterestTagActivity.access$1100(this.a));
      }
      else
      {
        ChooseInterestTagActivity.access$1100(this.a).a(ChooseInterestTagActivity.access$1000(this.a), true);
      }
      paramMessage = this.a;
      if (ChooseInterestTagActivity.access$200(paramMessage) == -1) {
        bool = false;
      }
      ChooseInterestTagActivity.access$1400(paramMessage, false, bool);
      return;
    }
    ChooseInterestTagActivity.access$300(this.a).a(ChooseInterestTagActivity.access$700(this.a), ChooseInterestTagActivity.access$000(this.a), ChooseInterestTagActivity.access$800(this.a), 30, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.5
 * JD-Core Version:    0.7.0.1
 */