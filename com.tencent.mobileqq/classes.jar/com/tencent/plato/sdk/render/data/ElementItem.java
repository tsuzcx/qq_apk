package com.tencent.plato.sdk.render.data;

import com.tencent.plato.JSONWritableMap;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.IWritableMap;
import com.tencent.plato.sdk.element.IElement;
import com.tencent.plato.sdk.element.IProperty;
import com.tencent.plato.sdk.render.PRect;
import java.util.List;
import java.util.Map;

public class ElementItem
{
  public String elementType;
  public boolean isBlockType;
  public List<String> mEvents = null;
  public int mId;
  public int mIndex;
  public Map<String, Object> mTransform = null;
  public PRect rc;
  public IWritableMap uiStyles = new JSONWritableMap();
  
  public int getElementId()
  {
    return this.mId;
  }
  
  public String getElementType()
  {
    return this.elementType;
  }
  
  public List<String> getEvents()
  {
    return this.mEvents;
  }
  
  public int getIndex()
  {
    return this.mIndex;
  }
  
  public float getLayoutHeight()
  {
    return this.rc.height;
  }
  
  public float getLayoutWidth()
  {
    return this.rc.width;
  }
  
  public float getLayoutX()
  {
    return this.rc.left;
  }
  
  public float getLayoutY()
  {
    return this.rc.top;
  }
  
  public IElement getParent()
  {
    return null;
  }
  
  public IProperty getProperty()
  {
    return null;
  }
  
  public Map<String, Object> getTransfrom()
  {
    return this.mTransform;
  }
  
  public IReadableMap getUIStyles()
  {
    return this.uiStyles;
  }
  
  public void setIndex(int paramInt)
  {
    this.mIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.render.data.ElementItem
 * JD-Core Version:    0.7.0.1
 */