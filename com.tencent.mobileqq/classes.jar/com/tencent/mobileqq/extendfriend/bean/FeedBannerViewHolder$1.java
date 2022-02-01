package com.tencent.mobileqq.extendfriend.bean;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.wiget.TabLayout.TabAdapter;
import java.util.ArrayList;
import java.util.HashMap;

class FeedBannerViewHolder$1
  implements TabLayout.TabAdapter
{
  FeedBannerViewHolder$1(FeedBannerViewHolder paramFeedBannerViewHolder, ArrayList paramArrayList, int paramInt1, int paramInt2) {}
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Rect a(int paramInt)
  {
    Rect localRect = new Rect(0, 0, 0, 0);
    int i = a();
    if (i > 1) {
      if (paramInt == 0)
      {
        localRect.right = this.b;
        localRect.left = (this.b * 2);
      }
    }
    while (i != 1)
    {
      return localRect;
      if (paramInt == i - 1)
      {
        localRect.left = this.b;
        localRect.right = (this.b * 2);
        return localRect;
      }
      paramInt = this.b;
      localRect.right = paramInt;
      localRect.left = paramInt;
      return localRect;
    }
    paramInt = this.b * 2;
    localRect.right = paramInt;
    localRect.left = paramInt;
    return localRect;
  }
  
  public View a(int paramInt)
  {
    int j = a();
    int i;
    View localView;
    HashMap localHashMap;
    if (j <= b())
    {
      i = 2131561214;
      localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder.itemView.getContext(), i, null);
      FeedBannerViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder, localView, (FeedBannerTabItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), paramInt, j);
      FeedBannerViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder, (FeedBannerTabItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), paramInt, "0X800A9B0");
      localHashMap = new HashMap();
      if (paramInt != 0) {
        break label152;
      }
      localHashMap.put("banner_appid", "1");
    }
    for (;;)
    {
      ExpandReportUtils.a("expose#" + FeedBannerViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder) + "#banner", true, -1L, -1L, localHashMap, true, true);
      return localView;
      i = 2131561215;
      break;
      label152:
      localHashMap.put("banner_appid", String.valueOf(((FeedBannerTabItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a));
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.FeedBannerViewHolder.1
 * JD-Core Version:    0.7.0.1
 */