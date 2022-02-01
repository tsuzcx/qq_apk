package com.tencent.oscarcamera.particlesystem;

import java.util.HashMap;
import java.util.Map;

public class AttributeConst
{
  public static final String A = "colorA";
  public static final int ATTR_A = 6;
  public static final int ATTR_B = 5;
  public static final int ATTR_CNT = 10;
  public static final int ATTR_G = 4;
  public static final int ATTR_HEIGHT = 1;
  public static final Map<String, Integer> ATTR_INDEX_MAP = new HashMap();
  public static final int ATTR_LIFE = 2;
  public static final int ATTR_R = 3;
  public static final int ATTR_WIDTH = 0;
  public static final int ATTR_X = 7;
  public static final int ATTR_Y = 8;
  public static final int ATTR_Z = 9;
  public static final String B = "colorB";
  public static final String EMISSION_RATE = "emissionRate";
  public static final String G = "colorG";
  public static final String HEIGHT = "height";
  public static final String LIFE = "life";
  public static final String MAX_COUNT = "particleCountMax";
  public static final String NAME = "name";
  public static final int PARAM_CNT = 11;
  public static final int PARAM_R0 = 0;
  public static final int PARAM_R1 = 1;
  public static final int PARAM_R2 = 2;
  public static final int PARAM_R3 = 3;
  public static final int PARAM_R4 = 4;
  public static final int PARAM_R5 = 5;
  public static final int PARAM_R6 = 6;
  public static final int PARAM_R7 = 7;
  public static final int PARAM_R8 = 8;
  public static final int PARAM_R9 = 9;
  public static final int PARAM_T = 10;
  public static final String R = "colorR";
  public static final String WIDTH = "width";
  public static final String X = "positionX";
  public static final String Y = "positionY";
  public static final String Z = "positionZ";
  
  static
  {
    ATTR_INDEX_MAP.put("life", Integer.valueOf(2));
    ATTR_INDEX_MAP.put("width", Integer.valueOf(0));
    ATTR_INDEX_MAP.put("height", Integer.valueOf(1));
    ATTR_INDEX_MAP.put("positionX", Integer.valueOf(7));
    ATTR_INDEX_MAP.put("positionY", Integer.valueOf(8));
    ATTR_INDEX_MAP.put("positionZ", Integer.valueOf(9));
    ATTR_INDEX_MAP.put("colorR", Integer.valueOf(3));
    ATTR_INDEX_MAP.put("colorG", Integer.valueOf(4));
    ATTR_INDEX_MAP.put("colorB", Integer.valueOf(5));
    ATTR_INDEX_MAP.put("colorA", Integer.valueOf(6));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oscarcamera.particlesystem.AttributeConst
 * JD-Core Version:    0.7.0.1
 */