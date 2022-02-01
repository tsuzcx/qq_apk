package com.tencent.mobileqq.receipt;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
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
  private QQViewPager a;
  private TabBarView b;
  private ReceiptMessageReadMemberListContainerFragment.MemberListTabAdapter c;
  private ReceiptMessageReadMemberListContainerFragment.ListProcessHandler d;
  private QQAppInterface e;
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> f;
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> g;
  private long h;
  private long i;
  private long j;
  private boolean k;
  private long l;
  private long m;
  private SessionInfo n;
  private boolean o;
  private TroopObserver p = new ReceiptMessageReadMemberListContainerFragment.3(this);
  private Comparator<ReceiptMessageReadMemberListFragment.MemberInfo> q = new ReceiptMessageReadMemberListContainerFragment.4(this);
  private Comparator<ReceiptMessageReadMemberListFragment.MemberInfo> r = new ReceiptMessageReadMemberListContainerFragment.5(this);
  private TabBarView.OnTabChangeListener s = new ReceiptMessageReadMemberListContainerFragment.7(this);
  private ViewPager.OnPageChangeListener t = new ReceiptMessageReadMemberListContainerFragment.8(this);
  
  private long a(String paramString)
  {
    try
    {
      long l1 = Long.parseLong(paramString);
      return l1;
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("packAndSendTroopFetchReadMemberRequest with troopCode: ");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append(" startUin: ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x986.ReqBody();
    ((oidb_0x986.ReqBody)localObject).uint32_msg_time.set((int)this.i);
    ((oidb_0x986.ReqBody)localObject).uint64_group_code.set(this.h);
    ((oidb_0x986.ReqBody)localObject).uint32_msg_seq.set((int)this.m);
    ((oidb_0x986.ReqBody)localObject).uint64_start_uin.set(paramLong);
    ((oidb_0x986.ReqBody)localObject).uint64_from_uin.set(this.j);
    ProtoUtils.a(this.e, new ReceiptMessageReadMemberListContainerFragment.TroopFetchReadMemberListCallback(this), ((oidb_0x986.ReqBody)localObject).toByteArray(), "OidbSvc.0x986_1", 2438, 1);
  }
  
  private ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> b(List<oidb_0x985.UinInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_0x985.UinInfo localUinInfo = (oidb_0x985.UinInfo)paramList.next();
      String str = Long.toString(localUinInfo.uint64_uin.get());
      if (!Long.toString(this.j).equals(str)) {
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
    localGetReadListReq.uint32_msg_seq.set((int)this.m);
    localGetReadListReq.uint64_conf_uin.set(a(this.n.b));
    localGetReadListReq.uint64_from_uin.set(this.j);
    localReqBody.msg_get_read_list_req.set(localGetReadListReq);
    ProtoUtils.a(this.e, new ReceiptMessageReadMemberListContainerFragment.DiscussionFetchReadStatusCallback(this), localReqBody.toByteArray(), "OidbSvc.0x985", 2437, 0);
  }
  
  private void c()
  {
    ThreadManager.post(new ReceiptMessageReadMemberListContainerFragment.2(this), 8, null, true);
  }
  
  private void d()
  {
    Iterator localIterator = this.f.iterator();
    ReceiptMessageReadMemberListFragment.MemberInfo localMemberInfo;
    while (localIterator.hasNext())
    {
      localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)localIterator.next();
      localMemberInfo.b = ContactUtils.b(this.e, Long.toString(this.h), localMemberInfo.a);
    }
    localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)localIterator.next();
      localMemberInfo.b = ContactUtils.b(this.e, Long.toString(this.h), localMemberInfo.a);
    }
    this.d.sendEmptyMessage(5);
  }
  
  private void e()
  {
    Collections.sort(this.f, this.q);
    Collections.sort(this.g, this.r);
  }
  
  private void f()
  {
    this.c = new ReceiptMessageReadMemberListContainerFragment.MemberListTabAdapter(getChildFragmentManager(), null);
    Object localObject = getString(2131896524);
    String str = getString(2131896532);
    this.c.a(this.f, this.g, new String[] { localObject, str });
    this.a.setAdapter(this.c);
    this.b.setUnselectColor(getResources().getColor(2131168133));
    this.b.a(String.format(getString(2131896514), new Object[] { Integer.valueOf(this.f.size()) }));
    this.b.a(String.format(getString(2131896515), new Object[] { Integer.valueOf(this.g.size()) }));
    this.b.setSelectedTab(0, false);
    this.b.setOnTabChangeListener(this.s);
    this.a.requestParentDisallowInterecptTouchEvent(true);
    this.a.setOnPageChangeListener(this.t);
    this.a.setVisibility(0);
    this.b.setVisibility(0);
    stopTitleProgress();
    localObject = new Intent();
    ((Intent)localObject).putExtra("ReceiptMessageReadMemberListContainerFragment.RESULT_KEY_READ_NUMBER", this.f.size());
    getBaseActivity().setResult(-1, (Intent)localObject);
  }
  
  private void g()
  {
    if (!isAdded()) {
      return;
    }
    QQToast.makeText(this.e.getApp(), 1, 2131896513, 0).show();
  }
  
  private void h()
  {
    if (!this.k) {
      return;
    }
    ThreadManager.post(new ReceiptMessageReadMemberListContainerFragment.6(this), 8, null, false);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = ((QQViewPager)this.mContentView.findViewById(2131449896));
    this.b = ((TabBarView)this.mContentView.findViewById(2131446735));
    setTitle(getString(2131896516));
    startTitleProgress();
  }
  
  protected int getContentLayoutId()
  {
    return 2131624157;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getBaseActivity().getAppInterface() instanceof QQAppInterface))
    {
      this.e = ((QQAppInterface)getBaseActivity().getAppInterface());
      paramActivity = getArguments();
      this.h = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_TROOP_CODE");
      this.i = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_MSG_TIME");
      this.j = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_SENDER_UIN");
      this.k = paramActivity.getBoolean("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_IS_SENDER");
      this.l = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_MSG_UNISEQ");
      this.n = ((SessionInfo)paramActivity.getParcelable("ReceiptMessageReadMemberListContainerFragment.EXTRA_KEY_SESSION_INFO"));
      this.m = paramActivity.getLong("ReceiptMessageReadMemberListContainerFragment.extra_shmsgseq", -1L);
      int i1 = this.n.a;
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      this.o = bool;
      return;
    }
    throw new IllegalStateException("Only allowed in main progress");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.e.removeObserver(this.p);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.d = new ReceiptMessageReadMemberListContainerFragment.ListProcessHandler(this, null);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment
 * JD-Core Version:    0.7.0.1
 */