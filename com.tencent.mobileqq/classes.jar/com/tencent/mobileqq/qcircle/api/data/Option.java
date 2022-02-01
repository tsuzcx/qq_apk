package com.tencent.mobileqq.qcircle.api.data;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class Option
{
  public static final Drawable DEFAULT_FAILED_DRAWABLE = RFApplication.getApplication().getResources().getDrawable(2130845171);
  public static final Drawable DEFAULT_LOADING_DRAWABLE = RFApplication.getApplication().getResources().getDrawable(2130848395);
  public static final int DEFAULT_PIC_TYPE = 0;
  public static final int LOAD_FROM_CACHE = 0;
  public static final int LOAD_FROM_NET = 2;
  public static final int LOAD_FROM_SDCARD = 1;
  public static final int MAX_RETRY_COUNT = 3;
  public static final int NINE_PATCH_PIC_TYPE = 2;
  public static final int PIC_TYPE_AVATAR = 3;
  public static final int PRIORITY_DEFAULT = 0;
  public static final int PRIORITY_PRELOAD = 1;
  public static final int SHARE_P_PIC_TYPE = 1;
  private String mCacheKey;
  public Long mDecodeStartTime;
  public Long mDownLoadStartTime;
  private Drawable mFailedDrawable = DEFAULT_FAILED_DRAWABLE;
  private String mIP;
  private boolean mIsFromPreLoad;
  private boolean mIsPreDecode = true;
  public int mLoadType = 2;
  private Drawable mLoadingDrawable = DEFAULT_LOADING_DRAWABLE;
  private String mLocalPath;
  private int mPicType;
  private int mPriority = 0;
  private int mRequestHeight;
  private int mRequestWidth;
  private Bitmap mResultBitMap;
  private int mRetryCount;
  private int mSeq;
  public Long mStartTime;
  private ImageView mTargetView;
  private String mUrl;
  
  public static Option getDefaultOptions(ImageView paramImageView)
  {
    Option localOption = new Option();
    localOption.mLoadingDrawable = RFApplication.getApplication().getResources().getDrawable(2130842613);
    localOption.mFailedDrawable = RFApplication.getApplication().getResources().getDrawable(2130845171);
    if ((paramImageView != null) && (paramImageView.getLayoutParams() != null))
    {
      localOption.mRequestWidth = paramImageView.getLayoutParams().width;
      localOption.mRequestHeight = paramImageView.getLayoutParams().height;
    }
    return localOption;
  }
  
  public boolean continueRetry()
  {
    return this.mRetryCount < 3;
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
  
  public int getRetryCount()
  {
    return this.mRetryCount;
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
    Object localObject = this.mTargetView;
    if ((localObject != null) && ((((ImageView)localObject).getTag(2131441767) instanceof String)))
    {
      localObject = (String)this.mTargetView.getTag(2131441767);
      if (((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getUniKeyFromUrl((String)localObject).equals(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getUniKeyFromUrl(this.mUrl)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("seq = ");
        ((StringBuilder)localObject).append(this.mSeq);
        ((StringBuilder)localObject).append(" is valid, url:");
        ((StringBuilder)localObject).append(this.mUrl);
        QLog.i("QCircleFeedPicLoader", 1, ((StringBuilder)localObject).toString());
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seq = ");
      localStringBuilder.append(this.mSeq);
      localStringBuilder.append(" is unValid, tagUrl:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("-----original url:");
      localStringBuilder.append(this.mUrl);
      QLog.i("QCircleFeedPicLoader", 1, localStringBuilder.toString());
      return false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seq = ");
    ((StringBuilder)localObject).append(this.mSeq);
    ((StringBuilder)localObject).append(" unValid mTargetView is empty,isFromPreload:");
    ((StringBuilder)localObject).append(this.mIsFromPreLoad);
    QLog.i("QCircleFeedPicLoader", 1, ((StringBuilder)localObject).toString());
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
        paramImageView.setTag(2131441767, this.mUrl);
      }
    }
    return this;
  }
  
  public Option setUrl(String paramString)
  {
    this.mUrl = paramString;
    if (this.mTargetView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return this;
      }
      if ((((this.mTargetView.getTag(2131441767) instanceof String)) && (!this.mTargetView.getTag(2131441767).equals(this.mUrl))) || (this.mTargetView.getTag(2131441767) == null)) {
        this.mTargetView.setTag(2131441767, this.mUrl);
      }
    }
    return this;
  }
  
  public Option updateRetryCount()
  {
    this.mRetryCount += 1;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.data.Option
 * JD-Core Version:    0.7.0.1
 */