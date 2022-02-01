package com.tencent.mobileqq.onlinestatus.view;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.text.QQText;
import mqq.observer.BusinessObserver;

class OnlineStatusAIOPopUpWindow$2
  implements BusinessObserver
{
  OnlineStatusAIOPopUpWindow$2(OnlineStatusAIOPopUpWindow paramOnlineStatusAIOPopUpWindow) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((this.a.isShowing()) && (paramBoolean) && (paramBundle != null) && (paramBundle.getString("key_auto_reply") != null))
    {
      OnlineStatusAIOPopUpWindow.a(this.a).setVisibility(0);
      paramBundle = new QQText(paramBundle.getString("key_auto_reply"), 3, 16);
      OnlineStatusAIOPopUpWindow.a(this.a).setText(paramBundle);
      OnlineStatusAIOPopUpWindow.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusAIOPopUpWindow.2
 * JD-Core Version:    0.7.0.1
 */