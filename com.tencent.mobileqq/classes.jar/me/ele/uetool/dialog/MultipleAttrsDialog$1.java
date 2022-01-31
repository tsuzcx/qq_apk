package me.ele.uetool.dialog;

import android.graphics.Color;
import android.view.View;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.ElementItem.ChangeCallBack;
import me.ele.uetool.util.Util;

final class MultipleAttrsDialog$1
  implements ElementItem.ChangeCallBack
{
  MultipleAttrsDialog$1(View paramView) {}
  
  public void callBack(Element paramElement, Object paramObject)
  {
    Object localObject = Util.getBackground(this.val$view);
    if (((localObject instanceof String)) && (localObject != null)) {}
    for (int i = Color.parseColor((String)localObject);; i = -1)
    {
      Util.showColorPickerDialog(i, new MultipleAttrsDialog.1.1(this, paramElement, paramObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.1
 * JD-Core Version:    0.7.0.1
 */