package com.tencent.viola.ui.dom;

import android.text.TextUtils;
import com.tencent.viola.ui.dom.style.FlexDirection;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class DomObjectList
  extends DomObject
{
  public void applyStyleToNode()
  {
    super.applyStyleToNode();
    Iterator localIterator = getAttributes().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if ("direction".equals((String)((Map.Entry)localObject).getKey()))
      {
        localObject = ViolaUtils.getString(((Map.Entry)localObject).getValue(), null);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && ("horizontal".equals(localObject))) {
          setFlexDirection(FlexDirection.ROW);
        }
      }
    }
  }
  
  public void layoutAfter()
  {
    super.layoutAfter();
    float f1 = ViolaUtils.getListContentWidth(this);
    float f2 = ViolaUtils.getListContentHeight(this);
    if (((this.mLastLayoutWidth != f1) || (this.mLastLayoutHeight != f2)) && (getEvents().contains("contentSizeChanged")))
    {
      ViolaUtils.fireContentSizeChange(this, f1, f2);
      this.mLastLayoutWidth = f1;
      this.mLastLayoutHeight = f2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectList
 * JD-Core Version:    0.7.0.1
 */