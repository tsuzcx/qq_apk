package com.tencent.mobileqq.troop.homework.entry.ui;

import aekt;
import alpo;
import alzf;
import amab;
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
import aogj;
import azgq;
import bbtw;
import bbut;
import bbuv;
import bbuy;
import bbvb;
import bbvi;
import bbvj;
import bbvk;
import bbvl;
import bbvm;
import bbvn;
import bbvo;
import bbvp;
import bbvq;
import bbvr;
import bbvs;
import bbvt;
import bbvu;
import bbvv;
import bbvw;
import bbvx;
import bbvy;
import bbvz;
import bbwa;
import bbwb;
import bbwc;
import bbwn;
import bbwo;
import bbwx;
import bbzm;
import bbzo;
import bbzp;
import bbzq;
import bbzr;
import bbzu;
import bbzz;
import bcaa;
import bcar;
import bcgp;
import bckj;
import bckk;
import bclo;
import bdaj;
import bdcd;
import bdda;
import bddb;
import bdds;
import bdee;
import bdfq;
import bepp;
import bhoc;
import bhpy;
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
import com.tencent.mobileqq.widget.QQToast;
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
  implements View.OnClickListener, bbwx
{
  public int a;
  protected long a;
  protected alzf a;
  protected amab a;
  protected BroadcastReceiver a;
  protected View a;
  public ViewGroup a;
  public EditText a;
  protected RelativeLayout a;
  protected TextView a;
  protected bbtw a;
  protected bbwc a;
  public bbwo a;
  protected bepp a;
  public bhpy a;
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
  protected List<Pair<Integer, View>> a;
  protected JSONObject a;
  public boolean a;
  protected int b;
  protected long b;
  protected View b;
  protected ViewGroup b;
  protected bbtw b;
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
  protected String d;
  public boolean d;
  protected int e;
  protected ViewGroup e;
  protected String e;
  public boolean e;
  protected String f;
  public boolean f;
  protected String g;
  protected boolean g;
  protected String h;
  public boolean h;
  protected boolean i;
  public boolean j;
  protected boolean k;
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
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bbvt(this);
  }
  
  protected static View a(Context paramContext, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setClickable(true);
    localLinearLayout.setGravity(16);
    localLinearLayout.setBackgroundResource(2130843397);
    Object localObject = new LinearLayout.LayoutParams(-2, azgq.a(42.0F));
    ((LinearLayout.LayoutParams)localObject).setMargins(azgq.a(12.0F), 0, 0, 0);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setTextColor(Color.parseColor("#5E6379"));
    ((TextView)localObject).setTextSize(1, 14.0F);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setBackgroundColor(0);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(azgq.a(12.0F), 0, azgq.a(24.0F), 0);
    ((TextView)localObject).setLayoutParams(paramString);
    if (paramInt2 > 0)
    {
      paramContext = new ImageView(paramContext);
      paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext.setImageResource(paramInt2);
      paramString = new LinearLayout.LayoutParams(azgq.a(21.0F), azgq.a(21.0F));
      paramString.setMargins(azgq.a(24.0F), 0, 0, 0);
      paramContext.setLayoutParams(paramString);
      localLinearLayout.addView(paramContext);
    }
    localLinearLayout.addView((View)localObject);
    localLinearLayout.setOnClickListener(paramOnClickListener);
    localLinearLayout.setTag(new bbwb(paramInt1, paramObject));
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
    paramContext.setPadding(azgq.a(12.0F), 0, azgq.a(12.0F), 0);
    paramString1 = new LinearLayout.LayoutParams(-1, -2);
    paramString1.setMargins(0, azgq.a(2.0F), 0, azgq.a(4.0F));
    paramContext.setLayoutParams(paramString1);
    paramContext.setText(paramString2);
    localLinearLayout.addView((View)localObject);
    localLinearLayout.addView(paramContext);
    localLinearLayout.setTag(new bbwb(paramInt, paramObject));
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
    bckj localbckj = bckj.a();
    Object localObject2 = localbckj.a("troop_create_homework");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://qun.qq.com/homework/features/sethomework.html?_wv=5123&_bid=2146#role=teacher&gid=<$GC>&content=<$CONTENT>&type=word&from=<$FROM>";
    }
    localObject2 = new bckk();
    ((bckk)localObject2).jdField_a_of_type_JavaLangString = paramString;
    ((bckk)localObject2).jdField_c_of_type_JavaLangString = "aio";
    ((bckk)localObject2).i = "";
    paramString = localbckj.a((String)localObject1, (bckk)localObject2);
    if (paramString != null)
    {
      if (!paramString.startsWith("mqqapi://")) {
        break label100;
      }
      paramQQAppInterface = bdds.a(paramQQAppInterface, paramContext, paramString);
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
    ((Activity)paramContext).overridePendingTransition(2130772292, 2130771990);
  }
  
  private boolean a(long paramLong)
  {
    long l1 = System.currentTimeMillis() / 1000L;
    if (this.jdField_a_of_type_Bbwo != null)
    {
      if (paramLong < l1 + 1L) {
        QQToast.a(getActivity(), 2131697909, 0).a();
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  private void c(bbtw parambbtw)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("homework_id", Long.toString(parambbtw.d));
    localBundle.putString("group_id", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("title", parambbtw.jdField_a_of_type_JavaLangString);
    String str1;
    String str2;
    if (parambbtw.jdField_a_of_type_Boolean)
    {
      str1 = "1";
      localBundle.putString("need_feedback", str1);
      localBundle.putString("c", parambbtw.jdField_b_of_type_JavaLangString);
      str2 = getActivity().app.c();
      parambbtw = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      if (parambbtw == null) {
        break label287;
      }
      str1 = parambbtw.getSkey(str2);
      parambbtw = parambbtw.getPskey(str2, "qun.qq.com");
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localBundle.putString("bkn", "" + bclo.b(str1));
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str1 + ";p_uin=o" + str2 + ";p_skey=" + parambbtw);
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new bcgp("https://qun.qq.com/cgi-bin/homework/hw/modify_hw.fcg", "POST", new bbvu(this), 1000, null).a(localHashMap);
      return;
      str1 = "0";
      break;
      label287:
      parambbtw = null;
      str1 = null;
    }
  }
  
  private void d(bbtw parambbtw)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("group_id", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("course_id", "0");
    if (!this.jdField_a_of_type_JavaLangString.isEmpty())
    {
      localBundle.putString("course_name", this.jdField_a_of_type_JavaLangString);
      localBundle.putString("title", parambbtw.jdField_a_of_type_JavaLangString);
      if (!parambbtw.jdField_a_of_type_Boolean) {
        break label236;
      }
    }
    int i1;
    label236:
    for (String str1 = "1";; str1 = "0")
    {
      localBundle.putString("need_feedback", str1);
      localBundle.putString("c", parambbtw.jdField_b_of_type_JavaLangString);
      localBundle.putString("team_id", "0");
      localBundle.putString("hw_type", "0");
      localBundle.putString("tsfeedback", String.valueOf(this.jdField_c_of_type_Long));
      if ((parambbtw.jdField_a_of_type_JavaUtilList == null) || (parambbtw.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label287;
      }
      str1 = "[";
      i1 = 0;
      while (i1 < parambbtw.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        str1 = str1 + String.valueOf(parambbtw.jdField_a_of_type_JavaUtilList.get(i1)) + ",";
        i1 += 1;
      }
      localBundle.putString("course_name", alpo.a(2131697857));
      break;
    }
    localBundle.putString("syncgids", str1 + String.valueOf(parambbtw.jdField_a_of_type_JavaUtilList.get(i1)) + "]");
    label287:
    String str2 = getActivity().app.c();
    parambbtw = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (parambbtw != null)
    {
      str1 = parambbtw.getSkey(str2);
      parambbtw = parambbtw.getPskey(str2, "qun.qq.com");
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localBundle.putString("bkn", "" + bclo.b(str1));
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str1 + ";p_uin=o" + str2 + ";p_skey=" + parambbtw);
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new bcgp("https://qun.qq.com/cgi-bin/homework/hw/assign_hw.fcg", "POST", new bbvv(this), 1000, null).a(localHashMap);
      return;
      parambbtw = null;
      str1 = null;
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_Bbwo = bbwn.a(getActivity());
    this.jdField_a_of_type_Bbwo.a(new bbvk(this));
    this.jdField_a_of_type_Bbwo.a(new bbvl(this));
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
    return String.valueOf(i1) + alpo.a(2131697911) + String.valueOf(i2 + 1) + alpo.a(2131697910) + String.valueOf(i3) + alpo.a(2131697908) + " " + (String)localObject1 + ":" + (String)localObject2;
  }
  
  List<View> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair != null) && (localPair.second != null) && (((View)localPair.second).getTag() != null) && ((((View)localPair.second).getTag() instanceof bbwb)) && (((bbwb)((View)localPair.second).getTag()).jdField_a_of_type_Int == paramInt)) {
        localArrayList.add(localPair.second);
      }
    }
    return localArrayList;
  }
  
  @NonNull
  protected List<String> a(bbzz parambbzz)
  {
    ArrayList localArrayList = new ArrayList();
    if (parambbzz != null)
    {
      if (!(parambbzz instanceof bcaa)) {
        break label50;
      }
      localArrayList.add(alpo.a(2131709225) + "");
    }
    label50:
    do
    {
      return localArrayList;
      if ((parambbzz instanceof bbzu))
      {
        localArrayList.add(alpo.a(2131709208) + "");
        return localArrayList;
      }
      if ((parambbzz instanceof bbzo))
      {
        localArrayList.add(alpo.a(2131709214) + "");
        return localArrayList;
      }
      if ((parambbzz instanceof bbzm))
      {
        localArrayList.add(alpo.a(2131709218) + "");
        return localArrayList;
      }
    } while (!(parambbzz instanceof bbzr));
    localArrayList.add(alpo.a(2131709222) + "");
    return localArrayList;
  }
  
  List<Pair<Integer, View>> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a != null))
    {
      if (!bbvb.jdField_a_of_type_JavaLangString.equals(paramString)) {
        break label110;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "add special entry for recite");
        }
        localArrayList.add(new Pair(Integer.valueOf(1), a(getActivity(), 4, alpo.a(2131709204), 2130840146, new bbvr(this), null)));
      }
    }
    label110:
    while ((!bbvb.jdField_b_of_type_JavaLangString.equals(paramString)) || (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_b_of_type_Boolean)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "add special entry for arithmetic");
    }
    localArrayList.add(new Pair(Integer.valueOf(2), a(getActivity(), 7, alpo.a(2131709226), alpo.a(2131709213), new bbvs(this), null)));
    return localArrayList;
  }
  
  protected void a()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bbwc = new bbwc(this, Looper.getMainLooper());
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
      this.jdField_a_of_type_Alzf = ((alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
      this.jdField_a_of_type_Amab = new bbvq(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
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
        if (this.jdField_a_of_type_Bepp == null)
        {
          this.jdField_a_of_type_Bepp = new bepp(getActivity(), getActivity().getTitleBarHeight());
          this.jdField_a_of_type_Bepp.setCancelable(false);
          this.jdField_a_of_type_Bepp.show();
        }
        this.jdField_a_of_type_Bepp.c(paramInt);
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
        bdaj.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, "1", "{\"type\":\"calculation\"}" });
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
        bbzp localbbzp = (bbzp)((Iterator)localObject).next();
        if (localbbzp != null) {
          localJSONArray.put(localbbzp.a());
        }
      }
    } while (localArrayList.isEmpty());
    if (this.jdField_b_of_type_JavaLangString == null) {}
    for (Object localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      bdaj.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(localArrayList.size()), localJSONArray.toString() });
      return;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    label63:
    String str2;
    switch (paramInt)
    {
    default: 
      this.jdField_d_of_type_JavaLangString = "";
      this.k = false;
      this.jdField_e_of_type_JavaLangString = paramString1;
      this.f = paramString2;
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        paramString2 = "";
        str2 = this.jdField_d_of_type_JavaLangString;
        if (!this.k) {
          break label212;
        }
        if (this.jdField_e_of_type_JavaLangString != null) {
          break label204;
        }
        paramString1 = "";
        label86:
        if (this.jdField_a_of_type_Int != 1) {
          break label233;
        }
      }
      break;
    }
    label204:
    label212:
    label233:
    for (String str1 = "1";; str1 = "2")
    {
      bdaj.a("Grp_edu", "homework", "CreateHw_Show", 0, 0, new String[] { paramString2, str2, paramString1, str1 });
      return;
      this.jdField_d_of_type_JavaLangString = "classteacher";
      this.k = true;
      break;
      this.jdField_d_of_type_JavaLangString = "teacher";
      this.k = true;
      break;
      this.jdField_d_of_type_JavaLangString = "parent";
      this.k = false;
      break;
      this.jdField_d_of_type_JavaLangString = "student";
      this.k = false;
      break;
      paramString2 = this.jdField_b_of_type_JavaLangString;
      break label63;
      paramString1 = this.jdField_e_of_type_JavaLangString;
      break label86;
      if (this.f == null)
      {
        paramString1 = "";
        break label86;
      }
      paramString1 = this.f;
      break label86;
    }
  }
  
  protected void a(int paramInt, ArrayList<bbzz> paramArrayList, bbtw parambbtw)
  {
    if (paramInt == 0)
    {
      parambbtw = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        parambbtw.addAll(a((bbzz)localIterator.next()));
      }
      parambbtw = new ArrayList(new TreeSet(parambbtw));
      if (parambbtw.isEmpty())
      {
        parambbtw = "";
        if (this.jdField_b_of_type_Int != 0) {
          break label277;
        }
        this.jdField_b_of_type_Int += 1;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList.isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramArrayList);
        }
        paramArrayList = getString(2131697930, new Object[] { parambbtw });
        QQToast.a(getActivity(), paramArrayList, 0).a();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "Error, reason_code = " + paramInt + ", print trace: ", new RuntimeException("UPLOAD_ERROR"));
      }
      return;
      if (parambbtw.size() == 1)
      {
        parambbtw = (String)parambbtw.get(0);
        break;
      }
      parambbtw = (String)parambbtw.get(0) + "、" + (String)parambbtw.get(1) + alpo.a(2131709206);
      break;
      label277:
      paramArrayList = getString(2131697928, new Object[] { parambbtw });
      QQToast.a(getActivity(), paramArrayList, 0).a();
      continue;
      if (paramInt == 1) {
        QQToast.a(getActivity(), 2131697892, 0).a();
      } else if (paramInt == 3) {
        QQToast.a(getActivity(), 2131697924, 0).a();
      } else if (paramInt == 2) {
        QQToast.a(getActivity(), 2131694775, 0).a();
      }
    }
  }
  
  protected void a(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 515;
    this.jdField_a_of_type_Bbwc.sendMessageDelayed(localMessage, paramLong);
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
        QQToast.a(getActivity(), alpo.a(2131709207) + 10 + alpo.a(2131709211), 0).a();
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
        getActivity().requestPermissions(new bbvi(this, i2), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i1 = 0;
      }
      else
      {
        paramView = TroopHWJsPlugin.a(10 - i2, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
        startActivityForResult(paramView, 259);
        bhoc.a(getActivity());
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
        QQToast.a(getActivity(), 0, alpo.a(2131709202), 1).a();
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
      bdfq localbdfq = bdcd.a(getActivity(), 230);
      localbdfq.setMessage(alpo.a(2131709221)).setNegativeButton(alpo.a(2131709224), new bbvn(this)).setPositiveButton(alpo.a(2131709219), new bbvm(this, (FormSwitchItem)localObject, paramCompoundButton));
      this.jdField_d_of_type_Boolean = true;
      paramCompoundButton.setChecked(true);
      localbdfq.show();
      return;
    }
  }
  
  public void a(bbtw parambbtw)
  {
    int i1 = 0;
    this.jdField_a_of_type_Bbtw = parambbtw;
    parambbtw = parambbtw.jdField_b_of_type_JavaLangString;
    try
    {
      parambbtw = new JSONObject(parambbtw).getJSONArray("c");
      for (;;)
      {
        if (i1 < parambbtw.length())
        {
          JSONObject localJSONObject = parambbtw.getJSONObject(i1);
          if (localJSONObject != null)
          {
            String str1 = localJSONObject.optString("type");
            String str2 = localJSONObject.optString("exam_type");
            if ((str1.equals("exam")) && (str2 != null) && (!str2.equals("0"))) {
              a(localJSONObject);
            }
          }
        }
        else
        {
          a(new JSONObject().put("c", parambbtw).toString());
          if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().isEmpty()))
          {
            this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_Bbtw.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
            this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
          }
          return;
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception parambbtw) {}
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
  
  protected void a(String paramString)
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
    bhoc.a(getActivity());
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
  
  protected void a(@NonNull ArrayList<bbzz> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.addAll(a((bbzz)paramArrayList.next()));
    }
    paramArrayList = new ArrayList(new TreeSet(localArrayList));
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    for (;;)
    {
      paramArrayList = getString(2131697930, new Object[] { paramArrayList });
      QQToast.a(getActivity(), paramArrayList, 0).a();
      return;
      if (paramArrayList.size() == 1) {
        paramArrayList = (String)paramArrayList.get(0);
      } else {
        paramArrayList = (String)paramArrayList.get(0) + "、" + (String)paramArrayList.get(1) + alpo.a(2131709217);
      }
    }
  }
  
  protected void a(JSONObject paramJSONObject)
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
    if (this.jdField_a_of_type_Bbtw.jdField_c_of_type_Long != 0L) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(a(this.jdField_a_of_type_Bbtw.jdField_c_of_type_Long));
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
    this.jdField_a_of_type_Bbwc.postDelayed(new PublishHomeWorkFragment.20(this), 20L);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      j();
      return;
    }
    if (paramInt == 10022)
    {
      a(1, null, null);
      return;
    }
    if (paramInt == 1002)
    {
      a(2, null, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: server error " + paramInt);
    }
    a(3, null, null);
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
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "检测到你是" + this.jdField_a_of_type_JavaLangString + "老师，将按照需求定制入口");
      }
      List localList = a(this.jdField_a_of_type_JavaLangString);
      if (localList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(localList);
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
        QQToast.a(getActivity(), alpo.a(2131709203) + 10 + alpo.a(2131709220), 0).a();
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
        getActivity().requestPermissions(new bbvj(this), 3, new String[] { "android.permission.CAMERA" });
        return;
        i1 = 0;
      }
      else
      {
        this.jdField_c_of_type_JavaLangString = TroopHWJsPlugin.a(getActivity(), 260);
        bhoc.a(getActivity());
        return;
        i1 = 1;
      }
    }
  }
  
  protected void b(bbtw parambbtw)
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
        bbzz localbbzz = (bbzz)((Iterator)localObject).next();
        if (localbbzz != null) {
          if (localbbzz.e() == 1) {
            localArrayList1.add(localbbzz);
          } else if ((localbbzz.e() == 2) || (localbbzz.e() == 0)) {
            localArrayList2.add(localbbzz);
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
        a(0, localArrayList2, parambbtw);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: unknown error list");
      }
      a(3, localArrayList2, parambbtw);
      return;
      if (parambbtw == null) {
        break;
      }
      a(2131697907);
      if (this.jdField_a_of_type_Int == 1)
      {
        d(parambbtw);
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    c(parambbtw);
    return;
    if (QLog.isColorLevel()) {
      QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: homework info is null");
    }
    a(3, null, parambbtw);
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
          bbuv localbbuv = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a;
          SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("PublishHomeWorkFragment:homework_troop", 0);
          if (localbbuv != null) {
            if ((bbvb.jdField_a_of_type_JavaLangString.equals(paramString)) && (localbbuv.jdField_a_of_type_Boolean))
            {
              try
              {
                if (!localSharedPreferences.getBoolean(a(4), true)) {
                  continue;
                }
                paramString = new File(new URL(localbbuv.jdField_b_of_type_JavaLangString).getFile()).getName();
                paramString = new bbut(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbbuv.jdField_b_of_type_JavaLangString, paramString, localbbuv.jdField_c_of_type_JavaLangString);
                if (QLog.isColorLevel()) {
                  QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for recite");
                }
                paramString.a(this.jdField_a_of_type_Bbwc, 4, true);
                return;
              }
              catch (Exception paramString) {}
              if (QLog.isColorLevel()) {
                QLog.d("PublishHomeWorkFragment", 2, "download manager init error ", paramString);
              }
            }
            else
            {
              if ((!bbvb.jdField_b_of_type_JavaLangString.equals(paramString)) || (!localbbuv.jdField_b_of_type_Boolean)) {
                break label300;
              }
              try
              {
                if (localSharedPreferences.getBoolean(a(7), true))
                {
                  paramString = new File(new URL(localbbuv.jdField_d_of_type_JavaLangString).getFile()).getName();
                  paramString = new bbut(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbbuv.jdField_d_of_type_JavaLangString, paramString, localbbuv.jdField_e_of_type_JavaLangString);
                  if (QLog.isColorLevel()) {
                    QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for arithmetic");
                  }
                  paramString.a(this.jdField_a_of_type_Bbwc, 7, true);
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
  
  public void b(boolean paramBoolean, int paramInt)
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
      if (bbvb.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      return;
    }
  }
  
  protected void c()
  {
    if (this.mContentView == null) {}
    label576:
    label584:
    label591:
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidViewView = a(2131372457);
      this.jdField_c_of_type_AndroidViewView = a(2131378337);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard = ((InputMethodGuard)a(2131368355));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getActivity().getLayoutInflater().inflate(2131560455, null, false));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372446));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)a(2131372456));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_b_of_type_AndroidViewView = a(2131363428);
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376879));
      this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376878));
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376877));
      this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364627));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131372452));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131372459));
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131372453));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnClickListener(this);
        this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new bbvw(this));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131378338));
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
          if (!this.n) {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378347));
        this.jdField_d_of_type_AndroidViewView = a(2131378345);
        if (this.jdField_d_of_type_AndroidViewView != null) {
          this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        }
        if (this.jdField_a_of_type_Int == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.setOnInputMethodChangeListener(this);
        localView = a(2131372454);
        if (localView != null) {
          localView.setOnClickListener(this);
        }
        localView = a(2131372463);
        if (localView != null) {
          localView.setOnClickListener(this);
        }
        localView = a(2131372469);
        if (localView != null) {
          localView.setOnClickListener(this);
        }
        localView = a(2131372461);
        bbuy localbbuy = (bbuy)aogj.a().a(605);
        if (localView != null)
        {
          if (!localbbuy.a()) {
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
          if (this.jdField_a_of_type_Bbwo != null) {
            break label591;
          }
          try
          {
            p();
            if (!(this.jdField_a_of_type_Bbwo.a() instanceof bbwn)) {
              break;
            }
            bbwn.a(this.jdField_a_of_type_Bbwo, (bbwn)this.jdField_a_of_type_Bbwo.a());
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
  
  protected void c(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onRecordBtnClick");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(3) >= 6)
    {
      if (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 2000L)
      {
        QQToast.a(getActivity(), alpo.a(2131709205) + 6 + alpo.a(2131709212), 0).a();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    l();
  }
  
  protected void d()
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
        f();
        a(8000L);
        if (this.jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_Alzf.d(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        }
        if (this.jdField_a_of_type_Int == 2)
        {
          if (this.jdField_a_of_type_Long > 0L)
          {
            a(2131697901);
            this.jdField_a_of_type_Alzf.a(this.jdField_a_of_type_Long);
          }
        }
        else {
          return;
        }
        QQToast.a(getActivity(), 2131697926, 0).a();
        getActivity().finish();
        return;
      }
      QQToast.a(getActivity(), 2131697926, 0).a();
      getActivity().finish();
      return;
    }
    QQToast.a(getActivity(), 2131697926, 0).a();
    getActivity().finish();
  }
  
  protected void d(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onJumpToThridPartyHwk");
    }
    paramView = new Intent(getActivity(), QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder(((bbuy)aogj.a().a(605)).a());
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
    d();
    c();
    e();
    if (BaseApplicationImpl.sProcessId != 9) {
      SubmitHomeWorkFragment.a(getActivity());
    }
  }
  
  protected void e()
  {
    setLeftButton(2131697884, new bbvx(this));
    setRightButton(2131697898, new bbvy(this));
    if (this.jdField_a_of_type_Int == 1) {
      setTitle(getResources().getString(2131697900));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bbvz(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setFocusChangeListener(new bbwa(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setSizeLimit(500);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHint(getString(2131697893));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int == 1) {
        ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.9(this), 550L);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
      f();
      return;
      if (this.jdField_a_of_type_Int == 2) {
        setTitle(getResources().getString(2131697873));
      }
    }
  }
  
  protected void e(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onJumpToThridPartyHwk");
    }
    paramView = ((bbuy)aogj.a().a(605)).b();
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
    Message localMessage = Message.obtain();
    localMessage.what = 513;
    this.jdField_a_of_type_Bbwc.sendMessage(localMessage);
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
          this.jdField_a_of_type_Bbwc.sendMessageDelayed((Message)localObject, 100L);
        }
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
    }
  }
  
  protected void g(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onClickSelectTime");
    }
    if (this.jdField_a_of_type_Bbwo == null) {}
    try
    {
      p();
      if ((this.jdField_a_of_type_Bbwo.a() instanceof bbwn)) {
        bbwn.a(this.jdField_a_of_type_Bbwo, (bbwn)this.jdField_a_of_type_Bbwo.a());
      }
      this.jdField_a_of_type_Bbwo.a();
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public int getContentLayoutId()
  {
    return 2131560456;
  }
  
  public void h()
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
  
  public void i()
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
      bdaj.a("Grp_edu", "homework", "CreateHw_Sub", 0, 0, new String[] { localObject1, str, localObject2 });
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
      QQToast.a(getActivity(), 2131697887, 0).a();
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_b_of_type_JavaLangString);
    }
    Object localObject1 = new bbtw();
    ((bbtw)localObject1).jdField_b_of_type_Long = 0L;
    ((bbtw)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (TextUtils.isEmpty(((bbtw)localObject1).jdField_a_of_type_JavaLangString.trim()))
    {
      QQToast.a(getActivity(), 2131697888, 0).a();
      return;
    }
    if (!bdee.g(getActivity()))
    {
      QQToast.a(getActivity(), 0, 2131694764, 0).a();
      return;
    }
    try
    {
      ((bbtw)localObject1).jdField_b_of_type_Long = Long.parseLong(getActivity().app.c());
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label493;
      }
      ((bbtw)localObject1).jdField_a_of_type_Long = 0L;
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
      ((bbtw)localObject1).jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
      ((bbtw)localObject1).jdField_b_of_type_JavaLangString = localJSONObject.toString();
      if (this.jdField_a_of_type_Int == 2)
      {
        ((bbtw)localObject1).d = this.jdField_a_of_type_Long;
        ((bbtw)localObject1).jdField_a_of_type_Boolean = this.jdField_a_of_type_Bbtw.jdField_a_of_type_Boolean;
      }
      this.jdField_b_of_type_Bbtw = ((bbtw)localObject1);
      b((bbtw)localObject1);
      return;
      label493:
      ((bbtw)localObject1).jdField_a_of_type_Long = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      break;
      ((bbtw)localObject1).jdField_a_of_type_JavaUtilList = localJSONObject;
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
  
  public void j()
  {
    try
    {
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label427;
      }
      str1 = "";
      str3 = this.jdField_d_of_type_JavaLangString;
      if (this.jdField_b_of_type_Bbtw != null) {
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
    bdaj.a("Grp_edu", "homework", "CreateHw_Complete", 0, 0, new String[] { str1, str3, localObject, str2 });
    if (this.l)
    {
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "";
        bdaj.a("Grp_edu", "homework", "CreateHw_EditTitle", 0, 0, new String[] { localObject });
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
        bdaj.a("Grp_edu", "homework", "createHW_lele", 0, 0, new String[] { localObject });
      }
      if ((this.jdField_b_of_type_Bbtw != null) && (this.jdField_b_of_type_Bbtw.jdField_a_of_type_Boolean))
      {
        if (this.jdField_b_of_type_JavaLangString != null) {
          break label478;
        }
        localObject = "";
        bdaj.a("Grp_edu", "homework", "CreateHw_Sub_Open", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString });
      }
      if ((this.jdField_b_of_type_Bbtw != null) && (this.jdField_b_of_type_Bbtw.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_b_of_type_Bbtw.jdField_a_of_type_JavaUtilList.isEmpty())) {
        if (this.jdField_b_of_type_JavaLangString != null) {
          break label486;
        }
      }
    }
    for (localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      bdaj.a("Grp_edu", "homework", "CreateHw_CopyGrp", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(this.jdField_b_of_type_Bbtw.jdField_a_of_type_JavaUtilList.size()) });
      a(1, "CreateHw_Pic");
      a(2, "CreateHw_Video");
      a(3, "CreateHw_Voice");
      a(7, "CreateHw_Calculate");
      a(4, "CreateHw_Recite");
      QQToast.a(getActivity(), 2131697899, 0).a();
      localObject = aekt.a(new Intent(getActivity(), SplashActivity.class), new int[] { 2 });
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("uin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1);
      getActivity().startActivity((Intent)localObject);
      getActivity().overridePendingTransition(2130771990, 2130772294);
      return;
      str1 = this.jdField_b_of_type_JavaLangString;
      break;
      if (this.jdField_b_of_type_Bbtw.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "";
        break label26;
      }
      localObject = this.jdField_b_of_type_Bbtw.jdField_b_of_type_JavaLangString;
      break label26;
      localObject = this.jdField_b_of_type_JavaLangString;
      break label89;
      localObject = this.jdField_b_of_type_JavaLangString;
      break label128;
      localObject = this.jdField_b_of_type_JavaLangString;
      break label177;
    }
  }
  
  protected void k()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      HomeWorkTroopSelectorFragment.a(getActivity(), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_Bhpy == null)
    {
      this.jdField_a_of_type_Bhpy = bhpy.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2131559714, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Bbwc);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setMinimumHeight((int)(azgq.jdField_b_of_type_Int * 0.3F));
      this.jdField_a_of_type_Bhpy.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
      this.jdField_a_of_type_Bhpy.e(50);
      this.jdField_a_of_type_Bhpy.a().setGravity(17);
      this.jdField_a_of_type_Bhpy.a(new bbvo(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    this.jdField_a_of_type_Bhpy.c(true);
    bhoc.a(getActivity());
    this.jdField_a_of_type_Bhpy.show();
  }
  
  public void m()
  {
    this.jdField_a_of_type_Bhpy.dismiss();
  }
  
  public void n()
  {
    this.jdField_a_of_type_Bbwc.postDelayed(new PublishHomeWorkFragment.17(this), 400L);
  }
  
  public void o()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bepp.dismiss();
      label24:
      this.jdField_a_of_type_Bepp = null;
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
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(bbzq.a(paramIntent));
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
      }
      if (paramInt2 != -1) {
        continue;
      }
      if (!bdee.d(getActivity()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "no network toast from capture");
        }
        QQToast.a(getActivity(), 2131697659, 0).a();
        return;
      }
      bdda.a(getActivity(), this.jdField_c_of_type_JavaLangString);
      paramIntent = new bbzu(this.jdField_c_of_type_JavaLangString);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((String)this.jdField_b_of_type_JavaUtilList.get(0) + alpo.a(2131709215) + this.jdField_b_of_type_JavaUtilList.size() + alpo.a(2131709210));
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
        localObject = alpo.a(2131697858) + " (" + this.jdField_e_of_type_Int + alpo.a(2131697859) + ")\n" + alpo.a(2131697860) + "\n" + this.jdField_h_of_type_JavaLangString;
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
          f();
          this.n = true;
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_h_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          if ((this.jdField_c_of_type_Long == 0L) && (this.jdField_a_of_type_Bbwo != null))
          {
            paramIntent = (bbwn)this.jdField_a_of_type_Bbwo.a();
            this.jdField_c_of_type_Long = bbwn.a();
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
      bdfq localbdfq = bdcd.a(getActivity(), 230);
      bbvp localbbvp = new bbvp(this);
      if (this.jdField_a_of_type_Int == 1) {
        localbdfq.setMessage(2131697889);
      }
      for (;;)
      {
        localbdfq.setPositiveButton(2131697890, localbbvp);
        localbdfq.setNegativeButton(2131697885, localbbvp);
        localbdfq.show();
        return true;
        if (this.jdField_a_of_type_Int == 2) {
          localbdfq.setMessage(2131697870);
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
    case 2131372454: 
      a(paramView);
      return;
    case 2131372463: 
      b(paramView);
      return;
    case 2131372469: 
      c(paramView);
      return;
    case 2131372452: 
      k();
      return;
    case 2131372461: 
      d(paramView);
      return;
    case 2131372459: 
      g(paramView);
      return;
    case 2131378338: 
      e(paramView);
      return;
    }
    f(paramView);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.jdField_a_of_type_Amab != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
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
    this.jdField_a_of_type_Bbwc.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (!this.i) {
      getActivity().overridePendingTransition(2130771990, 2130772294);
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
    this.jdField_g_of_type_Boolean = bcar.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor, paramIntent, this.jdField_g_of_type_Boolean);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      return;
    }
    this.jdField_a_of_type_Bbwc.postDelayed(new PublishHomeWorkFragment.1(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */