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
  private List<MeasureGridView> b = new ArrayList();
  
  ReadInJoyDiandianHeaderController$ViewPagerAdapter(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public int a(int paramInt)
  {
    int j = c();
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
    if (this.b.size() > 0) {
      this.b.clear();
    }
    this.b.addAll(paramList);
    ReadInJoyDiandianHeaderController.a(this.a, new View[getCount()]);
    notifyDataSetChanged();
  }
  
  public int c()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
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
    if (paramInt < ReadInJoyDiandianHeaderController.h(this.a).length) {
      ReadInJoyDiandianHeaderController.h(this.a)[paramInt] = null;
    }
  }
  
  public int getCount()
  {
    int i = c();
    if (i <= 1) {
      return i;
    }
    return i + 3;
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (MeasureGridView)paramObject;
    int i = this.b.indexOf(paramObject);
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
    int i = c();
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
        if (ReadInJoyDiandianHeaderController.h(this.a)[paramInt] != null) {
          return ReadInJoyDiandianHeaderController.h(this.a)[paramInt];
        }
      }
      else
      {
        if ((ReadInJoyDiandianHeaderController.h(this.a)[paramInt] == null) || (ReadInJoyDiandianHeaderController.h(this.a)[paramInt].getParent() != null)) {
          ReadInJoyDiandianHeaderController.h(this.a)[paramInt] = ((View)instantiateItem(null, paramInt));
        }
        paramViewGroup.addView(ReadInJoyDiandianHeaderController.h(this.a)[paramInt]);
        return ReadInJoyDiandianHeaderController.h(this.a)[paramInt];
      }
    }
    i = a(paramInt);
    Object localObject2 = (View)this.b.get(i);
    localObject1 = localObject2;
    if (((View)localObject2).getParent() != null) {
      localObject1 = ReadInJoyDiandianHeaderController.a(this.a, i);
    }
    ReadInJoyDiandianHeaderController.h(this.a)[paramInt] = localObject1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController.ViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */