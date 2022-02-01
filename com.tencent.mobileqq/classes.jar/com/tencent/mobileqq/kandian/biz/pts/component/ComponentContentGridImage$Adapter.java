package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.SquareCornerTextImageView;
import com.tencent.mobileqq.kandian.base.view.widget.SquareCornerTextImageView.PicInfo;
import com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class ComponentContentGridImage$Adapter
  extends BaseAdapter
{
  String jdField_a_of_type_JavaLangString;
  List<URL> jdField_a_of_type_JavaUtilList;
  String jdField_b_of_type_JavaLangString;
  List<SquareCornerTextImageView.PicInfo> jdField_b_of_type_JavaUtilList;
  
  public ComponentContentGridImage$Adapter(ComponentContentGridImage paramComponentContentGridImage, ComponentContentGridImage.Model paramModel)
  {
    a(paramModel);
  }
  
  private int a()
  {
    int i = AIOUtils.b(82.0F, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage.getResources());
    int j = getCount();
    if ((j == 2) || (j == 4)) {
      i = AIOUtils.b(116.0F, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage.getResources());
    }
    return i;
  }
  
  private <T> List<T> a(List<T> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return paramList;
      }
      ArrayList localArrayList = new ArrayList();
      int i = Math.min(paramList.size(), paramInt);
      paramInt = 0;
      while (paramInt < i)
      {
        localArrayList.add(paramList.get(paramInt));
        paramInt += 1;
      }
      return localArrayList;
    }
    return paramList;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_JavaUtilList, 3);
    this.jdField_b_of_type_JavaUtilList = a(this.jdField_b_of_type_JavaUtilList, 3);
  }
  
  private void a(SquareCornerTextImageView paramSquareCornerTextImageView, @NonNull SquareCornerTextImageView.PicInfo paramPicInfo, String paramString, int paramInt1, int paramInt2)
  {
    if (!RIJSmartCropUtils.a(paramString))
    {
      paramSquareCornerTextImageView.a(paramPicInfo);
      return;
    }
    String str = RIJSmartCropUtils.a(paramString, paramInt1, paramInt2);
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[configSmartSizeImage], url = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n, smartUrl = ");
      localStringBuilder.append(str);
      localStringBuilder.append("\n, width = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", height = ");
      localStringBuilder.append(paramInt2);
      QLog.i("ComponentContentGridImage", 2, localStringBuilder.toString());
    }
    paramSquareCornerTextImageView.a(paramPicInfo, str);
  }
  
  private int b()
  {
    int i = AIOUtils.b(116.0F, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage.getResources());
    int j = getCount();
    if ((j == 2) || (j == 4)) {
      i = AIOUtils.b(175.0F, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage.getResources());
    }
    return i;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<URL> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(ComponentContentGridImage.Model paramModel)
  {
    this.jdField_b_of_type_JavaUtilList = paramModel.a();
    this.jdField_a_of_type_JavaUtilList = paramModel.b();
    this.jdField_a_of_type_JavaLangString = paramModel.a();
    this.jdField_b_of_type_JavaLangString = paramModel.b();
    a();
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Context localContext = paramViewGroup.getContext();
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = new SquareCornerTextImageView(localContext);
    }
    paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, a()));
    a((SquareCornerTextImageView)paramViewGroup, (SquareCornerTextImageView.PicInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt), ((URL)this.jdField_a_of_type_JavaUtilList.get(paramInt)).toString(), b(), a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage.a(paramViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage.Adapter
 * JD-Core Version:    0.7.0.1
 */