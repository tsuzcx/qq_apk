package com.tencent.ttpic.openapi.cache;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.ETC1Util.ETC1Texture;
import com.tencent.ttpic.cache.LoadItemManager;
import com.tencent.ttpic.openapi.extrastickerutil.ExtraStickerParserAgent;
import com.tencent.ttpic.openapi.extrastickerutil.IExtraStickerParser;
import com.tencent.ttpic.openapi.model.StickerItem;

@TargetApi(19)
public class LoadExtraStickerParserManager
  implements LoadItemManager
{
  protected final int RENDER_FAILED = -1;
  protected final int RENDER_NEW_TEXT = 1;
  protected final int RENDER_OLD_TEXT = 0;
  protected String mDataPath;
  protected int mHeight;
  protected boolean mIsPrepared;
  protected String mStickerFileName;
  protected float mStickerFrames;
  protected IExtraStickerParser mStickerParser;
  protected int mStickerType;
  protected int mWidth;
  
  public LoadExtraStickerParserManager(String paramString, StickerItem paramStickerItem)
  {
    float f = 1.0F;
    this.mStickerFrames = 1.0F;
    this.mIsPrepared = false;
    this.mStickerType = 0;
    if (paramStickerItem == null) {
      return;
    }
    this.mStickerType = paramStickerItem.stickerType;
    this.mStickerParser = ExtraStickerParserAgent.getInstance().creatExtraParser(this.mStickerType);
    this.mStickerFileName = paramStickerItem.id;
    if (paramStickerItem.frames > 0) {
      f = paramStickerItem.frames;
    }
    this.mStickerFrames = f;
    this.mDataPath = paramString;
    if ((paramStickerItem.extarTypeHeight > 0) && (paramStickerItem.extraTypeWidth > 0))
    {
      this.mWidth = paramStickerItem.extraTypeWidth;
      this.mHeight = paramStickerItem.extarTypeHeight;
    }
    else
    {
      this.mWidth = paramStickerItem.width;
      this.mHeight = paramStickerItem.height;
    }
    this.mIsPrepared = true;
    paramString = this.mStickerParser;
    if (paramString != null) {
      paramString.setSize(this.mWidth, this.mHeight);
    }
  }
  
  public void clear()
  {
    IExtraStickerParser localIExtraStickerParser = this.mStickerParser;
    if (localIExtraStickerParser != null) {
      localIExtraStickerParser.clear();
    }
  }
  
  public void initInGLThread(int paramInt)
  {
    if (this.mIsPrepared)
    {
      if (paramInt <= 0) {
        return;
      }
      IExtraStickerParser localIExtraStickerParser = this.mStickerParser;
      if (localIExtraStickerParser != null) {
        localIExtraStickerParser.initInGLThread(paramInt, this.mDataPath, this.mStickerFileName);
      }
    }
  }
  
  public boolean isBitmap()
  {
    IExtraStickerParser localIExtraStickerParser = this.mStickerParser;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localIExtraStickerParser != null)
    {
      bool1 = bool2;
      if (localIExtraStickerParser.getResultType() == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public ETC1Util.ETC1Texture loadETCAlphaTexture(int paramInt)
  {
    return null;
  }
  
  public ETC1Util.ETC1Texture loadETCRGBTexture(int paramInt)
  {
    return null;
  }
  
  public int loadImage(int paramInt1, int paramInt2)
  {
    IExtraStickerParser localIExtraStickerParser = this.mStickerParser;
    if (localIExtraStickerParser != null) {
      return localIExtraStickerParser.updateTexture(paramInt1, paramInt2 / this.mStickerFrames, EGL14.eglGetCurrentContext());
    }
    return -1;
  }
  
  public int loadImage(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    IExtraStickerParser localIExtraStickerParser = this.mStickerParser;
    if (localIExtraStickerParser != null) {
      return localIExtraStickerParser.updateTexture(paramInt1, paramInt2 / this.mStickerFrames, paramEGLContext);
    }
    return -1;
  }
  
  public Bitmap loadImage(int paramInt)
  {
    return null;
  }
  
  public Bitmap loadImage(String paramString)
  {
    return null;
  }
  
  public void prepareImages()
  {
    if (!this.mIsPrepared) {
      return;
    }
    if (this.mStickerParser == null) {
      this.mStickerParser = ExtraStickerParserAgent.getInstance().creatExtraParser(this.mStickerType);
    }
    IExtraStickerParser localIExtraStickerParser = this.mStickerParser;
    if (localIExtraStickerParser == null) {
      return;
    }
    if (localIExtraStickerParser != null)
    {
      localIExtraStickerParser.setSize(this.mWidth, this.mHeight);
      this.mIsPrepared = this.mStickerParser.prepare(this.mDataPath, this.mStickerFileName);
    }
  }
  
  public void reset()
  {
    IExtraStickerParser localIExtraStickerParser = this.mStickerParser;
    if (localIExtraStickerParser != null) {
      localIExtraStickerParser.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.LoadExtraStickerParserManager
 * JD-Core Version:    0.7.0.1
 */