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
  protected boolean mIsPrepared = false;
  protected String mStickerFileName;
  protected float mStickerFrames = 1.0F;
  protected IExtraStickerParser mStickerParser;
  protected int mStickerType = 0;
  protected int mWidth;
  
  public LoadExtraStickerParserManager(String paramString, StickerItem paramStickerItem)
  {
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
    if ((paramStickerItem.extarTypeHeight <= 0) || (paramStickerItem.extraTypeWidth <= 0)) {
      this.mWidth = paramStickerItem.width;
    }
    for (this.mHeight = paramStickerItem.height;; this.mHeight = paramStickerItem.extarTypeHeight)
    {
      this.mIsPrepared = true;
      if (this.mStickerParser == null) {
        break;
      }
      this.mStickerParser.setSize(this.mWidth, this.mHeight);
      return;
      this.mWidth = paramStickerItem.extraTypeWidth;
    }
  }
  
  public void clear()
  {
    if (this.mStickerParser != null) {
      this.mStickerParser.clear();
    }
  }
  
  public void initInGLThread(int paramInt)
  {
    if ((!this.mIsPrepared) || (paramInt <= 0)) {}
    while (this.mStickerParser == null) {
      return;
    }
    this.mStickerParser.initInGLThread(paramInt, this.mDataPath, this.mStickerFileName);
  }
  
  public boolean isBitmap()
  {
    if (this.mStickerParser != null) {
      return this.mStickerParser.getResultType() == 1;
    }
    return false;
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
    if (this.mStickerParser != null) {
      return this.mStickerParser.updateTexture(paramInt1, paramInt2 / this.mStickerFrames, EGL14.eglGetCurrentContext());
    }
    return -1;
  }
  
  public int loadImage(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    if (this.mStickerParser != null) {
      return this.mStickerParser.updateTexture(paramInt1, paramInt2 / this.mStickerFrames, paramEGLContext);
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
    if (!this.mIsPrepared) {}
    do
    {
      return;
      if (this.mStickerParser == null) {
        this.mStickerParser = ExtraStickerParserAgent.getInstance().creatExtraParser(this.mStickerType);
      }
    } while ((this.mStickerParser == null) || (this.mStickerParser == null));
    this.mStickerParser.setSize(this.mWidth, this.mHeight);
    this.mIsPrepared = this.mStickerParser.prepare(this.mDataPath, this.mStickerFileName);
  }
  
  public void reset()
  {
    if (this.mStickerParser != null) {
      this.mStickerParser.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.LoadExtraStickerParserManager
 * JD-Core Version:    0.7.0.1
 */