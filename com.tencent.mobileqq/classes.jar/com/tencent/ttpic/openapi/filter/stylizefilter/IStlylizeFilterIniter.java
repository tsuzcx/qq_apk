package com.tencent.ttpic.openapi.filter.stylizefilter;

import java.util.Map;

public abstract interface IStlylizeFilterIniter
{
  public static final int CARTOON_STYLE_FILTER = 5;
  public static final int COMIC_STYLE_FILTER = 7;
  public static final int CYBERPUNK_STYLE_FILTER = 6;
  public static final String LUT_1 = "lut1";
  public static final String LUT_2 = "lut2";
  public static final String MATERIAL_1 = "material1";
  public static final String MATERIAL_2 = "material2";
  public static final int TTMOONA_PENCILE_FILTER = 3;
  public static final int TTPENCIL_FILTER_GROUP = 4;
  public static final int TTSELF_INNOV_SETCH_FILTER = 2;
  public static final int TTWESEE_SKETCH_FILTER = 1;
  
  public abstract void updateLutPaths(Map<String, String> paramMap);
  
  public abstract void updateMateriaPaths(Map<String, String> paramMap);
  
  public abstract void updateThresholdValue(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.IStlylizeFilterIniter
 * JD-Core Version:    0.7.0.1
 */