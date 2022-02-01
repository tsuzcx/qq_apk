package com.tencent.mobileqq.selectmember;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopRankConfig.TroopRankItem;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberHandler;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.util.TroopInfoUtil;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class TroopMemberListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  protected static double B = 10.0D;
  private static int I = 1000;
  protected double A = 0.0D;
  Handler C = new TroopMemberListInnerFrame.1(this);
  long D = 0L;
  private String E;
  private TroopInfo F;
  private IndexView G;
  private int H = 0;
  private TroopObserver J = new TroopMemberListInnerFrame.7(this);
  private TroopOnlineMemberObserver K = new TroopMemberListInnerFrame.8(this);
  private AbsListView.OnScrollListener L = new TroopMemberListInnerFrame.9(this);
  int a = 0;
  String b = "";
  String c;
  PinnedDividerListView d;
  TroopMemberListInnerFrame.TroopMemberListAdapter e;
  TextView j;
  RelativeLayout k;
  CheckBox l;
  boolean m;
  TroopMemberInfo n;
  List<TroopMemberInfo> o = new ArrayList();
  Map<String, List<TroopMemberInfo>> p = Collections.synchronizedMap(new LinkedHashMap());
  int[] q = new int[0];
  String[] r = new String[0];
  boolean s = false;
  boolean t = false;
  int u = 1;
  protected TextView v = null;
  protected TextView w = null;
  protected RelativeLayout x;
  protected ProgressBar y;
  protected TextView z;
  
  public TroopMemberListInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(Map<String, List<TroopMemberInfo>> paramMap)
  {
    Object localObject1 = (ITroopRobotService)this.h.getRuntimeService(ITroopRobotService.class, "all");
    boolean bool = TroopInfoUtil.a(this.h, this.c, this.h.getCurrentAccountUin());
    int i1;
    if ((!((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(this.h, this.c, this.h.getCurrentAccountUin())) && (!bool)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Iterator localIterator = paramMap.values().iterator();
    int i2 = 0;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (List)localIterator.next();
      int i3;
      for (int i = 0; i < ((List)localObject2).size(); i = i3 + 1)
      {
        if (((List)localObject2).get(i) == null) {
          ((List)localObject2).remove(i);
        }
        for (;;)
        {
          i3 = i - 1;
          break;
          if (CommonUtils.a(this.h, ((TroopMemberInfo)((List)localObject2).get(i)).memberuin))
          {
            ((List)localObject2).remove(i);
          }
          else
          {
            i3 = i;
            if (i1 == 0) {
              break;
            }
            i3 = i;
            if (!((ITroopRobotService)localObject1).isRobotUin(((TroopMemberInfo)((List)localObject2).get(i)).memberuin)) {
              break;
            }
            ((List)localObject2).remove(i);
          }
        }
      }
      i2 += ((List)localObject2).size();
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
    return i2;
  }
  
  /* Error */
  private Bitmap a(View paramView)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokevirtual 277	android/view/View:getWidth	()I
    //   7: istore_2
    //   8: aload_1
    //   9: invokevirtual 280	android/view/View:getHeight	()I
    //   12: istore_3
    //   13: aload 5
    //   15: astore 4
    //   17: iload_2
    //   18: ifeq +34 -> 52
    //   21: aload 5
    //   23: astore 4
    //   25: iload_3
    //   26: ifeq +26 -> 52
    //   29: iload_2
    //   30: iload_3
    //   31: getstatic 286	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   34: invokestatic 292	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   37: astore 4
    //   39: aload_1
    //   40: new 294	android/graphics/Canvas
    //   43: dup
    //   44: aload 4
    //   46: invokespecial 297	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   49: invokevirtual 301	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   52: aload 4
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: areturn
    //   58: astore_1
    //   59: goto -7 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	TroopMemberListInnerFrame
    //   0	62	1	paramView	View
    //   7	23	2	i	int
    //   12	19	3	i1	int
    //   15	38	4	localObject1	Object
    //   1	21	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	55	java/lang/Exception
    //   3	13	55	java/lang/OutOfMemoryError
    //   29	39	55	java/lang/Exception
    //   29	39	55	java/lang/OutOfMemoryError
    //   39	52	55	java/lang/Exception
    //   39	52	58	java/lang/OutOfMemoryError
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (Object[])paramMessage.obj;
    this.x.setVisibility(8);
    int i = paramMessage.length;
    boolean bool = true;
    if (i == 3)
    {
      this.p = ((Map)paramMessage[0]);
      this.q = ((int[])paramMessage[1]);
      this.r = ((String[])paramMessage[2]);
      this.j.setVisibility(8);
      if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.f))
      {
        ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).handleGameClockData(this.h);
        paramMessage = ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).getQQGameTroopManager_TASK_NAME_MEMBER_StringValue();
        ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).sortAndPreloadIfNeed(this.h, paramMessage);
      }
    }
    else
    {
      this.p = Collections.synchronizedMap(new LinkedHashMap());
      this.q = new int[0];
      this.r = new String[0];
      this.j.setVisibility(0);
    }
    this.e.notifyDataSetChanged();
    paramMessage = this.f;
    if (this.u != 2) {
      bool = false;
    }
    paramMessage.refreshGVideoTextView(bool, this.H);
  }
  
  private void a(String paramString)
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
        this.s = true;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("get troop members from server, troopUin: ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" troopCode: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("TroopMemberListInnerFrame", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberListHandlerName();
        localObject2 = (ITroopMemberListHandler)this.h.getBusinessHandler((String)localObject2);
        this.D = System.currentTimeMillis();
        ((ITroopMemberListHandler)localObject2).a(true, paramString, (String)localObject1, true, 7, this.D, ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getSCENE_TYPE_DEFAULT_Value());
      }
    }
  }
  
  private void a(String paramString, List<TroopMemberInfo> paramList)
  {
    if (paramList == null) {}
    try
    {
      localObject = this.h.getEntityManagerFactory().createEntityManager();
      paramList = ((EntityManager)localObject).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
      ((EntityManager)localObject).close();
      if (!QLog.isColorLevel()) {
        break label453;
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
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        Map localMap;
        TroopInfo localTroopInfo;
        String str;
        int i1;
        int i2;
        StringBuilder localStringBuilder;
        for (;;)
        {
          throw paramString;
        }
        continue;
        continue;
        int i = 1;
        continue;
        i = 0;
      }
    }
    if (QLog.isColorLevel())
    {
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
      break label456;
      localMap = Collections.synchronizedMap(new LinkedHashMap());
      localTroopInfo = CommonUtils.e(this.h, this.c);
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
        i2 = i1 / I;
        if (i1 % I != 0) {
          break label459;
        }
        i = 0;
        localObject = new AtomicInteger(i2 + i);
        if (!QLog.isColorLevel()) {
          break label464;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parallel process mJobCount: ");
        localStringBuilder.append(((AtomicInteger)localObject).get());
        QLog.d("TroopMemberListInnerFrame.thread", 2, localStringBuilder.toString());
        break label464;
        while (i < i1)
        {
          ThreadManager.post(new TroopMemberListInnerFrame.5(this, paramList, i, Math.min(I + i - 1, i1), paramString, str, localTroopInfo, localMap, (AtomicInteger)localObject), 8, null, false);
          i += I;
        }
      }
      paramString = this.C.obtainMessage(3);
      this.C.sendMessage(paramString);
      return;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.k;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0))
    {
      boolean bool = false;
      if ((paramString != null) && (!paramBoolean) && (this.l.isChecked()))
      {
        paramBoolean = bool;
      }
      else
      {
        int i1 = this.e.getCount();
        int i = 0;
        while (i < i1)
        {
          paramString = (TroopMemberInfo)this.e.getItem(i);
          if ((paramString != null) && (!this.f.isResultListContainFriend(paramString.memberuin)))
          {
            paramBoolean = bool;
            break label108;
          }
          i += 1;
        }
        paramBoolean = true;
      }
      label108:
      this.l.setChecked(paramBoolean);
    }
  }
  
  private void g()
  {
    this.d = ((PinnedDividerListView)findViewById(2131430527));
    this.G = ((IndexView)findViewById(2131435678));
    this.G.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.G.setOnIndexChangedListener(this);
    this.d.setSelector(2131168376);
    this.d.setOnLayoutListener(this);
    this.j = ((TextView)findViewById(2131448609));
    this.k = ((RelativeLayout)findViewById(2131445020));
    Object localObject1 = (LinearLayout)this.k.findViewById(2131437552);
    this.l = ((CheckBox)findViewById(2131430406));
    ((LinearLayout)localObject1).setOnClickListener(this);
    this.x = ((RelativeLayout)findViewById(2131448021));
    this.y = ((ProgressBar)findViewById(2131435131));
    this.z = ((TextView)findViewById(2131437663));
    if (this.f.mEntrance == 21)
    {
      localObject1 = (ViewGroup)this.f.getWindow().getDecorView();
      this.v = new TextView(this.f);
      Object localObject2 = new LinearLayout.LayoutParams(-2, (int)DisplayUtils.a(this.f, 17.0F));
      this.v.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      int i = (int)DisplayUtils.a(this.f, 4.0F);
      this.v.setPadding(i, 0, i, 0);
      this.v.setTextColor(getResources().getColor(2131168094));
      this.v.setTextSize(1, 12.0F);
      this.v.setText(HardCodeUtil.a(2131912805));
      localObject2 = TroopRankConfig.a().a(301, false, false, true);
      if (localObject2 != null) {
        TroopRankConfig.a(this.v, ((TroopRankConfig.TroopRankItem)localObject2).b);
      }
      this.v.setVisibility(4);
      ((ViewGroup)localObject1).addView(this.v);
      this.w = new TextView(this.f);
      localObject2 = new LinearLayout.LayoutParams(-2, (int)DisplayUtils.a(this.f, 17.0F));
      this.w.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.w.setPadding(i, 0, i, 0);
      this.w.setTextColor(getResources().getColor(2131168094));
      this.w.setTextSize(1, 12.0F);
      this.w.setText(HardCodeUtil.a(2131912848));
      localObject2 = TroopRankConfig.a().a(300, false, true, false);
      if (localObject2 != null) {
        TroopRankConfig.a(this.w, ((TroopRankConfig.TroopRankItem)localObject2).b);
      }
      this.w.setVisibility(4);
      ((ViewGroup)localObject1).addView(this.w);
      this.v.getViewTreeObserver().addOnGlobalLayoutListener(new TroopMemberListInnerFrame.2(this, (ViewGroup)localObject1));
      this.w.getViewTreeObserver().addOnGlobalLayoutListener(new TroopMemberListInnerFrame.3(this, (ViewGroup)localObject1));
    }
  }
  
  private void getTroopMembers()
  {
    Object localObject = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_update_time");
    localStringBuilder.append(this.h.getCurrentAccountUin());
    localObject = ((SelectMemberActivity)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_last_update_time");
    localStringBuilder.append(this.c);
    long l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopMembers, lastUpdateTime=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", curTime=");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(", diff=");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d("TroopMemberListInnerFrame", 2, ((StringBuilder)localObject).toString());
    }
    this.F = CommonUtils.d(this.h, this.c);
    if (this.f.mEntrance != 21)
    {
      localObject = this.F;
      if (localObject != null)
      {
        this.a = (((TroopInfo)localObject).wMemberNum - 1);
        if (this.a > 0)
        {
          this.A = 0.0D;
          localObject = this.C;
          ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(4));
        }
      }
    }
    if ((l1 != 0L) && ((l1 <= 0L) || (l3 <= 300000L)))
    {
      ThreadManager.executeOnNetWorkThread(new TroopMemberListInnerFrame.4(this));
      return;
    }
    a(this.c);
  }
  
  private Object[] h()
  {
    Object localObject1 = this.p.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      Collections.sort((List)this.p.get(localObject2), new TroopMemberListInnerFrame.MyComparator(this, null));
    }
    localObject1 = this.p;
    this.p = Collections.synchronizedMap(new LinkedHashMap());
    if ((this.f.mShowMyself) && (this.f.mIsPutMySelfFirst) && (this.n != null))
    {
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(this.n);
      this.p.put(HardCodeUtil.a(2131912851), localObject2);
    }
    for (char c1 = 'A'; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
      if (((Map)localObject1).get(String.valueOf(c1)) != null) {
        this.p.put(String.valueOf(c1), ((Map)localObject1).get(String.valueOf(c1)));
      }
    }
    if (((Map)localObject1).get("#") != null) {
      this.p.put("#", ((Map)localObject1).get("#"));
    }
    ((Map)localObject1).clear();
    localObject1 = new int[this.p.keySet().size()];
    Object localObject2 = new String[this.p.keySet().size()];
    Iterator localIterator = this.p.keySet().iterator();
    if (localObject1.length == 0) {
      return new Object[0];
    }
    localObject1[0] = 0;
    int i = 1;
    while (i < localObject1.length)
    {
      localObject1[i] += localObject1[(i - 1)] + ((List)this.p.get(localIterator.next())).size() + 1;
      i += 1;
    }
    localIterator = this.p.keySet().iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      localObject2[i] = ((String)localIterator.next());
      i += 1;
    }
    return new Object[] { this.p, localObject1, localObject2 };
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131629255);
    g();
    this.e = new TroopMemberListInnerFrame.TroopMemberListAdapter(this);
    this.d.setAdapter(this.e);
    this.d.setOnScrollListener(this.L);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.d.getFirstVisiblePosition() > 0) || ((this.d.getFirstVisiblePosition() == 0) && (this.d.getChildCount() < this.e.getCount() + this.d.getHeaderViewsCount()))) && (!this.f.isSoftInputShowing()) && (!((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.f)))
    {
      this.G.setVisibility(0);
      return;
    }
    this.G.setVisibility(4);
  }
  
  protected void a(Map<String, List<TroopMemberInfo>> paramMap, int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    this.p = paramMap;
    this.q = paramArrayOfInt;
    this.r = paramArrayOfString;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.s = false;
    this.f.mSelectedAndSearchBar.c();
    this.c = paramBundle.getString("group_uin");
    this.E = paramBundle.getString("group_name");
    this.u = paramBundle.getInt("param_member_show_type", 1);
    boolean bool = paramBundle.getBoolean("param_enable_all_select", false);
    paramBundle = this.k;
    int i;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    paramBundle.setVisibility(i);
    paramBundle = this.E;
    if ((paramBundle == null) || (paramBundle.length() == 0))
    {
      paramBundle = this.c;
      if ((paramBundle != null) && (paramBundle.length() > 0))
      {
        paramBundle = CommonUtils.d(this.h, this.c);
        if (paramBundle != null) {
          this.E = paramBundle.getTroopDisplayName();
        }
      }
    }
    if (this.f.mOnlyTroopMember) {
      this.f.setupTitleBar(false, "", this.E);
    } else {
      this.f.setupTitleBar(true, "", this.E);
    }
    this.f.addObserver(this.J);
    this.f.addObserver(this.K);
    this.x.setVisibility(8);
    paramBundle = this.c;
    if ((paramBundle != null) && (paramBundle.length() > 0)) {
      if (!this.c.equals(this.b))
      {
        this.p = Collections.synchronizedMap(new LinkedHashMap());
        this.q = new int[0];
        this.r = new String[0];
        this.e.notifyDataSetChanged();
        this.j.setVisibility(8);
        this.t = false;
        getTroopMembers();
        this.d.setSelection(0);
        this.b = this.c;
        if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.f))
        {
          ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).initTaskSet(this.h);
          ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).doReqGameFriends(this.h, this.c, this.f);
          paramBundle = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopOnlineMemberHandlerName();
          ((ITroopOnlineMemberHandler)this.h.getBusinessHandler(paramBundle)).b(this.c);
        }
      }
      else
      {
        this.t = true;
        this.e.notifyDataSetChanged();
      }
    }
  }
  
  public void c()
  {
    super.c();
    this.f.removeObserver(this.J);
    this.f.removeObserver(this.K);
  }
  
  public void d()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((TroopMemberListInnerFrame.TroopMemberListAdapter)localObject).d();
    }
    localObject = this.v;
    if ((localObject != null) && (((TextView)localObject).getTag() != null))
    {
      ((Bitmap)this.v.getTag()).recycle();
      this.v.setTag(null);
    }
    localObject = this.w;
    if ((localObject != null) && (((TextView)localObject).getTag() != null))
    {
      ((Bitmap)this.w.getTag()).recycle();
      this.w.setTag(null);
    }
    if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.f)) {
      ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).onDestroyForQQGameTroopManager(this.h);
    }
    super.d();
  }
  
  public void f()
  {
    this.e.notifyDataSetChanged();
    a(null, false);
  }
  
  public ContactSearchFragment getContactSearchFragment()
  {
    if (this.f.mEntrance != 21) {
      return ContactSearchFragment.a(-1, 8192, this.c, this.f.mUinsToHide, this.f);
    }
    return ContactSearchFragment.a(-1, 262144, this.c, this.f.mUinsToHide, this.f);
  }
  
  public String getGroupUin()
  {
    return this.c;
  }
  
  protected Map<String, List<TroopMemberInfo>> getIndexedFriends()
  {
    return this.p;
  }
  
  public CharDividedFacePreloadBaseAdapter getMemberListAdapter()
  {
    return this.e;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (2131430406 == paramCompoundButton.getId())
    {
      if (paramBoolean)
      {
        ArrayList localArrayList = new ArrayList();
        int i1 = this.e.getCount();
        int i = 0;
        while (i < i1)
        {
          TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)this.e.getItem(i);
          if (localTroopMemberInfo != null)
          {
            String str = ((ITroopMemberNameService)this.h.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(localTroopMemberInfo);
            SelectMemberActivity localSelectMemberActivity = this.f;
            localArrayList.add(SelectMemberActivity.constructAResultRecord(localTroopMemberInfo.memberuin, str, 1, this.c));
          }
          if (this.f.mEntrance == 31) {
            ReportController.b(this.h, "dc00898", "", "", "0X8007CFB", "0X8007CFB", 0, 0, "", "", "", "");
          }
          i += 1;
        }
        this.f.addFriendResults(localArrayList, false, true);
        if (this.f.mEntrance == 35) {
          ReportController.b(this.h, "CliOper", "", "", "0X8009E2C", "0X8009E2C", 0, 0, "", "", "", "");
        }
      }
      else
      {
        this.f.removeAllFriendResult();
        if (this.f.mEntrance == 35) {
          ReportController.b(this.h, "CliOper", "", "", "0X8009E2D", "0X8009E2D", 0, 0, "", "", "", "");
        }
      }
      this.e.notifyDataSetChanged();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    if (2131437552 != paramView.getId())
    {
      localObject1 = (TroopMemberListInnerFrame.ViewHolder)paramView.getTag();
      if ((localObject1 != null) && (((TroopMemberListInnerFrame.ViewHolder)localObject1).a != null) && (((TroopMemberListInnerFrame.ViewHolder)localObject1).i != null) && (((TroopMemberListInnerFrame.ViewHolder)localObject1).a.isEnabled()))
      {
        boolean bool = this.f.onListViewItemClick(((TroopMemberListInnerFrame.ViewHolder)localObject1).y, ((TroopMemberListInnerFrame.ViewHolder)localObject1).i.getText().toString(), 1, this.c);
        ((TroopMemberListInnerFrame.ViewHolder)localObject1).a.setChecked(bool);
        a(((TroopMemberListInnerFrame.ViewHolder)localObject1).y, bool);
        if (AppSetting.e)
        {
          if (((TroopMemberListInnerFrame.ViewHolder)localObject1).a.isChecked())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((TroopMemberListInnerFrame.ViewHolder)localObject1).i.getText().toString());
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131912879));
            paramView.setContentDescription(((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((TroopMemberListInnerFrame.ViewHolder)localObject1).i.getText().toString());
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131912864));
            paramView.setContentDescription(((StringBuilder)localObject2).toString());
          }
          int i;
          if (((TroopMemberListInnerFrame.ViewHolder)localObject1).a.isChecked()) {
            i = 2131912846;
          } else {
            i = 2131912831;
          }
          AccessibilityUtils.a(paramView, HardCodeUtil.a(i));
        }
      }
    }
    else if (((this.f.mEntrance == 32) || (this.f.mEntrance == 43)) && (!this.l.isChecked()) && (this.f.mMaxSelectNumber < this.e.b()))
    {
      localObject1 = new TroopMemberListInnerFrame.6(this);
      localObject2 = MessageFormat.format(this.f.getString(2131916219), new Object[] { Integer.valueOf(this.f.mMaxSelectNumber) });
      localObject1 = DialogUtil.a(this.f, 232, this.f.getResources().getString(2131917233), (String)localObject2, 2131887648, 2131896937, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject1);
    }
    try
    {
      ((Dialog)localObject1).show();
    }
    catch (Throwable localThrowable)
    {
      break label482;
    }
    Object localObject1 = this.l;
    ((CheckBox)localObject1).setChecked(true ^ ((CheckBox)localObject1).isChecked());
    localObject1 = this.l;
    onCheckedChanged((CompoundButton)localObject1, ((CheckBox)localObject1).isChecked());
    if (this.f.mEntrance == 32)
    {
      localObject2 = (IQWalletApi)QRoute.api(IQWalletApi.class);
      if (this.l.isChecked()) {
        localObject1 = "friendsfinder.all.confirm";
      } else {
        localObject1 = "friendsfinder.all.cancel";
      }
      ((IQWalletApi)localObject2).reportTenpay(0, (String)localObject1);
    }
    label482:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onIndexChanged(String paramString)
  {
    if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.f)) {
      return;
    }
    if ("$".equals(paramString))
    {
      this.d.setSelection(0);
      return;
    }
    int i = this.e.b(paramString);
    if (i != -1)
    {
      paramString = this.d;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame
 * JD-Core Version:    0.7.0.1
 */