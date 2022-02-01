package com.tencent.mobileqq.gamecenter.view;

import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class GameAioViewSwitcher$1
  implements Runnable
{
  GameAioViewSwitcher$1(GameAioViewSwitcher paramGameAioViewSwitcher) {}
  
  public void run()
  {
    try
    {
      if (GameAioViewSwitcher.a(this.this$0) != null)
      {
        if (GameAioViewSwitcher.a(this.this$0).size() == 0) {
          return;
        }
        Iterator localIterator = GameAioViewSwitcher.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          URLDrawable.getDrawable((String)localIterator.next()).downloadImediatly(true);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("GameAioViewSwitcher download.", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameAioViewSwitcher.1
 * JD-Core Version:    0.7.0.1
 */