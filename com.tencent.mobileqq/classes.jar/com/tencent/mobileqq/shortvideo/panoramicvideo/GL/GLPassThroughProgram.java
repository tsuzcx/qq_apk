package com.tencent.mobileqq.shortvideo.panoramicvideo.GL;

import android.content.Context;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public class GLPassThroughProgram
  extends GLProgram
{
  private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor=texture2D(sTexture, vTextureCoord);\n}\n";
  private static final String VERTEX_SHADER = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nuniform mat4 uMVPMatrix;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}\n";
  private int uMVPMatrixHandle;
  private int uTextureSamplerHandle;
  
  public GLPassThroughProgram(Context paramContext)
  {
    super(paramContext, "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nuniform mat4 uMVPMatrix;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor=texture2D(sTexture, vTextureCoord);\n}\n");
  }
  
  public void create()
  {
    super.create();
    this.uTextureSamplerHandle = GLES20.glGetUniformLocation(getProgramId(), "sTexture");
    GlUtil.checkGlError("glGetUniformLocation uniform sTexture");
    this.uMVPMatrixHandle = GLES20.glGetUniformLocation(getProgramId(), "uMVPMatrix");
    GlUtil.checkGlError("glGetUniformLocation uMVPMatrix");
  }
  
  public int getMVPMatrixHandle()
  {
    return this.uMVPMatrixHandle;
  }
  
  public int getTextureSamplerHandle()
  {
    return this.uTextureSamplerHandle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.GL.GLPassThroughProgram
 * JD-Core Version:    0.7.0.1
 */