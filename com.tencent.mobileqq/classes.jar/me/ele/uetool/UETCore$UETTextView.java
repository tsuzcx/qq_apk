package me.ele.uetool;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.Layout;
import android.util.Pair;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.IAttrs;
import me.ele.uetool.base.item.AddMinusEditItem;
import me.ele.uetool.base.item.BitmapItem;
import me.ele.uetool.base.item.EditTextItem;
import me.ele.uetool.base.item.Item;
import me.ele.uetool.base.item.SwitchItem;
import me.ele.uetool.base.item.TextItem;
import me.ele.uetool.util.Util;

class UETCore$UETTextView
  implements IAttrs
{
  public List<Item> getAttrs(Element paramElement)
  {
    ArrayList localArrayList = new ArrayList();
    TextView localTextView = (TextView)paramElement.getView();
    localArrayList.add(new EditTextItem("文本内容", paramElement, 1, localTextView.getText().toString()));
    Object localObject = localTextView.getLayout();
    if (localObject != null)
    {
      localArrayList.add(new TextItem("文本框下内边距（dp）", "" + ((Layout)localObject).getBottomPadding()));
      localArrayList.add(new TextItem("文本框上内边距（dp）", "" + ((Layout)localObject).getTopPadding()));
    }
    localObject = new AddMinusEditItem("字号（px）", paramElement, 2, localTextView.getTextSize() + "");
    ((AddMinusEditItem)localObject).setAddMin(new UETCore.UETTextView.1(this));
    localArrayList.add(localObject);
    localArrayList.add(new EditTextItem("文字颜色", paramElement, 3, Util.intToHexColor(localTextView.getCurrentTextColor())));
    localObject = Util.getTextViewBitmap(localTextView).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      localArrayList.add(new BitmapItem((String)localPair.first, (Bitmap)localPair.second));
    }
    if (localTextView.getTypeface() != null) {}
    for (boolean bool = localTextView.getTypeface().isBold();; bool = false)
    {
      localArrayList.add(new SwitchItem("文字加粗", paramElement, 1, bool));
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.UETCore.UETTextView
 * JD-Core Version:    0.7.0.1
 */