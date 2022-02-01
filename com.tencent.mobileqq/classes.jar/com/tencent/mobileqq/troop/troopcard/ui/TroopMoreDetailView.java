package com.tencent.mobileqq.troop.troopcard.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.ReqBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.troop.activity.troopactivity.ActSSOReq;
import tencent.im.troop.activity.troopactivity.Activity;
import tencent.im.troop.activity.troopactivity.GroupInfoCardResp;

public class TroopMoreDetailView
  extends LinearLayout
  implements View.OnClickListener
{
  public static int l = 3;
  TroopInfo a;
  TroopInfoData b = new TroopInfoData();
  String c = "";
  boolean d;
  TroopMoreDetailView.GetTroopMemberDistributeObserver e;
  TroopMoreDetailView.GetTroopActivityObserver f;
  ArrayList<String> g = new ArrayList();
  DisplayMetrics h;
  View[] i;
  List<ImageView> j;
  ConcurrentLinkedQueue<TroopMoreDetailView.ShowTagTask> k = new ConcurrentLinkedQueue();
  AtomicInteger m = new AtomicInteger(0);
  
  public TroopMoreDetailView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public TroopMoreDetailView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public TroopMoreDetailView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  @RequiresApi(api=21)
  public TroopMoreDetailView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    d();
  }
  
  private String a(String paramString, long paramLong, int paramInt)
  {
    if (getActivity() == null) {
      return "";
    }
    Object localObject = getAppInterface();
    if (localObject == null) {
      return "";
    }
    String str2 = ((AppInterface)localObject).getCurrentAccountUin();
    boolean bool = this.b.bOwner;
    String str1 = "1";
    if (bool) {
      localObject = "0";
    } else if (this.b.bAdmin) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    localObject = paramString.replace("$GCODE$", this.b.troopUin).replace("$CLIENTVER$", "android8.8.17").replace("$UIN$", str2).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", (CharSequence)localObject);
    paramString = str1;
    if (this.d) {
      paramString = "2";
    }
    paramString = ((String)localObject).replace("$ENTERSOURCE$", paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b.troopName);
    ((StringBuilder)localObject).append("");
    return paramString.replace("$GNAME$", ((StringBuilder)localObject).toString()).replace("$GUIN$", this.b.troopUin).replace("$UNREADNUM$", String.valueOf(paramInt));
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    troopactivity.ActSSOReq localActSSOReq = new troopactivity.ActSSOReq();
    localActSSOReq.cmd.set(1);
    localActSSOReq.group_code.set(Long.parseLong(paramString));
    paramString = new NewIntent(paramAppInterface.getApp(), ProtoServlet.class);
    paramString.putExtra("cmd", "qqact.actvitylist");
    paramString.putExtra("data", localActSSOReq.toByteArray());
    paramString.setObserver(paramBusinessObserver);
    paramAppInterface.startServlet(paramString);
  }
  
  private void a(troopactivity.GroupInfoCardResp paramGroupInfoCardResp)
  {
    if (paramGroupInfoCardResp == null) {
      return;
    }
    int n = paramGroupInfoCardResp.activitys.size();
    Object localObject1 = paramGroupInfoCardResp.group_act_url.get();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.c = a((String)localObject1, 0L, 0);
    }
    localObject1 = this.i[3];
    if (localObject1 == null) {
      return;
    }
    View localView = ((View)localObject1).findViewById(2131447876);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131427607);
    if (n > 0)
    {
      Object localObject2 = (troopactivity.Activity)paramGroupInfoCardResp.activitys.get(0);
      String str = ((troopactivity.Activity)localObject2).str_name.get();
      localObject2 = ((troopactivity.Activity)localObject2).str_start_time.get();
      paramGroupInfoCardResp.being_act_num.get();
      a(3, 0, localView, getContext().getString(2131894072), getContext().getString(2131894992), true);
      paramGroupInfoCardResp = new StringBuilder();
      paramGroupInfoCardResp.append(str);
      paramGroupInfoCardResp.append("\n");
      paramGroupInfoCardResp.append((String)localObject2);
      localTextView.setText(paramGroupInfoCardResp.toString());
      localTextView.setVisibility(0);
      ((View)localObject1).setVisibility(0);
      return;
    }
    if (paramGroupInfoCardResp.history_act_num.get() > 0)
    {
      n = paramGroupInfoCardResp.history_act_num.get();
      paramGroupInfoCardResp = String.format(getContext().getString(2131894991), new Object[] { Integer.valueOf(n) });
      a(3, 0, localView, getContext().getString(2131894072), paramGroupInfoCardResp, true);
      ((View)localObject1).setVisibility(0);
      localTextView.setVisibility(8);
      return;
    }
    ((View)localObject1).setVisibility(8);
    localTextView.setVisibility(8);
  }
  
  private void b(AppInterface paramAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      troop_member_distribute.ReqBody localReqBody = new troop_member_distribute.ReqBody();
      localReqBody.uint64_group_code.set(Long.parseLong(paramString));
      paramString = new NewIntent(paramAppInterface.getApp(), ProtoServlet.class);
      paramString.putExtra("cmd", "group_member_statistic.get_group_member_statistic");
      paramString.putExtra("data", localReqBody.toByteArray());
      paramString.setObserver(paramBusinessObserver);
      paramAppInterface.startServlet(paramString);
      return;
    }
    catch (NumberFormatException paramAppInterface) {}
  }
  
  private void d()
  {
    setOrientation(1);
  }
  
  private void e()
  {
    if (!NetworkUtil.isNetworkAvailable(getContext())) {
      return;
    }
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface == null) {
      return;
    }
    this.e = new TroopMoreDetailView.GetTroopMemberDistributeObserver(this);
    b(localAppInterface, this.b.troopUin, this.e);
    if (this.d)
    {
      this.f = new TroopMoreDetailView.GetTroopActivityObserver(this);
      a(localAppInterface, this.b.troopUin, this.f);
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMoreDetailView", 2, String.format("runNextShowTagTask %s / %s", new Object[] { Integer.valueOf(this.m.get()), Integer.valueOf(this.k.size()) }));
    }
    if (this.m.get() < l)
    {
      TroopMoreDetailView.ShowTagTask localShowTagTask = (TroopMoreDetailView.ShowTagTask)this.k.poll();
      if (localShowTagTask != null)
      {
        this.m.incrementAndGet();
        ThreadManager.post(localShowTagTask, 8, null, true);
      }
    }
  }
  
  private Activity getActivity()
  {
    Context localContext = getContext();
    if ((localContext instanceof Activity)) {
      return (Activity)localContext;
    }
    return null;
  }
  
  private AppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a()
  {
    Object localObject1 = getActivity();
    if (localObject1 == null) {
      return;
    }
    this.h = new DisplayMetrics();
    ((Activity)localObject1).getWindowManager().getDefaultDisplay().getMetrics(this.h);
    int n;
    if ((this.b.dwGroupFlagExt & 0x800) != 0L) {
      n = 1;
    } else {
      n = 0;
    }
    removeAllViews();
    int i2 = 8;
    this.i = new View[8];
    localObject1 = View.inflate(getContext(), 2131627905, null);
    if (n != 0) {
      i1 = 1;
    } else {
      i1 = 3;
    }
    a(0, i1, (View)localObject1, getContext().getString(2131917409), null, true, 1);
    this.i[0] = localObject1;
    addView((View)localObject1);
    b();
    localObject1 = View.inflate(getContext(), 2131626756, null);
    a(3, 3, (View)localObject1, HardCodeUtil.a(2131912923), "", true);
    this.i[3] = localObject1;
    new LinearLayout.LayoutParams(-1, -2).setMargins(0, ViewUtils.dip2px(10.0F), 0, 0);
    addView((View)localObject1);
    ((View)localObject1).setVisibility(8);
    localObject1 = View.inflate(getContext(), 2131627926, null);
    addView((View)localObject1);
    ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298801);
    localObject1 = View.inflate(getContext(), 2131627920, null);
    this.i[4] = localObject1;
    addView((View)localObject1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.b.wMemberNum);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131912920));
    localObject2 = ((StringBuilder)localObject2).toString();
    a(4, 3, (View)localObject1, HardCodeUtil.a(2131912922), (String)localObject2, true);
    localObject1 = View.inflate(getContext(), 2131625929, null);
    this.i[5] = localObject1;
    ((View)localObject1).setBackgroundResource(2130839629);
    ((View)localObject1).setFocusable(true);
    ((View)localObject1).setTag(Integer.valueOf(5));
    ((View)localObject1).setOnClickListener(this);
    ((View)localObject1).setVisibility(8);
    addView((View)localObject1);
    localObject1 = this.b;
    if ((localObject1 != null) && (((TroopInfoData)localObject1).troopUin != null))
    {
      boolean bool1 = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).isGrayTroopForTroopGameCard(this.b.troopUin);
      boolean bool2 = this.b.checkFlagExt4(4096);
      boolean bool3 = ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
      boolean bool4 = this.b.isHomeworkTroop();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initView(), troopGameCardConfigEnabled = ");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append(", troopGameCardEnabled = ");
        ((StringBuilder)localObject1).append(bool2);
        ((StringBuilder)localObject1).append(", isStudyMode = ");
        ((StringBuilder)localObject1).append(bool3);
        ((StringBuilder)localObject1).append(", isHwTroop = ");
        ((StringBuilder)localObject1).append(bool4);
        QLog.d("TroopMoreDetailView", 2, ((StringBuilder)localObject1).toString());
      }
      if ((bool1) && (bool2) && (!bool4) && (!bool3))
      {
        localObject1 = new TroopGameCardView(getContext(), this.b.troopUin);
        this.i[7] = localObject1;
        addView((View)localObject1);
      }
    }
    localObject1 = View.inflate(getContext(), 2131627926, null);
    addView((View)localObject1);
    ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298801);
    localObject1 = View.inflate(getContext(), 2131627928, null);
    localObject2 = this.i;
    localObject2[6] = localObject1;
    localObject2[6].setBackgroundResource(2130839629);
    ((View)localObject1).setTag(Integer.valueOf(6));
    ((View)localObject1).setOnClickListener(this);
    a((View)localObject1);
    addView((View)localObject1);
    ((TextView)((View)localObject1).findViewById(2131438053)).setText(HardCodeUtil.a(2131912928));
    TroopReportor.a("grpProfile", "grpProfile_exp", "admin_exp", 0, 0, new String[] { this.b.troopUin });
    localObject1 = ((View)localObject1).findViewById(2131437197);
    if ((this.d) && (n != 0)) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = View.inflate(getContext(), 2131627906, null);
    a(1, 2, (View)localObject1, HardCodeUtil.a(2131912927), this.b.troopAuthenticateInfo, true);
    this.i[1] = localObject1;
    addView((View)localObject1);
    int i1 = i2;
    if (n != 0) {
      i1 = 0;
    }
    ((View)localObject1).setVisibility(i1);
    if (n != 0) {
      TroopReportor.a("grpProfile", "grpProfile_exp", "certification_exp", 0, 0, new String[] { this.b.troopUin });
    }
    e();
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
    }
    else
    {
      paramView.setTag(null);
      paramView.setOnClickListener(null);
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 == 3) {
            paramView.setBackgroundResource(2130839629);
          }
        }
        else {
          paramView.setBackgroundResource(2130839632);
        }
      }
      else {
        paramView.setBackgroundResource(2130839638);
      }
    }
    else {
      paramView.setBackgroundResource(2130839622);
    }
    TextView localTextView1 = (TextView)paramView.findViewById(2131447463);
    TextView localTextView2 = (TextView)paramView.findViewById(2131435692);
    View localView = paramView.findViewById(2131428774);
    paramView = paramString1;
    if (paramString1 == null) {
      paramView = "";
    }
    localTextView1.setText(paramView);
    localTextView2.setText(paramString2);
    if (paramBoolean) {
      paramInt1 = 0;
    } else {
      paramInt1 = 8;
    }
    localView.setVisibility(paramInt1);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, String[] paramArrayOfString, boolean paramBoolean, int paramInt3)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131447463);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    localTextView.setText(paramArrayOfString);
    paramString = paramView.findViewById(2131428774);
    if (paramBoolean) {
      paramInt3 = 0;
    } else {
      paramInt3 = 8;
    }
    paramString.setVisibility(paramInt3);
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
    }
    else
    {
      paramView.setTag(null);
      paramView.setOnClickListener(null);
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 != 3) {
            return;
          }
          paramView.setBackgroundResource(2130839629);
          return;
        }
        paramView.setBackgroundResource(2130839632);
        return;
      }
      paramView.setBackgroundResource(2130839638);
      return;
    }
    paramView.setBackgroundResource(2130839622);
  }
  
  protected void a(int paramInt1, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateClrTextItemView(), tag = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", info = ");
      ((StringBuilder)localObject1).append(paramArrayList);
      ((StringBuilder)localObject1).append(", bShowArrow = ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      QLog.i("TroopMoreDetailView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.i;
    if (localObject1 == null) {
      return;
    }
    if ((paramInt1 >= 0) && (paramInt1 < localObject1.length)) {
      localObject1 = localObject1[paramInt1];
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      if ((paramArrayList != null) && (paramArrayList.size() != 0))
      {
        ((View)localObject1).setVisibility(0);
        int n = Utils.a(5.0F, getResources());
        int i1 = Utils.a(2.0F, getResources());
        int i4 = Utils.a(77.0F, getResources());
        int i3 = Utils.a(11.0F, getResources());
        int i10 = Utils.a(12.0F, getResources());
        Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131430860);
        LinearLayout localLinearLayout = (LinearLayout)((View)localObject1).findViewById(2131430861);
        if (this.d)
        {
          ((LinearLayout)localObject2).setVisibility(8);
          localLinearLayout.setVisibility(0);
          localLinearLayout.removeAllViews();
        }
        else
        {
          ((LinearLayout)localObject2).setVisibility(0);
          localLinearLayout.setVisibility(8);
          ((LinearLayout)localObject2).setPadding(((LinearLayout)localObject2).getPaddingLeft(), i1, ((LinearLayout)localObject2).getPaddingRight(), ((LinearLayout)localObject2).getPaddingBottom());
          ((LinearLayout)localObject2).removeAllViews();
        }
        if (paramArrayList == null) {
          return;
        }
        int i6 = getResources().getDisplayMetrics().widthPixels - localLinearLayout.getLeft();
        int i5 = 0;
        for (;;)
        {
          int i2 = paramInt2;
          if ((i5 >= paramArrayList.size()) || ((i5 >= l) && ((!this.d) || (i6 <= 0)))) {
            break;
          }
          if (TextUtils.isEmpty((CharSequence)paramArrayList.get(i5)))
          {
            i2 = i6;
          }
          else
          {
            TextView localTextView = new TextView(getContext());
            localTextView.setId(2131441564);
            if (i2 == 1) {
              i2 = 2130844939;
            } else if ((i2 != 2) && (i2 == 3)) {
              i2 = 2130844938;
            } else {
              i2 = 2130844937;
            }
            Object localObject3 = getResources().getDrawable(i2);
            ITroopCardApi localITroopCardApi = (ITroopCardApi)QRoute.api(ITroopCardApi.class);
            i2 = i1;
            localITroopCardApi.setNightModeFilterForDrawable(getAppInterface(), (Drawable)localObject3);
            localTextView.setBackgroundDrawable((Drawable)localObject3);
            localTextView.setTextSize(1, 12.0F);
            if (paramBoolean2) {
              localTextView.setMaxWidth(i4);
            }
            localTextView.setSingleLine();
            localObject3 = getResources();
            int i7;
            if (this.d) {
              i7 = 2131167993;
            } else {
              i7 = 2131168212;
            }
            localTextView.setTextColor(((Resources)localObject3).getColor(i7));
            if (this.d) {
              i7 = i3;
            } else {
              i7 = n;
            }
            int i8;
            if (this.d) {
              i8 = n;
            } else {
              i8 = i2;
            }
            int i9;
            if (this.d) {
              i9 = i3;
            } else {
              i9 = n;
            }
            if (this.d) {
              i2 = n;
            }
            localTextView.setPadding(i7, i8, i9, i2);
            localTextView.setGravity(17);
            localTextView.setText((CharSequence)paramArrayList.get(i5));
            localTextView.setEllipsize(TextUtils.TruncateAt.END);
            localObject3 = new LinearLayout.LayoutParams(-2, -2);
            if (this.d)
            {
              ((LinearLayout.LayoutParams)localObject3).rightMargin = i10;
              localTextView.measure(0, 0);
              if (i6 >= localTextView.getMeasuredWidth() + i10)
              {
                localLinearLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject3);
                i2 = i6 - (localTextView.getMeasuredWidth() + i10);
              }
              else
              {
                i2 = 0;
              }
            }
            else
            {
              ((LinearLayout.LayoutParams)localObject3).leftMargin = n;
              ((LinearLayout)localObject2).addView(localTextView, (ViewGroup.LayoutParams)localObject3);
              i2 = i6;
            }
          }
          i5 += 1;
          i6 = i2;
        }
        paramArrayList = ((View)localObject1).findViewById(2131428774);
        if (paramBoolean1)
        {
          if (this.d)
          {
            localObject2 = (RelativeLayout.LayoutParams)paramArrayList.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131447463);
            paramArrayList.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          ((View)localObject1).setTag(Integer.valueOf(paramInt1));
          ((View)localObject1).setOnClickListener(this);
          paramArrayList.setVisibility(0);
          return;
        }
        ((View)localObject1).setTag(null);
        ((View)localObject1).setOnClickListener(null);
        paramArrayList.setVisibility(8);
        return;
      }
      ((View)localObject1).setVisibility(8);
    }
  }
  
  protected void a(View paramView)
  {
    int[] arrayOfInt = new int[6];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 2131448043;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131448044;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131448045;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131448046;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131448047;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131448048;
    tmp38_32;
    this.j = new ArrayList(6);
    int i1 = Math.min(arrayOfInt.length, 6);
    int n = 0;
    while (n < i1)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(arrayOfInt[n]);
      this.j.add(localImageView);
      n += 1;
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = this.i;
    if (localObject[4] != null)
    {
      localObject = (TextView)localObject[4].findViewById(2131435692);
      if (localObject != null) {
        ((TextView)localObject).setText(paramString);
      }
    }
  }
  
  public void a(List<oidb_0x899.memberlist> paramList)
  {
    if (paramList == null) {
      return;
    }
    int i1 = paramList.size();
    this.g.clear();
    int n = 0;
    while (n < i1)
    {
      oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)paramList.get(n);
      if ((localmemberlist != null) && (localmemberlist.uint64_member_uin.has()))
      {
        long l1 = localmemberlist.uint64_member_uin.get();
        this.g.add(String.valueOf(l1));
      }
      n += 1;
    }
    ThreadManager.getUIHandler().post(new TroopMoreDetailView.UpdateTroopMembersFaceTask(this));
  }
  
  public void b()
  {
    this.k.offer(new TroopMoreDetailView.ShowTagTask(this, this));
    f();
  }
  
  protected void c()
  {
    if (((ITroopCardApi)QRoute.api(ITroopCardApi.class)).isFastDoubleClick()) {
      return;
    }
    Activity localActivity = getActivity();
    if (localActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", this.b.troopUin);
    localIntent.putExtra("param_from", 0);
    localIntent.putExtra("TROOP_INFO_MEMBER_NUM", this.b.wMemberNum);
    RouteUtils.a(localActivity, localIntent, "/troop/memberlist/TroopMemberList", 100);
  }
  
  public void onClick(View paramView)
  {
    if (!((ITroopCardApi)QRoute.api(ITroopCardApi.class)).isFastDoubleClick())
    {
      Object localObject1 = getActivity();
      if (localObject1 != null)
      {
        Object localObject2 = paramView.getTag();
        if ((localObject2 instanceof Integer))
        {
          int n = ((Integer)localObject2).intValue();
          if (n != 0)
          {
            if (n != 1)
            {
              if (n != 3)
              {
                if ((n != 4) && (n != 5))
                {
                  if (n == 6)
                  {
                    if (this.d) {
                      TroopReportor.a("grpProfile", "grpProfile_clk", "admin_click", 0, 0, new String[] { this.b.troopUin });
                    }
                    if (!this.g.isEmpty())
                    {
                      localObject2 = new Intent((Context)localObject1, ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopAdminListClass());
                      ((Intent)localObject2).putExtra("uin", this.b.troopowneruin);
                      ((Intent)localObject2).putExtra("troop_uin", this.b.troopUin);
                      ((Intent)localObject2).putExtra("troop_code", this.b.troopCode);
                      ((Intent)localObject2).putStringArrayListExtra("troop_info_memo", this.g);
                      if (((Activity)localObject1).getIntent() != null) {
                        ((Intent)localObject2).putExtra("t_s_f", ((Activity)localObject1).getIntent().getIntExtra("t_s_f", -1));
                      }
                      ((Activity)localObject1).startActivity((Intent)localObject2);
                      if (QLog.isColorLevel()) {
                        QLog.i("addFriendTag", 2, String.format("DATA_TAG_TROOP_ADMIN_LIST, [uin:%s, code:%s]", new Object[] { this.b.troopUin, this.b.troopCode }));
                      }
                      if (((ITroopSettingApi)QRoute.api(ITroopSettingApi.class)).isInstanceOfTroopSettingActivity((Activity)localObject1))
                      {
                        if (!this.b.hasSetNewTroopHead) {
                          n = 1;
                        } else {
                          n = 2;
                        }
                        localObject1 = new StringBuilder();
                        ((StringBuilder)localObject1).append(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSourceReportVal());
                        ((StringBuilder)localObject1).append("");
                        ReportController.b(null, "dc00898", "", "", "0X800A52A", "0X800A52A", n, 0, ((StringBuilder)localObject1).toString(), "", "", "");
                      }
                    }
                  }
                }
                else
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=");
                  ((StringBuilder)localObject2).append(this.b.troopUin);
                  localObject2 = ((StringBuilder)localObject2).toString();
                  ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(getContext(), "/pubaccount/browser");
                  localActivityURIRequest.extra().putString("url", (String)localObject2);
                  QRoute.startUri(localActivityURIRequest, null);
                  if (this.d) {
                    TroopReportor.a("grpProfile", "grpProfile_clk", "grpMember_click", 0, 0, new String[] { this.b.troopUin });
                  } else {
                    TroopReportor.a("Grp_set_new", "moreData", "clk_mberIntro", 0, 0, new String[] { this.b.troopUin, TroopReportor.a(this.b) });
                  }
                  if (((ITroopSettingApi)QRoute.api(ITroopSettingApi.class)).isInstanceOfTroopSettingActivity((Activity)localObject1))
                  {
                    if (!this.b.hasSetNewTroopHead) {
                      n = 1;
                    } else {
                      n = 2;
                    }
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSourceReportVal());
                    ((StringBuilder)localObject1).append("");
                    ReportController.b(null, "dc00898", "", "", "0X800A529", "0X800A529", n, 0, ((StringBuilder)localObject1).toString(), "", "", "");
                  }
                }
              }
              else if (!TextUtils.isEmpty(this.c))
              {
                localObject1 = new ActivityURIRequest((Context)localObject1, "/base/browser");
                ((ActivityURIRequest)localObject1).extra().putLong("startOpenPageTime", System.currentTimeMillis());
                ((ActivityURIRequest)localObject1).extra().putString("url", this.c);
                QRoute.startUri((URIRequest)localObject1, null);
              }
            }
            else
            {
              localObject2 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.b.troopUin });
              localObject1 = new ActivityURIRequest((Context)localObject1, "/base/browser");
              ((ActivityURIRequest)localObject1).extra().putLong("startOpenPageTime", System.currentTimeMillis());
              ((ActivityURIRequest)localObject1).extra().putString("url", (String)localObject2);
              QRoute.startUri((URIRequest)localObject1, null);
              if (this.d) {
                TroopReportor.a("grpProfile", "grpProfile_clk", "certification_click", 0, 0, new String[] { this.b.troopUin });
              } else {
                TroopReportor.a("Grp_set_new", "moreData", "clk_certifiedInfo", 0, 0, new String[] { this.b.troopUin, TroopReportor.a(this.b) });
              }
            }
          }
          else
          {
            ThreadManager.post(new TroopMoreDetailView.JumpTagDetailTask(this), 8, null, true);
            if (this.d) {
              TroopReportor.a("grpProfile", "grpProfile_clk", "grpTag_click", 0, 0, new String[] { this.b.troopUin });
            } else {
              TroopReportor.a("Grp_set_new", "moreData", "clk_tag", 0, 0, new String[] { this.b.troopUin, TroopReportor.a(this.b) });
            }
            if (((ITroopSettingApi)QRoute.api(ITroopSettingApi.class)).isInstanceOfTroopSettingActivity((Activity)localObject1))
            {
              if (!this.b.hasSetNewTroopHead) {
                n = 1;
              } else {
                n = 2;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSourceReportVal());
              ((StringBuilder)localObject1).append("");
              ReportController.b(null, "dc00898", "", "", "0X800A528", "0X800A528", n, 0, ((StringBuilder)localObject1).toString(), "", "", "");
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setGuestVisitor(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setTroopInfo(TroopInfo paramTroopInfo)
  {
    this.a = paramTroopInfo;
    paramTroopInfo = getAppInterface();
    if (paramTroopInfo == null) {
      return;
    }
    this.b.updateForTroopInfo(this.a, paramTroopInfo.getCurrentAccountUin());
  }
  
  public void setTroopInfoData(TroopInfoData paramTroopInfoData)
  {
    this.b = paramTroopInfoData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopMoreDetailView
 * JD-Core Version:    0.7.0.1
 */