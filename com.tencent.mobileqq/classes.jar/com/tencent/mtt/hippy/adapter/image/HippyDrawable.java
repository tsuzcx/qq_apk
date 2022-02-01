package com.tencent.mtt.hippy.adapter.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;
import java.io.IOException;

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
  public void setData(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: new 48	java/io/FileInputStream
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 50	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 54	java/io/FileInputStream:available	()I
    //   18: newarray byte
    //   20: astore_2
    //   21: aload_1
    //   22: aload_2
    //   23: invokevirtual 58	java/io/FileInputStream:read	([B)I
    //   26: pop
    //   27: aload_0
    //   28: aload_2
    //   29: invokevirtual 61	com/tencent/mtt/hippy/adapter/image/HippyDrawable:setData	([B)V
    //   32: aload_1
    //   33: invokevirtual 64	java/io/FileInputStream:close	()V
    //   36: return
    //   37: astore_2
    //   38: goto +40 -> 78
    //   41: astore_3
    //   42: goto +15 -> 57
    //   45: astore_3
    //   46: aload_2
    //   47: astore_1
    //   48: aload_3
    //   49: astore_2
    //   50: goto +28 -> 78
    //   53: astore_3
    //   54: aload 4
    //   56: astore_1
    //   57: aload_1
    //   58: astore_2
    //   59: aload_3
    //   60: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   63: aload_1
    //   64: ifnull +13 -> 77
    //   67: aload_1
    //   68: invokevirtual 64	java/io/FileInputStream:close	()V
    //   71: return
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   77: return
    //   78: aload_1
    //   79: ifnull +15 -> 94
    //   82: aload_1
    //   83: invokevirtual 64	java/io/FileInputStream:close	()V
    //   86: goto +8 -> 94
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   94: aload_2
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	HippyDrawable
    //   0	96	1	paramFile	java.io.File
    //   4	25	2	arrayOfByte	byte[]
    //   37	10	2	localObject1	Object
    //   49	46	2	localObject2	Object
    //   41	1	3	localException1	Exception
    //   45	4	3	localObject3	Object
    //   53	7	3	localException2	Exception
    //   1	54	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   14	32	37	finally
    //   14	32	41	java/lang/Exception
    //   5	14	45	finally
    //   59	63	45	finally
    //   5	14	53	java/lang/Exception
    //   32	36	72	java/lang/Exception
    //   67	71	72	java/lang/Exception
    //   82	86	89	java/lang/Exception
  }
  
  /* Error */
  public void setData(java.io.File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_3
    //   8: new 48	java/io/FileInputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 50	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: astore_1
    //   17: iload_2
    //   18: ifeq +19 -> 37
    //   21: aload_0
    //   22: aload_1
    //   23: invokestatic 76	android/graphics/Movie:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Movie;
    //   26: putfield 33	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mGifMovie	Landroid/graphics/Movie;
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 23	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mBitmap	Landroid/graphics/Bitmap;
    //   34: goto +16 -> 50
    //   37: aload_0
    //   38: aload_1
    //   39: invokestatic 81	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   42: putfield 23	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mBitmap	Landroid/graphics/Bitmap;
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 33	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mGifMovie	Landroid/graphics/Movie;
    //   50: aload_1
    //   51: invokevirtual 64	java/io/FileInputStream:close	()V
    //   54: return
    //   55: astore_3
    //   56: goto +71 -> 127
    //   59: astore 4
    //   61: goto +23 -> 84
    //   64: astore 4
    //   66: goto +39 -> 105
    //   69: astore 4
    //   71: aload_3
    //   72: astore_1
    //   73: aload 4
    //   75: astore_3
    //   76: goto +51 -> 127
    //   79: astore 4
    //   81: aload 5
    //   83: astore_1
    //   84: aload_1
    //   85: astore_3
    //   86: aload 4
    //   88: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   91: aload_1
    //   92: ifnull +34 -> 126
    //   95: aload_1
    //   96: invokevirtual 64	java/io/FileInputStream:close	()V
    //   99: return
    //   100: astore 4
    //   102: aload 6
    //   104: astore_1
    //   105: aload_1
    //   106: astore_3
    //   107: aload 4
    //   109: invokevirtual 82	java/lang/OutOfMemoryError:printStackTrace	()V
    //   112: aload_1
    //   113: ifnull +13 -> 126
    //   116: aload_1
    //   117: invokevirtual 64	java/io/FileInputStream:close	()V
    //   120: return
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   126: return
    //   127: aload_1
    //   128: ifnull +15 -> 143
    //   131: aload_1
    //   132: invokevirtual 64	java/io/FileInputStream:close	()V
    //   135: goto +8 -> 143
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   143: aload_3
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	HippyDrawable
    //   0	145	1	paramFile	java.io.File
    //   0	145	2	paramBoolean	boolean
    //   7	1	3	localObject1	Object
    //   55	17	3	localObject2	Object
    //   75	69	3	localObject3	Object
    //   59	1	4	localException1	Exception
    //   64	1	4	localOutOfMemoryError1	OutOfMemoryError
    //   69	5	4	localObject4	Object
    //   79	8	4	localException2	Exception
    //   100	8	4	localOutOfMemoryError2	OutOfMemoryError
    //   1	81	5	localObject5	Object
    //   4	99	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   21	34	55	finally
    //   37	50	55	finally
    //   21	34	59	java/lang/Exception
    //   37	50	59	java/lang/Exception
    //   21	34	64	java/lang/OutOfMemoryError
    //   37	50	64	java/lang/OutOfMemoryError
    //   8	17	69	finally
    //   86	91	69	finally
    //   107	112	69	finally
    //   8	17	79	java/lang/Exception
    //   8	17	100	java/lang/OutOfMemoryError
    //   50	54	121	java/lang/Exception
    //   95	99	121	java/lang/Exception
    //   116	120	121	java/lang/Exception
    //   131	135	138	java/lang/Exception
  }
  
  /* Error */
  public void setData(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 37	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mSource	Ljava/lang/String;
    //   5: aload_0
    //   6: getfield 37	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mSource	Ljava/lang/String;
    //   9: ldc 85
    //   11: invokevirtual 91	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14: ifeq +49 -> 63
    //   17: aload_0
    //   18: getfield 37	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mSource	Ljava/lang/String;
    //   21: ldc 93
    //   23: invokevirtual 97	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   26: istore_2
    //   27: iload_2
    //   28: iflt +238 -> 266
    //   31: aload_0
    //   32: getfield 37	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mSource	Ljava/lang/String;
    //   35: iload_2
    //   36: bipush 8
    //   38: iadd
    //   39: invokevirtual 101	java/lang/String:substring	(I)Ljava/lang/String;
    //   42: iconst_0
    //   43: invokestatic 107	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +218 -> 266
    //   51: aload_0
    //   52: aload_1
    //   53: invokevirtual 61	com/tencent/mtt/hippy/adapter/image/HippyDrawable:setData	([B)V
    //   56: return
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   62: return
    //   63: aload_0
    //   64: getfield 37	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mSource	Ljava/lang/String;
    //   67: ldc 109
    //   69: invokevirtual 91	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   72: ifeq +24 -> 96
    //   75: aload_0
    //   76: new 111	java/io/File
    //   79: dup
    //   80: aload_0
    //   81: getfield 37	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mSource	Ljava/lang/String;
    //   84: bipush 7
    //   86: invokevirtual 101	java/lang/String:substring	(I)Ljava/lang/String;
    //   89: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: invokevirtual 115	com/tencent/mtt/hippy/adapter/image/HippyDrawable:setData	(Ljava/io/File;)V
    //   95: return
    //   96: aload_0
    //   97: getfield 37	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mSource	Ljava/lang/String;
    //   100: ldc 117
    //   102: invokevirtual 91	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   105: ifeq +161 -> 266
    //   108: aconst_null
    //   109: astore 5
    //   111: aconst_null
    //   112: astore 6
    //   114: aconst_null
    //   115: astore 4
    //   117: aload 5
    //   119: astore_1
    //   120: aload 6
    //   122: astore_3
    //   123: getstatic 123	android/os/Build$VERSION:SDK_INT	I
    //   126: bipush 28
    //   128: if_icmplt +20 -> 148
    //   131: aload 5
    //   133: astore_1
    //   134: aload 6
    //   136: astore_3
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 37	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mSource	Ljava/lang/String;
    //   142: invokevirtual 126	com/tencent/mtt/hippy/adapter/image/HippyDrawable:setDataForTarge28Assets	(Ljava/lang/String;)V
    //   145: goto +70 -> 215
    //   148: aload 5
    //   150: astore_1
    //   151: aload 6
    //   153: astore_3
    //   154: invokestatic 132	com/tencent/mtt/hippy/utils/ContextHolder:getAppContext	()Landroid/content/Context;
    //   157: invokevirtual 138	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   160: aload_0
    //   161: getfield 37	com/tencent/mtt/hippy/adapter/image/HippyDrawable:mSource	Ljava/lang/String;
    //   164: bipush 9
    //   166: invokevirtual 101	java/lang/String:substring	(I)Ljava/lang/String;
    //   169: invokevirtual 144	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   172: astore 4
    //   174: aload 4
    //   176: astore_1
    //   177: aload 4
    //   179: astore_3
    //   180: aload 4
    //   182: invokevirtual 147	java/io/InputStream:available	()I
    //   185: newarray byte
    //   187: astore 5
    //   189: aload 4
    //   191: astore_1
    //   192: aload 4
    //   194: astore_3
    //   195: aload 4
    //   197: aload 5
    //   199: invokevirtual 148	java/io/InputStream:read	([B)I
    //   202: pop
    //   203: aload 4
    //   205: astore_1
    //   206: aload 4
    //   208: astore_3
    //   209: aload_0
    //   210: aload 5
    //   212: invokevirtual 61	com/tencent/mtt/hippy/adapter/image/HippyDrawable:setData	([B)V
    //   215: aload 4
    //   217: ifnull +49 -> 266
    //   220: aload 4
    //   222: invokevirtual 149	java/io/InputStream:close	()V
    //   225: return
    //   226: astore_3
    //   227: goto +21 -> 248
    //   230: astore 4
    //   232: aload_3
    //   233: astore_1
    //   234: aload 4
    //   236: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   239: aload_3
    //   240: ifnull +26 -> 266
    //   243: aload_3
    //   244: invokevirtual 149	java/io/InputStream:close	()V
    //   247: return
    //   248: aload_1
    //   249: ifnull +15 -> 264
    //   252: aload_1
    //   253: invokevirtual 149	java/io/InputStream:close	()V
    //   256: goto +8 -> 264
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   264: aload_3
    //   265: athrow
    //   266: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	HippyDrawable
    //   0	267	1	paramString	String
    //   26	13	2	i	int
    //   122	87	3	localObject1	Object
    //   226	39	3	localObject2	Object
    //   115	106	4	localInputStream	java.io.InputStream
    //   230	5	4	localException	Exception
    //   109	102	5	arrayOfByte	byte[]
    //   112	40	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	27	57	java/lang/Exception
    //   31	47	57	java/lang/Exception
    //   51	56	57	java/lang/Exception
    //   220	225	57	java/lang/Exception
    //   243	247	57	java/lang/Exception
    //   123	131	226	finally
    //   137	145	226	finally
    //   154	174	226	finally
    //   180	189	226	finally
    //   195	203	226	finally
    //   209	215	226	finally
    //   234	239	226	finally
    //   123	131	230	java/lang/Exception
    //   137	145	230	java/lang/Exception
    //   154	174	230	java/lang/Exception
    //   180	189	230	java/lang/Exception
    //   195	203	230	java/lang/Exception
    //   209	215	230	java/lang/Exception
    //   252	256	259	java/lang/Exception
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    try
    {
      this.mGifMovie = Movie.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      if (this.mGifMovie == null)
      {
        this.mBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
        return;
      }
      this.mBitmap = null;
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public void setDataForTarge28Assets(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      try
      {
        this.mBitmap = ImageDecoder.decodeBitmap(ImageDecoder.createSource(ContextHolder.getAppContext().getAssets(), paramString.substring(9)));
        return;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setDrawable(Drawable paramDrawable)
  {
    this.mDrawable = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.image.HippyDrawable
 * JD-Core Version:    0.7.0.1
 */