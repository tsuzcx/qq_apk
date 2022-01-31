package dov.com.tencent.biz.qqstory.takevideo.doodle.layer.config;

import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.DefaultDoodleStrategy;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleStrategy;

public class DoodleConfig$Builder
{
  private int jdField_a_of_type_Int;
  private DoodleStrategy jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseDoodleStrategy = new DefaultDoodleStrategy();
  private int b;
  
  public Builder a(int paramInt)
  {
    if (paramInt > 0) {
      this.jdField_a_of_type_Int = paramInt;
    }
    return this;
  }
  
  public Builder a(DoodleStrategy paramDoodleStrategy)
  {
    if (paramDoodleStrategy != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseDoodleStrategy = paramDoodleStrategy;
    }
    return this;
  }
  
  public DoodleConfig a()
  {
    return new DoodleConfig(this, null);
  }
  
  public Builder b(int paramInt)
  {
    if (paramInt > 0) {
      this.b = paramInt;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.config.DoodleConfig.Builder
 * JD-Core Version:    0.7.0.1
 */