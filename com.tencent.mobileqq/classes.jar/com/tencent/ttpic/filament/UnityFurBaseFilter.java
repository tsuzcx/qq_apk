package com.tencent.ttpic.filament;

import android.opengl.Matrix;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.MatrixUtil;

public abstract class UnityFurBaseFilter
  extends VideoFilterBase
{
  private static final boolean DEBUG = false;
  private static final String TAG = "UnityFurBaseFilter";
  
  public UnityFurBaseFilter(ShaderCreateFactory.PROGRAM_TYPE paramPROGRAM_TYPE)
  {
    super(ShaderManager.getInstance().getShader(paramPROGRAM_TYPE));
  }
  
  public void updateParams(UnityFurConfig paramUnityFurConfig)
  {
    initAttribParams();
    addAttribParam(new AttributeParam("normal", paramUnityFurConfig.normal, 3));
    addAttribParam(new AttributeParam("color", paramUnityFurConfig.color, 4));
    addAttribParam(new AttributeParam("tangent", paramUnityFurConfig.tangent, 3));
    Matrix.perspectiveM(new float[16], 0, 45.0F, 1.333333F, 0.1F, 500.0F);
    float[] arrayOfFloat1 = MatrixUtil.getMVPMatrix(6.0F, 5.0F, 10.0F);
    float[] arrayOfFloat2 = new float[16];
    Matrix.setIdentityM(arrayOfFloat2, 0);
    Matrix.translateM(arrayOfFloat2, 0, 0.0F, 0.0F, paramUnityFurConfig.g_fZoom);
    float[] arrayOfFloat3 = new float[16];
    Matrix.setIdentityM(arrayOfFloat3, 0);
    Matrix.rotateM(arrayOfFloat3, 0, paramUnityFurConfig.g_fSpinY, 0.0F, 1.0F, 0.0F);
    Matrix.multiplyMM(paramUnityFurConfig.matWorld, 0, arrayOfFloat2, 0, arrayOfFloat3, 0);
    Matrix.multiplyMM(paramUnityFurConfig.worldViewProjMat, 0, arrayOfFloat1, 0, paramUnityFurConfig.matWorld, 0);
    arrayOfFloat1 = new float[16];
    arrayOfFloat1 = new float[16];
    addParam(new UniformParam.FloatParam("FUR_OFFSET", paramUnityFurConfig.FUR_OFFSET));
    addParam(new UniformParam.Float2fParam("_Time", paramUnityFurConfig._Time[0], paramUnityFurConfig._Time[1]));
    addParam(new UniformParam.FloatParam("_Spacing", paramUnityFurConfig._Spacing));
    addParam(new UniformParam.Mat4Param("worldViewProj", paramUnityFurConfig.worldViewProjMat));
    addParam(new UniformParam.Mat4Param("matWorld", paramUnityFurConfig.matWorld));
    addParam(new UniformParam.TextureParam("_SubTex", paramUnityFurConfig._SubTex, 33986));
    addParam(new UniformParam.Float3fParam("_WorldSpaceCameraPos", paramUnityFurConfig._WorldSpaceCameraPos[0], paramUnityFurConfig._WorldSpaceCameraPos[1], paramUnityFurConfig._WorldSpaceCameraPos[2]));
    addParam(new UniformParam.Float3fParam("_SGameShadowParams", paramUnityFurConfig._SGameShadowParams[0], paramUnityFurConfig._SGameShadowParams[1], paramUnityFurConfig._SGameShadowParams[2]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filament.UnityFurBaseFilter
 * JD-Core Version:    0.7.0.1
 */