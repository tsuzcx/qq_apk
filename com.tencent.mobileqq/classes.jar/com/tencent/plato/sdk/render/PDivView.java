package com.tencent.plato.sdk.render;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.utils.Ev;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.sdk.IImageLoader;
import com.tencent.plato.sdk.IImageLoader.Listener;
import com.tencent.plato.sdk.PlatoSDKManager;
import com.tencent.plato.sdk.render.data.ElementItem;
import java.io.IOException;

public class PDivView
  extends PView
{
  private void setBackgroundByPosition(BitmapDrawable paramBitmapDrawable, IReadableMap paramIReadableMap)
  {
    float f4 = paramIReadableMap.getFloat("backgroundPositionX", 0.0F);
    float f5 = paramIReadableMap.getFloat("backgroundPositionY", 0.0F);
    float f2 = paramIReadableMap.getFloat("backgroundSizeW", 0.0F);
    float f3 = paramIReadableMap.getFloat("backgroundSizeH", 0.0F);
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = getWidth();
    }
    f2 = f3;
    if (f3 == 0.0F) {
      f2 = getHeight();
    }
    if ((f1 > 0.0F) && (f2 > 0.0F))
    {
      paramIReadableMap = Bitmap.createBitmap((int)f1, (int)f2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(paramIReadableMap);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localCanvas.drawBitmap(paramBitmapDrawable.getBitmap(), new Rect((int)(-1.0F * f4), (int)(-1.0F * f5), (int)(-1.0F * f4) + (int)f1, (int)(-1.0F * f5) + (int)f2), new Rect(0, 0, (int)f1, (int)f2), localPaint);
      this.view.setBackground(new BitmapDrawable(paramIReadableMap));
    }
  }
  
  public void init(IPlatoRuntime paramIPlatoRuntime, IPView paramIPView, ElementItem paramElementItem)
  {
    super.init(paramIPlatoRuntime, paramIPView, paramElementItem);
    if (paramElementItem != null)
    {
      paramElementItem.getUIStyles();
      this.view = new FrameLayout(paramIPlatoRuntime.getContext());
      this.id = paramElementItem.getElementId();
      return;
    }
    this.view = new FrameLayout(paramIPlatoRuntime.getContext());
  }
  
  public void setStyles(final IReadableMap paramIReadableMap)
  {
    Object localObject4 = null;
    super.setStyles(paramIReadableMap);
    if (this.view == null) {}
    for (;;)
    {
      return;
      Object localObject2 = paramIReadableMap.getString("backgroundImage", null);
      if (localObject2 != null)
      {
        Object localObject1 = null;
        try
        {
          if (PlatoSDKManager.getImageLoader() != null) {
            PlatoSDKManager.getImageLoader().loadDrawable((String)localObject2, this.mPlatoRuntime.getContext(), new IImageLoader.Listener()
            {
              public void onLoad(BitmapDrawable paramAnonymousBitmapDrawable)
              {
                Object localObject2 = null;
                if (paramAnonymousBitmapDrawable != null) {
                  if (!paramIReadableMap.getBoolean("backgroundRepeatX", false)) {
                    break label92;
                  }
                }
                label92:
                for (Object localObject1 = Shader.TileMode.REPEAT;; localObject1 = null)
                {
                  paramAnonymousBitmapDrawable.setTileModeX((Shader.TileMode)localObject1);
                  localObject1 = localObject2;
                  if (paramIReadableMap.getBoolean("backgroundRepeatX", false)) {
                    localObject1 = Shader.TileMode.REPEAT;
                  }
                  paramAnonymousBitmapDrawable.setTileModeY((Shader.TileMode)localObject1);
                  int i = paramIReadableMap.getInt("backgroundPosition", 0);
                  if (i == 0) {
                    break;
                  }
                  paramAnonymousBitmapDrawable.setGravity(i);
                  PDivView.this.view.setBackground(paramAnonymousBitmapDrawable);
                  return;
                }
                PDivView.this.setBackgroundByPosition(paramAnonymousBitmapDrawable, paramIReadableMap);
              }
            });
          }
          while (localObject1 != null)
          {
            if (!paramIReadableMap.getBoolean("backgroundRepeatX", false)) {
              break label210;
            }
            localObject2 = Shader.TileMode.REPEAT;
            ((BitmapDrawable)localObject1).setTileModeX((Shader.TileMode)localObject2);
            localObject2 = localObject4;
            if (paramIReadableMap.getBoolean("backgroundRepeatX", false)) {
              localObject2 = Shader.TileMode.REPEAT;
            }
            ((BitmapDrawable)localObject1).setTileModeY((Shader.TileMode)localObject2);
            int i = paramIReadableMap.getInt("backgroundPosition", 0);
            if (i == 0) {
              break label216;
            }
            ((BitmapDrawable)localObject1).setGravity(i);
            this.view.setBackground((Drawable)localObject1);
            return;
            localObject2 = (BitmapDrawable)Drawable.createFromStream(Ev.appContext().getAssets().open((String)localObject2), null);
            localObject1 = localObject2;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            PLog.e("PDivView", "backgroundDrawable error. " + Log.getStackTraceString(localIOException));
            continue;
            label210:
            Object localObject3 = null;
          }
          label216:
          setBackgroundByPosition((BitmapDrawable)localObject1, paramIReadableMap);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.render.PDivView
 * JD-Core Version:    0.7.0.1
 */