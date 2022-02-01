package com.tencent.mobileqq.editor.composite.step;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.MobileQQ;

public class VideoStoryPicToVideo
{
  private static VideoStoryPicToVideo jdField_a_of_type_ComTencentMobileqqEditorCompositeStepVideoStoryPicToVideo;
  public static final String a;
  public static final String b;
  private Context jdField_a_of_type_AndroidContentContext = MobileQQ.getContext();
  private MuiltiImageToVideo jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/Android/data/com.tencent.mobileqq/qq/video/imagevideo/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("cache/videostory/");
    b = localStringBuilder.toString();
  }
  
  private VideoStoryPicToVideo()
  {
    Object localObject = new File(b);
    if (!((File)localObject).exists())
    {
      boolean bool = ((File)localObject).mkdirs();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("VideoStoryPicToVideo, createDir:");
        ((StringBuilder)localObject).append(bool);
        QLog.d("VideoStoryPicToVideo", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static VideoStoryPicToVideo a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEditorCompositeStepVideoStoryPicToVideo == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqEditorCompositeStepVideoStoryPicToVideo == null) {
          jdField_a_of_type_ComTencentMobileqqEditorCompositeStepVideoStoryPicToVideo = new VideoStoryPicToVideo();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqEditorCompositeStepVideoStoryPicToVideo;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, VideoStoryPicToVideo.ConvertListener paramConvertListener)
  {
    VideoStoryPicToVideo.RetCode localRetCode = new VideoStoryPicToVideo.RetCode(0, "success");
    try
    {
      FFmpegUtils.convertPicToVideoWidthDuration(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, paramString3, new VideoStoryPicToVideo.2(this, paramConvertListener, localRetCode));
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      if (paramConvertListener != null)
      {
        localRetCode.a(943004);
        localRetCode.a(paramString1.getMessage());
        paramConvertListener.b(localRetCode);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("VideoStoryPicToVideo", 2, "picToVideo failure");
        return;
      }
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      paramString1.printStackTrace();
      if (paramConvertListener != null)
      {
        localRetCode.a(943004);
        localRetCode.a(paramString1.getMessage());
        paramConvertListener.b(localRetCode);
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoStoryPicToVideo", 2, "picToVideo failure");
      }
    }
  }
  
  /* Error */
  @android.support.annotation.RequiresApi(api=17)
  private void b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, VideoStoryPicToVideo.ConvertListener paramConvertListener)
  {
    // Byte code:
    //   0: new 95	com/tencent/mobileqq/editor/composite/step/VideoStoryPicToVideo$RetCode
    //   3: dup
    //   4: iconst_0
    //   5: ldc 97
    //   7: invokespecial 100	com/tencent/mobileqq/editor/composite/step/VideoStoryPicToVideo$RetCode:<init>	(ILjava/lang/String;)V
    //   10: astore 21
    //   12: aconst_null
    //   13: astore 20
    //   15: new 141	java/io/FileInputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 142	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: astore 14
    //   25: new 144	java/io/BufferedInputStream
    //   28: dup
    //   29: aload 14
    //   31: ldc 145
    //   33: invokespecial 148	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   36: astore 19
    //   38: aload 14
    //   40: astore 15
    //   42: aload 19
    //   44: astore 17
    //   46: aload 19
    //   48: aconst_null
    //   49: iload 4
    //   51: iload 5
    //   53: invokestatic 153	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/io/InputStream;Landroid/graphics/Rect;II)Landroid/graphics/Bitmap;
    //   56: astore 16
    //   58: iload 4
    //   60: istore 12
    //   62: iload 5
    //   64: istore 11
    //   66: aload 19
    //   68: invokevirtual 156	java/io/BufferedInputStream:close	()V
    //   71: iload 4
    //   73: istore 12
    //   75: iload 5
    //   77: istore 11
    //   79: aload 14
    //   81: invokevirtual 157	java/io/FileInputStream:close	()V
    //   84: aload 16
    //   86: astore 15
    //   88: goto +114 -> 202
    //   91: astore 18
    //   93: aload 14
    //   95: astore 16
    //   97: aload 19
    //   99: astore 14
    //   101: goto +46 -> 147
    //   104: astore_1
    //   105: aconst_null
    //   106: astore 17
    //   108: goto +343 -> 451
    //   111: astore 18
    //   113: aconst_null
    //   114: astore 15
    //   116: aload 14
    //   118: astore 16
    //   120: aload 15
    //   122: astore 14
    //   124: goto +23 -> 147
    //   127: astore_1
    //   128: aconst_null
    //   129: astore 14
    //   131: aload 14
    //   133: astore 17
    //   135: goto +316 -> 451
    //   138: astore 18
    //   140: aconst_null
    //   141: astore 16
    //   143: aload 16
    //   145: astore 14
    //   147: aload 16
    //   149: astore 15
    //   151: aload 14
    //   153: astore 17
    //   155: aload 18
    //   157: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   160: aload 14
    //   162: ifnull +19 -> 181
    //   165: iload 4
    //   167: istore 12
    //   169: iload 5
    //   171: istore 11
    //   173: aload 14
    //   175: invokevirtual 156	java/io/BufferedInputStream:close	()V
    //   178: goto +3 -> 181
    //   181: aload 16
    //   183: ifnull +16 -> 199
    //   186: iload 4
    //   188: istore 12
    //   190: iload 5
    //   192: istore 11
    //   194: aload 16
    //   196: invokevirtual 157	java/io/FileInputStream:close	()V
    //   199: aconst_null
    //   200: astore 15
    //   202: aload 15
    //   204: astore 14
    //   206: aload 15
    //   208: ifnonnull +21 -> 229
    //   211: iload 4
    //   213: istore 12
    //   215: iload 5
    //   217: istore 11
    //   219: aload_1
    //   220: iload 4
    //   222: iload 5
    //   224: invokestatic 161	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   227: astore 14
    //   229: aload 14
    //   231: ifnonnull +56 -> 287
    //   234: aload 8
    //   236: ifnull +432 -> 668
    //   239: iload 4
    //   241: istore 12
    //   243: iload 5
    //   245: istore 11
    //   247: aload 21
    //   249: ldc 162
    //   251: invokevirtual 118	com/tencent/mobileqq/editor/composite/step/VideoStoryPicToVideo$RetCode:a	(I)V
    //   254: iload 4
    //   256: istore 12
    //   258: iload 5
    //   260: istore 11
    //   262: aload 21
    //   264: ldc 164
    //   266: invokevirtual 123	com/tencent/mobileqq/editor/composite/step/VideoStoryPicToVideo$RetCode:a	(Ljava/lang/String;)V
    //   269: iload 4
    //   271: istore 12
    //   273: iload 5
    //   275: istore 11
    //   277: aload 8
    //   279: aload 21
    //   281: invokeinterface 128 2 0
    //   286: return
    //   287: iload 4
    //   289: istore 12
    //   291: iload 5
    //   293: istore 11
    //   295: aload_1
    //   296: invokestatic 170	com/tencent/mobileqq/utils/BaseImageUtil:c	(Ljava/lang/String;)I
    //   299: istore 13
    //   301: iload 13
    //   303: ifeq +137 -> 440
    //   306: iload 13
    //   308: bipush 90
    //   310: irem
    //   311: ifne +129 -> 440
    //   314: iload 4
    //   316: istore 12
    //   318: iload 5
    //   320: istore 11
    //   322: new 172	android/graphics/Matrix
    //   325: dup
    //   326: invokespecial 173	android/graphics/Matrix:<init>	()V
    //   329: astore_1
    //   330: iload 4
    //   332: istore 12
    //   334: iload 5
    //   336: istore 11
    //   338: aload_1
    //   339: iload 13
    //   341: i2f
    //   342: aload 14
    //   344: invokevirtual 179	android/graphics/Bitmap:getWidth	()I
    //   347: i2f
    //   348: fconst_2
    //   349: fdiv
    //   350: aload 14
    //   352: invokevirtual 182	android/graphics/Bitmap:getHeight	()I
    //   355: i2f
    //   356: fconst_2
    //   357: fdiv
    //   358: invokevirtual 186	android/graphics/Matrix:postRotate	(FFF)Z
    //   361: pop
    //   362: iload 4
    //   364: istore 12
    //   366: iload 5
    //   368: istore 11
    //   370: aload 14
    //   372: iconst_0
    //   373: iconst_0
    //   374: aload 14
    //   376: invokevirtual 179	android/graphics/Bitmap:getWidth	()I
    //   379: aload 14
    //   381: invokevirtual 182	android/graphics/Bitmap:getHeight	()I
    //   384: aload_1
    //   385: iconst_1
    //   386: invokestatic 190	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   389: astore_1
    //   390: iload 13
    //   392: bipush 90
    //   394: if_icmpeq +275 -> 669
    //   397: iload 4
    //   399: istore 9
    //   401: iload 5
    //   403: istore 10
    //   405: iload 13
    //   407: sipush 270
    //   410: if_icmpne +6 -> 416
    //   413: goto +256 -> 669
    //   416: iload 9
    //   418: istore 12
    //   420: iload 10
    //   422: istore 11
    //   424: aload 14
    //   426: invokevirtual 193	android/graphics/Bitmap:recycle	()V
    //   429: iload 9
    //   431: istore 4
    //   433: iload 10
    //   435: istore 5
    //   437: goto +63 -> 500
    //   440: aload 14
    //   442: astore_1
    //   443: goto +57 -> 500
    //   446: astore_1
    //   447: aload 15
    //   449: astore 14
    //   451: aload 17
    //   453: ifnull +19 -> 472
    //   456: iload 4
    //   458: istore 12
    //   460: iload 5
    //   462: istore 11
    //   464: aload 17
    //   466: invokevirtual 156	java/io/BufferedInputStream:close	()V
    //   469: goto +3 -> 472
    //   472: aload 14
    //   474: ifnull +16 -> 490
    //   477: iload 4
    //   479: istore 12
    //   481: iload 5
    //   483: istore 11
    //   485: aload 14
    //   487: invokevirtual 157	java/io/FileInputStream:close	()V
    //   490: iload 4
    //   492: istore 12
    //   494: iload 5
    //   496: istore 11
    //   498: aload_1
    //   499: athrow
    //   500: aload_1
    //   501: ifnonnull +32 -> 533
    //   504: aload 8
    //   506: ifnull +26 -> 532
    //   509: aload 21
    //   511: ldc 162
    //   513: invokevirtual 118	com/tencent/mobileqq/editor/composite/step/VideoStoryPicToVideo$RetCode:a	(I)V
    //   516: aload 21
    //   518: ldc 164
    //   520: invokevirtual 123	com/tencent/mobileqq/editor/composite/step/VideoStoryPicToVideo$RetCode:a	(Ljava/lang/String;)V
    //   523: aload 8
    //   525: aload 21
    //   527: invokeinterface 128 2 0
    //   532: return
    //   533: aload_0
    //   534: new 195	com/tencent/mobileqq/editor/composite/step/MuiltiImageToVideo
    //   537: dup
    //   538: aload_2
    //   539: iload 4
    //   541: iload 5
    //   543: ldc 197
    //   545: invokestatic 202	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   548: checkcast 197	com/tencent/mobileqq/dov/story/api/ISVParamManager
    //   551: iconst_2
    //   552: invokeinterface 206 2 0
    //   557: iconst_4
    //   558: imul
    //   559: sipush 1000
    //   562: imul
    //   563: aload_3
    //   564: invokestatic 212	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   567: invokevirtual 215	java/lang/Integer:intValue	()I
    //   570: sipush 1000
    //   573: imul
    //   574: i2l
    //   575: iload 6
    //   577: iload 7
    //   579: invokespecial 218	com/tencent/mobileqq/editor/composite/step/MuiltiImageToVideo:<init>	(Ljava/lang/String;IIIJZI)V
    //   582: putfield 220	com/tencent/mobileqq/editor/composite/step/VideoStoryPicToVideo:jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo	Lcom/tencent/mobileqq/editor/composite/step/MuiltiImageToVideo;
    //   585: aload_0
    //   586: getfield 220	com/tencent/mobileqq/editor/composite/step/VideoStoryPicToVideo:jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo	Lcom/tencent/mobileqq/editor/composite/step/MuiltiImageToVideo;
    //   589: bipush 16
    //   591: invokevirtual 221	com/tencent/mobileqq/editor/composite/step/MuiltiImageToVideo:a	(I)V
    //   594: new 223	java/util/ArrayList
    //   597: dup
    //   598: invokespecial 224	java/util/ArrayList:<init>	()V
    //   601: astore_2
    //   602: aload_2
    //   603: aload_1
    //   604: invokevirtual 228	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   607: pop
    //   608: aload_0
    //   609: getfield 220	com/tencent/mobileqq/editor/composite/step/VideoStoryPicToVideo:jdField_a_of_type_ComTencentMobileqqEditorCompositeStepMuiltiImageToVideo	Lcom/tencent/mobileqq/editor/composite/step/MuiltiImageToVideo;
    //   612: aload_2
    //   613: aload 8
    //   615: invokevirtual 231	com/tencent/mobileqq/editor/composite/step/MuiltiImageToVideo:a	(Ljava/util/List;Lcom/tencent/mobileqq/editor/composite/step/VideoStoryPicToVideo$ConvertListener;)V
    //   618: return
    //   619: astore 15
    //   621: goto -550 -> 71
    //   624: astore_1
    //   625: iload 12
    //   627: istore 4
    //   629: iload 11
    //   631: istore 5
    //   633: aload 20
    //   635: astore_1
    //   636: goto -136 -> 500
    //   639: astore 14
    //   641: aload 16
    //   643: astore 15
    //   645: goto -443 -> 202
    //   648: astore 14
    //   650: goto -469 -> 181
    //   653: astore 14
    //   655: goto -456 -> 199
    //   658: astore 15
    //   660: goto -188 -> 472
    //   663: astore 14
    //   665: goto -175 -> 490
    //   668: return
    //   669: iload 5
    //   671: istore 9
    //   673: iload 4
    //   675: istore 10
    //   677: goto -261 -> 416
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	680	0	this	VideoStoryPicToVideo
    //   0	680	1	paramString1	String
    //   0	680	2	paramString2	String
    //   0	680	3	paramString3	String
    //   0	680	4	paramInt1	int
    //   0	680	5	paramInt2	int
    //   0	680	6	paramBoolean	boolean
    //   0	680	7	paramInt3	int
    //   0	680	8	paramConvertListener	VideoStoryPicToVideo.ConvertListener
    //   399	273	9	i	int
    //   403	273	10	j	int
    //   64	566	11	k	int
    //   60	566	12	m	int
    //   299	112	13	n	int
    //   23	463	14	localObject1	Object
    //   639	1	14	localException1	java.lang.Exception
    //   648	1	14	localException2	java.lang.Exception
    //   653	1	14	localException3	java.lang.Exception
    //   663	1	14	localException4	java.lang.Exception
    //   40	408	15	localObject2	Object
    //   619	1	15	localException5	java.lang.Exception
    //   643	1	15	localObject3	Object
    //   658	1	15	localException6	java.lang.Exception
    //   56	586	16	localObject4	Object
    //   44	421	17	localObject5	Object
    //   91	1	18	localException7	java.lang.Exception
    //   111	1	18	localException8	java.lang.Exception
    //   138	18	18	localException9	java.lang.Exception
    //   36	62	19	localBufferedInputStream	java.io.BufferedInputStream
    //   13	621	20	localObject6	Object
    //   10	516	21	localRetCode	VideoStoryPicToVideo.RetCode
    // Exception table:
    //   from	to	target	type
    //   46	58	91	java/lang/Exception
    //   25	38	104	finally
    //   25	38	111	java/lang/Exception
    //   15	25	127	finally
    //   15	25	138	java/lang/Exception
    //   46	58	446	finally
    //   155	160	446	finally
    //   66	71	619	java/lang/Exception
    //   66	71	624	java/lang/OutOfMemoryError
    //   79	84	624	java/lang/OutOfMemoryError
    //   173	178	624	java/lang/OutOfMemoryError
    //   194	199	624	java/lang/OutOfMemoryError
    //   219	229	624	java/lang/Exception
    //   219	229	624	java/lang/OutOfMemoryError
    //   247	254	624	java/lang/Exception
    //   247	254	624	java/lang/OutOfMemoryError
    //   262	269	624	java/lang/Exception
    //   262	269	624	java/lang/OutOfMemoryError
    //   277	286	624	java/lang/Exception
    //   277	286	624	java/lang/OutOfMemoryError
    //   295	301	624	java/lang/Exception
    //   295	301	624	java/lang/OutOfMemoryError
    //   322	330	624	java/lang/Exception
    //   322	330	624	java/lang/OutOfMemoryError
    //   338	362	624	java/lang/Exception
    //   338	362	624	java/lang/OutOfMemoryError
    //   370	390	624	java/lang/Exception
    //   370	390	624	java/lang/OutOfMemoryError
    //   424	429	624	java/lang/Exception
    //   424	429	624	java/lang/OutOfMemoryError
    //   464	469	624	java/lang/OutOfMemoryError
    //   485	490	624	java/lang/OutOfMemoryError
    //   498	500	624	java/lang/Exception
    //   498	500	624	java/lang/OutOfMemoryError
    //   79	84	639	java/lang/Exception
    //   173	178	648	java/lang/Exception
    //   194	199	653	java/lang/Exception
    //   464	469	658	java/lang/Exception
    //   485	490	663	java/lang/Exception
  }
  
  public String a(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    Object localObject = localFile.getName();
    paramString1 = (String)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString1 = ((String)localObject).replace(".", "_");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(localFile.length());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString2);
      paramString1 = ((StringBuilder)localObject).toString();
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(".mp4");
      paramString1 = paramString2.toString();
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = new StringBuilder();
      paramString2.append(b);
      paramString2.append(paramString1);
      paramString1 = paramString2.toString();
    }
    else
    {
      paramString1 = "";
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("genOupPath");
      paramString2.append(paramString1);
      QLog.d("VideoStoryPicToVideo", 2, paramString2.toString());
    }
    return paramString1;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, VideoStoryPicToVideo.ConvertListener paramConvertListener)
  {
    VideoStoryPicToVideo.RetCode localRetCode = new VideoStoryPicToVideo.RetCode(0, "success");
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      if (paramString3.equals("0"))
      {
        localRetCode.a(941003);
        localRetCode.a("duration is 0");
        paramConvertListener.b(localRetCode);
        return;
      }
      if (FileUtils.fileExistsAndNotEmpty(paramString2)) {
        if (paramConvertListener != null)
        {
          localRetCode.a(0);
          localRetCode.a("success");
          paramConvertListener.a(localRetCode);
        }
      }
      for (;;)
      {
        return;
        if (Build.VERSION.SDK_INT < 17) {
          break;
        }
        ThreadManager.newFreeThread(new VideoStoryPicToVideo.1(this, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramBoolean, paramInt3, paramConvertListener), "videoStoryPicToVideo", 5).start();
      }
      a(paramString1, paramString2, paramString3, paramConvertListener);
      return;
    }
    localRetCode.a(940007);
    localRetCode.a("Invalid argument");
    paramConvertListener.b(localRetCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo
 * JD-Core Version:    0.7.0.1
 */