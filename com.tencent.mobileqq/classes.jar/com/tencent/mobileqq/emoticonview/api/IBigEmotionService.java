package com.tencent.mobileqq.emoticonview.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.SpannableString;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListener;
import com.tencent.mobileqq.emoticon.IEmoticonPackage;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IBigEmotionService
  extends QRouteApi
{
  public abstract void addEmotionPanelPayBackListener(EmotionPanelPayBackListener paramEmotionPanelPayBackListener);
  
  public abstract SpannableString dealIPSiteString(String paramString);
  
  public abstract boolean emoticonPkgNeedUpdate(int paramInt1, int paramInt2);
  
  public abstract Drawable getCoverBitmap(int paramInt, String paramString);
  
  public abstract String getCoverPath(int paramInt, String paramString);
  
  public abstract String getCoverUrl(int paramInt, String paramString);
  
  public abstract float getEmoticonPackageLoadingProgress(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString);
  
  public abstract Drawable getIPSiteDrawable(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener, Drawable paramDrawable);
  
  public abstract Parcelable getIPSiteInfoFromBytes(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, byte[] paramArrayOfByte);
  
  public abstract float getStatusPercent(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString);
  
  public abstract boolean hasRecommendDressup(String paramString, boolean paramBoolean);
  
  public abstract boolean isAuthorized(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt);
  
  public abstract boolean isKandianType(int paramInt);
  
  public abstract boolean isRichIPSite(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Parcelable paramParcelable);
  
  public abstract void openEmojiDetailPage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2);
  
  public abstract void openEmojiDetailPage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt1, String paramString2, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, String paramString3);
  
  public abstract void openQQBrowserWithoutAD(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt);
  
  public abstract void pullEmoticonPackage(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, IEmoticonPackage paramIEmoticonPackage, boolean paramBoolean, int paramInt);
  
  public abstract void removeEmotionPanelPayBackListener(EmotionPanelPayBackListener paramEmotionPanelPayBackListener);
  
  public abstract void reportAddEmoticonPkg(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString, int paramInt);
  
  public abstract void reportCommercialDrainage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7);
  
  public abstract void reportCommercialDrainage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public abstract void sendPayBackMessage(IEmoticonMainPanelApp paramIEmoticonMainPanelApp);
  
  public abstract void startActivityForResult(Activity paramActivity, String paramString, int paramInt);
  
  public abstract void stopEmoticonPackageDownload(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IBigEmotionService
 * JD-Core Version:    0.7.0.1
 */