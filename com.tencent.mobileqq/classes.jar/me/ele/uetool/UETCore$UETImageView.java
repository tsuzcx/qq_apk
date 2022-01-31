package me.ele.uetool;

import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.IAttrs;
import me.ele.uetool.base.item.BitmapItem;
import me.ele.uetool.base.item.Item;
import me.ele.uetool.util.Util;

class UETCore$UETImageView
  implements IAttrs
{
  public List<Item> getAttrs(Element paramElement)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BitmapItem("图片", Util.getImageViewBitmap((ImageView)paramElement.getView())));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.UETCore.UETImageView
 * JD-Core Version:    0.7.0.1
 */