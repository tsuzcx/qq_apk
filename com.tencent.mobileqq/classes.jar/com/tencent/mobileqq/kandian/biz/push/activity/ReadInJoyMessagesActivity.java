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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
  public static int f = 0;
  public static int g = 1;
  public static final String h = HardCodeUtil.a(2131910618);
  protected DragFrameLayout a;
  public View b;
  public long c = 0L;
  public boolean d;
  public boolean e;
  private SwipListView i;
  private QQAppInterface j;
  private KandianMergeManager k;
  private long l = 0L;
  private SubscriptFeedsNewAdapter m;
  private List<SubscriptionFeed> n;
  private int o = 0;
  private ReadInJoyObserver p = new ReadInJoyMessagesActivity.1(this);
  private XListView.DrawFinishedListener q = new ReadInJoyMessagesActivity.2(this);
  
  public static DragFrameLayout a(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    DragFrameLayout localDragFrameLayout = null;
    View localView = null;
    int i1 = 0;
    while (i1 < localViewGroup.getChildCount())
    {
      localView = localViewGroup.getChildAt(i1);
      if ((localView instanceof DragFrameLayout)) {
        return (DragFrameLayout)localView;
      }
      if ((localView instanceof TopGestureLayout)) {
        break;
      }
      i1 += 1;
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
    this.j = ((QQAppInterface)super.getAppRuntime());
    if (this.j == null) {
      return;
    }
    setContentView(2131626339);
    this.k = ((KandianMergeManager)this.j.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    this.k.a(this);
    this.a = a(getActivity());
    DragFrameLayout localDragFrameLayout = this.a;
    if (localDragFrameLayout != null) {
      localDragFrameLayout.a(this, false);
    }
    setTitle(h);
    this.leftView.setText(HardCodeUtil.a(2131901576));
    this.b = findViewById(2131432530);
    this.i = ((SwipListView)findViewById(2131433082));
    this.i.setDivider(getResources().getDrawable(2131167227));
    this.i.setDividerHeight(getResources().getDimensionPixelSize(2131297287));
    this.i.setOnScrollListener(this);
    this.i.setDrawFinishedListener(this.q);
    this.m = new SubscriptFeedsNewAdapter(getActivity(), this.j, this.i, getActivity().getLayoutInflater());
    this.m.a(this);
    this.i.setAdapter(this.m);
    this.m.a(this.a);
    this.i.setBackgroundResource(2131166842);
    this.i.setDragEnable(true);
    this.i.setRightIconMenuListener(this);
  }
  
  private void c()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.p);
    if (this.k != null) {
      ReadInJoyWebDataManager.a().a(this.j.getCurrentAccountUin(), this.k.P() ^ true);
    }
  }
  
  private void d()
  {
    if (this.m.getCount() == 0)
    {
      ((TextView)this.b.findViewById(2131447914)).setText(HardCodeUtil.a(2131910434));
      this.b.setVisibility(0);
      ((ImageView)this.b.findViewById(2131440829)).setImageResource(2130843882);
      this.b.setBackgroundResource(2131166842);
      this.i.setBackgroundResource(2130853309);
      return;
    }
    this.b.setVisibility(8);
    this.i.setBackgroundResource(2131166842);
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
      if (ThemeUtil.isInNightMode(this.j))
      {
        if ((!SystemUtil.d()) && (!SystemUtil.g()))
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
        }
        else
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
          this.mSystemBarComp.setStatusBarDarkMode(true);
        }
      }
      else if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if ((!SystemUtil.d()) && (!SystemUtil.g()))
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
    this.leftView.setBackgroundResource(2130851519);
    if (this.centerView != null) {
      this.centerView.setTextColor(-16777216);
    }
    this.vg.setBackgroundColor(-1);
  }
  
  public void a(List<SubscriptionFeed> paramList)
  {
    DragFrameLayout localDragFrameLayout = this.a;
    if ((localDragFrameLayout != null) && (localDragFrameLayout.getMode() != -1)) {
      return;
    }
    if (this.m != null)
    {
      if (this.b == null) {
        return;
      }
      if (paramList != null) {
        this.n = paramList;
      }
      if (this.o != 0)
      {
        ThreadManager.getUIHandler().postDelayed(new ReadInJoyMessagesActivity.3(this, paramList), 1500L);
        return;
      }
      this.e = true;
      this.m.a(this.n);
      this.m.b();
      this.m.c();
      this.m.notifyDataSetChanged();
      d();
    }
  }
  
  public void da_()
  {
    ((ReadInJoyLogicManager)this.j.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().y();
    if (this.k != null) {
      ReadInJoyWebDataManager.a().a(this.j.getCurrentAccountUin(), this.k.P() ^ true);
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
    Object localObject = this.j;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeHandler(getClass());
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((SwipListView)localObject).setAdapter(null);
      this.i.setDrawFinishedListener(null);
    }
    localObject = this.m;
    if (localObject != null)
    {
      ((SubscriptFeedsNewAdapter)localObject).a();
      this.m = null;
    }
    this.k.b(this);
    this.n = null;
    localObject = this.a;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a(this);
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.p);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    DragFrameLayout localDragFrameLayout = this.a;
    if (localDragFrameLayout != null) {
      localDragFrameLayout.a();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((ReadInJoyLogicManager)this.j.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().y();
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_private_letter_count", this.k.F());
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
    Object localObject = this.a;
    if ((localObject != null) && (((DragFrameLayout)localObject).getMode() == -1) && (paramDragFrameLayout.getDragView() != null) && (paramDragFrameLayout.getDragView().getId() == 2131449123))
    {
      paramDragFrameLayout = (SubscriptionFeed)paramDragFrameLayout.getDragView().getTag(2131446598);
      if (paramDragFrameLayout != null)
      {
        localObject = paramDragFrameLayout.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramDragFrameLayout.b);
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject, "0X80064D1", "0X80064D1", 0, 0, localStringBuilder.toString(), "", "", "");
        paramDragFrameLayout.a();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i2 = paramView.getId();
    int i1 = 0;
    String str = "";
    Object localObject1;
    switch (i2)
    {
    default: 
    case 2131446595: 
      if (((Integer)paramView.getTag(2131446599)).intValue() == SubscriptFeedsAdapter.d)
      {
        Object localObject2 = paramView.getTag(2131446598);
        Object localObject4 = paramView.getTag(2131446607);
        if (localObject4 != null) {
          localObject1 = (String)localObject4;
        } else {
          localObject1 = "";
        }
        if (localObject4 != null) {
          i1 = ((Integer)localObject2).intValue();
        }
        localObject4 = Integer.valueOf(i1);
        if (((Integer)localObject4).intValue() > 0) {
          ReportController.b(this.j, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.j, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
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
        PublicAccountReportUtils.a(null, (String)localObject1, "0X8007DB3", "0X8007DB3", 0, 0, "", "", "", (String)localObject3, false);
        ReportController.b(this.j, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80081C8", "0X80081C8", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(((Integer)localObject4).intValue()), false);
        if (TextUtils.isEmpty(TroopBarAssistantManager.a().a((String)localObject1)))
        {
          localObject3 = (IPublicAccountHandler)this.j.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
          if (localObject3 != null) {
            ((IPublicAccountHandler)localObject3).getUserFollowList();
          }
        }
        paramView = paramView.getTag(2131446600);
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
    case 2131438909: 
      i2 = ((Integer)paramView.getTag(2131446599)).intValue();
      i1 = ((Integer)paramView.getTag(2131444211)).intValue();
      if (i2 == SubscriptFeedsAdapter.e) {
        ReadInJoyUtils.a(this, (String)paramView.getTag(2131446833));
      }
      i2 = ((Integer)paramView.getTag(2131444210)).intValue();
      if (i2 == f) {
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(i1), false);
      } else if (i2 == g) {
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80080F2", "0X80080F2", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(i1), false);
      }
      paramView.findViewById(2131449123).setVisibility(8);
      paramView.findViewById(2131428790).setVisibility(0);
      this.k.I();
      return;
    case 2131438144: 
      paramView = paramView.getTag(2131446607);
      if (paramView != null) {
        str = (String)paramView;
      }
      ReadInJoyLogicEngine.a().b(str);
      return;
    case 2131438143: 
      localObject1 = paramView.getTag(2131446607);
      if (localObject1 != null) {
        localObject1 = (String)localObject1;
      } else {
        localObject1 = "";
      }
      paramView = paramView.getTag(2131446600);
      if (paramView != null) {
        str = (String)paramView;
      }
      paramView = (ActionSheet)ActionSheetHelper.b(getActivity(), null);
      paramView.setMainTitle(String.format(getResources().getString(2131894284), new Object[] { str }));
      paramView.addButton(2131894218, 3);
      paramView.addCancelButton(2131887648);
      paramView.setOnButtonClickListener(new ReadInJoyMessagesActivity.4(this, (String)localObject1, paramView));
      paramView.show();
      return;
    case 2131438138: 
      paramView = paramView.getTag(2131446607);
      if (paramView != null) {
        str = (String)paramView;
      }
      ReadInJoyLogicEngine.a().a(str);
      return;
    case 2131438112: 
      paramView = paramView.getTag(2131446607);
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
    this.o = paramInt;
    if (paramInt != 0)
    {
      DropFrameMonitor.b().a("list_subscript");
      return;
    }
    DropFrameMonitor.b().a("list_subscript", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyMessagesActivity
 * JD-Core Version:    0.7.0.1
 */