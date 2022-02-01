package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IBigEmotionService
  extends QRouteApi
{
  public abstract void openEmojiDetailPage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2);
  
  public abstract void openEmojiDetailPage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt1, String paramString2, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, String paramString3);
  
  public abstract void openQQBrowserWithoutAD(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IBigEmotionService
 * JD-Core Version:    0.7.0.1
 */