package com.tencent.mobileqq.qqgamepub.web;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.model.GameMsgData;
import com.tencent.mobileqq.qqgamepub.mvp.model.bean.QQGameWebFeedModel;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class WebHeadPageAdapter
  extends PagerAdapter
{
  private QQGameWebPresenter a;
  private Context b;
  private ViewPager c;
  private GameMsgData d;
  
  public WebHeadPageAdapter(QQGameWebPresenter paramQQGameWebPresenter, Context paramContext, ViewPager paramViewPager)
  {
    this.a = paramQQGameWebPresenter;
    this.b = paramContext;
    this.c = paramViewPager;
    this.d = new GameMsgData();
  }
  
  private GameMsgData a()
  {
    if (this.d == null) {
      this.d = new GameMsgData();
    }
    return this.d;
  }
  
  private IHeaderView a(int paramInt)
  {
    IHeaderView localIHeaderView;
    if (a().e(paramInt)) {
      localIHeaderView = a().b(paramInt);
    } else {
      localIHeaderView = null;
    }
    if (!a(localIHeaderView, paramInt)) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("headerView = ");
      ((StringBuilder)localObject).append(localIHeaderView.getClass().getSimpleName());
      QLog.d("WebHeadPageAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (View)localIHeaderView;
    if (((View)localObject).getParent() != null) {
      ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
    }
    return localIHeaderView;
  }
  
  private void a(RelativeLayout paramRelativeLayout, IHeaderView paramIHeaderView, QQGameMsgInfo paramQQGameMsgInfo, int paramInt)
  {
    paramIHeaderView.a(paramQQGameMsgInfo, this.b, paramInt, "1");
    b(paramIHeaderView, paramInt);
    paramQQGameMsgInfo = new RelativeLayout.LayoutParams(-1, -2);
    paramIHeaderView = (View)paramIHeaderView;
    paramQQGameMsgInfo.addRule(13, paramIHeaderView.getId());
    paramRelativeLayout.addView(paramIHeaderView, paramQQGameMsgInfo);
  }
  
  private void a(IHeaderView paramIHeaderView, RelativeLayout paramRelativeLayout, QQGameMsgInfo paramQQGameMsgInfo)
  {
    if ((paramIHeaderView instanceof MoreMsgHeaderView)) {
      return;
    }
    paramIHeaderView = null;
    if (paramQQGameMsgInfo != null)
    {
      paramQQGameMsgInfo = QQGameUIHelper.a(paramQQGameMsgInfo, this.b);
      paramIHeaderView = (TextView)paramQQGameMsgInfo.first;
      paramQQGameMsgInfo = (RelativeLayout.LayoutParams)paramQQGameMsgInfo.second;
    }
    else
    {
      paramQQGameMsgInfo = null;
    }
    if ((paramIHeaderView != null) && (paramQQGameMsgInfo != null)) {
      paramRelativeLayout.addView(paramIHeaderView, paramQQGameMsgInfo);
    }
  }
  
  private boolean a(IHeaderView paramIHeaderView, int paramInt)
  {
    if (paramIHeaderView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebHeadPageAdapter", 2, "headerView = null");
      }
      return false;
    }
    return (!a().a(paramIHeaderView)) || (a().d(paramInt));
  }
  
  private QQGameMsgInfo b(int paramInt)
  {
    QQGameMsgInfo localQQGameMsgInfo1;
    if (paramInt < a().b()) {
      localQQGameMsgInfo1 = a().a(paramInt);
    } else {
      localQQGameMsgInfo1 = null;
    }
    QQGameMsgInfo localQQGameMsgInfo2 = localQQGameMsgInfo1;
    if (localQQGameMsgInfo1 == null) {
      localQQGameMsgInfo2 = new QQGameMsgInfo();
    }
    localQQGameMsgInfo2.loadArkResPath = this.a.x();
    return localQQGameMsgInfo2;
  }
  
  private void b(IHeaderView paramIHeaderView, int paramInt)
  {
    if (paramInt == this.c.getCurrentItem())
    {
      ((QQGameWebFeedModel)this.a.b()).a(paramIHeaderView);
      if ((paramIHeaderView instanceof GameArkView))
      {
        paramIHeaderView = (GameArkView)paramIHeaderView;
        paramIHeaderView.setPrePause(false);
        GameVideoManager.a().a(paramIHeaderView);
        return;
      }
      GameVideoManager.a().a(null);
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(this.b).inflate(2131624902, null, false);
    ((ImageView)localView.findViewById(2131432508)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public void a(GameMsgData paramGameMsgData)
  {
    this.d.d().clear();
    this.d.e().clear();
    this.d.d().addAll(paramGameMsgData.d());
    this.d.e().addAll(paramGameMsgData.e());
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return Math.max(a().c(), 1);
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (a().a()) {
      return a(paramViewGroup);
    }
    RelativeLayout localRelativeLayout = null;
    IHeaderView localIHeaderView = a(paramInt);
    if (localIHeaderView != null)
    {
      localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      QQGameMsgInfo localQQGameMsgInfo = b(paramInt);
      a(localRelativeLayout, localIHeaderView, localQQGameMsgInfo, paramInt);
      a(localIHeaderView, localRelativeLayout, localQQGameMsgInfo);
      paramViewGroup.addView(localRelativeLayout, localLayoutParams);
    }
    return localRelativeLayout;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.WebHeadPageAdapter
 * JD-Core Version:    0.7.0.1
 */