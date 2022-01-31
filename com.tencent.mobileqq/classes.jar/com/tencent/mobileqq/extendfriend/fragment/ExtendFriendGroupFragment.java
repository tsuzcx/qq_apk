package com.tencent.mobileqq.extendfriend.fragment;

import achy;
import achz;
import acia;
import acib;
import acic;
import acik;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.bean.GroupInfo;
import com.tencent.mobileqq.extendfriend.pulltorefresh.ILoadingLayout;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.OnRefreshListener2;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExtendFriendGroupFragment
  extends Fragment
  implements GroupItemClickListeneer, PullToRefreshBase.OnRefreshListener2
{
  private static acic jdField_a_of_type_Acic;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private acik jdField_a_of_type_Acik;
  public Drawable a;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  public StaggeredGridLayoutManager a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new achz(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendFriendHandler jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendHandler;
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendObserver = new achy(this);
  private PullToRefreshRecyclerView jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public ExtendFriendGroupFragment()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt, paramString, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "刷新成功 (｡･∀･)ﾉﾞ";; str = "嘤嘤嘤刷新失败了(/▽＼)")
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false).setRefreshResultLabel(str);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.b();
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, List paramList)
  {
    if (paramLong != this.jdField_a_of_type_Long) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    if (!paramBoolean1)
    {
      if (paramBoolean2) {
        this.jdField_a_of_type_Acik.a(1, true);
      }
      a(getString(2131439333), 1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Acik.getItemCount() == 0) {
        this.jdField_a_of_type_Acik.a(true);
      }
      if ((paramBoolean2) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView == null)) {
        break;
      }
      a(paramBoolean1);
      return;
      if (paramBoolean2)
      {
        this.jdField_a_of_type_Int += paramList.size();
        int i = 0;
        while (i < paramList.size())
        {
          if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramList.get(i))) {
            this.jdField_a_of_type_JavaUtilLinkedList.add(paramList.get(i));
          }
          i += 1;
        }
      }
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilLinkedList.addAll(paramList);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilLinkedList.size();
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
      {
        paramList = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
        if (paramList != null)
        {
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          paramList.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131434348), TimeFormatterUtils.a(this.jdField_b_of_type_Long, true, "yyyy-MM-dd") }));
        }
      }
      this.jdField_a_of_type_Boolean = paramBoolean3;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Acik.a(2, false);
      }
      this.jdField_a_of_type_Acik.notifyDataSetChanged();
      c();
    }
  }
  
  private boolean a()
  {
    if ((jdField_a_of_type_Acic != null) && (jdField_a_of_type_Acic.jdField_a_of_type_JavaUtilList != null) && (!jdField_a_of_type_Acic.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_Boolean = jdField_a_of_type_Acic.jdField_a_of_type_Boolean;
      this.jdField_b_of_type_Long = jdField_a_of_type_Acic.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_Acik != null))
      {
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Acik.a(2, false);
          this.jdField_a_of_type_JavaUtilLinkedList.clear();
          this.jdField_a_of_type_JavaUtilLinkedList.addAll(jdField_a_of_type_Acic.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_Acik.notifyDataSetChanged();
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
      {
        ILoadingLayout localILoadingLayout = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
        if (localILoadingLayout != null) {
          localILoadingLayout.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131434348), TimeFormatterUtils.a(jdField_a_of_type_Acic.jdField_a_of_type_Long, true, "yyyy-MM-dd") }));
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendGroupFragment", 2, String.format("loadCacheData result=%s %s", new Object[] { Boolean.valueOf(bool), jdField_a_of_type_Acic }));
      }
      return bool;
      this.jdField_a_of_type_Acik.a(0, false);
      break;
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendGroupFragment", 2, String.format("requestGroupList loadMore:%b loading:%b isOver:%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    }
    if (this.jdField_b_of_type_Boolean) {}
    while ((paramBoolean) && (this.jdField_a_of_type_Boolean)) {
      return false;
    }
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      a(getString(2131437530), 1);
      return false;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (paramBoolean) {}
    for (int i = this.jdField_a_of_type_Int;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendHandler.a(false, i, 30, paramBoolean, this.jdField_a_of_type_Long);
      return true;
    }
  }
  
  private void c()
  {
    if (jdField_a_of_type_Acic == null)
    {
      jdField_a_of_type_Acic = new acic(null);
      jdField_a_of_type_Acic.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    jdField_a_of_type_Acic.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_JavaUtilLinkedList != null)
    {
      jdField_a_of_type_Acic.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilLinkedList);
      jdField_a_of_type_Acic.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      jdField_a_of_type_Acic.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendGroupFragment", 2, String.format("saveCacheData %s", new Object[] { jdField_a_of_type_Acic }));
    }
  }
  
  public GroupInfo a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilLinkedList != null)
    {
      int i = this.jdField_a_of_type_JavaUtilLinkedList.size();
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < i) {
          localObject1 = (GroupInfo)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
    }
  }
  
  public void a(int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D6", "0X80092D6", 0, 0, "", "", "", "");
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      localObject = TroopInfoActivity.a(Long.toString(((GroupInfo)localObject).groupCode), 34);
      ((Bundle)localObject).putInt("exposureSource", 11);
      ((Bundle)localObject).putInt("t_s_f", 1002);
      ChatSettingForTroop.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (Bundle)localObject, 2);
    }
  }
  
  public void a(PullToRefreshBase paramPullToRefreshBase)
  {
    if (!isAdded()) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D8", "0X80092D8", 0, 0, "", "", "", "");
    if (a(false))
    {
      this.jdField_a_of_type_Acik.a(0, true);
      return;
    }
    a(false);
  }
  
  public void b()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendGroupFragment", 2, String.format("onFooterItemClick", new Object[0]));
    }
    boolean bool = a(true);
    acik localacik = this.jdField_a_of_type_Acik;
    if (bool) {}
    for (;;)
    {
      localacik.a(i, true);
      return;
      i = 1;
    }
  }
  
  public void b(PullToRefreshBase paramPullToRefreshBase) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendHandler = ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(128));
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendObserver);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130970336, null);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131370093));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_Acik = new acik(this, this, this.jdField_a_of_type_JavaUtilLinkedList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Acik);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new acia(this));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendHandler = null;
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendGroupFragment", 2, "onResume");
    }
    super.onResume();
    if (!this.c)
    {
      boolean bool = a();
      long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendGroupFragment", 2, String.format("onResume loadSuccess=%s interval=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) }));
      }
      if ((!bool) || (l > 60000L)) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new acib(this), 500L);
      }
      this.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment
 * JD-Core Version:    0.7.0.1
 */