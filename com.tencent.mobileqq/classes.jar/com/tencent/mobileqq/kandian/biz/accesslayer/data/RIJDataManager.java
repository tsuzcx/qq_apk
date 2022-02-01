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
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RIJDataManager.Builder jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder;
  ReadInJoyBaseListView.OnDrawCompleteListener jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$OnDrawCompleteListener;
  public AbsListView.OnScrollListener a;
  protected List<AbsBaseArticleInfo> a;
  
  public RIJDataManager(RIJDataManager.Builder paramBuilder)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new RIJDataManager.2(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder = paramBuilder;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$OnDrawCompleteListener = new RIJDataManager.OnDrawCompleteListener(this, this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
      if ((a().size() > 0) && (paramInt1 == 70))
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)a().get(0);
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
  
  public int a()
  {
    return a().size();
  }
  
  public long a(int paramInt)
  {
    Object localObject = a(paramInt);
    if ((localObject instanceof BaseArticleInfo)) {
      return ((AbsBaseArticleInfo)localObject).mArticleID;
    }
    return paramInt;
  }
  
  public RIJDataManager.Builder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder;
  }
  
  public ReadInJoyBaseListView.OnDrawCompleteListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$OnDrawCompleteListener;
  }
  
  public ReadInJoyModelImpl a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo;
    if (paramInt2 < a() - 1) {
      localAbsBaseArticleInfo = a(paramInt2 + 1);
    } else {
      localAbsBaseArticleInfo = null;
    }
    return new ReadInJoyModelImpl(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder.a(), paramAbsBaseArticleInfo, paramInt1, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder.b(), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder.a(), paramInt2, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder.d(), a(), localAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder.a());
  }
  
  public AbsBaseArticleInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (AbsBaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
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
    if ((paramInt >= 0) && (paramInt < a().size())) {
      return a(paramInt);
    }
    return null;
  }
  
  public List<AbsBaseArticleInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    a().clear();
  }
  
  public void a(int paramInt, ArrayList<AbsBaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a().removeAll(paramArrayList);
      a().e(true);
      a().a().notifyDataSetChanged();
    }
    int i = paramArrayList.size();
    int j = 0;
    AbsBaseArticleInfo localAbsBaseArticleInfo;
    if (i > 0) {
      localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramArrayList.get(0);
    } else {
      localAbsBaseArticleInfo = null;
    }
    i = 2131699885;
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo)) {
      i = 2131699886;
    }
    if ((a().a() instanceof BaseActivity)) {
      QQToast.a(a().a(), -1, a().a().getString(i), 0).b(((BaseActivity)a().a()).getTitleBarHeight());
    } else if ((a().a() instanceof PluginBaseActivity)) {
      QQToast.a(a().a(), -1, a().a().getString(i), 0).b(((PluginBaseActivity)a().a()).g());
    }
    a().a().a(paramInt, paramArrayList, paramArrayList1);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(localAbsBaseArticleInfo))
    {
      long l2 = 0L;
      long l1 = l2;
      if (paramObject != null)
      {
        l1 = l2;
        if ((paramObject instanceof DislikeInfo)) {
          l1 = ((DislikeInfo)paramObject).a;
        }
      }
      if ((localAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        paramArrayList = (AdvertisementInfo)localAbsBaseArticleInfo;
      } else {
        paramArrayList = null;
      }
      ReadInJoyLogicEngine.a().a(a().a(), paramArrayList, l1, paramArrayList1, paramBoolean1);
    }
    try
    {
      paramArrayList = new JSONObject();
      paramArrayList.put("time", System.currentTimeMillis() / 1000L);
      paramArrayList.put("channel_id", a().b());
      paramInt = j;
      if (paramArrayList1 != null) {
        paramInt = paramArrayList1.size();
      }
      paramArrayList.put("tag_num", paramInt);
      paramBoolean1 = a().a() instanceof BaseActivity;
      if (paramBoolean1)
      {
        paramArrayList.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        paramArrayList.put("kandian_mode", RIJAppSetting.a());
        if (localAbsBaseArticleInfo != null)
        {
          paramObject = new StringBuilder();
          paramObject.append("");
          paramObject.append(RIJFeedsType.a(localAbsBaseArticleInfo));
          paramArrayList.put("feeds_type", paramObject.toString());
          paramArrayList.put("rowkey", ReadinjoyReportUtils.a(localAbsBaseArticleInfo));
        }
        paramArrayList = paramArrayList.toString();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007059", "0X8007059", 0, 0, "", "", RIJDislikeManager.a(paramArrayList1), paramArrayList, false);
      }
      else if ((a().a() instanceof PluginBaseActivity))
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
  
  public void a(AdvertisementInfo paramAdvertisementInfo, ReadInJoyXListView paramReadInJoyXListView)
  {
    int j = 0;
    int i = 0;
    Object localObject2;
    for (;;)
    {
      int k = a().size();
      localObject2 = null;
      if (i >= k) {
        break;
      }
      localObject1 = (AbsBaseArticleInfo)a().get(i);
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
        paramAdvertisementInfo = paramReadInJoyXListView.getChildAt(j).getTag(2131380884);
        if (!(paramAdvertisementInfo instanceof IReadInJoyModel))
        {
          paramAdvertisementInfo = localObject2;
          break;
        }
        if (localObject1 == ((IReadInJoyModel)paramAdvertisementInfo).a())
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
        paramReadInJoyXListView = ((ProteusItemView)paramAdvertisementInfo).a();
      }
      paramAdvertisementInfo = new RIJDataManager.1(this, (AbsBaseArticleInfo)localObject1, i);
      localObject1 = (Animation)paramReadInJoyXListView.getTag(2131369613);
      if (localObject1 == null) {
        return;
      }
      ((Animation)localObject1).setAnimationListener(paramAdvertisementInfo);
      paramReadInJoyXListView.startAnimation((Animation)localObject1);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, boolean paramBoolean)
  {
    if ((a() != null) && (a().contains(paramAbsBaseArticleInfo1)))
    {
      int i = a().indexOf(paramAbsBaseArticleInfo1);
      if (paramBoolean) {
        a().remove(i + 1);
      }
      if ((paramAbsBaseArticleInfo2 instanceof BaseArticleInfo)) {
        a().add(i + 1, paramAbsBaseArticleInfo2);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder.a().notifyDataSetChanged();
    }
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    if ((paramList != null) && (this.jdField_a_of_type_JavaUtilList.getClass().isInstance(paramList)) && (paramList.size() > 0))
    {
      c(paramList);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder.e(true);
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder.a().a(System.nanoTime());
    VideoBehaviorsReporter.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder.a(), a());
  }
  
  public void a(List<AbsBaseArticleInfo> paramList, int paramInt)
  {
    a().removeAll(paramList);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder.e(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder.a().notifyDataSetChanged();
    int i = 0;
    while (i < paramList.size())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.get(i);
      if (localAbsBaseArticleInfo != null)
      {
        long l = localAbsBaseArticleInfo.mRecommendSeq;
        if (ReadinjoyFixPosArticleManager.isFixPosArticleSeq(l)) {
          ReadinjoyFixPosArticleManager.getInstant().deleteFixPosArticle(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder.b(), l);
        } else {
          ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder.b(), localAbsBaseArticleInfo);
        }
      }
      i += 1;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager$Builder.b(), paramInt);
  }
  
  public void b()
  {
    QLog.d("RIJDataManager", 1, "invalidAllArticles");
    ProteusSupportUtil.a(a().a(), "default_feeds");
    if (a() != null)
    {
      Iterator localIterator = a().iterator();
      while (localIterator.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator.next();
        if (localAbsBaseArticleInfo != null) {
          localAbsBaseArticleInfo.invalidateProteusTemplateBean();
        }
      }
    }
  }
  
  public void b(List<AbsBaseArticleInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteData: ");
    localStringBuilder.append(paramList);
    QLog.d("RIJDataManager", 2, localStringBuilder.toString());
    EmojiManagerServiceConstant.printStackTraces(8);
    if ((paramList != null) && (a().getClass().isInstance(paramList)) && (paramList.size() > 0)) {
      a().removeAll(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager
 * JD-Core Version:    0.7.0.1
 */