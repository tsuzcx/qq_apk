package com.tencent.plato.sdk.render;

import com.tencent.plato.sdk.render.data.ElementItem;
import java.util.List;

public abstract interface IBlockView
{
  public abstract void addBlockEvent(int paramInt, List<String> paramList);
  
  public abstract void createBlockFinish();
  
  public abstract void createBlockView(ElementItem paramElementItem, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean isBlockViewContainID(int paramInt);
  
  public abstract void moveBlockView(int paramInt1, int paramInt2, int paramInt3, ElementItem paramElementItem);
  
  public abstract void removeBlockView(int paramInt);
  
  public abstract void setBlockData(int paramInt, ElementItem paramElementItem);
  
  public abstract void updateBlockStyles(int paramInt, Object paramObject);
  
  public abstract void updateRects(int paramInt, PRect paramPRect);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.render.IBlockView
 * JD-Core Version:    0.7.0.1
 */