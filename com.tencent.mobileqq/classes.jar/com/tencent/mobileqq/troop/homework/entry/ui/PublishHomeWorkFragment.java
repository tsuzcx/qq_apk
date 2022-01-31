package com.tencent.mobileqq.troop.homework.entry.ui;

import aciy;
import ajjy;
import ajtg;
import ajuc;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
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
import awmc;
import ayuv;
import ayvs;
import ayvu;
import ayvy;
import aywf;
import aywg;
import aywh;
import aywi;
import aywj;
import aywk;
import aywl;
import aywm;
import aywn;
import aywo;
import aywp;
import aywq;
import aywr;
import ayws;
import aywt;
import aywu;
import ayxi;
import ayzx;
import ayzz;
import azaa;
import azab;
import azac;
import azaf;
import azak;
import azal;
import azbc;
import azkf;
import azkg;
import azzx;
import babr;
import bacm;
import bacn;
import bade;
import badq;
import bafb;
import bbms;
import bbmy;
import beex;
import begr;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class PublishHomeWorkFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, ayxi
{
  protected int a;
  protected long a;
  protected ajtg a;
  protected ajuc a;
  protected BroadcastReceiver a;
  protected View a;
  public ViewGroup a;
  public EditText a;
  protected ayuv a;
  protected aywu a;
  protected bbms a;
  public begr a;
  public CommonRecordSoundPanel a;
  protected QQAppInterface a;
  protected TroopManager a;
  public InputMethodGuard a;
  public XMediaEditor a;
  protected FormSimpleItem a;
  public FormSwitchItem a;
  public String a;
  protected ArrayList<String> a;
  public List<Pair<Integer, View>> a;
  protected JSONArray a;
  public boolean a;
  protected View b;
  protected ViewGroup b;
  public String b;
  protected List<String> b;
  protected boolean b;
  protected View c;
  protected ViewGroup c;
  protected String c;
  protected boolean c;
  protected ViewGroup d;
  public String d;
  public boolean d;
  protected ViewGroup e;
  public String e;
  public boolean e;
  public String f;
  public boolean f;
  protected boolean g;
  public boolean h;
  protected boolean i;
  public boolean j;
  public boolean k;
  protected boolean l;
  
  public PublishHomeWorkFragment()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aywl(this);
  }
  
  protected static View a(Context paramContext, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setClickable(true);
    localLinearLayout.setGravity(16);
    localLinearLayout.setBackgroundResource(2130843129);
    Object localObject = new LinearLayout.LayoutParams(-2, awmc.a(42.0F));
    ((LinearLayout.LayoutParams)localObject).setMargins(awmc.a(12.0F), 0, 0, 0);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setTextColor(Color.parseColor("#5E6379"));
    ((TextView)localObject).setTextSize(1, 14.0F);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setBackgroundColor(0);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(awmc.a(12.0F), 0, awmc.a(24.0F), 0);
    ((TextView)localObject).setLayoutParams(paramString);
    if (paramInt2 > 0)
    {
      paramContext = new ImageView(paramContext);
      paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext.setImageResource(paramInt2);
      paramString = new LinearLayout.LayoutParams(awmc.a(21.0F), awmc.a(21.0F));
      paramString.setMargins(awmc.a(24.0F), 0, 0, 0);
      paramContext.setLayoutParams(paramString);
      localLinearLayout.addView(paramContext);
    }
    localLinearLayout.addView((View)localObject);
    localLinearLayout.setOnClickListener(paramOnClickListener);
    localLinearLayout.setTag(new aywt(paramInt1, paramObject));
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
    paramContext.setPadding(awmc.a(12.0F), 0, awmc.a(12.0F), 0);
    paramString1 = new LinearLayout.LayoutParams(-1, -2);
    paramString1.setMargins(0, awmc.a(2.0F), 0, awmc.a(4.0F));
    paramContext.setLayoutParams(paramString1);
    paramContext.setText(paramString2);
    localLinearLayout.addView((View)localObject);
    localLinearLayout.addView(paramContext);
    localLinearLayout.setTag(new aywt(paramInt, paramObject));
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
    azkf localazkf = azkf.a();
    Object localObject2 = localazkf.a("troop_create_homework");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://qun.qq.com/homework/features/sethomework.html?_wv=5123&_bid=2146#role=teacher&gid=<$GC>&content=<$CONTENT>&type=word&from=<$FROM>";
    }
    localObject2 = new azkg();
    ((azkg)localObject2).jdField_a_of_type_JavaLangString = paramString;
    ((azkg)localObject2).jdField_c_of_type_JavaLangString = "aio";
    ((azkg)localObject2).i = "";
    paramString = localazkf.a((String)localObject1, (azkg)localObject2);
    if (paramString != null)
    {
      if (!paramString.startsWith("mqqapi://")) {
        break label97;
      }
      paramQQAppInterface = bade.a(paramQQAppInterface, paramContext, paramString);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.c();
      }
    }
    label97:
    do
    {
      return;
      paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
      paramQQAppInterface.putExtra("finish_animation_up_down", true);
      paramQQAppInterface.putExtra("url", paramString);
      paramContext.startActivity(paramQQAppInterface);
    } while (!(paramContext instanceof Activity));
    ((Activity)paramContext).overridePendingTransition(2130772277, 2130771990);
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
        int n = paramView.getChildCount();
        int m = 0;
        while (m < n)
        {
          View localView = a(paramClass, paramView.getChildAt(m));
          if (localView != null) {
            return localView;
          }
          m += 1;
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
    int n;
    int m;
    label38:
    do
    {
      return localObject2;
      if (!(paramView instanceof ViewGroup)) {
        break;
      }
      n = ((ViewGroup)paramView).getChildCount();
      m = 0;
      localObject1 = localObject2;
      localObject2 = localObject1;
    } while (m >= n);
    localObject2 = a(((ViewGroup)paramView).getChildAt(m));
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      m += 1;
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
  
  List<View> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair != null) && (localPair.second != null) && (((View)localPair.second).getTag() != null) && ((((View)localPair.second).getTag() instanceof aywt)) && (((aywt)((View)localPair.second).getTag()).jdField_a_of_type_Int == paramInt)) {
        localArrayList.add(localPair.second);
      }
    }
    return localArrayList;
  }
  
  @NonNull
  protected List<String> a(azak paramazak)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramazak != null)
    {
      if (!(paramazak instanceof azal)) {
        break label50;
      }
      localArrayList.add(ajjy.a(2131643057) + "");
    }
    label50:
    do
    {
      return localArrayList;
      if ((paramazak instanceof azaf))
      {
        localArrayList.add(ajjy.a(2131643040) + "");
        return localArrayList;
      }
      if ((paramazak instanceof ayzz))
      {
        localArrayList.add(ajjy.a(2131643046) + "");
        return localArrayList;
      }
      if ((paramazak instanceof ayzx))
      {
        localArrayList.add(ajjy.a(2131643050) + "");
        return localArrayList;
      }
    } while (!(paramazak instanceof azac));
    localArrayList.add(ajjy.a(2131643054) + "");
    return localArrayList;
  }
  
  public List<Pair<Integer, View>> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a != null))
    {
      if (!ayvy.jdField_a_of_type_JavaLangString.equals(paramString)) {
        break label110;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "add special entry for recite");
        }
        localArrayList.add(new Pair(Integer.valueOf(1), a(getActivity(), 4, ajjy.a(2131643036), 2130839749, new aywj(this), null)));
      }
    }
    label110:
    while ((!ayvy.jdField_b_of_type_JavaLangString.equals(paramString)) || (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_b_of_type_Boolean)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "add special entry for arithmetic");
    }
    localArrayList.add(new Pair(Integer.valueOf(2), a(getActivity(), 7, ajjy.a(2131643058), ajjy.a(2131643045), new aywk(this), null)));
    return localArrayList;
  }
  
  protected void a()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Aywu = new aywu(this, Looper.getMainLooper());
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
      this.jdField_a_of_type_Ajtg = ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
      this.jdField_a_of_type_Ajuc = new aywm(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
    } while (this.l);
    this.l = true;
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
        if (this.jdField_a_of_type_Bbms == null)
        {
          this.jdField_a_of_type_Bbms = new bbms(getActivity(), getActivity().getTitleBarHeight());
          this.jdField_a_of_type_Bbms.setCancelable(false);
          this.jdField_a_of_type_Bbms.show();
        }
        this.jdField_a_of_type_Bbms.c(paramInt);
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
        azzx.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, "1", "{\"type\":\"calculation\"}" });
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
        azaa localazaa = (azaa)((Iterator)localObject).next();
        if (localazaa != null) {
          localJSONArray.put(localazaa.a());
        }
      }
    } while (localArrayList.isEmpty());
    if (this.jdField_b_of_type_JavaLangString == null) {}
    for (Object localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      azzx.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(localArrayList.size()), localJSONArray.toString() });
      return;
    }
  }
  
  public void a(int paramInt, ArrayList<azak> paramArrayList, ayuv paramayuv)
  {
    if (paramInt == 0)
    {
      paramayuv = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        paramayuv.addAll(a((azak)localIterator.next()));
      }
      paramayuv = new ArrayList(new TreeSet(paramayuv));
      if (paramayuv.isEmpty())
      {
        paramayuv = "";
        if (this.jdField_a_of_type_Int != 0) {
          break label277;
        }
        this.jdField_a_of_type_Int += 1;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList.isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramArrayList);
        }
        paramArrayList = getString(2131632024, new Object[] { paramayuv });
        bbmy.a(getActivity(), paramArrayList, 0).a();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublishHomeWorkFragment", 2, "Error, reason_code = " + paramInt + ", print trace: ", new RuntimeException("UPLOAD_ERROR"));
      }
      return;
      if (paramayuv.size() == 1)
      {
        paramayuv = (String)paramayuv.get(0);
        break;
      }
      paramayuv = (String)paramayuv.get(0) + "、" + (String)paramayuv.get(1) + ajjy.a(2131643038);
      break;
      label277:
      paramArrayList = getString(2131632022, new Object[] { paramayuv });
      bbmy.a(getActivity(), paramArrayList, 0).a();
      continue;
      if (paramInt == 1) {
        bbmy.a(getActivity(), 2131631992, 0).a();
      } else if (paramInt == 3) {
        bbmy.a(getActivity(), 2131632018, 0).a();
      } else if (paramInt == 2) {
        bbmy.a(getActivity(), 2131628954, 0).a();
      }
    }
  }
  
  protected void a(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 515;
    this.jdField_a_of_type_Aywu.sendMessageDelayed(localMessage, paramLong);
  }
  
  protected void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onPictureBtnClick");
    }
    int m = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(1) + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(2);
    if (m >= 10)
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 2000L)
      {
        bbmy.a(getActivity(), ajjy.a(2131643039) + 10 + ajjy.a(2131643043), 0).a();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    paramView = TroopHWJsPlugin.a(10 - m, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
    startActivityForResult(paramView, 259);
    beex.a(getActivity());
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) {}
    for (int m = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(4);; m = 0)
    {
      if ((m > 0) && (!paramBoolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        this.jdField_d_of_type_Boolean = true;
        bbmy.a(getActivity(), 0, ajjy.a(2131643034), 1).a();
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
      bafb localbafb = babr.a(getActivity(), 230);
      localbafb.setMessage(ajjy.a(2131643053)).setNegativeButton(ajjy.a(2131643056), new aywg(this)).setPositiveButton(ajjy.a(2131643051), new aywf(this, (FormSwitchItem)localObject, paramCompoundButton));
      this.jdField_d_of_type_Boolean = true;
      paramCompoundButton.setChecked(true);
      localbafb.show();
      return;
    }
  }
  
  public void a(ayuv paramayuv)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        azak localazak = (azak)((Iterator)localObject).next();
        if (localazak != null) {
          if (localazak.e() == 1) {
            localArrayList1.add(localazak);
          } else if ((localazak.e() == 2) || (localazak.e() == 0)) {
            localArrayList2.add(localazak);
          }
        }
      }
      if (!localArrayList1.isEmpty())
      {
        a(localArrayList1);
        return;
      }
      if (!localArrayList2.isEmpty())
      {
        a(0, localArrayList2, paramayuv);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: unknown error list");
      }
      a(3, localArrayList2, paramayuv);
      return;
    }
    if ((this.jdField_a_of_type_Ajtg != null) && (paramayuv != null))
    {
      a(2131632005);
      this.jdField_a_of_type_Ajtg.a(paramayuv);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PublishHomeWorkFragment", 2, "UPLOAD_ERROR_UNKNOWN_ERROR: homework info is null");
    }
    a(3, null, paramayuv);
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
          ayvu localayvu = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a;
          SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("PublishHomeWorkFragment:homework_troop", 0);
          if (localayvu != null) {
            if ((ayvy.jdField_a_of_type_JavaLangString.equals(paramString)) && (localayvu.jdField_a_of_type_Boolean))
            {
              try
              {
                if (!localSharedPreferences.getBoolean(a(4), true)) {
                  continue;
                }
                paramString = new File(new URL(localayvu.jdField_b_of_type_JavaLangString).getFile()).getName();
                paramString = new ayvs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayvu.jdField_b_of_type_JavaLangString, paramString, localayvu.jdField_c_of_type_JavaLangString);
                if (QLog.isColorLevel()) {
                  QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for recite");
                }
                paramString.a(this.jdField_a_of_type_Aywu, 4, true);
                return;
              }
              catch (Exception paramString) {}
              if (QLog.isColorLevel()) {
                QLog.d("PublishHomeWorkFragment", 2, "download manager init error ", paramString);
              }
            }
            else
            {
              if ((!ayvy.jdField_b_of_type_JavaLangString.equals(paramString)) || (!localayvu.jdField_b_of_type_Boolean)) {
                break label300;
              }
              try
              {
                if (localSharedPreferences.getBoolean(a(7), true))
                {
                  paramString = new File(new URL(localayvu.jdField_d_of_type_JavaLangString).getFile()).getName();
                  paramString = new ayvs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayvu.jdField_d_of_type_JavaLangString, paramString, localayvu.e);
                  if (QLog.isColorLevel()) {
                    QLog.d("PublishHomeWorkFragment", 2, "prepareBeginnerGuide start download for arithmetic");
                  }
                  paramString.a(this.jdField_a_of_type_Aywu, 7, true);
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
    beex.a(getActivity());
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
  
  protected void a(@NonNull ArrayList<azak> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.addAll(a((azak)paramArrayList.next()));
    }
    paramArrayList = new ArrayList(new TreeSet(localArrayList));
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    for (;;)
    {
      paramArrayList = getString(2131632024, new Object[] { paramArrayList });
      bbmy.a(getActivity(), paramArrayList, 0).a();
      return;
      if (paramArrayList.size() == 1) {
        paramArrayList = (String)paramArrayList.get(0);
      } else {
        paramArrayList = (String)paramArrayList.get(0) + "、" + (String)paramArrayList.get(1) + ajjy.a(2131643049);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      View localView = this.jdField_b_of_type_AndroidViewView;
      if (this.jdField_a_of_type_Boolean) {}
      for (int m = 0;; m = 8)
      {
        localView.setVisibility(m);
        this.jdField_e_of_type_AndroidViewViewGroup.setVisibility(8);
        return;
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Aywu.postDelayed(new PublishHomeWorkFragment.16(this), 20L);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
    ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.15(this), 10L);
    a(paramBoolean);
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (paramInt = 8;; paramInt = 0)
    {
      localView.setVisibility(paramInt);
      if (ayvy.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
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
      int m = ((JSONArray)localObject).length();
      if (m <= 0) {
        return true;
      }
      if (m == 1)
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
    View localView;
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView = a(2131306442);
      this.jdField_c_of_type_AndroidViewView = a(2131311970);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard = ((InputMethodGuard)a(2131302588));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getActivity().getLayoutInflater().inflate(2131494775, null, false));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306431));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)a(2131306441));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_b_of_type_AndroidViewView = a(2131297844);
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131310580));
      this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131310579));
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131310578));
      this.jdField_e_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131298993));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131306437));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131306438));
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aywn(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.setOnInputMethodChangeListener(this);
      localView = a(2131306439);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      localView = a(2131306446);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      localView = a(2131306447);
    } while (localView == null);
    localView.setOnClickListener(this);
  }
  
  protected void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onVideoBtnClick");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(1) + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(2) >= 10)
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 2000L)
      {
        bbmy.a(getActivity(), ajjy.a(2131643035) + 10 + ajjy.a(2131643052), 0).a();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    this.jdField_c_of_type_JavaLangString = TroopHWJsPlugin.a(getActivity(), 260);
    beex.a(getActivity());
  }
  
  protected void c()
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      String str = ((Bundle)localObject).getString("extra.GROUP_UIN");
      this.h = ((Bundle)localObject).getBoolean("BeginnerGuideFragment:from_beginner_guide", false);
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_b_of_type_JavaLangString = str;
        if (QLog.isColorLevel()) {
          QLog.d("PublishHomeWorkFragment", 2, "uin: " + str);
        }
        e();
        a(8000L);
        this.jdField_a_of_type_Ajtg.d(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        localObject = ((Bundle)localObject).getString("HomeWorkConstants:homework_default_request_key");
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
      try
      {
        this.jdField_a_of_type_OrgJsonJSONArray = new JSONObject((String)localObject).getJSONArray("c");
        return;
        bbmy.a(getActivity(), 2131632020, 0).a();
        getActivity().finish();
        return;
      }
      catch (Exception localException)
      {
        do
        {
          this.jdField_a_of_type_OrgJsonJSONArray = null;
        } while (!QLog.isColorLevel());
        QLog.e("PublishHomeWorkFragment", 2, "error when parse homework ", localException);
        return;
      }
    }
    bbmy.a(getActivity(), 2131632020, 0).a();
    getActivity().finish();
  }
  
  protected void c(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onRecordBtnClick");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(3) >= 6)
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 2000L)
      {
        bbmy.a(getActivity(), ajjy.a(2131643037) + 6 + ajjy.a(2131643044), 0).a();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    k();
  }
  
  protected void d()
  {
    setLeftButton(2131631984, new aywo(this));
    setRightButton(2131631997, new aywp(this));
    setTitle(getResources().getString(2131631999));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new aywq(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setFocusChangeListener(new aywr(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setSizeLimit(500);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHint(getString(2131631993));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_OrgJsonJSONArray != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setData(this.jdField_a_of_type_OrgJsonJSONArray.toString());
    }
    ThreadManager.getUIHandler().postDelayed(new PublishHomeWorkFragment.8(this), 550L);
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    e();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    getActivity().getWindow().setSoftInputMode(16);
    a();
    b();
    c();
    d();
    if (BaseApplicationImpl.sProcessId != 9) {
      SubmitHomeWorkFragment.a(getActivity());
    }
  }
  
  public void e()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 513;
    this.jdField_a_of_type_Aywu.sendMessage(localMessage);
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
    for (int m = 1;; m = 0)
    {
      if (m != 0)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.a());
        if ((this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 8) || (this.jdField_b_of_type_AndroidViewViewGroup.getHeight() <= 0))
        {
          localObject = Message.obtain();
          ((Message)localObject).what = 514;
          this.jdField_a_of_type_Aywu.sendMessageDelayed((Message)localObject, 100L);
        }
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
    }
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
  
  public int getContentLayoutId()
  {
    return 2131494776;
  }
  
  public void h()
  {
    if (this.jdField_b_of_type_JavaLangString == null) {}
    Object localObject3;
    for (Object localObject1 = "";; localObject1 = this.jdField_b_of_type_JavaLangString)
    {
      azzx.a("Grp_edu", "homework", "CreateHw_Sub", 0, 0, new String[] { localObject1, this.jdField_d_of_type_JavaLangString });
      localObject2 = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a());
      localObject1 = new JSONArray();
      int n = ((JSONArray)localObject2).length();
      int m = 0;
      while (m < n)
      {
        localObject3 = ((JSONArray)localObject2).optJSONObject(m);
        if (a((JSONObject)localObject3)) {
          ((JSONArray)localObject1).put(localObject3);
        }
        m += 1;
      }
    }
    if (((JSONArray)localObject1).length() <= 0)
    {
      bbmy.a(getActivity(), 2131631987, 0).a();
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_b_of_type_JavaLangString);
    }
    Object localObject2 = new ayuv();
    ((ayuv)localObject2).jdField_b_of_type_Long = 0L;
    ((ayuv)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (TextUtils.isEmpty(((ayuv)localObject2).jdField_a_of_type_JavaLangString.trim()))
    {
      bbmy.a(getActivity(), 2131631988, 0).a();
      return;
    }
    if (!badq.g(getActivity()))
    {
      bbmy.a(getActivity(), 0, 2131628946, 0).a();
      return;
    }
    try
    {
      ((ayuv)localObject2).jdField_b_of_type_Long = Long.parseLong(getActivity().app.c());
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        ((ayuv)localObject2).jdField_a_of_type_Long = 0L;
        localObject3 = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ((List)localObject3).add(Long.valueOf(Long.parseLong((String)localIterator.next())));
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
      ((JSONArray)localObject1).put(new JSONObject("{\"type\":\"calculation\"}"));
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("c", localObject1);
      ((ayuv)localObject2).jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
      ((ayuv)localObject2).jdField_b_of_type_JavaLangString = localJSONObject.toString();
      this.jdField_a_of_type_Ayuv = ((ayuv)localObject2);
      localObject1 = babr.a(getActivity(), 230);
      localObject2 = new ayws(this, (ayuv)localObject2);
      ((bafb)localObject1).setMessage(2131631986);
      ((bafb)localObject1).setPositiveButton(2131631991, (DialogInterface.OnClickListener)localObject2);
      ((bafb)localObject1).setNegativeButton(2131631985, (DialogInterface.OnClickListener)localObject2);
      ((bafb)localObject1).show();
      return;
      ((ayuv)localObject2).jdField_a_of_type_Long = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      break;
      ((ayuv)localObject2).jdField_a_of_type_JavaUtilList = localJSONObject;
    }
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label349;
      }
      str1 = "";
      str3 = this.jdField_d_of_type_JavaLangString;
      if (this.jdField_a_of_type_Ayuv != null) {
        break label357;
      }
      localObject = "";
      label26:
      if (!this.jdField_d_of_type_Boolean) {
        break label404;
      }
      str2 = "1";
    }
    catch (Exception localException)
    {
      label392:
      label404:
      for (;;)
      {
        String str1;
        String str3;
        Object localObject;
        label99:
        label357:
        continue;
        label349:
        String str2 = "0";
      }
    }
    azzx.a("Grp_edu", "homework", "CreateHw_Complete", 0, 0, new String[] { str1, str3, localObject, str2 });
    if ((this.jdField_a_of_type_Ayuv != null) && (this.jdField_a_of_type_Ayuv.jdField_a_of_type_Boolean))
    {
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "";
        azzx.a("Grp_edu", "homework", "CreateHw_Sub_Open", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString });
      }
    }
    else if ((this.jdField_a_of_type_Ayuv != null) && (this.jdField_a_of_type_Ayuv.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_Ayuv.jdField_a_of_type_JavaUtilList.isEmpty())) {
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label392;
      }
    }
    for (localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      azzx.a("Grp_edu", "homework", "CreateHw_CopyGrp", 0, 0, new String[] { localObject, this.jdField_d_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Ayuv.jdField_a_of_type_JavaUtilList.size()) });
      a(1, "CreateHw_Pic");
      a(2, "CreateHw_Video");
      a(3, "CreateHw_Voice");
      a(7, "CreateHw_Calculate");
      a(4, "CreateHw_Recite");
      bbmy.a(getActivity(), 2131631998, 0).a();
      localObject = aciy.a(new Intent(getActivity(), SplashActivity.class), new int[] { 2 });
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("uin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1);
      getActivity().startActivity((Intent)localObject);
      getActivity().overridePendingTransition(2130771990, 2130772279);
      return;
      str1 = this.jdField_b_of_type_JavaLangString;
      break;
      if (this.jdField_a_of_type_Ayuv.jdField_b_of_type_JavaLangString == null)
      {
        localObject = "";
        break label26;
      }
      localObject = this.jdField_a_of_type_Ayuv.jdField_b_of_type_JavaLangString;
      break label26;
      localObject = this.jdField_b_of_type_JavaLangString;
      break label99;
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
    if (this.jdField_a_of_type_Begr == null)
    {
      this.jdField_a_of_type_Begr = begr.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2131494089, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Aywu);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setMinimumHeight((int)(awmc.b * 0.3F));
      this.jdField_a_of_type_Begr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
      this.jdField_a_of_type_Begr.e(50);
      this.jdField_a_of_type_Begr.a().setGravity(17);
      this.jdField_a_of_type_Begr.a(new aywh(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    this.jdField_a_of_type_Begr.c(true);
    beex.a(getActivity());
    this.jdField_a_of_type_Begr.show();
  }
  
  public void l()
  {
    this.jdField_a_of_type_Begr.dismiss();
  }
  
  public void m()
  {
    this.jdField_a_of_type_Aywu.postDelayed(new PublishHomeWorkFragment.13(this), 400L);
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bbms.dismiss();
      label24:
      this.jdField_a_of_type_Bbms = null;
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
    label217:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramIntent != null) && (paramInt2 == 257))
            {
              paramInt1 = paramIntent.getIntExtra("HomeWorkConstants:homework_default_index_key", -2147483648);
              paramIntent = paramIntent.getStringExtra("HomeWorkConstants:homework_default_result_key");
              if (!TextUtils.isEmpty(paramIntent))
              {
                if (paramInt1 == -2147483648) {
                  break label217;
                }
                this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramInt1, paramIntent);
                this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
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
              this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(azab.a(paramIntent));
              this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
              bool = true;
            }
          } while (paramInt2 != -1);
          if (!badq.d(getActivity()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PublishHomeWorkFragment", 2, "no network toast from capture");
            }
            bbmy.a(getActivity(), 2131631771, 0).a();
            return;
          }
          bacm.a(getActivity(), this.jdField_c_of_type_JavaLangString);
          paramIntent = new azaf(this.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramIntent);
          return;
        } while ((paramIntent == null) || (paramInt2 != 262));
        ArrayList localArrayList = paramIntent.getStringArrayListExtra("HomeWorkConstants:homework_async_uin_list_key");
        paramIntent = paramIntent.getStringArrayListExtra("HomeWorkConstants:homework_async_name_list_key");
        if (localArrayList != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
        }
        if (paramIntent != null)
        {
          this.jdField_b_of_type_JavaUtilList.clear();
          this.jdField_b_of_type_JavaUtilList.addAll(paramIntent);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null);
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
    } while (this.jdField_b_of_type_JavaUtilList.size() <= 1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((String)this.jdField_b_of_type_JavaUtilList.get(0) + ajjy.a(2131643047) + this.jdField_b_of_type_JavaUtilList.size() + ajjy.a(2131643042));
  }
  
  public boolean onBackEvent()
  {
    if (!a())
    {
      bafb localbafb = babr.a(getActivity(), 230);
      aywi localaywi = new aywi(this);
      localbafb.setMessage(2131631989);
      localbafb.setPositiveButton(2131631990, localaywi);
      localbafb.setNegativeButton(2131631985, localaywi);
      localbafb.show();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131306439: 
      a(paramView);
      return;
    case 2131306446: 
      b(paramView);
      return;
    case 2131306447: 
      c(paramView);
      return;
    }
    j();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.jdField_a_of_type_Ajuc != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
    }
    TroopHWJsPlugin.a();
    if (this.l)
    {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.l = false;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_Aywu.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (!this.i) {
      getActivity().overridePendingTransition(2130771990, 2130772279);
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
    this.g = azbc.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor, paramIntent, this.g);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Aywu.postDelayed(new PublishHomeWorkFragment.1(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */