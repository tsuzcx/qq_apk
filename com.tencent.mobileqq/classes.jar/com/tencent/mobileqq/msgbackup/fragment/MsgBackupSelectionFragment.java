package com.tencent.mobileqq.msgbackup.fragment;

import adak;
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
import axgj;
import axhw;
import axhy;
import axij;
import axik;
import axil;
import axjk;
import bhnv;
import bhtq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
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
  private long jdField_a_of_type_Long;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private axgj jdField_a_of_type_Axgj;
  private axhw jdField_a_of_type_Axhw;
  private axhy jdField_a_of_type_Axhy = new axil(this);
  private String jdField_a_of_type_JavaLangString;
  public List<RecentBaseData> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1000;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
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
      localStringBuilder.append(getString(2131690412, new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Long != 0L))
    {
      if (paramInt > 0) {
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(getString(2131690402, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
    }
    if (this.jdField_b_of_type_Int == 2) {
      localStringBuilder.append("\n").append(getString(2131690392));
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
        a(this.jdField_b_of_type_AndroidWidgetTextView, 2131690438);
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
        a(this.jdField_b_of_type_AndroidWidgetTextView, 2131690420);
        return;
      }
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_Boolean = false;
    a(this.jdField_b_of_type_AndroidWidgetTextView, 2131690420);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt > 0) {
      localStringBuilder.append(getString(2131690412, new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Long != 0L))
    {
      if (paramInt > 0) {
        localStringBuilder.append("\n");
      }
      localStringBuilder.append(getString(2131690402, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
    }
    if (this.jdField_b_of_type_Int == 2) {
      localStringBuilder.append("\n").append(getString(2131690392));
    }
    if (localStringBuilder.length() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
    }
    while (paramBoolean)
    {
      a(this.jdField_b_of_type_AndroidWidgetTextView, 2131690438);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    a(this.jdField_b_of_type_AndroidWidgetTextView, 2131690420);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if (paramTextView != null)
    {
      paramTextView.setText(paramInt);
      if (AppSetting.c) {
        paramTextView.setContentDescription(getString(paramInt));
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Axgj = axgj.a();
  }
  
  private void c()
  {
    axgj.a().a.clear();
    axgj.a().a(new axij(this));
    axgj.a().n();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131363580));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131377263));
    a(this.jdField_a_of_type_AndroidWidgetButton, 2131690420);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365284));
    a(this.jdField_c_of_type_AndroidWidgetTextView, 2131690421);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131377285));
    a(this.jdField_a_of_type_AndroidWidgetButton, 2131690411);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131370978));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131370974));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Axhw = new axhw(getActivity(), getActivity().app, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Axhw);
    this.jdField_a_of_type_Axhw.a(this.jdField_a_of_type_Axhy);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131366047);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131370289);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.vg.setOnItemSelectListener(new axik(this));
  }
  
  private void e()
  {
    bhtq.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, 0);
    bhtq.b(this.jdField_b_of_type_AndroidViewView, 8);
    bhtq.b(this.jdField_a_of_type_AndroidViewView, 8);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      h();
      if (this.jdField_a_of_type_Int == 0) {
        axjk.a("0X800A233", 2);
      }
    }
    do
    {
      do
      {
        return;
      } while (!axgj.c);
      axjk.a("0X800A258", 2);
      return;
      g();
      if (this.jdField_a_of_type_Int == 0)
      {
        axjk.a("0X800A233", 1);
        return;
      }
    } while (!axgj.c);
    axjk.a("0X800A258", 1);
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
        axgj.a().a.add(localRecentBaseData);
      }
    }
    this.jdField_a_of_type_Axhw.b();
  }
  
  private void h()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      a(0, this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Axhw.c();
      axgj.a().c();
      return;
    }
  }
  
  private void i()
  {
    int m = 3;
    int k = 2;
    Object localObject = axgj.a().a.iterator();
    int i = 0;
    int j = i;
    if (((Iterator)localObject).hasNext())
    {
      if (!adak.d(((RecentBaseData)((Iterator)localObject).next()).getRecentUserType())) {
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
          axjk.a((String)localObject, j, i);
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
        if (axgj.c) {
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
    axgj.a().c();
  }
  
  public int getContentLayoutId()
  {
    return 2131561546;
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
      this.jdField_a_of_type_Axhw.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Axhw.a();
      this.jdField_a_of_type_Axhw.notifyDataSetChanged();
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
        a(this.jdField_a_of_type_Axgj.a.size());
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
    case 2131377263: 
    case 2131365284: 
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
    axgj.jdField_b_of_type_Int = axgj.a().a.size();
    axjk.a();
    axjk.a.jdField_b_of_type_Long = axgj.jdField_b_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "select session detail, sessionCount = " + axgj.jdField_b_of_type_Int);
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("session_start_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("session_end_time", this.jdField_b_of_type_Long);
    localIntent.putExtra("session_content_type", this.jdField_b_of_type_Int);
    boolean bool;
    if (this.jdField_a_of_type_Int == 0)
    {
      bool = bhnv.a(BaseApplication.getContext());
      localIntent.putExtra("session_net_status", bool);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupSelectionFragment", 2, "onClick!!! TYPE_TO_OTHER_DEVICE isNetEnable = " + bool);
      }
      if (bool)
      {
        axgj.a().a(false);
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
    setTitle(getActivity().getString(2131690422));
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Axhw != null) {
      this.jdField_a_of_type_Axhw.d();
    }
    axgj.a().a(null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Axhw.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment
 * JD-Core Version:    0.7.0.1
 */