package com.tencent.ttpic.cache;

public class ImageItemDeleteInfo
{
  public int currentIndex;
  public String id;
  public int index;
  public String key;
  public double time;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteItemInfo key:" + this.key);
    localStringBuilder.append(", id:" + this.id);
    localStringBuilder.append(", currentIndex:" + this.currentIndex);
    localStringBuilder.append(", index:" + this.index);
    localStringBuilder.append(", time:" + this.time);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.cache.ImageItemDeleteInfo
 * JD-Core Version:    0.7.0.1
 */