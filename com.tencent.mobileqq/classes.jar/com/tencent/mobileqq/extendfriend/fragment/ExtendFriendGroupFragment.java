package com.tencent.mobileqq.extendfriend.fragment;

import ajya;
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
import aoet;
import aoez;
import aohh;
import aohi;
import aohj;
import aohk;
import aohs;
import aoiy;
import aoka;
import aokg;
import axmv;
import axqy;
import banb;
import bbfj;
import bbkp;
import bcql;
import bfob;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.bean.GroupInfo;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExtendFriendGroupFragment
  extends Fragment
  implements aoiy, aokg<RecyclerView>
{
  private static aohk jdField_a_of_type_Aohk;
  private static boolean e = ;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Drawable a;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  public StaggeredGridLayoutManager a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aohi(this);
  private aoet jdField_a_of_type_Aoet;
  private aoez jdField_a_of_type_Aoez = new aohh(this);
  private aohs jdField_a_of_type_Aohs;
  private bfob jdField_a_of_type_Bfob;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PullToRefreshRecyclerView jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView;
  private LinkedList<GroupInfo> jdField_a_of_type_JavaUtilLinkedList;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d = axmv.b();
  
  public ExtendFriendGroupFragment()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      bcql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt, paramString, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = ajya.a(2131704253);; str = ajya.a(2131704272))
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false).setRefreshResultLabel(str);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.b();
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, List<GroupInfo> paramList)
  {
    if (paramLong != this.jdField_a_of_type_Long) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    if (!paramBoolean1)
    {
      if (paramBoolean2) {
        this.jdField_a_of_type_Aohs.a(1, true);
      }
      a(getString(2131699014), 1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aohs.getItemCount() == 0) {
        this.jdField_a_of_type_Aohs.a(true);
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
          paramList.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131719800), bbkp.a(this.jdField_b_of_type_Long, true, "yyyy-MM-dd") }));
        }
      }
      this.jdField_a_of_type_Boolean = paramBoolean3;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Aohs.a(2, false);
      }
      this.jdField_a_of_type_Aohs.notifyDataSetChanged();
      b();
    }
  }
  
  private boolean a()
  {
    if ((jdField_a_of_type_Aohk != null) && (jdField_a_of_type_Aohk.jdField_a_of_type_JavaUtilList != null) && (!jdField_a_of_type_Aohk.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_Boolean = jdField_a_of_type_Aohk.jdField_a_of_type_Boolean;
      this.jdField_b_of_type_Long = jdField_a_of_type_Aohk.jdField_a_of_type_Long;
      Object localObject;
      if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_Aohs != null))
      {
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Aohs.a(2, false);
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilLinkedList.clear();
          this.jdField_a_of_type_JavaUtilLinkedList.addAll(jdField_a_of_type_Aohk.jdField_a_of_type_JavaUtilList);
          if (this.d == e) {
            break label190;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendGroupFragment", 2, String.format("loadCacheData clear image cache", new Object[0]));
          }
          localObject = URLDrawable.URLDrawableOptions.obtain();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
          while (localIterator.hasNext()) {
            URLDrawable.removeMemoryCacheByUrl(((GroupInfo)localIterator.next()).groupFace, (URLDrawable.URLDrawableOptions)localObject);
          }
          this.jdField_a_of_type_Aohs.a(0, false);
        }
        e = this.d;
        label190:
        this.jdField_a_of_type_Aohs.notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
        if (localObject != null) {
          ((aoka)localObject).setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131719800), bbkp.a(jdField_a_of_type_Aohk.jdField_a_of_type_Long, true, "yyyy-MM-dd") }));
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendGroupFragment", 2, String.format("loadCacheData result=%s %s", new Object[] { Boolean.valueOf(bool), jdField_a_of_type_Aohk }));
      }
      return bool;
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
    if (!bbfj.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      a(getString(2131694972), 1);
      return false;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (paramBoolean) {}
    for (int i = this.jdField_a_of_type_Int;; i = 0)
    {
      this.jdField_a_of_type_Aoet.a(false, i, 30, paramBoolean, this.jdField_a_of_type_Long);
      return true;
    }
  }
  
  private void b()
  {
    if (jdField_a_of_type_Aohk == null)
    {
      jdField_a_of_type_Aohk = new aohk(null);
      jdField_a_of_type_Aohk.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    jdField_a_of_type_Aohk.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_JavaUtilLinkedList != null)
    {
      jdField_a_of_type_Aohk.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilLinkedList);
      jdField_a_of_type_Aohk.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      jdField_a_of_type_Aohk.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendGroupFragment", 2, String.format("saveCacheData %s", new Object[] { jdField_a_of_type_Aohk }));
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
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendGroupFragment", 2, String.format("onFooterItemClick", new Object[0]));
    }
    boolean bool = a(true);
    aohs localaohs = this.jdField_a_of_type_Aohs;
    if (bool) {}
    for (;;)
    {
      localaohs.a(i, true);
      return;
      i = 1;
    }
  }
  
  public void a(int paramInt)
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D6", "0X80092D6", 0, 0, "", "", "", "");
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      localObject = TroopInfoActivity.a(Long.toString(((GroupInfo)localObject).groupCode), 34);
      ((Bundle)localObject).putInt("exposureSource", 11);
      ((Bundle)localObject).putInt("t_s_f", 1002);
      banb.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (Bundle)localObject, 2);
    }
  }
  
  public void a(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (!isAdded()) {
      return;
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D8", "0X80092D8", 0, 0, "", "", "", "");
    if (a(false))
    {
      this.jdField_a_of_type_Aohs.a(0, true);
      return;
    }
    a(false);
  }
  
  public void b(PullToRefreshBase<RecyclerView> paramPullToRefreshBase) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    this.jdField_a_of_type_Aoet = ((aoet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127));
    this.jdField_a_of_type_Bfob = new bfob(Looper.getMainLooper(), null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoez);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560744, null);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131372153));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setId(2131375022);
    this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_Aohs = new aohs(this, this, this.jdField_a_of_type_JavaUtilLinkedList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aohs);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new aohj(this));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoez);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.jdField_a_of_type_Aoet = null;
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
        this.jdField_a_of_type_Bfob.postDelayed(new ExtendFriendGroupFragment.4(this), 500L);
      }
      this.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment
 * JD-Core Version:    0.7.0.1
 */