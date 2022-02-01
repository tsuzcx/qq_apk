package com.tencent.mobileqq.mediabrowser.impl;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserProviderCallBack;

class MediaBrowserActivity$2
  implements IMediaBrowserProviderCallBack
{
  MediaBrowserActivity$2(MediaBrowserActivity paramMediaBrowserActivity) {}
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    this.a.runOnUiThread(new MediaBrowserActivity.2.2(this, paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    this.a.runOnUiThread(new MediaBrowserActivity.2.1(this, paramBoolean, paramLong, paramInt1, paramInt2, paramInt3, paramString));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    this.a.runOnUiThread(new MediaBrowserActivity.2.3(this, paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediabrowser.impl.MediaBrowserActivity.2
 * JD-Core Version:    0.7.0.1
 */