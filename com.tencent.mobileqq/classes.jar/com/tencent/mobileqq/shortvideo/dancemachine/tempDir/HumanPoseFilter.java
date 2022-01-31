package com.tencent.mobileqq.shortvideo.dancemachine.tempDir;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.PoseDataConvert;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f;
import java.util.ArrayList;
import java.util.List;

public class HumanPoseFilter
{
  public static boolean a;
  private float jdField_a_of_type_Float;
  private DebugModeLine jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTempDirDebugModeLine = null;
  private List jdField_a_of_type_JavaUtilList = new ArrayList(18);
  private float jdField_b_of_type_Float;
  private List jdField_b_of_type_JavaUtilList = new ArrayList(18);
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public HumanPoseFilter(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  public void a()
  {
    if (jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTempDirDebugModeLine = new DebugModeLine();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  public void a(RenderBuffer paramRenderBuffer)
  {
    int i = paramRenderBuffer.b();
    int j = paramRenderBuffer.c();
    if (jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTempDirDebugModeLine.a(i, j);
    }
  }
  
  public void a(RenderBuffer paramRenderBuffer, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = PoseDataConvert.a(paramArrayOfFloat, paramRenderBuffer.b(), paramRenderBuffer.c(), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
    int j = arrayOfFloat.length / 3;
    if (this.jdField_a_of_type_JavaUtilList.size() < j)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_JavaUtilList.add(new Vec3f());
        i += 1;
      }
    }
    if (this.jdField_b_of_type_JavaUtilList.size() < j)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      i = 0;
      while (i < j)
      {
        this.jdField_b_of_type_JavaUtilList.add(new Vec3f());
        i += 1;
      }
    }
    int i = 0;
    while (i < j)
    {
      paramArrayOfFloat = (Vec3f)this.jdField_a_of_type_JavaUtilList.get(i);
      paramRenderBuffer = paramArrayOfFloat;
      if (paramArrayOfFloat == null)
      {
        paramRenderBuffer = new Vec3f();
        this.jdField_a_of_type_JavaUtilList.set(i, paramRenderBuffer);
      }
      paramRenderBuffer.a(arrayOfFloat[(i * 3)], arrayOfFloat[(i * 3 + 1)], arrayOfFloat[(i * 3 + 2)]);
      paramArrayOfFloat = (Vec3f)this.jdField_b_of_type_JavaUtilList.get(i);
      paramRenderBuffer = paramArrayOfFloat;
      if (paramArrayOfFloat == null)
      {
        paramRenderBuffer = new Vec3f();
        this.jdField_b_of_type_JavaUtilList.set(i, paramRenderBuffer);
      }
      paramRenderBuffer.a(arrayOfFloat[(i * 3)], arrayOfFloat[(i * 3 + 1)], arrayOfFloat[(i * 3 + 2)]);
      i += 1;
    }
    if (((((Vec3f)this.jdField_a_of_type_JavaUtilList.get(0)).c > 0.0F) || (((Vec3f)this.jdField_a_of_type_JavaUtilList.get(14)).c <= 0.0F) || (((Vec3f)this.jdField_a_of_type_JavaUtilList.get(15)).c > 0.0F)) || (jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTempDirDebugModeLine.a(this.jdField_b_of_type_JavaUtilList);
    }
  }
  
  public void b(RenderBuffer paramRenderBuffer)
  {
    paramRenderBuffer.b();
    GLES20.glEnable(2884);
    GLES20.glFrontFace(2305);
    GLES20.glCullFace(1029);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    if (jdField_a_of_type_Boolean)
    {
      GLES20.glFinish();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineTempDirDebugModeLine.a();
    }
    GLES20.glDisable(3042);
    GLES20.glDisable(2884);
    paramRenderBuffer.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.tempDir.HumanPoseFilter
 * JD-Core Version:    0.7.0.1
 */