package com.tencent.trackrecordlib.core;

import android.view.View;

class a$1
  implements a.a
{
  a$1(a parama) {}
  
  public void a(View paramView)
  {
    try
    {
      if (RecordManager.getInstance().isEnableRecord())
      {
        if (com.tencent.trackrecordlib.g.a.a(RecordManager.getInstance().a)) {
          return;
        }
        if (paramView != null) {
          a.a(this.a, paramView);
        }
        a.a(this.a);
        return;
      }
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.a.1
 * JD-Core Version:    0.7.0.1
 */