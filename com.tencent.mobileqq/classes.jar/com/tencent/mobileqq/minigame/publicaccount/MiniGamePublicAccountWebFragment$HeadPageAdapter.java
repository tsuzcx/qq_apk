package com.tencent.mobileqq.minigame.publicaccount;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import avfh;
import bhid;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MiniGamePublicAccountWebFragment$HeadPageAdapter
  extends PagerAdapter
{
  private MiniGamePublicAccountWebFragment$HeadPageAdapter(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (MiniGamePublicAccountWebFragment.access$000(this.this$0) == null) {
      return 0;
    }
    return MiniGamePublicAccountWebFragment.access$000(this.this$0).size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((MiniGamePublicAccountWebFragment.access$000(this.this$0) == null) || (MiniGamePublicAccountWebFragment.access$000(this.this$0).size() == 0))
    {
      localObject1 = this.this$0.createEmptyView();
      paramViewGroup.addView((View)localObject1);
      return localObject1;
    }
    for (;;)
    {
      synchronized (MiniGamePublicAccountWebFragment.access$000(this.this$0))
      {
        if (paramInt >= MiniGamePublicAccountWebFragment.access$000(this.this$0).size()) {
          break label460;
        }
        localObject1 = (QQGameMsgInfo)MiniGamePublicAccountWebFragment.access$000(this.this$0).get(paramInt);
        avfh localavfh = (avfh)this.this$0.mHeaderRecords.get(paramInt);
        if (localavfh == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MiniGamePublicAccountWebFragment", 2, "headerView = null");
          }
          return null;
        }
        if (((localavfh instanceof MoreMsgHeaderView)) && (paramInt != MiniGamePublicAccountWebFragment.access$000(this.this$0).size())) {
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MiniGamePublicAccountWebFragment", 2, "headerView = " + localavfh.getClass().getSimpleName());
        }
        RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
        if (((View)localavfh).getParent() != null) {
          ((ViewGroup)((View)localavfh).getParent()).removeView((View)localavfh);
        }
        if (localObject1 == null) {
          break label451;
        }
        localTextView = new TextView(this.this$0.getActivity());
        localTextView.setTextColor(-1);
        localTextView.setTextSize(1, 10.0F);
        localTextView.setText(bhid.a(this.this$0.getActivity(), 3, ((QQGameMsgInfo)localObject1).msgTime * 1000L));
        localTextView.setPadding(12, 0, 12, 0);
        localTextView.setId(2131378912);
        localObject1 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = new RelativeLayout.LayoutParams(-2, AIOUtils.dp2px(15.0F, this.this$0.getResources()));
          localTextView.setGravity(17);
          ((RelativeLayout.LayoutParams)localObject1).addRule(14);
          ((RelativeLayout.LayoutParams)localObject1).addRule(10);
          localTextView.bringToFront();
          if (localTextView != null) {
            localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject1);
          }
          localObject1 = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131378912);
          localRelativeLayout.addView((View)localavfh, (ViewGroup.LayoutParams)localObject1);
          paramViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
          if (paramInt == 0) {
            MiniGamePublicAccountWebFragment.access$1100(this.this$0, 0);
          }
          return localRelativeLayout;
        }
      }
      continue;
      label451:
      TextView localTextView = null;
      localObject1 = localObject2;
      continue;
      label460:
      localObject1 = null;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.HeadPageAdapter
 * JD-Core Version:    0.7.0.1
 */