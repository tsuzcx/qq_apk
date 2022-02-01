package com.tencent.mobileqq.kandian.biz.tab;

import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ReadInJoyNaviController
{
  public static int b = 0;
  public static int c = 0;
  public static int d = 7;
  public static final int e = ViewUtils.a(5.0F);
  public int a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ReadInJoyNavigationGridview jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview;
  protected ReadInJoyObserver a;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ReadInJoyNaviController(ViewGroup paramViewGroup, ReadInJoyNavigationGridview paramReadInJoyNavigationGridview, ImageView paramImageView)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyNaviController.3(this);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview = paramReadInJoyNavigationGridview;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview.setChannelButtonListener(new ReadInJoyNaviController.ChannelButtonListenerImpl(this));
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    a();
  }
  
  public static String a(int paramInt, ChannelCoverInfo paramChannelCoverInfo)
  {
    JSONObject localJSONObject = RIJTransMergeKanDianReport.b();
    int i;
    if (paramInt != 0)
    {
      i = 1;
      if (paramInt == 1) {
        if (paramChannelCoverInfo == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("channel_id", paramChannelCoverInfo.mChannelCoverId);
        if (!TextUtils.isEmpty(paramChannelCoverInfo.mChannelJumpUrl)) {
          break label106;
        }
        paramInt = i;
        localJSONObject.put("content_type", paramInt);
        localJSONObject.put("channel_index", c);
      }
      catch (Exception paramChannelCoverInfo)
      {
        paramChannelCoverInfo.printStackTrace();
      }
      localJSONObject.put("channel_id", -1);
      localJSONObject.put("content_type", -1);
      localJSONObject.put("channel_index", -1);
      return localJSONObject.toString();
      label106:
      paramInt = 2;
    }
  }
  
  private List<ChannelCoverInfo> a(List<ChannelCoverInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramList.next();
        if (!localChannelCoverInfo.isExternalExposure) {
          localArrayList.add(localChannelCoverInfo);
        }
      }
    }
    paramList = new StringBuilder();
    paramList.append("filtered channel list size: ");
    paramList.append(localArrayList.size());
    QLog.d("ReadInJoyNaviController", 2, paramList.toString());
    return localArrayList;
  }
  
  public static void a(int paramInt, String paramString)
  {
    String str;
    if (paramInt != 0) {
      if (paramInt != 1) {
        str = "";
      }
    }
    for (;;)
    {
      break;
      str = "0X8008B83";
      continue;
      str = "0X8008B81";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", str, str, 0, 0, "", "", "", paramString, false);
  }
  
  private void a(long paramLong)
  {
    RIJThreadHandler.b().postDelayed(new ReadInJoyNaviController.4(this), paramLong);
  }
  
  public void a()
  {
    try
    {
      ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      List localList = localReadInJoyLogicManager.getReadInJoyLogicEngine().a(0);
      if ((localList != null) && (localList.size() != 0))
      {
        a(localList);
      }
      else
      {
        localReadInJoyLogicManager.getReadInJoyLogicEngine().c(0);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNaviController", 2, "No channel Cache info.");
        }
      }
      localReadInJoyLogicManager.getReadInJoyLogicEngine().a(0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview.a() <= 0)
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNaviController", 2, "No channel info.");
      }
      return;
    }
    b = paramInt;
    if (this.jdField_a_of_type_AndroidViewViewGroup.findViewWithTag("mReadInJoyNavigation") == null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 48;
      localLayoutParams.topMargin = this.jdField_a_of_type_Int;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview.a().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = ((ChannelCoverInfo)localIterator.next()).clone();
        if (localChannelCoverInfo != null)
        {
          boolean bool;
          if (paramInt == localChannelCoverInfo.mChannelCoverId) {
            bool = true;
          } else {
            bool = false;
          }
          localChannelCoverInfo.isSelected = bool;
          if (paramInt == localChannelCoverInfo.mChannelCoverId) {
            c = i;
          }
        }
        localArrayList.add(localChannelCoverInfo);
        i += 1;
      }
      a(localArrayList);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview.setAlpha(0.0F);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview.setTag("mReadInJoyNavigation");
      RIJThreadHandler.b().postDelayed(new ReadInJoyNaviController.1(this), 0L);
    }
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    if (a())
    {
      if (paramChannelCoverInfo != null)
      {
        int i = 0;
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview.a().iterator();
        while (localIterator.hasNext())
        {
          ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
          if ((localChannelCoverInfo != null) && (localChannelCoverInfo.mChannelCoverId == paramChannelCoverInfo.mChannelCoverId))
          {
            c = i;
            break;
          }
          i += 1;
        }
      }
      RIJThreadHandler.b().postDelayed(new ReadInJoyNaviController.2(this, paramChannelCoverInfo), 0L);
    }
  }
  
  public void a(List<ChannelCoverInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNaviController", 2, "setAdapterData.");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview.setNaviBarAdapterDataSet(a(paramList));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup.findViewWithTag("mReadInJoyNavigation") != null;
  }
  
  public void b()
  {
    ReadInJoyNavigationGridview localReadInJoyNavigationGridview = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview;
    if (localReadInJoyNavigationGridview != null) {
      localReadInJoyNavigationGridview.a();
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNaviController
 * JD-Core Version:    0.7.0.1
 */