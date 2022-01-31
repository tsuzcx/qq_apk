package com.tencent.plato.sdk.element;

import com.tencent.plato.core.IReadableArray;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.layout.LayoutEngine;
import com.tencent.plato.sdk.animation.PAnimation;
import com.tencent.plato.sdk.dom.IDom;
import com.tencent.plato.sdk.render.IPView;
import com.tencent.plato.sdk.render.data.ElementItem;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract interface IElement
{
  public abstract void addAnimation(PAnimation paramPAnimation);
  
  public abstract void addChildAt(IElement paramIElement, int paramInt);
  
  public abstract void addEvent(String paramString);
  
  public abstract void addEventArray(IReadableArray paramIReadableArray);
  
  public abstract void calculateLayout(float paramFloat1, float paramFloat2);
  
  public abstract JSONObject dumpNode(JSONObject paramJSONObject);
  
  public abstract void generateTransitionAnimations();
  
  public abstract IElement getChildAt(int paramInt);
  
  public abstract int getChildCount();
  
  public abstract IDom getDom();
  
  public abstract int getElementId();
  
  public abstract String getElementType();
  
  public abstract List<String> getEvents();
  
  public abstract int getIndex();
  
  public abstract float getLayoutHeight();
  
  public abstract float getLayoutWidth();
  
  public abstract float getLayoutX();
  
  public abstract float getLayoutY();
  
  public abstract Map<Integer, Object> getOperateAnimations();
  
  public abstract IElement getParent();
  
  public abstract IProperty getProperty();
  
  public abstract int getState();
  
  public abstract IReadableMap getUIStyles();
  
  public abstract int indexOf(IElement paramIElement);
  
  public abstract boolean isBlockType();
  
  public abstract boolean isDisplayNone();
  
  public abstract boolean isLeafNode();
  
  public abstract boolean isNotCalculate();
  
  public abstract void pauseAnimation(String paramString);
  
  public abstract void playAnimation(String paramString1, String paramString2);
  
  public abstract void removeAttr(String paramString);
  
  public abstract void removeChildAt(int paramInt);
  
  public abstract void removeEvent(String paramString);
  
  public abstract void resumeAnimation(String paramString);
  
  public abstract ElementItem retrieveData(boolean paramBoolean);
  
  public abstract void setDom(IDom paramIDom);
  
  public abstract void setIndex(int paramInt);
  
  public abstract void setState(int paramInt);
  
  public abstract void stopAnimation(String paramString);
  
  public static abstract interface IOperation
  {
    public abstract void execute();
  }
  
  public static abstract interface IProvider<T extends IElement, V extends IPView>
  {
    public abstract T createElement(LayoutEngine paramLayoutEngine, int paramInt);
    
    public abstract V createView();
    
    public abstract String getName();
  }
  
  public static class State
  {
    public static final int STATE_ANIMATION = 16;
    public static final int STATE_EVENT = 8;
    public static final int STATE_MOVE = 2;
    public static final int STATE_NEW = 1;
    public static final int STATE_NONE = 0;
    public static final int STATE_UPDATE = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.element.IElement
 * JD-Core Version:    0.7.0.1
 */