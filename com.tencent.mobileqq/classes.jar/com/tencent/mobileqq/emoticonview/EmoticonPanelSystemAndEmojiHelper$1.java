package com.tencent.mobileqq.emoticonview;

import asoj;
import aspt;
import java.util.List;

public class EmoticonPanelSystemAndEmojiHelper$1
  implements Runnable
{
  public EmoticonPanelSystemAndEmojiHelper$1(asoj paramasoj) {}
  
  public void run()
  {
    List localList = this.this$0.a.b;
    int i;
    aspt localaspt;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        localaspt = (aspt)localList.get(i);
        if ((localaspt == null) || (localaspt.a != 7)) {}
      }
    }
    for (;;)
    {
      if ((localaspt != null) && (this.this$0.a.a != null)) {
        this.this$0.a.a.a(localaspt);
      }
      return;
      i += 1;
      break;
      localaspt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper.1
 * JD-Core Version:    0.7.0.1
 */