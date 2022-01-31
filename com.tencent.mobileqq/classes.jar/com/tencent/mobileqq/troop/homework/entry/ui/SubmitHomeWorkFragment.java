package com.tencent.mobileqq.troop.homework.entry.ui;

import ajjy;
import ajtg;
import ajuc;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import awmc;
import ayuv;
import ayvy;
import aywv;
import ayww;
import aywx;
import aywy;
import aywz;
import ayxa;
import ayxb;
import ayxc;
import ayxd;
import ayxe;
import ayxi;
import ayzx;
import ayzz;
import azaa;
import azac;
import azae;
import azaf;
import azak;
import azal;
import azbc;
import azvv;
import azzx;
import babr;
import bacm;
import badq;
import bafb;
import bajq;
import bbms;
import bbmy;
import beex;
import begr;
import bheo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SubmitHomeWorkFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, ayxi
{
  protected int a;
  public long a;
  protected ajtg a;
  protected ajuc a;
  protected BroadcastReceiver a;
  protected View a;
  protected ViewGroup a;
  public ayuv a;
  protected ayxe a;
  protected bbms a;
  public begr a;
  public CommonRecordSoundPanel a;
  protected QQAppInterface a;
  protected InputMethodGuard a;
  public XMediaEditor a;
  protected String a;
  public LinkedList<JSONObject> a;
  public boolean a;
  protected long b;
  protected View b;
  protected ayuv b;
  public XMediaEditor b;
  protected String b;
  public boolean b;
  protected long c;
  protected View c;
  public String c;
  protected boolean c;
  public String d;
  protected boolean d;
  
  public SubmitHomeWorkFragment()
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ayww(this);
  }
  
  public static Intent a(Activity paramActivity, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("hide_title_left_arrow", true);
    localIntent.putExtra("SubmitHomeWorkFragment:valid", "SubmitHomeWorkFragment:valid");
    localIntent.putExtra("HomeWorkConstants:homework_id_default_request_key", paramLong2);
    localIntent.putExtra("extra.GROUP_UIN", String.valueOf(paramLong1));
    localIntent.putExtra("public_fragment_class", SubmitHomeWorkFragment.class.getName());
    localIntent.setClass(paramActivity, PublicFragmentActivity.class);
    return localIntent;
  }
  
  public static void a(Activity paramActivity)
  {
    bheo.a(BaseApplicationImpl.getContext());
  }
  
  public static void a(Activity paramActivity, @Nullable Bundle paramBundle, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("hide_title_left_arrow", true);
    localBundle.putLong("HomeWorkConstants:homework_id_default_request_key", paramLong2);
    localBundle.putString("SubmitHomeWorkFragment:valid", "SubmitHomeWorkFragment:valid");
    if (paramLong1 > 0L) {
      localBundle.putString("extra.GROUP_UIN", String.valueOf(paramLong1));
    }
    localIntent.putExtras(localBundle);
    PublicFragmentActivity.a(paramActivity, localIntent, SubmitHomeWorkFragment.class);
  }
  
  protected <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  protected EditText a(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramView == null) {
      localObject2 = localObject1;
    }
    int j;
    int i;
    label38:
    do
    {
      return localObject2;
      if (!(paramView instanceof ViewGroup)) {
        break;
      }
      j = ((ViewGroup)paramView).getChildCount();
      i = 0;
      localObject1 = localObject2;
      localObject2 = localObject1;
    } while (i >= j);
    localObject2 = a(((ViewGroup)paramView).getChildAt(i));
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      i += 1;
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
  
  @NonNull
  protected List<String> a(azak paramazak)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramazak != null)
    {
      if (!(paramazak instanceof azal)) {
        break label49;
      }
      localArrayList.add(ajjy.a(2131648846) + "");
    }
    label49:
    do
    {
      return localArrayList;
      if ((paramazak instanceof azaf))
      {
        localArrayList.add(ajjy.a(2131648839) + "");
        return localArrayList;
      }
      if ((paramazak instanceof ayzz))
      {
        localArrayList.add(ajjy.a(2131648833) + "");
        return localArrayList;
      }
      if ((paramazak instanceof ayzx))
      {
        localArrayList.add(ajjy.a(2131648842) + "");
        return localArrayList;
      }
    } while (!(paramazak instanceof azac));
    localArrayList.add(ajjy.a(2131648836) + "");
    return localArrayList;
  }
  
  List<Boolean> a(@NonNull JSONArray paramJSONArray1, @NonNull JSONArray paramJSONArray2)
  {
    bool5 = true;
    bool4 = false;
    localArrayList = new ArrayList(3);
    try
    {
      localObject = new JSONArray(this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a());
      localJSONArray = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a());
      j = ((JSONArray)localObject).length();
      i = 0;
    }
    catch (Exception paramJSONArray1)
    {
      for (;;)
      {
        int i;
        try
        {
          Object localObject;
          JSONArray localJSONArray;
          int j;
          JSONObject localJSONObject;
          if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
            continue;
          }
          bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a().equals(this.jdField_c_of_type_JavaLangString);
          if (!bool2)
          {
            bool3 = true;
            bool2 = bool3;
          }
        }
        catch (Exception paramJSONArray1)
        {
          boolean bool1;
          boolean bool6;
          boolean bool7;
          boolean bool8;
          boolean bool2 = false;
          boolean bool3 = false;
          continue;
          bool2 = false;
          bool3 = false;
          continue;
        }
        try
        {
          i = paramJSONArray1.length();
          if (i > 0)
          {
            bool4 = true;
            if (bool3) {
              continue;
            }
          }
        }
        catch (Exception paramJSONArray1)
        {
          bool5 = false;
          bool4 = bool2;
          bool2 = bool5;
          continue;
          continue;
        }
        try
        {
          i = paramJSONArray1.length();
          if (i > 0)
          {
            bool3 = bool5;
            bool5 = bool3;
            bool6 = bool2;
            bool7 = bool4;
            bool8 = bool1;
            localArrayList.add(Boolean.valueOf(bool5));
            localArrayList.add(Boolean.valueOf(bool6));
            localArrayList.add(Boolean.valueOf(bool7));
            localArrayList.add(Boolean.valueOf(bool8));
            return localArrayList;
            bool1 = false;
            continue;
            bool3 = false;
            continue;
            bool4 = false;
            continue;
          }
          bool3 = false;
          continue;
          paramJSONArray1 = paramJSONArray1;
          bool2 = false;
          bool3 = false;
          bool1 = false;
        }
        catch (Exception paramJSONArray1)
        {
          bool5 = bool2;
          bool2 = bool4;
          bool4 = bool5;
          continue;
        }
        bool8 = bool1;
        bool7 = bool2;
        bool6 = bool4;
        bool5 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.e("SubmitHomeWorkFragment", 2, "check isHomeWorkModify error", paramJSONArray1);
          bool8 = bool1;
          bool7 = bool2;
          bool6 = bool4;
          bool5 = bool3;
          continue;
          i += 1;
          continue;
          i += 1;
        }
      }
    }
    if (i < j)
    {
      localJSONObject = ((JSONArray)localObject).optJSONObject(i);
      if (a(localJSONObject)) {
        paramJSONArray1.put(localJSONObject);
      }
    }
    else
    {
      j = localJSONArray.length();
      i = 0;
      if (i < j)
      {
        localObject = localJSONArray.optJSONObject(i);
        if (!a((JSONObject)localObject)) {
          break label434;
        }
        paramJSONArray2.put(localObject);
        break label434;
      }
      bool1 = this.jdField_a_of_type_JavaUtilLinkedList.isEmpty();
      if (!bool1) {
        bool1 = true;
      }
    }
  }
  
  protected void a()
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Ayxe = new ayxe(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    if (getActivity() == null)
    {
      localObject = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label75;
      }
      getActivity().finish();
    }
    label75:
    do
    {
      return;
      localObject = (QQAppInterface)getActivity().getAppInterface();
      break;
      this.jdField_a_of_type_Ajtg = ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
      this.jdField_a_of_type_Ajuc = new aywv(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
    } while (this.jdField_d_of_type_Boolean);
    this.jdField_d_of_type_Boolean = true;
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
  
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    ArrayList localArrayList;
    JSONArray localJSONArray;
    for (Object localObject = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor;; localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor)
    {
      localArrayList = ((XMediaEditor)localObject).a(paramInt);
      localJSONArray = new JSONArray();
      localObject = localArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        azaa localazaa = (azaa)((Iterator)localObject).next();
        if (localazaa != null) {
          localJSONArray.put(localazaa.a());
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      if (this.jdField_d_of_type_JavaLangString == null)
      {
        localObject = "";
        azzx.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, "", String.valueOf(localArrayList.size()), localJSONArray.toString() });
      }
    }
    else
    {
      if (paramInt != 7) {
        break label255;
      }
      paramString = localArrayList.iterator();
      paramInt = 0;
      label162:
      if (!paramString.hasNext()) {
        break label216;
      }
      localObject = (azaa)paramString.next();
      if ((localObject == null) || (!(localObject instanceof ayzx))) {
        break label264;
      }
      paramInt = ((ayzx)localObject).c();
    }
    label264:
    for (;;)
    {
      break label162;
      localObject = this.jdField_d_of_type_JavaLangString;
      break;
      label216:
      if (this.jdField_d_of_type_JavaLangString == null) {}
      for (paramString = "";; paramString = this.jdField_d_of_type_JavaLangString)
      {
        azzx.a("Grp_edu", "Grp_oral", "Finish_Oral_Number", 0, 0, new String[] { paramString, String.valueOf(paramInt) });
        label255:
        return;
      }
    }
  }
  
  public void a(int paramInt, ArrayList<azak> paramArrayList1, ArrayList<azak> paramArrayList2, ayuv paramayuv)
  {
    if (paramInt == 0)
    {
      paramayuv = new ArrayList();
      Iterator localIterator = paramArrayList1.iterator();
      while (localIterator.hasNext()) {
        paramayuv.addAll(a((azak)localIterator.next()));
      }
      localIterator = paramArrayList2.iterator();
      while (localIterator.hasNext()) {
        paramayuv.addAll(a((azak)localIterator.next()));
      }
      paramayuv = new ArrayList(new TreeSet(paramayuv));
      if (paramayuv.isEmpty())
      {
        paramayuv = "";
        if (this.jdField_a_of_type_Int != 0) {
          break label353;
        }
        this.jdField_a_of_type_Int += 1;
        if ((this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList1.isEmpty())) {
          this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramArrayList1);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null) && (!paramArrayList2.isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramArrayList2);
        }
        paramArrayList1 = getString(2131632024, new Object[] { paramayuv });
        bbmy.a(getActivity(), paramArrayList1, 0).a();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubmitHomeWorkFragment", 2, "Error, reason_code = " + paramInt + ", print trace: ", new RuntimeException("UPLOAD_ERROR"));
      }
      return;
      if (paramayuv.size() == 1)
      {
        paramayuv = (String)paramayuv.get(0);
        break;
      }
      paramayuv = (String)paramayuv.get(0) + "、" + (String)paramayuv.get(1) + ajjy.a(2131648835);
      break;
      label353:
      paramArrayList1 = getString(2131632022, new Object[] { paramayuv });
      bbmy.a(getActivity(), paramArrayList1, 0).a();
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
  
  protected void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "onPictureBtnClick");
    }
    int i = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(1) + this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(2);
    if (i >= 10)
    {
      if (System.currentTimeMillis() - this.jdField_c_of_type_Long >= 2000L)
      {
        bbmy.a(getActivity(), ajjy.a(2131648845) + 10 + ajjy.a(2131648843), 0).a();
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    paramView = TroopHWJsPlugin.a(10 - i, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
    startActivity(paramView);
    beex.a(getActivity());
  }
  
  public void a(ayuv paramayuv)
  {
    Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
    if (localObject1 == null) {
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      if (localObject2 == null) {
        localObject2 = new ArrayList();
      }
      for (;;)
      {
        if ((!((ArrayList)localObject1).isEmpty()) || (!((ArrayList)localObject2).isEmpty()))
        {
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          ArrayList localArrayList3 = new ArrayList();
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            azak localazak = (azak)((Iterator)localObject1).next();
            if (localazak != null) {
              if (localazak.e() == 1) {
                localArrayList3.add(localazak);
              } else if ((localazak.e() == 2) || (localazak.e() == 0)) {
                localArrayList1.add(localazak);
              }
            }
          }
          localObject1 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (azak)((Iterator)localObject1).next();
            if (localObject2 != null) {
              if (((azak)localObject2).e() == 1) {
                localArrayList3.add(localObject2);
              } else if ((((azak)localObject2).e() == 2) || (((azak)localObject2).e() == 0)) {
                localArrayList2.add(localObject2);
              }
            }
          }
          if (!localArrayList3.isEmpty())
          {
            a(localArrayList3);
            return;
          }
          if ((!localArrayList1.isEmpty()) || (!localArrayList2.isEmpty()))
          {
            a(0, localArrayList1, localArrayList2, paramayuv);
            return;
          }
          a(3, null, null, paramayuv);
          return;
        }
        if ((this.jdField_a_of_type_Ajtg != null) && (paramayuv != null))
        {
          a(2131631983);
          this.jdField_b_of_type_Ayuv = paramayuv;
          this.jdField_b_of_type_Long = paramayuv.jdField_c_of_type_Long;
          this.jdField_a_of_type_Ajtg.a(paramayuv.jdField_c_of_type_Long, paramayuv.jdField_a_of_type_Long, paramayuv.jdField_b_of_type_JavaLangString);
          return;
        }
        a(3, null, null, paramayuv);
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.has("c")) {
          break label147;
        }
        paramString = paramString.getJSONArray("c");
        if (paramString != null)
        {
          this.jdField_b_of_type_JavaLangString = paramString.toString();
          if (i < paramString.length())
          {
            JSONObject localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject == null) {
              break label177;
            }
            String str = localJSONObject.getString("type");
            if (!TextUtils.isEmpty(str))
            {
              if (Arrays.asList(ayvy.c).contains(str)) {
                this.jdField_a_of_type_JavaUtilLinkedList.add(localJSONObject);
              }
            }
            else if (QLog.isColorLevel()) {
              QLog.d("SubmitHomeWorkFragment", 2, "home work must contains type key");
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SubmitHomeWorkFragment", 2, "parse homework json error", paramString);
        }
        return;
      }
      e();
      return;
      label147:
      paramString = new IllegalArgumentException("home work json format error");
      if (QLog.isColorLevel())
      {
        QLog.e("SubmitHomeWorkFragment", 2, paramString, new Object[0]);
        return;
        label177:
        i += 1;
      }
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
        paramArrayList = (String)paramArrayList.get(0) + "、" + (String)paramArrayList.get(1) + ajjy.a(2131648844);
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("detect input method state changed, current state is ");
      if (!paramBoolean) {
        break label51;
      }
    }
    label51:
    for (String str = "on";; str = "off")
    {
      QLog.d("SubmitHomeWorkFragment", 2, str);
      a(paramBoolean);
      return;
    }
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
      this.jdField_a_of_type_AndroidViewView = a(2131310849);
      this.jdField_b_of_type_AndroidViewView = a(2131297844);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard = ((InputMethodGuard)a(2131302588));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.setOnInputMethodChangeListener(this);
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)a(2131302049));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getActivity().getLayoutInflater().inflate(2131494777, null, false));
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302056));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setLeftRightPadding(azvv.a(getActivity(), 12.0F));
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setLeftRightPadding(azvv.a(getActivity(), 12.0F));
      this.jdField_c_of_type_AndroidViewView = a(2131304759);
      d(this.jdField_c_of_type_AndroidViewView.findViewById(2131304760));
      this.jdField_c_of_type_AndroidViewView.findViewById(2131304760).setOnClickListener(this);
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
      QLog.d("SubmitHomeWorkFragment", 2, "onVideoBtnClick");
    }
    if (this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(1) + this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(2) >= 10)
    {
      if (System.currentTimeMillis() - this.jdField_c_of_type_Long >= 2000L)
      {
        bbmy.a(getActivity(), ajjy.a(2131648847) + 10 + ajjy.a(2131648838), 0).a();
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    this.jdField_a_of_type_JavaLangString = TroopHWJsPlugin.a(getActivity(), 260);
    beex.a(getActivity());
  }
  
  protected void c()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      String str2 = localBundle.getString("extra.GROUP_UIN");
      if (str2 == null) {}
      for (String str1 = "";; str1 = str2)
      {
        azzx.a("Grp_edu", "homework", "CompleteHw_Show", 0, 0, new String[] { str1 });
        if (TextUtils.isEmpty(str2)) {
          break;
        }
        this.jdField_d_of_type_JavaLangString = str2;
        this.jdField_a_of_type_Long = localBundle.getLong("HomeWorkConstants:homework_id_default_request_key");
        if (this.jdField_a_of_type_Long <= 0L) {
          break label123;
        }
        a(2131631974);
        this.jdField_a_of_type_Ajtg.a(this.jdField_a_of_type_Long);
        return;
      }
      bbmy.a(getActivity(), 2131632020, 0).a();
      getActivity().finish();
      return;
      label123:
      bbmy.a(getActivity(), 2131632020, 0).a();
      getActivity().finish();
      return;
    }
    bbmy.a(getActivity(), 2131632020, 0).a();
    getActivity().finish();
  }
  
  protected void c(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "onRecordBtnClick");
    }
    if (this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(3) >= 6)
    {
      if (System.currentTimeMillis() - this.jdField_c_of_type_Long >= 2000L)
      {
        bbmy.a(getActivity(), ajjy.a(2131648840) + 6 + ajjy.a(2131648834), 0).a();
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    beex.b(paramView);
    h();
  }
  
  protected void d()
  {
    setLeftButton(2131632008, new aywx(this));
    setRightButton(2131632016, new aywy(this));
    setTitle(getResources().getString(2131632017));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setShowType(2);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setScrollable(false);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setShowType(0);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setMinimumHeight((int)(awmc.b * 0.4D));
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setSizeLimit(500);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.jdField_d_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHint(getActivity().getString(2131632013));
  }
  
  protected void d(View paramView)
  {
    if (paramView != null) {
      paramView.setOnTouchListener(new ayxd(this));
    }
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
      a(getActivity());
    }
  }
  
  protected void e()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 513;
    this.jdField_a_of_type_Ayxe.sendMessage(localMessage);
  }
  
  public void f()
  {
    int j = 0;
    if (!badq.g(getActivity()))
    {
      bbmy.a(getActivity(), 0, 2131628946, 0).a();
      return;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    boolean bool;
    label169:
    Object localObject5;
    if (this.jdField_d_of_type_JavaLangString == null)
    {
      localObject1 = "";
      azzx.a("Grp_edu", "homework", "CompleteHw_Sub", 0, 0, new String[] { localObject1 });
      localObject2 = new ayuv();
      ((ayuv)localObject2).jdField_c_of_type_Long = this.jdField_a_of_type_Long;
      localObject3 = new JSONArray();
      localObject4 = new JSONArray();
      localObject1 = a((JSONArray)localObject3, (JSONArray)localObject4);
      ((Boolean)((List)localObject1).get(1)).booleanValue();
      bool = ((Boolean)((List)localObject1).get(2)).booleanValue();
      if (!((Boolean)((List)localObject1).get(3)).booleanValue()) {
        break label294;
      }
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b().iterator();; localObject1 = ajjy.a(2131648837)) {
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject5 = (azae)((Iterator)localObject1).next();
            if ((localObject5 != null) && (((azae)localObject5).d() == 0)) {
              if (!(localObject5 instanceof ayzx)) {
                break;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = getActivity().getString(2131632011, new Object[] { localObject1 });
        bbmy.a(getActivity(), (CharSequence)localObject1, 0).a();
        return;
        localObject1 = this.jdField_d_of_type_JavaLangString;
        break;
        if (!(localObject5 instanceof azac)) {
          break label169;
        }
        localObject1 = ajjy.a(2131648832);
        continue;
        label294:
        if (!bool)
        {
          bbmy.a(getActivity(), 2131632010, 0).a();
          return;
        }
      }
      localObject1 = new JSONArray();
      int k = ((JSONArray)localObject4).length();
      int i = 0;
      while (i < k)
      {
        localObject5 = ((JSONArray)localObject4).optJSONObject(i);
        if (localObject5 != null) {
          ((JSONArray)localObject1).put(localObject5);
        }
        i += 1;
      }
      k = ((JSONArray)localObject3).length();
      i = j;
      while (i < k)
      {
        localObject4 = ((JSONArray)localObject3).optJSONObject(i);
        if (localObject4 != null) {
          ((JSONArray)localObject1).put(localObject4);
        }
        i += 1;
      }
      localObject3 = new JSONObject();
      for (;;)
      {
        try
        {
          ((JSONObject)localObject3).put("c", localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("SubmitHomeWorkFragment", 2, ((JSONObject)localObject3).toString());
          }
        }
        catch (JSONException localJSONException)
        {
          a(3, null, null, null);
          return;
        }
        try
        {
          if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
            break label542;
          }
          ((ayuv)localObject2).jdField_a_of_type_Long = 0L;
          ((ayuv)localObject2).jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).toString();
        }
        catch (Exception localException)
        {
          continue;
        }
        localObject1 = babr.a(getActivity(), 230);
        localObject2 = new aywz(this, (ayuv)localObject2);
        ((bafb)localObject1).setMessage(2131632009);
        ((bafb)localObject1).setPositiveButton(2131631991, (DialogInterface.OnClickListener)localObject2);
        ((bafb)localObject1).setNegativeButton(2131631985, (DialogInterface.OnClickListener)localObject2);
        ((bafb)localObject1).show();
        return;
        label542:
        ((ayuv)localObject2).jdField_a_of_type_Long = Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue();
      }
      String str = "";
    }
  }
  
  public void g()
  {
    String str;
    Object localObject;
    if (this.jdField_d_of_type_JavaLangString == null)
    {
      str = "";
      if (this.jdField_b_of_type_Ayuv != null) {
        break label167;
      }
      localObject = "";
    }
    for (;;)
    {
      azzx.a("Grp_edu", "homework", "CompleteHw_Success", 0, 0, new String[] { str, "", localObject });
      a(1, "CompleteHw_Pic", true);
      a(2, "CompleteHw_Video", true);
      a(3, "CompleteHw_Voice", true);
      a(7, "CompleteHw_Calculate", false);
      a(4, "CompleteHw_Recite", false);
      localObject = new Intent();
      ((Intent)localObject).putExtra("SubmitHomeWorkFragment:js_callback", "{\"submit\":\"true\", \"hw_id\":" + this.jdField_b_of_type_Long + "}");
      getActivity().setResult(-1, (Intent)localObject);
      getActivity().finish();
      return;
      str = this.jdField_d_of_type_JavaLangString;
      break;
      label167:
      if (this.jdField_b_of_type_Ayuv.jdField_b_of_type_JavaLangString == null) {
        localObject = "";
      } else {
        localObject = this.jdField_b_of_type_Ayuv.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131494778;
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_Begr == null)
    {
      this.jdField_a_of_type_Begr = begr.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2131494089, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Ayxe);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setMinimumHeight((int)(awmc.b * 0.3F));
      this.jdField_a_of_type_Begr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
      this.jdField_a_of_type_Begr.e(50);
      this.jdField_a_of_type_Begr.a(new ayxa(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    this.jdField_a_of_type_Begr.c(true);
    beex.a(getActivity());
    this.jdField_a_of_type_Begr.show();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Ayxe.postDelayed(new SubmitHomeWorkFragment.6(this), 400L);
  }
  
  public void j()
  {
    this.jdField_a_of_type_Begr.dismiss();
  }
  
  protected void k()
  {
    if (this.jdField_d_of_type_JavaLangString == null) {}
    for (Object localObject1 = "";; localObject1 = this.jdField_d_of_type_JavaLangString)
    {
      azzx.a("Grp_edu", "homework", "Subhw_hwDetail", 0, 0, new String[] { localObject1 });
      localObject1 = begr.a(getActivity());
      ViewGroup localViewGroup = (ViewGroup)getActivity().getLayoutInflater().inflate(2131494790, null);
      XMediaEditor localXMediaEditor = (XMediaEditor)localViewGroup.findViewById(2131302055);
      localXMediaEditor.setMaxHeight(awmc.b - this.vg.getHeight() - bajq.a(getActivity()) - awmc.a(122.0F));
      localXMediaEditor.setShowType(1);
      Object localObject2 = (TextView)localViewGroup.findViewById(2131301958);
      View localView = localViewGroup.findViewById(2131301957);
      if (this.jdField_a_of_type_Ayuv != null)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Ayuv.jdField_a_of_type_JavaLangString)) {
          ((TextView)localObject2).setText(this.jdField_a_of_type_Ayuv.jdField_a_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Ayuv.jdField_d_of_type_JavaLangString))
        {
          localObject2 = (Integer)ayvy.a.get(this.jdField_a_of_type_Ayuv.jdField_d_of_type_JavaLangString);
          if (localObject2 != null) {
            localView.setBackgroundResource(((Integer)localObject2).intValue());
          }
        }
      }
      localView = localViewGroup.findViewById(2131301956);
      d(localView);
      localView.setOnClickListener(new ayxb(this, (begr)localObject1));
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        localXMediaEditor.setData(this.jdField_b_of_type_JavaLangString);
      }
      ((begr)localObject1).a(localViewGroup);
      beex.a(getActivity());
      ((begr)localObject1).e(300);
      ((begr)localObject1).show();
      return;
    }
  }
  
  public void l()
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
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, new Object[] { "onActivityResult. requestCode=", Integer.valueOf(paramInt1), ", resultCode=", Integer.valueOf(paramInt2) });
    }
    switch (paramInt1)
    {
    }
    label233:
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
            break label233;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramInt1, paramIntent);
          if (QLog.isColorLevel()) {
            QLog.d("SubmitHomeWorkFragment", 2, "merging: " + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a());
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.invalidate();
        }
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(paramIntent)) && (QLog.isColorLevel())) {
          QLog.d("SubmitHomeWorkFragment", 2, "提交新作业->" + paramIntent);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SubmitHomeWorkFragment", 2, "Return from entry");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SubmitHomeWorkFragment", 2, "no index found");
        }
      }
    } while (paramInt2 != -1);
    if (!badq.d(getActivity()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubmitHomeWorkFragment", 2, "no network toast from capture");
      }
      bbmy.a(getActivity(), 2131631771, 0).a();
      return;
    }
    bacm.a(getActivity(), this.jdField_a_of_type_JavaLangString);
    paramIntent = new azaf(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if (((Boolean)a(new JSONArray(), new JSONArray()).get(0)).booleanValue())
    {
      bafb localbafb = babr.a(getActivity(), 230);
      ayxc localayxc = new ayxc(this);
      localbafb.setMessage(2131632012);
      localbafb.setPositiveButton(2131631990, localayxc);
      localbafb.setNegativeButton(2131631985, localayxc);
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
    k();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Ajuc != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
    }
    TroopHWJsPlugin.a();
    if (this.jdField_d_of_type_Boolean)
    {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_Ayxe.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130771990, 2130772279);
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
    this.jdField_c_of_type_Boolean = azbc.a(this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor, paramIntent, this.jdField_c_of_type_Boolean);
  }
  
  public void onPause()
  {
    super.onPause();
    Intent localIntent = new Intent();
    localIntent.setAction("com.tnecnet.mobileqq.homework.recite.stopAudio");
    getActivity().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment
 * JD-Core Version:    0.7.0.1
 */