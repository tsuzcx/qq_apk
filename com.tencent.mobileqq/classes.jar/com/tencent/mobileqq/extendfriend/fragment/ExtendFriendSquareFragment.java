package com.tencent.mobileqq.extendfriend.fragment;

import aciy;
import ajjh;
import amhe;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anod;
import anoe;
import anoj;
import anow;
import anox;
import anpb;
import anpd;
import anpg;
import anpv;
import anpx;
import anpy;
import anqp;
import anrl;
import anrv;
import anrw;
import anrx;
import anry;
import anrz;
import ansa;
import ansb;
import ansc;
import ansd;
import anse;
import ansf;
import ansg;
import ansi;
import ansj;
import ansl;
import antj;
import antp;
import anuj;
import anux;
import awqx;
import azwp;
import bacm;
import badq;
import baiu;
import befq;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.State;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendHorizontalTagsView;
import com.tencent.mobileqq.extendfriend.wiget.InterceptHorizontalScrollView;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import mjh;

public class ExtendFriendSquareFragment
  extends ExtendFriendBaseFragment
  implements View.OnClickListener, antp<RecyclerView>
{
  private ajjh jdField_a_of_type_Ajjh = new ansc(this);
  public View a;
  public Interpolator a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private anoj jdField_a_of_type_Anoj = new anrv(this);
  private anow jdField_a_of_type_Anow = new anow();
  private anpd jdField_a_of_type_Anpd = new anpd();
  private anqp jdField_a_of_type_Anqp;
  private anrl jdField_a_of_type_Anrl;
  public Animator.AnimatorListener a;
  public ValueAnimator a;
  public ExtendFriendHorizontalTagsView a;
  InterceptHorizontalScrollView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetInterceptHorizontalScrollView;
  QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  ArrayList<ImageView> jdField_a_of_type_JavaUtilArrayList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private befq jdField_b_of_type_Befq;
  public Animator.AnimatorListener b;
  public ValueAnimator b;
  private String c;
  public long d = -1L;
  private long e;
  public boolean e;
  private long f;
  public boolean f;
  public boolean g;
  public int h;
  boolean h;
  public int i;
  boolean i;
  public int j;
  boolean j;
  int jdField_k_of_type_Int;
  boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int = 1;
  boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int = -1;
  private boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int;
  private boolean jdField_o_of_type_Boolean;
  private boolean p;
  private boolean q;
  private boolean r;
  private volatile boolean s;
  
  public ExtendFriendSquareFragment()
  {
    this.jdField_i_of_type_Int = 480;
    this.jdField_c_of_type_JavaLangString = anoe.jdField_a_of_type_JavaLangString;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_j_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new LinearInterpolator();
  }
  
  private void a(int paramInt, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSquareFragment", 2, "updateSearchBarState scrollY: " + paramInt + "  speed: " + paramFloat);
    }
    if (paramInt < this.jdField_i_of_type_Int) {
      if (paramInt > this.jdField_o_of_type_Int / 2) {
        if (paramFloat > 0.0F) {
          g(false);
        }
      }
    }
    do
    {
      return;
      f(false);
      return;
      if (paramFloat < -5.0F)
      {
        f(false);
        return;
      }
    } while (paramFloat <= 0.5D);
    g(false);
  }
  
  private void a(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (!TextUtils.isEmpty(paramString))
    {
      i1 = 0;
      localObject1 = localObject2;
      if (i1 < this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView.getChildCount())
      {
        localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView.getChildAt(i1);
        if ((!(((TextView)localObject1).getTag() instanceof anuj)) || (!paramString.equals(((anuj)((TextView)localObject1).getTag()).jdField_a_of_type_JavaLangString))) {}
      }
    }
    for (int i1 = ((TextView)localObject1).getRight();; i1 = 0)
    {
      int i2 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetInterceptHorizontalScrollView.getWidth();
      if ((i1 > i2) && (i2 > 0) && (localObject1 != null)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetInterceptHorizontalScrollView.scrollTo(i1 - i2, 0);
      }
      return;
      i1 += 1;
      break;
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<anpv> paramList, anpd paramanpd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList success=%s searchKey=%s", new Object[] { Boolean.valueOf(paramBoolean1), paramString }));
    }
    if ((!isAdded()) || (this.jdField_a_of_type_Ansi == null)) {
      return;
    }
    paramString = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getTag(2131309276);
    if ((paramString != null) && ((paramString instanceof Integer))) {}
    for (int i1 = ((Integer)paramString).intValue();; i1 = 0)
    {
      paramString = this.jdField_a_of_type_Ansi;
      int i2;
      if (paramBoolean1)
      {
        i2 = 0;
        paramString.c(i2);
        if ((paramBoolean1) && (paramList != null)) {
          break label298;
        }
        if (this.jdField_o_of_type_Boolean) {
          this.jdField_a_of_type_Ansi.a(1, true);
        }
        if (this.jdField_l_of_type_Int != 0) {
          break label282;
        }
        paramInt = 2131629294;
        label132:
        if (i1 == 1)
        {
          if (this.jdField_l_of_type_Int != 0) {
            break label290;
          }
          paramInt = 2131629294;
        }
        label150:
        a(getString(paramInt), 1);
        if (this.jdField_a_of_type_Ansi.getItemCount() == 0) {
          this.jdField_a_of_type_Ansi.a(true);
        }
        this.jdField_a_of_type_Ansi.notifyDataSetChanged();
        if ((!this.jdField_o_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null))
        {
          if (!paramBoolean1) {
            break label646;
          }
          paramInt = 2131633262;
          label209:
          if (i1 != 1) {
            break label662;
          }
          if (!paramBoolean1) {
            break label654;
          }
          paramInt = 2131633257;
        }
      }
      label646:
      label654:
      label662:
      for (;;)
      {
        paramString = getResources().getString(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false).setRefreshResultLabel(paramString);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.b();
        i(0);
        this.jdField_n_of_type_Boolean = false;
        g();
        b(true);
        return;
        i2 = 1;
        break;
        label282:
        paramInt = 2131633260;
        break label132;
        label290:
        paramInt = 2131633256;
        break label150;
        label298:
        this.p = paramBoolean2;
        this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.jdField_a_of_type_Boolean = paramBoolean3;
        this.jdField_b_of_type_Boolean = paramBoolean4;
        this.jdField_m_of_type_Int = paramInt;
        this.jdField_a_of_type_Anpd.jdField_a_of_type_Int = paramanpd.jdField_a_of_type_Int;
        this.jdField_a_of_type_Anpd.jdField_b_of_type_Int = paramanpd.jdField_b_of_type_Int;
        this.jdField_a_of_type_Anpd.jdField_c_of_type_Int = paramanpd.jdField_c_of_type_Int;
        this.jdField_a_of_type_Anpd.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_Anpd.jdField_a_of_type_JavaUtilList.addAll(paramanpd.jdField_a_of_type_JavaUtilList);
        a(this.jdField_a_of_type_Anpd.jdField_a_of_type_JavaUtilList);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList mLoadOver=%s mRequestCookies=%s mProfileComplete=%s mShowCard=%s mMaxLikeCount=%s matchCount=%d limitDuration=%d", new Object[] { Boolean.valueOf(this.p), this.jdField_a_of_type_ArrayOfByte, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_m_of_type_Int), Integer.valueOf(paramanpd.jdField_a_of_type_Int), Integer.valueOf(paramanpd.jdField_b_of_type_Int) }));
        }
        if (!this.jdField_o_of_type_Boolean)
        {
          this.jdField_a_of_type_Ansi.a();
          if (!c()) {
            break label638;
          }
          d();
        }
        for (;;)
        {
          if (this.p) {
            this.jdField_a_of_type_Ansi.a(2, false);
          }
          this.jdField_a_of_type_Ansi.a(paramList);
          if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
          {
            paramString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
            if (paramString != null)
            {
              this.jdField_e_of_type_Long = System.currentTimeMillis();
              this.jdField_n_of_type_Int = Calendar.getInstance().get(6);
              paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131653905), baiu.a(this.jdField_e_of_type_Long, true, "yyyy-MM-dd") }));
            }
          }
          u();
          break;
          label638:
          e();
        }
        paramInt = 2131633260;
        break label209;
        paramInt = 2131633256;
      }
    }
  }
  
  private boolean a(boolean paramBoolean, String paramString)
  {
    boolean bool2 = false;
    List localList = this.jdField_a_of_type_Anoe.a();
    boolean bool1 = bool2;
    int i1;
    int i2;
    Object localObject;
    if (anoe.jdField_a_of_type_Anpx != null)
    {
      bool1 = bool2;
      if (anoe.jdField_a_of_type_Anpx.jdField_a_of_type_JavaUtilList != null)
      {
        bool1 = bool2;
        if (anoe.jdField_a_of_type_Anpx.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          if (!paramBoolean) {
            break label571;
          }
          paramString = anoe.jdField_a_of_type_Anpx.a();
          if ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList.size() <= 0) || (!localList.contains(paramString.jdField_a_of_type_JavaLangString))) {
            break label565;
          }
          bool1 = true;
          if (bool1)
          {
            this.jdField_a_of_type_Boolean = anoe.jdField_a_of_type_Anpx.jdField_a_of_type_Boolean;
            this.jdField_b_of_type_Boolean = anoe.jdField_a_of_type_Anpx.jdField_b_of_type_Boolean;
            this.jdField_m_of_type_Int = anoe.jdField_a_of_type_Anpx.jdField_a_of_type_Int;
            this.p = paramString.jdField_a_of_type_Boolean;
            this.jdField_a_of_type_ArrayOfByte = paramString.jdField_a_of_type_ArrayOfByte;
            this.jdField_e_of_type_Long = paramString.jdField_a_of_type_Long;
            this.jdField_n_of_type_Int = paramString.jdField_a_of_type_Int;
            this.jdField_c_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
            i1 = paramString.jdField_b_of_type_Int;
            i2 = paramString.jdField_c_of_type_Int;
            if (paramString.jdField_a_of_type_JavaUtilList.size() > 0)
            {
              localObject = (anpv)paramString.jdField_a_of_type_JavaUtilList.get(0);
              if (!(localObject instanceof anpd)) {
                break label607;
              }
              localObject = (anpd)localObject;
              if (this.jdField_a_of_type_Anpd != localObject)
              {
                this.jdField_a_of_type_Anpd.jdField_a_of_type_Int = ((anpd)localObject).jdField_a_of_type_Int;
                this.jdField_a_of_type_Anpd.jdField_b_of_type_Int = ((anpd)localObject).jdField_b_of_type_Int;
                this.jdField_a_of_type_Anpd.jdField_c_of_type_Int = ((anpd)localObject).jdField_c_of_type_Int;
                this.jdField_a_of_type_Anpd.jdField_a_of_type_JavaUtilList.clear();
                this.jdField_a_of_type_Anpd.jdField_a_of_type_JavaUtilList.addAll(((anpd)localObject).jdField_a_of_type_JavaUtilList);
                a(this.jdField_a_of_type_Anpd.jdField_a_of_type_JavaUtilList);
              }
            }
            label311:
            if (paramBoolean)
            {
              int i3 = localList.indexOf(this.jdField_c_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView.setSearchTags((ArrayList)localList, i3);
            }
            if (this.jdField_a_of_type_Ansi != null)
            {
              if (!this.p) {
                break label625;
              }
              this.jdField_a_of_type_Ansi.a(2, false);
              label365:
              this.jdField_a_of_type_Ansi.a();
              this.jdField_a_of_type_Ansi.a(paramString.jdField_a_of_type_JavaUtilList);
              if (!c()) {
                break label637;
              }
              d();
            }
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ansi.notifyDataSetChanged();
      if (Math.abs(System.currentTimeMillis() - this.jdField_e_of_type_Long) < 60000L) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new ExtendFriendSquareFragment.9(this, i1, i2), 100L);
      }
      g();
      b(true);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
        if (paramString != null) {
          paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131653905), baiu.a(this.jdField_e_of_type_Long, true, "yyyy-MM-dd") }));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendSquareFragment", 2, String.format("loadCacheData result=%b ts=%d tag=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(this.jdField_e_of_type_Long), this.jdField_c_of_type_JavaLangString }));
      }
      return bool1;
      label565:
      bool1 = false;
      break;
      label571:
      paramString = anoe.jdField_a_of_type_Anpx.a(paramString);
      if ((paramString != null) && (paramString.jdField_a_of_type_JavaUtilList.size() > 0)) {}
      for (bool1 = true;; bool1 = false) {
        break;
      }
      label607:
      if (!(localObject instanceof anow)) {
        break label311;
      }
      localObject = (anow)localObject;
      break label311;
      label625:
      this.jdField_a_of_type_Ansi.a(0, false);
      break label365;
      label637:
      e();
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_j_of_type_Int = (((FrameLayout.LayoutParams)paramView.getLayoutParams()).topMargin + paramView.getHeight());
    this.g = true;
  }
  
  private void b(List<String> paramList)
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
        int i1 = this.jdField_a_of_type_Ansi.a((String)localObject);
        if (i1 >= 0)
        {
          localObject = this.jdField_a_of_type_Ansi.a(i1);
          if ((localObject != null) && (!((anpv)localObject).mAddFriendVerified))
          {
            ((anpv)localObject).mAddFriendVerified = true;
            this.jdField_a_of_type_Ansi.notifyItemChanged(i1);
          }
        }
      }
    }
  }
  
  private boolean b()
  {
    if (this.jdField_n_of_type_Int < 0) {}
    while (Calendar.getInstance().get(6) == this.jdField_n_of_type_Int) {
      return false;
    }
    return true;
  }
  
  @TargetApi(11)
  private void c(View paramView)
  {
    if (!this.g) {
      b(paramView);
    }
    if (this.jdField_j_of_type_Int <= 0) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(200L);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new anrw(this, localLayoutParams, paramView));
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new anrx(this);
    }
    if ((this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
    {
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  private boolean c()
  {
    return this.s;
  }
  
  @TargetApi(11)
  private void d(View paramView)
  {
    if (!this.g) {
      b(paramView);
    }
    if (this.jdField_j_of_type_Int <= 0) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    if (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(200L);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new anry(this, localLayoutParams, paramView));
      this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new anrz(this, paramView);
    }
    if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  private boolean d()
  {
    Object localObject;
    int i1;
    label243:
    boolean bool1;
    if ((this.jdField_a_of_type_Ansi != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (anoe.jdField_a_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString)))
    {
      if (!((anoe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).d())
      {
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendSquareFragment", 2, "refreshFeedBanner LimitChatSwithOpen false");
        }
        return true;
      }
      this.jdField_h_of_type_Boolean = true;
      localObject = this.jdField_a_of_type_Ansi.a(0);
      if ((localObject instanceof anow))
      {
        localObject = (anow)localObject;
        i1 = 0;
        if (((anow)localObject).jdField_a_of_type_JavaUtilArrayList == null) {
          break label377;
        }
        localObject = ((anow)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            anox localanox = (anox)((Iterator)localObject).next();
            if (localanox.jdField_a_of_type_Int == 0)
            {
              if ((this.jdField_a_of_type_Anpd.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_Anpd.jdField_a_of_type_JavaUtilList.isEmpty())) {
                localanox.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_Anpd.jdField_a_of_type_JavaUtilList);
              }
              localObject = localanox;
              if (this.jdField_a_of_type_Anpd.jdField_c_of_type_Int > 0)
              {
                localanox.jdField_b_of_type_JavaLangString = (this.jdField_a_of_type_Anpd.jdField_c_of_type_Int + getResources().getString(2131633249));
                localObject = localanox;
              }
              if (i1 != 0)
              {
                this.jdField_a_of_type_Ansi.notifyDataSetChanged();
                bool1 = true;
                label256:
                bool2 = bool1;
                if (this.jdField_h_of_type_Boolean)
                {
                  bool2 = bool1;
                  if (!this.r)
                  {
                    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A4", "0X80096A4", 0, 0, "", "", "", "");
                    this.r = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      return bool2;
      if ((localObject instanceof anpd)) {
        this.jdField_a_of_type_Ansi.b(0);
      }
      this.jdField_a_of_type_Ansi.a(0, this.jdField_a_of_type_Anow);
      localObject = this.jdField_a_of_type_Anow;
      i1 = 1;
      break;
      if (localObject != null) {
        this.jdField_a_of_type_Ansi.a((anox)localObject);
      }
      bool1 = false;
      break label256;
      label377:
      localObject = null;
      break label243;
    }
  }
  
  private boolean e()
  {
    Object localObject;
    boolean bool1;
    if ((this.jdField_a_of_type_Ansi != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      boolean bool2 = ((anoe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).d();
      localObject = (ansl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(292);
      if ((anoe.jdField_a_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString)) && (bool2))
      {
        bool1 = true;
        this.jdField_h_of_type_Boolean = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, "limitchat refreshMatchFeedShow = " + this.jdField_h_of_type_Boolean + ", searchKey = " + this.jdField_c_of_type_JavaLangString + ", resReady = " + true + ", isBottomBarVisible = " + this.jdField_l_of_type_Boolean + ", isSwitchOpen = " + bool2);
        }
        if ((!this.jdField_h_of_type_Boolean) && (this.jdField_l_of_type_Boolean)) {
          q();
        }
        localObject = this.jdField_a_of_type_Ansi.a(0);
        if ((localObject == null) || (!((anpv)localObject).mIsMyFeed)) {
          break label357;
        }
        localObject = this.jdField_a_of_type_Ansi.a(1);
      }
    }
    label352:
    label357:
    for (int i1 = 1;; i1 = 0)
    {
      if ((localObject != null) && ((localObject instanceof anpd))) {
        if (this.jdField_h_of_type_Boolean)
        {
          if (((anpd)localObject).jdField_c_of_type_Int <= 0) {
            break label352;
          }
          bool1 = true;
        }
      }
      for (;;)
      {
        if ((this.jdField_h_of_type_Boolean) && (!this.r))
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A4", "0X80096A4", 0, 0, "", "", "", "");
          this.r = true;
        }
        return bool1;
        bool1 = false;
        break;
        this.jdField_a_of_type_Ansi.b(i1);
        bool1 = true;
        continue;
        if (this.jdField_h_of_type_Boolean)
        {
          if ((localObject instanceof anow)) {
            this.jdField_a_of_type_Ansi.b(i1);
          }
          this.jdField_a_of_type_Ansi.a(i1, this.jdField_a_of_type_Anpd);
          bool1 = true;
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, "showSearchBar  direct=" + paramBoolean + "  mSearchBarIsVisible:" + this.jdField_f_of_type_Boolean + " mSearchBarOffset:" + this.jdField_j_of_type_Int);
      }
      if (paramBoolean)
      {
        if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
        {
          this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
          this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
        }
        n();
        this.jdField_f_of_type_Boolean = true;
        return;
      }
      if (!this.jdField_f_of_type_Boolean) {
        break;
      }
    } while ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null) || (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()) || (((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).topMargin == 0));
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "showSearchBar catch a display exception");
    }
    n();
    return;
    this.jdField_f_of_type_Boolean = true;
    c(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, "hideSearchBar  direct=" + paramBoolean + "  mSearchBarIsVisible:" + this.jdField_f_of_type_Boolean + " mSearchBarOffset:" + this.jdField_j_of_type_Int);
      }
    } while (!this.jdField_f_of_type_Boolean);
    this.jdField_f_of_type_Boolean = false;
    if (!paramBoolean)
    {
      d(this.jdField_a_of_type_AndroidViewView);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.topMargin = (-this.jdField_j_of_type_Int);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void i(int paramInt)
  {
    int i1 = 1;
    antj localantj = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
    if (paramInt == 1) {
      if (i1 == 0) {
        break label58;
      }
    }
    label58:
    for (i1 = 2131633258;; i1 = 2131633261)
    {
      localantj.setRefreshingLabel(getResources().getString(i1));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setTag(2131309276, Integer.valueOf(paramInt));
      return;
      i1 = 0;
      break;
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_Anow.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    Object localObject = ((anoe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      this.s = true;
      anox localanox = new anox();
      localanox.jdField_a_of_type_Int = 0;
      localanox.jdField_a_of_type_JavaLangString = getResources().getString(2131633233);
      localanox.jdField_c_of_type_Int = -20771;
      localanox.jdField_d_of_type_Int = -31578;
      localanox.jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
      this.jdField_a_of_type_Anow.jdField_a_of_type_JavaUtilArrayList.add(localanox);
      localObject = ((ArrayList)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        amhe localamhe = (amhe)((Iterator)localObject).next();
        localanox = new anox();
        localanox.jdField_a_of_type_JavaLangString = localamhe.jdField_c_of_type_JavaLangString;
        localanox.jdField_b_of_type_Int = localamhe.jdField_a_of_type_Int;
        localanox.jdField_b_of_type_JavaLangString = localamhe.jdField_d_of_type_JavaLangString;
        if ("0".equals(localamhe.f)) {
          localanox.jdField_a_of_type_Int = 0;
        }
        for (;;)
        {
          localanox.jdField_d_of_type_JavaLangString = localamhe.g;
          localanox.jdField_c_of_type_JavaLangString = localamhe.e;
          try
          {
            if (localamhe.jdField_a_of_type_JavaLangString != null) {
              localanox.jdField_c_of_type_Int = Color.parseColor(localamhe.jdField_a_of_type_JavaLangString);
            }
            if (localamhe.jdField_b_of_type_JavaLangString != null) {
              localanox.jdField_d_of_type_Int = Color.parseColor(localamhe.jdField_b_of_type_JavaLangString);
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
          this.jdField_a_of_type_Anow.jdField_a_of_type_JavaUtilArrayList.add(localanox);
          break;
          if ("1".equals(localamhe.f)) {
            localanox.jdField_a_of_type_Int = 1;
          } else if ("2".equals(localamhe.f)) {
            localanox.jdField_a_of_type_Int = 2;
          } else {
            localanox.jdField_a_of_type_Int = -1;
          }
        }
      }
    }
    else
    {
      this.s = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "initFeedBannerData " + this.s + this.jdField_a_of_type_Anow.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  private void s()
  {
    if ((!isAdded()) || (this.jdField_a_of_type_Ansi == null)) {}
    do
    {
      do
      {
        return;
      } while (this.q);
      if (!badq.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView == null);
    i(1);
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.d())
    {
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setRefreshing();
    this.jdField_a_of_type_Ansi.a(0, true);
    return;
    this.jdField_l_of_type_Int = 0;
    t();
  }
  
  private void t()
  {
    a(false, this.jdField_c_of_type_JavaLangString, false, null, false, false, 0, null, null);
  }
  
  private void u()
  {
    if (anoe.jdField_a_of_type_Anpx == null) {
      anoe.jdField_a_of_type_Anpx = new anpx();
    }
    if (this.jdField_a_of_type_Ansi != null)
    {
      localObject = new anpy();
      ((anpy)localObject).jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Ansi.a());
      ((anpy)localObject).jdField_a_of_type_Long = this.jdField_e_of_type_Long;
      ((anpy)localObject).jdField_a_of_type_Int = this.jdField_n_of_type_Int;
      ((anpy)localObject).jdField_a_of_type_Boolean = this.p;
      ((anpy)localObject).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((anpy)localObject).jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      ((anpy)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      if (((anpy)localObject).jdField_b_of_type_Int < 0) {
        ((anpy)localObject).jdField_b_of_type_Int = 0;
      }
      View localView = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(((anpy)localObject).jdField_b_of_type_Int);
      if (localView != null) {
        ((anpy)localObject).jdField_c_of_type_Int = localView.getTop();
      }
      anoe.jdField_a_of_type_Anpx.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      anoe.jdField_a_of_type_Anpx.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
      anoe.jdField_a_of_type_Anpx.jdField_a_of_type_Int = this.jdField_m_of_type_Int;
      anoe.jdField_a_of_type_Anpx.a((anpy)localObject, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_m_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      if (anoe.jdField_a_of_type_Anpx != null) {
        break label221;
      }
    }
    label221:
    for (Object localObject = "null";; localObject = anoe.jdField_a_of_type_Anpx.toString())
    {
      QLog.i("ExtendFriendSquareFragment", 2, String.format("saveCacheData %s", new Object[] { localObject }));
      return;
    }
  }
  
  protected int a()
  {
    return 1031;
  }
  
  public void a()
  {
    boolean bool2 = false;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    boolean bool1 = bool2;
    int i3;
    int i1;
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null)
    {
      localObject1 = localObject3;
      bool1 = bool2;
      if (this.jdField_a_of_type_Ansi != null)
      {
        i3 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
        int i4 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
        i1 = i3;
        bool1 = false;
        localObject1 = localObject2;
        if (i1 <= i4)
        {
          localObject2 = this.jdField_a_of_type_Ansi.a(i1);
          localObject3 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(i1);
          if ((localObject2 != null) && (localObject3 != null) && ((localObject3 instanceof anpb)))
          {
            localObject3 = (anpb)localObject3;
            localObject2 = a(((anpv)localObject2).mUin, ((anpv)localObject2).mNickName, ((anpb)localObject3).a);
            ((anpb)localObject3).a.setImageDrawable((Drawable)localObject2);
          }
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break;
      if ((localObject2 != null) && (localObject3 != null) && ((localObject3 instanceof anpg)))
      {
        localObject1 = (anpg)localObject3;
        localObject2 = (anpd)localObject2;
        if (i1 == i3) {}
        for (int i2 = this.jdField_o_of_type_Int;; i2 = 0)
        {
          ((anpg)localObject1).a((anpg)localObject1, (anpd)localObject2, i2);
          localObject1 = this.jdField_a_of_type_Anpd.jdField_a_of_type_JavaUtilList;
          bool1 = true;
          break;
        }
      }
      if ((localObject2 instanceof anow))
      {
        localObject2 = ((anow)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (anox)((Iterator)localObject2).next();
            if (((anox)localObject3).jdField_a_of_type_Int == 0)
            {
              localObject1 = ((anox)localObject3).jdField_a_of_type_JavaUtilArrayList;
              bool1 = true;
              break;
              if (this.jdField_h_of_type_Boolean)
              {
                e(bool1);
                a((List)localObject1);
              }
              return;
            }
          }
        }
      }
    }
  }
  
  void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131297793));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131301804));
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297255);
    Object localObject = localImageView.getDrawable();
    if ((localObject instanceof SkinnableBitmapDrawable)) {}
    for (localObject = ((SkinnableBitmapDrawable)localObject).mutate2();; localObject = ((Drawable)localObject).mutate())
    {
      ((Drawable)localObject).setColorFilter(-16578534, PorterDuff.Mode.SRC_ATOP);
      localImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      int i1 = 0;
      while (i1 < this.jdField_b_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        localObject = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getChildAt(i1);
        ((ImageView)localObject).setVisibility(8);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        i1 += 1;
      }
    }
    this.jdField_k_of_type_Int = aciy.a(66.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTranslationY(this.jdField_k_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new ansa(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)paramView.findViewById(2131297800));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setTranslationY(this.jdField_k_of_type_Int);
    o();
  }
  
  public void a(anqp paramanqp)
  {
    this.jdField_a_of_type_Anqp = paramanqp;
  }
  
  public void a(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onPullDownToRefresh  mRecyclerViewScrollY:" + this.jdField_h_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSquareFragment", 2, "onPullDownToRefresh state:" + paramPullToRefreshBase.a() + " lastCacheOk:" + this.q);
    }
    if (this.jdField_a_of_type_Befq.hasMessages(10))
    {
      this.jdField_a_of_type_Befq.removeMessages(10);
      e();
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D4", "0X80092D4", 0, 0, "", "", "", "");
    if ((paramPullToRefreshBase.a() == PullToRefreshBase.State.MANUAL_REFRESHING) && (this.q)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.b();
    }
    for (;;)
    {
      a(this.jdField_h_of_type_Int, 0.0F);
      return;
      if (badq.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        a(false);
        j();
        this.jdField_a_of_type_Ansi.a(0, true);
      }
      else
      {
        this.jdField_l_of_type_Int = 0;
        t();
      }
    }
  }
  
  void a(List<String> paramList)
  {
    if (paramList == null) {}
    int i2;
    label41:
    label77:
    do
    {
      return;
      i2 = paramList.size();
      int i1;
      ImageView localImageView;
      String str;
      if (i2 > 0)
      {
        i1 = 1;
        if (i1 == 0) {
          break label145;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
        i1 = 0;
        if (i1 >= i3) {
          continue;
        }
        localImageView = (ImageView)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (i1 >= i2) {
          break label129;
        }
        str = (String)paramList.get(i1);
        if (TextUtils.isEmpty(str)) {
          break label135;
        }
        Drawable localDrawable = bacm.a(true);
        localImageView.setImageDrawable(azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str, 4, localDrawable, localDrawable));
        localImageView.setVisibility(0);
      }
      for (;;)
      {
        i1 += 1;
        break label41;
        i1 = 0;
        break;
        str = null;
        break label77;
        localImageView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    } while (!QLog.isColorLevel());
    label129:
    label135:
    label145:
    QLog.d("ExtendFriendSquareFragment", 2, "updateBottomBarHeadUI infoListSize = " + i2 + ",mScrolling = " + this.jdField_c_of_type_Boolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("requestSquareStrangerList loadMore=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.jdField_o_of_type_Boolean = paramBoolean;
    if (!this.jdField_o_of_type_Boolean)
    {
      this.p = false;
      this.jdField_a_of_type_ArrayOfByte = null;
    }
    if (this.jdField_a_of_type_Anod != null)
    {
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Anod.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ArrayOfByte, 20, this.jdField_c_of_type_JavaLangString, this.jdField_f_of_type_Long, anoe.jdField_a_of_type_JavaLangString, true);
      this.jdField_n_of_type_Boolean = true;
    }
    if (!paramBoolean) {}
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if ((paramBoolean1) || (paramBoolean2)) {
      u();
    }
  }
  
  protected int b()
  {
    return this.jdField_m_of_type_Int;
  }
  
  public void b(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onPullUpToRefresh  mRecyclerViewScrollY:" + this.jdField_h_of_type_Int);
    }
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
    return localView.getHeight() * i1 - (localView.getTop() - aciy.a(11.0F, getResources()));
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "limitchat enter match");
    }
    if (a())
    {
      awqx.b(null, "dc00898", "", "", "kuolie", "0X80097DD", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, "onMatchItemClick, showExtendFriendQuestionDialog");
      }
      return;
    }
    if (this.jdField_a_of_type_Anqp != null)
    {
      awqx.b(null, "dc00898", "", "", "0X800A68C", "0X800A68C", 2, 0, "", "", "", "");
      this.jdField_a_of_type_Anqp.a();
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A5", "0X80096A5", 0, 0, "", "", "", "");
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView == null)) {}
    while ((this.jdField_e_of_type_Boolean) && (!paramBoolean)) {
      return;
    }
    Object localObject = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen((int[])localObject);
    int i3 = localObject[1];
    int i2 = this.jdField_a_of_type_AndroidViewView.getHeight();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.getHeight() + i3;
    if ((i1 <= i3) || (i3 <= 0) || (i2 <= 0))
    {
      i1 = 1920;
      i3 = 223;
      i2 = 105;
    }
    for (;;)
    {
      int i5 = i3 * 36 / i1;
      int i4 = (i3 + i2) * 36 / i1;
      int i6 = i3 * -35 / i1;
      i1 = (i2 + i3) * -35 / i1;
      i2 = Color.argb(255, 79 - i5, 127 - i6, 255);
      i1 = Color.argb(255, 79 - i4, 127 - i1, 255);
      localObject = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i2, i1 });
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
      return;
      this.jdField_e_of_type_Boolean = true;
    }
  }
  
  void e(boolean paramBoolean)
  {
    if (!this.jdField_j_of_type_Boolean)
    {
      this.jdField_j_of_type_Boolean = true;
      this.jdField_i_of_type_Boolean = paramBoolean;
      if (!this.jdField_i_of_type_Boolean) {
        p();
      }
    }
    do
    {
      return;
      if ((!this.jdField_i_of_type_Boolean) && (paramBoolean)) {
        q();
      }
      if ((this.jdField_i_of_type_Boolean) && (!paramBoolean)) {
        p();
      }
    } while (this.jdField_i_of_type_Boolean == paramBoolean);
    this.jdField_i_of_type_Boolean = paramBoolean;
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
      s();
    }
  }
  
  @TargetApi(11)
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "resetSearchBar  mSearchBarIsVisible:" + this.jdField_f_of_type_Boolean + "  mTitleBarOffset:" + this.jdField_j_of_type_Int);
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, "resetSearchBar exit null");
      }
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.topMargin = 0;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
    QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (Build.VERSION.SDK_INT >= 24) {}
    for (boolean bool = true;; bool = false)
    {
      localQQBlurView.setEnableBlur(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130849472);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ansb(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      this.jdField_k_of_type_Boolean = true;
      return;
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
      m();
      a(true, true);
      if (paramInt2 == 8193) {
        l();
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
        paramIntent = this.jdField_a_of_type_Ansi.a(this.jdField_b_of_type_Int);
      } while ((paramIntent == null) || (paramIntent.mAddFriendVerified));
      paramIntent.mAddFriendVerified = true;
      this.jdField_a_of_type_Ansi.notifyItemChanged(this.jdField_b_of_type_Int);
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
      b(paramIntent.getStringArrayListExtra("add_frd_list"));
    }
    if (paramIntent.hasExtra("remain_match_count"))
    {
      paramInt1 = paramIntent.getIntExtra("remain_match_count", 0);
      if (paramInt1 != this.jdField_a_of_type_Anpd.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Anpd.jdField_a_of_type_Int = paramInt1;
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update remainMatchCount=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Anpd.jdField_a_of_type_Int) }));
        }
      }
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramIntent.hasExtra("limit_chat_duration"))
      {
        paramInt2 = paramIntent.getIntExtra("limit_chat_duration", 0);
        if (paramInt2 != this.jdField_a_of_type_Anpd.jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_Anpd.jdField_b_of_type_Int = paramInt2;
          paramInt1 = i1;
          if (QLog.isColorLevel())
          {
            QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update limitChatDuration=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Anpd.jdField_b_of_type_Int) }));
            paramInt1 = i1;
          }
        }
      }
      while ((paramInt1 != 0) && (this.jdField_a_of_type_Ansi != null) && (!c()))
      {
        e();
        this.jdField_a_of_type_Ansi.notifyDataSetChanged();
        return;
      }
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131297793: 
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E2F", "0X8009E2F", 0, 0, "", "", "", "");
      }
    } while (this.jdField_a_of_type_Anqp == null);
    awqx.b(null, "dc00898", "", "", "0X800A68C", "0X800A68C", 3, 0, "", "", "", "");
    this.jdField_a_of_type_Anqp.a();
    return;
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009417", "0X8009417", 0, 0, "", "", "", "");
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ExtendFriendSearchFragment.class, 3);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 2130772306);
    return;
    QLog.d("ExtendFriendSquareFragment", 2, "@gdtadv  feedbackContainer click");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onCreate");
    }
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anoj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
      ((anoe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_b_of_type_Befq = new befq(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Anrl = new anrl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    r();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onCreateView");
    }
    this.jdField_o_of_type_Int = aciy.a(35.0F, getResources());
    this.jdField_i_of_type_Int = aciy.a(160.0F, getResources());
    paramLayoutInflater = paramLayoutInflater.inflate(2131495184, null);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131306454));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new anux(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setId(2131309276);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    ((SimpleItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new ansd(this));
    this.jdField_a_of_type_Ansj = new ansj(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new anse(this);
    this.jdField_a_of_type_Ansi = new ansi(this, this, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
    this.jdField_a_of_type_Ansi.a(aciy.a(35.0F, getResources()));
    this.jdField_a_of_type_Ansi.registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    this.jdField_a_of_type_Ansi.a(this.jdField_a_of_type_Anrl);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ansi);
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout = ((NearbyZanAnimLayout)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131301878));
    paramViewGroup = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131299149);
    paramViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ansf(this, paramViewGroup));
    a(paramLayoutInflater);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131309912);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetInterceptHorizontalScrollView = ((InterceptHorizontalScrollView)paramLayoutInflater.findViewById(2131309973));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView = ((ExtendFriendHorizontalTagsView)this.jdField_a_of_type_AndroidViewView.findViewById(2131309969));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131309932).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131309932).setOnTouchListener(new mjh());
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView.setOnItemClickListener(new ansg(this));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onDestroy");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_Anrl != null)
    {
      this.jdField_a_of_type_Anrl.a();
      this.jdField_a_of_type_Anrl = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anoj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver != null) {
      this.jdField_a_of_type_Ansi.unregisterAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    }
    this.jdField_a_of_type_Ansi.b();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.jdField_a_of_type_Anod = null;
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseAll();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onResume");
    }
    super.onResume();
    if ((!this.jdField_m_of_type_Boolean) && (isAdded()))
    {
      boolean bool = a(true, null);
      long l1 = System.currentTimeMillis() - this.jdField_e_of_type_Long;
      if ((!bool) || (l1 > 60000L) || (b()))
      {
        this.q = false;
        this.jdField_c_of_type_JavaLangString = anoe.jdField_a_of_type_JavaLangString;
        List localList = this.jdField_a_of_type_Anoe.a();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView.setSearchTags((ArrayList)localList, 0);
        this.jdField_b_of_type_Befq.removeMessages(11);
        this.jdField_b_of_type_Befq.sendEmptyMessageDelayed(11, 500L);
        this.jdField_m_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, String.format("onResume loadSuccess=%s interval=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) }));
        }
        this.jdField_b_of_type_Befq.postDelayed(new ExtendFriendSquareFragment.7(this), 100L);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Befq.postDelayed(new ExtendFriendSquareFragment.8(this), 100L);
      a(this.jdField_h_of_type_Int, 0.0F);
      ApngImage.resumeAll();
      return;
      this.q = true;
      break;
      if (b())
      {
        this.q = false;
        this.jdField_b_of_type_Befq.removeMessages(11);
        this.jdField_b_of_type_Befq.sendEmptyMessageDelayed(11, 500L);
      }
      else if (!c())
      {
        if (e()) {
          this.jdField_a_of_type_Ansi.notifyDataSetChanged();
        }
      }
      else if (!d())
      {
        this.jdField_a_of_type_Ansi.notifyDataSetChanged();
      }
    }
  }
  
  void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "showBottomBar ,shouldShowMatchFeed = " + this.jdField_h_of_type_Boolean);
    }
    if (!this.jdField_h_of_type_Boolean) {
      return;
    }
    this.jdField_l_of_type_Boolean = true;
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E2E", "0X8009E2E", 0, 0, "", "", "", "");
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { this.jdField_k_of_type_Int, 0.0F });
    localObjectAnimator1.setDuration(500L);
    if (this.jdField_k_of_type_Boolean)
    {
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView, "translationY", new float[] { this.jdField_k_of_type_Int, 0.0F });
      localObjectAnimator2.setDuration(500L);
      localObjectAnimator2.start();
    }
    localObjectAnimator1.start();
  }
  
  void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "hideBottomBar ");
    }
    this.jdField_l_of_type_Boolean = false;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { 0.0F, this.jdField_k_of_type_Int });
    localObjectAnimator1.setDuration(500L);
    if (this.jdField_k_of_type_Boolean)
    {
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView, "translationY", new float[] { 0.0F, this.jdField_k_of_type_Int });
      localObjectAnimator2.setDuration(500L);
      localObjectAnimator2.start();
    }
    localObjectAnimator1.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment
 * JD-Core Version:    0.7.0.1
 */