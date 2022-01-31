package com.tencent.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.util.FileEncryptUtils;
import com.tencent.util.GLMemoryManager;
import com.tencent.util.IOUtils;
import com.tencent.util.LogUtil;
import com.tencent.view.raw.FilterRawGet;
import java.io.FileInputStream;
import java.io.InputStream;

public class FilterDefault
{
  public static boolean ENABLE_DEBUG;
  public static boolean ENABLE_GLFLUSH = false;
  public static boolean ENABLE_PROFILE;
  public static boolean ENABLE＿ASSERT;
  public static int currentShareIndex;
  private static FilterRawGet maim_Raw = new FilterRawGet();
  public static Context main_Context;
  
  static
  {
    ENABLE＿ASSERT = false;
    ENABLE_DEBUG = false;
    ENABLE_PROFILE = true;
    currentShareIndex = -1;
  }
  
  public static Bitmap decodeBitmap(int paramInt)
  {
    Object localObject2 = main_Context.getResources().openRawResource(paramInt);
    Object localObject1 = FileEncryptUtils.decryptFile((InputStream)localObject2);
    IOUtils.closeQuietly((InputStream)localObject2);
    if (localObject1 == null) {
      return null;
    }
    localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.ARGB_8888;
    try
    {
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      return localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public static Bitmap decodeBitmap(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      InputStream localInputStream = getInputStreamByName(paramString);
      if (localInputStream == null)
      {
        localObject1 = localObject2;
        LogUtil.e("FilterDefault", "decodeBitmap  getStream " + paramString + " not exist");
      }
      localObject1 = localObject2;
      paramString = FileEncryptUtils.decryptFile(localInputStream);
      localObject1 = paramString;
      IOUtils.closeQuietly(localInputStream);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        LogUtil.e("FilterDefault", "decodeBitmap  getStream", paramString);
        paramString = (String)localObject1;
      }
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.ARGB_8888;
      try
      {
        paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length, (BitmapFactory.Options)localObject1);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        LogUtil.e("FilterDefault", "decodeByteArray", paramString);
      }
    }
    if (paramString == null) {
      return null;
    }
    return null;
  }
  
  public static Bitmap decodeBitmap(String paramString, Bitmap.Config paramConfig)
  {
    Object localObject2 = null;
    localObject1 = localObject2;
    try
    {
      InputStream localInputStream = getInputStreamByName(paramString);
      localObject1 = localObject2;
      paramString = FileEncryptUtils.decryptFile(localInputStream);
      localObject1 = paramString;
      IOUtils.closeQuietly(localInputStream);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = (String)localObject1;
      }
    }
    if (paramString == null) {
      return null;
    }
    localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inPreferredConfig = paramConfig;
    return BitmapFactory.decodeByteArray(paramString, 0, paramString.length, (BitmapFactory.Options)localObject1);
  }
  
  public static Bitmap decodeBitmap(String paramString, Bitmap.Config paramConfig, int paramInt1, int paramInt2)
  {
    Paint localPaint = null;
    localObject = localPaint;
    try
    {
      InputStream localInputStream = getInputStreamByName(paramString);
      localObject = localPaint;
      paramString = FileEncryptUtils.decryptFile(localInputStream);
      localObject = paramString;
      IOUtils.closeQuietly(localInputStream);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = (String)localObject;
      }
    }
    if (paramString == null) {
      return null;
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inPreferredConfig = paramConfig;
    paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length, (BitmapFactory.Options)localObject);
    paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localObject = new Canvas(paramConfig);
    localPaint = new Paint(6);
    ((Canvas)localObject).drawBitmap(paramString, new Rect(0, 0, paramString.getWidth(), paramString.getHeight()), new Rect(0, 0, paramInt1, paramInt2), localPaint);
    paramString.recycle();
    return paramConfig;
  }
  
  public static int decodeBitmap2Texture(String paramString)
  {
    int i = 0;
    paramString = decodeBitmap(paramString);
    if (paramString != null)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 0;
      GLMemoryManager.getInstance().genTexture(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9728.0F);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLUtils.texImage2D(3553, 0, paramString, 0);
      paramString.recycle();
      i = arrayOfInt[0];
    }
    return i;
  }
  
  public static Bitmap decodeBitmapOutside(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      if (localFileInputStream == null)
      {
        localObject1 = localObject2;
        LogUtil.e("FilterDefault", "decodeBitmap  getStream " + paramString + " not exist");
      }
      localObject1 = localObject2;
      paramString = FileEncryptUtils.decryptFile(localFileInputStream);
      localObject1 = paramString;
      IOUtils.closeQuietly(localFileInputStream);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        LogUtil.e("FilterDefault", "decodeBitmap  getStream", paramString);
        paramString = (String)localObject1;
      }
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.ARGB_8888;
      try
      {
        paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length, (BitmapFactory.Options)localObject1);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        LogUtil.e("FilterDefault", "decodeByteArray", paramString);
      }
    }
    if (paramString == null) {
      return null;
    }
    return null;
  }
  
  /* Error */
  public static InputStream getInputStreamByName(String paramString)
  {
    // Byte code:
    //   0: getstatic 26	com/tencent/view/FilterDefault:ENABLE＿ASSERT	Z
    //   3: ifeq +24 -> 27
    //   6: getstatic 42	com/tencent/view/FilterDefault:main_Context	Landroid/content/Context;
    //   9: invokevirtual 201	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: invokevirtual 206	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_0
    //   19: aload_0
    //   20: areturn
    //   21: astore_0
    //   22: aconst_null
    //   23: areturn
    //   24: astore_0
    //   25: aload_0
    //   26: athrow
    //   27: getstatic 24	com/tencent/view/FilterDefault:maim_Raw	Lcom/tencent/view/raw/FilterRawGet;
    //   30: aload_0
    //   31: invokevirtual 209	com/tencent/view/raw/FilterRawGet:getInpuStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	paramString	String
    //   12	2	1	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   13	19	21	java/io/IOException
    //   13	19	24	finally
  }
  
  public static void initResource()
  {
    IOUtils.closeQuietly(getInputStreamByName("pro.png"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.view.FilterDefault
 * JD-Core Version:    0.7.0.1
 */