package com.tencent.mobileqq.pluginsdk;

public abstract class ResourceIdMapper
{
  public static final int RES_ID_ANIM_BOTTOM_IN = 2;
  public static final int RES_ID_ANIM_BOTTOM_OUT = 7;
  public static final int RES_ID_ANIM_FADE_IN = 0;
  public static final int RES_ID_ANIM_FADE_OUT = 1;
  public static final int RES_ID_ANIM_LEFT_IN = 5;
  public static final int RES_ID_ANIM_LEFT_OUT = 4;
  public static final int RES_ID_ANIM_RIGHT_IN = 3;
  public static final int RES_ID_ANIM_RIGHT_OUT = 6;
  public static final int RES_ID_STYLE_BOTTOM_IN_OUT = 8;
  public static final ResourceIdMapper.ResourceIdMapperFactory sFactory = new ResourceIdMapper.ResourceIdMapperFactory();
  
  public abstract int getHostResourceId(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ResourceIdMapper
 * JD-Core Version:    0.7.0.1
 */