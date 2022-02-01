package com.tencent.mobileqq.text.style;

import android.content.Context;
import com.tencent.util.Thrower.Action;
import com.tencent.widget.ActionSheet;

final class LinkSpan$5
  implements Thrower.Action<Integer>
{
  LinkSpan$5(Context paramContext, String paramString, ActionSheet paramActionSheet) {}
  
  public void a(Integer paramInteger)
  {
    int i = paramInteger.intValue();
    if (i != 0)
    {
      if (i == 1) {
        LinkSpan.c(this.a, this.b);
      }
    }
    else {
      LinkSpan.b(this.a, this.b);
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.LinkSpan.5
 * JD-Core Version:    0.7.0.1
 */