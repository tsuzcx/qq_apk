package com.tencent.mobileqq.gamecenter.hippy.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.gamecenter.hippy.GamePubAccountHippyFragment;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.gamecenter.util.QQGameUIHelper;
import com.tencent.mobileqq.gamecenter.view.IHeaderView;
import com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GamePubAccountHeadAdapter
  extends PagerAdapter
{
  private static final String TAG = "GamePubAccountHeadAdapt";
  private Context mContext;
  private GamePubAccountHippyFragment mFragment;
  private List<IHeaderView> mHeaderRecords;
  private List<QQGameMsgInfo> mMsgList;
  
  public GamePubAccountHeadAdapter(List<IHeaderView> paramList, List<QQGameMsgInfo> paramList1, Context paramContext, GamePubAccountHippyFragment paramGamePubAccountHippyFragment)
  {
    this.mHeaderRecords = paramList;
    this.mMsgList = paramList1;
    this.mContext = paramContext;
    this.mFragment = paramGamePubAccountHippyFragment;
  }
  
  public View createEmptyView()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2131559275, null, false);
    ((ImageView)localView.findViewById(2131366332)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int j = 1;
    int i = j;
    if (this.mHeaderRecords != null)
    {
      i = j;
      if (this.mHeaderRecords.size() > 1) {
        i = this.mHeaderRecords.size();
      }
    }
    return i;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    TextView localTextView = null;
    Object localObject = null;
    if ((this.mMsgList == null) || (this.mMsgList.size() == 0))
    {
      localObject = createEmptyView();
      paramViewGroup.addView((View)localObject);
      return localObject;
    }
    if (paramInt < this.mMsgList.size()) {}
    for (QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)this.mMsgList.get(paramInt);; localQQGameMsgInfo = null)
    {
      if (paramInt < this.mHeaderRecords.size()) {}
      for (IHeaderView localIHeaderView = (IHeaderView)this.mHeaderRecords.get(paramInt);; localIHeaderView = null)
      {
        if (localIHeaderView == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("GamePubAccountHeadAdapt", 2, "headerView = null");
          return null;
        }
        if (((localIHeaderView instanceof MoreMsgHeaderView)) && (paramInt != this.mMsgList.size())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GamePubAccountHeadAdapt", 2, "headerView = " + localIHeaderView.getClass().getSimpleName());
        }
        RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
        if (((View)localIHeaderView).getParent() != null) {
          ((ViewGroup)((View)localIHeaderView).getParent()).removeView((View)localIHeaderView);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(13, ((View)localIHeaderView).getId());
        if (localQQGameMsgInfo != null)
        {
          localObject = QQGameUIHelper.a(localQQGameMsgInfo, this.mContext);
          localTextView = (TextView)((Pair)localObject).first;
        }
        for (localObject = (RelativeLayout.LayoutParams)((Pair)localObject).second;; localObject = null)
        {
          localRelativeLayout.addView((View)localIHeaderView, localLayoutParams);
          if ((localTextView != null) && (localObject != null)) {
            localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
          }
          paramViewGroup.addView(localRelativeLayout, localLayoutParams);
          if (localQQGameMsgInfo != null)
          {
            localIHeaderView.a(localQQGameMsgInfo, (Activity)this.mContext, paramInt, QQGameHelper.b());
            this.mFragment.a(paramInt, localIHeaderView);
          }
          for (;;)
          {
            return localRelativeLayout;
            localIHeaderView.a(new QQGameMsgInfo(), (Activity)this.mContext, paramInt, QQGameHelper.b());
          }
        }
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setData(List<IHeaderView> paramList, List<QQGameMsgInfo> paramList1)
  {
    this.mHeaderRecords = paramList;
    this.mMsgList = paramList1;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.view.GamePubAccountHeadAdapter
 * JD-Core Version:    0.7.0.1
 */