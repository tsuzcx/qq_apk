package com.tencent.ttpic.particle;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.GsonUtils;
import java.util.ArrayList;

public class ParticleJsonParser
{
  private static final String TAG = ParticleJsonParser.class.getSimpleName();
  
  public static ParticleConfig parseParticleConfig(String paramString1, String paramString2)
  {
    ParticleConfig localParticleConfig = new ParticleConfig();
    localParticleConfig.setParticleEmitterConfig(new ParticleConfig.ParticleEmitterConfigBean());
    ParticleConfig.ParticleEmitterConfigBean localParticleEmitterConfigBean = localParticleConfig.getParticleEmitterConfig();
    try
    {
      paramString1 = GsonUtils.json2JsonObject(VideoTemplateParser.readMaterialFile(paramString1, paramString2.split("\\.")[0], true, null));
      if (paramString1 == null) {
        return null;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        paramString1 = null;
      }
      try
      {
        paramString2 = GsonUtils.optJsonArray(paramString1, "sourcePosition");
        Object localObject;
        if (paramString2 != null)
        {
          localObject = new ParticleConfig.ParticleEmitterConfigBean.SourcePositionBean();
          ((ParticleConfig.ParticleEmitterConfigBean.SourcePositionBean)localObject).x = GsonUtils.getFloatSafe(paramString2, 0);
          ((ParticleConfig.ParticleEmitterConfigBean.SourcePositionBean)localObject).y = GsonUtils.getFloatSafe(paramString2, 1);
          ((ParticleConfig.ParticleEmitterConfigBean.SourcePositionBean)localObject).z = GsonUtils.getFloatSafe(paramString2, 2);
          localParticleEmitterConfigBean.setSourcePosition((ParticleConfig.ParticleEmitterConfigBean.SourcePositionBean)localObject);
        }
        paramString2 = GsonUtils.optJsonArray(paramString1, "sourcePositionVariance");
        if (paramString2 != null)
        {
          localObject = new ParticleConfig.ParticleEmitterConfigBean.SourcePositionVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.SourcePositionVarianceBean)localObject).x = GsonUtils.getFloatSafe(paramString2, 0);
          ((ParticleConfig.ParticleEmitterConfigBean.SourcePositionVarianceBean)localObject).y = GsonUtils.getFloatSafe(paramString2, 1);
          ((ParticleConfig.ParticleEmitterConfigBean.SourcePositionVarianceBean)localObject).z = GsonUtils.getFloatSafe(paramString2, 2);
          localParticleEmitterConfigBean.setSourcePositionVariance((ParticleConfig.ParticleEmitterConfigBean.SourcePositionVarianceBean)localObject);
        }
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.SpeedBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "speed");
        localParticleEmitterConfigBean.setSpeed(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.SpeedVarianceBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "speedVariance");
        localParticleEmitterConfigBean.setSpeedVariance(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.ParticleLifeSpanBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "particleLifeSpan");
        localParticleEmitterConfigBean.setParticleLifeSpan(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.ParticleLifespanVarianceBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "particleLifespanVariance");
        localParticleEmitterConfigBean.setParticleLifespanVariance(paramString2);
        paramString2 = GsonUtils.optJsonArray(paramString1, "emissionVector");
        if (paramString2 != null) {
          localParticleEmitterConfigBean.emission3DVector = new ParticleConfig.ParticleEmitterConfigBean.Emission3DVector(GsonUtils.getFloatSafe(paramString2, 0), GsonUtils.getFloatSafe(paramString2, 1), GsonUtils.getFloatSafe(paramString2, 2));
        }
        paramString2 = GsonUtils.optJsonArray(paramString1, "emissionVectorVariance");
        if (paramString2 != null) {
          localParticleEmitterConfigBean.emission3DVectorVariance = new ParticleConfig.ParticleEmitterConfigBean.Emission3DVectorVariance(GsonUtils.getFloatSafe(paramString2, 0), GsonUtils.getFloatSafe(paramString2, 1), GsonUtils.getFloatSafe(paramString2, 2));
        }
        paramString2 = GsonUtils.optJsonArray(paramString1, "gravity");
        if (paramString2 != null)
        {
          localObject = new ParticleConfig.ParticleEmitterConfigBean.GravityBean();
          ((ParticleConfig.ParticleEmitterConfigBean.GravityBean)localObject).x = GsonUtils.getFloatSafe(paramString2, 0);
          ((ParticleConfig.ParticleEmitterConfigBean.GravityBean)localObject).y = GsonUtils.getFloatSafe(paramString2, 1);
          ((ParticleConfig.ParticleEmitterConfigBean.GravityBean)localObject).z = GsonUtils.getFloatSafe(paramString2, 2);
          localParticleEmitterConfigBean.setGravity((ParticleConfig.ParticleEmitterConfigBean.GravityBean)localObject);
        }
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.RadialAccelerationBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "radialAcceleration");
        localParticleEmitterConfigBean.setRadialAcceleration(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.TangentialAccelerationBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "tangentialAcceleration");
        localParticleEmitterConfigBean.setTangentialAcceleration(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.RadialAccelVarianceBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "radialAccelVariance");
        localParticleEmitterConfigBean.setRadialAccelVariance(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.TangentialAccelVarianceBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "tangentialAccelVariance");
        localParticleEmitterConfigBean.setTangentialAccelVariance(paramString2);
        paramString2 = GsonUtils.optJsonArray(paramString1, "startColor");
        if (paramString2 != null)
        {
          localObject = new ParticleConfig.ParticleEmitterConfigBean.StartColorBean();
          ((ParticleConfig.ParticleEmitterConfigBean.StartColorBean)localObject).red = GsonUtils.getFloatSafe(paramString2, 0);
          ((ParticleConfig.ParticleEmitterConfigBean.StartColorBean)localObject).green = GsonUtils.getFloatSafe(paramString2, 1);
          ((ParticleConfig.ParticleEmitterConfigBean.StartColorBean)localObject).blue = GsonUtils.getFloatSafe(paramString2, 2);
          ((ParticleConfig.ParticleEmitterConfigBean.StartColorBean)localObject).alpha = GsonUtils.getFloatSafe(paramString2, 3);
          localParticleEmitterConfigBean.setStartColor((ParticleConfig.ParticleEmitterConfigBean.StartColorBean)localObject);
        }
        paramString2 = GsonUtils.optJsonArray(paramString1, "startColorVariance");
        if (paramString2 != null)
        {
          localObject = new ParticleConfig.ParticleEmitterConfigBean.StartColorVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.StartColorVarianceBean)localObject).red = GsonUtils.getFloatSafe(paramString2, 0);
          ((ParticleConfig.ParticleEmitterConfigBean.StartColorVarianceBean)localObject).green = GsonUtils.getFloatSafe(paramString2, 1);
          ((ParticleConfig.ParticleEmitterConfigBean.StartColorVarianceBean)localObject).blue = GsonUtils.getFloatSafe(paramString2, 2);
          ((ParticleConfig.ParticleEmitterConfigBean.StartColorVarianceBean)localObject).alpha = GsonUtils.getFloatSafe(paramString2, 3);
          localParticleEmitterConfigBean.setStartColorVariance((ParticleConfig.ParticleEmitterConfigBean.StartColorVarianceBean)localObject);
        }
        paramString2 = GsonUtils.optJsonArray(paramString1, "finishColor");
        if (paramString2 != null)
        {
          localObject = new ParticleConfig.ParticleEmitterConfigBean.FinishColorBean();
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorBean)localObject).red = GsonUtils.getFloatSafe(paramString2, 0);
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorBean)localObject).green = GsonUtils.getFloatSafe(paramString2, 1);
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorBean)localObject).blue = GsonUtils.getFloatSafe(paramString2, 2);
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorBean)localObject).alpha = GsonUtils.getFloatSafe(paramString2, 3);
          localParticleEmitterConfigBean.setFinishColor((ParticleConfig.ParticleEmitterConfigBean.FinishColorBean)localObject);
        }
        paramString2 = GsonUtils.optJsonArray(paramString1, "finishColorVariance");
        if (paramString2 != null)
        {
          localObject = new ParticleConfig.ParticleEmitterConfigBean.FinishColorVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorVarianceBean)localObject).red = GsonUtils.getFloatSafe(paramString2, 0);
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorVarianceBean)localObject).green = GsonUtils.getFloatSafe(paramString2, 1);
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorVarianceBean)localObject).blue = GsonUtils.getFloatSafe(paramString2, 2);
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorVarianceBean)localObject).alpha = GsonUtils.getFloatSafe(paramString2, 3);
          localParticleEmitterConfigBean.setFinishColorVariance((ParticleConfig.ParticleEmitterConfigBean.FinishColorVarianceBean)localObject);
        }
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.MaxParticlesBean();
        paramString2.value = GsonUtils.optInt(paramString1, "maxParticles");
        localParticleEmitterConfigBean.setMaxParticles(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.StartParticleSizeBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "startParticleSize");
        localParticleEmitterConfigBean.setStartParticleSize(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.StartParticleSizeVarianceBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "startParticleSizeVariance");
        localParticleEmitterConfigBean.setStartParticleSizeVariance(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.FinishParticleSizeBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "finishParticleSize");
        localParticleEmitterConfigBean.setFinishParticleSize(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.FinishParticleSizeVarianceBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "finishParticleSizeVariance");
        localParticleEmitterConfigBean.setFinishParticleSizeVariance(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.DurationBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "duration");
        localParticleEmitterConfigBean.setDuration(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.EmitterTypeBean();
        paramString2.value = GsonUtils.optInt(paramString1, "emitterType");
        localParticleEmitterConfigBean.setEmitterType(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.MaxRadiusBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "maxRadius");
        localParticleEmitterConfigBean.setMaxRadius(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.MaxRadiusVarianceBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "maxRadiusVariance");
        localParticleEmitterConfigBean.setMaxRadiusVariance(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.MinRadiusBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "minRadius");
        localParticleEmitterConfigBean.setMinRadius(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.MinRadiusVarianceBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "minRadiusVariance");
        localParticleEmitterConfigBean.setMinRadiusVariance(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.RotatePerSecondBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "rotatePerSecond");
        localParticleEmitterConfigBean.setRotatePerSecond(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.RotatePerSecondVarianceBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "rotatePerSecondVariance");
        localParticleEmitterConfigBean.setRotatePerSecondVariance(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.BlendFuncSourceBean();
        paramString2.value = GsonUtils.optInt(paramString1, "blendFuncSource");
        localParticleEmitterConfigBean.setBlendFuncSource(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.BlendFuncDestinationBean();
        paramString2.value = GsonUtils.optInt(paramString1, "blendFuncDestination");
        localParticleEmitterConfigBean.setBlendFuncDestination(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.RotationStartBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "rotationStart");
        localParticleEmitterConfigBean.setRotationStart(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.RotationStartVarianceBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "rotationStartVariance");
        localParticleEmitterConfigBean.setRotationStartVariance(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.RotationEndBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "rotationEnd");
        localParticleEmitterConfigBean.setRotationEnd(paramString2);
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.RotationEndVarianceBean();
        paramString2.value = GsonUtils.optFloat(paramString1, "rotationEndVariance");
        localParticleEmitterConfigBean.setRotationEndVariance(paramString2);
        paramString2 = GsonUtils.optJsonArray(paramString1, "spriteList");
        if (paramString2 != null)
        {
          localParticleEmitterConfigBean.sprites = new ArrayList();
          int i = 0;
          while (i < paramString2.size())
          {
            localObject = GsonUtils.getJsonObjectUnsafe(paramString2, i);
            ParticleConfig.ParticleEmitterConfigBean.Sprite localSprite = new ParticleConfig.ParticleEmitterConfigBean.Sprite();
            localSprite.width = GsonUtils.optInt((JsonObject)localObject, "width");
            localSprite.height = GsonUtils.optInt((JsonObject)localObject, "height");
            localSprite.imageWidth = GsonUtils.optInt((JsonObject)localObject, "imageWidth");
            localSprite.imageHeight = GsonUtils.optInt((JsonObject)localObject, "imageHeight");
            localSprite.looped = GsonUtils.optInt((JsonObject)localObject, "looped");
            localSprite.row = GsonUtils.optInt((JsonObject)localObject, "row");
            localSprite.column = GsonUtils.optInt((JsonObject)localObject, "column");
            localSprite.path = GsonUtils.optString((JsonObject)localObject, "path");
            localSprite.frameDuration = GsonUtils.optInt((JsonObject)localObject, "frameDuration");
            localParticleEmitterConfigBean.sprites.add(localSprite);
            i += 1;
          }
        }
        paramString2 = new ParticleConfig.ParticleEmitterConfigBean.ParticlePath();
        paramString2.path = GsonUtils.optString(paramString1, "particlePath");
        localParticleEmitterConfigBean.setParticlePath(paramString2);
        localParticleEmitterConfigBean.emissionRate = GsonUtils.optInt(paramString1, "emissionRate");
        return localParticleConfig;
      }
      catch (Throwable paramString1)
      {
        LogUtils.e(TAG, paramString1.toString());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleJsonParser
 * JD-Core Version:    0.7.0.1
 */