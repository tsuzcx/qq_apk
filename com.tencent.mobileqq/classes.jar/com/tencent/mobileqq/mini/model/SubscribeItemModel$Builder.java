package com.tencent.mobileqq.mini.model;

import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;

public class SubscribeItemModel$Builder
{
  private String content;
  private boolean isChecked;
  private INTERFACE.StSubscribeMessage stSubscribeMessage;
  private SubscribeItemModel.SubscribeViewType viewType;
  
  public SubscribeItemModel$Builder() {}
  
  public SubscribeItemModel$Builder(SubscribeItemModel paramSubscribeItemModel)
  {
    this.viewType = SubscribeItemModel.access$100(paramSubscribeItemModel);
    this.isChecked = SubscribeItemModel.access$200(paramSubscribeItemModel);
    this.content = SubscribeItemModel.access$300(paramSubscribeItemModel);
    this.stSubscribeMessage = SubscribeItemModel.access$400(paramSubscribeItemModel);
  }
  
  public SubscribeItemModel build()
  {
    return new SubscribeItemModel(this.viewType, this.isChecked, this.content, this.stSubscribeMessage, null);
  }
  
  public Builder setContent(String paramString)
  {
    this.content = paramString;
    return this;
  }
  
  public Builder setIsChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
    return this;
  }
  
  public Builder setStSubscribeMessage(INTERFACE.StSubscribeMessage paramStSubscribeMessage)
  {
    this.stSubscribeMessage = paramStSubscribeMessage;
    return this;
  }
  
  public Builder setViewType(SubscribeItemModel.SubscribeViewType paramSubscribeViewType)
  {
    this.viewType = paramSubscribeViewType;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.model.SubscribeItemModel.Builder
 * JD-Core Version:    0.7.0.1
 */