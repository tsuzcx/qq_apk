package com.tencent.mobileqq.extendfriend.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import anvi;
import arhw;
import aslm;
import aslo;
import aslz;
import asmr;
import asms;
import asmy;
import asmz;
import asnd;
import asnq;
import asnu;
import asnv;
import aspe;
import aspq;
import asqc;
import asqd;
import asqe;
import asqf;
import asqg;
import asqh;
import asqi;
import asqk;
import asql;
import assb;
import assh;
import assp;
import assw;
import asud;
import asvq;
import bdla;
import bhid;
import bkys;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.State;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendBottomBarView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView.TipsType;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class ExtendFriendSquareFragment
  extends ExtendFriendBaseFragment
  implements assh<RecyclerView>, asud
{
  private anvi jdField_a_of_type_Anvi = new asqd(this);
  private aslz jdField_a_of_type_Aslz = new asqc(this);
  private asmr jdField_a_of_type_Asmr = new asmr();
  private asnd jdField_a_of_type_Asnd = new asnd();
  private aspq jdField_a_of_type_Aspq;
  private ExtendFriendBottomBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView;
  private ExtendFriendSearchBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private bkys b;
  public long e;
  public boolean e;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  public int h;
  private boolean h;
  public int i;
  private boolean i;
  private boolean j;
  private int jdField_k_of_type_Int = 1;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private int m = -1;
  private int n;
  
  public ExtendFriendSquareFragment()
  {
    this.jdField_i_of_type_Int = 480;
    this.jdField_e_of_type_Long = -1L;
  }
  
  private void a(int paramInt, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSquareFragment", 2, "updateSearchBarState scrollY: " + paramInt + "  speed: " + paramFloat);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView != null)
    {
      if (paramInt >= this.jdField_i_of_type_Int) {
        break label94;
      }
      if (paramInt <= this.n / 2) {
        break label84;
      }
      if (paramFloat > 0.0F) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.b();
      }
    }
    for (;;)
    {
      d(false);
      return;
      label84:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.a();
      continue;
      label94:
      if (paramFloat < -5.0F) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.a();
      } else if (paramFloat > 0.5D) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.b();
      }
    }
  }
  
  private void a(List<String> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendSquareFragment", 2, String.format("updateAddFrdState count=%d", new Object[] { Integer.valueOf(paramList.size()) }));
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        int i1 = this.jdField_a_of_type_Asqk.a((String)localObject);
        if (i1 >= 0)
        {
          localObject = this.jdField_a_of_type_Asqk.a(i1);
          if ((localObject != null) && (!((asnq)localObject).mAddFriendVerified))
          {
            ((asnq)localObject).mAddFriendVerified = true;
            this.jdField_a_of_type_Asqk.notifyItemChanged(i1);
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<asnq> paramList, asnd paramasnd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList success=%s searchKey=%s", new Object[] { Boolean.valueOf(paramBoolean1), paramString }));
    }
    if ((!isAdded()) || (this.jdField_a_of_type_Asqk == null)) {
      return;
    }
    paramString = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getTag(2131376423);
    if ((paramString != null) && ((paramString instanceof Integer))) {}
    for (int i1 = ((Integer)paramString).intValue();; i1 = 0)
    {
      paramString = this.jdField_a_of_type_Asqk;
      int i2;
      if (paramBoolean1)
      {
        i2 = 0;
        paramString.c(i2);
        if ((paramBoolean1) && (paramList != null)) {
          break label294;
        }
        if (this.jdField_h_of_type_Boolean) {
          this.jdField_a_of_type_Asqk.a(1, true);
        }
        if (this.jdField_k_of_type_Int != 0) {
          break label278;
        }
        paramInt = 2131694512;
        label131:
        if (i1 == 1)
        {
          if (this.jdField_k_of_type_Int != 0) {
            break label286;
          }
          paramInt = 2131694512;
        }
        label148:
        a(getString(paramInt), 1);
        label159:
        if (this.jdField_a_of_type_Asqk.getItemCount() == 0) {
          this.jdField_a_of_type_Asqk.a(true);
        }
        this.jdField_a_of_type_Asqk.notifyDataSetChanged();
        if ((!this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null))
        {
          if (!paramBoolean1) {
            break label629;
          }
          paramInt = 2131698539;
          label206:
          if (i1 != 1) {
            break label645;
          }
          if (!paramBoolean1) {
            break label637;
          }
          paramInt = 2131698518;
        }
      }
      label645:
      for (;;)
      {
        paramString = getResources().getString(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false).setRefreshResultLabel(paramString);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.b();
        j(0);
        this.g = false;
        g();
        b(true);
        return;
        i2 = 1;
        break;
        label278:
        paramInt = 2131698537;
        break label131;
        label286:
        paramInt = 2131698517;
        break label148;
        label294:
        this.jdField_i_of_type_Boolean = paramBoolean2;
        this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.jdField_a_of_type_Boolean = paramBoolean3;
        this.jdField_b_of_type_Boolean = paramBoolean4;
        this.jdField_l_of_type_Int = paramInt;
        this.jdField_a_of_type_Asnd.jdField_a_of_type_Int = paramasnd.jdField_a_of_type_Int;
        this.jdField_a_of_type_Asnd.jdField_b_of_type_Int = paramasnd.jdField_b_of_type_Int;
        this.jdField_a_of_type_Asnd.jdField_c_of_type_Int = paramasnd.jdField_c_of_type_Int;
        this.jdField_a_of_type_Asnd.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_Asnd.jdField_a_of_type_JavaUtilList.addAll(paramasnd.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(this.jdField_a_of_type_Asnd.jdField_a_of_type_JavaUtilList);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList mLoadOver=%s mRequestCookies=%s mProfileComplete=%s mShowCard=%s mMaxLikeCount=%s matchCount=%d limitDuration=%d", new Object[] { Boolean.valueOf(this.jdField_i_of_type_Boolean), this.jdField_a_of_type_ArrayOfByte, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_l_of_type_Int), Integer.valueOf(paramasnd.jdField_a_of_type_Int), Integer.valueOf(paramasnd.jdField_b_of_type_Int) }));
        }
        if (!this.jdField_h_of_type_Boolean)
        {
          this.jdField_a_of_type_Asqk.a();
          p();
        }
        if (this.jdField_i_of_type_Boolean) {
          this.jdField_a_of_type_Asqk.a(2, false);
        }
        this.jdField_a_of_type_Asqk.a(paramList);
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
          if (paramString != null)
          {
            this.jdField_f_of_type_Long = System.currentTimeMillis();
            this.m = Calendar.getInstance().get(6);
            paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131718994), bhid.a(this.jdField_f_of_type_Long, true, "yyyy-MM-dd") }));
          }
        }
        q();
        break label159;
        label629:
        paramInt = 2131698537;
        break label206;
        label637:
        paramInt = 2131698517;
      }
    }
  }
  
  private boolean a(boolean paramBoolean, String paramString)
  {
    boolean bool2 = false;
    List localList = this.jdField_a_of_type_Aslo.a(2);
    boolean bool1 = bool2;
    int i1;
    int i2;
    Object localObject;
    if (aslo.jdField_a_of_type_Asnu != null)
    {
      bool1 = bool2;
      if (aslo.jdField_a_of_type_Asnu.jdField_a_of_type_JavaUtilList != null)
      {
        bool1 = bool2;
        if (aslo.jdField_a_of_type_Asnu.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          if (!paramBoolean) {
            break label567;
          }
          paramString = aslo.jdField_a_of_type_Asnu.a();
          if ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList.size() <= 0) || (!localList.contains(paramString.jdField_a_of_type_JavaLangString))) {
            break label561;
          }
          bool1 = true;
          if (bool1)
          {
            this.jdField_a_of_type_Boolean = aslo.jdField_a_of_type_Asnu.jdField_a_of_type_Boolean;
            this.jdField_b_of_type_Boolean = aslo.jdField_a_of_type_Asnu.jdField_b_of_type_Boolean;
            this.jdField_l_of_type_Int = aslo.jdField_a_of_type_Asnu.jdField_a_of_type_Int;
            this.jdField_i_of_type_Boolean = paramString.jdField_a_of_type_Boolean;
            this.jdField_a_of_type_ArrayOfByte = paramString.jdField_a_of_type_ArrayOfByte;
            this.jdField_f_of_type_Long = paramString.jdField_a_of_type_Long;
            this.m = paramString.jdField_a_of_type_Int;
            this.jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
            i1 = paramString.jdField_b_of_type_Int;
            i2 = paramString.jdField_c_of_type_Int;
            if (paramString.jdField_a_of_type_JavaUtilList.size() > 0)
            {
              localObject = (asnq)paramString.jdField_a_of_type_JavaUtilList.get(0);
              if (!(localObject instanceof asnd)) {
                break label603;
              }
              localObject = (asnd)localObject;
              if (this.jdField_a_of_type_Asnd != localObject)
              {
                this.jdField_a_of_type_Asnd.jdField_a_of_type_Int = ((asnd)localObject).jdField_a_of_type_Int;
                this.jdField_a_of_type_Asnd.jdField_b_of_type_Int = ((asnd)localObject).jdField_b_of_type_Int;
                this.jdField_a_of_type_Asnd.jdField_c_of_type_Int = ((asnd)localObject).jdField_c_of_type_Int;
                this.jdField_a_of_type_Asnd.jdField_a_of_type_JavaUtilList.clear();
                this.jdField_a_of_type_Asnd.jdField_a_of_type_JavaUtilList.addAll(((asnd)localObject).jdField_a_of_type_JavaUtilList);
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(this.jdField_a_of_type_Asnd.jdField_a_of_type_JavaUtilList);
              }
            }
            label315:
            if (paramBoolean)
            {
              int i3 = localList.indexOf(this.jdField_b_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, i3);
            }
            if (this.jdField_a_of_type_Asqk != null)
            {
              if (!this.jdField_i_of_type_Boolean) {
                break label621;
              }
              this.jdField_a_of_type_Asqk.a(2, false);
            }
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Asqk.a();
      this.jdField_a_of_type_Asqk.a(paramString.jdField_a_of_type_JavaUtilList);
      p();
      this.jdField_a_of_type_Asqk.notifyDataSetChanged();
      if (Math.abs(System.currentTimeMillis() - this.jdField_f_of_type_Long) < 60000L) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new ExtendFriendSquareFragment.9(this, i1, i2), 100L);
      }
      g();
      b(true);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
        if (paramString != null) {
          paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131718994), bhid.a(this.jdField_f_of_type_Long, true, "yyyy-MM-dd") }));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendSquareFragment", 2, String.format("loadCacheData result=%b ts=%d tag=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(this.jdField_f_of_type_Long), this.jdField_b_of_type_JavaLangString }));
      }
      return bool1;
      label561:
      bool1 = false;
      break;
      label567:
      paramString = aslo.jdField_a_of_type_Asnu.a(paramString);
      if ((paramString != null) && (paramString.jdField_a_of_type_JavaUtilList.size() > 0)) {}
      for (bool1 = true;; bool1 = false) {
        break;
      }
      label603:
      if (!(localObject instanceof asmr)) {
        break label315;
      }
      localObject = (asmr)localObject;
      break label315;
      label621:
      this.jdField_a_of_type_Asqk.a(0, false);
    }
  }
  
  private boolean b()
  {
    if (this.m < 0) {}
    while (Calendar.getInstance().get(6) == this.m) {
      return false;
    }
    return true;
  }
  
  private void j(int paramInt)
  {
    int i1 = 1;
    assb localassb = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
    if (paramInt == 1) {
      if (i1 == 0) {
        break label58;
      }
    }
    label58:
    for (i1 = 2131698519;; i1 = 2131698538)
    {
      localassb.setRefreshingLabel(getResources().getString(i1));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setTag(2131376423, Integer.valueOf(paramInt));
      return;
      i1 = 0;
      break;
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_Asmr.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    Object localObject = new asms();
    ((asms)localObject).jdField_a_of_type_Int = 0;
    ((asms)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131698484);
    ((asms)localObject).jdField_b_of_type_Int = -20771;
    ((asms)localObject).jdField_c_of_type_Int = -31578;
    ((asms)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
    this.jdField_a_of_type_Asmr.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = ((aslo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        arhw localarhw = (arhw)((Iterator)localObject).next();
        asms localasms = new asms();
        localasms.jdField_a_of_type_JavaLangString = localarhw.jdField_c_of_type_JavaLangString;
        localasms.jdField_a_of_type_Long = localarhw.jdField_a_of_type_Long;
        localasms.jdField_b_of_type_JavaLangString = localarhw.d;
        if ("0".equals(localarhw.f)) {
          localasms.jdField_a_of_type_Int = 0;
        }
        for (;;)
        {
          localasms.d = localarhw.g;
          localasms.jdField_c_of_type_JavaLangString = localarhw.e;
          localasms.jdField_a_of_type_OrgJsonJSONObject = localarhw.jdField_a_of_type_OrgJsonJSONObject;
          try
          {
            if (localarhw.jdField_a_of_type_JavaLangString != null) {
              localasms.jdField_b_of_type_Int = Color.parseColor(localarhw.jdField_a_of_type_JavaLangString);
            }
            if (localarhw.jdField_b_of_type_JavaLangString != null) {
              localasms.jdField_c_of_type_Int = Color.parseColor(localarhw.jdField_b_of_type_JavaLangString);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSquareFragment", 2, "parse banner color " + localException);
              }
            }
          }
          this.jdField_a_of_type_Asmr.jdField_a_of_type_JavaUtilArrayList.add(localasms);
          break;
          if ("1".equals(localarhw.f)) {
            localasms.jdField_a_of_type_Int = 1;
          } else if ("2".equals(localarhw.f)) {
            localasms.jdField_a_of_type_Int = 2;
          } else if ("3".equals(localarhw.f)) {
            localasms.jdField_a_of_type_Int = 3;
          } else {
            localasms.jdField_a_of_type_Int = -1;
          }
        }
      }
    }
  }
  
  private void n()
  {
    if ((!isAdded()) || (this.jdField_a_of_type_Asqk == null)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_j_of_type_Boolean);
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView == null);
    j(1);
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.d())
    {
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setRefreshing();
    this.jdField_a_of_type_Asqk.a(0, true);
    return;
    this.jdField_k_of_type_Int = 0;
    o();
  }
  
  private void o()
  {
    a(false, this.jdField_b_of_type_JavaLangString, false, null, false, false, 0, null, null);
  }
  
  private void p()
  {
    aslo localaslo;
    boolean bool;
    Object localObject1;
    int i2;
    Object localObject2;
    asms localasms;
    if ((this.jdField_a_of_type_Asqk != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (aslo.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)))
    {
      if (this.jdField_j_of_type_Int != 0) {
        break label639;
      }
      localaslo = (aslo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      bool = localaslo.g();
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, String.format("refreshFeedBanner limitChatSwitch=%s mTabPos=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.jdField_j_of_type_Int) }));
      }
      if (!bool) {
        break label677;
      }
      this.jdField_k_of_type_Boolean = true;
      localObject1 = this.jdField_a_of_type_Asqk.a(0);
      if (!(localObject1 instanceof asmr)) {
        break label526;
      }
      localObject1 = (asmr)localObject1;
      i2 = 0;
      i1 = i2;
      if (((asmr)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject2 = ((asmr)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localasms = (asms)((Iterator)localObject2).next();
            if (localasms.jdField_a_of_type_Int == 0)
            {
              if ((this.jdField_a_of_type_Asnd.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_Asnd.jdField_a_of_type_JavaUtilList.isEmpty())) {
                localasms.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_Asnd.jdField_a_of_type_JavaUtilList);
              }
              localObject2 = localasms;
              if (this.jdField_a_of_type_Asnd.jdField_c_of_type_Int > 0)
              {
                if (((asmr)localObject1).jdField_a_of_type_JavaUtilArrayList.size() > 1)
                {
                  localasms.jdField_b_of_type_JavaLangString = String.format(getResources().getString(2131698481), new Object[] { Integer.valueOf(this.jdField_a_of_type_Asnd.jdField_c_of_type_Int) });
                  localObject2 = localasms;
                }
              }
              else
              {
                label292:
                i1 = i2;
                if (localObject2 != null) {
                  this.jdField_a_of_type_Asqk.a((asms)localObject2);
                }
              }
            }
          }
        }
      }
    }
    label526:
    label677:
    for (int i1 = i2;; i1 = 0)
    {
      bool = localaslo.f();
      int i3 = localaslo.e();
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, String.format("refreshFeedBanner needShowVerifyTips=%s verifyStatus=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i3) }));
      }
      if (this.jdField_k_of_type_Boolean)
      {
        i2 = 1;
        label369:
        localObject1 = this.jdField_a_of_type_Asqk.a(i2);
        bool = ExtendFriendCampusVerifyTipsView.a(bool, i3);
        localObject2 = ExtendFriendCampusVerifyTipsView.a(i3);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, String.format("refreshFeedBanner showVerifyTips=%s tipsType=%s", new Object[] { Boolean.valueOf(bool), localObject2 }));
        }
        if (!bool) {
          break label618;
        }
        if (!(localObject1 instanceof asmy)) {
          break label596;
        }
        localObject1 = (asmy)localObject1;
        label448:
        ((asmy)localObject1).a = ExtendFriendCampusVerifyTipsView.a(i3);
        i1 = 1;
      }
      for (;;)
      {
        if (i1 != 0) {
          this.jdField_a_of_type_Asqk.notifyDataSetChanged();
        }
        if ((this.jdField_k_of_type_Boolean) && (!this.jdField_l_of_type_Boolean))
        {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A4", "0X80096A4", 0, 0, "", "", "", "");
          this.jdField_l_of_type_Boolean = true;
        }
        return;
        this.jdField_a_of_type_Asqk.a(0, this.jdField_a_of_type_Asmr);
        localObject1 = this.jdField_a_of_type_Asmr;
        i2 = 1;
        break;
        localasms.jdField_b_of_type_JavaLangString = (this.jdField_a_of_type_Asnd.jdField_c_of_type_Int + getString(2131698507));
        localObject2 = localasms;
        break label292;
        i2 = 0;
        break label369;
        label596:
        localObject1 = new asmy();
        this.jdField_a_of_type_Asqk.a(i2, (asnq)localObject1);
        break label448;
        label618:
        if ((localObject1 instanceof asmy))
        {
          this.jdField_a_of_type_Asqk.b(i2);
          i1 = 1;
          continue;
          label639:
          if ((this.jdField_a_of_type_Asqk.a(0) instanceof asmr))
          {
            this.jdField_a_of_type_Asqk.b(0);
            i1 = 1;
          }
          else
          {
            i1 = 0;
          }
        }
      }
      localObject2 = null;
      break label292;
    }
  }
  
  private void q()
  {
    if (aslo.jdField_a_of_type_Asnu == null) {
      aslo.jdField_a_of_type_Asnu = new asnu();
    }
    if (this.jdField_a_of_type_Asqk != null)
    {
      localObject = new asnv();
      ((asnv)localObject).jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Asqk.a());
      ((asnv)localObject).jdField_a_of_type_Long = this.jdField_f_of_type_Long;
      ((asnv)localObject).jdField_a_of_type_Int = this.m;
      ((asnv)localObject).jdField_a_of_type_Boolean = this.jdField_i_of_type_Boolean;
      ((asnv)localObject).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((asnv)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((asnv)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      if (((asnv)localObject).jdField_b_of_type_Int < 0) {
        ((asnv)localObject).jdField_b_of_type_Int = 0;
      }
      View localView = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(((asnv)localObject).jdField_b_of_type_Int);
      if (localView != null) {
        ((asnv)localObject).jdField_c_of_type_Int = localView.getTop();
      }
      aslo.jdField_a_of_type_Asnu.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      aslo.jdField_a_of_type_Asnu.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
      aslo.jdField_a_of_type_Asnu.jdField_a_of_type_Int = this.jdField_l_of_type_Int;
      aslo.jdField_a_of_type_Asnu.a((asnv)localObject, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_l_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      if (aslo.jdField_a_of_type_Asnu != null) {
        break label221;
      }
    }
    label221:
    for (Object localObject = "null";; localObject = aslo.jdField_a_of_type_Asnu.toString())
    {
      QLog.i("ExtendFriendSquareFragment", 2, String.format("saveCacheData %s", new Object[] { localObject }));
      return;
    }
  }
  
  private void r()
  {
    List localList = null;
    if (this.jdField_a_of_type_Aslo != null) {
      localList = this.jdField_a_of_type_Aslo.a(2);
    }
    if (localList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, 0);
      this.jdField_b_of_type_Bkys.post(new ExtendFriendSquareFragment.10(this));
    }
  }
  
  protected int a()
  {
    return 1031;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "limitchat enter match");
    }
    if (a())
    {
      bdla.b(null, "dc00898", "", "", "kuolie", "0X80097DD", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, "onMatchItemClick, showExtendFriendQuestionDialog");
      }
      return;
    }
    if (this.jdField_a_of_type_Aspe != null)
    {
      this.jdField_a_of_type_Aspe.a();
      assw.a().b(2);
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A5", "0X80096A5", 0, 0, "", "", "", "");
  }
  
  public void a(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onPullDownToRefresh  mRecyclerViewScrollY:" + this.jdField_h_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSquareFragment", 2, "onPullDownToRefresh state:" + paramPullToRefreshBase.a() + " lastCacheOk:" + this.jdField_j_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Bkys.hasMessages(10))
    {
      this.jdField_a_of_type_Bkys.removeMessages(10);
      e();
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D4", "0X80092D4", 0, 0, "", "", "", "");
    if ((paramPullToRefreshBase.a() == PullToRefreshBase.State.MANUAL_REFRESHING) && (this.jdField_j_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.b();
    }
    for (;;)
    {
      a(this.jdField_h_of_type_Int, 0.0F);
      return;
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        a(false);
        j();
        this.jdField_a_of_type_Asqk.a(0, true);
      }
      else
      {
        this.jdField_k_of_type_Int = 0;
        o();
      }
    }
  }
  
  public void a(ExtendFriendCampusVerifyTipsView.TipsType paramTipsType)
  {
    ExtendFriendCampusVerifyTipsView.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("requestSquareStrangerList loadMore=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.jdField_h_of_type_Boolean = paramBoolean;
    if (!this.jdField_h_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = false;
      this.jdField_a_of_type_ArrayOfByte = null;
    }
    if (this.jdField_a_of_type_Aslm != null)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Aslm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ArrayOfByte, 20, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long, aslo.jdField_a_of_type_JavaLangString, true);
      this.g = true;
    }
    if (!paramBoolean) {}
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if ((paramBoolean1) || (paramBoolean2)) {
      q();
    }
  }
  
  public void am_()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    Object localObject2 = null;
    ArrayList localArrayList = null;
    Object localObject1 = localObject2;
    boolean bool2 = bool3;
    int i1;
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null)
    {
      localObject1 = localObject2;
      bool2 = bool3;
      if (this.jdField_a_of_type_Asqk != null)
      {
        i1 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
        int i2 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
        localObject1 = localArrayList;
        bool2 = bool1;
        if (i1 <= i2)
        {
          localObject1 = this.jdField_a_of_type_Asqk.a(i1);
          localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(i1);
          if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof asmz)))
          {
            localObject2 = (asmz)localObject2;
            localObject1 = a(((asnq)localObject1).mUin, ((asnq)localObject1).mNickName, ((asmz)localObject2).a);
            ((asmz)localObject2).a.setImageDrawable((Drawable)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break;
      if ((localObject1 instanceof asmr))
      {
        localObject1 = ((asmr)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (asms)((Iterator)localObject1).next();
            if (((asms)localObject2).jdField_a_of_type_Int == 0)
            {
              bool1 = true;
              localArrayList = ((asms)localObject2).jdField_a_of_type_JavaUtilArrayList;
              break;
              if (this.jdField_k_of_type_Boolean)
              {
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(bool2);
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a((List)localObject1);
              }
              return;
            }
          }
        }
      }
    }
  }
  
  protected int b()
  {
    return this.jdField_l_of_type_Int;
  }
  
  public void b(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onPullUpToRefresh  mRecyclerViewScrollY:" + this.jdField_h_of_type_Int);
    }
  }
  
  public void b(ExtendFriendCampusVerifyTipsView.TipsType paramTipsType)
  {
    assp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    p();
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) {}
    int i1;
    View localView;
    do
    {
      return 0;
      i1 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      localView = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(i1);
    } while (localView == null);
    return localView.getHeight() * i1 - (localView.getTop() - AIOUtils.dp2px(11.0F, getResources()));
  }
  
  public void d(boolean paramBoolean)
  {
    if ((!this.jdField_e_of_type_Boolean) || (paramBoolean))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.getHeight());
      }
      this.jdField_e_of_type_Boolean = true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      n();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (paramInt1 == 1031)
    {
      l();
      a(true, true);
      if (paramInt2 == 8193) {
        k();
      }
      this.jdField_c_of_type_Int = -1;
    }
    do
    {
      do
      {
        return;
        if ((paramInt1 != 1) || (paramInt2 != -1)) {
          break;
        }
        paramIntent = this.jdField_a_of_type_Asqk.a(this.jdField_b_of_type_Int);
      } while ((paramIntent == null) || (paramIntent.mAddFriendVerified));
      paramIntent.mAddFriendVerified = true;
      this.jdField_a_of_type_Asqk.notifyItemChanged(this.jdField_b_of_type_Int);
      return;
      if ((paramInt1 == 2) && (paramInt2 == -1))
      {
        a(false, true);
        return;
      }
    } while ((paramInt1 != 3) || (paramInt2 != -1) || (paramIntent == null));
    if (paramIntent.getBooleanExtra("has_entered_profile", false)) {
      a(true, true);
    }
    if (paramIntent.hasExtra("add_frd_list")) {
      a(paramIntent.getStringArrayListExtra("add_frd_list"));
    }
    if (paramIntent.hasExtra("remain_match_count"))
    {
      paramInt1 = paramIntent.getIntExtra("remain_match_count", 0);
      if (paramInt1 != this.jdField_a_of_type_Asnd.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Asnd.jdField_a_of_type_Int = paramInt1;
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update remainMatchCount=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Asnd.jdField_a_of_type_Int) }));
        }
      }
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramIntent.hasExtra("limit_chat_duration"))
      {
        paramInt2 = paramIntent.getIntExtra("limit_chat_duration", 0);
        if (paramInt2 != this.jdField_a_of_type_Asnd.jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_Asnd.jdField_b_of_type_Int = paramInt2;
          paramInt1 = i1;
          if (QLog.isColorLevel())
          {
            QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update limitChatDuration=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Asnd.jdField_b_of_type_Int) }));
            paramInt1 = i1;
          }
        }
      }
      while ((paramInt1 != 0) && (this.jdField_a_of_type_Asqk != null)) {
        return;
      }
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onCreate");
    }
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aslz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
      ((aslo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_b_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Aspq = new aspq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    m();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onCreateView");
    }
    this.n = AIOUtils.dp2px(35.0F, getResources());
    this.jdField_i_of_type_Int = AIOUtils.dp2px(160.0F, getResources());
    paramLayoutInflater = paramLayoutInflater.inflate(2131561144, null);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131373386));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new asvq(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setId(2131376423);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    ((SimpleItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new asqe(this));
    this.jdField_a_of_type_Asql = new asql(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new asqf(this);
    this.jdField_a_of_type_Asqk = new asqk(this, this, this, this, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
    this.jdField_a_of_type_Asqk.a(AIOUtils.dp2px(35.0F, getResources()));
    this.jdField_a_of_type_Asqk.registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    this.jdField_a_of_type_Asqk.a(this.jdField_a_of_type_Aspq);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Asqk);
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout = ((NearbyZanAnimLayout)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131368178));
    paramViewGroup = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131365174);
    paramViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new asqg(this, paramViewGroup));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView = ((ExtendFriendSearchBarView)paramLayoutInflater.findViewById(2131377155));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setItemClickListener(new asqh(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView = ((ExtendFriendBottomBarView)paramLayoutInflater.findViewById(2131363692));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.setOnClickListener(new asqi(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onDestroy");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_Aspq != null)
    {
      this.jdField_a_of_type_Aspq.a();
      this.jdField_a_of_type_Aspq = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aslz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver != null) {
      this.jdField_a_of_type_Asqk.unregisterAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    }
    this.jdField_a_of_type_Asqk.b();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.jdField_a_of_type_Aslm = null;
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onResume");
    }
    super.onResume();
    if ((!this.jdField_f_of_type_Boolean) && (isAdded()))
    {
      boolean bool = a(true, null);
      long l1 = System.currentTimeMillis() - this.jdField_f_of_type_Long;
      if ((!bool) || (l1 > 60000L) || (b()))
      {
        this.jdField_j_of_type_Boolean = false;
        this.jdField_b_of_type_JavaLangString = aslo.jdField_a_of_type_JavaLangString;
        List localList = this.jdField_a_of_type_Aslo.a(2);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, 0);
        this.jdField_b_of_type_Bkys.removeMessages(11);
        this.jdField_b_of_type_Bkys.sendEmptyMessageDelayed(11, 500L);
        this.jdField_f_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, String.format("onResume loadSuccess=%s interval=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) }));
        }
        this.jdField_b_of_type_Bkys.postDelayed(new ExtendFriendSquareFragment.8(this), 100L);
      }
    }
    for (;;)
    {
      a(this.jdField_h_of_type_Int, 0.0F);
      UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "expose#voice_tab#view", true, -1L, -1L, null, true, true);
      return;
      this.jdField_j_of_type_Boolean = true;
      break;
      if (b())
      {
        this.jdField_j_of_type_Boolean = false;
        this.jdField_b_of_type_Bkys.removeMessages(11);
        this.jdField_b_of_type_Bkys.sendEmptyMessageDelayed(11, 500L);
      }
      else
      {
        p();
        this.jdField_a_of_type_Asqk.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment
 * JD-Core Version:    0.7.0.1
 */