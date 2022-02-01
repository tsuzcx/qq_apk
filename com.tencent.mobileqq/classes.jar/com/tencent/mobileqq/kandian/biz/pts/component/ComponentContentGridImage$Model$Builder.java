package com.tencent.mobileqq.kandian.biz.pts.component;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.kandian.base.view.widget.SquareCornerTextImageView.PicInfo;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class ComponentContentGridImage$Model$Builder
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private List<URL> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String jdField_b_of_type_JavaLangString = "";
  private List<SquareCornerTextImageView.PicInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(@NonNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder a(@NonNull List<SquareCornerTextImageView.PicInfo> paramList)
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() == 1)) {
      ((SquareCornerTextImageView.PicInfo)this.jdField_b_of_type_JavaUtilList.get(0)).a(true);
    }
    this.jdField_b_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public ComponentContentGridImage.Model a()
  {
    return new ComponentContentGridImage.Model(this, null);
  }
  
  public Builder b(@NonNull String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder b(@NonNull List<URL> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage.Model.Builder
 * JD-Core Version:    0.7.0.1
 */