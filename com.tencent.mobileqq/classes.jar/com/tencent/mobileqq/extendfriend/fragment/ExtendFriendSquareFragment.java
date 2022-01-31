package com.tencent.mobileqq.extendfriend.fragment;

import aepi;
import altm;
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
import aosx;
import aqbe;
import aqbg;
import aqbl;
import aqby;
import aqbz;
import aqcf;
import aqcg;
import aqck;
import aqcx;
import aqdb;
import aqdc;
import aqeb;
import aqen;
import aqez;
import aqfa;
import aqfb;
import aqfc;
import aqfd;
import aqfe;
import aqff;
import aqfh;
import aqfi;
import aqgl;
import aqgr;
import aqgz;
import aqhg;
import aqib;
import aqiy;
import azqs;
import bdin;
import bdns;
import bhtd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.State;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendBottomBarView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView.TipsType;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class ExtendFriendSquareFragment
  extends ExtendFriendBaseFragment
  implements aqgr<RecyclerView>, aqib
{
  private altm jdField_a_of_type_Altm = new aqfa(this);
  private aqbl jdField_a_of_type_Aqbl = new aqez(this);
  private aqby jdField_a_of_type_Aqby = new aqby();
  private aqck jdField_a_of_type_Aqck = new aqck();
  private aqen jdField_a_of_type_Aqen;
  private ExtendFriendBottomBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView;
  private ExtendFriendSearchBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private bhtd b;
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
        int i1 = this.jdField_a_of_type_Aqfh.a((String)localObject);
        if (i1 >= 0)
        {
          localObject = this.jdField_a_of_type_Aqfh.a(i1);
          if ((localObject != null) && (!((aqcx)localObject).mAddFriendVerified))
          {
            ((aqcx)localObject).mAddFriendVerified = true;
            this.jdField_a_of_type_Aqfh.notifyItemChanged(i1);
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<aqcx> paramList, aqck paramaqck)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList success=%s searchKey=%s", new Object[] { Boolean.valueOf(paramBoolean1), paramString }));
    }
    if ((!isAdded()) || (this.jdField_a_of_type_Aqfh == null)) {
      return;
    }
    paramString = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getTag(2131375543);
    if ((paramString != null) && ((paramString instanceof Integer))) {}
    for (int i1 = ((Integer)paramString).intValue();; i1 = 0)
    {
      paramString = this.jdField_a_of_type_Aqfh;
      int i2;
      if (paramBoolean1)
      {
        i2 = 0;
        paramString.c(i2);
        if ((paramBoolean1) && (paramList != null)) {
          break label294;
        }
        if (this.jdField_h_of_type_Boolean) {
          this.jdField_a_of_type_Aqfh.a(1, true);
        }
        if (this.jdField_k_of_type_Int != 0) {
          break label278;
        }
        paramInt = 2131695131;
        label131:
        if (i1 == 1)
        {
          if (this.jdField_k_of_type_Int != 0) {
            break label286;
          }
          paramInt = 2131695131;
        }
        label148:
        a(getString(paramInt), 1);
        label159:
        if (this.jdField_a_of_type_Aqfh.getItemCount() == 0) {
          this.jdField_a_of_type_Aqfh.a(true);
        }
        this.jdField_a_of_type_Aqfh.notifyDataSetChanged();
        if ((!this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null))
        {
          if (!paramBoolean1) {
            break label629;
          }
          paramInt = 2131699365;
          label206:
          if (i1 != 1) {
            break label645;
          }
          if (!paramBoolean1) {
            break label637;
          }
          paramInt = 2131699352;
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
        paramInt = 2131699363;
        break label131;
        label286:
        paramInt = 2131699351;
        break label148;
        label294:
        this.jdField_i_of_type_Boolean = paramBoolean2;
        this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.jdField_a_of_type_Boolean = paramBoolean3;
        this.jdField_b_of_type_Boolean = paramBoolean4;
        this.jdField_l_of_type_Int = paramInt;
        this.jdField_a_of_type_Aqck.jdField_a_of_type_Int = paramaqck.jdField_a_of_type_Int;
        this.jdField_a_of_type_Aqck.jdField_b_of_type_Int = paramaqck.jdField_b_of_type_Int;
        this.jdField_a_of_type_Aqck.jdField_c_of_type_Int = paramaqck.jdField_c_of_type_Int;
        this.jdField_a_of_type_Aqck.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_Aqck.jdField_a_of_type_JavaUtilList.addAll(paramaqck.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(this.jdField_a_of_type_Aqck.jdField_a_of_type_JavaUtilList);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList mLoadOver=%s mRequestCookies=%s mProfileComplete=%s mShowCard=%s mMaxLikeCount=%s matchCount=%d limitDuration=%d", new Object[] { Boolean.valueOf(this.jdField_i_of_type_Boolean), this.jdField_a_of_type_ArrayOfByte, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_l_of_type_Int), Integer.valueOf(paramaqck.jdField_a_of_type_Int), Integer.valueOf(paramaqck.jdField_b_of_type_Int) }));
        }
        if (!this.jdField_h_of_type_Boolean)
        {
          this.jdField_a_of_type_Aqfh.a();
          p();
        }
        if (this.jdField_i_of_type_Boolean) {
          this.jdField_a_of_type_Aqfh.a(2, false);
        }
        this.jdField_a_of_type_Aqfh.a(paramList);
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
          if (paramString != null)
          {
            this.jdField_f_of_type_Long = System.currentTimeMillis();
            this.m = Calendar.getInstance().get(6);
            paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131720338), bdns.a(this.jdField_f_of_type_Long, true, "yyyy-MM-dd") }));
          }
        }
        q();
        break label159;
        label629:
        paramInt = 2131699363;
        break label206;
        label637:
        paramInt = 2131699351;
      }
    }
  }
  
  private boolean a(boolean paramBoolean, String paramString)
  {
    boolean bool2 = false;
    List localList = this.jdField_a_of_type_Aqbg.a(2);
    boolean bool1 = bool2;
    int i1;
    int i2;
    Object localObject;
    if (aqbg.jdField_a_of_type_Aqdb != null)
    {
      bool1 = bool2;
      if (aqbg.jdField_a_of_type_Aqdb.jdField_a_of_type_JavaUtilList != null)
      {
        bool1 = bool2;
        if (aqbg.jdField_a_of_type_Aqdb.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          if (!paramBoolean) {
            break label567;
          }
          paramString = aqbg.jdField_a_of_type_Aqdb.a();
          if ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList.size() <= 0) || (!localList.contains(paramString.jdField_a_of_type_JavaLangString))) {
            break label561;
          }
          bool1 = true;
          if (bool1)
          {
            this.jdField_a_of_type_Boolean = aqbg.jdField_a_of_type_Aqdb.jdField_a_of_type_Boolean;
            this.jdField_b_of_type_Boolean = aqbg.jdField_a_of_type_Aqdb.jdField_b_of_type_Boolean;
            this.jdField_l_of_type_Int = aqbg.jdField_a_of_type_Aqdb.jdField_a_of_type_Int;
            this.jdField_i_of_type_Boolean = paramString.jdField_a_of_type_Boolean;
            this.jdField_a_of_type_ArrayOfByte = paramString.jdField_a_of_type_ArrayOfByte;
            this.jdField_f_of_type_Long = paramString.jdField_a_of_type_Long;
            this.m = paramString.jdField_a_of_type_Int;
            this.jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
            i1 = paramString.jdField_b_of_type_Int;
            i2 = paramString.jdField_c_of_type_Int;
            if (paramString.jdField_a_of_type_JavaUtilList.size() > 0)
            {
              localObject = (aqcx)paramString.jdField_a_of_type_JavaUtilList.get(0);
              if (!(localObject instanceof aqck)) {
                break label603;
              }
              localObject = (aqck)localObject;
              if (this.jdField_a_of_type_Aqck != localObject)
              {
                this.jdField_a_of_type_Aqck.jdField_a_of_type_Int = ((aqck)localObject).jdField_a_of_type_Int;
                this.jdField_a_of_type_Aqck.jdField_b_of_type_Int = ((aqck)localObject).jdField_b_of_type_Int;
                this.jdField_a_of_type_Aqck.jdField_c_of_type_Int = ((aqck)localObject).jdField_c_of_type_Int;
                this.jdField_a_of_type_Aqck.jdField_a_of_type_JavaUtilList.clear();
                this.jdField_a_of_type_Aqck.jdField_a_of_type_JavaUtilList.addAll(((aqck)localObject).jdField_a_of_type_JavaUtilList);
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(this.jdField_a_of_type_Aqck.jdField_a_of_type_JavaUtilList);
              }
            }
            label315:
            if (paramBoolean)
            {
              int i3 = localList.indexOf(this.jdField_b_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, i3);
            }
            if (this.jdField_a_of_type_Aqfh != null)
            {
              if (!this.jdField_i_of_type_Boolean) {
                break label621;
              }
              this.jdField_a_of_type_Aqfh.a(2, false);
            }
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqfh.a();
      this.jdField_a_of_type_Aqfh.a(paramString.jdField_a_of_type_JavaUtilList);
      p();
      this.jdField_a_of_type_Aqfh.notifyDataSetChanged();
      if (Math.abs(System.currentTimeMillis() - this.jdField_f_of_type_Long) < 60000L) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new ExtendFriendSquareFragment.9(this, i1, i2), 100L);
      }
      g();
      b(true);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
        if (paramString != null) {
          paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131720338), bdns.a(this.jdField_f_of_type_Long, true, "yyyy-MM-dd") }));
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
      paramString = aqbg.jdField_a_of_type_Aqdb.a(paramString);
      if ((paramString != null) && (paramString.jdField_a_of_type_JavaUtilList.size() > 0)) {}
      for (bool1 = true;; bool1 = false) {
        break;
      }
      label603:
      if (!(localObject instanceof aqby)) {
        break label315;
      }
      localObject = (aqby)localObject;
      break label315;
      label621:
      this.jdField_a_of_type_Aqfh.a(0, false);
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
    aqgl localaqgl = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
    if (paramInt == 1) {
      if (i1 == 0) {
        break label58;
      }
    }
    label58:
    for (i1 = 2131699353;; i1 = 2131699364)
    {
      localaqgl.setRefreshingLabel(getResources().getString(i1));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setTag(2131375543, Integer.valueOf(paramInt));
      return;
      i1 = 0;
      break;
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_Aqby.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    Object localObject = new aqbz();
    ((aqbz)localObject).jdField_a_of_type_Int = 0;
    ((aqbz)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131699315);
    ((aqbz)localObject).jdField_b_of_type_Int = -20771;
    ((aqbz)localObject).jdField_c_of_type_Int = -31578;
    ((aqbz)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
    this.jdField_a_of_type_Aqby.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = ((aqbg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        aosx localaosx = (aosx)((Iterator)localObject).next();
        aqbz localaqbz = new aqbz();
        localaqbz.jdField_a_of_type_JavaLangString = localaosx.jdField_c_of_type_JavaLangString;
        localaqbz.jdField_a_of_type_Long = localaosx.jdField_a_of_type_Long;
        localaqbz.jdField_b_of_type_JavaLangString = localaosx.d;
        if ("0".equals(localaosx.f)) {
          localaqbz.jdField_a_of_type_Int = 0;
        }
        for (;;)
        {
          localaqbz.d = localaosx.g;
          localaqbz.jdField_c_of_type_JavaLangString = localaosx.e;
          localaqbz.jdField_a_of_type_OrgJsonJSONObject = localaosx.jdField_a_of_type_OrgJsonJSONObject;
          try
          {
            if (localaosx.jdField_a_of_type_JavaLangString != null) {
              localaqbz.jdField_b_of_type_Int = Color.parseColor(localaosx.jdField_a_of_type_JavaLangString);
            }
            if (localaosx.jdField_b_of_type_JavaLangString != null) {
              localaqbz.jdField_c_of_type_Int = Color.parseColor(localaosx.jdField_b_of_type_JavaLangString);
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
          this.jdField_a_of_type_Aqby.jdField_a_of_type_JavaUtilArrayList.add(localaqbz);
          break;
          if ("1".equals(localaosx.f)) {
            localaqbz.jdField_a_of_type_Int = 1;
          } else if ("2".equals(localaosx.f)) {
            localaqbz.jdField_a_of_type_Int = 2;
          } else if ("3".equals(localaosx.f)) {
            localaqbz.jdField_a_of_type_Int = 3;
          } else {
            localaqbz.jdField_a_of_type_Int = -1;
          }
        }
      }
    }
  }
  
  private void n()
  {
    if ((!isAdded()) || (this.jdField_a_of_type_Aqfh == null)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_j_of_type_Boolean);
      if (!bdin.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
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
    this.jdField_a_of_type_Aqfh.a(0, true);
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
    Object localObject1;
    int i2;
    int i1;
    Object localObject2;
    aqbz localaqbz;
    if ((this.jdField_a_of_type_Aqfh != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (aqbg.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)))
    {
      if (this.jdField_j_of_type_Int != 0) {
        break label650;
      }
      aqbg localaqbg = (aqbg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264);
      boolean bool = localaqbg.f();
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, String.format("refreshFeedBanner limitChatSwitch=%s mTabPos=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.jdField_j_of_type_Int) }));
      }
      if (!bool) {
        break label645;
      }
      this.jdField_k_of_type_Boolean = true;
      localObject1 = this.jdField_a_of_type_Aqfh.a(0);
      if (!(localObject1 instanceof aqby)) {
        break label526;
      }
      localObject1 = (aqby)localObject1;
      i2 = 0;
      i1 = i2;
      if (((aqby)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject2 = ((aqby)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localaqbz = (aqbz)((Iterator)localObject2).next();
        } while (localaqbz.jdField_a_of_type_Int != 0);
        if ((this.jdField_a_of_type_Aqck.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_Aqck.jdField_a_of_type_JavaUtilList.isEmpty())) {
          localaqbz.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_Aqck.jdField_a_of_type_JavaUtilList);
        }
        localObject2 = localaqbz;
        if (this.jdField_a_of_type_Aqck.jdField_c_of_type_Int > 0)
        {
          if (((aqby)localObject1).jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
            break label549;
          }
          localaqbz.jdField_b_of_type_JavaLangString = String.format(getResources().getString(2131699312), new Object[] { Integer.valueOf(this.jdField_a_of_type_Aqck.jdField_c_of_type_Int) });
          localObject2 = localaqbz;
        }
        label292:
        i1 = i2;
        if (localObject2 != null)
        {
          this.jdField_a_of_type_Aqfh.a((aqbz)localObject2);
          i1 = i2;
        }
      }
      label310:
      bool = localaqbg.e();
      int i3 = localaqbg.c();
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, String.format("refreshFeedBanner needShowVerifyTips=%s verifyStatus=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i3) }));
      }
      if (!this.jdField_k_of_type_Boolean) {
        break label591;
      }
      i2 = 1;
      label369:
      localObject1 = this.jdField_a_of_type_Aqfh.a(i2);
      bool = ExtendFriendCampusVerifyTipsView.a(bool, i3);
      localObject2 = ExtendFriendCampusVerifyTipsView.a(i3);
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, String.format("refreshFeedBanner showVerifyTips=%s tipsType=%s", new Object[] { Boolean.valueOf(bool), localObject2 }));
      }
      if (!bool) {
        break label618;
      }
      if (!(localObject1 instanceof aqcf)) {
        break label596;
      }
      localObject1 = (aqcf)localObject1;
      label448:
      ((aqcf)localObject1).a = ExtendFriendCampusVerifyTipsView.a(i3);
      i1 = 1;
    }
    label645:
    label650:
    for (;;)
    {
      if (i1 != 0) {
        this.jdField_a_of_type_Aqfh.notifyDataSetChanged();
      }
      if ((this.jdField_k_of_type_Boolean) && (!this.jdField_l_of_type_Boolean))
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A4", "0X80096A4", 0, 0, "", "", "", "");
        this.jdField_l_of_type_Boolean = true;
      }
      return;
      label526:
      this.jdField_a_of_type_Aqfh.a(0, this.jdField_a_of_type_Aqby);
      localObject1 = this.jdField_a_of_type_Aqby;
      i2 = 1;
      break;
      label549:
      localaqbz.jdField_b_of_type_JavaLangString = (this.jdField_a_of_type_Aqck.jdField_c_of_type_Int + getString(2131699338));
      localObject2 = localaqbz;
      break label292;
      label591:
      i2 = 0;
      break label369;
      label596:
      localObject1 = new aqcf();
      this.jdField_a_of_type_Aqfh.a(i2, (aqcx)localObject1);
      break label448;
      label618:
      if ((localObject1 instanceof aqcf))
      {
        this.jdField_a_of_type_Aqfh.b(i2);
        i1 = 1;
        continue;
        localObject2 = null;
        break label292;
        i1 = 0;
        break label310;
        i1 = 0;
      }
    }
  }
  
  private void q()
  {
    if (aqbg.jdField_a_of_type_Aqdb == null) {
      aqbg.jdField_a_of_type_Aqdb = new aqdb();
    }
    if (this.jdField_a_of_type_Aqfh != null)
    {
      localObject = new aqdc();
      ((aqdc)localObject).jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Aqfh.a());
      ((aqdc)localObject).jdField_a_of_type_Long = this.jdField_f_of_type_Long;
      ((aqdc)localObject).jdField_a_of_type_Int = this.m;
      ((aqdc)localObject).jdField_a_of_type_Boolean = this.jdField_i_of_type_Boolean;
      ((aqdc)localObject).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((aqdc)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((aqdc)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      if (((aqdc)localObject).jdField_b_of_type_Int < 0) {
        ((aqdc)localObject).jdField_b_of_type_Int = 0;
      }
      View localView = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(((aqdc)localObject).jdField_b_of_type_Int);
      if (localView != null) {
        ((aqdc)localObject).jdField_c_of_type_Int = localView.getTop();
      }
      aqbg.jdField_a_of_type_Aqdb.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      aqbg.jdField_a_of_type_Aqdb.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
      aqbg.jdField_a_of_type_Aqdb.jdField_a_of_type_Int = this.jdField_l_of_type_Int;
      aqbg.jdField_a_of_type_Aqdb.a((aqdc)localObject, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_l_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      if (aqbg.jdField_a_of_type_Aqdb != null) {
        break label221;
      }
    }
    label221:
    for (Object localObject = "null";; localObject = aqbg.jdField_a_of_type_Aqdb.toString())
    {
      QLog.i("ExtendFriendSquareFragment", 2, String.format("saveCacheData %s", new Object[] { localObject }));
      return;
    }
  }
  
  private void r()
  {
    List localList = null;
    if (this.jdField_a_of_type_Aqbg != null) {
      localList = this.jdField_a_of_type_Aqbg.a(2);
    }
    if (localList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, 0);
      this.jdField_b_of_type_Bhtd.post(new ExtendFriendSquareFragment.10(this));
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
      azqs.b(null, "dc00898", "", "", "kuolie", "0X80097DD", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, "onMatchItemClick, showExtendFriendQuestionDialog");
      }
      return;
    }
    if (this.jdField_a_of_type_Aqeb != null)
    {
      this.jdField_a_of_type_Aqeb.a();
      aqhg.a().b(2);
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A5", "0X80096A5", 0, 0, "", "", "", "");
  }
  
  public void a(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onPullDownToRefresh  mRecyclerViewScrollY:" + this.jdField_h_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSquareFragment", 2, "onPullDownToRefresh state:" + paramPullToRefreshBase.a() + " lastCacheOk:" + this.jdField_j_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Bhtd.hasMessages(10))
    {
      this.jdField_a_of_type_Bhtd.removeMessages(10);
      e();
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D4", "0X80092D4", 0, 0, "", "", "", "");
    if ((paramPullToRefreshBase.a() == PullToRefreshBase.State.MANUAL_REFRESHING) && (this.jdField_j_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.b();
    }
    for (;;)
    {
      a(this.jdField_h_of_type_Int, 0.0F);
      return;
      if (bdin.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        a(false);
        j();
        this.jdField_a_of_type_Aqfh.a(0, true);
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
    if (this.jdField_a_of_type_Aqbe != null)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Aqbe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ArrayOfByte, 20, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long, aqbg.jdField_a_of_type_JavaLangString, true);
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
  
  public void ax_()
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
      if (this.jdField_a_of_type_Aqfh != null)
      {
        i1 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
        int i2 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
        localObject1 = localArrayList;
        bool2 = bool1;
        if (i1 <= i2)
        {
          localObject1 = this.jdField_a_of_type_Aqfh.a(i1);
          localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(i1);
          if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof aqcg)))
          {
            localObject2 = (aqcg)localObject2;
            localObject1 = a(((aqcx)localObject1).mUin, ((aqcx)localObject1).mNickName, ((aqcg)localObject2).a);
            ((aqcg)localObject2).a.setImageDrawable((Drawable)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break;
      if ((localObject1 instanceof aqby))
      {
        localObject1 = ((aqby)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (aqbz)((Iterator)localObject1).next();
            if (((aqbz)localObject2).jdField_a_of_type_Int == 0)
            {
              bool1 = true;
              localArrayList = ((aqbz)localObject2).jdField_a_of_type_JavaUtilArrayList;
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
    aqgz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
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
    return localView.getHeight() * i1 - (localView.getTop() - aepi.a(11.0F, getResources()));
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
        paramIntent = this.jdField_a_of_type_Aqfh.a(this.jdField_b_of_type_Int);
      } while ((paramIntent == null) || (paramIntent.mAddFriendVerified));
      paramIntent.mAddFriendVerified = true;
      this.jdField_a_of_type_Aqfh.notifyItemChanged(this.jdField_b_of_type_Int);
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
      if (paramInt1 != this.jdField_a_of_type_Aqck.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Aqck.jdField_a_of_type_Int = paramInt1;
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update remainMatchCount=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Aqck.jdField_a_of_type_Int) }));
        }
      }
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramIntent.hasExtra("limit_chat_duration"))
      {
        paramInt2 = paramIntent.getIntExtra("limit_chat_duration", 0);
        if (paramInt2 != this.jdField_a_of_type_Aqck.jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_Aqck.jdField_b_of_type_Int = paramInt2;
          paramInt1 = i1;
          if (QLog.isColorLevel())
          {
            QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update limitChatDuration=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Aqck.jdField_b_of_type_Int) }));
            paramInt1 = i1;
          }
        }
      }
      while ((paramInt1 != 0) && (this.jdField_a_of_type_Aqfh != null)) {
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aqbl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
      ((aqbg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_b_of_type_Bhtd = new bhtd(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Aqen = new aqen(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    m();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onCreateView");
    }
    this.n = aepi.a(35.0F, getResources());
    this.jdField_i_of_type_Int = aepi.a(160.0F, getResources());
    paramLayoutInflater = paramLayoutInflater.inflate(2131560960, null);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131372496));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new aqiy(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setId(2131375543);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    ((SimpleItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new aqfb(this));
    this.jdField_a_of_type_Aqfi = new aqfi(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new aqfc(this);
    this.jdField_a_of_type_Aqfh = new aqfh(this, this, this, this, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
    this.jdField_a_of_type_Aqfh.a(aepi.a(35.0F, getResources()));
    this.jdField_a_of_type_Aqfh.registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    this.jdField_a_of_type_Aqfh.a(this.jdField_a_of_type_Aqen);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aqfh);
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout = ((NearbyZanAnimLayout)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131367633));
    paramViewGroup = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131364788);
    paramViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new aqfd(this, paramViewGroup));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView = ((ExtendFriendSearchBarView)paramLayoutInflater.findViewById(2131376222));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setItemClickListener(new aqfe(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView = ((ExtendFriendBottomBarView)paramLayoutInflater.findViewById(2131363377));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.setOnClickListener(new aqff(this));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onDestroy");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_Aqen != null)
    {
      this.jdField_a_of_type_Aqen.a();
      this.jdField_a_of_type_Aqen = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aqbl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver != null) {
      this.jdField_a_of_type_Aqfh.unregisterAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    }
    this.jdField_a_of_type_Aqfh.b();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.jdField_a_of_type_Aqbe = null;
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
        this.jdField_b_of_type_JavaLangString = aqbg.jdField_a_of_type_JavaLangString;
        List localList = this.jdField_a_of_type_Aqbg.a(2);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, 0);
        this.jdField_b_of_type_Bhtd.removeMessages(11);
        this.jdField_b_of_type_Bhtd.sendEmptyMessageDelayed(11, 500L);
        this.jdField_f_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, String.format("onResume loadSuccess=%s interval=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) }));
        }
        this.jdField_b_of_type_Bhtd.postDelayed(new ExtendFriendSquareFragment.8(this), 100L);
      }
    }
    for (;;)
    {
      a(this.jdField_h_of_type_Int, 0.0F);
      return;
      this.jdField_j_of_type_Boolean = true;
      break;
      if (b())
      {
        this.jdField_j_of_type_Boolean = false;
        this.jdField_b_of_type_Bhtd.removeMessages(11);
        this.jdField_b_of_type_Bhtd.sendEmptyMessageDelayed(11, 500L);
      }
      else
      {
        p();
        this.jdField_a_of_type_Aqfh.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment
 * JD-Core Version:    0.7.0.1
 */