package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.base.view.widget.SquareCornerTextImageView.PicInfo;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ComponentContentGridImage$Model
{
  private List<URL> a = new ArrayList();
  private List<SquareCornerTextImageView.PicInfo> b = new ArrayList();
  private String c = "";
  private String d = "";
  private int e;
  
  private ComponentContentGridImage$Model(ComponentContentGridImage.Model.Builder paramBuilder)
  {
    this.a = ComponentContentGridImage.Model.Builder.a(paramBuilder);
    this.c = ComponentContentGridImage.Model.Builder.b(paramBuilder);
    this.d = ComponentContentGridImage.Model.Builder.c(paramBuilder);
    this.b = ComponentContentGridImage.Model.Builder.d(paramBuilder);
    this.e = ComponentContentGridImage.Model.Builder.e(paramBuilder);
  }
  
  public List<SquareCornerTextImageView.PicInfo> a()
  {
    return this.b;
  }
  
  public List<URL> b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage.Model
 * JD-Core Version:    0.7.0.1
 */