package com.tencent.mobileqq.troop.troopcard;

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
  public static int a = 3;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = new TroopInfoData();
  TroopMoreDetailView.GetTroopActivityObserver jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView$GetTroopActivityObserver;
  TroopMoreDetailView.GetTroopMemberDistributeObserver jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView$GetTroopMemberDistributeObserver;
  String jdField_a_of_type_JavaLangString = "";
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  List<ImageView> jdField_a_of_type_JavaUtilList;
  ConcurrentLinkedQueue<TroopMoreDetailView.ShowTagTask> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  boolean jdField_a_of_type_Boolean;
  View[] jdField_a_of_type_ArrayOfAndroidViewView;
  
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
  
  private AppInterface a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
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
    String str2 = ((AppInterface)localObject).getCurrentAccountUin();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner;
    String str1 = "1";
    if (bool) {
      localObject = "0";
    } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    localObject = paramString.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin).replace("$CLIENTVER$", "android8.7.0").replace("$UIN$", str2).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", (CharSequence)localObject);
    paramString = str1;
    if (this.jdField_a_of_type_Boolean) {
      paramString = "2";
    }
    paramString = ((String)localObject).replace("$ENTERSOURCE$", paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName);
    ((StringBuilder)localObject).append("");
    return paramString.replace("$GNAME$", ((StringBuilder)localObject).toString()).replace("$GUIN$", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin).replace("$UNREADNUM$", String.valueOf(paramInt));
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
    int i = paramGroupInfoCardResp.activitys.size();
    Object localObject1 = paramGroupInfoCardResp.group_act_url.get();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.jdField_a_of_type_JavaLangString = a((String)localObject1, 0L, 0);
    }
    localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[3];
    if (localObject1 == null) {
      return;
    }
    View localView = ((View)localObject1).findViewById(2131379140);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131362029);
    if (i > 0)
    {
      Object localObject2 = (troopactivity.Activity)paramGroupInfoCardResp.activitys.get(0);
      String str = ((troopactivity.Activity)localObject2).str_name.get();
      localObject2 = ((troopactivity.Activity)localObject2).str_start_time.get();
      paramGroupInfoCardResp.being_act_num.get();
      a(3, 0, localView, getContext().getString(2131696306), getContext().getString(2131697219), true);
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
      i = paramGroupInfoCardResp.history_act_num.get();
      paramGroupInfoCardResp = String.format(getContext().getString(2131697218), new Object[] { Integer.valueOf(i) });
      a(3, 0, localView, getContext().getString(2131696306), paramGroupInfoCardResp, true);
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
    AppInterface localAppInterface = a();
    if (localAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView$GetTroopMemberDistributeObserver = new TroopMoreDetailView.GetTroopMemberDistributeObserver(this);
    b(localAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView$GetTroopMemberDistributeObserver);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView$GetTroopActivityObserver = new TroopMoreDetailView.GetTroopActivityObserver(this);
      a(localAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView$GetTroopActivityObserver);
    }
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
    Object localObject1 = a();
    if (localObject1 == null) {
      return;
    }
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    ((Activity)localObject1).getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt & 0x800) != 0L) {
      i = 1;
    } else {
      i = 0;
    }
    removeAllViews();
    int k = 8;
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[8];
    localObject1 = View.inflate(getContext(), 2131561544, null);
    if (i != 0) {
      j = 1;
    } else {
      j = 3;
    }
    a(0, j, (View)localObject1, getContext().getString(2131719805), null, true, 1);
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject1;
    addView((View)localObject1);
    b();
    localObject1 = View.inflate(getContext(), 2131560711, null);
    a(3, 3, (View)localObject1, HardCodeUtil.a(2131715446), "", true);
    this.jdField_a_of_type_ArrayOfAndroidViewView[3] = localObject1;
    new LinearLayout.LayoutParams(-1, -2).setMargins(0, ViewUtils.a(10.0F), 0, 0);
    addView((View)localObject1);
    ((View)localObject1).setVisibility(8);
    localObject1 = View.inflate(getContext(), 2131561565, null);
    addView((View)localObject1);
    ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298125);
    localObject1 = View.inflate(getContext(), 2131561559, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
    addView((View)localObject1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131715443));
    localObject2 = ((StringBuilder)localObject2).toString();
    a(4, 3, (View)localObject1, HardCodeUtil.a(2131715445), (String)localObject2, true);
    localObject1 = View.inflate(getContext(), 2131559886, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject1;
    ((View)localObject1).setBackgroundResource(2130839440);
    ((View)localObject1).setFocusable(true);
    ((View)localObject1).setTag(Integer.valueOf(5));
    ((View)localObject1).setOnClickListener(this);
    ((View)localObject1).setVisibility(8);
    addView((View)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if ((localObject1 != null) && (((TroopInfoData)localObject1).troopUin != null))
    {
      boolean bool1 = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).isGrayTroopForTroopGameCard(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.checkFlagExt4(4096);
      boolean bool3 = ((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
      boolean bool4 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isHomeworkTroop();
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
        localObject1 = new TroopGameCardView(getContext(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
        addView((View)localObject1);
      }
    }
    localObject1 = View.inflate(getContext(), 2131561565, null);
    addView((View)localObject1);
    ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298125);
    localObject1 = View.inflate(getContext(), 2131561567, null);
    localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView;
    localObject2[6] = localObject1;
    localObject2[6].setBackgroundResource(2130839440);
    ((View)localObject1).setTag(Integer.valueOf(6));
    ((View)localObject1).setOnClickListener(this);
    a((View)localObject1);
    addView((View)localObject1);
    ((TextView)((View)localObject1).findViewById(2131370751)).setText(HardCodeUtil.a(2131715451));
    TroopReportor.a("grpProfile", "grpProfile_exp", "admin_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    localObject1 = ((View)localObject1).findViewById(2131370041);
    if ((this.jdField_a_of_type_Boolean) && (i != 0)) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = View.inflate(getContext(), 2131561545, null);
    a(1, 2, (View)localObject1, HardCodeUtil.a(2131715450), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopAuthenticateInfo, true);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject1;
    addView((View)localObject1);
    int j = k;
    if (i != 0) {
      j = 0;
    }
    ((View)localObject1).setVisibility(j);
    if (i != 0) {
      TroopReportor.a("grpProfile", "grpProfile_exp", "certification_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
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
            paramView.setBackgroundResource(2130839440);
          }
        }
        else {
          paramView.setBackgroundResource(2130839443);
        }
      }
      else {
        paramView.setBackgroundResource(2130839449);
      }
    }
    else {
      paramView.setBackgroundResource(2130839433);
    }
    TextView localTextView1 = (TextView)paramView.findViewById(2131378784);
    TextView localTextView2 = (TextView)paramView.findViewById(2131368773);
    View localView = paramView.findViewById(2131362975);
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
    TextView localTextView = (TextView)paramView.findViewById(2131378784);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    localTextView.setText(paramArrayOfString);
    paramString = paramView.findViewById(2131362975);
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
          paramView.setBackgroundResource(2130839440);
          return;
        }
        paramView.setBackgroundResource(2130839443);
        return;
      }
      paramView.setBackgroundResource(2130839449);
      return;
    }
    paramView.setBackgroundResource(2130839433);
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
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView;
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
        int i = Utils.a(5.0F, getResources());
        int j = Utils.a(2.0F, getResources());
        int n = Utils.a(77.0F, getResources());
        int m = Utils.a(11.0F, getResources());
        int i6 = Utils.a(12.0F, getResources());
        Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131364752);
        LinearLayout localLinearLayout = (LinearLayout)((View)localObject1).findViewById(2131364753);
        if (this.jdField_a_of_type_Boolean)
        {
          ((LinearLayout)localObject2).setVisibility(8);
          localLinearLayout.setVisibility(0);
          localLinearLayout.removeAllViews();
        }
        else
        {
          ((LinearLayout)localObject2).setVisibility(0);
          localLinearLayout.setVisibility(8);
          ((LinearLayout)localObject2).setPadding(((LinearLayout)localObject2).getPaddingLeft(), j, ((LinearLayout)localObject2).getPaddingRight(), ((LinearLayout)localObject2).getPaddingBottom());
          ((LinearLayout)localObject2).removeAllViews();
        }
        if (paramArrayList == null) {
          return;
        }
        int i2 = getResources().getDisplayMetrics().widthPixels - localLinearLayout.getLeft();
        int i1 = 0;
        for (;;)
        {
          int k = paramInt2;
          if ((i1 >= paramArrayList.size()) || ((i1 >= jdField_a_of_type_Int) && ((!this.jdField_a_of_type_Boolean) || (i2 <= 0)))) {
            break;
          }
          if (TextUtils.isEmpty((CharSequence)paramArrayList.get(i1)))
          {
            k = i2;
          }
          else
          {
            TextView localTextView = new TextView(getContext());
            localTextView.setId(2131373890);
            if (k == 1) {
              k = 2130843984;
            } else if ((k != 2) && (k == 3)) {
              k = 2130843983;
            } else {
              k = 2130843982;
            }
            Object localObject3 = getResources().getDrawable(k);
            ITroopCardApi localITroopCardApi = (ITroopCardApi)QRoute.api(ITroopCardApi.class);
            k = j;
            localITroopCardApi.setNightModeFilterForDrawable(a(), (Drawable)localObject3);
            localTextView.setBackgroundDrawable((Drawable)localObject3);
            localTextView.setTextSize(1, 12.0F);
            if (paramBoolean2) {
              localTextView.setMaxWidth(n);
            }
            localTextView.setSingleLine();
            localObject3 = getResources();
            int i3;
            if (this.jdField_a_of_type_Boolean) {
              i3 = 2131167056;
            } else {
              i3 = 2131167222;
            }
            localTextView.setTextColor(((Resources)localObject3).getColor(i3));
            if (this.jdField_a_of_type_Boolean) {
              i3 = m;
            } else {
              i3 = i;
            }
            int i4;
            if (this.jdField_a_of_type_Boolean) {
              i4 = i;
            } else {
              i4 = k;
            }
            int i5;
            if (this.jdField_a_of_type_Boolean) {
              i5 = m;
            } else {
              i5 = i;
            }
            if (this.jdField_a_of_type_Boolean) {
              k = i;
            }
            localTextView.setPadding(i3, i4, i5, k);
            localTextView.setGravity(17);
            localTextView.setText((CharSequence)paramArrayList.get(i1));
            localTextView.setEllipsize(TextUtils.TruncateAt.END);
            localObject3 = new LinearLayout.LayoutParams(-2, -2);
            if (this.jdField_a_of_type_Boolean)
            {
              ((LinearLayout.LayoutParams)localObject3).rightMargin = i6;
              localTextView.measure(0, 0);
              if (i2 >= localTextView.getMeasuredWidth() + i6)
              {
                localLinearLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject3);
                k = i2 - (localTextView.getMeasuredWidth() + i6);
              }
              else
              {
                k = 0;
              }
            }
            else
            {
              ((LinearLayout.LayoutParams)localObject3).leftMargin = i;
              ((LinearLayout)localObject2).addView(localTextView, (ViewGroup.LayoutParams)localObject3);
              k = i2;
            }
          }
          i1 += 1;
          i2 = k;
        }
        paramArrayList = ((View)localObject1).findViewById(2131362975);
        if (paramBoolean1)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            localObject2 = (RelativeLayout.LayoutParams)paramArrayList.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131378784);
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
    tmp8_6[0] = 2131379306;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131379307;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131379308;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131379309;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131379310;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131379311;
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
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView;
    if (localObject[4] != null)
    {
      localObject = (TextView)localObject[4].findViewById(2131368773);
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
    int j = paramList.size();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i = 0;
    while (i < j)
    {
      oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)paramList.get(i);
      if ((localmemberlist != null) && (localmemberlist.uint64_member_uin.has()))
      {
        long l = localmemberlist.uint64_member_uin.get();
        this.jdField_a_of_type_JavaUtilArrayList.add(String.valueOf(l));
      }
      i += 1;
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
    if (((ITroopCardApi)QRoute.api(ITroopCardApi.class)).isFastDoubleClick()) {
      return;
    }
    Activity localActivity = a();
    if (localActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    localIntent.putExtra("param_from", 0);
    localIntent.putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum);
    RouteUtils.a(localActivity, localIntent, "/troop/memberlist/TroopMemberList", 100);
  }
  
  public void onClick(View paramView)
  {
    if (!((ITroopCardApi)QRoute.api(ITroopCardApi.class)).isFastDoubleClick())
    {
      Object localObject1 = a();
      if (localObject1 != null)
      {
        Object localObject2 = paramView.getTag();
        if ((localObject2 instanceof Integer))
        {
          int i = ((Integer)localObject2).intValue();
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 3)
              {
                if ((i != 4) && (i != 5))
                {
                  if (i == 6)
                  {
                    if (this.jdField_a_of_type_Boolean) {
                      TroopReportor.a("grpProfile", "grpProfile_clk", "admin_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
                    }
                    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
                    {
                      localObject2 = new Intent((Context)localObject1, ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopAdminListClass());
                      ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin);
                      ((Intent)localObject2).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
                      ((Intent)localObject2).putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopCode);
                      ((Intent)localObject2).putStringArrayListExtra("troop_info_memo", this.jdField_a_of_type_JavaUtilArrayList);
                      if (((Activity)localObject1).getIntent() != null) {
                        ((Intent)localObject2).putExtra("t_s_f", ((Activity)localObject1).getIntent().getIntExtra("t_s_f", -1));
                      }
                      ((Activity)localObject1).startActivity((Intent)localObject2);
                      if (QLog.isColorLevel()) {
                        QLog.i("addFriendTag", 2, String.format("DATA_TAG_TROOP_ADMIN_LIST, [uin:%s, code:%s]", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopCode }));
                      }
                      if (((ITroopSettingApi)QRoute.api(ITroopSettingApi.class)).isInstanceOfTroopSettingActivity((Activity)localObject1))
                      {
                        if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) {
                          i = 1;
                        } else {
                          i = 2;
                        }
                        localObject1 = new StringBuilder();
                        ((StringBuilder)localObject1).append(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSourceReportVal());
                        ((StringBuilder)localObject1).append("");
                        ReportController.b(null, "dc00898", "", "", "0X800A52A", "0X800A52A", i, 0, ((StringBuilder)localObject1).toString(), "", "", "");
                      }
                    }
                  }
                }
                else
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=");
                  ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
                  localObject2 = ((StringBuilder)localObject2).toString();
                  ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(getContext(), "/pubaccount/browser");
                  localActivityURIRequest.extra().putString("url", (String)localObject2);
                  QRoute.startUri(localActivityURIRequest, null);
                  if (this.jdField_a_of_type_Boolean) {
                    TroopReportor.a("grpProfile", "grpProfile_clk", "grpMember_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
                  } else {
                    TroopReportor.a("Grp_set_new", "moreData", "clk_mberIntro", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
                  }
                  if (((ITroopSettingApi)QRoute.api(ITroopSettingApi.class)).isInstanceOfTroopSettingActivity((Activity)localObject1))
                  {
                    if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) {
                      i = 1;
                    } else {
                      i = 2;
                    }
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSourceReportVal());
                    ((StringBuilder)localObject1).append("");
                    ReportController.b(null, "dc00898", "", "", "0X800A529", "0X800A529", i, 0, ((StringBuilder)localObject1).toString(), "", "", "");
                  }
                }
              }
              else if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
              {
                localObject1 = new ActivityURIRequest((Context)localObject1, "/base/browser");
                ((ActivityURIRequest)localObject1).extra().putLong("startOpenPageTime", System.currentTimeMillis());
                ((ActivityURIRequest)localObject1).extra().putString("url", this.jdField_a_of_type_JavaLangString);
                QRoute.startUri((URIRequest)localObject1, null);
              }
            }
            else
            {
              localObject2 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
              localObject1 = new ActivityURIRequest((Context)localObject1, "/base/browser");
              ((ActivityURIRequest)localObject1).extra().putLong("startOpenPageTime", System.currentTimeMillis());
              ((ActivityURIRequest)localObject1).extra().putString("url", (String)localObject2);
              QRoute.startUri((URIRequest)localObject1, null);
              if (this.jdField_a_of_type_Boolean) {
                TroopReportor.a("grpProfile", "grpProfile_clk", "certification_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
              } else {
                TroopReportor.a("Grp_set_new", "moreData", "clk_certifiedInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
              }
            }
          }
          else
          {
            ThreadManager.post(new TroopMoreDetailView.JumpTagDetailTask(this), 8, null, true);
            if (this.jdField_a_of_type_Boolean) {
              TroopReportor.a("grpProfile", "grpProfile_clk", "grpTag_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
            } else {
              TroopReportor.a("Grp_set_new", "moreData", "clk_tag", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
            }
            if (((ITroopSettingApi)QRoute.api(ITroopSettingApi.class)).isInstanceOfTroopSettingActivity((Activity)localObject1))
            {
              if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) {
                i = 1;
              } else {
                i = 2;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSourceReportVal());
              ((StringBuilder)localObject1).append("");
              ReportController.b(null, "dc00898", "", "", "0X800A528", "0X800A528", i, 0, ((StringBuilder)localObject1).toString(), "", "", "");
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateForTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramTroopInfo.getCurrentAccountUin());
  }
  
  public void setTroopInfoData(TroopInfoData paramTroopInfoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = paramTroopInfoData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopMoreDetailView
 * JD-Core Version:    0.7.0.1
 */