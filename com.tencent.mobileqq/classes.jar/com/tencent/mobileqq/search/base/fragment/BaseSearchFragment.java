package com.tencent.mobileqq.search.base.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchGroupEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.base.model.SearchRespData;
import com.tencent.mobileqq.search.base.util.VADHelper;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class BaseSearchFragment<M extends IModel>
  extends QBaseFragment
  implements Handler.Callback, ISearchListener<M>
{
  protected LinearLayout A;
  protected TextView B;
  protected View C;
  protected int D = 0;
  protected boolean E;
  public boolean F = false;
  private long a = 0L;
  public boolean j = false;
  protected View k;
  protected ListView l;
  protected BaseMvpAdapter m;
  protected IFaceDecoder n;
  public ISearchEngine o;
  protected AppInterface p;
  public volatile String q;
  public List<M> r;
  public List<M> s;
  public boolean t = false;
  protected volatile boolean u = false;
  protected Handler v = new Handler(this);
  protected View w;
  protected TextView x;
  protected View y;
  protected TextView z;
  
  public void a(String paramString)
  {
    VADHelper.a("voice_search_als_cost");
    a(paramString, 1);
  }
  
  protected void a(String paramString, int paramInt)
  {
    a(paramString, null, paramInt);
  }
  
  protected void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startSearch, key: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(getClass());
      QLog.d("GroupSearchFragment", 2, ((StringBuilder)localObject).toString());
    }
    QBaseActivity localQBaseActivity = super.getQBaseActivity();
    boolean bool2 = localQBaseActivity instanceof BaseSearchActivity;
    boolean bool1;
    if (bool2) {
      bool1 = ((BaseSearchActivity)localQBaseActivity).o;
    } else {
      bool1 = false;
    }
    h_(false);
    boolean bool3 = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if ((bool3) && (!bool1) && (this.m != null))
    {
      this.x.setVisibility(8);
      this.C.setVisibility(8);
      this.y.setVisibility(8);
      this.z.setVisibility(8);
      h_(false);
      o_(false);
      this.w.setVisibility(8);
      this.o.b();
      g();
      paramArrayOfByte = this.m;
      if (paramArrayOfByte != null)
      {
        this.r = null;
        paramArrayOfByte.a(null);
      }
      this.q = paramString;
      return;
    }
    this.q = paramString;
    if (this.l == null) {
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        this.o.c();
      }
    }
    else {
      this.o.b();
    }
    g();
    h();
    this.x.setVisibility(8);
    if (this.u)
    {
      this.D += 1;
      if (bool2) {
        localObject = ((BaseSearchActivity)localQBaseActivity).m;
      }
      if (localObject != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("search_restrict_mem", (String)localObject);
        localObject = (BaseSearchActivity)localQBaseActivity;
        localBundle.putString("search_restrict_uin", ((BaseSearchActivity)localObject).n);
        localBundle.putBoolean("search_restrict_empty", bool1);
        localBundle.putInt("search_restrict_uintype", ((BaseSearchActivity)localObject).p);
        this.o.a(new SearchRequest(paramString, paramArrayOfByte, localBundle), this);
        return;
      }
      this.o.a(new SearchRequest(paramString, paramArrayOfByte), this);
    }
  }
  
  public void a(List<M> paramList)
  {
    this.r = paramList;
    long l1 = System.currentTimeMillis();
    if (l1 - this.a >= 300L)
    {
      this.v.removeMessages(1);
      this.v.sendEmptyMessage(1);
      return;
    }
    this.v.removeMessages(1);
    this.v.sendEmptyMessageDelayed(1, 300L - (l1 - this.a));
  }
  
  public void a(List<M> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, new Object[] { "onFinish with status:", Integer.valueOf(paramInt) });
    }
    VADHelper.b("voice_search_als_cost");
    VADHelper.b("voice_search_all_cost");
    this.r = paramList;
    c(false);
    g();
    this.v.removeMessages(1);
    this.v.sendEmptyMessage(4);
  }
  
  public void a(List<M> paramList, SearchRespData paramSearchRespData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, new Object[] { "onFinish with respData:", paramSearchRespData.toString() });
    }
    if (paramSearchRespData.a(this.q))
    {
      a(paramList, paramSearchRespData.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.a, " keyword2:", this.q });
    }
  }
  
  protected abstract BaseMvpAdapter b();
  
  protected void b(List<M> paramList)
  {
    i();
    this.m.a(paramList);
    this.x.setVisibility(0);
  }
  
  protected abstract ISearchEngine c();
  
  protected void c(List<M> paramList)
  {
    i();
    this.m.a(paramList);
    this.x.setVisibility(8);
    if (this.m.getCount() <= 0) {
      o_(j());
    } else {
      h_(true);
    }
    VADHelper.a(getQBaseActivity());
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.E != paramBoolean)
    {
      this.E = paramBoolean;
      ISearchEngine localISearchEngine = this.o;
      if ((localISearchEngine != null) && ((localISearchEngine instanceof ISearchGroupEngine))) {
        ((ISearchGroupEngine)localISearchEngine).a(paramBoolean);
      }
    }
  }
  
  protected boolean cj_()
  {
    return true;
  }
  
  protected String d()
  {
    return null;
  }
  
  protected void d(List<M> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchFragment", 2, "onSearchTimeout");
    }
    if (this.m.getCount() <= 0)
    {
      i();
      o_(true);
    }
  }
  
  protected String e()
  {
    return null;
  }
  
  protected void g()
  {
    this.v.removeMessages(4);
    this.v.removeMessages(1);
  }
  
  protected void h()
  {
    BaseMvpAdapter localBaseMvpAdapter = this.m;
    if ((localBaseMvpAdapter == null) || (localBaseMvpAdapter.getCount() == 0))
    {
      this.C.setVisibility(0);
      this.w.setVisibility(8);
    }
  }
  
  protected void h_(boolean paramBoolean)
  {
    TextView localTextView = this.B;
    if (localTextView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localTextView.setVisibility(i);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 3)
      {
        if (i != 4) {
          return true;
        }
        c(this.r);
        return true;
      }
      d(this.r);
      return true;
    }
    this.a = System.currentTimeMillis();
    b(this.r);
    return true;
  }
  
  protected void i()
  {
    View localView = this.w;
    int i;
    if (cj_()) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
    this.C.setVisibility(8);
    o_(false);
  }
  
  protected boolean j()
  {
    return true;
  }
  
  protected boolean k()
  {
    return false;
  }
  
  protected int l()
  {
    return 0;
  }
  
  protected void o_(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.A.setVisibility(0);
      ((TextView)this.A.findViewById(2131439367)).setText(this.q);
      this.C.setVisibility(8);
      this.w.setVisibility(8);
      h_(false);
      return;
    }
    this.A.setVisibility(8);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof QBaseActivity))
    {
      this.p = ((AppInterface)((QBaseActivity)paramActivity).getAppRuntime());
      return;
    }
    throw new IllegalStateException("Activity must be instance of BaseActivity");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.o = c();
    if (this.E)
    {
      paramBundle = this.o;
      if ((paramBundle != null) && ((paramBundle instanceof ISearchGroupEngine))) {
        ((ISearchGroupEngine)paramBundle).a(true);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131627776, paramViewGroup, false);
    this.l = ((ListView)paramViewGroup.findViewById(2131437272));
    this.l.setOnTouchListener(new BaseSearchFragment.1(this));
    this.w = paramViewGroup.findViewById(2131434975);
    paramBundle = this.w;
    int i;
    if (cj_()) {
      i = 0;
    } else {
      i = 8;
    }
    paramBundle.setVisibility(i);
    ((TextView)paramViewGroup.findViewById(2131434940)).setText(d());
    this.C = paramViewGroup.findViewById(2131430440);
    this.A = ((LinearLayout)paramViewGroup.findViewById(2131439368));
    paramBundle = (TextView)this.A.findViewById(2131439370);
    String str = e();
    if (!TextUtils.isEmpty(str)) {
      paramBundle.setText(str);
    }
    paramBundle = paramLayoutInflater.inflate(2131627523, null, false);
    this.x = ((TextView)paramBundle.findViewById(2131433573));
    this.x.setText(HardCodeUtil.a(2131899284));
    this.x.setVisibility(8);
    this.B = ((TextView)paramBundle.findViewById(2131439360));
    this.l.addFooterView(paramBundle);
    paramBundle = paramLayoutInflater.inflate(2131626496, null, false);
    this.y = paramBundle.findViewById(2131433573);
    this.y.setVisibility(8);
    this.l.addFooterView(paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131627523, null, false);
    this.z = ((TextView)paramLayoutInflater.findViewById(2131433573));
    this.z.setText(HardCodeUtil.a(2131899289));
    this.z.setTextSize(16.0F);
    this.z.setTextColor(getActivity().getResources().getColor(2131168125));
    this.z.setVisibility(8);
    this.l.addFooterView(paramLayoutInflater);
    this.k = paramViewGroup;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (k()) {
      return;
    }
    IFaceDecoder localIFaceDecoder = this.n;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    ReportController.b(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", l(), 0, String.valueOf(this.D), "", this.q, "");
    if (this.u)
    {
      this.u = false;
      this.o.e();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.n = ((IQQAvatarService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)getQBaseActivity().getAppRuntime());
    this.m = b();
    this.l.setAdapter(this.m);
    i();
    boolean bool;
    if ((super.getQBaseActivity() instanceof BaseSearchActivity)) {
      bool = ((BaseSearchActivity)super.getQBaseActivity()).o;
    } else {
      bool = false;
    }
    ThreadManager.postImmediately(new BaseSearchFragment.2(this, bool), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
 * JD-Core Version:    0.7.0.1
 */