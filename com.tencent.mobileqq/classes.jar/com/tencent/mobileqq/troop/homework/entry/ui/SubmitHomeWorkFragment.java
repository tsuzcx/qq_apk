package com.tencent.mobileqq.troop.homework.entry.ui;

import ajyc;
import akhq;
import akim;
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
import axli;
import azvl;
import azwo;
import azxn;
import azxo;
import azxp;
import azxq;
import azxr;
import azxs;
import azxt;
import azxu;
import azxv;
import azxw;
import azya;
import baap;
import baar;
import baas;
import baau;
import baaw;
import baax;
import babc;
import babd;
import babu;
import bawz;
import bbbb;
import bbcv;
import bbdr;
import bbev;
import bbgg;
import bbkx;
import bcpq;
import bcpw;
import bfmr;
import bfol;
import bihe;
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
  implements View.OnClickListener, azya
{
  protected static String a;
  protected int a;
  public long a;
  protected akhq a;
  protected akim a;
  protected BroadcastReceiver a;
  protected View a;
  protected ViewGroup a;
  public azvl a;
  protected azxw a;
  protected bcpq a;
  public bfol a;
  public CommonRecordSoundPanel a;
  protected QQAppInterface a;
  protected InputMethodGuard a;
  public XMediaEditor a;
  public LinkedList<JSONObject> a;
  public boolean a;
  protected long b;
  protected View b;
  protected azvl b;
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
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new azxo(this);
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
    bihe.a(BaseApplicationImpl.getContext());
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
  protected List<String> a(babc parambabc)
  {
    ArrayList localArrayList = new ArrayList();
    if (parambabc != null)
    {
      if (!(parambabc instanceof babd)) {
        break label49;
      }
      localArrayList.add(ajyc.a(2131714635) + "");
    }
    label49:
    do
    {
      return localArrayList;
      if ((parambabc instanceof baax))
      {
        localArrayList.add(ajyc.a(2131714628) + "");
        return localArrayList;
      }
      if ((parambabc instanceof baar))
      {
        localArrayList.add(ajyc.a(2131714622) + "");
        return localArrayList;
      }
      if ((parambabc instanceof baap))
      {
        localArrayList.add(ajyc.a(2131714631) + "");
        return localArrayList;
      }
    } while (!(parambabc instanceof baau));
    localArrayList.add(ajyc.a(2131714625) + "");
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
    this.jdField_a_of_type_Azxw = new azxw(this, Looper.getMainLooper());
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
      this.jdField_a_of_type_Akhq = ((akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
      this.jdField_a_of_type_Akim = new azxn(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akim);
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
        if (this.jdField_a_of_type_Bcpq == null)
        {
          this.jdField_a_of_type_Bcpq = new bcpq(getActivity(), getActivity().getTitleBarHeight());
          this.jdField_a_of_type_Bcpq.setCancelable(false);
          this.jdField_a_of_type_Bcpq.show();
        }
        this.jdField_a_of_type_Bcpq.c(paramInt);
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
        baas localbaas = (baas)((Iterator)localObject).next();
        if (localbaas != null) {
          localJSONArray.put(localbaas.a());
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      if (this.jdField_d_of_type_JavaLangString == null)
      {
        localObject = "";
        bbbb.a("Grp_edu", "homework", paramString, 0, 0, new String[] { localObject, "", String.valueOf(localArrayList.size()), localJSONArray.toString() });
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
      localObject = (baas)paramString.next();
      if ((localObject == null) || (!(localObject instanceof baap))) {
        break label264;
      }
      paramInt = ((baap)localObject).c();
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
        bbbb.a("Grp_edu", "Grp_oral", "Finish_Oral_Number", 0, 0, new String[] { paramString, String.valueOf(paramInt) });
        label255:
        return;
      }
    }
  }
  
  public void a(int paramInt, ArrayList<babc> paramArrayList1, ArrayList<babc> paramArrayList2, azvl paramazvl)
  {
    if (paramInt == 0)
    {
      paramazvl = new ArrayList();
      Iterator localIterator = paramArrayList1.iterator();
      while (localIterator.hasNext()) {
        paramazvl.addAll(a((babc)localIterator.next()));
      }
      localIterator = paramArrayList2.iterator();
      while (localIterator.hasNext()) {
        paramazvl.addAll(a((babc)localIterator.next()));
      }
      paramazvl = new ArrayList(new TreeSet(paramazvl));
      if (paramazvl.isEmpty())
      {
        paramazvl = "";
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
        paramArrayList1 = getString(2131697743, new Object[] { paramazvl });
        bcpw.a(getActivity(), paramArrayList1, 0).a();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubmitHomeWorkFragment", 2, "Error, reason_code = " + paramInt + ", print trace: ", new RuntimeException("UPLOAD_ERROR"));
      }
      return;
      if (paramazvl.size() == 1)
      {
        paramazvl = (String)paramazvl.get(0);
        break;
      }
      paramazvl = (String)paramazvl.get(0) + "、" + (String)paramazvl.get(1) + ajyc.a(2131714624);
      break;
      label353:
      paramArrayList1 = getString(2131697741, new Object[] { paramazvl });
      bcpw.a(getActivity(), paramArrayList1, 0).a();
      continue;
      if (paramInt == 1) {
        bcpw.a(getActivity(), 2131697710, 0).a();
      } else if (paramInt == 3) {
        bcpw.a(getActivity(), 2131697737, 0).a();
      } else if (paramInt == 2) {
        bcpw.a(getActivity(), 2131694618, 0).a();
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
        bcpw.a(getActivity(), ajyc.a(2131714634) + 10 + ajyc.a(2131714632), 0).a();
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    paramView = TroopHWJsPlugin.a(10 - i, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramView.putExtra("HomeWorkConstants:homework_request_code_key", 259);
    startActivity(paramView);
    bfmr.a(getActivity());
  }
  
  public void a(azvl paramazvl)
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
            babc localbabc = (babc)((Iterator)localObject1).next();
            if (localbabc != null) {
              if (localbabc.e() == 1) {
                localArrayList3.add(localbabc);
              } else if ((localbabc.e() == 2) || (localbabc.e() == 0)) {
                localArrayList1.add(localbabc);
              }
            }
          }
          localObject1 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (babc)((Iterator)localObject1).next();
            if (localObject2 != null) {
              if (((babc)localObject2).e() == 1) {
                localArrayList3.add(localObject2);
              } else if ((((babc)localObject2).e() == 2) || (((babc)localObject2).e() == 0)) {
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
            a(0, localArrayList1, localArrayList2, paramazvl);
            return;
          }
          a(3, null, null, paramazvl);
          return;
        }
        if ((this.jdField_a_of_type_Akhq != null) && (paramazvl != null))
        {
          a(2131697701);
          this.jdField_b_of_type_Azvl = paramazvl;
          this.jdField_b_of_type_Long = paramazvl.jdField_c_of_type_Long;
          this.jdField_a_of_type_Akhq.a(paramazvl.jdField_c_of_type_Long, paramazvl.jdField_a_of_type_Long, paramazvl.jdField_b_of_type_JavaLangString);
          return;
        }
        a(3, null, null, paramazvl);
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
              if (Arrays.asList(azwo.c).contains(str)) {
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
  
  protected void a(@NonNull ArrayList<babc> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.addAll(a((babc)paramArrayList.next()));
    }
    paramArrayList = new ArrayList(new TreeSet(localArrayList));
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    for (;;)
    {
      paramArrayList = getString(2131697743, new Object[] { paramArrayList });
      bcpw.a(getActivity(), paramArrayList, 0).a();
      return;
      if (paramArrayList.size() == 1) {
        paramArrayList = (String)paramArrayList.get(0);
      } else {
        paramArrayList = (String)paramArrayList.get(0) + "、" + (String)paramArrayList.get(1) + ajyc.a(2131714633);
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
      this.jdField_a_of_type_AndroidViewView = a(2131376656);
      this.jdField_b_of_type_AndroidViewView = a(2131363390);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard = ((InputMethodGuard)a(2131368209));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewInputMethodGuard.setOnInputMethodChangeListener(this);
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)a(2131367667));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getActivity().getLayoutInflater().inflate(2131560349, null, false));
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor = ((XMediaEditor)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367674));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setLeftRightPadding(bawz.a(getActivity(), 12.0F));
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setLeftRightPadding(bawz.a(getActivity(), 12.0F));
      this.jdField_c_of_type_AndroidViewView = a(2131370416);
      d(this.jdField_c_of_type_AndroidViewView.findViewById(2131370417));
      this.jdField_c_of_type_AndroidViewView.findViewById(2131370417).setOnClickListener(this);
      localView = a(2131372136);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      localView = a(2131372143);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      localView = a(2131372144);
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
        bcpw.a(getActivity(), ajyc.a(2131714636) + 10 + ajyc.a(2131714627), 0).a();
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    jdField_a_of_type_JavaLangString = TroopHWJsPlugin.a(getActivity(), 260);
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, new Object[] { "onVideoBtnClick", String.format("mCameraPath=%s", new Object[] { jdField_a_of_type_JavaLangString }) });
    }
    bfmr.a(getActivity());
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
        bbbb.a("Grp_edu", "homework", "CompleteHw_Show", 0, 0, new String[] { str1 });
        if (TextUtils.isEmpty(str2)) {
          break;
        }
        this.jdField_d_of_type_JavaLangString = str2;
        this.jdField_a_of_type_Long = localBundle.getLong("HomeWorkConstants:homework_id_default_request_key");
        if (this.jdField_a_of_type_Long <= 0L) {
          break label123;
        }
        a(2131697688);
        this.jdField_a_of_type_Akhq.a(this.jdField_a_of_type_Long);
        return;
      }
      bcpw.a(getActivity(), 2131697739, 0).a();
      getActivity().finish();
      return;
      label123:
      bcpw.a(getActivity(), 2131697739, 0).a();
      getActivity().finish();
      return;
    }
    bcpw.a(getActivity(), 2131697739, 0).a();
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
        bcpw.a(getActivity(), ajyc.a(2131714629) + 6 + ajyc.a(2131714623), 0).a();
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    bfmr.b(paramView);
    h();
  }
  
  protected void d()
  {
    setLeftButton(2131697727, new azxp(this));
    setRightButton(2131697735, new azxq(this));
    setTitle(getResources().getString(2131697736));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setShowType(2);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setScrollable(false);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setShowType(0);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setMinimumHeight((int)(axli.b * 0.4D));
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setSizeLimit(500);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setExtraValue("troopuin", this.jdField_d_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHint(getActivity().getString(2131697732));
  }
  
  protected void d(View paramView)
  {
    if (paramView != null) {
      paramView.setOnTouchListener(new azxv(this));
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
    this.jdField_a_of_type_Azxw.sendMessage(localMessage);
  }
  
  public void f()
  {
    int j = 0;
    if (!bbev.g(getActivity()))
    {
      bcpw.a(getActivity(), 0, 2131694607, 0).a();
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
      bbbb.a("Grp_edu", "homework", "CompleteHw_Sub", 0, 0, new String[] { localObject1 });
      localObject2 = new azvl();
      ((azvl)localObject2).jdField_c_of_type_Long = this.jdField_a_of_type_Long;
      localObject3 = new JSONArray();
      localObject4 = new JSONArray();
      localObject1 = a((JSONArray)localObject3, (JSONArray)localObject4);
      ((Boolean)((List)localObject1).get(1)).booleanValue();
      bool = ((Boolean)((List)localObject1).get(2)).booleanValue();
      if (!((Boolean)((List)localObject1).get(3)).booleanValue()) {
        break label294;
      }
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b().iterator();; localObject1 = ajyc.a(2131714626)) {
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject5 = (baaw)((Iterator)localObject1).next();
            if ((localObject5 != null) && (((baaw)localObject5).d() == 0)) {
              if (!(localObject5 instanceof baap)) {
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
        localObject1 = getActivity().getString(2131697730, new Object[] { localObject1 });
        bcpw.a(getActivity(), (CharSequence)localObject1, 0).a();
        return;
        localObject1 = this.jdField_d_of_type_JavaLangString;
        break;
        if (!(localObject5 instanceof baau)) {
          break label169;
        }
        localObject1 = ajyc.a(2131714621);
        continue;
        label294:
        if (!bool)
        {
          bcpw.a(getActivity(), 2131697729, 0).a();
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
          ((azvl)localObject2).jdField_a_of_type_Long = 0L;
          ((azvl)localObject2).jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).toString();
        }
        catch (Exception localException)
        {
          continue;
        }
        localObject1 = bbcv.a(getActivity(), 230);
        localObject2 = new azxr(this, (azvl)localObject2);
        ((bbgg)localObject1).setMessage(2131697728);
        ((bbgg)localObject1).setPositiveButton(2131697709, (DialogInterface.OnClickListener)localObject2);
        ((bbgg)localObject1).setNegativeButton(2131697703, (DialogInterface.OnClickListener)localObject2);
        ((bbgg)localObject1).show();
        return;
        label542:
        ((azvl)localObject2).jdField_a_of_type_Long = Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue();
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
      if (this.jdField_b_of_type_Azvl != null) {
        break label167;
      }
      localObject = "";
    }
    for (;;)
    {
      bbbb.a("Grp_edu", "homework", "CompleteHw_Success", 0, 0, new String[] { str, "", localObject });
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
      if (this.jdField_b_of_type_Azvl.jdField_b_of_type_JavaLangString == null) {
        localObject = "";
      } else {
        localObject = this.jdField_b_of_type_Azvl.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560350;
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_Bfol == null)
    {
      this.jdField_a_of_type_Bfol = bfol.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)getActivity().getLayoutInflater().inflate(2131559661, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Azxw);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setMinimumHeight((int)(axli.b * 0.3F));
      this.jdField_a_of_type_Bfol.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
      this.jdField_a_of_type_Bfol.e(50);
      this.jdField_a_of_type_Bfol.a(new azxs(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    this.jdField_a_of_type_Bfol.c(true);
    bfmr.a(getActivity());
    this.jdField_a_of_type_Bfol.show();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Azxw.postDelayed(new SubmitHomeWorkFragment.6(this), 400L);
  }
  
  public void j()
  {
    this.jdField_a_of_type_Bfol.dismiss();
  }
  
  protected void k()
  {
    if (this.jdField_d_of_type_JavaLangString == null) {}
    for (Object localObject1 = "";; localObject1 = this.jdField_d_of_type_JavaLangString)
    {
      bbbb.a("Grp_edu", "homework", "Subhw_hwDetail", 0, 0, new String[] { localObject1 });
      localObject1 = bfol.a(getActivity());
      ViewGroup localViewGroup = (ViewGroup)getActivity().getLayoutInflater().inflate(2131560362, null);
      XMediaEditor localXMediaEditor = (XMediaEditor)localViewGroup.findViewById(2131367673);
      localXMediaEditor.setMaxHeight(axli.b - this.vg.getHeight() - bbkx.a(getActivity()) - axli.a(122.0F));
      localXMediaEditor.setShowType(1);
      Object localObject2 = (TextView)localViewGroup.findViewById(2131367575);
      View localView = localViewGroup.findViewById(2131367574);
      if (this.jdField_a_of_type_Azvl != null)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Azvl.jdField_a_of_type_JavaLangString)) {
          ((TextView)localObject2).setText(this.jdField_a_of_type_Azvl.jdField_a_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Azvl.jdField_d_of_type_JavaLangString))
        {
          localObject2 = (Integer)azwo.a.get(this.jdField_a_of_type_Azvl.jdField_d_of_type_JavaLangString);
          if (localObject2 != null) {
            localView.setBackgroundResource(((Integer)localObject2).intValue());
          }
        }
      }
      localView = localViewGroup.findViewById(2131367573);
      d(localView);
      localView.setOnClickListener(new azxt(this, (bfol)localObject1));
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        localXMediaEditor.setData(this.jdField_b_of_type_JavaLangString);
      }
      ((bfol)localObject1).a(localViewGroup);
      bfmr.a(getActivity());
      ((bfol)localObject1).e(300);
      ((bfol)localObject1).show();
      return;
    }
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bcpq.dismiss();
      label24:
      this.jdField_a_of_type_Bcpq = null;
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
    if (!bbev.d(getActivity()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubmitHomeWorkFragment", 2, "no network toast from capture");
      }
      bcpw.a(getActivity(), 2131697483, 0).a();
      return;
    }
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      try
      {
        bbdr.a(getActivity(), jdField_a_of_type_JavaLangString);
        paramIntent = new baax(jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          QLog.d("SubmitHomeWorkFragment", 1, "onActivityResult save exception", paramIntent);
        }
      }
    }
    bcpw.a(getActivity(), 2131695189, 0).a();
    QLog.d("SubmitHomeWorkFragment", 1, new Object[] { "onActivityResult path=%s", jdField_a_of_type_JavaLangString });
  }
  
  public boolean onBackEvent()
  {
    if (((Boolean)a(new JSONArray(), new JSONArray()).get(0)).booleanValue())
    {
      bbgg localbbgg = bbcv.a(getActivity(), 230);
      azxu localazxu = new azxu(this);
      localbbgg.setMessage(2131697731);
      localbbgg.setPositiveButton(2131697708, localazxu);
      localbbgg.setNegativeButton(2131697703, localazxu);
      localbbgg.show();
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
    case 2131372136: 
      a(paramView);
      return;
    case 2131372143: 
      b(paramView);
      return;
    case 2131372144: 
      c(paramView);
      return;
    }
    k();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Akim != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akim);
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
    this.jdField_a_of_type_Azxw.removeCallbacksAndMessages(null);
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130771990, 2130772280);
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
    this.jdField_c_of_type_Boolean = babu.a(this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor, paramIntent, this.jdField_c_of_type_Boolean);
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