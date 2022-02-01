package com.tencent.mobileqq.qqlive.end;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;
import com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback;
import com.tencent.mobileqq.qqlive.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.qqlive.data.QQLiveEndRecommendInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.live.ILiveReportUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EndLiveHelper
  implements View.OnClickListener, IQQLiveEndView
{
  private QBaseActivity A;
  private Context B;
  private IQQLiveSDK C;
  private EndLiveClickCallback D;
  private Drawable E;
  private Drawable F;
  private Drawable G;
  private Drawable H;
  private Drawable I;
  private QQLiveEndRecommendInfo J;
  private QQLiveEndRecommendInfo K;
  private View a;
  private ImageView b;
  private URLImageView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private View h;
  private RoundRelativeLayout i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private ImageView p;
  private ImageView q;
  private RoundRelativeLayout r;
  private RoundRelativeLayout s;
  private View t;
  private View u;
  private View v;
  private View w;
  private LifeCycleAndViewModelStoreOwner x;
  private EndFragmentViewModel y;
  private QQLiveEndPageInfo z = new QQLiveEndPageInfo();
  
  private String a(long paramLong)
  {
    long l1 = paramLong / 3600L;
    Object localObject1 = "";
    if (l1 > 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append("小时");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    l1 = paramLong % 3600L;
    paramLong = l1 % 60L;
    l1 /= 60L;
    if (l1 > 0L)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("分钟");
      return ((StringBuilder)localObject2).toString();
    }
    Object localObject2 = localObject1;
    if (paramLong > 0L)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("秒");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
  
  private void a()
  {
    this.x = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(this.A);
    this.y = ((EndFragmentViewModel)ViewModelProviderHelper.a(this.x, EndFragmentViewModel.i).get(EndFragmentViewModel.class));
    this.y.a(this.C);
    new QQLiveGameEndViewBinder().a(this.x, this.y, this);
  }
  
  private void a(Context paramContext)
  {
    this.c = ((URLImageView)this.a.findViewById(2131442362));
    this.i = ((RoundRelativeLayout)this.a.findViewById(2131442363));
    this.d = ((TextView)this.a.findViewById(2131442364));
    this.e = ((TextView)this.a.findViewById(2131442365));
    this.f = ((TextView)this.a.findViewById(2131442368));
    this.g = ((TextView)this.a.findViewById(2131442361));
    this.b = ((ImageView)this.a.findViewById(2131442359));
    this.h = this.a.findViewById(2131442372);
    this.j = ((TextView)this.a.findViewById(2131442414));
    this.k = ((TextView)this.a.findViewById(2131442420));
    this.l = ((TextView)this.a.findViewById(2131442415));
    this.m = ((TextView)this.a.findViewById(2131442421));
    this.n = ((TextView)this.a.findViewById(2131442416));
    this.o = ((TextView)this.a.findViewById(2131442422));
    this.p = ((ImageView)this.a.findViewById(2131442418));
    this.q = ((ImageView)this.a.findViewById(2131442424));
    this.r = ((RoundRelativeLayout)this.a.findViewById(2131442417));
    this.s = ((RoundRelativeLayout)this.a.findViewById(2131442423));
    this.t = this.a.findViewById(2131442413);
    this.u = this.a.findViewById(2131442419);
    this.v = this.a.findViewById(2131442412);
    this.w = this.a.findViewById(2131442411);
    int i1 = ViewUtils.getStatusBarHeight(paramContext);
    this.a.findViewById(2131442371).setPadding(0, i1, 0, 0);
    this.i.d = 15;
    i1 = ViewUtils.dip2px(96.0F) / 2;
    this.i.b = ViewUtils.dpToPx(i1);
    RoundRelativeLayout localRoundRelativeLayout = this.r;
    localRoundRelativeLayout.d = 3;
    localRoundRelativeLayout.b = ViewUtils.dip2px(8.0F);
    localRoundRelativeLayout = this.s;
    localRoundRelativeLayout.d = 3;
    localRoundRelativeLayout.b = ViewUtils.dip2px(8.0F);
    this.G = paramContext.getResources().getDrawable(2130848137);
    this.I = paramContext.getResources().getDrawable(2130848129);
    this.H = paramContext.getResources().getDrawable(2130848136);
    this.E = paramContext.getResources().getDrawable(2130848135);
    this.F = paramContext.getResources().getDrawable(2130848134);
    this.b.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.u.setOnClickListener(this);
  }
  
  private void a(View paramView, int paramInt, QQLiveEndRecommendInfo paramQQLiveEndRecommendInfo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qqlive_recommend_id", String.valueOf(paramQQLiveEndRecommendInfo.roomId));
    localHashMap.put("qqlive_recommend_place", String.valueOf(paramInt));
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(paramView, false, null, "em_qqlive_recommend", localHashMap);
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a("imp", paramView, localHashMap);
  }
  
  private void a(URLImageView paramURLImageView, int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = this.I;
        paramInt = ViewUtils.dip2px(paramInt);
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        paramString.setTag(new int[] { paramInt, paramInt });
        paramURLImageView.setImageDrawable(paramString);
        return;
      }
      catch (Exception paramURLImageView)
      {
        paramString = new StringBuilder();
        paramString.append("loadRoundImg + ");
        paramString.append(paramURLImageView);
        QLog.e("QQLiveEndFragment", 1, paramString.toString());
      }
    }
  }
  
  private void a(QQLiveEndPageInfo paramQQLiveEndPageInfo)
  {
    if (paramQQLiveEndPageInfo.uid == paramQQLiveEndPageInfo.anchorUid) {
      setFollowVisible(false);
    } else {
      setFollowVisible(true);
    }
    if (paramQQLiveEndPageInfo.recommendInfos.size() != 0) {
      this.v.setVisibility(0);
    }
    EndFragmentViewModel localEndFragmentViewModel = this.y;
    if (localEndFragmentViewModel != null)
    {
      localEndFragmentViewModel.a(paramQQLiveEndPageInfo);
      return;
    }
    setHeadIcon(paramQQLiveEndPageInfo.headIcon);
    setNick(paramQQLiveEndPageInfo.nick);
    setPopularity(paramQQLiveEndPageInfo.popularity);
    setLiveTime(paramQQLiveEndPageInfo.time);
    setNick(paramQQLiveEndPageInfo.nick);
    setFollow(paramQQLiveEndPageInfo.follow);
    if ((paramQQLiveEndPageInfo.recommendInfos != null) && (paramQQLiveEndPageInfo.recommendInfos.size() > 0))
    {
      this.v.setVisibility(0);
      if (paramQQLiveEndPageInfo.recommendInfos.size() == 1)
      {
        if (paramQQLiveEndPageInfo.recommendInfos.get(0) != null) {
          setLeftRecommend((QQLiveEndRecommendInfo)paramQQLiveEndPageInfo.recommendInfos.get(0));
        }
      }
      else
      {
        if (paramQQLiveEndPageInfo.recommendInfos.get(0) != null) {
          setLeftRecommend((QQLiveEndRecommendInfo)paramQQLiveEndPageInfo.recommendInfos.get(0));
        }
        if (paramQQLiveEndPageInfo.recommendInfos.get(1) != null) {
          setRightRecommend((QQLiveEndRecommendInfo)paramQQLiveEndPageInfo.recommendInfos.get(1));
        }
      }
    }
  }
  
  private void a(RoundRelativeLayout paramRoundRelativeLayout, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramRoundRelativeLayout.setBackgroundDrawable(URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain()));
        return;
      }
      catch (Exception paramRoundRelativeLayout)
      {
        paramString = new StringBuilder();
        paramString.append("setRecommendCover + ");
        paramString.append(paramRoundRelativeLayout);
        QLog.e("QQLiveEndFragment", 1, paramString.toString());
      }
    }
  }
  
  private void b()
  {
    View localView = this.a.findViewById(2131442360);
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(localView, false, null, "em_qqlive_anchor_inf", new HashMap());
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a("imp", localView, new HashMap());
    localView = this.a.findViewById(2131442367);
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(localView, false, null, "em_qqlive_datamodule", new HashMap());
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a("imp", localView, new HashMap());
  }
  
  private void b(QQLiveEndPageInfo paramQQLiveEndPageInfo)
  {
    if (paramQQLiveEndPageInfo != null)
    {
      this.z.uid = paramQQLiveEndPageInfo.uid;
      this.z.anchorUid = paramQQLiveEndPageInfo.anchorUid;
      this.z.headIcon = paramQQLiveEndPageInfo.headIcon;
      this.z.nick = paramQQLiveEndPageInfo.nick;
      this.z.time = paramQQLiveEndPageInfo.time;
      this.z.popularity = paramQQLiveEndPageInfo.popularity;
      this.z.follow = paramQQLiveEndPageInfo.follow;
      this.z.recommendInfos = paramQQLiveEndPageInfo.recommendInfos;
      a(this.z);
    }
  }
  
  private void c(QQLiveEndPageInfo paramQQLiveEndPageInfo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qqlive_user_id", String.valueOf(paramQQLiveEndPageInfo.uid));
    localHashMap.put("qqlive_anchor_id", String.valueOf(paramQQLiveEndPageInfo.anchorUid));
    localHashMap.put("qqlive_room_id", String.valueOf(paramQQLiveEndPageInfo.roomId));
    localHashMap.put("qqlive_program_id", paramQQLiveEndPageInfo.programId);
    localHashMap.put("qqlive_zhibo_type", String.valueOf(paramQQLiveEndPageInfo.liveType));
    localHashMap.put("qqlive_zhibo_content", paramQQLiveEndPageInfo.liveContent);
    localHashMap.put("qqlive_start_source", paramQQLiveEndPageInfo.liveSource);
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(this.a, "pg_qqlive_liveend_audience", localHashMap);
    localHashMap.put("pgid", "pg_qqlive_liveend_audience");
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a("pgin", this.a, localHashMap);
  }
  
  private void d(QQLiveEndPageInfo paramQQLiveEndPageInfo)
  {
    Object localObject = this.a.findViewById(2131442360);
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a((View)localObject, false, null, "em_qqlive_anchor_inf", new HashMap());
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a("imp", localObject, new HashMap());
    localObject = this.a.findViewById(2131442367);
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a((View)localObject, false, null, "em_qqlive_datamodule", new HashMap());
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a("imp", localObject, new HashMap());
    localObject = new HashMap();
    if (paramQQLiveEndPageInfo.follow == 1) {
      ((Map)localObject).put("qqlive_follow_status", String.valueOf(1));
    } else {
      ((Map)localObject).put("qqlive_follow_status", String.valueOf(0));
    }
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(this.h, false, null, "em_qqlive_follow", (Map)localObject);
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a("imp", this.h, (Map)localObject);
    if ((paramQQLiveEndPageInfo.recommendInfos != null) && (paramQQLiveEndPageInfo.recommendInfos.size() != 0)) {
      if (paramQQLiveEndPageInfo.recommendInfos.size() == 1)
      {
        paramQQLiveEndPageInfo = (QQLiveEndRecommendInfo)paramQQLiveEndPageInfo.recommendInfos.get(0);
        if (paramQQLiveEndPageInfo != null) {
          a(this.t, 0, paramQQLiveEndPageInfo);
        }
      }
      else
      {
        localObject = (QQLiveEndRecommendInfo)paramQQLiveEndPageInfo.recommendInfos.get(0);
        paramQQLiveEndPageInfo = (QQLiveEndRecommendInfo)paramQQLiveEndPageInfo.recommendInfos.get(1);
        if (localObject != null) {
          a(this.t, 0, (QQLiveEndRecommendInfo)localObject);
        }
        if (paramQQLiveEndPageInfo != null) {
          a(this.u, 1, paramQQLiveEndPageInfo);
        }
      }
    }
  }
  
  private void e(QQLiveEndPageInfo paramQQLiveEndPageInfo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qqlive_zhibo_type", String.valueOf(paramQQLiveEndPageInfo.liveType));
    localHashMap.put("qqlive_zhibo_content", paramQQLiveEndPageInfo.liveContent);
    localHashMap.put("qqlive_anchor_id", String.valueOf(paramQQLiveEndPageInfo.anchorUid));
    localHashMap.put("qqlive_room_id", String.valueOf(paramQQLiveEndPageInfo.roomId));
    localHashMap.put("qqlive_user_id", String.valueOf(paramQQLiveEndPageInfo.uid));
    localHashMap.put("qqlive_program_id", paramQQLiveEndPageInfo.programId);
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(this.a, "pg_qqlive_liveend_anchor", localHashMap);
    localHashMap.put("pgid", "pg_qqlive_liveend_anchor");
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a("pgin", this.a, localHashMap);
  }
  
  public IQQLiveEndView a(Context paramContext, IQQLiveSDK paramIQQLiveSDK, QQLiveEndPageInfo paramQQLiveEndPageInfo, EndLiveClickCallback paramEndLiveClickCallback)
  {
    this.B = paramContext;
    this.C = paramIQQLiveSDK;
    this.D = paramEndLiveClickCallback;
    this.a = LayoutInflater.from(paramContext).inflate(2131627986, null);
    a(paramContext);
    b(paramQQLiveEndPageInfo);
    c(paramQQLiveEndPageInfo);
    d(paramQQLiveEndPageInfo);
    return this;
  }
  
  public IQQLiveEndView a(QBaseActivity paramQBaseActivity, IQQLiveSDK paramIQQLiveSDK, QQLiveEndPageInfo paramQQLiveEndPageInfo, EndLiveClickCallback paramEndLiveClickCallback)
  {
    this.A = paramQBaseActivity;
    this.C = paramIQQLiveSDK;
    this.D = paramEndLiveClickCallback;
    this.a = LayoutInflater.from(paramQBaseActivity).inflate(2131627986, null);
    a(paramQBaseActivity);
    a();
    b(paramQQLiveEndPageInfo);
    e(paramQQLiveEndPageInfo);
    b();
    return this;
  }
  
  public View getView()
  {
    return this.a;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    EndLiveClickCallback localEndLiveClickCallback;
    if (i1 == 2131442359)
    {
      localEndLiveClickCallback = this.D;
      if (localEndLiveClickCallback != null) {
        localEndLiveClickCallback.a(this.a);
      }
    }
    else if (i1 == 2131442372)
    {
      localEndLiveClickCallback = this.D;
      if (localEndLiveClickCallback != null) {
        localEndLiveClickCallback.b(this.a);
      }
    }
    else if (i1 == 2131442362)
    {
      localEndLiveClickCallback = this.D;
      if (localEndLiveClickCallback != null) {
        localEndLiveClickCallback.c(this.a);
      }
    }
    else if (i1 == 2131442364)
    {
      localEndLiveClickCallback = this.D;
      if (localEndLiveClickCallback != null) {
        localEndLiveClickCallback.d(this.a);
      }
    }
    else if (i1 == 2131442365)
    {
      localEndLiveClickCallback = this.D;
      if (localEndLiveClickCallback != null) {
        localEndLiveClickCallback.e(this.a);
      }
    }
    else if (i1 == 2131442368)
    {
      localEndLiveClickCallback = this.D;
      if (localEndLiveClickCallback != null) {
        localEndLiveClickCallback.f(this.a);
      }
    }
    else if (i1 == 2131442413)
    {
      localEndLiveClickCallback = this.D;
      if (localEndLiveClickCallback != null) {
        localEndLiveClickCallback.a(0, this.J, this.a);
      }
    }
    else if (i1 == 2131442419)
    {
      localEndLiveClickCallback = this.D;
      if (localEndLiveClickCallback != null) {
        localEndLiveClickCallback.a(1, this.K, this.a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setFollow(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt == 1)
    {
      this.g.setText("已关注");
      localDrawable = this.E;
      if (localDrawable != null) {
        this.h.setBackgroundDrawable(localDrawable);
      }
    }
    else if (paramInt == 2)
    {
      this.g.setText("关注");
      localDrawable = this.F;
      if (localDrawable != null) {
        this.h.setBackgroundDrawable(localDrawable);
      }
    }
  }
  
  public void setFollowVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.h.setVisibility(0);
      return;
    }
    this.h.setVisibility(4);
  }
  
  public void setHeadIcon(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("QQLiveEndFragment", 1, "iconUrl is empty");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upload success iconUrl is ");
    localStringBuilder.append(paramString);
    QLog.d("QQLiveEndFragment", 1, localStringBuilder.toString());
    a(this.c, 96, paramString);
  }
  
  public void setLeftRecommend(QQLiveEndRecommendInfo paramQQLiveEndRecommendInfo)
  {
    this.J = paramQQLiveEndRecommendInfo;
    this.t.setVisibility(0);
    a(this.r, paramQQLiveEndRecommendInfo.roomBg);
    this.j.setText(paramQQLiveEndRecommendInfo.nick);
    Object localObject = String.valueOf(paramQQLiveEndRecommendInfo.popularity);
    if (paramQQLiveEndRecommendInfo.popularity > 10000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramQQLiveEndRecommendInfo.popularity / 10000L);
      ((StringBuilder)localObject).append("万");
      localObject = ((StringBuilder)localObject).toString();
    }
    this.l.setText((CharSequence)localObject);
    this.n.setText(paramQQLiveEndRecommendInfo.roomTitle);
    if (paramQQLiveEndRecommendInfo.roomType == 1)
    {
      this.p.setImageDrawable(this.G);
      return;
    }
    if (paramQQLiveEndRecommendInfo.roomType == 0) {
      this.p.setImageDrawable(this.H);
    }
  }
  
  public void setLiveTime(long paramLong)
  {
    if (paramLong > 0L)
    {
      this.f.setText(a(paramLong));
      return;
    }
    this.f.setText("--");
  }
  
  public void setNick(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void setPopularity(String paramString)
  {
    this.e.setText(paramString);
  }
  
  public void setRightRecommend(QQLiveEndRecommendInfo paramQQLiveEndRecommendInfo)
  {
    this.K = paramQQLiveEndRecommendInfo;
    this.u.setVisibility(0);
    a(this.s, paramQQLiveEndRecommendInfo.roomBg);
    this.k.setText(paramQQLiveEndRecommendInfo.nick);
    Object localObject = String.valueOf(paramQQLiveEndRecommendInfo.popularity);
    if (paramQQLiveEndRecommendInfo.popularity > 10000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramQQLiveEndRecommendInfo.popularity / 10000L);
      ((StringBuilder)localObject).append("万");
      localObject = ((StringBuilder)localObject).toString();
    }
    this.m.setText((CharSequence)localObject);
    this.o.setText(paramQQLiveEndRecommendInfo.roomTitle);
    if (paramQQLiveEndRecommendInfo.roomType == 1)
    {
      this.q.setImageDrawable(this.G);
      return;
    }
    if (paramQQLiveEndRecommendInfo.roomType == 0) {
      this.q.setImageDrawable(this.H);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.end.EndLiveHelper
 * JD-Core Version:    0.7.0.1
 */