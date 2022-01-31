package com.tencent.mobileqq.teamworkforgroup;

import agzz;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import arom;
import axds;
import axdz;
import axfb;
import axff;
import axfi;
import axfs;
import axhp;
import axhs;
import axhu;
import axhv;
import axhw;
import axhx;
import axhy;
import axhz;
import axia;
import axib;
import axic;
import axid;
import axif;
import axih;
import axii;
import axij;
import axik;
import axil;
import axim;
import azlj;
import babl;
import babr;
import bafb;
import baig;
import beez;
import begh;
import belq;
import bemm;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
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
  implements Handler.Callback, View.OnClickListener, axds, begh, belq
{
  public int a;
  public long a;
  private agzz jdField_a_of_type_Agzz;
  public Dialog a;
  private View jdField_a_of_type_AndroidViewView;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  axfb jdField_a_of_type_Axfb;
  axff jdField_a_of_type_Axff;
  axfi jdField_a_of_type_Axfi = new axic(this);
  private axhp jdField_a_of_type_Axhp;
  private axhs jdField_a_of_type_Axhs;
  public axhu a;
  axil jdField_a_of_type_Axil;
  axim jdField_a_of_type_Axim = new axib(this);
  private bafb jdField_a_of_type_Bafb;
  private bemm jdField_a_of_type_Bemm = new axij(this);
  private FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  Comparator<PadInfo> jdField_a_of_type_JavaUtilComparator = new axik(this);
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
    this.jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this, true);
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidViewView = findViewById(2131309736);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131311108);
    this.f = findViewById(2131311107);
    this.f.setOnClickListener(this);
    this.g = findViewById(2131311095);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311097));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)findViewById(2131303596));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setDivider(null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverscrollHeader(getResources().getDrawable(2130839107));
    View localView = LayoutInflater.from(this).inflate(2131496896, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
    Object localObject = new LinearLayout(this);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).addView(localView);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131496908, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, false);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301602));
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(getResources().getDimensionPixelSize(2131165965));
    }
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312509));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131300167));
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new axif(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131493891, null));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131496899, null);
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131311111);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131311110));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_c_of_type_AndroidViewView.findViewById(2131311109));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.jdField_c_of_type_AndroidViewView);
    b();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131309578));
    localObject = new ArrayList();
    ((List)localObject).add(agzz.a);
    ((List)localObject).add(agzz.b);
    ((List)localObject).add(agzz.c);
    this.jdField_a_of_type_Agzz = new agzz(this, (List)localObject, this.jdField_a_of_type_Bemm);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (baig.b(this, this.app.c(), 1))
    {
      new axih(this);
      localView.setVisibility(0);
      localObject = (TextView)localView.findViewById(2131298736);
      FixSizeImageView localFixSizeImageView = (FixSizeImageView)localView.findViewById(2131298735);
      ((TextView)localObject).setText(getString(2131625276));
      ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      localFixSizeImageView.setOnClickListener(new axii(this, localView));
      return;
    }
    localView.setVisibility(8);
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Axhu != null)
    {
      this.jdField_a_of_type_Axhu.a(paramLong, paramInt1, paramInt2, paramInt3);
      this.jdField_a_of_type_Axhu.a(paramLong);
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131654259);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131654260);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void b()
  {
    this.leftView.setText(getResources().getString(2131627578));
    this.leftView.setBackgroundResource(2130849303);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130839691);
    this.rightViewImg.setOnClickListener(this);
    this.centerView.setMaxEms(13);
    this.centerView.setText(getResources().getString(2131627576));
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
    if ((this.jdField_a_of_type_Bafb == null) || (this.jdField_a_of_type_Bafb.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bafb.dismiss();
      this.jdField_a_of_type_Bafb = null;
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
    String str2 = getString(2131629116);
    if ((this.jdField_a_of_type_Int == 1) || ((paramPadInfo.creatorUin > 0L) && (this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin))))) {
      if (paramPadInfo.type == 1)
      {
        str1 = getString(2131625941);
        str2 = getString(2131625925);
        if ((paramPadInfo.creatorUin <= 0L) || (!this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin)))) {
          break label258;
        }
        this.jdField_a_of_type_Bafb = babr.a(this, 230, null, str1, getString(2131625945), getString(2131625035), str2, new axhw(this), new axhx(this, paramPadInfo), new axhy(this));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bafb.show();
      return;
      str1 = getString(2131625943);
      str2 = getString(2131625925);
      break;
      if (!azlj.a(this.app, this.jdField_a_of_type_Long, this.app.getCurrentAccountUin())) {
        break;
      }
      if (paramPadInfo.type == 1)
      {
        str1 = getString(2131625940);
        str2 = getString(2131625925);
        break;
      }
      str1 = getString(2131625942);
      str2 = getString(2131625925);
      break;
      label258:
      this.jdField_a_of_type_Bafb = babr.a(this, 230).setMessage(str1);
      this.jdField_a_of_type_Bafb.setPositiveButton(str2, new axhz(this, paramPadInfo));
      this.jdField_a_of_type_Bafb.setNegativeButton(getString(2131625035), new axia(this));
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
        localIntent.putExtra(axdz.a, str2);
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
    setContentView(2131493561);
    this.jdField_a_of_type_Long = getIntent().getLongExtra(axdz.e, 0L);
    this.jdField_a_of_type_Axhu = ((axhu)this.app.a(143));
    this.jdField_a_of_type_Axil = ((axil)this.app.getManager(304));
    this.jdField_a_of_type_Axfb = ((axfb)this.app.a(122));
    this.jdField_a_of_type_Axff = ((axff)this.app.getManager(283));
    this.jdField_a_of_type_Axhs = new axhs(this.app, this, this, null);
    a();
    this.app.addObserver(this.jdField_a_of_type_Axim);
    this.app.addObserver(this.jdField_a_of_type_Axfi);
    paramBundle = (TroopManager)this.app.getManager(52);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.b(String.valueOf(this.jdField_a_of_type_Long));
      if (paramBundle != null) {
        this.jdField_b_of_type_Long = paramBundle.dwGroupClassExt;
      }
    }
    b(1);
    ((arom)this.app.getManager(37)).a(this.app.getApp(), String.valueOf(this.jdField_a_of_type_Long), "TIM_GROUP_TM_REDDOT", false);
    ((axhu)this.app.a(143)).b(this.jdField_a_of_type_Long);
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Axhs);
    this.jdField_a_of_type_Axhs.a(new axhv(this));
    this.jdField_a_of_type_Axhs.b(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Axhp = new axhp(this, this);
    c(1);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Axhp);
    this.jdField_a_of_type_Axhp.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_Axhp.notifyDataSetChanged();
    this.jdField_a_of_type_Axhp.a(new axid(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Agzz != null) {
      this.jdField_a_of_type_Agzz.a();
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(114);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(111);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(112);
    }
    babl.a(this.app.getCurrentAccountUin(), "group_file_inner_reddot_tim", String.valueOf(this.jdField_a_of_type_Long), false);
    this.app.removeObserver(this.jdField_a_of_type_Axim);
    this.app.removeObserver(this.jdField_a_of_type_Axfi);
    c();
    if (this.jdField_a_of_type_Axhp != null) {
      this.jdField_a_of_type_Axhp = null;
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Agzz != null) {
      this.jdField_a_of_type_Agzz.a();
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
      if (this.jdField_a_of_type_Axhs == null) {
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
          this.jdField_a_of_type_Axhs.b(this.jdField_a_of_type_JavaUtilList);
          if (i == 1)
          {
            if (this.jdField_a_of_type_Axhs.getCount() > 0)
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
        if (this.jdField_a_of_type_Axhs.getCount() > 0)
        {
          if (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0) {
            this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          }
          if (this.g.getVisibility() == 0) {
            this.g.setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLastVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getFirstVisiblePosition() + 1 >= this.jdField_a_of_type_Axhs.getCount()) {
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
      if (this.jdField_a_of_type_Axhp == null) {
        continue;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_Axhp.a(this.jdField_b_of_type_JavaUtilList);
        if (this.jdField_a_of_type_Axhp.getCount() <= 0) {
          continue;
        }
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
        return true;
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Agzz != null) {
      this.jdField_a_of_type_Agzz.a();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131302816: 
      do
      {
        return;
        axfs.a(this.app, "0X800993A");
      } while (this.jdField_a_of_type_Agzz == null);
      this.jdField_a_of_type_Agzz.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth() - getResources().getDimensionPixelSize(2131167526), getResources().getDimensionPixelSize(2131167523));
      return;
    }
    a(this.jdField_a_of_type_Long, 0, 20, 1);
    this.f.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
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
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Axhs != null) && (this.jdField_a_of_type_Axhs.getCount() > 0) && (this.jdField_c_of_type_Boolean) && (paramInt != 0))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity
 * JD-Core Version:    0.7.0.1
 */