package com.tencent.ttpic.util;

import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.particle.ParticleConfig;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.AbsolutePositionBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.AngleBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.AngleVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.BlendFuncDestinationBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.BlendFuncSourceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.DurationBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.EmitterTypeBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.FinishColorBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.FinishColorVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.FinishParticleSizeBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.FinishParticleSizeVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.GravityBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.MaxParticlesBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.MaxRadiusBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.MaxRadiusVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.MinRadiusBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.MinRadiusVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.ParticleLifeSpanBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.ParticleLifespanVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.RadialAccelVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.RadialAccelerationBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.RotatePerSecondBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.RotatePerSecondVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.RotationEndBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.RotationEndVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.RotationStartBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.RotationStartVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.SourcePositionBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.SourcePositionVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.SpeedBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.SpeedVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.StartColorBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.StartColorVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.StartParticleSizeBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.StartParticleSizeVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.TangentialAccelVarianceBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.TangentialAccelerationBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.TextureBean;
import com.tencent.ttpic.particle.ParticleConfig.ParticleEmitterConfigBean.YCoordFlippedBean;
import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XmlParseUtils
{
  private static final String TAG = XmlParseUtils.class.getSimpleName();
  
  public static ParticleConfig parseParticleConfig(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      LogUtils.e(TAG, "parseParticleConfig input xml is null");
      return null;
    }
    ParticleConfig localParticleConfig = new ParticleConfig();
    localParticleConfig.setParticleEmitterConfig(new ParticleConfig.ParticleEmitterConfigBean());
    ParticleConfig.ParticleEmitterConfigBean localParticleEmitterConfigBean = localParticleConfig.getParticleEmitterConfig();
    for (;;)
    {
      XmlPullParser localXmlPullParser;
      try
      {
        localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        localXmlPullParser.setInput(new StringReader(paramString));
        i = localXmlPullParser.getEventType();
        if (i == 1) {
          break label2369;
        }
        paramString = localXmlPullParser.getName();
        switch (i)
        {
        }
      }
      catch (XmlPullParserException paramString)
      {
        int i;
        LogUtils.e(TAG, paramString.toString());
        return null;
        if (!"sourcePosition".equals(paramString)) {
          continue;
        }
        paramString = localXmlPullParser.getAttributeValue(null, "x");
        localObject1 = localXmlPullParser.getAttributeValue(null, "y");
        localObject2 = new ParticleConfig.ParticleEmitterConfigBean.SourcePositionBean();
        ((ParticleConfig.ParticleEmitterConfigBean.SourcePositionBean)localObject2).x = Float.parseFloat(paramString);
        ((ParticleConfig.ParticleEmitterConfigBean.SourcePositionBean)localObject2).y = Float.parseFloat((String)localObject1);
        localParticleEmitterConfigBean.setSourcePosition((ParticleConfig.ParticleEmitterConfigBean.SourcePositionBean)localObject2);
        continue;
      }
      catch (IOException paramString)
      {
        LogUtils.e(TAG, paramString.toString());
        return null;
        if (!"particleLifeSpan".equals(paramString)) {
          break label391;
        }
        paramString = localXmlPullParser.getAttributeValue(null, "value");
        localObject1 = new ParticleConfig.ParticleEmitterConfigBean.ParticleLifeSpanBean();
        ((ParticleConfig.ParticleEmitterConfigBean.ParticleLifeSpanBean)localObject1).value = Float.parseFloat(paramString);
        localParticleEmitterConfigBean.setParticleLifeSpan((ParticleConfig.ParticleEmitterConfigBean.ParticleLifeSpanBean)localObject1);
        continue;
      }
      catch (Exception paramString)
      {
        LogUtils.e(TAG, paramString.toString());
        return null;
      }
      i = localXmlPullParser.next();
      continue;
      Object localObject1;
      Object localObject2;
      String str;
      Object localObject3;
      if ("startColor".equals(paramString))
      {
        paramString = localXmlPullParser.getAttributeValue(null, "alpha");
        localObject1 = localXmlPullParser.getAttributeValue(null, "blue");
        localObject2 = localXmlPullParser.getAttributeValue(null, "green");
        str = localXmlPullParser.getAttributeValue(null, "red");
        localObject3 = new ParticleConfig.ParticleEmitterConfigBean.StartColorBean();
        ((ParticleConfig.ParticleEmitterConfigBean.StartColorBean)localObject3).alpha = Float.parseFloat(paramString);
        ((ParticleConfig.ParticleEmitterConfigBean.StartColorBean)localObject3).blue = Float.parseFloat((String)localObject1);
        ((ParticleConfig.ParticleEmitterConfigBean.StartColorBean)localObject3).green = Float.parseFloat((String)localObject2);
        ((ParticleConfig.ParticleEmitterConfigBean.StartColorBean)localObject3).red = Float.parseFloat(str);
        localParticleEmitterConfigBean.setStartColor((ParticleConfig.ParticleEmitterConfigBean.StartColorBean)localObject3);
      }
      else
      {
        label391:
        if ("maxRadius".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.MaxRadiusBean();
          ((ParticleConfig.ParticleEmitterConfigBean.MaxRadiusBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setMaxRadius((ParticleConfig.ParticleEmitterConfigBean.MaxRadiusBean)localObject1);
        }
        else if ("speedVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.SpeedVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.SpeedVarianceBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setSpeedVariance((ParticleConfig.ParticleEmitterConfigBean.SpeedVarianceBean)localObject1);
        }
        else if ("rotatePerSecond".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.RotatePerSecondBean();
          ((ParticleConfig.ParticleEmitterConfigBean.RotatePerSecondBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setRotatePerSecond((ParticleConfig.ParticleEmitterConfigBean.RotatePerSecondBean)localObject1);
        }
        else if ("rotationStart".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.RotationStartBean();
          ((ParticleConfig.ParticleEmitterConfigBean.RotationStartBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setRotationStart((ParticleConfig.ParticleEmitterConfigBean.RotationStartBean)localObject1);
        }
        else if ("duration".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.DurationBean();
          ((ParticleConfig.ParticleEmitterConfigBean.DurationBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setDuration((ParticleConfig.ParticleEmitterConfigBean.DurationBean)localObject1);
        }
        else if ("rotatePerSecondVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.RotatePerSecondVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.RotatePerSecondVarianceBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setRotatePerSecondVariance((ParticleConfig.ParticleEmitterConfigBean.RotatePerSecondVarianceBean)localObject1);
        }
        else if ("tangentialAccelVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.TangentialAccelVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.TangentialAccelVarianceBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setTangentialAccelVariance((ParticleConfig.ParticleEmitterConfigBean.TangentialAccelVarianceBean)localObject1);
        }
        else if ("maxRadiusVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.MaxRadiusVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.MaxRadiusVarianceBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setMaxRadiusVariance((ParticleConfig.ParticleEmitterConfigBean.MaxRadiusVarianceBean)localObject1);
        }
        else if ("radialAccelVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.RadialAccelVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.RadialAccelVarianceBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setRadialAccelVariance((ParticleConfig.ParticleEmitterConfigBean.RadialAccelVarianceBean)localObject1);
        }
        else if ("finishParticleSize".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.FinishParticleSizeBean();
          ((ParticleConfig.ParticleEmitterConfigBean.FinishParticleSizeBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setFinishParticleSize((ParticleConfig.ParticleEmitterConfigBean.FinishParticleSizeBean)localObject1);
        }
        else if ("blendFuncSource".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.BlendFuncSourceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.BlendFuncSourceBean)localObject1).value = Integer.parseInt(paramString);
          localParticleEmitterConfigBean.setBlendFuncSource((ParticleConfig.ParticleEmitterConfigBean.BlendFuncSourceBean)localObject1);
        }
        else if ("yCoordFlipped".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.YCoordFlippedBean();
          ((ParticleConfig.ParticleEmitterConfigBean.YCoordFlippedBean)localObject1).value = Integer.parseInt(paramString);
          localParticleEmitterConfigBean.setYCoordFlipped((ParticleConfig.ParticleEmitterConfigBean.YCoordFlippedBean)localObject1);
        }
        else if ("emitterType".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.EmitterTypeBean();
          ((ParticleConfig.ParticleEmitterConfigBean.EmitterTypeBean)localObject1).value = Integer.parseInt(paramString);
          localParticleEmitterConfigBean.setEmitterType((ParticleConfig.ParticleEmitterConfigBean.EmitterTypeBean)localObject1);
        }
        else if ("texture".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "name");
          localObject1 = localXmlPullParser.getAttributeValue(null, "data");
          localObject2 = new ParticleConfig.ParticleEmitterConfigBean.TextureBean();
          ((ParticleConfig.ParticleEmitterConfigBean.TextureBean)localObject2).name = paramString;
          ((ParticleConfig.ParticleEmitterConfigBean.TextureBean)localObject2).data = ((String)localObject1);
          localParticleEmitterConfigBean.setTexture((ParticleConfig.ParticleEmitterConfigBean.TextureBean)localObject2);
        }
        else if ("minRadiusVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.MinRadiusVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.MinRadiusVarianceBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setMinRadiusVariance((ParticleConfig.ParticleEmitterConfigBean.MinRadiusVarianceBean)localObject1);
        }
        else if ("finishColorVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "alpha");
          localObject1 = localXmlPullParser.getAttributeValue(null, "blue");
          localObject2 = localXmlPullParser.getAttributeValue(null, "green");
          str = localXmlPullParser.getAttributeValue(null, "red");
          localObject3 = new ParticleConfig.ParticleEmitterConfigBean.FinishColorVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorVarianceBean)localObject3).alpha = Float.parseFloat(paramString);
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorVarianceBean)localObject3).blue = Float.parseFloat((String)localObject1);
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorVarianceBean)localObject3).green = Float.parseFloat((String)localObject2);
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorVarianceBean)localObject3).red = Float.parseFloat(str);
          localParticleEmitterConfigBean.setFinishColorVariance((ParticleConfig.ParticleEmitterConfigBean.FinishColorVarianceBean)localObject3);
        }
        else if ("startParticleSizeVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.StartParticleSizeVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.StartParticleSizeVarianceBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setStartParticleSizeVariance((ParticleConfig.ParticleEmitterConfigBean.StartParticleSizeVarianceBean)localObject1);
        }
        else if ("rotationEndVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.RotationEndVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.RotationEndVarianceBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setRotationEndVariance((ParticleConfig.ParticleEmitterConfigBean.RotationEndVarianceBean)localObject1);
        }
        else if ("blendFuncDestination".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.BlendFuncDestinationBean();
          ((ParticleConfig.ParticleEmitterConfigBean.BlendFuncDestinationBean)localObject1).value = Integer.parseInt(paramString);
          localParticleEmitterConfigBean.setBlendFuncDestination((ParticleConfig.ParticleEmitterConfigBean.BlendFuncDestinationBean)localObject1);
        }
        else if ("angle".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.AngleBean();
          ((ParticleConfig.ParticleEmitterConfigBean.AngleBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setAngle((ParticleConfig.ParticleEmitterConfigBean.AngleBean)localObject1);
        }
        else if ("rotationStartVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.RotationStartVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.RotationStartVarianceBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setRotationStartVariance((ParticleConfig.ParticleEmitterConfigBean.RotationStartVarianceBean)localObject1);
        }
        else if ("finishColor".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "alpha");
          localObject1 = localXmlPullParser.getAttributeValue(null, "blue");
          localObject2 = localXmlPullParser.getAttributeValue(null, "green");
          str = localXmlPullParser.getAttributeValue(null, "red");
          localObject3 = new ParticleConfig.ParticleEmitterConfigBean.FinishColorBean();
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorBean)localObject3).alpha = Float.parseFloat(paramString);
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorBean)localObject3).blue = Float.parseFloat((String)localObject1);
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorBean)localObject3).green = Float.parseFloat((String)localObject2);
          ((ParticleConfig.ParticleEmitterConfigBean.FinishColorBean)localObject3).red = Float.parseFloat(str);
          localParticleEmitterConfigBean.setFinishColor((ParticleConfig.ParticleEmitterConfigBean.FinishColorBean)localObject3);
        }
        else if ("absolutePosition".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.AbsolutePositionBean();
          ((ParticleConfig.ParticleEmitterConfigBean.AbsolutePositionBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setAbsolutePosition((ParticleConfig.ParticleEmitterConfigBean.AbsolutePositionBean)localObject1);
        }
        else if ("angleVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.AngleVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.AngleVarianceBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setAngleVariance((ParticleConfig.ParticleEmitterConfigBean.AngleVarianceBean)localObject1);
        }
        else if ("sourcePositionVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "x");
          localObject1 = localXmlPullParser.getAttributeValue(null, "y");
          localObject2 = new ParticleConfig.ParticleEmitterConfigBean.SourcePositionVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.SourcePositionVarianceBean)localObject2).x = Float.parseFloat(paramString);
          ((ParticleConfig.ParticleEmitterConfigBean.SourcePositionVarianceBean)localObject2).y = Float.parseFloat((String)localObject1);
          localParticleEmitterConfigBean.setSourcePositionVariance((ParticleConfig.ParticleEmitterConfigBean.SourcePositionVarianceBean)localObject2);
        }
        else if ("tangentialAcceleration".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.TangentialAccelerationBean();
          ((ParticleConfig.ParticleEmitterConfigBean.TangentialAccelerationBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setTangentialAcceleration((ParticleConfig.ParticleEmitterConfigBean.TangentialAccelerationBean)localObject1);
        }
        else if ("rotationEnd".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.RotationEndBean();
          ((ParticleConfig.ParticleEmitterConfigBean.RotationEndBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setRotationEnd((ParticleConfig.ParticleEmitterConfigBean.RotationEndBean)localObject1);
        }
        else if ("speed".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.SpeedBean();
          ((ParticleConfig.ParticleEmitterConfigBean.SpeedBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setSpeed((ParticleConfig.ParticleEmitterConfigBean.SpeedBean)localObject1);
        }
        else if ("maxParticles".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.MaxParticlesBean();
          ((ParticleConfig.ParticleEmitterConfigBean.MaxParticlesBean)localObject1).value = Integer.parseInt(paramString);
          localParticleEmitterConfigBean.setMaxParticles((ParticleConfig.ParticleEmitterConfigBean.MaxParticlesBean)localObject1);
        }
        else if ("minRadius".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.MinRadiusBean();
          ((ParticleConfig.ParticleEmitterConfigBean.MinRadiusBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setMinRadius((ParticleConfig.ParticleEmitterConfigBean.MinRadiusBean)localObject1);
        }
        else if ("particleLifespanVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.ParticleLifespanVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.ParticleLifespanVarianceBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setParticleLifespanVariance((ParticleConfig.ParticleEmitterConfigBean.ParticleLifespanVarianceBean)localObject1);
        }
        else if ("finishParticleSizeVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.FinishParticleSizeVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.FinishParticleSizeVarianceBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setFinishParticleSizeVariance((ParticleConfig.ParticleEmitterConfigBean.FinishParticleSizeVarianceBean)localObject1);
        }
        else if ("gravity".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "x");
          localObject1 = localXmlPullParser.getAttributeValue(null, "y");
          localObject2 = new ParticleConfig.ParticleEmitterConfigBean.GravityBean();
          ((ParticleConfig.ParticleEmitterConfigBean.GravityBean)localObject2).x = Float.parseFloat(paramString);
          ((ParticleConfig.ParticleEmitterConfigBean.GravityBean)localObject2).y = Float.parseFloat((String)localObject1);
          localParticleEmitterConfigBean.setGravity((ParticleConfig.ParticleEmitterConfigBean.GravityBean)localObject2);
        }
        else if ("radialAcceleration".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.RadialAccelerationBean();
          ((ParticleConfig.ParticleEmitterConfigBean.RadialAccelerationBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setRadialAcceleration((ParticleConfig.ParticleEmitterConfigBean.RadialAccelerationBean)localObject1);
        }
        else if ("startParticleSize".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "value");
          localObject1 = new ParticleConfig.ParticleEmitterConfigBean.StartParticleSizeBean();
          ((ParticleConfig.ParticleEmitterConfigBean.StartParticleSizeBean)localObject1).value = Float.parseFloat(paramString);
          localParticleEmitterConfigBean.setStartParticleSize((ParticleConfig.ParticleEmitterConfigBean.StartParticleSizeBean)localObject1);
        }
        else if ("startColorVariance".equals(paramString))
        {
          paramString = localXmlPullParser.getAttributeValue(null, "alpha");
          localObject1 = localXmlPullParser.getAttributeValue(null, "blue");
          localObject2 = localXmlPullParser.getAttributeValue(null, "green");
          str = localXmlPullParser.getAttributeValue(null, "red");
          localObject3 = new ParticleConfig.ParticleEmitterConfigBean.StartColorVarianceBean();
          ((ParticleConfig.ParticleEmitterConfigBean.StartColorVarianceBean)localObject3).alpha = Float.parseFloat(paramString);
          ((ParticleConfig.ParticleEmitterConfigBean.StartColorVarianceBean)localObject3).blue = Float.parseFloat((String)localObject1);
          ((ParticleConfig.ParticleEmitterConfigBean.StartColorVarianceBean)localObject3).green = Float.parseFloat((String)localObject2);
          ((ParticleConfig.ParticleEmitterConfigBean.StartColorVarianceBean)localObject3).red = Float.parseFloat(str);
          localParticleEmitterConfigBean.setStartColorVariance((ParticleConfig.ParticleEmitterConfigBean.StartColorVarianceBean)localObject3);
          continue;
          label2369:
          paramString = new LinkedBlockingQueue(100);
          try
          {
            paramString.offer("askldf", 10000L, TimeUnit.MILLISECONDS);
            return localParticleConfig;
          }
          catch (Exception paramString)
          {
            return localParticleConfig;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.XmlParseUtils
 * JD-Core Version:    0.7.0.1
 */