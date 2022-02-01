package com.tencent.ttpic.util;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

public class TransformUtil
{
  public static List<PointF> getFullPoints(List<PointF> paramList)
  {
    if ((paramList != null) && (paramList.size() >= 90))
    {
      while (paramList.size() > 90) {
        paramList.remove(paramList.size() - 1);
      }
      paramList.add(new PointF((((PointF)paramList.get(57)).x + ((PointF)paramList.get(58)).x) * 0.5F, (((PointF)paramList.get(57)).y + ((PointF)paramList.get(58)).y) * 0.5F));
      paramList.add(new PointF((((PointF)paramList.get(60)).x + ((PointF)paramList.get(61)).x) * 0.5F, (((PointF)paramList.get(60)).y + ((PointF)paramList.get(61)).y) * 0.5F));
      paramList.add(new PointF((((PointF)paramList.get(2)).x + ((PointF)paramList.get(3)).x + ((PointF)paramList.get(57)).x) / 3.0F, (((PointF)paramList.get(2)).y + ((PointF)paramList.get(3)).y + ((PointF)paramList.get(57)).y) / 3.0F));
      paramList.add(new PointF((((PointF)paramList.get(16)).x + ((PointF)paramList.get(15)).x + ((PointF)paramList.get(61)).x) / 3.0F, (((PointF)paramList.get(16)).y + ((PointF)paramList.get(15)).y + ((PointF)paramList.get(61)).y) / 3.0F));
      paramList.add(new PointF((((PointF)paramList.get(73)).x + ((PointF)paramList.get(81)).x) / 2.0F, (((PointF)paramList.get(73)).y + ((PointF)paramList.get(81)).y) / 2.0F));
      return paramList;
    }
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.TransformUtil
 * JD-Core Version:    0.7.0.1
 */