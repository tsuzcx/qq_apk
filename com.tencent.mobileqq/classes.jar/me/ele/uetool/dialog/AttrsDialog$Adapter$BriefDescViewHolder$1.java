package me.ele.uetool.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import me.ele.uetool.base.item.BriefDescItem;

class AttrsDialog$Adapter$BriefDescViewHolder$1
  implements View.OnClickListener
{
  AttrsDialog$Adapter$BriefDescViewHolder$1(AttrsDialog.Adapter.BriefDescViewHolder paramBriefDescViewHolder, AttrsDialog.AttrDialogCallback paramAttrDialogCallback) {}
  
  public void onClick(View paramView)
  {
    if (this.val$callback != null) {
      this.val$callback.selectView(((BriefDescItem)this.this$0.item).getElement());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.BriefDescViewHolder.1
 * JD-Core Version:    0.7.0.1
 */