package com.tencent.mobileqq.kandian.biz.framework.click;

import com.tencent.mobileqq.kandian.biz.pts.OnLastReadRefreshListener;

public class ListenerBuilder
{
  protected OnLastReadRefreshListener a;
  protected OnSubRegionClickListener b;
  protected OnGalleryImageClickListener c;
  protected OnHorizontalSubArticleClick d;
  
  public ListenerBuilder a(OnGalleryImageClickListener paramOnGalleryImageClickListener)
  {
    this.c = paramOnGalleryImageClickListener;
    return this;
  }
  
  public ListenerBuilder a(OnHorizontalSubArticleClick paramOnHorizontalSubArticleClick)
  {
    this.d = paramOnHorizontalSubArticleClick;
    return this;
  }
  
  public ListenerBuilder a(OnSubRegionClickListener paramOnSubRegionClickListener)
  {
    this.b = paramOnSubRegionClickListener;
    return this;
  }
  
  public ListenerBuilder a(OnLastReadRefreshListener paramOnLastReadRefreshListener)
  {
    this.a = paramOnLastReadRefreshListener;
    return this;
  }
  
  public OnLastReadRefreshListener a()
  {
    return this.a;
  }
  
  public OnHorizontalSubArticleClick b()
  {
    return this.d;
  }
  
  public OnSubRegionClickListener c()
  {
    return this.b;
  }
  
  public OnGalleryImageClickListener d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder
 * JD-Core Version:    0.7.0.1
 */