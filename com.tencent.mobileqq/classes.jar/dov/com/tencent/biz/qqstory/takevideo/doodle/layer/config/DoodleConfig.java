package dov.com.tencent.biz.qqstory.takevideo.doodle.layer.config;

import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleStrategy;

public class DoodleConfig
{
  public int a;
  public DoodleStrategy a;
  public int b;
  
  private DoodleConfig(DoodleConfig.Builder paramBuilder)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseDoodleStrategy = DoodleConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_Int = DoodleConfig.Builder.a(paramBuilder);
    this.b = DoodleConfig.Builder.b(paramBuilder);
  }
  
  public String toString()
  {
    return "DoodleConfig{doodleStrategy=" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseDoodleStrategy + ", maxBitmapWidth=" + this.jdField_a_of_type_Int + ", maxBitmapHeight=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.config.DoodleConfig
 * JD-Core Version:    0.7.0.1
 */