package com.tencent.mobileqq.richmediabrowser;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack.Stub;
import com.tencent.mobileqq.data.MessageForShortVideo;

class AIOGalleryActivity$3
  extends IAIOImageProviderCallBack.Stub
{
  AIOGalleryActivity$3(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public void a()
  {
    this.a.runOnUiThread(new AIOGalleryActivity.3.4(this));
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    this.a.runOnUiThread(new AIOGalleryActivity.3.2(this, paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    this.a.runOnUiThread(new AIOGalleryActivity.3.1(this, paramBoolean, paramLong, paramInt1, paramInt2, paramInt3, paramString));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    this.a.runOnUiThread(new AIOGalleryActivity.3.5(this, paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3, paramBundle));
  }
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    this.a.runOnUiThread(new AIOGalleryActivity.3.3(this, paramArrayOfAIORichMediaData, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.3
 * JD-Core Version:    0.7.0.1
 */