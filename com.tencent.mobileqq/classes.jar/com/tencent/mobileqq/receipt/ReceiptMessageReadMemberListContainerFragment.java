package com.tencent.mobileqq.receipt;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import anxg;
import bahd;
import bahe;
import bahf;
import bahg;
import bahh;
import bahi;
import bahj;
import bahk;
import bahl;
import bglf;
import bics;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import nir;
import tencent.im.oidb.cmd0x985.oidb_0x985.GetReadListReq;
import tencent.im.oidb.cmd0x985.oidb_0x985.ReqBody;
import tencent.im.oidb.cmd0x985.oidb_0x985.UinInfo;
import tencent.im.oidb.cmd0x986.oidb_0x986.ReqBody;
import tencent.im.oidb.cmd0x986.oidb_0x986.UinInfo;

public class ReceiptMessageReadMemberListContainerFragment
  extends IphoneTitleBarFragment
{
  private long jdField_a_of_type_Long;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new bahh(this);
  private anxg jdField_a_of_type_Anxg = new bahd(this);
  private bahj jdField_a_of_type_Bahj;
  private bahk jdField_a_of_type_Bahk;
  private bics jdField_a_of_type_Bics = new bahg(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> jdField_a_of_type_JavaUtilArrayList;
  private Comparator<ReceiptMessageReadMemberListFragment.MemberInfo> jdField_a_of_type_JavaUtilComparator = new bahe(this);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> jdField_b_of_type_JavaUtilArrayList;
  private Comparator<ReceiptMessageReadMemberListFragment.MemberInfo> jdField_b_of_type_JavaUtilComparator = new bahf(this);
  private boolean jdField_b_of_type_Boolean;
  private long c;
  private long d;
  private long e;
  
  private long a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, QLog.getStackTraceString(paramString));
      }
    }
    return -1L;
  }
  
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> a(List<oidb_0x986.UinInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_0x986.UinInfo localUinInfo = (oidb_0x986.UinInfo)paramList.next();
      localArrayList.add(new ReceiptMessageReadMemberListFragment.MemberInfo(Long.toString(localUinInfo.uint64_uin.get()), "", localUinInfo.uint32_msg_read_time.get()));
    }
    return localArrayList;
  }
  
  private void a()
  {
    ThreadManager.post(new ReceiptMessageReadMemberListContainerFragment.1(this), 10, null, true);
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, "packAndSendTroopFetchReadMemberRequest with troopCode: " + this.jdField_a_of_type_Long + " startUin: " + paramLong);
    }
    oidb_0x986.ReqBody localReqBody = new oidb_0x986.ReqBody();
    localReqBody.uint32_msg_time.set((int)this.jdField_b_of_type_Long);
    localReqBody.uint64_group_code.set(this.jdField_a_of_type_Long);
    localReqBody.uint32_msg_seq.set((int)this.e);
    localReqBody.uint64_start_uin.set(paramLong);
    localReqBody.uint64_from_uin.set(this.c);
    nir.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new bahl(this), localReqBody.toByteArray(), "OidbSvc.0x986_1", 2438, 1);
  }
  
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> b(List<oidb_0x985.UinInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_0x985.UinInfo localUinInfo = (oidb_0x985.UinInfo)paramList.next();
      String str = Long.toString(localUinInfo.uint64_uin.get());
      if (!Long.toString(this.c).equals(str)) {
        localArrayList.add(new ReceiptMessageReadMemberListFragment.MemberInfo(str, localUinInfo.bytes_name.get().toStringUtf8(), localUinInfo.uint32_time.get()));
      }
    }
    return localArrayList;
  }
  
  private void b()
  {
    oidb_0x985.ReqBody localReqBody = new oidb_0x985.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    oidb_0x985.GetReadListReq localGetReadListReq = new oidb_0x985.GetReadListReq();
    localGetReadListReq.uint32_msg_seq.set((int)this.e);
    localGetReadListReq.uint64_conf_uin.set(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localGetReadListReq.uint64_from_uin.set(this.c);
    localReqBody.msg_get_read_list_req.set(localGetReadListReq);
    nir.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new bahi(this), localReqBody.toByteArray(), "OidbSvc.0x985", 2437, 0);
  }
  
  private void c()
  {
    ThreadManager.post(new ReceiptMessageReadMemberListContainerFragment.2(this), 8, null, true);
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    ReceiptMessageReadMemberListFragment.MemberInfo localMemberInfo;
    while (localIterator.hasNext())
    {
      localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)localIterator.next();
      localMemberInfo.b = bglf.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(this.jdField_a_of_type_Long), localMemberInfo.jdField_a_of_type_JavaLangString);
    }
    localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)localIterator.next();
      localMemberInfo.b = bglf.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(this.jdField_a_of_type_Long), localMemberInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Bahj.sendEmptyMessage(5);
  }
  
  private void e()
  {
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
    Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilComparator);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Bahk = new bahk(getChildFragmentManager(), null);
    Object localObject = getString(2131697721);
    String str = getString(2131697729);
    this.jdField_a_of_type_Bahk.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilArrayList, new String[] { localObject, str });
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_Bahk);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnselectColor(getResources().getColor(2131167074));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(String.format(getString(2131697711), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(String.format(getString(2131697712), new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) }));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_Bics);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(0);
    stopTitleProgress();
    localObject = new Intent();
    ((Intent)localObject).putExtra("ReceiptMessageReadMemberListContainerFragment.RESULT_KEY_READ_NUMBER", this.jdField_a_of_type_JavaUtilArrayList.size());
    getActivity().setResult(-1, (Intent)localObject);
  }
  
  private void g()
  {
    if (!isAdded()) {
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131697710, 0).a();
  }
  
  private void h()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.post(new ReceiptMessageReadMemberListContainerFragment.6(this), 8, null, false);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.mContentView.findViewById(2131380955));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)this.mContentView.findViewById(2131378188));
    setTitle(getString(2131697713));
    startTitleProgress();
  }
  
  public int getContentLayoutId()
  {
    return 2131558657;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getActivity().getAppInterface() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
      paramActivity = getArguments();
      this.jdField_a_of_type_Long = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_TROOP_CODE");
      this.jdField_b_of_type_Long = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_MSG_TIME");
      this.c = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_SENDER_UIN");
      this.jdField_a_of_type_Boolean = paramActivity.getBoolean("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_IS_SENDER");
      this.d = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_MSG_UNISEQ");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramActivity.getParcelable("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_SESSION_INFO"));
      this.e = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.extra_shmsgseq", -1L);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break label150;
      }
    }
    label150:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
      throw new IllegalStateException("Only allowed in main progress");
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_Bahj = new bahj(this, null);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment
 * JD-Core Version:    0.7.0.1
 */