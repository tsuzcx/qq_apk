package com.tencent.mobileqq.troop.homework.entry.ui;

import agej;
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
import android.support.v4.util.SparseArrayCompat;
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
import anzj;
import aoip;
import aojs;
import bdep;
import bfyk;
import bfzh;
import bfzj;
import bfzp;
import bfzw;
import bfzx;
import bfzy;
import bfzz;
import bgaa;
import bgab;
import bgac;
import bgad;
import bgae;
import bgaf;
import bgag;
import bgah;
import bgai;
import bgaj;
import bgak;
import bgal;
import bgam;
import bgan;
import bgao;
import bgap;
import bgaq;
import bgbb;
import bgbc;
import bgbl;
import bgbn;
import bgbo;
import bgbp;
import bged;
import bgef;
import bgeg;
import bgeh;
import bgei;
import bgel;
import bgeq;
import bger;
import bgfi;
import bgpq;
import bgtj;
import bgtk;
import bguq;
import bhju;
import bhlq;
import bhmq;
import bhmr;
import bhni;
import bhnv;
import bhpc;
import bjbs;
import blgx;
import blir;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  implements View.OnClickListener, bgbl
{
  public int a;
  protected long a;
  protected BroadcastReceiver a;
  protected SparseArrayCompat<bgbo> a;
  protected View a;
  public ViewGroup a;
  public EditText a;
  protected aoip a;
  protected aojs a;
  protected bfyk a;
  protected bgaq a;
  public bgbc a;
  protected bjbs a;
  public blir a;
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
  public boolean a;
  protected int b;
  protected long b;
  protected View b;
  protected ViewGroup b;
  protected bfyk b;
  public FormSimpleItem b;
  public String b;
  protected List<String> b;
  protected boolean b;
  public long c;
  protected View c;
  protected ViewGroup c;
  public String c;
  protected boolean c;
  protected ViewGroup d;
  protected String d;
  public boolean d;
  protected ViewGroup e;
  protected String e;
  public boolean e;
  protected String f;
  public boolean f;
  protected boolean g;
  public boolean h;
  protected boolean i;
  public boolean j;
  protected boolean k;
  public boolean l;
  protected boolean m;
  
  public PublishHomeWorkFragment()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bgah(this);
  }
  
  protected static View a(Context paramContext, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setClickable(true);
    localLinearLayout.setGravity(16);
    localLinearLayout.setBackgroundResource(2130843789);
    Object localObject = new LinearLayout.LayoutParams(-2, bdep.a(42.0F));
    ((LinearLayout.LayoutParams)localObject).setMargins(bdep.a(12.0F), 0, 0, 0);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setTextColor(Color.parseColor("#5E6379"));
    ((TextView)localObject).setTextSize(1, 14.0F);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setBackgroundColor(0);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(bdep.a(12.0F), 0, bdep.a(24.0F), 0);
    ((TextView)localObject).setLayoutParams(paramString);
    if (paramInt2 > 0)
    {
      paramContext = new ImageView(paramContext);
      paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext.setImageResource(paramInt2);
      paramString = new LinearLayout.LayoutParams(bdep.a(21.0F), bdep.a(21.0F));
      paramString.setMargins(bdep.a(24.0F), 0, 0, 0);
      paramContext.setLayoutParams(paramString);
      localLinearLayout.addView(paramContext);
    }
    localLinearLayout.addView((View)localObject);
    localLinearLayout.setOnClickListener(paramOnClickListener);
    localLinearLayout.setTag(new bgap(paramInt1, paramObject));
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
    paramContext.setPadding(bdep.a(12.0F), 0, bdep.a(12.0F), 0);
    paramString1 = new LinearLayout.LayoutParams(-1, -2);
    paramString1.setMargins(0, bdep.a(2.0F), 0, bdep.a(4.0F));
    paramContext.setLayoutParams(paramString1);
    paramContext.setText(paramString2);
    localLinearLayout.addView((View)localObject);
    localLinearLayout.addView(paramContext);
    localLinearLayout.setTag(new bgap(paramInt, paramObject));
    return localLinearLayout;
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int n = 0;
    while (n < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((bgbo)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(n))).a(paramInt1, paramInt2, paramIntent);
      n += 1;
    }
  }
  
  private void a(int paramInt, bgbo parambgbo)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, parambgbo);
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
    bgtj localbgtj = bgtj.a();
    Object localObject2 = localbgtj.a("troop_create_homework");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://qun.qq.com/homework/features/sethomework.html?_wv=5123&_bid=2146#role=teacher&gid=<$GC>&content=<$CONTENT>&type=word&from=<$FROM>";
    }
    localObject2 = new bgtk();
    ((bgtk)localObject2).jdField_a_of_type_JavaLangString = paramString;
    ((bgtk)localObject2).jdField_c_of_type_JavaLangString = "aio";
    ((bgtk)localObject2).i = "";
    paramString = localbgtj.a((String)localObject1, (bgtk)localObject2);
    if (paramString != null)
    {
      if (!paramString.startsWith("mqqapi://")) {
        break label100;
      }
      paramQQAppInterface = bhni.a(paramQQAppInterface, paramContext, paramString);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a();
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
    ((Activity)paramContext).overridePendingTransition(2130772302, 2130771990);
  }
  
  private void a(JSONArray paramJSONArray)
  {
    int n = 0;
    while (n < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((bgbo)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(n))).a(paramJSONArray);
      n += 1;
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int n = 0;
    while (n < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((bgbo)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(n))).a(paramJSONObject);
      n += 1;
    }
  }
  
  private boolean a(long paramLong)
  {
    long l1 = System.currentTimeMillis() / 1000L;
    if (this.jdField_a_of_type_Bgbc != null)
    {
      if (paramLong < l1 + 1L) {
        QQToast.a(getActivity(), 2131696804, 0).a();
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  private void b(boolean paramBoolean)
  {
    int n = 0;
    while (n < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((bgbo)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(n))).b(paramBoolean);
      n += 1;
    }
  }
  
  private void c(int paramInt)
  {
    int n = 0;
    while (n < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((bgbo)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(n))).a(paramInt);
      n += 1;
    }
  }
  
  private void c(bfyk parambfyk)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("homework_id", Long.toString(parambfyk.d));
    localBundle.putString("group_id", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("title", parambfyk.jdField_a_of_type_JavaLangString);
    String str1;
    String str2;
    if (parambfyk.jdField_a_of_type_Boolean)
    {
      str1 = "1";
      localBundle.putString("need_feedback", str1);
      localBundle.putString("c", parambfyk.jdField_b_of_type_JavaLangString);
      str2 = getActivity().app.c();
      parambfyk = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      if (parambfyk == null) {
        break label287;
      }
      str1 = parambfyk.getSkey(str2);
      parambfyk = parambfyk.getPskey(str2, "qun.qq.com");
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localBundle.putString("bkn", "" + bguq.b(str1));
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str1 + ";p_uin=o" + str2 + ";p_skey=" + parambfyk);
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new bgpq("https://qun.qq.com/cgi-bin/homework/hw/modify_hw.fcg", "POST", new bgai(this), 1000, null).a(localHashMap);
      return;
      str1 = "0";
      break;
      label287:
      parambfyk = null;
      str1 = null;
    }
  }
  
  private void d(bfyk parambfyk)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("group_id", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("course_id", "0");
    if (!this.jdField_a_of_type_JavaLangString.isEmpty())
    {
      localBundle.putString("course_name", this.jdField_a_of_type_JavaLangString);
      localBundle.putString("title", parambfyk.jdField_a_of_type_JavaLangString);
      if (!parambfyk.jdField_a_of_type_Boolean) {
        break label236;
      }
    }
    int n;
    label236:
    for (String str1 = "1";; str1 = "0")
    {
      localBundle.putString("need_feedback", str1);
      localBundle.putString("c", parambfyk.jdField_b_of_type_JavaLangString);
      localBundle.putString("team_id", "0");
      localBundle.putString("hw_type", "0");
      localBundle.putString("tsfeedback", String.valueOf(this.jdField_c_of_type_Long));
      if ((parambfyk.jdField_a_of_type_JavaUtilList == null) || (parambfyk.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label287;
      }
      str1 = "[";
      n = 0;
      while (n < parambfyk.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        str1 = str1 + String.valueOf(parambfyk.jdField_a_of_type_JavaUtilList.get(n)) + ",";
        n += 1;
      }
      localBundle.putString("course_name", anzj.a(2131696750));
      break;
    }
    localBundle.putString("syncgids", str1 + String.valueOf(parambfyk.jdField_a_of_type_JavaUtilList.get(n)) + "]");
    label287:
    String str2 = getActivity().app.c();
    parambfyk = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (parambfyk != null)
    {
      str1 = parambfyk.getSkey(str2);
      parambfyk = parambfyk.getPskey(str2, "qun.qq.com");
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localBundle.putString("bkn", "" + bguq.b(str1));
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str1 + ";p_uin=o" + str2 + ";p_skey=" + parambfyk);
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new bgpq("https://qun.qq.com/cgi-bin/homework/hw/assign_hw.fcg", "POST", new bgaj(this), 1000, null).a(localHashMap);
      return;
      parambfyk = null;
      str1 = null;
    }
  }
  
  private void p()
  {
    a(2, new bgbn(this, this.jdField_b_of_type_JavaLangString));
    a(1, new bgbp(this, this.jdField_b_of_type_JavaLangString));
  }
  
  private void q()
  {
    int n = 0;
    while (n < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((bgbo)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(n))).a();
      n += 1;
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_Bgbc = bgbb.a(getActivity());
    this.jdField_a_of_type_Bgbc.a(new bfzy(this));
    this.jdField_a_of_type_Bgbc.a(new bfzz(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    String str;
    if (this.jdField_d_of_type_JavaLangString == null)
    {
      str = "";
      localBundle.putString("reportIdentity", str);
      if (!this.k) {
        break label69;
      }
      if (this.jdField_e_of_type_JavaLangString != null) {
        break label61;
      }
      str = "";
    }
    for (;;)
    {
      localBundle.putString("reportCourse", str);
      return localBundle;
      str = this.jdField_d_of_type_JavaLangString;
      break;
      label61:
      str = this.jdField_e_of_type_JavaLangString;
      continue;
      label69:
      if (this.f == null) {
        str = "";
      } else {
        str = this.f;
      }
    }
  }
  
  public <T extends View> T a(int paramInt)
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
        int i1 = paramView.getChildCount();
        int n = 0;
        while (n < i1)
        {
          View localView = a(paramClass, paramView.getChildAt(n));
          if (localView != null) {
            return localView;
          }
          n += 1;
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
    int i1;
    int n;
    label38:
    do
    {
      return localObject2;
      if (!(paramView instanceof ViewGroup)) {
        break;
      }
      i1 = ((ViewGroup)paramView).getChildCount();
      n = 0;
      localObject1 = localObject2;
      localObject2 = localObject1;
    } while (n >= i1);
    localObject2 = a(((ViewGroup)paramView).getChildAt(n));
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      n += 1;
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
  
  public XMediaEditor a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor;
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
    int n = ((Calendar)localObject3).get(1);
    int i1 = ((Calendar)localObject3).get(2);
    int i2 = ((Calendar)localObject3).get(5);
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
    return String.valueOf(n) + anzj.a(2131696806) + String.valueOf(i1 + 1) + anzj.a(2131696805) + String.valueOf(i2) + anzj.a(2131696803) + " " + (String)localObject1 + ":" + (String)localObject2;
  }
  
  List<View> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair != null) && (localPair.second != null) && (((View)localPair.second).getTag() != null) && ((((View)localPair.second).getTag() instanceof bgap)) && (((bgap)((View)localPair.second).getTag()).jdField_a_of_type_Int == paramInt)) {
        localArrayList.add(localPair.second);
      }
    }
    return localArrayList;
  }
  
  @NonNull
  protected List<String> a(bgeq parambgeq)
  {
    ArrayList localArrayList = new ArrayList();
    if (parambgeq != null)
    {
      if (!(parambgeq instanceof bger)) {
        break label50;
      }
      localArrayList.add(anzj.a(2131707722) + "");
    }
    label50:
    do
    {
      return localArrayList;
      if ((parambgeq instanceof bgel))
      {
        localArrayList.add(anzj.a(2131707705) + "");
        return localArrayList;
      }
      if ((parambgeq instanceof bgef))
      {
        localArrayList.add(anzj.a(2131707711) + "");
        return localArrayList;
      }
      if ((parambgeq instanceof bged))
      {
        localArrayList.add(anzj.a(2131707715) + "");
        return localArrayList;
      }
    } while (!(parambgeq instanceof bgei));
    localArrayList.add(anzj.a(2131707719) + "");
    return localArrayList;
  }
  
  List<Pair<Integer, View>> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a != null))
    {
      if (!bfzp.jdField_a_of_type_JavaLangString.equals(paramString)) {
        break label110;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "add special entry for recite");
        }
        localArrayList.add(new Pair(Integer.valueOf(1), a(getActivity(), 4, anzj.a(2131707701), 2130840336, new bgaf(this), null)));
      }
    }
    label110:
    while ((!bfzp.jdField_b_of_type_JavaLangString.equals(paramString)) || (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_b_of_type_Boolean)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "add special entry for arithmetic");
    }
    localArrayList.add(new Pair(Integer.valueOf(2), a(getActivity(), 7, anzj.a(2131707723), anzj.a(2131707710), new bgag(this), null)));
    return localArrayList;
  }
  
  protected void a()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bgaq = new bgaq(this, Looper.getMainLooper());
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
      this.jdField_a_of_type_Aoip = ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
      this.jdField_a_of_type_Aojs = new bgae(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
    } while (this.m);
    this.m = true;
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
    ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
    getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
  }
  
  public void a(int paramInt)
  {
    int n = 0;
    boolean bool = ((bgbo)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt)).a();
    if ((bool) && (paramInt == 1)) {
      if (this.jdField_a_of_type_Bgbc != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        if (this.jdField_a_of_type_Int == 1)
        {
          if (this.jdField_c_of_type_Long == 0L)
          {
            bgbb localbgbb = (bgbb)this.jdField_a_of_type_Bgbc.a();
            this.jdField_c_of_type_Long = bgbb.a();
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(a(this.jdField_c_of_type_Long));
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(true);
        }
      }
      else
      {
        if (!bool) {
          break label232;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      }
    }
    for (;;)
    {
      if (n >= this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size()) {
        return;
      }
      ((bgbo)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(n))).a(paramInt, bool);
      n += 1;
      continue;
      if (this.jdField_a_of_type_Bfyk.jdField_c_of_type_Long != 0L) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(a(this.jdField_a_of_type_Bfyk.jdField_c_of_type_Long));
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
      break;
      this.jdField_c_of_type_Long = 0L;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      label232:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
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
        bhju.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, "1", "{\"type\":\"calculation\"}" });
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
        bgeg localbgeg = (bgeg)((Iterator)localObject).next();
        if (localbgeg != null) {
          localJSONArray.put(localbgeg.a());
        }
      }
    } while (localArrayList.isEmpty());
    if (this.jdField_b_of_type_JavaLangString == null) {}
    for (Object localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      bhju.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(localArrayList.size()), localJSONArray.toString() });
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
      bhju.a("Grp_edu", "homework", "CreateHw_Show", 0, 0, new String[] { paramString2, str2, paramString1, str1 });
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
  
  protected void a(int paramInt, ArrayList<bgeq> paramArrayList, bfyk parambfyk)
  {
    if (paramInt == 0)
    {
      parambfyk = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        parambfyk.addAll(a((bgeq)localIterator.next()));
      }
      parambfyk = new ArrayList(new TreeSet(parambfyk));
      if (parambfyk.isEmpty())
      {
        parambfyk = "";
        if (this.jdField_b_of_type_Int != 0) {
          break label277;
        }
        this.jdField_b_of_type_Int += 1;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList.isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramArrayList);
        }
        paramArrayList = getString(2131696825, new Object[] { parambfyk });
        QQToast.a(getActivity(), paramArrayList, 0).a();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "Error, reason_code = " + paramInt + ", print trace: ", new RuntimeException("UPLOAD_ERROR"));
      }
      return;
      if (parambfyk.size() == 1)
      {
        parambfyk = (String)parambfyk.get(0);
        break;
      }
      parambfyk = (String)parambfyk.get(0) + "、" + (String)parambfyk.get(1) + anzj.a(2131707703);
      break;
      label277:
      paramArrayList = getString(2131696823, new Object[] { parambfyk });
      QQToast.a(getActivity(), paramArrayList, 0).a();
      continue;
      if (paramInt == 1) {
        QQToast.a(getActivity(), 2131696787, 0).a();
      } else if (paramInt == 3) {
        QQToast.a(getActivity(), 2131696819, 0).a();
      } else if (paramInt == 2) {
        QQToast.a(getActivity(), 2131693972, 0).a();
      }
    }
  }
  
  protected void a(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 515;
    this.jdField_a_of_type_Bgaq.sendMessageDelayed(localMessage, paramLong);
  }
  
  protected void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onPictureBtnClick");
    }
    int n = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(1);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(2) + n;
    if (i1 >= 10)
    {
      if (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 2000L)
      {
        QQToast.a(getActivity(), anzj.a(2131707704) + 10 + anzj.a(2131707708), 0).a();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      if ((getActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (getActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        n = 1;
      }
    }
    for (;;)
    {
      if (n == 0)
      {
        getActivity().requestPermissions(new bfzw(this, i1), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        n = 0;
      }
      else
      {
        paramView = TroopHWJsPlugin.a(10 - i1, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
        startActivityForResult(paramView, 259);
        blgx.a(getActivity());
        return;
        n = 1;
      }
    }
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) {}
    for (int n = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(4);; n = 0)
    {
      if ((n > 0) && (!paramBoolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        this.jdField_d_of_type_Boolean = true;
        QQToast.a(getActivity(), 0, anzj.a(2131707699), 1).a();
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
      bhpc localbhpc = bhlq.a(getActivity(), 230);
      localbhpc.setMessage(anzj.a(2131707718)).setNegativeButton(anzj.a(2131707721), new bgab(this)).setPositiveButton(anzj.a(2131707716), new bgaa(this, (FormSwitchItem)localObject, paramCompoundButton));
      this.jdField_d_of_type_Boolean = true;
      paramCompoundButton.setChecked(true);
      localbhpc.show();
      return;
    }
  }
  
  public void a(bfyk parambfyk)
  {
    int n = 0;
    this.jdField_a_of_type_Bfyk = parambfyk;
    parambfyk = parambfyk.jdField_b_of_type_JavaLangString;
    for (;;)
    {
      try
      {
        parambfyk = new JSONObject(parambfyk).getJSONArray("c");
        if (n < parambfyk.length())
        {
          JSONObject localJSONObject = parambfyk.getJSONObject(n);
          if (localJSONObject != null) {
            a(localJSONObject);
          }
        }
        else
        {
          a(new JSONObject().put("c", parambfyk).toString());
          if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().isEmpty()))
          {
            this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_Bfyk.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
            this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
          }
          return;
        }
      }
      catch (Exception parambfyk)
      {
        return;
      }
      n += 1;
    }
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
    blgx.a(getActivity());
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
  
  protected void a(@NonNull ArrayList<bgeq> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.addAll(a((bgeq)paramArrayList.next()));
    }
    paramArrayList = new ArrayList(new TreeSet(localArrayList));
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    for (;;)
    {
      paramArrayList = getString(2131696825, new Object[] { paramArrayList });
      QQToast.a(getActivity(), paramArrayList, 0).a();
      return;
      if (paramArrayList.size() == 1) {
        paramArrayList = (String)paramArrayList.get(0);
      } else {
        paramArrayList = (String)paramArrayList.get(0) + "、" + (String)paramArrayList.get(1) + anzj.a(2131707714);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int n;
    if (paramBoolean)
    {
      View localView = this.jdField_b_of_type_AndroidViewView;
      if (this.jdField_a_of_type_Boolean)
      {
        n = 0;
        localView.setVisibility(n);
        this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    for (;;)
    {
      b(paramBoolean);
      return;
      n = 8;
      break;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.20(this), 20L);
    }
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
      int n = ((JSONArray)localObject).length();
      if (n <= 0) {
        return true;
      }
      if (n == 1)
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
  
  protected void b(int paramInt)
  {
    try
    {
      if (!getActivity().isFinishing())
      {
        if (this.jdField_a_of_type_Bjbs == null)
        {
          this.jdField_a_of_type_Bjbs = new bjbs(getActivity(), getActivity().getTitleBarHeight());
          this.jdField_a_of_type_Bjbs.setCancelable(false);
          this.jdField_a_of_type_Bjbs.show();
        }
        this.jdField_a_of_type_Bjbs.c(paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
        QQToast.a(getActivity(), anzj.a(2131707700) + 10 + anzj.a(2131707717), 0).a();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    int n;
    if (Build.VERSION.SDK_INT >= 23) {
      if (getActivity().checkSelfPermission("android.permission.CAMERA") == 0) {
        n = 1;
      }
    }
    for (;;)
    {
      if (n == 0)
      {
        getActivity().requestPermissions(new bfzx(this), 3, new String[] { "android.permission.CAMERA" });
        return;
        n = 0;
      }
      else
      {
        this.jdField_c_of_type_JavaLangString = TroopHWJsPlugin.a(getActivity(), 260);
        blgx.a(getActivity());
        return;
        n = 1;
      }
    }
  }
  
  protected void b(bfyk parambfyk)
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
        bgeq localbgeq = (bgeq)((Iterator)localObject).next();
        if (localbgeq != null) {
          if (localbgeq.e() == 1) {
            localArrayList1.add(localbgeq);
          } else if ((localbgeq.e() == 2) || (localbgeq.e() == 0)) {
            localArrayList2.add(localbgeq);
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
        a(0, localArrayList2, parambfyk);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: unknown error list");
      }
      a(3, localArrayList2, parambfyk);
      return;
      if (parambfyk == null) {
        break;
      }
      b(2131696802);
      if (this.jdField_a_of_type_Int == 1)
      {
        d(parambfyk);
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    c(parambfyk);
    return;
    if (QLog.isColorLevel()) {
      QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: homework info is null");
    }
    a(3, null, parambfyk);
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
          bfzj localbfzj = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a;
          SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("PublishHomeWorkFragment:homework_troop", 0);
          if (localbfzj != null) {
            if ((bfzp.jdField_a_of_type_JavaLangString.equals(paramString)) && (localbfzj.jdField_a_of_type_Boolean))
            {
              try
              {
                if (!localSharedPreferences.getBoolean(a(4), true)) {
                  continue;
                }
                paramString = new File(new URL(localbfzj.jdField_b_of_type_JavaLangString).getFile()).getName();
                paramString = new bfzh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbfzj.jdField_b_of_type_JavaLangString, paramString, localbfzj.jdField_c_of_type_JavaLangString);
                if (QLog.isColorLevel()) {
                  QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for recite");
                }
                paramString.a(this.jdField_a_of_type_Bgaq, 4, true);
                return;
              }
              catch (Exception paramString) {}
              if (QLog.isColorLevel()) {
                QLog.d("PublishHomeWorkFragment", 2, "download manager init error ", paramString);
              }
            }
            else
            {
              if ((!bfzp.jdField_b_of_type_JavaLangString.equals(paramString)) || (!localbfzj.jdField_b_of_type_Boolean)) {
                break label300;
              }
              try
              {
                if (localSharedPreferences.getBoolean(a(7), true))
                {
                  paramString = new File(new URL(localbfzj.jdField_d_of_type_JavaLangString).getFile()).getName();
                  paramString = new bfzh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbfzj.jdField_d_of_type_JavaLangString, paramString, localbfzj.jdField_e_of_type_JavaLangString);
                  if (QLog.isColorLevel()) {
                    QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for arithmetic");
                  }
                  paramString.a(this.jdField_a_of_type_Bgaq, 7, true);
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
      if (bfzp.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      return;
    }
  }
  
  protected void c()
  {
    if (this.mContentView == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidViewView = a(2131373190);
      this.jdField_c_of_type_AndroidViewView = a(2131379408);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard = ((InputMethodGuard)a(2131368748));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getActivity().getLayoutInflater().inflate(2131560624, null, false));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373179));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)a(2131373189));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_b_of_type_AndroidViewView = a(2131363646);
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131377892));
      this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131377891));
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131377890));
      this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364893));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131373185));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131373192));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131373186));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnClickListener(this);
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new bgak(this));
      q();
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.setOnInputMethodChangeListener(this);
      View localView = a(2131373187);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      localView = a(2131373195);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      localView = a(2131373201);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      if (this.jdField_a_of_type_Bgbc == null) {
        try
        {
          r();
          if ((this.jdField_a_of_type_Bgbc.a() instanceof bgbb))
          {
            bgbb.a(this.jdField_a_of_type_Bgbc, (bgbb)this.jdField_a_of_type_Bgbc.a());
            return;
          }
        }
        catch (Throwable localThrowable) {}
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
        QQToast.a(getActivity(), anzj.a(2131707702) + 6 + anzj.a(2131707709), 0).a();
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
        this.h = localBundle.getBoolean("BeginnerGuideFragment:from_beginner_guide", false);
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
          this.jdField_a_of_type_Aoip.d(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        }
        if (this.jdField_a_of_type_Int == 2)
        {
          if (this.jdField_a_of_type_Long > 0L)
          {
            b(2131696796);
            this.jdField_a_of_type_Aoip.a(this.jdField_a_of_type_Long);
          }
        }
        else {
          return;
        }
        QQToast.a(getActivity(), 2131696821, 0).a();
        getActivity().finish();
        return;
      }
      QQToast.a(getActivity(), 2131696821, 0).a();
      getActivity().finish();
      return;
    }
    QQToast.a(getActivity(), 2131696821, 0).a();
    getActivity().finish();
  }
  
  protected void d(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onClickSelectTime");
    }
    if (this.jdField_a_of_type_Bgbc == null) {}
    try
    {
      r();
      if ((this.jdField_a_of_type_Bgbc.a() instanceof bgbb)) {
        bgbb.a(this.jdField_a_of_type_Bgbc, (bgbb)this.jdField_a_of_type_Bgbc.a());
      }
      this.jdField_a_of_type_Bgbc.a();
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    getActivity().getWindow().setSoftInputMode(16);
    a();
    d();
    p();
    c();
    e();
    if (BaseApplicationImpl.sProcessId != 9) {
      SubmitHomeWorkFragment.a(getActivity());
    }
  }
  
  protected void e()
  {
    setLeftButton(2131696779, new bgal(this));
    setRightButton(2131696793, new bgam(this));
    if (this.jdField_a_of_type_Int == 1) {
      setTitle(getResources().getString(2131696795));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bgan(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setFocusChangeListener(new bgao(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setSizeLimit(500);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHint(getString(2131696788));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int == 1) {
        ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.9(this), 550L);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
      f();
      return;
      if (this.jdField_a_of_type_Int == 2) {
        setTitle(getResources().getString(2131696768));
      }
    }
  }
  
  public void f()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 513;
    this.jdField_a_of_type_Bgaq.sendMessage(localMessage);
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
    for (int n = 1;; n = 0)
    {
      if (n != 0)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.a());
        if ((this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 8) || (this.jdField_b_of_type_AndroidViewViewGroup.getHeight() <= 0))
        {
          localObject = Message.obtain();
          ((Message)localObject).what = 514;
          this.jdField_a_of_type_Bgaq.sendMessageDelayed((Message)localObject, 100L);
        }
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560625;
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
    int i1 = ((JSONArray)localObject3).length();
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
      bhju.a("Grp_edu", "homework", "CreateHw_Sub", 0, 0, new String[] { localObject1, str, localObject2 });
      int n = 0;
      while (n < i1)
      {
        localObject1 = ((JSONArray)localObject3).optJSONObject(n);
        if (a((JSONObject)localObject1)) {
          localJSONArray.put(localObject1);
        }
        n += 1;
      }
      localObject1 = this.jdField_b_of_type_JavaLangString;
      break;
    }
    if (localJSONArray.length() <= 0)
    {
      QQToast.a(getActivity(), 2131696782, 0).a();
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_b_of_type_JavaLangString);
    }
    Object localObject1 = new bfyk();
    ((bfyk)localObject1).jdField_b_of_type_Long = 0L;
    ((bfyk)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (TextUtils.isEmpty(((bfyk)localObject1).jdField_a_of_type_JavaLangString.trim()))
    {
      QQToast.a(getActivity(), 2131696783, 0).a();
      return;
    }
    if (!bhnv.g(getActivity()))
    {
      QQToast.a(getActivity(), 0, 2131693963, 0).a();
      return;
    }
    try
    {
      ((bfyk)localObject1).jdField_b_of_type_Long = Long.parseLong(getActivity().app.c());
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        ((bfyk)localObject1).jdField_a_of_type_Long = 0L;
        localObject2 = new ArrayList();
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            ((List)localObject2).add(Long.valueOf(Long.parseLong((String)((Iterator)localObject3).next())));
            continue;
            if (!this.jdField_e_of_type_Boolean) {
              break;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      localJSONArray.put(new JSONObject("{\"type\":\"calculation\"}"));
      a(localJSONArray);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("c", localJSONArray);
      ((bfyk)localObject1).jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
      ((bfyk)localObject1).jdField_b_of_type_JavaLangString = localJSONObject.toString();
      if (this.jdField_a_of_type_Int == 2)
      {
        ((bfyk)localObject1).d = this.jdField_a_of_type_Long;
        ((bfyk)localObject1).jdField_a_of_type_Boolean = this.jdField_a_of_type_Bfyk.jdField_a_of_type_Boolean;
      }
      this.jdField_b_of_type_Bfyk = ((bfyk)localObject1);
      b((bfyk)localObject1);
      return;
      ((bfyk)localObject1).jdField_a_of_type_Long = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      break;
      ((bfyk)localObject1).jdField_a_of_type_JavaUtilList = localJSONObject;
    }
  }
  
  public void j()
  {
    try
    {
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label393;
      }
      str1 = "";
      str3 = this.jdField_d_of_type_JavaLangString;
      if (this.jdField_b_of_type_Bfyk != null) {
        break label401;
      }
      localObject = "";
      label26:
      if (!this.jdField_d_of_type_Boolean) {
        break label456;
      }
      str2 = "1";
    }
    catch (Exception localException)
    {
      label393:
      for (;;)
      {
        String str1;
        String str3;
        Object localObject;
        label89:
        continue;
        label143:
        label401:
        label436:
        label444:
        label456:
        String str2 = "0";
      }
    }
    bhju.a("Grp_edu", "homework", "CreateHw_Complete", 0, 0, new String[] { str1, str3, localObject, str2 });
    if (this.l)
    {
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "";
        bhju.a("Grp_edu", "homework", "CreateHw_EditTitle", 0, 0, new String[] { localObject });
      }
    }
    else
    {
      c(1);
      if ((this.jdField_b_of_type_Bfyk != null) && (this.jdField_b_of_type_Bfyk.jdField_a_of_type_Boolean))
      {
        if (this.jdField_b_of_type_JavaLangString != null) {
          break label436;
        }
        localObject = "";
        bhju.a("Grp_edu", "homework", "CreateHw_Sub_Open", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString });
      }
      if ((this.jdField_b_of_type_Bfyk != null) && (this.jdField_b_of_type_Bfyk.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_b_of_type_Bfyk.jdField_a_of_type_JavaUtilList.isEmpty())) {
        if (this.jdField_b_of_type_JavaLangString != null) {
          break label444;
        }
      }
    }
    for (localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      bhju.a("Grp_edu", "homework", "CreateHw_CopyGrp", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(this.jdField_b_of_type_Bfyk.jdField_a_of_type_JavaUtilList.size()) });
      a(1, "CreateHw_Pic");
      a(2, "CreateHw_Video");
      a(3, "CreateHw_Voice");
      a(7, "CreateHw_Calculate");
      a(4, "CreateHw_Recite");
      QQToast.a(getActivity(), 2131696794, 0).a();
      localObject = agej.a(new Intent(getActivity(), SplashActivity.class), new int[] { 2 });
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("uin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1);
      getActivity().startActivity((Intent)localObject);
      getActivity().overridePendingTransition(2130771990, 2130772304);
      return;
      str1 = this.jdField_b_of_type_JavaLangString;
      break;
      if (this.jdField_b_of_type_Bfyk.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "";
        break label26;
      }
      localObject = this.jdField_b_of_type_Bfyk.jdField_b_of_type_JavaLangString;
      break label26;
      localObject = this.jdField_b_of_type_JavaLangString;
      break label89;
      localObject = this.jdField_b_of_type_JavaLangString;
      break label143;
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
    if (this.jdField_a_of_type_Blir == null)
    {
      this.jdField_a_of_type_Blir = blir.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2131559856, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Bgaq);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setMinimumHeight((int)(bdep.jdField_b_of_type_Int * 0.3F));
      this.jdField_a_of_type_Blir.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
      this.jdField_a_of_type_Blir.e(50);
      this.jdField_a_of_type_Blir.a().setGravity(17);
      this.jdField_a_of_type_Blir.a(new bgac(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.d();
    this.jdField_a_of_type_Blir.d(true);
    blgx.a(getActivity());
    this.jdField_a_of_type_Blir.show();
  }
  
  public void m()
  {
    this.jdField_a_of_type_Blir.dismiss();
  }
  
  public void n()
  {
    this.jdField_a_of_type_Bgaq.postDelayed(new PublishHomeWorkFragment.17(this), 400L);
  }
  
  public void o()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bjbs.dismiss();
      label24:
      this.jdField_a_of_type_Bjbs = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, new Object[] { "onActivityResult. requestCode=", Integer.valueOf(paramInt1), ", resultCode=", Integer.valueOf(paramInt2) });
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      a(paramInt1, paramInt2, paramIntent);
      return;
      Object localObject;
      if ((paramIntent != null) && (paramInt2 == 257))
      {
        int n = paramIntent.getIntExtra("HomeWorkConstants:homework_default_index_key", -2147483648);
        localObject = paramIntent.getStringExtra("HomeWorkConstants:homework_default_result_key");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (n == -2147483648) {
            break label235;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(n, (String)localObject);
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
        }
      }
      for (;;)
      {
        a((String)localObject, bool);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (QLog.isColorLevel())) {
          QLog.d("PublishHomeWorkFragment", 2, "提交新作业->" + (String)localObject);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PublishHomeWorkFragment", 2, "return from entry");
        break;
        label235:
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(bgeh.a((String)localObject));
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
        bool = true;
      }
      if (paramInt2 == -1)
      {
        if (!bhnv.d(getActivity()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublishHomeWorkFragment", 2, "no network toast from capture");
          }
          QQToast.a(getActivity(), 2131696546, 0).a();
          return;
        }
        bhmq.a(getActivity(), this.jdField_c_of_type_JavaLangString);
        localObject = new bgel(this.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a((bgeg)localObject);
        continue;
        if ((paramIntent != null) && (paramInt2 == 262))
        {
          localObject = paramIntent.getStringArrayListExtra("HomeWorkConstants:homework_async_uin_list_key");
          ArrayList localArrayList = paramIntent.getStringArrayListExtra("HomeWorkConstants:homework_async_name_list_key");
          if (localObject != null)
          {
            this.jdField_a_of_type_JavaUtilArrayList.clear();
            this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
          }
          if (localArrayList != null)
          {
            this.jdField_b_of_type_JavaUtilList.clear();
            this.jdField_b_of_type_JavaUtilList.addAll(localArrayList);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
            if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
            } else if (this.jdField_b_of_type_JavaUtilList.size() == 1) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)this.jdField_b_of_type_JavaUtilList.get(0));
            } else if (this.jdField_b_of_type_JavaUtilList.size() > 1) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((String)this.jdField_b_of_type_JavaUtilList.get(0) + anzj.a(2131707712) + this.jdField_b_of_type_JavaUtilList.size() + anzj.a(2131707707));
            }
          }
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (!a())
    {
      bhpc localbhpc = bhlq.a(getActivity(), 230);
      bgad localbgad = new bgad(this);
      if (this.jdField_a_of_type_Int == 1) {
        localbhpc.setMessage(2131696784);
      }
      for (;;)
      {
        localbhpc.setPositiveButton(2131696785, localbgad);
        localbhpc.setNegativeButton(2131696780, localbgad);
        localbhpc.show();
        blgx.a(getActivity());
        return true;
        if (this.jdField_a_of_type_Int == 2) {
          localbhpc.setMessage(2131696765);
        }
      }
    }
    blgx.a(getActivity());
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
      continue;
      b(paramView);
      continue;
      c(paramView);
      continue;
      k();
      continue;
      d(paramView);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.jdField_a_of_type_Aojs != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
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
    this.jdField_a_of_type_Bgaq.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (!this.i) {
      getActivity().overridePendingTransition(2130771990, 2130772304);
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
    this.g = bgfi.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor, paramIntent, this.g);
  }
  
  public void onPause()
  {
    super.onPause();
    blgx.a(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      return;
    }
    this.jdField_a_of_type_Bgaq.postDelayed(new PublishHomeWorkFragment.1(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */