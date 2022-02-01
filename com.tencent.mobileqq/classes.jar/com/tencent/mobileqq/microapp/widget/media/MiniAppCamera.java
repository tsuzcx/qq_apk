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
    if (paramString != null) {}
    for (paramString = paramString.toString();; paramString = "")
    {
      paramWebviewContainer.appBrandRuntime.i.evaluateCallbackJs(paramInt, paramString);
      return;
    }
  }
  
  /* Error */
  private static String b(android.graphics.Bitmap paramBitmap, File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: bipush 100
    //   5: istore_3
    //   6: new 63	java/io/FileOutputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 66	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   14: astore 5
    //   16: new 68	java/io/BufferedOutputStream
    //   19: dup
    //   20: aload 5
    //   22: invokespecial 71	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore 6
    //   27: ldc 73
    //   29: aload_2
    //   30: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +68 -> 101
    //   36: bipush 80
    //   38: istore_3
    //   39: aload_0
    //   40: getstatic 85	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   43: bipush 100
    //   45: iload_3
    //   46: invokestatic 91	java/lang/Math:min	(II)I
    //   49: aload 6
    //   51: invokevirtual 97	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   54: pop
    //   55: aload 6
    //   57: invokevirtual 101	java/io/BufferedOutputStream:flush	()V
    //   60: aload_1
    //   61: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   64: aload_1
    //   65: invokevirtual 106	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: getstatic 110	com/tencent/mobileqq/microapp/widget/media/MiniAppCamera:h	I
    //   71: getstatic 112	com/tencent/mobileqq/microapp/widget/media/MiniAppCamera:i	I
    //   74: iload_3
    //   75: invokestatic 117	bfvo:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   78: astore_0
    //   79: aload 6
    //   81: ifnull +8 -> 89
    //   84: aload 6
    //   86: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   89: aload 5
    //   91: ifnull +8 -> 99
    //   94: aload 5
    //   96: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   99: aload_0
    //   100: areturn
    //   101: ldc 123
    //   103: aload_2
    //   104: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: istore 4
    //   109: iload 4
    //   111: ifeq -72 -> 39
    //   114: bipush 60
    //   116: istore_3
    //   117: goto -78 -> 39
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_1
    //   123: aload 6
    //   125: astore_2
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   134: aload_2
    //   135: ifnull +7 -> 142
    //   138: aload_2
    //   139: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   142: aload_0
    //   143: athrow
    //   144: astore_1
    //   145: goto -56 -> 89
    //   148: astore_1
    //   149: aload_0
    //   150: areturn
    //   151: astore_1
    //   152: goto -18 -> 134
    //   155: astore_1
    //   156: goto -14 -> 142
    //   159: astore_0
    //   160: aconst_null
    //   161: astore_1
    //   162: aload 5
    //   164: astore_2
    //   165: goto -39 -> 126
    //   168: astore_0
    //   169: aload 5
    //   171: astore_2
    //   172: aload 6
    //   174: astore_1
    //   175: goto -49 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramBitmap	android.graphics.Bitmap
    //   0	178	1	paramFile	File
    //   0	178	2	paramString	String
    //   5	112	3	i	int
    //   107	3	4	bool	boolean
    //   14	156	5	localFileOutputStream	java.io.FileOutputStream
    //   1	172	6	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   6	16	120	finally
    //   84	89	144	java/lang/Exception
    //   94	99	148	java/lang/Exception
    //   130	134	151	java/lang/Exception
    //   138	142	155	java/lang/Exception
    //   16	27	159	finally
    //   27	36	168	finally
    //   39	79	168	finally
    //   101	109	168	finally
  }
  
  /* Error */
  private static android.graphics.Bitmap c(String paramString)
  {
    // Byte code:
    //   0: new 132	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 134	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_0
    //   12: invokevirtual 138	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   15: aload 6
    //   17: ldc2_w 139
    //   20: iconst_2
    //   21: invokevirtual 144	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +123 -> 149
    //   29: aload_0
    //   30: invokevirtual 148	android/graphics/Bitmap:getWidth	()I
    //   33: istore_2
    //   34: aload_0
    //   35: invokevirtual 151	android/graphics/Bitmap:getHeight	()I
    //   38: istore_3
    //   39: iload_2
    //   40: iload_3
    //   41: invokestatic 154	java/lang/Math:max	(II)I
    //   44: istore 4
    //   46: iload 4
    //   48: sipush 512
    //   51: if_icmple +98 -> 149
    //   54: ldc 155
    //   56: iload 4
    //   58: i2f
    //   59: fdiv
    //   60: fstore_1
    //   61: aload_0
    //   62: iload_2
    //   63: i2f
    //   64: fload_1
    //   65: fmul
    //   66: invokestatic 159	java/lang/Math:round	(F)I
    //   69: iload_3
    //   70: i2f
    //   71: fload_1
    //   72: fmul
    //   73: invokestatic 159	java/lang/Math:round	(F)I
    //   76: iconst_1
    //   77: invokestatic 163	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   80: astore 5
    //   82: aload 5
    //   84: astore_0
    //   85: aload 6
    //   87: invokevirtual 166	android/media/MediaMetadataRetriever:release	()V
    //   90: aload_0
    //   91: areturn
    //   92: astore 5
    //   94: aload 5
    //   96: invokevirtual 169	java/lang/RuntimeException:printStackTrace	()V
    //   99: aload_0
    //   100: areturn
    //   101: astore 5
    //   103: aconst_null
    //   104: astore_0
    //   105: aload 5
    //   107: invokevirtual 170	java/lang/Throwable:printStackTrace	()V
    //   110: aload 6
    //   112: invokevirtual 166	android/media/MediaMetadataRetriever:release	()V
    //   115: aload_0
    //   116: areturn
    //   117: astore 5
    //   119: aload 5
    //   121: invokevirtual 169	java/lang/RuntimeException:printStackTrace	()V
    //   124: aload_0
    //   125: areturn
    //   126: astore_0
    //   127: aload 6
    //   129: invokevirtual 166	android/media/MediaMetadataRetriever:release	()V
    //   132: aload_0
    //   133: athrow
    //   134: astore 5
    //   136: aload 5
    //   138: invokevirtual 169	java/lang/RuntimeException:printStackTrace	()V
    //   141: goto -9 -> 132
    //   144: astore 5
    //   146: goto -41 -> 105
    //   149: goto -64 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramString	String
    //   60	12	1	f	float
    //   33	30	2	i	int
    //   38	32	3	j	int
    //   44	13	4	k	int
    //   80	3	5	localBitmap	android.graphics.Bitmap
    //   92	3	5	localRuntimeException1	java.lang.RuntimeException
    //   101	5	5	localThrowable1	java.lang.Throwable
    //   117	3	5	localRuntimeException2	java.lang.RuntimeException
    //   134	3	5	localRuntimeException3	java.lang.RuntimeException
    //   144	1	5	localThrowable2	java.lang.Throwable
    //   7	121	6	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   85	90	92	java/lang/RuntimeException
    //   9	25	101	java/lang/Throwable
    //   110	115	117	java/lang/RuntimeException
    //   9	25	126	finally
    //   29	46	126	finally
    //   54	82	126	finally
    //   105	110	126	finally
    //   127	132	134	java/lang/RuntimeException
    //   29	46	144	java/lang/Throwable
    //   54	82	144	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.MiniAppCamera
 * JD-Core Version:    0.7.0.1
 */