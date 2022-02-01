package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.ad.api.IRIJSurpriseVideoService;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
  ComponentContentUgcOriginalHeader A;
  ComponentTopicItemSingle B;
  List<ComponentTopicItemMulti> C;
  ComponentHeaderRecommend D;
  ComponentHeaderTopicRecommend E;
  ComponentPolymericView F;
  int a;
  Object b;
  ReadInJoyModelImpl c;
  View d;
  Context e;
  IFaceDecoder f;
  ReadInJoyBaseAdapter g;
  boolean h = false;
  ComponentHeaderSpecialTopic i;
  ComponentHeaderFriendRecommend j;
  ComponentAccountSummary k;
  ComponentView l;
  ComponentTitle m;
  ComponentInfo n;
  ComponentContentUgcSource o;
  ComponentComment p;
  ComponentJump q;
  ComponentDivider r;
  ComponentWhiteSpace s;
  ComponentLastRead t;
  FeedItemCell.CellListener u;
  ComponentHeaderNewSocial v;
  ComponentHeaderPolymeric w;
  ComponentSocialOperation x;
  ComponentHeaderPublish y;
  ComponentHeaderUgc z;
  
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
    s();
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ListView localListView = this.g.d();
    int i3 = localListView.getChildCount();
    this.g.Q();
    localArrayList1.add(this.d);
    localArrayList2.add(paramIReadInJoyModel);
    int i2 = 0;
    int i1 = 0;
    while (i1 < i3)
    {
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)localListView.getChildAt(i1).getTag(2131449867);
      View localView = localListView.getChildAt(i1);
      if ((localIReadInJoyModel != null) && (localView != null) && (localIReadInJoyModel != paramIReadInJoyModel) && (paramIReadInJoyModel.k().mGroupId == localIReadInJoyModel.k().mGroupId) && (paramIReadInJoyModel.k().mGroupId != -1L))
      {
        localArrayList1.add(localView);
        localArrayList2.add(localIReadInJoyModel);
      }
      i1 += 1;
    }
    a(localArrayList2, paramInt, paramArrayList, paramObject, true);
    paramIReadInJoyModel = new FeedItemCell.8(this, localArrayList2, paramInt, paramArrayList, paramObject);
    paramInt = i2;
    while (paramInt < localArrayList1.size())
    {
      paramArrayList = (Animation)((View)localArrayList1.get(paramInt)).getTag(2131436721);
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
      a().post(new FeedItemCell.9(this, paramArrayList, paramArrayList1, paramInt, paramObject, paramBoolean));
      return;
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  private void b(ArrayList<IReadInJoyModel> paramArrayList, int paramInt, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean)
  {
    try
    {
      a().post(new FeedItemCell.10(this, paramArrayList, paramArrayList1, paramInt, paramObject, paramBoolean));
      return;
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public View a()
  {
    View localView = this.d;
    if (localView != null) {
      return localView;
    }
    throw new Exception("FeedItemCell convertView is null!");
  }
  
  public FeedItemCell a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public FeedItemCell a(Context paramContext)
  {
    this.e = paramContext;
    return this;
  }
  
  public FeedItemCell a(View paramView)
  {
    this.d = paramView;
    return this;
  }
  
  public FeedItemCell a(IFaceDecoder paramIFaceDecoder)
  {
    this.f = paramIFaceDecoder;
    return this;
  }
  
  public FeedItemCell a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.g = paramReadInJoyBaseAdapter;
    return this;
  }
  
  public FeedItemCell a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.v = new ComponentHeaderNewSocial(this.e);
    this.v.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public FeedItemCell a(ReadInJoyModelImpl paramReadInJoyModelImpl)
  {
    this.c = paramReadInJoyModelImpl;
    return this;
  }
  
  public FeedItemCell a(Object paramObject)
  {
    this.b = paramObject;
    return this;
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    Object localObject = this.j;
    if (localObject != null) {
      ((ComponentHeaderFriendRecommend)localObject).a(paramLong, paramBitmap);
    }
    localObject = this.v;
    if (localObject != null) {
      ((ComponentHeaderNewSocial)localObject).a(paramLong, paramBitmap);
    }
    localObject = this.y;
    if (localObject != null) {
      ((ComponentHeaderPublish)localObject).a(paramLong, paramBitmap);
    }
    localObject = this.z;
    if (localObject != null) {
      ((ComponentHeaderUgc)localObject).a(paramLong, paramBitmap);
    }
    localObject = this.w;
    if (localObject != null) {
      ((ComponentHeaderPolymeric)localObject).a(paramLong, paramBitmap);
    }
  }
  
  public void a(View paramView, Map<String, Object> paramMap) {}
  
  public abstract FeedItemCell b();
  
  public FeedItemCell b(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.w = new ComponentHeaderPolymeric(this.e);
    this.w.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public void b(View paramView)
  {
    boolean bool = ((IReadInJoyModel)this.b).k() instanceof AdvertisementInfo;
    Object localObject1;
    if (RIJFeedsType.f(((IReadInJoyModel)this.b).k())) {
      localObject1 = null;
    } else {
      localObject1 = ((IReadInJoyModel)this.b).k().mDislikeInfos;
    }
    KandianNegativeWindow localKandianNegativeWindow = this.g.B();
    Object localObject2 = this.g.C();
    if (bool)
    {
      if ((localKandianNegativeWindow != null) && (localKandianNegativeWindow.isShowing())) {
        localKandianNegativeWindow.dismiss();
      }
      localObject1 = (AdvertisementInfo)((IReadInJoyModel)this.b).k();
      if (localObject1 == null) {
        return;
      }
      ((KandianNegativeWindowForAd)localObject2).b((ReadInJoyModelImpl)this.b, ((AdvertisementInfo)localObject1).mAdDislikeInfos);
      ((KandianNegativeWindowForAd)localObject2).a(paramView, new FeedItemCell.2(this));
      ((KandianNegativeWindowForAd)localObject2).a(new FeedItemCell.3(this));
      ((KandianNegativeWindowForAd)localObject2).a(new FeedItemCell.4(this));
      ((IRIJSurpriseVideoService)QRoute.api(IRIJSurpriseVideoService.class)).handleDislikeWindowShow();
      ((KandianNegativeWindowForAd)localObject2).setOnDismissListener(new FeedItemCell.5(this, (KandianNegativeWindowForAd)localObject2));
    }
    else if (ReadinjoyReportUtils.d(this.g.c()))
    {
      this.g.D().a(paramView, ((IReadInJoyModel)this.b).k(), ((ReadInJoyModelImpl)this.b).b, this.d);
    }
    else
    {
      if ((localObject2 != null) && (((KandianNegativeWindowForAd)localObject2).isShowing())) {
        ((KandianNegativeWindowForAd)localObject2).dismiss();
      }
      localKandianNegativeWindow.a((ReadInJoyModelImpl)this.b, (ArrayList)localObject1);
      localKandianNegativeWindow.a(paramView, new FeedItemCell.6(this));
      localKandianNegativeWindow.setOnDismissListener(new FeedItemCell.7(this, localKandianNegativeWindow));
    }
    paramView = this.g.R();
    if ((paramView != null) && (paramView.g()))
    {
      paramView.c();
      this.g.b(true);
    }
    try
    {
      paramView = new JSONObject();
      paramView.put("time", System.currentTimeMillis() / 1000L);
      paramView.put("channel_id", ((ReadInJoyModelImpl)this.b).m());
      localObject1 = ((IReadInJoyModel)this.b).k();
      bool = this.e instanceof BaseActivity;
      if (bool)
      {
        paramView.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        paramView.put("kandian_mode", RIJAppSetting.b());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(RIJFeedsType.g((AbsBaseArticleInfo)localObject1));
        paramView.put("feeds_type", ((StringBuilder)localObject2).toString());
        paramView.put("rowkey", ReadinjoyReportUtils.c((AbsBaseArticleInfo)localObject1));
        PublicAccountReportUtils.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", paramView.toString(), false);
        return;
      }
      if ((this.e instanceof PluginBaseActivity))
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
  
  FeedItemCell c()
  {
    return i().j().k().m().n().p();
  }
  
  public FeedItemCell c(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.y = new ComponentHeaderPublish(this.e);
    this.y.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  FeedItemCell d()
  {
    return i().n().p();
  }
  
  public FeedItemCell d(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.z = new ComponentHeaderUgc(this.e);
    this.z.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public abstract FeedItemCell e();
  
  public FeedItemCell e(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.D = new ComponentHeaderRecommend(this.e);
    this.D.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public abstract FeedItemCell f();
  
  public FeedItemCell f(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.E = new ComponentHeaderTopicRecommend(this.e);
    this.E.setLogic(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    return this;
  }
  
  public FeedItemCell g()
  {
    this.k = new ComponentAccountSummary(this.e);
    return this;
  }
  
  public ComponentView h()
  {
    return this.l;
  }
  
  public FeedItemCell i()
  {
    return this;
  }
  
  public FeedItemCell j()
  {
    this.m = new ComponentTitle(this.e, this.b);
    return this;
  }
  
  public FeedItemCell k()
  {
    this.n = new ComponentInfo(this.e, this.b);
    return this;
  }
  
  public FeedItemCell l()
  {
    this.o = new ComponentContentUgcSource(this.e);
    return this;
  }
  
  public FeedItemCell m()
  {
    this.q = new ComponentJump(this.e);
    return this;
  }
  
  public FeedItemCell n()
  {
    this.r = new ComponentDivider(this.e, this.b);
    return this;
  }
  
  public FeedItemCell o()
  {
    this.s = new ComponentWhiteSpace(this.e, this.b);
    return this;
  }
  
  public FeedItemCell p()
  {
    this.t = new ComponentLastRead(this.e);
    return this;
  }
  
  public FeedItemCell q()
  {
    Object localObject = this.i;
    if (localObject != null) {
      ((ComponentHeaderSpecialTopic)localObject).a(this.b);
    }
    localObject = this.j;
    if (localObject != null) {
      ((ComponentHeaderFriendRecommend)localObject).a(this.b);
    }
    localObject = this.o;
    if (localObject != null) {
      ((ComponentContentUgcSource)localObject).a(this.b);
    }
    localObject = this.m;
    if (localObject != null) {
      ((ComponentTitle)localObject).a(this.b);
    }
    try
    {
      if ((this.b instanceof IReadInJoyModel))
      {
        localObject = (IReadInJoyModel)this.b;
        this.m.setReadedStatus(this.g.b(((IReadInJoyModel)localObject).m(), ((IReadInJoyModel)localObject).k().mArticleID));
      }
    }
    catch (Exception localException2)
    {
      label118:
      break label118;
    }
    localObject = this.k;
    if (localObject != null) {
      ((ComponentAccountSummary)localObject).a(this.b);
    }
    localObject = this.l;
    if (localObject != null) {
      ((ComponentView)localObject).a(this.b);
    }
    localObject = this.n;
    if (localObject != null) {
      ((ComponentInfo)localObject).a(this.b);
    }
    localObject = this.p;
    if (localObject != null) {
      ((ComponentComment)localObject).a(this.b);
    }
    localObject = this.q;
    if (localObject != null) {
      ((ComponentJump)localObject).a(this.b);
    }
    localObject = this.r;
    if (localObject != null) {
      ((ComponentDivider)localObject).a(this.b);
    }
    localObject = this.t;
    if (localObject != null) {
      ((ComponentLastRead)localObject).a(this.b);
    }
    localObject = this.s;
    if (localObject != null) {
      ((ComponentWhiteSpace)localObject).a(this.b);
    }
    try
    {
      f();
      return this;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      return this;
    }
  }
  
  public FeedItemCell r()
  {
    Object localObject = this.u;
    if (localObject == null) {
      return this;
    }
    ComponentHeaderTopicRecommend localComponentHeaderTopicRecommend = this.E;
    if (localComponentHeaderTopicRecommend != null) {
      localComponentHeaderTopicRecommend.a((FeedItemCell.CellListener)localObject);
    }
    localObject = this.i;
    if (localObject != null) {
      ((ComponentHeaderSpecialTopic)localObject).a(this.u);
    }
    localObject = this.j;
    if (localObject != null) {
      ((ComponentHeaderFriendRecommend)localObject).a(this.u);
    }
    localObject = this.y;
    if (localObject != null) {
      ((ComponentHeaderPublish)localObject).a(this.u);
    }
    localObject = this.m;
    if (localObject != null) {
      ((ComponentTitle)localObject).a(this.u);
    }
    localObject = this.k;
    if (localObject != null) {
      ((ComponentAccountSummary)localObject).a(this.u);
    }
    localObject = this.l;
    if (localObject != null) {
      ((ComponentView)localObject).a(this.u);
    }
    localObject = this.n;
    if (localObject != null) {
      ((ComponentInfo)localObject).a(this.u);
    }
    localObject = this.p;
    if (localObject != null) {
      ((ComponentComment)localObject).a(this.u);
    }
    localObject = this.o;
    if (localObject != null) {
      ((ComponentContentUgcSource)localObject).a(this.u);
    }
    localObject = this.q;
    if (localObject != null) {
      ((ComponentJump)localObject).a(this.u);
    }
    localObject = this.r;
    if (localObject != null) {
      ((ComponentDivider)localObject).a(this.u);
    }
    localObject = this.t;
    if (localObject != null) {
      ((ComponentLastRead)localObject).a(this.u);
    }
    localObject = this.s;
    if (localObject != null) {
      ((ComponentWhiteSpace)localObject).a(this.u);
    }
    return this;
  }
  
  public void s()
  {
    this.u = new FeedItemCell.1(this);
  }
  
  public FeedItemCell t()
  {
    this.x = new ComponentSocialOperation(this.e);
    return this;
  }
  
  public FeedItemCell u()
  {
    this.A = new ComponentContentUgcOriginalHeader(this.e);
    return this;
  }
  
  public FeedItemCell v()
  {
    this.B = new ComponentTopicItemSingle(this.e);
    return this;
  }
  
  public FeedItemCell w()
  {
    this.C = new ArrayList();
    this.C.add(new ComponentTopicItemMulti(this.e));
    this.C.add(new ComponentTopicItemMulti(this.e));
    return this;
  }
  
  public FeedItemCell x()
  {
    this.F = new ComponentPolymericView(this.e);
    return this;
  }
  
  public void y() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell
 * JD-Core Version:    0.7.0.1
 */