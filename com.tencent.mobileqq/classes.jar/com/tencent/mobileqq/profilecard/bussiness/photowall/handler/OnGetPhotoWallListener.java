package com.tencent.mobileqq.profilecard.bussiness.photowall.handler;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;

public abstract interface OnGetPhotoWallListener
{
  public abstract boolean hasMore();
  
  public abstract void onGetQZonePhotoWall(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp);
  
  public abstract void startFetchMore();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.handler.OnGetPhotoWallListener
 * JD-Core Version:    0.7.0.1
 */