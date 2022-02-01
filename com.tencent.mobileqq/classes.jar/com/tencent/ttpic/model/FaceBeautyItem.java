package com.tencent.ttpic.model;

import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.HashMap;
import java.util.Map;

public class FaceBeautyItem
  extends FaceMeshItem
{
  public Map<BeautyRealConfig.TYPE, Integer> beautyValues = new HashMap();
  
  public Map<BeautyRealConfig.TYPE, Integer> getBeautyValues()
  {
    return this.beautyValues;
  }
  
  public void putBeautyValues(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    int i;
    do
    {
      return;
      i = 0;
      try
      {
        float f = Float.parseFloat(paramString2);
        i = (int)(f * 100.0F);
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          LogUtils.e(paramString2);
        }
        if (!paramString1.equals("vFace")) {
          continue;
        }
        this.beautyValues.put(BeautyRealConfig.TYPE.FACE_V, Integer.valueOf(i));
        return;
        if (!paramString1.equals("chin")) {
          continue;
        }
        this.beautyValues.put(BeautyRealConfig.TYPE.CHIN, Integer.valueOf(i));
        return;
        if (!paramString1.equals("thinFace")) {
          continue;
        }
        this.beautyValues.put(BeautyRealConfig.TYPE.FACE_THIN, Integer.valueOf(i));
        return;
        if (!paramString1.equals("shortFace")) {
          continue;
        }
        this.beautyValues.put(BeautyRealConfig.TYPE.FACE_SHORTEN, Integer.valueOf(i));
        return;
        if (!paramString1.equals("enlargeEye")) {
          continue;
        }
        this.beautyValues.put(BeautyRealConfig.TYPE.EYE, Integer.valueOf(i));
        return;
        if (!paramString1.equals("thinNose")) {
          continue;
        }
        this.beautyValues.put(BeautyRealConfig.TYPE.NOSE, Integer.valueOf(i));
        return;
        if (!paramString1.equals("eyeLighten")) {
          continue;
        }
        this.beautyValues.put(BeautyRealConfig.TYPE.EYE_LIGHTEN, Integer.valueOf(i));
        return;
        if (!paramString1.equals("setupForeHead")) {
          continue;
        }
        this.beautyValues.put(BeautyRealConfig.TYPE.FOREHEAD, Integer.valueOf(i));
        return;
        if (!paramString1.equals("eyeDistance")) {
          continue;
        }
        this.beautyValues.put(BeautyRealConfig.TYPE.EYE_DISTANCE, Integer.valueOf(i));
        return;
        if (!paramString1.equals("eyeAngle")) {
          continue;
        }
        this.beautyValues.put(BeautyRealConfig.TYPE.EYE_ANGLE, Integer.valueOf(i));
        return;
        if (!paramString1.equals("noseAngle")) {
          continue;
        }
        this.beautyValues.put(BeautyRealConfig.TYPE.NOSE_WING, Integer.valueOf(i));
        return;
        if (!paramString1.equals("noseHeight")) {
          continue;
        }
        this.beautyValues.put(BeautyRealConfig.TYPE.NOSE_POSITION, Integer.valueOf(i));
        return;
        if (!paramString1.equals("mouthSize")) {
          continue;
        }
        this.beautyValues.put(BeautyRealConfig.TYPE.MOUTH_SHAPE, Integer.valueOf(i));
        return;
      }
      if (paramString1.equals("basicFace"))
      {
        this.beautyValues.put(BeautyRealConfig.TYPE.BASIC3, Integer.valueOf(i));
        this.beautyValues.put(BeautyRealConfig.TYPE.BASIC4, Integer.valueOf(i));
        return;
      }
    } while (!paramString1.equals("mouthHeight"));
    this.beautyValues.put(BeautyRealConfig.TYPE.LIPS_THICKNESS, Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.model.FaceBeautyItem
 * JD-Core Version:    0.7.0.1
 */