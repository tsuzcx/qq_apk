package com.tencent.mobileqq.kandian.biz.ugc;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k=3, mv={1, 1, 16})
final class ReadInJoyUgcSearchTopicFragment$initSearchBox$1
  implements View.OnTouchListener
{
  ReadInJoyUgcSearchTopicFragment$initSearchBox$1(ReadInJoyUgcSearchTopicFragment paramReadInJoyUgcSearchTopicFragment) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = ReadInJoyUgcSearchTopicFragment.b(this.a).getCompoundDrawables()[2];
    Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "event");
    if ((paramMotionEvent.getAction() == 0) && (paramView != null))
    {
      float f = ReadInJoyUgcSearchTopicFragment.b(this.a).getRight() - paramView.getBounds().width();
      if (paramMotionEvent.getRawX() >= f)
      {
        ReadInJoyUgcSearchTopicFragment.c(this.a);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyUgcSearchTopicFragment.initSearchBox.1
 * JD-Core Version:    0.7.0.1
 */