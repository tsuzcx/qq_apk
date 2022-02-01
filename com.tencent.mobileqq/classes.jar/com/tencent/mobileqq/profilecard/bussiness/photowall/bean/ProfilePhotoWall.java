package com.tencent.mobileqq.profilecard.bussiness.photowall.bean;

public abstract class ProfilePhotoWall
{
  public static final int TYPE_NOW_PHOTO = 2;
  public static final int TYPE_QZONE_PHOTO_WALL = 1;
  public long time;
  public int type;
  public String uin;
  
  public abstract String getOriginUrl();
  
  public abstract String getThumbUrl(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall
 * JD-Core Version:    0.7.0.1
 */