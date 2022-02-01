package com.tencent.mobileqq.gamecenter.web;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.gamecenter.media.GameVideoManager;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.view.IHeaderView;
import com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQGameFeedWebFragment$HeadPageAdapter
  extends PagerAdapter
{
  private QQGameFeedWebFragment$HeadPageAdapter(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    synchronized (QQGameFeedWebFragment.jdField_a_of_type_ArrayOfByte)
    {
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() > 1))
      {
        int i = this.a.jdField_a_of_type_JavaUtilList.size();
        return i;
      }
      return 1;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((QQGameFeedWebFragment.a(this.a) == null) || (QQGameFeedWebFragment.a(this.a).size() == 0))
    {
      localObject1 = this.a.a();
      paramViewGroup.addView((View)localObject1);
      return localObject1;
    }
    for (;;)
    {
      synchronized (QQGameFeedWebFragment.jdField_a_of_type_ArrayOfByte)
      {
        if (paramInt >= QQGameFeedWebFragment.a(this.a).size()) {
          break label605;
        }
        localQQGameMsgInfo = (QQGameMsgInfo)QQGameFeedWebFragment.a(this.a).get(paramInt);
        if (paramInt >= this.a.jdField_a_of_type_JavaUtilList.size()) {
          break label599;
        }
        localIHeaderView = (IHeaderView)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (localIHeaderView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameWebPage", 2, "headerView = null");
          }
          return null;
        }
        if (((localIHeaderView instanceof MoreMsgHeaderView)) && (paramInt != QQGameFeedWebFragment.a(this.a).size())) {
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GameWebPage", 2, "headerView = " + localIHeaderView.getClass().getSimpleName());
        }
        RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
        if (((View)localIHeaderView).getParent() != null) {
          ((ViewGroup)((View)localIHeaderView).getParent()).removeView((View)localIHeaderView);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(13, ((View)localIHeaderView).getId());
        if (localQQGameMsgInfo == null) {
          break label594;
        }
        TextView localTextView = new TextView(this.a.getActivity());
        localTextView.setTextColor(-1);
        localTextView.setTextSize(1, 10.0F);
        localTextView.setBackgroundColor(0);
        localTextView.setText(TimeFormatterUtils.a(this.a.getActivity(), 3, localQQGameMsgInfo.msgTime * 1000L));
        localTextView.setPadding(12, 0, 12, 0);
        localTextView.setId(2131379343);
        localObject1 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        if (localObject1 != null) {
          break label591;
        }
        localObject1 = new RelativeLayout.LayoutParams(-2, AIOUtils.a(15.0F, this.a.getResources()));
        localTextView.setGravity(17);
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10);
        localTextView.bringToFront();
        localObject2 = localObject1;
        localObject1 = localTextView;
        localRelativeLayout.addView((View)localIHeaderView, localLayoutParams);
        if ((localObject1 != null) && (localObject2 != null)) {
          localRelativeLayout.addView((View)localObject1, localObject2);
        }
        paramViewGroup.addView(localRelativeLayout, localLayoutParams);
        if (localQQGameMsgInfo != null)
        {
          localIHeaderView.a(localQQGameMsgInfo, this.a.getActivity(), paramInt, "1");
          if (paramInt == QQGameFeedWebFragment.a(this.a).getCurrentItem())
          {
            QQGameFeedWebFragment.a(this.a, localIHeaderView);
            if ((localIHeaderView instanceof GameArkView))
            {
              ((GameArkView)localIHeaderView).setPrePause(false);
              GameVideoManager.a().a((GameArkView)localIHeaderView);
            }
          }
          else
          {
            return localRelativeLayout;
          }
          GameVideoManager.a().a(null);
        }
      }
      localIHeaderView.a(new QQGameMsgInfo(), this.a.getActivity(), paramInt, "1");
      continue;
      label591:
      continue;
      label594:
      localObject1 = null;
      continue;
      label599:
      IHeaderView localIHeaderView = null;
      continue;
      label605:
      QQGameMsgInfo localQQGameMsgInfo = null;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.HeadPageAdapter
 * JD-Core Version:    0.7.0.1
 */