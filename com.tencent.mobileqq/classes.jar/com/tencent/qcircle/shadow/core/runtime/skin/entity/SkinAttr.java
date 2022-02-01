package com.tencent.qcircle.shadow.core.runtime.skin.entity;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.qcircle.shadow.core.runtime.skin.loader.SkinResLoader;

public abstract class SkinAttr
{
  public static final int EMPTY_VALUE_REF_ID = 0;
  protected static final String RES_TYPE_NAME_COLOR = "color";
  protected static final String RES_TYPE_NAME_DRAWABLE = "drawable";
  private static final String TAG;
  protected String attrName;
  protected int attrValueRefId;
  protected String attrValueRefName;
  protected String attrValueTypeName;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SKIN");
    localStringBuilder.append(SkinAttr.class.getSimpleName());
    TAG = localStringBuilder.toString();
  }
  
  public void apply(View paramView)
  {
    applyInner(paramView);
  }
  
  protected abstract boolean applyInner(View paramView);
  
  protected int getColor()
  {
    if (isColorAttr()) {
      return SkinResLoader.getColor(this.attrValueRefId, this.attrValueRefName);
    }
    return 0;
  }
  
  protected ColorStateList getColorStateList()
  {
    if (isColorAttr()) {
      return SkinResLoader.getColorStateList(this.attrValueRefId, this.attrValueRefName);
    }
    return null;
  }
  
  protected Drawable getDrawable()
  {
    if (isDrawableAttr()) {
      return SkinResLoader.getDrawable(this.attrValueRefId, this.attrValueRefName);
    }
    return null;
  }
  
  protected boolean isColorAttr()
  {
    return "color".equals(this.attrValueTypeName);
  }
  
  protected boolean isDrawableAttr()
  {
    return "drawable".equals(this.attrValueTypeName);
  }
  
  public void setBaseValue(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.attrName = paramString1;
    this.attrValueRefName = paramString2;
    this.attrValueTypeName = paramString3;
    this.attrValueRefId = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SkinAttr \n[\nattrName=");
    localStringBuilder.append(this.attrName);
    localStringBuilder.append(", \nattrValueRefId=");
    localStringBuilder.append(this.attrValueRefId);
    localStringBuilder.append(", \nattrValueRefName=");
    localStringBuilder.append(this.attrValueRefName);
    localStringBuilder.append(", \nattrValueTypeName=");
    localStringBuilder.append(this.attrValueTypeName);
    localStringBuilder.append("\n]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.skin.entity.SkinAttr
 * JD-Core Version:    0.7.0.1
 */