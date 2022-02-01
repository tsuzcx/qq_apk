package com.tencent.ttpic.openapi.model;

public class WMElementFactory
{
  public static WMElement createWMElement(WMElementConfig paramWMElementConfig)
  {
    if (paramWMElementConfig.wmtype == WMElement.WMType.TEXT.value) {
      return new TextWMElement(paramWMElementConfig);
    }
    return new ImageWMElement(paramWMElementConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.WMElementFactory
 * JD-Core Version:    0.7.0.1
 */