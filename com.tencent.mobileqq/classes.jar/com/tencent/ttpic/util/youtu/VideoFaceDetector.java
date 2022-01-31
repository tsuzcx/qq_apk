package com.tencent.ttpic.util.youtu;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.util.SoInfo;
import java.nio.ByteBuffer;

public class VideoFaceDetector
{
  private static final String TAG = VideoFaceDetector.class.getSimpleName();
  private long mNativeObjPtr;
  
  public static Bitmap getBitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
    return localBitmap;
  }
  
  @SoInfo(libName="CameraFaceJNI")
  private native boolean nativeConstructor();
  
  @SoInfo(libName="CameraFaceJNI")
  private native void nativeDestructor();
  
  @SoInfo(libName="CameraFaceJNI")
  private native boolean nativeFaceDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  @SoInfo(libName="CameraFaceJNI")
  private native void nativeFaceDetectByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void destroy()
  {
    nativeDestructor();
    LogUtils.i(TAG, "[FaceDetector] [Instance] instance destoryed");
  }
  
  public boolean doFaceDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return nativeFaceDetect(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void doFaceDetectByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    nativeFaceDetectByY(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public FaceStatus[] doTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return nativeFaceTrack(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public FaceStatus[] doTrack3D(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat)
  {
    return nativeFaceTrack3D(paramArrayOfByte, paramInt1, paramInt2, paramFloat);
  }
  
  public boolean init()
  {
    boolean bool = true & FeatureManager.Features.FACE_DETECT.init();
    AEOpenRenderConfig.checkStrictMode(bool, "FACE_DETECT init failed");
    bool &= nativeConstructor();
    AEOpenRenderConfig.checkStrictMode(bool, "VideoFaceDetector nativeConstructor failed");
    return bool;
  }
  
  @SoInfo(libName="CameraFaceJNI")
  public native FaceStatus[] nativeFaceTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  @SoInfo(libName="CameraFaceJNI")
  public native FaceStatus[] nativeFaceTrack3D(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.VideoFaceDetector
 * JD-Core Version:    0.7.0.1
 */