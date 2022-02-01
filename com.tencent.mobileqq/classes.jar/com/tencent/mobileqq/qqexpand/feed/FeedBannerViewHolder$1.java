package com.tencent.mobileqq.qqexpand.feed;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.TabLayout.TabAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.HashMap;

class FeedBannerViewHolder$1
  implements TabLayout.TabAdapter
{
  FeedBannerViewHolder$1(FeedBannerViewHolder paramFeedBannerViewHolder, ArrayList paramArrayList, int paramInt1, int paramInt2) {}
  
  public int a()
  {
    return this.a.size();
  }
  
  public View a(int paramInt)
  {
    int j = a();
    int i;
    if (j <= b()) {
      i = 1912995842;
    } else {
      i = 1912995843;
    }
    View localView = View.inflate(this.d.itemView.getContext(), i, null);
    FeedBannerViewHolder.a(this.d, localView, (FeedBannerTabItem)this.a.get(paramInt), paramInt, j);
    FeedBannerViewHolder.a(this.d, (FeedBannerTabItem)this.a.get(paramInt), paramInt, "0X800A9B0");
    HashMap localHashMap = new HashMap();
    if (paramInt == 0) {
      localHashMap.put("banner_appid", "1");
    } else {
      localHashMap.put("banner_appid", String.valueOf(((FeedBannerTabItem)this.a.get(paramInt)).b));
    }
    IExpandReportUtils localIExpandReportUtils = (IExpandReportUtils)QRoute.api(IExpandReportUtils.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expose#");
    localStringBuilder.append(FeedBannerViewHolder.a(this.d));
    localStringBuilder.append("#banner");
    localIExpandReportUtils.onUserActionToTunnel(localStringBuilder.toString(), true, -1L, -1L, localHashMap, true, true);
    return localView;
  }
  
  public int b()
  {
    return 2;
  }
  
  public Rect b(int paramInt)
  {
    Rect localRect = new Rect(0, 0, 0, 0);
    int i = a();
    if (i > 1)
    {
      if (paramInt == 0)
      {
        paramInt = this.c;
        localRect.right = paramInt;
        localRect.left = (paramInt * 2);
        return localRect;
      }
      if (paramInt == i - 1)
      {
        paramInt = this.c;
        localRect.left = paramInt;
        localRect.right = (paramInt * 2);
        return localRect;
      }
      paramInt = this.c;
      localRect.right = paramInt;
      localRect.left = paramInt;
      return localRect;
    }
    if (i == 1)
    {
      paramInt = this.c * 2;
      localRect.right = paramInt;
      localRect.left = paramInt;
    }
    return localRect;
  }
  
  public int c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.FeedBannerViewHolder.1
 * JD-Core Version:    0.7.0.1
 */