package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.ui.MoreItem;

public class MoreItemList$Builder
{
  private MoreItemList.DisplaySettings mDisplaySettings = new MoreItemList.DisplaySettings();
  MoreItemList mMoreItemList = new MoreItemList(null);
  
  public Builder addAbout()
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 5;
    localMoreItem.jdField_a_of_type_Boolean = this.mDisplaySettings.isShowAbout;
    localMoreItem.b = 2130840804;
    localMoreItem.jdField_a_of_type_JavaLangString = "关于";
    this.mMoreItemList.add(localMoreItem);
    return this;
  }
  
  public Builder addComplaint()
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 6;
    localMoreItem.jdField_a_of_type_Boolean = this.mDisplaySettings.isShowComplaint;
    localMoreItem.b = 2130840837;
    localMoreItem.jdField_a_of_type_JavaLangString = "举报";
    this.mMoreItemList.add(localMoreItem);
    return this;
  }
  
  public Builder addDebug()
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 7;
    localMoreItem.jdField_a_of_type_Boolean = this.mDisplaySettings.isShowDebug;
    localMoreItem.b = 2130840804;
    localMoreItem.jdField_a_of_type_JavaLangString = "调试";
    this.mMoreItemList.add(localMoreItem);
    return this;
  }
  
  public Builder addMonitor()
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 8;
    localMoreItem.jdField_a_of_type_Boolean = this.mDisplaySettings.isShowMonitor;
    localMoreItem.b = 2130840804;
    localMoreItem.jdField_a_of_type_JavaLangString = "性能";
    this.mMoreItemList.add(localMoreItem);
    return this;
  }
  
  public Builder addMoreItem(MoreItem paramMoreItem)
  {
    this.mMoreItemList.add(paramMoreItem);
    return this;
  }
  
  public Builder addShareQQ()
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 1;
    localMoreItem.jdField_a_of_type_Boolean = this.mDisplaySettings.isShowShareQQ;
    localMoreItem.b = 2130840838;
    localMoreItem.jdField_a_of_type_JavaLangString = "QQ";
    this.mMoreItemList.add(localMoreItem);
    return this;
  }
  
  public Builder addShareQzone()
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 2;
    localMoreItem.jdField_a_of_type_Boolean = this.mDisplaySettings.isShowShareQzone;
    localMoreItem.b = 2130840839;
    localMoreItem.jdField_a_of_type_JavaLangString = "QQ空间";
    this.mMoreItemList.add(localMoreItem);
    return this;
  }
  
  public Builder addShareWxFriends()
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 3;
    localMoreItem.jdField_a_of_type_Boolean = this.mDisplaySettings.isShowShareWxFriends;
    localMoreItem.b = 2130840840;
    localMoreItem.jdField_a_of_type_JavaLangString = "微信好友";
    this.mMoreItemList.add(localMoreItem);
    return this;
  }
  
  public Builder addShareWxMoments()
  {
    MoreItem localMoreItem = new MoreItem();
    localMoreItem.jdField_a_of_type_Int = 4;
    localMoreItem.jdField_a_of_type_Boolean = this.mDisplaySettings.isShowShareWxMoments;
    localMoreItem.b = 2130840841;
    localMoreItem.jdField_a_of_type_JavaLangString = "微信朋友圈";
    this.mMoreItemList.add(localMoreItem);
    return this;
  }
  
  public MoreItemList build()
  {
    return this.mMoreItemList;
  }
  
  public Builder setDisplaySettings(MoreItemList.DisplaySettings paramDisplaySettings)
  {
    this.mDisplaySettings = paramDisplaySettings;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.MoreItemList.Builder
 * JD-Core Version:    0.7.0.1
 */