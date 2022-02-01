package com.tencent.mtt.hippy.adapter.image;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class HippyDrawable
  implements IDrawableTarget
{
  private Bitmap mBitmap;
  protected Drawable mDrawable;
  private Movie mGifMovie;
  protected String mSource;
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
  
  public Object getExtraData()
  {
    return null;
  }
  
  public Movie getGIF()
  {
    return this.mGifMovie;
  }
  
  public String getSource()
  {
    return this.mSource;
  }
  
  public boolean isAnimated()
  {
    return this.mGifMovie != null;
  }
  
  public void onDrawableAttached() {}
  
  public void onDrawableDetached() {}
  
  public void setData(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    this.mGifMovie = null;
  }
  
  /* Error */
  public void setData(File paramFile)
  {
    // Byte code:
    //   0: new 48	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 50	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_2
    //   12: invokevirtual 54	java/io/FileInputStream:available	()I
    //   15: newarray byte
    //   17: astore_3
    //   18: aload_2
    //   19: astore_1
    //   20: aload_2
    //   21: aload_3
    //   22: invokevirtual 58	java/io/FileInputStream:read	([B)I
    //   25: pop
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: aload_3
    //   30: invokevirtual 61	com/tencent/mtt/hippy/adapter/image/HippyDrawable:setData	([B)V
    //   33: aload_2
    //   34: ifnull +7 -> 41
    //   37: aload_2
    //   38: invokevirtual 64	java/io/FileInputStream:close	()V
    //   41: return
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   47: return
    //   48: astore_3
    //   49: aconst_null
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   57: aload_2
    //   58: ifnull -17 -> 41
    //   61: aload_2
    //   62: invokevirtual 64	java/io/FileInputStream:close	()V
    //   65: return
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   71: return
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +7 -> 83
    //   79: aload_1
    //   80: invokevirtual 64	java/io/FileInputStream:close	()V
    //   83: aload_2
    //   84: athrow
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   90: goto -7 -> 83
    //   93: astore_2
    //   94: goto -19 -> 75
    //   97: astore_3
    //   98: goto -47 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	HippyDrawable
    //   0	101	1	paramFile	File
    //   8	54	2	localFileInputStream	java.io.FileInputStream
    //   72	12	2	localObject1	Object
    //   93	1	2	localObject2	Object
    //   17	13	3	arrayOfByte	byte[]
    //   48	6	3	localException1	Exception
    //   97	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   37	41	42	java/lang/Exception
    //   0	9	48	java/lang/Exception
    //   61	65	66	java/lang/Exception
    //   0	9	72	finally
    //   79	83	85	java/lang/Exception
    //   11	18	93	finally
    //   20	26	93	finally
    //   28	33	93	finally
    //   53	57	93	finally
    //   11	18	97	java/lang/Exception
    //   20	26	97	java/lang/Exception
    //   28	33	97	java/lang/Exception
  }
  
  /* Error */
  public void setData(File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 48	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 50	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_3
    //   9: iload_2
    //   10: ifeq +29 -> 39
    //   13: aload_3
    //   14: astore_1
    //   15: aload_0
    //   16: aload_3
    //   17: invokestatic 74	android/graphics/Movie:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Movie;
    //   20: putfield 33	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mGifMovie	Landroid/graphics/Movie;
    //   23: aload_3
    //   24: astore_1
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 23	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mBitmap	Landroid/graphics/Bitmap;
    //   30: aload_3
    //   31: ifnull +7 -> 38
    //   34: aload_3
    //   35: invokevirtual 64	java/io/FileInputStream:close	()V
    //   38: return
    //   39: aload_3
    //   40: astore_1
    //   41: aload_0
    //   42: aload_3
    //   43: invokestatic 79	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   46: putfield 23	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mBitmap	Landroid/graphics/Bitmap;
    //   49: aload_3
    //   50: astore_1
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 33	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mGifMovie	Landroid/graphics/Movie;
    //   56: goto -26 -> 30
    //   59: astore 4
    //   61: aload_3
    //   62: astore_1
    //   63: aload 4
    //   65: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   68: aload_3
    //   69: ifnull -31 -> 38
    //   72: aload_3
    //   73: invokevirtual 64	java/io/FileInputStream:close	()V
    //   76: return
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   82: return
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   88: return
    //   89: astore_3
    //   90: aconst_null
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 64	java/io/FileInputStream:close	()V
    //   100: aload_3
    //   101: athrow
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   107: goto -7 -> 100
    //   110: astore_3
    //   111: goto -19 -> 92
    //   114: astore 4
    //   116: aconst_null
    //   117: astore_3
    //   118: goto -57 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	HippyDrawable
    //   0	121	1	paramFile	File
    //   0	121	2	paramBoolean	boolean
    //   8	65	3	localFileInputStream	java.io.FileInputStream
    //   89	12	3	localObject1	Object
    //   110	1	3	localObject2	Object
    //   117	1	3	localObject3	Object
    //   59	5	4	localException1	Exception
    //   114	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   15	23	59	java/lang/Exception
    //   25	30	59	java/lang/Exception
    //   41	49	59	java/lang/Exception
    //   51	56	59	java/lang/Exception
    //   72	76	77	java/lang/Exception
    //   34	38	83	java/lang/Exception
    //   0	9	89	finally
    //   96	100	102	java/lang/Exception
    //   15	23	110	finally
    //   25	30	110	finally
    //   41	49	110	finally
    //   51	56	110	finally
    //   63	68	110	finally
    //   0	9	114	java/lang/Exception
  }
  
  public void setData(String paramString)
  {
    this.mSource = paramString;
    if (this.mSource.startsWith("data:")) {}
    for (;;)
    {
      try
      {
        int i = this.mSource.indexOf(";base64,");
        if (i >= 0)
        {
          int j = ";base64,".length();
          paramString = Base64.decode(this.mSource.substring(i + j), 0);
          if (paramString != null) {
            setData(paramString);
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (this.mSource.startsWith("file://"))
      {
        setData(new File(this.mSource.substring("file://".length())));
        return;
      }
      if (this.mSource.startsWith("assets://"))
      {
        byte[] arrayOfByte = null;
        Object localObject3 = null;
        InputStream localInputStream = null;
        Object localObject1 = arrayOfByte;
        paramString = localObject3;
        try
        {
          if (Build.VERSION.SDK_INT >= 28)
          {
            localObject1 = arrayOfByte;
            paramString = localObject3;
            setDataForTarge28Assets(this.mSource);
          }
          while (localInputStream != null)
          {
            try
            {
              localInputStream.close();
              return;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              return;
            }
            localObject1 = arrayOfByte;
            paramString = localObject3;
            localInputStream = ContextHolder.getAppContext().getAssets().open(this.mSource.substring("assets://".length()));
            localObject1 = localInputStream;
            paramString = localInputStream;
            arrayOfByte = new byte[localInputStream.available()];
            localObject1 = localInputStream;
            paramString = localInputStream;
            localInputStream.read(arrayOfByte);
            localObject1 = localInputStream;
            paramString = localInputStream;
            setData(arrayOfByte);
          }
        }
        catch (Exception localException)
        {
          paramString = (String)localObject1;
          localException.printStackTrace();
          if (localObject1 != null) {
            try
            {
              ((InputStream)localObject1).close();
              return;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              return;
            }
          }
        }
        finally
        {
          if (paramString == null) {}
        }
      }
    }
    try
    {
      paramString.close();
      throw localObject2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    this.mGifMovie = Movie.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    if (this.mGifMovie == null)
    {
      this.mBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      return;
    }
    this.mBitmap = null;
  }
  
  public void setDataForTarge28Assets(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 28) {}
    try
    {
      this.mBitmap = ImageDecoder.decodeBitmap(ImageDecoder.createSource(ContextHolder.getAppContext().getAssets(), paramString.substring("assets://".length())));
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setDrawable(Drawable paramDrawable)
  {
    this.mDrawable = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.image.HippyDrawable
 * JD-Core Version:    0.7.0.1
 */