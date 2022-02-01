package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.view.widget.BezierSideBarView;
import com.tencent.mobileqq.kandian.base.view.widget.DisableSlideHorizontalListView;
import com.tencent.mobileqq.kandian.base.view.widget.DisableSlideHorizontalListView.OnOverScrollListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentContentRecommendFollowList
  extends RelativeLayout
  implements DisableSlideHorizontalListView.OnOverScrollListener, ComponentInheritView
{
  private static int i = -1;
  protected ReadInJoyObserver a = new ComponentContentRecommendFollowList.6(this);
  private DisableSlideHorizontalListView b;
  private ComponentContentRecommendFollowList.FollowListAdapter c;
  private TextView d;
  private AbsBaseArticleInfo e;
  private View f;
  private View g;
  private IReadInJoyModel h;
  private ComponentNotIntrest j;
  private Set<String> k = new HashSet();
  private Set<Long> l = new HashSet();
  private Set<Long> m = new HashSet();
  private Set<String> n = new HashSet();
  
  public ComponentContentRecommendFollowList(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  @NotNull
  private JSONObject a(int paramInt, Long paramLong)
  {
    JSONObject localJSONObject = getReportStr();
    for (;;)
    {
      try
      {
        localJSONObject.put("acc_seq", paramInt + 1);
        localJSONObject.put("puin", paramLong);
        localJSONObject.put("feeds_type", 70);
        if (this.e != null)
        {
          localJSONObject.put("algorithm_id", this.e.mAlgorithmID);
          localJSONObject.put("rowkey", this.e.innerUniqueID);
        }
        if (ReadinjoyReportUtils.e() > 0)
        {
          paramInt = 0;
          localJSONObject.put("behavior_type", paramInt);
          return localJSONObject;
        }
      }
      catch (JSONException paramLong)
      {
        QLog.d("ComponentContentRecommendFollowList", 1, paramLong.getMessage());
        return localJSONObject;
      }
      paramInt = 1;
    }
  }
  
  private void a(int paramInt, RecommendFollowInfo paramRecommendFollowInfo)
  {
    Object localObject = Long.valueOf(paramRecommendFollowInfo.uin);
    if (!this.l.contains(localObject))
    {
      this.l.add(localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(RIJQQAppInterfaceUtil.c());
      localStringBuilder.append("");
      PublicAccountReportUtils.a(null, localStringBuilder.toString(), "0X800B96C", "0X800B96C", 0, 0, "", "", "", a(paramInt, (Long)localObject).toString(), false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.c());
      ((StringBuilder)localObject).append("");
      PublicAccountReportUtils.a(null, ((StringBuilder)localObject).toString(), "0X800B1A6", "0X800B1A6", 0, 0, "", "", "", c(paramRecommendFollowInfo).toString(), false);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, String paramString)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mRecommendFollowInfos != null) && (paramAbsBaseArticleInfo.mRecommendFollowInfos.h != null))
    {
      if (paramAbsBaseArticleInfo.mRecommendFollowInfos.h.size() <= 0) {
        return;
      }
      Iterator localIterator = paramAbsBaseArticleInfo.mRecommendFollowInfos.h.values().iterator();
      while (localIterator.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
        String str = ComponentContentRecommend.a(paramInt, localRecommendFollowInfo.uin, paramAbsBaseArticleInfo, localRecommendFollowInfo.algorithmId, 2, 0, i, null);
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(RIJQQAppInterfaceUtil.c());
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mRecommendFollowId);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramAbsBaseArticleInfo.mArticleID);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localRecommendFollowInfo.strategyId);
        localStringBuilder.append("");
        PublicAccountReportUtils.a(null, (String)localObject1, "0X80094DB", "0X80094DB", 0, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), str, false);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(RIJQQAppInterfaceUtil.c());
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mRecommendFollowId);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramAbsBaseArticleInfo.mArticleID);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localRecommendFollowInfo.strategyId);
        localStringBuilder.append("");
        PublicAccountReportUtils.a(null, (String)localObject1, paramString, paramString, 0, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), str, false);
      }
      paramAbsBaseArticleInfo.mRecommendFollowInfos.h.clear();
    }
  }
  
  private void a(RecommendFollowInfo paramRecommendFollowInfo, int paramInt)
  {
    if ((paramRecommendFollowInfo != null) && (paramRecommendFollowInfo.uin != 0L))
    {
      JSONObject localJSONObject = a(paramInt, Long.valueOf(paramRecommendFollowInfo.uin));
      if (!this.m.contains(Long.valueOf(paramRecommendFollowInfo.uin)))
      {
        this.m.add(Long.valueOf(paramRecommendFollowInfo.uin));
        paramRecommendFollowInfo = new StringBuilder();
        paramRecommendFollowInfo.append(RIJQQAppInterfaceUtil.c());
        paramRecommendFollowInfo.append("");
        PublicAccountReportUtils.a(null, paramRecommendFollowInfo.toString(), "0X800B96D", "0X800B96D", 0, 0, "", "", "", localJSONObject.toString(), false);
      }
      paramRecommendFollowInfo = this.e;
      if ((paramRecommendFollowInfo != null) && (!this.n.contains(paramRecommendFollowInfo.innerUniqueID)))
      {
        this.n.add(this.e.innerUniqueID);
        paramRecommendFollowInfo = new StringBuilder();
        paramRecommendFollowInfo.append(RIJQQAppInterfaceUtil.c());
        paramRecommendFollowInfo.append("");
        PublicAccountReportUtils.a(null, paramRecommendFollowInfo.toString(), "0X800B96B", "0X800B96B", 0, 0, "", "", "", localJSONObject.toString(), false);
        paramRecommendFollowInfo = new StringBuilder();
        paramRecommendFollowInfo.append(RIJQQAppInterfaceUtil.c());
        paramRecommendFollowInfo.append("");
        PublicAccountReportUtils.a(null, paramRecommendFollowInfo.toString(), "0X8007625", "0X8007625", 0, 0, "", "", "", localJSONObject.toString(), false);
      }
    }
  }
  
  private JSONObject c(RecommendFollowInfo paramRecommendFollowInfo)
  {
    JSONObject localJSONObject = getReportStr();
    for (;;)
    {
      try
      {
        localJSONObject.put("app_type", ReadinjoyReportUtils.h());
        if (this.e == null) {
          break label209;
        }
        l1 = this.e.mChannelID;
        localJSONObject.put("channel_id", l1);
        if (paramRecommendFollowInfo != null)
        {
          localJSONObject.put("ugcuin", paramRecommendFollowInfo.uin);
          localJSONObject.put("puin", paramRecommendFollowInfo.uin);
          boolean bool = paramRecommendFollowInfo.isFollowed;
          int i2 = 2;
          if (!bool) {
            break label217;
          }
          i1 = 2;
          localJSONObject.put("button_type", i1);
          i1 = i2;
          if (paramRecommendFollowInfo.isFollowed) {
            i1 = 1;
          }
          localJSONObject.put("click_type", i1);
        }
        if (this.e != null)
        {
          if (this.e.mChannelID != 0L) {
            break label222;
          }
          i1 = 14;
          localJSONObject.put("scene_type", i1);
          localJSONObject.put("channel_id", this.e.mChannelID);
          localJSONObject.put("algorithm_id", this.e.mAlgorithmID);
          return localJSONObject;
        }
      }
      catch (JSONException paramRecommendFollowInfo)
      {
        QLog.d("ComponentContentRecommendFollowList", 1, paramRecommendFollowInfo.getMessage());
      }
      return localJSONObject;
      label209:
      long l1 = -1L;
      continue;
      label217:
      int i1 = 1;
      continue;
      label222:
      i1 = -1;
    }
  }
  
  private void c()
  {
    Object localObject = this.e;
    if ((localObject != null) && (!TextUtils.isEmpty(((AbsBaseArticleInfo)localObject).innerUniqueID)) && (!this.k.contains(this.e.innerUniqueID)))
    {
      this.k.add(this.e.innerUniqueID);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.c());
      ((StringBuilder)localObject).append("");
      PublicAccountReportUtils.a(null, ((StringBuilder)localObject).toString(), "0X800B96A", "0X800B96A", 0, 0, "", "", "", getReportStr().toString(), false);
    }
  }
  
  private void d(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if ((paramRecommendFollowInfo != null) && (paramRecommendFollowInfo.uin != 0L))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(RIJQQAppInterfaceUtil.c());
      localStringBuilder.append("");
      PublicAccountReportUtils.a(null, localStringBuilder.toString(), "0X800B1A7", "0X800B1A7", 0, 0, "", "", "", c(paramRecommendFollowInfo).toString(), false);
    }
  }
  
  private JSONObject getReportStr()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (this.e != null)
        {
          if (this.e.mChannelID != 0L) {
            break label207;
          }
          i1 = 1;
          localJSONObject.put("acc_rec_location", i1);
          localJSONObject.put("channel_id", this.e.mChannelID);
          RIJFeedsInsertAction localRIJFeedsInsertAction = this.e.insertAction;
          int i2 = 0;
          if ((localRIJFeedsInsertAction == null) || (this.e.insertAction.a() == null)) {
            break label212;
          }
          i1 = this.e.insertAction.a().toPBInt();
          localJSONObject.put("trigger_type", i1);
          localJSONObject.put("scene_type", getSceneType());
          localJSONObject.put("kandian_mode_new", VideoReporter.c());
          localJSONObject.put("feeds_type", 70);
          localJSONObject.put("algorithm_id", this.e.mAlgorithmID);
          localJSONObject.put("rowkey", this.e.innerUniqueID);
          if (ReadinjoyReportUtils.e() <= 0) {
            break label217;
          }
          i1 = i2;
          localJSONObject.put("behavior_type", i1);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.d("ComponentContentRecommendFollowList", 1, localJSONException.getMessage());
      }
      return localJSONObject;
      label207:
      int i1 = -1;
      continue;
      label212:
      i1 = 0;
      continue;
      label217:
      i1 = 1;
    }
  }
  
  private int getSceneType()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.e;
    int i1 = 1;
    if (localAbsBaseArticleInfo != null)
    {
      if ((localAbsBaseArticleInfo.insertAction != null) && (this.e.insertAction.a().getActionType() == ActionType.ACTION_DATA_CARD_FOLLOW.getActionType())) {
        return 4;
      }
      int i2 = this.e.reqSource;
      if (i2 == 1) {
        return i1;
      }
      if (i2 != 5)
      {
        if (i2 == 6) {
          return 3;
        }
      }
      else {
        return 2;
      }
    }
    i1 = 0;
    return i1;
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626178, this, true);
  }
  
  public void a()
  {
    b();
  }
  
  public void a(View paramView)
  {
    this.b = ((DisableSlideHorizontalListView)paramView.findViewById(2131444459));
    this.d = ((TextView)paramView.findViewById(2131444467));
    this.f = paramView.findViewById(2131436957);
    this.g = paramView.findViewById(2131444462);
    this.j = ((ComponentNotIntrest)paramView.findViewById(2131439399));
    BezierSideBarView localBezierSideBarView = (BezierSideBarView)paramView.findViewById(2131429396);
    this.b.setSideBarView(localBezierSideBarView);
    this.c = new ComponentContentRecommendFollowList.FollowListAdapter(this, null);
    this.b.setDividerWidth(DisplayUtil.a(paramView.getContext(), 5.0F));
    this.b.setAdapter(this.c);
    this.b.setOnOverScrollListener(this);
    this.g.setOnClickListener(new ComponentContentRecommendFollowList.1(this));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.j.a(paramCellListener);
  }
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    ReadInJoyLogicEngine.a().f(this.e);
    ThreadManager.post(new ComponentContentRecommendFollowList.3(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    if (NetworkUtil.isNetworkAvailable(getContext()))
    {
      if (paramBoolean) {
        a("0X80094DC", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 1);
      } else {
        a("0X80094DD", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 1);
      }
      if (paramRecommendFollowInfo.type == 1) {
        c(paramRecommendFollowInfo, paramBoolean);
      }
      for (;;)
      {
        break;
        if (paramRecommendFollowInfo.type == 2)
        {
          b(paramRecommendFollowInfo, paramBoolean);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("followAccount, error type, info.type = ");
          localStringBuilder.append(paramRecommendFollowInfo.type);
          localStringBuilder.append(", follow = ");
          localStringBuilder.append(paramBoolean);
          QLog.e("ComponentContentRecommendFollowList", 1, localStringBuilder.toString());
        }
      }
      this.c.notifyDataSetChanged();
      return;
    }
    QQToast.makeText(getContext(), 1, 2131915450, 0).show();
  }
  
  public void a(Object paramObject)
  {
    i = RIJTransMergeKanDianReport.b();
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.h = ((IReadInJoyModel)paramObject);
      this.e = this.h.k();
      paramObject = this.e;
      if (paramObject == null) {
        return;
      }
      paramObject = paramObject.mRecommendFollowInfos;
      this.d.setText(paramObject.e);
      this.c.a(paramObject.c);
      if (this.e.mRecommendFollowInfos.a)
      {
        this.f.setVisibility(0);
        return;
      }
      this.f.setVisibility(8);
    }
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    Object localObject1 = this.h;
    int i1;
    if ((localObject1 != null) && (((IReadInJoyModel)localObject1).u() != null)) {
      i1 = this.h.u().c();
    } else {
      i1 = 0;
    }
    localObject1 = ComponentContentRecommend.a(i1, paramLong1, this.e, paramLong2, 2, paramInt2, i, null);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(RIJQQAppInterfaceUtil.c());
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.e.mRecommendFollowId);
    ((StringBuilder)localObject3).append("");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(this.e.mArticleID);
    ((StringBuilder)localObject4).append("");
    localObject4 = ((StringBuilder)localObject4).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("");
    PublicAccountReportUtils.a(null, (String)localObject2, paramString, paramString, 0, 0, (String)localObject3, (String)localObject4, localStringBuilder.toString(), (String)localObject1, false);
  }
  
  protected void b()
  {
    Object localObject = this.e.mRecommendFollowInfos.f;
    ReadInJoyUtils.b(getContext(), (String)localObject);
    localObject = (RecommendFollowInfo)this.e.mRecommendFollowInfos.c.get(0);
    a("0X800955C", 0L, ((RecommendFollowInfo)localObject).algorithmId, ((RecommendFollowInfo)localObject).strategyId, 0);
  }
  
  public void b(Context paramContext)
  {
    a(a(paramContext));
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!NetworkUtil.isNetworkAvailable(getContext()))
    {
      QQToast.makeText(getContext(), 1, 2131915450, 0).show();
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpToProfile, info = ");
      ((StringBuilder)localObject).append(paramRecommendFollowInfo);
      QLog.d("ComponentContentRecommendFollowList", 1, ((StringBuilder)localObject).toString());
    }
    if (paramRecommendFollowInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ReadInJoyConstants.l);
      ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2));
      localObject = ((StringBuilder)localObject).toString();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (ViolaAccessHelper.e((String)localObject)))
      {
        ViolaAccessHelper.a(getContext(), null, ViolaAccessHelper.f((String)localObject), null);
        return;
      }
      Intent localIntent = new Intent(getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      getContext().startActivity(localIntent);
      a("0X80094DA", paramRecommendFollowInfo.uin, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId, 0);
    }
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().c();
    localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRecommendFollowInfo.uin);
    localStringBuilder.append("");
    localUserOperationModule.request0x978((String)localObject, localStringBuilder.toString(), paramBoolean, paramRecommendFollowInfo.headUrl, new ComponentContentRecommendFollowList.2(this, paramRecommendFollowInfo), 2);
  }
  
  protected void c(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      ReadInJoyLogicEngine.a().c().request0x978(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, true, paramRecommendFollowInfo.headUrl, new ComponentContentRecommendFollowList.4(this, paramRecommendFollowInfo), 1);
      return;
    }
    ReadInJoyLogicEngine.a().c().request0x978(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, false, paramRecommendFollowInfo.headUrl, new ComponentContentRecommendFollowList.5(this, paramRecommendFollowInfo), 1);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowList
 * JD-Core Version:    0.7.0.1
 */