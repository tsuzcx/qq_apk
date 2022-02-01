package com.tencent.timi.game.component.chat.message;

import android.view.View;
import android.view.View.OnLongClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k=3, mv={1, 1, 16})
final class CenterMessageView$onLongClickListner$1
  implements View.OnLongClickListener
{
  CenterMessageView$onLongClickListner$1(CenterMessageView paramCenterMessageView) {}
  
  public final boolean onLongClick(View paramView)
  {
    CenterMessageView.c(this.a).a(this.a.getContext(), this.a.getMsg(), this.a.getLongOperOptions(), CenterMessageView.a(this.a), CenterMessageView.b(this.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.CenterMessageView.onLongClickListner.1
 * JD-Core Version:    0.7.0.1
 */