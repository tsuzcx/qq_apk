package com.tencent.mobileqq.receipt;

import ahem;
import ahen;
import aheo;
import ahep;
import aheq;
import aher;
import ahes;
import ahet;
import aheu;
import ahev;
import ahey;
import ahez;
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
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x985.oidb_0x985.GetReadListReq;
import tencent.im.oidb.cmd0x985.oidb_0x985.ReqBody;
import tencent.im.oidb.cmd0x985.oidb_0x985.UinInfo;
import tencent.im.oidb.cmd0x986.oidb_0x986.ReqBody;
import tencent.im.oidb.cmd0x986.oidb_0x986.UinInfo;

public class ReceiptMessageReadMemberListContainerFragment
  extends IphoneTitleBarFragment
{
  private long jdField_a_of_type_Long;
  private ahev jdField_a_of_type_Ahev;
  private ahey jdField_a_of_type_Ahey;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new ahet(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new aheo(this);
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new ahes(this);
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private Comparator jdField_a_of_type_JavaUtilComparator = new ahep(this);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private Comparator jdField_b_of_type_JavaUtilComparator = new aheq(this);
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
  
  private ArrayList a(List paramList)
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
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, "packAndSendTroopFetchReadMemberRequest with troopCode: " + this.jdField_a_of_type_Long + " startUin: " + paramLong);
    }
    oidb_0x986.ReqBody localReqBody = new oidb_0x986.ReqBody();
    localReqBody.uint32_msg_time.set((int)this.jdField_b_of_type_Long);
    localReqBody.uint64_group_code.set(this.jdField_a_of_type_Long);
    localReqBody.uint32_msg_seq.set((int)this.jdField_e_of_type_Long);
    localReqBody.uint64_start_uin.set(paramLong);
    localReqBody.uint64_from_uin.set(this.c);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ahez(this), localReqBody.toByteArray(), "OidbSvc.0x986_1", 2438, 1);
  }
  
  private ArrayList b(List paramList)
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
    ThreadManager.post(new ahem(this), 10, null, true);
  }
  
  private void c()
  {
    oidb_0x985.ReqBody localReqBody = new oidb_0x985.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    oidb_0x985.GetReadListReq localGetReadListReq = new oidb_0x985.GetReadListReq();
    localGetReadListReq.uint32_msg_seq.set((int)this.jdField_e_of_type_Long);
    localGetReadListReq.uint64_conf_uin.set(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localGetReadListReq.uint64_from_uin.set(this.c);
    localReqBody.msg_get_read_list_req.set(localGetReadListReq);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aheu(this), localReqBody.toByteArray(), "OidbSvc.0x985", 2437, 0);
  }
  
  private void d()
  {
    ThreadManager.post(new ahen(this), 8, null, true);
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    ReceiptMessageReadMemberListFragment.MemberInfo localMemberInfo;
    while (localIterator.hasNext())
    {
      localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)localIterator.next();
      localMemberInfo.b = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(this.jdField_a_of_type_Long), localMemberInfo.jdField_a_of_type_JavaLangString);
    }
    localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)localIterator.next();
      localMemberInfo.b = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(this.jdField_a_of_type_Long), localMemberInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Ahev.sendEmptyMessage(5);
  }
  
  private void f()
  {
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
    Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilComparator);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Ahey = new ahey(getChildFragmentManager(), null);
    Object localObject = getString(2131438998);
    String str = getString(2131438999);
    this.jdField_a_of_type_Ahey.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilArrayList, new String[] { localObject, str });
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_Ahey);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnselectColor(getResources().getColor(2131494277));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(String.format(getString(2131438993), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(String.format(getString(2131438992), new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) }));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(0);
    h();
    localObject = new Intent();
    ((Intent)localObject).putExtra("ReceiptMessageReadMemberListContainerFragment.RESULT_KEY_READ_NUMBER", this.jdField_a_of_type_JavaUtilArrayList.size());
    getActivity().setResult(-1, (Intent)localObject);
  }
  
  private void h()
  {
    if (!isAdded()) {
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131438995, 0).a();
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.post(new aher(this), 8, null, false);
  }
  
  protected int a()
  {
    return 2130968671;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)this.jdField_e_of_type_AndroidViewView.findViewById(2131363114));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)this.jdField_e_of_type_AndroidViewView.findViewById(2131363113));
    a(getString(2131438994));
    g();
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
      this.jdField_e_of_type_Long = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.extra_shmsgseq", -1L);
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
    this.jdField_a_of_type_Ahev = new ahev(this, null);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment
 * JD-Core Version:    0.7.0.1
 */