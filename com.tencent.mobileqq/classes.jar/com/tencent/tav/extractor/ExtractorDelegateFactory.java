package com.tencent.tav.extractor;

import org.jetbrains.annotations.NotNull;

public class ExtractorDelegateFactory
{
  private static ExtractorDelegateFactory.IExtractorDelegateCreator extractorDelegateCreator = new ExtractorDelegateFactory.1();
  
  public static IExtractorDelegate createDelegate()
  {
    return extractorDelegateCreator.createExtractorDelegate();
  }
  
  public static void setExtractorDelegateCreator(@NotNull ExtractorDelegateFactory.IExtractorDelegateCreator paramIExtractorDelegateCreator)
  {
    extractorDelegateCreator = paramIExtractorDelegateCreator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.extractor.ExtractorDelegateFactory
 * JD-Core Version:    0.7.0.1
 */