package me.ele.uetool;

import android.graphics.Color;
import android.view.View;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.ElementItem.ChangeCallBack;

class UETCore$5
  implements ElementItem.ChangeCallBack
{
  UETCore$5(UETCore paramUETCore) {}
  
  public void callBack(Element paramElement, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      int i = Color.parseColor((String)paramObject);
      paramElement.getView().setBackgroundColor(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.UETCore.5
 * JD-Core Version:    0.7.0.1
 */