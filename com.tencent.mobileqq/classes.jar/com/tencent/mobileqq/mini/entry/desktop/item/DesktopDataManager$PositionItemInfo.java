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
    if (paramObject == null) {
      return 0;
    }
    int i = this.position;
    int j = paramObject.position;
    if (i == j) {
      return 0;
    }
    if (i > j) {
      return 1;
    }
    return -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("index:");
    localStringBuilder.append(this.position);
    localStringBuilder.append("-type:");
    localStringBuilder.append(this.moduleType);
    localStringBuilder.append("-appId:");
    localStringBuilder.append(this.appId);
    localStringBuilder.append("-title:");
    localStringBuilder.append(this.moduleTitle);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.PositionItemInfo
 * JD-Core Version:    0.7.0.1
 */