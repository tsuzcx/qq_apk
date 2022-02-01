package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyFeedbackPopupWindow;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.KandianNegativeWindow;
import com.tencent.widget.KandianNegativeWindowForAd;
import com.tencent.widget.ListView;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class FeedItemCell
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  ReadInJoyModelImpl jdField_a_of_type_ComTencentMobileqqKandianBizPtsReadInJoyModelImpl;
  ComponentAccountSummary jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentAccountSummary;
  ComponentComment jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentComment;
  ComponentContentUgcOriginalHeader jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcOriginalHeader;
  ComponentContentUgcSource jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource;
  ComponentDivider jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider;
  ComponentHeaderFriendRecommend jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderFriendRecommend;
  ComponentHeaderNewSocial jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial;
  ComponentHeaderPolymeric jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric;
  ComponentHeaderPublish jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPublish;
  ComponentHeaderRecommend jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderRecommend;
  ComponentHeaderSpecialTopic jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderSpecialTopic;
  ComponentHeaderTopicRecommend jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderTopicRecommend;
  ComponentHeaderUgc jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc;
  ComponentInfo jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentInfo;
  ComponentJump jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentJump;
  ComponentLastRead jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead;
  ComponentPolymericView jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView;
  ComponentSocialOperation jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation;
  ComponentTitle jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle;
  ComponentTopicItemSingle jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTopicItemSingle;
  ComponentView jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView;
  ComponentWhiteSpace jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentWhiteSpace;
  FeedItemCell.CellListener jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener;
  Object jdField_a_of_type_JavaLangObject;
  List<ComponentTopicItemMulti> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  
  public FeedItemCell(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FeedItemCell created, class = ");
      localStringBuilder.append(getClass().getSimpleName());
      QLog.d("FeedItemCell", 2, localStringBuilder.toString());
    }
    a(paramContext);
    a(paramIFaceDecoder);
    a(paramReadInJoyBaseAdapter);
    a();
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ListView localListView = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a();
    int k = localListView.getChildCount();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.h();
    localArrayList1.add(this.jdField_a_of_type_AndroidViewView);
    localArrayList2.add(paramIReadInJoyModel);
    int j = 0;
    int i = 0;
    while (i < k)
    {
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)localListView.getChildAt(i).getTag(2131380884);
      View localView = localListView.getChildAt(i);
      if ((localIReadInJoyModel != null) && (localView != null) && (localIReadInJoyModel != paramIReadInJoyModel) && (paramIReadInJoyModel.a().mGroupId == localIReadInJoyModel.a().mGroupId) && (paramIReadInJoyModel.a().mGroupId != -1L))
      {
        localArrayList1.add(localView);
        localArrayList2.add(localIReadInJoyModel);
      }
      i += 1;
    }
    paramIReadInJoyModel = new FeedItemCell.7(this, localArrayList2, paramInt, paramArrayList, paramObject);
    paramInt = j;
    while (paramInt < localArrayList1.size())
    {
      paramArrayList = (Animation)((View)localArrayList1.get(paramInt)).getTag(2131369613);
      if (paramArrayList != null)
      {
        if (paramInt != 0) {
          paramArrayList.setAnimationListener(null);
        } else {
          paramArrayList.setAnimationListener(paramIReadInJoyModel);
        }
        ((View)localArrayList1.get(paramInt)).startAnimation(paramArrayList);
        paramArrayList.startNow();
      }
      paramInt += 1;
    }
  }
  
  private void a(ArrayList<IReadInJoyModel> paramArrayList, int paramInt, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean)
  {
    try
    {
      a().post(new FeedItemCell.8(this, paramArrayList, paramArrayList1, paramInt, paramObject, paramBoolean));
      return;
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public View a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      return localView;
    }
    throw new Exception("FeedItemCell convertView is null!");
  }
  
  public ComponentView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView;
  }
  
  public abstract FeedItemCell a();
  
  public FeedItemCell a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public FeedItemCell a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public FeedItemCell a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    return this;
  }
  
  public FeedItemCell a(IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    return this;
  }
  
  public FeedItemCell a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    return this;
  }
  
  public FeedItemCell a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial = new ComponentHeaderNewSocial(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public FeedItemCell a(ReadInJoyModelImpl paramReadInJoyModelImpl)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsReadInJoyModelImpl = paramReadInJoyModelImpl;
    return this;
  }
  
  public FeedItemCell a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    return this;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener = new FeedItemCell.1(this);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderFriendRecommend;
    if (localObject != null) {
      ((ComponentHeaderFriendRecommend)localObject).a(paramLong, paramBitmap);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial;
    if (localObject != null) {
      ((ComponentHeaderNewSocial)localObject).a(paramLong, paramBitmap);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPublish;
    if (localObject != null) {
      ((ComponentHeaderPublish)localObject).a(paramLong, paramBitmap);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc;
    if (localObject != null) {
      ((ComponentHeaderUgc)localObject).a(paramLong, paramBitmap);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric;
    if (localObject != null) {
      ((ComponentHeaderPolymeric)localObject).a(paramLong, paramBitmap);
    }
  }
  
  public void a(View paramView)
  {
    boolean bool = ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a() instanceof AdvertisementInfo;
    Object localObject1;
    if (RIJFeedsType.f(((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a())) {
      localObject1 = null;
    } else {
      localObject1 = ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a().mDislikeInfos;
    }
    KandianNegativeWindow localKandianNegativeWindow = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a();
    if (bool)
    {
      if ((localKandianNegativeWindow != null) && (localKandianNegativeWindow.isShowing())) {
        localKandianNegativeWindow.dismiss();
      }
      localObject1 = (AdvertisementInfo)((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a();
      if (localObject1 == null) {
        return;
      }
      ((KandianNegativeWindowForAd)localObject2).b((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject, ((AdvertisementInfo)localObject1).mAdDislikeInfos);
      ((KandianNegativeWindowForAd)localObject2).a(paramView, new FeedItemCell.2(this));
      ((KandianNegativeWindowForAd)localObject2).a(new FeedItemCell.3(this));
      ((KandianNegativeWindowForAd)localObject2).setOnDismissListener(new FeedItemCell.4(this, (KandianNegativeWindowForAd)localObject2));
    }
    else if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a().a(paramView, ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a(), ((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).b, this.jdField_a_of_type_AndroidViewView);
    }
    else
    {
      if ((localObject2 != null) && (((KandianNegativeWindowForAd)localObject2).isShowing())) {
        ((KandianNegativeWindowForAd)localObject2).dismiss();
      }
      localKandianNegativeWindow.a((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject, (ArrayList)localObject1);
      localKandianNegativeWindow.a(paramView, new FeedItemCell.5(this));
      localKandianNegativeWindow.setOnDismissListener(new FeedItemCell.6(this, localKandianNegativeWindow));
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a();
    if ((paramView != null) && (paramView.a()))
    {
      paramView.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.b(true);
    }
    try
    {
      paramView = new JSONObject();
      paramView.put("time", System.currentTimeMillis() / 1000L);
      paramView.put("channel_id", ((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).c());
      localObject1 = ((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a();
      bool = this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity;
      if (bool)
      {
        paramView.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        paramView.put("kandian_mode", RIJAppSetting.a());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(RIJFeedsType.a((AbsBaseArticleInfo)localObject1));
        paramView.put("feeds_type", ((StringBuilder)localObject2).toString());
        paramView.put("rowkey", ReadinjoyReportUtils.a((AbsBaseArticleInfo)localObject1));
        paramView = paramView.toString();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", paramView, false);
        return;
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof PluginBaseActivity))
      {
        paramView.put("folder_status", 1);
        ReportController.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", paramView.toString());
        return;
      }
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void a(View paramView, Map<String, Object> paramMap) {}
  
  FeedItemCell b()
  {
    return g().h().i().k().l().n();
  }
  
  public FeedItemCell b(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric = new ComponentHeaderPolymeric(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public void b() {}
  
  FeedItemCell c()
  {
    return g().l().n();
  }
  
  public FeedItemCell c(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPublish = new ComponentHeaderPublish(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPublish.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public abstract FeedItemCell d();
  
  public FeedItemCell d(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc = new ComponentHeaderUgc(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public abstract FeedItemCell e();
  
  public FeedItemCell e(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderRecommend = new ComponentHeaderRecommend(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderRecommend.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public FeedItemCell f()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentAccountSummary = new ComponentAccountSummary(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell f(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderTopicRecommend = new ComponentHeaderTopicRecommend(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderTopicRecommend.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public FeedItemCell g()
  {
    return this;
  }
  
  public FeedItemCell h()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle = new ComponentTitle(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public FeedItemCell i()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentInfo = new ComponentInfo(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public FeedItemCell j()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource = new ComponentContentUgcSource(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell k()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentJump = new ComponentJump(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell l()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider = new ComponentDivider(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public FeedItemCell m()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentWhiteSpace = new ComponentWhiteSpace(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangObject);
    return this;
  }
  
  public FeedItemCell n()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead = new ComponentLastRead(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell o()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderSpecialTopic;
    if (localObject != null) {
      ((ComponentHeaderSpecialTopic)localObject).a(this.jdField_a_of_type_JavaLangObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderFriendRecommend;
    if (localObject != null) {
      ((ComponentHeaderFriendRecommend)localObject).a(this.jdField_a_of_type_JavaLangObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource;
    if (localObject != null) {
      ((ComponentContentUgcSource)localObject).a(this.jdField_a_of_type_JavaLangObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle;
    if (localObject != null) {
      ((ComponentTitle)localObject).a(this.jdField_a_of_type_JavaLangObject);
    }
    try
    {
      if ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel))
      {
        localObject = (IReadInJoyModel)this.jdField_a_of_type_JavaLangObject;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.setReadedStatus(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(((IReadInJoyModel)localObject).c(), ((IReadInJoyModel)localObject).a().mArticleID));
      }
    }
    catch (Exception localException2)
    {
      label118:
      break label118;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentAccountSummary;
    if (localObject != null) {
      ((ComponentAccountSummary)localObject).a(this.jdField_a_of_type_JavaLangObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView;
    if (localObject != null) {
      ((ComponentView)localObject).a(this.jdField_a_of_type_JavaLangObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentInfo;
    if (localObject != null) {
      ((ComponentInfo)localObject).a(this.jdField_a_of_type_JavaLangObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentComment;
    if (localObject != null) {
      ((ComponentComment)localObject).a(this.jdField_a_of_type_JavaLangObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentJump;
    if (localObject != null) {
      ((ComponentJump)localObject).a(this.jdField_a_of_type_JavaLangObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider;
    if (localObject != null) {
      ((ComponentDivider)localObject).a(this.jdField_a_of_type_JavaLangObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead;
    if (localObject != null) {
      ((ComponentLastRead)localObject).a(this.jdField_a_of_type_JavaLangObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentWhiteSpace;
    if (localObject != null) {
      ((ComponentWhiteSpace)localObject).a(this.jdField_a_of_type_JavaLangObject);
    }
    try
    {
      e();
      return this;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      return this;
    }
  }
  
  public FeedItemCell p()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener;
    if (localObject == null) {
      return this;
    }
    ComponentHeaderTopicRecommend localComponentHeaderTopicRecommend = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderTopicRecommend;
    if (localComponentHeaderTopicRecommend != null) {
      localComponentHeaderTopicRecommend.a((FeedItemCell.CellListener)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderSpecialTopic;
    if (localObject != null) {
      ((ComponentHeaderSpecialTopic)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderFriendRecommend;
    if (localObject != null) {
      ((ComponentHeaderFriendRecommend)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPublish;
    if (localObject != null) {
      ((ComponentHeaderPublish)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle;
    if (localObject != null) {
      ((ComponentTitle)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentAccountSummary;
    if (localObject != null) {
      ((ComponentAccountSummary)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView;
    if (localObject != null) {
      ((ComponentView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentInfo;
    if (localObject != null) {
      ((ComponentInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentComment;
    if (localObject != null) {
      ((ComponentComment)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource;
    if (localObject != null) {
      ((ComponentContentUgcSource)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentJump;
    if (localObject != null) {
      ((ComponentJump)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider;
    if (localObject != null) {
      ((ComponentDivider)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead;
    if (localObject != null) {
      ((ComponentLastRead)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentWhiteSpace;
    if (localObject != null) {
      ((ComponentWhiteSpace)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    return this;
  }
  
  public FeedItemCell q()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation = new ComponentSocialOperation(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell r()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcOriginalHeader = new ComponentContentUgcOriginalHeader(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell s()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTopicItemSingle = new ComponentTopicItemSingle(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell t()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new ComponentTopicItemMulti(this.jdField_a_of_type_AndroidContentContext));
    this.jdField_a_of_type_JavaUtilList.add(new ComponentTopicItemMulti(this.jdField_a_of_type_AndroidContentContext));
    return this;
  }
  
  public FeedItemCell u()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView = new ComponentPolymericView(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell
 * JD-Core Version:    0.7.0.1
 */