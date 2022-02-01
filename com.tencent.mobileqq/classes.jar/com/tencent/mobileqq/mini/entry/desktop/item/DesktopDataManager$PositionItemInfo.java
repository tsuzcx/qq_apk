package com.tencent.mobileqq.mini.entry.desktop.item;

class DesktopDataManager$PositionItemInfo
  implements Comparable
{
  public String appId = "";
  public String moduleTitle = "";
  public int moduleType;
  public int position;
  
  public int compareTo(Object paramObject)
  {
    paramObject = (PositionItemInfo)paramObject;
    if (paramObject == null) {}
    while (this.position == paramObject.position) {
      return 0;
    }
    if (this.position > paramObject.position) {
      return 1;
    }
    return -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("index:").append(this.position).append("-type:").append(this.moduleType).append("-appId:").append(this.appId).append("-title:").append(this.moduleTitle);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.PositionItemInfo
 * JD-Core Version:    0.7.0.1
 */