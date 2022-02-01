package com.tencent.qcircle.weseevideo.model.template;

public class InteractTemplateModel
{
  protected String shootingGuideText;
  protected String templateThumbnail;
  
  public void clear() {}
  
  public String getShootingGuideText()
  {
    return this.shootingGuideText;
  }
  
  public String getTemplateThumbnail()
  {
    return this.templateThumbnail;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public void setShootingGuideText(String paramString)
  {
    this.shootingGuideText = paramString;
  }
  
  public void setTemplateThumbnail(String paramString)
  {
    this.templateThumbnail = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.template.InteractTemplateModel
 * JD-Core Version:    0.7.0.1
 */