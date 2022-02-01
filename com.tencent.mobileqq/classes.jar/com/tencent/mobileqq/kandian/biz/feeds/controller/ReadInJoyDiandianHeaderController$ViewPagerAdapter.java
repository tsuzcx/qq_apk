package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.kandian.biz.channel.banner.IBannerAdapter;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyDiandianHeaderController$ViewPagerAdapter
  extends PagerAdapter
  implements IBannerAdapter
{
  private List<MeasureGridView> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  ReadInJoyDiandianHeaderController$ViewPagerAdapter(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public int a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int a(int paramInt)
  {
    int j = a();
    if (j > 1)
    {
      if (paramInt == 0) {
        return j - 1;
      }
      int i = paramInt;
      if (paramInt > j) {
        i = paramInt - j;
      }
      return i - 1;
    }
    return 0;
  }
  
  void a(List<MeasureGridView> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController, new View[getCount()]);
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroyItem position : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" object: ");
    localStringBuilder.append(paramObject);
    QLog.d("ReadInJoyDiandianHeaderController", 2, localStringBuilder.toString());
    paramViewGroup.removeView((View)paramObject);
    if (paramInt < ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController).length) {
      ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController)[paramInt] = null;
    }
  }
  
  public int getCount()
  {
    int i = a();
    if (i <= 1) {
      return i;
    }
    return i + 3;
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (MeasureGridView)paramObject;
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramObject);
    if (i >= 0) {
      return i;
    }
    return -2;
  }
  
  public float getPageWidth(int paramInt)
  {
    return 0.95F;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("instantiateItem ");
    ((StringBuilder)localObject1).append(paramViewGroup);
    ((StringBuilder)localObject1).append("  ");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.d("ReadInJoyDiandianHeaderController", 2, ((StringBuilder)localObject1).toString());
    int i = a();
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDiandianHeaderController", 2, "data list count is 0");
      }
      return null;
    }
    if ((i > 1) && ((paramInt == 1) || (paramInt == i) || (paramInt == i + 1))) {
      if (paramViewGroup == null)
      {
        if (ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController)[paramInt] != null) {
          return ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController)[paramInt];
        }
      }
      else
      {
        if ((ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController)[paramInt] == null) || (ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController)[paramInt].getParent() != null)) {
          ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController)[paramInt] = ((View)instantiateItem(null, paramInt));
        }
        paramViewGroup.addView(ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController)[paramInt]);
        return ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController)[paramInt];
      }
    }
    i = a(paramInt);
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilList.get(i);
    localObject1 = localObject2;
    if (((View)localObject2).getParent() != null) {
      localObject1 = ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController, i);
    }
    ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController)[paramInt] = localObject1;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("childs ");
    ((StringBuilder)localObject2).append(paramInt);
    QLog.d("ReadInJoyDiandianHeaderController", 2, ((StringBuilder)localObject2).toString());
    if (paramViewGroup != null) {
      paramViewGroup.addView((View)localObject1);
    }
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController.ViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */