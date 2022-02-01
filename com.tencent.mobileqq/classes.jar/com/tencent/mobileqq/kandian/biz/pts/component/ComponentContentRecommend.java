package com.tencent.mobileqq.kandian.biz.pts.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.widgets.ListViewForListview;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentContentRecommend
  extends FrameLayout
  implements ComponentInheritView
{
  public static final String a = "ComponentContentRecommend";
  private static int l = -1;
  protected ReadInJoyObserver b = new ComponentContentRecommend.7(this);
  private Context c;
  private CmpCtxt d;
  private LinearLayout e;
  private TextView f;
  private ImageView g;
  private ListViewForListview h;
  private BaseAdapter i;
  private ArrayList<RecommendFollowInfo> j = new ArrayList();
  private AbsBaseArticleInfo k;
  
  public ComponentContentRecommend(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  public ComponentContentRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext);
  }
  
  public static String a(int paramInt1, long paramLong1, AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong2, int paramInt2, int paramInt3, int paramInt4, List<RecommendFollowInfo> paramList)
  {
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLong2);
        localStringBuilder.append("");
        ((JSONObject)localObject).put("algorithm_id", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(RIJKanDianFolderStatus.reportFolderStatus);
        localStringBuilder.append("");
        ((JSONObject)localObject).put("folder_status", localStringBuilder.toString());
        ((JSONObject)localObject).put("feeds_type", "70");
        ((JSONObject)localObject).put("time", System.currentTimeMillis());
        ((JSONObject)localObject).put("channel_id", paramInt1);
        if (NetworkState.isWifiConn())
        {
          paramInt1 = 2;
          ((JSONObject)localObject).put("network_type", paramInt1);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramLong1);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("feeds_source", localStringBuilder.toString());
          ((JSONObject)localObject).put("imei", ReadInJoyUtils.c());
          ((JSONObject)localObject).put("imsi", ReadInJoyUtils.d());
          ((JSONObject)localObject).put("idfa", "");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramAbsBaseArticleInfo.innerUniqueID);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("rowkey", localStringBuilder.toString());
          int m = 0;
          ((JSONObject)localObject).put("comment", 0);
          if (ReadInJoyHelper.ah(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            break label507;
          }
          paramInt1 = 1;
          ((JSONObject)localObject).put("reddot_style", paramInt1);
          ((JSONObject)localObject).put("tab_source", paramInt4);
          ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.b());
          if (ReadinjoyReportUtils.e() <= 0) {
            break label512;
          }
          paramInt1 = 0;
          ((JSONObject)localObject).put("behavior_type", paramInt1);
          if (paramInt3 != 0) {
            ((JSONObject)localObject).put("select_num", paramInt3);
          }
          ((JSONObject)localObject).put("sub_type", paramInt2);
          if ((paramList != null) && (!paramList.isEmpty()))
          {
            paramAbsBaseArticleInfo = new StringBuilder();
            paramInt1 = m;
            if (paramInt1 < paramList.size())
            {
              paramAbsBaseArticleInfo.append(((RecommendFollowInfo)paramList.get(paramInt1)).uin);
              if (paramInt1 >= paramList.size() - 1) {
                break label517;
              }
              paramAbsBaseArticleInfo.append("|");
              break label517;
            }
            ((JSONObject)localObject).put("feedssource_more", paramAbsBaseArticleInfo.toString());
          }
          paramAbsBaseArticleInfo = ((JSONObject)localObject).toString();
          return paramAbsBaseArticleInfo;
        }
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          paramList = a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("report");
          ((StringBuilder)localObject).append(QLog.getStackTraceString(paramAbsBaseArticleInfo));
          QLog.e(paramList, 2, ((StringBuilder)localObject).toString());
        }
        return "";
      }
      paramInt1 = 1;
      continue;
      label507:
      paramInt1 = 0;
      continue;
      label512:
      paramInt1 = 1;
      continue;
      label517:
      paramInt1 += 1;
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
        a("0X80094DB", paramInt, localRecommendFollowInfo.uin, paramAbsBaseArticleInfo, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId);
        a(paramString, paramInt, localRecommendFollowInfo.uin, paramAbsBaseArticleInfo, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId);
      }
      paramAbsBaseArticleInfo.mRecommendFollowInfos.h.clear();
    }
  }
  
  public static void a(String paramString, int paramInt1, long paramLong1, AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong2, int paramInt2)
  {
    String str = a(paramInt1, paramLong1, paramAbsBaseArticleInfo, paramLong2, 1, 0, l, null);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(RIJQQAppInterfaceUtil.c());
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo.mRecommendFollowId);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
    localStringBuilder.append("");
    paramAbsBaseArticleInfo = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("");
    PublicAccountReportUtils.a(null, (String)localObject1, paramString, paramString, 0, 0, (String)localObject2, paramAbsBaseArticleInfo, localStringBuilder.toString(), str, false);
  }
  
  private void a(String paramString, RecommendFollowInfo paramRecommendFollowInfo)
  {
    CmpCtxt localCmpCtxt = this.d;
    int m;
    if ((localCmpCtxt != null) && (localCmpCtxt.a() != null) && (this.d.a().u() != null)) {
      m = this.d.a().u().c();
    } else {
      m = 0;
    }
    a(paramString, m, paramRecommendFollowInfo.uin, this.k, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId);
  }
  
  private void c()
  {
    CmpCtxt localCmpCtxt = this.d;
    int m;
    if ((localCmpCtxt != null) && (localCmpCtxt.a() != null) && (this.d.a().u() != null)) {
      m = this.d.a().u().c();
    } else {
      m = 0;
    }
    a("0X8009494", m, 0L, this.k, 0L, 0);
  }
  
  private void c(Context paramContext)
  {
    this.d = new CmpCtxt();
    this.c = paramContext;
    a(paramContext);
    a();
  }
  
  private void setContent(IReadInJoyModel paramIReadInJoyModel)
  {
    this.k = paramIReadInJoyModel.k();
    if (this.k == null) {
      return;
    }
    l = RIJTransMergeKanDianReport.b();
    paramIReadInJoyModel = this.k.mRecommendFollowInfos;
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.c != null) && (paramIReadInJoyModel.c.size() > 0))
    {
      if (this.k.mRecommendFollowInfos.a) {
        this.e.setVisibility(0);
      } else {
        this.e.setVisibility(8);
      }
      this.j.clear();
      this.j.addAll(this.k.mRecommendFollowInfos.c);
      this.i.notifyDataSetChanged();
      paramIReadInJoyModel = new ComponentContentRecommend.1(this);
      this.f.setOnClickListener(paramIReadInJoyModel);
      this.g.setOnClickListener(paramIReadInJoyModel);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(a, 2, "setContent(): data is empty");
    }
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(b(paramContext));
  }
  
  public void a(View paramView)
  {
    this.e = ((LinearLayout)paramView.findViewById(2131436957));
    this.g = ((ImageView)paramView.findViewById(2131436312));
    this.f = ((TextView)paramView.findViewById(2131448321));
    this.h = ((ListViewForListview)paramView.findViewById(2131437784));
    this.i = b();
    this.h.setAdapter(this.i);
  }
  
  public void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(paramImageView.getContext(), 2130772306);
    if (localAnimation != null)
    {
      localAnimation.setInterpolator(new LinearInterpolator());
      paramImageView.startAnimation(localAnimation);
    }
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!NetworkUtil.isNetworkAvailable(getContext()))
    {
      QQToast.makeText(getContext(), 1, 2131915450, 0).show();
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpToProfile, info = ");
      localStringBuilder.append(paramRecommendFollowInfo);
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
    if (paramRecommendFollowInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ReadInJoyConstants.l);
      ((StringBuilder)localObject).append(Base64Util.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2));
      paramRecommendFollowInfo = ((StringBuilder)localObject).toString();
      if ((!TextUtils.isEmpty(paramRecommendFollowInfo)) && (ViolaAccessHelper.e(paramRecommendFollowInfo)))
      {
        ViolaAccessHelper.a(getContext(), null, ViolaAccessHelper.f(paramRecommendFollowInfo), null);
        return;
      }
      localObject = new Intent(getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
      ((Intent)localObject).putExtra("url", paramRecommendFollowInfo);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      ((Activity)getContext()).startActivityForResult((Intent)localObject, 1);
    }
  }
  
  protected void a(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    if (NetworkUtil.isNetworkAvailable(getContext()))
    {
      if (paramBoolean) {
        a("0X80094DC", paramRecommendFollowInfo);
      } else {
        a("0X80094DD", paramRecommendFollowInfo);
      }
      if (paramRecommendFollowInfo.type == 1)
      {
        c(paramRecommendFollowInfo, paramBoolean);
      }
      else if (paramRecommendFollowInfo.type == 2)
      {
        b(paramRecommendFollowInfo, paramBoolean);
      }
      else
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("followAccount, error type, info.type = ");
        localStringBuilder.append(paramRecommendFollowInfo.type);
        localStringBuilder.append(", follow = ");
        localStringBuilder.append(paramBoolean);
        QLog.e(str, 1, localStringBuilder.toString());
      }
      this.i.notifyDataSetChanged();
      return;
    }
    QQToast.makeText(getContext(), 1, 2131915450, 0).show();
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.d.a(paramObject);
      setContent(paramObject);
    }
  }
  
  public View b(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626177, this, true);
  }
  
  protected BaseAdapter b()
  {
    return new ComponentContentRecommend.2(this);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(paramRecommendFollowInfo.uin, paramRecommendFollowInfo.isFollowed);
    ReadInJoyLogicEngine.a().f(this.k);
    ThreadManager.post(new ComponentContentRecommend.6(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().c();
    localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRecommendFollowInfo.uin);
    localStringBuilder.append("");
    localUserOperationModule.request0x978((String)localObject, localStringBuilder.toString(), paramBoolean, paramRecommendFollowInfo.headUrl, new ComponentContentRecommend.3(this, paramRecommendFollowInfo), 2);
  }
  
  protected void c(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      ReadInJoyLogicEngine.a().c().request0x978(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, true, paramRecommendFollowInfo.headUrl, new ComponentContentRecommend.4(this, paramRecommendFollowInfo), 1);
      return;
    }
    ReadInJoyLogicEngine.a().c().request0x978(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, false, paramRecommendFollowInfo.headUrl, new ComponentContentRecommend.5(this, paramRecommendFollowInfo), 1);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.b);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommend
 * JD-Core Version:    0.7.0.1
 */