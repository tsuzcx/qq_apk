package com.tencent.mobileqq.vip.diy.common;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.util.URLUtil;
import cooperation.vip.jsoninflate.model.ViewModel;

public class DIYImageViewModule
  extends ViewModel
{
  private ImageView a;
  private String b;
  
  public DIYImageViewModule(String paramString1, View paramView, @NonNull String paramString2)
  {
    super(paramString1, paramView);
    if ((paramView != null) && ((paramView instanceof DIYImageView))) {
      this.a = ((DIYImageView)paramView).getContentView();
    }
    this.b = paramString2;
  }
  
  private ImageView.ScaleType b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return ImageView.ScaleType.CENTER_CROP;
    }
    if ("center_crop".equals(paramString)) {
      return ImageView.ScaleType.CENTER_CROP;
    }
    if ("fit_center".equals(paramString)) {
      return ImageView.ScaleType.FIT_CENTER;
    }
    return ImageView.ScaleType.CENTER_CROP;
  }
  
  public void a()
  {
    super.a();
    if (this.h != null)
    {
      if (this.a == null) {
        return;
      }
      if ((this.h.getParent() != null) && ((this.h.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.h.getParent()).setClipChildren(false);
      }
      ViewGroup.LayoutParams localLayoutParams1 = this.h.getLayoutParams();
      ViewGroup.LayoutParams localLayoutParams2 = this.a.getLayoutParams();
      if ((localLayoutParams1 != null) && (localLayoutParams2 != null))
      {
        localLayoutParams2.width = localLayoutParams1.width;
        localLayoutParams2.height = localLayoutParams1.height;
        this.a.setLayoutParams(localLayoutParams2);
      }
    }
  }
  
  protected void a(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.startsWith("http"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (!URLUtil.e((String)localObject)) {
      return;
    }
    paramString = URLDrawable.URLDrawableOptions.obtain();
    if ((this.j > 0) && (this.k > 0))
    {
      paramString.mRequestWidth = this.j;
      paramString.mRequestHeight = this.k;
    }
    paramString.mLoadingDrawable = URLDrawableHelperConstants.a;
    paramString.mFailedDrawable = URLDrawableHelperConstants.a;
    paramString.mPlayGifImage = false;
    paramString = URLDrawable.getDrawable((String)localObject, paramString);
    if (paramString != null) {
      this.a.setImageDrawable(paramString);
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (!(this.h instanceof DIYImageView))
    {
      AssertUtils.fail("JsonInflateViewModel current view type illegal!", new Object[0]);
      return;
    }
    if ("content".equals(paramString1))
    {
      a(paramString2);
      return;
    }
    if ("scale_type".equals(paramString1)) {
      this.a.setScaleType(b(paramString2));
    }
  }
  
  protected void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.common.DIYImageViewModule
 * JD-Core Version:    0.7.0.1
 */