package me.ele.uetool.dialog;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.EditTextItem;
import me.ele.uetool.colorpicker.listener.OnColorChangedListener;
import me.ele.uetool.util.Util;

class MultipleAttrsDialog$Adapter$EditTextViewHolder$2$1
  implements OnColorChangedListener
{
  MultipleAttrsDialog$Adapter$EditTextViewHolder$2$1(MultipleAttrsDialog.Adapter.EditTextViewHolder.2 param2) {}
  
  public void onColorChanged(int paramInt)
  {
    this.this$1.this$0.vDetail.setText(Util.intToHexColor(paramInt));
    if (((EditTextItem)this.this$1.this$0.item).getName().equals("Background")) {
      ((EditTextItem)this.this$1.this$0.item).getElement().getView().setBackgroundColor(paramInt);
    }
    for (;;)
    {
      ((MultipleAttrsDialog.Adapter)((RecyclerView)this.this$1.val$itemView.getParent()).getAdapter()).notifyDataSetChanged(((EditTextItem)this.this$1.this$0.item).getElement());
      return;
      if (((EditTextItem)this.this$1.this$0.item).getName().equals("TextColor")) {
        ((TextView)((EditTextItem)this.this$1.this$0.item).getElement().getView()).setTextColor(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.Adapter.EditTextViewHolder.2.1
 * JD-Core Version:    0.7.0.1
 */