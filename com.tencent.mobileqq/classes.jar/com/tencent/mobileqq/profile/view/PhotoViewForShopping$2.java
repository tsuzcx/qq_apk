package com.tencent.mobileqq.profile.view;

import android.os.Handler;
import android.os.Message;
import awmk;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;

class PhotoViewForShopping$2
  implements Runnable
{
  PhotoViewForShopping$2(PhotoViewForShopping paramPhotoViewForShopping, awmk paramawmk) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.a != null))
    {
      ProfileShoppingPhotoInfo localProfileShoppingPhotoInfo = ProfileShoppingPhotoInfo.getPhotoInfo(this.this$0.a, this.a.a.a);
      if ((localProfileShoppingPhotoInfo != null) && (PhotoViewForShopping.a(this.this$0) != null))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 200;
        localMessage.obj = localProfileShoppingPhotoInfo;
        PhotoViewForShopping.a(this.this$0).sendMessage(localMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.PhotoViewForShopping.2
 * JD-Core Version:    0.7.0.1
 */