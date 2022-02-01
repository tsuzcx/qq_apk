package com.tencent.viola.ui.dom.style;

public class Layout
{
  private static final int CSS_FLEX_DIRECTION_COLUMN;
  private static final int CSS_FLEX_DIRECTION_COLUMN_REVERSE;
  private static final int CSS_FLEX_DIRECTION_ROW;
  private static final int CSS_FLEX_DIRECTION_ROW_REVERSE;
  public static String TAG = "Layout";
  private static final int[] dim = { 1, 1, 0, 0 };
  private static final int[] leading;
  private static final int[] leadingSpacing = { 1, 3, 6, 6 };
  private static final int[] pos;
  private static final int[] trailing;
  private static final int[] trailingSpacing = { 3, 1, 7, 7 };
  
  static
  {
    CSS_FLEX_DIRECTION_COLUMN = FlexDirection.COLUMN.ordinal();
    CSS_FLEX_DIRECTION_COLUMN_REVERSE = FlexDirection.COLUMN_REVERSE.ordinal();
    CSS_FLEX_DIRECTION_ROW = FlexDirection.ROW.ordinal();
    CSS_FLEX_DIRECTION_ROW_REVERSE = FlexDirection.ROW_REVERSE.ordinal();
    leading = new int[] { 1, 3, 0, 2 };
    trailing = new int[] { 3, 1, 2, 0 };
    pos = new int[] { 1, 3, 0, 2 };
  }
  
  private static float boundAxis(FlexNode paramFlexNode, int paramInt, float paramFloat)
  {
    float f2 = (0.0F / 0.0F);
    float f1;
    if ((paramInt == CSS_FLEX_DIRECTION_COLUMN) || (paramInt == CSS_FLEX_DIRECTION_COLUMN_REVERSE))
    {
      f1 = paramFlexNode.flexStyle.minHeight;
      f2 = paramFlexNode.flexStyle.maxHeight;
    }
    for (;;)
    {
      float f3 = paramFloat;
      if (!Float.isNaN(f2))
      {
        f3 = paramFloat;
        if (f2 >= 0.0D)
        {
          f3 = paramFloat;
          if (paramFloat > f2) {
            f3 = f2;
          }
        }
      }
      paramFloat = f3;
      if (!Float.isNaN(f1))
      {
        paramFloat = f3;
        if (f1 >= 0.0D)
        {
          paramFloat = f3;
          if (f1 > f3) {
            paramFloat = f1;
          }
        }
      }
      return paramFloat;
      if ((paramInt == CSS_FLEX_DIRECTION_ROW) || (paramInt == CSS_FLEX_DIRECTION_ROW_REVERSE))
      {
        f1 = paramFlexNode.flexStyle.minWidth;
        f2 = paramFlexNode.flexStyle.maxWidth;
      }
      else
      {
        f1 = (0.0F / 0.0F);
      }
    }
  }
  
  private static FlexAlign getAlignItem(FlexNode paramFlexNode1, FlexNode paramFlexNode2)
  {
    if (paramFlexNode2.flexStyle.alignSelf != FlexAlign.AUTO) {
      return paramFlexNode2.flexStyle.alignSelf;
    }
    return paramFlexNode1.flexStyle.alignItems;
  }
  
  private static int getCrossFlexDirection(int paramInt, FlexLayoutDirection paramFlexLayoutDirection)
  {
    if ((paramInt == CSS_FLEX_DIRECTION_COLUMN) || (paramInt == CSS_FLEX_DIRECTION_COLUMN_REVERSE)) {
      return resolveAxis(CSS_FLEX_DIRECTION_ROW, paramFlexLayoutDirection);
    }
    return CSS_FLEX_DIRECTION_COLUMN;
  }
  
  private static int getFlexDirection(FlexNode paramFlexNode)
  {
    return paramFlexNode.flexStyle.flexDirection.ordinal();
  }
  
  private static float getRelativePosition(FlexNode paramFlexNode, int paramInt)
  {
    float f = paramFlexNode.flexStyle.position[leading[paramInt]];
    if (!Float.isNaN(f)) {
      return f;
    }
    f = paramFlexNode.flexStyle.position[trailing[paramInt]];
    if (Float.isNaN(f)) {
      return 0.0F;
    }
    return -f;
  }
  
  private static boolean isFlex(FlexNode paramFlexNode)
  {
    return (paramFlexNode.flexStyle.positionType == FlexPositionType.RELATIVE) && (paramFlexNode.flexStyle.flex > 0.0F);
  }
  
  private static boolean isMeasureDefined(FlexNode paramFlexNode)
  {
    return paramFlexNode.isMeasureDefined();
  }
  
  public static void layoutNode(FlexLayoutContext paramFlexLayoutContext, FlexNode paramFlexNode, float paramFloat, FlexLayoutDirection paramFlexLayoutDirection)
  {
    if (needsRelayout(paramFlexNode, paramFloat))
    {
      paramFlexNode.lastLayout.requestedWidth = paramFlexNode.flexLayout.dimensions[0];
      paramFlexNode.lastLayout.requestedHeight = paramFlexNode.flexLayout.dimensions[1];
      paramFlexNode.lastLayout.parentMaxWidth = paramFloat;
      layoutNodeImpl(paramFlexLayoutContext, paramFlexNode, paramFloat, paramFlexLayoutDirection);
      paramFlexNode.updateLastLayout(paramFlexNode.flexLayout);
    }
    for (;;)
    {
      paramFlexNode.markHasNewLayout();
      return;
      paramFlexNode.flexLayout.copy(paramFlexNode.lastLayout);
      paramFlexNode.updateLastLayout(paramFlexNode.lastLayout);
    }
  }
  
  private static void layoutNodeImpl(FlexLayoutContext paramFlexLayoutContext, FlexNode paramFlexNode, float paramFloat, FlexLayoutDirection paramFlexLayoutDirection)
  {
    int i = 0;
    int j = paramFlexNode.getChildCount();
    while (i < j)
    {
      if (paramFlexNode.getChildAt(i) != null) {
        paramFlexNode.getChildAt(i).flexLayout.resetResult();
      }
      i += 1;
    }
    if (!paramFlexNode.isShow()) {}
    FlexLayoutDirection localFlexLayoutDirection;
    int i14;
    int i15;
    int i16;
    int i6;
    float f13;
    float f1;
    label508:
    do
    {
      return;
      localFlexLayoutDirection = resolveDirection(paramFlexNode, paramFlexLayoutDirection);
      i14 = resolveAxis(getFlexDirection(paramFlexNode), localFlexLayoutDirection);
      i15 = getCrossFlexDirection(i14, localFlexLayoutDirection);
      i16 = resolveAxis(CSS_FLEX_DIRECTION_ROW, localFlexLayoutDirection);
      setDimensionFromStyle(paramFlexNode, i14);
      setDimensionFromStyle(paramFlexNode, i15);
      paramFlexNode.flexLayout.direction = localFlexLayoutDirection;
      paramFlexLayoutDirection = paramFlexNode.flexLayout.position;
      i = leading[i14];
      paramFlexLayoutDirection[i] += paramFlexNode.flexStyle.margin.getWithFallback(leadingSpacing[i14], leading[i14]) + getRelativePosition(paramFlexNode, i14);
      paramFlexLayoutDirection = paramFlexNode.flexLayout.position;
      i = trailing[i14];
      paramFlexLayoutDirection[i] += paramFlexNode.flexStyle.margin.getWithFallback(trailingSpacing[i14], trailing[i14]) + getRelativePosition(paramFlexNode, i14);
      paramFlexLayoutDirection = paramFlexNode.flexLayout.position;
      i = leading[i15];
      paramFlexLayoutDirection[i] += paramFlexNode.flexStyle.margin.getWithFallback(leadingSpacing[i15], leading[i15]) + getRelativePosition(paramFlexNode, i15);
      paramFlexLayoutDirection = paramFlexNode.flexLayout.position;
      i = trailing[i15];
      paramFlexLayoutDirection[i] += paramFlexNode.flexStyle.margin.getWithFallback(trailingSpacing[i15], trailing[i15]) + getRelativePosition(paramFlexNode, i15);
      i6 = paramFlexNode.getChildCount();
      f13 = paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[i16], leading[i16]) + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[i16], leading[i16]) + (paramFlexNode.flexStyle.padding.getWithFallback(trailingSpacing[i16], trailing[i16]) + paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[i16], trailing[i16]));
      if (!isMeasureDefined(paramFlexNode)) {
        break;
      }
      if (Float.isNaN(paramFlexNode.flexLayout.dimensions[dim[i16]])) {
        break label1459;
      }
      i = 1;
      if ((Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[i16]])) || (paramFlexNode.flexStyle.dimensions[dim[i16]] < 0.0D)) {
        break label1465;
      }
      f1 = paramFlexNode.flexStyle.dimensions[0];
      if (((!Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[i16]])) && (paramFlexNode.flexStyle.dimensions[dim[i16]] >= 0.0D)) || (i != 0)) {
        break label1541;
      }
      i = 1;
      if (((!Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[CSS_FLEX_DIRECTION_COLUMN]])) && (paramFlexNode.flexStyle.dimensions[dim[CSS_FLEX_DIRECTION_COLUMN]] >= 0.0D)) || (!Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[CSS_FLEX_DIRECTION_COLUMN]]))) {
        break label1547;
      }
      j = 1;
      if ((i != 0) || (j != 0))
      {
        paramFlexLayoutDirection = paramFlexNode.measure(paramFlexLayoutContext.measureOutput, f1 - f13);
        if (i != 0) {
          paramFlexNode.flexLayout.dimensions[0] = (paramFlexLayoutDirection.width + f13);
        }
        if (j != 0) {
          paramFlexNode.flexLayout.dimensions[1] = (paramFlexLayoutDirection.height + (paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[CSS_FLEX_DIRECTION_COLUMN], leading[CSS_FLEX_DIRECTION_COLUMN]) + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[CSS_FLEX_DIRECTION_COLUMN], leading[CSS_FLEX_DIRECTION_COLUMN]) + paramFlexNode.flexStyle.padding.getWithFallback(trailingSpacing[CSS_FLEX_DIRECTION_COLUMN], trailing[CSS_FLEX_DIRECTION_COLUMN]) + paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[CSS_FLEX_DIRECTION_COLUMN], trailing[CSS_FLEX_DIRECTION_COLUMN])));
        }
      }
    } while (i6 == 0);
    label556:
    label622:
    int i10;
    label806:
    FlexJustifyContent localFlexJustifyContent;
    float f5;
    float f11;
    float f12;
    int i7;
    label1119:
    int i8;
    label1142:
    int i11;
    label1161:
    Object localObject1;
    float f9;
    int i2;
    int i9;
    float f8;
    float f7;
    Object localObject6;
    Object localObject5;
    int i3;
    label1218:
    float f2;
    int k;
    int m;
    int i1;
    label1266:
    label1275:
    int n;
    Object localObject4;
    Object localObject3;
    float f3;
    int i5;
    int i4;
    Object localObject2;
    label1312:
    int i12;
    float f6;
    float f10;
    if (paramFlexNode.flexStyle.flexWrap == FlexWrap.WRAP)
    {
      i10 = 1;
      localFlexJustifyContent = paramFlexNode.flexStyle.justifyContent;
      float f14 = paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[i14], leading[i14]);
      float f15 = paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[i14], leading[i14]);
      f5 = paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[i15], leading[i15]) + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[i15], leading[i15]);
      f11 = paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[i14], leading[i14]) + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[i14], leading[i14]) + (paramFlexNode.flexStyle.padding.getWithFallback(trailingSpacing[i14], trailing[i14]) + paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[i14], trailing[i14]));
      f12 = paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[i15], leading[i15]) + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[i15], leading[i15]) + (paramFlexNode.flexStyle.padding.getWithFallback(trailingSpacing[i15], trailing[i15]) + paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[i15], trailing[i15]));
      if (Float.isNaN(paramFlexNode.flexLayout.dimensions[dim[i14]])) {
        break label1559;
      }
      i7 = 1;
      if (Float.isNaN(paramFlexNode.flexLayout.dimensions[dim[i15]])) {
        break label1565;
      }
      i8 = 1;
      if ((i14 != CSS_FLEX_DIRECTION_ROW) && (i14 != CSS_FLEX_DIRECTION_ROW_REVERSE)) {
        break label1571;
      }
      i11 = 1;
      localObject1 = null;
      f9 = (0.0F / 0.0F);
      if (i7 != 0) {
        f9 = paramFlexNode.flexLayout.dimensions[dim[i14]] - f11;
      }
      i = 0;
      i2 = 0;
      i9 = 0;
      f8 = 0.0F;
      f7 = 0.0F;
      localObject6 = null;
      localObject5 = null;
      i3 = 0;
      paramFlexLayoutDirection = null;
      if (i >= i6) {
        break label5563;
      }
      f2 = 0.0F;
      k = 0;
      f1 = 0.0F;
      m = 0;
      if (((i7 == 0) || (localFlexJustifyContent != FlexJustifyContent.FLEX_START)) && ((i7 != 0) || (localFlexJustifyContent == FlexJustifyContent.CENTER))) {
        break label1577;
      }
      i1 = 1;
      if (i1 == 0) {
        break label1583;
      }
      j = i6;
      n = 1;
      localObject4 = null;
      localObject3 = null;
      f3 = 0.0F;
      i5 = i;
      i4 = i3;
      f4 = f14 + f15;
      i = i6;
      localObject2 = paramFlexLayoutDirection;
      paramFlexLayoutDirection = (FlexLayoutDirection)localObject4;
      if (i4 >= i6) {
        break label7215;
      }
      localObject4 = paramFlexNode.getChildAt(i4);
      if (localObject4 == null) {
        break label1590;
      }
      if (((FlexNode)localObject4).isShow()) {
        break label1653;
      }
      localObject4 = localObject3;
      i12 = k;
      f6 = f4;
      k = n;
      i5 = i4 + 1;
      f10 = f3;
      localObject3 = localObject1;
      f4 = f2;
      n = i12;
      f3 = f1;
      localObject1 = paramFlexLayoutDirection;
      paramFlexLayoutDirection = (FlexLayoutDirection)localObject4;
      f2 = f6;
      f1 = f10;
    }
    for (;;)
    {
      i12 = i4 + 1;
      f6 = f4;
      f10 = f3;
      i4 = k;
      localObject4 = localObject1;
      localObject1 = localObject3;
      k = n;
      f3 = f1;
      f4 = f2;
      localObject3 = paramFlexLayoutDirection;
      paramFlexLayoutDirection = (FlexLayoutDirection)localObject4;
      n = i4;
      f1 = f10;
      f2 = f6;
      i4 = i12;
      break label1312;
      label1459:
      i = 0;
      break;
      label1465:
      if (i != 0)
      {
        f1 = paramFlexNode.flexLayout.dimensions[dim[i16]];
        break label508;
      }
      f1 = paramFloat - (paramFlexNode.flexStyle.margin.getWithFallback(leadingSpacing[i16], leading[i16]) + paramFlexNode.flexStyle.margin.getWithFallback(trailingSpacing[i16], trailing[i16]));
      break label508;
      label1541:
      i = 0;
      break label556;
      label1547:
      j = 0;
      break label622;
      i10 = 0;
      break label806;
      label1559:
      i7 = 0;
      break label1119;
      label1565:
      i8 = 0;
      break label1142;
      label1571:
      i11 = 0;
      break label1161;
      label1577:
      i1 = 0;
      break label1266;
      label1583:
      j = i3;
      break label1275;
      label1590:
      localObject4 = localObject3;
      i5 = k;
      localObject3 = localObject1;
      localObject1 = paramFlexLayoutDirection;
      k = n;
      f6 = f1;
      f10 = f2;
      i12 = i4 + 1;
      f1 = f3;
      f2 = f4;
      paramFlexLayoutDirection = (FlexLayoutDirection)localObject4;
      f3 = f6;
      n = i5;
      f4 = f10;
      i5 = i12;
    }
    label1653:
    ((FlexNode)localObject4).lineIndex = i9;
    ((FlexNode)localObject4).nextAbsoluteChild = null;
    ((FlexNode)localObject4).nextFlexChild = null;
    FlexAlign localFlexAlign = getAlignItem(paramFlexNode, (FlexNode)localObject4);
    label1934:
    Object localObject7;
    if ((localFlexAlign == FlexAlign.STRETCH) && (((FlexNode)localObject4).flexStyle.positionType == FlexPositionType.RELATIVE) && (i8 != 0) && ((Float.isNaN(localObject4.flexStyle.dimensions[dim[i15]])) || (localObject4.flexStyle.dimensions[dim[i15]] < 0.0D)))
    {
      ((FlexNode)localObject4).flexLayout.dimensions[dim[i15]] = Math.max(boundAxis((FlexNode)localObject4, i15, paramFlexNode.flexLayout.dimensions[dim[i15]] - f12 - (((FlexNode)localObject4).flexStyle.margin.getWithFallback(leadingSpacing[i15], leading[i15]) + ((FlexNode)localObject4).flexStyle.margin.getWithFallback(trailingSpacing[i15], trailing[i15]))), ((FlexNode)localObject4).flexStyle.padding.getWithFallback(leadingSpacing[i15], leading[i15]) + ((FlexNode)localObject4).flexStyle.border.getWithFallback(leadingSpacing[i15], leading[i15]) + (((FlexNode)localObject4).flexStyle.padding.getWithFallback(trailingSpacing[i15], trailing[i15]) + ((FlexNode)localObject4).flexStyle.border.getWithFallback(trailingSpacing[i15], trailing[i15])));
      if ((i7 == 0) || (!isFlex((FlexNode)localObject4))) {
        break label3015;
      }
      k += 1;
      f1 += ((FlexNode)localObject4).flexStyle.flex;
      localObject7 = paramFlexLayoutDirection;
      if (paramFlexLayoutDirection == null) {
        localObject7 = localObject4;
      }
      if (localObject3 != null) {
        ((FlexNode)localObject3).nextFlexChild = ((FlexNode)localObject4);
      }
      f6 = ((FlexNode)localObject4).flexStyle.padding.getWithFallback(leadingSpacing[i14], leading[i14]) + ((FlexNode)localObject4).flexStyle.border.getWithFallback(leadingSpacing[i14], leading[i14]) + (((FlexNode)localObject4).flexStyle.padding.getWithFallback(trailingSpacing[i14], trailing[i14]) + ((FlexNode)localObject4).flexStyle.border.getWithFallback(trailingSpacing[i14], trailing[i14])) + (((FlexNode)localObject4).flexStyle.margin.getWithFallback(leadingSpacing[i14], leading[i14]) + ((FlexNode)localObject4).flexStyle.margin.getWithFallback(trailingSpacing[i14], trailing[i14]));
      localObject3 = localObject4;
      i2 = m;
      paramFlexLayoutDirection = (FlexLayoutDirection)localObject7;
      label2145:
      if ((i10 == 0) || (i7 == 0) || (f2 + f6 <= f9) || (i4 == i3)) {
        break label3241;
      }
      m = i2 - 1;
      i2 = 1;
      localObject3 = localObject1;
      f6 = f1;
      label2190:
      if (i7 == 0) {
        break label3842;
      }
      f1 = f9 - f2;
    }
    label3842:
    label4116:
    for (;;)
    {
      label2202:
      if (k != 0)
      {
        float f16 = f1 / f6;
        localObject1 = paramFlexLayoutDirection;
        f2 = f1;
        for (;;)
        {
          if (localObject1 != null)
          {
            f10 = f2;
            f1 = f6;
            float f17;
            float f18;
            if (((FlexNode)localObject1).isShow())
            {
              f17 = ((FlexNode)localObject1).flexStyle.flex * f16 + (((FlexNode)localObject1).flexStyle.padding.getWithFallback(leadingSpacing[i14], leading[i14]) + ((FlexNode)localObject1).flexStyle.border.getWithFallback(leadingSpacing[i14], leading[i14]) + (((FlexNode)localObject1).flexStyle.padding.getWithFallback(trailingSpacing[i14], trailing[i14]) + ((FlexNode)localObject1).flexStyle.border.getWithFallback(trailingSpacing[i14], trailing[i14])));
              f18 = boundAxis((FlexNode)localObject1, i14, f17);
              f10 = f2;
              f1 = f6;
              if (f17 != f18)
              {
                f10 = f2 - f18;
                f1 = f6 - ((FlexNode)localObject1).flexStyle.flex;
              }
            }
            localObject1 = ((FlexNode)localObject1).nextFlexChild;
            f2 = f10;
            f6 = f1;
            continue;
            if (((FlexNode)localObject4).flexStyle.positionType != FlexPositionType.ABSOLUTE) {
              break label7212;
            }
            localObject7 = localObject2;
            if (localObject2 == null) {
              localObject7 = localObject4;
            }
            if (localObject1 != null) {
              ((FlexNode)localObject1).nextAbsoluteChild = ((FlexNode)localObject4);
            }
            i12 = 0;
            if (i12 >= 2) {
              break label7201;
            }
            label2474:
            int i17;
            float f19;
            float f20;
            float f21;
            float f22;
            if (i12 != 0)
            {
              i13 = CSS_FLEX_DIRECTION_ROW;
              if ((!Float.isNaN(paramFlexNode.flexLayout.dimensions[dim[i13]])) && ((Float.isNaN(localObject4.flexStyle.dimensions[dim[i13]])) || (localObject4.flexStyle.dimensions[dim[i13]] < 0.0D)) && (!Float.isNaN(localObject4.flexStyle.position[leading[i13]])) && (!Float.isNaN(localObject4.flexStyle.position[trailing[i13]])))
              {
                localObject1 = ((FlexNode)localObject4).flexLayout.dimensions;
                i17 = dim[i13];
                f16 = paramFlexNode.flexLayout.dimensions[dim[i13]];
                f17 = paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[i13], leading[i13]);
                f18 = paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[i13], leading[i13]);
                f19 = paramFlexNode.flexStyle.padding.getWithFallback(trailingSpacing[i13], trailing[i13]);
                f20 = paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[i13], trailing[i13]);
                f21 = ((FlexNode)localObject4).flexStyle.margin.getWithFallback(leadingSpacing[i13], leading[i13]);
                f22 = ((FlexNode)localObject4).flexStyle.margin.getWithFallback(trailingSpacing[i13], trailing[i13]);
                if (!Float.isNaN(localObject4.flexStyle.position[leading[i13]])) {
                  break label2975;
                }
                f6 = 0.0F;
                label2782:
                if (!Float.isNaN(localObject4.flexStyle.position[trailing[i13]])) {
                  break label2995;
                }
              }
            }
            label2975:
            label2995:
            for (f10 = 0.0F;; f10 = localObject4.flexStyle.position[trailing[i13]])
            {
              f6 = boundAxis((FlexNode)localObject4, i13, f16 - (f17 + f18 + (f19 + f20)) - (f21 + f22) - f6 - f10);
              f10 = ((FlexNode)localObject4).flexStyle.padding.getWithFallback(leadingSpacing[i13], leading[i13]);
              f16 = ((FlexNode)localObject4).flexStyle.border.getWithFallback(leadingSpacing[i13], leading[i13]);
              f17 = ((FlexNode)localObject4).flexStyle.padding.getWithFallback(trailingSpacing[i13], trailing[i13]);
              localObject1[i17] = Math.max(f6, ((FlexNode)localObject4).flexStyle.border.getWithFallback(trailingSpacing[i13], trailing[i13]) + f17 + (f10 + f16));
              i12 += 1;
              break;
              i13 = CSS_FLEX_DIRECTION_COLUMN;
              break label2474;
              f6 = localObject4.flexStyle.position[leading[i13]];
              break label2782;
            }
            label3015:
            f6 = (0.0F / 0.0F);
            if (i11 == 0) {
              if ((Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[i16]])) || (paramFlexNode.flexStyle.dimensions[dim[i16]] < 0.0D)) {
                break label3186;
              }
            }
            label3186:
            for (f6 = paramFlexNode.flexStyle.dimensions[dim[i16]] - f13;; f6 = paramFloat - (paramFlexNode.flexStyle.margin.getWithFallback(leadingSpacing[i16], leading[i16]) + paramFlexNode.flexStyle.margin.getWithFallback(trailingSpacing[i16], trailing[i16])) - f13)
            {
              if (i2 == 0) {
                layoutNode(paramFlexLayoutContext, (FlexNode)localObject4, f6, localFlexLayoutDirection);
              }
              if (((FlexNode)localObject4).flexStyle.positionType != FlexPositionType.RELATIVE) {
                break label7191;
              }
              i2 = m + 1;
              f6 = localObject4.flexLayout.dimensions[dim[i14]] + ((FlexNode)localObject4).flexStyle.margin.getWithFallback(leadingSpacing[i14], leading[i14]) + ((FlexNode)localObject4).flexStyle.margin.getWithFallback(trailingSpacing[i14], trailing[i14]);
              break;
            }
            label3241:
            i5 = j;
            m = i1;
            if (i1 != 0) {
              if (((FlexNode)localObject4).flexStyle.positionType == FlexPositionType.RELATIVE)
              {
                i5 = j;
                m = i1;
                if (((FlexNode)localObject4).flexStyle.positionType == FlexPositionType.RELATIVE)
                {
                  i5 = j;
                  m = i1;
                  if (((FlexNode)localObject4).flexStyle.flex <= 0.0F) {}
                }
              }
              else
              {
                m = 0;
                i5 = i4;
              }
            }
            j = i;
            i1 = n;
            if (n != 0) {
              if ((((FlexNode)localObject4).flexStyle.positionType == FlexPositionType.RELATIVE) && ((localFlexAlign == FlexAlign.STRETCH) || (localFlexAlign == FlexAlign.FLEX_START)))
              {
                j = i;
                i1 = n;
                if (!Float.isNaN(localObject4.flexStyle.dimensions[dim[i15]])) {}
              }
              else
              {
                i1 = 0;
                j = i4;
              }
            }
            if (m == 0) {
              break label7176;
            }
            localObject7 = ((FlexNode)localObject4).flexLayout.position;
            i = pos[i14];
            localObject7[i] += f4;
            if (i7 != 0) {
              ((FlexNode)localObject4).flexLayout.position[trailing[i14]] = (paramFlexNode.flexLayout.dimensions[dim[i14]] - localObject4.flexLayout.dimensions[dim[i14]] - localObject4.flexLayout.position[pos[i14]]);
            }
            f4 += localObject4.flexLayout.dimensions[dim[i14]] + ((FlexNode)localObject4).flexStyle.margin.getWithFallback(leadingSpacing[i14], leading[i14]) + ((FlexNode)localObject4).flexStyle.margin.getWithFallback(trailingSpacing[i14], trailing[i14]);
            f10 = Math.max(f3, boundAxis((FlexNode)localObject4, i15, localObject4.flexLayout.dimensions[dim[i15]] + ((FlexNode)localObject4).flexStyle.margin.getWithFallback(leadingSpacing[i15], leading[i15]) + ((FlexNode)localObject4).flexStyle.margin.getWithFallback(trailingSpacing[i15], trailing[i15])));
            f3 = f4;
            f4 = f10;
            label3652:
            if (i1 != 0)
            {
              localObject7 = ((FlexNode)localObject4).flexLayout.position;
              i = pos[i15];
              localObject7[i] += f7 + f5;
              if (i8 != 0) {
                ((FlexNode)localObject4).flexLayout.position[trailing[i15]] = (paramFlexNode.flexLayout.dimensions[dim[i15]] - localObject4.flexLayout.dimensions[dim[i15]] - localObject4.flexLayout.position[pos[i15]]);
              }
            }
            i12 = i4 + 1;
            localObject4 = localObject1;
            n = k;
            int i13 = 0;
            localObject1 = paramFlexLayoutDirection;
            k = i1;
            f10 = f1;
            f6 = f2 + f6;
            paramFlexLayoutDirection = (FlexLayoutDirection)localObject3;
            i = j;
            f1 = f4;
            f2 = f3;
            j = i5;
            i1 = m;
            m = i2;
            f3 = f10;
            f4 = f6;
            i2 = i13;
            i5 = i12;
            localObject3 = localObject4;
            break;
            f1 = Math.max(f2, 0.0F) - f2;
            break label2202;
          }
        }
        f1 = f2 / f6;
        f2 = f1;
        localObject1 = paramFlexLayoutDirection;
        if (f1 < 0.0F)
        {
          f2 = 0.0F;
          localObject1 = paramFlexLayoutDirection;
        }
        if (localObject1 != null)
        {
          if (((FlexNode)localObject1).isShow())
          {
            ((FlexNode)localObject1).flexLayout.dimensions[dim[i14]] = boundAxis((FlexNode)localObject1, i14, ((FlexNode)localObject1).flexStyle.flex * f2 + (((FlexNode)localObject1).flexStyle.padding.getWithFallback(leadingSpacing[i14], leading[i14]) + ((FlexNode)localObject1).flexStyle.border.getWithFallback(leadingSpacing[i14], leading[i14]) + (((FlexNode)localObject1).flexStyle.padding.getWithFallback(trailingSpacing[i14], trailing[i14]) + ((FlexNode)localObject1).flexStyle.border.getWithFallback(trailingSpacing[i14], trailing[i14]))));
            f1 = (0.0F / 0.0F);
            if ((Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[i16]])) || (paramFlexNode.flexStyle.dimensions[dim[i16]] < 0.0D)) {
              break label4116;
            }
            f1 = paramFlexNode.flexStyle.dimensions[dim[i16]] - f13;
          }
          for (;;)
          {
            layoutNode(paramFlexLayoutContext, (FlexNode)localObject1, f1, localFlexLayoutDirection);
            paramFlexLayoutDirection = ((FlexNode)localObject1).nextFlexChild;
            ((FlexNode)localObject1).nextFlexChild = null;
            localObject1 = paramFlexLayoutDirection;
            break;
            if (i11 == 0) {
              f1 = paramFloat - (paramFlexNode.flexStyle.margin.getWithFallback(leadingSpacing[i16], leading[i16]) + paramFlexNode.flexStyle.margin.getWithFallback(trailingSpacing[i16], trailing[i16])) - f13;
            }
          }
        }
        f1 = 0.0F;
        f2 = 0.0F;
        label4182:
        f4 += f2;
        f2 = f3;
        f3 = f4;
        label4197:
        if (j >= i5) {
          break label4768;
        }
        paramFlexLayoutDirection = paramFlexNode.getChildAt(j);
        if (paramFlexLayoutDirection == null) {
          break label7164;
        }
        if (paramFlexLayoutDirection.isShow()) {
          break label4370;
        }
      }
    }
    for (;;)
    {
      label4222:
      j += 1;
      break label4197;
      if (localFlexJustifyContent == FlexJustifyContent.FLEX_START) {
        break label7167;
      }
      if (localFlexJustifyContent == FlexJustifyContent.CENTER)
      {
        f2 = f1 / 2.0F;
        f1 = 0.0F;
        break;
      }
      if (localFlexJustifyContent == FlexJustifyContent.FLEX_END)
      {
        f2 = f1;
        f1 = 0.0F;
        break;
      }
      if (localFlexJustifyContent == FlexJustifyContent.SPACE_BETWEEN)
      {
        f1 = Math.max(f1, 0.0F);
        if (k + m - 1 != 0)
        {
          f1 /= (k + m - 1);
          f2 = 0.0F;
          break;
        }
        f1 = 0.0F;
        f2 = 0.0F;
        break;
      }
      if (localFlexJustifyContent != FlexJustifyContent.SPACE_AROUND) {
        break label7167;
      }
      if (k + m == 0) {}
      for (;;)
      {
        f2 = f1 / 2.0F;
        break;
        f1 /= (k + m);
      }
      label4370:
      if ((paramFlexLayoutDirection.flexStyle.positionType == FlexPositionType.ABSOLUTE) && (!Float.isNaN(paramFlexLayoutDirection.flexStyle.position[leading[i14]])))
      {
        localObject1 = paramFlexLayoutDirection.flexLayout.position;
        k = pos[i14];
        if (Float.isNaN(paramFlexLayoutDirection.flexStyle.position[leading[i14]])) {}
        for (f4 = 0.0F;; f4 = paramFlexLayoutDirection.flexStyle.position[leading[i14]])
        {
          localObject1[k] = (f4 + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[i14], leading[i14]) + paramFlexLayoutDirection.flexStyle.margin.getWithFallback(leadingSpacing[i14], leading[i14]));
          break;
        }
      }
      localObject1 = paramFlexLayoutDirection.flexLayout.position;
      k = pos[i14];
      localObject1[k] += f3;
      if (i7 != 0) {
        paramFlexLayoutDirection.flexLayout.position[trailing[i14]] = (paramFlexNode.flexLayout.dimensions[dim[i14]] - paramFlexLayoutDirection.flexLayout.dimensions[dim[i14]] - paramFlexLayoutDirection.flexLayout.position[pos[i14]]);
      }
      if (paramFlexLayoutDirection.flexStyle.positionType != FlexPositionType.RELATIVE) {
        break label7164;
      }
      f3 += paramFlexLayoutDirection.flexLayout.dimensions[dim[i14]] + paramFlexLayoutDirection.flexStyle.margin.getWithFallback(leadingSpacing[i14], leading[i14]) + paramFlexLayoutDirection.flexStyle.margin.getWithFallback(trailingSpacing[i14], trailing[i14]) + f1;
      f2 = Math.max(f2, boundAxis(paramFlexLayoutDirection, i15, paramFlexLayoutDirection.flexLayout.dimensions[dim[i15]] + paramFlexLayoutDirection.flexStyle.margin.getWithFallback(leadingSpacing[i15], leading[i15]) + paramFlexLayoutDirection.flexStyle.margin.getWithFallback(trailingSpacing[i15], trailing[i15])));
    }
    label4768:
    float f4 = paramFlexNode.flexLayout.dimensions[dim[i15]];
    if (i8 == 0)
    {
      f4 = Math.max(boundAxis(paramFlexNode, i15, f2 + f12), f12);
      label4807:
      localObject1 = localObject6;
      paramFlexLayoutDirection = (FlexLayoutDirection)localObject5;
      for (;;)
      {
        if (i < i5)
        {
          localObject4 = paramFlexNode.getChildAt(i);
          localObject5 = localObject1;
          localObject6 = paramFlexLayoutDirection;
          if (localObject4 != null)
          {
            if (!((FlexNode)localObject4).isShow())
            {
              localObject6 = paramFlexLayoutDirection;
              localObject5 = localObject1;
            }
          }
          else
          {
            label4856:
            i += 1;
            localObject1 = localObject5;
            paramFlexLayoutDirection = (FlexLayoutDirection)localObject6;
            continue;
          }
          if ((((FlexNode)localObject4).flexStyle.positionType == FlexPositionType.ABSOLUTE) && (!Float.isNaN(localObject4.flexStyle.position[leading[i15]])))
          {
            localObject5 = ((FlexNode)localObject4).flexLayout.position;
            j = pos[i15];
            if (Float.isNaN(localObject4.flexStyle.position[leading[i15]])) {}
            for (f1 = 0.0F;; f1 = localObject4.flexStyle.position[leading[i15]])
            {
              localObject5[j] = (f1 + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[i15], leading[i15]) + ((FlexNode)localObject4).flexStyle.margin.getWithFallback(leadingSpacing[i15], leading[i15]));
              localObject5 = localObject1;
              localObject6 = paramFlexLayoutDirection;
              break;
            }
          }
          if (((FlexNode)localObject4).flexStyle.positionType != FlexPositionType.RELATIVE) {
            break label7226;
          }
          localObject5 = getAlignItem(paramFlexNode, (FlexNode)localObject4);
          if (localObject5 == FlexAlign.STRETCH)
          {
            if (!Float.isNaN(localObject4.flexLayout.dimensions[dim[i15]])) {
              break label7226;
            }
            ((FlexNode)localObject4).flexLayout.dimensions[dim[i15]] = Math.max(boundAxis((FlexNode)localObject4, i15, f4 - f12 - (((FlexNode)localObject4).flexStyle.margin.getWithFallback(leadingSpacing[i15], leading[i15]) + ((FlexNode)localObject4).flexStyle.margin.getWithFallback(trailingSpacing[i15], trailing[i15]))), ((FlexNode)localObject4).flexStyle.padding.getWithFallback(leadingSpacing[i15], leading[i15]) + ((FlexNode)localObject4).flexStyle.border.getWithFallback(leadingSpacing[i15], leading[i15]) + (((FlexNode)localObject4).flexStyle.padding.getWithFallback(trailingSpacing[i15], trailing[i15]) + ((FlexNode)localObject4).flexStyle.border.getWithFallback(trailingSpacing[i15], trailing[i15])));
            if (paramFlexLayoutDirection == null)
            {
              f1 = f5;
              localObject1 = localObject4;
              paramFlexLayoutDirection = (FlexLayoutDirection)localObject4;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject5 = ((FlexNode)localObject4).flexLayout.position;
      j = pos[i15];
      localObject5[j] = (f1 + f7 + localObject5[j]);
      localObject5 = localObject1;
      localObject6 = paramFlexLayoutDirection;
      if (i8 == 0) {
        break label4856;
      }
      ((FlexNode)localObject4).flexLayout.position[trailing[i15]] = (paramFlexNode.flexLayout.dimensions[dim[i15]] - localObject4.flexLayout.dimensions[dim[i15]] - localObject4.flexLayout.position[pos[i15]]);
      localObject5 = localObject1;
      localObject6 = paramFlexLayoutDirection;
      break label4856;
      ((FlexNode)localObject1).nextMinHeightChild = ((FlexNode)localObject4);
      f1 = f5;
      localObject1 = localObject4;
      continue;
      if (localObject5 != FlexAlign.FLEX_START)
      {
        f1 = f4 - f12 - (localObject4.flexLayout.dimensions[dim[i15]] + ((FlexNode)localObject4).flexStyle.margin.getWithFallback(leadingSpacing[i15], leading[i15]) + ((FlexNode)localObject4).flexStyle.margin.getWithFallback(trailingSpacing[i15], trailing[i15]));
        if (localObject5 == FlexAlign.CENTER)
        {
          f1 = f1 / 2.0F + f5;
          continue;
        }
        f1 = f5 + f1;
        continue;
        f8 = Math.max(f8, f3);
        i9 += 1;
        f7 = f2 + f7;
        localObject6 = localObject1;
        localObject5 = paramFlexLayoutDirection;
        localObject1 = localObject3;
        i3 = i5;
        i = i5;
        paramFlexLayoutDirection = (FlexLayoutDirection)localObject2;
        break label1218;
        label5563:
        if ((i9 > 1) && (i8 != 0))
        {
          f3 = paramFlexNode.flexLayout.dimensions[dim[i15]] - f12;
          f4 = f3 - f7;
          f2 = 0.0F;
          paramFlexLayoutContext = paramFlexNode.flexStyle.alignContent;
          if (paramFlexLayoutContext == FlexAlign.FLEX_END)
          {
            paramFloat = f5 + f4;
            f1 = f2;
            i = 0;
            k = 0;
          }
          for (;;)
          {
            if (k >= i9) {
              break label6181;
            }
            f2 = 0.0F;
            j = i;
            for (;;)
            {
              if (j < i6)
              {
                paramFlexLayoutContext = paramFlexNode.getChildAt(j);
                f3 = f2;
                if (paramFlexLayoutContext != null)
                {
                  f3 = f2;
                  if (paramFlexLayoutContext.isShow())
                  {
                    if (paramFlexLayoutContext.flexStyle.positionType == FlexPositionType.RELATIVE) {
                      break label5776;
                    }
                    f3 = f2;
                  }
                }
                j += 1;
                f2 = f3;
                continue;
                if (paramFlexLayoutContext == FlexAlign.CENTER)
                {
                  paramFloat = f5 + f4 / 2.0F;
                  f1 = f2;
                  break;
                }
                f1 = f2;
                paramFloat = f5;
                if (paramFlexLayoutContext != FlexAlign.STRETCH) {
                  break;
                }
                f1 = f2;
                paramFloat = f5;
                if (f3 <= f7) {
                  break;
                }
                f1 = f4 / i9;
                paramFloat = f5;
                break;
                if (paramFlexLayoutContext.lineIndex == k) {
                  break label5839;
                }
              }
            }
            f2 += f1;
            if (i < j)
            {
              paramFlexLayoutContext = paramFlexNode.getChildAt(i);
              if ((paramFlexLayoutContext == null) || (!paramFlexLayoutContext.isShow()) || (paramFlexLayoutContext.flexStyle.positionType != FlexPositionType.RELATIVE)) {}
              for (;;)
              {
                i += 1;
                break label5792;
                label5839:
                f3 = f2;
                if (Float.isNaN(paramFlexLayoutContext.flexLayout.dimensions[dim[i15]])) {
                  break;
                }
                f3 = paramFlexLayoutContext.flexLayout.dimensions[dim[i15]];
                f4 = paramFlexLayoutContext.flexStyle.margin.getWithFallback(leadingSpacing[i15], leading[i15]);
                f3 = Math.max(f2, paramFlexLayoutContext.flexStyle.margin.getWithFallback(trailingSpacing[i15], trailing[i15]) + f4 + f3);
                break;
                localObject1 = getAlignItem(paramFlexNode, paramFlexLayoutContext);
                if (localObject1 == FlexAlign.FLEX_START)
                {
                  paramFlexLayoutContext.flexLayout.position[pos[i15]] = (paramFlexLayoutContext.flexStyle.margin.getWithFallback(leadingSpacing[i15], leading[i15]) + paramFloat);
                }
                else if (localObject1 == FlexAlign.FLEX_END)
                {
                  paramFlexLayoutContext.flexLayout.position[pos[i15]] = (paramFloat + f2 - paramFlexLayoutContext.flexStyle.margin.getWithFallback(trailingSpacing[i15], trailing[i15]) - paramFlexLayoutContext.flexStyle.dimensions[dim[i15]]);
                }
                else if (localObject1 == FlexAlign.CENTER)
                {
                  f3 = paramFlexLayoutContext.flexLayout.dimensions[dim[i15]];
                  paramFlexLayoutContext.flexLayout.position[pos[i15]] = ((f2 - f3) / 2.0F + paramFloat);
                }
                else if (localObject1 == FlexAlign.STRETCH)
                {
                  paramFlexLayoutContext.flexLayout.position[pos[i15]] = (paramFlexLayoutContext.flexStyle.margin.getWithFallback(leadingSpacing[i15], leading[i15]) + paramFloat);
                }
              }
            }
            paramFloat += f2;
            k += 1;
            i = j;
          }
        }
        label5776:
        label5792:
        label6181:
        j = 0;
        i = j;
        if (i7 == 0)
        {
          paramFlexNode.flexLayout.dimensions[dim[i14]] = Math.max(boundAxis(paramFlexNode, i14, paramFlexNode.flexStyle.padding.getWithFallback(trailingSpacing[i14], trailing[i14]) + paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[i14], trailing[i14]) + f8), f11);
          if (i14 != CSS_FLEX_DIRECTION_ROW_REVERSE)
          {
            i = j;
            if (i14 != CSS_FLEX_DIRECTION_COLUMN_REVERSE) {}
          }
          else
          {
            i = 1;
          }
        }
        if (i8 == 0)
        {
          paramFlexNode.flexLayout.dimensions[dim[i15]] = Math.max(boundAxis(paramFlexNode, i15, f7 + f12), f12);
          if ((i15 != CSS_FLEX_DIRECTION_ROW_REVERSE) && (i15 != CSS_FLEX_DIRECTION_COLUMN_REVERSE)) {}
        }
        for (j = 1;; j = 0)
        {
          if ((i != 0) || (j != 0))
          {
            k = 0;
            if (k < i6)
            {
              paramFlexLayoutContext = paramFlexNode.getChildAt(k);
              if ((paramFlexLayoutContext == null) || (!paramFlexLayoutContext.isShow())) {}
              for (;;)
              {
                k += 1;
                break;
                if (i != 0) {
                  paramFlexLayoutContext.flexLayout.position[trailing[i14]] = (paramFlexNode.flexLayout.dimensions[dim[i14]] - paramFlexLayoutContext.flexLayout.dimensions[dim[i14]] - paramFlexLayoutContext.flexLayout.position[pos[i14]]);
                }
                if (j != 0) {
                  paramFlexLayoutContext.flexLayout.position[trailing[i15]] = (paramFlexNode.flexLayout.dimensions[dim[i15]] - paramFlexLayoutContext.flexLayout.dimensions[dim[i15]] - paramFlexLayoutContext.flexLayout.position[pos[i15]]);
                }
              }
            }
          }
          for (paramFlexLayoutContext = paramFlexLayoutDirection; paramFlexLayoutContext != null; paramFlexLayoutContext = paramFlexLayoutDirection)
          {
            if (paramFlexLayoutContext.isShow())
            {
              i = 0;
              if (i < 2)
              {
                if (i != 0)
                {
                  j = CSS_FLEX_DIRECTION_ROW;
                  label6551:
                  if ((!Float.isNaN(paramFlexNode.flexLayout.dimensions[dim[j]])) && ((Float.isNaN(paramFlexLayoutContext.flexStyle.dimensions[dim[j]])) || (paramFlexLayoutContext.flexStyle.dimensions[dim[j]] < 0.0D)) && (!Float.isNaN(paramFlexLayoutContext.flexStyle.position[leading[j]])) && (!Float.isNaN(paramFlexLayoutContext.flexStyle.position[trailing[j]])))
                  {
                    paramFlexLayoutDirection = paramFlexLayoutContext.flexLayout.dimensions;
                    k = dim[j];
                    f2 = paramFlexNode.flexLayout.dimensions[dim[j]];
                    f3 = paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[j], leading[j]);
                    f4 = paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[j], trailing[j]);
                    f5 = paramFlexLayoutContext.flexStyle.margin.getWithFallback(leadingSpacing[j], leading[j]);
                    f6 = paramFlexLayoutContext.flexStyle.margin.getWithFallback(trailingSpacing[j], trailing[j]);
                    if (!Float.isNaN(paramFlexLayoutContext.flexStyle.position[leading[j]])) {
                      break label7085;
                    }
                    paramFloat = 0.0F;
                    if (!Float.isNaN(paramFlexLayoutContext.flexStyle.position[trailing[j]])) {
                      break label7103;
                    }
                    f1 = 0.0F;
                    label6824:
                    paramFlexLayoutDirection[k] = Math.max(boundAxis(paramFlexLayoutContext, j, f2 - (f3 + f4) - (f5 + f6) - paramFloat - f1), paramFlexLayoutContext.flexStyle.padding.getWithFallback(leadingSpacing[j], leading[j]) + paramFlexLayoutContext.flexStyle.border.getWithFallback(leadingSpacing[j], leading[j]) + (paramFlexLayoutContext.flexStyle.padding.getWithFallback(trailingSpacing[j], trailing[j]) + paramFlexLayoutContext.flexStyle.border.getWithFallback(trailingSpacing[j], trailing[j])));
                  }
                  label6801:
                  if ((!Float.isNaN(paramFlexLayoutContext.flexStyle.position[trailing[j]])) && (Float.isNaN(paramFlexLayoutContext.flexStyle.position[leading[j]])))
                  {
                    paramFlexLayoutDirection = paramFlexLayoutContext.flexLayout.position;
                    k = leading[j];
                    f1 = paramFlexNode.flexLayout.dimensions[dim[j]];
                    f2 = paramFlexLayoutContext.flexLayout.dimensions[dim[j]];
                    if (!Float.isNaN(paramFlexLayoutContext.flexStyle.position[trailing[j]])) {
                      break label7122;
                    }
                  }
                }
                label7085:
                label7103:
                label7122:
                for (paramFloat = 0.0F;; paramFloat = paramFlexLayoutContext.flexStyle.position[trailing[j]])
                {
                  paramFlexLayoutDirection[k] = (f1 - f2 - paramFloat);
                  i += 1;
                  break;
                  j = CSS_FLEX_DIRECTION_COLUMN;
                  break label6551;
                  paramFloat = paramFlexLayoutContext.flexStyle.position[leading[j]];
                  break label6801;
                  f1 = paramFlexLayoutContext.flexStyle.position[trailing[j]];
                  break label6824;
                }
              }
            }
            paramFlexLayoutDirection = paramFlexLayoutContext.nextAbsoluteChild;
            paramFlexLayoutContext.nextAbsoluteChild = null;
          }
          break;
        }
        break label4807;
        label7164:
        break label4222;
        label7167:
        f1 = 0.0F;
        f2 = 0.0F;
        break label4182;
        label7176:
        f10 = f4;
        f4 = f3;
        f3 = f10;
        break label3652;
        label7191:
        f6 = 0.0F;
        i2 = m;
        break label2145;
        label7201:
        localObject2 = localObject7;
        localObject1 = localObject4;
        break label1934;
        label7212:
        break label1934;
        label7215:
        f6 = f1;
        localObject3 = localObject1;
        break label2190;
      }
      label7226:
      f1 = f5;
    }
  }
  
  static boolean needsRelayout(FlexNode paramFlexNode, float paramFloat)
  {
    boolean bool = false;
    if ((paramFlexNode.isDirty()) || (!FloatUtils.floatsEqual(paramFlexNode.lastLayout.requestedHeight, paramFlexNode.flexLayout.dimensions[1])) || (!FloatUtils.floatsEqual(paramFlexNode.lastLayout.requestedWidth, paramFlexNode.flexLayout.dimensions[0])) || (!FloatUtils.floatsEqual(paramFlexNode.lastLayout.parentMaxWidth, paramFloat))) {
      bool = true;
    }
    return bool;
  }
  
  private static int resolveAxis(int paramInt, FlexLayoutDirection paramFlexLayoutDirection)
  {
    int i = paramInt;
    if (paramFlexLayoutDirection == FlexLayoutDirection.RTL)
    {
      if (paramInt != CSS_FLEX_DIRECTION_ROW) {
        break label22;
      }
      i = CSS_FLEX_DIRECTION_ROW_REVERSE;
    }
    label22:
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != CSS_FLEX_DIRECTION_ROW_REVERSE);
    return CSS_FLEX_DIRECTION_ROW;
  }
  
  private static FlexLayoutDirection resolveDirection(FlexNode paramFlexNode, FlexLayoutDirection paramFlexLayoutDirection)
  {
    paramFlexNode = paramFlexNode.flexStyle.direction;
    if (paramFlexNode == FlexLayoutDirection.INHERIT)
    {
      paramFlexNode = paramFlexLayoutDirection;
      if (paramFlexLayoutDirection == null) {
        paramFlexNode = FlexLayoutDirection.LTR;
      }
      return paramFlexNode;
    }
    return paramFlexNode;
  }
  
  private static void setDimensionFromStyle(FlexNode paramFlexNode, int paramInt)
  {
    if (!Float.isNaN(paramFlexNode.flexLayout.dimensions[dim[paramInt]])) {}
    do
    {
      return;
      if ((paramInt != 0) && (paramInt != 1)) {
        break;
      }
    } while (((Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[paramInt]])) && (Float.isNaN(paramFlexNode.flexStyle.minHeight)) && (Float.isNaN(paramFlexNode.flexStyle.maxHeight))) || (paramFlexNode.flexStyle.dimensions[dim[paramInt]] <= 0.0D));
    do
    {
      float f = Math.max(boundAxis(paramFlexNode, paramInt, paramFlexNode.flexStyle.dimensions[dim[paramInt]]), paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[paramInt], leading[paramInt]) + paramFlexNode.flexStyle.padding.getWithFallback(trailingSpacing[paramInt], trailing[paramInt]) + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[paramInt], leading[paramInt]) + paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[paramInt], trailing[paramInt]));
      paramFlexNode.flexLayout.dimensions[dim[paramInt]] = f;
      return;
      if ((Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[paramInt]])) && (Float.isNaN(paramFlexNode.flexStyle.minWidth)) && (Float.isNaN(paramFlexNode.flexStyle.maxWidth))) {
        break;
      }
    } while (paramFlexNode.flexStyle.dimensions[dim[paramInt]] > 0.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.Layout
 * JD-Core Version:    0.7.0.1
 */