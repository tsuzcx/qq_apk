package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class AnonymousGiftAppInfo
  extends GiftAppInfo
{
  public int defaultDrawableID()
  {
    return 2130851172;
  }
  
  public int getAppID()
  {
    if (isTroop()) {
      return 1200000006;
    }
    return 0;
  }
  
  public int getManageConfigID()
  {
    return 0;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131697220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AnonymousGiftAppInfo
 * JD-Core Version:    0.7.0.1
 */