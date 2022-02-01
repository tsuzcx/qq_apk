package com.tencent.mobileqq.vas.qvip.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.view.IHeaderView;
import com.tencent.mobileqq.vas.qvip.view.QQVipPubHeaderFactory;
import java.util.ArrayList;
import java.util.List;

public class QQVipFeedWedFragment$HeadPageAdapter
  extends PagerAdapter
{
  public QQVipFeedWedFragment$HeadPageAdapter(QQVipFeedWedFragment paramQQVipFeedWedFragment) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return QQVipFeedWedFragment.a(this.a).size() + 1;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if ((QQVipFeedWedFragment.a(this.a) != null) && (QQVipFeedWedFragment.a(this.a).size() != 0))
    {
      if (paramInt < QQVipFeedWedFragment.a(this.a).size()) {
        localObject = (QQVipMsgInfo)QQVipFeedWedFragment.a(this.a).get(paramInt);
      } else {
        localObject = null;
      }
      IHeaderView localIHeaderView = QQVipPubHeaderFactory.a((QQVipMsgInfo)localObject, this.a.getBaseActivity());
      if (localIHeaderView == null) {
        return null;
      }
      this.a.a.add(localIHeaderView);
      RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
      View localView = (View)localIHeaderView;
      if (localView.getParent() != null) {
        ((ViewGroup)localView.getParent()).removeView(localView);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13, localView.getId());
      QQVipFeedWedFragment.a(this.a, paramViewGroup, paramInt, localIHeaderView, (QQVipMsgInfo)localObject, localRelativeLayout, localLayoutParams);
      return localRelativeLayout;
    }
    Object localObject = this.a.a();
    paramViewGroup.addView((View)localObject);
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment.HeadPageAdapter
 * JD-Core Version:    0.7.0.1
 */