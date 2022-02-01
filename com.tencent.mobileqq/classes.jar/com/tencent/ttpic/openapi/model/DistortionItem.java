package com.tencent.ttpic.openapi.model;

public class DistortionItem
  implements Cloneable
{
  public int direction;
  public int distortion;
  public int position;
  public float radius;
  public float strength;
  public int targetDx = 0;
  public int targetDy = 0;
  public int x;
  public int y;
  
  public DistortionItem clone()
  {
    DistortionItem localDistortionItem = new DistortionItem();
    try
    {
      Object localObject = super.clone();
      if ((localObject instanceof DistortionItem))
      {
        localObject = (DistortionItem)localObject;
        return localObject;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return localDistortionItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.DistortionItem
 * JD-Core Version:    0.7.0.1
 */