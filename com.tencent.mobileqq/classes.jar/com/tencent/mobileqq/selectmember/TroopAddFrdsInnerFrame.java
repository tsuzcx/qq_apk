package com.tencent.mobileqq.selectmember;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopAddFriendHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.util.TroopInfoUtil;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopAddFrdsInnerFrame
  extends SelectMemberInnerFrame
  implements Handler.Callback, View.OnClickListener, SelectMemberActivity.IOnSelectStateChange, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, AbsListView.OnScrollListener
{
  private static final int Q = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getSCENE_TYPE_DEFAULT_Value();
  private static int R = 1000;
  protected static double v = 10.0D;
  public static int x = 0;
  public static int y = 1;
  Set<String> A = new HashSet();
  Handler B;
  Handler C;
  FriendObserver D = new TroopAddFrdsInnerFrame.1(this);
  IFriendObserver E = new TroopAddFrdsInnerFrame.2(this);
  TroopObserver F = new TroopAddFrdsInnerFrame.3(this);
  long G = 0L;
  private String H;
  private String I;
  private TroopInfo J;
  private int K;
  private String L;
  private IndexView M;
  private int N = 0;
  private View O;
  private EditText P;
  int a = 0;
  String b = "";
  String c;
  Long d;
  PinnedDividerListView e;
  TroopAddFrdsInnerFrame.ListAdapter j;
  TextView k;
  Map<String, List<TroopMemberInfo>> l = Collections.synchronizedMap(new LinkedHashMap());
  int[] m = new int[0];
  String[] n = new String[0];
  int o = 0;
  int p = 0;
  boolean q = false;
  protected RelativeLayout r;
  protected ProgressBar s;
  protected TextView t;
  protected double u = 0.0D;
  boolean w = false;
  int z = y;
  
  public TroopAddFrdsInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopAddFrdsInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopAddFrdsInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void a(Context paramContext, TroopMemberInfo paramTroopMemberInfo, String paramString, boolean paramBoolean)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = CommonUtils.a(localAppInterface, paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin);
    if ((paramContext instanceof Activity))
    {
      i = ((Activity)paramContext).getIntent().getIntExtra("batch_addfrd_scene_type", Q);
      if (i != Q)
      {
        i = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getSubSourceId_single(i);
        break label83;
      }
    }
    int i = 16;
    label83:
    paramString = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramContext, 1, paramTroopMemberInfo.memberuin, paramString, 3004, i, str, null, null, null, null);
    paramString.putExtra("need_result_uin", true);
    paramString.putExtra("select_multi_mode", paramBoolean);
    paramString.putExtra("troop_uin", paramTroopMemberInfo.troopuin);
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult((Activity)paramContext, paramString, 11);
    ThreadManager.post(new TroopAddFrdsInnerFrame.7(paramBoolean, localAppInterface, paramTroopMemberInfo), 5, null, true);
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (Object[])paramMessage.obj;
    this.r.setVisibility(8);
    if (paramMessage.length == 3)
    {
      this.l = ((Map)paramMessage[0]);
      this.m = ((int[])paramMessage[1]);
      this.n = ((String[])paramMessage[2]);
      this.k.setVisibility(8);
    }
    else
    {
      this.l = Collections.synchronizedMap(new LinkedHashMap());
      this.m = new int[0];
      this.n = new String[0];
      this.k.setVisibility(0);
    }
    f();
  }
  
  private void a(String paramString, List<TroopMemberInfo> paramList)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      if (paramList == null)
      {
        localObject = this.h.getEntityManagerFactory().createEntityManager();
        paramList = ((EntityManager)localObject).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
        ((EntityManager)localObject).close();
        if (!QLog.isColorLevel()) {
          break label475;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTroopMemberFromDB, troopMemberInfoList==null, queryDB, troopUin=");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(",");
        if (paramList == null) {
          i = 0;
        } else {
          i = paramList.size();
        }
        ((StringBuilder)localObject).append(i);
        QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)localObject).toString());
        break label475;
      }
      if (!QLog.isColorLevel()) {
        break label478;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopMemberFromDB, troopuin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",");
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)localObject).toString());
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        Map localMap;
        ArrayList localArrayList;
        String str;
        int i1;
        int i2;
        StringBuilder localStringBuilder;
        for (;;)
        {
          throw paramString;
        }
        label475:
        continue;
        label478:
        continue;
        int i = 1;
        continue;
        label486:
        i = 0;
      }
    }
    localMap = Collections.synchronizedMap(new LinkedHashMap());
    localArrayList = new ArrayList();
    CommonUtils.e(this.h, this.c);
    str = this.h.getCurrentAccountUin();
    if (paramList == null)
    {
      paramString = this.C.obtainMessage(3);
      this.C.sendMessage(paramString);
      return;
    }
    i1 = paramList.size();
    this.a = (i1 - 1);
    if (i1 > 0)
    {
      i2 = i1 / R;
      if (i1 % R == 0)
      {
        i = 0;
        localObject = new AtomicInteger(i2 + i);
        if (!QLog.isColorLevel()) {
          break label486;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parallel process mJobCount: ");
        localStringBuilder.append(((AtomicInteger)localObject).get());
        QLog.d("TroopMemberListInnerFrame.thread", 2, localStringBuilder.toString());
        break label486;
        while (i < i1)
        {
          ThreadManager.post(new TroopAddFrdsInnerFrame.5(this, paramList, i, Math.min(R + i - 1, i1), paramString, str, localMap, localArrayList, (AtomicInteger)localObject), 8, null, false);
          i += R;
        }
      }
    }
    else
    {
      paramString = this.C.obtainMessage(3);
      this.C.sendMessage(paramString);
      return;
    }
  }
  
  private void a(Map<String, List<TroopMemberInfo>> paramMap)
  {
    Object localObject1 = (ITroopRobotService)this.f.getAppRuntime().getRuntimeService(ITroopRobotService.class, "all");
    boolean bool = TroopInfoUtil.a(this.f.getAppRuntime(), this.c, this.f.getAppRuntime().getCurrentAccountUin());
    int i1;
    if ((!((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(this.f.getAppRuntime(), this.c, this.f.getAppRuntime().getCurrentAccountUin())) && (!bool)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Iterator localIterator = paramMap.values().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (List)localIterator.next();
      int i2;
      for (int i = 0; i < ((List)localObject2).size(); i = i2 + 1)
      {
        if (((List)localObject2).get(i) == null) {
          ((List)localObject2).remove(i);
        }
        for (;;)
        {
          i2 = i - 1;
          break;
          if (CommonUtils.a(this.h, ((TroopMemberInfo)((List)localObject2).get(i)).memberuin))
          {
            ((List)localObject2).remove(i);
          }
          else
          {
            i2 = i;
            if (i1 == 0) {
              break;
            }
            i2 = i;
            if (!((ITroopRobotService)localObject1).isRobotUin(((TroopMemberInfo)((List)localObject2).get(i)).memberuin)) {
              break;
            }
            ((List)localObject2).remove(i);
          }
        }
      }
    }
    localObject1 = new HashMap();
    localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      if (((List)paramMap.get(localObject2)).size() == 0) {
        ((Map)localObject1).put(localObject2, Integer.valueOf(1));
      }
    }
    localObject1 = ((Map)localObject1).keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramMap.remove((String)((Iterator)localObject1).next());
    }
  }
  
  private int b(String paramString)
  {
    boolean bool2 = SearchUtils.b(this.h, paramString);
    boolean bool1;
    if (!bool2) {
      bool1 = SearchUtils.c(this.h, paramString);
    } else {
      bool1 = false;
    }
    if (bool2) {
      return 4;
    }
    if (bool1) {
      return 3;
    }
    return 2;
  }
  
  private void c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject1 = CommonUtils.d(this.h, paramString);
      if (localObject1 != null) {
        localObject1 = ((TroopInfo)localObject1).troopcode;
      } else {
        localObject1 = "0";
      }
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          this.f.stopTitleProgress();
          QQToast.makeText(this.f, this.f.getString(2131889169), 0).show(this.f.mTitleBar.getHeight());
          return;
        }
        this.q = true;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("get troop members from server, troopUin: ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" troopCode: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("TroopAddFrdsInnerFrame", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberListHandlerName();
        localObject2 = (ITroopMemberListHandler)this.h.getBusinessHandler((String)localObject2);
        this.G = System.currentTimeMillis();
        ((ITroopMemberListHandler)localObject2).a(true, paramString, (String)localObject1, true, 7, this.G, Q);
      }
    }
  }
  
  private void g()
  {
    this.e = ((PinnedDividerListView)findViewById(2131430527));
    this.M = ((IndexView)findViewById(2131435678));
    if (this.z == x)
    {
      this.M.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.M.setOnIndexChangedListener(this);
    }
    else
    {
      this.M.setVisibility(8);
    }
    this.e.setSelector(2131168376);
    this.e.setOnLayoutListener(this);
    this.k = ((TextView)findViewById(2131448609));
    this.r = ((RelativeLayout)findViewById(2131448021));
    this.s = ((ProgressBar)findViewById(2131435131));
    this.t = ((TextView)findViewById(2131437663));
    this.O = LayoutInflater.from(this.f).inflate(2131629215, this.e, false);
    this.O.findViewById(2131429816).setVisibility(8);
    this.P = ((EditText)this.O.findViewById(2131432634));
    this.P.setFocusableInTouchMode(false);
    this.P.setCursorVisible(false);
    this.P.setOnClickListener(this);
    this.e.addHeaderView(this.O);
  }
  
  private void getTroopMembers()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.h.getApp());
    String str = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getScene_SP_KEY_BAF_DATA_CHECK_FLAG_MEMBERS_KeyString();
    long l1 = ((SharedPreferences)localObject).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { str, this.h.getCurrentAccountUin(), this.c }), 0L);
    this.J = CommonUtils.d(this.h, this.c);
    localObject = this.J;
    if (localObject != null)
    {
      this.a = (((TroopInfo)localObject).wMemberNum - 1);
      if (this.a > 0)
      {
        this.u = 0.0D;
        localObject = this.C;
        ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(4));
      }
    }
    if (l1 == 0L)
    {
      c(this.c);
      return;
    }
    ThreadManager.executeOnNetWorkThread(new TroopAddFrdsInnerFrame.4(this));
  }
  
  private Object[] h()
  {
    Object localObject1 = this.l.keySet().iterator();
    if ((this.J == null) && (QLog.isColorLevel())) {
      QLog.d("TroopAddFrdsInnerFrame", 2, "sortMembers: mTroopInfo not exist");
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      Collections.sort((List)this.l.get(localObject2), new TroopAddFrdsInnerFrame.MyComparator(this, null));
    }
    localObject1 = this.l;
    this.l = Collections.synchronizedMap(new LinkedHashMap());
    int i = this.z;
    if (i == x)
    {
      for (char c1 = 'A'; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
        if (((Map)localObject1).get(String.valueOf(c1)) != null) {
          this.l.put(String.valueOf(c1), ((Map)localObject1).get(String.valueOf(c1)));
        }
      }
      if (((Map)localObject1).get("#") != null) {
        this.l.put("#", ((Map)localObject1).get("#"));
      }
      ((Map)localObject1).clear();
    }
    else if (i == y)
    {
      i = 1;
      while (i < 5)
      {
        if (((Map)localObject1).get(String.valueOf(i)) != null) {
          this.l.put(String.valueOf(i), ((Map)localObject1).get(String.valueOf(i)));
        }
        i += 1;
      }
      ((Map)localObject1).clear();
    }
    localObject1 = new int[this.l.keySet().size()];
    Object localObject2 = new String[this.l.keySet().size()];
    Iterator localIterator = this.l.keySet().iterator();
    if (localObject1.length == 0) {
      return new Object[0];
    }
    localObject1[0] = 0;
    i = 1;
    while (i < localObject1.length)
    {
      localObject1[i] += localObject1[(i - 1)] + ((List)this.l.get(localIterator.next())).size() + 1;
      i += 1;
    }
    localIterator = this.l.keySet().iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      localObject2[i] = ((String)localIterator.next());
      i += 1;
    }
    return new Object[] { this.l, localObject1, localObject2 };
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if ((paramInt1 == 10) && (paramIntent != null) && (paramInt2 == -1))
    {
      localObject = paramIntent.getStringExtra(((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getUnitedVerifyMsgEditFragment_VERIFY_MSG_KeyString());
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      paramIntent = this.f.getResultUins();
      paramInt1 = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getSubSourceId_multi(this.K);
      ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).batchAddFriendForTroopMembers(this.h, this.c, this.I, (String)localObject, paramIntent, true, 3093, paramInt1);
      localObject = this.B.obtainMessage(9);
      ((Message)localObject).obj = paramIntent;
      ((Message)localObject).sendToTarget();
      this.f.toggleSelectMode(true, false);
      this.C.removeMessages(8);
      localObject = this.C;
      ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(8), 120L);
      QQToast.makeText(this.f, this.f.getString(2131916262), 0).show();
      f();
      localObject = this.c;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ThreadManager.post(new TroopAddFrdsInnerFrame.6(this, (String)localObject, paramIntent), 5, null, true);
      }
    }
    else if ((paramInt1 == 11) && (paramIntent != null) && (paramInt2 == -1))
    {
      localObject = paramIntent.getStringExtra("uin");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      paramIntent = new ArrayList(1);
      paramIntent.add(localObject);
      if (this.w)
      {
        this.f.toggleSelectMode(true, false);
        this.C.removeMessages(8);
        localObject = this.C;
        ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(8), 120L);
      }
      localObject = this.B.obtainMessage(9);
      ((Message)localObject).obj = paramIntent;
      ((Message)localObject).sendToTarget();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131629255);
    this.B = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.C = new Handler(Looper.getMainLooper(), this);
    this.K = paramBundle.getInt("batch_addfrd_scene_type", Q);
    g();
    this.j = new TroopAddFrdsInnerFrame.ListAdapter(this);
    this.e.setAdapter(this.j);
    this.e.setOnScrollListener(this);
    this.f.addObserver(this.E);
    this.f.addObserver(this.D);
    this.f.addObserver(this.F);
    this.f.setOnSelectStateChangeListener(this);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    if (paramResultRecord != null) {
      this.j.a(paramResultRecord, paramBoolean);
    }
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.l.keySet().iterator();
    TroopMemberInfo localTroopMemberInfo = null;
    label110:
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (List)this.l.get(localObject);
      int i = 0;
      for (;;)
      {
        if (i >= ((List)localObject).size()) {
          break label110;
        }
        if (paramString.equals(((TroopMemberInfo)((List)localObject).get(i)).memberuin))
        {
          localTroopMemberInfo = (TroopMemberInfo)((List)localObject).get(i);
          break;
        }
        i += 1;
      }
    }
    if (localTroopMemberInfo != null) {
      a(this.f, localTroopMemberInfo, this.I, true);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.w ^= true;
    }
    if (this.w) {
      this.e.removeHeaderView(this.O);
    } else {
      this.e.addHeaderView(this.O);
    }
    if (paramBoolean1)
    {
      this.j.a.clear();
      this.f.removeAllFriendResult();
    }
    this.j.a(this.w);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.q = false;
    this.f.mSelectedAndSearchBar.c();
    this.c = paramBundle.getString("group_uin");
    this.H = paramBundle.getString("group_name");
    this.I = paramBundle.getString("param_groupcode");
    this.L = paramBundle.getString("batch_addfrd_recommand_uin");
    paramBundle = this.H;
    if ((paramBundle == null) || (paramBundle.length() == 0))
    {
      paramBundle = this.c;
      if ((paramBundle != null) && (paramBundle.length() > 0))
      {
        paramBundle = CommonUtils.d(this.h, this.c);
        if (paramBundle != null) {
          this.H = paramBundle.getTroopDisplayName();
        }
      }
    }
    if (this.f.mOnlyTroopMember) {
      this.f.setupTitleBar(false, "", this.H);
    } else {
      this.f.setupTitleBar(true, HardCodeUtil.a(2131912431), this.H);
    }
    this.r.setVisibility(8);
    paramBundle = this.c;
    if ((paramBundle != null) && (paramBundle.length() > 0))
    {
      if (!this.c.equals(this.b))
      {
        this.l = Collections.synchronizedMap(new LinkedHashMap());
        this.m = new int[0];
        this.n = new String[0];
        f();
        this.k.setVisibility(8);
        getTroopMembers();
        this.e.setSelection(0);
        this.b = this.c;
        return;
      }
      f();
      return;
    }
    this.f.finish();
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    TroopAddFrdsInnerFrame.ListAdapter localListAdapter = this.j;
    if (localListAdapter != null) {
      localListAdapter.d();
    }
    this.C.removeCallbacksAndMessages(null);
    this.B.removeCallbacksAndMessages(null);
    this.f.removeObserver(this.E);
    this.f.removeObserver(this.D);
    this.f.removeObserver(this.F);
    super.d();
  }
  
  public void f()
  {
    this.j.notifyDataSetChanged();
  }
  
  public ContactSearchFragment getContactSearchFragment()
  {
    return ContactSearchFragment.a(24, 1048576, this.c, this.f.mUinsToHide, this.f);
  }
  
  public String getGroupUin()
  {
    return this.c;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    Object localObject2;
    int i;
    int i2;
    int i1;
    String str;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 10: 
      if (this.A.size() > 0)
      {
        paramMessage = new HashMap(this.A.size());
        localObject1 = this.A.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          paramMessage.put(localObject2, Integer.valueOf(b((String)localObject2)));
        }
        this.A.clear();
        localObject1 = this.C.obtainMessage(7);
        ((Message)localObject1).obj = paramMessage;
        ((Message)localObject1).sendToTarget();
        return false;
      }
      break;
    case 9: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof List)))
      {
        paramMessage = (List)paramMessage.obj;
        this.A.addAll(paramMessage);
        if (!this.B.hasMessages(10))
        {
          this.B.sendEmptyMessageDelayed(10, 300L);
          return false;
        }
      }
      break;
    case 8: 
      this.e.setSelectionFromTop(0, 0);
      return false;
    case 7: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof HashMap)))
      {
        paramMessage = (HashMap)paramMessage.obj;
        localObject1 = this.l.keySet().iterator();
        for (i = 0; ((Iterator)localObject1).hasNext(); i = i1)
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = (List)this.l.get(localObject2);
          i2 = 0;
          for (;;)
          {
            i1 = i;
            if (i2 >= ((List)localObject2).size()) {
              break;
            }
            str = ((TroopMemberInfo)((List)localObject2).get(i2)).memberuin;
            i1 = i;
            if (paramMessage.containsKey(str))
            {
              i1 = i + 1;
              i = ((Integer)paramMessage.get(str)).intValue();
              ((TroopMemberInfo)((List)localObject2).get(i2)).addState = i;
            }
            if (i1 >= paramMessage.size()) {
              break;
            }
            i2 += 1;
            i = i1;
          }
        }
        f();
        return false;
      }
      break;
    case 6: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof HashMap)))
      {
        paramMessage = (HashMap)paramMessage.obj;
        localObject1 = this.l.keySet().iterator();
        for (i = 0; ((Iterator)localObject1).hasNext(); i = i1)
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = (List)this.l.get(localObject2);
          i2 = 0;
          for (;;)
          {
            i1 = i;
            if (i2 >= ((List)localObject2).size()) {
              break;
            }
            str = ((TroopMemberInfo)((List)localObject2).get(i2)).memberuin;
            i1 = i;
            if (paramMessage.containsKey(str))
            {
              i += 1;
              i1 = ((Integer)paramMessage.get(str)).intValue();
              ((TroopMemberInfo)((List)localObject2).get(i2)).commonFrdCnt = i1;
              i1 = i;
              if (i >= paramMessage.size())
              {
                i1 = i;
                break;
              }
            }
            i2 += 1;
            i = i1;
          }
        }
        f();
        return false;
      }
      break;
    case 5: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof List)))
      {
        paramMessage = (List)paramMessage.obj;
        localObject1 = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAddFriendHandlerName();
        localObject1 = (ITroopAddFriendHandler)this.h.getBusinessHandler((String)localObject1);
        this.d = Long.valueOf(System.currentTimeMillis());
        ((ITroopAddFriendHandler)localObject1).a(this.c, paramMessage, 0, this.d.longValue(), Q, false);
        return false;
      }
      break;
    case 4: 
      this.u += v;
      if ((this.u < 90.0D) && (this.a > 0))
      {
        if (this.r.getVisibility() == 8) {
          this.r.setVisibility(0);
        }
        this.s.setProgress((int)this.u);
        paramMessage = this.t;
        localObject1 = HardCodeUtil.a(2131912429);
        i = this.a;
        double d1 = i;
        double d2 = this.u;
        Double.isNaN(d1);
        paramMessage.setText(String.format((String)localObject1, new Object[] { Integer.valueOf(Math.min((int)(d1 * d2 / 100.0D), i)), Integer.valueOf(this.a) }));
        paramMessage = this.C;
        paramMessage.sendMessageDelayed(paramMessage.obtainMessage(4), 800L);
        return false;
      }
      break;
    case 3: 
      this.N = paramMessage.arg1;
      this.C.removeMessages(4);
      if ((paramMessage.obj instanceof Object[]))
      {
        localObject2 = (Object[])paramMessage.obj;
        if (localObject2.length > 0)
        {
          localObject1 = (String)localObject2[1];
          if (!((String)localObject1).equals(this.c))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            paramMessage = new StringBuilder();
            paramMessage.append("handleMessage, troopUin != mTroopUin, break:");
            paramMessage.append((String)localObject1);
            paramMessage.append(",");
            paramMessage.append(this.c);
            QLog.d("TroopMemberListInnerFrame.thread", 2, paramMessage.toString());
            return false;
          }
          this.l = ((Map)localObject2[0]);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleMessage, mIndexedFriends.size=");
        ((StringBuilder)localObject1).append(this.l.size());
        QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)localObject1).toString());
      }
      a(this.l);
      paramMessage.obj = h();
      a(paramMessage);
      return false;
    case 1: 
    case 2: 
      a(paramMessage);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131432634)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("batch_addfrd_scene_type", this.K);
      ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).launchContactSearchComponentActivityForResult(this.f, null, this.c, 23, 1048576, 21001, localBundle);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.e.setSelection(0);
      return;
    }
    int i = this.j.b(paramString);
    if (i != -1)
    {
      paramString = this.e;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      paramAbsListView = MobileQQ.sMobileQQ;
      ((InputMethodManager)MobileQQ.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.e.getWindowToken(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame
 * JD-Core Version:    0.7.0.1
 */