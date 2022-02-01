package com.tencent.mobileqq.richmediabrowser;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack.Stub;
import com.tencent.mobileqq.data.MessageForShortVideo;

class AIOGalleryActivity$2
  extends IAIOImageProviderCallBack.Stub
{
  AIOGalleryActivity$2(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public void a() {}
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    this.a.runOnUiThread(new AIOGalleryActivity.2.2(this, paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    this.a.runOnUiThread(new AIOGalleryActivity.2.1(this, paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    this.a.runOnUiThread(new AIOGalleryActivity.2.4(this, paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3, paramBundle));
  }
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    this.a.runOnUiThread(new AIOGalleryActivity.2.3(this, paramArrayOfAIORichMediaData, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2
 * JD-Core Version:    0.7.0.1
 */