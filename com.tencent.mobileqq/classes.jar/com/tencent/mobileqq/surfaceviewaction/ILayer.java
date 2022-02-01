package com.tencent.mobileqq.surfaceviewaction;

import java.util.List;

public abstract interface ILayer<T extends BaseNode>
{
  public abstract <N extends BaseNode> N a(String paramString);
  
  public abstract List<BaseNode> a();
  
  public abstract void a(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.ILayer
 * JD-Core Version:    0.7.0.1
 */