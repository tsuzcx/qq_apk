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
  
  private boolean isAutoSize()
  {
    if (this.mDomObj == null) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = this.mDomObj.getAttributes();
      } while ((!((Attr)localObject).containsKey("autosize")) || ("none".equals(((Attr)localObject).get("autosize").toString())));
      localObject = this.mDomObj.getStyle();
    } while (((((Style)localObject).containsKey("width")) && (((Style)localObject).containsKey("height"))) || ((!((Style)localObject).containsKey("width")) && (!((Style)localObject).containsKey("height"))));
    return true;
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
    boolean bool2 = true;
    boolean bool1 = true;
    if (!isMounted()) {}
    Object localObject;
    do
    {
      return false;
      localObject = getHostView();
    } while (localObject == null);
    if (this.mDomObj != null)
    {
      localObject = this.mDomObj.getStyle();
      if ((((Style)localObject).getWidth(this.mDomObj.getViewPortWidth()) != 0.0F) && (((Style)localObject).getHeight(this.mDomObj.getViewPortWidth()) != 0.0F)) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
    }
    if ((((View)localObject).getHeight() != 0) && (((View)localObject).getWidth() != 0)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
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
    if (tryRecordRequestImage(paramString, paramInt1, paramInt2, paramBoolean)) {}
    VComponentAdapter localVComponentAdapter;
    do
    {
      return;
      localVComponentAdapter = ViolaSDKManager.getInstance().getComponentAdapter();
    } while ((localVImageView2 == null) || (localVComponentAdapter == null));
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
  
  private void removeCheckMsg()
  {
    if (this.mNullDrawableChecker != null) {
      this.mNullDrawableChecker.removeCheckMsg();
    }
  }
  
  private void requestImage(boolean paramBoolean, String paramString)
  {
    if (isRequestNow())
    {
      if (this.mDomObj != null)
      {
        Style localStyle = this.mDomObj.getStyle();
        int i = (int)localStyle.getWidth(this.mDomObj.getViewPortWidth());
        int j = (int)localStyle.getHeight(this.mDomObj.getViewPortWidth());
        if ((i == 0) || (j == 0)) {
          break label95;
        }
        nowRequest(i, j, paramBoolean, paramString);
      }
      for (;;)
      {
        ViolaLogUtils.d("VImage2", "request now, url: " + paramString);
        return;
        label95:
        nowRequest(((VImageView2)getHostView()).getWidth(), ((VImageView2)getHostView()).getHeight(), paramBoolean, paramString);
      }
    }
    deferredRequest(paramBoolean, paramString);
  }
  
  private void setImage(Object paramObject)
  {
    VImageView2 localVImageView2 = (VImageView2)getHostView();
    if (localVImageView2 == null) {}
    do
    {
      return;
      if ((paramObject instanceof Bitmap))
      {
        localVImageView2.setImageBitmap((Bitmap)paramObject);
        return;
      }
    } while (!(paramObject instanceof Drawable));
    localVImageView2.setImageDrawable((Drawable)paramObject);
  }
  
  private void setImageResize(String paramString)
  {
    if (getHostView() != null) {
      ((VImageView2)getHostView()).setScaleType(getResizeMode(paramString));
    }
  }
  
  private void setResult(Object paramObject, String paramString, boolean paramBoolean)
  {
    if ((paramObject == null) || (getHostView() == null)) {}
    VImageView2 localVImageView2;
    do
    {
      return;
      localVImageView2 = (VImageView2)getHostView();
      if (!paramBoolean) {
        break;
      }
    } while ((localVImageView2.getDrawable() != null) || (this.mHasSetPlaceHolder));
    localVImageView2.setNeedFading(false);
    setImage(paramObject);
    this.mHasSetPlaceHolder = true;
    return;
    this.mHasSetPlaceHolder = true;
    localVImageView2.setNeedFading(true);
    localVImageView2.setUrl(paramString);
    setImage(paramObject);
  }
  
  private void tryCalSizeAndUpdate(Bundle paramBundle)
  {
    if (!isAutoSize()) {}
    int j;
    int i;
    do
    {
      do
      {
        return;
        localObject1 = (VImageView2)getHostView();
      } while ((localObject1 == null) || (((VImageView2)localObject1).getLayoutParams() == null));
      j = ((VImageView2)localObject1).getNaturalWidth();
      i = ((VImageView2)localObject1).getNaturalHeight();
      if (paramBundle != null)
      {
        j = paramBundle.getInt(ImageAdapterHolder.BUNDLE_WIDTH, 0);
        i = paramBundle.getInt(ImageAdapterHolder.BUNDLE_HEIGHT, 0);
      }
    } while ((j == 0) || (i == 0));
    Object localObject2 = this.mDomObj.getAttributes().get("autosize").toString();
    paramBundle = ((VImageView2)localObject1).getLayoutParams();
    int m = paramBundle.width;
    int n = paramBundle.height;
    Object localObject1 = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    int k;
    label287:
    int i1;
    for (;;)
    {
      try
      {
        if (!"width".equals(localObject2)) {
          break label384;
        }
        k = (int)this.mDomObj.flexStyle.maxHeight;
        if (k == 0) {
          break label717;
        }
        if (i > k)
        {
          j = (int)(k / i * j);
          if (n != 0) {
            break label726;
          }
          i = k;
          m = (int)(i / k * j);
          if ((m == paramBundle.width) && (i == paramBundle.height)) {
            break;
          }
          m = (int)FlexConvertUtils.px2dip(m);
          ((JSONObject)localObject1).put("width", m + "dp");
          ((JSONObject)localObject1).put("height", (int)FlexConvertUtils.px2dip(i) + "dp");
          i = k;
          localJSONObject.put("style", localObject1);
          paramBundle = new MethodUpdateElement(getRef(), localJSONObject);
          ViolaSDKManager.getInstance().getDomManager().postAction(getInstance().getInstanceId(), paramBundle, false);
          ViolaLogUtils.d("VImage2", " for image width :" + j + ",height:" + i);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      if (n != 0) {
        break label717;
      }
      k = i;
      continue;
      label384:
      if (!"height".equals(localObject2)) {
        break label714;
      }
      i1 = (int)this.mDomObj.flexStyle.maxWidth;
      n = m;
      if (i1 == 0) {
        break label696;
      }
      if (j <= i1) {
        break label732;
      }
      float f = i1 / j;
      i = (int)(i * f);
      if (m != 0) {
        break label703;
      }
      k = i1;
      j = i1;
      label450:
      m = (int)(k / j * i);
      if ((m == paramBundle.height) && (k == paramBundle.width)) {
        break;
      }
      m = (int)FlexConvertUtils.px2dip(m);
      ((JSONObject)localObject1).put("width", (int)FlexConvertUtils.px2dip(k) + "dp");
      ((JSONObject)localObject1).put("height", m + "dp");
    }
    for (;;)
    {
      for (;;)
      {
        n = k;
        if (getDomObject().getAttributes().containsKey("autoScaleWidth"))
        {
          localObject2 = getDomObject().getAttributes().get("autoScaleWidth");
          n = k;
          if (localObject2 != null)
          {
            boolean bool = TextUtils.isEmpty(localObject2.toString());
            n = k;
            if (!bool)
            {
              m = k;
              try
              {
                if (k >= Integer.parseInt(localObject2.toString())) {
                  m = Math.min((int)getDomObject().getParent().getLayoutWidth(), i1);
                }
                k = m;
              }
              catch (NumberFormatException localNumberFormatException)
              {
                ViolaLogUtils.e("VImage2", "AUTO_SCALE_WIDTH NumberFormatException" + localNumberFormatException.getMessage());
                n = k;
              }
            }
          }
        }
      }
      label696:
      k = n;
      break label450;
      label703:
      k = m;
      j = i1;
      break label450;
      label714:
      break label287;
      label717:
      k = i;
      i = n;
      break;
      label726:
      i = n;
      break;
      label732:
      k = m;
      if (m == 0) {
        k = j;
      }
    }
  }
  
  private boolean tryRecordRequestImage(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramBoolean) || (!useCacheWrap())) {}
    while (this.mHost == null) {
      return false;
    }
    ensureImageCacheManager();
    return cacheManager.recordRequest((VImageView2)this.mHost, paramString, paramInt1, paramInt2, getBlurRadius(), this.mDomObj.getStyle());
  }
  
  public int getBlurRadius()
  {
    if (this.mDomObj == null) {
      return 0;
    }
    return (int)((int)FlexConvertUtils.converPxByViewportToRealPx(this.mDomObj.getAttributes().get("blurRadius"), 750) * 2.3D);
  }
  
  public ImageView.ScaleType getResizeMode(String paramString)
  {
    ImageView.ScaleType localScaleType = ImageView.ScaleType.FIT_XY;
    if (TextUtils.isEmpty(paramString)) {
      return localScaleType;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return localScaleType;
      case 0: 
        return ImageView.ScaleType.CENTER_CROP;
        if (paramString.equals("cover"))
        {
          i = 0;
          continue;
          if (paramString.equals("contain"))
          {
            i = 1;
            continue;
            if (paramString.equals("stretch")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    return ImageView.ScaleType.FIT_CENTER;
    return ImageView.ScaleType.FIT_XY;
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
    boolean bool = true;
    paramContext = new VImageView2(paramContext);
    paramContext.bindComponent(this);
    paramContext.initBorderInfo(this.mDomObj);
    paramContext.setScaleType(ImageView.ScaleType.FIT_XY);
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.setCropToPadding(true);
    }
    this.mNullDrawableChecker = new VImage2.NullDrawableChecker(this);
    if ((this.mDomObj != null) && (ViolaUtils.getBoolean(this.mDomObj.getAttributes().get("cacheWrap")))) {}
    for (;;)
    {
      this.useCacheWrap = bool;
      return paramContext;
      bool = false;
    }
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
    ViolaLogUtils.e("VImage2", "onCancel, hashCode: " + hashCode() + ", url: " + this.mImageUrl);
    this.mImageUrl = null;
    removeCheckMsg();
    tryRemoveCache();
  }
  
  public void onDrawableLoadFinish(String paramString, Drawable paramDrawable, ImageCacheManager.ImageCacheKey paramImageCacheKey)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.equals(this.mPlaceHolderUrl)) {
      return;
    }
    onGetDrawable(paramImageCacheKey, paramDrawable);
  }
  
  public void onError()
  {
    tryFireEvent(false, null);
    ViolaLogUtils.e("VImage2", "onError, hashCode: " + hashCode() + ", url: " + this.mImageUrl);
    this.mImageUrl = null;
    removeCheckMsg();
    tryRemoveCache();
  }
  
  public void onGetDrawable(ImageCacheManager.ImageCacheKey paramImageCacheKey, Drawable paramDrawable)
  {
    if ((!useCacheWrap()) || (paramImageCacheKey == null)) {
      return;
    }
    ensureImageCacheManager();
    cacheManager.onGetDrawable(paramImageCacheKey, paramDrawable);
  }
  
  public void onRecycler()
  {
    tryRemoveCache();
  }
  
  public void onSuccess(Object paramObject, String paramString, Bundle paramBundle)
  {
    removeCheckMsg();
    if (((VImageView2)getHostView() == null) || (paramString == null)) {
      return;
    }
    if (paramString.equals(this.mImageUrl)) {}
    for (boolean bool = false;; bool = true)
    {
      setResult(paramObject, paramString, bool);
      if (!bool)
      {
        tryCalSizeAndUpdate(paramBundle);
        tryFireEvent(true, paramBundle);
      }
      ViolaLogUtils.d("VImage2", "onSuccess, url: " + paramString + ", hashCode: " + hashCode() + ", isPlaceHolder: " + bool);
      return;
      if (!paramString.equals(this.mPlaceHolderUrl)) {
        break;
      }
    }
    tryRemoveCache();
    ViolaLogUtils.e("VImage2", "url has change, hashCode: " + hashCode() + ", requestUrl: " + paramString + ", imageUrl: " + this.mImageUrl + ", placeHolder: " + this.mPlaceHolderUrl);
  }
  
  public boolean resetAttr(String paramString)
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
      localObject = new StringBuilder().append("hostView is null, src: ");
      if (paramString != null)
      {
        localObject = ((StringBuilder)localObject).append(paramString).append(", cache url: ");
        if (this.mImageUrl == null) {
          break label75;
        }
        paramString = this.mImageUrl;
        label54:
        ViolaLogUtils.e("VImage2", paramString);
      }
    }
    label75:
    do
    {
      return;
      paramString = "null";
      break;
      paramString = "";
      break label54;
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
    } while ((((VImageView2)localObject).getDrawable() != null) || (this.mNullDrawableChecker == null));
    this.mNullDrawableChecker.sendCheckMsg();
  }
  
  protected void tryFireEvent(boolean paramBoolean, Bundle paramBundle)
  {
    if (!hasFinishEvent()) {
      return;
    }
    Object localObject = (VImageView2)getHostView();
    int i;
    int j;
    if (localObject != null)
    {
      i = ((VImageView2)localObject).getNaturalWidth();
      j = ((VImageView2)localObject).getNaturalHeight();
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        i = paramBundle.getInt(ImageAdapterHolder.BUNDLE_WIDTH);
        j = paramBundle.getInt(ImageAdapterHolder.BUNDLE_HEIGHT);
      }
      for (;;)
      {
        try
        {
          paramBundle = new JSONObject();
          localObject = new JSONObject();
          ((JSONObject)localObject).put("width", i);
          ((JSONObject)localObject).put("height", j);
          if (paramBoolean)
          {
            i = 1;
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
        }
        catch (Exception paramBundle)
        {
          return;
        }
        i = 0;
      }
      j = 0;
      i = 0;
    }
  }
  
  public void tryRemoveCache()
  {
    if ((useCacheWrap()) && (this.mHost != null))
    {
      ensureImageCacheManager();
      cacheManager.removeCache(((VImageView2)this.mHost).getCacheKey());
    }
  }
  
  public boolean useCacheWrap()
  {
    return (getInstance() != null) && (getInstance().isSupportNativeVue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.component.image.VImage2
 * JD-Core Version:    0.7.0.1
 */