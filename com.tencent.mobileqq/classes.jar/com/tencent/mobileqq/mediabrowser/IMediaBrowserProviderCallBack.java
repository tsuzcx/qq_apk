package com.tencent.mobileqq.mediabrowser;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageForShortVideo;

public abstract interface IMediaBrowserProviderCallBack
{
  public abstract void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediabrowser.IMediaBrowserProviderCallBack
 * JD-Core Version:    0.7.0.1
 */