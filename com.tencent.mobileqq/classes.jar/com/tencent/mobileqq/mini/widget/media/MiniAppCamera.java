package com.tencent.mobileqq.mini.widget.media;

import amtj;
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
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
public class MiniAppCamera
  extends GlCameraHolderSurfaceView
{
  public static final String DEVICE_POSITION_BACK = "back";
  public static final String DEVICE_POSITION_FRONT = "front";
  private static final String TAG = "MiniAppCamera";
  public static int cameraHeight = 240;
  public static int cameraWidth = 320;
  private static volatile boolean isRecordStart;
  private static final ExecutorService mExecutor = Executors.newSingleThreadExecutor();
  private static int recordCallBackId;
  private static MediaRecorder recorder;
  private static WeakReference<WebviewContainer> sContainer;
  private static String videoPath;
  private int cameraId;
  private volatile FFmpeg ffmpeg;
  private CameraSurfaceView.CameraSurfaceViewCallBack mCallback;
  protected WeakReference<WebviewContainer> mWcRef;
  
  public MiniAppCamera(Context paramContext, WebviewContainer paramWebviewContainer)
  {
    super(paramContext);
    this.mWcRef = new WeakReference(paramWebviewContainer);
    Log.i("MiniAppCamera", "MiniAppCamera: " + Build.BRAND + " " + Build.MODEL);
  }
  
  private void callBackJsError(String paramString, WebviewContainer paramWebviewContainer, int paramInt)
  {
    paramString = ApiUtil.wrapCallbackFail(paramString, null);
    if (paramString != null) {}
    for (paramString = paramString.toString();; paramString = "")
    {
      paramWebviewContainer.appBrandRuntime.serviceRuntime.evaluateCallbackJs(paramInt, paramString);
      return;
    }
  }
  
  private void execCommand(String paramString1, String paramString2, String paramString3, WebviewContainer paramWebviewContainer, String paramString4, int paramInt)
  {
    if (this.ffmpeg == null) {
      this.ffmpeg = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
    }
    paramWebviewContainer.showLoading(amtj.a(2131705903));
    paramString1 = paramString1.split(" ");
    mExecutor.execute(new MiniAppCamera.6(this, paramString2, paramString1, paramWebviewContainer, paramString4, paramInt, paramString3));
  }
  
  private static Bitmap getFirstKeyFrame(String paramString)
  {
    return ThumbnailUtils.createVideoThumbnail(paramString, 1);
  }
  
  private boolean isMainThread()
  {
    return Thread.currentThread() == Looper.getMainLooper().getThread();
  }
  
  private void nativeStartRecord()
  {
    if (recorder == null) {}
    do
    {
      return;
      videoPath = MiniAppFileManager.getInstance().getTmpPath("mp4");
    } while (videoPath == null);
    Log.i("MiniAppCamera", "nativeStartRecord: " + videoPath);
    try
    {
      this.camera.unlock();
      MediaRecorder localMediaRecorder = recorder;
      if (this.isBackCameraNow)
      {
        i = 90;
        localMediaRecorder.setOrientationHint(i);
        recorder.reset();
        recorder.setCamera(this.camera);
        recorder.setAudioSource(0);
        recorder.setVideoSource(1);
        recorder.setOutputFormat(2);
        recorder.setVideoEncoder(2);
        recorder.setAudioEncoder(3);
        if (this.cameraSize != null) {
          recorder.setVideoSize(this.cameraSize.width, this.cameraSize.height);
        }
        recorder.setVideoEncodingBitRate(5242880);
        recorder.setOutputFile(videoPath);
        recorder.prepare();
        recorder.start();
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
  
  private void nativeStopRecord()
  {
    if (recorder == null) {
      return;
    }
    try
    {
      recorder.stop();
      recorder.reset();
      recorder.release();
      recorder = null;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      try
      {
        this.camera.unlock();
        try
        {
          this.camera.reconnect();
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
  
  private void nativeTakePhoto(String paramString, boolean paramBoolean, MiniAppCamera.GetPhotoCallback paramGetPhotoCallback)
  {
    if (paramGetPhotoCallback == null) {
      return;
    }
    Log.i("MiniAppCamera", "nativeTakePhoto: ");
    try
    {
      this.camera.takePicture(null, null, new MiniAppCamera.2(this, paramBoolean, paramString, paramGetPhotoCallback));
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MiniAppCamera", "nativeTakePhoto: ", paramString);
      paramGetPhotoCallback.onGetPhoto(null);
    }
  }
  
  private void reportRecordAns(String paramString1, WebviewContainer paramWebviewContainer, String paramString2, int paramInt)
  {
    Log.i("MiniAppCamera", "reportRecordAns: " + paramString1);
    ThreadManagerV2.excute(new MiniAppCamera.5(this, paramString1, paramString2, paramWebviewContainer, paramInt), 16, null, true);
  }
  
  /* Error */
  private static String saveJpeg(Bitmap paramBitmap, File paramFile, String paramString)
  {
    // Byte code:
    //   0: bipush 100
    //   2: istore_3
    //   3: new 371	java/io/BufferedOutputStream
    //   6: dup
    //   7: new 373	java/io/FileOutputStream
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 376	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   15: invokespecial 379	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 5
    //   20: ldc_w 381
    //   23: aload_2
    //   24: invokevirtual 385	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +58 -> 85
    //   30: bipush 80
    //   32: istore_3
    //   33: aload_0
    //   34: getstatic 391	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   37: bipush 100
    //   39: iload_3
    //   40: invokestatic 397	java/lang/Math:min	(II)I
    //   43: aload 5
    //   45: invokevirtual 403	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   48: pop
    //   49: aload 5
    //   51: invokevirtual 406	java/io/BufferedOutputStream:flush	()V
    //   54: aload_1
    //   55: invokevirtual 411	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   58: aload_1
    //   59: invokevirtual 411	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   62: getstatic 41	com/tencent/mobileqq/mini/widget/media/MiniAppCamera:cameraWidth	I
    //   65: getstatic 43	com/tencent/mobileqq/mini/widget/media/MiniAppCamera:cameraHeight	I
    //   68: iload_3
    //   69: invokestatic 416	bfvo:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   72: astore_0
    //   73: aload 5
    //   75: ifnull +8 -> 83
    //   78: aload 5
    //   80: invokevirtual 419	java/io/BufferedOutputStream:close	()V
    //   83: aload_0
    //   84: areturn
    //   85: ldc_w 421
    //   88: aload_2
    //   89: invokevirtual 385	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: istore 4
    //   94: iload 4
    //   96: ifeq -63 -> 33
    //   99: bipush 60
    //   101: istore_3
    //   102: goto -69 -> 33
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 419	java/io/BufferedOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_1
    //   119: aload_0
    //   120: areturn
    //   121: astore_1
    //   122: goto -6 -> 116
    //   125: astore_0
    //   126: aload 5
    //   128: astore_1
    //   129: goto -21 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramBitmap	Bitmap
    //   0	132	1	paramFile	File
    //   0	132	2	paramString	String
    //   2	100	3	i	int
    //   92	3	4	bool	boolean
    //   18	109	5	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   3	20	105	finally
    //   78	83	118	java/lang/Exception
    //   112	116	121	java/lang/Exception
    //   20	30	125	finally
    //   33	73	125	finally
    //   85	94	125	finally
  }
  
  private String saveVideoThumbImg(String paramString)
  {
    Object localObject = new File(paramString);
    if (((File)localObject).length() == 0L) {}
    do
    {
      return null;
      Log.i("MiniAppCamera", "saveVideoThumbImg: " + ((File)localObject).length());
      paramString = MiniAppFileManager.getInstance().getTmpPath("jpg");
      localObject = getFirstKeyFrame(((File)localObject).getAbsolutePath());
    } while (localObject == null);
    saveJpeg((Bitmap)localObject, new File(paramString), "");
    Log.i("MiniAppCamera", "saveVideoThumbImg: " + paramString);
    return paramString;
  }
  
  private void startCrop(String paramString1, WebviewContainer paramWebviewContainer, String paramString2, int paramInt)
  {
    int m = 0;
    String str = MiniAppFileManager.getInstance().getTmpPath("mp4");
    int k = getWidth();
    int n = getHeight();
    int j = this.cameraSize.height;
    int i = this.cameraSize.width;
    if (i * k > j * n)
    {
      n = n * j / k;
      k = (i - n) / 2;
      i = n;
    }
    for (;;)
    {
      Log.i("MiniAppCamera", "startCrop: " + paramString1);
      execCommand("-y -i " + paramString1 + " -strict -2 -vcodec libx264 -preset ultrafast -vf crop=" + j + ":" + i + ":" + m + ":" + k + " " + str, str, paramString1, paramWebviewContainer, paramString2, paramInt);
      return;
      k *= i / n;
      m = (j - k) / 2;
      j = k;
      k = 0;
    }
  }
  
  public void closeCamera()
  {
    if (recorder != null) {}
    try
    {
      recorder.stop();
      recorder.reset();
      recorder.release();
      recorder = null;
      stopPreview();
      releaseCamera();
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
  
  protected void onCodeRead(String paramString)
  {
    super.onCodeRead(paramString);
    if (!this.isScanMode) {}
    WebviewContainer localWebviewContainer;
    do
    {
      return;
      localWebviewContainer = (WebviewContainer)this.mWcRef.get();
    } while (localWebviewContainer == null);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramString);
      localJSONObject.put("type", "barcode");
      localJSONObject.put("cameraId", this.cameraId);
      localWebviewContainer.appBrandRuntime.serviceRuntime.evaluateSubcribeJS("onCameraScanCode", localJSONObject.toString(), localWebviewContainer.getPageWebview().pageWebviewId);
      return;
    }
    catch (JSONException paramString)
    {
      Log.w("MiniAppCamera", "onCodeRead: ", paramString);
    }
  }
  
  public void openCamera(String paramString)
  {
    if ((this.frontCameraId == null) && (this.backCameraId == null))
    {
      if (this.mCallback != null) {
        this.mCallback.onStartPreview(false);
      }
      return;
    }
    for (;;)
    {
      try
      {
        if ((!"front".equals(paramString)) || (this.frontCameraId == null)) {
          break label118;
        }
        setupCamera(this.frontCameraId.intValue());
        setCameraSize(this.cameraSize);
        startPreview();
        if (this.mCallback == null) {
          break;
        }
        this.mCallback.onStartPreview(true);
        return;
      }
      catch (Exception paramString)
      {
        Log.w("MiniAppCamera", "openCamera: ", paramString);
      }
      if (this.mCallback == null) {
        break;
      }
      this.mCallback.onStartPreview(false);
      return;
      label118:
      if ((!"back".equals(paramString)) || (this.backCameraId == null)) {
        break label148;
      }
      setupCamera(this.backCameraId.intValue());
    }
    label148:
    if (this.backCameraId == null) {}
    for (paramString = this.frontCameraId;; paramString = this.backCameraId)
    {
      setupCamera(paramString.intValue());
      break;
    }
  }
  
  public void setCameraId(int paramInt)
  {
    this.cameraId = paramInt;
  }
  
  public void setCameraSurfaceCallBack(CameraSurfaceView.CameraSurfaceViewCallBack paramCameraSurfaceViewCallBack)
  {
    this.mCallback = paramCameraSurfaceViewCallBack;
  }
  
  public void startPreview()
  {
    super.startPreview();
  }
  
  public void startRecord(WebviewContainer paramWebviewContainer, String paramString, int paramInt)
  {
    if (isRecordStart) {
      return;
    }
    isRecordStart = true;
    sContainer = new WeakReference(paramWebviewContainer);
    recordCallBackId = paramInt;
    recorder = new MediaRecorder();
    recorder.setOnErrorListener(new MiniAppCamera.3(this, paramWebviewContainer, paramString));
    recorder.setOnInfoListener(new MiniAppCamera.4(this, paramWebviewContainer, paramString));
    try
    {
      nativeStartRecord();
      return;
    }
    catch (Exception localException)
    {
      Log.w("MiniAppCamera", "startRecord: ", localException);
      paramWebviewContainer.callbackJsEventFail(paramString, null, recordCallBackId);
      isRecordStart = false;
    }
    try
    {
      recorder.reset();
      recorder.release();
      recorder = null;
      return;
    }
    catch (Exception paramWebviewContainer)
    {
      for (;;)
      {
        Log.w("MiniAppCamera", "startRecord: ", localException);
      }
    }
  }
  
  public void stopPreview(boolean paramBoolean)
  {
    Log.i("MiniAppCamera", "stopPreview: ");
    if (isRecordStart)
    {
      isRecordStart = false;
      WebviewContainer localWebviewContainer = (WebviewContainer)sContainer.get();
      if (localWebviewContainer != null) {
        localWebviewContainer.callbackJsEventFail("operateCamera", null, recordCallBackId);
      }
      sContainer.clear();
      nativeStopRecord();
    }
    stopPreview();
    if (paramBoolean) {
      releaseCamera();
    }
  }
  
  public void stopRecord(WebviewContainer paramWebviewContainer, String paramString, int paramInt)
  {
    Log.i("MiniAppCamera", "stopRecord: " + isRecordStart + " " + isMainThread());
    if (!isRecordStart) {
      return;
    }
    isRecordStart = false;
    nativeStopRecord();
    if (this.cameraSize.width * getWidth() == this.cameraSize.height * getHeight())
    {
      reportRecordAns(videoPath, paramWebviewContainer, paramString, paramInt);
      return;
    }
    startCrop(videoPath, paramWebviewContainer, paramString, paramInt);
  }
  
  public void switchCamera(WebviewContainer paramWebviewContainer, boolean paramBoolean, String paramString)
  {
    Log.i("MiniAppCamera", "switchCamera: ");
    setFlashMode(paramString);
    if ((this.frontCameraId == null) || (this.backCameraId == null) || (paramBoolean == this.isBackCameraNow))
    {
      updateFlashMode();
      return;
    }
    ThreadManagerV2.excute(new MiniAppCamera.7(this, paramBoolean), 16, null, true);
  }
  
  public void takePhoto(WebviewContainer paramWebviewContainer, String paramString1, int paramInt, String paramString2)
  {
    nativeTakePhoto(paramString2, true, new MiniAppCamera.1(this, paramString1, paramWebviewContainer, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppCamera
 * JD-Core Version:    0.7.0.1
 */