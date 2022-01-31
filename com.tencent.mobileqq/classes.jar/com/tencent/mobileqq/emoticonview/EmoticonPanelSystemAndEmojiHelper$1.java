package com.tencent.mobileqq.emoticonview;

import apvp;
import apwv;
import java.util.List;

public class EmoticonPanelSystemAndEmojiHelper$1
  implements Runnable
{
  public EmoticonPanelSystemAndEmojiHelper$1(apvp paramapvp) {}
  
  public void run()
  {
    List localList = this.this$0.a.b;
    int i;
    apwv localapwv;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        localapwv = (apwv)localList.get(i);
        if ((localapwv == null) || (localapwv.a != 7)) {}
      }
    }
    for (;;)
    {
      if ((localapwv != null) && (this.this$0.a.a != null)) {
        this.this$0.a.a.a(localapwv);
      }
      return;
      i += 1;
      break;
      localapwv = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper.1
 * JD-Core Version:    0.7.0.1
 */