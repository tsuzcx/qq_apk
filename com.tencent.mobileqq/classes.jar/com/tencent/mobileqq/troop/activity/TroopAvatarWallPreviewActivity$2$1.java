package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;

class TroopAvatarWallPreviewActivity$2$1
  implements Runnable
{
  TroopAvatarWallPreviewActivity$2$1(TroopAvatarWallPreviewActivity.2 param2, Setting paramSetting) {}
  
  public void run()
  {
    if (this.b.this$0.isFinishing()) {
      return;
    }
    if (!this.b.this$0.mIsFromPhotoWall)
    {
      this.b.this$0.initGallery(this.b.a);
      this.b.this$0.mAdapter.a(this.b.this$0.mTroopUin, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.2.1
 * JD-Core Version:    0.7.0.1
 */