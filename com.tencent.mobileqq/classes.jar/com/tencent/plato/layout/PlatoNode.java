package com.tencent.plato.layout;

public abstract interface PlatoNode
{
  public abstract void addChildAt(PlatoNode paramPlatoNode, int paramInt);
  
  public abstract void calculateLayout(float paramFloat1, float paramFloat2);
  
  public abstract void dirty();
  
  public abstract PAlign getAlignItems();
  
  public abstract PlatoNode getChildAt(int paramInt);
  
  public abstract int getChildCount();
  
  public abstract Object getData();
  
  public abstract PDisplay getDisplay();
  
  public abstract PFlexDirection getFlexDirection();
  
  public abstract PValue getHeight();
  
  public abstract PJustify getJustifyContent();
  
  public abstract float getLayoutHeight();
  
  public abstract float getLayoutWidth();
  
  public abstract float getLayoutX();
  
  public abstract float getLayoutY();
  
  public abstract PValue getMargin(PEdge paramPEdge);
  
  public abstract int getNodeId();
  
  public abstract PValue getPadding(PEdge paramPEdge);
  
  public abstract PlatoNode getParent();
  
  public abstract PValue getWidth();
  
  public abstract int indexOf(PlatoNode paramPlatoNode);
  
  public abstract boolean isMeasureDefined();
  
  public abstract void removeChildAt(int paramInt);
  
  public abstract void setAlignItems(PAlign paramPAlign);
  
  public abstract void setAlignItems(String paramString);
  
  public abstract void setAlignSelf(PAlign paramPAlign);
  
  public abstract void setAlignSelf(String paramString);
  
  public abstract void setBorder(PEdge paramPEdge, float paramFloat);
  
  public abstract void setBorder(PEdge paramPEdge, String paramString);
  
  public abstract void setBorder(String paramString);
  
  public abstract void setData(Object paramObject);
  
  public abstract void setDisplay(PDisplay paramPDisplay);
  
  public abstract void setDisplay(String paramString);
  
  public abstract void setFlex(String paramString);
  
  public abstract void setFlexBasis(float paramFloat);
  
  public abstract void setFlexBasis(String paramString);
  
  public abstract void setFlexBasisAuto();
  
  public abstract void setFlexDirection(PFlexDirection paramPFlexDirection);
  
  public abstract void setFlexDirection(String paramString);
  
  public abstract void setFlexGrow(float paramFloat);
  
  public abstract void setFlexGrow(String paramString);
  
  public abstract void setFlexShrink(float paramFloat);
  
  public abstract void setFlexShrink(String paramString);
  
  public abstract void setHeight(float paramFloat);
  
  public abstract void setHeight(String paramString);
  
  public abstract void setHeightPercent(float paramFloat);
  
  public abstract void setJustifyContent(PJustify paramPJustify);
  
  public abstract void setJustifyContent(String paramString);
  
  public abstract void setMargin(PEdge paramPEdge, float paramFloat);
  
  public abstract void setMargin(PEdge paramPEdge, String paramString);
  
  public abstract void setMargin(String paramString);
  
  public abstract void setMarginAuto(PEdge paramPEdge);
  
  public abstract void setMarginPercent(PEdge paramPEdge, float paramFloat);
  
  public abstract void setMeasureFunction(PMeasureFunction paramPMeasureFunction);
  
  public abstract void setPadding(PEdge paramPEdge, float paramFloat);
  
  public abstract void setPadding(PEdge paramPEdge, String paramString);
  
  public abstract void setPadding(String paramString);
  
  public abstract void setPaddingPercent(PEdge paramPEdge, float paramFloat);
  
  public abstract void setPosition(PEdge paramPEdge, float paramFloat);
  
  public abstract void setPosition(PEdge paramPEdge, String paramString);
  
  public abstract void setPosition(String paramString);
  
  public abstract void setPositionPercent(PEdge paramPEdge, float paramFloat);
  
  public abstract void setPositionType(PPositionType paramPPositionType);
  
  public abstract void setPositionType(String paramString);
  
  public abstract void setWidth(float paramFloat);
  
  public abstract void setWidth(String paramString);
  
  public abstract void setWidthPercent(float paramFloat);
  
  public abstract void setWrap(PWrap paramPWrap);
  
  public abstract void setWrap(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.layout.PlatoNode
 * JD-Core Version:    0.7.0.1
 */