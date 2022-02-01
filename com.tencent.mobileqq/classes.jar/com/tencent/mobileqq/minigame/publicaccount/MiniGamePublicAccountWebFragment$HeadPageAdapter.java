package com.tencent.mobileqq.minigame.publicaccount;

import agej;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import avmq;
import bhsw;
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
    Object localObject = null;
    if ((MiniGamePublicAccountWebFragment.access$000(this.this$0) == null) || (MiniGamePublicAccountWebFragment.access$000(this.this$0).size() == 0))
    {
      localObject = this.this$0.createEmptyView();
      paramViewGroup.addView((View)localObject);
      return localObject;
    }
    for (;;)
    {
      synchronized (MiniGamePublicAccountWebFragment.access$000(this.this$0))
      {
        if (paramInt >= MiniGamePublicAccountWebFragment.access$000(this.this$0).size()) {
          break label494;
        }
        localQQGameMsgInfo = (QQGameMsgInfo)MiniGamePublicAccountWebFragment.access$000(this.this$0).get(paramInt);
        avmq localavmq = (avmq)this.this$0.mHeaderRecords.get(paramInt);
        if (localavmq == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MiniGamePublicAccountWebFragment", 2, "headerView = null");
          }
          return null;
        }
        if (((localavmq instanceof MoreMsgHeaderView)) && (paramInt != MiniGamePublicAccountWebFragment.access$000(this.this$0).size())) {
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MiniGamePublicAccountWebFragment", 2, "headerView = " + localavmq.getClass().getSimpleName());
        }
        RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
        if (((View)localavmq).getParent() != null) {
          ((ViewGroup)((View)localavmq).getParent()).removeView((View)localavmq);
        }
        if (localQQGameMsgInfo == null) {
          break label488;
        }
        localTextView = new TextView(this.this$0.getActivity());
        localTextView.setTextColor(-1);
        localTextView.setTextSize(1, 10.0F);
        localTextView.setText(bhsw.a(this.this$0.getActivity(), 3, localQQGameMsgInfo.msgTime * 1000L));
        localTextView.setPadding(12, 0, 12, 0);
        localTextView.setId(2131378854);
        localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        if (localObject == null)
        {
          localObject = new RelativeLayout.LayoutParams(-2, agej.a(15.0F, this.this$0.getResources()));
          localTextView.setGravity(17);
          ((RelativeLayout.LayoutParams)localObject).addRule(14);
          ((RelativeLayout.LayoutParams)localObject).addRule(10);
          localTextView.bringToFront();
          if (localTextView != null) {
            localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
          }
          localObject = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131378854);
          localRelativeLayout.addView((View)localavmq, (ViewGroup.LayoutParams)localObject);
          paramViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
          if (localQQGameMsgInfo != null)
          {
            localavmq.a(localQQGameMsgInfo, this.this$0.getActivity(), paramInt);
            return localRelativeLayout;
          }
          localavmq.a(new QQGameMsgInfo(), this.this$0.getActivity(), paramInt);
        }
      }
      continue;
      label488:
      TextView localTextView = null;
      continue;
      label494:
      QQGameMsgInfo localQQGameMsgInfo = null;
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