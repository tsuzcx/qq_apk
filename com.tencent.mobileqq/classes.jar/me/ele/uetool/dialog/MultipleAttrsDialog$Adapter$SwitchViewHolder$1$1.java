package me.ele.uetool.dialog;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.SwitchItem;

class MultipleAttrsDialog$Adapter$SwitchViewHolder$1$1
  implements AttrsDialog.Adapter.SwitchViewHolder.AfterColorChange
{
  MultipleAttrsDialog$Adapter$SwitchViewHolder$1$1(MultipleAttrsDialog.Adapter.SwitchViewHolder.1 param1) {}
  
  public void afterColorChange(int paramInt)
  {
    ((MultipleAttrsDialog.Adapter)((RecyclerView)this.this$1.val$itemView.getParent()).getAdapter()).notifyDataSetChanged(((SwitchItem)this.this$1.this$0.item).getElement());
    if ((((SwitchItem)this.this$1.this$0.item).getElement().getView() instanceof TextView))
    {
      localIterator = MultipleAttrsDialog.Adapter.access$100().iterator();
      while (localIterator.hasNext()) {
        ((TextView)((Element)localIterator.next()).getView()).setTextColor(paramInt);
      }
    }
    Iterator localIterator = MultipleAttrsDialog.Adapter.access$100().iterator();
    while (localIterator.hasNext()) {
      ((Element)localIterator.next()).getView().setBackgroundColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.Adapter.SwitchViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */