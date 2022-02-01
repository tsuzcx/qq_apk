package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardNewPhotoWallView;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import java.util.LinkedList;

public class ProfileCardDiyPhotoWallView
  extends ProfileCardNewPhotoWallView
{
  private int a = -16777216;
  private int b = 10;
  private String c;
  
  public ProfileCardDiyPhotoWallView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProfileCardDiyPhotoWallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected URLDrawable a(String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
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
  
  public void genImg(LinkedList<ProfilePhotoWall> paramLinkedList, int paramInt)
  {
    super.genImg(paramLinkedList, paramInt);
  }
  
  public ViewGroup getImageView(int paramInt1, int paramInt2, int paramInt3)
  {
    ViewGroup localViewGroup = super.getImageView(paramInt1, paramInt2, paramInt3);
    if ((!TextUtils.isEmpty(this.c)) && (this.c.startsWith("http")))
    {
      localViewGroup.setBackgroundDrawable(a(this.c, new ProfileTemplateBase.NinePatchDecoderHandler(paramInt1 * 2, paramInt2 * 2)));
      return localViewGroup;
    }
    localViewGroup.setBackgroundColor(this.a);
    return localViewGroup;
  }
  
  protected View getImageViewLayout()
  {
    View localView = this.mLayoutInflater.inflate(2131628460, null);
    int i = this.b;
    localView.setPadding(i, i, i, i);
    return localView;
  }
  
  public void setBorderImgUrl(String paramString)
  {
    this.c = paramString;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setItemViewBorderColor(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setMargin(int paramInt)
  {
    this.mMargin = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.ProfileCardDiyPhotoWallView
 * JD-Core Version:    0.7.0.1
 */