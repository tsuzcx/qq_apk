package com.tencent.mobileqq.richmediabrowser;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserManager;

class AIOGalleryActivity$2$4
  implements Runnable
{
  AIOGalleryActivity$2$4(AIOGalleryActivity.2 param2, long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle) {}
  
  public void run()
  {
    if (AIOGalleryActivity.a(this.j.a) != null) {
      AIOGalleryActivity.a(this.j.a).notifyVideoUrl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2.4
 * JD-Core Version:    0.7.0.1
 */