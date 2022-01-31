package com.tencent.mobileqq.troop.homework.entry.ui;

import aepi;
import alud;
import amdu;
import ameq;
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
import aoks;
import azkz;
import bbyf;
import bbzc;
import bbze;
import bbzh;
import bbzk;
import bbzr;
import bbzs;
import bbzt;
import bbzu;
import bbzv;
import bbzw;
import bbzx;
import bbzy;
import bbzz;
import bcaa;
import bcab;
import bcac;
import bcad;
import bcae;
import bcaf;
import bcag;
import bcah;
import bcai;
import bcaj;
import bcak;
import bcal;
import bcaw;
import bcax;
import bcbg;
import bcdv;
import bcdx;
import bcdy;
import bcdz;
import bcea;
import bced;
import bcei;
import bcej;
import bcfa;
import bcky;
import bcos;
import bcot;
import bcpx;
import bdes;
import bdgm;
import bdhj;
import bdhk;
import bdib;
import bdin;
import bdjz;
import bety;
import bhsj;
import bhuf;
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
  implements View.OnClickListener, bcbg
{
  public int a;
  protected long a;
  protected amdu a;
  protected ameq a;
  protected BroadcastReceiver a;
  protected View a;
  public ViewGroup a;
  public EditText a;
  protected RelativeLayout a;
  protected TextView a;
  protected bbyf a;
  protected bcal a;
  public bcax a;
  protected bety a;
  public bhuf a;
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
  protected bbyf b;
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
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bcac(this);
  }
  
  protected static View a(Context paramContext, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setClickable(true);
    localLinearLayout.setGravity(16);
    localLinearLayout.setBackgroundResource(2130843410);
    Object localObject = new LinearLayout.LayoutParams(-2, azkz.a(42.0F));
    ((LinearLayout.LayoutParams)localObject).setMargins(azkz.a(12.0F), 0, 0, 0);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setTextColor(Color.parseColor("#5E6379"));
    ((TextView)localObject).setTextSize(1, 14.0F);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setBackgroundColor(0);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(azkz.a(12.0F), 0, azkz.a(24.0F), 0);
    ((TextView)localObject).setLayoutParams(paramString);
    if (paramInt2 > 0)
    {
      paramContext = new ImageView(paramContext);
      paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext.setImageResource(paramInt2);
      paramString = new LinearLayout.LayoutParams(azkz.a(21.0F), azkz.a(21.0F));
      paramString.setMargins(azkz.a(24.0F), 0, 0, 0);
      paramContext.setLayoutParams(paramString);
      localLinearLayout.addView(paramContext);
    }
    localLinearLayout.addView((View)localObject);
    localLinearLayout.setOnClickListener(paramOnClickListener);
    localLinearLayout.setTag(new bcak(paramInt1, paramObject));
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
    paramContext.setPadding(azkz.a(12.0F), 0, azkz.a(12.0F), 0);
    paramString1 = new LinearLayout.LayoutParams(-1, -2);
    paramString1.setMargins(0, azkz.a(2.0F), 0, azkz.a(4.0F));
    paramContext.setLayoutParams(paramString1);
    paramContext.setText(paramString2);
    localLinearLayout.addView((View)localObject);
    localLinearLayout.addView(paramContext);
    localLinearLayout.setTag(new bcak(paramInt, paramObject));
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
    bcos localbcos = bcos.a();
    Object localObject2 = localbcos.a("troop_create_homework");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://qun.qq.com/homework/features/sethomework.html?_wv=5123&_bid=2146#role=teacher&gid=<$GC>&content=<$CONTENT>&type=word&from=<$FROM>";
    }
    localObject2 = new bcot();
    ((bcot)localObject2).jdField_a_of_type_JavaLangString = paramString;
    ((bcot)localObject2).jdField_c_of_type_JavaLangString = "aio";
    ((bcot)localObject2).i = "";
    paramString = localbcos.a((String)localObject1, (bcot)localObject2);
    if (paramString != null)
    {
      if (!paramString.startsWith("mqqapi://")) {
        break label100;
      }
      paramQQAppInterface = bdib.a(paramQQAppInterface, paramContext, paramString);
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
    ((Activity)paramContext).overridePendingTransition(2130772293, 2130771990);
  }
  
  private boolean a(long paramLong)
  {
    long l1 = System.currentTimeMillis() / 1000L;
    if (this.jdField_a_of_type_Bcax != null)
    {
      if (paramLong < l1 + 1L) {
        QQToast.a(getActivity(), 2131697911, 0).a();
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  private void c(bbyf parambbyf)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("homework_id", Long.toString(parambbyf.d));
    localBundle.putString("group_id", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("title", parambbyf.jdField_a_of_type_JavaLangString);
    String str1;
    String str2;
    if (parambbyf.jdField_a_of_type_Boolean)
    {
      str1 = "1";
      localBundle.putString("need_feedback", str1);
      localBundle.putString("c", parambbyf.jdField_b_of_type_JavaLangString);
      str2 = getActivity().app.c();
      parambbyf = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      if (parambbyf == null) {
        break label287;
      }
      str1 = parambbyf.getSkey(str2);
      parambbyf = parambbyf.getPskey(str2, "qun.qq.com");
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localBundle.putString("bkn", "" + bcpx.b(str1));
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str1 + ";p_uin=o" + str2 + ";p_skey=" + parambbyf);
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new bcky("https://qun.qq.com/cgi-bin/homework/hw/modify_hw.fcg", "POST", new bcad(this), 1000, null).a(localHashMap);
      return;
      str1 = "0";
      break;
      label287:
      parambbyf = null;
      str1 = null;
    }
  }
  
  private void d(bbyf parambbyf)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("group_id", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("course_id", "0");
    if (!this.jdField_a_of_type_JavaLangString.isEmpty())
    {
      localBundle.putString("course_name", this.jdField_a_of_type_JavaLangString);
      localBundle.putString("title", parambbyf.jdField_a_of_type_JavaLangString);
      if (!parambbyf.jdField_a_of_type_Boolean) {
        break label236;
      }
    }
    int i1;
    label236:
    for (String str1 = "1";; str1 = "0")
    {
      localBundle.putString("need_feedback", str1);
      localBundle.putString("c", parambbyf.jdField_b_of_type_JavaLangString);
      localBundle.putString("team_id", "0");
      localBundle.putString("hw_type", "0");
      localBundle.putString("tsfeedback", String.valueOf(this.jdField_c_of_type_Long));
      if ((parambbyf.jdField_a_of_type_JavaUtilList == null) || (parambbyf.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label287;
      }
      str1 = "[";
      i1 = 0;
      while (i1 < parambbyf.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        str1 = str1 + String.valueOf(parambbyf.jdField_a_of_type_JavaUtilList.get(i1)) + ",";
        i1 += 1;
      }
      localBundle.putString("course_name", alud.a(2131697859));
      break;
    }
    localBundle.putString("syncgids", str1 + String.valueOf(parambbyf.jdField_a_of_type_JavaUtilList.get(i1)) + "]");
    label287:
    String str2 = getActivity().app.c();
    parambbyf = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (parambbyf != null)
    {
      str1 = parambbyf.getSkey(str2);
      parambbyf = parambbyf.getPskey(str2, "qun.qq.com");
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localBundle.putString("bkn", "" + bcpx.b(str1));
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str1 + ";p_uin=o" + str2 + ";p_skey=" + parambbyf);
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new bcky("https://qun.qq.com/cgi-bin/homework/hw/assign_hw.fcg", "POST", new bcae(this), 1000, null).a(localHashMap);
      return;
      parambbyf = null;
      str1 = null;
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_Bcax = bcaw.a(getActivity());
    this.jdField_a_of_type_Bcax.a(new bbzt(this));
    this.jdField_a_of_type_Bcax.a(new bbzu(this));
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
    return String.valueOf(i1) + alud.a(2131697913) + String.valueOf(i2 + 1) + alud.a(2131697912) + String.valueOf(i3) + alud.a(2131697910) + " " + (String)localObject1 + ":" + (String)localObject2;
  }
  
  List<View> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair != null) && (localPair.second != null) && (((View)localPair.second).getTag() != null) && ((((View)localPair.second).getTag() instanceof bcak)) && (((bcak)((View)localPair.second).getTag()).jdField_a_of_type_Int == paramInt)) {
        localArrayList.add(localPair.second);
      }
    }
    return localArrayList;
  }
  
  @NonNull
  protected List<String> a(bcei parambcei)
  {
    ArrayList localArrayList = new ArrayList();
    if (parambcei != null)
    {
      if (!(parambcei instanceof bcej)) {
        break label50;
      }
      localArrayList.add(alud.a(2131709237) + "");
    }
    label50:
    do
    {
      return localArrayList;
      if ((parambcei instanceof bced))
      {
        localArrayList.add(alud.a(2131709220) + "");
        return localArrayList;
      }
      if ((parambcei instanceof bcdx))
      {
        localArrayList.add(alud.a(2131709226) + "");
        return localArrayList;
      }
      if ((parambcei instanceof bcdv))
      {
        localArrayList.add(alud.a(2131709230) + "");
        return localArrayList;
      }
    } while (!(parambcei instanceof bcea));
    localArrayList.add(alud.a(2131709234) + "");
    return localArrayList;
  }
  
  List<Pair<Integer, View>> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a != null))
    {
      if (!bbzk.jdField_a_of_type_JavaLangString.equals(paramString)) {
        break label110;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "add special entry for recite");
        }
        localArrayList.add(new Pair(Integer.valueOf(1), a(getActivity(), 4, alud.a(2131709216), 2130840147, new bcaa(this), null)));
      }
    }
    label110:
    while ((!bbzk.jdField_b_of_type_JavaLangString.equals(paramString)) || (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_b_of_type_Boolean)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "add special entry for arithmetic");
    }
    localArrayList.add(new Pair(Integer.valueOf(2), a(getActivity(), 7, alud.a(2131709238), alud.a(2131709225), new bcab(this), null)));
    return localArrayList;
  }
  
  protected void a()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bcal = new bcal(this, Looper.getMainLooper());
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
      this.jdField_a_of_type_Amdu = ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
      this.jdField_a_of_type_Ameq = new bbzz(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ameq);
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
        if (this.jdField_a_of_type_Bety == null)
        {
          this.jdField_a_of_type_Bety = new bety(getActivity(), getActivity().getTitleBarHeight());
          this.jdField_a_of_type_Bety.setCancelable(false);
          this.jdField_a_of_type_Bety.show();
        }
        this.jdField_a_of_type_Bety.c(paramInt);
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
        bdes.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, "1", "{\"type\":\"calculation\"}" });
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
        bcdy localbcdy = (bcdy)((Iterator)localObject).next();
        if (localbcdy != null) {
          localJSONArray.put(localbcdy.a());
        }
      }
    } while (localArrayList.isEmpty());
    if (this.jdField_b_of_type_JavaLangString == null) {}
    for (Object localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      bdes.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(localArrayList.size()), localJSONArray.toString() });
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
      bdes.a("Grp_edu", "homework", "CreateHw_Show", 0, 0, new String[] { paramString2, str2, paramString1, str1 });
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
  
  protected void a(int paramInt, ArrayList<bcei> paramArrayList, bbyf parambbyf)
  {
    if (paramInt == 0)
    {
      parambbyf = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        parambbyf.addAll(a((bcei)localIterator.next()));
      }
      parambbyf = new ArrayList(new TreeSet(parambbyf));
      if (parambbyf.isEmpty())
      {
        parambbyf = "";
        if (this.jdField_b_of_type_Int != 0) {
          break label277;
        }
        this.jdField_b_of_type_Int += 1;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList.isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramArrayList);
        }
        paramArrayList = getString(2131697932, new Object[] { parambbyf });
        QQToast.a(getActivity(), paramArrayList, 0).a();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "Error, reason_code = " + paramInt + ", print trace: ", new RuntimeException("UPLOAD_ERROR"));
      }
      return;
      if (parambbyf.size() == 1)
      {
        parambbyf = (String)parambbyf.get(0);
        break;
      }
      parambbyf = (String)parambbyf.get(0) + "、" + (String)parambbyf.get(1) + alud.a(2131709218);
      break;
      label277:
      paramArrayList = getString(2131697930, new Object[] { parambbyf });
      QQToast.a(getActivity(), paramArrayList, 0).a();
      continue;
      if (paramInt == 1) {
        QQToast.a(getActivity(), 2131697894, 0).a();
      } else if (paramInt == 3) {
        QQToast.a(getActivity(), 2131697926, 0).a();
      } else if (paramInt == 2) {
        QQToast.a(getActivity(), 2131694777, 0).a();
      }
    }
  }
  
  protected void a(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 515;
    this.jdField_a_of_type_Bcal.sendMessageDelayed(localMessage, paramLong);
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
        QQToast.a(getActivity(), alud.a(2131709219) + 10 + alud.a(2131709223), 0).a();
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
        getActivity().requestPermissions(new bbzr(this, i2), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i1 = 0;
      }
      else
      {
        paramView = TroopHWJsPlugin.a(10 - i2, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
        startActivityForResult(paramView, 259);
        bhsj.a(getActivity());
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
        QQToast.a(getActivity(), 0, alud.a(2131709214), 1).a();
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
      bdjz localbdjz = bdgm.a(getActivity(), 230);
      localbdjz.setMessage(alud.a(2131709233)).setNegativeButton(alud.a(2131709236), new bbzw(this)).setPositiveButton(alud.a(2131709231), new bbzv(this, (FormSwitchItem)localObject, paramCompoundButton));
      this.jdField_d_of_type_Boolean = true;
      paramCompoundButton.setChecked(true);
      localbdjz.show();
      return;
    }
  }
  
  public void a(bbyf parambbyf)
  {
    int i1 = 0;
    this.jdField_a_of_type_Bbyf = parambbyf;
    parambbyf = parambbyf.jdField_b_of_type_JavaLangString;
    try
    {
      parambbyf = new JSONObject(parambbyf).getJSONArray("c");
      for (;;)
      {
        if (i1 < parambbyf.length())
        {
          JSONObject localJSONObject = parambbyf.getJSONObject(i1);
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
          a(new JSONObject().put("c", parambbyf).toString());
          if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().isEmpty()))
          {
            this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_Bbyf.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
            this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
          }
          return;
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception parambbyf) {}
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
    bhsj.a(getActivity());
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
  
  protected void a(@NonNull ArrayList<bcei> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.addAll(a((bcei)paramArrayList.next()));
    }
    paramArrayList = new ArrayList(new TreeSet(localArrayList));
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    for (;;)
    {
      paramArrayList = getString(2131697932, new Object[] { paramArrayList });
      QQToast.a(getActivity(), paramArrayList, 0).a();
      return;
      if (paramArrayList.size() == 1) {
        paramArrayList = (String)paramArrayList.get(0);
      } else {
        paramArrayList = (String)paramArrayList.get(0) + "、" + (String)paramArrayList.get(1) + alud.a(2131709229);
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
    if (this.jdField_a_of_type_Bbyf.jdField_c_of_type_Long != 0L) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(a(this.jdField_a_of_type_Bbyf.jdField_c_of_type_Long));
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
    this.jdField_a_of_type_Bcal.postDelayed(new PublishHomeWorkFragment.20(this), 20L);
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
        QQToast.a(getActivity(), alud.a(2131709215) + 10 + alud.a(2131709232), 0).a();
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
        getActivity().requestPermissions(new bbzs(this), 3, new String[] { "android.permission.CAMERA" });
        return;
        i1 = 0;
      }
      else
      {
        this.jdField_c_of_type_JavaLangString = TroopHWJsPlugin.a(getActivity(), 260);
        bhsj.a(getActivity());
        return;
        i1 = 1;
      }
    }
  }
  
  protected void b(bbyf parambbyf)
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
        bcei localbcei = (bcei)((Iterator)localObject).next();
        if (localbcei != null) {
          if (localbcei.e() == 1) {
            localArrayList1.add(localbcei);
          } else if ((localbcei.e() == 2) || (localbcei.e() == 0)) {
            localArrayList2.add(localbcei);
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
        a(0, localArrayList2, parambbyf);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: unknown error list");
      }
      a(3, localArrayList2, parambbyf);
      return;
      if (parambbyf == null) {
        break;
      }
      a(2131697909);
      if (this.jdField_a_of_type_Int == 1)
      {
        d(parambbyf);
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    c(parambbyf);
    return;
    if (QLog.isColorLevel()) {
      QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: homework info is null");
    }
    a(3, null, parambbyf);
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
          bbze localbbze = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a;
          SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("PublishHomeWorkFragment:homework_troop", 0);
          if (localbbze != null) {
            if ((bbzk.jdField_a_of_type_JavaLangString.equals(paramString)) && (localbbze.jdField_a_of_type_Boolean))
            {
              try
              {
                if (!localSharedPreferences.getBoolean(a(4), true)) {
                  continue;
                }
                paramString = new File(new URL(localbbze.jdField_b_of_type_JavaLangString).getFile()).getName();
                paramString = new bbzc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbbze.jdField_b_of_type_JavaLangString, paramString, localbbze.jdField_c_of_type_JavaLangString);
                if (QLog.isColorLevel()) {
                  QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for recite");
                }
                paramString.a(this.jdField_a_of_type_Bcal, 4, true);
                return;
              }
              catch (Exception paramString) {}
              if (QLog.isColorLevel()) {
                QLog.d("PublishHomeWorkFragment", 2, "download manager init error ", paramString);
              }
            }
            else
            {
              if ((!bbzk.jdField_b_of_type_JavaLangString.equals(paramString)) || (!localbbze.jdField_b_of_type_Boolean)) {
                break label300;
              }
              try
              {
                if (localSharedPreferences.getBoolean(a(7), true))
                {
                  paramString = new File(new URL(localbbze.jdField_d_of_type_JavaLangString).getFile()).getName();
                  paramString = new bbzc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbbze.jdField_d_of_type_JavaLangString, paramString, localbbze.jdField_e_of_type_JavaLangString);
                  if (QLog.isColorLevel()) {
                    QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for arithmetic");
                  }
                  paramString.a(this.jdField_a_of_type_Bcal, 7, true);
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
      if (bbzk.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
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
      this.jdField_a_of_type_AndroidViewView = a(2131372477);
      this.jdField_c_of_type_AndroidViewView = a(2131378391);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard = ((InputMethodGuard)a(2131368366));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getActivity().getLayoutInflater().inflate(2131560454, null, false));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372466));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)a(2131372476));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_b_of_type_AndroidViewView = a(2131363428);
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376933));
      this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376932));
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376931));
      this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364629));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131372472));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131372479));
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131372473));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnClickListener(this);
        this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new bcaf(this));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131378392));
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
          if (!this.n) {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378401));
        this.jdField_d_of_type_AndroidViewView = a(2131378399);
        if (this.jdField_d_of_type_AndroidViewView != null) {
          this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        }
        if (this.jdField_a_of_type_Int == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.setOnInputMethodChangeListener(this);
        localView = a(2131372474);
        if (localView != null) {
          localView.setOnClickListener(this);
        }
        localView = a(2131372483);
        if (localView != null) {
          localView.setOnClickListener(this);
        }
        localView = a(2131372489);
        if (localView != null) {
          localView.setOnClickListener(this);
        }
        localView = a(2131372481);
        bbzh localbbzh = (bbzh)aoks.a().a(605);
        if (localView != null)
        {
          if (!localbbzh.a()) {
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
          if (this.jdField_a_of_type_Bcax != null) {
            break label591;
          }
          try
          {
            p();
            if (!(this.jdField_a_of_type_Bcax.a() instanceof bcaw)) {
              break;
            }
            bcaw.a(this.jdField_a_of_type_Bcax, (bcaw)this.jdField_a_of_type_Bcax.a());
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
        QQToast.a(getActivity(), alud.a(2131709217) + 6 + alud.a(2131709224), 0).a();
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
          this.jdField_a_of_type_Amdu.d(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        }
        if (this.jdField_a_of_type_Int == 2)
        {
          if (this.jdField_a_of_type_Long > 0L)
          {
            a(2131697903);
            this.jdField_a_of_type_Amdu.a(this.jdField_a_of_type_Long);
          }
        }
        else {
          return;
        }
        QQToast.a(getActivity(), 2131697928, 0).a();
        getActivity().finish();
        return;
      }
      QQToast.a(getActivity(), 2131697928, 0).a();
      getActivity().finish();
      return;
    }
    QQToast.a(getActivity(), 2131697928, 0).a();
    getActivity().finish();
  }
  
  protected void d(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onJumpToThridPartyHwk");
    }
    paramView = new Intent(getActivity(), QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder(((bbzh)aoks.a().a(605)).a());
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
    setLeftButton(2131697886, new bcag(this));
    setRightButton(2131697900, new bcah(this));
    if (this.jdField_a_of_type_Int == 1) {
      setTitle(getResources().getString(2131697902));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bcai(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setFocusChangeListener(new bcaj(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setSizeLimit(500);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHint(getString(2131697895));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int == 1) {
        ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.9(this), 550L);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
      f();
      return;
      if (this.jdField_a_of_type_Int == 2) {
        setTitle(getResources().getString(2131697875));
      }
    }
  }
  
  protected void e(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onJumpToThridPartyHwk");
    }
    paramView = ((bbzh)aoks.a().a(605)).b();
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
    this.jdField_a_of_type_Bcal.sendMessage(localMessage);
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
          this.jdField_a_of_type_Bcal.sendMessageDelayed((Message)localObject, 100L);
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
    if (this.jdField_a_of_type_Bcax == null) {}
    try
    {
      p();
      if ((this.jdField_a_of_type_Bcax.a() instanceof bcaw)) {
        bcaw.a(this.jdField_a_of_type_Bcax, (bcaw)this.jdField_a_of_type_Bcax.a());
      }
      this.jdField_a_of_type_Bcax.a();
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public int getContentLayoutId()
  {
    return 2131560455;
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
      bdes.a("Grp_edu", "homework", "CreateHw_Sub", 0, 0, new String[] { localObject1, str, localObject2 });
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
      QQToast.a(getActivity(), 2131697889, 0).a();
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_b_of_type_JavaLangString);
    }
    Object localObject1 = new bbyf();
    ((bbyf)localObject1).jdField_b_of_type_Long = 0L;
    ((bbyf)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (TextUtils.isEmpty(((bbyf)localObject1).jdField_a_of_type_JavaLangString.trim()))
    {
      QQToast.a(getActivity(), 2131697890, 0).a();
      return;
    }
    if (!bdin.g(getActivity()))
    {
      QQToast.a(getActivity(), 0, 2131694766, 0).a();
      return;
    }
    try
    {
      ((bbyf)localObject1).jdField_b_of_type_Long = Long.parseLong(getActivity().app.c());
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label493;
      }
      ((bbyf)localObject1).jdField_a_of_type_Long = 0L;
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
      ((bbyf)localObject1).jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
      ((bbyf)localObject1).jdField_b_of_type_JavaLangString = localJSONObject.toString();
      if (this.jdField_a_of_type_Int == 2)
      {
        ((bbyf)localObject1).d = this.jdField_a_of_type_Long;
        ((bbyf)localObject1).jdField_a_of_type_Boolean = this.jdField_a_of_type_Bbyf.jdField_a_of_type_Boolean;
      }
      this.jdField_b_of_type_Bbyf = ((bbyf)localObject1);
      b((bbyf)localObject1);
      return;
      label493:
      ((bbyf)localObject1).jdField_a_of_type_Long = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      break;
      ((bbyf)localObject1).jdField_a_of_type_JavaUtilList = localJSONObject;
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
      if (this.jdField_b_of_type_Bbyf != null) {
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
    bdes.a("Grp_edu", "homework", "CreateHw_Complete", 0, 0, new String[] { str1, str3, localObject, str2 });
    if (this.l)
    {
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "";
        bdes.a("Grp_edu", "homework", "CreateHw_EditTitle", 0, 0, new String[] { localObject });
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
        bdes.a("Grp_edu", "homework", "createHW_lele", 0, 0, new String[] { localObject });
      }
      if ((this.jdField_b_of_type_Bbyf != null) && (this.jdField_b_of_type_Bbyf.jdField_a_of_type_Boolean))
      {
        if (this.jdField_b_of_type_JavaLangString != null) {
          break label478;
        }
        localObject = "";
        bdes.a("Grp_edu", "homework", "CreateHw_Sub_Open", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString });
      }
      if ((this.jdField_b_of_type_Bbyf != null) && (this.jdField_b_of_type_Bbyf.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_b_of_type_Bbyf.jdField_a_of_type_JavaUtilList.isEmpty())) {
        if (this.jdField_b_of_type_JavaLangString != null) {
          break label486;
        }
      }
    }
    for (localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      bdes.a("Grp_edu", "homework", "CreateHw_CopyGrp", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(this.jdField_b_of_type_Bbyf.jdField_a_of_type_JavaUtilList.size()) });
      a(1, "CreateHw_Pic");
      a(2, "CreateHw_Video");
      a(3, "CreateHw_Voice");
      a(7, "CreateHw_Calculate");
      a(4, "CreateHw_Recite");
      QQToast.a(getActivity(), 2131697901, 0).a();
      localObject = aepi.a(new Intent(getActivity(), SplashActivity.class), new int[] { 2 });
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("uin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1);
      getActivity().startActivity((Intent)localObject);
      getActivity().overridePendingTransition(2130771990, 2130772295);
      return;
      str1 = this.jdField_b_of_type_JavaLangString;
      break;
      if (this.jdField_b_of_type_Bbyf.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "";
        break label26;
      }
      localObject = this.jdField_b_of_type_Bbyf.jdField_b_of_type_JavaLangString;
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
    if (this.jdField_a_of_type_Bhuf == null)
    {
      this.jdField_a_of_type_Bhuf = bhuf.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2131559713, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Bcal);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setMinimumHeight((int)(azkz.jdField_b_of_type_Int * 0.3F));
      this.jdField_a_of_type_Bhuf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
      this.jdField_a_of_type_Bhuf.e(50);
      this.jdField_a_of_type_Bhuf.a().setGravity(17);
      this.jdField_a_of_type_Bhuf.a(new bbzx(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    this.jdField_a_of_type_Bhuf.c(true);
    bhsj.a(getActivity());
    this.jdField_a_of_type_Bhuf.show();
  }
  
  public void m()
  {
    this.jdField_a_of_type_Bhuf.dismiss();
  }
  
  public void n()
  {
    this.jdField_a_of_type_Bcal.postDelayed(new PublishHomeWorkFragment.17(this), 400L);
  }
  
  public void o()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bety.dismiss();
      label24:
      this.jdField_a_of_type_Bety = null;
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
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(bcdz.a(paramIntent));
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
      }
      if (paramInt2 != -1) {
        continue;
      }
      if (!bdin.d(getActivity()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "no network toast from capture");
        }
        QQToast.a(getActivity(), 2131697661, 0).a();
        return;
      }
      bdhj.a(getActivity(), this.jdField_c_of_type_JavaLangString);
      paramIntent = new bced(this.jdField_c_of_type_JavaLangString);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((String)this.jdField_b_of_type_JavaUtilList.get(0) + alud.a(2131709227) + this.jdField_b_of_type_JavaUtilList.size() + alud.a(2131709222));
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
        localObject = alud.a(2131697860) + " (" + this.jdField_e_of_type_Int + alud.a(2131697861) + ")\n" + alud.a(2131697862) + "\n" + this.jdField_h_of_type_JavaLangString;
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
          if ((this.jdField_c_of_type_Long == 0L) && (this.jdField_a_of_type_Bcax != null))
          {
            paramIntent = (bcaw)this.jdField_a_of_type_Bcax.a();
            this.jdField_c_of_type_Long = bcaw.a();
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
      bdjz localbdjz = bdgm.a(getActivity(), 230);
      bbzy localbbzy = new bbzy(this);
      if (this.jdField_a_of_type_Int == 1) {
        localbdjz.setMessage(2131697891);
      }
      for (;;)
      {
        localbdjz.setPositiveButton(2131697892, localbbzy);
        localbdjz.setNegativeButton(2131697887, localbbzy);
        localbdjz.show();
        return true;
        if (this.jdField_a_of_type_Int == 2) {
          localbdjz.setMessage(2131697872);
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
    case 2131372474: 
      a(paramView);
      return;
    case 2131372483: 
      b(paramView);
      return;
    case 2131372489: 
      c(paramView);
      return;
    case 2131372472: 
      k();
      return;
    case 2131372481: 
      d(paramView);
      return;
    case 2131372479: 
      g(paramView);
      return;
    case 2131378392: 
      e(paramView);
      return;
    }
    f(paramView);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.jdField_a_of_type_Ameq != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ameq);
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
    this.jdField_a_of_type_Bcal.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (!this.i) {
      getActivity().overridePendingTransition(2130771990, 2130772295);
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
    this.jdField_g_of_type_Boolean = bcfa.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor, paramIntent, this.jdField_g_of_type_Boolean);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      return;
    }
    this.jdField_a_of_type_Bcal.postDelayed(new PublishHomeWorkFragment.1(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */