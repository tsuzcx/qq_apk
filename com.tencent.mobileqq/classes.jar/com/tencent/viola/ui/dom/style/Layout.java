package com.tencent.viola.ui.dom.style;

public class Layout
{
  private static final int CSS_FLEX_DIRECTION_COLUMN = FlexDirection.COLUMN.ordinal();
  private static final int CSS_FLEX_DIRECTION_COLUMN_REVERSE = FlexDirection.COLUMN_REVERSE.ordinal();
  private static final int CSS_FLEX_DIRECTION_ROW = FlexDirection.ROW.ordinal();
  private static final int CSS_FLEX_DIRECTION_ROW_REVERSE = FlexDirection.ROW_REVERSE.ordinal();
  public static String TAG = "Layout";
  private static final int[] dim = { 1, 1, 0, 0 };
  private static final int[] leading = { 1, 3, 0, 2 };
  private static final int[] leadingSpacing = { 1, 3, 6, 6 };
  private static final int[] pos;
  private static final int[] trailing = { 3, 1, 2, 0 };
  private static final int[] trailingSpacing = { 3, 1, 7, 7 };
  
  static
  {
    pos = new int[] { 1, 3, 0, 2 };
  }
  
  private static float boundAxis(FlexNode paramFlexNode, int paramInt, float paramFloat)
  {
    int i = CSS_FLEX_DIRECTION_COLUMN;
    float f1 = (0.0F / 0.0F);
    float f2;
    if ((paramInt != i) && (paramInt != CSS_FLEX_DIRECTION_COLUMN_REVERSE))
    {
      if ((paramInt != CSS_FLEX_DIRECTION_ROW) && (paramInt != CSS_FLEX_DIRECTION_ROW_REVERSE))
      {
        f2 = (0.0F / 0.0F);
      }
      else
      {
        f1 = paramFlexNode.flexStyle.minWidth;
        f2 = paramFlexNode.flexStyle.maxWidth;
      }
    }
    else
    {
      f1 = paramFlexNode.flexStyle.minHeight;
      f2 = paramFlexNode.flexStyle.maxHeight;
    }
    if ((Float.isNaN(f2)) || (f2 < 0.0D) || (paramFloat <= f2)) {
      f2 = paramFloat;
    }
    paramFloat = f2;
    if (!Float.isNaN(f1))
    {
      paramFloat = f2;
      if (f1 >= 0.0D)
      {
        paramFloat = f2;
        if (f1 > f2) {
          paramFloat = f1;
        }
      }
    }
    return paramFloat;
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
    int i = CSS_FLEX_DIRECTION_COLUMN;
    if ((paramInt != i) && (paramInt != CSS_FLEX_DIRECTION_COLUMN_REVERSE)) {
      return i;
    }
    return resolveAxis(CSS_FLEX_DIRECTION_ROW, paramFlexLayoutDirection);
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
    else
    {
      paramFlexNode.flexLayout.copy(paramFlexNode.lastLayout);
      paramFlexNode.updateLastLayout(paramFlexNode.lastLayout);
    }
    paramFlexNode.markHasNewLayout();
  }
  
  private static void layoutNodeImpl(FlexLayoutContext paramFlexLayoutContext, FlexNode paramFlexNode, float paramFloat, FlexLayoutDirection paramFlexLayoutDirection)
  {
    int k = paramFlexNode.getChildCount();
    int i = 0;
    while (i < k)
    {
      if (paramFlexNode.getChildAt(i) != null) {
        paramFlexNode.getChildAt(i).flexLayout.resetResult();
      }
      i += 1;
    }
    if (!paramFlexNode.isShow()) {
      return;
    }
    Object localObject4 = resolveDirection(paramFlexNode, paramFlexLayoutDirection);
    int m = resolveAxis(getFlexDirection(paramFlexNode), (FlexLayoutDirection)localObject4);
    int i6 = getCrossFlexDirection(m, (FlexLayoutDirection)localObject4);
    int i12 = resolveAxis(CSS_FLEX_DIRECTION_ROW, (FlexLayoutDirection)localObject4);
    setDimensionFromStyle(paramFlexNode, m);
    setDimensionFromStyle(paramFlexNode, i6);
    paramFlexNode.flexLayout.direction = ((FlexLayoutDirection)localObject4);
    paramFlexLayoutDirection = paramFlexNode.flexLayout.position;
    i = leading[m];
    paramFlexLayoutDirection[i] += paramFlexNode.flexStyle.margin.getWithFallback(leadingSpacing[m], leading[m]) + getRelativePosition(paramFlexNode, m);
    paramFlexLayoutDirection = paramFlexNode.flexLayout.position;
    i = trailing[m];
    paramFlexLayoutDirection[i] += paramFlexNode.flexStyle.margin.getWithFallback(trailingSpacing[m], trailing[m]) + getRelativePosition(paramFlexNode, m);
    paramFlexLayoutDirection = paramFlexNode.flexLayout.position;
    i = leading[i6];
    paramFlexLayoutDirection[i] += paramFlexNode.flexStyle.margin.getWithFallback(leadingSpacing[i6], leading[i6]) + getRelativePosition(paramFlexNode, i6);
    paramFlexLayoutDirection = paramFlexNode.flexLayout.position;
    i = trailing[i6];
    paramFlexLayoutDirection[i] += paramFlexNode.flexStyle.margin.getWithFallback(trailingSpacing[i6], trailing[i6]) + getRelativePosition(paramFlexNode, i6);
    int i2 = paramFlexNode.getChildCount();
    float f7 = paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[i12], leading[i12]) + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[i12], leading[i12]) + (paramFlexNode.flexStyle.padding.getWithFallback(trailingSpacing[i12], trailing[i12]) + paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[i12], trailing[i12]));
    float f1;
    Object localObject1;
    float f2;
    float f4;
    if (isMeasureDefined(paramFlexNode))
    {
      boolean bool1 = Float.isNaN(paramFlexNode.flexLayout.dimensions[dim[i12]]) ^ true;
      if ((!Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[i12]])) && (paramFlexNode.flexStyle.dimensions[dim[i12]] >= 0.0D)) {
        f1 = paramFlexNode.flexStyle.dimensions[0];
      } else if (bool1) {
        f1 = paramFlexNode.flexLayout.dimensions[dim[i12]];
      } else {
        f1 = paramFloat - (paramFlexNode.flexStyle.margin.getWithFallback(leadingSpacing[i12], leading[i12]) + paramFlexNode.flexStyle.margin.getWithFallback(trailingSpacing[i12], trailing[i12]));
      }
      if (((Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[i12]])) || (paramFlexNode.flexStyle.dimensions[dim[i12]] < 0.0D)) && (!bool1)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (((Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[CSS_FLEX_DIRECTION_COLUMN]])) || (paramFlexNode.flexStyle.dimensions[dim[CSS_FLEX_DIRECTION_COLUMN]] < 0.0D)) && (Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[CSS_FLEX_DIRECTION_COLUMN]]))) {
        k = 1;
      } else {
        k = 0;
      }
      if ((bool1) || (k != 0))
      {
        localObject1 = paramFlexNode.measure(paramFlexLayoutContext.measureOutput, f1 - f7);
        if (bool1) {
          paramFlexNode.flexLayout.dimensions[0] = (((MeasureOutput)localObject1).width + f7);
        }
        if (k != 0)
        {
          paramFlexLayoutDirection = paramFlexNode.flexLayout.dimensions;
          f1 = ((MeasureOutput)localObject1).height;
          localObject1 = paramFlexNode.flexStyle.padding;
          localObject2 = leadingSpacing;
          j = CSS_FLEX_DIRECTION_COLUMN;
          f2 = ((StyleSpace)localObject1).getWithFallback(localObject2[j], leading[j]);
          localObject1 = paramFlexNode.flexStyle.border;
          localObject2 = leadingSpacing;
          j = CSS_FLEX_DIRECTION_COLUMN;
          f3 = ((StyleSpace)localObject1).getWithFallback(localObject2[j], leading[j]);
          localObject1 = paramFlexNode.flexStyle.padding;
          localObject2 = trailingSpacing;
          j = CSS_FLEX_DIRECTION_COLUMN;
          f4 = ((StyleSpace)localObject1).getWithFallback(localObject2[j], trailing[j]);
          localObject1 = paramFlexNode.flexStyle.border;
          localObject2 = trailingSpacing;
          j = CSS_FLEX_DIRECTION_COLUMN;
          paramFlexLayoutDirection[1] = (f1 + (f2 + f3 + f4 + ((StyleSpace)localObject1).getWithFallback(localObject2[j], trailing[j])));
        }
      }
      if (i2 == 0) {
        return;
      }
    }
    int i13;
    if (paramFlexNode.flexStyle.flexWrap == FlexWrap.WRAP) {
      i13 = 1;
    } else {
      i13 = 0;
    }
    Object localObject2 = paramFlexNode.flexStyle.justifyContent;
    float f15 = paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[m], leading[m]);
    float f16 = paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[m], leading[m]);
    float f3 = paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[i6], leading[i6]) + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[i6], leading[i6]);
    float f14 = paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[m], leading[m]) + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[m], leading[m]) + (paramFlexNode.flexStyle.padding.getWithFallback(trailingSpacing[m], trailing[m]) + paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[m], trailing[m]));
    float f6 = paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[i6], leading[i6]) + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[i6], leading[i6]) + (paramFlexNode.flexStyle.padding.getWithFallback(trailingSpacing[i6], trailing[i6]) + paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[i6], trailing[i6]));
    boolean bool3 = Float.isNaN(paramFlexNode.flexLayout.dimensions[dim[m]]) ^ true;
    boolean bool2 = Float.isNaN(paramFlexNode.flexLayout.dimensions[dim[i6]]) ^ true;
    if ((m != CSS_FLEX_DIRECTION_ROW) && (m != CSS_FLEX_DIRECTION_ROW_REVERSE)) {
      j = 0;
    } else {
      j = 1;
    }
    float f11;
    if (bool3) {
      f11 = paramFlexNode.flexLayout.dimensions[dim[m]] - f14;
    } else {
      f11 = (0.0F / 0.0F);
    }
    int i1 = 0;
    int i4 = 0;
    float f10 = 0.0F;
    k = 0;
    Object localObject3 = null;
    float f9 = 0.0F;
    paramFlexLayoutDirection = null;
    int n = 0;
    Object localObject9 = null;
    Object localObject6 = null;
    int i14 = j;
    int j = i2;
    float f5;
    for (;;)
    {
      Object localObject8 = paramFlexLayoutContext;
      if (i1 >= j) {
        break;
      }
      if (((bool3) && (localObject2 == FlexJustifyContent.FLEX_START)) || ((!bool3) && (localObject2 != FlexJustifyContent.CENTER))) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      if (i3 != 0) {
        i2 = j;
      } else {
        i2 = k;
      }
      int i5 = j;
      int i9 = i1;
      f4 = f15 + f16;
      int i16 = k;
      Object localObject5 = paramFlexLayoutDirection;
      i1 = i2;
      paramFlexLayoutDirection = null;
      i2 = 0;
      f2 = 0.0F;
      int i10 = 0;
      f5 = 0.0F;
      f1 = 0.0F;
      int i7 = 1;
      int i11 = n;
      Object localObject7 = null;
      n = i5;
      int i8 = i3;
      int i3 = i10;
      localObject1 = localObject3;
      i10 = k;
      int i15 = i4;
      i5 = j;
      k = i12;
      j = i6;
      i6 = i16;
      label1884:
      float f13;
      float f17;
      float f18;
      float f12;
      while (i6 < i5)
      {
        localObject3 = paramFlexNode.getChildAt(i6);
        if (localObject3 != null)
        {
          if (!((FlexNode)localObject3).isShow())
          {
            i4 = i6 + 1;
            i12 = i8;
            i16 = i1;
          }
          else
          {
            ((FlexNode)localObject3).lineIndex = i15;
            ((FlexNode)localObject3).nextAbsoluteChild = null;
            ((FlexNode)localObject3).nextFlexChild = null;
            Object localObject10 = getAlignItem(paramFlexNode, (FlexNode)localObject3);
            if (localObject10 == FlexAlign.STRETCH) {
              if ((((FlexNode)localObject3).flexStyle.positionType == FlexPositionType.RELATIVE) && (bool2))
              {
                if ((!Float.isNaN(localObject3.flexStyle.dimensions[dim[j]])) && (localObject3.flexStyle.dimensions[dim[j]] >= 0.0D)) {
                  break label1884;
                }
                ((FlexNode)localObject3).flexLayout.dimensions[dim[j]] = Math.max(boundAxis((FlexNode)localObject3, j, paramFlexNode.flexLayout.dimensions[dim[j]] - f6 - (((FlexNode)localObject3).flexStyle.margin.getWithFallback(leadingSpacing[j], leading[j]) + ((FlexNode)localObject3).flexStyle.margin.getWithFallback(trailingSpacing[j], trailing[j]))), ((FlexNode)localObject3).flexStyle.padding.getWithFallback(leadingSpacing[j], leading[j]) + ((FlexNode)localObject3).flexStyle.border.getWithFallback(leadingSpacing[j], leading[j]) + (((FlexNode)localObject3).flexStyle.padding.getWithFallback(trailingSpacing[j], trailing[j]) + ((FlexNode)localObject3).flexStyle.border.getWithFallback(trailingSpacing[j], trailing[j])));
                break label2481;
              }
              else {}
            }
            if (((FlexNode)localObject3).flexStyle.positionType == FlexPositionType.ABSOLUTE)
            {
              localObject8 = localObject1;
              if (localObject1 == null) {
                localObject8 = localObject3;
              }
              if (localObject5 != null) {
                ((FlexNode)localObject5).nextAbsoluteChild = ((FlexNode)localObject3);
              }
              i4 = 0;
              while (i4 < 2)
              {
                if (i4 != 0) {
                  i12 = CSS_FLEX_DIRECTION_ROW;
                } else {
                  i12 = CSS_FLEX_DIRECTION_COLUMN;
                }
                if ((!Float.isNaN(paramFlexNode.flexLayout.dimensions[dim[i12]])) && ((Float.isNaN(localObject3.flexStyle.dimensions[dim[i12]])) || (localObject3.flexStyle.dimensions[dim[i12]] < 0.0D)) && (!Float.isNaN(localObject3.flexStyle.position[leading[i12]])) && (!Float.isNaN(localObject3.flexStyle.position[trailing[i12]])))
                {
                  localObject1 = ((FlexNode)localObject3).flexLayout.dimensions;
                  i16 = dim[i12];
                  f13 = paramFlexNode.flexLayout.dimensions[dim[i12]];
                  f17 = paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[i12], leading[i12]);
                  f18 = paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[i12], leading[i12]);
                  float f19 = paramFlexNode.flexStyle.padding.getWithFallback(trailingSpacing[i12], trailing[i12]);
                  float f20 = paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[i12], trailing[i12]);
                  float f21 = ((FlexNode)localObject3).flexStyle.margin.getWithFallback(leadingSpacing[i12], leading[i12]);
                  float f22 = ((FlexNode)localObject3).flexStyle.margin.getWithFallback(trailingSpacing[i12], trailing[i12]);
                  if (Float.isNaN(localObject3.flexStyle.position[leading[i12]])) {
                    f8 = 0.0F;
                  } else {
                    f8 = localObject3.flexStyle.position[leading[i12]];
                  }
                  if (Float.isNaN(localObject3.flexStyle.position[trailing[i12]])) {
                    f12 = 0.0F;
                  } else {
                    f12 = localObject3.flexStyle.position[trailing[i12]];
                  }
                  localObject1[i16] = Math.max(boundAxis((FlexNode)localObject3, i12, f13 - (f17 + f18 + (f19 + f20)) - (f21 + f22) - f8 - f12), ((FlexNode)localObject3).flexStyle.padding.getWithFallback(leadingSpacing[i12], leading[i12]) + ((FlexNode)localObject3).flexStyle.border.getWithFallback(leadingSpacing[i12], leading[i12]) + (((FlexNode)localObject3).flexStyle.padding.getWithFallback(trailingSpacing[i12], trailing[i12]) + ((FlexNode)localObject3).flexStyle.border.getWithFallback(trailingSpacing[i12], trailing[i12])));
                }
                i4 += 1;
              }
              localObject5 = localObject3;
              localObject1 = localObject8;
            }
            label2481:
            i4 = k;
            localObject8 = localObject4;
            if ((bool3) && (isFlex((FlexNode)localObject3)))
            {
              i2 += 1;
              f2 += ((FlexNode)localObject3).flexStyle.flex;
              localObject4 = paramFlexLayoutDirection;
              if (paramFlexLayoutDirection == null) {
                localObject4 = localObject3;
              }
              if (localObject7 != null) {
                ((FlexNode)localObject7).nextFlexChild = ((FlexNode)localObject3);
              }
              f8 = ((FlexNode)localObject3).flexStyle.padding.getWithFallback(leadingSpacing[m], leading[m]) + ((FlexNode)localObject3).flexStyle.border.getWithFallback(leadingSpacing[m], leading[m]) + (((FlexNode)localObject3).flexStyle.padding.getWithFallback(trailingSpacing[m], trailing[m]) + ((FlexNode)localObject3).flexStyle.border.getWithFallback(trailingSpacing[m], trailing[m])) + (((FlexNode)localObject3).flexStyle.margin.getWithFallback(leadingSpacing[m], leading[m]) + ((FlexNode)localObject3).flexStyle.margin.getWithFallback(trailingSpacing[m], trailing[m]));
              localObject7 = localObject3;
              paramFlexLayoutDirection = (FlexLayoutDirection)localObject4;
            }
            else
            {
              if (i14 == 0)
              {
                if ((!Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[i4]])) && (paramFlexNode.flexStyle.dimensions[dim[i4]] >= 0.0D)) {
                  f8 = paramFlexNode.flexStyle.dimensions[dim[i4]];
                } else {
                  f8 = paramFloat - (paramFlexNode.flexStyle.margin.getWithFallback(leadingSpacing[i4], leading[i4]) + paramFlexNode.flexStyle.margin.getWithFallback(trailingSpacing[i4], trailing[i4]));
                }
                f8 -= f7;
              }
              else
              {
                f8 = (0.0F / 0.0F);
              }
              if (i11 == 0) {
                layoutNode(paramFlexLayoutContext, (FlexNode)localObject3, f8, (FlexLayoutDirection)localObject8);
              }
              if (((FlexNode)localObject3).flexStyle.positionType == FlexPositionType.RELATIVE)
              {
                i3 += 1;
                f8 = localObject3.flexLayout.dimensions[dim[m]] + ((FlexNode)localObject3).flexStyle.margin.getWithFallback(leadingSpacing[m], leading[m]) + ((FlexNode)localObject3).flexStyle.margin.getWithFallback(trailingSpacing[m], trailing[m]);
              }
              else
              {
                f8 = 0.0F;
              }
            }
            localObject4 = localObject8;
            localObject8 = paramFlexLayoutContext;
            if ((i13 != 0) && (bool3)) {
              if (f5 + f8 > f11)
              {
                if (i6 != i10)
                {
                  i3 -= 1;
                  i11 = 1;
                  localObject3 = localObject1;
                  f8 = f2;
                  break label3596;
                }
              }
              else {}
            }
            i11 = i6;
            i4 = i8;
            i9 = i1;
            if (i8 != 0) {
              if (((FlexNode)localObject3).flexStyle.positionType == FlexPositionType.RELATIVE)
              {
                i4 = i8;
                i9 = i1;
                if (((FlexNode)localObject3).flexStyle.positionType == FlexPositionType.RELATIVE)
                {
                  i4 = i8;
                  i9 = i1;
                  if (((FlexNode)localObject3).flexStyle.flex <= 0.0F) {}
                }
              }
              else
              {
                i9 = i11;
                i4 = 0;
              }
            }
            i8 = n;
            i1 = i7;
            if (i7 != 0) {
              if ((((FlexNode)localObject3).flexStyle.positionType == FlexPositionType.RELATIVE) && ((localObject10 == FlexAlign.STRETCH) || (localObject10 == FlexAlign.FLEX_START)))
              {
                i8 = n;
                i1 = i7;
                if (!Float.isNaN(localObject3.flexStyle.dimensions[dim[j]])) {}
              }
              else
              {
                i8 = i11;
                i1 = 0;
              }
            }
            if (i4 != 0)
            {
              localObject10 = ((FlexNode)localObject3).flexLayout.position;
              n = pos[m];
              localObject10[n] += f4;
              if (bool3) {
                ((FlexNode)localObject3).flexLayout.position[trailing[m]] = (paramFlexNode.flexLayout.dimensions[dim[m]] - localObject3.flexLayout.dimensions[dim[m]] - localObject3.flexLayout.position[pos[m]]);
              }
              f4 += localObject3.flexLayout.dimensions[dim[m]] + ((FlexNode)localObject3).flexStyle.margin.getWithFallback(leadingSpacing[m], leading[m]) + ((FlexNode)localObject3).flexStyle.margin.getWithFallback(trailingSpacing[m], trailing[m]);
              f1 = Math.max(f1, boundAxis((FlexNode)localObject3, j, localObject3.flexLayout.dimensions[dim[j]] + ((FlexNode)localObject3).flexStyle.margin.getWithFallback(leadingSpacing[j], leading[j]) + ((FlexNode)localObject3).flexStyle.margin.getWithFallback(trailingSpacing[j], trailing[j])));
            }
            if (i1 != 0)
            {
              localObject10 = ((FlexNode)localObject3).flexLayout.position;
              n = pos[j];
              localObject10[n] += f10 + f3;
              if (bool2) {
                ((FlexNode)localObject3).flexLayout.position[trailing[j]] = (paramFlexNode.flexLayout.dimensions[dim[j]] - localObject3.flexLayout.dimensions[dim[j]] - localObject3.flexLayout.position[pos[j]]);
              }
            }
            n = i11 + 1;
            i11 = 0;
            f5 = f8 + f5;
            i12 = i4;
            i4 = n;
            i16 = i9;
            n = i8;
            i7 = i1;
          }
        }
        else
        {
          i4 = i6 + 1;
          i16 = i1;
          i12 = i8;
        }
        i6 += 1;
        i8 = i12;
        i9 = i4;
        i1 = i16;
      }
      float f8 = f2;
      localObject3 = localObject1;
      label3596:
      if (bool3) {
        f2 = f11 - f5;
      } else {
        f2 = Math.max(f5, 0.0F) - f5;
      }
      if (i2 != 0)
      {
        f5 = f2 / f8;
        localObject1 = paramFlexLayoutDirection;
        f12 = f2;
        f2 = f5;
        while (localObject1 != null)
        {
          if (((FlexNode)localObject1).isShow())
          {
            f17 = ((FlexNode)localObject1).flexStyle.flex * f2 + (((FlexNode)localObject1).flexStyle.padding.getWithFallback(leadingSpacing[m], leading[m]) + ((FlexNode)localObject1).flexStyle.border.getWithFallback(leadingSpacing[m], leading[m]) + (((FlexNode)localObject1).flexStyle.padding.getWithFallback(trailingSpacing[m], trailing[m]) + ((FlexNode)localObject1).flexStyle.border.getWithFallback(trailingSpacing[m], trailing[m])));
            f18 = boundAxis((FlexNode)localObject1, m, f17);
            f5 = f12;
            f13 = f8;
            if (f17 != f18)
            {
              f5 = f12 - f18;
              f13 = f8 - ((FlexNode)localObject1).flexStyle.flex;
            }
          }
          else
          {
            f13 = f8;
            f5 = f12;
          }
          localObject1 = ((FlexNode)localObject1).nextFlexChild;
          f12 = f5;
          f8 = f13;
        }
        localObject1 = localObject5;
        f5 = f12 / f8;
        f2 = f5;
        if (f5 < 0.0F) {
          f2 = 0.0F;
        }
        while (paramFlexLayoutDirection != null)
        {
          if (paramFlexLayoutDirection.isShow())
          {
            paramFlexLayoutDirection.flexLayout.dimensions[dim[m]] = boundAxis(paramFlexLayoutDirection, m, paramFlexLayoutDirection.flexStyle.flex * f2 + (paramFlexLayoutDirection.flexStyle.padding.getWithFallback(leadingSpacing[m], leading[m]) + paramFlexLayoutDirection.flexStyle.border.getWithFallback(leadingSpacing[m], leading[m]) + (paramFlexLayoutDirection.flexStyle.padding.getWithFallback(trailingSpacing[m], trailing[m]) + paramFlexLayoutDirection.flexStyle.border.getWithFallback(trailingSpacing[m], trailing[m]))));
            if ((!Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[k]])) && (paramFlexNode.flexStyle.dimensions[dim[k]] >= 0.0D))
            {
              f5 = paramFlexNode.flexStyle.dimensions[dim[k]];
            }
            else
            {
              if (i14 != 0) {
                break label4124;
              }
              f5 = paramFloat - (paramFlexNode.flexStyle.margin.getWithFallback(leadingSpacing[k], leading[k]) + paramFlexNode.flexStyle.margin.getWithFallback(trailingSpacing[k], trailing[k]));
            }
            f5 -= f7;
            break label4128;
            label4124:
            f5 = (0.0F / 0.0F);
            label4128:
            layoutNode((FlexLayoutContext)localObject8, paramFlexLayoutDirection, f5, (FlexLayoutDirection)localObject4);
          }
          localObject5 = paramFlexLayoutDirection.nextFlexChild;
          paramFlexLayoutDirection.nextFlexChild = null;
          paramFlexLayoutDirection = (FlexLayoutDirection)localObject5;
        }
        f5 = f1;
      }
      else
      {
        paramFlexLayoutDirection = (FlexLayoutDirection)localObject5;
        localObject7 = FlexJustifyContent.FLEX_START;
        localObject5 = localObject2;
        f5 = f1;
        localObject1 = paramFlexLayoutDirection;
        if (localObject5 != localObject7)
        {
          if (localObject5 == FlexJustifyContent.CENTER) {
            f2 /= 2.0F;
          }
          while (localObject5 == FlexJustifyContent.FLEX_END)
          {
            f5 = f2;
            break;
          }
          if (localObject5 == FlexJustifyContent.SPACE_BETWEEN)
          {
            f2 = Math.max(f2, 0.0F);
            i2 = i2 + i3 - 1;
            f5 = f1;
            localObject1 = paramFlexLayoutDirection;
            if (i2 != 0)
            {
              f2 /= i2;
              f5 = 0.0F;
              localObject5 = paramFlexLayoutDirection;
              break label4347;
            }
          }
          else
          {
            f5 = f1;
            localObject1 = paramFlexLayoutDirection;
            if (localObject5 == FlexJustifyContent.SPACE_AROUND)
            {
              i2 += i3;
              if (i2 != 0) {
                f2 /= i2;
              }
              f5 = f2 / 2.0F;
              localObject5 = paramFlexLayoutDirection;
              break label4347;
            }
          }
        }
      }
      f2 = 0.0F;
      paramFlexLayoutDirection = (FlexLayoutDirection)localObject1;
      f1 = f5;
      f5 = f2;
      f2 = 0.0F;
      localObject5 = paramFlexLayoutDirection;
      label4347:
      f8 = f1;
      f1 = f4 + f5;
      f4 = f8;
      localObject7 = localObject2;
      while (i1 < i9)
      {
        paramFlexLayoutDirection = paramFlexNode.getChildAt(i1);
        if ((paramFlexLayoutDirection != null) && (paramFlexLayoutDirection.isShow()))
        {
          if ((paramFlexLayoutDirection.flexStyle.positionType == FlexPositionType.ABSOLUTE) && (!Float.isNaN(paramFlexLayoutDirection.flexStyle.position[leading[m]])))
          {
            localObject1 = paramFlexLayoutDirection.flexLayout.position;
            i2 = pos[m];
            if (Float.isNaN(paramFlexLayoutDirection.flexStyle.position[leading[m]])) {
              f5 = 0.0F;
            } else {
              f5 = paramFlexLayoutDirection.flexStyle.position[leading[m]];
            }
            localObject1[i2] = (f5 + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[m], leading[m]) + paramFlexLayoutDirection.flexStyle.margin.getWithFallback(leadingSpacing[m], leading[m]));
            f5 = f4;
            f8 = f1;
          }
          else
          {
            localObject1 = paramFlexLayoutDirection.flexLayout.position;
            i2 = pos[m];
            localObject1[i2] += f1;
            if (bool3) {
              paramFlexLayoutDirection.flexLayout.position[trailing[m]] = (paramFlexNode.flexLayout.dimensions[dim[m]] - paramFlexLayoutDirection.flexLayout.dimensions[dim[m]] - paramFlexLayoutDirection.flexLayout.position[pos[m]]);
            }
            f5 = f4;
            f8 = f1;
            if (paramFlexLayoutDirection.flexStyle.positionType == FlexPositionType.RELATIVE)
            {
              f8 = f1 + (f2 + (paramFlexLayoutDirection.flexLayout.dimensions[dim[m]] + paramFlexLayoutDirection.flexStyle.margin.getWithFallback(leadingSpacing[m], leading[m]) + paramFlexLayoutDirection.flexStyle.margin.getWithFallback(trailingSpacing[m], trailing[m])));
              f5 = Math.max(f4, boundAxis(paramFlexLayoutDirection, j, paramFlexLayoutDirection.flexLayout.dimensions[dim[j]] + paramFlexLayoutDirection.flexStyle.margin.getWithFallback(leadingSpacing[j], leading[j]) + paramFlexLayoutDirection.flexStyle.margin.getWithFallback(trailingSpacing[j], trailing[j])));
            }
          }
        }
        else
        {
          f8 = f1;
          f5 = f4;
        }
        i1 += 1;
        f4 = f5;
        f1 = f8;
      }
      f2 = paramFlexNode.flexLayout.dimensions[dim[j]];
      if (!bool2) {
        f2 = Math.max(boundAxis(paramFlexNode, j, f4 + f6), f6);
      }
      paramFlexLayoutDirection = (FlexLayoutDirection)localObject6;
      localObject1 = localObject9;
      i1 = i9;
      while (n < i1)
      {
        localObject8 = paramFlexNode.getChildAt(n);
        if ((localObject8 != null) && (((FlexNode)localObject8).isShow()))
        {
          if ((((FlexNode)localObject8).flexStyle.positionType == FlexPositionType.ABSOLUTE) && (!Float.isNaN(localObject8.flexStyle.position[leading[j]])))
          {
            localObject2 = ((FlexNode)localObject8).flexLayout.position;
            i2 = pos[j];
            if (Float.isNaN(localObject8.flexStyle.position[leading[j]])) {
              f5 = 0.0F;
            } else {
              f5 = localObject8.flexStyle.position[leading[j]];
            }
            localObject2[i2] = (f5 + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[j], leading[j]) + ((FlexNode)localObject8).flexStyle.margin.getWithFallback(leadingSpacing[j], leading[j]));
            localObject2 = paramFlexLayoutDirection;
            localObject6 = localObject1;
          }
          else
          {
            if (((FlexNode)localObject8).flexStyle.positionType == FlexPositionType.RELATIVE)
            {
              localObject9 = getAlignItem(paramFlexNode, (FlexNode)localObject8);
              if (localObject9 == FlexAlign.STRETCH)
              {
                if (Float.isNaN(localObject8.flexLayout.dimensions[dim[j]]))
                {
                  ((FlexNode)localObject8).flexLayout.dimensions[dim[j]] = Math.max(boundAxis((FlexNode)localObject8, j, f2 - f6 - (((FlexNode)localObject8).flexStyle.margin.getWithFallback(leadingSpacing[j], leading[j]) + ((FlexNode)localObject8).flexStyle.margin.getWithFallback(trailingSpacing[j], trailing[j]))), ((FlexNode)localObject8).flexStyle.padding.getWithFallback(leadingSpacing[j], leading[j]) + ((FlexNode)localObject8).flexStyle.border.getWithFallback(leadingSpacing[j], leading[j]) + (((FlexNode)localObject8).flexStyle.padding.getWithFallback(trailingSpacing[j], trailing[j]) + ((FlexNode)localObject8).flexStyle.border.getWithFallback(trailingSpacing[j], trailing[j])));
                  if (localObject1 == null)
                  {
                    localObject2 = localObject8;
                    localObject6 = localObject2;
                    break label5456;
                  }
                  paramFlexLayoutDirection.nextMinHeightChild = ((FlexNode)localObject8);
                  localObject2 = localObject8;
                  localObject6 = localObject1;
                  break label5456;
                }
              }
              else
              {
                localObject2 = paramFlexLayoutDirection;
                localObject6 = localObject1;
                if (localObject9 == FlexAlign.FLEX_START) {
                  break label5456;
                }
                f8 = f2 - f6 - (localObject8.flexLayout.dimensions[dim[j]] + ((FlexNode)localObject8).flexStyle.margin.getWithFallback(leadingSpacing[j], leading[j]) + ((FlexNode)localObject8).flexStyle.margin.getWithFallback(trailingSpacing[j], trailing[j]));
                f5 = f8;
                if (localObject9 == FlexAlign.CENTER) {
                  f5 = f8 / 2.0F;
                }
                f5 = f3 + f5;
                break label5467;
              }
            }
            localObject6 = localObject1;
            localObject2 = paramFlexLayoutDirection;
            label5456:
            f5 = f3;
            localObject1 = localObject6;
            paramFlexLayoutDirection = (FlexLayoutDirection)localObject2;
            label5467:
            localObject2 = ((FlexNode)localObject8).flexLayout.position;
            i2 = pos[j];
            localObject2[i2] += f10 + f5;
            localObject2 = paramFlexLayoutDirection;
            localObject6 = localObject1;
            if (bool2)
            {
              ((FlexNode)localObject8).flexLayout.position[trailing[j]] = (paramFlexNode.flexLayout.dimensions[dim[j]] - localObject8.flexLayout.dimensions[dim[j]] - localObject8.flexLayout.position[pos[j]]);
              localObject2 = paramFlexLayoutDirection;
              localObject6 = localObject1;
            }
          }
        }
        else
        {
          localObject6 = localObject1;
          localObject2 = paramFlexLayoutDirection;
        }
        n += 1;
        paramFlexLayoutDirection = (FlexLayoutDirection)localObject2;
        localObject1 = localObject6;
      }
      f10 += f4;
      f9 = Math.max(f9, f1);
      i4 = i15 + 1;
      n = i1;
      localObject2 = localObject7;
      localObject6 = paramFlexLayoutDirection;
      i6 = j;
      i12 = k;
      j = i5;
      k = n;
      paramFlexLayoutDirection = (FlexLayoutDirection)localObject5;
      n = i11;
      localObject9 = localObject1;
    }
    n = j;
    if (i4 > 1)
    {
      n = j;
      if (bool2)
      {
        f1 = paramFlexNode.flexLayout.dimensions[dim[i6]] - f6;
        paramFloat = f1 - f10;
        paramFlexLayoutContext = paramFlexNode.flexStyle.alignContent;
        if (paramFlexLayoutContext == FlexAlign.FLEX_END) {}
        for (f1 = f3 + paramFloat;; f1 = f3)
        {
          paramFloat = 0.0F;
          break label5789;
          if (paramFlexLayoutContext == FlexAlign.CENTER)
          {
            paramFloat /= 2.0F;
            break;
          }
          if ((paramFlexLayoutContext == FlexAlign.STRETCH) && (f1 > f10))
          {
            paramFloat /= i4;
            f1 = f3;
            break label5789;
          }
        }
        label5789:
        i1 = 0;
        n = 0;
        k = j;
        j = n;
        for (;;)
        {
          n = k;
          if (i1 >= i4) {
            break;
          }
          n = j;
          f2 = 0.0F;
          while (n < k)
          {
            paramFlexLayoutContext = paramFlexNode.getChildAt(n);
            if ((paramFlexLayoutContext != null) && (paramFlexLayoutContext.isShow()) && (paramFlexLayoutContext.flexStyle.positionType == FlexPositionType.RELATIVE))
            {
              if (paramFlexLayoutContext.lineIndex != i1) {
                break;
              }
              if (!Float.isNaN(paramFlexLayoutContext.flexLayout.dimensions[dim[i6]])) {
                f2 = Math.max(f2, paramFlexLayoutContext.flexLayout.dimensions[dim[i6]] + (paramFlexLayoutContext.flexStyle.margin.getWithFallback(leadingSpacing[i6], leading[i6]) + paramFlexLayoutContext.flexStyle.margin.getWithFallback(trailingSpacing[i6], trailing[i6])));
              }
            }
            n += 1;
          }
          f2 += paramFloat;
          i2 = j;
          j = n;
          while (i2 < j)
          {
            paramFlexLayoutContext = paramFlexNode.getChildAt(i2);
            if ((paramFlexLayoutContext != null) && (paramFlexLayoutContext.isShow()) && (paramFlexLayoutContext.flexStyle.positionType == FlexPositionType.RELATIVE))
            {
              paramFlexLayoutDirection = getAlignItem(paramFlexNode, paramFlexLayoutContext);
              if (paramFlexLayoutDirection == FlexAlign.FLEX_START)
              {
                paramFlexLayoutContext.flexLayout.position[pos[i6]] = (paramFlexLayoutContext.flexStyle.margin.getWithFallback(leadingSpacing[i6], leading[i6]) + f1);
              }
              else if (paramFlexLayoutDirection == FlexAlign.FLEX_END)
              {
                paramFlexLayoutContext.flexLayout.position[pos[i6]] = (f1 + f2 - paramFlexLayoutContext.flexStyle.margin.getWithFallback(trailingSpacing[i6], trailing[i6]) - paramFlexLayoutContext.flexStyle.dimensions[dim[i6]]);
              }
              else if (paramFlexLayoutDirection == FlexAlign.CENTER)
              {
                f3 = paramFlexLayoutContext.flexLayout.dimensions[dim[i6]];
                paramFlexLayoutContext.flexLayout.position[pos[i6]] = ((f2 - f3) / 2.0F + f1);
              }
              else if (paramFlexLayoutDirection == FlexAlign.STRETCH)
              {
                paramFlexLayoutContext.flexLayout.position[pos[i6]] = (paramFlexLayoutContext.flexStyle.margin.getWithFallback(leadingSpacing[i6], leading[i6]) + f1);
              }
            }
            i2 += 1;
          }
          f1 += f2;
          i1 += 1;
        }
      }
    }
    if (!bool3)
    {
      paramFlexLayoutContext = paramFlexNode.flexLayout.dimensions;
      k = dim[m];
      paramFloat = paramFlexNode.flexStyle.padding.getWithFallback(trailingSpacing[m], trailing[m]);
      f1 = paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[m], trailing[m]);
      j = m;
      paramFlexLayoutContext[k] = Math.max(boundAxis(paramFlexNode, j, paramFloat + f1 + f9), f14);
      if ((j == CSS_FLEX_DIRECTION_ROW_REVERSE) || (j == CSS_FLEX_DIRECTION_COLUMN_REVERSE))
      {
        j = 1;
        break label6393;
      }
    }
    j = 0;
    label6393:
    i1 = m;
    if (!bool2)
    {
      paramFlexNode.flexLayout.dimensions[dim[i6]] = Math.max(boundAxis(paramFlexNode, i6, f10 + f6), f6);
      if ((i6 == CSS_FLEX_DIRECTION_ROW_REVERSE) || (i6 == CSS_FLEX_DIRECTION_COLUMN_REVERSE))
      {
        k = 1;
        break label6457;
      }
    }
    k = 0;
    label6457:
    if ((j != 0) || (k != 0))
    {
      m = 0;
      while (m < n)
      {
        paramFlexLayoutContext = paramFlexNode.getChildAt(m);
        if ((paramFlexLayoutContext != null) && (paramFlexLayoutContext.isShow()))
        {
          if (j != 0) {
            paramFlexLayoutContext.flexLayout.position[trailing[i1]] = (paramFlexNode.flexLayout.dimensions[dim[i1]] - paramFlexLayoutContext.flexLayout.dimensions[dim[i1]] - paramFlexLayoutContext.flexLayout.position[pos[i1]]);
          }
          if (k != 0) {
            paramFlexLayoutContext.flexLayout.position[trailing[i6]] = (paramFlexNode.flexLayout.dimensions[dim[i6]] - paramFlexLayoutContext.flexLayout.dimensions[dim[i6]] - paramFlexLayoutContext.flexLayout.position[pos[i6]]);
          }
        }
        m += 1;
      }
    }
    for (paramFlexLayoutContext = (FlexLayoutContext)localObject3; paramFlexLayoutContext != null; paramFlexLayoutContext = paramFlexLayoutDirection)
    {
      if (paramFlexLayoutContext.isShow())
      {
        j = 0;
        while (j < 2)
        {
          if (j != 0) {
            k = CSS_FLEX_DIRECTION_ROW;
          } else {
            k = CSS_FLEX_DIRECTION_COLUMN;
          }
          if (!Float.isNaN(paramFlexNode.flexLayout.dimensions[dim[k]]))
          {
            if (!Float.isNaN(paramFlexLayoutContext.flexStyle.dimensions[dim[k]])) {
              if (paramFlexLayoutContext.flexStyle.dimensions[dim[k]] >= 0.0D) {
                break label7113;
              }
            }
            if ((!Float.isNaN(paramFlexLayoutContext.flexStyle.position[leading[k]])) && (!Float.isNaN(paramFlexLayoutContext.flexStyle.position[trailing[k]])))
            {
              paramFlexLayoutDirection = paramFlexLayoutContext.flexLayout.dimensions;
              m = dim[k];
              f2 = paramFlexNode.flexLayout.dimensions[dim[k]];
              f3 = paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[k], leading[k]);
              f4 = paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[k], trailing[k]);
              f5 = paramFlexLayoutContext.flexStyle.margin.getWithFallback(leadingSpacing[k], leading[k]);
              f6 = paramFlexLayoutContext.flexStyle.margin.getWithFallback(trailingSpacing[k], trailing[k]);
              if (Float.isNaN(paramFlexLayoutContext.flexStyle.position[leading[k]])) {
                paramFloat = 0.0F;
              } else {
                paramFloat = paramFlexLayoutContext.flexStyle.position[leading[k]];
              }
              if (Float.isNaN(paramFlexLayoutContext.flexStyle.position[trailing[k]])) {
                f1 = 0.0F;
              } else {
                f1 = paramFlexLayoutContext.flexStyle.position[trailing[k]];
              }
              paramFlexLayoutDirection[m] = Math.max(boundAxis(paramFlexLayoutContext, k, f2 - (f3 + f4) - (f5 + f6) - paramFloat - f1), paramFlexLayoutContext.flexStyle.padding.getWithFallback(leadingSpacing[k], leading[k]) + paramFlexLayoutContext.flexStyle.border.getWithFallback(leadingSpacing[k], leading[k]) + (paramFlexLayoutContext.flexStyle.padding.getWithFallback(trailingSpacing[k], trailing[k]) + paramFlexLayoutContext.flexStyle.border.getWithFallback(trailingSpacing[k], trailing[k])));
            }
          }
          label7113:
          if ((!Float.isNaN(paramFlexLayoutContext.flexStyle.position[trailing[k]])) && (Float.isNaN(paramFlexLayoutContext.flexStyle.position[leading[k]])))
          {
            paramFlexLayoutDirection = paramFlexLayoutContext.flexLayout.position;
            m = leading[k];
            f1 = paramFlexNode.flexLayout.dimensions[dim[k]];
            f2 = paramFlexLayoutContext.flexLayout.dimensions[dim[k]];
            if (Float.isNaN(paramFlexLayoutContext.flexStyle.position[trailing[k]])) {
              paramFloat = 0.0F;
            } else {
              paramFloat = paramFlexLayoutContext.flexStyle.position[trailing[k]];
            }
            paramFlexLayoutDirection[m] = (f1 - f2 - paramFloat);
          }
          j += 1;
        }
      }
      paramFlexLayoutDirection = paramFlexLayoutContext.nextAbsoluteChild;
      paramFlexLayoutContext.nextAbsoluteChild = null;
    }
  }
  
  static boolean needsRelayout(FlexNode paramFlexNode, float paramFloat)
  {
    boolean bool2 = paramFlexNode.isDirty();
    boolean bool1 = false;
    if ((bool2) || (!FloatUtils.floatsEqual(paramFlexNode.lastLayout.requestedHeight, paramFlexNode.flexLayout.dimensions[1])) || (!FloatUtils.floatsEqual(paramFlexNode.lastLayout.requestedWidth, paramFlexNode.flexLayout.dimensions[0])) || (!FloatUtils.floatsEqual(paramFlexNode.lastLayout.parentMaxWidth, paramFloat))) {
      bool1 = true;
    }
    return bool1;
  }
  
  private static int resolveAxis(int paramInt, FlexLayoutDirection paramFlexLayoutDirection)
  {
    if (paramFlexLayoutDirection == FlexLayoutDirection.RTL)
    {
      int i = CSS_FLEX_DIRECTION_ROW;
      if (paramInt == i) {
        return CSS_FLEX_DIRECTION_ROW_REVERSE;
      }
      if (paramInt == CSS_FLEX_DIRECTION_ROW_REVERSE) {
        return i;
      }
    }
    return paramInt;
  }
  
  private static FlexLayoutDirection resolveDirection(FlexNode paramFlexNode, FlexLayoutDirection paramFlexLayoutDirection)
  {
    FlexLayoutDirection localFlexLayoutDirection = paramFlexNode.flexStyle.direction;
    paramFlexNode = localFlexLayoutDirection;
    if (localFlexLayoutDirection == FlexLayoutDirection.INHERIT)
    {
      paramFlexNode = paramFlexLayoutDirection;
      if (paramFlexLayoutDirection == null) {
        paramFlexNode = FlexLayoutDirection.LTR;
      }
    }
    return paramFlexNode;
  }
  
  private static void setDimensionFromStyle(FlexNode paramFlexNode, int paramInt)
  {
    if (!Float.isNaN(paramFlexNode.flexLayout.dimensions[dim[paramInt]])) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (((!Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[paramInt]])) || (!Float.isNaN(paramFlexNode.flexStyle.minWidth)) || (!Float.isNaN(paramFlexNode.flexStyle.maxWidth))) && (paramFlexNode.flexStyle.dimensions[dim[paramInt]] > 0.0D)) {}
    }
    else if (((Float.isNaN(paramFlexNode.flexStyle.dimensions[dim[paramInt]])) && (Float.isNaN(paramFlexNode.flexStyle.minHeight)) && (Float.isNaN(paramFlexNode.flexStyle.maxHeight))) || (paramFlexNode.flexStyle.dimensions[dim[paramInt]] <= 0.0D)) {
      return;
    }
    float f = Math.max(boundAxis(paramFlexNode, paramInt, paramFlexNode.flexStyle.dimensions[dim[paramInt]]), paramFlexNode.flexStyle.padding.getWithFallback(leadingSpacing[paramInt], leading[paramInt]) + paramFlexNode.flexStyle.padding.getWithFallback(trailingSpacing[paramInt], trailing[paramInt]) + paramFlexNode.flexStyle.border.getWithFallback(leadingSpacing[paramInt], leading[paramInt]) + paramFlexNode.flexStyle.border.getWithFallback(trailingSpacing[paramInt], trailing[paramInt]));
    paramFlexNode.flexLayout.dimensions[dim[paramInt]] = f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.Layout
 * JD-Core Version:    0.7.0.1
 */