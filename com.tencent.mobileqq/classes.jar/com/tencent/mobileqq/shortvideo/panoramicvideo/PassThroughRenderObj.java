package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.GLPassThroughProgram;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.TextureUtil;

public class PassThroughRenderObj
  extends BaseRenderObj
{
  protected Context context;
  protected GLPassThroughProgram glPassThroughProgram;
  private Plane plane;
  protected float[] projectionMatrix = new float[16];
  
  public PassThroughRenderObj(Context paramContext)
  {
    this.context = paramContext;
    this.glPassThroughProgram = new GLPassThroughProgram(paramContext);
    this.plane = new Plane(true);
  }
  
  public void destroy()
  {
    this.glPassThroughProgram.onDestroy();
  }
  
  public void init()
  {
    this.glPassThroughProgram.create();
  }
  
  public void onDrawFrame(int paramInt)
  {
    onPreDrawElements();
    GlUtil.checkGlError("onPreDrawElements");
    this.glPassThroughProgram.use();
    Matrix.setIdentityM(this.projectionMatrix, 0);
    this.plane.uploadTexCoordinateBuffer(this.glPassThroughProgram.getTextureCoordinateHandle());
    this.plane.uploadVerticesBuffer(this.glPassThroughProgram.getPositionHandle());
    GLES20.glUniformMatrix4fv(this.glPassThroughProgram.getMVPMatrixHandle(), 1, false, this.projectionMatrix, 0);
    TextureUtil.bindTexture2D(paramInt, 33984, this.glPassThroughProgram.getTextureSamplerHandle(), 0);
    GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
    this.plane.draw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.PassThroughRenderObj
 * JD-Core Version:    0.7.0.1
 */