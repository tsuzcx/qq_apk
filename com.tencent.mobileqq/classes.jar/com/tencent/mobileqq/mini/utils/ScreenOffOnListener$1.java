package com.tencent.mobileqq.mini.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.StringUtil;

class ScreenOffOnListener$1
  extends BroadcastReceiver
{
  ScreenOffOnListener$1(ScreenOffOnListener paramScreenOffOnListener) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (StringUtil.isEmpty(paramIntent.getAction())) {
      return;
    }
    if (ScreenOffOnListener.access$000(this.this$0) != null) {
      ScreenOffOnListener.access$000(this.this$0).onReceiveListener(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.ScreenOffOnListener.1
 * JD-Core Version:    0.7.0.1
 */