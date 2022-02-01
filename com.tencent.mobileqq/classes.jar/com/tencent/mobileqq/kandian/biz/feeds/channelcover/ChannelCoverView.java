package com.tencent.mobileqq.kandian.biz.feeds.channelcover;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;

public class ChannelCoverView
  implements AdapterView.OnItemClickListener
{
  public static int a = 2;
  public static int b = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ChannelCoverSimpleAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelcoverChannelCoverSimpleAdapter;
  protected ReadInJoyObserver a;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private ArrayList<ChannelCoverInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int c;
  
  public ChannelCoverView(Context paramContext, int paramInt, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ChannelCoverView.ChannelCoverViewObserver(this, null);
    this.c = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)ReadInJoyLogicEngine.a().a(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverView", 2, "ChannelCoverView createSimpleView");
    }
    a(paramContext);
    paramContext = this.jdField_a_of_type_JavaUtilArrayList;
    if ((paramContext != null) && (paramContext.size() > 0)) {
      this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    paramContext = this.jdField_a_of_type_JavaUtilArrayList;
    if ((paramContext == null) || (paramContext.size() == 0)) {
      ReadInJoyLogicEngine.a().c(paramInt);
    }
    ReadInJoyLogicEngine.a().a(paramInt);
  }
  
  public static void a(String paramString, ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    a(paramString, paramChannelCoverInfo, paramInt, -1, -1);
  }
  
  public static void a(String paramString, ChannelCoverInfo paramChannelCoverInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    ThreadManager.post(new ChannelCoverView.3(paramChannelCoverInfo, paramInt1, paramInt2, paramInt3, paramString), 5, null, true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    ThreadManager.executeOnSubThread(new ChannelCoverView.2(paramChannelCoverInfo, paramInt, paramString1, paramString2, paramString3, paramString4));
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void a()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    this.jdField_a_of_type_JavaUtilArrayList = null;
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverView", 2, "onDestroy()");
    }
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(paramContext).inflate(2131558788, null, false));
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365132);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131381146));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(AIOUtils.b(6.0F, paramContext.getResources()));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelcoverChannelCoverSimpleAdapter = new ChannelCoverSimpleAdapter(paramContext, this.jdField_a_of_type_JavaUtilArrayList, this.c);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelcoverChannelCoverSimpleAdapter);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    if (this.c == 56)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnTouchListener(new ChannelCoverView.4(this, paramContext));
      localLinearLayout.setPadding(0, (int)DisplayUtils.a(paramContext, 2.0F), 0, (int)DisplayUtils.a(paramContext, 2.0F));
    }
    if (this.c == 41523) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, AIOUtils.b(10.0F, paramContext.getResources()), 0, 0);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt)
    {
      paramAdapterView = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (TextUtils.isEmpty(paramAdapterView.mChannelJumpUrl))
      {
        paramView = new HashMap();
        paramView.put("param_key_ariticle_id", Long.valueOf(paramAdapterView.mArticleId));
        paramView.put("param_key_channel_cover_style", Integer.valueOf(paramAdapterView.mChannelCoverStyle));
        if (this.c == 56) {
          ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchVideoSubChannelActivity(this.jdField_a_of_type_AndroidContentContext, paramAdapterView.mChannelCoverId, paramAdapterView.mChannelCoverName, paramAdapterView.mChannelType, 4, paramView);
        } else {
          ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchChannelActivity(this.jdField_a_of_type_AndroidContentContext, paramAdapterView.mChannelCoverId, paramAdapterView.mChannelCoverName, paramAdapterView.mChannelType, 4, paramView);
        }
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("launchChannelActivity info.mArticleId:");
          paramView.append(paramAdapterView.mArticleId);
          paramView.append(" info.mChannelCoverStyle: ");
          paramView.append(paramAdapterView.mChannelCoverStyle);
          paramView.append(" info.mChannelCoverId:");
          paramView.append(paramAdapterView.mChannelCoverId);
          paramView.append(" info.mChannelCoverName:");
          paramView.append(paramAdapterView.mChannelCoverName);
          paramView.append(" info.mChannelType: ");
          paramView.append(paramAdapterView.mChannelType);
          QLog.d("ChannelCoverView", 2, paramView.toString());
        }
        if (this.c == 56) {
          ThreadManager.executeOnSubThread(new ChannelCoverView.1(this, paramAdapterView));
        }
      }
      else
      {
        paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramView.putExtra("url", paramAdapterView.mChannelJumpUrl);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("info.mChannelJumpUrl:");
          paramView.append(paramAdapterView.mChannelJumpUrl);
          QLog.d("ChannelCoverView", 2, paramView.toString());
        }
        paramAdapterView.mPreUpdateTime = paramAdapterView.mUpdateTime;
      }
      if (this.c == 0) {
        a("0X8007F02", paramAdapterView, jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView
 * JD-Core Version:    0.7.0.1
 */