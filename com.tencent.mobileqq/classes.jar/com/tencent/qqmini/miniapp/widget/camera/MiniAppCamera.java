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
    paramIMiniAppContext = new StringBuilder();
    paramIMiniAppContext.append("MiniAppCamera: ");
    paramIMiniAppContext.append(Build.BRAND);
    paramIMiniAppContext.append(" ");
    paramIMiniAppContext.append(Build.MODEL);
    Log.i("MiniAppCamera", paramIMiniAppContext.toString());
  }
  
  private void execCommand(String paramString1, String paramString2, String paramString3, RequestEvent paramRequestEvent)
  {
    showLoading("正在处理");
    paramString1 = paramString1.split(" ");
    mExecutor.execute(new MiniAppCamera.7(this, paramString2, paramString1, paramRequestEvent, paramString3));
  }
  
  private float getDegrees()
  {
    if (CameraCompatibleList.isFoundProduct(CameraCompatibleList.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL))
    {
      if (!this.isBackCameraNow) {}
    }
    else {
      while (!this.isBackCameraNow) {
        return 270.0F;
      }
    }
    return 90.0F;
  }
  
  private static Bitmap getFirstKeyFrame(String paramString)
  {
    return ThumbnailUtils.createVideoThumbnail(paramString, 1);
  }
  
  private float getQuScale(String paramString)
  {
    if ("normal".equals(paramString)) {
      return 0.8F;
    }
    if ("low".equals(paramString)) {
      return 0.6F;
    }
    return 1.0F;
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
    if (recorder == null) {
      return;
    }
    videoPath = getTmpPath("mp4");
    if (videoPath == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nativeStartRecord: ");
    localStringBuilder.append(videoPath);
    Log.i("MiniAppCamera", localStringBuilder.toString());
    try
    {
      this.camera.unlock();
    }
    catch (Exception localException)
    {
      Log.i("MiniAppCamera", "nativeStartRecord: ", localException);
    }
    MediaRecorder localMediaRecorder = recorder;
    int i;
    if (this.isBackCameraNow) {
      i = 90;
    } else {
      i = 270;
    }
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
  }
  
  private void nativeStopRecord()
  {
    MediaRecorder localMediaRecorder = recorder;
    if (localMediaRecorder == null) {
      return;
    }
    try
    {
      localMediaRecorder.stop();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.w("MiniAppCamera", "nativeStopRecord: failed to stop", localIllegalStateException);
    }
    recorder.reset();
    recorder.release();
    recorder = null;
    try
    {
      this.camera.unlock();
    }
    catch (Exception localException1)
    {
      Log.w("MiniAppCamera", "stopRecord: ", localException1);
    }
    try
    {
      this.camera.reconnect();
      return;
    }
    catch (Exception localException2)
    {
      Log.w("MiniAppCamera", "stopRecord: ", localException2);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportRecordAns: ");
    localStringBuilder.append(paramString);
    Log.i("MiniAppCamera", localStringBuilder.toString());
    ThreadManager.executeOnComputationThreadPool(new MiniAppCamera.6(this, paramString, paramRequestEvent));
  }
  
  /* Error */
  private static String saveJpeg(Bitmap paramBitmap, File paramFile, String paramString)
  {
    // Byte code:
    //   0: new 382	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 384	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 387	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 390	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore 4
    //   17: ldc 206
    //   19: aload_2
    //   20: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifeq +9 -> 32
    //   26: bipush 80
    //   28: istore_3
    //   29: goto +18 -> 47
    //   32: ldc 213
    //   34: aload_2
    //   35: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   38: ifeq +83 -> 121
    //   41: bipush 60
    //   43: istore_3
    //   44: goto +3 -> 47
    //   47: aload_0
    //   48: getstatic 396	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   51: bipush 100
    //   53: iload_3
    //   54: invokestatic 402	java/lang/Math:min	(II)I
    //   57: aload 4
    //   59: invokevirtual 408	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   62: pop
    //   63: aload 4
    //   65: invokevirtual 411	java/io/BufferedOutputStream:flush	()V
    //   68: aload_1
    //   69: invokevirtual 416	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   72: aload_1
    //   73: invokevirtual 416	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   76: getstatic 52	com/tencent/qqmini/miniapp/widget/camera/MiniAppCamera:cameraWidth	I
    //   79: getstatic 54	com/tencent/qqmini/miniapp/widget/camera/MiniAppCamera:cameraHeight	I
    //   82: iload_3
    //   83: invokestatic 422	com/tencent/qqmini/sdk/core/utils/ImageUtil:compressImageJpg	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   86: astore_0
    //   87: aload 4
    //   89: invokevirtual 425	java/io/BufferedOutputStream:close	()V
    //   92: aload_0
    //   93: areturn
    //   94: astore_0
    //   95: aload 4
    //   97: astore_1
    //   98: goto +6 -> 104
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 425	java/io/BufferedOutputStream:close	()V
    //   112: aload_0
    //   113: athrow
    //   114: astore_1
    //   115: aload_0
    //   116: areturn
    //   117: astore_1
    //   118: goto -6 -> 112
    //   121: bipush 100
    //   123: istore_3
    //   124: goto -77 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramBitmap	Bitmap
    //   0	127	1	paramFile	File
    //   0	127	2	paramString	String
    //   28	96	3	i	int
    //   15	81	4	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   17	26	94	finally
    //   32	41	94	finally
    //   47	87	94	finally
    //   0	17	101	finally
    //   87	92	114	java/lang/Exception
    //   108	112	117	java/lang/Exception
  }
  
  private String saveVideoThumbImg(String paramString)
  {
    Object localObject = new File(paramString);
    if (((File)localObject).length() == 0L) {
      return null;
    }
    paramString = new StringBuilder();
    paramString.append("saveVideoThumbImg: ");
    paramString.append(((File)localObject).length());
    Log.i("MiniAppCamera", paramString.toString());
    paramString = getTmpPath("jpg");
    localObject = getFirstKeyFrame(((File)localObject).getAbsolutePath());
    if (localObject == null) {
      return null;
    }
    saveJpeg((Bitmap)localObject, new File(paramString), "");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveVideoThumbImg: ");
    ((StringBuilder)localObject).append(paramString);
    Log.i("MiniAppCamera", ((StringBuilder)localObject).toString());
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
    if (this.backCameraId == null) {
      paramString = this.frontCameraId;
    } else {
      paramString = this.backCameraId;
    }
    setupCamera(paramString.intValue());
  }
  
  private void showLoading(String paramString)
  {
    AppBrandTask.runTaskOnUiThread(new MiniAppCamera.8(this, paramString));
  }
  
  private void startCrop(String paramString, RequestEvent paramRequestEvent)
  {
    String str = getTmpPath("mp4");
    int m = getWidth();
    int n = getHeight();
    int k = this.cameraSize.height;
    int i = this.cameraSize.width;
    int i1 = k * n;
    int j = 0;
    if (i * m > i1)
    {
      j = i1 / m;
      m = (i - j) / 2;
      i = j;
      j = m;
      m = 0;
    }
    else
    {
      n = m * (i / n);
      m = (k - n) / 2;
      k = n;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startCrop: ");
    localStringBuilder.append(paramString);
    Log.i("MiniAppCamera", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("-y -i ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" -strict -2 -vcodec libx264 -preset ultrafast -vf crop=");
    localStringBuilder.append(k);
    localStringBuilder.append(":");
    localStringBuilder.append(i);
    localStringBuilder.append(":");
    localStringBuilder.append(m);
    localStringBuilder.append(":");
    localStringBuilder.append(j);
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    execCommand(localStringBuilder.toString(), str, paramString, paramRequestEvent);
  }
  
  public void closeCamera()
  {
    MediaRecorder localMediaRecorder = recorder;
    if (localMediaRecorder != null)
    {
      try
      {
        localMediaRecorder.stop();
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Log.w("MiniAppCamera", "nativeStopRecord: failed to stop", localIllegalStateException);
      }
      recorder.reset();
      recorder.release();
      recorder = null;
    }
    stopPreview();
    releaseCamera();
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
    if (!this.isScanMode) {
      return;
    }
    IJsService localIJsService = (IJsService)this.mJsService.get();
    if (localIJsService == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramString);
      localJSONObject.put("type", "barcode");
      localJSONObject.put("cameraId", this.cameraId);
      localIJsService.evaluateSubscribeJS("onCameraScanCode", localJSONObject.toString(), this.mWebviewId);
      paramString = new StringBuilder();
      paramString.append("onCodeRead, result = ");
      paramString.append(localJSONObject);
      paramString.append(", webviewId = ");
      paramString.append(this.mWebviewId);
      QMLog.i("MiniAppCamera", paramString.toString());
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
      paramString = this.mCallback;
      if (paramString != null) {
        paramString.onStartPreview(false);
      }
      return;
    }
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
      paramString = this.mCallback;
      if (paramString != null) {
        paramString.onStartPreview(false);
      }
    }
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
    }
    catch (Exception paramRequestEvent)
    {
      label112:
      break label112;
    }
    Log.w("MiniAppCamera", "startRecord: ", localException);
    recorder = null;
  }
  
  public void stopPreview(boolean paramBoolean)
  {
    Log.i("MiniAppCamera", "stopPreview: ");
    if (isRecordStart)
    {
      isRecordStart = false;
      IJsService localIJsService = (IJsService)sRecordJsService.get();
      if (localIJsService != null)
      {
        Object localObject = ApiUtil.wrapCallbackFail("operateCamera", null);
        if (localObject != null) {
          localObject = ((JSONObject)localObject).toString();
        } else {
          localObject = "";
        }
        localIJsService.evaluateCallbackJs(recordCallBackId, (String)localObject);
      }
      sRecordJsService.clear();
      nativeStopRecord();
    }
    stopPreview();
    if (paramBoolean) {
      releaseCamera();
    }
  }
  
  public void stopRecord(RequestEvent paramRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopRecord: ");
    localStringBuilder.append(isRecordStart);
    localStringBuilder.append(" ");
    localStringBuilder.append(isMainThread());
    Log.i("MiniAppCamera", localStringBuilder.toString());
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
    if ((this.frontCameraId != null) && (this.backCameraId != null) && (paramBoolean != this.isBackCameraNow))
    {
      ThreadManager.executeOnComputationThreadPool(new MiniAppCamera.10(this, paramBoolean));
      return;
    }
    updateFlashMode();
  }
  
  public void takePhoto(RequestEvent paramRequestEvent, String paramString)
  {
    nativeTakePhoto(paramString, true, new MiniAppCamera.1(this, paramRequestEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera
 * JD-Core Version:    0.7.0.1
 */