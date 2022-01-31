package me.ele.uetool.dialog;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.SwitchItem;

class AttrsDialog$Adapter$SwitchViewHolder$1$1
  implements AttrsDialog.Adapter.SwitchViewHolder.AfterColorChange
{
  AttrsDialog$Adapter$SwitchViewHolder$1$1(AttrsDialog.Adapter.SwitchViewHolder.1 param1) {}
  
  public void afterColorChange(int paramInt)
  {
    ((SwitchItem)this.this$1.this$0.item).getElement().reset();
    ((AttrsDialog.Adapter)((RecyclerView)this.this$1.val$itemView.getParent()).getAdapter()).notifyDataSetChanged(((SwitchItem)this.this$1.this$0.item).getElement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.SwitchViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */