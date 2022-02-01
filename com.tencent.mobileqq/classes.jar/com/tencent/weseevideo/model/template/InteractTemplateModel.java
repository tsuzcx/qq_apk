package com.tencent.weseevideo.model.template;

import com.tencent.weseevideo.model.BaseMediaModel;

public class InteractTemplateModel
  extends BaseMediaModel
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.InteractTemplateModel
 * JD-Core Version:    0.7.0.1
 */