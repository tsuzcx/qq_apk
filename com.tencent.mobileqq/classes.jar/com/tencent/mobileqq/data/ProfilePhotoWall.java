package com.tencent.mobileqq.data;

public abstract class ProfilePhotoWall
{
  public long time;
  public int type;
  public String uin;
  
  public abstract String getOriginUrl();
  
  public abstract String getThumbUrl(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ProfilePhotoWall
 * JD-Core Version:    0.7.0.1
 */