package com.tencent.mobileqq.nearby.profilecard.moment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PicMomentFeedInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseMomentItemBuilder
  implements View.OnClickListener, CommentsAdapter.CommentsItemClickListener
{
  protected Context a;
  protected boolean b;
  protected QQAppInterface c;
  protected NearbyPeopleCard d;
  protected Map<String, MomentFeedInfo> e = new HashMap();
  protected Map<String, MomentFeedInfo> f = new HashMap();
  protected Map<String, MomentFeedInfo> g = new HashMap();
  protected int h;
  
  public BaseMomentItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.a = paramContext;
    this.c = paramQQAppInterface;
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString.trim()));
  }
  
  private void k(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    MomentFeedInfo localMomentFeedInfo = paramMomentViewHolder.a;
    DialogUtil.a(this.a, 230).setTitle(HardCodeUtil.a(2131899260)).setNegativeButton(2131887648, new BaseMomentItemBuilder.5(this)).setPositiveButton(2131888438, new BaseMomentItemBuilder.4(this, localMomentFeedInfo, paramMomentViewHolder)).show();
  }
  
  private void l(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a))
    {
      QQToast.makeText(this.a, 1, HardCodeUtil.a(2131899257), 0).show();
      return;
    }
    boolean bool = paramMomentViewHolder.a.u;
    Object localObject2 = j(paramMomentViewHolder);
    Object localObject1 = (NearbyMomentManager)this.c.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER);
    if (!bool) {
      ((NearbyMomentManager)localObject1).d((String)localObject2);
    } else {
      ((NearbyMomentManager)localObject1).e((String)localObject2);
    }
    INowVideoReporter localINowVideoReporter = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card");
    if (bool) {
      localObject1 = "feed_unlike";
    } else {
      localObject1 = "feed_like";
    }
    localINowVideoReporter = localINowVideoReporter.opName((String)localObject1);
    localObject1 = "2";
    localObject2 = localINowVideoReporter.source("2").timelong(h(paramMomentViewHolder)).feedid((String)localObject2).feed_type(String.valueOf(g(paramMomentViewHolder)));
    paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject1;
    if (this.b) {
      paramMomentViewHolder = "1";
    }
    ((INowVideoReporter)localObject2).d1(paramMomentViewHolder).report(this.c);
  }
  
  public abstract View a(ViewGroup paramViewGroup, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder);
  
  public View a(MomentFeedInfo paramMomentFeedInfo, Context paramContext, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    if (localObject == null)
    {
      localObject = new LinearLayout(paramContext);
      ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((LinearLayout)localObject).setBackgroundColor(-1);
      ((LinearLayout)localObject).setOrientation(1);
      BaseMomentItemBuilder.MomentViewHolder localMomentViewHolder = a();
      if (localMomentViewHolder == null) {
        return null;
      }
      localMomentViewHolder.b = ((Activity)paramContext);
      localMomentViewHolder.c = ((View)localObject);
      paramView = LayoutInflater.from(paramContext).inflate(2131627580, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.topMargin = UIUtils.a(paramContext, 20.0F);
      localLayoutParams1.leftMargin = UIUtils.a(paramContext, 16.0F);
      localLayoutParams1.bottomMargin = UIUtils.a(paramContext, 0.0F);
      localLayoutParams1.rightMargin = UIUtils.a(paramContext, 6.0F);
      localMomentViewHolder.e = ((ImageView)paramView.findViewById(2131436403));
      localMomentViewHolder.f = ((TextView)paramView.findViewById(2131448598));
      localMomentViewHolder.g = ((ImageView)paramView.findViewById(2131436457));
      View localView1 = LayoutInflater.from(paramContext).inflate(2131627576, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.leftMargin = UIUtils.a(paramContext, 66.0F);
      localLayoutParams2.rightMargin = UIUtils.a(paramContext, 6.0F);
      localMomentViewHolder.h = ((TextView)localView1.findViewById(2131448572));
      localMomentViewHolder.i = ((TextView)localView1.findViewById(2131448449));
      localMomentViewHolder.j = localView1.findViewById(2131440578);
      localMomentViewHolder.k = ((ImageView)localView1.findViewById(2131436500));
      localMomentViewHolder.k.setOnClickListener(this);
      localMomentViewHolder.l = ((TextView)localView1.findViewById(2131448652));
      localMomentViewHolder.m = ((ImageView)localView1.findViewById(2131436326));
      localMomentViewHolder.m.setOnClickListener(this);
      localMomentViewHolder.n = ((TextView)localView1.findViewById(2131448336));
      localMomentViewHolder.o = ((ListView)localView1.findViewById(2131431127));
      localMomentViewHolder.p = new CommentsAdapter();
      localMomentViewHolder.p.a(this);
      localMomentViewHolder.o.setAdapter(localMomentViewHolder.p);
      localMomentViewHolder.q = ((TextView)localView1.findViewById(2131450030));
      localMomentViewHolder.r = localView1.findViewById(2131431125);
      localMomentViewHolder.q.setOnClickListener(this);
      ((LinearLayout)localObject).addView(paramView, localLayoutParams1);
      View localView2 = a((ViewGroup)localObject, localMomentViewHolder);
      if (localView2 != null)
      {
        localLayoutParams1 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        paramView = localLayoutParams1;
        if (localLayoutParams1 == null) {
          paramView = new LinearLayout.LayoutParams(-1, -2);
        }
        paramView.leftMargin = UIUtils.a(paramContext, 66.0F);
        paramView.rightMargin = UIUtils.a(paramContext, 6.0F);
        paramView.topMargin = UIUtils.a(paramContext, -14.0F);
        ((LinearLayout)localObject).addView(localView2);
        localView2.setId(2131442446);
        localMomentViewHolder.d = localView2;
        localView2.setOnClickListener(this);
      }
      ((LinearLayout)localObject).addView(localView1, localLayoutParams2);
      ((LinearLayout)localObject).setTag(localMomentViewHolder);
      localMomentViewHolder.g.setOnClickListener(this);
      paramView = new View(this.a);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.a(this.a, 10.0F)));
      paramView.setBackgroundColor(-460807);
      ((LinearLayout)localObject).addView(paramView);
      paramView = (View)localObject;
    }
    localObject = (BaseMomentItemBuilder.MomentViewHolder)paramView.getTag();
    ((BaseMomentItemBuilder.MomentViewHolder)localObject).a = paramMomentFeedInfo;
    a((BaseMomentItemBuilder.MomentViewHolder)localObject);
    if ((!TextUtils.isEmpty(paramMomentFeedInfo.p)) && (!paramMomentFeedInfo.p.endsWith(HardCodeUtil.a(2131899261))))
    {
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).h.setCompoundDrawablesWithIntrinsicBounds(2130847163, 0, 0, 0);
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).h.setTextColor(Color.parseColor("#576B95"));
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).h.setOnClickListener(new BaseMomentItemBuilder.1(this, paramContext, paramMomentFeedInfo, (BaseMomentItemBuilder.MomentViewHolder)localObject));
    }
    else
    {
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).h.setCompoundDrawablesWithIntrinsicBounds(2130847161, 0, 0, 0);
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).h.setOnClickListener(null);
      ((BaseMomentItemBuilder.MomentViewHolder)localObject).h.setTextColor(Color.parseColor("#777777"));
    }
    if (this.e.get(((BaseMomentItemBuilder.MomentViewHolder)localObject).a.f) == null)
    {
      paramContext = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card").opName("feed_exp").timelong(h((BaseMomentItemBuilder.MomentViewHolder)localObject));
      paramMomentFeedInfo = "2";
      paramContext = paramContext.source("2").feedid(((BaseMomentItemBuilder.MomentViewHolder)localObject).a.f).feed_type(String.valueOf(g((BaseMomentItemBuilder.MomentViewHolder)localObject)));
      if (this.b) {
        paramMomentFeedInfo = "1";
      }
      paramContext.d1(paramMomentFeedInfo).report(this.c);
      this.e.put(((BaseMomentItemBuilder.MomentViewHolder)localObject).a.f, ((BaseMomentItemBuilder.MomentViewHolder)localObject).a);
    }
    return paramView;
  }
  
  public abstract BaseMomentItemBuilder.MomentViewHolder a();
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(View paramView)
  {
    paramView = (BaseMomentItemBuilder.MomentViewHolder)NearbyMomentUtils.a(paramView, BaseMomentItemBuilder.MomentViewHolder.class);
    if (paramView == null) {
      return;
    }
    c(paramView);
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.d = paramNearbyPeopleCard;
    this.b = paramNearbyPeopleCard.isHostSelf;
  }
  
  public void a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = UIUtils.a(this.a, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = UIUtils.a(this.a, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getResources().getDrawable(2130841062);
    try
    {
      localObject = URLDrawable.getDrawable(paramMomentViewHolder.a.h, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(UIUtils.a(this.a, 40.0F), UIUtils.a(this.a, 40.0F)));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.b);
      paramMomentViewHolder.e.setImageDrawable((Drawable)localObject);
    }
    catch (Exception localException)
    {
      label106:
      List localList;
      INowVideoReporter localINowVideoReporter;
      break label106;
    }
    paramMomentViewHolder.e.setImageDrawable(this.a.getResources().getDrawable(2130841062));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateUI, holder.momentFeedInfo.headUrl=");
    ((StringBuilder)localObject).append(paramMomentViewHolder.a.h);
    QLog.i("BaseMomentItemBuilder", 1, ((StringBuilder)localObject).toString());
    if (this.d != null) {
      paramMomentViewHolder.f.setText(this.d.nickname);
    }
    paramMomentViewHolder.d.setOnClickListener(this);
    f(paramMomentViewHolder);
    if (!TextUtils.isEmpty(paramMomentViewHolder.a.l))
    {
      paramMomentViewHolder.h.setVisibility(0);
      paramMomentViewHolder.h.setText(paramMomentViewHolder.a.l);
    }
    else
    {
      paramMomentViewHolder.h.setVisibility(8);
    }
    localObject = new StringBuilder();
    if (!TextUtils.isEmpty(paramMomentViewHolder.a.k))
    {
      if (((StringBuilder)localObject).length() > 0) {
        ((StringBuilder)localObject).append(" · ");
      }
      ((StringBuilder)localObject).append(paramMomentViewHolder.a.k);
    }
    if (((StringBuilder)localObject).length() > 0)
    {
      paramMomentViewHolder.i.setText(((StringBuilder)localObject).toString());
      paramMomentViewHolder.i.setVisibility(0);
    }
    else
    {
      paramMomentViewHolder.i.setVisibility(8);
    }
    if (i(paramMomentViewHolder))
    {
      paramMomentViewHolder.j.setVisibility(0);
      if (paramMomentViewHolder.a.u)
      {
        paramMomentViewHolder.k.setImageResource(2130847099);
        paramMomentViewHolder.l.setTextColor(-52924);
      }
      else
      {
        paramMomentViewHolder.k.setImageResource(2130847117);
        paramMomentViewHolder.l.setTextColor(-4473925);
      }
      paramMomentViewHolder.l.setText(String.valueOf(paramMomentViewHolder.a.v));
      paramMomentViewHolder.m.setVisibility(0);
      paramMomentViewHolder.n.setText(String.valueOf(paramMomentViewHolder.a.w));
    }
    else
    {
      paramMomentViewHolder.j.setVisibility(8);
    }
    localList = paramMomentViewHolder.a.x;
    if ((localList != null) && (localList.size() > 0))
    {
      paramMomentViewHolder.o.setVisibility(0);
      paramMomentViewHolder.p.a(localList);
      paramMomentViewHolder.p.notifyDataSetChanged();
      if (this.f.get(paramMomentViewHolder.a.f) == null)
      {
        localINowVideoReporter = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card").opName("feed_com_exp");
        localObject = "2";
        localINowVideoReporter = localINowVideoReporter.source("2").timelong(h(paramMomentViewHolder)).feedid(paramMomentViewHolder.a.f).feed_type(String.valueOf(g(paramMomentViewHolder)));
        if (this.b) {
          localObject = "1";
        }
        localINowVideoReporter.d1((String)localObject).report(this.c);
        this.f.put(paramMomentViewHolder.a.f, paramMomentViewHolder.a);
      }
    }
    else
    {
      paramMomentViewHolder.o.setVisibility(8);
    }
    if ((localList != null) && (localList.size() > 0) && (paramMomentViewHolder.a.w > localList.size())) {
      paramMomentViewHolder.q.setVisibility(0);
    } else {
      paramMomentViewHolder.q.setVisibility(8);
    }
    if ((paramMomentViewHolder.o.getVisibility() != 0) && (paramMomentViewHolder.q.getVisibility() != 0)) {
      paramMomentViewHolder.r.setVisibility(8);
    } else {
      paramMomentViewHolder.r.setVisibility(0);
    }
    paramMomentViewHolder.g.setClickable(true);
    paramMomentViewHolder.g.setAlpha(1.0F);
    paramMomentViewHolder.k.setClickable(true);
    paramMomentViewHolder.m.setClickable(true);
    paramMomentViewHolder.k.setAlpha(1.0F);
    paramMomentViewHolder.l.setAlpha(1.0F);
    paramMomentViewHolder.m.setAlpha(1.0F);
    paramMomentViewHolder.n.setAlpha(1.0F);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("raw_url", paramString);
      ((Intent)localObject).putExtra("scroll_to_comment", paramBoolean);
      ((Intent)localObject).putExtra("play_mode", "2");
      ((Intent)localObject).putExtra("is_multi_progress_bar", true);
      ((Intent)localObject).putExtra("_from", "3");
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
      PublicTransFragmentActivity.b(this.a, (Intent)localObject, QQNearbyManager.n());
      return;
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onItemClick exp:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.w("BaseMomentItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void b(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    MomentFeedInfo localMomentFeedInfo = paramMomentViewHolder.a;
    INowVideoReporter localINowVideoReporter = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card").opName("feed_more_clk");
    Object localObject = "2";
    localINowVideoReporter = localINowVideoReporter.source("2").timelong(h(paramMomentViewHolder)).feedid(localMomentFeedInfo.f).feed_type(String.valueOf(g(paramMomentViewHolder)));
    if (this.b) {
      localObject = "1";
    }
    localINowVideoReporter.d1((String)localObject).report(this.c);
    if (TextUtils.equals(this.c.getCurrentAccountUin(), localMomentFeedInfo.i))
    {
      localObject = ActionSheet.create(this.a);
      ((ActionSheet)localObject).addButton(2131888438, 1);
      ((ActionSheet)localObject).addCancelButton(2131887648);
      ((ActionSheet)localObject).setOnButtonClickListener(new BaseMomentItemBuilder.2(this, paramMomentViewHolder, localMomentFeedInfo, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
      return;
    }
    localObject = ActionSheet.create(this.a);
    ((ActionSheet)localObject).addButton(2131914943, 1);
    ((ActionSheet)localObject).addCancelButton(2131887648);
    ((ActionSheet)localObject).setOnButtonClickListener(new BaseMomentItemBuilder.3(this, paramMomentViewHolder, localMomentFeedInfo, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  public void c(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a))
    {
      QQToast.makeText(this.a, 1, HardCodeUtil.a(2131899255), 0).show();
      return;
    }
    a(paramMomentViewHolder.a.r, true);
  }
  
  public void d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    Object localObject = paramMomentViewHolder.a.f;
    INowVideoReporter localINowVideoReporter = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card").opName("feed_clk");
    String str = "2";
    localObject = localINowVideoReporter.source("2").timelong(h(paramMomentViewHolder)).feedid((String)localObject).feed_type(String.valueOf(g(paramMomentViewHolder)));
    if (this.b) {
      str = "1";
    }
    ((INowVideoReporter)localObject).d1(str).report(this.c);
    if (!NetworkUtil.isNetworkAvailable(this.a))
    {
      QQToast.makeText(this.a, 1, HardCodeUtil.a(2131899258), 0).show();
      return;
    }
    a(paramMomentViewHolder.a.r, false);
  }
  
  public void e(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    PicMomentFeedInfo localPicMomentFeedInfo = (PicMomentFeedInfo)paramMomentViewHolder.a;
    Object localObject = localPicMomentFeedInfo.c;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("feedId", localPicMomentFeedInfo.f);
      ((JSONObject)localObject).put("tinyId", "");
      ((JSONObject)localObject).put("uin", localPicMomentFeedInfo.i);
      ((JSONObject)localObject).put("reason", HardCodeUtil.a(2131899259));
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    TroopNoticeJsHandler.a(paramMomentViewHolder.b, 0, localArrayList, null, null, false, false, "5", 100, null, null, ((JSONObject)localObject).toString());
  }
  
  public abstract void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder);
  
  public abstract int g(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder);
  
  public String h(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return "";
  }
  
  public boolean i(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return true;
  }
  
  public String j(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return paramMomentViewHolder.a.f;
  }
  
  public void onClick(View paramView)
  {
    BaseMomentItemBuilder.MomentViewHolder localMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)NearbyMomentUtils.a(paramView, BaseMomentItemBuilder.MomentViewHolder.class);
    if (localMomentViewHolder == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131450030: 
      INowVideoReporter localINowVideoReporter = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card").opName("feed_com_clk");
      paramView = "2";
      localINowVideoReporter = localINowVideoReporter.source("2").timelong(h(localMomentViewHolder)).feedid(localMomentViewHolder.a.f).feed_type(String.valueOf(g(localMomentViewHolder)));
      if (this.b) {
        paramView = "1";
      }
      localINowVideoReporter.d1(paramView).report(this.c);
      break;
    case 2131442446: 
      d(localMomentViewHolder);
      return;
    case 2131436500: 
      l(localMomentViewHolder);
      return;
    case 2131436489: 
      e(localMomentViewHolder);
      return;
    case 2131436457: 
      b(localMomentViewHolder);
      return;
    }
    c(localMomentViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */