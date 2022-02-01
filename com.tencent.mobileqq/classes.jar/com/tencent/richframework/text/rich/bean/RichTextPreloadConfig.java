package com.tencent.richframework.text.rich.bean;

public class RichTextPreloadConfig
{
  private RichTextPreloadConfig.TextImageSpanConfig a;
  private RichTextPreloadConfig.TextAtConfig b;
  private RichTextPreloadConfig.TextHashTagConfig c;
  
  public RichTextPreloadConfig.TextImageSpanConfig a()
  {
    return this.a;
  }
  
  public RichTextPreloadConfig a(RichTextPreloadConfig.TextAtConfig paramTextAtConfig)
  {
    this.b = paramTextAtConfig;
    return this;
  }
  
  public RichTextPreloadConfig a(RichTextPreloadConfig.TextHashTagConfig paramTextHashTagConfig)
  {
    this.c = paramTextHashTagConfig;
    return this;
  }
  
  public RichTextPreloadConfig a(RichTextPreloadConfig.TextImageSpanConfig paramTextImageSpanConfig)
  {
    this.a = paramTextImageSpanConfig;
    return this;
  }
  
  public RichTextPreloadConfig.TextAtConfig b()
  {
    return this.b;
  }
  
  public RichTextPreloadConfig.TextHashTagConfig c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.bean.RichTextPreloadConfig
 * JD-Core Version:    0.7.0.1
 */