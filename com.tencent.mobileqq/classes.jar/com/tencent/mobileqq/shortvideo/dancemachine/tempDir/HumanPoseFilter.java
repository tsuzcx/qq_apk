package com.tencent.mobileqq.shortvideo.dancemachine.tempDir;

import android.opengl.GLES20;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.PoseDataConvert;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.List;

public class HumanPoseFilter
{
  public static boolean ENABLE_DEBUG_MODE = true;
  private List<Vec3f> cachePoints = new ArrayList(18);
  private DebugModeLine debugMode = null;
  private List<Vec3f> facePoints = new ArrayList(18);
  private float poseHeight;
  private float poseWidth;
  
  public HumanPoseFilter(float paramFloat1, float paramFloat2)
  {
    this.poseWidth = paramFloat1;
    this.poseHeight = paramFloat2;
  }
  
  public void drawFrame(RenderBuffer paramRenderBuffer)
  {
    paramRenderBuffer.bind();
    GLES20.glEnable(2884);
    GLES20.glFrontFace(2305);
    GLES20.glCullFace(1029);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    if (ENABLE_DEBUG_MODE)
    {
      GLES20.glFinish();
      this.debugMode.draw();
    }
    GLES20.glDisable(3042);
    GLES20.glDisable(2884);
    paramRenderBuffer.unbind();
  }
  
  public List<Vec3f> getPosePoints()
  {
    return this.cachePoints;
  }
  
  public void initHumanFilter()
  {
    if (ENABLE_DEBUG_MODE) {
      this.debugMode = new DebugModeLine();
    }
  }
  
  public void updateFboSize(RenderBuffer paramRenderBuffer)
  {
    int i = paramRenderBuffer.getWidth();
    int j = paramRenderBuffer.getHeight();
    if (ENABLE_DEBUG_MODE) {
      this.debugMode.updateFboSize(i, j);
    }
  }
  
  public void updateParams(RenderBuffer paramRenderBuffer, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = PoseDataConvert.convertPointsToFrameCoordinate(paramArrayOfFloat, paramRenderBuffer.getWidth(), paramRenderBuffer.getHeight(), this.poseWidth, this.poseHeight);
    int j = arrayOfFloat.length / 3;
    if (this.facePoints.size() < j)
    {
      this.facePoints.clear();
      i = 0;
      while (i < j)
      {
        this.facePoints.add(new Vec3f());
        i += 1;
      }
    }
    if (this.cachePoints.size() < j)
    {
      this.cachePoints.clear();
      i = 0;
      while (i < j)
      {
        this.cachePoints.add(new Vec3f());
        i += 1;
      }
    }
    int i = 0;
    float f1;
    while (i < j)
    {
      paramArrayOfFloat = (Vec3f)this.facePoints.get(i);
      paramRenderBuffer = paramArrayOfFloat;
      if (paramArrayOfFloat == null)
      {
        paramRenderBuffer = new Vec3f();
        this.facePoints.set(i, paramRenderBuffer);
      }
      int k = i * 3;
      f1 = arrayOfFloat[k];
      int m = k + 1;
      float f2 = arrayOfFloat[m];
      int n = k + 2;
      paramRenderBuffer.set(f1, f2, arrayOfFloat[n]);
      paramArrayOfFloat = (Vec3f)this.cachePoints.get(i);
      paramRenderBuffer = paramArrayOfFloat;
      if (paramArrayOfFloat == null)
      {
        paramRenderBuffer = new Vec3f();
        this.cachePoints.set(i, paramRenderBuffer);
      }
      paramRenderBuffer.set(arrayOfFloat[k], arrayOfFloat[m], arrayOfFloat[n]);
      i += 1;
    }
    if ((((Vec3f)this.facePoints.get(0)).z <= 0.0F) && (((Vec3f)this.facePoints.get(14)).z > 0.0F)) {
      f1 = ((Vec3f)this.facePoints.get(15)).z;
    }
    if (ENABLE_DEBUG_MODE) {
      this.debugMode.updateParams(this.cachePoints);
    }
  }
  
  public void updatePoseSize(float paramFloat1, float paramFloat2)
  {
    this.poseWidth = paramFloat1;
    this.poseHeight = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.tempDir.HumanPoseFilter
 * JD-Core Version:    0.7.0.1
 */