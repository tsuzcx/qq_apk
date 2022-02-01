package com.tencent.mobileqq.kandian.biz.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.ExecutorService;

public class ReadInJoyManager$NotifyReceiver
  extends BroadcastReceiver
{
  public ReadInJoyManager$NotifyReceiver(ReadInJoyManager paramReadInJoyManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ReadInJoyManager.e(this.a).execute(new ReadInJoyManager.NotifyReceiver.1(this, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyManager.NotifyReceiver
 * JD-Core Version:    0.7.0.1
 */