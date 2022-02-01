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
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.utils.LogUtils;
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
import java.util.HashMap;
import java.util.Map;

public class HippyImageView
  extends AsyncImageView
  implements HippyViewBase, CommonBorder, HippyRecycler
{
  public static final String IMAGE_PROPS = "props";
  public static final String IMAGE_TYPE_APNG = "apng";
  public static final String IMAGE_TYPE_GIF = "gif";
  private HippyEngineContext hippyEngineContext;
  private HippyMap initProps = new HippyMap();
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
    this.hippyEngineContext = ((HippyInstanceContext)paramContext).getEngineContext();
    paramContext = this.hippyEngineContext;
    if (paramContext != null) {
      setImageAdapter(paramContext.getGlobalConfigs().getImageLoaderAdapter());
    }
  }
  
  private void computeMatrixParams()
  {
    if (!this.mGifMatrixComputed)
    {
      this.mGifStartX = 0;
      this.mGifStartY = 0;
      float f1 = 1.0F;
      this.mGifScaleX = 1.0F;
      this.mGifScaleY = 1.0F;
      if ((this.mGifMovie.width() > 0) && (this.mGifMovie.height() > 0) && (getWidth() > 0) && (getHeight() > 0))
      {
        this.mGifScaleX = (getWidth() / this.mGifMovie.width());
        this.mGifScaleY = (getHeight() / this.mGifMovie.height());
      }
      AsyncImageView.ScaleType localScaleType;
      if (this.mScaleType != null) {
        localScaleType = this.mScaleType;
      } else {
        localScaleType = AsyncImageView.ScaleType.FIT_XY;
      }
      int i = HippyImageView.2.$SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[localScaleType.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          float f2;
          float f3;
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                break label238;
              }
              this.mGifScaleY = 1.0F;
              this.mGifScaleX = 1.0F;
              break label238;
            }
            f2 = this.mGifScaleX;
            f3 = this.mGifScaleY;
            f1 = f2;
            if (f2 >= f3) {
              break label233;
            }
            f1 = f3;
          }
          else
          {
            f2 = this.mGifScaleX;
            f3 = this.mGifScaleY;
            f1 = f2;
            if (f2 <= f3) {
              break label233;
            }
            f1 = f3;
          }
          this.mGifScaleX = f1;
          break label238;
        }
        else
        {
          this.mGifScaleX = 1.0F;
        }
        label233:
        this.mGifScaleY = f1;
      }
      label238:
      if (this.mScaleType != AsyncImageView.ScaleType.ORIGIN)
      {
        this.mGifStartX = ((int)((getWidth() / this.mGifScaleX - this.mGifMovie.width()) / 2.0F));
        this.mGifStartY = ((int)((getHeight() / this.mGifScaleY - this.mGifMovie.height()) / 2.0F));
      }
      this.mGifMatrixComputed = true;
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
  
  protected void afterSetContent(String paramString)
  {
    restoreBackgroundColorAfterSetContent();
  }
  
  public void clear()
  {
    this.mTintColor = 0;
  }
  
  protected void doFetchImage(Object paramObject, int paramInt)
  {
    if (this.mImageAdapter != null)
    {
      Object localObject = paramObject;
      if (paramObject == null) {
        localObject = new HashMap();
      }
      if ((localObject instanceof Map))
      {
        paramObject = this.hippyEngineContext;
        if (paramObject != null)
        {
          paramObject = paramObject.getRenderManager().getRenderNode(getId());
          if (paramObject != null) {
            this.initProps = paramObject.getProps();
          }
        }
        try
        {
          ((Map)localObject).put("props", this.initProps);
        }
        catch (Exception paramObject)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("doFetchImage: ");
          localStringBuilder.append(paramObject.getMessage());
          LogUtils.d("HippyImageView", localStringBuilder.toString());
        }
      }
      if (paramInt == SOURCE_TYPE_SRC) {
        paramObject = this.mUrl;
      } else {
        paramObject = this.mDefaultSourceUrl;
      }
      this.mImageAdapter.fetchImage(paramObject, new HippyImageView.1(this, paramInt, paramObject), localObject);
    }
  }
  
  protected void drawGIF(Canvas paramCanvas)
  {
    Movie localMovie = this.mGifMovie;
    if (localMovie == null) {
      return;
    }
    int j = localMovie.duration();
    int i = j;
    if (j == 0) {
      i = 1000;
    }
    long l1 = System.currentTimeMillis();
    if (!this.isGifPaused)
    {
      long l2 = this.mGifLastPlayTime;
      if (l2 != -1L)
      {
        this.mGifProgress = ((int)(this.mGifProgress + (l1 - l2)));
        if (this.mGifProgress > i) {
          this.mGifProgress = 0;
        }
      }
      this.mGifLastPlayTime = l1;
    }
    computeMatrixParams();
    this.mGifMovie.setTime(this.mGifProgress);
    paramCanvas.save();
    paramCanvas.scale(this.mGifScaleX, this.mGifScaleY);
    this.mGifMovie.draw(paramCanvas, this.mGifStartX, this.mGifStartY);
    paramCanvas.restore();
    if (!this.isGifPaused) {
      postInvalidateDelayed(40L);
    }
  }
  
  protected BackgroundDrawable generateBackgroundDrawable()
  {
    return new CommonBackgroundDrawable();
  }
  
  protected ContentDrawable generateContentDrawable()
  {
    return new HippyContentDrawable();
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return this.mGestureDispatcher;
  }
  
  protected void handleGetImageFail(Throwable paramThrowable)
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
  
  protected void handleGetImageStart()
  {
    if (this.mShouldSendImageEvent[HippyImageView.ImageEvent.ONLOAD_START.ordinal()] != 0) {
      getOnLoadStartEvent().send(this, null);
    }
  }
  
  protected void handleGetImageSuccess()
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
  
  protected void handleImageRequest(IDrawableTarget paramIDrawableTarget, int paramInt, Object paramObject)
  {
    boolean bool = paramIDrawableTarget instanceof HippyDrawable;
    Object localObject = null;
    if (bool)
    {
      HippyDrawable localHippyDrawable = (HippyDrawable)paramIDrawableTarget;
      if (localHippyDrawable.isAnimated())
      {
        this.mGifMovie = localHippyDrawable.getGIF();
        setLayerType(1, null);
      }
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
          this.mUrlFetchState = 2;
          setContent(paramInt);
          handleGetImageSuccess();
          return;
        }
      }
      this.mUrlFetchState = 0;
      paramIDrawableTarget = localObject;
      if ((paramObject instanceof Throwable)) {
        paramIDrawableTarget = (Throwable)paramObject;
      }
      handleGetImageFail(paramIDrawableTarget);
      return;
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
  
  protected void onFetchImage(String paramString)
  {
    Drawable localDrawable = getBackground();
    resetContent();
    if ((paramString != null) && ((UrlUtils.isWebUrl(paramString)) || (UrlUtils.isFileUrl(paramString))))
    {
      int i = -3355444;
      if (this.mUserHasSetBackgroudnColor) {
        i = this.mUserSetBackgroundColor;
      }
      if ((localDrawable instanceof CommonBackgroundDrawable)) {
        paramString = localDrawable;
      }
      do
      {
        paramString = (CommonBackgroundDrawable)paramString;
        paramString.setBackgroundColor(i);
        setCustomBackgroundDrawable(paramString);
        break;
        if (!(localDrawable instanceof LayerDrawable)) {
          break;
        }
        paramString = (LayerDrawable)localDrawable;
        if (paramString.getNumberOfLayers() <= 0) {
          break;
        }
        paramString = paramString.getDrawable(0);
      } while ((paramString instanceof CommonBackgroundDrawable));
      super.setBackgroundColor(i);
      this.mHasSetTempBackgroundColor = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    NativeGestureDispatcher localNativeGestureDispatcher = this.mGestureDispatcher;
    boolean bool1 = bool2;
    if (localNativeGestureDispatcher != null) {
      bool1 = bool2 | localNativeGestureDispatcher.handleTouchEvent(paramMotionEvent);
    }
    return bool1;
  }
  
  public void pause()
  {
    this.isGifPaused = true;
    this.mGifLastPlayTime = -1L;
  }
  
  protected void resetContent()
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
    for (;;)
    {
      boolean[] arrayOfBoolean = this.mShouldSendImageEvent;
      if (i >= arrayOfBoolean.length) {
        break;
      }
      arrayOfBoolean[i] = false;
      i += 1;
    }
  }
  
  protected void restoreBackgroundColorAfterSetContent()
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
    setDefaultSource(paramString);
  }
  
  protected void setImageEventEnable(int paramInt, boolean paramBoolean)
  {
    this.mShouldSendImageEvent[paramInt] = paramBoolean;
  }
  
  public void setInitProps(HippyMap paramHippyMap)
  {
    this.initProps = paramHippyMap;
  }
  
  public void setNinePatchCoordinate(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      this.mNinePatchRect = null;
    }
    else
    {
      if (this.mNinePatchRect == null) {
        this.mNinePatchRect = new Rect();
      }
      this.mNinePatchRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if ((this.mContentDrawable instanceof HippyContentDrawable))
    {
      ((HippyContentDrawable)this.mContentDrawable).setNinePatchCoordinate(this.mNinePatchRect);
      invalidate();
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
  
  protected boolean shouldFetchImage()
  {
    if (this.mUrlFetchState == 1) {
      return false;
    }
    if (this.mUrlFetchState == 0) {
      return true;
    }
    Object localObject = this.initProps;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((HippyMap)localObject).getBoolean("isGif");
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1) {
      if ((!TextUtils.isEmpty(this.mImageType)) && (this.mImageType.equals("gif"))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    if ((!TextUtils.isEmpty(this.mImageType)) && (this.mImageType.equals("apng")) && (this.mContentDrawable != null) && (!(this.mContentDrawable instanceof ContentDrawable))) {
      return false;
    }
    if (bool2)
    {
      if (this.mGifMovie == null) {
        return true;
      }
    }
    else
    {
      localObject = getBitmap();
      if (localObject == null) {
        break label150;
      }
      if (((Bitmap)localObject).isRecycled()) {
        return true;
      }
    }
    return false;
    label150:
    return true;
  }
  
  protected boolean shouldUseFetchImageMode(String paramString)
  {
    return (UrlUtils.isWebUrl(paramString)) || (UrlUtils.isFileUrl(paramString));
  }
  
  public void startPlay()
  {
    this.isGifPaused = false;
    invalidate();
  }
  
  protected void updateContentDrawableProperty()
  {
    super.updateContentDrawableProperty();
    if ((this.mContentDrawable instanceof HippyContentDrawable)) {
      ((HippyContentDrawable)this.mContentDrawable).setNinePatchCoordinate(this.mNinePatchRect);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.image.HippyImageView
 * JD-Core Version:    0.7.0.1
 */