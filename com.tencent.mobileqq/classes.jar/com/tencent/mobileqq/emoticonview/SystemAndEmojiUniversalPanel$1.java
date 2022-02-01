package com.tencent.mobileqq.emoticonview;

import ascv;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class SystemAndEmojiUniversalPanel$1
  implements Runnable
{
  SystemAndEmojiUniversalPanel$1(SystemAndEmojiUniversalPanel paramSystemAndEmojiUniversalPanel, int paramInt) {}
  
  public void run()
  {
    List localList = ascv.a(this.a, SystemAndEmojiUniversalPanel.a(this.this$0), true, SystemAndEmojiUniversalPanel.b(this.this$0));
    ThreadManager.getUIHandler().post(new SystemAndEmojiUniversalPanel.1.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.1
 * JD-Core Version:    0.7.0.1
 */