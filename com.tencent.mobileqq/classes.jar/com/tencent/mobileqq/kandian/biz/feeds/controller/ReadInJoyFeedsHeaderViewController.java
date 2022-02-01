package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.LooperGifImage;
import com.tencent.biz.pubaccount.util.api.IPublicAccountGifPlayTimeHttpDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyCapsuleView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfProcessor;
import com.tencent.mobileqq.kandian.biz.framework.RIJWebSearchUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyFeedsHeaderViewController
  extends HeaderViewController
  implements View.OnClickListener
{
  protected static int a;
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#F1F3F6"));
  private static int jdField_b_of_type_Int = Color.parseColor("#47000000");
  protected BroadcastReceiver a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LooperGifImage jdField_a_of_type_ComTencentBizPubaccountLooperGifImage;
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new ReadInJoyFeedsHeaderViewController.6(this);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  protected UniteSearchHandler a;
  protected UniteSearchObserver a;
  private ReadInJoyCapsuleView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView;
  private ReadInJoyFeedsHeaderViewController.CapsuleViewStateController jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyFeedsHeaderViewController.1(this);
  HotWordSearchEntryDataModel jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel;
  protected String a;
  protected boolean a;
  private ReadInJoyCapsuleView jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView;
  private ReadInJoyFeedsHeaderViewController.CapsuleViewStateController jdField_b_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController;
  protected boolean b;
  private ReadInJoyCapsuleView jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView;
  private ReadInJoyFeedsHeaderViewController.CapsuleViewStateController jdField_c_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public ReadInJoyFeedsHeaderViewController(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new ReadInJoyFeedsHeaderViewController.2(this);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ReadInJoyFeedsHeaderViewController.4(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560200, null);
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131378638);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView = ((ReadInJoyCapsuleView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364283));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController = new ReadInJoyFeedsHeaderViewController.CapsuleViewStateController(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView);
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView = ((ReadInJoyCapsuleView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364282));
    this.jdField_b_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController = new ReadInJoyFeedsHeaderViewController.CapsuleViewStateController(this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView);
    this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView = ((ReadInJoyCapsuleView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364281));
    this.jdField_c_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController = new ReadInJoyFeedsHeaderViewController.CapsuleViewStateController(this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369386));
    a(a(ReadInJoyLogicEngine.a().a(0)));
    ((View)localObject).setOnClickListener(this);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
    g();
    localObject = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
    paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
  }
  
  private URLDrawable a(ChannelCoverInfo paramChannelCoverInfo, boolean paramBoolean)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = paramBoolean;
    paramChannelCoverInfo = ((IPublicAccountGifPlayTimeHttpDownloader)QRoute.api(IPublicAccountGifPlayTimeHttpDownloader.class)).getPubURL(paramChannelCoverInfo.externalExposureBackgroundUrl);
    if (paramChannelCoverInfo == null) {
      return null;
    }
    paramChannelCoverInfo = URLDrawable.getDrawable(paramChannelCoverInfo, (URLDrawable.URLDrawableOptions)localObject);
    if ((paramChannelCoverInfo.getCurrDrawable() instanceof GifDrawable))
    {
      localObject = ((GifDrawable)paramChannelCoverInfo.getCurrDrawable()).getImage();
      paramChannelCoverInfo.setIndividualPause(paramBoolean ^ true);
      ((AbstractGifImage)localObject).reset();
    }
    return paramChannelCoverInfo;
  }
  
  private static <T> Iterable<T> a(Iterable<T> paramIterable)
  {
    Object localObject = paramIterable;
    if (paramIterable == null) {
      localObject = Collections.emptyList();
    }
    return localObject;
  }
  
  private List<ChannelCoverInfo> a(List<ChannelCoverInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a(paramList).iterator();
    while (localIterator.hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
      if ((localChannelCoverInfo.isExternalExposure) && (((RIJShowKanDianTabSp.c()) && (!ReadInJoyHelper.l())) || (localChannelCoverInfo.mChannelCoverId != 56)))
      {
        paramList = localChannelCoverInfo.externalExposureBackgroundUrl;
        if ((!TextUtils.isEmpty(paramList)) && (!TextUtils.equals(ReadInJoyHelper.e(localChannelCoverInfo.mChannelCoverId), paramList)))
        {
          if (localChannelCoverInfo.isExternalExposurePersist) {
            paramList = "";
          }
          ReadInJoyHelper.a(paramList, localChannelCoverInfo.mChannelCoverId);
          ReadInJoyHelper.a(localChannelCoverInfo.mChannelCoverId, false);
        }
        localArrayList.add(localChannelCoverInfo);
      }
    }
    return localArrayList;
  }
  
  private void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    URLDrawable localURLDrawable = a(paramChannelCoverInfo, true);
    if (localURLDrawable == null) {
      return;
    }
    if (localURLDrawable.getStatus() == 1)
    {
      if ((localURLDrawable.getCurrDrawable() instanceof GifDrawable))
      {
        AbstractGifImage localAbstractGifImage = ((GifDrawable)localURLDrawable.getCurrDrawable()).getImage();
        if ((localAbstractGifImage instanceof LooperGifImage))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountLooperGifImage = ((LooperGifImage)localAbstractGifImage);
          this.jdField_a_of_type_ComTencentBizPubaccountLooperGifImage.a(new ReadInJoyFeedsHeaderViewController.5(this, paramChannelCoverInfo));
        }
      }
      this.jdField_a_of_type_ComTencentImageURLDrawableDownListener.onLoadSuccessed(this.jdField_a_of_type_ComTencentImageURLImageView, localURLDrawable);
    }
    else
    {
      localURLDrawable.startDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
    this.jdField_a_of_type_ComTencentImageURLImageView.setTag(paramChannelCoverInfo);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("is_pic", i);
      a(paramString, localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      label38:
      break label38;
    }
    throw new IllegalArgumentException("fail to construct json object");
  }
  
  private void a(List<ChannelCoverInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView.setVisibility(8);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
      int i = localChannelCoverInfo.mChannelCoverId;
      ReadInJoyCapsuleView localReadInJoyCapsuleView = null;
      if (i == 56)
      {
        localReadInJoyCapsuleView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView;
        paramList = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController;
      }
      else if (localChannelCoverInfo.mChannelCoverId == 1000000)
      {
        localReadInJoyCapsuleView = this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView;
        paramList = this.jdField_b_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController;
      }
      else if (localChannelCoverInfo.mChannelCoverId == 2000000)
      {
        a(localChannelCoverInfo);
        paramList = null;
      }
      else
      {
        localReadInJoyCapsuleView = this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetReadInJoyCapsuleView;
        paramList = this.jdField_c_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController;
      }
      if (localReadInJoyCapsuleView != null)
      {
        localReadInJoyCapsuleView.setVisibility(0);
        localReadInJoyCapsuleView.setText(localChannelCoverInfo.mChannelCoverName);
        paramList.a(localChannelCoverInfo, this);
      }
    }
  }
  
  private static int b(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramInt != 56)
      {
        if (paramInt != 1000000) {
          return 0;
        }
        return 2130843023;
      }
      return 2130843026;
    }
    if (paramInt != 56)
    {
      if (paramInt != 1000000) {
        return 0;
      }
      return 2130843022;
    }
    return 2130843025;
  }
  
  public void a()
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "reportExposure");
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a() != null) {
      a("0X8008B88", this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a());
    }
    if (this.jdField_b_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a() != null) {
      a("0X8008B89", this.jdField_b_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a());
    }
  }
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController.b();
    this.jdField_b_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController.b();
    this.jdField_c_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController.b();
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_Boolean = true;
    LooperGifImage localLooperGifImage = this.jdField_a_of_type_ComTencentBizPubaccountLooperGifImage;
    if (localLooperGifImage != null) {
      localLooperGifImage.a();
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = false;
    } else {
      f();
    }
    AbstractGifImage.resumeAll();
  }
  
  public void d() {}
  
  protected void f()
  {
    HotWordSearchEntryDataModel localHotWordSearchEntryDataModel = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel;
    if ((localHotWordSearchEntryDataModel != null) && (localHotWordSearchEntryDataModel.a != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.size() == 0) {
        return;
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.size();
      this.jdField_a_of_type_JavaLangString = ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.get(jdField_a_of_type_Int % i)).title;
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378638)).setText(this.jdField_a_of_type_JavaLangString);
      jdField_a_of_type_Int += 1;
    }
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!TextUtils.isEmpty(((IReadInJoySearchJumpUrlConfProcessor)QRoute.api(IReadInJoySearchJumpUrlConfProcessor.class)).getConfig().a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(localQQAppInterface, 1, 6, false);
      ThreadManager.post(new ReadInJoyFeedsHeaderViewController.3(this, localQQAppInterface), 5, null, true);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1 = null;
    switch (i)
    {
    default: 
      return;
    case 2131378638: 
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel;
      paramView = (View)localObject1;
      if (localObject2 != null)
      {
        paramView = (View)localObject1;
        if (((HotWordSearchEntryDataModel)localObject2).a != null)
        {
          paramView = (View)localObject1;
          if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.size() > 0)
          {
            paramView = (View)localObject1;
            if (jdField_a_of_type_Int > 0)
            {
              i = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.size();
              paramView = (HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.get((jdField_a_of_type_Int - 1) % i);
            }
          }
        }
      }
      RIJWebSearchUtils.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView);
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("active_search").ver1(this.jdField_a_of_type_JavaLangString);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("{experiment_id:");
      ((StringBuilder)localObject2).append(UniteSearchReportController.b);
      ((StringBuilder)localObject2).append("}");
      UniteSearchReportController.a(paramView, ((ReportModelDC02528)localObject1).ver7(((StringBuilder)localObject2).toString()));
      return;
    case 2131369386: 
      localObject1 = (ChannelCoverInfo)paramView.getTag();
      ReadInJoyUtils.a(paramView.getContext(), ((ChannelCoverInfo)localObject1).mChannelJumpUrl);
      a("0X800920D", new JSONObject());
      return;
    case 2131364283: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a();
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("param_key_ariticle_id", Long.valueOf(paramView.mArticleId));
      ((HashMap)localObject1).put("param_key_channel_cover_style", Integer.valueOf(paramView.mChannelCoverStyle));
      ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchChannelActivity(this.jdField_a_of_type_AndroidContentContext, paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, 4, (Map)localObject1);
      a("0X8008B84", this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a());
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a();
    ViolaAccessHelper.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131712958), "https://kandian.qq.com/viola/bundle_hotTopic.js?v_bid=3256&statusColor=1", null);
    a("0X8008B85", this.jdField_b_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyFeedsHeaderViewController$CapsuleViewStateController.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyFeedsHeaderViewController
 * JD-Core Version:    0.7.0.1
 */