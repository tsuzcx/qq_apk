package com.tencent.ttpic.filament;

import android.opengl.Matrix;
import android.util.Log;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.MatrixUtil;

public abstract class FurBaseFilter
  extends VideoFilterBase
{
  private static final boolean DEBUG = true;
  private static final String TAG = "FurBaseFilter";
  
  public FurBaseFilter(ShaderCreateFactory.PROGRAM_TYPE paramPROGRAM_TYPE)
  {
    super(ShaderManager.getInstance().getShader(paramPROGRAM_TYPE));
  }
  
  public void updateParams(FurConfig paramFurConfig)
  {
    initAttribParams();
    addAttribParam(new AttributeParam("normal", paramFurConfig.normal, 3));
    Matrix.perspectiveM(new float[16], 0, 45.0F, 1.333333F, 0.1F, 500.0F);
    float[] arrayOfFloat = MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F);
    Object localObject1 = new float[16];
    Matrix.setIdentityM((float[])localObject1, 0);
    Matrix.translateM((float[])localObject1, 0, 0.0F, 0.0F, paramFurConfig.g_fZoom);
    Object localObject2 = new float[16];
    Matrix.setIdentityM((float[])localObject2, 0);
    Matrix.rotateM((float[])localObject2, 0, paramFurConfig.g_fSpinY, 0.0F, 1.0F, 0.0F);
    Matrix.multiplyMM(paramFurConfig.matWorld, 0, (float[])localObject1, 0, (float[])localObject2, 0);
    Matrix.multiplyMM(paramFurConfig.worldViewProjMat, 0, arrayOfFloat, 0, paramFurConfig.matWorld, 0);
    localObject1 = new float[16];
    arrayOfFloat = new float[16];
    int j = 0;
    int i = 0;
    while (j < 4)
    {
      int k = j * 4;
      localObject1[k] = getAttribParam("normal").vertices[i];
      localObject1[(k + 1)] = getAttribParam("normal").vertices[(i + 1)];
      localObject1[(k + 2)] = getAttribParam("normal").vertices[(i + 2)];
      localObject1[(k + 3)] = 1.0F;
      Matrix.multiplyMV(arrayOfFloat, k, paramFurConfig.matWorld, 0, (float[])localObject1, k);
      j += 1;
      i += 3;
    }
    localObject1 = new StringBuilder("[resultVec] \n");
    i = 0;
    while (i < 4)
    {
      j = 0;
      while (j < 4)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(arrayOfFloat[(i * 4 + j)]);
        ((StringBuilder)localObject2).append(", ");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
        j += 1;
      }
      ((StringBuilder)localObject1).append('\n');
      i += 1;
    }
    Log.d(TAG, ((StringBuilder)localObject1).toString());
    addParam(new UniformParam.FloatParam("FurLength", 0.0F));
    addParam(new UniformParam.FloatParam("Layer", 0.0F));
    addParam(new UniformParam.FloatParam("UVScale", 1.0F));
    addParam(new UniformParam.Float3fParam("vGravity", paramFurConfig.g_vGravity[0], paramFurConfig.g_vGravity[1], paramFurConfig.g_vGravity[2]));
    addParam(new UniformParam.Mat4Param("worldViewProj", paramFurConfig.worldViewProjMat));
    addParam(new UniformParam.Mat4Param("matWorld", paramFurConfig.matWorld));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filament.FurBaseFilter
 * JD-Core Version:    0.7.0.1
 */