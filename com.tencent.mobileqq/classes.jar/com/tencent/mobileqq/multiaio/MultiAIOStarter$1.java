package com.tencent.mobileqq.multiaio;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.multiaio.view.MultiAioCaller;

final class MultiAIOStarter$1
  implements MultiAioCaller
{
  MultiAIOStarter$1(Context paramContext) {}
  
  public void a(Intent paramIntent)
  {
    Context localContext = this.a;
    if ((localContext instanceof ChatActivity)) {
      ((ChatActivity)localContext).switchToAio(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOStarter.1
 * JD-Core Version:    0.7.0.1
 */