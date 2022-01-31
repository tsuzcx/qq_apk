package com.tencent.ttpic.model;

public class DistortionItem
  implements Cloneable
{
  public int direction;
  public int distortion;
  public int position;
  public float radius;
  public float strength;
  public int x;
  public int y;
  
  public DistortionItem clone()
  {
    DistortionItem localDistortionItem2 = new DistortionItem();
    try
    {
      Object localObject = super.clone();
      DistortionItem localDistortionItem1 = localDistortionItem2;
      if ((localObject instanceof DistortionItem)) {
        localDistortionItem1 = (DistortionItem)localObject;
      }
      return localDistortionItem1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return localDistortionItem2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.DistortionItem
 * JD-Core Version:    0.7.0.1
 */