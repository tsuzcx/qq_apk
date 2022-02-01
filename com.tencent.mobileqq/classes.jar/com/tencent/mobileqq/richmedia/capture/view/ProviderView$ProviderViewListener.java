package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

public abstract interface ProviderView$ProviderViewListener
{
  public abstract void a(int paramInt);
  
  public abstract void a(FilterCategoryItem paramFilterCategoryItem);
  
  public abstract void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo);
  
  public abstract void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString);
  
  public abstract void b(FilterCategoryItem paramFilterCategoryItem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.ProviderView.ProviderViewListener
 * JD-Core Version:    0.7.0.1
 */