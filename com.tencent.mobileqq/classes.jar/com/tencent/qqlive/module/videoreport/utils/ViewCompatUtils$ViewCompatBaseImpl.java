package com.tencent.qqlive.module.videoreport.utils;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

class ViewCompatUtils$ViewCompatBaseImpl
{
  private static final Integer FLAG_CLIP_CHILDREN = (Integer)ReflectUtils.getField(ViewGroup.class, "FLAG_CLIP_CHILDREN");
  private static final Integer FLAG_CLIP_TO_PADDING = (Integer)ReflectUtils.getField(ViewGroup.class, "FLAG_CLIP_TO_PADDING");
  private static final String TAG = "ViewCompatBaseImpl";
  
  private boolean hasBooleanFlag(ViewGroup paramViewGroup, Integer paramInteger)
  {
    Integer localInteger = (Integer)ReflectUtils.getField(ViewGroup.class, "mGroupFlags", paramViewGroup);
    StringBuilder localStringBuilder;
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localStringBuilder = new StringBuilder().append("hasBooleanFlag: groupFlags = ");
      if (localInteger != null) {
        break label86;
      }
      paramViewGroup = "null";
      localStringBuilder = localStringBuilder.append(paramViewGroup).append(", flag = ");
      if (paramInteger != null) {
        break label94;
      }
    }
    label86:
    label94:
    for (paramViewGroup = "null";; paramViewGroup = paramInteger.toString())
    {
      Log.d("ViewCompatBaseImpl", paramViewGroup);
      if ((localInteger != null) && (paramInteger != null)) {
        break label102;
      }
      return false;
      paramViewGroup = localInteger.toString();
      break;
    }
    label102:
    return (localInteger.intValue() & paramInteger.intValue()) == paramInteger.intValue();
  }
  
  public boolean getClipChildren(ViewGroup paramViewGroup)
  {
    return hasBooleanFlag(paramViewGroup, FLAG_CLIP_CHILDREN);
  }
  
  public boolean getClipToPadding(ViewGroup paramViewGroup)
  {
    return hasBooleanFlag(paramViewGroup, FLAG_CLIP_TO_PADDING);
  }
  
  public boolean isAttachedToWindow(View paramView)
  {
    return ReflectUtils.getField(View.class, "mAttachInfo", paramView) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils.ViewCompatBaseImpl
 * JD-Core Version:    0.7.0.1
 */