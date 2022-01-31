package me.ele.uetool.dialog;

import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import me.ele.uetool.base.Element;
import me.ele.uetool.colorpicker.listener.OnColorChangedListener;

class MultipleAttrsDialog$1$1
  implements OnColorChangedListener
{
  MultipleAttrsDialog$1$1(MultipleAttrsDialog.1 param1, Element paramElement, Object paramObject) {}
  
  public void onColorChanged(int paramInt)
  {
    Log.i("MultipleAttrsDialog", "onSelected: " + paramInt);
    ColorDrawable localColorDrawable = new ColorDrawable(paramInt);
    this.val$element.getView().setBackground(localColorDrawable);
    if ((this.val$valAfterChange instanceof AttrsDialog.Adapter.SwitchViewHolder.AfterColorChange)) {
      ((AttrsDialog.Adapter.SwitchViewHolder.AfterColorChange)this.val$valAfterChange).afterColorChange(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.1.1
 * JD-Core Version:    0.7.0.1
 */