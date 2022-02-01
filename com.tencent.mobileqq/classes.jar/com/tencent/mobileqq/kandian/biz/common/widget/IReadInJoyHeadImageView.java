package com.tencent.mobileqq.kandian.biz.common.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/widget/IReadInJoyHeadImageView;", "", "comLayout", "", "i", "", "i1", "i2", "i3", "getComMeasuredHeight", "getComMeasuredWidth", "getView", "Landroid/view/View;", "measureComponent", "widthMeasureSpec", "heightMeasureSpec", "onComLayout", "changed", "", "l", "t", "r", "b", "onComMeasure", "onLoadUserInfoFailed", "uin", "", "errMsg", "onLoadUserInfoSucceed", "userInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ReadInJoyUserInfo;", "setHeadImgByUin", "", "useDefaultPlaceholder", "userInfoCallBack", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "useRealTimeRead", "uinStr", "setImageBitmap", "bm", "Landroid/graphics/Bitmap;", "setImagePlaceHolder", "Ljava/lang/Object;", "placeHolder", "Landroid/graphics/drawable/Drawable;", "setImageSrc", "path", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyHeadImageView
{
  @Nullable
  public abstract Object a(@Nullable Drawable paramDrawable);
  
  @NotNull
  public abstract View getView();
  
  public abstract void setHeadImgByUin(long paramLong, boolean paramBoolean);
  
  public abstract void setHeadImgByUin(@Nullable String paramString);
  
  public abstract void setImageSrc(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.IReadInJoyHeadImageView
 * JD-Core Version:    0.7.0.1
 */