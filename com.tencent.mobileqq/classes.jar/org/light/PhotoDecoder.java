package org.light;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class PhotoDecoder
{
  private static final String ASSET = "asset://";
  private static final int AlphaType_Opaque = 1;
  private static final int AlphaType_Premul = 2;
  private static final int AlphaType_Unpremul = 3;
  private static final int ColorType_ARGB_4444 = 3;
  private static final int ColorType_Alpha_8 = 1;
  private static final int ColorType_BGRA_8888 = 5;
  private static final int ColorType_Gray_8 = 7;
  private static final int ColorType_Index_8 = 6;
  private static final int ColorType_RGBA_8888 = 4;
  private static final int ColorType_RGBA_F16 = 8;
  private static final int ColorType_RGB_565 = 2;
  private static final String TAG = "PhotoDecoder";
  boolean isNoConstrictFlag;
  private int photoHeight = 0;
  private String photoPath = null;
  private int photoWidth = 0;
  private PhotoDecoder.OutputBitmap successBitmap = null;
  
  private PhotoDecoder(String paramString)
  {
    this.photoPath = paramString;
    paramString = new BitmapFactory.Options();
    paramString.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeFile(this.photoPath, paramString);
      this.photoWidth = paramString.outWidth;
      this.photoHeight = paramString.outHeight;
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static PhotoDecoder Create(String paramString)
  {
    Log.d("PhotoDecoder", "Create:" + paramString);
    paramString = new PhotoDecoder(paramString);
    paramString.isNoConstrictFlag = false;
    return paramString;
  }
  
  private Bitmap convert(Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setColor(0);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return localBitmap;
  }
  
  private PhotoDecoder.OutputBitmap decode()
  {
    Object localObject4 = null;
    Log.d("PhotoDecoder", "decode :" + this.photoPath);
    Object localObject3;
    if (this.successBitmap != null) {
      localObject3 = this.successBitmap;
    }
    do
    {
      return localObject3;
      localObject3 = localObject4;
    } while (TextUtils.isEmpty(this.photoPath));
    if (this.photoPath.startsWith("asset://")) {}
    for (;;)
    {
      try
      {
        Object localObject1 = LibraryLoadUtils.getAppContext().getAssets().open(this.photoPath.substring("asset://".length()));
        localObject1 = BitmapFactory.decodeStream((InputStream)localObject1);
        localObject3 = localObject4;
        if (localObject1 == null) {
          break;
        }
        if ((!this.isNoConstrictFlag) && (Build.VERSION.SDK_INT >= 26))
        {
          localObject3 = localObject4;
          if (((Bitmap)localObject1).getConfig() == Bitmap.Config.HARDWARE) {
            break;
          }
        }
        Log.d("PhotoDecoder", "decode done:" + this.photoPath);
        if (!this.isNoConstrictFlag)
        {
          localObject2 = ByteBuffer.allocate(((Bitmap)localObject1).getHeight() * ((Bitmap)localObject1).getRowBytes());
          ((Bitmap)localObject1).copyPixelsToBuffer((Buffer)localObject2);
          Bitmap.Config localConfig = ((Bitmap)localObject1).getConfig();
          localObject3 = localConfig;
          if (localConfig == null) {
            localObject3 = Bitmap.Config.ARGB_8888;
          }
          if (localObject3 != Bitmap.Config.ARGB_8888)
          {
            Log.d("PhotoDecoder", this.photoPath + " need to convert");
            localObject1 = convert((Bitmap)localObject1);
            localObject3 = localObject4;
            if (localObject1 == null) {
              break;
            }
            this.successBitmap = new PhotoDecoder.OutputBitmap(null);
            if (!this.isNoConstrictFlag)
            {
              if (localObject2 != null) {
                this.successBitmap.pixels = ((ByteBuffer)localObject2).array();
              }
              this.successBitmap.width = ((Bitmap)localObject1).getWidth();
              this.successBitmap.height = ((Bitmap)localObject1).getHeight();
              this.successBitmap.rowBytes = ((Bitmap)localObject1).getRowBytes();
              return this.successBitmap;
              localObject1 = BitmapFactory.decodeFile(this.photoPath);
              continue;
            }
            localObject2 = new int[((Bitmap)localObject1).getWidth() * ((Bitmap)localObject1).getHeight()];
            ((Bitmap)localObject1).getPixels((int[])localObject2, 0, ((Bitmap)localObject1).getWidth(), 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
            this.successBitmap.colors = ((int[])localObject2);
            continue;
          }
          continue;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  private int height()
  {
    return this.photoHeight;
  }
  
  private void onRelease()
  {
    this.successBitmap = null;
  }
  
  private int width()
  {
    return this.photoWidth;
  }
  
  public void setNoConstrictFlag(boolean paramBoolean)
  {
    Log.d("PhotoDecoder", "setNoConstrictFlag:" + paramBoolean);
    this.isNoConstrictFlag = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.PhotoDecoder
 * JD-Core Version:    0.7.0.1
 */