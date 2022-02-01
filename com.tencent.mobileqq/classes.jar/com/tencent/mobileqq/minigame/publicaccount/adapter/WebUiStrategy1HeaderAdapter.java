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
    if ((this.mMsgInfoList != null) && (this.mMsgInfoList.size() != 0))
    {
      int i = this.mMsgInfoList.size();
      TextView localTextView = null;
      if (paramInt < i) {
        localObject1 = (QQGameMsgInfo)this.mMsgInfoList.get(paramInt);
      } else {
        localObject1 = null;
      }
      Object localObject2 = (IHeaderView)this.mHeaderRecords.get(paramInt);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebUiStrategy1HeaderAdapter", 2, "headerView = null");
        }
        return null;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("headerView = ");
        ((StringBuilder)localObject3).append(localObject2.getClass().getSimpleName());
        QLog.d("WebUiStrategy1HeaderAdapter", 2, ((StringBuilder)localObject3).toString());
      }
      Object localObject3 = new RelativeLayout(paramViewGroup.getContext());
      View localView = (View)localObject2;
      if (localView.getParent() != null) {
        ((ViewGroup)localView.getParent()).removeView(localView);
      }
      if (localObject1 != null)
      {
        localTextView = new TextView(this.mActivity);
        localTextView.setTextColor(-1);
        localTextView.setTextSize(1, 10.0F);
        localTextView.setText(TimeFormatterUtils.a(this.mActivity, 3, ((QQGameMsgInfo)localObject1).msgTime * 1000L));
        localTextView.setPadding(12, 0, 12, 0);
        localTextView.setId(2131378695);
        localObject2 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new RelativeLayout.LayoutParams(-2, AIOUtils.b(15.0F, this.mActivity.getResources()));
        }
        localTextView.setGravity(17);
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        ((RelativeLayout.LayoutParams)localObject1).addRule(10);
        localTextView.bringToFront();
      }
      else
      {
        localObject1 = null;
      }
      if (localTextView != null) {
        ((RelativeLayout)localObject3).addView(localTextView, (ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131378695);
      ((RelativeLayout)localObject3).addView(localView, (ViewGroup.LayoutParams)localObject1);
      paramViewGroup.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      if (paramInt == 0) {
        initArk(0);
      }
      return localObject3;
    }
    Object localObject1 = createEmptyView();
    paramViewGroup.addView((View)localObject1);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.adapter.WebUiStrategy1HeaderAdapter
 * JD-Core Version:    0.7.0.1
 */