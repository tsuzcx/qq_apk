package com.tencent.mobileqq.richmediabrowser;

import com.tencent.mobileqq.richmediabrowser.api.IBrowserManager;

class AIOGalleryActivity$2$1
  implements Runnable
{
  AIOGalleryActivity$2$1(AIOGalleryActivity.2 param2, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (AIOGalleryActivity.a(this.g.a) != null) {
      AIOGalleryActivity.a(this.g.a).notifyImageResult(this.a, this.b, this.c, this.d, this.e, this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2.1
 * JD-Core Version:    0.7.0.1
 */