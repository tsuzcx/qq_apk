package com.tencent.mobileqq.troop.homework.entry.ui;

import actj;
import ajya;
import akhp;
import akil;
import ampl;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import axlk;
import azvn;
import azwk;
import azwm;
import azwp;
import azws;
import azwz;
import azxa;
import azxb;
import azxc;
import azxd;
import azxe;
import azxf;
import azxg;
import azxh;
import azxi;
import azxj;
import azxk;
import azxl;
import azxm;
import azxn;
import azxo;
import azxp;
import azxq;
import azxr;
import azxs;
import azxt;
import azye;
import azyf;
import azyo;
import babd;
import babf;
import babg;
import babh;
import babi;
import babl;
import babq;
import babr;
import baci;
import baid;
import balw;
import balx;
import banb;
import bbbp;
import bbdj;
import bbef;
import bbeg;
import bbex;
import bbfj;
import bbgu;
import bcqf;
import bcql;
import bfni;
import bfpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.TreeSet;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PublishHomeWorkFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, azyo
{
  public int a;
  protected long a;
  protected akhp a;
  protected akil a;
  protected BroadcastReceiver a;
  protected View a;
  public ViewGroup a;
  public EditText a;
  protected RelativeLayout a;
  protected TextView a;
  public azvn a;
  protected azxt a;
  public azyf a;
  protected bcqf a;
  public bfpc a;
  public CommonRecordSoundPanel a;
  public QQAppInterface a;
  protected TroopManager a;
  public InputMethodGuard a;
  public XMediaEditor a;
  protected FormSimpleItem a;
  public FormSwitchItem a;
  protected Boolean a;
  public String a;
  protected ArrayList<String> a;
  public List<Pair<Integer, View>> a;
  protected JSONObject a;
  public boolean a;
  protected int b;
  protected long b;
  protected View b;
  protected ViewGroup b;
  protected azvn b;
  public FormSimpleItem b;
  public String b;
  protected List<String> b;
  protected boolean b;
  protected int c;
  public long c;
  protected View c;
  protected ViewGroup c;
  public String c;
  protected boolean c;
  protected int d;
  protected View d;
  protected ViewGroup d;
  public String d;
  public boolean d;
  protected int e;
  protected ViewGroup e;
  public String e;
  public boolean e;
  public String f;
  public boolean f;
  protected String g;
  protected boolean g;
  protected String h;
  public boolean h;
  protected boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  protected boolean m;
  protected boolean n;
  
  public PublishHomeWorkFragment()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new azxk(this);
  }
  
  protected static View a(Context paramContext, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setClickable(true);
    localLinearLayout.setGravity(16);
    localLinearLayout.setBackgroundResource(2130843213);
    Object localObject = new LinearLayout.LayoutParams(-2, axlk.a(42.0F));
    ((LinearLayout.LayoutParams)localObject).setMargins(axlk.a(12.0F), 0, 0, 0);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setTextColor(Color.parseColor("#5E6379"));
    ((TextView)localObject).setTextSize(1, 14.0F);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setBackgroundColor(0);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(axlk.a(12.0F), 0, axlk.a(24.0F), 0);
    ((TextView)localObject).setLayoutParams(paramString);
    if (paramInt2 > 0)
    {
      paramContext = new ImageView(paramContext);
      paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext.setImageResource(paramInt2);
      paramString = new LinearLayout.LayoutParams(axlk.a(21.0F), axlk.a(21.0F));
      paramString.setMargins(axlk.a(24.0F), 0, 0, 0);
      paramContext.setLayoutParams(paramString);
      localLinearLayout.addView(paramContext);
    }
    localLinearLayout.addView((View)localObject);
    localLinearLayout.setOnClickListener(paramOnClickListener);
    localLinearLayout.setTag(new azxs(paramInt1, paramObject));
    return localLinearLayout;
  }
  
  protected static View a(Context paramContext, int paramInt, String paramString1, String paramString2, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener, Object paramObject)
  {
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new FormSwitchItem(paramContext);
    ((FormSwitchItem)localObject).setText(paramString1);
    ((FormSwitchItem)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    ((FormSwitchItem)localObject).setBgType(0);
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(paramOnCheckedChangeListener);
    paramContext = new TextView(paramContext);
    paramContext.setTextSize(1, 14.0F);
    paramContext.setTextColor(Color.parseColor("#BBBBBB"));
    paramContext.setPadding(axlk.a(12.0F), 0, axlk.a(12.0F), 0);
    paramString1 = new LinearLayout.LayoutParams(-1, -2);
    paramString1.setMargins(0, axlk.a(2.0F), 0, axlk.a(4.0F));
    paramContext.setLayoutParams(paramString1);
    paramContext.setText(paramString2);
    localLinearLayout.addView((View)localObject);
    localLinearLayout.addView(paramContext);
    localLinearLayout.setTag(new azxs(paramInt, paramObject));
    return localLinearLayout;
  }
  
  public static void a(Activity paramActivity, @Nullable Bundle paramBundle, @Nullable String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("hide_title_left_arrow", true);
    localBundle.putString("PublishHomeWorkFragment:valid", "PublishHomeWorkFragment:valid");
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("extra.GROUP_UIN", paramString);
    }
    localIntent.putExtras(localBundle);
    PublicFragmentActivity.a(paramActivity, localIntent, PublishHomeWorkFragment.class);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    balw localbalw = balw.a();
    Object localObject2 = localbalw.a("troop_create_homework");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://qun.qq.com/homework/features/sethomework.html?_wv=5123&_bid=2146#role=teacher&gid=<$GC>&content=<$CONTENT>&type=word&from=<$FROM>";
    }
    localObject2 = new balx();
    ((balx)localObject2).jdField_a_of_type_JavaLangString = paramString;
    ((balx)localObject2).jdField_c_of_type_JavaLangString = "aio";
    ((balx)localObject2).i = "";
    paramString = localbalw.a((String)localObject1, (balx)localObject2);
    if (paramString != null)
    {
      if (!paramString.startsWith("mqqapi://")) {
        break label100;
      }
      paramQQAppInterface = bbex.a(paramQQAppInterface, paramContext, paramString);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.c();
      }
    }
    label100:
    do
    {
      return;
      paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
      paramQQAppInterface.putExtra("finish_animation_up_down", true);
      paramQQAppInterface.putExtra("url", paramString);
      paramContext.startActivity(paramQQAppInterface);
    } while (!(paramContext instanceof Activity));
    ((Activity)paramContext).overridePendingTransition(2130772278, 2130771990);
  }
  
  private boolean a(long paramLong)
  {
    long l1 = System.currentTimeMillis() / 1000L;
    if (this.jdField_a_of_type_Azyf != null)
    {
      if (paramLong < l1 + 1L) {
        bcql.a(getActivity(), 2131697732, 0).a();
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  private void b(azvn paramazvn)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("homework_id", Long.toString(paramazvn.d));
    localBundle.putString("group_id", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("title", paramazvn.jdField_a_of_type_JavaLangString);
    String str1;
    String str2;
    if (paramazvn.jdField_a_of_type_Boolean)
    {
      str1 = "1";
      localBundle.putString("need_feedback", str1);
      localBundle.putString("c", paramazvn.jdField_b_of_type_JavaLangString);
      str2 = getActivity().app.c();
      paramazvn = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      if (paramazvn == null) {
        break label287;
      }
      str1 = paramazvn.getSkey(str2);
      paramazvn = paramazvn.getPskey(str2, "qun.qq.com");
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localBundle.putString("bkn", "" + banb.b(str1));
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str1 + ";p_uin=o" + str2 + ";p_skey=" + paramazvn);
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new baid("https://qun.qq.com/cgi-bin/homework/hw/modify_hw.fcg", "POST", new azxl(this), 1000, null).a(localHashMap);
      return;
      str1 = "0";
      break;
      label287:
      paramazvn = null;
      str1 = null;
    }
  }
  
  private void c(azvn paramazvn)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("group_id", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("course_id", "0");
    if (!this.jdField_a_of_type_JavaLangString.isEmpty())
    {
      localBundle.putString("course_name", this.jdField_a_of_type_JavaLangString);
      localBundle.putString("title", paramazvn.jdField_a_of_type_JavaLangString);
      if (!paramazvn.jdField_a_of_type_Boolean) {
        break label236;
      }
    }
    int i1;
    label236:
    for (String str1 = "1";; str1 = "0")
    {
      localBundle.putString("need_feedback", str1);
      localBundle.putString("c", paramazvn.jdField_b_of_type_JavaLangString);
      localBundle.putString("team_id", "0");
      localBundle.putString("hw_type", "0");
      localBundle.putString("tsfeedback", String.valueOf(this.jdField_c_of_type_Long));
      if ((paramazvn.jdField_a_of_type_JavaUtilList == null) || (paramazvn.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label287;
      }
      str1 = "[";
      i1 = 0;
      while (i1 < paramazvn.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        str1 = str1 + String.valueOf(paramazvn.jdField_a_of_type_JavaUtilList.get(i1)) + ",";
        i1 += 1;
      }
      localBundle.putString("course_name", ajya.a(2131697682));
      break;
    }
    localBundle.putString("syncgids", str1 + String.valueOf(paramazvn.jdField_a_of_type_JavaUtilList.get(i1)) + "]");
    label287:
    String str2 = getActivity().app.c();
    paramazvn = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (paramazvn != null)
    {
      str1 = paramazvn.getSkey(str2);
      paramazvn = paramazvn.getPskey(str2, "qun.qq.com");
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localBundle.putString("bkn", "" + banb.b(str1));
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str1 + ";p_uin=o" + str2 + ";p_skey=" + paramazvn);
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new baid("https://qun.qq.com/cgi-bin/homework/hw/assign_hw.fcg", "POST", new azxm(this), 1000, null).a(localHashMap);
      return;
      paramazvn = null;
      str1 = null;
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_Azyf = azye.a(getActivity());
    this.jdField_a_of_type_Azyf.a(new azxb(this));
    this.jdField_a_of_type_Azyf.a(new azxc(this));
  }
  
  protected <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  protected <T extends View> T a(Class<T> paramClass, View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return null;
      if (paramClass.isInstance(paramView)) {
        return (View)paramClass.cast(paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i2 = paramView.getChildCount();
        int i1 = 0;
        while (i1 < i2)
        {
          View localView = a(paramClass, paramView.getChildAt(i1));
          if (localView != null) {
            return localView;
          }
          i1 += 1;
        }
      }
    }
  }
  
  protected EditText a(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramView == null) {
      localObject2 = localObject1;
    }
    int i2;
    int i1;
    label38:
    do
    {
      return localObject2;
      if (!(paramView instanceof ViewGroup)) {
        break;
      }
      i2 = ((ViewGroup)paramView).getChildCount();
      i1 = 0;
      localObject1 = localObject2;
      localObject2 = localObject1;
    } while (i1 >= i2);
    localObject2 = a(((ViewGroup)paramView).getChildAt(i1));
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      i1 += 1;
      break label38;
      localObject2 = localObject1;
      if (!(paramView instanceof EditText)) {
        break;
      }
      localObject2 = localObject1;
      if (!paramView.isFocused()) {
        break;
      }
      return (EditText)paramView;
    }
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "_" + "PublishHomeWorkFragment:show_beginner_guide" + "_" + paramInt;
  }
  
  public String a(long paramLong)
  {
    Object localObject3 = Calendar.getInstance();
    ((Calendar)localObject3).setTimeInMillis(1000L * paramLong);
    ((Calendar)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
    int i1 = ((Calendar)localObject3).get(1);
    int i2 = ((Calendar)localObject3).get(2);
    int i3 = ((Calendar)localObject3).get(5);
    ((Calendar)localObject3).get(7);
    Object localObject2 = String.valueOf(((Calendar)localObject3).get(11));
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() == 1) {
        localObject1 = "0" + (String)localObject2;
      }
    }
    localObject3 = String.valueOf(((Calendar)localObject3).get(12));
    localObject2 = localObject3;
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (((String)localObject3).length() == 1) {
        localObject2 = "0" + (String)localObject3;
      }
    }
    return String.valueOf(i1) + ajya.a(2131697734) + String.valueOf(i2 + 1) + ajya.a(2131697733) + String.valueOf(i3) + ajya.a(2131697731) + " " + (String)localObject1 + ":" + (String)localObject2;
  }
  
  List<View> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair != null) && (localPair.second != null) && (((View)localPair.second).getTag() != null) && ((((View)localPair.second).getTag() instanceof azxs)) && (((azxs)((View)localPair.second).getTag()).jdField_a_of_type_Int == paramInt)) {
        localArrayList.add(localPair.second);
      }
    }
    return localArrayList;
  }
  
  @NonNull
  protected List<String> a(babq parambabq)
  {
    ArrayList localArrayList = new ArrayList();
    if (parambabq != null)
    {
      if (!(parambabq instanceof babr)) {
        break label50;
      }
      localArrayList.add(ajya.a(2131708853) + "");
    }
    label50:
    do
    {
      return localArrayList;
      if ((parambabq instanceof babl))
      {
        localArrayList.add(ajya.a(2131708836) + "");
        return localArrayList;
      }
      if ((parambabq instanceof babf))
      {
        localArrayList.add(ajya.a(2131708842) + "");
        return localArrayList;
      }
      if ((parambabq instanceof babd))
      {
        localArrayList.add(ajya.a(2131708846) + "");
        return localArrayList;
      }
    } while (!(parambabq instanceof babi));
    localArrayList.add(ajya.a(2131708850) + "");
    return localArrayList;
  }
  
  public List<Pair<Integer, View>> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a != null))
    {
      if (!azws.jdField_a_of_type_JavaLangString.equals(paramString)) {
        break label110;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "add special entry for recite");
        }
        localArrayList.add(new Pair(Integer.valueOf(1), a(getActivity(), 4, ajya.a(2131708832), 2130839798, new azxi(this), null)));
      }
    }
    label110:
    while ((!azws.jdField_b_of_type_JavaLangString.equals(paramString)) || (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_b_of_type_Boolean)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "add special entry for arithmetic");
    }
    localArrayList.add(new Pair(Integer.valueOf(2), a(getActivity(), 7, ajya.a(2131708854), ajya.a(2131708841), new azxj(this), null)));
    return localArrayList;
  }
  
  protected void a()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Azxt = new azxt(this, Looper.getMainLooper());
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    if (getActivity() == null)
    {
      localObject = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label91;
      }
      getActivity().finish();
    }
    label91:
    do
    {
      return;
      localObject = (QQAppInterface)getActivity().getAppInterface();
      break;
      this.jdField_a_of_type_Akhp = ((akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
      this.jdField_a_of_type_Akil = new azxh(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akil);
    } while (this.m);
    this.m = true;
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
    ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
    getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
  }
  
  protected void a(int paramInt)
  {
    try
    {
      if (!getActivity().isFinishing())
      {
        if (this.jdField_a_of_type_Bcqf == null)
        {
          this.jdField_a_of_type_Bcqf = new bcqf(getActivity(), getActivity().getTitleBarHeight());
          this.jdField_a_of_type_Bcqf.setCancelable(false);
          this.jdField_a_of_type_Bcqf.show();
        }
        this.jdField_a_of_type_Bcqf.c(paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (paramInt == 7) {
      if (this.jdField_e_of_type_Boolean)
      {
        if (this.jdField_b_of_type_JavaLangString != null) {
          break label63;
        }
        localObject = "";
        bbbp.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, "1", "{\"type\":\"calculation\"}" });
      }
    }
    label63:
    ArrayList localArrayList;
    JSONArray localJSONArray;
    do
    {
      return;
      localObject = this.jdField_b_of_type_JavaLangString;
      break;
      localArrayList = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramInt);
      localJSONArray = new JSONArray();
      localObject = localArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        babg localbabg = (babg)((Iterator)localObject).next();
        if (localbabg != null) {
          localJSONArray.put(localbabg.a());
        }
      }
    } while (localArrayList.isEmpty());
    if (this.jdField_b_of_type_JavaLangString == null) {}
    for (Object localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      bbbp.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(localArrayList.size()), localJSONArray.toString() });
      return;
    }
  }
  
  public void a(int paramInt, ArrayList<babq> paramArrayList, azvn paramazvn)
  {
    if (paramInt == 0)
    {
      paramazvn = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        paramazvn.addAll(a((babq)localIterator.next()));
      }
      paramazvn = new ArrayList(new TreeSet(paramazvn));
      if (paramazvn.isEmpty())
      {
        paramazvn = "";
        if (this.jdField_b_of_type_Int != 0) {
          break label277;
        }
        this.jdField_b_of_type_Int += 1;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList.isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramArrayList);
        }
        paramArrayList = getString(2131697753, new Object[] { paramazvn });
        bcql.a(getActivity(), paramArrayList, 0).a();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "Error, reason_code = " + paramInt + ", print trace: ", new RuntimeException("UPLOAD_ERROR"));
      }
      return;
      if (paramazvn.size() == 1)
      {
        paramazvn = (String)paramazvn.get(0);
        break;
      }
      paramazvn = (String)paramazvn.get(0) + "、" + (String)paramazvn.get(1) + ajya.a(2131708834);
      break;
      label277:
      paramArrayList = getString(2131697751, new Object[] { paramazvn });
      bcql.a(getActivity(), paramArrayList, 0).a();
      continue;
      if (paramInt == 1) {
        bcql.a(getActivity(), 2131697715, 0).a();
      } else if (paramInt == 3) {
        bcql.a(getActivity(), 2131697747, 0).a();
      } else if (paramInt == 2) {
        bcql.a(getActivity(), 2131694619, 0).a();
      }
    }
  }
  
  protected void a(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 515;
    this.jdField_a_of_type_Azxt.sendMessageDelayed(localMessage, paramLong);
  }
  
  protected void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onPictureBtnClick");
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(1);
    int i2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(2) + i1;
    if (i2 >= 10)
    {
      if (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 2000L)
      {
        bcql.a(getActivity(), ajya.a(2131708835) + 10 + ajya.a(2131708839), 0).a();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      if ((getActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (getActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 == 0)
      {
        getActivity().requestPermissions(new azwz(this, i2), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i1 = 0;
      }
      else
      {
        paramView = TroopHWJsPlugin.a(10 - i2, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
        startActivityForResult(paramView, 259);
        bfni.a(getActivity());
        return;
        i1 = 1;
      }
    }
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) {}
    for (int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(4);; i1 = 0)
    {
      if ((i1 > 0) && (!paramBoolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        this.jdField_d_of_type_Boolean = true;
        bcql.a(getActivity(), 0, ajya.a(2131708830), 1).a();
      }
      Object localObject;
      do
      {
        do
        {
          return;
          localObject = a(7);
        } while ((localObject == null) || (((List)localObject).isEmpty()));
        localObject = (FormSwitchItem)a(FormSwitchItem.class, (View)((List)localObject).get(0));
      } while ((localObject == null) || (!((FormSwitchItem)localObject).a()) || (this.jdField_d_of_type_Boolean));
      bbgu localbbgu = bbdj.a(getActivity(), 230);
      localbbgu.setMessage(ajya.a(2131708849)).setNegativeButton(ajya.a(2131708852), new azxe(this)).setPositiveButton(ajya.a(2131708847), new azxd(this, (FormSwitchItem)localObject, paramCompoundButton));
      this.jdField_d_of_type_Boolean = true;
      paramCompoundButton.setChecked(true);
      localbbgu.show();
      return;
    }
  }
  
  protected void a(azvn paramazvn)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
    ArrayList localArrayList2;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        babq localbabq = (babq)((Iterator)localObject).next();
        if (localbabq != null) {
          if (localbabq.e() == 1) {
            localArrayList1.add(localbabq);
          } else if ((localbabq.e() == 2) || (localbabq.e() == 0)) {
            localArrayList2.add(localbabq);
          }
        }
      }
      if (!localArrayList1.isEmpty()) {
        a(localArrayList1);
      }
    }
    do
    {
      return;
      if (!localArrayList2.isEmpty())
      {
        a(0, localArrayList2, paramazvn);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: unknown error list");
      }
      a(3, localArrayList2, paramazvn);
      return;
      if (paramazvn == null) {
        break;
      }
      a(2131697730);
      if (this.jdField_a_of_type_Int == 1)
      {
        c(paramazvn);
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    b(paramazvn);
    return;
    if (QLog.isColorLevel()) {
      QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: homework info is null");
    }
    a(3, null, paramazvn);
  }
  
  protected void a(Pair<Integer, View> paramPair)
  {
    if ((this.jdField_d_of_type_AndroidViewViewGroup == null) || (paramPair == null)) {
      return;
    }
    switch (((Integer)paramPair.first).intValue())
    {
    default: 
      return;
    case 1: 
      this.jdField_d_of_type_AndroidViewViewGroup.addView((View)paramPair.second);
      return;
    }
    this.jdField_c_of_type_AndroidViewViewGroup.addView((View)paramPair.second, 0);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("c"))
      {
        paramString = paramString.getJSONArray("c");
        if (paramString != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setDataByEdit(paramString);
          ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.4(this), 550L);
        }
      }
      else
      {
        paramString = new IllegalArgumentException("home work json format error");
        if (QLog.isColorLevel())
        {
          QLog.e("PublishHomeWorkFragment", 2, paramString, new Object[0]);
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublishHomeWorkFragment", 2, "parse homework json error", paramString);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onBeginnerGuidePrepared at " + paramString);
    }
    if (!isResumed()) {
      return;
    }
    BeginnerGuideFragment.a(getActivity(), getArguments(), paramInt);
    paramString = getActivity().getSharedPreferences("PublishHomeWorkFragment:homework_troop", 0).edit();
    paramString.putBoolean(a(paramInt), false);
    paramString.apply();
    bfni.a(getActivity());
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if (("recite".equals(new JSONObject(paramString).getString("type"))) && (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PublishHomeWorkFragment", 2, "onSpecialHomeWorkChanged error ", paramString);
    }
  }
  
  protected void a(@NonNull ArrayList<babq> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.addAll(a((babq)paramArrayList.next()));
    }
    paramArrayList = new ArrayList(new TreeSet(localArrayList));
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    for (;;)
    {
      paramArrayList = getString(2131697753, new Object[] { paramArrayList });
      bcql.a(getActivity(), paramArrayList, 0).a();
      return;
      if (paramArrayList.size() == 1) {
        paramArrayList = (String)paramArrayList.get(0);
      } else {
        paramArrayList = (String)paramArrayList.get(0) + "、" + (String)paramArrayList.get(1) + ajya.a(2131708845);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    String str = paramJSONObject.optString("exam_id");
    paramJSONObject = paramJSONObject.optString("title");
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramJSONObject);
    this.n = true;
    this.jdField_c_of_type_Int = Integer.valueOf(str).intValue();
    if (this.jdField_a_of_type_Azvn.jdField_c_of_type_Long != 0L) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(a(this.jdField_a_of_type_Azvn.jdField_c_of_type_Long));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      View localView = this.jdField_b_of_type_AndroidViewView;
      if (this.jdField_a_of_type_Boolean) {}
      for (int i1 = 0;; i1 = 8)
      {
        localView.setVisibility(i1);
        this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Azxt.postDelayed(new PublishHomeWorkFragment.20(this), 20L);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
    ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.19(this), 10L);
    a(paramBoolean);
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (paramInt = 8;; paramInt = 0)
    {
      localView.setVisibility(paramInt);
      if (azws.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      return;
    }
  }
  
  boolean a()
  {
    boolean bool2 = true;
    boolean bool1;
    try
    {
      Object localObject = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a());
      int i1 = ((JSONArray)localObject).length();
      if (i1 <= 0) {
        return true;
      }
      if (i1 == 1)
      {
        localObject = ((JSONArray)localObject).getJSONObject(0);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).getString("type");
          bool1 = bool2;
          if (TextUtils.isEmpty(str)) {
            return bool1;
          }
          if ("str".equals(str))
          {
            boolean bool3 = TextUtils.isEmpty(((JSONObject)localObject).getString("text"));
            bool1 = bool2;
            if (bool3) {
              return bool1;
            }
          }
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      bool1 = false;
    }
    return bool1;
  }
  
  protected boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    String str;
    do
    {
      return false;
      str = paramJSONObject.optString("type");
    } while ((TextUtils.isEmpty(str)) || (("str".equals(str)) && (TextUtils.isEmpty(paramJSONObject.optString("text")))));
    return true;
  }
  
  protected void b()
  {
    if (this.mContentView == null) {}
    label576:
    label584:
    label591:
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidViewView = a(2131372139);
      this.jdField_c_of_type_AndroidViewView = a(2131377793);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard = ((InputMethodGuard)a(2131368209));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getActivity().getLayoutInflater().inflate(2131560347, null, false));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372128));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)a(2131372138));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_b_of_type_AndroidViewView = a(2131363389);
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376375));
      this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376374));
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376373));
      this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364552));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131372134));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131372141));
      label233:
      View localView;
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
      {
        if (this.n) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        }
      }
      else
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131372135));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnClickListener(this);
        this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new azxn(this));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131377794));
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
          if (!this.n) {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131377803));
        this.jdField_d_of_type_AndroidViewView = a(2131377801);
        if (this.jdField_d_of_type_AndroidViewView != null) {
          this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        }
        if (this.jdField_a_of_type_Int == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.setOnInputMethodChangeListener(this);
        localView = a(2131372136);
        if (localView != null) {
          localView.setOnClickListener(this);
        }
        localView = a(2131372145);
        if (localView != null) {
          localView.setOnClickListener(this);
        }
        localView = a(2131372146);
        if (localView != null) {
          localView.setOnClickListener(this);
        }
        localView = a(2131372143);
        azwp localazwp = (azwp)ampl.a().a(605);
        if (localView != null)
        {
          if (!localazwp.a()) {
            break label584;
          }
          localView.setVisibility(0);
          localView.setOnClickListener(this);
          if (this.jdField_a_of_type_Int != 1) {
            break label576;
          }
          localView.setClickable(true);
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (this.jdField_a_of_type_Azyf != null) {
            break label591;
          }
          try
          {
            o();
            if (!(this.jdField_a_of_type_Azyf.a() instanceof azye)) {
              break;
            }
            azye.a(this.jdField_a_of_type_Azyf, (azye)this.jdField_a_of_type_Azyf.a());
            return;
          }
          catch (Throwable localThrowable) {}
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        break label233;
        localView.setClickable(false);
        continue;
        localView.setVisibility(8);
      }
    }
  }
  
  protected void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onVideoBtnClick");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(1) + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(2) >= 10)
    {
      if (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 2000L)
      {
        bcql.a(getActivity(), ajya.a(2131708831) + 10 + ajya.a(2131708848), 0).a();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    int i1;
    if (Build.VERSION.SDK_INT >= 23) {
      if (getActivity().checkSelfPermission("android.permission.CAMERA") == 0) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 == 0)
      {
        getActivity().requestPermissions(new azxa(this), 3, new String[] { "android.permission.CAMERA" });
        return;
        i1 = 0;
      }
      else
      {
        this.jdField_c_of_type_JavaLangString = TroopHWJsPlugin.a(getActivity(), 260);
        bfni.a(getActivity());
        return;
        i1 = 1;
      }
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide");
    }
    if (TextUtils.isEmpty(paramString)) {}
    label300:
    do
    {
      do
      {
        for (;;)
        {
          return;
          azwm localazwm = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a;
          SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("PublishHomeWorkFragment:homework_troop", 0);
          if (localazwm != null) {
            if ((azws.jdField_a_of_type_JavaLangString.equals(paramString)) && (localazwm.jdField_a_of_type_Boolean))
            {
              try
              {
                if (!localSharedPreferences.getBoolean(a(4), true)) {
                  continue;
                }
                paramString = new File(new URL(localazwm.jdField_b_of_type_JavaLangString).getFile()).getName();
                paramString = new azwk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localazwm.jdField_b_of_type_JavaLangString, paramString, localazwm.jdField_c_of_type_JavaLangString);
                if (QLog.isColorLevel()) {
                  QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for recite");
                }
                paramString.a(this.jdField_a_of_type_Azxt, 4, true);
                return;
              }
              catch (Exception paramString) {}
              if (QLog.isColorLevel()) {
                QLog.d("PublishHomeWorkFragment", 2, "download manager init error ", paramString);
              }
            }
            else
            {
              if ((!azws.jdField_b_of_type_JavaLangString.equals(paramString)) || (!localazwm.jdField_b_of_type_Boolean)) {
                break label300;
              }
              try
              {
                if (localSharedPreferences.getBoolean(a(7), true))
                {
                  paramString = new File(new URL(localazwm.jdField_d_of_type_JavaLangString).getFile()).getName();
                  paramString = new azwk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localazwm.jdField_d_of_type_JavaLangString, paramString, localazwm.e);
                  if (QLog.isColorLevel()) {
                    QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for arithmetic");
                  }
                  paramString.a(this.jdField_a_of_type_Azxt, 7, true);
                  return;
                }
              }
              catch (Exception paramString) {}
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("PublishHomeWorkFragment", 2, "download manager init error ", paramString);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide course not match");
  }
  
  protected void c()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      String str = localBundle.getString("extra.GROUP_UIN");
      this.jdField_a_of_type_Int = localBundle.getInt("publish_homework_mode", 1);
      this.jdField_a_of_type_Long = localBundle.getLong("hw_id", 0L);
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_h_of_type_Boolean = localBundle.getBoolean("BeginnerGuideFragment:from_beginner_guide", false);
      }
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_b_of_type_JavaLangString = str;
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "uin: " + str);
        }
        e();
        a(8000L);
        if (this.jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_Akhp.d(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        }
        if (this.jdField_a_of_type_Int == 2)
        {
          if (this.jdField_a_of_type_Long > 0L)
          {
            a(2131697724);
            this.jdField_a_of_type_Akhp.a(this.jdField_a_of_type_Long);
          }
        }
        else {
          return;
        }
        bcql.a(getActivity(), 2131697749, 0).a();
        getActivity().finish();
        return;
      }
      bcql.a(getActivity(), 2131697749, 0).a();
      getActivity().finish();
      return;
    }
    bcql.a(getActivity(), 2131697749, 0).a();
    getActivity().finish();
  }
  
  protected void c(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onRecordBtnClick");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(3) >= 6)
    {
      if (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 2000L)
      {
        bcql.a(getActivity(), ajya.a(2131708833) + 6 + ajya.a(2131708840), 0).a();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    k();
  }
  
  protected void d()
  {
    setLeftButton(2131697707, new azxo(this));
    setRightButton(2131697721, new azxp(this));
    if (this.jdField_a_of_type_Int == 1) {
      setTitle(getResources().getString(2131697723));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new azxq(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setFocusChangeListener(new azxr(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setSizeLimit(500);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHint(getString(2131697716));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int == 1) {
        ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.9(this), 550L);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
      e();
      return;
      if (this.jdField_a_of_type_Int == 2) {
        setTitle(getResources().getString(2131697698));
      }
    }
  }
  
  protected void d(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onJumpToThridPartyHwk");
    }
    paramView = new Intent(getActivity(), QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder(((azwp)ampl.a().a(605)).a());
    localStringBuilder.append("?gc=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("&appid=").append("101036803");
    localStringBuilder.append("&_wwv=128&_wv=3");
    paramView.putExtra("url", localStringBuilder.toString());
    getActivity().startActivityForResult(paramView, 264);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    getActivity().getWindow().setSoftInputMode(16);
    a();
    c();
    b();
    d();
    if (BaseApplicationImpl.sProcessId != 9) {
      SubmitHomeWorkFragment.a(getActivity());
    }
  }
  
  public void e()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 513;
    this.jdField_a_of_type_Azxt.sendMessage(localMessage);
  }
  
  protected void e(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onJumpToThridPartyHwk");
    }
    paramView = ((azwp)ampl.a().a(605)).b();
    if (paramView.isEmpty()) {
      return;
    }
    paramView = new StringBuilder(paramView);
    paramView.append("?gc=").append(this.jdField_b_of_type_JavaLangString);
    paramView.append("&appid=").append("101036803");
    paramView.append("&examid=").append(this.jdField_c_of_type_Int);
    paramView.append("&_wwv=128&_wv=3");
    paramView = paramView.toString();
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramView);
    startActivity(localIntent);
  }
  
  public void f()
  {
    Object localObject;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Integer)((Pair)((Iterator)localObject).next()).first).intValue() != 1);
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.a());
        if ((this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 8) || (this.jdField_b_of_type_AndroidViewViewGroup.getHeight() <= 0))
        {
          localObject = Message.obtain();
          ((Message)localObject).what = 514;
          this.jdField_a_of_type_Azxt.sendMessageDelayed((Message)localObject, 100L);
        }
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
    }
  }
  
  protected void f(View paramView)
  {
    this.n = false;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  public void g()
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((Pair)localIterator.next());
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  protected void g(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onClickSelectTime");
    }
    if (this.jdField_a_of_type_Azyf == null) {}
    try
    {
      o();
      if ((this.jdField_a_of_type_Azyf.a() instanceof azye)) {
        azye.a(this.jdField_a_of_type_Azyf, (azye)this.jdField_a_of_type_Azyf.a());
      }
      this.jdField_a_of_type_Azyf.a();
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public int getContentLayoutId()
  {
    return 2131560348;
  }
  
  public void h()
  {
    Object localObject3 = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a());
    JSONArray localJSONArray = new JSONArray();
    int i2 = ((JSONArray)localObject3).length();
    String str;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      localObject1 = "";
      str = this.jdField_d_of_type_JavaLangString;
      if (this.jdField_a_of_type_Int != 1) {
        break label136;
      }
    }
    label136:
    for (Object localObject2 = "1";; localObject2 = "2")
    {
      bbbp.a("Grp_edu", "homework", "CreateHw_Sub", 0, 0, new String[] { localObject1, str, localObject2 });
      int i1 = 0;
      while (i1 < i2)
      {
        localObject1 = ((JSONArray)localObject3).optJSONObject(i1);
        if (a((JSONObject)localObject1)) {
          localJSONArray.put(localObject1);
        }
        i1 += 1;
      }
      localObject1 = this.jdField_b_of_type_JavaLangString;
      break;
    }
    if (localJSONArray.length() <= 0)
    {
      bcql.a(getActivity(), 2131697710, 0).a();
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_b_of_type_JavaLangString);
    }
    Object localObject1 = new azvn();
    ((azvn)localObject1).jdField_b_of_type_Long = 0L;
    ((azvn)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (TextUtils.isEmpty(((azvn)localObject1).jdField_a_of_type_JavaLangString.trim()))
    {
      bcql.a(getActivity(), 2131697711, 0).a();
      return;
    }
    if (!bbfj.g(getActivity()))
    {
      bcql.a(getActivity(), 0, 2131694608, 0).a();
      return;
    }
    try
    {
      ((azvn)localObject1).jdField_b_of_type_Long = Long.parseLong(getActivity().app.c());
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label493;
      }
      ((azvn)localObject1).jdField_a_of_type_Long = 0L;
      localObject2 = new ArrayList();
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((List)localObject2).add(Long.valueOf(Long.parseLong((String)((Iterator)localObject3).next())));
      }
      if (!this.jdField_e_of_type_Boolean) {
        break label394;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    label371:
    localJSONArray.put(new JSONObject("{\"type\":\"calculation\"}"));
    label394:
    if (this.n)
    {
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        break label516;
      }
      localJSONArray.put(this.jdField_a_of_type_OrgJsonJSONObject);
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("c", localJSONArray);
      ((azvn)localObject1).jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
      ((azvn)localObject1).jdField_b_of_type_JavaLangString = localJSONObject.toString();
      if (this.jdField_a_of_type_Int == 2)
      {
        ((azvn)localObject1).d = this.jdField_a_of_type_Long;
        ((azvn)localObject1).jdField_a_of_type_Boolean = this.jdField_a_of_type_Azvn.jdField_a_of_type_Boolean;
      }
      this.jdField_b_of_type_Azvn = ((azvn)localObject1);
      a((azvn)localObject1);
      return;
      label493:
      ((azvn)localObject1).jdField_a_of_type_Long = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      break;
      ((azvn)localObject1).jdField_a_of_type_JavaUtilList = localJSONObject;
      break label371;
      label516:
      localJSONObject = new JSONObject();
      localJSONObject.put("type", "exam");
      localJSONObject.put("exam_type", "1");
      localJSONObject.put("appid", "101036803");
      localJSONObject.put("exam_id", String.valueOf(this.jdField_c_of_type_Int));
      localJSONObject.put("course_name", this.jdField_g_of_type_JavaLangString);
      localJSONObject.put("exam_count", String.valueOf(this.jdField_e_of_type_Int));
      localJSONObject.put("title", this.jdField_h_of_type_JavaLangString);
      localJSONArray.put(localJSONObject);
    }
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label427;
      }
      str1 = "";
      str3 = this.jdField_d_of_type_JavaLangString;
      if (this.jdField_b_of_type_Azvn != null) {
        break label435;
      }
      localObject = "";
      label26:
      if (!this.jdField_d_of_type_Boolean) {
        break label498;
      }
      str2 = "1";
    }
    catch (Exception localException)
    {
      label128:
      label427:
      for (;;)
      {
        String str1;
        String str3;
        Object localObject;
        label89:
        label478:
        label486:
        continue;
        label177:
        label435:
        label470:
        label498:
        String str2 = "0";
      }
    }
    bbbp.a("Grp_edu", "homework", "CreateHw_Complete", 0, 0, new String[] { str1, str3, localObject, str2 });
    if (this.l)
    {
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "";
        bbbp.a("Grp_edu", "homework", "CreateHw_EditTitle", 0, 0, new String[] { localObject });
      }
    }
    else
    {
      if (this.n)
      {
        if (this.jdField_b_of_type_JavaLangString != null) {
          break label470;
        }
        localObject = "";
        bbbp.a("Grp_edu", "homework", "createHW_lele", 0, 0, new String[] { localObject });
      }
      if ((this.jdField_b_of_type_Azvn != null) && (this.jdField_b_of_type_Azvn.jdField_a_of_type_Boolean))
      {
        if (this.jdField_b_of_type_JavaLangString != null) {
          break label478;
        }
        localObject = "";
        bbbp.a("Grp_edu", "homework", "CreateHw_Sub_Open", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString });
      }
      if ((this.jdField_b_of_type_Azvn != null) && (this.jdField_b_of_type_Azvn.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_b_of_type_Azvn.jdField_a_of_type_JavaUtilList.isEmpty())) {
        if (this.jdField_b_of_type_JavaLangString != null) {
          break label486;
        }
      }
    }
    for (localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      bbbp.a("Grp_edu", "homework", "CreateHw_CopyGrp", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(this.jdField_b_of_type_Azvn.jdField_a_of_type_JavaUtilList.size()) });
      a(1, "CreateHw_Pic");
      a(2, "CreateHw_Video");
      a(3, "CreateHw_Voice");
      a(7, "CreateHw_Calculate");
      a(4, "CreateHw_Recite");
      bcql.a(getActivity(), 2131697722, 0).a();
      localObject = actj.a(new Intent(getActivity(), SplashActivity.class), new int[] { 2 });
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("uin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1);
      getActivity().startActivity((Intent)localObject);
      getActivity().overridePendingTransition(2130771990, 2130772280);
      return;
      str1 = this.jdField_b_of_type_JavaLangString;
      break;
      if (this.jdField_b_of_type_Azvn.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "";
        break label26;
      }
      localObject = this.jdField_b_of_type_Azvn.jdField_b_of_type_JavaLangString;
      break label26;
      localObject = this.jdField_b_of_type_JavaLangString;
      break label89;
      localObject = this.jdField_b_of_type_JavaLangString;
      break label128;
      localObject = this.jdField_b_of_type_JavaLangString;
      break label177;
    }
  }
  
  protected void j()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      HomeWorkTroopSelectorFragment.a(getActivity(), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_Bfpc == null)
    {
      this.jdField_a_of_type_Bfpc = bfpc.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2131559661, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Azxt);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setMinimumHeight((int)(axlk.jdField_b_of_type_Int * 0.3F));
      this.jdField_a_of_type_Bfpc.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
      this.jdField_a_of_type_Bfpc.e(50);
      this.jdField_a_of_type_Bfpc.a().setGravity(17);
      this.jdField_a_of_type_Bfpc.a(new azxf(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    this.jdField_a_of_type_Bfpc.c(true);
    bfni.a(getActivity());
    this.jdField_a_of_type_Bfpc.show();
  }
  
  public void l()
  {
    this.jdField_a_of_type_Bfpc.dismiss();
  }
  
  public void m()
  {
    this.jdField_a_of_type_Azxt.postDelayed(new PublishHomeWorkFragment.17(this), 400L);
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bcqf.dismiss();
      label24:
      this.jdField_a_of_type_Bcqf = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, new Object[] { "onActivityResult. requestCode=", Integer.valueOf(paramInt1), ", resultCode=", Integer.valueOf(paramInt2) });
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      if ((paramIntent != null) && (paramInt2 == 257))
      {
        paramInt1 = paramIntent.getIntExtra("HomeWorkConstants:homework_default_index_key", -2147483648);
        paramIntent = paramIntent.getStringExtra("HomeWorkConstants:homework_default_result_key");
        if (!TextUtils.isEmpty(paramIntent))
        {
          if (paramInt1 == -2147483648) {
            break label224;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramInt1, paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
          bool = false;
        }
      }
      for (;;)
      {
        a(paramIntent, bool);
        if ((!TextUtils.isEmpty(paramIntent)) && (QLog.isColorLevel())) {
          QLog.d("PublishHomeWorkFragment", 2, "提交新作业->" + paramIntent);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PublishHomeWorkFragment", 2, "return from entry");
        return;
        label224:
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(babh.a(paramIntent));
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
      }
      if (paramInt2 != -1) {
        continue;
      }
      if (!bbfj.d(getActivity()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "no network toast from capture");
        }
        bcql.a(getActivity(), 2131697484, 0).a();
        return;
      }
      bbef.a(getActivity(), this.jdField_c_of_type_JavaLangString);
      paramIntent = new babl(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramIntent);
      return;
      if ((paramIntent == null) || (paramInt2 != 262)) {
        continue;
      }
      Object localObject = paramIntent.getStringArrayListExtra("HomeWorkConstants:homework_async_uin_list_key");
      paramIntent = paramIntent.getStringArrayListExtra("HomeWorkConstants:homework_async_name_list_key");
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
      }
      if (paramIntent != null)
      {
        this.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_b_of_type_JavaUtilList.addAll(paramIntent);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {
        continue;
      }
      if (this.jdField_b_of_type_JavaUtilList.isEmpty())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
        return;
      }
      if (this.jdField_b_of_type_JavaUtilList.size() == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)this.jdField_b_of_type_JavaUtilList.get(0));
        return;
      }
      if (this.jdField_b_of_type_JavaUtilList.size() <= 1) {
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((String)this.jdField_b_of_type_JavaUtilList.get(0) + ajya.a(2131708843) + this.jdField_b_of_type_JavaUtilList.size() + ajya.a(2131708838));
      return;
      if (paramIntent == null) {
        continue;
      }
      paramIntent = paramIntent.getStringExtra("params");
      if (paramIntent.isEmpty()) {
        continue;
      }
      try
      {
        paramIntent = new JSONObject(paramIntent);
        if (paramIntent == null) {
          continue;
        }
        this.jdField_h_of_type_JavaLangString = paramIntent.optString("title");
        this.jdField_e_of_type_Int = paramIntent.optInt("num", 0);
        localObject = ajya.a(2131697683) + " (" + this.jdField_e_of_type_Int + ajya.a(2131697684) + ")\n" + ajya.a(2131697685) + "\n" + this.jdField_h_of_type_JavaLangString;
        this.jdField_g_of_type_JavaLangString = paramIntent.optString("course_name");
        this.jdField_c_of_type_Int = paramIntent.optInt("exam_id", -1);
      }
      catch (JSONException paramIntent)
      {
        try
        {
          paramIntent = new JSONObject();
          paramIntent.put("type", "str");
          paramIntent.put("text", localObject);
          localObject = new JSONArray();
          ((JSONArray)localObject).put(paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setDefaultContent();
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setDataByEdit((JSONArray)localObject);
          e();
          this.n = true;
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_h_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          if ((this.jdField_c_of_type_Long == 0L) && (this.jdField_a_of_type_Azyf != null))
          {
            paramIntent = (azye)this.jdField_a_of_type_Azyf.a();
            this.jdField_c_of_type_Long = azye.a();
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(a(this.jdField_c_of_type_Long));
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
          return;
          paramIntent = paramIntent;
          paramIntent = null;
        }
        catch (JSONException paramIntent)
        {
          for (;;)
          {
            paramIntent.printStackTrace();
          }
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (!a())
    {
      bbgu localbbgu = bbdj.a(getActivity(), 230);
      azxg localazxg = new azxg(this);
      if (this.jdField_a_of_type_Int == 1) {
        localbbgu.setMessage(2131697712);
      }
      for (;;)
      {
        localbbgu.setPositiveButton(2131697713, localazxg);
        localbbgu.setNegativeButton(2131697708, localazxg);
        localbbgu.show();
        return true;
        if (this.jdField_a_of_type_Int == 2) {
          localbbgu.setMessage(2131697695);
        }
      }
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131372136: 
      a(paramView);
      return;
    case 2131372145: 
      b(paramView);
      return;
    case 2131372146: 
      c(paramView);
      return;
    case 2131372134: 
      j();
      return;
    case 2131372143: 
      d(paramView);
      return;
    case 2131372141: 
      g(paramView);
      return;
    case 2131377794: 
      e(paramView);
      return;
    }
    f(paramView);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.jdField_a_of_type_Akil != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akil);
    }
    TroopHWJsPlugin.a();
    if (this.m)
    {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.m = false;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_Azxt.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (!this.i) {
      getActivity().overridePendingTransition(2130771990, 2130772280);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    switch (paramIntent.getIntExtra("HomeWorkConstants:homework_request_code_key", 0))
    {
    default: 
      return;
    }
    this.jdField_g_of_type_Boolean = baci.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor, paramIntent, this.jdField_g_of_type_Boolean);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      return;
    }
    this.jdField_a_of_type_Azxt.postDelayed(new PublishHomeWorkFragment.1(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */