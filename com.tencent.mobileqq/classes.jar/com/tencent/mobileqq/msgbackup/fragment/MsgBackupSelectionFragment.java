package com.tencent.mobileqq.msgbackup.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class MsgBackupSelectionFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MsgBackupManager jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager;
  private MsgBackupListAdapter.OnItemCheckedChangeListener jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter$OnItemCheckedChangeListener = new MsgBackupSelectionFragment.3(this);
  private MsgBackupListAdapter jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter;
  private String jdField_a_of_type_JavaLangString;
  protected List<RecentBaseData> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1000;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private final int jdField_c_of_type_Int = 10000;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  
  public MsgBackupSelectionFragment()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    Bundle localBundle = getArguments();
    this.jdField_a_of_type_Int = localBundle.getInt("backup_select_from", 0);
    this.jdField_c_of_type_JavaLangString = localBundle.getString("0x11bpush_extra");
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "handlerArg, mFrom = " + this.jdField_a_of_type_Int);
    }
  }
  
  private void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt > 0) {
      localStringBuilder.append(getString(2131690629, new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Long != 0L))
    {
      if (paramInt > 0) {
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(getString(2131690619, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
    }
    if (this.jdField_b_of_type_Int == 2) {
      localStringBuilder.append("\n").append(getString(2131690609));
    }
    if (localStringBuilder.length() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
    }
    while (paramInt > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      if (paramInt == this.jdField_a_of_type_JavaUtilList.size())
      {
        this.jdField_a_of_type_Boolean = true;
        a(this.jdField_b_of_type_AndroidWidgetTextView, 2131690655);
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
        a(this.jdField_b_of_type_AndroidWidgetTextView, 2131690637);
        return;
      }
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_Boolean = false;
    a(this.jdField_b_of_type_AndroidWidgetTextView, 2131690637);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt > 0) {
      localStringBuilder.append(getString(2131690629, new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Long != 0L))
    {
      if (paramInt > 0) {
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(getString(2131690619, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
    }
    if (this.jdField_b_of_type_Int == 2) {
      localStringBuilder.append("\n").append(getString(2131690609));
    }
    if (localStringBuilder.length() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
    }
    while (paramBoolean)
    {
      a(this.jdField_b_of_type_AndroidWidgetTextView, 2131690655);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    a(this.jdField_b_of_type_AndroidWidgetTextView, 2131690637);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if (paramTextView != null)
    {
      paramTextView.setText(paramInt);
      if (AppSetting.d) {
        paramTextView.setContentDescription(getString(paramInt));
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager = MsgBackupManager.a();
  }
  
  private void c()
  {
    MsgBackupManager.a().a.clear();
    MsgBackupManager.a().a(new MsgBackupSelectionFragment.1(this));
    MsgBackupManager.a().n();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131363771));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131377707));
    a(this.jdField_a_of_type_AndroidWidgetButton, 2131690637);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365572));
    a(this.jdField_c_of_type_AndroidWidgetTextView, 2131690638);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131377729));
    a(this.jdField_a_of_type_AndroidWidgetButton, 2131690628);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131371409));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131371405));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter = new MsgBackupListAdapter(getActivity(), getActivity().app, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter$OnItemCheckedChangeListener);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131366349);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131370713);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.vg.setOnItemSelectListener(new MsgBackupSelectionFragment.2(this));
  }
  
  private void e()
  {
    ViewUtils.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, 0);
    ViewUtils.b(this.jdField_b_of_type_AndroidViewView, 8);
    ViewUtils.b(this.jdField_a_of_type_AndroidViewView, 8);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      h();
      if (this.jdField_a_of_type_Int == 0) {
        MsgBackupReporter.a("0X800A233", 2);
      }
    }
    do
    {
      do
      {
        return;
      } while (!MsgBackupManager.c);
      MsgBackupReporter.a("0X800A258", 2);
      return;
      g();
      if (this.jdField_a_of_type_Int == 0)
      {
        MsgBackupReporter.a("0X800A233", 1);
        return;
      }
    } while (!MsgBackupManager.c);
    MsgBackupReporter.a("0X800A258", 1);
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        a(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_Boolean);
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        MsgBackupManager.a().a.add(localRecentBaseData);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.b();
  }
  
  private void h()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      a(0, this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.c();
      MsgBackupManager.a().c();
      return;
    }
  }
  
  private void i()
  {
    int m = 3;
    int k = 2;
    Object localObject = MsgBackupManager.a().a.iterator();
    int i = 0;
    int j = i;
    if (((Iterator)localObject).hasNext())
    {
      if (!UinTypeUtil.b(((RecentBaseData)((Iterator)localObject).next()).getRecentUserType())) {
        break label135;
      }
      if (i == 2) {
        j = 3;
      }
    }
    else
    {
      i = m;
      if (this.jdField_a_of_type_Long != 0L)
      {
        i = m;
        if (this.jdField_b_of_type_Long != 0L) {
          i = 1;
        }
      }
      if (this.jdField_b_of_type_Int != 2) {
        break label169;
      }
      if (i != 1) {
        break label150;
      }
      i = k;
    }
    label135:
    label150:
    label169:
    for (;;)
    {
      label97:
      localObject = "";
      if (this.jdField_a_of_type_Int == 0) {
        localObject = "0X800A238";
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          MsgBackupReporter.a((String)localObject, j, i);
        }
        return;
        i = 1;
        for (;;)
        {
          break;
          if (i == 1) {
            i = 3;
          } else {
            i = 2;
          }
        }
        i = 4;
        break label97;
        if (MsgBackupManager.c) {
          localObject = "0X800A25D";
        }
      }
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    a();
    b();
    d();
    c();
    MsgBackupManager.a().c();
  }
  
  public int getContentLayoutId()
  {
    return 2131561596;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    e();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.notifyDataSetChanged();
      return false;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == 0)) {
      if (paramIntent != null)
      {
        this.jdField_a_of_type_Long = paramIntent.getLongExtra("session_start_time", 0L);
        this.jdField_b_of_type_Long = paramIntent.getLongExtra("session_end_time", 0L);
        this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("session_start_time_str");
        this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("session_end_time_str");
        this.jdField_b_of_type_Int = paramIntent.getIntExtra("session_content_type", 1);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "onActivityResult startTime = " + this.jdField_a_of_type_Long + ", endTime = " + this.jdField_b_of_type_Long + ", mCurContentType = " + this.jdField_b_of_type_Int + ", startTimeShow = " + this.jdField_a_of_type_JavaLangString + ", endTimeShow = " + this.jdField_b_of_type_JavaLangString);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager.a.size());
      }
    }
    while ((1000 != paramInt1) || (paramInt2 != 1001)) {
      return;
    }
    if (getActivity() != null) {
      getActivity().setResult(1001);
    }
    onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131377707: 
    case 2131365572: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        f();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "date_select startTime = " + this.jdField_a_of_type_Long + ", endTime = " + this.jdField_b_of_type_Long + ", mCurContentType = " + this.jdField_b_of_type_Int + ", startTimeShow = " + this.jdField_a_of_type_JavaLangString + ", endTimeShow = " + this.jdField_b_of_type_JavaLangString);
        }
        localIntent = new Intent();
        localIntent.putExtra("session_start_time", this.jdField_a_of_type_Long);
        localIntent.putExtra("session_end_time", this.jdField_b_of_type_Long);
        localIntent.putExtra("session_start_time_str", this.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("session_end_time_str", this.jdField_b_of_type_JavaLangString);
        localIntent.putExtra("session_content_type", this.jdField_b_of_type_Int);
        localIntent.putExtra("backup_select_from", this.jdField_a_of_type_Int);
        PublicFragmentActivity.a(getActivity(), localIntent, MsgBackupDateFragment.class, 1000);
      }
    }
    MsgBackupManager.jdField_b_of_type_Int = MsgBackupManager.a().a.size();
    MsgBackupReporter.a();
    MsgBackupReporter.a.jdField_b_of_type_Long = MsgBackupManager.jdField_b_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "select session detail, sessionCount = " + MsgBackupManager.jdField_b_of_type_Int);
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("session_start_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("session_end_time", this.jdField_b_of_type_Long);
    localIntent.putExtra("session_content_type", this.jdField_b_of_type_Int);
    boolean bool;
    if (this.jdField_a_of_type_Int == 0)
    {
      bool = NetworkUtil.a(BaseApplication.getContext());
      localIntent.putExtra("session_net_status", bool);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "onClick!!! TYPE_TO_OTHER_DEVICE isNetEnable = " + bool);
      }
      if (bool)
      {
        MsgBackupManager.a().a(false);
        label407:
        PublicFragmentActivity.a(getActivity(), localIntent, MsgBackupQRFragment.class, 1000);
      }
    }
    for (;;)
    {
      i();
      break;
      if (!QLog.isColorLevel()) {
        break label407;
      }
      QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "onClick!!! TYPE_TO_OTHER_DEVICE net enable status = " + bool);
      break label407;
      if (this.jdField_a_of_type_Int == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "onClick!!! TYPE_TO_PC");
        }
        localIntent.putExtra("0x11bpush_extra", this.jdField_c_of_type_JavaLangString);
        localIntent.putExtra("param_start", 2);
        PublicFragmentActivity.a(getActivity(), localIntent, MsgBackupPCTransportFragment.class, 1000);
      }
    }
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131690639));
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.d();
    }
    MsgBackupManager.a().a(null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment
 * JD-Core Version:    0.7.0.1
 */