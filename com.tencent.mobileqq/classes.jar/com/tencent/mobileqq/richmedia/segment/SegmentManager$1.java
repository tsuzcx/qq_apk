package com.tencent.mobileqq.richmedia.segment;

import android.media.MediaFormat;
import axxn;

public class SegmentManager$1
  implements Runnable
{
  public SegmentManager$1(axxn paramaxxn, String paramString, MediaFormat paramMediaFormat) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Laxxn;
    //   4: invokestatic 33	axxn:a	(Laxxn;)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +22 -> 31
    //   12: iconst_0
    //   13: ifeq +11 -> 24
    //   16: new 35	java/lang/NullPointerException
    //   19: dup
    //   20: invokespecial 36	java/lang/NullPointerException:<init>	()V
    //   23: athrow
    //   24: return
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 39	java/io/IOException:printStackTrace	()V
    //   30: return
    //   31: aload_0
    //   32: getfield 15	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Laxxn;
    //   35: invokevirtual 42	axxn:a	()Ljava/lang/String;
    //   38: astore_3
    //   39: new 44	java/io/File
    //   42: dup
    //   43: aload_3
    //   44: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 15	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Laxxn;
    //   52: getfield 50	axxn:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView	Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView;
    //   55: invokevirtual 56	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:getContext	()Landroid/content/Context;
    //   58: aload_0
    //   59: getfield 17	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   62: invokestatic 61	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   65: astore 4
    //   67: aload_3
    //   68: invokestatic 67	bdhb:d	(Ljava/lang/String;)Z
    //   71: pop
    //   72: aload_3
    //   73: invokestatic 70	bdhb:a	(Ljava/lang/String;)Ljava/io/File;
    //   76: pop
    //   77: aload_1
    //   78: invokevirtual 74	java/io/File:createNewFile	()Z
    //   81: pop
    //   82: new 76	java/io/BufferedOutputStream
    //   85: dup
    //   86: new 78	java/io/FileOutputStream
    //   89: dup
    //   90: aload_3
    //   91: invokespecial 79	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   94: invokespecial 82	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   97: astore_2
    //   98: aload_2
    //   99: astore_1
    //   100: aload 4
    //   102: getstatic 88	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   105: bipush 80
    //   107: aload_2
    //   108: invokevirtual 94	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   111: pop
    //   112: aload_2
    //   113: astore_1
    //   114: aload 4
    //   116: invokevirtual 97	android/graphics/Bitmap:recycle	()V
    //   119: aload_2
    //   120: astore_1
    //   121: aload_2
    //   122: invokevirtual 100	java/io/BufferedOutputStream:flush	()V
    //   125: aload_2
    //   126: astore_1
    //   127: aload_0
    //   128: getfield 15	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Laxxn;
    //   131: aload_3
    //   132: invokestatic 103	axxn:a	(Laxxn;Ljava/lang/String;)Ljava/lang/String;
    //   135: pop
    //   136: aload_2
    //   137: astore_1
    //   138: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +36 -> 177
    //   144: aload_2
    //   145: astore_1
    //   146: ldc 110
    //   148: iconst_2
    //   149: new 112	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   156: ldc 115
    //   158: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: getfield 15	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Laxxn;
    //   165: invokestatic 33	axxn:a	(Laxxn;)Ljava/lang/String;
    //   168: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload_2
    //   178: astore_1
    //   179: aload_0
    //   180: getfield 15	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Laxxn;
    //   183: invokestatic 128	axxn:a	(Laxxn;)Landroid/os/Bundle;
    //   186: astore_3
    //   187: aload_2
    //   188: astore_1
    //   189: aload_0
    //   190: getfield 15	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Laxxn;
    //   193: getfield 131	axxn:jdField_a_of_type_Axnn	Laxnn;
    //   196: sipush 202
    //   199: iconst_m1
    //   200: aload_3
    //   201: invokevirtual 136	axnn:a	(IILandroid/os/Bundle;)Z
    //   204: pop
    //   205: aload_2
    //   206: astore_1
    //   207: aload_0
    //   208: getfield 15	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Laxxn;
    //   211: aload_0
    //   212: getfield 19	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   215: invokestatic 139	axxn:a	(Laxxn;Landroid/media/MediaFormat;)V
    //   218: aload_2
    //   219: ifnull -195 -> 24
    //   222: aload_2
    //   223: invokevirtual 142	java/io/BufferedOutputStream:close	()V
    //   226: return
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 39	java/io/IOException:printStackTrace	()V
    //   232: return
    //   233: astore_3
    //   234: aconst_null
    //   235: astore_2
    //   236: aload_2
    //   237: astore_1
    //   238: aload_3
    //   239: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   242: aload_2
    //   243: astore_1
    //   244: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq +13 -> 260
    //   250: aload_2
    //   251: astore_1
    //   252: ldc 110
    //   254: iconst_2
    //   255: ldc 145
    //   257: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload_2
    //   261: astore_1
    //   262: aload_0
    //   263: getfield 15	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Laxxn;
    //   266: invokevirtual 148	axxn:b	()V
    //   269: aload_2
    //   270: ifnull -246 -> 24
    //   273: aload_2
    //   274: invokevirtual 142	java/io/BufferedOutputStream:close	()V
    //   277: return
    //   278: astore_1
    //   279: aload_1
    //   280: invokevirtual 39	java/io/IOException:printStackTrace	()V
    //   283: return
    //   284: astore_2
    //   285: aconst_null
    //   286: astore_1
    //   287: aload_1
    //   288: ifnull +7 -> 295
    //   291: aload_1
    //   292: invokevirtual 142	java/io/BufferedOutputStream:close	()V
    //   295: aload_2
    //   296: athrow
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 39	java/io/IOException:printStackTrace	()V
    //   302: goto -7 -> 295
    //   305: astore_2
    //   306: goto -19 -> 287
    //   309: astore_3
    //   310: goto -74 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	1
    //   7	2	1	str	String
    //   25	2	1	localIOException1	java.io.IOException
    //   47	160	1	localObject1	Object
    //   227	2	1	localIOException2	java.io.IOException
    //   237	25	1	localObject2	Object
    //   278	2	1	localIOException3	java.io.IOException
    //   286	6	1	localObject3	Object
    //   297	2	1	localIOException4	java.io.IOException
    //   97	177	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   284	12	2	localObject4	Object
    //   305	1	2	localObject5	Object
    //   38	163	3	localObject6	Object
    //   233	6	3	localException1	java.lang.Exception
    //   309	1	3	localException2	java.lang.Exception
    //   65	50	4	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   16	24	25	java/io/IOException
    //   222	226	227	java/io/IOException
    //   0	8	233	java/lang/Exception
    //   31	98	233	java/lang/Exception
    //   273	277	278	java/io/IOException
    //   0	8	284	finally
    //   31	98	284	finally
    //   291	295	297	java/io/IOException
    //   100	112	305	finally
    //   114	119	305	finally
    //   121	125	305	finally
    //   127	136	305	finally
    //   138	144	305	finally
    //   146	177	305	finally
    //   179	187	305	finally
    //   189	205	305	finally
    //   207	218	305	finally
    //   238	242	305	finally
    //   244	250	305	finally
    //   252	260	305	finally
    //   262	269	305	finally
    //   100	112	309	java/lang/Exception
    //   114	119	309	java/lang/Exception
    //   121	125	309	java/lang/Exception
    //   127	136	309	java/lang/Exception
    //   138	144	309	java/lang/Exception
    //   146	177	309	java/lang/Exception
    //   179	187	309	java/lang/Exception
    //   189	205	309	java/lang/Exception
    //   207	218	309	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.segment.SegmentManager.1
 * JD-Core Version:    0.7.0.1
 */