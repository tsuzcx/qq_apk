package com.tencent.mobileqq.emoticonview;

import apza;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class SystemAndEmojiUniversalPanel$1
  implements Runnable
{
  public void run()
  {
    List localList = apza.a(this.a, SystemAndEmojiUniversalPanel.a(this.this$0), true);
    ThreadManager.getUIHandler().post(new SystemAndEmojiUniversalPanel.1.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.1
 * JD-Core Version:    0.7.0.1
 */