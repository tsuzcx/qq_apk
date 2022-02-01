package com.tencent.mobileqq.kandian.biz.share.api;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/api/IWxShareHelperFromReadInjoy;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addObserver", "", "observer", "Lcom/tencent/mobileqq/kandian/biz/share/api/IWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener;", "handleWXEntryActivityIntent", "wxEntryActivity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "removeObserver", "shareImageToWX", "filePath", "", "bmp", "Landroid/graphics/Bitmap;", "scene", "", "outSquare", "", "shareToMiniProgramWithPath", "transaction", "title", "icon", "description", "webPageUrl", "path", "shareVideo", "shareVideoMiniProgram", "rowKey", "shareWebPage", "WXShareHelperFromReadInjoyListener", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IWxShareHelperFromReadInjoy
  extends QRouteApi
{
  public abstract void addObserver(@Nullable IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener paramWXShareHelperFromReadInjoyListener);
  
  public abstract void handleWXEntryActivityIntent(@Nullable Activity paramActivity, @Nullable Intent paramIntent);
  
  public abstract void removeObserver(@Nullable IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener paramWXShareHelperFromReadInjoyListener);
  
  public abstract void shareImageToWX(@Nullable String paramString, @Nullable Bitmap paramBitmap, int paramInt, boolean paramBoolean);
  
  public abstract void shareToMiniProgramWithPath(@Nullable String paramString1, @Nullable String paramString2, @Nullable Bitmap paramBitmap, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5);
  
  public abstract void shareVideo(@Nullable String paramString1, @Nullable String paramString2, @Nullable Bitmap paramBitmap, @Nullable String paramString3, @Nullable String paramString4, int paramInt);
  
  public abstract void shareVideoMiniProgram(@Nullable String paramString1, @Nullable String paramString2, @Nullable Bitmap paramBitmap, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5);
  
  public abstract void shareWebPage(@Nullable String paramString1, @Nullable String paramString2, @Nullable Bitmap paramBitmap, @Nullable String paramString3, @Nullable String paramString4, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy
 * JD-Core Version:    0.7.0.1
 */