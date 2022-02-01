package com.tencent.mobileqq.kandian.biz.share.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.kandian.biz.share.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/api/impl/WxShareHelperFromReadInjoyImpl;", "Lcom/tencent/mobileqq/kandian/biz/share/api/IWxShareHelperFromReadInjoy;", "()V", "addObserver", "", "observer", "Lcom/tencent/mobileqq/kandian/biz/share/api/IWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener;", "handleWXEntryActivityIntent", "wxEntryActivity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "removeObserver", "shareImageToWX", "filePath", "", "bmp", "Landroid/graphics/Bitmap;", "scene", "", "outSquare", "", "shareToMiniProgramWithPath", "transaction", "title", "icon", "description", "webPageUrl", "path", "shareVideo", "shareVideoMiniProgram", "rowKey", "shareWebPage", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class WxShareHelperFromReadInjoyImpl
  implements IWxShareHelperFromReadInjoy
{
  public WxShareHelperFromReadInjoyImpl()
  {
    WxShareHelperFromReadInjoy localWxShareHelperFromReadInjoy = WxShareHelperFromReadInjoy.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localWxShareHelperFromReadInjoy, "WxShareHelperFromReadInjoy.getInstance()");
    this.$$delegate_0 = localWxShareHelperFromReadInjoy;
  }
  
  public void addObserver(@Nullable IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener paramWXShareHelperFromReadInjoyListener)
  {
    this.$$delegate_0.addObserver(paramWXShareHelperFromReadInjoyListener);
  }
  
  public void handleWXEntryActivityIntent(@Nullable Activity paramActivity, @Nullable Intent paramIntent)
  {
    this.$$delegate_0.handleWXEntryActivityIntent(paramActivity, paramIntent);
  }
  
  public void removeObserver(@Nullable IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener paramWXShareHelperFromReadInjoyListener)
  {
    this.$$delegate_0.removeObserver(paramWXShareHelperFromReadInjoyListener);
  }
  
  public void shareImageToWX(@Nullable String paramString, @Nullable Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    this.$$delegate_0.shareImageToWX(paramString, paramBitmap, paramInt, paramBoolean);
  }
  
  public void shareToMiniProgramWithPath(@Nullable String paramString1, @Nullable String paramString2, @Nullable Bitmap paramBitmap, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5)
  {
    this.$$delegate_0.shareToMiniProgramWithPath(paramString1, paramString2, paramBitmap, paramString3, paramString4, paramString5);
  }
  
  public void shareVideo(@Nullable String paramString1, @Nullable String paramString2, @Nullable Bitmap paramBitmap, @Nullable String paramString3, @Nullable String paramString4, int paramInt)
  {
    this.$$delegate_0.shareVideo(paramString1, paramString2, paramBitmap, paramString3, paramString4, paramInt);
  }
  
  public void shareVideoMiniProgram(@Nullable String paramString1, @Nullable String paramString2, @Nullable Bitmap paramBitmap, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5)
  {
    this.$$delegate_0.shareVideoMiniProgram(paramString1, paramString2, paramBitmap, paramString3, paramString4, paramString5);
  }
  
  public void shareWebPage(@Nullable String paramString1, @Nullable String paramString2, @Nullable Bitmap paramBitmap, @Nullable String paramString3, @Nullable String paramString4, int paramInt)
  {
    this.$$delegate_0.shareWebPage(paramString1, paramString2, paramBitmap, paramString3, paramString4, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.api.impl.WxShareHelperFromReadInjoyImpl
 * JD-Core Version:    0.7.0.1
 */