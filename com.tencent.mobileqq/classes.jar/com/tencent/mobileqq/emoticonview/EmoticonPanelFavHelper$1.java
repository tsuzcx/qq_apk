package com.tencent.mobileqq.emoticonview;

import asnt;
import aspt;
import java.util.List;

public class EmoticonPanelFavHelper$1
  implements Runnable
{
  public EmoticonPanelFavHelper$1(asnt paramasnt) {}
  
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
        if ((localaspt == null) || (localaspt.a != 4)) {}
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
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.1
 * JD-Core Version:    0.7.0.1
 */