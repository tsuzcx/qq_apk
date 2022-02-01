package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSImageUtil;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler.FastBlurDecoder;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSTimeCostUtil;
import com.tencent.pts.utils.PTSValueConvertUtil;
import com.tencent.qphone.base.util.QLog;

public class PTSNodeImage
  extends PTSNodeVirtual<PTSImageView>
{
  public static final String TAG = "PTSNodeImage";
  private float blurRadius = 0.0F;
  private String imageUrl;
  private Drawable normalDrawable;
  private Drawable pressedDrawable;
  private IReadInJoyUserInfoModule.RefreshUserInfoCallBack refreshUserInfoCallBack;
  private long uin;
  
  private PTSNodeImage(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  private String addSmartCrop(String paramString)
  {
    int i = getNodeInfo().getStyle().getWidth();
    int j = getNodeInfo().getStyle().getHeight();
    String str = paramString;
    if (i > 0)
    {
      str = paramString;
      if (j > 0) {
        str = RIJSmartCropUtils.a(paramString, i, j);
      }
    }
    return str;
  }
  
  private void initRefreshUserInfoCallBack()
  {
    if (this.refreshUserInfoCallBack == null) {
      this.refreshUserInfoCallBack = new PTSNodeImage.1(this);
    }
  }
  
  private void loadAvatarByUin(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("PTSNodeImage", 1, "[loadAvatarByUin] uin is null");
      return;
    }
    try
    {
      long l = Long.parseLong(paramString);
      this.uin = l;
      initRefreshUserInfoCallBack();
      paramString = ReadInJoyUserInfoModule.a(l, this.refreshUserInfoCallBack);
      if (paramString != null)
      {
        paramString = ReadInJoyUserInfoModule.a(paramString);
        ((PTSImageView)getView()).setImageSrc(paramString);
        return;
      }
    }
    catch (NumberFormatException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadAvatarByUin] error, e = ");
      localStringBuilder.append(paramString);
      QLog.e("PTSNodeImage", 1, localStringBuilder.toString());
    }
  }
  
  private void setImageSrc(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("image-");
    localStringBuilder.append(paramString);
    PTSTimeCostUtil.start(localStringBuilder.toString());
    ((PTSImageView)getView()).setImageDrawable(((PTSImageView)getView()).getResources().getDrawable(2130841770));
    if (!TextUtils.isEmpty(paramString))
    {
      if (PTSImageUtil.a(paramString)) {
        setNetWorkImage(paramString);
      } else if (PTSImageUtil.b(paramString)) {
        PTSImageUtil.a((PTSImageView)getView(), paramString);
      } else {
        loadAvatarByUin(paramString);
      }
    }
    else {
      QLog.i("PTSNodeImage", 1, "[setImageSrc] imageUrl is null.");
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setImageSrc], imageUrl = ");
    localStringBuilder.append(paramString);
    QLog.i("PTSNodeImage", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("image-");
    localStringBuilder.append(paramString);
    PTSTimeCostUtil.end(localStringBuilder.toString());
  }
  
  private void setNetWorkImage(String paramString)
  {
    paramString = addSmartCrop(paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[setImageSrc], cropUrl = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", blurRadius = ");
    ((StringBuilder)localObject).append(this.blurRadius);
    PTSLog.i("PTSNodeImage", ((StringBuilder)localObject).toString());
    if (this.blurRadius > 0.0F)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = ((PTSImageView)getView()).getResources().getDrawable(2130841770);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
      paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      paramString.setDecodeHandler(new URLDrawableDecodeHandler.FastBlurDecoder((int)this.blurRadius));
      ((PTSImageView)getView()).setImageDrawable(paramString);
      return;
    }
    ((PTSImageView)getView()).setImageSrc(paramString);
  }
  
  private void updatePtsOnPressedSrc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[updatePtsOnPressedSrc], imageUrl = ");
    ((StringBuilder)localObject).append(this.imageUrl);
    ((StringBuilder)localObject).append(", onPressedSrc = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", blurRadius = ");
    ((StringBuilder)localObject).append(this.blurRadius);
    QLog.i("PTSNodeImage", 1, ((StringBuilder)localObject).toString());
    localObject = new StateListDrawable();
    this.normalDrawable = PTSImageUtil.a(getContext(), addSmartCrop(this.imageUrl), (int)this.blurRadius);
    this.pressedDrawable = PTSImageUtil.a(getContext(), addSmartCrop(paramString), (int)this.blurRadius);
    if (this.normalDrawable != null)
    {
      paramString = this.pressedDrawable;
      if (paramString != null)
      {
        ((StateListDrawable)localObject).addState(new int[] { 16842919 }, paramString);
        paramString = this.normalDrawable;
        ((StateListDrawable)localObject).addState(new int[0], paramString);
        ((PTSImageView)getView()).setImageDrawable((Drawable)localObject);
      }
    }
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    setImageSrc(this.imageUrl);
    updatePtsOnPressedSrc(getPtsOnPressSrc());
  }
  
  protected boolean setAttribute(String paramString, Object paramObject)
  {
    boolean bool = super.setAttribute(paramString, paramObject);
    if ("src".equals(paramString))
    {
      this.imageUrl = PTSValueConvertUtil.getString(paramObject);
      bool = true;
    }
    return bool;
  }
  
  protected boolean setStyle(String paramString, Object paramObject)
  {
    boolean bool = super.setStyle(paramString, paramObject);
    if ("filter".equalsIgnoreCase(paramString)) {
      this.blurRadius = PTSValueConvertUtil.getFloat(paramObject);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeImage
 * JD-Core Version:    0.7.0.1
 */