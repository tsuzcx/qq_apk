package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.kandian.ad.api.IRIJADExposureService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView.OnDrawCompleteListener;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager;
import com.tencent.mobileqq.kandian.biz.feeds.ReadinjoyFixPosArticleManager;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.RIJPreloadImage;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReporter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.pts.PTSPreLayoutHandler;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJDataManager
{
  ReadInJoyBaseListView.OnDrawCompleteListener a;
  protected List<AbsBaseArticleInfo> b = new ArrayList();
  public AbsListView.OnScrollListener c = new RIJDataManager.2(this);
  private RIJDataManager.Builder d;
  private Handler e;
  private RIJDataManager.CheckingHandler f;
  
  public RIJDataManager(RIJDataManager.Builder paramBuilder)
  {
    this.d = paramBuilder;
    this.e = new Handler();
    this.a = new RIJDataManager.OnDrawCompleteListener(this, this);
    this.f = new RIJDataManager.CheckingHandler(null);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.b();
      if ((b().size() > 0) && (paramInt1 == 70))
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)b().get(0);
        if ((localAbsBaseArticleInfo != null) && ((localAbsBaseArticleInfo instanceof BaseArticleInfo))) {
          ((KandianSubscribeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a(localAbsBaseArticleInfo, NetConnInfoCenter.getServerTime());
        }
      }
    }
  }
  
  private void c(List<AbsBaseArticleInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("articleInfo list size =  ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("RIJDataManager", 1, ((StringBuilder)localObject).toString());
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject).next();
        if (localAbsBaseArticleInfo != null) {
          localArrayList.add(localAbsBaseArticleInfo);
        } else {
          QLog.d("RIJDataManager", 1, "has null items");
        }
      }
      paramList.clear();
      paramList.addAll(localArrayList);
    }
    paramList = new StringBuilder();
    paramList.append("tempList size =  ");
    paramList.append(localArrayList.size());
    QLog.d("RIJDataManager", 1, paramList.toString());
  }
  
  private void l()
  {
    if (ReadInJoyHelper.h("android_add_check_scene")) {
      ((IRIJADExposureService)RIJQQAppInterfaceUtil.a().getRuntimeService(IRIJADExposureService.class)).checkAndReportAdExposure(a().v(), (Activity)a().A(), false);
    }
  }
  
  private void m()
  {
    if (ReadInJoyHelper.h("clear_after_disappear")) {
      ((IRIJADExposureService)RIJQQAppInterfaceUtil.a().getRuntimeService(IRIJADExposureService.class)).clearAdExposureTime();
    }
  }
  
  private void n()
  {
    o();
    this.f.a(this);
    this.f.sendEmptyMessageDelayed(1, 1000L);
  }
  
  private void o()
  {
    this.f.removeCallbacksAndMessages(null);
  }
  
  public RIJDataManager.Builder a()
  {
    return this.d;
  }
  
  public ReadInJoyModelImpl a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo;
    if (paramInt2 < e() - 1) {
      localAbsBaseArticleInfo = c(paramInt2 + 1);
    } else {
      localAbsBaseArticleInfo = null;
    }
    return new ReadInJoyModelImpl(this.d.A(), paramAbsBaseArticleInfo, paramInt1, this.d.B(), this.d.r(), paramInt2, this.d.n(), e(), localAbsBaseArticleInfo, this.d.v());
  }
  
  public AbsBaseArticleInfo a(Activity paramActivity)
  {
    long l = paramActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
    AbsBaseArticleInfo localAbsBaseArticleInfo2 = ReadInJoyLogicEngine.a().a(0, l);
    AbsBaseArticleInfo localAbsBaseArticleInfo1 = localAbsBaseArticleInfo2;
    if (localAbsBaseArticleInfo2 == null) {
      localAbsBaseArticleInfo1 = (AbsBaseArticleInfo)paramActivity.getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
    }
    return localAbsBaseArticleInfo1;
  }
  
  public Object a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < b().size())) {
      return c(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, ArrayList<AbsBaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayList.size() > 0) {
      paramArrayList = (AbsBaseArticleInfo)paramArrayList.get(0);
    } else {
      paramArrayList = null;
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramArrayList)) {
      l();
    }
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo, ReadInJoyXListView paramReadInJoyXListView)
  {
    int j = 0;
    int i = 0;
    Object localObject2;
    for (;;)
    {
      int k = b().size();
      localObject2 = null;
      if (i >= k) {
        break;
      }
      localObject1 = (AbsBaseArticleInfo)b().get(i);
      if ((localObject1 instanceof AdvertisementInfo))
      {
        String str = paramAdvertisementInfo.mAdTraceId;
        localObject1 = (AdvertisementInfo)localObject1;
        if (str.equals(((AdvertisementInfo)localObject1).mAdTraceId)) {
          break label89;
        }
      }
      i += 1;
    }
    i = -1;
    Object localObject1 = null;
    label89:
    if (i >= 0)
    {
      if (localObject1 == null) {
        return;
      }
      for (;;)
      {
        paramAdvertisementInfo = localObject2;
        if (j >= paramReadInJoyXListView.getChildCount()) {
          break;
        }
        paramAdvertisementInfo = paramReadInJoyXListView.getChildAt(j).getTag(2131449867);
        if (!(paramAdvertisementInfo instanceof IReadInJoyModel))
        {
          paramAdvertisementInfo = localObject2;
          break;
        }
        if (localObject1 == ((IReadInJoyModel)paramAdvertisementInfo).k())
        {
          paramAdvertisementInfo = paramReadInJoyXListView.getChildAt(j);
          break;
        }
        j += 1;
      }
      if (paramAdvertisementInfo == null) {
        return;
      }
      paramReadInJoyXListView = paramAdvertisementInfo;
      if ((paramAdvertisementInfo instanceof ProteusItemView)) {
        paramReadInJoyXListView = ((ProteusItemView)paramAdvertisementInfo).getContainer();
      }
      paramAdvertisementInfo = new RIJDataManager.1(this, (AbsBaseArticleInfo)localObject1, i);
      localObject1 = (Animation)paramReadInJoyXListView.getTag(2131436721);
      if (localObject1 == null) {
        return;
      }
      ((Animation)localObject1).setAnimationListener(paramAdvertisementInfo);
      paramReadInJoyXListView.startAnimation((Animation)localObject1);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, boolean paramBoolean)
  {
    if ((b() != null) && (b().contains(paramAbsBaseArticleInfo1)))
    {
      int i = b().indexOf(paramAbsBaseArticleInfo1);
      if (paramBoolean) {
        b().remove(i + 1);
      }
      if ((paramAbsBaseArticleInfo2 instanceof BaseArticleInfo)) {
        b().add(i + 1, paramAbsBaseArticleInfo2);
      }
      this.d.v().notifyDataSetChanged();
    }
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    if ((paramList != null) && (this.b.getClass().isInstance(paramList)) && (paramList.size() > 0))
    {
      c(paramList);
      this.b.clear();
      this.b.addAll(paramList);
      this.d.e(true);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setData:");
      int i;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      localStringBuilder.append(i);
      QLog.d("RIJDataManager", 2, localStringBuilder.toString());
    }
    this.d.h().a(System.nanoTime());
    VideoBehaviorsReporter.a().a(this.d.v(), b());
  }
  
  public void a(List<AbsBaseArticleInfo> paramList, int paramInt)
  {
    b().removeAll(paramList);
    this.d.e(true);
    this.d.v().notifyDataSetChanged();
    int i = 0;
    while (i < paramList.size())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.get(i);
      if (localAbsBaseArticleInfo != null)
      {
        long l = localAbsBaseArticleInfo.mRecommendSeq;
        if (ReadinjoyFixPosArticleManager.isFixPosArticleSeq(l)) {
          ReadinjoyFixPosArticleManager.getInstant().deleteFixPosArticle(this.d.B(), l);
        } else {
          ReadInJoyLogicEngine.a().a(this.d.B(), localAbsBaseArticleInfo);
        }
      }
      i += 1;
    }
    a(this.d.B(), paramInt);
  }
  
  public long b(int paramInt)
  {
    Object localObject = a(paramInt);
    if ((localObject instanceof BaseArticleInfo)) {
      return ((AbsBaseArticleInfo)localObject).mArticleID;
    }
    return paramInt;
  }
  
  public List<AbsBaseArticleInfo> b()
  {
    return this.b;
  }
  
  public void b(int paramInt, ArrayList<AbsBaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      b().removeAll(paramArrayList);
      a().e(true);
      a().v().notifyDataSetChanged();
    }
    int i = paramArrayList.size();
    int j = 0;
    AbsBaseArticleInfo localAbsBaseArticleInfo;
    if (i > 0) {
      localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramArrayList.get(0);
    } else {
      localAbsBaseArticleInfo = null;
    }
    i = 2131897938;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo)) {
      i = 2131897939;
    }
    if ((a().A() instanceof BaseActivity)) {
      QQToast.makeText(a().A(), -1, a().A().getString(i), 0).show(((BaseActivity)a().A()).getTitleBarHeight());
    } else if ((a().A() instanceof PluginBaseActivity)) {
      QQToast.makeText(a().A(), -1, a().A().getString(i), 0).show(((PluginBaseActivity)a().A()).L());
    }
    a().v().a(paramInt, paramArrayList, paramArrayList1);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo))
    {
      long l2 = 0L;
      long l1 = l2;
      if (paramObject != null)
      {
        l1 = l2;
        if ((paramObject instanceof DislikeInfo)) {
          l1 = ((DislikeInfo)paramObject).e;
        }
      }
      if ((localAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        paramArrayList = (AdvertisementInfo)localAbsBaseArticleInfo;
      } else {
        paramArrayList = null;
      }
      ReadInJoyLogicEngine.a().a(a().A(), paramArrayList, l1, paramArrayList1, paramBoolean1);
    }
    try
    {
      paramArrayList = new JSONObject();
      paramArrayList.put("time", System.currentTimeMillis() / 1000L);
      paramArrayList.put("channel_id", a().B());
      paramInt = j;
      if (paramArrayList1 != null) {
        paramInt = paramArrayList1.size();
      }
      paramArrayList.put("tag_num", paramInt);
      paramBoolean1 = a().A() instanceof BaseActivity;
      if (paramBoolean1)
      {
        paramArrayList.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        paramArrayList.put("kandian_mode", RIJAppSetting.b());
        if (localAbsBaseArticleInfo != null)
        {
          paramObject = new StringBuilder();
          paramObject.append("");
          paramObject.append(RIJFeedsType.g(localAbsBaseArticleInfo));
          paramArrayList.put("feeds_type", paramObject.toString());
          paramArrayList.put("rowkey", ReadinjoyReportUtils.c(localAbsBaseArticleInfo));
        }
        paramArrayList = paramArrayList.toString();
        PublicAccountReportUtils.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", RIJDislikeManager.a(paramArrayList1), paramArrayList, false);
      }
      else if ((a().A() instanceof PluginBaseActivity))
      {
        paramArrayList.put("folder_status", 1);
        ReportController.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", paramArrayList.toString());
      }
    }
    catch (JSONException paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
    PTSPreLayoutHandler.a(localAbsBaseArticleInfo);
  }
  
  public void b(List<AbsBaseArticleInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteData: ");
    localStringBuilder.append(paramList);
    QLog.d("RIJDataManager", 2, localStringBuilder.toString());
    EmojiManagerServiceConstant.printStackTraces(8);
    if ((paramList != null) && (b().getClass().isInstance(paramList)) && (paramList.size() > 0)) {
      b().removeAll(paramList);
    }
  }
  
  public ReadInJoyBaseListView.OnDrawCompleteListener c()
  {
    return this.a;
  }
  
  public AbsBaseArticleInfo c(int paramInt)
  {
    if ((this.b.size() > 0) && (paramInt < this.b.size())) {
      return (AbsBaseArticleInfo)this.b.get(paramInt);
    }
    return null;
  }
  
  public void d()
  {
    b().clear();
  }
  
  public int e()
  {
    return b().size();
  }
  
  public void f()
  {
    QLog.d("RIJDataManager", 1, "invalidAllArticles");
    ProteusSupportUtil.b(a().g(), "default_feeds");
    if (b() != null)
    {
      Iterator localIterator = b().iterator();
      while (localIterator.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator.next();
        if (localAbsBaseArticleInfo != null) {
          localAbsBaseArticleInfo.invalidateProteusTemplateBean();
        }
      }
    }
  }
  
  public void g()
  {
    m();
    o();
  }
  
  public void h()
  {
    l();
    n();
  }
  
  public void i()
  {
    l();
  }
  
  public void j()
  {
    l();
    m();
    o();
  }
  
  public void k()
  {
    l();
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager
 * JD-Core Version:    0.7.0.1
 */