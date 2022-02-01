package com.tencent.mobileqq.teamworkforgroup;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.GridOptPopBar;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.IGroupTeamWorkAdapter;
import com.tencent.mobileqq.teamwork.OnItemLongClickListener;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.teamwork.TeamWorkManager;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkAdapterCreator;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mqq.os.MqqHandler;

public class GroupTeamWorkListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, OnItemLongClickListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  public int a;
  public long a;
  public Dialog a;
  private View jdField_a_of_type_AndroidViewView;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private GridOptPopBar jdField_a_of_type_ComTencentMobileqqActivityRecentGridOptPopBar;
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private IGroupTeamWorkAdapter jdField_a_of_type_ComTencentMobileqqTeamworkIGroupTeamWorkAdapter;
  TeamWorkManager jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkManager;
  TeamWorkObserver jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver = new GroupTeamWorkListActivity.17(this);
  IGroupTeamWorkHandler jdField_a_of_type_ComTencentMobileqqTeamworkApiIGroupTeamWorkHandler;
  ITeamWorkHandler jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkHandler;
  private GroupPadTemplateAdapter jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateAdapter;
  GroupTeamWorkManager jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkManager;
  GroupTeamWorkObserver jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkObserver = new GroupTeamWorkListActivity.16(this);
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private PopupMenuDialog.OnClickActionListener jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener = new GroupTeamWorkListActivity.7(this);
  Comparator<PadInfo> jdField_a_of_type_JavaUtilComparator = new GroupTeamWorkListActivity.9(this);
  List<GPadInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected final MqqHandler a;
  volatile boolean jdField_a_of_type_Boolean = false;
  public int b;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  List<GroupPadTemplateInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private volatile int jdField_c_of_type_Int = 1;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = false;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean = false;
  private View f;
  private View g;
  
  public GroupTeamWorkListActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_AndroidAppDialog = null;
    this.jdField_b_of_type_Int = 0;
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376809);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131378352);
    this.f = findViewById(2131378351);
    this.f.setOnClickListener(this);
    this.g = findViewById(2131378337);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378339));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)findViewById(2131370110));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDivider(null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(getResources().getDrawable(2130839396));
    View localView = LayoutInflater.from(this).inflate(2131562917, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
    Object localObject = new LinearLayout(this);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).addView(localView);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562927, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367858));
    localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    if (localObject != null)
    {
      ((HorizontalListView)localObject).setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(getResources().getDimensionPixelSize(2131297181));
    }
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379866));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new GroupTeamWorkListActivity.4(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559642, null));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562920, null);
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131378355);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378354));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_c_of_type_AndroidViewView.findViewById(2131378353));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_c_of_type_AndroidViewView);
    b();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376636));
    localObject = new ArrayList();
    ((List)localObject).add(GridOptPopBar.a);
    ((List)localObject).add(GridOptPopBar.b);
    ((List)localObject).add(GridOptPopBar.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentGridOptPopBar = new GridOptPopBar(this, (List)localObject, this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$OnClickActionListener);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (SharedPreUtils.b(this, this.app.getCurrentUin(), 1))
    {
      new GroupTeamWorkListActivity.5(this);
      localView.setVisibility(0);
      localObject = (TextView)localView.findViewById(2131364737);
      FixSizeImageView localFixSizeImageView = (FixSizeImageView)localView.findViewById(2131364736);
      ((TextView)localObject).setText(getString(2131690879));
      ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      localFixSizeImageView.setOnClickListener(new GroupTeamWorkListActivity.6(this, localView));
      return;
    }
    localView.setVisibility(8);
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    IGroupTeamWorkHandler localIGroupTeamWorkHandler = this.jdField_a_of_type_ComTencentMobileqqTeamworkApiIGroupTeamWorkHandler;
    if (localIGroupTeamWorkHandler != null)
    {
      localIGroupTeamWorkHandler.getGroupTeamWorkList(paramLong, paramInt1, paramInt2, paramInt3);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkApiIGroupTeamWorkHandler.getGroupPadTemplateList(paramLong);
    }
  }
  
  private void a(List<GPadInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719562);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719563);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void b()
  {
    this.leftView.setText(getResources().getString(2131693084));
    this.leftView.setBackgroundResource(2130851066);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130840334);
    this.rightViewImg.setOnClickListener(this);
    this.centerView.setMaxEms(13);
    this.centerView.setText(getResources().getString(2131693082));
    this.centerView.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    ThreadManager.postImmediately(new GroupTeamWorkListActivity.8(this, paramInt), null, true);
  }
  
  private void b(List<GroupPadTemplateInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
  }
  
  private void c()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      if (localQQCustomDialog.isShowing()) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" dismiss exception: ");
          localStringBuilder.append(localException.toString());
          QLog.e("GroupTeamWorkListActivity", 1, localStringBuilder.toString());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  private void c(int paramInt)
  {
    ThreadManager.postImmediately(new GroupTeamWorkListActivity.10(this, paramInt), null, true);
  }
  
  private void c(PadInfo paramPadInfo)
  {
    c();
    if (paramPadInfo == null) {
      return;
    }
    String str1 = getString(2131694583);
    if ((this.jdField_a_of_type_Int != 1) && ((paramPadInfo.creatorUin <= 0L) || (!this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin)))))
    {
      if (TroopUtils.a(this.app, this.jdField_a_of_type_Long, this.app.getCurrentAccountUin()))
      {
        if (paramPadInfo.type == 1)
        {
          str1 = getString(2131691489);
          str2 = getString(2131691476);
        }
        else
        {
          str1 = getString(2131691491);
          str2 = getString(2131691476);
        }
      }
      else
      {
        str2 = "";
        str3 = str1;
        break label182;
      }
    }
    else if (paramPadInfo.type == 1)
    {
      str1 = getString(2131691490);
      str2 = getString(2131691476);
    }
    else
    {
      str1 = getString(2131691492);
      str2 = getString(2131691476);
    }
    String str3 = str2;
    String str2 = str1;
    label182:
    if ((paramPadInfo.creatorUin > 0L) && (this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin))))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, null, str2, getString(2131691494), getString(2131690728), str3, new GroupTeamWorkListActivity.11(this), new GroupTeamWorkListActivity.12(this, paramPadInfo), new GroupTeamWorkListActivity.13(this));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setMessage(str2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(str3, new GroupTeamWorkListActivity.14(this, paramPadInfo));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(getString(2131690728), new GroupTeamWorkListActivity.15(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Boolean = true;
      startTitleProgress();
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_a_of_type_Boolean = false;
      stopTitleProgress();
    }
  }
  
  public void a(PadInfo paramPadInfo)
  {
    if ((paramPadInfo != null) && (!TextUtils.isEmpty(paramPadInfo.pad_url))) {
      c(paramPadInfo);
    }
  }
  
  public void b(PadInfo paramPadInfo)
  {
    if ((paramPadInfo != null) && (!TextUtils.isEmpty(paramPadInfo.pad_url)))
    {
      String str1 = paramPadInfo.pad_url;
      String str2 = paramPadInfo.title;
      String str3 = String.valueOf(paramPadInfo.creatorUin);
      Intent localIntent = new Intent(getApplicationContext(), TeamWorkTransparentShareActivity.class);
      if ((!TextUtils.isEmpty(str3)) && (str3.equals(getCurrentAccountUin()))) {
        localIntent.putExtra("team_is_my_document", true);
      }
      if (!TextUtils.isEmpty(str2)) {
        localIntent.putExtra(TeamWorkConstants.a, str2);
      }
      if (!TextUtils.isEmpty(str1)) {
        localIntent.putExtra("team_work_pad_url", str1);
      }
      localIntent.putExtra("team_policy", paramPadInfo.policy);
      localIntent.putExtra("team_work_pad_list_type", paramPadInfo.type_list);
      localIntent.putExtra("team_work_pad_type", paramPadInfo.type);
      localIntent.putExtra("from_activity", "GroupTeamWorkListActivity");
      localIntent.putExtra("select_type", this.jdField_a_of_type_Int);
      overridePendingTransition(0, 0);
      startActivity(localIntent);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onActivityResult,requestCode=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",resultCode=");
      localStringBuilder.append(paramInt2);
      QLog.d("GroupTeamWorkListActivity", 2, localStringBuilder.toString());
    }
    if (paramInt1 == 14001)
    {
      a(this.jdField_a_of_type_Long, 0, 20, 1);
      this.jdField_e_of_type_Boolean = true;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559215);
    this.jdField_a_of_type_Long = getIntent().getLongExtra(TeamWorkConstants.e, 0L);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkApiIGroupTeamWorkHandler = ((IGroupTeamWorkHandler)this.app.getBusinessHandler(BusinessHandlerFactory.GROUP_TEAM_WORK_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkManager = ((GroupTeamWorkManager)this.app.getManager(QQManagerFactory.GROUP_TEAM_WORK_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkApiITeamWorkHandler = ((ITeamWorkHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkManager = ((TeamWorkManager)this.app.getManager(QQManagerFactory.TEAMWORK_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkIGroupTeamWorkAdapter = ((IGroupTeamWorkAdapterCreator)QRoute.api(IGroupTeamWorkAdapterCreator.class)).getGroupTeamWorkAdapter(this.app, this, this, null);
    a();
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
    paramBundle = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.b(String.valueOf(this.jdField_a_of_type_Long));
      if (paramBundle != null) {
        this.jdField_b_of_type_Long = paramBundle.dwGroupClassExt;
      }
    }
    b(1);
    ((TroopInfoManager)this.app.getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(this.app.getApp(), String.valueOf(this.jdField_a_of_type_Long), "TIM_GROUP_TM_REDDOT", false);
    ((IGroupTeamWorkHandler)this.app.getBusinessHandler(BusinessHandlerFactory.GROUP_TEAM_WORK_HANDLER)).getGroupTeamWorkListLastAddTime(this.jdField_a_of_type_Long);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTeamworkIGroupTeamWorkAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkIGroupTeamWorkAdapter.a(new GroupTeamWorkListActivity.1(this));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkIGroupTeamWorkAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateAdapter = new GroupPadTemplateAdapter(this, this);
    c(1);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateAdapter.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateAdapter.a(new GroupTeamWorkListActivity.2(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentGridOptPopBar;
    if (localObject != null) {
      ((GridOptPopBar)localObject).a();
    }
    localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null)
    {
      ((MqqHandler)localObject).removeMessages(114);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(111);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(112);
    }
    ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupTIMFileNewsInfo(this.app.getCurrentAccountUin(), "group_file_inner_reddot_tim", String.valueOf(this.jdField_a_of_type_Long), false);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkObserver);
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateAdapter = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    GridOptPopBar localGridOptPopBar = this.jdField_a_of_type_ComTencentMobileqqActivityRecentGridOptPopBar;
    if (localGridOptPopBar != null) {
      localGridOptPopBar.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ThreadManager.getUIHandler().postDelayed(new GroupTeamWorkListActivity.3(this), 100L);
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return true;
    case 115: 
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateAdapter != null) {
        synchronized (this.jdField_b_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateAdapter.a(this.jdField_b_of_type_JavaUtilList);
          if (this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateAdapter.getCount() > 0)
          {
            this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
            return true;
          }
        }
      }
      break;
    case 114: 
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(114);
      if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() == 8)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        return true;
      }
      break;
    case 113: 
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkIGroupTeamWorkAdapter != null)
      {
        int i = ???.arg1;
        i = ???.arg2;
        if (i == 4) {
          a(false);
        }
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_ComTencentMobileqqTeamworkIGroupTeamWorkAdapter.a(this.jdField_a_of_type_JavaUtilList);
          if (i == 1)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqTeamworkIGroupTeamWorkAdapter.getCount() > 0)
            {
              if (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0) {
                this.jdField_e_of_type_AndroidViewView.setVisibility(8);
              }
              if (this.g.getVisibility() == 0) {
                this.g.setVisibility(8);
              }
              this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
              if (this.jdField_e_of_type_Boolean) {
                a(1);
              }
            }
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkIGroupTeamWorkAdapter.getCount() > 0)
          {
            if (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0) {
              this.jdField_e_of_type_AndroidViewView.setVisibility(8);
            }
            if (this.g.getVisibility() == 0) {
              this.g.setVisibility(8);
            }
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
            if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() + 1 >= this.jdField_a_of_type_ComTencentMobileqqTeamworkIGroupTeamWorkAdapter.getCount()) {
              this.jdField_d_of_type_AndroidViewView.setVisibility(8);
            }
          }
          else
          {
            if (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0) {
              this.jdField_e_of_type_AndroidViewView.setVisibility(8);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getVisibility() == 0) {
              this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
            }
            this.g.setVisibility(0);
          }
          if ((this.jdField_a_of_type_Boolean) || (i == 5))
          {
            a(2);
            return true;
          }
        }
      }
      break;
    case 112: 
      ??? = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
      if (??? != null)
      {
        ???.springBackOverScrollHeaderView();
        return true;
      }
      break;
    case 111: 
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null) {
        if (???.arg1 == 1) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
        }
      }
      ??? = new Message();
      ???.what = 112;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(???, 500L);
    }
    return true;
  }
  
  protected boolean onBackEvent()
  {
    GridOptPopBar localGridOptPopBar = this.jdField_a_of_type_ComTencentMobileqqActivityRecentGridOptPopBar;
    if (localGridOptPopBar != null) {
      localGridOptPopBar.a();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131369216)
    {
      if (i == 2131378351)
      {
        a(this.jdField_a_of_type_Long, 0, 20, 1);
        this.f.setVisibility(8);
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else
    {
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).report(this.app, "0X800993A");
      GridOptPopBar localGridOptPopBar = this.jdField_a_of_type_ComTencentMobileqqActivityRecentGridOptPopBar;
      if (localGridOptPopBar != null)
      {
        RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
        localGridOptPopBar.a(localRelativeLayout, localRelativeLayout.getWidth() - getResources().getDimensionPixelSize(2131298902), getResources().getDimensionPixelSize(2131298899));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).c(0L);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 != 0) && (paramInt1 + paramInt2 == paramInt3))
    {
      this.jdField_b_of_type_Boolean = true;
      if (paramInt3 <= paramInt2)
      {
        this.jdField_c_of_type_Boolean = false;
        return;
      }
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqTeamworkIGroupTeamWorkAdapter;
      if ((paramAbsListView != null) && (paramAbsListView.getCount() > 0) && (this.jdField_c_of_type_Boolean) && (paramInt != 0))
      {
        if (this.jdField_b_of_type_Int != 0)
        {
          a(true);
          a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, 20, 3);
          return;
        }
        a(false);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(114, 1500L);
      }
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).b(0L);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).a(0L);
    a(this.jdField_a_of_type_Long, 0, 20, 2);
    this.jdField_d_of_type_Boolean = true;
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity
 * JD-Core Version:    0.7.0.1
 */