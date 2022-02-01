package com.tencent.qt.base.video;

import com.tencent.ilivesdk.playview.codec.VideoEncoder;
import com.tencent.ilivesdk.utils.LogUtils;

public class AVCEncoder
  implements VideoEncoder
{
  public static final int EXPECT_CAMERA_CAPTURE_HEIGHT = 480;
  public static final int EXPECT_CAMERA_CAPTURE_WIDTH = 640;
  private static final String TAG = "Render|AVCEncoder";
  private static byte[] mExpectData = null;
  private static int nExpectYSize = 307200;
  private long mHandle;
  private int mHeight;
  private int mNativeInJavaObj;
  private int mWidth;
  
  public static byte[] clipHeight(byte[] paramArrayOfByte, int paramInt)
  {
    int i = nExpectYSize;
    if (mExpectData == null) {
      mExpectData = new byte[i * 3 / 2];
    }
    int j = (paramInt - 640) / 2 * 480;
    paramInt *= 480;
    System.arraycopy(paramArrayOfByte, j, mExpectData, 0, i);
    System.arraycopy(paramArrayOfByte, j / 4 + paramInt, mExpectData, i, i / 4);
    int k = paramInt / 4;
    System.arraycopy(paramArrayOfByte, j / 4 + (paramInt + k), mExpectData, i / 4 + i, i / 4);
    return mExpectData;
  }
  
  public static void initBeauty(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AVCEncoder localAVCEncoder = new AVCEncoder();
    localAVCEncoder.create(paramInt1, paramInt2, paramInt3, paramInt4, Integer.valueOf(0));
    localAVCEncoder.release();
  }
  
  public static int native_cleanupencoder(int paramInt)
  {
    return -1;
  }
  
  public static int native_encodervideoframe(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, VideoFrame paramVideoFrame)
  {
    return -1;
  }
  
  public static long native_getpts()
  {
    return -1L;
  }
  
  public static int native_i420clipto(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    return -1;
  }
  
  public static int native_i420tonv12(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    return -1;
  }
  
  public static int native_i420torgba(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    return -1;
  }
  
  public static int native_nv21clipto(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    return -1;
  }
  
  public static int native_nv21toi420rotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return -1;
  }
  
  public static int native_rgbatoi420(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    return -1;
  }
  
  public static int native_rgbatoi420rotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return -1;
  }
  
  public static int native_setimagebeauty(byte[] paramArrayOfByte, int paramInt)
  {
    return -1;
  }
  
  public static int native_setimageclear(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    return -1;
  }
  
  public static int native_startupencoder(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return -1;
  }
  
  public static int native_yv12tonv21(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    return -1;
  }
  
  public boolean create(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    try
    {
      this.mHandle = native_startupencoder(paramInt1, paramInt2, paramInt3, paramInt4);
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      return true;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        LogUtils.e("Render|AVCEncoder", "native code library native_startupencoder Failed.\n" + paramObject);
      }
    }
  }
  
  public int encode(byte[] paramArrayOfByte, long paramLong, VideoFrame paramVideoFrame)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    try
    {
      int i = native_encodervideoframe((int)this.mHandle, paramArrayOfByte, paramArrayOfByte.length, (int)paramLong, paramVideoFrame);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      LogUtils.e("Render|AVCEncoder", "native code library native_encodervideoframe Failed.\n" + paramArrayOfByte);
    }
    return 0;
  }
  
  protected boolean isReleased()
  {
    return this.mNativeInJavaObj == 0;
  }
  
  public void release()
  {
    if (this.mHandle != 0L) {
      native_cleanupencoder((int)this.mHandle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qt.base.video.AVCEncoder
 * JD-Core Version:    0.7.0.1
 */