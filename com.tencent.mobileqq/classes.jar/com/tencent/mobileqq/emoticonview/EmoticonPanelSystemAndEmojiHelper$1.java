package com.tencent.mobileqq.emoticonview;

import aprg;
import apsm;
import java.util.List;

public class EmoticonPanelSystemAndEmojiHelper$1
  implements Runnable
{
  public EmoticonPanelSystemAndEmojiHelper$1(aprg paramaprg) {}
  
  public void run()
  {
    List localList = this.this$0.a.b;
    int i;
    apsm localapsm;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        localapsm = (apsm)localList.get(i);
        if ((localapsm == null) || (localapsm.a != 7)) {}
      }
    }
    for (;;)
    {
      if ((localapsm != null) && (this.this$0.a.a != null)) {
        this.this$0.a.a.a(localapsm);
      }
      return;
      i += 1;
      break;
      localapsm = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper.1
 * JD-Core Version:    0.7.0.1
 */