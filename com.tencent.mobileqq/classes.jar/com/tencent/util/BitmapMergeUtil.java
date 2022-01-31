package com.tencent.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class BitmapMergeUtil
{
  static Paint paint = new Paint(7);
  
  public static Bitmap createBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (paramBitmap1 == null) {
      return null;
    }
    int i = paramBitmap1.getWidth();
    int j = paramBitmap1.getHeight();
    int k = paramBitmap2.getWidth();
    int m = paramBitmap2.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, paint);
    localCanvas.drawBitmap(paramBitmap2, i - k + 5, j - m + 5, paint);
    localCanvas.save(31);
    localCanvas.restore();
    return localBitmap;
  }
  
  public static Bitmap decodeBitmap(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    FileInputStream localFileInputStream = new FileInputStream(paramString);
    BitmapFactory.decodeStream(localFileInputStream, null, (BitmapFactory.Options)localObject);
    localFileInputStream.close();
    int i = 1;
    int k = ((BitmapFactory.Options)localObject).outWidth;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    for (;;)
    {
      if ((k / 2 < paramInt1) || (j / 2 < paramInt2))
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        paramString = new FileInputStream(paramString);
        localObject = BitmapFactory.decodeStream(paramString, null, (BitmapFactory.Options)localObject);
        paramString.close();
        return localObject;
      }
      k /= 2;
      j /= 2;
      i *= 2;
    }
  }
  
  public static Bitmap gerZoomRotateBitmap(Bitmap paramBitmap, int paramInt)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = 300 / i;
    float f2 = 300 / j;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    localMatrix.postRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-12434878);
    localCanvas.drawRoundRect(localRectF, 12.0F, 12.0F, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  public static Bitmap getStrechBitmap(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject6 = null;
    Object localObject3 = localObject4;
    try
    {
      localObject5 = paramResources.openRawResource(paramInt1);
      localObject1 = localObject5;
      localObject3 = localObject4;
      localObject2 = localObject5;
      localObject4 = NinePatchCodec.decodeNinePatch((InputStream)localObject5);
      localObject1 = localObject5;
      localObject3 = localObject4;
      localObject2 = localObject5;
      IOUtils.closeQuietly((InputStream)localObject5);
      localObject1 = localObject5;
      localObject3 = localObject4;
      localObject2 = localObject5;
      paramResources = paramResources.openRawResource(paramInt1);
      localObject1 = paramResources;
      localObject3 = localObject4;
      localObject2 = paramResources;
      localObject5 = BitmapFactory.decodeStream(paramResources);
      localObject1 = localObject5;
      IOUtils.closeQuietly(paramResources);
      localObject3 = localObject4;
      paramResources = (Resources)localObject1;
    }
    catch (Throwable paramResources)
    {
      for (;;)
      {
        localObject2 = localObject1;
        paramResources.printStackTrace();
        IOUtils.closeQuietly((InputStream)localObject1);
        paramResources = (Resources)localObject6;
      }
    }
    finally
    {
      IOUtils.closeQuietly((InputStream)localObject2);
    }
    if ((localObject3 == null) || (paramResources == null)) {
      return null;
    }
    paramInt1 = paramResources.getWidth();
    int i = paramResources.getHeight();
    paramInt2 = ((NinePatchCodec.NinePatch)localObject3).padLeft + paramInt2 + ((NinePatchCodec.NinePatch)localObject3).padRight;
    paramInt3 = ((NinePatchCodec.NinePatch)localObject3).padTop + paramInt3 + ((NinePatchCodec.NinePatch)localObject3).padBottom;
    localObject1 = new Rect();
    localObject2 = new Rect();
    localObject4 = Bitmap.createBitmap(paramInt2, i, Bitmap.Config.ARGB_8888);
    Object localObject5 = new Canvas((Bitmap)localObject4);
    localObject6 = getStrechBlockList(((NinePatchCodec.NinePatch)localObject3).xDivs, paramInt1, paramInt2);
    ((Rect)localObject2).left = 0;
    ((Rect)localObject1).top = 0;
    ((Rect)localObject1).bottom = i;
    ((Rect)localObject2).top = 0;
    ((Rect)localObject2).bottom = i;
    localObject6 = ((ArrayList)localObject6).iterator();
    StrechBlock localStrechBlock;
    while (((Iterator)localObject6).hasNext())
    {
      localStrechBlock = (StrechBlock)((Iterator)localObject6).next();
      paramInt1 = localStrechBlock.strechWidth;
      while (paramInt1 > localStrechBlock.end - localStrechBlock.start)
      {
        ((Rect)localObject1).left = localStrechBlock.start;
        ((Rect)localObject1).right = localStrechBlock.end;
        ((Rect)localObject2).right = (((Rect)localObject2).left + ((Rect)localObject1).width());
        ((Canvas)localObject5).drawBitmap(paramResources, (Rect)localObject1, (Rect)localObject2, paint);
        ((Rect)localObject2).left += ((Rect)localObject1).width();
        paramInt1 -= ((Rect)localObject1).width();
      }
      ((Rect)localObject1).left = localStrechBlock.start;
      ((Rect)localObject1).right = (localStrechBlock.start + paramInt1);
      ((Rect)localObject2).right = (((Rect)localObject2).left + ((Rect)localObject1).width());
      ((Canvas)localObject5).drawBitmap(paramResources, (Rect)localObject1, (Rect)localObject2, paint);
      ((Rect)localObject2).left += ((Rect)localObject1).width();
    }
    localObject5 = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    localObject6 = new Canvas((Bitmap)localObject5);
    localObject3 = getStrechBlockList(((NinePatchCodec.NinePatch)localObject3).yDivs, i, paramInt3);
    ((Rect)localObject2).top = 0;
    ((Rect)localObject1).left = 0;
    ((Rect)localObject1).right = paramInt2;
    ((Rect)localObject2).left = 0;
    ((Rect)localObject2).right = paramInt2;
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localStrechBlock = (StrechBlock)((Iterator)localObject3).next();
      paramInt1 = localStrechBlock.strechWidth;
      while (paramInt1 > localStrechBlock.end - localStrechBlock.start)
      {
        ((Rect)localObject1).top = localStrechBlock.start;
        ((Rect)localObject1).bottom = localStrechBlock.end;
        ((Rect)localObject2).bottom = (((Rect)localObject2).top + ((Rect)localObject1).height());
        ((Canvas)localObject6).drawBitmap((Bitmap)localObject4, (Rect)localObject1, (Rect)localObject2, paint);
        ((Rect)localObject2).top += ((Rect)localObject1).height();
        paramInt1 -= ((Rect)localObject1).height();
      }
      ((Rect)localObject1).top = localStrechBlock.start;
      ((Rect)localObject1).bottom = (localStrechBlock.start + paramInt1);
      ((Rect)localObject2).bottom = (((Rect)localObject2).top + ((Rect)localObject1).height());
      ((Canvas)localObject6).drawBitmap((Bitmap)localObject4, (Rect)localObject1, (Rect)localObject2, paint);
      ((Rect)localObject2).top += ((Rect)localObject1).height();
    }
    ((Bitmap)localObject4).recycle();
    paramResources.recycle();
    return localObject5;
  }
  
  public static ArrayList<StrechBlock> getStrechBlockList(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 1;
    while (i < paramArrayOfInt.length)
    {
      int k = j;
      if (i % 2 == 1) {
        k = j + (paramArrayOfInt[i] - paramArrayOfInt[(i - 1)]);
      }
      i += 1;
      j = k;
    }
    double d2 = 1.0D * (paramInt2 - (paramInt1 - j)) / j;
    double d1 = d2;
    if (d2 < 0.0D) {
      d1 = 1.0D;
    }
    StrechBlock localStrechBlock = new StrechBlock();
    localStrechBlock.start = 0;
    localStrechBlock.end = paramArrayOfInt[0];
    localStrechBlock.strechWidth = paramArrayOfInt[0];
    localArrayList.add(localStrechBlock);
    i = 1;
    if (i < paramArrayOfInt.length)
    {
      localStrechBlock = new StrechBlock();
      localStrechBlock.start = paramArrayOfInt[(i - 1)];
      localStrechBlock.end = paramArrayOfInt[i];
      if (i % 2 == 1) {
        localStrechBlock.strechWidth = ((int)((localStrechBlock.end - localStrechBlock.start) * d1));
      }
      for (localStrechBlock.strechWidth = (localStrechBlock.strechWidth / (localStrechBlock.end - localStrechBlock.start) * (localStrechBlock.end - localStrechBlock.start));; localStrechBlock.strechWidth = (localStrechBlock.end - localStrechBlock.start))
      {
        localArrayList.add(localStrechBlock);
        i += 1;
        break;
      }
    }
    localStrechBlock = new StrechBlock();
    localStrechBlock.start = paramArrayOfInt[(paramArrayOfInt.length - 1)];
    localStrechBlock.end = paramInt1;
    localStrechBlock.strechWidth = (localStrechBlock.end - localStrechBlock.start);
    localArrayList.add(localStrechBlock);
    paramInt1 = 0;
    paramArrayOfInt = localArrayList.iterator();
    while (paramArrayOfInt.hasNext()) {
      paramInt1 += ((StrechBlock)paramArrayOfInt.next()).strechWidth;
    }
    paramArrayOfInt = (StrechBlock)localArrayList.get(1);
    paramArrayOfInt.strechWidth += paramInt2 - paramInt1;
    paramArrayOfInt = (StrechBlock)localArrayList.get(1);
    paramInt1 = ((StrechBlock)localArrayList.get(1)).strechWidth / (((StrechBlock)localArrayList.get(1)).end - ((StrechBlock)localArrayList.get(1)).start);
    paramArrayOfInt.strechWidth = ((((StrechBlock)localArrayList.get(1)).end - ((StrechBlock)localArrayList.get(1)).start) * paramInt1);
    return localArrayList;
  }
  
  public static Bitmap mergeBitmap(Resources paramResources, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4)
    throws IOException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    NinePatchCodec.NinePatch localNinePatch;
    try
    {
      localObject3 = paramResources.openRawResource(paramInt1);
      localObject1 = localObject3;
      localObject2 = localObject3;
      localNinePatch = NinePatchCodec.decodeNinePatch((InputStream)localObject3);
      IOUtils.closeQuietly((InputStream)localObject3);
      if (localNinePatch == null) {
        return null;
      }
    }
    catch (Throwable paramResources)
    {
      localObject2 = localObject1;
      paramResources.printStackTrace();
      return null;
    }
    finally
    {
      IOUtils.closeQuietly((InputStream)localObject2);
    }
    localObject2 = paramResources.openRawResource(paramInt1);
    localObject1 = BitmapFactory.decodeStream((InputStream)localObject2);
    ((InputStream)localObject2).close();
    if ((localNinePatch.xDivs[1] == 1) && (localNinePatch.xDivs[0] == 0) && (localNinePatch.yDivs[1] == 1) && (localNinePatch.yDivs[0] == 0))
    {
      localObject2 = new Rect(localNinePatch.padLeft, localNinePatch.padTop, ((Bitmap)localObject1).getWidth() - localNinePatch.padRight, ((Bitmap)localObject1).getHeight() - localNinePatch.padBottom);
      if (paramInt2 > 0) {
        paramResources.getDrawable(paramInt2);
      }
      return mergeBitmap((Bitmap)localObject1, (Rect)localObject2, paramBitmap);
    }
    int m = ((Bitmap)localObject1).getWidth();
    int k = ((Bitmap)localObject1).getHeight();
    int i = paramBitmap.getWidth() + localNinePatch.padLeft + localNinePatch.padRight;
    paramInt2 = paramBitmap.getHeight() + localNinePatch.padTop + localNinePatch.padBottom;
    paramInt1 = i;
    if (i < m) {
      paramInt1 = m;
    }
    int j = paramInt2;
    if (paramInt2 < k) {
      j = k;
    }
    i = j;
    paramInt2 = paramInt1;
    if (paramInt3 > 0)
    {
      i = j;
      paramInt2 = paramInt1;
      if (paramInt1 > paramInt3)
      {
        i = j * paramInt3 / paramInt1;
        paramInt2 = paramInt3;
      }
    }
    paramInt1 = i;
    paramInt3 = paramInt2;
    if (paramInt4 > 0)
    {
      paramInt1 = i;
      paramInt3 = paramInt2;
      if (i > paramInt4)
      {
        paramInt3 = paramInt2 * paramInt4 / i;
        paramInt1 = paramInt4;
      }
    }
    paramResources = new Rect();
    localObject2 = new Rect();
    Object localObject5 = getStrechBlockList(localNinePatch.xDivs, m, paramInt3);
    paramInt2 = 0;
    Object localObject3 = ((ArrayList)localObject5).iterator();
    while (((Iterator)localObject3).hasNext()) {
      paramInt2 += ((StrechBlock)((Iterator)localObject3).next()).strechWidth;
    }
    localObject3 = Bitmap.createBitmap(paramInt2, k, Bitmap.Config.ARGB_8888);
    Object localObject4 = new Canvas((Bitmap)localObject3);
    ((Rect)localObject2).left = 0;
    paramResources.top = 0;
    paramResources.bottom = k;
    ((Rect)localObject2).top = 0;
    ((Rect)localObject2).bottom = k;
    localObject5 = ((ArrayList)localObject5).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (StrechBlock)((Iterator)localObject5).next();
      paramInt3 = ((StrechBlock)localObject6).strechWidth;
      while (paramInt3 > ((StrechBlock)localObject6).end - ((StrechBlock)localObject6).start)
      {
        paramResources.left = ((StrechBlock)localObject6).start;
        paramResources.right = ((StrechBlock)localObject6).end;
        ((Rect)localObject2).right = (((Rect)localObject2).left + paramResources.width());
        ((Canvas)localObject4).drawBitmap((Bitmap)localObject1, paramResources, (Rect)localObject2, paint);
        ((Rect)localObject2).left += paramResources.width();
        paramInt3 -= paramResources.width();
      }
      paramResources.left = ((StrechBlock)localObject6).start;
      paramResources.right = (((StrechBlock)localObject6).start + paramInt3);
      ((Rect)localObject2).right = (((Rect)localObject2).left + paramResources.width());
      ((Canvas)localObject4).drawBitmap((Bitmap)localObject1, paramResources, (Rect)localObject2, paint);
      ((Rect)localObject2).left += paramResources.width();
    }
    Object localObject6 = getStrechBlockList(localNinePatch.yDivs, k, paramInt1);
    paramInt1 = 0;
    localObject4 = ((ArrayList)localObject6).iterator();
    while (((Iterator)localObject4).hasNext()) {
      paramInt1 += ((StrechBlock)((Iterator)localObject4).next()).strechWidth;
    }
    localObject4 = Bitmap.createBitmap(paramInt2, paramInt1, Bitmap.Config.ARGB_8888);
    localObject5 = new Canvas((Bitmap)localObject4);
    ((Rect)localObject2).top = 0;
    paramResources.left = 0;
    paramResources.right = paramInt2;
    ((Rect)localObject2).left = 0;
    ((Rect)localObject2).right = paramInt2;
    localObject6 = ((ArrayList)localObject6).iterator();
    while (((Iterator)localObject6).hasNext())
    {
      StrechBlock localStrechBlock = (StrechBlock)((Iterator)localObject6).next();
      paramInt1 = localStrechBlock.strechWidth;
      while (paramInt1 > localStrechBlock.end - localStrechBlock.start)
      {
        paramResources.top = localStrechBlock.start;
        paramResources.bottom = localStrechBlock.end;
        ((Rect)localObject2).bottom = (((Rect)localObject2).top + paramResources.height());
        ((Canvas)localObject5).drawBitmap((Bitmap)localObject3, paramResources, (Rect)localObject2, paint);
        ((Rect)localObject2).top += paramResources.height();
        paramInt1 -= paramResources.height();
      }
      paramResources.top = localStrechBlock.start;
      paramResources.bottom = (localStrechBlock.start + paramInt1);
      ((Rect)localObject2).bottom = (((Rect)localObject2).top + paramResources.height());
      ((Canvas)localObject5).drawBitmap((Bitmap)localObject3, paramResources, (Rect)localObject2, paint);
      ((Rect)localObject2).top += paramResources.height();
    }
    ((Bitmap)localObject3).recycle();
    ((Bitmap)localObject1).recycle();
    paramResources = mergeBitmap((Bitmap)localObject4, new Rect(localNinePatch.padLeft, localNinePatch.padTop, ((Bitmap)localObject4).getWidth() - localNinePatch.padRight, ((Bitmap)localObject4).getHeight() - localNinePatch.padBottom), paramBitmap);
    ((Bitmap)localObject4).recycle();
    return paramResources;
  }
  
  public static Bitmap mergeBitmap(Bitmap paramBitmap1, Rect paramRect, Bitmap paramBitmap2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap1.getWidth(), paramBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.save();
    Matrix localMatrix = new Matrix();
    float f1 = 0.0F;
    float f2 = 0.0F;
    int i = paramRect.width();
    int j = paramRect.height();
    int k = paramBitmap2.getWidth();
    int m = paramBitmap2.getHeight();
    float f3;
    if (k * j > i * m)
    {
      f3 = j / m;
      f1 = (i - k * f3) * 0.5F;
    }
    for (;;)
    {
      localMatrix.setScale(f3, f3);
      localMatrix.postTranslate((int)(0.5F + f1), (int)(0.5F + f2));
      localCanvas.clipRect(paramRect);
      localCanvas.translate(paramRect.left, paramRect.top);
      localCanvas.drawBitmap(paramBitmap2, localMatrix, paint);
      localCanvas.restore();
      localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, paint);
      return localBitmap;
      f3 = i / k;
      f2 = (j - m * f3) * 0.5F;
    }
  }
  
  public static Bitmap mergeBitmapIn(Bitmap paramBitmap1, Drawable paramDrawable, Rect paramRect, Bitmap paramBitmap2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap1.getWidth(), paramBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.save();
    Matrix localMatrix = new Matrix();
    int i = paramRect.width();
    int j = paramRect.height();
    int k = paramBitmap2.getWidth();
    int m = paramBitmap2.getHeight();
    float f1;
    if ((k <= i) && (m <= j))
    {
      f1 = 1.0F;
      float f2 = (int)((i - k * f1) * 0.5F + 0.5F);
      float f3 = (int)((j - m * f1) * 0.5F + 0.5F);
      localMatrix.setScale(f1, f1);
      localMatrix.postTranslate(f2, f3);
      localCanvas.clipRect(paramRect);
      if (paramDrawable == null) {
        break label235;
      }
      paramDrawable.setBounds(paramRect);
      paramDrawable.draw(localCanvas);
    }
    for (;;)
    {
      localCanvas.translate(paramRect.left, paramRect.top);
      localCanvas.drawBitmap(paramBitmap2, localMatrix, paint);
      localCanvas.restore();
      localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, paint);
      return localBitmap;
      f1 = Math.min(i / k, j / m);
      break;
      label235:
      paramDrawable = new Paint();
      paramDrawable.setColor(-1);
      localCanvas.drawRect(paramRect, paramDrawable);
    }
  }
  
  public static Bitmap mergeInBitmap(Bitmap paramBitmap1, Rect paramRect, Bitmap paramBitmap2)
  {
    paramBitmap1.getWidth();
    paramBitmap1.getHeight();
    Canvas localCanvas = new Canvas(paramBitmap1);
    Matrix localMatrix = new Matrix();
    float f1 = 0.0F;
    float f2 = 0.0F;
    int i = paramRect.width();
    int j = paramRect.height();
    int k = paramBitmap2.getWidth();
    int m = paramBitmap2.getHeight();
    float f3;
    if (k * j > i * m)
    {
      f3 = j / m;
      f1 = (i - k * f3) * 0.5F;
    }
    for (;;)
    {
      localMatrix.setScale(f3, f3);
      localMatrix.postTranslate((int)(0.5F + f1 + paramRect.left), (int)(0.5F + f2 + paramRect.top));
      localCanvas.drawBitmap(paramBitmap2, localMatrix, paint);
      return paramBitmap1;
      f3 = i / k;
      f2 = (j - m * f3) * 0.5F;
    }
  }
  
  public static class StrechBlock
  {
    public int end;
    public int start;
    public int strechWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.util.BitmapMergeUtil
 * JD-Core Version:    0.7.0.1
 */