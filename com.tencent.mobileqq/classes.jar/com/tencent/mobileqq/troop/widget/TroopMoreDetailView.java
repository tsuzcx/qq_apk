package com.tencent.mobileqq.troop.widget;

import akbn;
import akbo;
import akbp;
import akbq;
import akbs;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
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
  akbn jdField_a_of_type_Akbn;
  akbo jdField_a_of_type_Akbo;
  public DisplayMetrics a;
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  public TroopInfoData a;
  String jdField_a_of_type_JavaLangString = "";
  public ArrayList a;
  public List a;
  boolean jdField_a_of_type_Boolean;
  public View[] a;
  
  public TroopMoreDetailView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    d();
  }
  
  public TroopMoreDetailView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    d();
  }
  
  public TroopMoreDetailView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
      localObject = paramString.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).replace("$CLIENTVER$", "android7.6.8").replace("$UIN$", str).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", (CharSequence)localObject);
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
    View localView = ((View)localObject1).findViewById(2131368621);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131368622);
    if (i > 0)
    {
      Object localObject2 = (troopactivity.Activity)paramGroupInfoCardResp.activitys.get(0);
      String str = ((troopactivity.Activity)localObject2).str_name.get();
      localObject2 = ((troopactivity.Activity)localObject2).str_start_time.get();
      paramGroupInfoCardResp.being_act_num.get();
      a(3, 0, localView, getContext().getString(2131430379), getContext().getString(2131430513), true);
      localTextView.setText(str + "\n" + (String)localObject2);
      localTextView.setVisibility(0);
      ((View)localObject1).setVisibility(0);
      return;
    }
    if (paramGroupInfoCardResp.history_act_num.get() > 0)
    {
      i = paramGroupInfoCardResp.history_act_num.get();
      paramGroupInfoCardResp = String.format(getContext().getString(2131430514), new Object[] { Integer.valueOf(i) });
      a(3, 0, localView, getContext().getString(2131430379), paramGroupInfoCardResp, true);
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
      this.jdField_a_of_type_Akbo = new akbo(this);
      b(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_Akbo);
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Akbn = new akbn(this);
    a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_Akbn);
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
    label73:
    int k;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L)
    {
      j = 1;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)) {
        break label582;
      }
      i = 1;
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[7];
      localObject = View.inflate(getContext(), 2130970668, null);
      if ((j == 0) && (i == 0)) {
        break label587;
      }
      k = 1;
      label105:
      a(0, k, (View)localObject, getContext().getString(2131433674), null, true, 1);
      this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject;
      addView((View)localObject);
      b();
      localObject = View.inflate(getContext(), 2130970669, null);
      a(1, 2, (View)localObject, "认证机构", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, true);
      this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject;
      addView((View)localObject);
      if (j == 0) {
        break label592;
      }
      j = 0;
      label196:
      ((View)localObject).setVisibility(j);
      localObject = View.inflate(getContext(), 2130970669, null);
      a(2, 3, (View)localObject, "群位置", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, true);
      this.jdField_a_of_type_ArrayOfAndroidViewView[2] = localObject;
      addView((View)localObject);
      if (i == 0) {
        break label598;
      }
    }
    label582:
    label587:
    label592:
    label598:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      localObject = View.inflate(getContext(), 2130969977, null);
      a(3, 0, (View)localObject, "群活动", "", true);
      this.jdField_a_of_type_ArrayOfAndroidViewView[3] = localObject;
      new LinearLayout.LayoutParams(-1, -2).setMargins(0, UIUtils.a(getContext(), 10.0F), 0, 0);
      addView((View)localObject);
      ((View)localObject).setVisibility(8);
      addView(View.inflate(getContext(), 2130970681, null));
      localObject = View.inflate(getContext(), 2130970677, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject;
      addView((View)localObject);
      a(4, 0, (View)localObject, "成员概况", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "人", true);
      localObject = View.inflate(getContext(), 2130969447, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject;
      ((View)localObject).setBackgroundResource(2130838636);
      ((View)localObject).setFocusable(true);
      ((View)localObject).setTag(Integer.valueOf(5));
      ((View)localObject).setOnClickListener(this);
      ((View)localObject).setVisibility(8);
      addView((View)localObject);
      addView(View.inflate(getContext(), 2130970681, null));
      localObject = View.inflate(getContext(), 2130970682, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject;
      this.jdField_a_of_type_ArrayOfAndroidViewView[6].setBackgroundResource(2130838629);
      ((View)localObject).setTag(Integer.valueOf(6));
      ((View)localObject).setOnClickListener(this);
      a((View)localObject);
      addView((View)localObject);
      ((TextView)((View)localObject).findViewById(2131365887)).setText("管理员");
      e();
      return;
      j = 0;
      break;
      i = 0;
      break label73;
      k = 0;
      break label105;
      j = 8;
      break label196;
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
        TextView localTextView1 = (TextView)paramView.findViewById(2131363397);
        TextView localTextView2 = (TextView)paramView.findViewById(2131364144);
        localView = paramView.findViewById(2131363462);
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
      paramView.setBackgroundResource(2130838629);
      break label48;
      paramView.setBackgroundResource(2130838641);
      break label48;
      paramView.setBackgroundResource(2130838639);
      break label48;
      paramView.setBackgroundResource(2130838636);
      break label48;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, String[] paramArrayOfString, boolean paramBoolean, int paramInt3)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131363397);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    localTextView.setText(paramArrayOfString);
    paramString = paramView.findViewById(2131363462);
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
    paramView.setBackgroundResource(2130838629);
    return;
    paramView.setBackgroundResource(2130838641);
    return;
    paramView.setBackgroundResource(2130838639);
    return;
    paramView.setBackgroundResource(2130838636);
  }
  
  public void a(int paramInt1, ArrayList paramArrayList, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMoreDetailView", 2, "updateClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayList + ", bShowArrow = " + paramBoolean1);
    }
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
    for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1];; localView = null)
    {
      int j;
      int k;
      int m;
      LinearLayout localLinearLayout;
      if (localView != null)
      {
        j = AIOUtils.a(5.0F, getResources());
        k = AIOUtils.a(2.0F, getResources());
        m = AIOUtils.a(77.0F, getResources());
        localLinearLayout = (LinearLayout)localView.findViewById(2131371573);
        localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), k, localLinearLayout.getPaddingRight(), localLinearLayout.getPaddingBottom());
        localLinearLayout.removeAllViews();
        if (paramArrayList != null) {}
      }
      else
      {
        return;
      }
      int i = 0;
      while ((i < paramArrayList.size()) && (i < 3)) {
        if (TextUtils.isEmpty((CharSequence)paramArrayList.get(i)))
        {
          i += 1;
        }
        else
        {
          TextView localTextView = new TextView(getContext());
          localTextView.setId(2131362056);
          if (paramInt2 == 1) {
            localTextView.setBackgroundResource(2130841456);
          }
          for (;;)
          {
            localTextView.setTextSize(1, 12.0F);
            if (paramBoolean2) {
              localTextView.setMaxWidth(m);
            }
            localTextView.setSingleLine();
            localTextView.setTextColor(-1);
            localTextView.setPadding(j, k, j, k);
            localTextView.setGravity(17);
            localTextView.setText((CharSequence)paramArrayList.get(i));
            localTextView.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            localLayoutParams.leftMargin = j;
            localLinearLayout.addView(localTextView, localLayoutParams);
            break;
            if (paramInt2 == 2) {
              localTextView.setBackgroundResource(2130841455);
            } else {
              localTextView.setBackgroundResource(2130841455);
            }
          }
        }
      }
      paramArrayList = localView.findViewById(2131363462);
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
    tmp8_6[0] = 2131371581;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131371582;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131371583;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131371584;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131371585;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131371586;
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
  
  public void a(List paramList)
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
    ThreadManager.getUIHandler().post(new akbs(this));
  }
  
  public void b()
  {
    ThreadManager.post(new akbq(this), 8, null, true);
  }
  
  public void c()
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
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localActivity = a();
          } while (localActivity == null);
          paramView = paramView.getTag();
        } while (!(paramView instanceof Integer));
        switch (((Integer)paramView).intValue())
        {
        default: 
          return;
        case 0: 
          ThreadManager.post(new akbp(this), 8, null, true);
          if (this.jdField_a_of_type_Boolean)
          {
            TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_tag", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            return;
          }
          TroopReportor.a("Grp_set_new", "moreData", "clk_tag", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
          return;
        }
      } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
      paramView = new Intent(localActivity, QQBrowserActivity.class);
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
      localActivity.startActivity(paramView);
      return;
      paramView = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("url", paramView);
      localActivity.startActivity(localIntent);
      if (this.jdField_a_of_type_Boolean)
      {
        TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_certifiedInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        return;
      }
      TroopReportor.a("Grp_set_new", "moreData", "clk_certifiedInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 15) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 10) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 11)) || ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon != 0)))
      {
        paramView = new Intent(localActivity, QQBrowserActivity.class);
        paramView.putExtra("url", String.format("https://nearby.qq.com/hot_chat/qun_class.html?_wv=1031&latitude=%1$s&longitude=%2$s", new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat / 1000000.0D), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon / 1000000.0D) }));
        localActivity.startActivity(paramView);
      }
      while (this.jdField_a_of_type_Boolean)
      {
        TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_grpMap", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
          TroopLocationModifyActivity.a(localActivity, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, 99);
        }
      }
      TroopReportor.a("Grp_set_new", "moreData", "clk_grpMap", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      paramView = new Intent(getContext(), PublicAccountBrowser.class);
      paramView.putExtra("url", "http://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      getContext().startActivity(paramView);
      if (this.jdField_a_of_type_Boolean)
      {
        TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_mberIntro", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        return;
      }
      TroopReportor.a("Grp_set_new", "moreData", "clk_mberIntro", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      if (this.jdField_a_of_type_Boolean) {
        TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_manaList", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList.isEmpty());
    paramView = new Intent(localActivity, TroopAdminList.class);
    paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
    paramView.putStringArrayListExtra("troop_info_memo", this.jdField_a_of_type_JavaUtilArrayList);
    if (localActivity.getIntent() != null) {
      paramView.putExtra("t_s_f", localActivity.getIntent().getIntExtra("t_s_f", -1));
    }
    localActivity.startActivity(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopMoreDetailView
 * JD-Core Version:    0.7.0.1
 */