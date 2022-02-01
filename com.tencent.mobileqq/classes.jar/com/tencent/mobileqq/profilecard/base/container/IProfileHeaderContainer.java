package com.tencent.mobileqq.profilecard.base.container;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;

public abstract interface IProfileHeaderContainer
{
  public abstract boolean hasPhotoWall();
  
  public abstract void onGetQZoneCover(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.IProfileHeaderContainer
 * JD-Core Version:    0.7.0.1
 */