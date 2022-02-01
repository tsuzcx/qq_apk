package com.tencent.mobileqq.listentogether;

import android.text.TextUtils;
import java.util.Map;

class ListenTogetherManager$1
  implements Runnable
{
  ListenTogetherManager$1(ListenTogetherManager paramListenTogetherManager) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(ListenTogetherManager.a(this.this$0))) {
      return;
    }
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)ListenTogetherManager.a(this.this$0).get(ListenTogetherManager.a(this.this$0));
    if (localListenTogetherSession == null) {
      return;
    }
    ListenTogetherManager.a(this.this$0, localListenTogetherSession.f, localListenTogetherSession.e, 1007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.1
 * JD-Core Version:    0.7.0.1
 */