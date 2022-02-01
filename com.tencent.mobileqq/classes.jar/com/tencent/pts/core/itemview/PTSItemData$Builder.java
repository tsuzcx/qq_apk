package com.tencent.pts.core.itemview;

public class PTSItemData$Builder
{
  private String frameTreeJson;
  private String itemID;
  private String jsonData;
  private String pageJs;
  private String pageName;
  
  public PTSItemData build()
  {
    PTSItemData localPTSItemData = new PTSItemData(null);
    PTSItemData.access$102(localPTSItemData, this.itemID);
    PTSItemData.access$202(localPTSItemData, this.pageName);
    PTSItemData.access$302(localPTSItemData, this.jsonData);
    PTSItemData.access$402(localPTSItemData, this.frameTreeJson);
    PTSItemData.access$502(localPTSItemData, this.pageJs);
    return localPTSItemData;
  }
  
  public Builder withFrameTreeJson(String paramString)
  {
    this.frameTreeJson = paramString;
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
  
  public Builder withPageJs(String paramString)
  {
    this.pageJs = paramString;
    return this;
  }
  
  public Builder withPageName(String paramString)
  {
    this.pageName = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.core.itemview.PTSItemData.Builder
 * JD-Core Version:    0.7.0.1
 */