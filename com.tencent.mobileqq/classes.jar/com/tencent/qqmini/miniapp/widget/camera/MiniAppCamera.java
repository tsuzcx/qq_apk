package com.tencent.qqmini.miniapp.widget.camera;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.tencent.qqmini.miniapp.util.CameraCompatibleList;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;
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
  public static int cameraWidth;
  private static volatile boolean isRecordStart;
  private static final ExecutorService mExecutor = ;
  private static int recordCallBackId;
  private static MediaRecorder recorder;
  private static WeakReference<IJsService> sRecordJsService;
  private static String videoPath;
  private int cameraId;
  private CameraCallBack mCallback;
  protected WeakReference<IJsService> mJsService;
  private WeakReference<IMiniAppContext> mMiniAppContext;
  private int mWebviewId;
  private ToastView toastView;
  
  static
  {
    cameraWidth = 320;
  }
  
  public MiniAppCamera(IMiniAppContext paramIMiniAppContext, IJsService paramIJsService)
  {
    super(paramIMiniAppContext.getContext());
    this.mMiniAppContext = new WeakReference(paramIMiniAppContext);
    this.mJsService = new WeakReference(paramIJsService);
    Log.i("MiniAppCamera", "MiniAppCamera: " + Build.BRAND + " " + Build.MODEL);
  }
  
  private void execCommand(String paramString1, String paramString2, String paramString3, RequestEvent paramRequestEvent)
  {
    showLoading("正在处理");
    paramString1 = paramString1.split(" ");
    mExecutor.execute(new MiniAppCamera.7(this, paramString2, paramString1, paramRequestEvent, paramString3));
  }
  
  private float getDegrees()
  {
    float f = 90.0F;
    if (CameraCompatibleList.isFoundProduct(CameraCompatibleList.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL))
    {
      if (this.isBackCameraNow) {
        return 270.0F;
      }
      return 90.0F;
    }
    if (this.isBackCameraNow) {}
    for (;;)
    {
      return f;
      f = 270.0F;
    }
  }
  
  private static Bitmap getFirstKeyFrame(String paramString)
  {
    return ThumbnailUtils.createVideoThumbnail(paramString, 1);
  }
  
  private float getQuScale(String paramString)
  {
    float f = 1.0F;
    if ("normal".equals(paramString)) {
      f = 0.8F;
    }
    while (!"low".equals(paramString)) {
      return f;
    }
    return 0.6F;
  }
  
  private void hideLoading()
  {
    AppBrandTask.runTaskOnUiThread(new MiniAppCamera.9(this));
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
      videoPath = getTmpPath("mp4");
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
  
  private void postProcessPhoto(byte[] paramArrayOfByte, boolean paramBoolean, String paramString, MiniAppCamera.GetPhotoCallback paramGetPhotoCallback)
  {
    ThreadManager.executeOnDiskIOThreadPool(new MiniAppCamera.3(this, paramArrayOfByte, paramBoolean, paramString, paramGetPhotoCallback));
  }
  
  private void reportRecordAns(String paramString, RequestEvent paramRequestEvent)
  {
    Log.i("MiniAppCamera", "reportRecordAns: " + paramString);
    ThreadManager.executeOnComputationThreadPool(new MiniAppCamera.6(this, paramString, paramRequestEvent));
  }
  
  /* Error */
  private static String saveJpeg(Bitmap paramBitmap, File paramFile, String paramString)
  {
    // Byte code:
    //   0: bipush 100
    //   2: istore_3
    //   3: new 382	java/io/BufferedOutputStream
    //   6: dup
    //   7: new 384	java/io/FileOutputStream
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 387	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   15: invokespecial 390	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 5
    //   20: ldc 206
    //   22: aload_2
    //   23: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +58 -> 84
    //   29: bipush 80
    //   31: istore_3
    //   32: aload_0
    //   33: getstatic 396	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   36: bipush 100
    //   38: iload_3
    //   39: invokestatic 402	java/lang/Math:min	(II)I
    //   42: aload 5
    //   44: invokevirtual 408	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   47: pop
    //   48: aload 5
    //   50: invokevirtual 411	java/io/BufferedOutputStream:flush	()V
    //   53: aload_1
    //   54: invokevirtual 416	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   57: aload_1
    //   58: invokevirtual 416	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   61: getstatic 52	com/tencent/qqmini/miniapp/widget/camera/MiniAppCamera:cameraWidth	I
    //   64: getstatic 54	com/tencent/qqmini/miniapp/widget/camera/MiniAppCamera:cameraHeight	I
    //   67: iload_3
    //   68: invokestatic 422	com/tencent/qqmini/sdk/core/utils/ImageUtil:compressImageJpg	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   71: astore_0
    //   72: aload 5
    //   74: ifnull +8 -> 82
    //   77: aload 5
    //   79: invokevirtual 425	java/io/BufferedOutputStream:close	()V
    //   82: aload_0
    //   83: areturn
    //   84: ldc 213
    //   86: aload_2
    //   87: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   111: invokevirtual 425	java/io/BufferedOutputStream:close	()V
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
  
  private String saveVideoThumbImg(String paramString)
  {
    Object localObject = new File(paramString);
    if (((File)localObject).length() == 0L) {}
    do
    {
      return null;
      Log.i("MiniAppCamera", "saveVideoThumbImg: " + ((File)localObject).length());
      paramString = getTmpPath("jpg");
      localObject = getFirstKeyFrame(((File)localObject).getAbsolutePath());
    } while (localObject == null);
    saveJpeg((Bitmap)localObject, new File(paramString), "");
    Log.i("MiniAppCamera", "saveVideoThumbImg: " + paramString);
    return paramString;
  }
  
  private void setupCamera(String paramString)
  {
    if (("front".equals(paramString)) && (this.frontCameraId != null))
    {
      setupCamera(this.frontCameraId.intValue());
      return;
    }
    if (("back".equals(paramString)) && (this.backCameraId != null))
    {
      setupCamera(this.backCameraId.intValue());
      return;
    }
    if (this.backCameraId == null) {}
    for (paramString = this.frontCameraId;; paramString = this.backCameraId)
    {
      setupCamera(paramString.intValue());
      return;
    }
  }
  
  private void showLoading(String paramString)
  {
    AppBrandTask.runTaskOnUiThread(new MiniAppCamera.8(this, paramString));
  }
  
  private void startCrop(String paramString, RequestEvent paramRequestEvent)
  {
    int m = 0;
    String str = getTmpPath("mp4");
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
      Log.i("MiniAppCamera", "startCrop: " + paramString);
      execCommand("-y -i " + paramString + " -strict -2 -vcodec libx264 -preset ultrafast -vf crop=" + j + ":" + i + ":" + m + ":" + k + " " + str, str, paramString, paramRequestEvent);
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
  
  public String getTmpPath(String paramString)
  {
    IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.mMiniAppContext.get();
    if (localIMiniAppContext != null) {
      return ((MiniAppFileManager)localIMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(paramString);
    }
    return "";
  }
  
  public String getWxFilePath(String paramString)
  {
    IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.mMiniAppContext.get();
    if (localIMiniAppContext != null) {
      return ((MiniAppFileManager)localIMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(paramString);
    }
    return "";
  }
  
  protected void onCodeRead(String paramString)
  {
    super.onCodeRead(paramString);
    if (!this.isScanMode) {}
    IJsService localIJsService;
    do
    {
      return;
      localIJsService = (IJsService)this.mJsService.get();
    } while (localIJsService == null);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramString);
      localJSONObject.put("type", "barcode");
      localJSONObject.put("cameraId", this.cameraId);
      localIJsService.evaluateSubscribeJS("onCameraScanCode", localJSONObject.toString(), this.mWebviewId);
      QMLog.i("MiniAppCamera", "onCodeRead, result = " + localJSONObject + ", webviewId = " + this.mWebviewId);
      return;
    }
    catch (JSONException paramString)
    {
      Log.w("MiniAppCamera", "onCodeRead: ", paramString);
    }
  }
  
  public void openCamera(String paramString)
  {
    if ((this.frontCameraId == null) && (this.backCameraId == null)) {
      if (this.mCallback != null) {
        this.mCallback.onStartPreview(false);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          setupCamera(paramString);
          setCameraSize(this.cameraSize);
          startPreview();
          if (this.mCallback != null)
          {
            this.mCallback.onStartPreview(true);
            return;
          }
        }
        catch (Exception paramString)
        {
          Log.w("MiniAppCamera", "openCamera: ", paramString);
        }
      }
    } while (this.mCallback == null);
    this.mCallback.onStartPreview(false);
  }
  
  public void setCameraId(int paramInt)
  {
    this.cameraId = paramInt;
  }
  
  public void setCameraSurfaceCallBack(CameraCallBack paramCameraCallBack)
  {
    this.mCallback = paramCameraCallBack;
  }
  
  public void setWebviewId(int paramInt)
  {
    this.mWebviewId = paramInt;
  }
  
  public void startPreview()
  {
    super.startPreview();
  }
  
  public void startRecord(RequestEvent paramRequestEvent)
  {
    if (isRecordStart) {
      return;
    }
    isRecordStart = true;
    sRecordJsService = new WeakReference(paramRequestEvent.jsService);
    recordCallBackId = paramRequestEvent.callbackId;
    recorder = new MediaRecorder();
    recorder.setOnErrorListener(new MiniAppCamera.4(this, paramRequestEvent));
    recorder.setOnInfoListener(new MiniAppCamera.5(this, paramRequestEvent));
    try
    {
      nativeStartRecord();
      return;
    }
    catch (Exception localException)
    {
      Log.w("MiniAppCamera", "startRecord: ", localException);
      paramRequestEvent.fail();
      isRecordStart = false;
    }
    try
    {
      recorder.reset();
      recorder.release();
      recorder = null;
      return;
    }
    catch (Exception paramRequestEvent)
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
    IJsService localIJsService;
    if (isRecordStart)
    {
      isRecordStart = false;
      localIJsService = (IJsService)sRecordJsService.get();
      if (localIJsService != null)
      {
        localObject = ApiUtil.wrapCallbackFail("operateCamera", null);
        if (localObject == null) {
          break label83;
        }
      }
    }
    label83:
    for (Object localObject = ((JSONObject)localObject).toString();; localObject = "")
    {
      localIJsService.evaluateCallbackJs(recordCallBackId, (String)localObject);
      sRecordJsService.clear();
      nativeStopRecord();
      stopPreview();
      if (paramBoolean) {
        releaseCamera();
      }
      return;
    }
  }
  
  public void stopRecord(RequestEvent paramRequestEvent)
  {
    Log.i("MiniAppCamera", "stopRecord: " + isRecordStart + " " + isMainThread());
    if (!isRecordStart) {
      return;
    }
    isRecordStart = false;
    nativeStopRecord();
    if (this.cameraSize.width * getWidth() == this.cameraSize.height * getHeight())
    {
      reportRecordAns(videoPath, paramRequestEvent);
      return;
    }
    startCrop(videoPath, paramRequestEvent);
  }
  
  public void switchCamera(boolean paramBoolean, String paramString)
  {
    Log.i("MiniAppCamera", "switchCamera: ");
    setFlashMode(paramString);
    if ((this.frontCameraId == null) || (this.backCameraId == null) || (paramBoolean == this.isBackCameraNow))
    {
      updateFlashMode();
      return;
    }
    ThreadManager.executeOnComputationThreadPool(new MiniAppCamera.10(this, paramBoolean));
  }
  
  public void takePhoto(RequestEvent paramRequestEvent, String paramString)
  {
    nativeTakePhoto(paramString, true, new MiniAppCamera.1(this, paramRequestEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera
 * JD-Core Version:    0.7.0.1
 */