package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.apollo.utils.ApolloBitmapUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import mqq.os.MqqHandler;

public class SavaImageUtil
{
  protected static long a = 0L;
  protected static File b;
  private static int c = 1024;
  private static int d = 1024;
  private static final String e;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("cmshow");
    e = localStringBuilder.toString();
  }
  
  public static Bitmap a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getApolloBitmap], path:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",format:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("[cmshow]ImageUtil", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ImageUtil", 2, "errInfo-> path is NULL.");
      }
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (4 == paramInt) {
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
    } else if (6 == paramInt) {
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    } else {
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      return localBitmap;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("errInfo3->exception->");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("[cmshow]ImageUtil", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      localOptions.inJustDecodeBounds = true;
    }
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      localObject = paramString;
      paramInt = localOptions.outWidth;
    }
    catch (OutOfMemoryError paramString)
    {
      int i;
      label287:
      break label287;
    }
    try
    {
      i = localOptions.outHeight;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("errInfo2->oom->");
      ((StringBuilder)localObject).append(localOutOfMemoryError2.getMessage());
      ((StringBuilder)localObject).append(",h:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",w:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("[cmshow]ImageUtil", 1, ((StringBuilder)localObject).toString());
      return paramString;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      break label292;
    }
    paramInt = 0;
    paramString = (String)localObject;
    label292:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("errInfo1->oom->");
    ((StringBuilder)localObject).append(localOutOfMemoryError2.getMessage());
    ((StringBuilder)localObject).append(",h:");
    ((StringBuilder)localObject).append(0);
    ((StringBuilder)localObject).append(",w:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("[cmshow]ImageUtil", 1, ((StringBuilder)localObject).toString());
    return paramString;
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramInt, (BitmapFactory.Options)localObject);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("BitmapFactory.decodeBuffer failed:");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      QLog.e("[cmshow]ImageUtil", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.e("[cmshow]ImageUtil", 2, "imageselector selectPhotoFromSystem");
    View localView = ApolloRender.getCurrentRenderView();
    if (localView == null)
    {
      QLog.e("[cmshow]ImageUtil", 2, "imageselector view Null Error");
      return;
    }
    if (a == 0L)
    {
      QLog.e("[cmshow]ImageUtil", 2, "imageselector g_imageselector == 0 Error");
      return;
    }
    if ((localView instanceof ApolloSurfaceView))
    {
      if (QLog.isColorLevel()) {
        QLog.e("[cmshow]ImageUtil", 2, "imageselector selectimagecallback ");
      }
      if (paramInt2 == -1)
      {
        Object localObject = null;
        if (paramInt1 == 14005)
        {
          localObject = ApolloBitmapUtil.a(b.getAbsolutePath(), c, d);
          b = null;
        }
        else if (paramInt1 == 14006)
        {
          localObject = paramIntent.getData();
          paramIntent = new String[1];
          paramIntent[0] = "_data";
          localObject = localView.getContext().getContentResolver().query((Uri)localObject, paramIntent, null, null, null);
          ((Cursor)localObject).moveToFirst();
          paramIntent = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex(paramIntent[0]));
          ((Cursor)localObject).close();
          localObject = ApolloBitmapUtil.a(paramIntent, 1024, 1024);
        }
        if (localObject != null)
        {
          paramIntent = ByteBuffer.allocate(((Bitmap)localObject).getByteCount());
          paramInt1 = ((Bitmap)localObject).getWidth();
          int i = ((Bitmap)localObject).getHeight();
          ((Bitmap)localObject).copyPixelsToBuffer(paramIntent);
          paramIntent = paramIntent.array();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("imageselector selectimageallback surfaceView  ");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(" data: ");
          QLog.e("[cmshow]ImageUtil", 2, ((StringBuilder)localObject).toString());
          ((ApolloSurfaceView)localView).getRender().getSavaWrapper().selectPhotoCallBack(a, 1, paramInt1, i, paramIntent);
          return;
        }
        ((ApolloSurfaceView)localView).getRender().getSavaWrapper().selectPhotoCallBack(a, 2, 0, 0, null);
        return;
      }
      if (paramInt2 == 0)
      {
        ((ApolloSurfaceView)localView).getRender().getSavaWrapper().selectPhotoCallBack(a, 3, 0, 0, null);
        return;
      }
      ((ApolloSurfaceView)localView).getRender().getSavaWrapper().selectPhotoCallBack(a, 2, 0, 0, null);
      return;
    }
    if ((localView instanceof ApolloTextureView))
    {
      ((ApolloTextureView)localView).queueEvent(new SavaImageUtil.2(paramInt2, paramIntent, localView));
      return;
    }
    QLog.e("[cmshow]ImageUtil", 1, "imageselector view type else ");
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2)
  {
    View localView = ApolloRender.getCurrentRenderView();
    if (localView == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new SavaImageUtil.1(paramLong, paramInt1, localView));
  }
  
  /* Error */
  public static Bitmap b(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aload 5
    //   10: astore_2
    //   11: new 75	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 76	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore 6
    //   20: aload 5
    //   22: astore_2
    //   23: aload 6
    //   25: iconst_1
    //   26: putfield 124	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   29: aload 5
    //   31: astore_2
    //   32: aload 6
    //   34: iconst_0
    //   35: putfield 105	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   38: aload 5
    //   40: astore_2
    //   41: aload 6
    //   43: getstatic 88	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   46: putfield 85	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   49: aload 5
    //   51: astore_2
    //   52: aload_0
    //   53: iconst_0
    //   54: iload_1
    //   55: aload 6
    //   57: invokestatic 128	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: astore 6
    //   62: aload 5
    //   64: astore_2
    //   65: aload 6
    //   67: invokevirtual 224	android/graphics/Bitmap:getWidth	()I
    //   70: aload 6
    //   72: invokevirtual 227	android/graphics/Bitmap:getHeight	()I
    //   75: getstatic 88	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   78: invokestatic 288	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   81: astore_0
    //   82: new 290	android/graphics/Canvas
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 293	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   90: astore_2
    //   91: aload_2
    //   92: aload 6
    //   94: fconst_0
    //   95: fconst_0
    //   96: aconst_null
    //   97: invokevirtual 297	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   100: aload_2
    //   101: invokevirtual 300	android/graphics/Canvas:save	()I
    //   104: pop
    //   105: aload_0
    //   106: areturn
    //   107: aload_0
    //   108: areturn
    //   109: astore_3
    //   110: goto +11 -> 121
    //   113: astore_3
    //   114: goto +15 -> 129
    //   117: astore_3
    //   118: aload 4
    //   120: astore_0
    //   121: aload_0
    //   122: astore_2
    //   123: aload_3
    //   124: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   127: aload_0
    //   128: areturn
    //   129: aload_0
    //   130: astore_2
    //   131: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +15 -> 149
    //   137: aload_0
    //   138: astore_2
    //   139: ldc 62
    //   141: iconst_2
    //   142: aload_3
    //   143: invokevirtual 114	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   146: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload_0
    //   150: areturn
    //   151: astore_0
    //   152: aload_2
    //   153: areturn
    //   154: astore_2
    //   155: goto -48 -> 107
    //   158: astore_2
    //   159: aload_3
    //   160: astore_0
    //   161: aload_2
    //   162: astore_3
    //   163: goto -34 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramArrayOfByte	byte[]
    //   0	166	1	paramInt	int
    //   10	143	2	localObject1	Object
    //   154	1	2	localObject2	Object
    //   158	4	2	localOutOfMemoryError1	OutOfMemoryError
    //   1	1	3	localObject3	Object
    //   109	1	3	localException1	Exception
    //   113	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   117	43	3	localException2	Exception
    //   162	1	3	localObject4	Object
    //   6	113	4	localObject5	Object
    //   3	60	5	localObject6	Object
    //   18	75	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   82	105	109	java/lang/Exception
    //   82	105	113	java/lang/OutOfMemoryError
    //   11	20	117	java/lang/Exception
    //   23	29	117	java/lang/Exception
    //   32	38	117	java/lang/Exception
    //   41	49	117	java/lang/Exception
    //   52	62	117	java/lang/Exception
    //   65	82	117	java/lang/Exception
    //   11	20	151	finally
    //   23	29	151	finally
    //   32	38	151	finally
    //   41	49	151	finally
    //   52	62	151	finally
    //   65	82	151	finally
    //   123	127	151	finally
    //   131	137	151	finally
    //   139	149	151	finally
    //   82	105	154	finally
    //   11	20	158	java/lang/OutOfMemoryError
    //   23	29	158	java/lang/OutOfMemoryError
    //   32	38	158	java/lang/OutOfMemoryError
    //   41	49	158	java/lang/OutOfMemoryError
    //   52	62	158	java/lang/OutOfMemoryError
    //   65	82	158	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.SavaImageUtil
 * JD-Core Version:    0.7.0.1
 */