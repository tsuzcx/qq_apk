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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Create:");
    localStringBuilder.append(paramString);
    Log.d("PhotoDecoder", localStringBuilder.toString());
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("decode :");
    ((StringBuilder)localObject1).append(this.photoPath);
    Log.d("PhotoDecoder", ((StringBuilder)localObject1).toString());
    localObject1 = this.successBitmap;
    if (localObject1 != null) {
      return localObject1;
    }
    if (TextUtils.isEmpty(this.photoPath)) {
      return null;
    }
    if (this.photoPath.startsWith("asset://")) {}
    try
    {
      localObject1 = LibraryLoadUtils.getAppContext().getAssets().open(this.photoPath.substring(8));
      localObject1 = BitmapFactory.decodeStream((InputStream)localObject1);
      break label104;
      localObject1 = BitmapFactory.decodeFile(this.photoPath);
      label104:
      if (localObject1 == null) {
        return null;
      }
      if ((!this.isNoConstrictFlag) && (Build.VERSION.SDK_INT >= 26) && (((Bitmap)localObject1).getConfig() == Bitmap.Config.HARDWARE)) {
        return null;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("decode done:");
      ((StringBuilder)localObject2).append(this.photoPath);
      Log.d("PhotoDecoder", ((StringBuilder)localObject2).toString());
      if (!this.isNoConstrictFlag)
      {
        localObject2 = ByteBuffer.allocate(((Bitmap)localObject1).getHeight() * ((Bitmap)localObject1).getRowBytes());
        ((Bitmap)localObject1).copyPixelsToBuffer((Buffer)localObject2);
      }
      else
      {
        localObject2 = null;
      }
      Object localObject3 = ((Bitmap)localObject1).getConfig();
      Object localObject4 = localObject3;
      if (localObject3 == null) {
        localObject4 = Bitmap.Config.ARGB_8888;
      }
      localObject3 = localObject1;
      if (localObject4 != Bitmap.Config.ARGB_8888)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.photoPath);
        ((StringBuilder)localObject3).append(" need to convert");
        Log.d("PhotoDecoder", ((StringBuilder)localObject3).toString());
        localObject1 = convert((Bitmap)localObject1);
        localObject3 = localObject1;
        if (localObject1 == null) {
          return null;
        }
      }
      this.successBitmap = new PhotoDecoder.OutputBitmap(null);
      if (!this.isNoConstrictFlag)
      {
        if (localObject2 != null) {
          this.successBitmap.pixels = ((ByteBuffer)localObject2).array();
        }
      }
      else
      {
        localObject1 = new int[((Bitmap)localObject3).getWidth() * ((Bitmap)localObject3).getHeight()];
        ((Bitmap)localObject3).getPixels((int[])localObject1, 0, ((Bitmap)localObject3).getWidth(), 0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
        this.successBitmap.colors = ((int[])localObject1);
      }
      this.successBitmap.width = ((Bitmap)localObject3).getWidth();
      this.successBitmap.height = ((Bitmap)localObject3).getHeight();
      this.successBitmap.rowBytes = ((Bitmap)localObject3).getRowBytes();
      return this.successBitmap;
    }
    catch (Exception localException) {}
    return null;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setNoConstrictFlag:");
    localStringBuilder.append(paramBoolean);
    Log.d("PhotoDecoder", localStringBuilder.toString());
    this.isNoConstrictFlag = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.PhotoDecoder
 * JD-Core Version:    0.7.0.1
 */