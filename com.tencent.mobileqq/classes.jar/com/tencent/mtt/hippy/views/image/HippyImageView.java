package com.tencent.mtt.hippy.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.utils.UrlUtils;
import com.tencent.mtt.hippy.views.common.CommonBackgroundDrawable;
import com.tencent.mtt.hippy.views.common.CommonBorder;
import com.tencent.mtt.hippy.views.list.HippyRecycler;
import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;
import com.tencent.mtt.supportui.adapters.image.IImageLoaderAdapter;
import com.tencent.mtt.supportui.views.asyncimage.AsyncImageView;
import com.tencent.mtt.supportui.views.asyncimage.AsyncImageView.ScaleType;
import com.tencent.mtt.supportui.views.asyncimage.BackgroundDrawable;
import com.tencent.mtt.supportui.views.asyncimage.ContentDrawable;

public class HippyImageView
  extends AsyncImageView
  implements HippyViewBase, CommonBorder, HippyRecycler
{
  public static final String IMAGE_TYPE_APNG = "apng";
  private boolean isGifPaused = false;
  protected NativeGestureDispatcher mGestureDispatcher;
  private long mGifLastPlayTime = -1L;
  private boolean mGifMatrixComputed = false;
  private Movie mGifMovie;
  private long mGifMovieStart;
  private int mGifProgress = 0;
  private float mGifScaleX = 1.0F;
  private float mGifScaleY = 1.0F;
  private int mGifStartX = 0;
  private int mGifStartY = 0;
  private boolean mHasSetTempBackgroundColor = false;
  protected String mHippyImageViewDefalutImgeUrl = null;
  private HippyMap mIniProps = new HippyMap();
  private Rect mNinePatchRect;
  private HippyImageView.OnErrorEvent mOnErrorEvent;
  private HippyImageView.OnLoadEndEvent mOnLoadEndEvent;
  private HippyImageView.OnLoadEvent mOnLoadEvent;
  private HippyImageView.OnLoadStartEvent mOnLoadStartEvent;
  private int mRepeatCount = -1;
  private boolean[] mShouldSendImageEvent = new boolean[HippyImageView.ImageEvent.values().length];
  private int mShowCount = 0;
  private boolean mUserHasSetBackgroudnColor = false;
  private int mUserSetBackgroundColor = 0;
  
  public HippyImageView(Context paramContext)
  {
    super(paramContext);
    paramContext = ((HippyInstanceContext)paramContext).getEngineContext();
    if (paramContext != null) {
      setImageAdapter(paramContext.getGlobalConfigs().getImageLoaderAdapter());
    }
  }
  
  private void computeMatrixParams()
  {
    AsyncImageView.ScaleType localScaleType;
    if (!this.mGifMatrixComputed)
    {
      this.mGifStartX = 0;
      this.mGifStartY = 0;
      this.mGifScaleX = 1.0F;
      this.mGifScaleY = 1.0F;
      if ((this.mGifMovie.width() > 0) && (this.mGifMovie.height() > 0) && (getWidth() > 0) && (getHeight() > 0))
      {
        this.mGifScaleX = (getWidth() / this.mGifMovie.width());
        this.mGifScaleY = (getHeight() / this.mGifMovie.height());
      }
      if (this.mScaleType == null) {
        break label220;
      }
      localScaleType = this.mScaleType;
      switch (HippyImageView.2.$SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[localScaleType.ordinal()])
      {
      }
    }
    for (;;)
    {
      if (this.mScaleType != AsyncImageView.ScaleType.ORIGIN)
      {
        this.mGifStartX = ((int)((getWidth() / this.mGifScaleX - this.mGifMovie.width()) / 2.0F));
        this.mGifStartY = ((int)((getHeight() / this.mGifScaleY - this.mGifMovie.height()) / 2.0F));
      }
      this.mGifMatrixComputed = true;
      return;
      label220:
      localScaleType = AsyncImageView.ScaleType.FIT_XY;
      break;
      this.mGifScaleX = 1.0F;
      this.mGifScaleY = 1.0F;
      continue;
      if (this.mGifScaleX > this.mGifScaleY)
      {
        this.mGifScaleX = this.mGifScaleY;
      }
      else
      {
        this.mGifScaleY = this.mGifScaleX;
        continue;
        if (this.mGifScaleX < this.mGifScaleY)
        {
          this.mGifScaleX = this.mGifScaleY;
        }
        else
        {
          this.mGifScaleY = this.mGifScaleX;
          continue;
          this.mGifScaleY = 1.0F;
          this.mGifScaleX = 1.0F;
        }
      }
    }
  }
  
  private HippyImageView.OnErrorEvent getOnErrorEvent()
  {
    if (this.mOnErrorEvent == null) {
      this.mOnErrorEvent = new HippyImageView.OnErrorEvent(this, "onError");
    }
    return this.mOnErrorEvent;
  }
  
  private HippyImageView.OnLoadEndEvent getOnLoadEndEvent()
  {
    if (this.mOnLoadEndEvent == null) {
      this.mOnLoadEndEvent = new HippyImageView.OnLoadEndEvent(this, "onLoadEnd");
    }
    return this.mOnLoadEndEvent;
  }
  
  private HippyImageView.OnLoadEvent getOnLoadEvent()
  {
    if (this.mOnLoadEvent == null) {
      this.mOnLoadEvent = new HippyImageView.OnLoadEvent(this, "onLoad");
    }
    return this.mOnLoadEvent;
  }
  
  private HippyImageView.OnLoadStartEvent getOnLoadStartEvent()
  {
    if (this.mOnLoadStartEvent == null) {
      this.mOnLoadStartEvent = new HippyImageView.OnLoadStartEvent(this, "onLoadStart");
    }
    return this.mOnLoadStartEvent;
  }
  
  public void afterSetContent(String paramString)
  {
    restoreBackgroundColorAfterSetContent();
  }
  
  public void clear()
  {
    this.mTintColor = 0;
  }
  
  public void doFetchImage(Object paramObject, int paramInt)
  {
    if (this.mImageAdapter != null)
    {
      if (paramObject != null) {
        this.mIniProps.pushObject("extraData", paramObject);
      }
      if (paramInt != SOURCE_TYPE_SRC) {
        break label57;
      }
    }
    label57:
    for (paramObject = this.mUrl;; paramObject = this.mDefaultSourceUrl)
    {
      this.mImageAdapter.fetchImage(paramObject, new HippyImageView.1(this, paramInt), this.mIniProps);
      return;
    }
  }
  
  protected boolean drawGIF(Canvas paramCanvas)
  {
    if (this.mGifMovie == null) {
      return false;
    }
    int j = this.mGifMovie.duration();
    int i = j;
    if (j == 0) {
      i = 1000;
    }
    long l = System.currentTimeMillis();
    if (!this.isGifPaused)
    {
      if (this.mGifLastPlayTime == -1L) {
        break label158;
      }
      this.mGifProgress = ((int)(this.mGifProgress + (l - this.mGifLastPlayTime)));
      if (this.mGifProgress > i) {
        this.mGifProgress = 0;
      }
    }
    label158:
    for (this.mGifLastPlayTime = l;; this.mGifLastPlayTime = l)
    {
      computeMatrixParams();
      this.mGifMovie.setTime(this.mGifProgress);
      paramCanvas.save();
      paramCanvas.scale(this.mGifScaleX, this.mGifScaleY);
      this.mGifMovie.draw(paramCanvas, this.mGifStartX, this.mGifStartY);
      paramCanvas.restore();
      if (this.isGifPaused) {
        break;
      }
      postInvalidateDelayed(40L);
      return false;
    }
  }
  
  public BackgroundDrawable generateBackgroundDrawable()
  {
    return new CommonBackgroundDrawable();
  }
  
  public ContentDrawable generateContentDrawable()
  {
    return new HippyContentDrawable();
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return this.mGestureDispatcher;
  }
  
  public void handleGetImageFail(Throwable paramThrowable)
  {
    if (this.mShouldSendImageEvent[HippyImageView.ImageEvent.ONERROR.ordinal()] != 0) {
      getOnErrorEvent().send(this, null);
    }
    if (this.mShouldSendImageEvent[HippyImageView.ImageEvent.ONLOAD_END.ordinal()] != 0)
    {
      paramThrowable = new HippyMap();
      paramThrowable.pushInt("success", 0);
      getOnLoadEndEvent().send(this, paramThrowable);
    }
  }
  
  public void handleGetImageStart()
  {
    if (this.mShouldSendImageEvent[HippyImageView.ImageEvent.ONLOAD_START.ordinal()] != 0) {
      getOnLoadStartEvent().send(this, null);
    }
  }
  
  public void handleGetImageSuccess()
  {
    if (this.mShouldSendImageEvent[HippyImageView.ImageEvent.ONLOAD.ordinal()] != 0) {
      getOnLoadEvent().send(this, null);
    }
    if (this.mShouldSendImageEvent[HippyImageView.ImageEvent.ONLOAD_END.ordinal()] != 0)
    {
      HippyMap localHippyMap1 = new HippyMap();
      localHippyMap1.pushInt("success", 1);
      if (this.mSourceDrawable != null)
      {
        Bitmap localBitmap = this.mSourceDrawable.getBitmap();
        if (localBitmap != null)
        {
          HippyMap localHippyMap2 = new HippyMap();
          localHippyMap2.pushInt("width", localBitmap.getWidth());
          localHippyMap2.pushInt("height", localBitmap.getHeight());
          localHippyMap1.pushMap("image", localHippyMap2);
        }
      }
      getOnLoadEndEvent().send(this, localHippyMap1);
    }
  }
  
  public void handleImageRequest(IDrawableTarget paramIDrawableTarget, int paramInt, Object paramObject)
  {
    if (((paramIDrawableTarget instanceof HippyDrawable)) && (((HippyDrawable)paramIDrawableTarget).isAnimated()))
    {
      this.mGifMovie = ((HippyDrawable)paramIDrawableTarget).getGIF();
      setLayerType(1, null);
    }
    if ((!TextUtils.isEmpty(this.mImageType)) && (this.mImageType.equals("apng")) && (paramInt == SOURCE_TYPE_SRC))
    {
      if (paramIDrawableTarget != null)
      {
        paramIDrawableTarget = paramIDrawableTarget.getDrawable();
        if (paramIDrawableTarget != null)
        {
          this.mSourceDrawable = null;
          this.mContentDrawable = paramIDrawableTarget;
          this.mIsUrlFetchSucceed = true;
          setContent(paramInt);
          handleGetImageSuccess();
          return;
        }
      }
      this.mIsUrlFetchSucceed = false;
      if ((paramObject instanceof Throwable)) {}
      for (paramIDrawableTarget = (Throwable)paramObject;; paramIDrawableTarget = null)
      {
        handleGetImageFail(paramIDrawableTarget);
        return;
      }
    }
    super.handleImageRequest(paramIDrawableTarget, paramInt, paramObject);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mGifMovie != null) {
      drawGIF(paramCanvas);
    }
  }
  
  public void onFetchImage(String paramString)
  {
    Drawable localDrawable = getBackground();
    resetContent();
    if ((paramString != null) && ((UrlUtils.isWebUrl(paramString)) || (UrlUtils.isFileUrl(paramString)))) {
      if (!this.mUserHasSetBackgroudnColor) {
        break label125;
      }
    }
    label125:
    for (int i = this.mUserSetBackgroundColor;; i = -3355444)
    {
      if ((localDrawable instanceof CommonBackgroundDrawable))
      {
        ((CommonBackgroundDrawable)localDrawable).setBackgroundColor(i);
        setCustomBackgroundDrawable((CommonBackgroundDrawable)localDrawable);
      }
      for (;;)
      {
        super.setBackgroundColor(i);
        this.mHasSetTempBackgroundColor = true;
        return;
        if (((localDrawable instanceof LayerDrawable)) && (((LayerDrawable)localDrawable).getNumberOfLayers() > 0))
        {
          paramString = ((LayerDrawable)localDrawable).getDrawable(0);
          if ((paramString instanceof CommonBackgroundDrawable))
          {
            ((CommonBackgroundDrawable)paramString).setBackgroundColor(i);
            setCustomBackgroundDrawable((CommonBackgroundDrawable)paramString);
          }
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    boolean bool1 = bool2;
    if (this.mGestureDispatcher != null) {
      bool1 = bool2 | this.mGestureDispatcher.handleTouchEvent(paramMotionEvent);
    }
    return bool1;
  }
  
  public void pause()
  {
    this.isGifPaused = true;
    this.mGifLastPlayTime = -1L;
  }
  
  public void resetContent()
  {
    super.resetContent();
    this.mGifMovie = null;
    this.mGifProgress = 0;
    this.mGifLastPlayTime = -1L;
  }
  
  public void resetProps()
  {
    HippyViewController.resetTransform(this);
    setAlpha(1.0F);
    this.mTintColor = 0;
    this.mBGDrawable = null;
    this.mContentDrawable = null;
    this.mScaleType = AsyncImageView.ScaleType.FIT_XY;
    setImagePositionX(0);
    setImagePositionY(0);
    this.mUrl = null;
    this.mImageType = null;
    setBackgroundDrawable(null);
    int i = 0;
    while (i < this.mShouldSendImageEvent.length)
    {
      this.mShouldSendImageEvent[i] = false;
      i += 1;
    }
  }
  
  public void restoreBackgroundColorAfterSetContent()
  {
    if ((this.mBGDrawable != null) && (this.mHasSetTempBackgroundColor))
    {
      this.mBGDrawable.setBackgroundColor(0);
      this.mHasSetTempBackgroundColor = false;
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mUserHasSetBackgroudnColor = true;
    this.mUserSetBackgroundColor = paramInt;
    super.setBackgroundColor(paramInt);
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher)
  {
    this.mGestureDispatcher = paramNativeGestureDispatcher;
  }
  
  public void setHippyViewDefaultSource(String paramString)
  {
    this.mHippyImageViewDefalutImgeUrl = paramString;
    setDefaultSource(this.mHippyImageViewDefalutImgeUrl);
  }
  
  protected void setImageEventEnable(int paramInt, boolean paramBoolean)
  {
    this.mShouldSendImageEvent[paramInt] = paramBoolean;
  }
  
  public void setIniProps(HippyMap paramHippyMap)
  {
    int m = 0;
    int j = 0;
    this.mIniProps.clear();
    int i;
    if (paramHippyMap.containsKey("style"))
    {
      HippyMap localHippyMap = paramHippyMap.getMap("style");
      if (localHippyMap != null) {
        if (localHippyMap.containsKey("width"))
        {
          i = Math.round(PixelUtil.dp2px(localHippyMap.getDouble("width")));
          if (localHippyMap.containsKey("height")) {
            j = Math.round(PixelUtil.dp2px(localHippyMap.getDouble("height")));
          }
          k = i;
          m = j;
          if (localHippyMap.containsKey("resizeMode"))
          {
            this.mIniProps.pushString("resizeMode", localHippyMap.getString("resizeMode"));
            m = j;
          }
        }
      }
    }
    for (int k = i;; k = 0)
    {
      if (paramHippyMap.containsKey("imageType")) {
        this.mIniProps.pushString("imageType", paramHippyMap.getString("imageType"));
      }
      this.mIniProps.pushBoolean("isGif", paramHippyMap.getBoolean("isGif"));
      this.mIniProps.pushInt("width", k);
      this.mIniProps.pushInt("height", m);
      return;
      i = 0;
      break;
    }
  }
  
  public void setNinePatchCoordinate(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean) {
      this.mNinePatchRect = null;
    }
    for (;;)
    {
      if ((this.mContentDrawable instanceof HippyContentDrawable))
      {
        ((HippyContentDrawable)this.mContentDrawable).setNinePatchCoordinate(this.mNinePatchRect);
        invalidate();
      }
      return;
      if (this.mNinePatchRect == null) {
        this.mNinePatchRect = new Rect();
      }
      this.mNinePatchRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.mRepeatCount = paramInt;
    if (this.mRepeatCount == 0) {
      this.mRepeatCount = 1;
    }
    this.mShowCount = 0;
  }
  
  public boolean shouldUseFetchImageMode(String paramString)
  {
    return (UrlUtils.isWebUrl(paramString)) || (UrlUtils.isFileUrl(paramString));
  }
  
  public void startPlay()
  {
    this.isGifPaused = false;
    invalidate();
  }
  
  public void updateContentDrawableProperty()
  {
    super.updateContentDrawableProperty();
    if ((this.mContentDrawable instanceof HippyContentDrawable)) {
      ((HippyContentDrawable)this.mContentDrawable).setNinePatchCoordinate(this.mNinePatchRect);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.image.HippyImageView
 * JD-Core Version:    0.7.0.1
 */