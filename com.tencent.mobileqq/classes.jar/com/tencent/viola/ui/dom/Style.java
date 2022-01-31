package com.tencent.viola.ui.dom;

import android.graphics.Paint.Align;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.viola.ui.dom.style.FlexAlign;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.dom.style.FlexDirection;
import com.tencent.viola.ui.dom.style.FlexJustifyContent;
import com.tencent.viola.ui.dom.style.FlexPositionType;
import com.tencent.viola.ui.dom.style.FlexWrap;
import com.tencent.viola.ui.dom.style.ImageSpanAlign;
import com.tencent.viola.ui.dom.style.font.TextDecoration;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class Style
  implements Cloneable, Map<String, Object>
{
  public static String TAG = "Style";
  public static final float UNDEFINED = (0.0F / 0.0F);
  public static final int UNSET = -1;
  @NonNull
  private final ConcurrentHashMap<String, Object> mStyles = new ConcurrentHashMap();
  
  public Style() {}
  
  public Style(Map<String, Object> paramMap)
  {
    this();
    putAll(paramMap);
  }
  
  public Style(JSONObject paramJSONObject)
  {
    this();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext()) {
      try
      {
        String str = (String)localIterator.next();
        put(str, paramJSONObject.get(str));
      }
      catch (JSONException localJSONException)
      {
        ViolaLogUtils.e(TAG, "Style JSONException e:" + localJSONException.getMessage());
      }
    }
  }
  
  public static float getBorderWidthWithObj(Object paramObject, int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(paramObject, paramInt);
  }
  
  public void clear()
  {
    this.mStyles.clear();
  }
  
  protected Style clone()
  {
    Style localStyle = new Style();
    localStyle.mStyles.putAll(this.mStyles);
    return localStyle;
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.mStyles.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return this.mStyles.containsValue(paramObject);
  }
  
  @NonNull
  public Set<Map.Entry<String, Object>> entrySet()
  {
    return this.mStyles.entrySet();
  }
  
  public Object get(Object paramObject)
  {
    return this.mStyles.get(paramObject);
  }
  
  public FlexAlign getAlignItems()
  {
    Object localObject = get("alignItems");
    if (localObject == null) {
      return FlexAlign.STRETCH;
    }
    return FlexConvertUtils.convertAlignItem(localObject.toString().trim());
  }
  
  public FlexAlign getAlignSelf()
  {
    Object localObject = get("alignSelf");
    if (localObject == null) {
      return FlexAlign.STRETCH;
    }
    return FlexConvertUtils.convertAlignSelf(localObject.toString().trim());
  }
  
  public String getBackGroundColor()
  {
    return (String)get("backgroundColor");
  }
  
  public float getBorderBottomWidth(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("borderBottomWidth"), paramInt);
  }
  
  public float getBorderLeftWidth(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("borderLeftWidth"), paramInt);
  }
  
  public float getBorderRightWidth(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("borderRightWidth"), paramInt);
  }
  
  public float getBorderTopWidth(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("borderTopWidth"), paramInt);
  }
  
  public float getBorderWidth(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("borderWidth"), paramInt);
  }
  
  public float getBottom(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("bottom"), paramInt);
  }
  
  public FlexWrap getCSSWrap()
  {
    Object localObject = get("flexWrap");
    if (localObject == null) {
      return FlexWrap.NOWRAP;
    }
    return FlexConvertUtils.convertWrap(localObject.toString().trim());
  }
  
  public float getDefaultHeight(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("defaultHeight"), paramInt);
  }
  
  public float getDefaultWidth(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("defaultWidth"), paramInt);
  }
  
  public String getEllipsisColor()
  {
    Object localObject = get("ellipsisColor");
    if (localObject == null) {
      return "";
    }
    return localObject.toString();
  }
  
  public float getFlex()
  {
    return ViolaUtils.getFloat(get("flex"));
  }
  
  public FlexDirection getFlexDirection()
  {
    Object localObject = get("flexDirection");
    if (localObject == null) {
      return FlexDirection.COLUMN;
    }
    return FlexConvertUtils.convertDirection(localObject.toString().trim());
  }
  
  public String getFontFamily()
  {
    String str = null;
    Object localObject = get("fontFamily");
    if (localObject != null) {
      str = localObject.toString();
    }
    return str;
  }
  
  public int getFontSize(int paramInt)
  {
    Object localObject = get("fontSize");
    if (localObject == null) {
      return (int)FlexConvertUtils.converPxByViewportToRealPx("12dp", paramInt);
    }
    return (int)FlexConvertUtils.converPxByViewportToRealPx(localObject, paramInt);
  }
  
  public int getFontStyle()
  {
    Object localObject = get("fontStyle");
    if (localObject == null) {}
    while (!localObject.toString().equals("italic")) {
      return 0;
    }
    return 2;
  }
  
  public int getFontWeight()
  {
    int j = 1;
    Object localObject = get("fontWeight");
    int i;
    if (localObject != null)
    {
      localObject = localObject.toString();
      i = -1;
      switch (((String)localObject).hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        j = 0;
      }
      return j;
      if (((String)localObject).equals("600"))
      {
        i = 0;
        continue;
        if (((String)localObject).equals("700"))
        {
          i = 1;
          continue;
          if (((String)localObject).equals("800"))
          {
            i = 2;
            continue;
            if (((String)localObject).equals("900"))
            {
              i = 3;
              continue;
              if (((String)localObject).equals("bold")) {
                i = 4;
              }
            }
          }
        }
      }
    }
  }
  
  public float getHeight(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("height"), paramInt);
  }
  
  public ImageSpanAlign getImageSpanALign()
  {
    Object localObject = get("imageAlign");
    if (localObject == null) {
      return ImageSpanAlign.BASELINE;
    }
    return FlexConvertUtils.convertImageSpanAlign(localObject.toString().trim());
  }
  
  public FlexJustifyContent getJustifyContent()
  {
    Object localObject = get("justifyContent");
    if (localObject == null) {
      return FlexJustifyContent.FLEX_START;
    }
    return FlexConvertUtils.convertJustifyContent(localObject.toString().trim());
  }
  
  public float getLeft(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("left"), paramInt);
  }
  
  public int getLetterSpacing(int paramInt)
  {
    int i = (int)FlexConvertUtils.converPxByViewportToRealPx(get("letterSpacing"), paramInt);
    paramInt = i;
    if (i <= 0) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  public int getLineHeight(int paramInt)
  {
    int i = (int)FlexConvertUtils.converPxByViewportToRealPx(get("lineHeight"), paramInt);
    paramInt = i;
    if (i <= 0) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  public int getLineSpacing(int paramInt)
  {
    int i = (int)FlexConvertUtils.converPxByViewportToRealPx(get("lineSpacing"), paramInt);
    paramInt = i;
    if (i <= 0) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  public int getLines()
  {
    return ViolaUtils.getInt(get("lines"));
  }
  
  public float getMargin(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("margin"), paramInt);
  }
  
  public float getMarginBottom(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("marginBottom"), paramInt);
  }
  
  public float getMarginLeft(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("marginLeft"), paramInt);
  }
  
  public float getMarginRight(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("marginRight"), paramInt);
  }
  
  public float getMarginTop(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("marginTop"), paramInt);
  }
  
  public float getMaxHeight(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("maxHeight"), paramInt);
  }
  
  public float getMaxWidth(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("maxWidth"), paramInt);
  }
  
  public float getMinHeight(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("minHeight"), paramInt);
  }
  
  public float getMinWidth(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("minWidth"), paramInt);
  }
  
  public float getPadding(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("padding"), paramInt);
  }
  
  public float getPaddingBottom(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("paddingBottom"), paramInt);
  }
  
  public float getPaddingLeft(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("paddingLeft"), paramInt);
  }
  
  public float getPaddingRight(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("paddingRight"), paramInt);
  }
  
  public float getPaddingTop(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("paddingTop"), paramInt);
  }
  
  public FlexPositionType getPosition()
  {
    Object localObject = get("position");
    if (localObject == null) {
      return FlexPositionType.RELATIVE;
    }
    return FlexConvertUtils.converPosition(localObject.toString().trim());
  }
  
  public float getRight(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("right"), paramInt);
  }
  
  public Layout.Alignment getTextAlignment()
  {
    Layout.Alignment localAlignment = Layout.Alignment.ALIGN_NORMAL;
    String str = (String)get("textAlign");
    if (TextUtils.equals("left", str)) {
      return Layout.Alignment.ALIGN_NORMAL;
    }
    if (TextUtils.equals("center", str)) {
      return Layout.Alignment.ALIGN_CENTER;
    }
    if (TextUtils.equals("right", str)) {
      return Layout.Alignment.ALIGN_OPPOSITE;
    }
    return localAlignment;
  }
  
  public String getTextColor()
  {
    Object localObject = get("color");
    if (localObject == null) {
      return "";
    }
    return localObject.toString();
  }
  
  public TextDecoration getTextDecoration()
  {
    Object localObject = get("textDecoration");
    TextDecoration localTextDecoration = TextDecoration.NONE;
    if (localObject == null) {
      return localTextDecoration;
    }
    localObject = localObject.toString();
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return TextDecoration.INVALID;
        if (((String)localObject).equals("underline"))
        {
          i = 0;
          continue;
          if (((String)localObject).equals("line-through"))
          {
            i = 1;
            continue;
            if (((String)localObject).equals("none"))
            {
              i = 2;
              continue;
              if (((String)localObject).equals("")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return TextDecoration.UNDERLINE;
    return TextDecoration.LINETHROUGH;
    return TextDecoration.NONE;
  }
  
  public TextUtils.TruncateAt getTextOverflow()
  {
    if (TextUtils.equals("ellipsis", (String)get("textOverflow"))) {
      return TextUtils.TruncateAt.END;
    }
    return null;
  }
  
  public Paint.Align getTextPaintAlign()
  {
    Paint.Align localAlign = Paint.Align.LEFT;
    String str = (String)get("textAlign");
    if (TextUtils.equals("left", str)) {
      return Paint.Align.LEFT;
    }
    if (TextUtils.equals("center", str)) {
      return Paint.Align.CENTER;
    }
    if (TextUtils.equals("right", str)) {
      return Paint.Align.RIGHT;
    }
    return localAlign;
  }
  
  public float getTop(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("top"), paramInt);
  }
  
  public float getWidth(int paramInt)
  {
    return FlexConvertUtils.converPxByViewportToRealPx(get("width"), paramInt);
  }
  
  public boolean isEmpty()
  {
    return this.mStyles.isEmpty();
  }
  
  public boolean isFixed()
  {
    return false;
  }
  
  @NonNull
  public Set<String> keySet()
  {
    return this.mStyles.keySet();
  }
  
  public Object put(String paramString, Object paramObject)
  {
    return this.mStyles.put(paramString, paramObject);
  }
  
  public void putAll(@NonNull Map<? extends String, ?> paramMap)
  {
    this.mStyles.putAll(paramMap);
  }
  
  public Object remove(Object paramObject)
  {
    return this.mStyles.remove(paramObject);
  }
  
  public int size()
  {
    return this.mStyles.size();
  }
  
  @NonNull
  public Collection<Object> values()
  {
    return this.mStyles.values();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.dom.Style
 * JD-Core Version:    0.7.0.1
 */