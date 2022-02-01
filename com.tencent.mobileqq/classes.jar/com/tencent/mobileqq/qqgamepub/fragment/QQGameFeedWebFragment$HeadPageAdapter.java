package com.tencent.mobileqq.qqgamepub.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.mobileqq.qqgamepub.view.QQGamePubViewpager;
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
    if ((QQGameFeedWebFragment.a(this.a) != null) && (QQGameFeedWebFragment.a(this.a).size() != 0)) {}
    for (;;)
    {
      synchronized (QQGameFeedWebFragment.jdField_a_of_type_ArrayOfByte)
      {
        if (paramInt >= QQGameFeedWebFragment.a(this.a).size()) {
          break label630;
        }
        localQQGameMsgInfo = (QQGameMsgInfo)QQGameFeedWebFragment.a(this.a).get(paramInt);
        if (paramInt >= this.a.jdField_a_of_type_JavaUtilList.size()) {
          break label636;
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
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("headerView = ");
          ((StringBuilder)localObject1).append(localIHeaderView.getClass().getSimpleName());
          QLog.d("GameWebPage", 2, ((StringBuilder)localObject1).toString());
        }
        RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
        if (((View)localIHeaderView).getParent() != null) {
          ((ViewGroup)((View)localIHeaderView).getParent()).removeView((View)localIHeaderView);
        }
        RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams2.addRule(13, ((View)localIHeaderView).getId());
        if (localQQGameMsgInfo == null) {
          break label642;
        }
        localObject2 = new TextView(QQGameFeedWebFragment.a(this.a));
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setTextSize(1, 10.0F);
        ((TextView)localObject2).setBackgroundColor(0);
        ((TextView)localObject2).setText(TimeFormatterUtils.a(QQGameFeedWebFragment.a(this.a), 3, localQQGameMsgInfo.msgTime * 1000L));
        ((TextView)localObject2).setPadding(12, 0, 12, 0);
        ((TextView)localObject2).setId(2131378720);
        RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
        localObject1 = localLayoutParams1;
        if (localLayoutParams1 == null) {
          localObject1 = new RelativeLayout.LayoutParams(-2, UIUtils.a(15.0F, this.a.getResources()));
        }
        ((TextView)localObject2).setGravity(17);
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10);
        ((TextView)localObject2).bringToFront();
        localRelativeLayout.addView((View)localIHeaderView, localLayoutParams2);
        if ((localObject2 != null) && (localObject1 != null)) {
          localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        }
        paramViewGroup.addView(localRelativeLayout, localLayoutParams2);
        if (localQQGameMsgInfo != null)
        {
          localQQGameMsgInfo.loadArkResPath = this.a.jdField_a_of_type_JavaLangString;
          localIHeaderView.a(localQQGameMsgInfo, QQGameFeedWebFragment.a(this.a), paramInt, "1");
          if (paramInt == QQGameFeedWebFragment.a(this.a).getCurrentItem())
          {
            QQGameFeedWebFragment.a(this.a, localIHeaderView);
            if ((localIHeaderView instanceof GameArkView))
            {
              ((GameArkView)localIHeaderView).setPrePause(false);
              GameVideoManager.a().a((GameArkView)localIHeaderView);
            }
            else
            {
              GameVideoManager.a().a(null);
            }
          }
        }
        else
        {
          paramViewGroup = new QQGameMsgInfo();
          paramViewGroup.loadArkResPath = this.a.jdField_a_of_type_JavaLangString;
          localIHeaderView.a(paramViewGroup, QQGameFeedWebFragment.a(this.a), paramInt, "1");
        }
        return localRelativeLayout;
      }
      Object localObject1 = this.a.a();
      paramViewGroup.addView((View)localObject1);
      return localObject1;
      label630:
      QQGameMsgInfo localQQGameMsgInfo = null;
      continue;
      label636:
      IHeaderView localIHeaderView = null;
      continue;
      label642:
      localObject1 = null;
      Object localObject2 = localObject1;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.HeadPageAdapter
 * JD-Core Version:    0.7.0.1
 */