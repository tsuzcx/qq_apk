package com.tencent.mobileqq.troop.widget;

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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
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
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfig;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.NetworkUtil;
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
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.ReqBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.troop.activity.troopactivity.ActSSOReq;
import tencent.im.troop.activity.troopactivity.Activity;
import tencent.im.troop.activity.troopactivity.GroupInfoCardResp;

public class TroopMoreDetailView
  extends LinearLayout
  implements View.OnClickListener
{
  public static int a;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  TroopMoreDetailView.GetTroopActivityObserver jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView$GetTroopActivityObserver;
  TroopMoreDetailView.GetTroopMemberDistributeObserver jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView$GetTroopMemberDistributeObserver;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  String jdField_a_of_type_JavaLangString = "";
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  List<ImageView> jdField_a_of_type_JavaUtilList;
  ConcurrentLinkedQueue<TroopMoreDetailView.ShowTagTask> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  boolean jdField_a_of_type_Boolean;
  View[] jdField_a_of_type_ArrayOfAndroidViewView;
  
  static
  {
    jdField_a_of_type_Int = 3;
  }
  
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
      localObject = paramString.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).replace("$CLIENTVER$", "android8.5.5").replace("$UIN$", str).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", (CharSequence)localObject);
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
    paramString = new NewIntent(paramQQAppInterface.getApp(), ProtoServlet.class);
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
    View localView = ((View)localObject1).findViewById(2131379811);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131362013);
    if (i > 0)
    {
      Object localObject2 = (troopactivity.Activity)paramGroupInfoCardResp.activitys.get(0);
      String str = ((troopactivity.Activity)localObject2).str_name.get();
      localObject2 = ((troopactivity.Activity)localObject2).str_start_time.get();
      paramGroupInfoCardResp.being_act_num.get();
      a(3, 0, localView, getContext().getString(2131696287), getContext().getString(2131697200), true);
      localTextView.setText(str + "\n" + (String)localObject2);
      localTextView.setVisibility(0);
      ((View)localObject1).setVisibility(0);
      return;
    }
    if (paramGroupInfoCardResp.history_act_num.get() > 0)
    {
      i = paramGroupInfoCardResp.history_act_num.get();
      paramGroupInfoCardResp = String.format(getContext().getString(2131697199), new Object[] { Integer.valueOf(i) });
      a(3, 0, localView, getContext().getString(2131696287), paramGroupInfoCardResp, true);
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
      paramString = new NewIntent(paramQQAppInterface.getApp(), ProtoServlet.class);
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
    if (!NetworkUtil.g(getContext())) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        localQQAppInterface = a();
      } while (localQQAppInterface == null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView$GetTroopMemberDistributeObserver = new TroopMoreDetailView.GetTroopMemberDistributeObserver(this);
      b(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView$GetTroopMemberDistributeObserver);
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView$GetTroopActivityObserver = new TroopMoreDetailView.GetTroopActivityObserver(this);
    a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView$GetTroopActivityObserver);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMoreDetailView", 2, String.format("runNextShowTagTask %s / %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()), Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size()) }));
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < jdField_a_of_type_Int)
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
    int i;
    label90:
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
    {
      i = 1;
      removeAllViews();
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[8];
      localObject = View.inflate(getContext(), 2131561701, null);
      if (i == 0) {
        break label858;
      }
      j = 1;
      a(0, j, (View)localObject, getContext().getString(2131720073), null, true, 1);
      this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject;
      addView((View)localObject);
      b();
      localObject = View.inflate(getContext(), 2131560837, null);
      a(3, 3, (View)localObject, HardCodeUtil.a(2131715524), "", true);
      this.jdField_a_of_type_ArrayOfAndroidViewView[3] = localObject;
      new LinearLayout.LayoutParams(-1, -2).setMargins(0, UIUtils.a(getContext(), 10.0F), 0, 0);
      addView((View)localObject);
      ((View)localObject).setVisibility(8);
      localObject = View.inflate(getContext(), 2131561722, null);
      addView((View)localObject);
      ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298131);
      localObject = View.inflate(getContext(), 2131561716, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject;
      addView((View)localObject);
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + HardCodeUtil.a(2131715521);
      a(4, 3, (View)localObject, HardCodeUtil.a(2131715523), str, true);
      localObject = View.inflate(getContext(), 2131560015, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject;
      ((View)localObject).setBackgroundResource(2130839582);
      ((View)localObject).setFocusable(true);
      ((View)localObject).setTag(Integer.valueOf(5));
      ((View)localObject).setOnClickListener(this);
      ((View)localObject).setVisibility(8);
      addView((View)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin != null))
      {
        localObject = (TroopGameCardConfig)QConfigManager.a().a(695);
        if ((localObject == null) || (!((TroopGameCardConfig)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
          break label863;
        }
        bool1 = true;
        label434:
        boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFlagExt4(4096);
        boolean bool3 = StudyModeManager.a();
        boolean bool4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMoreDetailView", 2, "initView(), troopGameCardConfigEnabled = " + bool1 + ", troopGameCardEnabled = " + bool2 + ", isStudyMode = " + bool3 + ", isHwTroop = " + bool4);
        }
        if ((bool1) && (bool2) && (!bool4) && (!bool3))
        {
          localObject = new TroopGameCardView(getContext(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject;
          addView((View)localObject);
        }
      }
      localObject = View.inflate(getContext(), 2131561722, null);
      addView((View)localObject);
      ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298131);
      localObject = View.inflate(getContext(), 2131561724, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject;
      this.jdField_a_of_type_ArrayOfAndroidViewView[6].setBackgroundResource(2130839582);
      ((View)localObject).setTag(Integer.valueOf(6));
      ((View)localObject).setOnClickListener(this);
      a((View)localObject);
      addView((View)localObject);
      ((TextView)((View)localObject).findViewById(2131371127)).setText(HardCodeUtil.a(2131715529));
      TroopReportor.a("grpProfile", "grpProfile_exp", "admin_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      localObject = ((View)localObject).findViewById(2131370380);
      if ((this.jdField_a_of_type_Boolean) && (i != 0)) {
        ((View)localObject).setVisibility(0);
      }
      localObject = View.inflate(getContext(), 2131561702, null);
      a(1, 2, (View)localObject, HardCodeUtil.a(2131715528), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, true);
      this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject;
      addView((View)localObject);
      if (i == 0) {
        break label868;
      }
    }
    label858:
    label863:
    label868:
    for (int j = 0;; j = 8)
    {
      ((View)localObject).setVisibility(j);
      if (i != 0) {
        TroopReportor.a("grpProfile", "grpProfile_exp", "certification_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
      e();
      return;
      i = 0;
      break;
      j = 3;
      break label90;
      bool1 = false;
      break label434;
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
        TextView localTextView1 = (TextView)paramView.findViewById(2131379432);
        TextView localTextView2 = (TextView)paramView.findViewById(2131369051);
        localView = paramView.findViewById(2131363027);
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
      paramView.setBackgroundResource(2130839575);
      break label48;
      paramView.setBackgroundResource(2130839591);
      break label48;
      paramView.setBackgroundResource(2130839585);
      break label48;
      paramView.setBackgroundResource(2130839582);
      break label48;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, String[] paramArrayOfString, boolean paramBoolean, int paramInt3)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131379432);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    localTextView.setText(paramArrayOfString);
    paramString = paramView.findViewById(2131363027);
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
    paramView.setBackgroundResource(2130839575);
    return;
    paramView.setBackgroundResource(2130839591);
    return;
    paramView.setBackgroundResource(2130839585);
    return;
    paramView.setBackgroundResource(2130839582);
  }
  
  protected void a(int paramInt1, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMoreDetailView", 2, "updateClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayList + ", bShowArrow = " + paramBoolean1);
    }
    if (this.jdField_a_of_type_ArrayOfAndroidViewView == null) {}
    label387:
    label656:
    label664:
    label671:
    label678:
    label810:
    for (;;)
    {
      return;
      if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
      for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1];; localView = null)
      {
        if (localView == null) {
          break label810;
        }
        if ((paramArrayList == null) || (paramArrayList.size() == 0))
        {
          localView.setVisibility(8);
          return;
        }
        localView.setVisibility(0);
        int i = AIOUtils.a(5.0F, getResources());
        int k = AIOUtils.a(2.0F, getResources());
        int i5 = AIOUtils.a(77.0F, getResources());
        int m = AIOUtils.a(11.0F, getResources());
        int i6 = AIOUtils.a(12.0F, getResources());
        Object localObject1 = (LinearLayout)localView.findViewById(2131364866);
        LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131364867);
        label221:
        int i1;
        int n;
        label246:
        int j;
        if (this.jdField_a_of_type_Boolean)
        {
          ((LinearLayout)localObject1).setVisibility(8);
          localLinearLayout.setVisibility(0);
          localLinearLayout.removeAllViews();
          if (paramArrayList == null) {
            break label348;
          }
          i1 = getResources().getDisplayMetrics().widthPixels - localLinearLayout.getLeft();
          n = 0;
          if ((n >= paramArrayList.size()) || ((n >= jdField_a_of_type_Int) && ((!this.jdField_a_of_type_Boolean) || (i1 <= 0)))) {
            break label721;
          }
          if (!TextUtils.isEmpty((CharSequence)paramArrayList.get(n))) {
            break label350;
          }
          j = i1;
        }
        for (;;)
        {
          n += 1;
          i1 = j;
          break label246;
          ((LinearLayout)localObject1).setVisibility(0);
          localLinearLayout.setVisibility(8);
          ((LinearLayout)localObject1).setPadding(((LinearLayout)localObject1).getPaddingLeft(), k, ((LinearLayout)localObject1).getPaddingRight(), ((LinearLayout)localObject1).getPaddingBottom());
          ((LinearLayout)localObject1).removeAllViews();
          break label221;
          label348:
          break;
          label350:
          TextView localTextView = new TextView(getContext());
          localTextView.setId(2131374334);
          j = 2130844078;
          Object localObject2;
          label458:
          label481:
          int i2;
          label492:
          int i3;
          if (paramInt2 == 1)
          {
            j = 2130844080;
            localObject2 = getResources().getDrawable(j);
            ProfileActivity.a(a(), (Drawable)localObject2);
            localTextView.setBackgroundDrawable((Drawable)localObject2);
            localTextView.setTextSize(1, 12.0F);
            if (paramBoolean2) {
              localTextView.setMaxWidth(i5);
            }
            localTextView.setSingleLine();
            localObject2 = getResources();
            if (!this.jdField_a_of_type_Boolean) {
              break label656;
            }
            j = 2131167033;
            localTextView.setTextColor(((Resources)localObject2).getColor(j));
            if (!this.jdField_a_of_type_Boolean) {
              break label664;
            }
            j = m;
            if (!this.jdField_a_of_type_Boolean) {
              break label671;
            }
            i2 = i;
            if (!this.jdField_a_of_type_Boolean) {
              break label678;
            }
            i3 = m;
            label503:
            if (!this.jdField_a_of_type_Boolean) {
              break label685;
            }
          }
          label685:
          for (int i4 = i;; i4 = k)
          {
            localTextView.setPadding(j, i2, i3, i4);
            localTextView.setGravity(17);
            localTextView.setText((CharSequence)paramArrayList.get(n));
            localTextView.setEllipsize(TextUtils.TruncateAt.END);
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            if (!this.jdField_a_of_type_Boolean) {
              break label698;
            }
            ((LinearLayout.LayoutParams)localObject2).rightMargin = i6;
            localTextView.measure(0, 0);
            if (i1 < localTextView.getMeasuredWidth() + i6) {
              break label692;
            }
            localLinearLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject2);
            j = i1 - (localTextView.getMeasuredWidth() + i6);
            break;
            if (paramInt2 == 2)
            {
              j = 2130844078;
              break label387;
            }
            if (paramInt2 != 3) {
              break label387;
            }
            j = 2130844079;
            break label387;
            j = 2131167197;
            break label458;
            j = i;
            break label481;
            i2 = k;
            break label492;
            i3 = i;
            break label503;
          }
          label692:
          j = 0;
          continue;
          label698:
          ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
          ((LinearLayout)localObject1).addView(localTextView, (ViewGroup.LayoutParams)localObject2);
          j = i1;
        }
        label721:
        paramArrayList = localView.findViewById(2131363027);
        if (paramBoolean1)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            localObject1 = (RelativeLayout.LayoutParams)paramArrayList.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131379432);
            paramArrayList.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
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
  }
  
  protected void a(View paramView)
  {
    int[] arrayOfInt = new int[6];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 2131379977;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131379978;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131379979;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131379980;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131379981;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131379982;
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
      TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[4].findViewById(2131369051);
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
  
  protected void c()
  {
    if (UIUtils.b()) {}
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
    if (UIUtils.b()) {}
    Activity localActivity;
    label145:
    label254:
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
              localObject1 = paramView.getTag();
              if ((localObject1 instanceof Integer)) {
                switch (((Integer)localObject1).intValue())
                {
                case 2: 
                default: 
                  break;
                case 0: 
                  ThreadManager.post(new TroopMoreDetailView.JumpTagDetailTask(this), 8, null, true);
                  if (this.jdField_a_of_type_Boolean)
                  {
                    TroopReportor.a("grpProfile", "grpProfile_clk", "grpTag_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
                    if (!(localActivity instanceof ChatSettingForTroop)) {
                      continue;
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
                      break label254;
                    }
                  }
                  for (i = 1;; i = 2)
                  {
                    ReportController.b(null, "dc00898", "", "", "0X800A528", "0X800A528", i, 0, TroopUtils.a() + "", "", "", "");
                    break;
                    TroopReportor.a("Grp_set_new", "moreData", "clk_tag", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                    break label145;
                  }
                case 3: 
                  if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
                  {
                    localObject1 = new Intent(localActivity, QQBrowserActivity.class);
                    ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
                    ((Intent)localObject1).putExtra("url", this.jdField_a_of_type_JavaLangString);
                    localActivity.startActivity((Intent)localObject1);
                  }
                  break;
                case 1: 
                  localObject1 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
                  localObject2 = new Intent(localActivity, QQBrowserActivity.class);
                  ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
                  ((Intent)localObject2).putExtra("url", (String)localObject1);
                  localActivity.startActivity((Intent)localObject2);
                  if (this.jdField_a_of_type_Boolean) {
                    TroopReportor.a("grpProfile", "grpProfile_clk", "certification_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
                  } else {
                    TroopReportor.a("Grp_set_new", "moreData", "clk_certifiedInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                  }
                  break;
                }
              }
            }
          }
          localObject1 = "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
          Object localObject2 = new ActivityURIRequest(getContext(), "/pubaccount/browser");
          ((ActivityURIRequest)localObject2).extra().putString("url", (String)localObject1);
          QRoute.startUri((URIRequest)localObject2, null);
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          TroopReportor.a("grpProfile", "grpProfile_clk", "grpMember_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        } while (!(localActivity instanceof ChatSettingForTroop));
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
        for (i = 1;; i = 2)
        {
          ReportController.b(null, "dc00898", "", "", "0X800A529", "0X800A529", i, 0, TroopUtils.a() + "", "", "", "");
          break;
          TroopReportor.a("Grp_set_new", "moreData", "clk_mberIntro", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
          break label557;
        }
        if (this.jdField_a_of_type_Boolean) {
          TroopReportor.a("grpProfile", "grpProfile_clk", "admin_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        }
      } while (this.jdField_a_of_type_JavaUtilArrayList.isEmpty());
      Object localObject1 = new Intent(localActivity, TroopAdminList.class);
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      ((Intent)localObject1).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((Intent)localObject1).putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode);
      ((Intent)localObject1).putStringArrayListExtra("troop_info_memo", this.jdField_a_of_type_JavaUtilArrayList);
      if (localActivity.getIntent() != null) {
        ((Intent)localObject1).putExtra("t_s_f", localActivity.getIntent().getIntExtra("t_s_f", -1));
      }
      localActivity.startActivity((Intent)localObject1);
      if (QLog.isColorLevel()) {
        QLog.i("addFriendTag", 2, String.format("DATA_TAG_TROOP_ADMIN_LIST, [uin:%s, code:%s]", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode }));
      }
    } while (!(localActivity instanceof ChatSettingForTroop));
    label557:
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A52A", "0X800A52A", i, 0, TroopUtils.a() + "", "", "", "");
      break;
    }
  }
  
  public void setGuestVisitor(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setTroopInfo(TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    paramTroopInfo = a();
    if (paramTroopInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramTroopInfo.getCurrentAccountUin());
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