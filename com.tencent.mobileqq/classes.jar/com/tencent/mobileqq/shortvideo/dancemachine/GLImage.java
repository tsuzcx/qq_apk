package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.mobileqq.activity.richmedia.FileUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public class GLImage
{
  private int height;
  private boolean mIsBoyFilterTexture = false;
  private boolean mTemporaryRelease = false;
  private int texture = 0;
  private int width;
  
  public GLImage()
  {
    this.mTemporaryRelease = false;
    this.mIsBoyFilterTexture = false;
  }
  
  public GLImage(boolean paramBoolean)
  {
    this.mTemporaryRelease = paramBoolean;
    this.mIsBoyFilterTexture = false;
  }
  
  public GLImage(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mTemporaryRelease = paramBoolean1;
    this.mIsBoyFilterTexture = paramBoolean2;
  }
  
  private boolean reuseTextureMemory(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 == this.width)
    {
      bool1 = bool2;
      if (paramInt2 == this.height)
      {
        GLES20.glBindTexture(3553, this.texture);
        if (paramBitmap != null) {
          GLUtils.texImage2D(3553, 0, paramBitmap, 0);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getTexture()
  {
    return this.texture;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public boolean isBoyFilterTexture()
  {
    return this.mIsBoyFilterTexture;
  }
  
  public boolean isEnableTemporaryRelease()
  {
    return this.mTemporaryRelease;
  }
  
  public void loadTextureSync(Bitmap paramBitmap)
  {
    loadTextureSync(paramBitmap, true);
  }
  
  public void loadTextureSync(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBitmap != null)
    {
      if (this.texture == 0) {
        break label40;
      }
      if (!reuseTextureMemory(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap)) {
        break label36;
      }
      if (paramBoolean) {
        paramBitmap.recycle();
      }
    }
    label36:
    label40:
    do
    {
      return;
      release();
      this.width = paramBitmap.getWidth();
      this.height = paramBitmap.getHeight();
      this.texture = GlUtil.createTexture(3553, paramBitmap);
    } while (!paramBoolean);
    paramBitmap.recycle();
  }
  
  public void loadTextureSync(String paramString)
  {
    loadTextureSync(FileUtils.loadBitmapFromNative(paramString, false));
  }
  
  public void release()
  {
    if (this.texture != 0)
    {
      GLES20.glDeleteTextures(1, new int[] { this.texture }, 0);
      this.texture = 0;
    }
    this.width = 0;
    this.height = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLImage
 * JD-Core Version:    0.7.0.1
 */