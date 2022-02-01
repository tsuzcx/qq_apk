package com.tencent.mobileqq.teamworkforgroup;

import Override;
import akkb;
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
import avtd;
import bcts;
import bctz;
import bcvc;
import bcvg;
import bcvj;
import bcvs;
import bcxq;
import bcxt;
import bcxv;
import bcxw;
import bcxx;
import bcxy;
import bcxz;
import bcya;
import bcyb;
import bcyc;
import bcyd;
import bcye;
import bcyg;
import bcyi;
import bcyj;
import bcyk;
import bcyl;
import bcym;
import bcyn;
import bfun;
import bfur;
import bfyz;
import bjmp;
import bjsd;
import bjsz;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mqq.os.MqqHandler;

public class GroupTeamWorkListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, bcts, bjsd, AbsListView.OnScrollListener
{
  public int a;
  public long a;
  private akkb jdField_a_of_type_Akkb;
  public Dialog a;
  private View jdField_a_of_type_AndroidViewView;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bcvc jdField_a_of_type_Bcvc;
  bcvg jdField_a_of_type_Bcvg;
  bcvj jdField_a_of_type_Bcvj = new bcyd(this);
  private bcxq jdField_a_of_type_Bcxq;
  private bcxt jdField_a_of_type_Bcxt;
  public bcxv a;
  bcym jdField_a_of_type_Bcym;
  bcyn jdField_a_of_type_Bcyn = new bcyc(this);
  private bjsz jdField_a_of_type_Bjsz = new bcyk(this);
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  Comparator<PadInfo> jdField_a_of_type_JavaUtilComparator = new bcyl(this);
  List<GPadInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  public final MqqHandler a;
  volatile boolean jdField_a_of_type_Boolean = false;
  public int b;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  List<GroupPadTemplateInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private volatile int jdField_c_of_type_Int = 1;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private View f;
  private View g;
  
  public GroupTeamWorkListActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_MqqOsMqqHandler = new bjmp(Looper.getMainLooper(), this, true);
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376679);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131378256);
    this.f = findViewById(2131378255);
    this.f.setOnClickListener(this);
    this.g = findViewById(2131378241);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378243));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)findViewById(2131370009));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDivider(null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(getResources().getDrawable(2130839440));
    View localView = LayoutInflater.from(this).inflate(2131562868, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
    Object localObject = new LinearLayout(this);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).addView(localView);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562880, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367761));
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(getResources().getDimensionPixelSize(2131297177));
    }
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379819));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366179));
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bcyg(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559654, null));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562871, null);
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131378259);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378258));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_c_of_type_AndroidViewView.findViewById(2131378257));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_c_of_type_AndroidViewView);
    b();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376501));
    localObject = new ArrayList();
    ((List)localObject).add(akkb.a);
    ((List)localObject).add(akkb.b);
    ((List)localObject).add(akkb.c);
    this.jdField_a_of_type_Akkb = new akkb(this, (List)localObject, this.jdField_a_of_type_Bjsz);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (bfyz.b(this, this.app.getCurrentUin(), 1))
    {
      new bcyi(this);
      localView.setVisibility(0);
      localObject = (TextView)localView.findViewById(2131364649);
      FixSizeImageView localFixSizeImageView = (FixSizeImageView)localView.findViewById(2131364648);
      ((TextView)localObject).setText(getString(2131690773));
      ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      localFixSizeImageView.setOnClickListener(new bcyj(this, localView));
      return;
    }
    localView.setVisibility(8);
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bcxv != null)
    {
      this.jdField_a_of_type_Bcxv.a(paramLong, paramInt1, paramInt2, paramInt3);
      this.jdField_a_of_type_Bcxv.a(paramLong);
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718889);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718890);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void b()
  {
    this.leftView.setText(getResources().getString(2131692873));
    this.leftView.setBackgroundResource(2130850593);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130840316);
    this.rightViewImg.setOnClickListener(this);
    this.centerView.setMaxEms(13);
    this.centerView.setText(getResources().getString(2131692871));
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
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("GroupTeamWorkListActivity", 1, " dismiss exception: " + localException.toString());
      }
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
    String str1 = "";
    String str2 = getString(2131694201);
    if ((this.jdField_a_of_type_Int == 1) || ((paramPadInfo.creatorUin > 0L) && (this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin))))) {
      if (paramPadInfo.type == 1)
      {
        str1 = getString(2131691374);
        str2 = getString(2131691360);
        if ((paramPadInfo.creatorUin <= 0L) || (!this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin)))) {
          break label258;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this, 230, null, str1, getString(2131691378), getString(2131690620), str2, new bcxx(this), new bcxy(this, paramPadInfo), new bcxz(this));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      str1 = getString(2131691376);
      str2 = getString(2131691360);
      break;
      if (!TroopUtils.IsTroopAdmin(this.app, this.jdField_a_of_type_Long, this.app.getCurrentAccountUin())) {
        break;
      }
      if (paramPadInfo.type == 1)
      {
        str1 = getString(2131691373);
        str2 = getString(2131691360);
        break;
      }
      str1 = getString(2131691375);
      str2 = getString(2131691360);
      break;
      label258:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this, 230).setMessage(str1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(str2, new bcya(this, paramPadInfo));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(getString(2131690620), new bcyb(this));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Boolean = true;
      startTitleProgress();
    }
    while (paramInt != 2) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    stopTitleProgress();
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
        localIntent.putExtra(bctz.a, str2);
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupTeamWorkListActivity", 2, " onActivityResult,requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt1 == 14001)
    {
      a(this.jdField_a_of_type_Long, 0, 20, 1);
      this.jdField_e_of_type_Boolean = true;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559258);
    this.jdField_a_of_type_Long = getIntent().getLongExtra(bctz.e, 0L);
    this.jdField_a_of_type_Bcxv = ((bcxv)this.app.getBusinessHandler(143));
    this.jdField_a_of_type_Bcym = ((bcym)this.app.getManager(304));
    this.jdField_a_of_type_Bcvc = ((bcvc)this.app.getBusinessHandler(122));
    this.jdField_a_of_type_Bcvg = ((bcvg)this.app.getManager(283));
    this.jdField_a_of_type_Bcxt = new bcxt(this.app, this, this, null);
    a();
    this.app.addObserver(this.jdField_a_of_type_Bcyn);
    this.app.addObserver(this.jdField_a_of_type_Bcvj);
    paramBundle = (TroopManager)this.app.getManager(52);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.b(String.valueOf(this.jdField_a_of_type_Long));
      if (paramBundle != null) {
        this.jdField_b_of_type_Long = paramBundle.dwGroupClassExt;
      }
    }
    b(1);
    ((avtd)this.app.getManager(37)).a(this.app.getApp(), String.valueOf(this.jdField_a_of_type_Long), "TIM_GROUP_TM_REDDOT", false);
    ((bcxv)this.app.getBusinessHandler(143)).b(this.jdField_a_of_type_Long);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Bcxt);
    this.jdField_a_of_type_Bcxt.a(new bcxw(this));
    this.jdField_a_of_type_Bcxt.b(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Bcxq = new bcxq(this, this);
    c(1);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bcxq);
    this.jdField_a_of_type_Bcxq.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_Bcxq.notifyDataSetChanged();
    this.jdField_a_of_type_Bcxq.a(new bcye(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Akkb != null) {
      this.jdField_a_of_type_Akkb.a();
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(114);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(111);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(112);
    }
    bfun.a(this.app.getCurrentAccountUin(), "group_file_inner_reddot_tim", String.valueOf(this.jdField_a_of_type_Long), false);
    this.app.removeObserver(this.jdField_a_of_type_Bcyn);
    this.app.removeObserver(this.jdField_a_of_type_Bcvj);
    c();
    if (this.jdField_a_of_type_Bcxq != null) {
      this.jdField_a_of_type_Bcxq = null;
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Akkb != null) {
      this.jdField_a_of_type_Akkb.a();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ThreadManager.getUIHandler().postDelayed(new GroupTeamWorkListActivity.3(this), 100L);
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
      {
        if (???.arg1 != 1) {
          break label93;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      }
      for (;;)
      {
        ??? = new Message();
        ???.what = 112;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(???, 500L);
        return true;
        label93:
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView == null) {
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.springBackOverScrollHeaderView();
      return true;
      if (this.jdField_a_of_type_Bcxt == null) {
        continue;
      }
      int i = ???.arg1;
      i = ???.arg2;
      if (i == 4) {
        a(false);
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_Bcxt.b(this.jdField_a_of_type_JavaUtilList);
          if (i == 1)
          {
            if (this.jdField_a_of_type_Bcxt.getCount() > 0)
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
            if ((!this.jdField_a_of_type_Boolean) && (i != 5)) {
              break;
            }
            a(2);
            return true;
          }
        }
        if (this.jdField_a_of_type_Bcxt.getCount() > 0)
        {
          if (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0) {
            this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          }
          if (this.g.getVisibility() == 0) {
            this.g.setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() + 1 >= this.jdField_a_of_type_Bcxt.getCount()) {
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
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(114);
      if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 8) {
        continue;
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      return true;
      if (this.jdField_a_of_type_Bcxq == null) {
        continue;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_Bcxq.a(this.jdField_b_of_type_JavaUtilList);
        if (this.jdField_a_of_type_Bcxq.getCount() <= 0) {
          continue;
        }
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
        return true;
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Akkb != null) {
      this.jdField_a_of_type_Akkb.a();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcvs.a(this.app, "0X800993A");
      if (this.jdField_a_of_type_Akkb != null)
      {
        this.jdField_a_of_type_Akkb.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth() - getResources().getDimensionPixelSize(2131298807), getResources().getDimensionPixelSize(2131298804));
        continue;
        a(this.jdField_a_of_type_Long, 0, 20, 1);
        this.f.setVisibility(8);
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
    }
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
    if (paramInt == 0) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bcxt != null) && (this.jdField_a_of_type_Bcxt.getCount() > 0) && (this.jdField_c_of_type_Boolean) && (paramInt != 0))
      {
        if (this.jdField_b_of_type_Int == 0) {
          break;
        }
        a(true);
        a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, 20, 3);
      }
      return;
    }
    a(false);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(114, 1500L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity
 * JD-Core Version:    0.7.0.1
 */