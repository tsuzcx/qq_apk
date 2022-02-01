package com.tencent.mobileqq.search.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.LocationInterface;
import com.tencent.mobileqq.search.SearchFragmentInfoInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.adapter.SubBusinessSearchAdapter;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.recommend.RecommendTroopListWrapper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tencent.im.oidb.search.DynamicTabSearch.SubHotWord;

public class ActiveEntitySearchFragment
  extends BaseFragment
  implements View.OnClickListener, SearchFragmentInfoInterface, AbsListView.OnScrollListener
{
  public static String a;
  Bitmap A;
  TextView B;
  Button C;
  String D = "";
  boolean E = false;
  public long[] F;
  public List<Long> G = new ArrayList();
  boolean H = false;
  RecommendTroopListWrapper I;
  int J = 0;
  int K = 0;
  protected UnifySearchObserver L = new ActiveEntitySearchFragment.1(this);
  protected UniteSearchObserver M = new ActiveEntitySearchFragment.2(this);
  public String N;
  TextView O;
  TextView P;
  private int Q;
  private int R;
  private String S;
  private List<DynamicTabSearch.SubHotWord> T;
  private boolean U = true;
  private long V = -1L;
  private int W;
  public String b;
  public boolean c = true;
  public String d = "";
  public boolean e;
  public boolean f = false;
  public List<IModel> g;
  protected View h;
  protected XListView i;
  protected SubBusinessSearchAdapter j;
  protected IFaceDecoder k;
  protected QQAppInterface l;
  protected UnifySearchHandler m;
  protected UniteSearchHandler n;
  public byte[] o;
  protected boolean p;
  View q;
  View r;
  View s;
  TextView t;
  LinearLayout u;
  View v;
  View w;
  View x;
  XListView y;
  ImageView z;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.uniteSearch.");
    localStringBuilder.append(ActiveEntitySearchFragment.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public static ActiveEntitySearchFragment a(int paramInt, long[] paramArrayOfLong, String paramString1, String paramString2)
  {
    ActiveEntitySearchFragment localActiveEntitySearchFragment = new ActiveEntitySearchFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt);
    localBundle.putLongArray("group_mask_long_array", paramArrayOfLong);
    localBundle.putString("group_name_string", paramString1);
    localBundle.putString("keyword", paramString2);
    localActiveEntitySearchFragment.setArguments(localBundle);
    return localActiveEntitySearchFragment;
  }
  
  public static boolean a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((paramArrayOfLong1 != null) && (paramArrayOfLong2 != null))
    {
      if (paramArrayOfLong1.length != paramArrayOfLong2.length) {
        return false;
      }
      int i1 = 0;
      while (i1 < paramArrayOfLong1.length)
      {
        if (paramArrayOfLong1[i1] != paramArrayOfLong2[i1]) {
          return false;
        }
        i1 += 1;
      }
      return true;
    }
    return false;
  }
  
  int a()
  {
    List localList = this.g;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.o;
        if (localObject1 != null) {
          return;
        }
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("hash = ");
          ((StringBuilder)localObject2).append(hashCode());
          ((StringBuilder)localObject2).append("   startSearchTAB isEnd = true mask;");
          ((StringBuilder)localObject2).append(Arrays.toString(this.F));
          ((StringBuilder)localObject2).append(" key=");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append("  name=");
          ((StringBuilder)localObject2).append(this.N);
          ((StringBuilder)localObject2).append(" isViewCreated");
          ((StringBuilder)localObject2).append(this.f);
          QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        this.K = 0;
        this.J = 0;
        this.b = paramString;
        if (this.f)
        {
          if (!(getBaseActivity() instanceof LocationInterface)) {
            break label370;
          }
          d1 = ((LocationInterface)getBaseActivity()).a();
          d2 = ((LocationInterface)getBaseActivity()).b();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(System.currentTimeMillis());
          ((StringBuilder)localObject1).append("");
          this.D = ((StringBuilder)localObject1).toString();
          this.E = true;
          localObject1 = new Bundle();
          if ((getBaseActivity() instanceof ActiveEntitySearchActivity))
          {
            localObject2 = (ActiveEntitySearchActivity)getBaseActivity();
            ((Bundle)localObject1).putInt("fromTypeForReport", ((ActiveEntitySearchActivity)localObject2).l);
            ((Bundle)localObject1).putInt("searchAvatarFrom", ((ActiveEntitySearchActivity)localObject2).r);
          }
          ((Bundle)localObject1).putBoolean("isLoadMore", false);
          ((Bundle)localObject1).putInt("fromType", this.R);
          a(paramString, b(), null, d1, d2, (Bundle)localObject1);
          b(false);
        }
        else
        {
          this.e = true;
          this.d = paramString;
          if (QLog.isColorLevel()) {
            QLog.i(a, 2, "startSearch 触发延迟逻辑");
          }
        }
        return;
      }
      finally {}
      label370:
      double d2 = 0.0D;
      double d1 = d2;
    }
  }
  
  protected void a(String paramString, List<Long> paramList, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      ((UniteSearchHandler)localObject).a(paramString, this.D, 20, SearchUtil.a(this.F), paramList, paramArrayOfByte, this.Q, paramDouble1, paramDouble2, paramBundle);
      return;
    }
    localObject = this.m;
    if (localObject != null)
    {
      ((UnifySearchHandler)localObject).a(paramString, this.D, 20, SearchUtil.a(this.F), paramList, paramArrayOfByte, this.Q, paramDouble1, paramDouble2, paramBundle);
      return;
    }
    QLog.e(a, 2, "handler null in frag");
  }
  
  public void a(List<IModel> paramList)
  {
    Object localObject = getBaseActivity();
    int i2 = 0;
    if (localObject != null)
    {
      localObject = getBaseActivity().getIntent();
      if (localObject != null)
      {
        i1 = ((Intent)localObject).getIntExtra("from_type_for_report", 0);
        break label42;
      }
    }
    int i1 = 0;
    label42:
    if (i1 == 9) {
      i1 = 5;
    } else if (i1 == 3) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    if (i1 > 0) {
      while (i2 < paramList.size())
      {
        if ((paramList.get(i2) instanceof GroupSearchModeTitle))
        {
          localObject = (GroupSearchModeTitle)paramList.get(i2);
          if ((localObject != null) && ((((GroupSearchModeTitle)localObject).k() instanceof GroupBaseNetSearchModel)))
          {
            localObject = (GroupBaseNetSearchModel)((GroupSearchModeTitle)localObject).k();
            if ((localObject != null) && (((GroupBaseNetSearchModel)localObject).a == 1002L)) {
              ((GroupBaseNetSearchModel)localObject).c(i1);
            }
          }
        }
        i2 += 1;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.U = paramBoolean;
  }
  
  public List<Long> b()
  {
    List localList1 = new PublicAccountSearchEngine(this.l, this.R).a(new SearchRequest(this.b));
    if ((localList1 != null) && (localList1.size() != 0))
    {
      List localList2 = ((IPublicAccountDataManager)this.l.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicAccountList();
      ArrayList localArrayList = new ArrayList();
      int i1;
      if ((localList2 != null) && (!localList2.isEmpty())) {
        i1 = 0;
      }
      while (i1 < localList1.size())
      {
        PublicAccountSearchResultModel localPublicAccountSearchResultModel = (PublicAccountSearchResultModel)localList1.get(i1);
        int i2 = 0;
        while (i2 < localList2.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localList2.get(i2);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localPublicAccountSearchResultModel.a.uin))) {
            localArrayList.add(Long.valueOf(localPublicAccountInfo.uin));
          }
          i2 += 1;
        }
        i1 += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "all publicAccountInfoList is null or empty");
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public void b(String paramString)
  {
    for (;;)
    {
      try
      {
        this.P.setVisibility(8);
        this.q.setVisibility(0);
        if (this.o != null) {
          SearchUtils.a("all_result", "load_tab", new String[] { paramString, SearchUtils.a(this.G), "", SearchUtils.a("UnifySearch.Unite", this.F) });
        }
        if ((getBaseActivity() instanceof LocationInterface))
        {
          d1 = ((LocationInterface)getBaseActivity()).a();
          d2 = ((LocationInterface)getBaseActivity()).b();
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(System.currentTimeMillis());
          ((StringBuilder)localObject).append("");
          this.D = ((StringBuilder)localObject).toString();
          if (QLog.isColorLevel())
          {
            localObject = a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("startNewSearchTAB isEnd = true mask;");
            localStringBuilder.append(Arrays.toString(this.F));
            localStringBuilder.append(" key=");
            localStringBuilder.append(paramString);
            localStringBuilder.append("  name=");
            localStringBuilder.append(this.N);
            localStringBuilder.append(" reqTime=");
            localStringBuilder.append(this.D);
            QLog.w((String)localObject, 2, localStringBuilder.toString());
          }
          this.E = true;
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("isLoadMore", true);
          ((Bundle)localObject).putInt("fromType", this.R);
          a(paramString, b(), this.o, d1, d2, (Bundle)localObject);
          b(true);
          return;
        }
      }
      finally {}
      double d1 = 0.0D;
      double d2 = d1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = false;
    if (this.f)
    {
      this.x.setVisibility(8);
      this.O.setVisibility(8);
      if (paramBoolean)
      {
        this.q.setVisibility(0);
        return;
      }
      this.v.setVisibility(0);
    }
  }
  
  protected void c()
  {
    if (this.R == 10)
    {
      this.l.removeObserver(this.M);
      return;
    }
    this.l.removeObserver(this.L);
  }
  
  public boolean dm_()
  {
    return this.U;
  }
  
  protected void e()
  {
    if (this.R == 10)
    {
      this.n = ((UniteSearchHandler)this.l.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER));
      this.m = null;
      this.l.addObserver(this.M);
      return;
    }
    this.m = ((UnifySearchHandler)this.l.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER));
    this.n = null;
    this.l.addObserver(this.L);
  }
  
  public void f()
  {
    List localList = this.g;
    if ((localList != null) && (this.j != null))
    {
      localList.clear();
      this.G.clear();
      a(false);
      this.j.a(this.g);
    }
    if (this.f)
    {
      this.v.setVisibility(8);
      this.q.setVisibility(8);
      this.O.setVisibility(8);
      this.w.setVisibility(8);
      this.x.setVisibility(8);
      this.s.setVisibility(8);
      this.u.removeAllViews();
    }
  }
  
  protected SubBusinessSearchAdapter g()
  {
    return new SubBusinessSearchAdapter(this.i, this.k, this, 0);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(2131435165);
    if ((localObject1 instanceof DynamicTabSearch.SubHotWord))
    {
      localObject1 = (DynamicTabSearch.SubHotWord)localObject1;
      this.Q = ((DynamicTabSearch.SubHotWord)localObject1).word_id.get();
      Object localObject2 = getBaseActivity();
      if ((localObject2 instanceof ActiveEntitySearchActivity))
      {
        localObject2 = (ActiveEntitySearchActivity)localObject2;
        SearchUtils.a("sub_result", "clk_relate", new String[] { this.b, ((DynamicTabSearch.SubHotWord)localObject1).search_word.get().toStringUtf8(), "", "" });
        ((ActiveEntitySearchActivity)localObject2).a((DynamicTabSearch.SubHotWord)localObject1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    Object localObject = getBaseActivity();
    if ((localObject instanceof UniteSearchActivity)) {
      this.H = true;
    }
    if ((localObject instanceof BaseActivity))
    {
      this.l = ((BaseActivity)localObject).app;
      this.k = ((IQQAvatarService)this.l.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.l);
      if (localBundle != null)
      {
        this.R = localBundle.getInt("fromType", -1);
        this.F = localBundle.getLongArray("group_mask_long_array");
        localObject = this.F;
        if (localObject != null)
        {
          if ((localObject.length == 1) && (localObject[0] == 0L)) {
            if (this.R == 10) {
              this.F = UniteSearchHandler.c;
            } else {
              this.F = UnifySearchHandler.c;
            }
          }
          this.N = localBundle.getString("group_name_string");
          this.b = localBundle.getString("keyword");
        }
        else
        {
          throw new RuntimeException("mask array can not be null in ActiveEntitySearchFragment.");
        }
      }
      e();
      super.onCreate(paramBundle);
      return;
    }
    throw new IllegalStateException("Activity must be instance of BaseActivity");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1;
    View localView2;
    double d1;
    try
    {
      super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      paramBundle = paramLayoutInflater.inflate(2131627933, paramViewGroup, false);
      this.v = paramBundle.findViewById(2131437664);
      this.v.setVisibility(0);
      this.w = paramBundle.findViewById(2131432605);
      this.x = paramBundle.findViewById(2131432778);
      this.B = ((TextView)paramBundle.findViewById(2131432780));
      this.z = ((ImageView)paramBundle.findViewById(2131432779));
      this.C = ((Button)paramBundle.findViewById(2131442926));
      this.r = ((RelativeLayout)paramBundle.findViewById(2131444724));
      this.y = ((XListView)paramBundle.findViewById(2131437789));
      this.x.setVisibility(8);
      this.w.setVisibility(8);
      localView1 = paramLayoutInflater.inflate(2131626495, null, false);
      this.s = localView1.findViewById(2131441336);
      this.t = ((TextView)localView1.findViewById(2131435166));
      this.u = ((LinearLayout)localView1.findViewById(2131435169));
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        this.s.setBackgroundResource(2130839569);
      } else {
        this.s.setBackgroundResource(2130839568);
      }
      this.s.setVisibility(8);
      this.u.removeAllViews();
      localView2 = paramLayoutInflater.inflate(2131626496, null, false);
      this.q = localView2.findViewById(2131433573);
      this.q.setVisibility(8);
      try
      {
        paramViewGroup = paramLayoutInflater.inflate(2131627523, null, false);
      }
      catch (Exception paramViewGroup)
      {
        if (!QLog.isColorLevel()) {
          break label1030;
        }
      }
      QLog.d(a, 2, QLog.getStackTraceString(paramViewGroup));
    }
    finally {}
    if (paramViewGroup != null)
    {
      this.O = ((TextView)paramViewGroup.findViewById(2131433573));
      this.O.setText(HardCodeUtil.a(2131898039));
      this.O.setTextSize(16.0F);
      this.O.setTextColor(getBaseActivity().getResources().getColor(2131168125));
      this.O.setVisibility(8);
      this.h = paramBundle;
      this.i = ((XListView)paramBundle.findViewById(2131437272));
      this.i.setOnTouchListener(new ActiveEntitySearchFragment.3(this));
      this.i.addFooterView(paramViewGroup);
    }
    try
    {
      paramLayoutInflater = paramLayoutInflater.inflate(2131627523, null, false);
    }
    catch (Exception localException)
    {
      paramLayoutInflater = paramViewGroup;
      if (QLog.isColorLevel())
      {
        QLog.d(a, 2, QLog.getStackTraceString(localException));
        paramLayoutInflater = paramViewGroup;
      }
    }
    if (paramLayoutInflater != null)
    {
      this.P = ((TextView)paramLayoutInflater.findViewById(2131433573));
      this.P.setText(HardCodeUtil.a(2131898047));
      this.P.setTextSize(16.0F);
      this.P.setTextColor(getBaseActivity().getResources().getColor(2131168125));
      this.P.setVisibility(8);
      this.i.addFooterView(paramLayoutInflater);
    }
    this.j = g();
    this.j.a(false);
    if (this.F.length == 1) {
      this.j.a(true);
    }
    this.i.addHeaderView(localView1);
    this.i.setAdapter(this.j);
    this.i.addFooterView(localView2);
    this.f = true;
    if (QLog.isColorLevel())
    {
      paramLayoutInflater = a;
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("hash = ");
      paramViewGroup.append(hashCode());
      paramViewGroup.append("  onCreateView shouldRequestDataOnCreate=");
      paramViewGroup.append(this.e);
      paramViewGroup.append("  name=");
      paramViewGroup.append(this.N);
      paramViewGroup.append(" mask=");
      paramViewGroup.append(Arrays.toString(this.F));
      QLog.w(paramLayoutInflater, 2, paramViewGroup.toString());
    }
    double d2;
    if (this.e)
    {
      if (!(getBaseActivity() instanceof LocationInterface)) {
        break label1035;
      }
      d1 = ((LocationInterface)getBaseActivity()).a();
      d2 = ((LocationInterface)getBaseActivity()).b();
    }
    for (;;)
    {
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append(System.currentTimeMillis());
      paramLayoutInflater.append("");
      this.D = paramLayoutInflater.toString();
      this.b = this.d;
      this.E = true;
      paramLayoutInflater = new Bundle();
      if ((getBaseActivity() instanceof ActiveEntitySearchActivity))
      {
        paramViewGroup = (ActiveEntitySearchActivity)getBaseActivity();
        paramLayoutInflater.putInt("fromTypeForReport", paramViewGroup.l);
        paramLayoutInflater.putInt("searchAvatarFrom", paramViewGroup.r);
      }
      paramLayoutInflater.putBoolean("isLoadMore", false);
      paramLayoutInflater.putInt("fromType", this.R);
      paramViewGroup = b();
      a(this.b, paramViewGroup, this.o, d1, d2, paramLayoutInflater);
      b(false);
      this.e = false;
      break label1008;
      this.j.a(this.g);
      this.v.setVisibility(8);
      this.w.setVisibility(8);
      this.i.setVisibility(0);
      if ((this.g != null) && (!this.g.isEmpty()))
      {
        if (this.p) {
          this.O.setVisibility(0);
        }
      }
      else if (this.p)
      {
        this.x.setVisibility(0);
        this.B.setText(HardCodeUtil.a(2131898050));
      }
      label1008:
      this.i.setOnScrollListener(this);
      AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramBundle);
      return paramBundle;
      label1030:
      paramViewGroup = null;
      break;
      label1035:
      d1 = 0.0D;
      d2 = d1;
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ActiveEntitySearchActivity.s = false;
    this.f = false;
    c();
    this.E = false;
    Object localObject = this.k;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.I;
    if (localObject != null) {
      ((RecommendTroopListWrapper)localObject).e();
    }
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hash = ");
      localStringBuilder.append(hashCode());
      localStringBuilder.append("   onDestroyView mask;");
      localStringBuilder.append(Arrays.toString(this.F));
      localStringBuilder.append(" key=");
      localStringBuilder.append(this.b);
      localStringBuilder.append("  name=");
      localStringBuilder.append(this.N);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.j.notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = this.j;
    if ((paramAbsListView != null) && (paramAbsListView.getCount() != 0))
    {
      if (this.W == 0) {
        return;
      }
      if ((paramInt3 - paramInt1 - paramInt2 < 10) && (!this.E) && (!this.p)) {
        b(this.b);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    paramAbsListView = new StringBuilder();
    paramAbsListView.append(a);
    paramAbsListView.append(" arend ");
    paramAbsListView = paramAbsListView.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" onScrollStateChanged");
    localStringBuilder.append(paramInt);
    QLog.d(paramAbsListView, 4, localStringBuilder.toString());
    this.W = paramInt;
    paramAbsListView = this.j;
    if (paramAbsListView != null)
    {
      if (paramAbsListView.getCount() == 0) {
        return;
      }
      paramAbsListView = this.j;
      if ((paramAbsListView != null) && (paramAbsListView.getCount() != 0))
      {
        paramInt = this.W;
        if (paramInt == 0) {
          return;
        }
        if ((paramInt != 0) && (this.f) && (!this.E) && (!this.p) && (a() < 20)) {
          b(this.b);
        }
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.i.setOnTouchListener(new ActiveEntitySearchFragment.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment
 * JD-Core Version:    0.7.0.1
 */