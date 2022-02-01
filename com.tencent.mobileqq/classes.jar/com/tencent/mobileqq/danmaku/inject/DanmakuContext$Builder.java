package com.tencent.mobileqq.danmaku.inject;

import com.tencent.mobileqq.danmaku.render.BaseDanmakuRender;
import java.util.ArrayList;
import java.util.List;

public final class DanmakuContext$Builder
{
  private int jdField_a_of_type_Int;
  private IDanmakuClearScreenCallback jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuClearScreenCallback;
  public IDanmakuCreator a;
  private IDanmakuDrawableFetcher jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuDrawableFetcher;
  private IDanmakuExposureCallback jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuExposureCallback;
  public IDanmakuLineHeightDecider a;
  private IDanmakuPlayTimeSupplier jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuPlayTimeSupplier;
  private IDanmakuUIConfigCreator jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuUIConfigCreator;
  private IDanmakuWindowConfigCreator jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuWindowConfigCreator;
  private IDanmakuWindowCreator jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuWindowCreator;
  private List<BaseDanmakuRender> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b = false;
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(IDanmakuCreator paramIDanmakuCreator)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuCreator = paramIDanmakuCreator;
    return this;
  }
  
  public Builder a(IDanmakuExposureCallback paramIDanmakuExposureCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuExposureCallback = paramIDanmakuExposureCallback;
    return this;
  }
  
  public Builder a(IDanmakuPlayTimeSupplier paramIDanmakuPlayTimeSupplier)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuPlayTimeSupplier = paramIDanmakuPlayTimeSupplier;
    return this;
  }
  
  public Builder a(IDanmakuUIConfigCreator paramIDanmakuUIConfigCreator)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuUIConfigCreator = paramIDanmakuUIConfigCreator;
    return this;
  }
  
  public Builder a(IDanmakuWindowCreator paramIDanmakuWindowCreator)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectIDanmakuWindowCreator = paramIDanmakuWindowCreator;
    return this;
  }
  
  public Builder a(BaseDanmakuRender paramBaseDanmakuRender)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramBaseDanmakuRender);
    return this;
  }
  
  public DanmakuContext a()
  {
    return new DanmakuContext(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.inject.DanmakuContext.Builder
 * JD-Core Version:    0.7.0.1
 */