package com.tencent.mobileqq.minigame.publicaccount.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;
import com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class WebUiStrategy1HeaderAdapter
  extends BaseHeaderAdapter
{
  private static final String TAG = "WebUiStrategy1HeaderAdapter";
  
  public WebUiStrategy1HeaderAdapter(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    TextView localTextView = null;
    RelativeLayout.LayoutParams localLayoutParams = null;
    if ((this.mMsgInfoList == null) || (this.mMsgInfoList.size() == 0))
    {
      localObject = createEmptyView();
      paramViewGroup.addView((View)localObject);
      paramViewGroup = (ViewGroup)localObject;
      return paramViewGroup;
    }
    if (paramInt < this.mMsgInfoList.size()) {}
    for (Object localObject = (QQGameMsgInfo)this.mMsgInfoList.get(paramInt);; localObject = null)
    {
      IHeaderView localIHeaderView = (IHeaderView)this.mHeaderRecords.get(paramInt);
      if (localIHeaderView == null)
      {
        paramViewGroup = localLayoutParams;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebUiStrategy1HeaderAdapter", 2, "headerView = null");
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebUiStrategy1HeaderAdapter", 2, "headerView = " + localIHeaderView.getClass().getSimpleName());
      }
      RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
      if (((View)localIHeaderView).getParent() != null) {
        ((ViewGroup)((View)localIHeaderView).getParent()).removeView((View)localIHeaderView);
      }
      if (localObject != null)
      {
        localTextView = new TextView(this.mActivity);
        localTextView.setTextColor(-1);
        localTextView.setTextSize(1, 10.0F);
        localTextView.setText(TimeFormatterUtils.a(this.mActivity, 3, ((QQGameMsgInfo)localObject).msgTime * 1000L));
        localTextView.setPadding(12, 0, 12, 0);
        localTextView.setId(2131379343);
        localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        localObject = localLayoutParams;
        if (localLayoutParams == null) {
          localObject = new RelativeLayout.LayoutParams(-2, AIOUtils.a(15.0F, this.mActivity.getResources()));
        }
        localTextView.setGravity(17);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).addRule(10);
        localTextView.bringToFront();
      }
      for (;;)
      {
        if (localTextView != null) {
          localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
        }
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131379343);
        localRelativeLayout.addView((View)localIHeaderView, (ViewGroup.LayoutParams)localObject);
        paramViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
        if (paramInt == 0) {
          initArk(0);
        }
        return localRelativeLayout;
        localObject = null;
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.adapter.WebUiStrategy1HeaderAdapter
 * JD-Core Version:    0.7.0.1
 */