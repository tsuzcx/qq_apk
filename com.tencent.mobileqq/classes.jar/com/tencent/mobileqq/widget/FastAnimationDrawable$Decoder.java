package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Message;
import babe;
import bbir;
import bbis;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class FastAnimationDrawable$Decoder
  implements Runnable
{
  private final bbir a;
  
  public FastAnimationDrawable$Decoder(FastAnimationDrawable paramFastAnimationDrawable, bbir parambbir)
  {
    this.a = parambbir;
  }
  
  @TargetApi(12)
  private BitmapDrawable a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(FastAnimationDrawable.a(this.this$0), 2, "decodeBitmap() called with: path = [" + paramString + "]");
    }
    for (;;)
    {
      try
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inSampleSize = 1;
        a((BitmapFactory.Options)localObject);
        boolean bool = FastAnimationDrawable.a(this.this$0);
        if (bool)
        {
          try
          {
            localBitmap1 = BitmapFactory.decodeResource(this.this$0.a.getResources(), Integer.valueOf(paramString).intValue(), (BitmapFactory.Options)localObject);
            if (localBitmap1 != null) {
              continue;
            }
          }
          catch (Throwable localThrowable)
          {
            try
            {
              Bitmap localBitmap1;
              QLog.e(FastAnimationDrawable.a(this.this$0), 1, "decodeBitmap: null. oom for " + paramString);
              localObject = localBitmap1;
              return new BitmapDrawable((Bitmap)localObject);
            }
            catch (OutOfMemoryError paramString) {}
            localThrowable = localThrowable;
            QLog.e(FastAnimationDrawable.a(this.this$0), 1, "decodeBitmap: ", localThrowable);
            ((BitmapFactory.Options)localObject).inBitmap = null;
            localBitmap2 = BitmapFactory.decodeResource(this.this$0.a.getResources(), Integer.valueOf(paramString).intValue(), (BitmapFactory.Options)localObject);
            continue;
          }
        }
        else
        {
          localBitmap2 = a(paramString, (BitmapFactory.Options)localObject);
          continue;
        }
        localObject = localBitmap2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(FastAnimationDrawable.a(this.this$0), 2, "path:" + paramString + " bitmapSize:" + localBitmap2.getByteCount() + " B");
        localObject = localBitmap2;
        continue;
      }
      catch (OutOfMemoryError paramString)
      {
        Object localObject;
        Bitmap localBitmap2 = null;
        continue;
      }
      QLog.e(FastAnimationDrawable.a(this.this$0), 1, "decodeBitmap: ", paramString);
      localObject = localBitmap2;
    }
  }
  
  @TargetApi(11)
  private void a(BitmapFactory.Options paramOptions)
  {
    paramOptions.inMutable = true;
    Bitmap localBitmap = a(paramOptions);
    if (localBitmap != null) {
      paramOptions.inBitmap = localBitmap;
    }
  }
  
  @TargetApi(19)
  private boolean a(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    if (Build.VERSION.SDK_INT < 19) {
      if ((paramBitmap.getWidth() != paramOptions.outWidth) || (paramBitmap.getHeight() != paramOptions.outHeight) || (paramOptions.inSampleSize != 1)) {}
    }
    while (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * FastAnimationDrawable.a(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount())
    {
      return true;
      return false;
    }
    return false;
  }
  
  protected Bitmap a(BitmapFactory.Options paramOptions)
  {
    if ((FastAnimationDrawable.a(this.this$0) != null) && (!FastAnimationDrawable.a(this.this$0).isEmpty())) {
      for (;;)
      {
        synchronized (FastAnimationDrawable.a(this.this$0))
        {
          Iterator localIterator = FastAnimationDrawable.a(this.this$0).iterator();
          if (localIterator.hasNext())
          {
            Bitmap localBitmap = (Bitmap)((SoftReference)localIterator.next()).get();
            if ((localBitmap != null) && (localBitmap.isMutable()))
            {
              if (!a(localBitmap, paramOptions)) {
                continue;
              }
              if (QLog.isColorLevel()) {
                QLog.d(FastAnimationDrawable.a(this.this$0), 2, "getBitmapFromReusableSet() found options = [" + paramOptions + "], item=[" + localBitmap + "]");
              }
              localIterator.remove();
              paramOptions = localBitmap;
              return paramOptions;
            }
            localIterator.remove();
          }
        }
        paramOptions = null;
      }
    }
    return null;
  }
  
  /* Error */
  public Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_2
    //   4: ifnull +54 -> 58
    //   7: aload_2
    //   8: getfield 218	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   11: ifeq +47 -> 58
    //   14: new 220	java/io/BufferedInputStream
    //   17: dup
    //   18: new 222	java/io/FileInputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 225	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   26: sipush 2048
    //   29: invokespecial 228	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   32: astore_1
    //   33: aload_1
    //   34: astore_3
    //   35: aload_1
    //   36: aconst_null
    //   37: aload_2
    //   38: invokestatic 232	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_3
    //   44: aload_3
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_1
    //   51: invokevirtual 237	java/io/InputStream:close	()V
    //   54: aload_3
    //   55: astore_2
    //   56: aload_2
    //   57: areturn
    //   58: new 220	java/io/BufferedInputStream
    //   61: dup
    //   62: new 222	java/io/FileInputStream
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 225	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   70: invokespecial 240	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   73: astore_1
    //   74: goto -41 -> 33
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_1
    //   80: aload_1
    //   81: astore_3
    //   82: aload_0
    //   83: getfield 14	com/tencent/mobileqq/widget/FastAnimationDrawable$Decoder:this$0	Lcom/tencent/mobileqq/widget/FastAnimationDrawable;
    //   86: invokestatic 39	com/tencent/mobileqq/widget/FastAnimationDrawable:a	(Lcom/tencent/mobileqq/widget/FastAnimationDrawable;)Ljava/lang/String;
    //   89: iconst_1
    //   90: ldc 242
    //   92: aload_2
    //   93: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   96: aload 4
    //   98: astore_2
    //   99: aload_1
    //   100: ifnull -44 -> 56
    //   103: aload_1
    //   104: invokevirtual 237	java/io/InputStream:close	()V
    //   107: aconst_null
    //   108: areturn
    //   109: astore_1
    //   110: aconst_null
    //   111: areturn
    //   112: astore_2
    //   113: aconst_null
    //   114: astore_1
    //   115: aload_1
    //   116: astore_3
    //   117: aload_0
    //   118: getfield 14	com/tencent/mobileqq/widget/FastAnimationDrawable$Decoder:this$0	Lcom/tencent/mobileqq/widget/FastAnimationDrawable;
    //   121: invokestatic 39	com/tencent/mobileqq/widget/FastAnimationDrawable:a	(Lcom/tencent/mobileqq/widget/FastAnimationDrawable;)Ljava/lang/String;
    //   124: iconst_1
    //   125: ldc 244
    //   127: aload_2
    //   128: invokestatic 111	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   131: aload 4
    //   133: astore_2
    //   134: aload_1
    //   135: ifnull -79 -> 56
    //   138: aload_1
    //   139: invokevirtual 237	java/io/InputStream:close	()V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_1
    //   145: aconst_null
    //   146: areturn
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_3
    //   150: aload_3
    //   151: ifnull +7 -> 158
    //   154: aload_3
    //   155: invokevirtual 237	java/io/InputStream:close	()V
    //   158: aload_1
    //   159: athrow
    //   160: astore_1
    //   161: aload_3
    //   162: areturn
    //   163: astore_2
    //   164: goto -6 -> 158
    //   167: astore_1
    //   168: goto -18 -> 150
    //   171: astore_2
    //   172: goto -57 -> 115
    //   175: astore_2
    //   176: goto -96 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	Decoder
    //   0	179	1	paramString	String
    //   0	179	2	paramOptions	BitmapFactory.Options
    //   34	128	3	localObject1	Object
    //   1	131	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	33	77	java/lang/Exception
    //   58	74	77	java/lang/Exception
    //   103	107	109	java/io/IOException
    //   7	33	112	java/lang/OutOfMemoryError
    //   58	74	112	java/lang/OutOfMemoryError
    //   138	142	144	java/io/IOException
    //   7	33	147	finally
    //   58	74	147	finally
    //   50	54	160	java/io/IOException
    //   154	158	163	java/io/IOException
    //   35	42	167	finally
    //   82	96	167	finally
    //   117	131	167	finally
    //   35	42	171	java/lang/OutOfMemoryError
    //   35	42	175	java/lang/Exception
  }
  
  public void run()
  {
    if (!this.this$0.isRunning()) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(FastAnimationDrawable.a(this.this$0), 2, "Decoder index:" + this.a.jdField_a_of_type_Int);
      }
      Object localObject = "android.resource://main_tab_animation_" + (String)FastAnimationDrawable.a(this.this$0).get(this.a.jdField_a_of_type_Int);
      Bitmap localBitmap = babe.a((String)localObject);
      if (localBitmap != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(FastAnimationDrawable.a(this.this$0), 2, "Decoder hit cache :" + this.a.jdField_a_of_type_Int);
        }
        this.a.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(localBitmap);
      }
      while (this.this$0.isRunning())
      {
        localObject = FastAnimationDrawable.a(this.this$0).obtainMessage(0, this.a);
        FastAnimationDrawable.a(this.this$0).sendMessageAtTime((Message)localObject, this.a.jdField_a_of_type_Long);
        return;
        long l1 = System.currentTimeMillis();
        this.a.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = a((String)FastAnimationDrawable.a(this.this$0).get(this.a.jdField_a_of_type_Int));
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d(FastAnimationDrawable.a(this.this$0), 2, "Decoder decodeBitmap index:" + this.a.jdField_a_of_type_Int + " cost:" + (l2 - l1) + " delay:" + FastAnimationDrawable.a(this.this$0));
        }
        babe.a((String)localObject, this.a.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FastAnimationDrawable.Decoder
 * JD-Core Version:    0.7.0.1
 */