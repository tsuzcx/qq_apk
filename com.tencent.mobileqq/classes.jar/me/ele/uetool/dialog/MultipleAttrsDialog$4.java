package me.ele.uetool.dialog;

import android.graphics.Color;
import android.view.View;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.ElementItem.ChangeCallBack;

final class MultipleAttrsDialog$4
  implements ElementItem.ChangeCallBack
{
  public void callBack(Element paramElement, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      int i = Color.parseColor((String)paramObject);
      paramElement.getView().setBackgroundColor(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.4
 * JD-Core Version:    0.7.0.1
 */