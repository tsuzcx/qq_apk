package com.tencent.plato.sdk.element;

import com.tencent.plato.layout.LayoutEngine;
import com.tencent.plato.layout.PAlign;
import com.tencent.plato.layout.PDisplay;
import com.tencent.plato.layout.PEdge;
import com.tencent.plato.layout.PFlexDirection;
import com.tencent.plato.layout.PJustify;
import com.tencent.plato.layout.PMeasureFunction;
import com.tencent.plato.layout.PPositionType;
import com.tencent.plato.layout.PWrap;
import com.tencent.plato.layout.PlatoNode;
import com.tencent.plato.layout.PlatoNodeImpl;

public abstract class LayoutElement
  extends PropertyImpl
  implements IElement
{
  public int mIndex = -1;
  protected final PlatoNode mNode;
  protected int mState = 0;
  
  public LayoutElement(LayoutEngine paramLayoutEngine, int paramInt)
  {
    this.mNode = new PlatoNodeImpl(paramLayoutEngine, paramInt);
    this.mNode.setData(this);
  }
  
  public void addChildAt(IElement paramIElement, int paramInt)
  {
    if ((this.mNode != null) && (paramIElement != null) && (((LayoutElement)paramIElement).mNode != null))
    {
      this.mNode.addChildAt(((LayoutElement)paramIElement).mNode, paramInt);
      if (paramIElement.isNotCalculate()) {
        ((LayoutElement)paramIElement).setDisplay(PDisplay.NONE);
      }
    }
  }
  
  public void calculateLayout(float paramFloat1, float paramFloat2)
  {
    this.mNode.calculateLayout(paramFloat1, paramFloat2);
  }
  
  public IElement clone()
  {
    return null;
  }
  
  public IElement getChildAt(int paramInt)
  {
    PlatoNode localPlatoNode = this.mNode.getChildAt(paramInt);
    if (localPlatoNode == null) {
      return null;
    }
    return (IElement)localPlatoNode.getData();
  }
  
  public int getChildCount()
  {
    return this.mNode.getChildCount();
  }
  
  public int getElementId()
  {
    return this.mNode.getNodeId();
  }
  
  public int getIndex()
  {
    return this.mIndex;
  }
  
  public float getLayoutHeight()
  {
    return this.mNode.getLayoutHeight();
  }
  
  public float getLayoutWidth()
  {
    return this.mNode.getLayoutWidth();
  }
  
  public float getLayoutX()
  {
    return this.mNode.getLayoutX();
  }
  
  public float getLayoutY()
  {
    return this.mNode.getLayoutY();
  }
  
  public IElement getParent()
  {
    PlatoNode localPlatoNode = this.mNode.getParent();
    if (localPlatoNode == null) {
      return null;
    }
    return (IElement)localPlatoNode.getData();
  }
  
  public IProperty getProperty()
  {
    return this;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public int indexOf(IElement paramIElement)
  {
    return this.mNode.indexOf(((LayoutElement)paramIElement).mNode);
  }
  
  public void removeChildAt(int paramInt)
  {
    this.mNode.removeChildAt(paramInt);
  }
  
  public void setAlignItems(PAlign paramPAlign)
  {
    this.mNode.setAlignItems(paramPAlign);
  }
  
  public void setAlignItems(String paramString)
  {
    this.mNode.setAlignItems(paramString);
  }
  
  public void setAlignSelf(PAlign paramPAlign)
  {
    this.mNode.setAlignSelf(paramPAlign);
  }
  
  public void setAlignSelf(String paramString)
  {
    this.mNode.setAlignSelf(paramString);
  }
  
  public void setBorder(PEdge paramPEdge, float paramFloat)
  {
    this.mNode.setBorder(paramPEdge, paramFloat);
  }
  
  public void setBorder(PEdge paramPEdge, String paramString)
  {
    this.mNode.setBorder(paramPEdge, paramString);
  }
  
  public void setBorder(String paramString)
  {
    this.mNode.setBorder(paramString);
  }
  
  public void setDisplay(PDisplay paramPDisplay)
  {
    this.mNode.setDisplay(paramPDisplay);
  }
  
  public void setDisplay(String paramString)
  {
    this.mNode.setDisplay(paramString);
  }
  
  public void setFlex(String paramString)
  {
    this.mNode.setFlex(paramString);
  }
  
  public void setFlexBasis(float paramFloat)
  {
    this.mNode.setFlexBasis(paramFloat);
  }
  
  public void setFlexBasis(String paramString)
  {
    this.mNode.setFlexBasis(paramString);
  }
  
  public void setFlexBasisAuto()
  {
    this.mNode.setFlexBasisAuto();
  }
  
  public void setFlexDirection(PFlexDirection paramPFlexDirection)
  {
    this.mNode.setFlexDirection(paramPFlexDirection);
  }
  
  public void setFlexDirection(String paramString)
  {
    this.mNode.setFlexDirection(paramString);
  }
  
  public void setFlexGrow(float paramFloat)
  {
    this.mNode.setFlexGrow(paramFloat);
  }
  
  public void setFlexGrow(String paramString)
  {
    this.mNode.setFlexGrow(paramString);
  }
  
  public void setFlexShrink(float paramFloat)
  {
    this.mNode.setFlexShrink(paramFloat);
  }
  
  public void setFlexShrink(String paramString)
  {
    this.mNode.setFlexShrink(paramString);
  }
  
  public void setHeight(float paramFloat)
  {
    this.mNode.setHeight(paramFloat);
  }
  
  public void setHeight(String paramString)
  {
    this.mNode.setHeight(paramString);
  }
  
  public void setHeightPercent(float paramFloat)
  {
    this.mNode.setHeightPercent(paramFloat);
  }
  
  public void setIndex(int paramInt)
  {
    this.mIndex = paramInt;
  }
  
  public void setJustifyContent(PJustify paramPJustify)
  {
    this.mNode.setJustifyContent(paramPJustify);
  }
  
  public void setJustifyContent(String paramString)
  {
    this.mNode.setJustifyContent(paramString);
  }
  
  public void setMargin(PEdge paramPEdge, String paramString)
  {
    this.mNode.setMargin(paramPEdge, paramString);
  }
  
  public void setMargin(String paramString)
  {
    this.mNode.setMargin(paramString);
  }
  
  public void setMeasureFunction(PMeasureFunction paramPMeasureFunction)
  {
    this.mNode.setMeasureFunction(paramPMeasureFunction);
  }
  
  public void setPadding(PEdge paramPEdge, String paramString)
  {
    this.mNode.setPadding(paramPEdge, paramString);
  }
  
  public void setPadding(String paramString)
  {
    this.mNode.setPadding(paramString);
  }
  
  public void setPosition(PEdge paramPEdge, float paramFloat)
  {
    this.mNode.setPosition(paramPEdge, paramFloat);
  }
  
  public void setPosition(PEdge paramPEdge, String paramString)
  {
    this.mNode.setPosition(paramPEdge, paramString);
  }
  
  public void setPosition(String paramString)
  {
    this.mNode.setPosition(paramString);
  }
  
  public void setPositionPercent(PEdge paramPEdge, float paramFloat)
  {
    this.mNode.setPositionPercent(paramPEdge, paramFloat);
  }
  
  public void setPositionType(PPositionType paramPPositionType)
  {
    this.mNode.setPositionType(paramPPositionType);
  }
  
  public void setPositionType(String paramString)
  {
    this.mNode.setPositionType(paramString);
  }
  
  public void setState(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public void setWidth(float paramFloat)
  {
    this.mNode.setWidth(paramFloat);
  }
  
  public void setWidth(String paramString)
  {
    this.mNode.setWidth(paramString);
  }
  
  public void setWidthPercent(float paramFloat)
  {
    this.mNode.setWidthPercent(paramFloat);
  }
  
  public void setWrap(PWrap paramPWrap)
  {
    this.mNode.setWrap(paramPWrap);
  }
  
  public void setWrap(String paramString)
  {
    this.mNode.setWrap(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.element.LayoutElement
 * JD-Core Version:    0.7.0.1
 */