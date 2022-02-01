package com.tencent.mobileqq.microapp.widget.media;

import android.content.Context;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.b.b;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import java.io.File;
import org.json.JSONObject;

public class MiniAppCamera
  extends CameraSurfaceView
{
  private static MediaRecorder m;
  private static boolean n;
  private static String o;
  
  public MiniAppCamera(Context paramContext, WebviewContainer paramWebviewContainer)
  {
    super(paramContext, paramWebviewContainer);
  }
  
  private void a(String paramString, WebviewContainer paramWebviewContainer, int paramInt)
  {
    paramString = c.b(paramString, null);
    if (paramString != null) {
      paramString = paramString.toString();
    } else {
      paramString = "";
    }
    paramWebviewContainer.appBrandRuntime.i.evaluateCallbackJs(paramInt, paramString);
  }
  
  /* Error */
  private static String b(android.graphics.Bitmap paramBitmap, File paramFile, String paramString)
  {
    // Byte code:
    //   0: new 63	java/io/FileOutputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 66	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore 4
    //   10: new 68	java/io/BufferedOutputStream
    //   13: dup
    //   14: aload 4
    //   16: invokespecial 71	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   19: astore 5
    //   21: ldc 73
    //   23: aload_2
    //   24: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +9 -> 36
    //   30: bipush 80
    //   32: istore_3
    //   33: goto +18 -> 51
    //   36: ldc 81
    //   38: aload_2
    //   39: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifeq +121 -> 163
    //   45: bipush 60
    //   47: istore_3
    //   48: goto +3 -> 51
    //   51: aload_0
    //   52: getstatic 87	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   55: bipush 100
    //   57: iload_3
    //   58: invokestatic 93	java/lang/Math:min	(II)I
    //   61: aload 5
    //   63: invokevirtual 99	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   66: pop
    //   67: aload 5
    //   69: invokevirtual 103	java/io/BufferedOutputStream:flush	()V
    //   72: aload_1
    //   73: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   76: aload_1
    //   77: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: getstatic 112	com/tencent/mobileqq/microapp/widget/media/MiniAppCamera:h	I
    //   83: getstatic 114	com/tencent/mobileqq/microapp/widget/media/MiniAppCamera:i	I
    //   86: iload_3
    //   87: invokestatic 119	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   90: astore_0
    //   91: aload 5
    //   93: invokevirtual 122	java/io/BufferedOutputStream:close	()V
    //   96: aload 4
    //   98: invokevirtual 123	java/io/FileOutputStream:close	()V
    //   101: aload_0
    //   102: areturn
    //   103: astore_0
    //   104: aload 4
    //   106: astore_2
    //   107: aload 5
    //   109: astore_1
    //   110: goto +17 -> 127
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_1
    //   116: aload 4
    //   118: astore_2
    //   119: goto +8 -> 127
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_2
    //   125: aload_2
    //   126: astore_1
    //   127: aload_1
    //   128: ifnull +10 -> 138
    //   131: aload_1
    //   132: invokevirtual 122	java/io/BufferedOutputStream:close	()V
    //   135: goto +3 -> 138
    //   138: aload_2
    //   139: ifnull +7 -> 146
    //   142: aload_2
    //   143: invokevirtual 123	java/io/FileOutputStream:close	()V
    //   146: aload_0
    //   147: athrow
    //   148: astore_1
    //   149: goto -53 -> 96
    //   152: astore_1
    //   153: aload_0
    //   154: areturn
    //   155: astore_1
    //   156: goto -18 -> 138
    //   159: astore_1
    //   160: goto -14 -> 146
    //   163: bipush 100
    //   165: istore_3
    //   166: goto -115 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramBitmap	android.graphics.Bitmap
    //   0	169	1	paramFile	File
    //   0	169	2	paramString	String
    //   32	134	3	i	int
    //   8	109	4	localFileOutputStream	java.io.FileOutputStream
    //   19	89	5	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   21	30	103	finally
    //   36	45	103	finally
    //   51	91	103	finally
    //   10	21	113	finally
    //   0	10	122	finally
    //   91	96	148	java/lang/Exception
    //   96	101	152	java/lang/Exception
    //   131	135	155	java/lang/Exception
    //   142	146	159	java/lang/Exception
  }
  
  /* Error */
  private static android.graphics.Bitmap c(String paramString)
  {
    // Byte code:
    //   0: new 132	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 134	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: aload 6
    //   14: astore 5
    //   16: aload 7
    //   18: aload_0
    //   19: invokevirtual 138	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   22: aload 6
    //   24: astore 5
    //   26: aload 7
    //   28: ldc2_w 139
    //   31: iconst_2
    //   32: invokevirtual 144	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   35: astore 6
    //   37: aload 6
    //   39: astore_0
    //   40: aload 6
    //   42: ifnull +81 -> 123
    //   45: aload 6
    //   47: astore 5
    //   49: aload 6
    //   51: invokevirtual 148	android/graphics/Bitmap:getWidth	()I
    //   54: istore_2
    //   55: aload 6
    //   57: astore 5
    //   59: aload 6
    //   61: invokevirtual 151	android/graphics/Bitmap:getHeight	()I
    //   64: istore_3
    //   65: aload 6
    //   67: astore 5
    //   69: iload_2
    //   70: iload_3
    //   71: invokestatic 154	java/lang/Math:max	(II)I
    //   74: istore 4
    //   76: aload 6
    //   78: astore_0
    //   79: iload 4
    //   81: sipush 512
    //   84: if_icmple +39 -> 123
    //   87: aload 6
    //   89: astore 5
    //   91: ldc 155
    //   93: iload 4
    //   95: i2f
    //   96: fdiv
    //   97: fstore_1
    //   98: aload 6
    //   100: astore 5
    //   102: aload 6
    //   104: iload_2
    //   105: i2f
    //   106: fload_1
    //   107: fmul
    //   108: invokestatic 159	java/lang/Math:round	(F)I
    //   111: fload_1
    //   112: iload_3
    //   113: i2f
    //   114: fmul
    //   115: invokestatic 159	java/lang/Math:round	(F)I
    //   118: iconst_1
    //   119: invokestatic 163	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   122: astore_0
    //   123: aload_0
    //   124: astore 6
    //   126: aload 7
    //   128: invokevirtual 166	android/media/MediaMetadataRetriever:release	()V
    //   131: aload_0
    //   132: areturn
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 169	java/lang/RuntimeException:printStackTrace	()V
    //   138: aload 6
    //   140: areturn
    //   141: astore_0
    //   142: goto +20 -> 162
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 170	java/lang/Throwable:printStackTrace	()V
    //   150: aload 5
    //   152: astore 6
    //   154: aload 7
    //   156: invokevirtual 166	android/media/MediaMetadataRetriever:release	()V
    //   159: aload 5
    //   161: areturn
    //   162: aload 7
    //   164: invokevirtual 166	android/media/MediaMetadataRetriever:release	()V
    //   167: goto +10 -> 177
    //   170: astore 5
    //   172: aload 5
    //   174: invokevirtual 169	java/lang/RuntimeException:printStackTrace	()V
    //   177: aload_0
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramString	String
    //   97	15	1	f	float
    //   54	51	2	i	int
    //   64	49	3	j	int
    //   74	20	4	k	int
    //   14	146	5	localObject1	java.lang.Object
    //   170	3	5	localRuntimeException	java.lang.RuntimeException
    //   10	143	6	localObject2	java.lang.Object
    //   7	156	7	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   126	131	133	java/lang/RuntimeException
    //   154	159	133	java/lang/RuntimeException
    //   16	22	141	finally
    //   26	37	141	finally
    //   49	55	141	finally
    //   59	65	141	finally
    //   69	76	141	finally
    //   91	98	141	finally
    //   102	123	141	finally
    //   146	150	141	finally
    //   16	22	145	java/lang/Throwable
    //   26	37	145	java/lang/Throwable
    //   49	55	145	java/lang/Throwable
    //   59	65	145	java/lang/Throwable
    //   69	76	145	java/lang/Throwable
    //   91	98	145	java/lang/Throwable
    //   102	123	145	java/lang/Throwable
    //   162	167	170	java/lang/RuntimeException
  }
  
  public void a(WebviewContainer paramWebviewContainer, String paramString, int paramInt)
  {
    if (n) {
      return;
    }
    try
    {
      if (m == null) {
        m = new MediaRecorder();
      }
      m.setCamera(a);
      m.setPreviewDisplay(getHolder().getSurface());
      m.setOnErrorListener(new f(this));
      m.setOnInfoListener(new g(this, paramWebviewContainer, paramString, paramInt));
      m.setVideoSource(1);
      m.setAudioSource(0);
      m.setOutputFormat(2);
      m.setMaxDuration(3000);
      m.setVideoEncoder(2);
      m.setAudioEncoder(0);
      CamcorderProfile localCamcorderProfile = CamcorderProfile.get(1);
      if (localCamcorderProfile != null) {
        m.setProfile(localCamcorderProfile);
      }
      o = b.a().a("mp4");
      new File(o).getParentFile().mkdirs();
      m.setOutputFile(o);
      a.unlock();
      m.prepare();
      m.start();
      n = true;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramWebviewContainer.callbackJsEventFail(paramString, null, paramInt);
    }
  }
  
  public void a(WebviewContainer paramWebviewContainer, String paramString1, int paramInt, String paramString2)
  {
    try
    {
      a.takePicture(null, null, new d(this, paramString2, paramString1, paramWebviewContainer, paramInt));
      return;
    }
    catch (Exception paramString2)
    {
      paramWebviewContainer.callbackJsEventFail(paramString1, null, paramInt);
      paramString2.printStackTrace();
    }
  }
  
  public void b(WebviewContainer paramWebviewContainer, String paramString, int paramInt)
  {
    ThreadManagerV2.excute(new h(this, paramString, paramWebviewContainer, paramInt), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.MiniAppCamera
 * JD-Core Version:    0.7.0.1
 */