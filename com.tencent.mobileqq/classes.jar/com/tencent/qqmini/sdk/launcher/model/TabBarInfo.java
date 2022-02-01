package com.tencent.qqmini.sdk.launcher.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
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
    if (paramJSONObject != null)
    {
      TabBarInfo localTabBarInfo = new TabBarInfo();
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
      return localTabBarInfo;
    }
    return null;
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
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Base64.decode(paramString, 0);
      if (paramString == null) {
        return null;
      }
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public TabBarInfo clone()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 147	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	com/tencent/qqmini/sdk/launcher/model/TabBarInfo
    //   7: astore_1
    //   8: aload_1
    //   9: new 91	java/util/LinkedList
    //   12: dup
    //   13: invokespecial 92	java/util/LinkedList:<init>	()V
    //   16: putfield 86	com/tencent/qqmini/sdk/launcher/model/TabBarInfo:list	Ljava/util/List;
    //   19: aload_0
    //   20: getfield 86	com/tencent/qqmini/sdk/launcher/model/TabBarInfo:list	Ljava/util/List;
    //   23: invokeinterface 151 1 0
    //   28: astore_3
    //   29: aload_1
    //   30: astore_2
    //   31: aload_3
    //   32: invokeinterface 157 1 0
    //   37: ifeq +43 -> 80
    //   40: aload_3
    //   41: invokeinterface 160 1 0
    //   46: checkcast 104	com/tencent/qqmini/sdk/launcher/model/TabBarInfo$ButtonInfo
    //   49: astore_2
    //   50: aload_1
    //   51: getfield 86	com/tencent/qqmini/sdk/launcher/model/TabBarInfo:list	Ljava/util/List;
    //   54: aload_2
    //   55: invokevirtual 163	com/tencent/qqmini/sdk/launcher/model/TabBarInfo$ButtonInfo:clone	()Lcom/tencent/qqmini/sdk/launcher/model/TabBarInfo$ButtonInfo;
    //   58: invokeinterface 113 2 0
    //   63: pop
    //   64: goto -35 -> 29
    //   67: astore_2
    //   68: goto +6 -> 74
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_2
    //   75: invokevirtual 164	java/lang/Throwable:printStackTrace	()V
    //   78: aload_1
    //   79: astore_2
    //   80: aload_2
    //   81: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	TabBarInfo
    //   7	72	1	localTabBarInfo1	TabBarInfo
    //   30	25	2	localObject	Object
    //   67	1	2	localThrowable1	java.lang.Throwable
    //   71	4	2	localThrowable2	java.lang.Throwable
    //   79	2	2	localTabBarInfo2	TabBarInfo
    //   28	13	3	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   8	29	67	java/lang/Throwable
    //   31	64	67	java/lang/Throwable
    //   0	8	71	java/lang/Throwable
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