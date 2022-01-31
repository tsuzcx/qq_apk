package me.ele.uetool;

import android.graphics.Color;
import android.view.View;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.ElementItem.ChangeCallBack;
import me.ele.uetool.util.Util;

class UETCore$1
  implements ElementItem.ChangeCallBack
{
  UETCore$1(UETCore paramUETCore, View paramView) {}
  
  public void callBack(Element paramElement, Object paramObject)
  {
    Object localObject = Util.getBackground(this.val$view);
    if (((localObject instanceof String)) && (localObject != null)) {}
    for (int i = Color.parseColor((String)localObject);; i = -1)
    {
      Util.showColorPickerDialog(i, new UETCore.1.1(this, paramElement, paramObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.UETCore.1
 * JD-Core Version:    0.7.0.1
 */