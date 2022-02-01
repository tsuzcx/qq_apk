package com.tencent.mobileqq.profilecard.bussiness.photowall.handler;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import com.tencent.mobileqq.app.BusinessObserver;

public class PhotoWallObserver
  implements BusinessObserver
{
  public static final int TYPE_REQ_DEL_QZONE_PHOTOWALL = 2;
  public static final int TYPE_REQ_GET_QZONE_PHOTOWALL = 1;
  
  private void onUpdate_onDelQZonePhotoWall(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 2) {
      return;
    }
    if (paramObject != null) {
      onDelQZonePhotoWall(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
    }
  }
  
  private void onUpdate_onGetQZonePhotoWall(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    if (paramObject != null)
    {
      paramObject = (Object[])paramObject;
      onGetQZonePhotoWall(paramBoolean, (String)paramObject[0], (mobile_sub_get_photo_wall_rsp)paramObject[1], (String)paramObject[2]);
    }
  }
  
  protected void onDelQZonePhotoWall(boolean paramBoolean, String paramString) {}
  
  protected void onGetQZonePhotoWall(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    onUpdate_onGetQZonePhotoWall(paramInt, paramBoolean, paramObject);
    onUpdate_onDelQZonePhotoWall(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver
 * JD-Core Version:    0.7.0.1
 */