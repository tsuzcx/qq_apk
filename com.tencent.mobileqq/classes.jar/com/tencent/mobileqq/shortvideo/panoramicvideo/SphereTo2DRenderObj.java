package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.GLPassThroughProgram;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.TextureUtil;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler;
import com.tencent.mobileqq.shortvideo.panoramicvideo.utils.OrientationHelper;

public class SphereTo2DRenderObj
  extends BaseRenderObj
{
  private GLPassThroughProgram glSphereProgram;
  private volatile boolean mCamereOrientationisFront = true;
  private float mDeltaX = -90.0F;
  private float mDeltaY = 0.0F;
  private float[] mMVPMatrix = new float[16];
  private float mScale = 1.0F;
  private float[] modelMatrix = new float[16];
  private float[] modelViewMatrix = new float[16];
  private OrientationHelper orientationHelper;
  private float[] projectionMatrix = new float[16];
  private float ratio;
  private float[] rotationMatrix = new float[16];
  private SensorEventHandler sensorEventHandler;
  private Sphere sphere = new Sphere(200.0F, 75, 150);
  private float[] viewMatrix = new float[16];
  
  public SphereTo2DRenderObj(Context paramContext)
  {
    this.sensorEventHandler = new SensorEventHandler(paramContext);
    this.sensorEventHandler.setSensorHandlerCallback(new SphereTo2DRenderObj.1(this));
    this.sensorEventHandler.init();
    this.glSphereProgram = new GLPassThroughProgram(paramContext);
    initMatrix();
    this.orientationHelper = new OrientationHelper();
  }
  
  private void initMatrix()
  {
    Matrix.setIdentityM(this.rotationMatrix, 0);
    Matrix.setIdentityM(this.modelMatrix, 0);
    Matrix.setIdentityM(this.projectionMatrix, 0);
    Matrix.setIdentityM(this.viewMatrix, 0);
    Matrix.setLookAtM(this.viewMatrix, 0, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 0.0F);
  }
  
  public void UpdateCameraOrientation(boolean paramBoolean)
  {
    if (paramBoolean == this.mCamereOrientationisFront) {
      return;
    }
    this.mCamereOrientationisFront = paramBoolean;
    if (this.mCamereOrientationisFront)
    {
      Matrix.setLookAtM(this.viewMatrix, 0, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 0.0F);
      return;
    }
    Matrix.setLookAtM(this.viewMatrix, 0, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F);
  }
  
  public void destroy()
  {
    this.glSphereProgram.onDestroy();
    this.sensorEventHandler.releaseResources();
  }
  
  public SensorEventHandler getSensorEventHandler()
  {
    return this.sensorEventHandler;
  }
  
  public void init()
  {
    this.glSphereProgram.create();
  }
  
  public void onDrawFrame(int paramInt)
  {
    GLES20.glEnable(2929);
    this.glSphereProgram.use();
    this.sphere.uploadTexCoordinateBuffer(this.glSphereProgram.getTextureCoordinateHandle());
    this.sphere.uploadVerticesBuffer(this.glSphereProgram.getPositionHandle());
    Math.toDegrees(Math.atan(this.mScale));
    Matrix.perspectiveM(this.projectionMatrix, 0, 75.0F, this.ratio, 3.0F, 300.0F);
    Matrix.setIdentityM(this.modelMatrix, 0);
    this.orientationHelper.recordRotation(this.rotationMatrix);
    System.arraycopy(this.rotationMatrix, 0, this.modelMatrix, 0, 16);
    this.orientationHelper.revertRotation(this.modelMatrix);
    Matrix.multiplyMM(this.modelViewMatrix, 0, this.viewMatrix, 0, this.modelMatrix, 0);
    Matrix.multiplyMM(this.mMVPMatrix, 0, this.projectionMatrix, 0, this.modelViewMatrix, 0);
    GLES20.glUniformMatrix4fv(this.glSphereProgram.getMVPMatrixHandle(), 1, false, this.mMVPMatrix, 0);
    TextureUtil.bindTexture2D(paramInt, 33984, this.glSphereProgram.getTextureSamplerHandle(), 0);
    onPreDrawElements();
    GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
    this.sphere.draw();
    GLES20.glDisable(2929);
  }
  
  public void onRenderObjChanged(int paramInt1, int paramInt2)
  {
    super.onRenderObjChanged(paramInt1, paramInt2);
    this.ratio = (paramInt1 / paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.SphereTo2DRenderObj
 * JD-Core Version:    0.7.0.1
 */