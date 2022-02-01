package com.tencent.mobileqq.msgbackup.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
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
  extends QIphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private MsgBackupManager jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager;
  private MsgBackupListAdapter.OnItemCheckedChangeListener jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter$OnItemCheckedChangeListener = new MsgBackupSelectionFragment.3(this);
  private MsgBackupListAdapter jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter;
  private String jdField_a_of_type_JavaLangString;
  protected List<RecentBaseData> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1000;
  private long jdField_b_of_type_Long = 0L;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private String jdField_b_of_type_JavaLangString;
  private final int jdField_c_of_type_Int = 10000;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private View d;
  private TextView g;
  private TextView h;
  private TextView i;
  
  public MsgBackupSelectionFragment()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    Object localObject = getArguments();
    this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("backup_select_from", 0);
    this.jdField_c_of_type_JavaLangString = ((Bundle)localObject).getString("0x11bpush_extra");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlerArg, mFrom = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt > 0) {
      localStringBuilder.append(getString(2131690557, new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Long != 0L))
    {
      if (paramInt > 0) {
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(getString(2131690547, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      localStringBuilder.append("\n");
      localStringBuilder.append(getString(2131690537));
    }
    if (localStringBuilder.length() > 0)
    {
      this.g.setVisibility(0);
      this.g.setText(localStringBuilder.toString());
    }
    else
    {
      this.g.setVisibility(8);
    }
    if (paramInt > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      if (paramInt == this.jdField_a_of_type_JavaUtilList.size())
      {
        this.jdField_a_of_type_Boolean = true;
        b(this.h, 2131690583);
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      b(this.h, 2131690565);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_Boolean = false;
    b(this.h, 2131690565);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt > 0) {
      localStringBuilder.append(getString(2131690557, new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Long != 0L))
    {
      if (paramInt > 0) {
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(getString(2131690547, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      localStringBuilder.append("\n");
      localStringBuilder.append(getString(2131690537));
    }
    if (localStringBuilder.length() > 0)
    {
      this.g.setVisibility(0);
      this.g.setText(localStringBuilder.toString());
    }
    else
    {
      this.g.setVisibility(8);
    }
    if (paramBoolean)
    {
      b(this.h, 2131690583);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    b(this.h, 2131690565);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  private void b(TextView paramTextView, int paramInt)
  {
    if (paramTextView != null)
    {
      paramTextView.setText(paramInt);
      if (AppSetting.d) {
        paramTextView.setContentDescription(getString(paramInt));
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager = MsgBackupManager.a();
  }
  
  private void d()
  {
    MsgBackupManager.a().a.clear();
    MsgBackupManager.a().a(new MsgBackupSelectionFragment.1(this));
    MsgBackupManager.a().n();
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131363700));
    this.h = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377135));
    b(this.jdField_a_of_type_AndroidWidgetButton, 2131690565);
    this.i = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365415));
    b(this.i, 2131690566);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131377157));
    b(this.jdField_a_of_type_AndroidWidgetButton, 2131690556);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.g = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371031));
    this.g.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371027));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter = new MsgBackupListAdapter(getActivity(), (BaseQQAppInterface)getQBaseActivity().getAppRuntime(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter$OnItemCheckedChangeListener);
    this.d = this.jdField_b_of_type_AndroidViewView.findViewById(2131366237);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370350);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(new MsgBackupSelectionFragment.2(this));
  }
  
  private void f()
  {
    ViewUtils.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, 0);
    ViewUtils.b(this.d, 8);
    ViewUtils.b(this.jdField_c_of_type_AndroidViewView, 8);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      i();
      if (this.jdField_a_of_type_Int == 0)
      {
        MsgBackupReporter.a("0X800A233", 2);
        return;
      }
      if (MsgBackupManager.jdField_c_of_type_Boolean) {
        MsgBackupReporter.a("0X800A258", 2);
      }
    }
    else
    {
      h();
      if (this.jdField_a_of_type_Int == 0)
      {
        MsgBackupReporter.a("0X800A233", 1);
        return;
      }
      if (MsgBackupManager.jdField_c_of_type_Boolean) {
        MsgBackupReporter.a("0X800A258", 1);
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_Boolean ^= true;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      a(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_Boolean);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
      MsgBackupManager.a().a.add(localRecentBaseData);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.b();
  }
  
  private void i()
  {
    this.jdField_a_of_type_Boolean ^= true;
    a(0, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.c();
    MsgBackupManager.a().c();
  }
  
  private void j()
  {
    Object localObject = MsgBackupManager.a().a.iterator();
    int j = 0;
    int n;
    int m;
    int k;
    for (;;)
    {
      boolean bool = ((Iterator)localObject).hasNext();
      n = 3;
      m = 2;
      k = j;
      if (!bool) {
        break;
      }
      if (UinTypeUtil.b(((RecentBaseData)((Iterator)localObject).next()).getRecentUserType()))
      {
        if (j == 2)
        {
          k = 3;
          break;
        }
        j = 1;
      }
      else if (j == 1)
      {
        j = 3;
      }
      else
      {
        j = 2;
      }
    }
    j = n;
    if (this.jdField_a_of_type_Long != 0L)
    {
      j = n;
      if (this.jdField_b_of_type_Long != 0L) {
        j = 1;
      }
    }
    if (this.jdField_b_of_type_Int == 2) {
      if (j == 1) {
        j = m;
      } else {
        j = 4;
      }
    }
    if (this.jdField_a_of_type_Int == 0) {
      localObject = "0X800A238";
    } else if (MsgBackupManager.jdField_c_of_type_Boolean) {
      localObject = "0X800A25D";
    } else {
      localObject = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      MsgBackupReporter.a((String)localObject, k, j);
    }
  }
  
  protected int a()
  {
    return 2131561438;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    a();
    c();
    e();
    d();
    MsgBackupManager.a().c();
  }
  
  protected View d()
  {
    View localView = super.d();
    a(getActivity().getString(2131690567));
    return localView;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 10000) {
      return false;
    }
    f();
    paramMessage = this.jdField_a_of_type_JavaUtilList;
    if ((paramMessage != null) && (paramMessage.size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.notifyDataSetChanged();
      return false;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(4);
    this.i.setEnabled(false);
    this.h.setEnabled(false);
    this.d.setVisibility(0);
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == 0))
    {
      if (paramIntent != null)
      {
        this.jdField_a_of_type_Long = paramIntent.getLongExtra("session_start_time", 0L);
        this.jdField_b_of_type_Long = paramIntent.getLongExtra("session_end_time", 0L);
        this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("session_start_time_str");
        this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("session_end_time_str");
        this.jdField_b_of_type_Int = paramIntent.getIntExtra("session_content_type", 1);
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("onActivityResult startTime = ");
          paramIntent.append(this.jdField_a_of_type_Long);
          paramIntent.append(", endTime = ");
          paramIntent.append(this.jdField_b_of_type_Long);
          paramIntent.append(", mCurContentType = ");
          paramIntent.append(this.jdField_b_of_type_Int);
          paramIntent.append(", startTimeShow = ");
          paramIntent.append(this.jdField_a_of_type_JavaLangString);
          paramIntent.append(", endTimeShow = ");
          paramIntent.append(this.jdField_b_of_type_JavaLangString);
          QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, paramIntent.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager.a.size());
      }
    }
    else if ((1000 == paramInt1) && (paramInt2 == 1001))
    {
      if (getActivity() != null) {
        getActivity().setResult(1001);
      }
      onBackEvent();
    }
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j == 2131377135)
    {
      g();
    }
    else
    {
      Object localObject;
      if (j == 2131365415)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("date_select startTime = ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
          ((StringBuilder)localObject).append(", endTime = ");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
          ((StringBuilder)localObject).append(", mCurContentType = ");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
          ((StringBuilder)localObject).append(", startTimeShow = ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(", endTimeShow = ");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
          QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("session_start_time", this.jdField_a_of_type_Long);
        ((Intent)localObject).putExtra("session_end_time", this.jdField_b_of_type_Long);
        ((Intent)localObject).putExtra("session_start_time_str", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("session_end_time_str", this.jdField_b_of_type_JavaLangString);
        ((Intent)localObject).putExtra("session_content_type", this.jdField_b_of_type_Int);
        ((Intent)localObject).putExtra("backup_select_from", this.jdField_a_of_type_Int);
        QPublicFragmentActivity.startForResult(getActivity(), (Intent)localObject, MsgBackupDateFragment.class, 1000);
      }
      else if (j == 2131377157)
      {
        MsgBackupManager.jdField_b_of_type_Int = MsgBackupManager.a().a.size();
        MsgBackupReporter.a();
        MsgBackupReporter.a.jdField_b_of_type_Long = MsgBackupManager.jdField_b_of_type_Int;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("select session detail, sessionCount = ");
          ((StringBuilder)localObject).append(MsgBackupManager.jdField_b_of_type_Int);
          QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("session_start_time", this.jdField_a_of_type_Long);
        ((Intent)localObject).putExtra("session_end_time", this.jdField_b_of_type_Long);
        ((Intent)localObject).putExtra("session_content_type", this.jdField_b_of_type_Int);
        j = this.jdField_a_of_type_Int;
        if (j == 0)
        {
          boolean bool = NetworkUtil.isWifiEnabled(BaseApplication.getContext());
          ((Intent)localObject).putExtra("session_net_status", bool);
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onClick!!! TYPE_TO_OTHER_DEVICE isNetEnable = ");
            localStringBuilder.append(bool);
            QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, localStringBuilder.toString());
          }
          if (bool)
          {
            MsgBackupManager.a().a(false);
          }
          else if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onClick!!! TYPE_TO_OTHER_DEVICE net enable status = ");
            localStringBuilder.append(bool);
            QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, localStringBuilder.toString());
          }
          QPublicFragmentActivity.startForResult(getActivity(), (Intent)localObject, MsgBackupQRFragment.class, 1000);
        }
        else if (j == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "onClick!!! TYPE_TO_PC");
          }
          ((Intent)localObject).putExtra("0x11bpush_extra", this.jdField_c_of_type_JavaLangString);
          ((Intent)localObject).putExtra("param_start", 2);
          QPublicFragmentActivity.startForResult(getActivity(), (Intent)localObject, MsgBackupPCTransportFragment.class, 1000);
        }
        j();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    MsgBackupManager.a().a(null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupFragmentMsgBackupListAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment
 * JD-Core Version:    0.7.0.1
 */