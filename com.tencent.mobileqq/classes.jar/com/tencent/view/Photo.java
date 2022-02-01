package com.tencent.view;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.ttpic.baseutils.device.DeviceAttrs;

public class Photo
{
  private static final String FRAGMENT_SHADER = "precision mediump float;\nuniform sampler2D tex_sampler;\nvarying vec2 v_texcoord;\nvoid main() {\ngl_FragColor = texture2D(tex_sampler, v_texcoord);\n}\n";
  private static final float[] POS_VERTICES = { -1.0F, 1.0F, 1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F };
  private static final int TEXTUREUNSET = -20000;
  private static final float[] TEX_VERTICES = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  private static final String VERTEX_SHADER = "attribute vec4 a_position;\nattribute vec2 a_texcoord;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_Position = a_position;\n  v_texcoord = a_texcoord;\n}\n";
  private int height;
  private int texture = -20000;
  private int width;
  
  public Photo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.texture = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
  }
  
  private void copyFBO(Photo paramPhoto)
  {
    this.width = paramPhoto.width;
    this.height = paramPhoto.height;
    int i = this.texture;
    if (i != -20000) {
      RendererUtils.clearTexture(i);
    }
    this.texture = RendererUtils.createTexture();
    GLES20.glActiveTexture(33984);
    GlUtil.glBindTexture(3553, this.texture);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glBindTexture(3553, 0);
    RendererUtils.renderTexture2FBO(RendererUtils.createFilterProgram("attribute vec4 a_position;\nattribute vec2 a_texcoord;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_Position = a_position;\n  v_texcoord = a_texcoord;\n}\n", "precision mediump float;\nuniform sampler2D tex_sampler;\nvarying vec2 v_texcoord;\nvoid main() {\ngl_FragColor = texture2D(tex_sampler, v_texcoord);\n}\n", POS_VERTICES, TEX_VERTICES), paramPhoto.texture(), this.texture, this.width, this.height);
  }
  
  private void copySave(Photo paramPhoto)
  {
    this.width = paramPhoto.width;
    this.height = paramPhoto.height;
    int i = this.texture;
    if (i != -20000) {
      RendererUtils.clearTexture(i);
    }
    paramPhoto = paramPhoto.save();
    this.texture = RendererUtils.createTexture(paramPhoto);
    if ((paramPhoto != null) && (!paramPhoto.isRecycled())) {
      paramPhoto.recycle();
    }
  }
  
  public static Photo create(int paramInt1, int paramInt2)
  {
    return new Photo(RendererUtils.createTexture(), paramInt1, paramInt2);
  }
  
  public static Photo create(int paramInt1, int paramInt2, int paramInt3)
  {
    return new Photo(paramInt1, paramInt2, paramInt3);
  }
  
  public static Photo create(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Photo localPhoto = new Photo(RendererUtils.createTexture(paramBitmap), paramBitmap.getWidth(), paramBitmap.getHeight());
      if (!paramBitmap.isRecycled()) {
        paramBitmap.recycle();
      }
      return localPhoto;
    }
    return null;
  }
  
  public static Photo create(Photo paramPhoto)
  {
    if (paramPhoto == null) {
      return null;
    }
    Photo localPhoto = new Photo(-20000, paramPhoto.width, paramPhoto.height);
    localPhoto.copy(paramPhoto);
    return localPhoto;
  }
  
  public static Photo createWithoutRecycle(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      return new Photo(RendererUtils.createTexture(paramBitmap), paramBitmap.getWidth(), paramBitmap.getHeight());
    }
    return null;
  }
  
  public void changeBitmap(Bitmap paramBitmap)
  {
    this.width = paramBitmap.getWidth();
    this.height = paramBitmap.getHeight();
    RendererUtils.clearTexture(this.texture);
    this.texture = RendererUtils.createTexture(paramBitmap);
  }
  
  public void changeDimension(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    RendererUtils.clearTexture(this.texture);
    this.texture = RendererUtils.createTexture();
  }
  
  public void changeImage(QImage paramQImage)
  {
    this.width = paramQImage.getWidth();
    this.height = paramQImage.getHeight();
    GLSLRender.nativeTextImage(paramQImage, this.texture);
  }
  
  public void clear()
  {
    int i = this.texture;
    if (i != -20000)
    {
      RendererUtils.clearTexture(i);
      this.texture = -20000;
    }
  }
  
  public void copy(Photo paramPhoto)
  {
    if (this.texture != paramPhoto.texture())
    {
      copyFBO(paramPhoto);
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public int height()
  {
    return this.height;
  }
  
  public boolean matchDimension(Photo paramPhoto)
  {
    return (paramPhoto.width == this.width) && (paramPhoto.height == this.height);
  }
  
  public Bitmap save()
  {
    int i = this.texture;
    if (DeviceAttrs.getInstance().gpuProcessNeedBackTexture)
    {
      i = RendererUtils.createTexture();
      GLES20.glActiveTexture(33984);
      GlUtil.glBindTexture(3553, i);
      GLES20.glTexParameteri(3553, 10240, 9729);
      GLES20.glTexParameteri(3553, 10241, 9729);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      GLES20.glBindTexture(3553, 0);
      RendererUtils.renderTexture2FBO(RendererUtils.createFilterProgram("attribute vec4 a_position;\nattribute vec2 a_texcoord;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_Position = a_position;\n  v_texcoord = a_texcoord;\n}\n", "precision mediump float;\nuniform sampler2D tex_sampler;\nvarying vec2 v_texcoord;\nvoid main() {\ngl_FragColor = texture2D(tex_sampler, v_texcoord);\n}\n", POS_VERTICES, TEX_VERTICES), this.texture, i, this.width, this.height);
    }
    Object localObject = null;
    try
    {
      Bitmap localBitmap = RendererUtils.saveTexture(i, this.width, this.height);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (DeviceAttrs.getInstance().gpuProcessNeedBackTexture) {
      RendererUtils.clearTexture(i);
    }
    return localObject;
  }
  
  public QImage saveImage()
  {
    if (DeviceAttrs.getInstance().gpuProcessNeedBackTexture)
    {
      Bitmap localBitmap = save();
      QImage localQImage = QImage.Bitmap2QImage(localBitmap);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
      return localQImage;
    }
    return RendererUtils.saveTexture2QImage(this.texture, this.width, this.height);
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setTexture(int paramInt)
  {
    this.texture = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  public void swap(Photo paramPhoto)
  {
    int i = paramPhoto.texture;
    paramPhoto.texture = this.texture;
    this.texture = i;
    i = paramPhoto.height;
    paramPhoto.height = this.height;
    this.height = i;
    i = paramPhoto.width;
    paramPhoto.width = this.width;
    this.width = i;
  }
  
  public int texture()
  {
    return this.texture;
  }
  
  public int width()
  {
    return this.width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.view.Photo
 * JD-Core Version:    0.7.0.1
 */