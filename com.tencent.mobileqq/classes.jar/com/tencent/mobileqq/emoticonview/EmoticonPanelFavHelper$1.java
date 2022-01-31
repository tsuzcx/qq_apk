package com.tencent.mobileqq.emoticonview;

import apqu;
import apsm;
import java.util.List;

public class EmoticonPanelFavHelper$1
  implements Runnable
{
  public EmoticonPanelFavHelper$1(apqu paramapqu) {}
  
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
        if ((localapsm == null) || (localapsm.a != 4)) {}
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
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.1
 * JD-Core Version:    0.7.0.1
 */