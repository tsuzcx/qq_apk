package com.tencent.mobileqq.editor.composite.step;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeInputSurface;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.HWVideoEncoder;

public class PicToVideoConverter
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private EncodeInputSurface jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface;
  public HWVideoEncoder a;
  private String jdField_a_of_type_JavaLangString;
  private float[] jdField_a_of_type_ArrayOfFloat;
  
  private static long a(int paramInt)
  {
    return paramInt * 1000000000L / 25L;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap.getWidth() % 2 == 1)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth() + 1, paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawARGB(0, 0, 0, 0);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      return localBitmap;
    }
    return paramBitmap;
  }
  
  private void a()
  {
    SLog.b("Q.qqstory.publish.upload.PicToVideoConverter", "preparing.");
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bitmap's width = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
    ((StringBuilder)localObject).append(", height = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    SLog.b("Q.qqstory.publish.upload.PicToVideoConverter", ((StringBuilder)localObject).toString());
    localObject = new EncodeConfig(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), 532480, 1, false, 0);
    ((EncodeConfig)localObject).d = 25;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder = new HWVideoEncoder();
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder.a((EncodeConfig)localObject);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface = new EncodeInputSurface();
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface.a((EncodeConfig)localObject, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder.a());
    this.jdField_a_of_type_Int = GlUtil.createTexture(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  private void b()
  {
    SLog.b("Q.qqstory.publish.upload.PicToVideoConverter", "releasing.");
    EncodeInputSurface localEncodeInputSurface = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface;
    if (localEncodeInputSurface != null)
    {
      localEncodeInputSurface.a();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface = null;
    }
  }
  
  /* Error */
  public int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +281 -> 285
    //   7: aload_2
    //   8: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +274 -> 285
    //   14: ldc 56
    //   16: ldc 146
    //   18: iconst_2
    //   19: anewarray 4	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: aload_1
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: aload_2
    //   29: aastore
    //   30: invokestatic 149	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aload_1
    //   34: invokestatic 155	com/tencent/biz/qqstory/utils/FileUtils:c	(Ljava/lang/String;)Z
    //   37: ifne +13 -> 50
    //   40: ldc 56
    //   42: ldc 157
    //   44: invokestatic 160	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: ldc 161
    //   49: ireturn
    //   50: aload_0
    //   51: aload_2
    //   52: putfield 90	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   55: aload_0
    //   56: aload_1
    //   57: invokestatic 167	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   60: putfield 66	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   63: goto +87 -> 150
    //   66: astore_2
    //   67: invokestatic 172	java/lang/System:gc	()V
    //   70: ldc2_w 173
    //   73: invokestatic 180	java/lang/Thread:sleep	(J)V
    //   76: goto +10 -> 86
    //   79: astore 6
    //   81: aload 6
    //   83: invokevirtual 183	java/lang/InterruptedException:printStackTrace	()V
    //   86: aload_0
    //   87: aload_1
    //   88: sipush 540
    //   91: sipush 960
    //   94: invokestatic 188	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   97: putfield 66	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   100: aload_0
    //   101: getfield 66	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   104: ifnonnull +17 -> 121
    //   107: aload_0
    //   108: aload_1
    //   109: sipush 360
    //   112: sipush 640
    //   115: invokestatic 188	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   118: putfield 66	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   121: aload_0
    //   122: getfield 66	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   125: ifnonnull +25 -> 150
    //   128: ldc 56
    //   130: ldc 190
    //   132: iconst_2
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload_1
    //   139: aastore
    //   140: dup
    //   141: iconst_1
    //   142: aload_2
    //   143: aastore
    //   144: invokestatic 192	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: ldc 193
    //   149: ireturn
    //   150: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   153: lstore 4
    //   155: aload_0
    //   156: invokespecial 198	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:a	()V
    //   159: iconst_0
    //   160: istore_3
    //   161: iload_3
    //   162: bipush 75
    //   164: if_icmpge +40 -> 204
    //   167: aload_0
    //   168: getfield 102	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder	Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/HWVideoEncoder;
    //   171: invokevirtual 199	com/tencent/mobileqq/videocodec/mediacodec/encoder/HWVideoEncoder:a	()V
    //   174: aload_0
    //   175: getfield 110	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface	Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeInputSurface;
    //   178: sipush 3553
    //   181: aload_0
    //   182: getfield 124	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:jdField_a_of_type_Int	I
    //   185: aload_0
    //   186: getfield 127	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:jdField_a_of_type_ArrayOfFloat	[F
    //   189: aconst_null
    //   190: iload_3
    //   191: invokestatic 201	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:a	(I)J
    //   194: invokevirtual 204	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeInputSurface:a	(II[F[FJ)V
    //   197: iload_3
    //   198: iconst_1
    //   199: iadd
    //   200: istore_3
    //   201: goto -40 -> 161
    //   204: aload_0
    //   205: getfield 102	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder	Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/HWVideoEncoder;
    //   208: invokevirtual 206	com/tencent/mobileqq/videocodec/mediacodec/encoder/HWVideoEncoder:b	()V
    //   211: aload_0
    //   212: invokespecial 207	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:b	()V
    //   215: iconst_0
    //   216: istore_3
    //   217: goto +30 -> 247
    //   220: astore_1
    //   221: goto +58 -> 279
    //   224: astore_1
    //   225: ldc 56
    //   227: ldc 209
    //   229: aload_1
    //   230: invokestatic 212	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   233: ldc 213
    //   235: istore_3
    //   236: aload_0
    //   237: getfield 102	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder	Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/HWVideoEncoder;
    //   240: invokevirtual 215	com/tencent/mobileqq/videocodec/mediacodec/encoder/HWVideoEncoder:c	()V
    //   243: aload_0
    //   244: invokespecial 207	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:b	()V
    //   247: ldc 56
    //   249: ldc 217
    //   251: iconst_2
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   260: lload 4
    //   262: lsub
    //   263: invokestatic 223	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   266: aastore
    //   267: dup
    //   268: iconst_1
    //   269: iload_3
    //   270: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: aastore
    //   274: invokestatic 149	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: iload_3
    //   278: ireturn
    //   279: aload_0
    //   280: invokespecial 207	com/tencent/mobileqq/editor/composite/step/PicToVideoConverter:b	()V
    //   283: aload_1
    //   284: athrow
    //   285: new 230	java/lang/IllegalStateException
    //   288: dup
    //   289: ldc 232
    //   291: invokespecial 235	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   294: astore_1
    //   295: goto +5 -> 300
    //   298: aload_1
    //   299: athrow
    //   300: goto -2 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	PicToVideoConverter
    //   0	303	1	paramString1	String
    //   0	303	2	paramString2	String
    //   160	118	3	i	int
    //   153	108	4	l	long
    //   79	3	6	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   55	63	66	java/lang/OutOfMemoryError
    //   70	76	79	java/lang/InterruptedException
    //   155	159	220	finally
    //   167	197	220	finally
    //   204	211	220	finally
    //   225	233	220	finally
    //   236	243	220	finally
    //   155	159	224	java/lang/Exception
    //   167	197	224	java/lang/Exception
    //   204	211	224	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.PicToVideoConverter
 * JD-Core Version:    0.7.0.1
 */