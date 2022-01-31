package com.tencent.pts.core.itemview;

public class PTSItemData$Builder
{
  private String appName;
  private String appPath;
  private String itemID;
  private String jsonData;
  
  public PTSItemData build()
  {
    PTSItemData localPTSItemData = new PTSItemData();
    PTSItemData.access$002(localPTSItemData, this.itemID);
    PTSItemData.access$102(localPTSItemData, this.appName);
    PTSItemData.access$202(localPTSItemData, this.appPath);
    PTSItemData.access$302(localPTSItemData, this.jsonData);
    return localPTSItemData;
  }
  
  public Builder withAppName(String paramString)
  {
    this.appName = paramString;
    return this;
  }
  
  public Builder withAppPath(String paramString)
  {
    this.appPath = paramString;
    return this;
  }
  
  public Builder withItemID(String paramString)
  {
    this.itemID = paramString;
    return this;
  }
  
  public Builder withJsonData(String paramString)
  {
    this.jsonData = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.core.itemview.PTSItemData.Builder
 * JD-Core Version:    0.7.0.1
 */