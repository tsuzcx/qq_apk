package com.tencent.viola.ui.component.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.viola.adapter.VComponentAdapter;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.commons.ImageAdapterHolder;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.action.MethodUpdateElement;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.Style;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.dom.style.FlexNode;
import com.tencent.viola.ui.dom.style.FlexStyle;
import com.tencent.viola.ui.view.image.VImageView2;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VImage2
  extends VComponent<VImageView2>
  implements ImageAction
{
  public static final int DEFAULT_SCALE_RADIO = 7;
  private static final String TAG = "VImage2";
  private static final String WEB_BASE64_PREFIX_JPEG = "data:image/jpeg;base64,";
  private static final String WEB_BASE64_PREFIX_JPG = "data:image/jpg;base64,";
  private static final String WEB_BASE64_PREFIX_PNG = "data:image/png;base64,";
  private static ImageCacheManager cacheManager;
  private boolean mHasSetPlaceHolder;
  private String mImageUrl;
  private VImage2.NullDrawableChecker mNullDrawableChecker;
  private String mPlaceHolderUrl;
  private boolean useCacheWrap;
  
  public VImage2(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public VImage2(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer, int paramInt)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer, paramInt);
  }
  
  private void deferredRequest(boolean paramBoolean, String paramString)
  {
    View localView = getHostView();
    if (localView == null) {
      return;
    }
    localView.post(new VImage2.1(this, localView, paramBoolean, paramString));
  }
  
  private static void ensureImageCacheManager()
  {
    if (cacheManager == null) {
      cacheManager = new ImageCacheManager();
    }
  }
  
  private void finishLoadBase64(Bitmap paramBitmap, String paramString, Bundle paramBundle)
  {
    ViolaSDKManager.getInstance().postOnUiThread(new VImage2.3(this, paramBitmap, paramString, paramBundle));
  }
  
  private boolean isAutoSize()
  {
    if (this.mDomObj == null) {
      return false;
    }
    Object localObject = this.mDomObj.getAttributes();
    if (((Attr)localObject).containsKey("autosize"))
    {
      if ("none".equals(((Attr)localObject).get("autosize").toString())) {
        return false;
      }
      localObject = this.mDomObj.getStyle();
      if ((((Style)localObject).containsKey("width")) && (((Style)localObject).containsKey("height"))) {
        return false;
      }
      return (((Style)localObject).containsKey("width")) || (((Style)localObject).containsKey("height"));
    }
    return false;
  }
  
  private boolean isBase64(String paramString)
  {
    return (paramString.startsWith("data:image/jpg;base64,")) || (paramString.startsWith("data:image/png;base64,")) || (paramString.startsWith("data:image/jpeg;base64,"));
  }
  
  private boolean isNeedRealImageSize()
  {
    return (hasFinishEvent()) || (isAutoSize());
  }
  
  private boolean isRequestNow()
  {
    boolean bool1 = isMounted();
    boolean bool3 = false;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Object localObject = getHostView();
    if (localObject == null) {
      return false;
    }
    if (this.mDomObj != null)
    {
      localObject = this.mDomObj.getStyle();
      bool1 = bool2;
      if (((Style)localObject).getWidth(this.mDomObj.getViewPortWidth()) != 0.0F)
      {
        bool1 = bool2;
        if (((Style)localObject).getHeight(this.mDomObj.getViewPortWidth()) != 0.0F) {
          bool1 = true;
        }
      }
      return bool1;
    }
    bool1 = bool3;
    if (((View)localObject).getHeight() != 0)
    {
      bool1 = bool3;
      if (((View)localObject).getWidth() != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void loadFromBase64(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ViolaSDKManager.getInstance().postOnThreadPool(new VImage2.2(this, paramString, paramBoolean));
  }
  
  private void nowRequest(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    VImageView2 localVImageView2 = (VImageView2)getHostView();
    if (tryRecordRequestImage(paramString, paramInt1, paramInt2, paramBoolean)) {
      return;
    }
    VComponentAdapter localVComponentAdapter = ViolaSDKManager.getInstance().getComponentAdapter();
    if (localVImageView2 != null)
    {
      if (localVComponentAdapter == null) {
        return;
      }
      if ((!paramBoolean) || (!useCacheWrap())) {
        localVImageView2.setImageDrawable(null);
      }
      boolean bool = isNeedRealImageSize();
      if (isBase64(paramString))
      {
        if (!paramBoolean) {
          localVImageView2.setImageStartTs(System.currentTimeMillis());
        }
        loadFromBase64(paramString, bool);
        return;
      }
      if (!paramBoolean) {
        localVImageView2.setImageStartTs(System.currentTimeMillis());
      }
      localVComponentAdapter.requestImage(paramString, paramInt1, paramInt2, bool, this, isGif());
    }
  }
  
  private void removeCheckMsg()
  {
    VImage2.NullDrawableChecker localNullDrawableChecker = this.mNullDrawableChecker;
    if (localNullDrawableChecker != null) {
      localNullDrawableChecker.removeCheckMsg();
    }
  }
  
  private void requestImage(boolean paramBoolean, String paramString)
  {
    if (isRequestNow())
    {
      if (this.mDomObj != null)
      {
        localObject = this.mDomObj.getStyle();
        int i = (int)((Style)localObject).getWidth(this.mDomObj.getViewPortWidth());
        int j = (int)((Style)localObject).getHeight(this.mDomObj.getViewPortWidth());
        if ((i != 0) && (j != 0)) {
          nowRequest(i, j, paramBoolean, paramString);
        } else {
          nowRequest(((VImageView2)getHostView()).getWidth(), ((VImageView2)getHostView()).getHeight(), paramBoolean, paramString);
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("request now, url: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", hashCode: ");
      ((StringBuilder)localObject).append(hashCode());
      ViolaLogUtils.d("VImage2", ((StringBuilder)localObject).toString());
      return;
    }
    deferredRequest(paramBoolean, paramString);
  }
  
  private void setImage(Object paramObject)
  {
    VImageView2 localVImageView2 = (VImageView2)getHostView();
    if (localVImageView2 == null) {
      return;
    }
    if ((paramObject instanceof Bitmap))
    {
      localVImageView2.setImageBitmap((Bitmap)paramObject);
      return;
    }
    if ((paramObject instanceof Drawable)) {
      localVImageView2.setImageDrawable((Drawable)paramObject);
    }
  }
  
  private void setImageResize(String paramString)
  {
    if (getHostView() != null) {
      ((VImageView2)getHostView()).setScaleType(getResizeMode(paramString));
    }
  }
  
  private void setResult(Object paramObject, String paramString, boolean paramBoolean)
  {
    if (paramObject != null)
    {
      if (getHostView() == null) {
        return;
      }
      VImageView2 localVImageView2 = (VImageView2)getHostView();
      if (paramBoolean)
      {
        if ((localVImageView2.getDrawable() == null) && (!this.mHasSetPlaceHolder))
        {
          localVImageView2.setNeedFading(false);
          setImage(paramObject);
          this.mHasSetPlaceHolder = true;
        }
      }
      else
      {
        this.mHasSetPlaceHolder = true;
        localVImageView2.setNeedFading(true);
        localVImageView2.setUrl(paramString);
        setImage(paramObject);
      }
    }
  }
  
  private void tryCalSizeAndUpdate(Bundle paramBundle)
  {
    if (!isAutoSize()) {
      return;
    }
    Object localObject1 = (VImageView2)getHostView();
    int i;
    int j;
    Object localObject3;
    Object localObject2;
    int n;
    int i2;
    if (localObject1 != null)
    {
      if (((VImageView2)localObject1).getLayoutParams() == null) {
        return;
      }
      i = ((VImageView2)localObject1).getNaturalWidth();
      j = ((VImageView2)localObject1).getNaturalHeight();
      if (paramBundle != null)
      {
        i = paramBundle.getInt(ImageAdapterHolder.BUNDLE_WIDTH, 0);
        j = paramBundle.getInt(ImageAdapterHolder.BUNDLE_HEIGHT, 0);
      }
      if (i != 0)
      {
        if (j == 0) {
          return;
        }
        localObject3 = this.mDomObj.getAttributes().get("autosize").toString();
        localObject2 = ((VImageView2)localObject1).getLayoutParams();
        n = ((ViewGroup.LayoutParams)localObject2).width;
        i2 = ((ViewGroup.LayoutParams)localObject2).height;
        paramBundle = new JSONObject();
        localObject1 = new JSONObject();
      }
    }
    for (;;)
    {
      int i3;
      try
      {
        boolean bool = "width".equals(localObject3);
        float f;
        if (bool)
        {
          n = (int)this.mDomObj.flexStyle.maxHeight;
          k = i;
          m = j;
          i1 = i2;
          if (n != 0)
          {
            if (j <= n) {
              break label832;
            }
            i = (int)(n / j * i);
            if (i2 != 0) {
              break label818;
            }
            j = n;
            break label848;
          }
          f = i1;
          i = (int)(f / m * k);
          if ((i == ((ViewGroup.LayoutParams)localObject2).width) && (i1 == ((ViewGroup.LayoutParams)localObject2).height)) {
            return;
          }
          i = (int)FlexConvertUtils.px2dip(i);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("dp");
          paramBundle.put("width", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((int)FlexConvertUtils.px2dip(f));
          ((StringBuilder)localObject2).append("dp");
          paramBundle.put("height", ((StringBuilder)localObject2).toString());
          i1 = m;
        }
        else
        {
          k = i;
          i1 = j;
          if ("height".equals(localObject3))
          {
            i3 = (int)this.mDomObj.flexStyle.maxWidth;
            m = i;
            i1 = j;
            k = n;
            if (i3 != 0)
            {
              if (i <= i3) {
                break label873;
              }
              i1 = (int)(i3 / i * j);
              if (n != 0) {
                break label862;
              }
              k = i3;
              break label866;
              m = i;
              i1 = j;
              k = i2;
              if (getDomObject().getAttributes().containsKey("autoScaleWidth"))
              {
                localObject3 = getDomObject().getAttributes().get("autoScaleWidth");
                m = i;
                i1 = j;
                k = i2;
                if (localObject3 != null)
                {
                  bool = TextUtils.isEmpty(localObject3.toString());
                  m = i;
                  i1 = j;
                  k = i2;
                  if (!bool)
                  {
                    m = i;
                    i1 = j;
                    k = i2;
                    try
                    {
                      if (i2 >= Integer.parseInt(localObject3.toString()))
                      {
                        k = Math.min((int)getDomObject().getParent().getLayoutWidth(), i3);
                        m = i;
                        i1 = j;
                      }
                    }
                    catch (NumberFormatException localNumberFormatException)
                    {
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append("AUTO_SCALE_WIDTH NumberFormatException");
                      localStringBuilder.append(localNumberFormatException.getMessage());
                      ViolaLogUtils.e("VImage2", localStringBuilder.toString());
                      k = i2;
                      i1 = j;
                      m = i;
                    }
                  }
                }
              }
            }
            f = k;
            i = (int)(f / m * i1);
            if ((i == ((ViewGroup.LayoutParams)localObject2).height) && (k == ((ViewGroup.LayoutParams)localObject2).width)) {
              return;
            }
            i = (int)FlexConvertUtils.px2dip(i);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((int)FlexConvertUtils.px2dip(f));
            ((StringBuilder)localObject2).append("dp");
            paramBundle.put("width", ((StringBuilder)localObject2).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append("dp");
            paramBundle.put("height", ((StringBuilder)localObject2).toString());
            k = m;
          }
        }
        ((JSONObject)localObject1).put("style", paramBundle);
        paramBundle = new MethodUpdateElement(getRef(), (JSONObject)localObject1);
        ViolaSDKManager.getInstance().getDomManager().postAction(getInstance().getInstanceId(), paramBundle, false);
        paramBundle = new StringBuilder();
        paramBundle.append(" for image width :");
        paramBundle.append(k);
        paramBundle.append(",height:");
        paramBundle.append(i1);
        ViolaLogUtils.d("VImage2", paramBundle.toString());
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
      }
      return;
      label818:
      int m = n;
      int k = i;
      int i1 = i2;
      continue;
      label832:
      k = i;
      m = j;
      i1 = i2;
      if (i2 == 0)
      {
        label848:
        i1 = j;
        k = i;
        m = j;
        continue;
        label862:
        k = n;
        label866:
        m = i3;
        continue;
        label873:
        i2 = n;
        if (n == 0) {
          i2 = i;
        }
      }
    }
  }
  
  private boolean tryRecordRequestImage(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (!useCacheWrap()) {
        return false;
      }
      if (this.mHost == null) {
        return false;
      }
      ensureImageCacheManager();
      return cacheManager.recordRequest((VImageView2)this.mHost, paramString, paramInt1, paramInt2, getBlurRadius(), this.mDomObj.getStyle());
    }
    return false;
  }
  
  public int getBlurRadius()
  {
    if (this.mDomObj == null) {
      return 0;
    }
    double d = (int)FlexConvertUtils.converPxByViewportToRealPx(this.mDomObj.getAttributes().get("blurRadius"), 750);
    Double.isNaN(d);
    return (int)(d * 2.3D);
  }
  
  public ImageView.ScaleType getResizeMode(String paramString)
  {
    ImageView.ScaleType localScaleType = ImageView.ScaleType.FIT_XY;
    if (TextUtils.isEmpty(paramString)) {
      return localScaleType;
    }
    int i = -1;
    int j = paramString.hashCode();
    if (j != -1881872635)
    {
      if (j != 94852023)
      {
        if ((j == 951526612) && (paramString.equals("contain"))) {
          i = 1;
        }
      }
      else if (paramString.equals("cover")) {
        i = 0;
      }
    }
    else if (paramString.equals("stretch")) {
      i = 2;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return localScaleType;
        }
        return ImageView.ScaleType.FIT_XY;
      }
      return ImageView.ScaleType.FIT_CENTER;
    }
    return ImageView.ScaleType.CENTER_CROP;
  }
  
  public int getScaleRadioForBlur()
  {
    if (this.mDomObj == null) {
      return 7;
    }
    return ViolaUtils.getInt(this.mDomObj.getStyle().get("scaleRadio"), 7);
  }
  
  public ImageView getTarget()
  {
    return (ImageView)getHostView();
  }
  
  protected boolean hasFinishEvent()
  {
    return (this.mDomObj != null) && (this.mDomObj.getEvents().contains("finish"));
  }
  
  protected VImageView2 initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VImageView2(paramContext);
    paramContext.bindComponent(this);
    paramContext.initBorderInfo(this.mDomObj);
    paramContext.setScaleType(ImageView.ScaleType.FIT_XY);
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (i >= 16) {
      paramContext.setCropToPadding(true);
    }
    this.mNullDrawableChecker = new VImage2.NullDrawableChecker(this);
    if ((this.mDomObj == null) || (!ViolaUtils.getBoolean(this.mDomObj.getAttributes().get("cacheWrap")))) {
      bool = false;
    }
    this.useCacheWrap = bool;
    return paramContext;
  }
  
  public boolean isGif()
  {
    return false;
  }
  
  public void onActivityDestroy()
  {
    if ((cacheManager != null) && (useCacheWrap())) {
      cacheManager.clear();
    }
  }
  
  public void onCancel()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCancel, hashCode: ");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(", url: ");
    localStringBuilder.append(this.mImageUrl);
    ViolaLogUtils.e("VImage2", localStringBuilder.toString());
    this.mImageUrl = null;
    removeCheckMsg();
    tryRemoveCache();
  }
  
  public void onDrawableLoadFinish(String paramString, Drawable paramDrawable, ImageCacheManager.ImageCacheKey paramImageCacheKey)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.equals(this.mPlaceHolderUrl)) {
      return;
    }
    onGetDrawable(paramImageCacheKey, paramDrawable);
  }
  
  public void onError()
  {
    tryFireEvent(false, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError, hashCode: ");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(", url: ");
    localStringBuilder.append(this.mImageUrl);
    ViolaLogUtils.e("VImage2", localStringBuilder.toString());
    this.mImageUrl = null;
    removeCheckMsg();
    tryRemoveCache();
  }
  
  public void onGetDrawable(ImageCacheManager.ImageCacheKey paramImageCacheKey, Drawable paramDrawable)
  {
    if (useCacheWrap())
    {
      if (paramImageCacheKey == null) {
        return;
      }
      ensureImageCacheManager();
      cacheManager.onGetDrawable(paramImageCacheKey, paramDrawable);
    }
  }
  
  public void onRecycler()
  {
    tryRemoveCache();
  }
  
  public void onSuccess(Object paramObject, String paramString, Bundle paramBundle)
  {
    removeCheckMsg();
    if ((VImageView2)getHostView() != null)
    {
      if (paramString == null) {
        return;
      }
      boolean bool;
      if (paramString.equals(this.mImageUrl))
      {
        bool = false;
      }
      else
      {
        if (!paramString.equals(this.mPlaceHolderUrl)) {
          break label138;
        }
        bool = true;
      }
      setResult(paramObject, paramString, bool);
      if (!bool)
      {
        tryCalSizeAndUpdate(paramBundle);
        tryFireEvent(true, paramBundle);
      }
      paramObject = new StringBuilder();
      paramObject.append("onSuccess, url: ");
      paramObject.append(paramString);
      paramObject.append(", hashCode: ");
      paramObject.append(hashCode());
      paramObject.append(", isPlaceHolder: ");
      paramObject.append(bool);
      ViolaLogUtils.d("VImage2", paramObject.toString());
      return;
      label138:
      tryRemoveCache();
      paramObject = new StringBuilder();
      paramObject.append("url has change, hashCode: ");
      paramObject.append(hashCode());
      paramObject.append(", requestUrl: ");
      paramObject.append(paramString);
      paramObject.append(", imageUrl: ");
      paramObject.append(this.mImageUrl);
      paramObject.append(", placeHolder: ");
      paramObject.append(this.mPlaceHolderUrl);
      ViolaLogUtils.e("VImage2", paramObject.toString());
    }
  }
  
  protected boolean resetAttr(String paramString)
  {
    if ((!super.resetAttr(paramString)) && (paramString.equals("resize")))
    {
      setResize("cover");
      return true;
    }
    return false;
  }
  
  public void resetComponent()
  {
    VImageView2 localVImageView2 = (VImageView2)getHostView();
    if (localVImageView2 != null)
    {
      localVImageView2.resetState();
      localVImageView2.setImageDrawable(null);
    }
    this.mImageUrl = null;
    this.mPlaceHolderUrl = null;
    this.mHasSetPlaceHolder = false;
    this.useCacheWrap = false;
  }
  
  public void resetComponent(DomObject paramDomObject)
  {
    if (this.mHost != null) {
      ((VImageView2)this.mHost).initBorderInfo(paramDomObject);
    }
  }
  
  @VComponentProp(name="alphaAnim")
  public void setAlphaAnim(boolean paramBoolean)
  {
    if (getHostView() != null) {
      ((VImageView2)getHostView()).setAlphaAnim(paramBoolean);
    }
  }
  
  @VComponentProp(name="alphaAnimDuration")
  public void setAlphaAnimDuration(int paramInt)
  {
    if (getHostView() != null) {
      ((VImageView2)getHostView()).setAlphaAnimDuration(paramInt);
    }
  }
  
  public void setBoderBottomLeftRadius(float paramFloat)
  {
    super.setBoderBottomLeftRadius(paramFloat);
    if (getHostView() != null) {
      ((VImageView2)getHostView()).setBottomLeftBorderRadius(paramFloat);
    }
  }
  
  public void setBoderBottomRightRadius(float paramFloat)
  {
    super.setBoderBottomRightRadius(paramFloat);
    if (getHostView() != null) {
      ((VImageView2)getHostView()).setBottomRightBorderRadius(paramFloat);
    }
  }
  
  public void setBoderTopLeftRadius(float paramFloat)
  {
    super.setBoderTopLeftRadius(paramFloat);
    if (getHostView() != null) {
      ((VImageView2)getHostView()).setTopLeftBorderRadius(paramFloat);
    }
  }
  
  public void setBoderTopRightRadius(float paramFloat)
  {
    super.setBoderTopRightRadius(paramFloat);
    if (getHostView() != null) {
      ((VImageView2)getHostView()).setTopRightBorderRadius(paramFloat);
    }
  }
  
  public void setBorderRadius(int paramInt, float paramFloat)
  {
    super.setBorderRadius(paramInt, paramFloat);
    if (getHostView() != null) {
      ((VImageView2)getHostView()).setBorderRadius(paramFloat);
    }
  }
  
  public void setBorderWidth(int paramInt, float paramFloat)
  {
    super.setBorderWidth(paramInt, paramFloat);
    if (getHostView() != null) {
      ((VImageView2)getHostView()).setBorderWidth(paramFloat);
    }
  }
  
  public void setHasSetPlaceHolder(boolean paramBoolean)
  {
    this.mHasSetPlaceHolder = paramBoolean;
  }
  
  @VComponentProp(name="placeholder")
  public void setPlaceholder(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.mPlaceHolderUrl)) && (!this.mHasSetPlaceHolder))
    {
      this.mPlaceHolderUrl = paramString;
      requestImage(true, this.mPlaceHolderUrl);
    }
  }
  
  @VComponentProp(name="resize")
  public void setResize(String paramString)
  {
    if (paramString != null) {
      setImageResize(paramString);
    }
  }
  
  @VComponentProp(name="src")
  public void setSrc(String paramString)
  {
    Object localObject = (VImageView2)getHostView();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hostView is null, src: ");
      if (paramString == null) {
        paramString = "null";
      }
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", cache url: ");
      paramString = this.mImageUrl;
      if (paramString == null) {
        paramString = "";
      }
      ((StringBuilder)localObject).append(paramString);
      ViolaLogUtils.e("VImage2", ((StringBuilder)localObject).toString());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      ViolaLogUtils.e("VImage2", "url is null");
      return;
    }
    if (!paramString.equals(this.mImageUrl))
    {
      this.mImageUrl = paramString;
      requestImage(false, this.mImageUrl);
      removeCheckMsg();
      return;
    }
    if (((VImageView2)localObject).getDrawable() == null)
    {
      paramString = this.mNullDrawableChecker;
      if (paramString != null) {
        paramString.sendCheckMsg();
      }
    }
  }
  
  protected void tryFireEvent(boolean paramBoolean, Bundle paramBundle)
  {
    if (!hasFinishEvent()) {
      return;
    }
    Object localObject = (VImageView2)getHostView();
    int k = 0;
    int i;
    int j;
    if (localObject != null)
    {
      i = ((VImageView2)localObject).getNaturalWidth();
      j = ((VImageView2)localObject).getNaturalHeight();
    }
    else
    {
      j = 0;
      i = 0;
    }
    if (paramBundle != null)
    {
      i = paramBundle.getInt(ImageAdapterHolder.BUNDLE_WIDTH);
      j = paramBundle.getInt(ImageAdapterHolder.BUNDLE_HEIGHT);
    }
    try
    {
      paramBundle = new JSONObject();
      localObject = new JSONObject();
      ((JSONObject)localObject).put("width", i);
      ((JSONObject)localObject).put("height", j);
      i = k;
      if (paramBoolean) {
        i = 1;
      }
      paramBundle.put("success", i);
      paramBundle.put("image", localObject);
      localObject = new JSONArray();
      String str = this.mDomObj.getRef();
      if (!TextUtils.isEmpty(str)) {
        ((JSONArray)localObject).put(str);
      }
      ((JSONArray)localObject).put("finish");
      fireEvent("finish", localObject, paramBundle);
      return;
    }
    catch (Exception paramBundle) {}
  }
  
  public void tryRemoveCache()
  {
    if ((useCacheWrap()) && (this.mHost != null))
    {
      ensureImageCacheManager();
      cacheManager.removeCache(((VImageView2)this.mHost).getCacheKey());
    }
  }
  
  public void tryRemoveCache(ImageCacheManager.ImageCacheKey paramImageCacheKey)
  {
    if (useCacheWrap())
    {
      ensureImageCacheManager();
      cacheManager.removeCache(paramImageCacheKey);
    }
  }
  
  public boolean useCacheWrap()
  {
    return (getInstance() != null) && (getInstance().isSupportNativeVue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.image.VImage2
 * JD-Core Version:    0.7.0.1
 */