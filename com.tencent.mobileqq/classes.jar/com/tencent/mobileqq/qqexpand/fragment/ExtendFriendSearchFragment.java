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
  int T = 0;
  QuickPinyinEditText U;
  ExtendFriendSearchFragment.CancelReceiver V;
  ImageView W;
  ExtendFriendMultiLinesTagsView X;
  ExtendFriendMultiLinesTagsView Y;
  ViewGroup Z;
  SystemBarCompact aa;
  private WeakReferenceHandler ab;
  private final FriendObserver ac = new ExtendFriendSearchFragment.1(this);
  private boolean ad;
  private boolean ae;
  private boolean af;
  private int ag = 1;
  private byte[] ah;
  private int ai;
  private long aj;
  private boolean ak = true;
  private ExtendFriendReporter al;
  private BounceScrollView am;
  private SoftKeyboardStateHelper an;
  private View ao;
  private Intent ap;
  private List<String> aq;
  private final ExpandObserver ar = new ExtendFriendSearchFragment.2(this);
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<StrangerInfo> paramList, MatchFeedInfo paramMatchFeedInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("handleGetSquareStrangerList success=%s searchKey=%s", new Object[] { Boolean.valueOf(paramBoolean1), paramString }));
    }
    if (isAdded())
    {
      if (this.m == null) {
        return;
      }
      this.m.d(paramBoolean1 ^ true);
      int i = 2131896857;
      if ((paramBoolean1) && (paramList != null))
      {
        this.af = paramBoolean2;
        this.ah = paramArrayOfByte;
        this.y = paramBoolean3;
        this.z = paramBoolean4;
        this.ai = paramInt;
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSearchFragment", 2, String.format("handleGetSquareStrangerList mLoadOver=%s mRequestCookies=%s mProfileComplete=%s mShowCard=%s mMaxLikeCount=%s matchCount=%d limitDuration=%d", new Object[] { Boolean.valueOf(this.af), this.ah, Boolean.valueOf(this.y), Boolean.valueOf(this.z), Integer.valueOf(this.ai), Integer.valueOf(paramMatchFeedInfo.a), Integer.valueOf(paramMatchFeedInfo.b) }));
        }
        if (!this.ae) {
          this.m.c();
        }
        if (this.af) {
          this.m.a(2, false);
        }
        this.m.a(paramList);
        if (!this.ae) {
          this.p.scrollToPosition(0);
        }
        if (this.n != null)
        {
          paramString = this.n.a(true, false);
          if (paramString != null)
          {
            this.aj = System.currentTimeMillis();
            paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131916800), TimeFormatterUtils.a(this.aj, true, "yyyy-MM-dd") }));
          }
        }
        if (this.ap == null) {
          this.ap = new Intent();
        }
        this.ap.putExtra("remain_match_count", paramMatchFeedInfo.a);
        this.ap.putExtra("limit_chat_duration", paramMatchFeedInfo.b);
        getQBaseActivity().setResult(-1, this.ap);
      }
      else
      {
        if (this.ae) {
          this.m.a(1, true);
        }
        this.m.c();
        if (this.ag == 0) {
          paramInt = 2131892406;
        } else {
          paramInt = 2131896857;
        }
        a(getString(paramInt), 1);
      }
      if (this.m.getItemCount() == 0) {
        this.m.a(true);
      }
      this.m.notifyDataSetChanged();
      if ((!this.ae) && (this.n != null))
      {
        paramInt = i;
        if (paramBoolean1) {
          paramInt = 2131896858;
        }
        paramString = getResources().getString(paramInt);
        this.n.a(true, false).setRefreshResultLabel(paramString);
        this.n.f();
      }
      this.ad = false;
      l();
      c(true);
    }
  }
  
  private boolean b(String paramString)
  {
    return this.l.c(2).contains(paramString);
  }
  
  private void c(String paramString)
  {
    float f1 = this.U.getWidth() - this.U.getPaddingLeft() - this.U.getPaddingRight();
    float f2 = this.U.getTextSize();
    if ((f2 > 1.0F) && (f1 > 1.0F)) {
      f1 /= f2;
    } else {
      f1 = 18.0F;
    }
    f1 = Math.max(f1, 12.0F);
    Object localObject = paramString;
    if (TagUtils.b(paramString) > f1)
    {
      int i = Math.max(0, (int)(f1 - 4.0F));
      int j = i;
      while (i < paramString.length())
      {
        if (!TextUtils.equals(String.valueOf(paramString.charAt(i - 1)), "、"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString.substring(0, i));
          ((StringBuilder)localObject).append("…");
          if (TagUtils.b(((StringBuilder)localObject).toString()) > f1) {
            break;
          }
          j = i;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, j));
      ((StringBuilder)localObject).append("…");
      localObject = ((StringBuilder)localObject).toString();
    }
    this.U.setHint((CharSequence)localObject);
  }
  
  private void d(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    if (this.Z.getVisibility() != i) {
      this.Z.setVisibility(i);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    this.U.setFocusable(paramBoolean);
    this.U.setFocusableInTouchMode(paramBoolean);
  }
  
  private void k(int paramInt)
  {
    this.T = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchToMode ");
      String str;
      if (this.T == 1) {
        str = "result";
      } else {
        str = "search";
      }
      localStringBuilder.append(str);
      QLog.i("ExtendFriendSearchFragment", 2, localStringBuilder.toString());
    }
    if (paramInt == 1)
    {
      if (this.n.getVisibility() != 0) {
        this.n.setVisibility(0);
      }
      if (this.am.getVisibility() != 8) {
        this.am.setVisibility(8);
      }
      a(false, 50L);
      return;
    }
    this.U.requestFocus();
    this.U.setText("");
    if (this.am.getVisibility() != 0) {
      this.am.setVisibility(0);
    }
    if (this.n.getVisibility() != 8) {
      this.n.setVisibility(8);
    }
    a(true, 50L);
  }
  
  private void t()
  {
    a(false, this.N, false, null, false, false, 0, null, null);
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, "autoRefresh");
    }
    if (isAdded())
    {
      if (this.m == null) {
        return;
      }
      if (NetworkUtil.isNetworkAvailable(this.h))
      {
        if (this.n != null)
        {
          LoadingLayoutBase localLoadingLayoutBase = this.n.getHeaderLayout();
          int i;
          if (localLoadingLayoutBase != null) {
            i = localLoadingLayoutBase.getHeight();
          } else {
            i = 0;
          }
          if ((!this.n.d()) && (i != 0))
          {
            this.n.setRefreshing();
            this.m.a(0, true);
            return;
          }
          b(false);
        }
      }
      else
      {
        this.ag = 0;
        t();
      }
    }
  }
  
  private void v()
  {
    try
    {
      if ((this.aa != null) && (ThemeUtil.isInNightMode(this.i)))
      {
        int i = getResources().getColor(2131167812);
        this.aa.setStatusBarMask(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
        return;
      }
    }
    catch (Exception localException)
    {
      QZLog.e("ExtendFriendSearchFragment", "catch an exception when set the NightMode for StatusBar.", localException);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(false, 50L);
  }
  
  public void a(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (this.s.hasMessages(10))
    {
      this.s.removeMessages(10);
      j();
    }
    ReportController.b(this.i, "dc00898", "", "", "0X80092D4", "0X80092D4", 0, 0, "", "", "", "");
    if (NetworkUtil.isNetworkAvailable(this.h))
    {
      b(false);
      n();
      this.m.a(0, true);
      return;
    }
    this.ag = 0;
    t();
  }
  
  public void a(PullToRefreshBase paramPullToRefreshBase, PullToRefreshBase.State paramState, PullToRefreshBase.Mode paramMode) {}
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("search keyword=%s", new Object[] { paramString }));
    }
    boolean bool = TextUtils.isEmpty(this.N);
    this.N = paramString;
    k(1);
    WeakReferenceHandler localWeakReferenceHandler = this.ab;
    if (localWeakReferenceHandler != null)
    {
      localWeakReferenceHandler.removeMessages(13);
      localWeakReferenceHandler = this.ab;
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
    Object localObject = this.ab;
    if (localObject == null) {
      return;
    }
    if (paramBoolean)
    {
      ((WeakReferenceHandler)localObject).removeMessages(12);
      if (!this.ab.hasMessages(11))
      {
        this.ab.sendEmptyMessageDelayed(11, paramLong);
        return;
      }
      if (paramLong == 0L)
      {
        this.ab.removeMessages(11);
        this.ab.sendEmptyMessage(11);
      }
    }
    else
    {
      ((WeakReferenceHandler)localObject).removeMessages(11);
      if (!this.ab.hasMessages(12))
      {
        this.ab.sendEmptyMessageDelayed(12, paramLong);
        return;
      }
      if (paramLong == 0L)
      {
        this.ab.removeMessages(12);
        this.ab.sendEmptyMessage(11);
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.U.getText().toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.W.setVisibility(8);
    } else {
      this.W.setVisibility(0);
    }
    if ((this.T == 1) && (TextUtils.isEmpty(paramEditable))) {
      k(0);
    }
  }
  
  public void b(PullToRefreshBase<RecyclerView> paramPullToRefreshBase) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("requestSquareStrangerList loadMore=%s keyword=%s", new Object[] { Boolean.valueOf(paramBoolean), this.N }));
    }
    this.ae = paramBoolean;
    if (!this.ae)
    {
      this.af = false;
      this.ah = null;
    }
    if (this.k != null)
    {
      if (this.i != null)
      {
        this.O = System.currentTimeMillis();
        this.k.a(this.i.getCurrentUin(), this.ah, 20, this.N, this.O, "", b(this.N));
        this.ad = true;
        return;
      }
      QLog.e("ExtendFriendSearchFragment", 2, "requestSquareStrangerList mApp is null");
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected int d()
  {
    return 1033;
  }
  
  public void dh_()
  {
    this.ab.post(new ExtendFriendSearchFragment.3(this));
  }
  
  protected int e()
  {
    return this.ai;
  }
  
  public void g()
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
      u();
      break;
    case 12: 
      r();
      break;
    case 11: 
      s();
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
      if (this.aa != null) {
        return;
      }
      this.aa = new SystemBarCompact(getQBaseActivity(), false, getResources().getColor(paramInt));
      this.aa.init();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      getQBaseActivity().getWindow().addFlags(67108864);
    }
    v();
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
      p();
      a(true, true);
      if (paramInt2 == 8193) {
        o();
      }
      this.w = -1;
      if (this.ap == null) {
        this.ap = new Intent();
      }
      this.ap.putExtra("has_entered_profile", true);
      getQBaseActivity().setResult(-1, this.ap);
      return;
    }
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      paramIntent = this.m.b(this.v);
      if ((paramIntent != null) && (!paramIntent.mAddFriendVerified))
      {
        paramIntent.mAddFriendVerified = true;
        this.m.notifyItemChanged(this.v);
        if (this.aq == null) {
          this.aq = new ArrayList();
        }
        this.aq.add(paramIntent.mUin);
        if (this.ap == null) {
          this.ap = new Intent();
        }
        if (this.ap.hasExtra("add_frd_list")) {
          this.ap.removeExtra("add_frd_list");
        }
        this.ap.putStringArrayListExtra("add_frd_list", (ArrayList)this.aq);
        getQBaseActivity().setResult(-1, this.ap);
      }
    }
    else if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      if (this.ap == null) {
        this.ap = new Intent();
      }
      this.ap.putExtra("has_entered_profile", true);
      getQBaseActivity().setResult(-1, this.ap);
      a(false, true);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.T == 1)
    {
      k(0);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (this.T == 0) {
      i = 1;
    } else {
      i = 2;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 1912930423: 
      if (this.T == 1) {
        k(0);
      }
      this.U.setText("");
      ReportController.b(this.i, "dc00898", "", "", "0X8009419", "0X8009419", i, 0, "", "", "", "");
      return;
    case 1912930422: 
      if (this.T == 1) {
        k(0);
      } else if (this.h != null) {
        this.h.finish();
      }
      ReportController.b(this.i, "dc00898", "", "", "0X800941A", "0X800941A", i, 0, "", "", "", "");
      return;
    }
    this.l.k().b();
    ReportController.b(this.i, "dc00898", "", "", "0X8009418", "0X8009418", 0, 0, "", "", "", "");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.h.getWindow();
    if (paramBundle != null)
    {
      paramBundle.setFormat(-3);
      paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
    }
    this.V = new ExtendFriendSearchFragment.CancelReceiver(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.search.cancel");
    paramBundle.addAction("com.tencent.mobileqq.search.finish");
    this.h.registerReceiver(this.V, paramBundle);
    this.l.k().a(this);
    this.i.addObserver(this.ar);
    this.i.addObserver(this.ac);
    this.ab = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.al = new ExtendFriendReporter(this.i);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = (ViewGroup)paramLayoutInflater.inflate(1912995848, null);
    paramViewGroup = paramLayoutInflater.findViewById(1912930436);
    this.U = ((QuickPinyinEditText)paramLayoutInflater.findViewById(1912930426));
    this.U.setImeOptions(3);
    this.U.setOnEditorActionListener(this);
    this.U.addTextChangedListener(this);
    if ("1".equals(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.search_input_type.name(), "0"))) {
      this.U.setInputType(524321);
    } else {
      this.U.setInputType(524289);
    }
    this.U.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
    this.U.setHint(this.l.y());
    this.an = new SoftKeyboardStateHelper(paramLayoutInflater);
    this.an.a(this);
    this.W = ((ImageView)paramLayoutInflater.findViewById(1912930423));
    this.W.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    this.W.setOnClickListener(this);
    paramBundle = paramLayoutInflater.findViewById(1912930422);
    paramBundle.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    paramBundle.setOnClickListener(this);
    paramLayoutInflater.findViewById(1912930360).setOnClickListener(this);
    if (paramViewGroup != null)
    {
      paramBundle = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
      paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(this.h);
      paramViewGroup.setLayoutParams(paramBundle);
    }
    this.Z = ((ViewGroup)paramLayoutInflater.findViewById(1912930361));
    this.am = ((BounceScrollView)paramLayoutInflater.findViewById(1912930433));
    this.am.setOnScrollChangedListener(this);
    this.X = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(1912930362));
    this.Y = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(1912930409));
    this.X.setViewMargin(AIOUtils.b(10.0F, getResources()), AIOUtils.b(10.0F, getResources()));
    this.Y.setViewMargin(AIOUtils.b(10.0F, getResources()), AIOUtils.b(10.0F, getResources()));
    paramBundle = this.l.c(2);
    this.Y.setSearchTags((ArrayList)paramBundle);
    paramBundle = this.l.k().a();
    this.X.setSearchTags((ArrayList)paramBundle);
    boolean bool;
    if (paramBundle.size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    d(bool);
    this.X.setOnItemClickListener(new ExtendFriendSearchFragment.4(this));
    this.Y.setOnItemClickListener(new ExtendFriendSearchFragment.5(this));
    this.n = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(1912930402));
    this.n.setOnRefreshListener(this);
    this.n.a(true, false).setRefreshingLabel(getResources().getString(2131896859));
    this.o = new WrapContentLinearLayoutManager(this.h);
    this.p = ((RecyclerView)this.n.getRefreshableView());
    this.p.setId(1912930410);
    this.p.setLayoutManager(this.o);
    ((SimpleItemAnimator)this.p.getItemAnimator()).setSupportsChangeAnimations(false);
    this.n.setOnPullEventListener(this);
    this.n.setMode(PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY);
    this.p.setOnScrollListener(new ExtendFriendSearchFragment.6(this));
    this.r = new RecyclerViewItemDecoration(this);
    this.q = new ExtendFriendSearchFragment.7(this);
    this.m = new RecyclerViewAdapter(this, this, null, null, this.p, this.h, 1, this.M);
    this.m.registerAdapterDataObserver(this.q);
    this.m.a(this.al);
    this.p.setAdapter(this.m);
    this.G = ((NearbyZanAnimLayout)paramLayoutInflater.findViewById(1912930359));
    paramViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ExtendFriendSearchFragment.8(this, paramViewGroup));
    this.ao = paramLayoutInflater.findViewById(1912930389);
    if (this.ao != null)
    {
      bool = ThemeUtil.isInNightMode(this.i);
      paramViewGroup = this.ao;
      int i;
      if (bool) {
        i = 0;
      } else {
        i = 8;
      }
      paramViewGroup.setVisibility(i);
    }
    k(0);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.V != null)
      {
        this.h.unregisterReceiver(this.V);
        this.V = null;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    this.ab.removeCallbacksAndMessages(null);
    try
    {
      this.U.setFocusable(false);
      this.U.setFocusableInTouchMode(false);
      this.U.setVisibility(8);
      if (this.U.getParent() != null) {
        ((ViewGroup)this.U.getParent()).removeView(this.U);
      }
      this.U.removeTextChangedListener(this);
      this.U.setOnEditorActionListener(null);
    }
    catch (Error localError)
    {
      localError.printStackTrace();
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    ExtendFriendReporter localExtendFriendReporter = this.al;
    if (localExtendFriendReporter != null)
    {
      localExtendFriendReporter.a();
      this.al = null;
    }
    if (this.i != null)
    {
      this.i.removeObserver(this.ar);
      this.i.removeObserver(this.ac);
      this.i = null;
    }
    if (this.q != null) {
      this.m.unregisterAdapterDataObserver(this.q);
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66))) {
      return false;
    }
    paramTextView = this.U.getText().toString().trim();
    if (!TextUtils.isEmpty(paramTextView)) {
      a(paramTextView);
    }
    a(false, 50L);
    if (this.T == 0) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    ReportController.b(this.i, "dc00898", "", "", "0X800941B", "0X800941B", paramInt, 0, "", "", "", "");
    return true;
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getQBaseActivity() != null) {
      getQBaseActivity().overridePendingTransition(0, 2130772473);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    j(2131168092);
    if ((!this.ak) && (this.T == 1))
    {
      e(false);
      this.ab.postDelayed(new ExtendFriendSearchFragment.9(this), 50L);
    }
    this.ak = false;
    if ((this.U != null) && (this.l != null)) {
      c(this.l.y());
    }
  }
  
  public void onSoftKeyboardClosed()
  {
    this.U.setCursorVisible(false);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    this.U.setCursorVisible(true);
  }
  
  public void onStop()
  {
    super.onStop();
    r();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    QuickPinyinEditText localQuickPinyinEditText = this.U;
    if (localQuickPinyinEditText != null) {
      localQuickPinyinEditText.removeTextChangedListener(this);
    }
    super.onViewStateRestored(paramBundle);
    paramBundle = this.U;
    if (paramBundle != null) {
      paramBundle.addTextChangedListener(this);
    }
  }
  
  protected void r()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchFragment", 2, "hideInputMethod");
    }
    this.U.clearFocus();
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.U.getWindowToken(), 0);
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchFragment", 2, "showInputMethod");
    }
    if (this.h != null)
    {
      QuickPinyinEditText localQuickPinyinEditText = this.U;
      if (localQuickPinyinEditText != null)
      {
        localQuickPinyinEditText.clearFocus();
        ((InputMethodManager)this.h.getSystemService("input_method")).showSoftInput(this.U, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchFragment
 * JD-Core Version:    0.7.0.1
 */