package com.tencent.mobileqq.teamworkforgroup;

import Override;
import almj;
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
import axfw;
import beab;
import beai;
import bebl;
import bebp;
import bebs;
import becb;
import bedz;
import beec;
import beee;
import beef;
import beeg;
import beeh;
import beei;
import beej;
import beek;
import beel;
import beem;
import been;
import beep;
import beer;
import bees;
import beet;
import beeu;
import beev;
import beew;
import bguq;
import bhlk;
import bhlq;
import bhpc;
import bhsi;
import blha;
import blih;
import blnt;
import blop;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mqq.os.MqqHandler;

public class GroupTeamWorkListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, beab, blih, blnt
{
  public int a;
  public long a;
  private almj jdField_a_of_type_Almj;
  public Dialog a;
  private View jdField_a_of_type_AndroidViewView;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bebl jdField_a_of_type_Bebl;
  bebp jdField_a_of_type_Bebp;
  bebs jdField_a_of_type_Bebs = new beem(this);
  private bedz jdField_a_of_type_Bedz;
  private beec jdField_a_of_type_Beec;
  public beee a;
  beev jdField_a_of_type_Beev;
  beew jdField_a_of_type_Beew = new beel(this);
  private bhpc jdField_a_of_type_Bhpc;
  private blop jdField_a_of_type_Blop = new beet(this);
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  Comparator<PadInfo> jdField_a_of_type_JavaUtilComparator = new beeu(this);
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
    this.jdField_a_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), this, true);
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376925);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131378488);
    this.f = findViewById(2131378487);
    this.f.setOnClickListener(this);
    this.g = findViewById(2131378473);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378475));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)findViewById(2131370012));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDivider(null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(getResources().getDrawable(2130839405));
    View localView = LayoutInflater.from(this).inflate(2131562989, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
    Object localObject = new LinearLayout(this);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).addView(localView);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131563001, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367729));
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(getResources().getDimensionPixelSize(2131297122));
    }
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380067));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366151));
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new beep(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559652, null));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562992, null);
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131378491);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378490));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_c_of_type_AndroidViewView.findViewById(2131378489));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_c_of_type_AndroidViewView);
    b();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376731));
    localObject = new ArrayList();
    ((List)localObject).add(almj.a);
    ((List)localObject).add(almj.b);
    ((List)localObject).add(almj.c);
    this.jdField_a_of_type_Almj = new almj(this, (List)localObject, this.jdField_a_of_type_Blop);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (bhsi.b(this, this.app.c(), 1))
    {
      new beer(this);
      localView.setVisibility(0);
      localObject = (TextView)localView.findViewById(2131364618);
      FixSizeImageView localFixSizeImageView = (FixSizeImageView)localView.findViewById(2131364617);
      ((TextView)localObject).setText(getString(2131690733));
      ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      localFixSizeImageView.setOnClickListener(new bees(this, localView));
      return;
    }
    localView.setVisibility(8);
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Beee != null)
    {
      this.jdField_a_of_type_Beee.a(paramLong, paramInt1, paramInt2, paramInt3);
      this.jdField_a_of_type_Beee.a(paramLong);
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718641);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718642);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void b()
  {
    this.leftView.setText(getResources().getString(2131692822));
    this.leftView.setBackgroundResource(2130850668);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130840278);
    this.rightViewImg.setOnClickListener(this);
    this.centerView.setMaxEms(13);
    this.centerView.setText(getResources().getString(2131692820));
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
    if ((this.jdField_a_of_type_Bhpc == null) || (this.jdField_a_of_type_Bhpc.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      this.jdField_a_of_type_Bhpc = null;
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
    String str2 = getString(2131694098);
    if ((this.jdField_a_of_type_Int == 1) || ((paramPadInfo.creatorUin > 0L) && (this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin))))) {
      if (paramPadInfo.type == 1)
      {
        str1 = getString(2131691334);
        str2 = getString(2131691320);
        if ((paramPadInfo.creatorUin <= 0L) || (!this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin)))) {
          break label258;
        }
        this.jdField_a_of_type_Bhpc = bhlq.a(this, 230, null, str1, getString(2131691338), getString(2131690580), str2, new beeg(this), new beeh(this, paramPadInfo), new beei(this));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpc.show();
      return;
      str1 = getString(2131691336);
      str2 = getString(2131691320);
      break;
      if (!bguq.a(this.app, this.jdField_a_of_type_Long, this.app.getCurrentAccountUin())) {
        break;
      }
      if (paramPadInfo.type == 1)
      {
        str1 = getString(2131691333);
        str2 = getString(2131691320);
        break;
      }
      str1 = getString(2131691335);
      str2 = getString(2131691320);
      break;
      label258:
      this.jdField_a_of_type_Bhpc = bhlq.a(this, 230).setMessage(str1);
      this.jdField_a_of_type_Bhpc.setPositiveButton(str2, new beej(this, paramPadInfo));
      this.jdField_a_of_type_Bhpc.setNegativeButton(getString(2131690580), new beek(this));
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
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).c(0L);
  }
  
  public void a(PadInfo paramPadInfo)
  {
    if ((paramPadInfo != null) && (!TextUtils.isEmpty(paramPadInfo.pad_url))) {
      c(paramPadInfo);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).a(0L);
    a(this.jdField_a_of_type_Long, 0, 20, 2);
    this.jdField_d_of_type_Boolean = true;
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).b(0L);
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
        localIntent.putExtra(beai.a, str2);
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
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
    setContentView(2131559251);
    this.jdField_a_of_type_Long = getIntent().getLongExtra(beai.e, 0L);
    this.jdField_a_of_type_Beee = ((beee)this.app.a(143));
    this.jdField_a_of_type_Beev = ((beev)this.app.getManager(304));
    this.jdField_a_of_type_Bebl = ((bebl)this.app.a(122));
    this.jdField_a_of_type_Bebp = ((bebp)this.app.getManager(283));
    this.jdField_a_of_type_Beec = new beec(this.app, this, this, null);
    a();
    this.app.addObserver(this.jdField_a_of_type_Beew);
    this.app.addObserver(this.jdField_a_of_type_Bebs);
    paramBundle = (TroopManager)this.app.getManager(52);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.b(String.valueOf(this.jdField_a_of_type_Long));
      if (paramBundle != null) {
        this.jdField_b_of_type_Long = paramBundle.dwGroupClassExt;
      }
    }
    b(1);
    ((axfw)this.app.getManager(37)).a(this.app.getApp(), String.valueOf(this.jdField_a_of_type_Long), "TIM_GROUP_TM_REDDOT", false);
    ((beee)this.app.a(143)).b(this.jdField_a_of_type_Long);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Beec);
    this.jdField_a_of_type_Beec.a(new beef(this));
    this.jdField_a_of_type_Beec.b(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Bedz = new bedz(this, this);
    c(1);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bedz);
    this.jdField_a_of_type_Bedz.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_Bedz.notifyDataSetChanged();
    this.jdField_a_of_type_Bedz.a(new been(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Almj != null) {
      this.jdField_a_of_type_Almj.a();
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(114);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(111);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(112);
    }
    bhlk.a(this.app.getCurrentAccountUin(), "group_file_inner_reddot_tim", String.valueOf(this.jdField_a_of_type_Long), false);
    this.app.removeObserver(this.jdField_a_of_type_Beew);
    this.app.removeObserver(this.jdField_a_of_type_Bebs);
    c();
    if (this.jdField_a_of_type_Bedz != null) {
      this.jdField_a_of_type_Bedz = null;
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Almj != null) {
      this.jdField_a_of_type_Almj.a();
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
      if (this.jdField_a_of_type_Beec == null) {
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
          this.jdField_a_of_type_Beec.b(this.jdField_a_of_type_JavaUtilList);
          if (i == 1)
          {
            if (this.jdField_a_of_type_Beec.getCount() > 0)
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
        if (this.jdField_a_of_type_Beec.getCount() > 0)
        {
          if (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0) {
            this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          }
          if (this.g.getVisibility() == 0) {
            this.g.setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() + 1 >= this.jdField_a_of_type_Beec.getCount()) {
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
      if (this.jdField_a_of_type_Bedz == null) {
        continue;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_Bedz.a(this.jdField_b_of_type_JavaUtilList);
        if (this.jdField_a_of_type_Bedz.getCount() <= 0) {
          continue;
        }
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
        return true;
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Almj != null) {
      this.jdField_a_of_type_Almj.a();
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
      becb.a(this.app, "0X800993A");
      if (this.jdField_a_of_type_Almj != null)
      {
        this.jdField_a_of_type_Almj.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth() - getResources().getDimensionPixelSize(2131298742), getResources().getDimensionPixelSize(2131298739));
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
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Beec != null) && (this.jdField_a_of_type_Beec.getCount() > 0) && (this.jdField_c_of_type_Boolean) && (paramInt != 0))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity
 * JD-Core Version:    0.7.0.1
 */