package com.tencent.qt.base.video;

import android.graphics.Bitmap.Config;
import com.tencent.ilivesdk.playview.codec.VideoDecoder;
import com.tencent.ilivesdk.playview.data.VideoFrame;
import com.tencent.ilivesdk.playview.data.VideoImage;
import com.tencent.ilivesdk.utils.LogUtils;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AVCDecoder
  implements VideoDecoder
{
  private static final String TAG = "Render|AVCDecoder";
  private VideoPicture bufPicture;
  protected volatile boolean mCreateFlag = false;
  protected int mHeight;
  private Bitmap.Config mImageConfig = Bitmap.Config.ARGB_8888;
  private int mNativeInJavaObj;
  protected int mWidth;
  public RandomAccessFile randomFile = null;
  
  public boolean create(int paramInt1, int paramInt2, Object paramObject)
  {
    for (;;)
    {
      int i;
      boolean bool;
      try
      {
        LogUtils.w("Render|AVCDecoder", "create.in.");
        if (isCreate())
        {
          if ((paramInt1 == this.mWidth) && (this.mHeight == paramInt2))
          {
            LogUtils.i("Render|AVCDecoder", "has create.");
            return false;
          }
          if (!isReleased()) {
            release();
          }
        }
        i = native_create(paramInt1, paramInt2, paramObject);
        bool = true;
        this.mCreateFlag = true;
        if (i == 0)
        {
          this.mWidth = paramInt1;
          this.mHeight = paramInt2;
          try
          {
            this.bufPicture = new VideoPicture(paramInt1, paramInt2, this.mImageConfig);
            LogUtils.i("Render|AVCDecoder", "create.successed.");
          }
          catch (OutOfMemoryError paramObject)
          {
            this.bufPicture = null;
            LogUtils.e("Render|AVCDecoder", paramObject.getMessage());
          }
          return bool;
        }
      }
      finally {}
      if (i != 0) {
        bool = false;
      }
    }
  }
  
  public int decode(VideoFrame paramVideoFrame, VideoImage paramVideoImage)
  {
    try
    {
      if (!isCreate())
      {
        LogUtils.e("Render|AVCDecoder", "AVCDecode.isCreate.not.");
        return -1;
      }
      if (this.bufPicture == null)
      {
        LogUtils.e("Render|AVCDecoder", "AVCDecode.decode.bufPicture is null");
        return 0;
      }
      this.bufPicture.clear();
      if ((paramVideoFrame != null) && (paramVideoFrame.content != null) && (paramVideoFrame.content.length > 0))
      {
        int j = native_decode(paramVideoFrame.content, 0, paramVideoFrame.content.length, this.bufPicture);
        int i;
        if ((j >= 0) && (this.bufPicture.got > 0) && (!paramVideoFrame.shouldDiscard))
        {
          LogUtils.e("Render|AVCDecoder", "got a picture");
          i = j;
          if (paramVideoImage != null)
          {
            paramVideoImage.seq = paramVideoFrame.seq;
            paramVideoImage.timestamp = paramVideoFrame.timestamp;
            paramVideoImage.type = paramVideoFrame.type;
            paramVideoImage.content = this.bufPicture.pixels;
            paramVideoImage.width = this.bufPicture.realwidth;
            paramVideoImage.height = this.bufPicture.realheight;
            i = j;
          }
        }
        else
        {
          i = j;
          if (j > 0)
          {
            LogUtils.e("Render|AVCDecoder", "AVCDecode.decode.got none picture.");
            i = 0;
          }
        }
        return i;
      }
      LogUtils.e("Render|AVCDecoder", "AVCDecode.decode.frame is null");
      return -1;
    }
    finally {}
  }
  
  protected boolean isCreate()
  {
    return this.mCreateFlag;
  }
  
  protected boolean isReleased()
  {
    return this.mNativeInJavaObj == 0;
  }
  
  public int native_create(int paramInt1, int paramInt2, Object paramObject)
  {
    return -1;
  }
  
  public int native_decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, VideoPicture paramVideoPicture)
  {
    return -1;
  }
  
  public void native_destroy() {}
  
  public void release()
  {
    LogUtils.w("Render|AVCDecoder", "release.in.");
    try
    {
      if (!isCreate()) {
        return;
      }
      native_destroy();
      this.mCreateFlag = false;
      this.bufPicture = null;
      return;
    }
    finally {}
  }
  
  public void writeFile(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      if (this.randomFile == null) {
        this.randomFile = new RandomAccessFile(paramString, "rw");
      }
      long l = this.randomFile.length();
      this.randomFile.seek(l);
      this.randomFile.write(paramArrayOfByte, 0, paramInt);
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qt.base.video.AVCDecoder
 * JD-Core Version:    0.7.0.1
 */