package com.tencent.widget;

import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

final class XEditTextEx$PerformClick
  implements Runnable
{
  long a;
  View b;
  
  XEditTextEx$PerformClick(XEditTextEx paramXEditTextEx, View paramView, long paramLong)
  {
    this.b = paramView;
    this.a = paramLong;
  }
  
  public void run()
  {
    if ((XEditTextEx.a(this.this$0) != null) && (XEditTextEx.a(this.this$0).size() > 0))
    {
      Iterator localIterator = XEditTextEx.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if (localObject != null)
        {
          localObject = (View.OnClickListener)((WeakReference)localObject).get();
          if (localObject != null) {
            ((View.OnClickListener)localObject).onClick(this.b);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.XEditTextEx.PerformClick
 * JD-Core Version:    0.7.0.1
 */