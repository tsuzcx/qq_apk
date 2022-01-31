package com.tencent.ttpic.util.youtu;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.util.VideoCacheUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class VideoFaceDetector
{
  private static final String TAG = VideoFaceDetector.class.getSimpleName();
  private String localPath;
  private long mNativeObjPtr;
  
  public VideoFaceDetector(String paramString)
  {
    this.localPath = paramString;
    Log.i(TAG, "VideoFaceDetector path:" + paramString);
  }
  
  private boolean initModel()
  {
    for (;;)
    {
      try
      {
        byte[] arrayOfByte;
        if (!TextUtils.isEmpty(this.localPath))
        {
          arrayOfByte = VideoFileUtil.readFile(this.localPath + "ufdmtcc.bin");
          if (!TextUtils.isEmpty(this.localPath))
          {
            localObject = VideoFileUtil.readFile(this.localPath + "ufat.bin");
            return nativeInit(arrayOfByte, (byte[])localObject);
          }
        }
        else
        {
          localObject = VideoGlobalContext.getContext().getAssets().open("ufdmtcc.bin");
          arrayOfByte = new byte[((InputStream)localObject).available()];
          ((InputStream)localObject).read(arrayOfByte);
          ((InputStream)localObject).close();
          continue;
        }
        localInputStream = VideoGlobalContext.getContext().getAssets().open("ufat.bin");
      }
      catch (IOException localIOException)
      {
        Log.e("FaceTrack", "initModel error");
        return false;
      }
      InputStream localInputStream;
      Object localObject = new byte[localInputStream.available()];
      localInputStream.read((byte[])localObject);
      localInputStream.close();
    }
  }
  
  private native boolean nativeConstructor(String paramString1, String paramString2, String paramString3);
  
  private native void nativeDestructor();
  
  private native FaceStatus[] nativeDoTrackByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native void nativeFaceDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native void nativeFaceDetect3D(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native void nativeFaceDetectByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void destroy()
  {
    nativeDestructor();
  }
  
  public void doFaceDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    nativeFaceDetect3D(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void doFaceDetectByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    nativeFaceDetectByY(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public FaceStatus[] doTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return nativeDoTrack(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public FaceStatus[] doTrack3D(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return nativeDoTrack3D(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public FaceStatus[] doTrackByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return nativeDoTrackByY(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int init()
  {
    String str1 = VideoCacheUtil.getTempDiskCacheDir() + File.separator + "ccnf_patches_1_my36n.txt";
    String str2 = VideoCacheUtil.getTempDiskCacheDir() + File.separator + "pdm_82_aligned_my36n.txt";
    String str3 = VideoCacheUtil.getTempDiskCacheDir() + File.separator + "pdm.txt";
    String str4 = VideoCacheUtil.getTempDiskCacheDir() + File.separator + "pdm_82.txt";
    String str5 = VideoCacheUtil.getTempDiskCacheDir() + File.separator + "meshBasis.bin";
    String str6 = VideoCacheUtil.getTempDiskCacheDir() + File.separator + "rotBasis.bin";
    String str7 = VideoCacheUtil.getTempDiskCacheDir() + File.separator;
    int i = 0;
    boolean bool1;
    boolean bool5;
    boolean bool4;
    boolean bool3;
    boolean bool2;
    if (!TextUtils.isEmpty(this.localPath))
    {
      bool1 = VideoFileUtil.copyFile(this.localPath + "ccnf_patches_1_my36n.txt", str1);
      bool5 = VideoFileUtil.copyFile(this.localPath + "pdm_82_aligned_my36n.txt", str2);
      bool4 = VideoFileUtil.copyFile(this.localPath + "pdm.txt", str3);
      bool3 = VideoFileUtil.copyFile(this.localPath + "pdm_82.txt", str4);
      bool2 = VideoFileUtil.copyFile(this.localPath + "meshBasis.bin", str5);
    }
    for (boolean bool6 = VideoFileUtil.copyFile(this.localPath + "rotBasis.bin", str6);; bool6 = VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "rotBasis.bin", str6))
    {
      if ((!bool1) || (!bool5) || (!bool4) || (!bool3) || (!bool2) || (!bool6)) {
        i = -1000;
      }
      if (!nativeConstructor(str1, str2, str7))
      {
        Log.e("VideoFaceDetector", "nativeConstructor failed");
        i = -1001;
      }
      if (!initModel())
      {
        i = -1002;
        Log.e("VideoFaceDetector", "nativeInit failed");
      }
      nativeSetRefine(false);
      return i;
      bool1 = VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "ccnf_patches_1_my36n.txt", str1);
      bool5 = VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "pdm_82_aligned_my36n.txt", str2);
      bool4 = VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "pdm.txt", str3);
      bool3 = VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "pdm_82.txt", str4);
      bool2 = VideoFileUtil.copyAssets(VideoGlobalContext.getContext(), "meshBasis.bin", str5);
    }
  }
  
  public native FaceStatus[] nativeDoTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native FaceStatus[] nativeDoTrack3D(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native boolean nativeInit(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public native void nativeSetRefine(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.VideoFaceDetector
 * JD-Core Version:    0.7.0.1
 */