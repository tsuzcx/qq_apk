package com.tencent.mtt.supportui.views.viewpager;

class ViewPager$ItemInfo
{
  Object object;
  float offset;
  int position;
  boolean scrolling;
  float sizeFactor;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("position=");
    localStringBuilder.append(this.position);
    localStringBuilder.append(",scrolling=");
    localStringBuilder.append(this.scrolling);
    localStringBuilder.append(",sizeFactor=");
    localStringBuilder.append(this.sizeFactor);
    localStringBuilder.append(",offset=");
    localStringBuilder.append(this.offset);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.viewpager.ViewPager.ItemInfo
 * JD-Core Version:    0.7.0.1
 */