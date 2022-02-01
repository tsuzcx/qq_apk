package com.tencent.mtt.hippy.dom.node;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.util.ArrayList;

public class ImageNode
  extends StyleNode
{
  public static final String PROP_VERTICAL_ALIGNMENT = "verticalAlignment";
  private ArrayList<String> mGestureTypes = null;
  private c mImageSpan = null;
  private boolean mIsVirtual;
  private int mVerticalAlignment = 1;
  
  public ImageNode(boolean paramBoolean)
  {
    this.mIsVirtual = paramBoolean;
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onClick")
  public void clickEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onClick");
    }
  }
  
  public ArrayList<String> getGestureTypes()
  {
    return this.mGestureTypes;
  }
  
  public int getVerticalAlignment()
  {
    return this.mVerticalAlignment;
  }
  
  public boolean isVirtual()
  {
    return this.mIsVirtual;
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onLongClick")
  public void longClickEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onLongClick");
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onPressIn")
  public void pressInEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onPressIn");
    }
  }
  
  @HippyControllerProps(name="onPressOut")
  public void pressOutEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onPressOut");
    }
  }
  
  public void setImageSpan(c paramc)
  {
    this.mImageSpan = paramc;
  }
  
  @HippyControllerProps(defaultString="", defaultType="string", name="src")
  public void setUrl(String paramString)
  {
    c localc = this.mImageSpan;
    if (localc != null) {
      localc.b(paramString);
    }
  }
  
  @HippyControllerProps(defaultNumber=1.0D, defaultType="number", name="verticalAlignment")
  public void setVerticalAlignment(int paramInt)
  {
    this.mVerticalAlignment = paramInt;
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onTouchCancel")
  public void touchCancelable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onTouchCancel");
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onTouchDown")
  public void touchDownEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onTouchDown");
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onTouchEnd")
  public void touchEndEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onTouchEnd");
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onTouchMove")
  public void touchUpEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mGestureTypes == null) {
        this.mGestureTypes = new ArrayList();
      }
      this.mGestureTypes.add("onTouchMove");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.ImageNode
 * JD-Core Version:    0.7.0.1
 */