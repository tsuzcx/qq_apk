package com.tencent.mobileqq.extendfriend.fragment;

import amsu;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import apsn;
import arhg;
import arhi;
import arht;
import arix;
import arjk;
import arlk;
import arln;
import arlo;
import arlp;
import arlq;
import arlr;
import arls;
import arlt;
import arlu;
import arlv;
import arme;
import armf;
import arnv;
import arnz;
import arob;
import arrk;
import bbgo;
import bbgp;
import bcef;
import bfzl;
import bhbn;
import bjng;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.pulltorefresh.LoadingLayoutBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.State;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendMultiLinesTagsView;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import mun;

public class ExtendFriendSearchFragment
  extends ExtendFriendBaseFragment
  implements TextWatcher, View.OnClickListener, TextView.OnEditorActionListener, arlv, arnz, arob<RecyclerView>, bbgp, bhbn
{
  private amsu jdField_a_of_type_Amsu = new arlo(this);
  private Intent jdField_a_of_type_AndroidContentIntent;
  private View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private arht jdField_a_of_type_Arht = new arln(this);
  private arlk jdField_a_of_type_Arlk;
  private bbgo jdField_a_of_type_Bbgo;
  ExtendFriendSearchFragment.CancelReceiver jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment$CancelReceiver;
  ExtendFriendMultiLinesTagsView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView;
  public QuickPinyinEditText a;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private List<String> jdField_a_of_type_JavaUtilList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private View jdField_b_of_type_AndroidViewView;
  private bjng jdField_b_of_type_Bjng;
  ExtendFriendMultiLinesTagsView jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = 1;
  private boolean jdField_i_of_type_Boolean = true;
  private int k;
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<arjk> paramList, arix paramarix)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("handleGetSquareStrangerList success=%s searchKey=%s", new Object[] { Boolean.valueOf(paramBoolean1), paramString }));
    }
    if ((!isAdded()) || (this.jdField_a_of_type_Arme == null)) {
      return;
    }
    paramString = this.jdField_a_of_type_Arme;
    int j;
    if (paramBoolean1)
    {
      j = 0;
      paramString.c(j);
      if ((paramBoolean1) && (paramList != null)) {
        break label226;
      }
      if (this.f) {
        this.jdField_a_of_type_Arme.a(1, true);
      }
      this.jdField_a_of_type_Arme.a();
      if (this.jdField_i_of_type_Int != 0) {
        break label219;
      }
      paramInt = 2131694311;
      label108:
      a(getString(paramInt), 1);
      label119:
      if (this.jdField_a_of_type_Arme.getItemCount() == 0) {
        this.jdField_a_of_type_Arme.a(true);
      }
      this.jdField_a_of_type_Arme.notifyDataSetChanged();
      if ((!this.f) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)) {
        if (!paramBoolean1) {
          break label532;
        }
      }
    }
    label532:
    for (paramInt = 2131698232;; paramInt = 2131698231)
    {
      paramString = getResources().getString(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false).setRefreshResultLabel(paramString);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.b();
      this.jdField_e_of_type_Boolean = false;
      g();
      b(true);
      return;
      j = 1;
      break;
      label219:
      paramInt = 2131698231;
      break label108;
      label226:
      this.g = paramBoolean2;
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      this.jdField_a_of_type_Boolean = paramBoolean3;
      this.jdField_b_of_type_Boolean = paramBoolean4;
      this.k = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSearchFragment", 2, String.format("handleGetSquareStrangerList mLoadOver=%s mRequestCookies=%s mProfileComplete=%s mShowCard=%s mMaxLikeCount=%s matchCount=%d limitDuration=%d", new Object[] { Boolean.valueOf(this.g), this.jdField_a_of_type_ArrayOfByte, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.k), Integer.valueOf(paramarix.a), Integer.valueOf(paramarix.jdField_b_of_type_Int) }));
      }
      if (!this.f) {
        this.jdField_a_of_type_Arme.a();
      }
      if (this.g) {
        this.jdField_a_of_type_Arme.a(2, false);
      }
      this.jdField_a_of_type_Arme.a(paramList);
      if (!this.f) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
        if (paramString != null)
        {
          this.jdField_e_of_type_Long = System.currentTimeMillis();
          paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131718605), bfzl.a(this.jdField_e_of_type_Long, true, "yyyy-MM-dd") }));
        }
      }
      if (this.jdField_a_of_type_AndroidContentIntent == null) {
        this.jdField_a_of_type_AndroidContentIntent = new Intent();
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("remain_match_count", paramarix.a);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("limit_chat_duration", paramarix.jdField_b_of_type_Int);
      getActivity().setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      break label119;
    }
  }
  
  private boolean a(String paramString)
  {
    return this.jdField_a_of_type_Arhi.b(2).contains(paramString);
  }
  
  private void b(String paramString)
  {
    float f3 = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWidth() - this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingLeft() - this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingRight();
    float f4 = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTextSize();
    float f2 = 18.0F;
    float f1 = f2;
    if (f4 > 1.0F)
    {
      f1 = f2;
      if (f3 > 1.0F) {
        f1 = f3 / f4;
      }
    }
    f1 = Math.max(f1, 12.0F);
    String str = paramString;
    int j;
    int m;
    if (apsn.a(paramString) > f1)
    {
      j = Math.max(0, (int)(f1 - 4.0F));
      m = j;
      if (j < paramString.length()) {
        if (!TextUtils.equals(String.valueOf(paramString.charAt(j - 1)), "、")) {}
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (apsn.a(paramString.substring(0, j) + "…") > f1)
      {
        str = paramString.substring(0, m) + "…";
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(str);
        return;
      }
      m = j;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int j = 0;; j = 8)
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != j) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(j);
      }
      return;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    boolean bool2 = true;
    QuickPinyinEditText localQuickPinyinEditText = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
    boolean bool1;
    if (paramBoolean)
    {
      bool1 = true;
      localQuickPinyinEditText.setFocusable(bool1);
      localQuickPinyinEditText = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localQuickPinyinEditText.setFocusableInTouchMode(paramBoolean);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void k(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("switchToMode ");
      if (this.jdField_h_of_type_Int != 1) {
        break label104;
      }
    }
    label104:
    for (String str = "result";; str = "search")
    {
      QLog.i("ExtendFriendSearchFragment", 2, str);
      if (paramInt != 1) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.getVisibility() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVisibility(8);
      }
      a(false, 50L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.requestFocus();
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.getVisibility() != 8) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setVisibility(8);
    }
    a(true, 50L);
  }
  
  private void o()
  {
    a(false, this.jdField_b_of_type_JavaLangString, false, null, false, false, 0, null, null);
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, "autoRefresh");
    }
    if ((!isAdded()) || (this.jdField_a_of_type_Arme == null)) {}
    do
    {
      return;
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView == null);
    LoadingLayoutBase localLoadingLayoutBase = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a();
    if (localLoadingLayoutBase != null) {}
    for (int j = localLoadingLayoutBase.getHeight();; j = 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.d()) || (j == 0))
      {
        a(false);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setRefreshing();
      this.jdField_a_of_type_Arme.a(0, true);
      return;
      this.jdField_i_of_type_Int = 0;
      o();
      return;
    }
  }
  
  private void q()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) && (ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)))
      {
        int j = getResources().getColor(2131166859);
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarMask(new PorterDuffColorFilter(j, PorterDuff.Mode.SRC_ATOP));
      }
      return;
    }
    catch (Exception localException)
    {
      QZLog.e("ExtendFriendSearchFragment", "catch an exception when set the NightMode for StatusBar.", localException);
    }
  }
  
  protected int a()
  {
    return 1033;
  }
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(false, 50L);
  }
  
  public void a(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (this.jdField_a_of_type_Bjng.hasMessages(10))
    {
      this.jdField_a_of_type_Bjng.removeMessages(10);
      e();
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D4", "0X80092D4", 0, 0, "", "", "", "");
    if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      a(false);
      j();
      this.jdField_a_of_type_Arme.a(0, true);
      return;
    }
    this.jdField_i_of_type_Int = 0;
    o();
  }
  
  public void a(PullToRefreshBase paramPullToRefreshBase, PullToRefreshBase.State paramState, PullToRefreshBase.Mode paramMode) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("search keyword=%s", new Object[] { paramString }));
    }
    boolean bool = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = paramString;
    k(1);
    bjng localbjng;
    if (this.jdField_b_of_type_Bjng != null)
    {
      this.jdField_b_of_type_Bjng.removeMessages(13);
      localbjng = this.jdField_b_of_type_Bjng;
      if (!bool) {
        break label98;
      }
    }
    label98:
    for (long l = 200L;; l = 50L)
    {
      localbjng.sendEmptyMessageDelayed(13, l);
      ThreadManager.postImmediately(new ExtendFriendSearchFragment.10(this, paramString), null, true);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("requestSquareStrangerList loadMore=%s keyword=%s", new Object[] { Boolean.valueOf(paramBoolean), this.jdField_b_of_type_JavaLangString }));
    }
    this.f = paramBoolean;
    if (!this.f)
    {
      this.g = false;
      this.jdField_a_of_type_ArrayOfByte = null;
    }
    if (this.jdField_a_of_type_Arhg != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Arhg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ArrayOfByte, 20, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long, "", a(this.jdField_b_of_type_JavaLangString));
        this.jdField_e_of_type_Boolean = true;
      }
    }
    else {
      return;
    }
    QLog.e("ExtendFriendSearchFragment", 2, "requestSquareStrangerList mApp is null");
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchFragment", 2, "requestToggleInputMethod " + paramBoolean);
    }
    if (this.jdField_b_of_type_Bjng == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        this.jdField_b_of_type_Bjng.removeMessages(12);
        if (!this.jdField_b_of_type_Bjng.hasMessages(11))
        {
          this.jdField_b_of_type_Bjng.sendEmptyMessageDelayed(11, paramLong);
          return;
        }
      } while (paramLong != 0L);
      this.jdField_b_of_type_Bjng.removeMessages(11);
      this.jdField_b_of_type_Bjng.sendEmptyMessage(11);
      return;
      this.jdField_b_of_type_Bjng.removeMessages(11);
      if (!this.jdField_b_of_type_Bjng.hasMessages(12))
      {
        this.jdField_b_of_type_Bjng.sendEmptyMessageDelayed(12, paramLong);
        return;
      }
    } while (paramLong != 0L);
    this.jdField_b_of_type_Bjng.removeMessages(12);
    this.jdField_b_of_type_Bjng.sendEmptyMessage(11);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      if ((this.jdField_h_of_type_Int == 1) && (TextUtils.isEmpty(paramEditable))) {
        k(0);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  protected int b()
  {
    return this.k;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Bjng.post(new ExtendFriendSearchFragment.3(this));
  }
  
  public void b(PullToRefreshBase<RecyclerView> paramPullToRefreshBase) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void d()
  {
    a(false, 50L);
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
      m();
      continue;
      n();
      continue;
      p();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j(int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getActivity().getWindow().addFlags(67108864);
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getActivity(), false, getResources().getColor(paramInt));
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      getActivity().getWindow().addFlags(67108864);
    }
    q();
  }
  
  protected void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchFragment", 2, "hideInputMethod");
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchFragment", 2, "showInputMethod");
    }
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
      ((InputMethodManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, 0);
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (paramInt1 == 1033)
    {
      l();
      a(true, true);
      if (paramInt2 == 8193) {
        k();
      }
      this.c = -1;
      if (this.jdField_a_of_type_AndroidContentIntent == null) {
        this.jdField_a_of_type_AndroidContentIntent = new Intent();
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("has_entered_profile", true);
      getActivity().setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    }
    do
    {
      do
      {
        return;
        if ((paramInt1 != 1) || (paramInt2 != -1)) {
          break;
        }
        paramIntent = this.jdField_a_of_type_Arme.a(this.jdField_b_of_type_Int);
      } while ((paramIntent == null) || (paramIntent.mAddFriendVerified));
      paramIntent.mAddFriendVerified = true;
      this.jdField_a_of_type_Arme.notifyItemChanged(this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.add(paramIntent.mUin);
      if (this.jdField_a_of_type_AndroidContentIntent == null) {
        this.jdField_a_of_type_AndroidContentIntent = new Intent();
      }
      if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("add_frd_list")) {
        this.jdField_a_of_type_AndroidContentIntent.removeExtra("add_frd_list");
      }
      this.jdField_a_of_type_AndroidContentIntent.putStringArrayListExtra("add_frd_list", (ArrayList)this.jdField_a_of_type_JavaUtilList);
      getActivity().setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      return;
    } while ((paramInt1 != 2) || (paramInt2 != -1));
    if (this.jdField_a_of_type_AndroidContentIntent == null) {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
    }
    this.jdField_a_of_type_AndroidContentIntent.putExtra("has_entered_profile", true);
    getActivity().setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    a(false, true);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_h_of_type_Int == 1)
    {
      k(0);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int j;
    if (this.jdField_h_of_type_Int == 0)
    {
      j = 1;
      switch (paramView.getId())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      j = 2;
      break;
      if (this.jdField_h_of_type_Int == 1) {
        k(0);
      }
      for (;;)
      {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800941A", "0X800941A", j, 0, "", "", "", "");
        break;
        if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
        }
      }
      this.jdField_a_of_type_Arhi.a().a();
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009418", "0X8009418", 0, 0, "", "", "", "");
      continue;
      if (this.jdField_h_of_type_Int == 1) {
        k(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009419", "0X8009419", j, 0, "", "", "", "");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow();
    if (paramBundle != null)
    {
      paramBundle.setFormat(-3);
      paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment$CancelReceiver = new ExtendFriendSearchFragment.CancelReceiver(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.search.cancel");
    paramBundle.addAction("com.tencent.mobileqq.search.finish");
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment$CancelReceiver, paramBundle);
    this.jdField_a_of_type_Arhi.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Arht);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amsu);
    this.jdField_b_of_type_Bjng = new bjng(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Arlk = new arlk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = (ViewGroup)paramLayoutInflater.inflate(2131561077, null);
    paramViewGroup = paramLayoutInflater.findViewById(2131378747);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramLayoutInflater.findViewById(2131376936));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    boolean bool;
    if ("1".equals(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.search_input_type.name(), "0")))
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setInputType(524321);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(this.jdField_a_of_type_Arhi.b());
      this.jdField_a_of_type_Bbgo = new bbgo(paramLayoutInflater);
      this.jdField_a_of_type_Bbgo.a(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131376911));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new mun());
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramBundle = paramLayoutInflater.findViewById(2131376910);
      paramBundle.setOnTouchListener(new mun());
      paramBundle.setOnClickListener(this);
      paramLayoutInflater.findViewById(2131368080).setOnClickListener(this);
      if (paramViewGroup != null)
      {
        paramBundle = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
        paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        paramViewGroup.setLayoutParams(paramBundle);
      }
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131368081));
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131378210);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramLayoutInflater.findViewById(2131378211));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(2131368090));
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(2131376117));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setViewMargin(AIOUtils.dp2px(10.0F, getResources()), AIOUtils.dp2px(10.0F, getResources()));
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setViewMargin(AIOUtils.dp2px(10.0F, getResources()), AIOUtils.dp2px(10.0F, getResources()));
      paramBundle = this.jdField_a_of_type_Arhi.b(2);
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setSearchTags((ArrayList)paramBundle);
      paramBundle = this.jdField_a_of_type_Arhi.a().a();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setSearchTags((ArrayList)paramBundle);
      if (paramBundle.size() <= 0) {
        break label799;
      }
      bool = true;
      label431:
      d(bool);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setOnItemClickListener(new arlp(this));
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setOnItemClickListener(new arlq(this));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131373175));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false).setRefreshingLabel(getResources().getString(2131698233));
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new arrk(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setId(2131376174);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
      ((SimpleItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnPullEventListener(this);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new arlr(this));
      this.jdField_a_of_type_Armf = new armf(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new arls(this);
      this.jdField_a_of_type_Arme = new arme(this, this, null, null, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      this.jdField_a_of_type_Arme.registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
      this.jdField_a_of_type_Arme.a(this.jdField_a_of_type_Arlk);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Arme);
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout = ((NearbyZanAnimLayout)paramLayoutInflater.findViewById(2131368043));
      paramViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new arlt(this, paramViewGroup));
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131371801);
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
        paramViewGroup = this.jdField_b_of_type_AndroidViewView;
        if (!bool) {
          break label805;
        }
      }
    }
    label799:
    label805:
    for (int j = 0;; j = 8)
    {
      paramViewGroup.setVisibility(j);
      k(0);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setInputType(524289);
      break;
      bool = false;
      break label431;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment$CancelReceiver != null)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment$CancelReceiver);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment$CancelReceiver = null;
      }
      this.jdField_b_of_type_Bjng.removeCallbacksAndMessages(null);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(false);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusableInTouchMode(false);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getParent() != null) {
          ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText);
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(null);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          localError.printStackTrace();
        }
      }
      if (this.jdField_a_of_type_Arlk != null)
      {
        this.jdField_a_of_type_Arlk.a();
        this.jdField_a_of_type_Arlk = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Arht);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amsu);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      }
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver != null) {
        this.jdField_a_of_type_Arme.unregisterAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
      }
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
      }
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      if (this.jdField_h_of_type_Int == 0) {}
      for (paramInt = 1;; paramInt = 2)
      {
        paramTextView = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
        if (!TextUtils.isEmpty(paramTextView)) {
          a(paramTextView);
        }
        a(false, 50L);
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800941B", "0X800941B", paramInt, 0, "", "", "", "");
        return true;
      }
    }
    return false;
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 2130772331);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    j(2131167070);
    if ((!this.jdField_i_of_type_Boolean) && (this.jdField_h_of_type_Int == 1))
    {
      e(false);
      this.jdField_b_of_type_Bjng.postDelayed(new ExtendFriendSearchFragment.9(this), 50L);
    }
    this.jdField_i_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) && (this.jdField_a_of_type_Arhi != null)) {
      b(this.jdField_a_of_type_Arhi.b());
    }
  }
  
  public void onSoftKeyboardClosed()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(false);
    this.jdField_h_of_type_Boolean = false;
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
    this.jdField_h_of_type_Boolean = true;
  }
  
  public void onStop()
  {
    super.onStop();
    m();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
    }
    super.onViewStateRestored(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment
 * JD-Core Version:    0.7.0.1
 */