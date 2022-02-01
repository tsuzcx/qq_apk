package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bhzv;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.ProfilePhotoWall;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.ProfileCardNewPhotoWallView;
import java.util.LinkedList;

public class ProfileCardDiyPhotoWallView
  extends ProfileCardNewPhotoWallView
{
  private String b;
  private int d = -16777216;
  private int e = 10;
  
  public ProfileCardDiyPhotoWallView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProfileCardDiyPhotoWallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public View a()
  {
    View localView = this.a.inflate(2131562059, null);
    localView.setPadding(this.e, this.e, this.e, this.e);
    return localView;
  }
  
  public ViewGroup a(int paramInt1, int paramInt2, int paramInt3)
  {
    ViewGroup localViewGroup = super.a(paramInt1, paramInt2, paramInt3);
    if ((!TextUtils.isEmpty(this.b)) && (this.b.startsWith("http")))
    {
      localViewGroup.setBackgroundDrawable(a(this.b, new bhzv(paramInt1 * 2, paramInt2 * 2)));
      return localViewGroup;
    }
    localViewGroup.setBackgroundColor(this.d);
    return localViewGroup;
  }
  
  protected URLDrawable a(String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mPlayGifImage = false;
    if (paramDecodeHandler != null) {
      localURLDrawableOptions.mMemoryCacheKeySuffix = paramDecodeHandler.toString();
    }
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDecodeHandler(paramDecodeHandler);
    return paramString;
  }
  
  public void a(LinkedList<ProfilePhotoWall> paramLinkedList, int paramInt)
  {
    super.a(paramLinkedList, paramInt);
  }
  
  public void setBorderImgUrl(String paramString)
  {
    this.b = paramString;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setItemViewBorderColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setMargin(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.ProfileCardDiyPhotoWallView
 * JD-Core Version:    0.7.0.1
 */