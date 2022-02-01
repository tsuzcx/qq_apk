package com.tencent.mobileqq.emoticonview;

import aryf;
import asaf;
import java.util.List;

public class EmoticonPanelFavHelper$1
  implements Runnable
{
  public EmoticonPanelFavHelper$1(aryf paramaryf) {}
  
  public void run()
  {
    List localList = this.this$0.a.b;
    int i;
    asaf localasaf;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        localasaf = (asaf)localList.get(i);
        if ((localasaf == null) || (localasaf.a != 4)) {}
      }
    }
    for (;;)
    {
      if ((localasaf != null) && (this.this$0.a.a != null)) {
        this.this$0.a.a.a(localasaf);
      }
      return;
      i += 1;
      break;
      localasaf = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.1
 * JD-Core Version:    0.7.0.1
 */