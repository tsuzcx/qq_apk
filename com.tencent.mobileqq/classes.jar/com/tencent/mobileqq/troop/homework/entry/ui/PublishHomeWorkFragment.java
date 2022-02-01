package com.tencent.mobileqq.troop.homework.entry.ui;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import com.tencent.mobileqq.troop.homework.config.BeginnerGuideDownloadManager;
import com.tencent.mobileqq.troop.homework.config.HomeworkConfig;
import com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimeAdpater;
import com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimePicker;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard.InputMethodChangeListener;
import com.tencent.mobileqq.troop.homework.logic.DocsEntranceHelper;
import com.tencent.mobileqq.troop.homework.logic.IHomeworkHelper;
import com.tencent.mobileqq.troop.homework.logic.WeiKeEntranceHelper;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ArithmeticInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoFactory;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.UploadEditItemInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.LinkParams;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
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
  implements View.OnClickListener, InputMethodGuard.InputMethodChangeListener
{
  protected int a;
  protected long a;
  protected BroadcastReceiver a;
  protected SparseArrayCompat<IHomeworkHelper> a;
  protected View a;
  protected ViewGroup a;
  protected EditText a;
  protected CommonRecordSoundPanel a;
  protected QQAppInterface a;
  protected TroopBusinessObserver a;
  protected TroopHandler a;
  protected TroopManager a;
  protected HomeworkInfo a;
  protected PublishHomeWorkFragment.UIHandler a;
  protected HwkTimePicker a;
  protected InputMethodGuard a;
  protected XMediaEditor a;
  protected FormSimpleItem a;
  protected FormSwitchItem a;
  protected QQProgressDialog a;
  protected ActionSheet a;
  protected Boolean a;
  protected String a;
  protected ArrayList<String> a;
  protected List<Pair<Integer, View>> a;
  protected boolean a;
  protected int b;
  protected long b;
  protected View b;
  protected ViewGroup b;
  protected HomeworkInfo b;
  protected FormSimpleItem b;
  protected String b;
  protected List<String> b;
  protected boolean b;
  protected long c;
  protected View c;
  protected ViewGroup c;
  protected String c;
  protected boolean c;
  protected ViewGroup d;
  protected String d;
  protected boolean d;
  protected ViewGroup e;
  protected String e;
  protected boolean e;
  protected String f;
  protected boolean f;
  protected boolean g;
  protected boolean h = false;
  protected boolean i = false;
  protected boolean j = false;
  protected boolean k = false;
  protected boolean l = false;
  protected boolean m = false;
  protected boolean n = false;
  
  public PublishHomeWorkFragment()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = null;
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new PublishHomeWorkFragment.23(this);
  }
  
  protected static View a(Context paramContext, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setClickable(true);
    localLinearLayout.setGravity(16);
    localLinearLayout.setBackgroundResource(2130844060);
    Object localObject = new LinearLayout.LayoutParams(-2, ScreenUtil.dip2px(42.0F));
    ((LinearLayout.LayoutParams)localObject).setMargins(ScreenUtil.dip2px(12.0F), 0, 0, 0);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setTextColor(Color.parseColor("#5E6379"));
    ((TextView)localObject).setTextSize(1, 14.0F);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setBackgroundColor(0);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(ScreenUtil.dip2px(12.0F), 0, ScreenUtil.dip2px(24.0F), 0);
    ((TextView)localObject).setLayoutParams(paramString);
    if (paramInt2 > 0)
    {
      paramContext = new ImageView(paramContext);
      paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext.setImageResource(paramInt2);
      paramString = new LinearLayout.LayoutParams(ScreenUtil.dip2px(21.0F), ScreenUtil.dip2px(21.0F));
      paramString.setMargins(ScreenUtil.dip2px(24.0F), 0, 0, 0);
      paramContext.setLayoutParams(paramString);
      localLinearLayout.addView(paramContext);
    }
    localLinearLayout.addView((View)localObject);
    localLinearLayout.setOnClickListener(paramOnClickListener);
    localLinearLayout.setTag(new PublishHomeWorkFragment.SpecialEntryTag(paramInt1, paramObject));
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
    paramContext.setPadding(ScreenUtil.dip2px(12.0F), 0, ScreenUtil.dip2px(12.0F), 0);
    paramString1 = new LinearLayout.LayoutParams(-1, -2);
    paramString1.setMargins(0, ScreenUtil.dip2px(2.0F), 0, ScreenUtil.dip2px(4.0F));
    paramContext.setLayoutParams(paramString1);
    paramContext.setText(paramString2);
    localLinearLayout.addView((View)localObject);
    localLinearLayout.addView(paramContext);
    localLinearLayout.setTag(new PublishHomeWorkFragment.SpecialEntryTag(paramInt, paramObject));
    return localLinearLayout;
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((IHomeworkHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i1))).a(paramInt1, paramInt2, paramIntent);
      i1 += 1;
    }
  }
  
  private void a(int paramInt, IHomeworkHelper paramIHomeworkHelper)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramIHomeworkHelper);
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
    TroopLinkManager localTroopLinkManager = TroopLinkManager.a();
    Object localObject2 = localTroopLinkManager.a("troop_create_homework");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://qun.qq.com/homework/features/sethomework.html?_wv=5123&_bid=2146#role=teacher&gid=<$GC>&content=<$CONTENT>&type=word&from=<$FROM>";
    }
    localObject2 = new TroopLinkManager.LinkParams();
    ((TroopLinkManager.LinkParams)localObject2).jdField_a_of_type_JavaLangString = paramString;
    ((TroopLinkManager.LinkParams)localObject2).jdField_c_of_type_JavaLangString = "aio";
    ((TroopLinkManager.LinkParams)localObject2).i = "";
    paramString = localTroopLinkManager.a((String)localObject1, (TroopLinkManager.LinkParams)localObject2);
    if (paramString != null)
    {
      if (!paramString.startsWith("mqqapi://")) {
        break label100;
      }
      paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramContext, paramString);
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
    ((Activity)paramContext).overridePendingTransition(2130772314, 2130771992);
  }
  
  private void a(JSONArray paramJSONArray)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((IHomeworkHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i1))).a(paramJSONArray);
      i1 += 1;
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((IHomeworkHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i1))).a(paramJSONObject);
      i1 += 1;
    }
  }
  
  private boolean a(long paramLong)
  {
    long l1 = System.currentTimeMillis() / 1000L;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker != null)
    {
      if (paramLong < l1 + 1L) {
        QQToast.a(getActivity(), 2131697473, 0).a();
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  private void b(boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((IHomeworkHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i1))).b(paramBoolean);
      i1 += 1;
    }
  }
  
  private void c(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((IHomeworkHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i1))).a(paramInt);
      i1 += 1;
    }
  }
  
  private void c(HomeworkInfo paramHomeworkInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("homework_id", Long.toString(paramHomeworkInfo.d));
    localBundle.putString("group_id", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("title", paramHomeworkInfo.jdField_a_of_type_JavaLangString);
    String str1;
    String str2;
    if (paramHomeworkInfo.jdField_a_of_type_Boolean)
    {
      str1 = "1";
      localBundle.putString("need_feedback", str1);
      localBundle.putString("c", paramHomeworkInfo.jdField_b_of_type_JavaLangString);
      str2 = getActivity().app.getCurrentUin();
      paramHomeworkInfo = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      if (paramHomeworkInfo == null) {
        break label287;
      }
      str1 = paramHomeworkInfo.getSkey(str2);
      paramHomeworkInfo = paramHomeworkInfo.getPskey(str2, "qun.qq.com");
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localBundle.putString("bkn", "" + TroopUtils.b(str1));
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str1 + ";p_uin=o" + str2 + ";p_skey=" + paramHomeworkInfo);
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new HttpWebCgiAsyncTask2("https://qun.qq.com/cgi-bin/homework/hw/modify_hw.fcg", "POST", new PublishHomeWorkFragment.24(this), 1000, null).a(localHashMap);
      return;
      str1 = "0";
      break;
      label287:
      paramHomeworkInfo = null;
      str1 = null;
    }
  }
  
  private void d(HomeworkInfo paramHomeworkInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("group_id", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("course_id", "0");
    if (!this.jdField_a_of_type_JavaLangString.isEmpty())
    {
      localBundle.putString("course_name", this.jdField_a_of_type_JavaLangString);
      localBundle.putString("title", paramHomeworkInfo.jdField_a_of_type_JavaLangString);
      if (!paramHomeworkInfo.jdField_a_of_type_Boolean) {
        break label236;
      }
    }
    int i1;
    label236:
    for (String str1 = "1";; str1 = "0")
    {
      localBundle.putString("need_feedback", str1);
      localBundle.putString("c", paramHomeworkInfo.jdField_b_of_type_JavaLangString);
      localBundle.putString("team_id", "0");
      localBundle.putString("hw_type", "0");
      localBundle.putString("tsfeedback", String.valueOf(this.jdField_c_of_type_Long));
      if ((paramHomeworkInfo.jdField_a_of_type_JavaUtilList == null) || (paramHomeworkInfo.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label287;
      }
      str1 = "[";
      i1 = 0;
      while (i1 < paramHomeworkInfo.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        str1 = str1 + String.valueOf(paramHomeworkInfo.jdField_a_of_type_JavaUtilList.get(i1)) + ",";
        i1 += 1;
      }
      localBundle.putString("course_name", HardCodeUtil.a(2131697419));
      break;
    }
    localBundle.putString("syncgids", str1 + String.valueOf(paramHomeworkInfo.jdField_a_of_type_JavaUtilList.get(i1)) + "]");
    label287:
    String str2 = getActivity().app.getCurrentUin();
    paramHomeworkInfo = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (paramHomeworkInfo != null)
    {
      str1 = paramHomeworkInfo.getSkey(str2);
      paramHomeworkInfo = paramHomeworkInfo.getPskey(str2, "qun.qq.com");
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localBundle.putString("bkn", "" + TroopUtils.b(str1));
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str1 + ";p_uin=o" + str2 + ";p_skey=" + paramHomeworkInfo);
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new HttpWebCgiAsyncTask2("https://qun.qq.com/cgi-bin/homework/hw/assign_hw.fcg", "POST", new PublishHomeWorkFragment.25(this), 1000, null).a(localHashMap);
      return;
      paramHomeworkInfo = null;
      str1 = null;
    }
  }
  
  private void p()
  {
    a(2, new DocsEntranceHelper(this, this.jdField_b_of_type_JavaLangString));
    a(1, new WeiKeEntranceHelper(this, this.jdField_b_of_type_JavaLangString));
  }
  
  private void q()
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      ((IHomeworkHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i1))).a();
      i1 += 1;
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker = HwkTimeAdpater.a(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker.a(new PublishHomeWorkFragment.12(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker.a(new PublishHomeWorkFragment.13(this));
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
      if (this.jdField_f_of_type_JavaLangString == null) {
        str = "";
      } else {
        str = this.jdField_f_of_type_JavaLangString;
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
  
  public XMediaEditor a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor;
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "_" + "PublishHomeWorkFragment:show_beginner_guide" + "_" + paramInt;
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
    return String.valueOf(i1) + HardCodeUtil.a(2131697475) + String.valueOf(i2 + 1) + HardCodeUtil.a(2131697474) + String.valueOf(i3) + HardCodeUtil.a(2131697472) + " " + (String)localObject1 + ":" + (String)localObject2;
  }
  
  List<View> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair != null) && (localPair.second != null) && (((View)localPair.second).getTag() != null) && ((((View)localPair.second).getTag() instanceof PublishHomeWorkFragment.SpecialEntryTag)) && (((PublishHomeWorkFragment.SpecialEntryTag)((View)localPair.second).getTag()).jdField_a_of_type_Int == paramInt)) {
        localArrayList.add(localPair.second);
      }
    }
    return localArrayList;
  }
  
  @NonNull
  protected List<String> a(UploadEditItemInfo paramUploadEditItemInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramUploadEditItemInfo != null)
    {
      if (!(paramUploadEditItemInfo instanceof VideoInfo)) {
        break label50;
      }
      localArrayList.add(HardCodeUtil.a(2131708828) + "");
    }
    label50:
    do
    {
      return localArrayList;
      if ((paramUploadEditItemInfo instanceof ImageInfo))
      {
        localArrayList.add(HardCodeUtil.a(2131708811) + "");
        return localArrayList;
      }
      if ((paramUploadEditItemInfo instanceof AudioInfo))
      {
        localArrayList.add(HardCodeUtil.a(2131708817) + "");
        return localArrayList;
      }
      if ((paramUploadEditItemInfo instanceof ArithmeticInfo))
      {
        localArrayList.add(HardCodeUtil.a(2131708821) + "");
        return localArrayList;
      }
    } while (!(paramUploadEditItemInfo instanceof HWReciteInfo));
    localArrayList.add(HardCodeUtil.a(2131708825) + "");
    return localArrayList;
  }
  
  List<Pair<Integer, View>> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a != null))
    {
      if (!HomeWorkConstants.jdField_a_of_type_JavaLangString.equals(paramString)) {
        break label110;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "add special entry for recite");
        }
        localArrayList.add(new Pair(Integer.valueOf(1), a(getActivity(), 4, HardCodeUtil.a(2131708807), 2130840524, new PublishHomeWorkFragment.21(this), null)));
      }
    }
    label110:
    while ((!HomeWorkConstants.jdField_b_of_type_JavaLangString.equals(paramString)) || (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_b_of_type_Boolean)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "add special entry for arithmetic");
    }
    localArrayList.add(new Pair(Integer.valueOf(2), a(getActivity(), 7, HardCodeUtil.a(2131708829), HardCodeUtil.a(2131708816), new PublishHomeWorkFragment.22(this), null)));
    return localArrayList;
  }
  
  protected void a()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler = new PublishHomeWorkFragment.UIHandler(this, Looper.getMainLooper());
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
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
      this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new PublishHomeWorkFragment.2(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    } while (this.m);
    this.m = true;
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
    ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
    getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
  }
  
  public void a(int paramInt)
  {
    int i1 = 0;
    boolean bool = ((IHomeworkHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt)).a();
    if ((bool) && (paramInt == 1)) {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        if (this.jdField_a_of_type_Int == 1)
        {
          if (this.jdField_c_of_type_Long == 0L)
          {
            HwkTimeAdpater localHwkTimeAdpater = (HwkTimeAdpater)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker.a();
            this.jdField_c_of_type_Long = HwkTimeAdpater.a();
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
      if (i1 >= this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size()) {
        return;
      }
      ((IHomeworkHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(i1))).a(paramInt, bool);
      i1 += 1;
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_c_of_type_Long != 0L) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_c_of_type_Long));
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
        TroopReportor.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, "1", "{\"type\":\"calculation\"}" });
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
        EditItemInfoBase localEditItemInfoBase = (EditItemInfoBase)((Iterator)localObject).next();
        if (localEditItemInfoBase != null) {
          localJSONArray.put(localEditItemInfoBase.a());
        }
      }
    } while (localArrayList.isEmpty());
    if (this.jdField_b_of_type_JavaLangString == null) {}
    for (Object localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      TroopReportor.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(localArrayList.size()), localJSONArray.toString() });
      return;
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    label63:
    String str2;
    switch (paramInt)
    {
    default: 
      this.jdField_d_of_type_JavaLangString = "";
      this.k = false;
      this.jdField_e_of_type_JavaLangString = paramString1;
      this.jdField_f_of_type_JavaLangString = paramString2;
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
      TroopReportor.a("Grp_edu", "homework", "CreateHw_Show", 0, 0, new String[] { paramString2, str2, paramString1, str1 });
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
      if (this.jdField_f_of_type_JavaLangString == null)
      {
        paramString1 = "";
        break label86;
      }
      paramString1 = this.jdField_f_of_type_JavaLangString;
      break label86;
    }
  }
  
  protected void a(int paramInt, ArrayList<UploadEditItemInfo> paramArrayList, HomeworkInfo paramHomeworkInfo)
  {
    if (paramInt == 0)
    {
      paramHomeworkInfo = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        paramHomeworkInfo.addAll(a((UploadEditItemInfo)localIterator.next()));
      }
      paramHomeworkInfo = new ArrayList(new TreeSet(paramHomeworkInfo));
      if (paramHomeworkInfo.isEmpty())
      {
        paramHomeworkInfo = "";
        if (this.jdField_b_of_type_Int != 0) {
          break label277;
        }
        this.jdField_b_of_type_Int += 1;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList.isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramArrayList);
        }
        paramArrayList = getString(2131697494, new Object[] { paramHomeworkInfo });
        QQToast.a(getActivity(), paramArrayList, 0).a();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "Error, reason_code = " + paramInt + ", print trace: ", new RuntimeException("UPLOAD_ERROR"));
      }
      return;
      if (paramHomeworkInfo.size() == 1)
      {
        paramHomeworkInfo = (String)paramHomeworkInfo.get(0);
        break;
      }
      paramHomeworkInfo = (String)paramHomeworkInfo.get(0) + "、" + (String)paramHomeworkInfo.get(1) + HardCodeUtil.a(2131708809);
      break;
      label277:
      paramArrayList = getString(2131697492, new Object[] { paramHomeworkInfo });
      QQToast.a(getActivity(), paramArrayList, 0).a();
      continue;
      if (paramInt == 1) {
        QQToast.a(getActivity(), 2131697456, 0).a();
      } else if (paramInt == 3) {
        QQToast.a(getActivity(), 2131697488, 0).a();
      } else if (paramInt == 2) {
        QQToast.a(getActivity(), 2131694466, 0).a();
      }
    }
  }
  
  protected void a(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 515;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler.sendMessageDelayed(localMessage, paramLong);
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
        QQToast.a(getActivity(), HardCodeUtil.a(2131708810) + 10 + HardCodeUtil.a(2131708814), 0).a();
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
        getActivity().requestPermissions(new PublishHomeWorkFragment.10(this, i2), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
        i1 = 0;
      }
      else
      {
        paramView = TroopHWJsPlugin.a(10 - i2, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
        startActivityForResult(paramView, 259);
        InputMethodUtil.a(getActivity());
        return;
        i1 = 1;
      }
    }
  }
  
  protected void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) {}
    for (int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(4);; i1 = 0)
    {
      if ((i1 > 0) && (!paramBoolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        this.jdField_d_of_type_Boolean = true;
        QQToast.a(getActivity(), 0, HardCodeUtil.a(2131708805), 1).a();
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
      QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230);
      localQQCustomDialog.setMessage(HardCodeUtil.a(2131708824)).setNegativeButton(HardCodeUtil.a(2131708827), new PublishHomeWorkFragment.15(this)).setPositiveButton(HardCodeUtil.a(2131708822), new PublishHomeWorkFragment.14(this, (FormSwitchItem)localObject, paramCompoundButton));
      this.jdField_d_of_type_Boolean = true;
      paramCompoundButton.setChecked(true);
      localQQCustomDialog.show();
      return;
    }
  }
  
  protected void a(HomeworkInfo paramHomeworkInfo)
  {
    int i1 = 0;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo = paramHomeworkInfo;
    paramHomeworkInfo = paramHomeworkInfo.jdField_b_of_type_JavaLangString;
    for (;;)
    {
      try
      {
        paramHomeworkInfo = new JSONObject(paramHomeworkInfo).getJSONArray("c");
        if (i1 < paramHomeworkInfo.length())
        {
          JSONObject localJSONObject = paramHomeworkInfo.getJSONObject(i1);
          if (localJSONObject != null) {
            a(localJSONObject);
          }
        }
        else
        {
          a(new JSONObject().put("c", paramHomeworkInfo).toString());
          if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().isEmpty()))
          {
            this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
            this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
          }
          return;
        }
      }
      catch (Exception paramHomeworkInfo)
      {
        return;
      }
      i1 += 1;
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
  
  protected void a(String paramString, int paramInt)
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
    InputMethodUtil.a(getActivity());
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
  
  protected void a(@NonNull ArrayList<UploadEditItemInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.addAll(a((UploadEditItemInfo)paramArrayList.next()));
    }
    paramArrayList = new ArrayList(new TreeSet(localArrayList));
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    for (;;)
    {
      paramArrayList = getString(2131697494, new Object[] { paramArrayList });
      QQToast.a(getActivity(), paramArrayList, 0).a();
      return;
      if (paramArrayList.size() == 1) {
        paramArrayList = (String)paramArrayList.get(0);
      } else {
        paramArrayList = (String)paramArrayList.get(0) + "、" + (String)paramArrayList.get(1) + HardCodeUtil.a(2131708820);
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      View localView = this.jdField_b_of_type_AndroidViewView;
      if (this.jdField_a_of_type_Boolean)
      {
        i1 = 0;
        localView.setVisibility(i1);
        this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    for (;;)
    {
      b(paramBoolean);
      return;
      i1 = 8;
      break;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.20(this), 20L);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
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
  
  protected void b()
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
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getActivity().getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
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
        QQToast.a(getActivity(), HardCodeUtil.a(2131708806) + 10 + HardCodeUtil.a(2131708823), 0).a();
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
        getActivity().requestPermissions(new PublishHomeWorkFragment.11(this), 3, new String[] { "android.permission.CAMERA" });
        return;
        i1 = 0;
      }
      else
      {
        this.jdField_c_of_type_JavaLangString = TroopHWJsPlugin.a(getActivity(), 260);
        InputMethodUtil.a(getActivity());
        return;
        i1 = 1;
      }
    }
  }
  
  protected void b(HomeworkInfo paramHomeworkInfo)
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
        UploadEditItemInfo localUploadEditItemInfo = (UploadEditItemInfo)((Iterator)localObject).next();
        if (localUploadEditItemInfo != null) {
          if (localUploadEditItemInfo.e() == 1) {
            localArrayList1.add(localUploadEditItemInfo);
          } else if ((localUploadEditItemInfo.e() == 2) || (localUploadEditItemInfo.e() == 0)) {
            localArrayList2.add(localUploadEditItemInfo);
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
        a(0, localArrayList2, paramHomeworkInfo);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: unknown error list");
      }
      a(3, localArrayList2, paramHomeworkInfo);
      return;
      if (paramHomeworkInfo == null) {
        break;
      }
      b(2131697471);
      if (this.jdField_a_of_type_Int == 1)
      {
        d(paramHomeworkInfo);
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    c(paramHomeworkInfo);
    return;
    if (QLog.isColorLevel()) {
      QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: homework info is null");
    }
    a(3, null, paramHomeworkInfo);
  }
  
  protected void b(String paramString)
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
          HomeworkConfig localHomeworkConfig = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a;
          SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("PublishHomeWorkFragment:homework_troop", 0);
          if (localHomeworkConfig != null) {
            if ((HomeWorkConstants.jdField_a_of_type_JavaLangString.equals(paramString)) && (localHomeworkConfig.jdField_a_of_type_Boolean))
            {
              try
              {
                if (!localSharedPreferences.getBoolean(a(4), true)) {
                  continue;
                }
                paramString = new File(new URL(localHomeworkConfig.jdField_b_of_type_JavaLangString).getFile()).getName();
                paramString = new BeginnerGuideDownloadManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHomeworkConfig.jdField_b_of_type_JavaLangString, paramString, localHomeworkConfig.jdField_c_of_type_JavaLangString);
                if (QLog.isColorLevel()) {
                  QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for recite");
                }
                paramString.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler, 4, true);
                return;
              }
              catch (Exception paramString) {}
              if (QLog.isColorLevel()) {
                QLog.d("PublishHomeWorkFragment", 2, "download manager init error ", paramString);
              }
            }
            else
            {
              if ((!HomeWorkConstants.jdField_b_of_type_JavaLangString.equals(paramString)) || (!localHomeworkConfig.jdField_b_of_type_Boolean)) {
                break label300;
              }
              try
              {
                if (localSharedPreferences.getBoolean(a(7), true))
                {
                  paramString = new File(new URL(localHomeworkConfig.jdField_d_of_type_JavaLangString).getFile()).getName();
                  paramString = new BeginnerGuideDownloadManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHomeworkConfig.jdField_d_of_type_JavaLangString, paramString, localHomeworkConfig.jdField_e_of_type_JavaLangString);
                  if (QLog.isColorLevel()) {
                    QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for arithmetic");
                  }
                  paramString.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler, 7, true);
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
      if (HomeWorkConstants.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
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
      this.jdField_a_of_type_AndroidViewView = a(2131373685);
      this.jdField_c_of_type_AndroidViewView = a(2131379903);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard = ((InputMethodGuard)a(2131369165));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getActivity().getLayoutInflater().inflate(2131560777, null, false));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373674));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)a(2131373684));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_b_of_type_AndroidViewView = a(2131363845);
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131378351));
      this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131378350));
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131378349));
      this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131365143));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131373680));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131373687));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131373681));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnClickListener(this);
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new PublishHomeWorkFragment.3(this));
      q();
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.setOnInputMethodChangeListener(this);
      View localView = a(2131373682);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      localView = a(2131373690);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      localView = a(2131373691);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker == null) {
        try
        {
          r();
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker.a() instanceof HwkTimeAdpater))
          {
            HwkTimeAdpater.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker, (HwkTimeAdpater)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker.a());
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
        QQToast.a(getActivity(), HardCodeUtil.a(2131708808) + 6 + HardCodeUtil.a(2131708815), 0).a();
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
          this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.d(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        }
        if (this.jdField_a_of_type_Int == 2)
        {
          if (this.jdField_a_of_type_Long > 0L)
          {
            b(2131697465);
            this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.jdField_a_of_type_Long);
          }
        }
        else {
          return;
        }
        QQToast.a(getActivity(), 2131697490, 0).a();
        getActivity().finish();
        return;
      }
      QQToast.a(getActivity(), 2131697490, 0).a();
      getActivity().finish();
      return;
    }
    QQToast.a(getActivity(), 2131697490, 0).a();
    getActivity().finish();
  }
  
  protected void d(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onClickSelectTime");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker == null) {}
    try
    {
      r();
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker.a() instanceof HwkTimeAdpater)) {
        HwkTimeAdpater.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker, (HwkTimeAdpater)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiUtilsHwkTimePicker.a();
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
    setLeftButton(2131697448, new PublishHomeWorkFragment.5(this));
    setRightButton(2131697462, new PublishHomeWorkFragment.6(this));
    if (this.jdField_a_of_type_Int == 1) {
      setTitle(getResources().getString(2131697464));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new PublishHomeWorkFragment.7(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setFocusChangeListener(new PublishHomeWorkFragment.8(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setSizeLimit(500);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHint(getString(2131697457));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int == 1) {
        ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.9(this), 550L);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
      f();
      return;
      if (this.jdField_a_of_type_Int == 2) {
        setTitle(getResources().getString(2131697437));
      }
    }
  }
  
  public void f()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 513;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler.sendMessage(localMessage);
  }
  
  protected void g()
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
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler.sendMessageDelayed((Message)localObject, 100L);
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
    return 2131560778;
  }
  
  protected void h()
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
  
  protected void i()
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
      TroopReportor.a("Grp_edu", "homework", "CreateHw_Sub", 0, 0, new String[] { localObject1, str, localObject2 });
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
      QQToast.a(getActivity(), 2131697451, 0).a();
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_b_of_type_JavaLangString);
    }
    Object localObject1 = new HomeworkInfo();
    ((HomeworkInfo)localObject1).jdField_b_of_type_Long = 0L;
    ((HomeworkInfo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (TextUtils.isEmpty(((HomeworkInfo)localObject1).jdField_a_of_type_JavaLangString.trim()))
    {
      QQToast.a(getActivity(), 2131697452, 0).a();
      return;
    }
    if (!NetworkUtil.g(getActivity()))
    {
      QQToast.a(getActivity(), 0, 2131694457, 0).a();
      return;
    }
    try
    {
      ((HomeworkInfo)localObject1).jdField_b_of_type_Long = Long.parseLong(getActivity().app.getCurrentUin());
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        ((HomeworkInfo)localObject1).jdField_a_of_type_Long = 0L;
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
      ((HomeworkInfo)localObject1).jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
      ((HomeworkInfo)localObject1).jdField_b_of_type_JavaLangString = localJSONObject.toString();
      if (this.jdField_a_of_type_Int == 2)
      {
        ((HomeworkInfo)localObject1).d = this.jdField_a_of_type_Long;
        ((HomeworkInfo)localObject1).jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_Boolean;
      }
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo = ((HomeworkInfo)localObject1);
      b((HomeworkInfo)localObject1);
      return;
      ((HomeworkInfo)localObject1).jdField_a_of_type_Long = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      break;
      ((HomeworkInfo)localObject1).jdField_a_of_type_JavaUtilList = localJSONObject;
    }
  }
  
  protected void j()
  {
    try
    {
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label393;
      }
      str1 = "";
      str3 = this.jdField_d_of_type_JavaLangString;
      if (this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo != null) {
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
    TroopReportor.a("Grp_edu", "homework", "CreateHw_Complete", 0, 0, new String[] { str1, str3, localObject, str2 });
    if (this.l)
    {
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "";
        TroopReportor.a("Grp_edu", "homework", "CreateHw_EditTitle", 0, 0, new String[] { localObject });
      }
    }
    else
    {
      c(1);
      if ((this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_Boolean))
      {
        if (this.jdField_b_of_type_JavaLangString != null) {
          break label436;
        }
        localObject = "";
        TroopReportor.a("Grp_edu", "homework", "CreateHw_Sub_Open", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString });
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_JavaUtilList.isEmpty())) {
        if (this.jdField_b_of_type_JavaLangString != null) {
          break label444;
        }
      }
    }
    for (localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      TroopReportor.a("Grp_edu", "homework", "CreateHw_CopyGrp", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_a_of_type_JavaUtilList.size()) });
      a(1, "CreateHw_Pic");
      a(2, "CreateHw_Video");
      a(3, "CreateHw_Voice");
      a(7, "CreateHw_Calculate");
      a(4, "CreateHw_Recite");
      QQToast.a(getActivity(), 2131697463, 0).a();
      localObject = AIOUtils.a(new Intent(getActivity(), SplashActivity.class), new int[] { 2 });
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("uin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1);
      getActivity().startActivity((Intent)localObject);
      getActivity().overridePendingTransition(2130771992, 2130772316);
      return;
      str1 = this.jdField_b_of_type_JavaLangString;
      break;
      if (this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "";
        break label26;
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkHomeworkInfo.jdField_b_of_type_JavaLangString;
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
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2131559978, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setMinimumHeight((int)(ScreenUtil.SCREEN_HIGHT * 0.3F));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setAnimationTime(50);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.getActionContentView().setGravity(17);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.registerWatchDisMissActionListener(new PublishHomeWorkFragment.16(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOutsideDismissEnableCompat(true);
    InputMethodUtil.a(getActivity());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  protected void m()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  protected void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler.postDelayed(new PublishHomeWorkFragment.17(this), 400L);
  }
  
  protected void o()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label24:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
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
        int i1 = paramIntent.getIntExtra("HomeWorkConstants:homework_default_index_key", -2147483648);
        localObject = paramIntent.getStringExtra("HomeWorkConstants:homework_default_result_key");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (i1 == -2147483648) {
            break label235;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(i1, (String)localObject);
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
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(EditItemInfoFactory.a((String)localObject));
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
        bool = true;
      }
      if (paramInt2 == -1)
      {
        if (!NetworkUtil.d(getActivity()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublishHomeWorkFragment", 2, "no network toast from capture");
          }
          QQToast.a(getActivity(), 2131697207, 0).a();
          return;
        }
        ImageUtil.a(getActivity(), this.jdField_c_of_type_JavaLangString);
        localObject = new ImageInfo(this.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a((EditItemInfoBase)localObject);
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
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((String)this.jdField_b_of_type_JavaUtilList.get(0) + HardCodeUtil.a(2131708818) + this.jdField_b_of_type_JavaUtilList.size() + HardCodeUtil.a(2131708813));
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
      QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230);
      PublishHomeWorkFragment.18 local18 = new PublishHomeWorkFragment.18(this);
      if (this.jdField_a_of_type_Int == 1) {
        localQQCustomDialog.setMessage(2131697453);
      }
      for (;;)
      {
        localQQCustomDialog.setPositiveButton(2131697454, local18);
        localQQCustomDialog.setNegativeButton(2131697449, local18);
        localQQCustomDialog.show();
        InputMethodUtil.a(getActivity());
        return true;
        if (this.jdField_a_of_type_Int == 2) {
          localQQCustomDialog.setMessage(2131697434);
        }
      }
    }
    InputMethodUtil.a(getActivity());
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
    if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
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
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (!this.i) {
      getActivity().overridePendingTransition(2130771992, 2130772316);
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
    this.g = ImageItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor, paramIntent, this.g);
  }
  
  public void onPause()
  {
    super.onPause();
    InputMethodUtil.a(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment$UIHandler.postDelayed(new PublishHomeWorkFragment.1(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */