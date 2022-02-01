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
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasBooleanFlag: groupFlags = ");
      String str = "null";
      if (localInteger == null) {
        paramViewGroup = "null";
      } else {
        paramViewGroup = localInteger.toString();
      }
      localStringBuilder.append(paramViewGroup);
      localStringBuilder.append(", flag = ");
      if (paramInteger == null) {
        paramViewGroup = str;
      } else {
        paramViewGroup = paramInteger.toString();
      }
      localStringBuilder.append(paramViewGroup);
      Log.d("ViewCompatBaseImpl", localStringBuilder.toString());
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localInteger != null)
    {
      if (paramInteger == null) {
        return false;
      }
      bool1 = bool2;
      if ((localInteger.intValue() & paramInteger.intValue()) == paramInteger.intValue()) {
        bool1 = true;
      }
    }
    return bool1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils.ViewCompatBaseImpl
 * JD-Core Version:    0.7.0.1
 */