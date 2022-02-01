package com.tencent.mobileqq.kandian.biz.pts.component;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.kandian.base.view.widget.SquareCornerTextImageView.PicInfo;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class ComponentContentGridImage$Model$Builder
{
  private List<URL> a = new ArrayList();
  private List<SquareCornerTextImageView.PicInfo> b = new ArrayList();
  private String c = "";
  private String d = "";
  private int e;
  
  public Builder a(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public Builder a(@NonNull String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public Builder a(@NonNull List<SquareCornerTextImageView.PicInfo> paramList)
  {
    List localList = this.b;
    if ((localList != null) && (localList.size() == 1)) {
      ((SquareCornerTextImageView.PicInfo)this.b.get(0)).a(true);
    }
    this.b = paramList;
    return this;
  }
  
  public ComponentContentGridImage.Model a()
  {
    return new ComponentContentGridImage.Model(this, null);
  }
  
  public Builder b(@NonNull String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public Builder b(@NonNull List<URL> paramList)
  {
    this.a = paramList;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage.Model.Builder
 * JD-Core Version:    0.7.0.1
 */