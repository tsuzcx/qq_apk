package com.tencent.qqmini.sdk.runtime.widget.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import bglu;
import bgnt;
import bgok;
import bgop;
import bhke;
import bhkg;
import bhkh;
import bhki;
import bhkj;
import bhkk;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
public class MiniAppCamera
  extends GlCameraHolderSurfaceView
{
  public static int a;
  private static MediaRecorder jdField_a_of_type_AndroidMediaMediaRecorder;
  private static String jdField_a_of_type_JavaLangString;
  private static final ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  public static int b;
  private static WeakReference<bglu> b;
  private static volatile boolean jdField_d_of_type_Boolean;
  private static int e;
  private bhke jdField_a_of_type_Bhke;
  protected WeakReference<bglu> a;
  private int c;
  private int jdField_d_of_type_Int;
  
  static
  {
    jdField_a_of_type_Int = 320;
    jdField_b_of_type_Int = 240;
  }
  
  public MiniAppCamera(Context paramContext, bglu parambglu)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambglu);
    Log.i("MiniAppCamera", "MiniAppCamera: " + Build.BRAND + " " + Build.MODEL);
  }
  
  private static Bitmap a(String paramString)
  {
    return ThumbnailUtils.createVideoThumbnail(paramString, 1);
  }
  
  private String a(String paramString)
  {
    Object localObject = new File(paramString);
    if (((File)localObject).length() == 0L) {}
    do
    {
      return null;
      Log.i("MiniAppCamera", "saveVideoThumbImg: " + ((File)localObject).length());
      paramString = bgnt.a().b("jpg");
      localObject = a(((File)localObject).getAbsolutePath());
    } while (localObject == null);
    b((Bitmap)localObject, new File(paramString), "");
    Log.i("MiniAppCamera", "saveVideoThumbImg: " + paramString);
    return paramString;
  }
  
  private void a(String paramString, bgok parambgok)
  {
    Log.i("MiniAppCamera", "reportRecordAns: " + paramString);
    ThreadManager.a(new MiniAppCamera.5(this, paramString, parambgok), 16, null, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, bgok parambgok) {}
  
  private void a(String paramString, boolean paramBoolean, bhkk parambhkk)
  {
    if (parambhkk == null) {
      return;
    }
    Log.i("MiniAppCamera", "nativeTakePhoto: ");
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.takePicture(null, null, new bhkh(this, paramBoolean, paramString, parambhkk));
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MiniAppCamera", "nativeTakePhoto: ", paramString);
      parambhkk.a(null);
    }
  }
  
  private boolean a()
  {
    return Thread.currentThread() == Looper.getMainLooper().getThread();
  }
  
  /* Error */
  private static String b(Bitmap paramBitmap, File paramFile, String paramString)
  {
    // Byte code:
    //   0: bipush 100
    //   2: istore_3
    //   3: new 185	java/io/BufferedOutputStream
    //   6: dup
    //   7: new 187	java/io/FileOutputStream
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 190	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   15: invokespecial 193	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 5
    //   20: ldc 195
    //   22: aload_2
    //   23: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +58 -> 84
    //   29: bipush 80
    //   31: istore_3
    //   32: aload_0
    //   33: getstatic 207	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   36: bipush 100
    //   38: iload_3
    //   39: invokestatic 213	java/lang/Math:min	(II)I
    //   42: aload 5
    //   44: invokevirtual 219	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   47: pop
    //   48: aload 5
    //   50: invokevirtual 222	java/io/BufferedOutputStream:flush	()V
    //   53: aload_1
    //   54: invokevirtual 119	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   57: aload_1
    //   58: invokevirtual 119	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   61: getstatic 24	com/tencent/qqmini/sdk/runtime/widget/camera/MiniAppCamera:jdField_a_of_type_Int	I
    //   64: getstatic 26	com/tencent/qqmini/sdk/runtime/widget/camera/MiniAppCamera:jdField_b_of_type_Int	I
    //   67: iload_3
    //   68: invokestatic 227	bgpe:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   71: astore_0
    //   72: aload 5
    //   74: ifnull +8 -> 82
    //   77: aload 5
    //   79: invokevirtual 230	java/io/BufferedOutputStream:close	()V
    //   82: aload_0
    //   83: areturn
    //   84: ldc 232
    //   86: aload_2
    //   87: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: istore 4
    //   92: iload 4
    //   94: ifeq -62 -> 32
    //   97: bipush 60
    //   99: istore_3
    //   100: goto -68 -> 32
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 230	java/io/BufferedOutputStream:close	()V
    //   114: aload_0
    //   115: athrow
    //   116: astore_1
    //   117: aload_0
    //   118: areturn
    //   119: astore_1
    //   120: goto -6 -> 114
    //   123: astore_0
    //   124: aload 5
    //   126: astore_1
    //   127: goto -21 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramBitmap	Bitmap
    //   0	130	1	paramFile	File
    //   0	130	2	paramString	String
    //   2	98	3	i	int
    //   90	3	4	bool	boolean
    //   18	107	5	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   3	20	103	finally
    //   77	82	116	java/lang/Exception
    //   110	114	119	java/lang/Exception
    //   20	29	123	finally
    //   32	72	123	finally
    //   84	92	123	finally
  }
  
  private void b(String paramString, bgok parambgok)
  {
    int m = 0;
    String str = bgnt.a().b("mp4");
    int k = getWidth();
    int n = getHeight();
    int j = this.jdField_a_of_type_AndroidHardwareCamera$Size.height;
    int i = this.jdField_a_of_type_AndroidHardwareCamera$Size.width;
    if (i * k > j * n)
    {
      n = n * j / k;
      k = (i - n) / 2;
      i = n;
    }
    for (;;)
    {
      Log.i("MiniAppCamera", "startCrop: " + paramString);
      a("-y -i " + paramString + " -strict -2 -vcodec libx264 -preset ultrafast -vf crop=" + j + ":" + i + ":" + m + ":" + k + " " + str, str, paramString, parambgok);
      return;
      k *= i / n;
      m = (j - k) / 2;
      j = k;
      k = 0;
    }
  }
  
  private void g()
  {
    if (jdField_a_of_type_AndroidMediaMediaRecorder == null) {}
    do
    {
      return;
      jdField_a_of_type_JavaLangString = bgnt.a().b("mp4");
    } while (jdField_a_of_type_JavaLangString == null);
    Log.i("MiniAppCamera", "nativeStartRecord: " + jdField_a_of_type_JavaLangString);
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.unlock();
      MediaRecorder localMediaRecorder = jdField_a_of_type_AndroidMediaMediaRecorder;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 90;
        localMediaRecorder.setOrientationHint(i);
        jdField_a_of_type_AndroidMediaMediaRecorder.reset();
        jdField_a_of_type_AndroidMediaMediaRecorder.setCamera(this.jdField_a_of_type_AndroidHardwareCamera);
        jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSource(0);
        jdField_a_of_type_AndroidMediaMediaRecorder.setVideoSource(1);
        jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFormat(2);
        jdField_a_of_type_AndroidMediaMediaRecorder.setVideoEncoder(2);
        jdField_a_of_type_AndroidMediaMediaRecorder.setAudioEncoder(3);
        if (this.jdField_a_of_type_AndroidHardwareCamera$Size != null) {
          jdField_a_of_type_AndroidMediaMediaRecorder.setVideoSize(this.jdField_a_of_type_AndroidHardwareCamera$Size.width, this.jdField_a_of_type_AndroidHardwareCamera$Size.height);
        }
        jdField_a_of_type_AndroidMediaMediaRecorder.setVideoEncodingBitRate(5242880);
        jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFile(jdField_a_of_type_JavaLangString);
        jdField_a_of_type_AndroidMediaMediaRecorder.prepare();
        jdField_a_of_type_AndroidMediaMediaRecorder.start();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MiniAppCamera", "nativeStartRecord: ", localException);
        continue;
        int i = 270;
      }
    }
  }
  
  private void h()
  {
    if (jdField_a_of_type_AndroidMediaMediaRecorder == null) {
      return;
    }
    try
    {
      jdField_a_of_type_AndroidMediaMediaRecorder.stop();
      jdField_a_of_type_AndroidMediaMediaRecorder.reset();
      jdField_a_of_type_AndroidMediaMediaRecorder.release();
      jdField_a_of_type_AndroidMediaMediaRecorder = null;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.unlock();
        try
        {
          this.jdField_a_of_type_AndroidHardwareCamera.reconnect();
          return;
        }
        catch (Exception localException1)
        {
          Log.w("MiniAppCamera", "stopRecord: ", localException1);
          return;
        }
        localIllegalStateException = localIllegalStateException;
        Log.w("MiniAppCamera", "nativeStopRecord: failed to stop", localIllegalStateException);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.w("MiniAppCamera", "stopRecord: ", localException2);
        }
      }
    }
  }
  
  public void a(bgok parambgok)
  {
    if (jdField_d_of_type_Boolean) {
      return;
    }
    jdField_d_of_type_Boolean = true;
    jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(parambgok.a);
    e = parambgok.jdField_b_of_type_Int;
    jdField_a_of_type_AndroidMediaMediaRecorder = new MediaRecorder();
    jdField_a_of_type_AndroidMediaMediaRecorder.setOnErrorListener(new bhki(this, parambgok));
    jdField_a_of_type_AndroidMediaMediaRecorder.setOnInfoListener(new bhkj(this, parambgok));
    try
    {
      g();
      return;
    }
    catch (Exception localException)
    {
      Log.w("MiniAppCamera", "startRecord: ", localException);
      parambgok.b();
      jdField_d_of_type_Boolean = false;
    }
    try
    {
      jdField_a_of_type_AndroidMediaMediaRecorder.reset();
      jdField_a_of_type_AndroidMediaMediaRecorder.release();
      jdField_a_of_type_AndroidMediaMediaRecorder = null;
      return;
    }
    catch (Exception parambgok)
    {
      for (;;)
      {
        Log.w("MiniAppCamera", "startRecord: ", localException);
      }
    }
  }
  
  public void a(bgok parambgok, String paramString)
  {
    a(paramString, true, new bhkg(this, parambgok));
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaLangInteger == null) && (this.jdField_b_of_type_JavaLangInteger == null))
    {
      if (this.jdField_a_of_type_Bhke != null) {
        this.jdField_a_of_type_Bhke.onStartPreview(false);
      }
      return;
    }
    for (;;)
    {
      try
      {
        if ((!"front".equals(paramString)) || (this.jdField_a_of_type_JavaLangInteger == null)) {
          break label119;
        }
        a(this.jdField_a_of_type_JavaLangInteger.intValue());
        setCameraSize(this.jdField_a_of_type_AndroidHardwareCamera$Size);
        b();
        if (this.jdField_a_of_type_Bhke == null) {
          break;
        }
        this.jdField_a_of_type_Bhke.onStartPreview(true);
        return;
      }
      catch (Exception paramString)
      {
        Log.w("MiniAppCamera", "openCamera: ", paramString);
      }
      if (this.jdField_a_of_type_Bhke == null) {
        break;
      }
      this.jdField_a_of_type_Bhke.onStartPreview(false);
      return;
      label119:
      if ((!"back".equals(paramString)) || (this.jdField_b_of_type_JavaLangInteger == null)) {
        break label150;
      }
      a(this.jdField_b_of_type_JavaLangInteger.intValue());
    }
    label150:
    if (this.jdField_b_of_type_JavaLangInteger == null) {}
    for (paramString = this.jdField_a_of_type_JavaLangInteger;; paramString = this.jdField_b_of_type_JavaLangInteger)
    {
      a(paramString.intValue());
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Log.i("MiniAppCamera", "stopPreview: ");
    bglu localbglu;
    if (jdField_d_of_type_Boolean)
    {
      jdField_d_of_type_Boolean = false;
      localbglu = (bglu)jdField_b_of_type_JavaLangRefWeakReference.get();
      if (localbglu != null)
      {
        localObject = bgop.b("operateCamera", null);
        if (localObject == null) {
          break label83;
        }
      }
    }
    label83:
    for (Object localObject = ((JSONObject)localObject).toString();; localObject = "")
    {
      localbglu.a(e, (String)localObject);
      jdField_b_of_type_JavaLangRefWeakReference.clear();
      h();
      c();
      if (paramBoolean) {
        d();
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Log.i("MiniAppCamera", "switchCamera: ");
    setFlashMode(paramString);
    if ((this.jdField_a_of_type_JavaLangInteger == null) || (this.jdField_b_of_type_JavaLangInteger == null) || (paramBoolean == this.jdField_a_of_type_Boolean))
    {
      e();
      return;
    }
    ThreadManager.a(new MiniAppCamera.6(this, paramBoolean), 16, null, true);
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(bgok parambgok)
  {
    Log.i("MiniAppCamera", "stopRecord: " + jdField_d_of_type_Boolean + " " + a());
    if (!jdField_d_of_type_Boolean) {
      return;
    }
    jdField_d_of_type_Boolean = false;
    h();
    if (this.jdField_a_of_type_AndroidHardwareCamera$Size.width * getWidth() == this.jdField_a_of_type_AndroidHardwareCamera$Size.height * getHeight())
    {
      a(jdField_a_of_type_JavaLangString, parambgok);
      return;
    }
    b(jdField_a_of_type_JavaLangString, parambgok);
  }
  
  public void f()
  {
    if (jdField_a_of_type_AndroidMediaMediaRecorder != null) {}
    try
    {
      jdField_a_of_type_AndroidMediaMediaRecorder.stop();
      jdField_a_of_type_AndroidMediaMediaRecorder.reset();
      jdField_a_of_type_AndroidMediaMediaRecorder.release();
      jdField_a_of_type_AndroidMediaMediaRecorder = null;
      c();
      d();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.w("MiniAppCamera", "nativeStopRecord: failed to stop", localIllegalStateException);
      }
    }
  }
  
  public void setCameraId(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setCameraSurfaceCallBack(bhke parambhke)
  {
    this.jdField_a_of_type_Bhke = parambhke;
  }
  
  public void setWebviewId(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.camera.MiniAppCamera
 * JD-Core Version:    0.7.0.1
 */