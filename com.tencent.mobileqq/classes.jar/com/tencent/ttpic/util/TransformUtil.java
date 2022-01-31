package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.ttpic.model.VideoMaterial;
import java.util.ArrayList;
import java.util.List;

public class TransformUtil
{
  public static List<PointF> getFullPoints(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() < 90)) {
      return new ArrayList();
    }
    paramList.add(new PointF(((PointF)paramList.get(58)).x, ((PointF)paramList.get(57)).y));
    paramList.add(new PointF(((PointF)paramList.get(60)).x, ((PointF)paramList.get(61)).y));
    float f1 = ((PointF)paramList.get(35)).x;
    f1 = (((PointF)paramList.get(36)).x + f1) / 2.0F;
    float f2 = (((PointF)paramList.get(3)).y - ((PointF)paramList.get(2)).y) / 3.0F;
    paramList.add(new PointF(f1, ((PointF)paramList.get(2)).y + f2));
    f1 = ((PointF)paramList.get(45)).x;
    f1 = (((PointF)paramList.get(46)).x + f1) / 2.0F;
    f2 = (((PointF)paramList.get(15)).y - ((PointF)paramList.get(16)).y) / 3.0F;
    paramList.add(new PointF(f1, ((PointF)paramList.get(16)).y + f2));
    f1 = ((PointF)paramList.get(73)).x;
    f1 = (((PointF)paramList.get(81)).x + f1) / 2.0F;
    f2 = ((PointF)paramList.get(73)).y;
    paramList.add(new PointF(f1, (((PointF)paramList.get(81)).y + f2) / 2.0F));
    return paramList;
  }
  
  public static boolean isTransformMaterial(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    while ((paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.TRANSFORM.value) && (paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.TransformUtil
 * JD-Core Version:    0.7.0.1
 */