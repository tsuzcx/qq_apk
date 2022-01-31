package com.tencent.richmediabrowser.model;

public abstract interface IBrowserModel
{
  public abstract int getCount();
  
  public abstract RichMediaBrowserInfo getItem(int paramInt);
  
  public abstract int getSelectedIndex();
  
  public abstract RichMediaBrowserInfo getSelectedItem();
  
  public abstract void setSelectedIndex(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.IBrowserModel
 * JD-Core Version:    0.7.0.1
 */