package com.tencent.mobileqq.dating.widget;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;

class InputBar$1
  implements Runnable
{
  InputBar$1(InputBar paramInputBar, int paramInt) {}
  
  public void run()
  {
    if (InputBar.a(this.this$0) > this.a - InputBar.b(this.this$0))
    {
      if (InputBar.c(this.this$0).getAdapter() == null) {
        i = 0;
      } else {
        i = InputBar.c(this.this$0).getAdapter().getCount();
      }
      int j = InputBar.d(this.this$0);
      int k = InputBar.c(this.this$0).getFooterViewsCount();
      float f = this.this$0.getResources().getDisplayMetrics().density;
      int m = (int)(61.0F * f);
      j = InputBar.b(this.this$0) - this.a + InputBar.c(this.this$0).getBottom() - (i - j - k - InputBar.e(this.this$0) - 1) * m;
      int i = j;
      if (InputBar.c(this.this$0).getFooterViewsCount() > 0) {
        i = (int)(j - f * 60.0F);
      }
      if (i > 0)
      {
        if (InputBar.f(this.this$0) != null) {
          InputBar.c(this.this$0).removeFooterView(InputBar.f(this.this$0));
        }
        InputBar localInputBar = this.this$0;
        InputBar.a(localInputBar, new View(localInputBar.getContext()));
        InputBar.f(this.this$0).setLayoutParams(new AbsListView.LayoutParams(-1, i));
        InputBar.c(this.this$0).addFooterView(InputBar.f(this.this$0));
      }
    }
    InputBar.c(this.this$0).setSelectionFromTop(InputBar.e(this.this$0) + InputBar.d(this.this$0), this.a - InputBar.g(this.this$0) - InputBar.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.InputBar.1
 * JD-Core Version:    0.7.0.1
 */