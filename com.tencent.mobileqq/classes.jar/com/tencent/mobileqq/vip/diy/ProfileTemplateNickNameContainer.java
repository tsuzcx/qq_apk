package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase.BackGroundUpdateListener;
import com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase.NinePatchDecoderHandler;
import com.tencent.mobileqq.widget.ProfileNameView;

public class ProfileTemplateNickNameContainer
  extends ViewGroup
{
  private ProfileNameView a;
  private int b;
  private String c;
  private boolean d;
  private ProfileTemplateBase.NinePatchDecoderHandler e = new ProfileTemplateBase.NinePatchDecoderHandler();
  private int f;
  private int g;
  
  public ProfileTemplateNickNameContainer(Context paramContext, ProfileNameView paramProfileNameView)
  {
    super(paramContext);
    this.a = paramProfileNameView;
    addView(this.a);
  }
  
  protected URLDrawable a(@NonNull String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mPlayGifImage = false;
    if (paramDecodeHandler != null) {
      localURLDrawableOptions.mMemoryCacheKeySuffix = paramDecodeHandler.toString();
    }
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDecodeHandler(paramDecodeHandler);
    return paramString;
  }
  
  public ETTextViewPlus getTextView()
  {
    return this.a.getEtNameView();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = this.a.getLayoutWidth();
    int i = this.b;
    int j = i + m;
    int k = paramInt3 - paramInt1;
    if (j > k)
    {
      paramInt1 = Math.max(0, paramInt3 - m);
      paramInt3 = k;
    }
    else
    {
      paramInt1 = i;
      paramInt3 = j;
      if (this.d)
      {
        paramInt1 = k / 2 - (j - i) / 2;
        paramInt3 = paramInt1 + m;
      }
    }
    Object localObject = this.a;
    paramInt2 = paramInt4 - paramInt2;
    ((ProfileNameView)localObject).layout(paramInt1, 0, paramInt3, paramInt2);
    if (!TextUtils.isEmpty(this.c))
    {
      this.e.a(paramInt3 - paramInt1, paramInt2);
      localObject = a(this.c, this.e);
      ProfileTemplateBase.BackGroundUpdateListener.a((URLDrawable)localObject, this.a);
      this.a.setBackgroundDrawable((Drawable)localObject);
      return;
    }
    this.a.setBackgroundDrawable(null);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.a.measure(paramInt2, paramInt2);
    setMeasuredDimension(getMeasuredWidth(), this.a.getMeasuredHeight());
  }
  
  public void setTextBgUrl(String paramString)
  {
    this.c = paramString;
    if (!TextUtils.isEmpty(this.c))
    {
      double d1 = UIUtils.c(getContext());
      Double.isNaN(d1);
      this.f = ((int)(0.005D * d1));
      Double.isNaN(d1);
      this.g = ((int)(d1 * 0.03D));
    }
    else
    {
      this.f = 0;
      this.g = 0;
      this.a.setBackgroundDrawable(null);
    }
    paramString = this.a.getEtNameView();
    int i = this.g;
    int j = this.f;
    paramString.setPadding(i, j, i, j);
  }
  
  public void setTextCenter()
  {
    this.d = true;
  }
  
  public void setTextViewX(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ProfileTemplateNickNameContainer
 * JD-Core Version:    0.7.0.1
 */