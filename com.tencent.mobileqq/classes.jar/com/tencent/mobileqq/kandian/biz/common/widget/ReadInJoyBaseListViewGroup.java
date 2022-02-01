package com.tencent.mobileqq.kandian.biz.common.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.base.view.widget.KandianProgressView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianProgressView.ClickCallBack;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyPageItemCache;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.ugc.KanDianVideoUploadUtils;
import com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadService;
import com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadService.ICallBack;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ReadInJoyBaseListViewGroup
  extends FrameLayout
{
  protected int a;
  KandianProgressView.ClickCallBack jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianProgressView$ClickCallBack = new ReadInJoyBaseListViewGroup.2(this);
  protected ReadInJoyPageItemCache a;
  protected ReadInJoyXListView a;
  protected ReadInJoyBaseViewController a;
  KandianVideoUploadService.ICallBack jdField_a_of_type_ComTencentMobileqqKandianBizUgcKandianVideoUploadService$ICallBack = new ReadInJoyBaseListViewGroup.1(this);
  List<KandianProgressView> jdField_a_of_type_JavaUtilList = new ArrayList();
  Map<String, KandianProgressView> jdField_a_of_type_JavaUtilMap = new HashMap();
  protected boolean a;
  
  public ReadInJoyBaseListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    super(paramReadInJoyBaseViewController.a());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController = paramReadInJoyBaseViewController;
    if (paramReadInJoyPageItemCache == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache = new ReadInJoyPageItemCache();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.a = ReadInJoyHelper.a(paramInt, (QQAppInterface)ReadInJoyUtils.a());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache = paramReadInJoyPageItemCache;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.b = 1;
  }
  
  private void a()
  {
    Iterator localIterator = KanDianVideoUploadUtils.a().iterator();
    while (localIterator.hasNext())
    {
      Intent localIntent = (Intent)localIterator.next();
      String str = localIntent.getStringExtra("mTaskID");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("is loading fail view:");
      localStringBuilder.append(str);
      localStringBuilder.append("map size");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilMap.size());
      QLog.d("KandianVideoUpload", 1, localStringBuilder.toString());
      if (this.jdField_a_of_type_JavaUtilMap.get(str) == null) {
        KandianVideoUploadService.a(localIntent.getExtras(), this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcKandianVideoUploadService$ICallBack);
      }
    }
  }
  
  private void a(Bundle paramBundle, String paramString)
  {
    String str1 = paramBundle.getString("mTaskID");
    String str2 = paramBundle.getString("arg_video_cover");
    Object localObject = (View)this.jdField_a_of_type_JavaUtilMap.get(str1);
    if (localObject == null)
    {
      if (this.jdField_a_of_type_JavaUtilMap.size() < 2)
      {
        if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
        {
          localObject = (KandianProgressView)this.jdField_a_of_type_JavaUtilList.get(0);
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
        else
        {
          localObject = new KandianProgressView(a(), paramBundle, str1, str2, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianProgressView$ClickCallBack);
        }
        ((KandianProgressView)localObject).setTag(paramString);
        ((KandianProgressView)localObject).setViewInformation(paramBundle, str1, str2);
        a((View)localObject);
        this.jdField_a_of_type_JavaUtilMap.put(str1, localObject);
      }
    }
    else {
      ((View)localObject).setTag(paramString);
    }
  }
  
  private void a(View paramView)
  {
    ReadInJoyXListView localReadInJoyXListView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView;
    if (localReadInJoyXListView != null) {
      localReadInJoyXListView.addHeaderView(paramView);
    }
  }
  
  private void a(String paramString)
  {
    KandianProgressView localKandianProgressView = (KandianProgressView)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localKandianProgressView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.removeHeaderView(localKandianProgressView);
      this.jdField_a_of_type_JavaUtilList.add(localKandianProgressView);
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController.a();
  }
  
  public RIJDataFetchManager a()
  {
    return null;
  }
  
  public ReadInJoyBaseViewController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController;
  }
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Map<Integer, Boolean> paramMap);
  
  public abstract void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean);
  
  public abstract void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap);
  
  public abstract void a(boolean paramBoolean);
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b() {}
  
  public abstract void b(Map<Integer, Boolean> paramMap);
  
  public void c() {}
  
  public void c(Map<Integer, BaseReportData> paramMap) {}
  
  public void d() {}
  
  public void e() {}
  
  public abstract void f();
  
  public void g()
  {
    a();
    KandianVideoUploadService.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcKandianVideoUploadService$ICallBack);
  }
  
  public void h()
  {
    KandianVideoUploadService.a(null);
  }
  
  public void i()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).isChannelRefreshing(this.jdField_a_of_type_Int, true);
      PublicTracker.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE");
      ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Int, 20, 9223372036854775807L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup
 * JD-Core Version:    0.7.0.1
 */