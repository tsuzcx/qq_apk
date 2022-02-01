package com.tencent.mobileqq.qqexpand.fragment;

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
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.TagUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchFeedInfo;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendSearchHistoryManager;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendSearchHistoryManager.HistoryTagChangeListener;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendMultiLinesTagsView;
import com.tencent.mobileqq.qqexpand.widget.WrapContentLinearLayoutManager;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.ILoadingLayout;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.OnPullEventListener;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.OnRefreshListener2;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.State;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.mobileqq.widget.NearbyZanAnimLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;

public class ExtendFriendSearchFragment
  extends ExtendFriendBaseFragment
  implements TextWatcher, View.OnClickListener, TextView.OnEditorActionListener, ExtendFriendSearchHistoryManager.HistoryTagChangeListener, PullToRefreshBase.OnPullEventListener, PullToRefreshBase.OnRefreshListener2<RecyclerView>, SoftKeyboardStateHelper.SoftKeyboardStateListener, BounceScrollView.OnScrollChangedListener
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new ExtendFriendSearchFragment.1(this);
  private ExtendFriendReporter jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendReporter;
  ExtendFriendSearchFragment.CancelReceiver jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSearchFragment$CancelReceiver;
  private final ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new ExtendFriendSearchFragment.2(this);
  ExtendFriendMultiLinesTagsView jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView;
  private SoftKeyboardStateHelper jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper;
  QuickPinyinEditText jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private List<String> jdField_a_of_type_JavaUtilList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  ExtendFriendMultiLinesTagsView jdField_b_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView;
  private WeakReferenceHandler jdField_b_of_type_ComTencentUtilWeakReferenceHandler;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  private boolean h = true;
  int i = 0;
  private int j = 1;
  private int k;
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<StrangerInfo> paramList, MatchFeedInfo paramMatchFeedInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("handleGetSquareStrangerList success=%s searchKey=%s", new Object[] { Boolean.valueOf(paramBoolean1), paramString }));
    }
    if (isAdded())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.c(paramBoolean1 ^ true);
      int m = 2131698885;
      if ((paramBoolean1) && (paramList != null))
      {
        this.g = paramBoolean2;
        this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.jdField_a_of_type_Boolean = paramBoolean3;
        this.jdField_b_of_type_Boolean = paramBoolean4;
        this.k = paramInt;
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSearchFragment", 2, String.format("handleGetSquareStrangerList mLoadOver=%s mRequestCookies=%s mProfileComplete=%s mShowCard=%s mMaxLikeCount=%s matchCount=%d limitDuration=%d", new Object[] { Boolean.valueOf(this.g), this.jdField_a_of_type_ArrayOfByte, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.k), Integer.valueOf(paramMatchFeedInfo.a), Integer.valueOf(paramMatchFeedInfo.b) }));
        }
        if (!this.f) {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a();
        }
        if (this.g) {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(2, false);
        }
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(paramList);
        if (!this.f) {
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(0);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView != null)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
          if (paramString != null)
          {
            this.jdField_e_of_type_Long = System.currentTimeMillis();
            paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131719248), TimeFormatterUtils.a(this.jdField_e_of_type_Long, true, "yyyy-MM-dd") }));
          }
        }
        if (this.jdField_a_of_type_AndroidContentIntent == null) {
          this.jdField_a_of_type_AndroidContentIntent = new Intent();
        }
        this.jdField_a_of_type_AndroidContentIntent.putExtra("remain_match_count", paramMatchFeedInfo.a);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("limit_chat_duration", paramMatchFeedInfo.b);
        getQBaseActivity().setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      }
      else
      {
        if (this.f) {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(1, true);
        }
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a();
        if (this.j == 0) {
          paramInt = 2131694709;
        } else {
          paramInt = 2131698885;
        }
        a(getString(paramInt), 1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.getItemCount() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.notifyDataSetChanged();
      if ((!this.f) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView != null))
      {
        paramInt = m;
        if (paramBoolean1) {
          paramInt = 2131698886;
        }
        paramString = getResources().getString(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false).setRefreshResultLabel(paramString);
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.b();
      }
      this.jdField_e_of_type_Boolean = false;
      h();
      c(true);
    }
  }
  
  private boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.b(2).contains(paramString);
  }
  
  private void b(String paramString)
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWidth() - this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingLeft() - this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingRight();
    float f2 = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTextSize();
    if ((f2 > 1.0F) && (f1 > 1.0F)) {
      f1 /= f2;
    } else {
      f1 = 18.0F;
    }
    f1 = Math.max(f1, 12.0F);
    Object localObject = paramString;
    if (TagUtils.a(paramString) > f1)
    {
      int m = Math.max(0, (int)(f1 - 4.0F));
      int n = m;
      while (m < paramString.length())
      {
        if (!TextUtils.equals(String.valueOf(paramString.charAt(m - 1)), "、"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString.substring(0, m));
          ((StringBuilder)localObject).append("…");
          if (TagUtils.a(((StringBuilder)localObject).toString()) > f1) {
            break;
          }
          n = m;
        }
        m += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, n));
      ((StringBuilder)localObject).append("…");
      localObject = ((StringBuilder)localObject).toString();
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint((CharSequence)localObject);
  }
  
  private void d(boolean paramBoolean)
  {
    int m;
    if (paramBoolean) {
      m = 0;
    } else {
      m = 8;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != m) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(m);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusableInTouchMode(paramBoolean);
  }
  
  private void k(int paramInt)
  {
    this.i = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchToMode ");
      String str;
      if (this.i == 1) {
        str = "result";
      } else {
        str = "search";
      }
      localStringBuilder.append(str);
      QLog.i("ExtendFriendSearchFragment", 2, localStringBuilder.toString());
    }
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.getVisibility() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.setVisibility(0);
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
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.getVisibility() != 8) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.setVisibility(8);
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
    if (isAdded())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter == null) {
        return;
      }
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView != null)
        {
          LoadingLayoutBase localLoadingLayoutBase = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.a();
          int m;
          if (localLoadingLayoutBase != null) {
            m = localLoadingLayoutBase.getHeight();
          } else {
            m = 0;
          }
          if ((!this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.d()) && (m != 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.setRefreshing();
            this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(0, true);
            return;
          }
          b(false);
        }
      }
      else
      {
        this.j = 0;
        o();
      }
    }
  }
  
  private void q()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) && (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        int m = getResources().getColor(2131166892);
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarMask(new PorterDuffColorFilter(m, PorterDuff.Mode.SRC_ATOP));
        return;
      }
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
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(10))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10);
      f();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D4", "0X80092D4", 0, 0, "", "", "", "");
    if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
    {
      b(false);
      j();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(0, true);
      return;
    }
    this.j = 0;
    o();
  }
  
  public void a(PullToRefreshBase paramPullToRefreshBase, PullToRefreshBase.State paramState, PullToRefreshBase.Mode paramMode) {}
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("search keyword=%s", new Object[] { paramString }));
    }
    boolean bool = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = paramString;
    k(1);
    WeakReferenceHandler localWeakReferenceHandler = this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler;
    if (localWeakReferenceHandler != null)
    {
      localWeakReferenceHandler.removeMessages(13);
      localWeakReferenceHandler = this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler;
      long l;
      if (bool) {
        l = 200L;
      } else {
        l = 50L;
      }
      localWeakReferenceHandler.sendEmptyMessageDelayed(13, l);
    }
    ThreadManager.postImmediately(new ExtendFriendSearchFragment.10(this, paramString), null, true);
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestToggleInputMethod ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("ExtendFriendSearchFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler;
    if (localObject == null) {
      return;
    }
    if (paramBoolean)
    {
      ((WeakReferenceHandler)localObject).removeMessages(12);
      if (!this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(11))
      {
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(11, paramLong);
        return;
      }
      if (paramLong == 0L)
      {
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(11);
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(11);
      }
    }
    else
    {
      ((WeakReferenceHandler)localObject).removeMessages(11);
      if (!this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(12))
      {
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(12, paramLong);
        return;
      }
      if (paramLong == 0L)
      {
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(12);
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(11);
      }
    }
  }
  
  public void aM_()
  {
    this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.post(new ExtendFriendSearchFragment.3(this));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if ((this.i == 1) && (TextUtils.isEmpty(paramEditable))) {
      k(0);
    }
  }
  
  protected int b()
  {
    return this.k;
  }
  
  public void b(PullToRefreshBase<RecyclerView> paramPullToRefreshBase) {}
  
  public void b(boolean paramBoolean)
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
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkIExpandHandler != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkIExpandHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ArrayOfByte, 20, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long, "", a(this.jdField_b_of_type_JavaLangString));
        this.jdField_e_of_type_Boolean = true;
        return;
      }
      QLog.e("ExtendFriendSearchFragment", 2, "requestSquareStrangerList mApp is null");
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void e()
  {
    a(false, 50L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      break;
    case 13: 
      p();
      break;
    case 12: 
      m();
      break;
    case 11: 
      n();
    }
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j(int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getQBaseActivity().getWindow().addFlags(67108864);
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getQBaseActivity(), false, getResources().getColor(paramInt));
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      getQBaseActivity().getWindow().addFlags(67108864);
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null)
    {
      QuickPinyinEditText localQuickPinyinEditText = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
      if (localQuickPinyinEditText != null)
      {
        localQuickPinyinEditText.clearFocus();
        ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, 0);
      }
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
      this.d = -1;
      if (this.jdField_a_of_type_AndroidContentIntent == null) {
        this.jdField_a_of_type_AndroidContentIntent = new Intent();
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("has_entered_profile", true);
      getQBaseActivity().setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(this.c);
      if ((paramIntent != null) && (!paramIntent.mAddFriendVerified))
      {
        paramIntent.mAddFriendVerified = true;
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.notifyItemChanged(this.c);
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
        getQBaseActivity().setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      }
    }
    else if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      if (this.jdField_a_of_type_AndroidContentIntent == null) {
        this.jdField_a_of_type_AndroidContentIntent = new Intent();
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("has_entered_profile", true);
      getQBaseActivity().setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      a(false, true);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.i == 1)
    {
      k(0);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int m;
    if (this.i == 0) {
      m = 1;
    } else {
      m = 2;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 1912930356: 
      if (this.i == 1) {
        k(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009419", "0X8009419", m, 0, "", "", "", "");
      return;
    case 1912930355: 
      if (this.i == 1) {
        k(0);
      } else if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800941A", "0X800941A", m, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.a().a();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009418", "0X8009418", 0, 0, "", "", "", "");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow();
    if (paramBundle != null)
    {
      paramBundle.setFormat(-3);
      paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSearchFragment$CancelReceiver = new ExtendFriendSearchFragment.CancelReceiver(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.search.cancel");
    paramBundle.addAction("com.tencent.mobileqq.search.finish");
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSearchFragment$CancelReceiver, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendReporter = new ExtendFriendReporter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = (ViewGroup)paramLayoutInflater.inflate(1912995844, null);
    paramViewGroup = paramLayoutInflater.findViewById(1912930367);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramLayoutInflater.findViewById(1912930359));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    if ("1".equals(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.search_input_type.name(), "0"))) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setInputType(524321);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setInputType(524289);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.e());
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper = new SoftKeyboardStateHelper(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper.a(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(1912930356));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramBundle = paramLayoutInflater.findViewById(1912930355);
    paramBundle.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    paramBundle.setOnClickListener(this);
    paramLayoutInflater.findViewById(1912930324).setOnClickListener(this);
    if (paramViewGroup != null)
    {
      paramBundle = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
      paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      paramViewGroup.setLayoutParams(paramBundle);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(1912930325));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramLayoutInflater.findViewById(1912930364));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(1912930326));
    this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(1912930352));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView.setViewMargin(AIOUtils.b(10.0F, getResources()), AIOUtils.b(10.0F, getResources()));
    this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView.setViewMargin(AIOUtils.b(10.0F, getResources()), AIOUtils.b(10.0F, getResources()));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.b(2);
    this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView.setSearchTags((ArrayList)paramBundle);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.a().a();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView.setSearchTags((ArrayList)paramBundle);
    boolean bool;
    if (paramBundle.size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    d(bool);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView.setOnItemClickListener(new ExtendFriendSearchFragment.4(this));
    this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView.setOnItemClickListener(new ExtendFriendSearchFragment.5(this));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(1912930350));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false).setRefreshingLabel(getResources().getString(2131698887));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new WrapContentLinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setId(1912930353);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    ((SimpleItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.setOnPullEventListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new ExtendFriendSearchFragment.6(this));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewItemDecoration = new RecyclerViewItemDecoration(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new ExtendFriendSearchFragment.7(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter = new RecyclerViewAdapter(this, this, null, null, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendReporter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout = ((NearbyZanAnimLayout)paramLayoutInflater.findViewById(1912930323));
    paramViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ExtendFriendSearchFragment.8(this, paramViewGroup));
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(1912930344);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
      int m;
      if (bool) {
        m = 0;
      } else {
        m = 8;
      }
      paramViewGroup.setVisibility(m);
    }
    k(0);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSearchFragment$CancelReceiver != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSearchFragment$CancelReceiver);
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSearchFragment$CancelReceiver = null;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
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
    catch (Error localError)
    {
      localError.printStackTrace();
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    ExtendFriendReporter localExtendFriendReporter = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendReporter;
    if (localExtendFriendReporter != null)
    {
      localExtendFriendReporter.a();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendReporter = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.unregisterAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66))) {
      return false;
    }
    paramTextView = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
    if (!TextUtils.isEmpty(paramTextView)) {
      a(paramTextView);
    }
    a(false, 50L);
    if (this.i == 0) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800941B", "0X800941B", paramInt, 0, "", "", "", "");
    return true;
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getQBaseActivity() != null) {
      getQBaseActivity().overridePendingTransition(0, 2130772377);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    j(2131167114);
    if ((!this.h) && (this.i == 1))
    {
      e(false);
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new ExtendFriendSearchFragment.9(this), 50L);
    }
    this.h = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager != null)) {
      b(this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.e());
    }
  }
  
  public void onSoftKeyboardClosed()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(false);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
  }
  
  public void onStop()
  {
    super.onStop();
    m();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    QuickPinyinEditText localQuickPinyinEditText = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
    if (localQuickPinyinEditText != null) {
      localQuickPinyinEditText.removeTextChangedListener(this);
    }
    super.onViewStateRestored(paramBundle);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
    if (paramBundle != null) {
      paramBundle.addTextChangedListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment
 * JD-Core Version:    0.7.0.1
 */