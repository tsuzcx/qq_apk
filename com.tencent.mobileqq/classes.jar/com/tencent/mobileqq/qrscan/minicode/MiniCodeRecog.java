package com.tencent.mobileqq.qrscan.minicode;

import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLES31;
import android.opengl.Matrix;
import com.tencent.mobileqq.minicode.RecogProxy;
import com.tencent.mobileqq.qrscan.AIRect;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.ArrayList;
import java.util.List;

public class MiniCodeRecog
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 0L;
  private MiniParam jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniParam;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = "MiniRecog.recog";
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat;
  
  public MiniCodeRecog(MiniParam paramMiniParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniParam = paramMiniParam;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.jdField_a_of_type_Int = GlUtil.a(paramMiniParam.jdField_c_of_type_Int, paramMiniParam.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramMiniParam.jdField_c_of_type_Int, paramMiniParam.jdField_b_of_type_Int);
    MiniCodeUtil.b(false);
    this.jdField_a_of_type_Long = RecogProxy.QCodeInit(this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniParam.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniParam.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniParam.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniParam.d, 0.35F);
    QLog.i("MiniRecog.recog", 1, String.format("RecogProxy.QCodeInit native_handler=0x%x", new Object[] { Long.valueOf(this.jdField_a_of_type_Long) }));
    if (this.jdField_a_of_type_Long != 0L) {
      MiniCodeUtil.c(false);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private Rect a(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if (paramInt1 > paramInt2) {
      i = 0;
    } else {
      i = 1;
    }
    float f1 = paramArrayOfFloat[i];
    float f2 = this.jdField_a_of_type_Float;
    paramArrayOfFloat[i] = ((f1 - 0.5F) / f2 + 0.5F);
    i += 2;
    paramArrayOfFloat[i] = ((paramArrayOfFloat[i] - 0.5F) / f2 + 0.5F);
    f1 = paramArrayOfFloat[0];
    f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    paramArrayOfFloat[0] = (1.0F - (f1 - 0.02F) * 2.0F);
    paramArrayOfFloat[1] = ((f2 - 0.02F) * 2.0F - 1.0F);
    paramArrayOfFloat[2] = (1.0F - (f3 + 0.02F) * 2.0F);
    paramArrayOfFloat[3] = ((f4 + 0.02F) * 2.0F - 1.0F);
    int i = 0;
    while (i < 4)
    {
      if (paramArrayOfFloat[i] > 1.0F) {
        paramArrayOfFloat[i] = 1.0F;
      } else if (paramArrayOfFloat[i] < -1.0F) {
        paramArrayOfFloat[i] = -1.0F;
      }
      i += 1;
    }
    f2 = paramArrayOfFloat[0];
    f1 = paramInt2;
    paramInt2 = (int)(f2 * 0.5F * f1);
    i = (int)(paramArrayOfFloat[2] * 0.5F * f1);
    f2 = paramArrayOfFloat[1];
    f3 = paramInt1;
    int j = (int)(f2 * 0.5F * f3);
    int k = (int)(paramArrayOfFloat[3] * 0.5F * f3);
    int m = Math.abs(k - j);
    int n = Math.abs(i - paramInt2);
    paramInt1 = k;
    if (j < k) {
      paramInt1 = j;
    }
    if (paramInt2 <= i) {
      paramInt2 = i;
    }
    paramInt1 = (int)(paramInt1 + f3 * 0.5F);
    paramInt2 = (int)(f1 * 0.5F - paramInt2);
    paramArrayOfFloat = new Rect();
    paramArrayOfFloat.left = paramInt1;
    paramArrayOfFloat.top = paramInt2;
    paramArrayOfFloat.right = (paramInt1 + m);
    paramArrayOfFloat.bottom = (paramInt2 + n);
    return paramArrayOfFloat;
  }
  
  public List<AIRect> a(int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    if (paramInt2 > paramInt3)
    {
      this.jdField_a_of_type_Float = (paramInt3 / paramInt2);
      Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_Float, 1.0F, 1.0F);
    }
    else
    {
      this.jdField_a_of_type_Float = (paramInt2 / paramInt3);
      Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, 1.0F, this.jdField_a_of_type_Float, 1.0F);
    }
    Matrix.rotateM(this.jdField_a_of_type_ArrayOfFloat, 0, 180.0F, 1.0F, 0.0F, 0.0F);
    Matrix.rotateM(this.jdField_a_of_type_ArrayOfFloat, 0, -90.0F, 0.0F, 0.0F, 1.0F);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.setUserTextureId(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    GLES31.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES31.glClear(16384);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt1, null, this.jdField_a_of_type_ArrayOfFloat);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    GLES20.glFlush();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Long != 0L)
        {
          RecogProxy.QCodeProcess(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, 0);
          j = RecogProxy.getBoxCnt(this.jdField_a_of_type_Long);
          int i = j;
          if (j < 2) {
            break label695;
          }
          i = 2;
          break label695;
          if (j < i)
          {
            localObject2 = new float[5];
            localObject2[0] = 0.0F;
            localObject2[1] = 0.0F;
            localObject2[2] = 0.0F;
            localObject2[3] = 0.0F;
            localObject2[4] = 0.0F;
            int k = RecogProxy.getBox(this.jdField_a_of_type_Long, j, (float[])localObject2);
            int m = RecogProxy.getBoxType(this.jdField_a_of_type_Long, j);
            if ((k < 0) || (m < 0)) {
              break label701;
            }
            if (QLog.isDevelopLevel()) {
              QLog.i("MiniRecog.recog", 2, String.format("debug_minicode_point=[%f,%f,%f,%f,%f,%d]", new Object[] { Float.valueOf(localObject2[0]), Float.valueOf(localObject2[1]), Float.valueOf(localObject2[2]), Float.valueOf(localObject2[3]), Float.valueOf(localObject2[4]), Integer.valueOf(m) }));
            }
            localObject3 = a(paramInt2, paramInt3, (float[])localObject2);
            AIRect localAIRect = new AIRect();
            localAIRect.jdField_a_of_type_AndroidGraphicsRect.set((Rect)localObject3);
            localAIRect.jdField_a_of_type_Int = m;
            localAIRect.jdField_a_of_type_Float = localObject2[4];
            localArrayList.add(localAIRect);
            break label701;
          }
        }
        if (paramBoolean)
        {
          Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
          if (paramInt2 > paramInt3) {
            Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_Float, 1.0F, 1.0F);
          } else {
            Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, 1.0F, this.jdField_a_of_type_Float, 1.0F);
          }
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.setUserTextureId(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
          GLES31.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          GLES31.glClear(16384);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt1, null, this.jdField_a_of_type_ArrayOfFloat);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          GLES20.glFlush();
        }
      }
      label695:
      int j = 0;
      continue;
      label701:
      j += 1;
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
    if (localObject != null) {
      ((TextureRender)localObject).release();
    }
    int i = this.jdField_a_of_type_Int;
    if (i >= 0)
    {
      GlUtils.a(i);
      this.jdField_a_of_type_Int = -1;
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    if (this.jdField_a_of_type_Long != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.recog", 2, String.format("RecogProxy.QCodeDestroy native_handler=0x%x", new Object[] { Long.valueOf(this.jdField_a_of_type_Long) }));
      }
      RecogProxy.QCodeDestroy(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Long = 0L;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Long != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniCodeRecog
 * JD-Core Version:    0.7.0.1
 */