package com.tencent.viola.ui.dom;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.style.ImageSpan;
import android.util.Base64;
import android.widget.ImageView.ScaleType;
import com.tencent.viola.adapter.VComponentAdapter;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.component.image.VImage2;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.view.image.ImageDrawable;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.ref.WeakReference;

public class VImgSpan
  extends ImageSpan
{
  private static final String TAG = "VImgSpan";
  private float[] borderRadii;
  private float borderRadius;
  private int height;
  private WeakReference<ImageSpanLoadListener> loadListenerWeakRef;
  private Drawable mDrawable;
  private ImageView.ScaleType scaleType;
  private final VImgSpan.VImageSpanListener vImageSpanListener = new VImgSpan.VImageSpanListener(this);
  private int width;
  
  public VImgSpan(int paramInt1, int paramInt2, int paramInt3, String paramString, Style paramStyle, ImageSpanLoadListener paramImageSpanLoadListener)
  {
    this(null, paramInt1);
    this.loadListenerWeakRef = new WeakReference(paramImageSpanLoadListener);
    this.width = paramInt2;
    this.height = paramInt3;
    this.scaleType = VImage2.getResizeMode(paramString);
    initBorderRadius(paramStyle);
  }
  
  public VImgSpan(Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }
  
  private void ensureBoderRadii()
  {
    if (this.borderRadii == null) {
      this.borderRadii = new float[8];
    }
  }
  
  private boolean hasSetBorderRadius()
  {
    return (this.borderRadius != 0.0F) || (!isBorderRadiiEmpty());
  }
  
  private void initBorderRadius(Style paramStyle)
  {
    float f;
    float[] arrayOfFloat;
    if (paramStyle.containsKey("borderTopLeftRadius"))
    {
      f = FlexConvertUtils.getFloatByViewport(paramStyle.get("borderTopLeftRadius"), 750);
      ensureBoderRadii();
      arrayOfFloat = this.borderRadii;
      arrayOfFloat[0] = f;
      arrayOfFloat[1] = f;
    }
    if (paramStyle.containsKey("borderTopRightRadius"))
    {
      f = FlexConvertUtils.getFloatByViewport(paramStyle.get("borderTopRightRadius"), 750);
      ensureBoderRadii();
      arrayOfFloat = this.borderRadii;
      arrayOfFloat[2] = f;
      arrayOfFloat[3] = f;
    }
    if (paramStyle.containsKey("borderBottomLeftRadius"))
    {
      f = FlexConvertUtils.getFloatByViewport(paramStyle.get("borderBottomLeftRadius"), 750);
      ensureBoderRadii();
      arrayOfFloat = this.borderRadii;
      arrayOfFloat[4] = f;
      arrayOfFloat[5] = f;
    }
    if (paramStyle.containsKey("borderBottomRightRadius"))
    {
      f = FlexConvertUtils.getFloatByViewport(paramStyle.get("borderBottomRightRadius"), 750);
      ensureBoderRadii();
      arrayOfFloat = this.borderRadii;
      arrayOfFloat[6] = f;
      arrayOfFloat[7] = f;
    }
    if (paramStyle.containsKey("borderRadius")) {
      this.borderRadius = FlexConvertUtils.getFloatByViewport(paramStyle.get("borderRadius"), 750);
    }
  }
  
  private boolean isBorderRadiiEmpty()
  {
    float[] arrayOfFloat = this.borderRadii;
    if (arrayOfFloat == null) {
      return true;
    }
    int j = arrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfFloat[i] != 0.0F) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void onLoadImageDrawableSuccess(Drawable paramDrawable)
  {
    this.mDrawable = paramDrawable;
    this.mDrawable.setBounds(0, 0, this.width, this.height);
    if (this.loadListenerWeakRef.get() != null) {
      ((ImageSpanLoadListener)this.loadListenerWeakRef.get()).onLoadFinish(true);
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    if (paramCharSequence == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat, (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2 + paramInt3);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public Drawable getDrawable()
  {
    Drawable localDrawable = this.mDrawable;
    if (localDrawable != null) {
      return localDrawable;
    }
    return super.getDrawable();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getDrawable();
    if (paramCharSequence == null) {
      return 0;
    }
    paramCharSequence = paramCharSequence.getBounds();
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetricsInt();
      paramFontMetricsInt.ascent = paramPaint.ascent;
      paramFontMetricsInt.descent = paramPaint.descent;
      paramFontMetricsInt.top = paramPaint.top;
      paramFontMetricsInt.bottom = paramPaint.bottom;
    }
    return paramCharSequence.right;
  }
  
  public void loadBase64(String paramString)
  {
    Object localObject = Base64.decode(paramString.split(",")[1], 0);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    try
    {
      if (Build.VERSION.SDK_INT > 19) {
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      } else {
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
      }
      localOptions.inJustDecodeBounds = false;
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length, localOptions);
      this.vImageSpanListener.onSpanFInish(paramString, new BitmapDrawable((Bitmap)localObject), true, null);
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      label79:
      break label79;
    }
    ViolaLogUtils.d("VImgSpan", "setImage decode base64 error");
  }
  
  public void loadImageSpan(String paramString)
  {
    if (VImage2.isBase64(paramString))
    {
      loadBase64(paramString);
      return;
    }
    VComponentAdapter localVComponentAdapter = ViolaSDKManager.getInstance().getComponentAdapter();
    if (localVComponentAdapter != null) {
      localVComponentAdapter.requestImageSpan(paramString, this.width, this.height, this.vImageSpanListener);
    }
  }
  
  public void loadSpanFinish(String paramString, Drawable paramDrawable, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      if (hasSetBorderRadius())
      {
        ImageDrawable.createImageDrawableForRound(paramDrawable, this.scaleType, this.width, this.height, paramString, new VImgSpan.1(this), true);
        return;
      }
      onLoadImageDrawableSuccess(ImageDrawable.createFromDrawable(paramDrawable, this.scaleType, this.width, this.height, true));
    }
  }
  
  public void setImageSpanListener(ImageSpanLoadListener paramImageSpanLoadListener)
  {
    this.loadListenerWeakRef = new WeakReference(paramImageSpanLoadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.VImgSpan
 * JD-Core Version:    0.7.0.1
 */