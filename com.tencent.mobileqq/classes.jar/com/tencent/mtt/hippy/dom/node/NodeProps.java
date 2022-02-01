package com.tencent.mtt.hippy.dom.node;

import com.tencent.mtt.hippy.common.HippyMap;
import java.util.Arrays;
import java.util.HashSet;

public class NodeProps
{
  public static final String ALIGN_ITEMS = "alignItems";
  public static final String ALIGN_SELF = "alignSelf";
  public static final String BACKGROUND_COLOR = "backgroundColor";
  public static final String BACKGROUND_COLORS = "backgroundColors";
  public static final String BACKGROUND_IMAGE = "backgroundImage";
  public static final String BACKGROUND_POSITION_X = "backgroundPositionX";
  public static final String BACKGROUND_POSITION_Y = "backgroundPositionY";
  public static final String BACKGROUND_SIZE = "backgroundSize";
  public static final String BORDER_BOTTOM_COLOR = "borderBottomColor";
  public static final String BORDER_BOTTOM_LEFT_RADIUS = "borderBottomLeftRadius";
  public static final String BORDER_BOTTOM_RIGHT_RADIUS = "borderBottomRightRadius";
  public static final String BORDER_BOTTOM_WIDTH = "borderBottomWidth";
  public static final String BORDER_COLOR = "borderColor";
  public static final String BORDER_LEFT_COLOR = "borderLeftColor";
  public static final String BORDER_LEFT_WIDTH = "borderLeftWidth";
  public static final String BORDER_RADIUS = "borderRadius";
  public static final String BORDER_RIGHT_COLOR = "borderRightColor";
  public static final String BORDER_RIGHT_WIDTH = "borderRightWidth";
  public static final String BORDER_STYLES = "borderStyle";
  public static final String BORDER_TOP_COLOR = "borderTopColor";
  public static final String BORDER_TOP_LEFT_RADIUS = "borderTopLeftRadius";
  public static final String BORDER_TOP_RIGHT_RADIUS = "borderTopRightRadius";
  public static final String BORDER_TOP_WIDTH = "borderTopWidth";
  public static final String BORDER_WIDTH = "borderWidth";
  public static final String BOTTOM = "bottom";
  public static final String COLLAPSABLE = "collapsable";
  public static final String COLOR = "color";
  public static final String COLORS = "colors";
  public static final String CUSTOM_PROP = "customProp";
  public static final String CUSTOM_PROP_IMAGE_TYPE = "imageType";
  public static final String CUSTOM_PROP_ISGIF = "isGif";
  public static final String DISPLAY = "display";
  public static final String ELLIPSIZE_MODE = "ellipsizeMode";
  public static final String ENABLED = "enabled";
  public static final String FLEX = "flex";
  public static final String FLEX_BASIS = "flexBasis";
  public static final String FLEX_DIRECTION = "flexDirection";
  public static final String FLEX_GROW = "flexGrow";
  public static final String FLEX_SHRINK = "flexShrink";
  public static final String FLEX_WRAP = "flexWrap";
  public static final String FOCUSABLE = "focusable";
  public static final String FONT_FAMILY = "fontFamily";
  public static final String FONT_SIZE = "fontSize";
  public static final float FONT_SIZE_SP = 14.0F;
  public static final String FONT_STYLE = "fontStyle";
  public static final String FONT_WEIGHT = "fontWeight";
  public static final String GAUSSIAN_BLUR = "gaussianBlur";
  public static final String HEIGHT = "height";
  public static final String IMAGE_CLASS_NAME = "Image";
  public static final String JUSTIFY_CONTENT = "justifyContent";
  private static final HashSet<String> JUST_LAYOUT_PROPS = new HashSet(Arrays.asList(new String[] { "alignSelf", "alignItems", "collapsable", "flex", "flexDirection", "flexWrap", "justifyContent", "position", "right", "top", "bottom", "left", "width", "height", "minWidth", "maxWidth", "minHeight", "maxHeight", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom" }));
  public static final String LEFT = "left";
  public static final String LETTER_SPACING = "letterSpacing";
  public static final String LINE_HEIGHT = "lineHeight";
  public static final String MARGIN = "margin";
  public static final String MARGIN_BOTTOM = "marginBottom";
  public static final String MARGIN_HORIZONTAL = "marginHorizontal";
  public static final String MARGIN_LEFT = "marginLeft";
  public static final String MARGIN_RIGHT = "marginRight";
  public static final String MARGIN_TOP = "marginTop";
  public static final String MARGIN_VERTICAL = "marginVertical";
  public static final String MAX_HEIGHT = "maxHeight";
  public static final String MAX_WIDTH = "maxWidth";
  public static final String MIN_HEIGHT = "minHeight";
  public static final String MIN_WIDTH = "minWidth";
  public static final String NEXT_FOCUS_DOWN_ID = "nextFocusDownId";
  public static final String NEXT_FOCUS_LEFT_ID = "nextFocusLeftId";
  public static final String NEXT_FOCUS_RIGHT_ID = "nextFocusRightId";
  public static final String NEXT_FOCUS_UP_ID = "nextFocusUpId";
  public static final String NUMBER_OF_LINES = "numberOfLines";
  public static final String ON = "on";
  public static final String ON_ATTACHED_TO_WINDOW = "onAttachedToWindow";
  public static final String ON_CLICK = "onClick";
  public static final String ON_DETACHED_FROM_WINDOW = "onDetachedFromWindow";
  public static final String ON_INTERCEPT_PULL_UP_EVENT = "onInterceptPullUpEvent";
  public static final String ON_INTERCEPT_TOUCH_EVENT = "onInterceptTouchEvent";
  public static final String ON_LONG_CLICK = "onLongClick";
  public static final String ON_PRESS_IN = "onPressIn";
  public static final String ON_PRESS_OUT = "onPressOut";
  public static final String ON_TOUCH_CANCEL = "onTouchCancel";
  public static final String ON_TOUCH_DOWN = "onTouchDown";
  public static final String ON_TOUCH_END = "onTouchEnd";
  public static final String ON_TOUCH_MOVE = "onTouchMove";
  public static final String OPACITY = "opacity";
  public static final String OVERFLOW = "overflow";
  public static final String PADDING = "padding";
  public static final String PADDING_BOTTOM = "paddingBottom";
  public static final String PADDING_HORIZONTAL = "paddingHorizontal";
  public static final String PADDING_LEFT = "paddingLeft";
  public static final String PADDING_RIGHT = "paddingRight";
  public static final String PADDING_TOP = "paddingTop";
  public static final String PADDING_VERTICAL = "paddingVertical";
  public static final String POSITION = "position";
  public static final String PROPS = "props";
  public static final String PROP_ACCESSIBILITY_LABEL = "accessibilityLabel";
  public static final String REPEAT_COUNT = "repeatCount";
  public static final String REQUEST_FOCUS = "requestFocus";
  public static final String RESIZE_METHOD = "resizeMethod";
  public static final String RESIZE_MODE = "resizeMode";
  public static final String RIGHT = "right";
  public static final String ROOT_NODE = "RootNode";
  public static final String SHADOW_COLOR = "shadowColor";
  public static final String SHADOW_OFFSET = "shadowOffset";
  public static final String SHADOW_OFFSET_X = "shadowOffsetX";
  public static final String SHADOW_OFFSET_Y = "shadowOffsetY";
  public static final String SHADOW_OPACITY = "shadowOpacity";
  public static final String SHADOW_RADIUS = "shadowRadius";
  public static final String SHADOW_SPREAD = "shadowSpread";
  public static final String STYLE = "style";
  public static final String TEXT_ALIGN = "textAlign";
  public static final String TEXT_ALIGN_VERTICAL = "textAlignVertical";
  public static final String TEXT_CLASS_NAME = "Text";
  public static final String TEXT_DECORATION_LINE = "textDecorationLine";
  public static final String TOP = "top";
  private static final HashSet<String> TOUCH_EVENT_PROPS = new HashSet(Arrays.asList(new String[] { "onClick", "onLongClick", "onPressIn", "onPressOut", "onTouchCancel", "onTouchDown", "onTouchEnd", "onTouchMove" }));
  public static final String TRANSFORM = "transform";
  public static final String VIEW_CLASS_NAME = "View";
  public static final String VISIBLE = "visible";
  public static final String WIDTH = "width";
  public static final String Z_INDEX = "zIndex";
  
  public static boolean isJustLayout(HippyMap paramHippyMap, String paramString)
  {
    if (JUST_LAYOUT_PROPS.contains(paramString)) {
      return true;
    }
    int i = paramString.hashCode();
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool11 = false;
    boolean bool1 = false;
    switch (i)
    {
    default: 
      break;
    case 1349188574: 
      if (paramString.equals("borderRadius")) {
        i = 1;
      }
      break;
    case 741115130: 
      if (paramString.equals("borderWidth")) {
        i = 6;
      }
      break;
    case 529642498: 
      if (paramString.equals("overflow")) {
        i = 11;
      }
      break;
    case -223992013: 
      if (paramString.equals("borderLeftWidth")) {
        i = 7;
      }
      break;
    case -242276144: 
      if (paramString.equals("borderLeftColor")) {
        i = 2;
      }
      break;
    case -1267206133: 
      if (paramString.equals("opacity")) {
        i = 0;
      }
      break;
    case -1290574193: 
      if (paramString.equals("borderBottomWidth")) {
        i = 10;
      }
      break;
    case -1308858324: 
      if (paramString.equals("borderBottomColor")) {
        i = 5;
      }
      break;
    case -1452542531: 
      if (paramString.equals("borderTopWidth")) {
        i = 8;
      }
      break;
    case -1470826662: 
      if (paramString.equals("borderTopColor")) {
        i = 4;
      }
      break;
    case -1971292586: 
      if (paramString.equals("borderRightWidth")) {
        i = 9;
      }
      break;
    case -1989576717: 
      if (paramString.equals("borderRightColor")) {
        i = 3;
      }
      break;
    }
    i = -1;
    switch (i)
    {
    default: 
      return false;
    case 11: 
      if ((paramHippyMap.isNull("overflow")) || ("visible".equals(paramHippyMap.getString("overflow")))) {
        bool1 = true;
      }
      return bool1;
    case 10: 
      if (!paramHippyMap.isNull("borderBottomWidth"))
      {
        bool1 = bool2;
        if (paramHippyMap.getDouble("borderBottomWidth") != 0.0D) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    case 9: 
      if (!paramHippyMap.isNull("borderRightWidth"))
      {
        bool1 = bool3;
        if (paramHippyMap.getDouble("borderRightWidth") != 0.0D) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    case 8: 
      if (!paramHippyMap.isNull("borderTopWidth"))
      {
        bool1 = bool4;
        if (paramHippyMap.getDouble("borderTopWidth") != 0.0D) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    case 7: 
      if (!paramHippyMap.isNull("borderLeftWidth"))
      {
        bool1 = bool5;
        if (paramHippyMap.getDouble("borderLeftWidth") != 0.0D) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    case 6: 
      if (!paramHippyMap.isNull("borderWidth"))
      {
        bool1 = bool6;
        if (paramHippyMap.getDouble("borderWidth") != 0.0D) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    case 5: 
      bool1 = bool7;
      if (paramHippyMap.getInt("borderBottomColor") == 0) {
        bool1 = true;
      }
      return bool1;
    case 4: 
      bool1 = bool8;
      if (paramHippyMap.getInt("borderTopColor") == 0) {
        bool1 = true;
      }
      return bool1;
    case 3: 
      bool1 = bool9;
      if (paramHippyMap.getInt("borderRightColor") == 0) {
        bool1 = true;
      }
      return bool1;
    case 2: 
      bool1 = bool10;
      if (paramHippyMap.getInt("borderLeftColor") == 0) {
        bool1 = true;
      }
      return bool1;
    case 1: 
      if ((paramHippyMap.containsKey("backgroundColor")) && (paramHippyMap.getInt("backgroundColor") != 0)) {
        return false;
      }
      return (!paramHippyMap.containsKey("borderWidth")) || (paramHippyMap.isNull("borderWidth")) || (paramHippyMap.getDouble("borderWidth") == 0.0D);
    }
    if (!paramHippyMap.isNull("opacity"))
    {
      bool1 = bool11;
      if (paramHippyMap.getDouble("opacity") != 1.0D) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean isTouchEventProp(String paramString)
  {
    return TOUCH_EVENT_PROPS.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.NodeProps
 * JD-Core Version:    0.7.0.1
 */