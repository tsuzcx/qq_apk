package com.tencent.plato.sdk.element;

import android.text.TextUtils;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.core.IWritableMap;
import com.tencent.plato.layout.LayoutEngine;
import com.tencent.plato.layout.PAlign;
import com.tencent.plato.layout.PDisplay;
import com.tencent.plato.layout.PFlexDirection;
import com.tencent.plato.layout.PJustify;
import com.tencent.plato.layout.PlatoNode;
import com.tencent.plato.sdk.render.PDivView;
import com.tencent.plato.sdk.utils.Dimension;
import com.tencent.plato.sdk.widget.PullToRefreshBase.Mode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PDivElement
  extends PElement
{
  private static final int SCROLL_HORIZONTAL = 2;
  private static final int SCROLL_NONE = 0;
  private static final int SCROLL_VERTICAL = 1;
  String backgroundImage;
  int backgroundPosition = 119;
  float backgroundPositionX;
  float backgroundPositionY;
  boolean backgroundRepeatX = false;
  boolean backgroundRepeatY = false;
  float backgroundSizeH;
  float backgroundSizeW;
  public String flexWrap;
  CharSequence pullLabel = "正在加载";
  CharSequence refreshingLabel = "正在加载";
  CharSequence releaseLabel = "正在加载";
  int scroll = 0;
  PullToRefreshBase.Mode scrollMode = PullToRefreshBase.Mode.DISABLED;
  
  public PDivElement(LayoutEngine paramLayoutEngine, int paramInt)
  {
    super(paramLayoutEngine, paramInt);
    this.uiStyles.put("scroll", this.scroll);
    this.uiStyles.put("backgroundRepeatX", this.backgroundRepeatX);
    this.uiStyles.put("backgroundRepeatY", this.backgroundRepeatY);
    this.uiStyles.put("backgroundPosition", this.backgroundPosition);
  }
  
  @Property("alignItems")
  public void alignItems(String paramString)
  {
    setAlignItems(paramString);
  }
  
  @Property("backgroundImage")
  public void backgroundImage(IPlatoRuntime paramIPlatoRuntime, String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("url(")) {
      str = paramString.substring(4, paramString.length() - 1);
    }
    paramString = str;
    if (!str.startsWith("/"))
    {
      paramString = str;
      if (!str.startsWith("http://"))
      {
        paramString = str;
        if (!str.startsWith("https://")) {
          paramString = "file://" + paramIPlatoRuntime.getPath() + "/" + str;
        }
      }
    }
    this.backgroundImage = paramString;
    addUIStyle("backgroundImage", this.backgroundImage);
  }
  
  @Property("backgroundPosition")
  public void backgroundPosition(String paramString)
  {
    if ("left top".equals(paramString)) {
      this.backgroundPosition = 51;
    }
    for (;;)
    {
      addUIStyle("backgroundPosition", this.backgroundPosition);
      return;
      if ("left center".equals(paramString))
      {
        this.backgroundPosition = 19;
      }
      else if ("left bottom".equals(paramString))
      {
        this.backgroundPosition = 83;
      }
      else if ("right top".equals(paramString))
      {
        this.backgroundPosition = 53;
      }
      else if ("right center".equals(paramString))
      {
        this.backgroundPosition = 21;
      }
      else if ("right bottom".equals(paramString))
      {
        this.backgroundPosition = 85;
      }
      else if ("center top".equals(paramString))
      {
        this.backgroundPosition = 49;
      }
      else if ("center center".equals(paramString))
      {
        this.backgroundPosition = 17;
      }
      else if ("center bottom".equals(paramString))
      {
        this.backgroundPosition = 81;
      }
      else if ("left".equals(paramString))
      {
        this.backgroundPosition = 19;
      }
      else if ("right".equals(paramString))
      {
        this.backgroundPosition = 21;
      }
      else if ("center".equals(paramString))
      {
        this.backgroundPosition = 17;
      }
      else if ("top".equals(paramString))
      {
        this.backgroundPosition = 49;
      }
      else if ("bottom".equals(paramString))
      {
        this.backgroundPosition = 81;
      }
      else if (TextUtils.isEmpty(paramString))
      {
        this.backgroundPosition = 119;
      }
      else
      {
        paramString = paramString.split(" ");
        if ((paramString != null) && (paramString.length == 2))
        {
          this.backgroundPosition = 0;
          this.backgroundPositionX = Float.parseFloat(paramString[0].substring(0, paramString[0].length() - 2));
          this.backgroundPositionY = Float.parseFloat(paramString[1].substring(0, paramString[1].length() - 2));
          addUIStyle("backgroundPositionX", this.backgroundPositionX);
          addUIStyle("backgroundPositionY", this.backgroundPositionY);
        }
      }
    }
  }
  
  @Property("backgroundPositionX")
  public void backgroundPositionX(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.backgroundPosition = 119;
      addUIStyle("backgroundPosition", this.backgroundPosition);
      return;
    }
    this.backgroundPositionX = Float.parseFloat(paramString.substring(0, paramString.length() - 2));
    addUIStyle("backgroundPosition", 0);
    addUIStyle("backgroundPositionX", this.backgroundPositionX);
  }
  
  @Property("backgroundPositionY")
  public void backgroundPositionY(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.backgroundPosition = 119;
      addUIStyle("backgroundPosition", this.backgroundPosition);
      return;
    }
    this.backgroundPositionX = Float.parseFloat(paramString.substring(0, paramString.length() - 2));
    addUIStyle("backgroundPosition", 0);
    addUIStyle("backgroundPositionY", this.backgroundPositionY);
  }
  
  @Property("backgroundRepeat")
  public void backgroundRepeat(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      removeUIStyle("backgroundRepeat");
      removeUIStyle("backgroundRepeatX");
      removeUIStyle("backgroundRepeatX");
      return;
    }
    if ("repeat".equals(paramString))
    {
      this.backgroundRepeatX = true;
      this.backgroundRepeatY = true;
    }
    for (;;)
    {
      addUIStyle("backgroundRepeatX", this.backgroundRepeatX);
      addUIStyle("backgroundRepeatY", this.backgroundRepeatY);
      return;
      if ("repeat-x".equals(paramString))
      {
        this.backgroundRepeatX = true;
        this.backgroundRepeatY = false;
      }
      else if ("repeat-y".equals(paramString))
      {
        this.backgroundRepeatX = false;
        this.backgroundRepeatY = true;
      }
      else if ("no-repeat".equals(paramString))
      {
        this.backgroundRepeatX = false;
        this.backgroundRepeatY = false;
      }
    }
  }
  
  @Property("backgroundSize")
  public void backgroundSize(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(" ");
      if ((paramString != null) && (paramString.length == 2))
      {
        this.backgroundSizeW = Float.parseFloat(paramString[0].substring(0, paramString[0].length() - 2));
        this.backgroundSizeH = Float.parseFloat(paramString[1].substring(0, paramString[1].length() - 2));
        addUIStyle("backgroundSizeW", this.backgroundSizeW);
        addUIStyle("backgroundSizeH", this.backgroundSizeH);
      }
    }
  }
  
  public JSONObject dumpNode(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject2 = super.dumpNode(paramJSONObject);
    label1111:
    label1625:
    label1882:
    for (;;)
    {
      Object localObject;
      int i;
      boolean bool1;
      boolean bool2;
      try
      {
        paramJSONObject = localJSONObject2.optJSONObject("attributes");
        localObject = paramJSONObject;
        if (paramJSONObject == null)
        {
          localObject = new JSONObject();
          localJSONObject2.put("attributes", localObject);
        }
        JSONObject localJSONObject1 = ((JSONObject)localObject).optJSONObject("style");
        paramJSONObject = localJSONObject1;
        if (localJSONObject1 == null)
        {
          paramJSONObject = new JSONObject();
          ((JSONObject)localObject).put("style", paramJSONObject);
        }
        if (this.mNode.getDisplay().equals(PDisplay.FLEX))
        {
          paramJSONObject.put("display", "flex");
          i = getUIStyles().getInt("scroll", 0);
          if (i != 2) {
            break label1111;
          }
          paramJSONObject.put("overflowX", "scroll");
          if (this.scrollMode != PullToRefreshBase.Mode.DISABLED) {
            paramJSONObject.put("refresh", this.pullLabel + " " + this.refreshingLabel + " " + this.releaseLabel);
          }
          if (!this.mNode.getJustifyContent().equals(PJustify.SPACE_BETWEEN)) {
            break label1129;
          }
          paramJSONObject.put("justifyContent", "space-between");
          if (!this.mNode.getAlignItems().equals(PAlign.CENTER)) {
            break label1256;
          }
          paramJSONObject.put("alignItems", "center");
          if (!this.mNode.getFlexDirection().equals(PFlexDirection.ROW)) {
            break label1466;
          }
          paramJSONObject.put("flexDirection", "row");
          if (this.flexWrap != null) {
            paramJSONObject.put("flexWrap", this.flexWrap);
          }
          i = getUIStyles().getInt("backgroundColor", 0);
          if (i != 0) {
            paramJSONObject.put("backgroundColor", String.format("#%06X", new Object[] { Integer.valueOf(0xFFFFFF & i) }));
          }
          localObject = getUIStyles().getString("backgroundImage", null);
          if (localObject != null) {
            paramJSONObject.put("backgroundImage", localObject);
          }
          bool1 = getUIStyles().getBoolean("backgroundRepeatX", false);
          bool2 = getUIStyles().getBoolean("backgroundRepeatY", false);
          if ((!bool1) || (!bool2)) {
            break label1562;
          }
          paramJSONObject.put("backgroundRepeat", "repeat");
          i = getUIStyles().getInt("backgroundPosition", 0);
          if (i != 51) {
            break label1625;
          }
          paramJSONObject.put("backgroundPosition", "left top");
          if (getUIStyles().get("borderWidth") != null) {
            break label1859;
          }
          localObject = null;
          if ((localObject != null) && (localObject.length == 4))
          {
            if ((localObject[0] == localObject[1]) && (localObject[0] == localObject[2]) && (localObject[0] == localObject[3]) && (localObject[0] > 0)) {
              paramJSONObject.put("borderWidth", Dimension.devicePx2RemPx(localObject[0]) + "px");
            }
            if (localObject[0] > 0) {
              paramJSONObject.put("borderTopWidth", Dimension.devicePx2RemPx(localObject[0]) + "px");
            }
            if (localObject[1] > 0) {
              paramJSONObject.put("borderRightWidth", Dimension.devicePx2RemPx(localObject[1]) + "px");
            }
            if (localObject[2] > 0) {
              paramJSONObject.put("borderBottomWidth", Dimension.devicePx2RemPx(localObject[2]) + "px");
            }
            if (localObject[3] > 0) {
              paramJSONObject.put("borderLeftWidth", Dimension.devicePx2RemPx(localObject[3]) + "px");
            }
          }
          if (getUIStyles().get("borderColor") != null) {
            break label1882;
          }
          localObject = null;
          if ((localObject != null) && (localObject.length == 4))
          {
            if ((localObject[0] == localObject[1]) && (localObject[0] == localObject[2]) && (localObject[0] == localObject[3]) && (localObject[0] > 0)) {
              paramJSONObject.put("borderColor", String.format("#%06X", new Object[] { Integer.valueOf(0xFFFFFF & localObject[0]) }));
            }
            if (localObject[0] > 0) {
              paramJSONObject.put("borderTopColor", String.format("#%06X", new Object[] { Integer.valueOf(0xFFFFFF & localObject[0]) }));
            }
            if (localObject[1] > 0) {
              paramJSONObject.put("borderRightColor", String.format("#%06X", new Object[] { Integer.valueOf(0xFFFFFF & localObject[1]) }));
            }
            if (localObject[2] > 0) {
              paramJSONObject.put("borderBottomColor", String.format("#%06X", new Object[] { Integer.valueOf(0xFFFFFF & localObject[2]) }));
            }
            if (localObject[3] > 0) {
              paramJSONObject.put("borderLeftColor", String.format("#%06X", new Object[] { Integer.valueOf(0xFFFFFF & localObject[3]) }));
            }
          }
          if (getUIStyles().get("roundRadius") != null) {
            break label1905;
          }
          i = 0;
          if (i > 0) {
            paramJSONObject.put("borderRadius", Dimension.devicePx2RemPx(i) + "px");
          }
          if (getChildCount() > 0)
          {
            paramJSONObject = new JSONArray();
            i = 0;
            if (i >= getChildCount()) {
              break;
            }
            paramJSONObject.put(((PElement)getChildAt(i)).dumpNode(null));
            i += 1;
            continue;
          }
        }
        else
        {
          if (!this.mNode.getDisplay().equals(PDisplay.NONE)) {
            continue;
          }
          paramJSONObject.put("display", "none");
          continue;
        }
        return localJSONObject2;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      label1256:
      if (i == 1)
      {
        paramJSONObject.put("overflowY", "scroll");
        continue;
        label1129:
        if (this.mNode.getJustifyContent().equals(PJustify.SPACE_AROUND))
        {
          paramJSONObject.put("justifyContent", "space-around");
        }
        else if (this.mNode.getJustifyContent().equals(PJustify.CENTER))
        {
          paramJSONObject.put("justifyContent", "center");
        }
        else if (this.mNode.getJustifyContent().equals(PJustify.FLEX_START))
        {
          paramJSONObject.put("justifyContent", "flex-start");
        }
        else if (this.mNode.getJustifyContent().equals(PJustify.FLEX_END))
        {
          paramJSONObject.put("justifyContent", "flex-end");
          continue;
          if (this.mNode.getAlignItems().equals(PAlign.STRETCH))
          {
            paramJSONObject.put("alignItems", "stretch");
          }
          else if ((this.mNode.getAlignItems().equals(PAlign.AUTO)) || (this.mNode.getAlignItems().equals(PAlign.FLEX_START)))
          {
            paramJSONObject.put("alignItems", "flex_start");
          }
          else if (this.mNode.getAlignItems().equals(PAlign.FLEX_END))
          {
            paramJSONObject.put("alignItems", "flex_end");
          }
          else if (this.mNode.getAlignItems().equals(PAlign.BASELINE))
          {
            paramJSONObject.put("alignItems", "baseline");
          }
          else if (this.mNode.getAlignItems().equals(PAlign.SPACE_BETWEEN))
          {
            paramJSONObject.put("alignItems", "space_between");
          }
          else if (this.mNode.getAlignItems().equals(PAlign.SPACE_AROUND))
          {
            paramJSONObject.put("alignItems", "space_around");
            continue;
            if (this.mNode.getFlexDirection().equals(PFlexDirection.ROW_REVERSE))
            {
              paramJSONObject.put("flexDirection", "row-reverse");
            }
            else if (this.mNode.getFlexDirection().equals(PFlexDirection.COLUMN))
            {
              paramJSONObject.put("flexDirection", "column");
            }
            else if (this.mNode.getFlexDirection().equals(PFlexDirection.COLUMN_REVERSE))
            {
              paramJSONObject.put("flexDirection", "column-reverse");
              continue;
              if ((bool1) && (!bool2))
              {
                paramJSONObject.put("backgroundRepeat", "repeat-x");
              }
              else if ((!bool1) && (bool2))
              {
                paramJSONObject.put("backgroundRepeat", "repeat-y");
              }
              else if ((!bool1) && (!bool2))
              {
                paramJSONObject.put("backgroundRepeat", "no-repeat");
                continue;
                if (i == 19)
                {
                  paramJSONObject.put("backgroundPosition", "left center");
                }
                else if (i == 83)
                {
                  paramJSONObject.put("backgroundPosition", "left bottom");
                }
                else if (i == 53)
                {
                  paramJSONObject.put("backgroundPosition", "right top");
                }
                else if (i == 21)
                {
                  paramJSONObject.put("backgroundPosition", "right center");
                }
                else if (i == 85)
                {
                  paramJSONObject.put("backgroundPosition", "right bottom");
                }
                else if (i == 49)
                {
                  paramJSONObject.put("backgroundPosition", "center top");
                }
                else if (i == 17)
                {
                  paramJSONObject.put("backgroundPosition", "center center");
                }
                else if (i == 81)
                {
                  paramJSONObject.put("backgroundPosition", "center bottom");
                }
                else if (i == 19)
                {
                  paramJSONObject.put("backgroundPosition", "left");
                }
                else if (i == 21)
                {
                  paramJSONObject.put("backgroundPosition", "right");
                }
                else if (i == 17)
                {
                  paramJSONObject.put("backgroundPosition", "center");
                }
                else if (i == 49)
                {
                  paramJSONObject.put("backgroundPosition", "top");
                }
                else if (i == 81)
                {
                  paramJSONObject.put("backgroundPosition", "bottom");
                  continue;
                  localObject = (int[])getUIStyles().get("borderWidth");
                  continue;
                  localObject = (int[])getUIStyles().get("borderColor");
                  continue;
                  label1905:
                  i = ((Integer)getUIStyles().get("roundRadius")).intValue();
                }
              }
            }
          }
        }
      }
    }
    label1466:
    label1859:
    localJSONObject2.put("children", paramJSONObject);
    label1562:
    return localJSONObject2;
  }
  
  @Property("flexDirection")
  public void flexDirection(String paramString)
  {
    setFlexDirection(paramString);
  }
  
  @Property("flexWrap")
  public void flexWrap(String paramString)
  {
    this.flexWrap = paramString;
    setWrap(paramString);
  }
  
  public String getElementType()
  {
    return "view";
  }
  
  @Property("justifyContent")
  public void justifyContent(String paramString)
  {
    setJustifyContent(paramString);
  }
  
  @Property("overflow")
  public void overflow(String paramString)
  {
    if ("scroll".equals(paramString)) {
      this.scroll = 1;
    }
    for (;;)
    {
      addUIStyle("scroll", this.scroll);
      return;
      if ("hidden".equals(paramString)) {
        this.scroll = 0;
      } else {
        this.scroll = 0;
      }
    }
  }
  
  @Property("overflowX")
  public void overflowX(String paramString)
  {
    if ("scroll".equals(paramString)) {}
    for (this.scroll = 2;; this.scroll = 0)
    {
      addUIStyle("scroll", this.scroll);
      return;
    }
  }
  
  @Property("overflowY")
  public void overflowY(String paramString)
  {
    if ("scroll".equals(paramString)) {}
    for (this.scroll = 1;; this.scroll = 0)
    {
      addUIStyle("scroll", this.scroll);
      return;
    }
  }
  
  @Property("refresh")
  public void refresh(String paramString)
  {
    this.scrollMode = PullToRefreshBase.Mode.PULL_FROM_START;
    paramString = paramString.split("\\s+");
    if (paramString.length == 3)
    {
      this.pullLabel = paramString[0];
      this.refreshingLabel = paramString[1];
      this.releaseLabel = paramString[2];
    }
  }
  
  public static class Provider
    implements IElement.IProvider<PDivElement, PDivView>
  {
    public PDivElement createElement(LayoutEngine paramLayoutEngine, int paramInt)
    {
      return new PDivElement(paramLayoutEngine, paramInt);
    }
    
    public PDivView createView()
    {
      return new PDivView();
    }
    
    public String getName()
    {
      return "view";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.element.PDivElement
 * JD-Core Version:    0.7.0.1
 */