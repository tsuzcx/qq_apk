package me.ele.uetool;

import android.os.Build.VERSION;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.IAttrs;
import me.ele.uetool.base.item.Item;
import me.ele.uetool.base.item.SwitchItem;
import me.ele.uetool.base.item.TextItem;
import me.ele.uetool.base.item.TitleItem;
import me.ele.uetool.util.AccessibilityUtil;
import me.ele.uetool.util.Util;

public class UETCore$DevAttrs
  implements IAttrs
{
  public List<Item> getAttrs(Element paramElement)
  {
    View localView = paramElement.getView();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TitleItem("Dev"));
    localArrayList.add(new SwitchItem("ValidViews", paramElement, 3));
    localArrayList.add(new TextItem("Class", localView.getClass().getName()));
    try
    {
      localArrayList.add(new TextItem("ViewRes", Util.getResourceName(Util.getImageBgName(localView))));
      localArrayList.add(new SwitchItem("show on layers", paramElement, 5));
      localArrayList.add(new TextItem("Fragment", Util.getCurrentFragmentName(paramElement.getView()), new UETCore.DevAttrs.1(this)));
      localArrayList.add(new TextItem("Id", Util.getResId(localView)));
      if (Build.VERSION.SDK_INT >= 23) {
        localArrayList.add(new TextItem("AccessibilityClassName", localView.getAccessibilityClassName().toString()));
      }
      localArrayList.add(new TextItem("ContentDescription", (String)localView.getContentDescription()));
      if (!AccessibilityUtil.getIgnored(localView))
      {
        bool = true;
        localArrayList.add(new TextItem("AccessibilityFocus", String.valueOf(bool).toUpperCase()));
        if (!bool) {
          break label384;
        }
        paramElement = AccessibilityUtil.getFocusableReasons(localView);
        localArrayList.add(new TextItem("AccessibilityFocus reason", paramElement));
        localArrayList.add(new TextItem("ResName", Util.getResourceName(localView.getId())));
        localArrayList.add(new TextItem("Clickable", Boolean.toString(localView.isClickable()).toUpperCase()));
        localArrayList.add(new TextItem("Focused", Boolean.toString(localView.isFocused()).toUpperCase()));
        return localArrayList;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        boolean bool = false;
        continue;
        label384:
        paramElement = AccessibilityUtil.getIgnoredReasons(localView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.UETCore.DevAttrs
 * JD-Core Version:    0.7.0.1
 */