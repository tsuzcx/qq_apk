package com.tencent.mobileqq.qcircle.api.data;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.MobileQQ;

public class Option
{
  public static final int DEFAULT_PIC_TYPE = 0;
  public static final int LOAD_FROM_CACHE = 0;
  public static final int LOAD_FROM_NET = 2;
  public static final int LOAD_FROM_SDCARD = 1;
  public static final int NINE_PATCH_PIC_TYPE = 2;
  public static final int PIC_TYPE_AVATAR = 3;
  public static final int PRIORITY_DEFAULT = 0;
  public static final int PRIORITY_PRELOAD = 1;
  public static final int SHARE_P_PIC_TYPE = 1;
  public static final Drawable sDefaultFailedDrawable = MobileQQ.sMobileQQ.getResources().getDrawable(2130844223);
  public static final Drawable sDefaultLoadingDrawable = MobileQQ.sMobileQQ.getResources().getDrawable(2130846965);
  private String mCacheKey;
  public Long mDecodeStartTime;
  public Long mDownLoadStartTime;
  private Drawable mFailedDrawable = sDefaultFailedDrawable;
  private String mIP;
  private boolean mIsFromPreLoad;
  private boolean mIsPreDecode = true;
  public int mLoadType = 2;
  private Drawable mLoadingDrawable = sDefaultLoadingDrawable;
  private String mLocalPath;
  private int mPicType;
  private int mPriority = 0;
  private int mRequestHeight;
  private int mRequestWidth;
  private Bitmap mResultBitMap;
  private int mSeq;
  public Long mStartTime;
  private ImageView mTargetView;
  private String mUrl;
  
  public static Option getDefaultOptions(ImageView paramImageView)
  {
    Option localOption = new Option();
    localOption.mLoadingDrawable = MobileQQ.sMobileQQ.getResources().getDrawable(2130841812);
    localOption.mFailedDrawable = MobileQQ.sMobileQQ.getResources().getDrawable(2130844223);
    if ((paramImageView != null) && (paramImageView.getLayoutParams() != null))
    {
      localOption.mRequestWidth = paramImageView.getLayoutParams().width;
      localOption.mRequestHeight = paramImageView.getLayoutParams().height;
    }
    return localOption;
  }
  
  public String getCacheKey()
  {
    return this.mCacheKey;
  }
  
  public Drawable getFailDrawable()
  {
    return this.mFailedDrawable;
  }
  
  public String getIP()
  {
    if (TextUtils.isEmpty(this.mIP)) {
      return "";
    }
    return this.mIP;
  }
  
  public Drawable getLoadingDrawable()
  {
    return this.mLoadingDrawable;
  }
  
  public String getLocalPath()
  {
    return this.mLocalPath;
  }
  
  public int getPicType()
  {
    return this.mPicType;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public int getRequestHeight()
  {
    return this.mRequestHeight;
  }
  
  public int getRequestWidth()
  {
    return this.mRequestWidth;
  }
  
  public Bitmap getResultBitMap()
  {
    return this.mResultBitMap;
  }
  
  public int getSeq()
  {
    return this.mSeq;
  }
  
  public ImageView getTargetView()
  {
    return this.mTargetView;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public boolean isFromPreload()
  {
    return this.mIsFromPreLoad;
  }
  
  public boolean isPreDecode()
  {
    return this.mIsPreDecode;
  }
  
  public boolean isValid()
  {
    if ((this.mTargetView != null) && ((this.mTargetView.getTag(2131374369) instanceof String)))
    {
      String str = (String)this.mTargetView.getTag(2131374369);
      if (((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getUniKeyFromUrl(str).equals(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getUniKeyFromUrl(this.mUrl)))
      {
        RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.mSeq + " is valid, url:" + this.mUrl);
        return true;
      }
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.mSeq + " is unValid, tagUrl:" + str + "-----original url:" + this.mUrl);
      return false;
    }
    RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + this.mSeq + " unValid mTargetView is empty,isFromPreload:" + this.mIsFromPreLoad);
    return false;
  }
  
  public Option setCacheKey(String paramString)
  {
    this.mCacheKey = paramString;
    return this;
  }
  
  public Option setFailDrawable(Drawable paramDrawable)
  {
    this.mFailedDrawable = paramDrawable;
    return this;
  }
  
  public Option setFromPreLoad(boolean paramBoolean)
  {
    this.mIsFromPreLoad = paramBoolean;
    return this;
  }
  
  public Option setIP(String paramString)
  {
    this.mIP = paramString;
    return this;
  }
  
  public Option setLoadingDrawable(Drawable paramDrawable)
  {
    this.mLoadingDrawable = paramDrawable;
    return this;
  }
  
  public Option setLocalPath(String paramString)
  {
    this.mLocalPath = paramString;
    return this;
  }
  
  public Option setPicType(int paramInt)
  {
    this.mPicType = paramInt;
    return this;
  }
  
  public Option setPredecode(boolean paramBoolean)
  {
    this.mIsPreDecode = paramBoolean;
    return this;
  }
  
  public Option setPriority(int paramInt)
  {
    this.mPriority = paramInt;
    return this;
  }
  
  public Option setRequestHeight(int paramInt)
  {
    this.mRequestHeight = paramInt;
    return this;
  }
  
  public Option setRequestWidth(int paramInt)
  {
    this.mRequestWidth = paramInt;
    return this;
  }
  
  public Option setResultBitMap(Bitmap paramBitmap)
  {
    this.mResultBitMap = paramBitmap;
    return this;
  }
  
  public Option setSeq(int paramInt)
  {
    this.mSeq = paramInt;
    return this;
  }
  
  public Option setTargetView(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.mTargetView = paramImageView;
      if (!TextUtils.isEmpty(this.mUrl)) {
        paramImageView.setTag(2131374369, this.mUrl);
      }
    }
    return this;
  }
  
  public Option setUrl(String paramString)
  {
    this.mUrl = paramString;
    if ((this.mTargetView == null) || (TextUtils.isEmpty(paramString))) {}
    while (((!(this.mTargetView.getTag(2131374369) instanceof String)) || (this.mTargetView.getTag(2131374369).equals(this.mUrl))) && (this.mTargetView.getTag(2131374369) != null)) {
      return this;
    }
    this.mTargetView.setTag(2131374369, this.mUrl);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.data.Option
 * JD-Core Version:    0.7.0.1
 */