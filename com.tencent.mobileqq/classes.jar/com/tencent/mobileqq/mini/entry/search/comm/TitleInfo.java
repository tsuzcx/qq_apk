package com.tencent.mobileqq.mini.entry.search.comm;

public class TitleInfo
  implements ItemInfo
{
  public String mTitle;
  public boolean showRefreshButton;
  
  public TitleInfo(String paramString)
  {
    this.mTitle = paramString;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void setRefreshButtonVisibility(boolean paramBoolean)
  {
    this.showRefreshButton = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.comm.TitleInfo
 * JD-Core Version:    0.7.0.1
 */