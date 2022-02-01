package com.tencent.mobileqq.mini.model;

import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;

public class SubscribeItemModel
{
  private String content;
  private boolean isChecked;
  private INTERFACE.StSubscribeMessage stSubscribeMessage;
  private SubscribeItemModel.SubscribeViewType viewType;
  
  private SubscribeItemModel(SubscribeItemModel.SubscribeViewType paramSubscribeViewType, boolean paramBoolean, String paramString, INTERFACE.StSubscribeMessage paramStSubscribeMessage)
  {
    this.viewType = paramSubscribeViewType;
    this.isChecked = paramBoolean;
    this.content = paramString;
    this.stSubscribeMessage = paramStSubscribeMessage;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public INTERFACE.StSubscribeMessage getStSubscribeMessage()
  {
    return this.stSubscribeMessage;
  }
  
  public SubscribeItemModel.SubscribeViewType getViewType()
  {
    return this.viewType;
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.model.SubscribeItemModel
 * JD-Core Version:    0.7.0.1
 */