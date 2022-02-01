package com.tencent.mobileqq.kandian.biz.push.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsAdapter;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsNewAdapter;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.message.activity.ReadInJoySelfActivity;
import com.tencent.mobileqq.kandian.biz.push.OnTabRedNumsChangeListenner;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.XListView.DrawFinishedListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.Serializable;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyMessagesActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, DragFrameLayout.OnDragModeChangedListener, OnTabRedNumsChangeListenner, AbsListView.OnScrollListener, SwipListView.RightIconMenuListener
{
  public static int a = 0;
  public static final String a;
  public static int b = 1;
  public long a;
  public View a;
  private SubscriptFeedsNewAdapter jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter;
  protected DragFrameLayout a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private KandianMergeManager jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyMessagesActivity.1(this);
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new ReadInJoyMessagesActivity.2(this);
  private List<SubscriptionFeed> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private long b;
  public boolean b;
  private int c = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713057);
  }
  
  public ReadInJoyMessagesActivity()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public static DragFrameLayout a(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    DragFrameLayout localDragFrameLayout = null;
    View localView = null;
    int i = 0;
    while (i < localViewGroup.getChildCount())
    {
      localView = localViewGroup.getChildAt(i);
      if ((localView instanceof DragFrameLayout)) {
        return (DragFrameLayout)localView;
      }
      if ((localView instanceof TopGestureLayout)) {
        break;
      }
      i += 1;
    }
    if (localView != null)
    {
      localDragFrameLayout = new DragFrameLayout(paramActivity.getApplication());
      localViewGroup.addView(localDragFrameLayout, 0);
      localViewGroup.removeView(localView);
      if (localView.getParent() != null) {
        ((ViewGroup)localView.getParent()).removeView(localView);
      }
      localDragFrameLayout.addView(localView);
    }
    return localDragFrameLayout;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    setContentView(2131560293);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = a(getActivity());
    DragFrameLayout localDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localDragFrameLayout != null) {
      localDragFrameLayout.a(this, false);
    }
    setTitle(jdField_a_of_type_JavaLangString);
    this.leftView.setText(HardCodeUtil.a(2131712876));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366238);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131366760));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDivider(getResources().getDrawable(2131166391));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDividerHeight(getResources().getDimensionPixelSize(2131296908));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter = new SubscriptFeedsNewAdapter(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, getActivity().getLayoutInflater());
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166115);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
  }
  
  private void c()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager != null) {
      ReadInJoyWebDataManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.i() ^ true);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.getCount() == 0)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379178)).setText(HardCodeUtil.a(2131712863));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373220)).setImageResource(2130842926);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166115);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2130851078);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166115);
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        if ((!SystemUtil.b()) && (!SystemUtil.d()))
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
        }
        else
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
          this.mSystemBarComp.setStatusBarDarkMode(true);
        }
      }
      else if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if ((!SystemUtil.b()) && (!SystemUtil.d()))
      {
        this.mSystemBarComp.setStatusBarColor(-4210753);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
    this.leftView.setTextColor(-14408926);
    this.leftView.setTextColor(-14408926);
    this.leftView.setBackgroundResource(2130849814);
    if (this.centerView != null) {
      this.centerView.setTextColor(-16777216);
    }
    this.vg.setBackgroundColor(-1);
  }
  
  public void a(List<SubscriptionFeed> paramList)
  {
    DragFrameLayout localDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if ((localDragFrameLayout != null) && (localDragFrameLayout.a() != -1)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter != null)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      if (paramList != null) {
        this.jdField_a_of_type_JavaUtilList = paramList;
      }
      if (this.c != 0)
      {
        ThreadManager.getUIHandler().postDelayed(new ReadInJoyMessagesActivity.3(this, paramList), 1500L);
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.b();
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.c();
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter.notifyDataSetChanged();
      d();
    }
  }
  
  public void aD_()
  {
    ((ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().e();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager != null) {
      ReadInJoyWebDataManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.i() ^ true);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    b();
    a();
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeHandler(getClass());
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetSwipListView;
    if (localObject != null)
    {
      ((SwipListView)localObject).setAdapter(null);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(null);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter;
    if (localObject != null)
    {
      ((SubscriptFeedsNewAdapter)localObject).a();
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsNewAdapter = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.b(this);
    this.jdField_a_of_type_JavaUtilList = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a(this);
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    DragFrameLayout localDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localDragFrameLayout != null) {
      localDragFrameLayout.a();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().e();
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_private_letter_count", this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.c());
    setResult(-1, localIntent);
    super.finish();
  }
  
  public boolean onBackEvent()
  {
    if (getIntent().getBooleanExtra("shouldBackSelfAct", false))
    {
      Intent localIntent = new Intent(this, ReadInJoySelfActivity.class);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if ((localObject != null) && (((DragFrameLayout)localObject).a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131380207))
    {
      paramDragFrameLayout = (SubscriptionFeed)paramDragFrameLayout.a().getTag(2131378092);
      if (paramDragFrameLayout != null)
      {
        localObject = paramDragFrameLayout.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramDragFrameLayout.jdField_b_of_type_Int);
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject, "0X80064D1", "0X80064D1", 0, 0, localStringBuilder.toString(), "", "", "");
        paramDragFrameLayout.a();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    int i = 0;
    String str = "";
    Object localObject1;
    switch (j)
    {
    default: 
    case 2131378089: 
      if (((Integer)paramView.getTag(2131378093)).intValue() == SubscriptFeedsAdapter.d)
      {
        Object localObject2 = paramView.getTag(2131378092);
        Object localObject4 = paramView.getTag(2131378101);
        if (localObject4 != null) {
          localObject1 = (String)localObject4;
        } else {
          localObject1 = "";
        }
        if (localObject4 != null) {
          i = ((Integer)localObject2).intValue();
        }
        localObject4 = Integer.valueOf(i);
        if (((Integer)localObject4).intValue() > 0) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
        }
        Object localObject3;
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
          ((JSONObject)localObject2).put("reddot_num", localObject4);
          localObject2 = ((JSONObject)localObject2).toString();
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          localObject3 = "";
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, (String)localObject1, "0X8007DB3", "0X8007DB3", 0, 0, "", "", "", (String)localObject3, false);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80081C8", "0X80081C8", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(((Integer)localObject4).intValue()), false);
        if (TextUtils.isEmpty(TroopBarAssistantManager.a().a((String)localObject1)))
        {
          localObject3 = (IPublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
          if (localObject3 != null) {
            ((IPublicAccountHandler)localObject3).getUserFollowList();
          }
        }
        paramView = paramView.getTag(2131378094);
        if (paramView != null) {
          str = (String)paramView;
        }
        paramView = new Intent(getActivity(), ChatActivity.class);
        paramView.putExtra("uintype", 1008);
        paramView.putExtra("uin", (String)localObject1);
        paramView.putExtra("uinname", str);
        paramView.putExtra("start_time", System.currentTimeMillis());
        paramView.putExtra("red_hot_count", (Serializable)localObject4);
        paramView.putExtra("is_come_from_readinjoy", true);
        getActivity().startActivity(paramView);
        PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
        return;
      }
      break;
    case 2131371530: 
      j = ((Integer)paramView.getTag(2131378093)).intValue();
      i = ((Integer)paramView.getTag(2131376011)).intValue();
      if (j == SubscriptFeedsAdapter.e) {
        ReadInJoyUtils.a(this, (String)paramView.getTag(2131378314));
      }
      j = ((Integer)paramView.getTag(2131376010)).intValue();
      if (j == jdField_a_of_type_Int) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(i), false);
      } else if (j == jdField_b_of_type_Int) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80080F2", "0X80080F2", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(i), false);
      }
      paramView.findViewById(2131380207).setVisibility(8);
      paramView.findViewById(2131362989).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.l();
      return;
    case 2131370821: 
      paramView = paramView.getTag(2131378101);
      if (paramView != null) {
        str = (String)paramView;
      }
      ReadInJoyLogicEngine.a().b(str);
      return;
    case 2131370820: 
      localObject1 = paramView.getTag(2131378101);
      if (localObject1 != null) {
        localObject1 = (String)localObject1;
      } else {
        localObject1 = "";
      }
      paramView = paramView.getTag(2131378094);
      if (paramView != null) {
        str = (String)paramView;
      }
      paramView = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
      paramView.setMainTitle(String.format(getResources().getString(2131696510), new Object[] { str }));
      paramView.addButton(2131696446, 3);
      paramView.addCancelButton(2131690728);
      paramView.setOnButtonClickListener(new ReadInJoyMessagesActivity.4(this, (String)localObject1, paramView));
      paramView.show();
      return;
    case 2131370815: 
      paramView = paramView.getTag(2131378101);
      if (paramView != null) {
        str = (String)paramView;
      }
      ReadInJoyLogicEngine.a().a(str);
      return;
    case 2131370802: 
      paramView = paramView.getTag(2131378101);
      if (paramView != null) {
        str = (String)paramView;
      }
      ReadInJoyLogicEngine.a().c(str);
    }
  }
  
  public void onRightIconMenuHide(View paramView) {}
  
  public void onRightIconMenuShow(View paramView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.c = paramInt;
    if (paramInt != 0)
    {
      DropFrameMonitor.a().a("list_subscript");
      return;
    }
    DropFrameMonitor.a().a("list_subscript", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyMessagesActivity
 * JD-Core Version:    0.7.0.1
 */