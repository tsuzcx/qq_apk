package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class GamePubAccountHeadAdapter
  extends PagerAdapter
{
  private List<IHeaderView> a;
  private List<QQGameMsgInfo> b;
  private Context c;
  private GamePAHippyFragment d;
  
  public GamePubAccountHeadAdapter(List<IHeaderView> paramList, List<QQGameMsgInfo> paramList1, Context paramContext, GamePAHippyFragment paramGamePAHippyFragment)
  {
    this.c = paramContext;
    this.d = paramGamePAHippyFragment;
    this.a = new ArrayList();
    this.a.addAll(paramList);
    this.b = new ArrayList();
    this.b.addAll(paramList1);
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(this.c).inflate(2131624902, null, false);
    ((ImageView)localView.findViewById(2131432508)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public void a(List<IHeaderView> paramList, List<QQGameMsgInfo> paramList1)
  {
    this.a.clear();
    this.a.addAll(paramList);
    this.b.clear();
    this.b.addAll(paramList1);
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    List localList = this.a;
    if ((localList != null) && (localList.size() > 1)) {
      return this.a.size();
    }
    return 1;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = this.b;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      int i = this.b.size();
      TextView localTextView = null;
      if (paramInt < i) {
        localObject1 = (QQGameMsgInfo)this.b.get(paramInt);
      } else {
        localObject1 = null;
      }
      IHeaderView localIHeaderView;
      if (paramInt < this.a.size()) {
        localIHeaderView = (IHeaderView)this.a.get(paramInt);
      } else {
        localIHeaderView = null;
      }
      if (localIHeaderView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGamePub_GamePubAccountHeadAdapt", 2, "headerView = null");
        }
        return null;
      }
      if (((localIHeaderView instanceof MoreMsgHeaderView)) && (paramInt != this.b.size())) {
        return null;
      }
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("headerView = ");
        ((StringBuilder)localObject2).append(localIHeaderView.getClass().getSimpleName());
        QLog.d("QQGamePub_GamePubAccountHeadAdapt", 2, ((StringBuilder)localObject2).toString());
      }
      RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
      View localView = (View)localIHeaderView;
      if (localView.getParent() != null) {
        ((ViewGroup)localView.getParent()).removeView(localView);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13, localView.getId());
      if (localObject1 != null)
      {
        localObject2 = QQGameUIHelper.a((QQGameMsgInfo)localObject1, this.c);
        localTextView = (TextView)((Pair)localObject2).first;
        localObject2 = (RelativeLayout.LayoutParams)((Pair)localObject2).second;
      }
      else
      {
        localObject2 = null;
      }
      localRelativeLayout.addView(localView, localLayoutParams);
      if ((localTextView != null) && (localObject2 != null)) {
        localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject2);
      }
      paramViewGroup.addView(localRelativeLayout, localLayoutParams);
      if (localObject1 != null)
      {
        localIHeaderView.a((QQGameMsgInfo)localObject1, (Activity)this.c, paramInt, GamePubAccountHelper.a());
        this.d.a(paramInt, localIHeaderView);
        return localRelativeLayout;
      }
      localIHeaderView.a(new QQGameMsgInfo(), (Activity)this.c, paramInt, GamePubAccountHelper.a());
      return localRelativeLayout;
    }
    localObject1 = a();
    paramViewGroup.addView((View)localObject1);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.view.GamePubAccountHeadAdapter
 * JD-Core Version:    0.7.0.1
 */