package dov.com.tencent.biz.qqstory.takevideo.localmedia.demos;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import anlv;
import anlw;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.opengl.CodecOutputSurface;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.TimeoutException;
import junit.framework.Assert;

@TargetApi(16)
public class MediaCodecThumbnailGenerator$CodecHandler
  extends Handler
{
  public MediaCodecThumbnailGenerator$CodecHandler(MediaCodecThumbnailGenerator paramMediaCodecThumbnailGenerator, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  private void a(MediaCodecThumbnailGenerator.ThumbnailArgs paramThumbnailArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: iconst_0
    //   4: istore_3
    //   5: new 26	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext
    //   8: dup
    //   9: invokespecial 29	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:<init>	()V
    //   12: astore 9
    //   14: aload 9
    //   16: aload_1
    //   17: putfield 32	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs	Ldov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs;
    //   20: aload 9
    //   22: aload_1
    //   23: getfield 37	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokestatic 42	dov/com/tencent/mobileqq/richmedia/mediacodec/utils/MediaUtil:a	(Ljava/lang/String;)J
    //   29: ldc2_w 43
    //   32: lmul
    //   33: putfield 48	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_Long	J
    //   36: new 50	java/io/File
    //   39: dup
    //   40: aload_1
    //   41: getfield 37	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   44: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 10
    //   49: aload 10
    //   51: invokevirtual 57	java/io/File:canRead	()Z
    //   54: ifne +89 -> 143
    //   57: new 59	java/io/FileNotFoundException
    //   60: dup
    //   61: new 61	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   68: ldc 64
    //   70: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 10
    //   75: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 76	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   84: athrow
    //   85: astore 7
    //   87: aload 8
    //   89: astore_1
    //   90: ldc 78
    //   92: ldc 80
    //   94: aload 7
    //   96: invokestatic 86	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   99: pop
    //   100: aload 7
    //   102: instanceof 88
    //   105: ifeq +481 -> 586
    //   108: aload 9
    //   110: bipush 100
    //   112: putfield 91	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_Int	I
    //   115: ldc 78
    //   117: ldc 93
    //   119: aload 7
    //   121: invokestatic 99	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_0
    //   125: iconst_4
    //   126: aload 9
    //   128: invokevirtual 103	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$CodecHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   131: invokevirtual 108	android/os/Message:sendToTarget	()V
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 113	android/media/MediaExtractor:release	()V
    //   142: return
    //   143: new 110	android/media/MediaExtractor
    //   146: dup
    //   147: invokespecial 114	android/media/MediaExtractor:<init>	()V
    //   150: astore 7
    //   152: aload 7
    //   154: aload 10
    //   156: invokevirtual 115	java/io/File:toString	()Ljava/lang/String;
    //   159: invokevirtual 118	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   162: aload 7
    //   164: invokestatic 123	dov/com/tencent/biz/qqstory/takevideo/localmedia/baoutils/media/VideoUtils:a	(Landroid/media/MediaExtractor;)I
    //   167: istore 5
    //   169: iload 5
    //   171: ifge +31 -> 202
    //   174: new 125	java/lang/RuntimeException
    //   177: dup
    //   178: new 61	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   185: ldc 127
    //   187: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload 10
    //   192: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokespecial 128	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   201: athrow
    //   202: aload 7
    //   204: iload 5
    //   206: invokevirtual 132	android/media/MediaExtractor:selectTrack	(I)V
    //   209: aload_1
    //   210: getfield 134	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:jdField_b_of_type_Int	I
    //   213: istore 4
    //   215: aload_1
    //   216: getfield 137	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:d	I
    //   219: newarray long
    //   221: astore 8
    //   223: aload_1
    //   224: getfield 137	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:d	I
    //   227: newarray long
    //   229: astore 10
    //   231: iload_3
    //   232: aload_1
    //   233: getfield 137	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:d	I
    //   236: if_icmpge +52 -> 288
    //   239: aload 7
    //   241: iload 4
    //   243: i2l
    //   244: ldc2_w 43
    //   247: lmul
    //   248: iconst_0
    //   249: invokevirtual 141	android/media/MediaExtractor:seekTo	(JI)V
    //   252: aload 10
    //   254: iload_3
    //   255: iload 4
    //   257: i2l
    //   258: ldc2_w 43
    //   261: lmul
    //   262: lastore
    //   263: aload 8
    //   265: iload_3
    //   266: aload 7
    //   268: invokevirtual 145	android/media/MediaExtractor:getSampleTime	()J
    //   271: lastore
    //   272: iload 4
    //   274: aload_1
    //   275: getfield 147	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:c	I
    //   278: iadd
    //   279: istore 4
    //   281: iload_3
    //   282: iconst_1
    //   283: iadd
    //   284: istore_3
    //   285: goto -54 -> 231
    //   288: aload 7
    //   290: aload 8
    //   292: iconst_0
    //   293: laload
    //   294: iconst_0
    //   295: invokevirtual 141	android/media/MediaExtractor:seekTo	(JI)V
    //   298: aload 7
    //   300: iload 5
    //   302: invokevirtual 151	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   305: astore 11
    //   307: aload 11
    //   309: ldc 153
    //   311: invokevirtual 159	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   314: istore 6
    //   316: iload 6
    //   318: ifeq +206 -> 524
    //   321: aload 9
    //   323: aload 11
    //   325: ldc 153
    //   327: invokevirtual 163	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   330: putfield 164	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_Int	I
    //   333: aload 11
    //   335: ldc 166
    //   337: invokevirtual 163	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   340: istore_3
    //   341: aload 11
    //   343: ldc 168
    //   345: invokevirtual 163	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   348: istore 4
    //   350: ldc 78
    //   352: new 61	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   359: ldc 170
    //   361: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: iload 4
    //   366: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: ldc 175
    //   371: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: iload_3
    //   375: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 178	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   384: pop
    //   385: aload_1
    //   386: getfield 179	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:jdField_a_of_type_Int	I
    //   389: i2f
    //   390: fconst_1
    //   391: fmul
    //   392: iload_3
    //   393: iload 4
    //   395: invokestatic 185	java/lang/Math:max	(II)I
    //   398: i2f
    //   399: fdiv
    //   400: fstore_2
    //   401: new 187	dov/com/tencent/biz/qqstory/takevideo/localmedia/opengl/CodecOutputSurface
    //   404: dup
    //   405: iload 4
    //   407: i2f
    //   408: fload_2
    //   409: fmul
    //   410: f2i
    //   411: iload_3
    //   412: i2f
    //   413: fload_2
    //   414: fmul
    //   415: f2i
    //   416: invokespecial 190	dov/com/tencent/biz/qqstory/takevideo/localmedia/opengl/CodecOutputSurface:<init>	(II)V
    //   419: astore_1
    //   420: aload 11
    //   422: ldc 192
    //   424: invokevirtual 196	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   427: invokestatic 202	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   430: astore 12
    //   432: aload 12
    //   434: aload 11
    //   436: aload_1
    //   437: invokevirtual 205	dov/com/tencent/biz/qqstory/takevideo/localmedia/opengl/CodecOutputSurface:a	()Landroid/view/Surface;
    //   440: aconst_null
    //   441: iconst_0
    //   442: invokevirtual 209	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   445: aload 12
    //   447: invokevirtual 212	android/media/MediaCodec:start	()V
    //   450: aload 9
    //   452: aload 7
    //   454: putfield 215	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   457: aload 9
    //   459: aload_1
    //   460: putfield 218	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface	Ldov/com/tencent/biz/qqstory/takevideo/localmedia/opengl/CodecOutputSurface;
    //   463: aload 9
    //   465: aload 12
    //   467: putfield 221	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   470: aload 9
    //   472: iload 5
    //   474: putfield 222	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:c	I
    //   477: aload 9
    //   479: iconst_0
    //   480: putfield 91	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_Int	I
    //   483: aload 9
    //   485: iconst_0
    //   486: putfield 223	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:d	I
    //   489: aload 9
    //   491: aload 8
    //   493: putfield 226	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_ArrayOfLong	[J
    //   496: aload 9
    //   498: aload 10
    //   500: putfield 228	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_ArrayOfLong	[J
    //   503: aload_0
    //   504: iconst_2
    //   505: aload 9
    //   507: invokevirtual 103	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$CodecHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   510: invokevirtual 108	android/os/Message:sendToTarget	()V
    //   513: aload 7
    //   515: ifnull -373 -> 142
    //   518: aload 7
    //   520: invokevirtual 113	android/media/MediaExtractor:release	()V
    //   523: return
    //   524: new 230	android/media/MediaMetadataRetriever
    //   527: dup
    //   528: invokespecial 231	android/media/MediaMetadataRetriever:<init>	()V
    //   531: astore 12
    //   533: aload 12
    //   535: aload 9
    //   537: getfield 32	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs	Ldov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs;
    //   540: getfield 37	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailArgs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   543: invokevirtual 232	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   546: aload 12
    //   548: bipush 24
    //   550: invokevirtual 236	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   553: astore 13
    //   555: aload 9
    //   557: aload 13
    //   559: invokestatic 241	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   562: putfield 164	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_b_of_type_Int	I
    //   565: aload 12
    //   567: invokevirtual 242	android/media/MediaMetadataRetriever:release	()V
    //   570: goto -237 -> 333
    //   573: astore_1
    //   574: aload 7
    //   576: ifnull +8 -> 584
    //   579: aload 7
    //   581: invokevirtual 113	android/media/MediaExtractor:release	()V
    //   584: aload_1
    //   585: athrow
    //   586: aload 7
    //   588: instanceof 125
    //   591: ifeq +13 -> 604
    //   594: aload 9
    //   596: bipush 101
    //   598: putfield 91	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_Int	I
    //   601: goto -486 -> 115
    //   604: aload 9
    //   606: iconst_m1
    //   607: putfield 91	dov/com/tencent/biz/qqstory/takevideo/localmedia/demos/MediaCodecThumbnailGenerator$ThumbnailTaskContext:jdField_a_of_type_Int	I
    //   610: goto -495 -> 115
    //   613: astore_1
    //   614: aconst_null
    //   615: astore 7
    //   617: goto -43 -> 574
    //   620: astore 13
    //   622: goto -57 -> 565
    //   625: astore 12
    //   627: goto -294 -> 333
    //   630: astore 8
    //   632: aload 7
    //   634: astore_1
    //   635: aload 8
    //   637: astore 7
    //   639: goto -549 -> 90
    //   642: astore 8
    //   644: aload_1
    //   645: astore 7
    //   647: aload 8
    //   649: astore_1
    //   650: goto -76 -> 574
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	653	0	this	CodecHandler
    //   0	653	1	paramThumbnailArgs	MediaCodecThumbnailGenerator.ThumbnailArgs
    //   400	14	2	f	float
    //   4	408	3	i	int
    //   213	193	4	j	int
    //   167	306	5	k	int
    //   314	3	6	bool	boolean
    //   85	35	7	localException1	java.lang.Exception
    //   150	496	7	localObject1	Object
    //   1	491	8	arrayOfLong	long[]
    //   630	6	8	localException2	java.lang.Exception
    //   642	6	8	localObject2	Object
    //   12	593	9	localThumbnailTaskContext	MediaCodecThumbnailGenerator.ThumbnailTaskContext
    //   47	452	10	localObject3	Object
    //   305	130	11	localMediaFormat	MediaFormat
    //   430	136	12	localObject4	Object
    //   625	1	12	localNullPointerException	java.lang.NullPointerException
    //   553	5	13	str	String
    //   620	1	13	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   36	85	85	java/lang/Exception
    //   143	152	85	java/lang/Exception
    //   152	169	573	finally
    //   174	202	573	finally
    //   202	231	573	finally
    //   231	252	573	finally
    //   263	281	573	finally
    //   288	316	573	finally
    //   321	333	573	finally
    //   333	513	573	finally
    //   524	555	573	finally
    //   555	565	573	finally
    //   565	570	573	finally
    //   36	85	613	finally
    //   143	152	613	finally
    //   555	565	620	java/lang/NumberFormatException
    //   321	333	625	java/lang/NullPointerException
    //   152	169	630	java/lang/Exception
    //   174	202	630	java/lang/Exception
    //   202	231	630	java/lang/Exception
    //   231	252	630	java/lang/Exception
    //   263	281	630	java/lang/Exception
    //   288	316	630	java/lang/Exception
    //   321	333	630	java/lang/Exception
    //   333	513	630	java/lang/Exception
    //   524	555	630	java/lang/Exception
    //   555	565	630	java/lang/Exception
    //   565	570	630	java/lang/Exception
    //   90	115	642	finally
    //   115	134	642	finally
    //   586	601	642	finally
    //   604	610	642	finally
  }
  
  private void a(MediaCodecThumbnailGenerator.ThumbnailTaskContext paramThumbnailTaskContext)
  {
    Log.e("MediaCodecThumbnailGen", "finishCapture");
    boolean bool = true;
    if (paramThumbnailTaskContext.jdField_a_of_type_Int != 0) {
      bool = false;
    }
    if (paramThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface != null)
    {
      paramThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface.a();
      paramThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface = null;
    }
    if (paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec != null)
    {
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec.release();
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if (paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    MediaCodecThumbnailGenerator.ThumbnailResult localThumbnailResult = new MediaCodecThumbnailGenerator.ThumbnailResult();
    localThumbnailResult.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(paramThumbnailTaskContext.jdField_a_of_type_JavaUtilArrayList);
    localThumbnailResult.b = Collections.unmodifiableList(paramThumbnailTaskContext.jdField_b_of_type_JavaUtilArrayList);
    localThumbnailResult.jdField_a_of_type_Int = paramThumbnailTaskContext.jdField_a_of_type_Int;
    this.a.a.post(new anlv(this, paramThumbnailTaskContext, bool, localThumbnailResult));
  }
  
  private void a(MediaCodecThumbnailGenerator.ThumbnailTaskContext paramThumbnailTaskContext, boolean paramBoolean)
  {
    Object localObject1 = paramThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface;
    MediaCodecThumbnailGenerator.ThumbnailArgs localThumbnailArgs = paramThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs;
    int k = paramThumbnailTaskContext.d;
    ArrayList localArrayList1 = paramThumbnailTaskContext.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList2 = paramThumbnailTaskContext.jdField_b_of_type_JavaUtilArrayList;
    label575:
    label578:
    label588:
    for (;;)
    {
      int j;
      try
      {
        ((CodecOutputSurface)localObject1).c();
        ((CodecOutputSurface)localObject1).d();
        ((CodecOutputSurface)localObject1).a(false);
        MediaCodecThumbnailGenerator.ThumbnailProgress localThumbnailProgress = new MediaCodecThumbnailGenerator.ThumbnailProgress();
        localObject1 = ((CodecOutputSurface)localObject1).a();
        if (localObject1 == null) {
          break label575;
        }
        j = paramThumbnailTaskContext.jdField_b_of_type_Int;
        if ((paramThumbnailTaskContext.jdField_b_of_type_Int % 180 > 0) && (((Bitmap)localObject1).getWidth() < ((Bitmap)localObject1).getHeight())) {
          break label578;
        }
        i = j;
        if (paramThumbnailTaskContext.jdField_b_of_type_Int % 180 == 0)
        {
          i = j;
          if (((Bitmap)localObject1).getWidth() > ((Bitmap)localObject1).getHeight()) {
            break label578;
          }
        }
        if (i > 0)
        {
          Object localObject2 = UIUtils.a((Bitmap)localObject1, i);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
          localArrayList2.add(localObject1);
          if (!paramBoolean) {
            break label588;
          }
          localObject2 = new File(localThumbnailArgs.jdField_b_of_type_JavaLangString, String.format(Locale.getDefault(), a(k), new Object[0]));
          try
          {
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject2));
            float f2;
            float f1;
            localObject1 = paramThumbnailTaskContext.jdField_b_of_type_ArrayOfLong;
          }
          finally
          {
            try
            {
              ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 80, localBufferedOutputStream);
              if (localBufferedOutputStream == null) {}
            }
            finally
            {
              continue;
            }
            try
            {
              localBufferedOutputStream.close();
              localArrayList1.add(((File)localObject2).getAbsolutePath());
              localThumbnailProgress.jdField_a_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
              SLog.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + ((File)localObject2).getPath());
              localThumbnailProgress.jdField_a_of_type_Int = paramThumbnailTaskContext.d;
              localThumbnailProgress.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              f2 = 0.0F;
              f1 = f2;
              if (localThumbnailArgs.jdField_b_of_type_Boolean)
              {
                f1 = f2;
                if (paramThumbnailTaskContext.d == 0)
                {
                  f1 = MediaCodecThumbnailGenerator.a((Bitmap)localObject1);
                  SLog.c("MediaCodecThumbnailGen", "blackRegionPrecent = " + f1);
                  localThumbnailProgress.jdField_a_of_type_Long = paramThumbnailTaskContext.jdField_b_of_type_ArrayOfLong[paramThumbnailTaskContext.d];
                }
              }
              if ((f1 >= 0.9F) && (localThumbnailProgress.jdField_a_of_type_Long <= 500000L) && (localThumbnailProgress.jdField_a_of_type_Long + 100000L <= paramThumbnailTaskContext.jdField_b_of_type_Long)) {
                continue;
              }
              localArrayList1.add(localThumbnailProgress.jdField_a_of_type_JavaLangString);
              localArrayList2.add(localObject1);
              this.a.a.post(new anlw(this, paramThumbnailTaskContext, localThumbnailProgress));
              paramThumbnailTaskContext.d += 1;
              obtainMessage(2, paramThumbnailTaskContext).sendToTarget();
              return;
            }
            catch (IOException localIOException)
            {
              SLog.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", localIOException);
            }
            localObject3 = finally;
            localBufferedOutputStream = null;
            if (localBufferedOutputStream != null) {
              localBufferedOutputStream.close();
            }
          }
          i = paramThumbnailTaskContext.d;
          localObject1[i] += 50000L;
          obtainMessage(2, paramThumbnailTaskContext).sendToTarget();
          return;
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        sendMessageDelayed(obtainMessage(3, paramThumbnailTaskContext), 100L);
        Log.e("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() timeout delay 100ms");
        return;
      }
      continue;
      continue;
      int i = j + 90;
    }
  }
  
  private void b(MediaCodecThumbnailGenerator.ThumbnailTaskContext paramThumbnailTaskContext)
  {
    MediaCodec localMediaCodec;
    long[] arrayOfLong2;
    int i2;
    long l1;
    MediaCodec.BufferInfo localBufferInfo;
    int j;
    int i;
    int k;
    int m;
    int n;
    long l2;
    try
    {
      MediaExtractor localMediaExtractor = paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor;
      localMediaCodec = paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec;
      MediaCodecThumbnailGenerator.ThumbnailArgs localThumbnailArgs = paramThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs;
      long[] arrayOfLong1 = paramThumbnailTaskContext.jdField_a_of_type_ArrayOfLong;
      arrayOfLong2 = paramThumbnailTaskContext.jdField_b_of_type_ArrayOfLong;
      int i1 = paramThumbnailTaskContext.c;
      i2 = paramThumbnailTaskContext.d;
      l1 = localMediaExtractor.getSampleTime();
      ByteBuffer[] arrayOfByteBuffer = localMediaCodec.getInputBuffers();
      localBufferInfo = new MediaCodec.BufferInfo();
      j = 0;
      i = 0;
      k = 0;
      if ((i != 0) || (i2 >= localThumbnailArgs.d)) {
        break label724;
      }
      if ((paramThumbnailTaskContext.jdField_a_of_type_Long != arrayOfLong1[i2]) && (l1 < arrayOfLong1[i2]))
      {
        Log.e("MediaCodecThumbnailGen", "SeekTo: " + arrayOfLong1[i2]);
        localMediaExtractor.seekTo(arrayOfLong1[i2], 0);
        paramThumbnailTaskContext.jdField_a_of_type_Long = arrayOfLong1[i2];
        localMediaCodec.flush();
      }
      m = k;
      n = j;
      l2 = l1;
      if (k == 0)
      {
        m = localMediaCodec.dequeueInputBuffer(-1L);
        if (m < 0) {
          break label448;
        }
        n = localMediaExtractor.readSampleData(arrayOfByteBuffer[m], 0);
        if (n >= 0) {
          break label289;
        }
        localMediaCodec.queueInputBuffer(m, 0, 0, 0L, 4);
        m = 1;
        Log.d("MediaCodecThumbnailGen", "sent input EOS");
        k = j;
        j = m;
        break label729;
      }
      for (;;)
      {
        label246:
        k = m;
        j = n;
        l1 = l2;
        if (i != 0) {
          break;
        }
        j = localMediaCodec.dequeueOutputBuffer(localBufferInfo, 10000L);
        if (j != -1) {
          break label494;
        }
        Log.d("MediaCodecThumbnailGen", "no output from decoder available");
        break label743;
        label289:
        if (localMediaExtractor.getSampleTrackIndex() != i1) {
          Log.w("MediaCodecThumbnailGen", "WEIRD: got sample from track " + localMediaExtractor.getSampleTrackIndex() + ", expected " + i1);
        }
        localMediaCodec.queueInputBuffer(m, 0, n, localMediaExtractor.getSampleTime(), 0);
        Log.d("MediaCodecThumbnailGen", "submitted frame " + j + " to dec, size=" + n);
        l1 = localMediaExtractor.getSampleTime();
        Log.d("MediaCodecThumbnailGen", "extractor sample time = " + l1);
        localMediaExtractor.advance();
        m = j + 1;
        j = k;
        k = m;
        break label729;
        label448:
        Log.d("MediaCodecThumbnailGen", "input buffer not available");
        m = k;
        n = j;
        l2 = l1;
      }
      if (j != -3) {
        break label512;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.e("MediaCodecThumbnailGen", 1, "decodeThumbnails fail", localIllegalStateException);
      obtainMessage(4, paramThumbnailTaskContext).sendToTarget();
      return;
    }
    label494:
    Log.d("MediaCodecThumbnailGen", "decoder output buffers changed");
    break label743;
    label512:
    if (j == -2)
    {
      MediaFormat localMediaFormat = localMediaCodec.getOutputFormat();
      Log.d("MediaCodecThumbnailGen", "decoder output format changed: " + localMediaFormat);
    }
    else if (j < 0)
    {
      Assert.fail("unexpected result from decoder.dequeueOutputBuffer: " + j);
    }
    else
    {
      Log.d("MediaCodecThumbnailGen", "surface decoder given buffer " + j + " (size=" + localBufferInfo.size + ")");
      if ((localBufferInfo.flags & 0x4) != 0)
      {
        Log.d("MediaCodecThumbnailGen", "output EOS");
        i = 1;
        break label757;
      }
    }
    for (;;)
    {
      boolean bool;
      localMediaCodec.releaseOutputBuffer(j, bool);
      if (bool)
      {
        Log.d("MediaCodecThumbnailGen", "awaiting decode of time: " + l2);
        label724:
        for (i = 1;; i = 0)
        {
          if (i == 0)
          {
            obtainMessage(4, paramThumbnailTaskContext).sendToTarget();
            return;
          }
          obtainMessage(3, paramThumbnailTaskContext).sendToTarget();
          return;
          break;
        }
        label729:
        m = j;
        n = k;
        l2 = l1;
        break label246;
      }
      label743:
      k = m;
      j = n;
      l1 = l2;
      break;
      label757:
      if (l2 > arrayOfLong2[i2]) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public String a(int paramInt)
  {
    return String.format(Locale.getDefault(), "thumbnail-%d.jpg", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      a((MediaCodecThumbnailGenerator.ThumbnailArgs)paramMessage.obj);
      continue;
      b((MediaCodecThumbnailGenerator.ThumbnailTaskContext)paramMessage.obj);
      continue;
      a((MediaCodecThumbnailGenerator.ThumbnailTaskContext)paramMessage.obj, true);
      continue;
      a((MediaCodecThumbnailGenerator.ThumbnailTaskContext)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.CodecHandler
 * JD-Core Version:    0.7.0.1
 */