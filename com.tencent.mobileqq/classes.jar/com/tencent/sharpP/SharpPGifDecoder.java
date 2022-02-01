package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDecoder.GifFrame;
import java.io.File;

public class SharpPGifDecoder
{
  public static final String TAG = "SharpPGifDecoder";
  private static final boolean USE_BITMAP_BUFFER = true;
  private int LOOP_COUNT = 0;
  private Bitmap.Config mAcceptableConfig;
  private Bitmap mBitmapBuffer;
  private NewGifDecoder.GifFrame mCurFrame;
  private int mCurLoop = 0;
  private SharpPDecoderHelper mDecoder;
  private int mDstHeight;
  private int mDstWidth;
  private File mFile;
  private long mHDec;
  private int mNextFrameIndex = 0;
  private int maxFrameIndex = -1;
  
  public SharpPGifDecoder(String paramString)
  {
    this.mDecoder = new SharpPDecoderHelper(paramString);
    this.mFile = new File(paramString);
    init();
    this.mDstWidth = this.mDecoder.getFeatureInfo().getWidth();
    this.mDstHeight = this.mDecoder.getFeatureInfo().getHeight();
  }
  
  public SharpPGifDecoder(String paramString, int paramInt1, int paramInt2)
  {
    this.mDecoder = new SharpPDecoderHelper(paramString);
    this.mDstWidth = paramInt1;
    this.mDstHeight = paramInt2;
    this.mFile = new File(paramString);
    init();
  }
  
  private void init()
  {
    try
    {
      if (this.mDecoder.parseHeader() == 0)
      {
        this.mHDec = this.mDecoder.createDecoder();
        this.maxFrameIndex = this.mDecoder.getFeatureInfo().getFrameCount();
        if (this.mDecoder.getFeatureInfo().getImageMode() == 4)
        {
          ImageManagerEnv.getLogger().d("SharpPGifDecoder", new Object[] { "gif: emMode_AnimationWithAlpha" });
          this.mAcceptableConfig = Bitmap.Config.ARGB_8888;
        }
      }
      if (this.mAcceptableConfig == null)
      {
        ImageManagerEnv.getLogger().d("SharpPGifDecoder", new Object[] { "gif: emMode_Animation" });
        this.mAcceptableConfig = Bitmap.Config.RGB_565;
      }
      return;
    }
    finally {}
  }
  
  int calculateDelayTime(int paramInt)
  {
    if (paramInt <= 1) {
      return 10;
    }
    return paramInt * 10;
  }
  
  public int close()
  {
    try
    {
      ImageManagerEnv.getLogger().d("SharpPGifDecoder", new Object[] { "close" });
      this.mNextFrameIndex = 0;
      if (this.mHDec == 0L)
      {
        ImageManagerEnv.getLogger().w("SharpPGifDecoder", new Object[] { "SharpPGifDecoder.close():mHDec=0" });
        return -1;
      }
      this.mDecoder.closeDecoder(this.mHDec);
      this.mHDec = 0L;
      return 0;
    }
    finally {}
  }
  
  public Bitmap.Config getAcceptableBitmapConfig()
  {
    return this.mAcceptableConfig;
  }
  
  public int getAllocationByteCount()
  {
    return this.mDecoder.getAllocationByteCount();
  }
  
  public int getCurFrameDuration()
  {
    NewGifDecoder.GifFrame localGifFrame = this.mCurFrame;
    if (localGifFrame != null) {
      return (int)localGifFrame.delay;
    }
    return 200;
  }
  
  public int getCurFrameIndex()
  {
    return this.mNextFrameIndex;
  }
  
  public int getCurrentLoop()
  {
    return this.mCurLoop;
  }
  
  public int getDstHeight()
  {
    return this.mDstHeight;
  }
  
  public int getDstWidth()
  {
    return this.mDstWidth;
  }
  
  public int getFrameCount()
  {
    if (this.maxFrameIndex == -1) {
      init();
    }
    return this.maxFrameIndex;
  }
  
  public int getLoopCount()
  {
    return this.LOOP_COUNT;
  }
  
  public long getSourceLength()
  {
    return this.mFile.length();
  }
  
  public NewGifDecoder.GifFrame next()
  {
    try
    {
      if (this.mHDec == 0L) {
        init();
      }
      Object localObject3 = new SharpPDecoderWrapper.WriteableInteger(0);
      Object localObject1 = null;
      if (!this.mFile.exists())
      {
        localObject1 = ImageManagerEnv.getLogger();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("gif file ");
        ((StringBuilder)localObject3).append(this.mFile.getAbsolutePath());
        ((StringBuilder)localObject3).append(" doesn't exist.");
        ((ILog)localObject1).e("SharpPGifDecoder", new Object[] { ((StringBuilder)localObject3).toString() });
        localObject1 = this.mCurFrame;
        return localObject1;
      }
      if (this.mHDec == 0L)
      {
        ImageManagerEnv.getLogger().e("SharpPGifDecoder", new Object[] { "gif mHDec is 0,createDecoder error." });
        localObject1 = this.mCurFrame;
        return localObject1;
      }
      if ((this.LOOP_COUNT != 0) && (this.mCurLoop >= this.LOOP_COUNT))
      {
        ILog localILog = ImageManagerEnv.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loop over,loopCount:");
        localStringBuilder.append(this.LOOP_COUNT);
        localILog.w("SharpPGifDecoder", new Object[] { localStringBuilder.toString() });
      }
      else
      {
        localObject1 = this.mDecoder.decodeSharpP2GifFrame(this.mHDec, this.mNextFrameIndex, this.mDstWidth, this.mDstHeight, (SharpPDecoderWrapper.WriteableInteger)localObject3, this.mBitmapBuffer);
        this.mNextFrameIndex += 1;
      }
      if (this.mNextFrameIndex == this.maxFrameIndex)
      {
        this.mNextFrameIndex = 0;
        this.mCurLoop += 1;
      }
      if (localObject1 != null)
      {
        this.mCurFrame = new NewGifDecoder.GifFrame((Bitmap)localObject1, calculateDelayTime(((SharpPDecoderWrapper.WriteableInteger)localObject3).realInt.intValue()));
      }
      else
      {
        localObject1 = ImageManagerEnv.getLogger();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("decode error:frameIndex=");
        ((StringBuilder)localObject3).append(this.mNextFrameIndex);
        ((ILog)localObject1).e("SharpPGifDecoder", new Object[] { ((StringBuilder)localObject3).toString() });
      }
      localObject1 = this.mCurFrame;
      return localObject1;
    }
    finally {}
  }
  
  public NewGifDecoder.GifFrame next(Bitmap paramBitmap)
  {
    try
    {
      this.mBitmapBuffer = paramBitmap;
      paramBitmap = next();
      return paramBitmap;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  public boolean reset()
  {
    try
    {
      this.mNextFrameIndex = 0;
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Bitmap seekToFrame(int paramInt, Bitmap paramBitmap)
  {
    setCurFrameIndex(paramInt);
    next();
    NewGifDecoder.GifFrame localGifFrame = this.mCurFrame;
    if (localGifFrame != null) {
      return localGifFrame.image;
    }
    return paramBitmap;
  }
  
  public void setCurFrameIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 65535)) {}
    try
    {
      this.mNextFrameIndex = paramInt;
      return;
    }
    finally {}
    throw new IllegalArgumentException("curFrameIndex is out of range <0, 65535>");
  }
  
  public void setLoopCount(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 65535))
    {
      this.LOOP_COUNT = paramInt;
      return;
    }
    throw new IllegalArgumentException("Loop count of range <0, 65535>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sharpP.SharpPGifDecoder
 * JD-Core Version:    0.7.0.1
 */