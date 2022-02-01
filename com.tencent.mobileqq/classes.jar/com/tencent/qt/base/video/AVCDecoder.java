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
  
  /* Error */
  public boolean create(int paramInt1, int paramInt2, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 10
    //   7: ldc 44
    //   9: invokestatic 50	com/tencent/ilivesdk/utils/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 54	com/tencent/qt/base/video/AVCDecoder:isCreate	()Z
    //   16: ifeq +30 -> 46
    //   19: iload_1
    //   20: aload_0
    //   21: getfield 56	com/tencent/qt/base/video/AVCDecoder:mWidth	I
    //   24: if_icmpne +11 -> 35
    //   27: aload_0
    //   28: getfield 58	com/tencent/qt/base/video/AVCDecoder:mHeight	I
    //   31: iload_2
    //   32: if_icmpeq +80 -> 112
    //   35: aload_0
    //   36: invokevirtual 61	com/tencent/qt/base/video/AVCDecoder:isReleased	()Z
    //   39: ifne +7 -> 46
    //   42: aload_0
    //   43: invokevirtual 64	com/tencent/qt/base/video/AVCDecoder:release	()V
    //   46: aload_0
    //   47: iload_1
    //   48: iload_2
    //   49: aload_3
    //   50: invokevirtual 68	com/tencent/qt/base/video/AVCDecoder:native_create	(IILjava/lang/Object;)I
    //   53: istore 4
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield 30	com/tencent/qt/base/video/AVCDecoder:mCreateFlag	Z
    //   60: iload 4
    //   62: ifne +37 -> 99
    //   65: aload_0
    //   66: iload_1
    //   67: putfield 56	com/tencent/qt/base/video/AVCDecoder:mWidth	I
    //   70: aload_0
    //   71: iload_2
    //   72: putfield 58	com/tencent/qt/base/video/AVCDecoder:mHeight	I
    //   75: aload_0
    //   76: new 70	com/tencent/qt/base/video/VideoPicture
    //   79: dup
    //   80: iload_1
    //   81: iload_2
    //   82: aload_0
    //   83: getfield 37	com/tencent/qt/base/video/AVCDecoder:mImageConfig	Landroid/graphics/Bitmap$Config;
    //   86: invokespecial 73	com/tencent/qt/base/video/VideoPicture:<init>	(IILandroid/graphics/Bitmap$Config;)V
    //   89: putfield 75	com/tencent/qt/base/video/AVCDecoder:bufPicture	Lcom/tencent/qt/base/video/VideoPicture;
    //   92: ldc 10
    //   94: ldc 77
    //   96: invokestatic 80	com/tencent/ilivesdk/utils/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: iload 4
    //   101: ifne +6 -> 107
    //   104: iconst_1
    //   105: istore 5
    //   107: aload_0
    //   108: monitorexit
    //   109: iload 5
    //   111: ireturn
    //   112: ldc 10
    //   114: ldc 82
    //   116: invokestatic 80	com/tencent/ilivesdk/utils/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_0
    //   120: monitorexit
    //   121: iconst_0
    //   122: ireturn
    //   123: astore_3
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_3
    //   127: athrow
    //   128: astore_3
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield 75	com/tencent/qt/base/video/AVCDecoder:bufPicture	Lcom/tencent/qt/base/video/VideoPicture;
    //   134: ldc 10
    //   136: aload_3
    //   137: invokevirtual 86	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   140: invokestatic 89	com/tencent/ilivesdk/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: goto -44 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	AVCDecoder
    //   0	146	1	paramInt1	int
    //   0	146	2	paramInt2	int
    //   0	146	3	paramObject	Object
    //   53	47	4	i	int
    //   1	109	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	35	123	finally
    //   35	46	123	finally
    //   46	60	123	finally
    //   65	75	123	finally
    //   75	99	123	finally
    //   107	109	123	finally
    //   112	121	123	finally
    //   124	126	123	finally
    //   129	143	123	finally
    //   75	99	128	java/lang/OutOfMemoryError
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
      if ((paramVideoFrame == null) || (paramVideoFrame.content == null) || (paramVideoFrame.content.length <= 0))
      {
        LogUtils.e("Render|AVCDecoder", "AVCDecode.decode.frame is null");
        return -1;
      }
    }
    finally {}
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
    for (;;)
    {
      return i;
      i = j;
      if (j > 0)
      {
        LogUtils.e("Render|AVCDecoder", "AVCDecode.decode.got none picture.");
        i = 0;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qt.base.video.AVCDecoder
 * JD-Core Version:    0.7.0.1
 */