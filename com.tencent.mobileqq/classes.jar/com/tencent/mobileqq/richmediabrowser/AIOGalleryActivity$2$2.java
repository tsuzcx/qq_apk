package com.tencent.mobileqq.richmediabrowser;

import com.tencent.mobileqq.richmediabrowser.api.IBrowserManager;

class AIOGalleryActivity$2$2
  implements Runnable
{
  AIOGalleryActivity$2$2(AIOGalleryActivity.2 param2, long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void run()
  {
    if (AIOGalleryActivity.a(this.g.a) != null) {
      AIOGalleryActivity.a(this.g.a).notifyImageProgress(this.a, this.b, this.c, this.d, this.e, this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2.2
 * JD-Core Version:    0.7.0.1
 */