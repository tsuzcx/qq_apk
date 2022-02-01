package com.tencent.richmediabrowser.model;

import android.content.Intent;

public class BrowserBaseModel
  implements IBrowserModel
{
  public void buildComplete() {}
  
  public void buildModel() {}
  
  public void buildParams(Intent paramIntent) {}
  
  public int getCount()
  {
    return 0;
  }
  
  public RichMediaBrowserInfo getItem(int paramInt)
  {
    return null;
  }
  
  public int getSelectedIndex()
  {
    return 0;
  }
  
  public RichMediaBrowserInfo getSelectedItem()
  {
    return null;
  }
  
  public void setSelectedIndex(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.BrowserBaseModel
 * JD-Core Version:    0.7.0.1
 */