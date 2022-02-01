package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tavsticker.model.TAVSticker;

public class PagFilterEffect
  extends BaseEffectNode
{
  private final TAVSticker jdField_a_of_type_ComTencentTavstickerModelTAVSticker;
  private final String jdField_a_of_type_JavaLangString;
  
  PagFilterEffect(TAVSticker paramTAVSticker)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PagFilterEffect@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentTavstickerModelTAVSticker = paramTAVSticker;
  }
  
  public BaseEffectNode.Filter a()
  {
    return new PagFilterEffect.MyFilter(this.jdField_a_of_type_ComTencentTavstickerModelTAVSticker);
  }
  
  public String getReportKey()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagFilterEffect
 * JD-Core Version:    0.7.0.1
 */