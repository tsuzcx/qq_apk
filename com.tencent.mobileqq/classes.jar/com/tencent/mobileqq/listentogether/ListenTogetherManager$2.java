package com.tencent.mobileqq.listentogether;

import android.text.TextUtils;
import java.util.Map;

class ListenTogetherManager$2
  implements Runnable
{
  ListenTogetherManager$2(ListenTogetherManager paramListenTogetherManager) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(ListenTogetherManager.a(this.this$0))) {}
    ListenTogetherSession localListenTogetherSession;
    do
    {
      return;
      localListenTogetherSession = (ListenTogetherSession)ListenTogetherManager.a(this.this$0).get(ListenTogetherManager.a(this.this$0));
    } while (localListenTogetherSession == null);
    ListenTogetherManager.a(this.this$0, localListenTogetherSession.jdField_e_of_type_Int, localListenTogetherSession.jdField_e_of_type_JavaLangString, 1004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.2
 * JD-Core Version:    0.7.0.1
 */