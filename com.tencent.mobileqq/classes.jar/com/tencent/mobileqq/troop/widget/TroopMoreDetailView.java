package com.tencent.mobileqq.troop.widget;

import agej;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import android.widget.TextView;
import anzj;
import bdll;
import bguq;
import bgxs;
import bgxt;
import bhju;
import bhnv;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import nkl;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.ReqBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.troop.activity.troopactivity.ActSSOReq;
import tencent.im.troop.activity.troopactivity.Activity;
import tencent.im.troop.activity.troopactivity.GroupInfoCardResp;
import zps;

public class TroopMoreDetailView
  extends LinearLayout
  implements View.OnClickListener
{
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  bgxs jdField_a_of_type_Bgxs;
  bgxt jdField_a_of_type_Bgxt;
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  String jdField_a_of_type_JavaLangString = "";
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  List<ImageView> jdField_a_of_type_JavaUtilList;
  ConcurrentLinkedQueue<TroopMoreDetailView.ShowTagTask> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  boolean jdField_a_of_type_Boolean;
  public View[] a;
  
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
  
  private Activity a()
  {
    Context localContext = getContext();
    if ((localContext instanceof Activity)) {
      return (Activity)localContext;
    }
    return null;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private String a(String paramString, long paramLong, int paramInt)
  {
    if (a() == null) {
      return "";
    }
    Object localObject = a();
    if (localObject == null) {
      return "";
    }
    String str = ((QQAppInterface)localObject).getCurrentAccountUin();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
    {
      localObject = "0";
      localObject = paramString.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).replace("$CLIENTVER$", "android8.4.5").replace("$UIN$", str).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", (CharSequence)localObject);
      if (!this.jdField_a_of_type_Boolean) {
        break label192;
      }
    }
    label192:
    for (paramString = "2";; paramString = "1")
    {
      return ((String)localObject).replace("$ENTERSOURCE$", paramString).replace("$GNAME$", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName + "").replace("$GUIN$", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).replace("$UNREADNUM$", String.valueOf(paramInt));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin)
      {
        localObject = "1";
        break;
      }
      localObject = "2";
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    troopactivity.ActSSOReq localActSSOReq = new troopactivity.ActSSOReq();
    localActSSOReq.cmd.set(1);
    localActSSOReq.group_code.set(Long.parseLong(paramString));
    paramString = new NewIntent(paramQQAppInterface.getApp(), nkl.class);
    paramString.putExtra("cmd", "qqact.actvitylist");
    paramString.putExtra("data", localActSSOReq.toByteArray());
    paramString.setObserver(paramBusinessObserver);
    paramQQAppInterface.startServlet(paramString);
  }
  
  private void a(troopactivity.GroupInfoCardResp paramGroupInfoCardResp)
  {
    if (paramGroupInfoCardResp == null) {}
    int i;
    Object localObject1;
    do
    {
      return;
      i = paramGroupInfoCardResp.activitys.size();
      localObject1 = paramGroupInfoCardResp.group_act_url.get();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.jdField_a_of_type_JavaLangString = a((String)localObject1, 0L, 0);
      }
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[3];
    } while (localObject1 == null);
    View localView = ((View)localObject1).findViewById(2131379323);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131362009);
    if (i > 0)
    {
      Object localObject2 = (troopactivity.Activity)paramGroupInfoCardResp.activitys.get(0);
      String str = ((troopactivity.Activity)localObject2).str_name.get();
      localObject2 = ((troopactivity.Activity)localObject2).str_start_time.get();
      paramGroupInfoCardResp.being_act_num.get();
      a(3, 0, localView, getContext().getString(2131695647), getContext().getString(2131696539), true);
      localTextView.setText(str + "\n" + (String)localObject2);
      localTextView.setVisibility(0);
      ((View)localObject1).setVisibility(0);
      return;
    }
    if (paramGroupInfoCardResp.history_act_num.get() > 0)
    {
      i = paramGroupInfoCardResp.history_act_num.get();
      paramGroupInfoCardResp = String.format(getContext().getString(2131696538), new Object[] { Integer.valueOf(i) });
      a(3, 0, localView, getContext().getString(2131695647), paramGroupInfoCardResp, true);
      ((View)localObject1).setVisibility(0);
      localTextView.setVisibility(8);
      return;
    }
    ((View)localObject1).setVisibility(8);
    localTextView.setVisibility(8);
  }
  
  private void b(QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      troop_member_distribute.ReqBody localReqBody = new troop_member_distribute.ReqBody();
      localReqBody.uint64_group_code.set(Long.parseLong(paramString));
      paramString = new NewIntent(paramQQAppInterface.getApp(), nkl.class);
      paramString.putExtra("cmd", "group_member_statistic.get_group_member_statistic");
      paramString.putExtra("data", localReqBody.toByteArray());
      paramString.setObserver(paramBusinessObserver);
      paramQQAppInterface.startServlet(paramString);
      return;
    }
    catch (NumberFormatException paramQQAppInterface) {}
  }
  
  private void d()
  {
    setOrientation(1);
  }
  
  private void e()
  {
    if (!bhnv.g(getContext())) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        localQQAppInterface = a();
      } while (localQQAppInterface == null);
      this.jdField_a_of_type_Bgxt = new bgxt(this);
      b(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_Bgxt);
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Bgxs = new bgxs(this);
    a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_Bgxs);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMoreDetailView", 2, String.format("runNextShowTagTask %s / %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()), Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size()) }));
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 3)
    {
      TroopMoreDetailView.ShowTagTask localShowTagTask = (TroopMoreDetailView.ShowTagTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localShowTagTask != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        ThreadManager.post(localShowTagTask, 8, null, true);
      }
    }
  }
  
  public void a()
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    ((Activity)localObject).getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
    {
      i = 1;
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[7];
      localObject = View.inflate(getContext(), 2131561642, null);
      if (i == 0) {
        break label488;
      }
      j = 1;
      label82:
      a(0, j, (View)localObject, getContext().getString(2131718855), null, true, 1);
      this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject;
      addView((View)localObject);
      b();
      localObject = View.inflate(getContext(), 2131561643, null);
      a(1, 2, (View)localObject, anzj.a(2131714454), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, true);
      this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject;
      addView((View)localObject);
      if (i == 0) {
        break label493;
      }
    }
    label488:
    label493:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      localObject = View.inflate(getContext(), 2131560683, null);
      a(3, 3, (View)localObject, anzj.a(2131714450), "", true);
      this.jdField_a_of_type_ArrayOfAndroidViewView[3] = localObject;
      new LinearLayout.LayoutParams(-1, -2).setMargins(0, zps.a(getContext(), 10.0F), 0, 0);
      addView((View)localObject);
      ((View)localObject).setVisibility(8);
      addView(View.inflate(getContext(), 2131561658, null));
      localObject = View.inflate(getContext(), 2131561652, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject;
      addView((View)localObject);
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + anzj.a(2131714447);
      a(4, 3, (View)localObject, anzj.a(2131714449), str, true);
      localObject = View.inflate(getContext(), 2131559893, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject;
      ((View)localObject).setBackgroundResource(2130839447);
      ((View)localObject).setFocusable(true);
      ((View)localObject).setTag(Integer.valueOf(5));
      ((View)localObject).setOnClickListener(this);
      ((View)localObject).setVisibility(8);
      addView((View)localObject);
      addView(View.inflate(getContext(), 2131561658, null));
      localObject = View.inflate(getContext(), 2131561659, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject;
      this.jdField_a_of_type_ArrayOfAndroidViewView[6].setBackgroundResource(2130839447);
      ((View)localObject).setTag(Integer.valueOf(6));
      ((View)localObject).setOnClickListener(this);
      a((View)localObject);
      addView((View)localObject);
      ((TextView)((View)localObject).findViewById(2131370694)).setText(anzj.a(2131714455));
      e();
      return;
      i = 0;
      break;
      j = 3;
      break label82;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    label48:
    View localView;
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
      switch (paramInt2)
      {
      default: 
        TextView localTextView1 = (TextView)paramView.findViewById(2131378936);
        TextView localTextView2 = (TextView)paramView.findViewById(2131368636);
        localView = paramView.findViewById(2131362954);
        paramView = paramString1;
        if (paramString1 == null) {
          paramView = "";
        }
        localTextView1.setText(paramView);
        localTextView2.setText(paramString2);
        if (!paramBoolean) {
          break;
        }
      }
    }
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      localView.setVisibility(paramInt1);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130839440);
      break label48;
      paramView.setBackgroundResource(2130839456);
      break label48;
      paramView.setBackgroundResource(2130839450);
      break label48;
      paramView.setBackgroundResource(2130839447);
      break label48;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, String[] paramArrayOfString, boolean paramBoolean, int paramInt3)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131378936);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    localTextView.setText(paramArrayOfString);
    paramString = paramView.findViewById(2131362954);
    if (paramBoolean)
    {
      paramInt3 = 0;
      label49:
      paramString.setVisibility(paramInt3);
      if (!paramBoolean) {
        break label112;
      }
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
    }
    for (;;)
    {
      switch (paramInt2)
      {
      default: 
        return;
        paramInt3 = 8;
        break label49;
        label112:
        paramView.setTag(null);
        paramView.setOnClickListener(null);
      }
    }
    paramView.setBackgroundResource(2130839440);
    return;
    paramView.setBackgroundResource(2130839456);
    return;
    paramView.setBackgroundResource(2130839450);
    return;
    paramView.setBackgroundResource(2130839447);
  }
  
  protected void a(int paramInt1, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMoreDetailView", 2, "updateClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayList + ", bShowArrow = " + paramBoolean1);
    }
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
    for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1];; localView = null)
    {
      if (localView != null)
      {
        if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
          break label98;
        }
        localView.setVisibility(8);
      }
      label98:
      int k;
      int m;
      int n;
      LinearLayout localLinearLayout;
      do
      {
        return;
        localView.setVisibility(0);
        k = agej.a(5.0F, getResources());
        m = agej.a(2.0F, getResources());
        n = agej.a(77.0F, getResources());
        localLinearLayout = (LinearLayout)localView.findViewById(2131364633);
        localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), m, localLinearLayout.getPaddingRight(), localLinearLayout.getPaddingBottom());
        localLinearLayout.removeAllViews();
      } while (paramArrayList == null);
      int j = 0;
      while ((j < paramArrayList.size()) && (j < 3)) {
        if (TextUtils.isEmpty((CharSequence)paramArrayList.get(j)))
        {
          j += 1;
        }
        else
        {
          TextView localTextView = new TextView(getContext());
          localTextView.setId(2131373880);
          int i = 2130843807;
          if (paramInt2 == 1) {
            i = 2130843808;
          }
          for (;;)
          {
            Object localObject = getResources().getDrawable(i);
            ProfileActivity.a(a(), (Drawable)localObject);
            localTextView.setBackgroundDrawable((Drawable)localObject);
            localTextView.setTextSize(1, 12.0F);
            if (paramBoolean2) {
              localTextView.setMaxWidth(n);
            }
            localTextView.setSingleLine();
            localTextView.setTextColor(getResources().getColor(2131167153));
            localTextView.setPadding(k, m, k, m);
            localTextView.setGravity(17);
            localTextView.setText((CharSequence)paramArrayList.get(j));
            localTextView.setEllipsize(TextUtils.TruncateAt.END);
            localObject = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject).leftMargin = k;
            localLinearLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
            break;
            if (paramInt2 == 2) {
              i = 2130843807;
            }
          }
        }
      }
      paramArrayList = localView.findViewById(2131362954);
      if (paramBoolean1)
      {
        localView.setTag(Integer.valueOf(paramInt1));
        localView.setOnClickListener(this);
        paramArrayList.setVisibility(0);
        return;
      }
      localView.setTag(null);
      localView.setOnClickListener(null);
      paramArrayList.setVisibility(8);
      return;
    }
  }
  
  protected void a(View paramView)
  {
    int[] arrayOfInt = new int[6];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 2131379480;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131379481;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131379482;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131379483;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131379484;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131379485;
    tmp38_32;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(6);
    int j = Math.min(arrayOfInt.length, 6);
    int i = 0;
    while (i < j)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(arrayOfInt[i]);
      this.jdField_a_of_type_JavaUtilList.add(localImageView);
      i += 1;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null)
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131368636);
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
    }
  }
  
  public void a(List<oidb_0x899.memberlist> paramList)
  {
    if (paramList == null) {
      return;
    }
    int j = paramList.size();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i = 0;
    if (i < j)
    {
      oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)paramList.get(i);
      if ((localmemberlist == null) || (!localmemberlist.uint64_member_uin.has())) {}
      for (;;)
      {
        i += 1;
        break;
        long l = localmemberlist.uint64_member_uin.get();
        this.jdField_a_of_type_JavaUtilArrayList.add(String.valueOf(l));
      }
    }
    ThreadManager.getUIHandler().post(new TroopMoreDetailView.UpdateTroopMembersFaceTask(this));
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(new TroopMoreDetailView.ShowTagTask(this, this));
    f();
  }
  
  public void c()
  {
    if (zps.b()) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = a();
    } while (localActivity == null);
    Intent localIntent = TroopMemberListActivity.a(localActivity, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
    localIntent.putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum);
    localActivity.startActivityForResult(localIntent, 100);
  }
  
  public void onClick(View paramView)
  {
    if (zps.b()) {}
    Activity localActivity;
    label155:
    label584:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            localActivity = a();
            if (localActivity != null)
            {
              localObject = paramView.getTag();
              if ((localObject instanceof Integer)) {
                switch (((Integer)localObject).intValue())
                {
                case 2: 
                default: 
                  break;
                case 0: 
                  ThreadManager.post(new TroopMoreDetailView.JumpTagDetailTask(this), 8, null, true);
                  if (this.jdField_a_of_type_Boolean)
                  {
                    bhju.a("Grp_set_new", "grpData_visitor", "clk_tag", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                    if (!(localActivity instanceof ChatSettingForTroop)) {
                      continue;
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
                      break label264;
                    }
                  }
                  for (i = 1;; i = 2)
                  {
                    bdll.b(null, "dc00898", "", "", "0X800A528", "0X800A528", i, 0, bguq.a() + "", "", "", "");
                    break;
                    bhju.a("Grp_set_new", "moreData", "clk_tag", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                    break label155;
                  }
                case 3: 
                  if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
                  {
                    localObject = new Intent(localActivity, QQBrowserActivity.class);
                    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
                    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
                    localActivity.startActivity((Intent)localObject);
                  }
                  break;
                case 1: 
                  localObject = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
                  Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
                  localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
                  localIntent.putExtra("url", (String)localObject);
                  localActivity.startActivity(localIntent);
                  if (this.jdField_a_of_type_Boolean) {
                    bhju.a("Grp_set_new", "grpData_visitor", "clk_certifiedInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                  } else {
                    bhju.a("Grp_set_new", "moreData", "clk_certifiedInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                  }
                  break;
                }
              }
            }
          }
          localObject = new Intent(getContext(), PublicAccountBrowser.class);
          ((Intent)localObject).putExtra("url", "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          getContext().startActivity((Intent)localObject);
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          bhju.a("Grp_set_new", "grpData_visitor", "clk_mberIntro", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        } while (!(localActivity instanceof ChatSettingForTroop));
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
        for (i = 1;; i = 2)
        {
          bdll.b(null, "dc00898", "", "", "0X800A529", "0X800A529", i, 0, bguq.a() + "", "", "", "");
          break;
          bhju.a("Grp_set_new", "moreData", "clk_mberIntro", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
          break label584;
        }
        if (this.jdField_a_of_type_Boolean) {
          bhju.a("Grp_set_new", "grpData_visitor", "clk_manaList", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        }
      } while (this.jdField_a_of_type_JavaUtilArrayList.isEmpty());
      Object localObject = new Intent(localActivity, TroopAdminList.class);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((Intent)localObject).putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode);
      ((Intent)localObject).putStringArrayListExtra("troop_info_memo", this.jdField_a_of_type_JavaUtilArrayList);
      if (localActivity.getIntent() != null) {
        ((Intent)localObject).putExtra("t_s_f", localActivity.getIntent().getIntExtra("t_s_f", -1));
      }
      localActivity.startActivity((Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("addFriendTag", 2, String.format("DATA_TAG_TROOP_ADMIN_LIST, [uin:%s, code:%s]", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode }));
      }
    } while (!(localActivity instanceof ChatSettingForTroop));
    label264:
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
    for (int i = 1;; i = 2)
    {
      bdll.b(null, "dc00898", "", "", "0X800A52A", "0X800A52A", i, 0, bguq.a() + "", "", "", "");
      break;
    }
  }
  
  public void setGuestVisitor(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setTroopInfo(TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    paramTroopInfo = a();
    if (paramTroopInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, paramTroopInfo.getCurrentAccountUin());
  }
  
  public void setTroopInfoData(TroopInfoData paramTroopInfoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = paramTroopInfoData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopMoreDetailView
 * JD-Core Version:    0.7.0.1
 */