package me.ele.uetool.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import me.ele.uetool.base.item.BriefDescItem;

class MultipleAttrsDialog$BriefDescViewHolder$1
  implements View.OnClickListener
{
  MultipleAttrsDialog$BriefDescViewHolder$1(MultipleAttrsDialog.BriefDescViewHolder paramBriefDescViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (MultipleAttrsDialog.BriefDescViewHolder.access$800(this.this$0) != null) {
      MultipleAttrsDialog.BriefDescViewHolder.access$800(this.this$0).selectView(((BriefDescItem)this.this$0.item).getElement());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.BriefDescViewHolder.1
 * JD-Core Version:    0.7.0.1
 */