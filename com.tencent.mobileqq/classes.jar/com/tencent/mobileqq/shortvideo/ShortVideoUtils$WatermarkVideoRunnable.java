package com.tencent.mobileqq.shortvideo;

import aiev;
import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class ShortVideoUtils$WatermarkVideoRunnable
  implements Runnable
{
  private static FFmpeg jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  public long a;
  private FFmpegExecuteResponseCallback jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback;
  public String a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  
  public ShortVideoUtils$WatermarkVideoRunnable(Context paramContext, int paramInt, String paramString1, String paramString2, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new aiev(this, paramString2);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(paramInt1, this.jdField_a_of_type_Int, paramInt2);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  @android.annotation.TargetApi(10)
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_1
    //   4: istore_3
    //   5: invokestatic 96	com/tencent/util/VersionUtils:d	()Z
    //   8: ifeq +400 -> 408
    //   11: new 98	android/media/MediaMetadataRetriever
    //   14: dup
    //   15: invokespecial 99	android/media/MediaMetadataRetriever:<init>	()V
    //   18: astore 7
    //   20: aload 7
    //   22: astore 6
    //   24: aload 7
    //   26: aload_0
    //   27: getfield 38	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   30: invokevirtual 103	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   33: aload 7
    //   35: astore 6
    //   37: aload 7
    //   39: bipush 18
    //   41: invokevirtual 107	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   44: astore 8
    //   46: aload 7
    //   48: astore 6
    //   50: aload 7
    //   52: bipush 19
    //   54: invokevirtual 107	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   57: astore 9
    //   59: aload 7
    //   61: astore 6
    //   63: aload 8
    //   65: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifne +47 -> 115
    //   71: aload 7
    //   73: astore 6
    //   75: aload 9
    //   77: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +35 -> 115
    //   83: aload 7
    //   85: astore 6
    //   87: aload_0
    //   88: aload 8
    //   90: invokestatic 119	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   93: invokevirtual 123	java/lang/Integer:intValue	()I
    //   96: putfield 125	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_b_of_type_Int	I
    //   99: aload 7
    //   101: astore 6
    //   103: aload_0
    //   104: aload 9
    //   106: invokestatic 119	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   109: invokevirtual 123	java/lang/Integer:intValue	()I
    //   112: putfield 127	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_c_of_type_Int	I
    //   115: aload 7
    //   117: ifnull +8 -> 125
    //   120: aload 7
    //   122: invokevirtual 130	android/media/MediaMetadataRetriever:release	()V
    //   125: getstatic 132	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg	Lcom/tencent/biz/qqstory/utils/ffmpeg/FFmpeg;
    //   128: ifnonnull +12 -> 140
    //   131: invokestatic 138	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   134: invokestatic 143	com/tencent/biz/qqstory/utils/ffmpeg/FFmpeg:a	(Landroid/content/Context;)Lcom/tencent/biz/qqstory/utils/ffmpeg/FFmpeg;
    //   137: putstatic 132	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg	Lcom/tencent/biz/qqstory/utils/ffmpeg/FFmpeg;
    //   140: aload_0
    //   141: invokestatic 148	com/tencent/mobileqq/shortvideo/ShortVideoUtils:d	()Ljava/lang/String;
    //   144: putfield 150	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   147: new 152	java/io/File
    //   150: dup
    //   151: aload_0
    //   152: getfield 150	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   155: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: astore 8
    //   160: aload 8
    //   162: invokevirtual 158	java/io/File:getParentFile	()Ljava/io/File;
    //   165: invokevirtual 161	java/io/File:exists	()Z
    //   168: ifne +248 -> 416
    //   171: aload 8
    //   173: invokevirtual 158	java/io/File:getParentFile	()Ljava/io/File;
    //   176: invokevirtual 164	java/io/File:mkdirs	()Z
    //   179: ifne +237 -> 416
    //   182: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +25 -> 210
    //   188: ldc 171
    //   190: iconst_2
    //   191: iconst_2
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: ldc 173
    //   199: aastore
    //   200: dup
    //   201: iconst_1
    //   202: aload_0
    //   203: getfield 150	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   206: aastore
    //   207: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   210: aload_0
    //   211: sipush 10001
    //   214: invokespecial 77	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:a	(I)V
    //   217: return
    //   218: astore 6
    //   220: aconst_null
    //   221: astore 7
    //   223: aload 7
    //   225: astore 6
    //   227: aload_0
    //   228: getfield 38	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   231: ifnonnull +126 -> 357
    //   234: aconst_null
    //   235: astore 8
    //   237: aload 7
    //   239: astore 6
    //   241: aload_0
    //   242: getfield 38	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   245: ifnonnull +132 -> 377
    //   248: iconst_1
    //   249: istore_2
    //   250: aload 8
    //   252: ifnull +130 -> 382
    //   255: aload 7
    //   257: astore 6
    //   259: aload 8
    //   261: invokevirtual 161	java/io/File:exists	()Z
    //   264: ifeq +118 -> 382
    //   267: aload 8
    //   269: ifnull +118 -> 387
    //   272: aload 7
    //   274: astore 6
    //   276: aload 8
    //   278: invokevirtual 179	java/io/File:length	()J
    //   281: lstore 4
    //   283: aload 7
    //   285: astore 6
    //   287: ldc 171
    //   289: iconst_1
    //   290: bipush 6
    //   292: anewarray 4	java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: ldc 181
    //   299: aastore
    //   300: dup
    //   301: iconst_1
    //   302: iload_2
    //   303: invokestatic 186	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   306: aastore
    //   307: dup
    //   308: iconst_2
    //   309: ldc 188
    //   311: aastore
    //   312: dup
    //   313: iconst_3
    //   314: iload_3
    //   315: invokestatic 186	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   318: aastore
    //   319: dup
    //   320: iconst_4
    //   321: ldc 190
    //   323: aastore
    //   324: dup
    //   325: iconst_5
    //   326: lload 4
    //   328: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   331: aastore
    //   332: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   335: aload 7
    //   337: astore 6
    //   339: aload_0
    //   340: sipush 10001
    //   343: invokespecial 77	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:a	(I)V
    //   346: aload 7
    //   348: ifnull -131 -> 217
    //   351: aload 7
    //   353: invokevirtual 130	android/media/MediaMetadataRetriever:release	()V
    //   356: return
    //   357: aload 7
    //   359: astore 6
    //   361: new 152	java/io/File
    //   364: dup
    //   365: aload_0
    //   366: getfield 38	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   369: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   372: astore 8
    //   374: goto -137 -> 237
    //   377: iconst_0
    //   378: istore_2
    //   379: goto -129 -> 250
    //   382: iconst_0
    //   383: istore_3
    //   384: goto -117 -> 267
    //   387: lconst_0
    //   388: lstore 4
    //   390: goto -107 -> 283
    //   393: astore 7
    //   395: aload 6
    //   397: ifnull +8 -> 405
    //   400: aload 6
    //   402: invokevirtual 130	android/media/MediaMetadataRetriever:release	()V
    //   405: aload 7
    //   407: athrow
    //   408: aload_0
    //   409: sipush 10001
    //   412: invokespecial 77	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:a	(I)V
    //   415: return
    //   416: aload_0
    //   417: getfield 34	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   420: invokevirtual 198	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   423: ifnonnull +25 -> 448
    //   426: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq +11 -> 440
    //   432: ldc 171
    //   434: iconst_2
    //   435: ldc 200
    //   437: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: aload_0
    //   441: sipush 10001
    //   444: invokespecial 77	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:a	(I)V
    //   447: return
    //   448: aload_0
    //   449: getfield 34	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   452: invokevirtual 198	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   455: checkcast 205	android/content/Context
    //   458: invokevirtual 209	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   461: ldc 210
    //   463: invokestatic 216	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   466: astore 6
    //   468: aload_0
    //   469: getfield 125	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_b_of_type_Int	I
    //   472: sipush 576
    //   475: if_icmpeq +145 -> 620
    //   478: aload_0
    //   479: getfield 125	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_b_of_type_Int	I
    //   482: i2f
    //   483: ldc 217
    //   485: fdiv
    //   486: fstore_1
    //   487: aload 6
    //   489: aload 6
    //   491: invokevirtual 222	android/graphics/Bitmap:getWidth	()I
    //   494: i2f
    //   495: fload_1
    //   496: fmul
    //   497: f2i
    //   498: fload_1
    //   499: aload 6
    //   501: invokevirtual 225	android/graphics/Bitmap:getHeight	()I
    //   504: i2f
    //   505: fmul
    //   506: f2i
    //   507: iconst_1
    //   508: invokestatic 229	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   511: astore 7
    //   513: aload 6
    //   515: invokevirtual 232	android/graphics/Bitmap:recycle	()V
    //   518: aload 7
    //   520: astore 6
    //   522: aload_0
    //   523: getfield 125	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_b_of_type_Int	I
    //   526: aload_0
    //   527: getfield 127	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_c_of_type_Int	I
    //   530: getstatic 238	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   533: invokestatic 242	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   536: astore 7
    //   538: new 244	android/graphics/Canvas
    //   541: dup
    //   542: aload 7
    //   544: invokespecial 247	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   547: aload 6
    //   549: ldc 248
    //   551: aload_0
    //   552: getfield 127	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_c_of_type_Int	I
    //   555: bipush 20
    //   557: isub
    //   558: aload 6
    //   560: invokevirtual 225	android/graphics/Bitmap:getHeight	()I
    //   563: isub
    //   564: i2f
    //   565: aconst_null
    //   566: invokevirtual 252	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   569: aload 7
    //   571: getstatic 258	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   574: bipush 100
    //   576: aload 8
    //   578: invokevirtual 261	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   581: invokestatic 266	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   584: ifne +95 -> 679
    //   587: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   590: ifeq +12 -> 602
    //   593: ldc 171
    //   595: iconst_2
    //   596: ldc_w 268
    //   599: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: aload 7
    //   604: invokestatic 270	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;)V
    //   607: aload 6
    //   609: invokestatic 270	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;)V
    //   612: aload_0
    //   613: sipush 10001
    //   616: invokespecial 77	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:a	(I)V
    //   619: return
    //   620: goto -98 -> 522
    //   623: astore 6
    //   625: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   628: ifeq +15 -> 643
    //   631: ldc 171
    //   633: iconst_2
    //   634: aload 6
    //   636: iconst_0
    //   637: anewarray 4	java/lang/Object
    //   640: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   643: aload_0
    //   644: sipush 10001
    //   647: invokespecial 77	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:a	(I)V
    //   650: return
    //   651: astore 6
    //   653: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   656: ifeq +15 -> 671
    //   659: ldc 171
    //   661: iconst_2
    //   662: aload 6
    //   664: iconst_0
    //   665: anewarray 4	java/lang/Object
    //   668: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   671: aload_0
    //   672: sipush 10001
    //   675: invokespecial 77	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:a	(I)V
    //   678: return
    //   679: aload 7
    //   681: invokestatic 270	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;)V
    //   684: aload 6
    //   686: invokestatic 270	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;)V
    //   689: getstatic 132	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg	Lcom/tencent/biz/qqstory/utils/ffmpeg/FFmpeg;
    //   692: invokevirtual 276	com/tencent/biz/qqstory/utils/ffmpeg/FFmpeg:a	()Z
    //   695: ifeq +35 -> 730
    //   698: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   701: ifeq +12 -> 713
    //   704: ldc 171
    //   706: iconst_2
    //   707: ldc_w 278
    //   710: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   713: getstatic 25	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   716: astore 6
    //   718: aload 6
    //   720: monitorenter
    //   721: getstatic 25	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   724: invokevirtual 281	java/lang/Object:wait	()V
    //   727: aload 6
    //   729: monitorexit
    //   730: getstatic 132	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg	Lcom/tencent/biz/qqstory/utils/ffmpeg/FFmpeg;
    //   733: aload_0
    //   734: getfield 40	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   737: invokevirtual 283	com/tencent/biz/qqstory/utils/ffmpeg/FFmpeg:a	(Ljava/lang/String;)V
    //   740: getstatic 132	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg	Lcom/tencent/biz/qqstory/utils/ffmpeg/FFmpeg;
    //   743: aload_0
    //   744: getfield 150	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   747: aload_0
    //   748: getfield 38	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   751: aload_0
    //   752: getfield 40	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   755: aload_0
    //   756: getfield 125	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_b_of_type_Int	I
    //   759: aload_0
    //   760: getfield 127	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_c_of_type_Int	I
    //   763: aload_0
    //   764: getfield 49	com/tencent/mobileqq/shortvideo/ShortVideoUtils$WatermarkVideoRunnable:jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback	Lcom/tencent/biz/qqstory/utils/ffmpeg/FFmpegExecuteResponseCallback;
    //   767: invokevirtual 286	com/tencent/biz/qqstory/utils/ffmpeg/FFmpeg:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/tencent/biz/qqstory/utils/ffmpeg/FFmpegExecuteResponseCallback;)V
    //   770: return
    //   771: astore 6
    //   773: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   776: ifeq -559 -> 217
    //   779: ldc 171
    //   781: iconst_2
    //   782: new 288	java/lang/StringBuilder
    //   785: dup
    //   786: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   789: ldc_w 291
    //   792: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: aload 6
    //   797: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   800: invokevirtual 301	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   806: return
    //   807: astore 7
    //   809: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   812: ifeq -85 -> 727
    //   815: ldc 171
    //   817: iconst_2
    //   818: aload 7
    //   820: iconst_0
    //   821: anewarray 4	java/lang/Object
    //   824: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   827: goto -100 -> 727
    //   830: astore 7
    //   832: aload 6
    //   834: monitorexit
    //   835: aload 7
    //   837: athrow
    //   838: astore 7
    //   840: goto -445 -> 395
    //   843: astore 6
    //   845: goto -622 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	848	0	this	WatermarkVideoRunnable
    //   486	13	1	f	float
    //   249	130	2	bool1	boolean
    //   4	380	3	bool2	boolean
    //   281	108	4	l	long
    //   1	101	6	localObject1	Object
    //   218	1	6	localRuntimeException1	java.lang.RuntimeException
    //   225	383	6	localObject2	Object
    //   623	12	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   651	34	6	localException1	java.lang.Exception
    //   716	12	6	localObject3	Object
    //   771	62	6	localException2	java.lang.Exception
    //   843	1	6	localRuntimeException2	java.lang.RuntimeException
    //   18	340	7	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   393	13	7	localObject4	Object
    //   511	169	7	localBitmap	android.graphics.Bitmap
    //   807	12	7	localInterruptedException	java.lang.InterruptedException
    //   830	6	7	localObject5	Object
    //   838	1	7	localObject6	Object
    //   44	533	8	localObject7	Object
    //   57	48	9	str	String
    // Exception table:
    //   from	to	target	type
    //   11	20	218	java/lang/RuntimeException
    //   11	20	393	finally
    //   448	518	623	java/lang/OutOfMemoryError
    //   448	518	651	java/lang/Exception
    //   730	770	771	java/lang/Exception
    //   721	727	807	java/lang/InterruptedException
    //   721	727	830	finally
    //   727	730	830	finally
    //   809	827	830	finally
    //   832	835	830	finally
    //   24	33	838	finally
    //   37	46	838	finally
    //   50	59	838	finally
    //   63	71	838	finally
    //   75	83	838	finally
    //   87	99	838	finally
    //   103	115	838	finally
    //   227	234	838	finally
    //   241	248	838	finally
    //   259	267	838	finally
    //   276	283	838	finally
    //   287	335	838	finally
    //   339	346	838	finally
    //   361	374	838	finally
    //   24	33	843	java/lang/RuntimeException
    //   37	46	843	java/lang/RuntimeException
    //   50	59	843	java/lang/RuntimeException
    //   63	71	843	java/lang/RuntimeException
    //   75	83	843	java/lang/RuntimeException
    //   87	99	843	java/lang/RuntimeException
    //   103	115	843	java/lang/RuntimeException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUtils.WatermarkVideoRunnable
 * JD-Core Version:    0.7.0.1
 */