package com.tencent.qqmini.sdk.launcher.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TabBarInfo
  implements Cloneable
{
  public static final String BORDER_STYLE_BLACK = "black";
  public static final String BORDER_STYLE_WHITE = "white";
  public static final String POS_BOTTOM = "bottom";
  public static final String POS_TOP = "top";
  public int backgroundColor;
  public String borderStyle;
  public int color;
  public boolean custom;
  public boolean isShow = true;
  public List<TabBarInfo.ButtonInfo> list;
  public String position;
  public int selectedColor;
  
  public static TabBarInfo parse(JSONObject paramJSONObject)
  {
    TabBarInfo localTabBarInfo = null;
    if (paramJSONObject != null)
    {
      localTabBarInfo = new TabBarInfo();
      localTabBarInfo.custom = paramJSONObject.optBoolean("custom", false);
      if (localTabBarInfo.custom) {
        localTabBarInfo.isShow = false;
      }
      localTabBarInfo.color = ColorUtils.parseColor(paramJSONObject.optString("color"));
      localTabBarInfo.selectedColor = ColorUtils.parseColor(paramJSONObject.optString("selectedColor"));
      localTabBarInfo.backgroundColor = ColorUtils.parseColor(paramJSONObject.optString("backgroundColor"));
      localTabBarInfo.borderStyle = paramJSONObject.optString("borderStyle", "black");
      localTabBarInfo.list = parseIconList(paramJSONObject.optJSONArray("list"));
      localTabBarInfo.position = paramJSONObject.optString("position", "bottom");
    }
    return localTabBarInfo;
  }
  
  public static List<TabBarInfo.ButtonInfo> parseIconList(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {
          localLinkedList.add(TabBarInfo.ButtonInfo.parse(localJSONObject));
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public static Bitmap transDataToBitmap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = Base64.decode(paramString, 0);
        if (paramString != null)
        {
          paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
          return paramString;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public TabBarInfo clone()
  {
    try
    {
      localTabBarInfo1 = (TabBarInfo)super.clone();
      try
      {
        localTabBarInfo1.list = new LinkedList();
        Iterator localIterator = this.list.iterator();
        for (;;)
        {
          Object localObject = localTabBarInfo1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (TabBarInfo.ButtonInfo)localIterator.next();
          localTabBarInfo1.list.add(((TabBarInfo.ButtonInfo)localObject).clone());
        }
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        TabBarInfo localTabBarInfo2;
        TabBarInfo localTabBarInfo1 = null;
      }
    }
    localTabBarInfo2 = localTabBarInfo1;
    return localTabBarInfo2;
  }
  
  public boolean isShow()
  {
    return this.isShow;
  }
  
  public void setShow(boolean paramBoolean)
  {
    this.isShow = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.TabBarInfo
 * JD-Core Version:    0.7.0.1
 */