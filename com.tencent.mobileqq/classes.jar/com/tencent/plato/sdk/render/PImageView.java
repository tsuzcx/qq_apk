package com.tencent.plato.sdk.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import cn.gavinliu.android.lib.shapedimageview.ShapedImageView;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.GifRequestBuilder;
import com.bumptech.glide.GifTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.sdk.IImageLoader;
import com.tencent.plato.sdk.IImageLoader.Option;
import com.tencent.plato.sdk.PlatoSDKManager;
import com.tencent.plato.sdk.render.data.ElementItem;
import com.tencent.plato.sdk.utils.watcher.WatchListener;

public class PImageView
  extends PView
{
  int height;
  WatchListener mWatchListener;
  int width;
  
  public void init(IPlatoRuntime paramIPlatoRuntime, IPView paramIPView, ElementItem paramElementItem)
  {
    super.init(paramIPlatoRuntime, paramIPView, paramElementItem);
    paramIPlatoRuntime = new ShapedImageView(paramIPlatoRuntime.getContext());
    paramIPlatoRuntime.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.view = paramIPlatoRuntime;
    this.id = paramElementItem.getElementId();
    this.width = ((int)paramElementItem.getLayoutWidth());
    this.height = ((int)paramElementItem.getLayoutHeight());
  }
  
  public void setListener(WatchListener paramWatchListener)
  {
    this.mWatchListener = paramWatchListener;
  }
  
  public void setStyles(IReadableMap paramIReadableMap)
  {
    String str2 = paramIReadableMap.getString("src", "");
    String str1 = paramIReadableMap.getString("resizeMode", "contain");
    int i = paramIReadableMap.getInt("roundRadius", 0);
    if (str2 == null)
    {
      PLog.e(PImageView.class.getName(), "src is null");
      return;
    }
    if (PlatoSDKManager.getImageLoader() != null)
    {
      PlatoSDKManager.getImageLoader().loadImage(str2, (ImageView)this.view, new IImageLoader.Option(str1, i, this.width, this.height));
      return;
    }
    if ((str2.endsWith(".gif")) || (str2.endsWith(".GIF")))
    {
      Glide.with(this.view.getContext()).load(str2).asGif().dontAnimate().diskCacheStrategy(DiskCacheStrategy.SOURCE).into((ImageView)this.view);
      return;
    }
    paramIReadableMap = Glide.with(this.view.getContext()).load(str2);
    if (str1.equals("contain")) {
      if (i != 0) {
        paramIReadableMap.transform(new BitmapTransformation[] { new FitCenter(this.view.getContext()), new GlideRoundTransform(this.view.getContext(), i) });
      }
    }
    for (;;)
    {
      paramIReadableMap.into((ImageView)this.view);
      return;
      paramIReadableMap.fitCenter();
      continue;
      if (str1.equals("cover")) {
        if (i != 0) {
          paramIReadableMap.transform(new BitmapTransformation[] { new CenterCrop(this.view.getContext()), new GlideRoundTransform(this.view.getContext(), i) });
        } else {
          paramIReadableMap.centerCrop();
        }
      }
    }
  }
  
  public class GlideRoundTransform
    extends BitmapTransformation
  {
    private float radius = 0.0F;
    
    public GlideRoundTransform(Context paramContext, int paramInt)
    {
      super();
      this.radius = paramInt;
    }
    
    private Bitmap roundCrop(BitmapPool paramBitmapPool, Bitmap paramBitmap)
    {
      if (paramBitmap == null) {
        return null;
      }
      Object localObject = paramBitmapPool.get(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      paramBitmapPool = (BitmapPool)localObject;
      if (localObject == null) {
        paramBitmapPool = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      }
      localObject = new Canvas(paramBitmapPool);
      Paint localPaint = new Paint();
      localPaint.setShader(new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      localPaint.setAntiAlias(true);
      ((Canvas)localObject).drawRoundRect(new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight()), this.radius, this.radius, localPaint);
      return paramBitmapPool;
    }
    
    public String getId()
    {
      return getClass().getName() + Math.round(this.radius);
    }
    
    protected Bitmap transform(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2)
    {
      return roundCrop(paramBitmapPool, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.render.PImageView
 * JD-Core Version:    0.7.0.1
 */