package com.tencent.mobileqq.troop.homework.recite.ui;

import ajjy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import ayys;
import ayyt;
import ayyu;
import ayyv;
import ayyw;
import ayyx;
import ayza;
import ayzb;
import ayzq;
import azgl;
import azgm;
import azxx;
import azzx;
import bbmy;
import begr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment;
import com.tencent.mobileqq.troop.widget.FlowLayout;
import com.tencent.mobileqq.troop.widget.LoadMoreXListView;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vqi;

public class SearchReciteArticleFragment
  extends AbsHomeWorkFragment
  implements azgl
{
  protected volatile long a;
  protected View a;
  InputMethodManager a;
  public EditText a;
  public ayyx a;
  public ayzb a;
  protected ayzq a;
  protected azgm a;
  protected FlowLayout a;
  public LoadMoreXListView a;
  public String a;
  protected boolean a;
  public int b;
  protected View b;
  protected azgm b;
  protected boolean b;
  
  public static CharSequence a(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    LinkedList localLinkedList;
    int i;
    int j;
    do
    {
      return paramString2;
      localLinkedList = new LinkedList();
      i = 0;
      j = paramString2.length();
      while (i < j)
      {
        if (paramString1.contains(String.valueOf(paramString2.charAt(i)))) {
          localLinkedList.offer(Integer.valueOf(i));
        }
        i += 1;
      }
    } while (localLinkedList.isEmpty());
    paramString1 = new SpannableString(paramString2);
    while (!localLinkedList.isEmpty())
    {
      j = ((Integer)localLinkedList.poll()).intValue();
      i = j + 1;
      while ((!localLinkedList.isEmpty()) && (i == ((Integer)localLinkedList.peek()).intValue()))
      {
        localLinkedList.poll();
        i += 1;
      }
      paramString1.setSpan(new ForegroundColorSpan(paramInt), j, i, 33);
    }
    return paramString1;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "", -2147483648);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    String str = paramString2;
    if (paramString2.startsWith("《"))
    {
      str = paramString2;
      if (paramString2.endsWith("》")) {
        str = paramString2.substring(1, paramString2.length() - 1);
      }
    }
    localIntent.putExtra("keywords", str);
    localIntent.putExtra("troop_uin", paramString1);
    AbsHomeWorkFragment.a((Activity)paramContext, SearchReciteArticleFragment.class, localIntent, paramInt, "");
  }
  
  public void a(int paramInt, ayza paramayza)
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromInputMethod(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    begr localbegr = begr.d(getActivity());
    localbegr.a(new ayyw(this, localbegr, paramayza, paramInt));
    if (paramayza.jdField_a_of_type_Int != 2) {
      localbegr.c(ajjy.a(2131647872));
    }
    localbegr.c(ajjy.a(2131647856));
    localbegr.d(ajjy.a(2131647863));
    localbegr.show();
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    b();
    c();
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    d();
  }
  
  public void a(@Nullable String paramString) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 10001: 
      a(paramJSONObject, paramBundle);
      return;
    }
    b(paramJSONObject, paramBundle);
  }
  
  protected void a(JSONObject paramJSONObject, Bundle paramBundle)
  {
    String str2 = "0";
    if (paramJSONObject != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchReciteArticleFragment", 2, paramJSONObject.toString());
      }
    }
    for (;;)
    {
      int i;
      String str1;
      try
      {
        i = paramJSONObject.getInt("retcode");
        if (i != 0) {
          continue;
        }
        localObject = paramJSONObject.getJSONObject("result");
        if (localObject == null) {
          break label368;
        }
        i = ((JSONObject)localObject).getInt("errCode");
        if (i != 0) {
          continue;
        }
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("rs");
        if (localJSONArray != null)
        {
          int j = localJSONArray.length();
          if (j != 0)
          {
            i = 0;
            if (i < j)
            {
              String str3 = localJSONArray.optString(i);
              localObject = str3;
              if (str3.startsWith("《"))
              {
                localObject = str3;
                if (str3.endsWith("》")) {
                  localObject = str3.substring(1, str3.length() - 1);
                }
              }
              this.jdField_a_of_type_Ayyx.a((String)localObject);
              i += 1;
              continue;
            }
            this.jdField_a_of_type_Ayyx.notifyDataSetChanged();
            if (!this.jdField_a_of_type_Boolean) {
              a(false);
            }
          }
        }
        i = 1;
        localObject = str2;
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SearchReciteArticleFragment", 2, localJSONException, new Object[0]);
        str1 = "-1";
        i = 0;
        continue;
      }
      if (i == 0)
      {
        if ((QLog.isColorLevel()) && (paramBundle != null)) {
          QLog.e("SearchReciteArticleFragment", 2, new Object[] { "onGetKeywordListCallBack server error: ", paramBundle, "\n", paramJSONObject });
        }
        g();
        paramJSONObject = (JSONObject)localObject;
        if (i != 0)
        {
          i = 1;
          azzx.a("Grp_edu", "publish_homework", "get_search_keywords", 0, i, new String[] { paramJSONObject });
          return;
          localObject = String.valueOf(i);
          i = 0;
          continue;
          localObject = String.valueOf(i);
          i = 0;
          continue;
          if ((QLog.isColorLevel()) && (paramBundle != null)) {
            QLog.e("SearchReciteArticleFragment", 2, new Object[] { "onGetKeywordListCallBack client error: ", paramBundle });
          }
          paramJSONObject = "-1";
          i = 0;
        }
        else
        {
          i = 2;
        }
      }
      else
      {
        paramJSONObject = str1;
        continue;
        label368:
        i = 0;
        str1 = str2;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (this.jdField_a_of_type_Ayyx.getCount() != 0) {}
    for (;;)
    {
      localView.setVisibility(i);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      i = 8;
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)a(2131300167));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView = ((LoadMoreXListView)a(2131309972));
    this.jdField_a_of_type_AndroidViewView = a(2131305203);
    this.jdField_b_of_type_AndroidViewView = a(2131303691);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFlowLayout = ((FlowLayout)a(2131300869));
  }
  
  public void b(String paramString)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      e();
      if (QLog.isColorLevel()) {
        QLog.i("SearchReciteArticleFragment", 2, "request search start is " + this.jdField_b_of_type_Int);
      }
      this.jdField_a_of_type_Azgm = this.jdField_a_of_type_Ayzq.a(localQQAppInterface, this, paramString, this.jdField_b_of_type_Int, 10, 10002);
    }
  }
  
  protected void b(JSONObject paramJSONObject, Bundle paramBundle)
  {
    boolean bool4 = false;
    boolean bool1 = false;
    int k;
    int i;
    boolean bool3;
    int j;
    boolean bool2;
    if (paramJSONObject != null)
    {
      k = 0;
      i = 0;
      bool3 = true;
      bool1 = true;
      if (this.jdField_b_of_type_Int != 0) {
        break label592;
      }
      j = 1;
      if (QLog.isColorLevel()) {
        QLog.i("SearchReciteArticleFragment", 2, paramJSONObject.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.a.a(true);
      bool2 = bool1;
    }
    for (;;)
    {
      try
      {
        m = paramJSONObject.getInt("retcode");
        if (m != 0) {
          continue;
        }
        bool2 = bool1;
        localObject = paramJSONObject.getJSONObject("result");
        if (localObject == null) {
          break label577;
        }
        bool2 = bool1;
        m = ((JSONObject)localObject).getInt("errCode");
        bool2 = bool1;
        if (((JSONObject)localObject).getInt("is_end") != 0) {
          break label598;
        }
        bool1 = true;
        if (m != 0) {
          continue;
        }
        bool4 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (!((JSONObject)localObject).has("rs")) {
          break label577;
        }
        bool2 = bool1;
        JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("rs");
        if (localJSONArray == null) {
          break label572;
        }
        bool2 = bool1;
        m = localJSONArray.length();
        if (m == 0) {
          break label572;
        }
        i = 0;
        if (i < m)
        {
          bool2 = bool1;
          this.jdField_a_of_type_Ayzb.a((ayza)azxx.b(localJSONArray.optJSONObject(i), ayza.class));
          i += 1;
          continue;
        }
        bool2 = bool1;
        this.jdField_a_of_type_Ayzb.a(((JSONObject)localObject).optString("key", ""));
        bool2 = bool1;
        this.jdField_a_of_type_Ayzb.notifyDataSetChanged();
        bool2 = bool1;
        this.jdField_b_of_type_Int += 10;
        i = 1;
        localObject = "0";
        bool2 = true;
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
      }
      catch (JSONException localJSONException)
      {
        int m;
        Object localObject;
        bool1 = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SearchReciteArticleFragment", 2, localJSONException, new Object[0]);
        str = "-1";
        i = k;
        continue;
      }
      if ((j != 0) && (i == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.a.a(bool1, bool2);
      if (!bool1)
      {
        if ((QLog.isColorLevel()) && (paramBundle != null)) {
          QLog.e("SearchReciteArticleFragment", 2, new Object[] { "onSearchArticleCallBack server error: ", paramBundle, "\n", paramJSONObject });
        }
        g();
      }
      paramJSONObject = (JSONObject)localObject;
      if (paramBundle != null)
      {
        localObject = paramBundle.getString("key", "");
        paramBundle = paramBundle.getString("start", "");
        if (bool1)
        {
          i = 1;
          azzx.a("Grp_edu", "publish_homework", "kewen_search", 0, i, new String[] { localObject, paramBundle, paramJSONObject });
        }
      }
      else
      {
        return;
        bool4 = false;
        bool3 = bool1;
        bool2 = bool1;
        localObject = String.valueOf(m);
        bool1 = bool3;
        bool2 = bool4;
        continue;
        bool2 = false;
        bool1 = true;
        localObject = String.valueOf(m);
        continue;
        if ((QLog.isColorLevel()) && (paramBundle != null)) {
          QLog.e("SearchReciteArticleFragment", 2, new Object[] { "onSearchArticleCallBack client error: ", paramBundle });
        }
        g();
        paramJSONObject = "-1";
        continue;
      }
      i = 2;
      continue;
      label572:
      i = 0;
      continue;
      label577:
      bool1 = bool3;
      String str = "0";
      bool2 = bool4;
      continue;
      label592:
      j = 0;
      break;
      label598:
      bool1 = false;
    }
  }
  
  protected void c()
  {
    setTitle(ajjy.a(2131647862));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ayys(this));
    this.jdField_a_of_type_Ayyx.a = new ayyt(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFlowLayout.setAdapter(this.jdField_a_of_type_Ayyx);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setAdapter(this.jdField_a_of_type_Ayzb);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.setOnItemClickListener(new ayyu(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.a.a(new ayyv(this));
    String str = getArguments().getString("keywords", "");
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
    }
  }
  
  protected void d()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      f();
      this.jdField_b_of_type_Azgm = this.jdField_a_of_type_Ayzq.a(localQQAppInterface, this, this.jdField_a_of_type_JavaLangString, 10001);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Azgm != null)
    {
      this.jdField_a_of_type_Azgm.cancel(true);
      this.jdField_a_of_type_Azgm = null;
    }
  }
  
  protected void f()
  {
    if (this.jdField_b_of_type_Azgm != null)
    {
      this.jdField_b_of_type_Azgm.cancel(true);
      this.jdField_b_of_type_Azgm = null;
    }
  }
  
  protected void g()
  {
    bbmy.a(getActivity(), ajjy.a(2131647859), 0).a();
  }
  
  public int getContentLayoutId()
  {
    return 2131494781;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("troop_uin");
    this.jdField_a_of_type_Ayyx = new ayyx();
    this.jdField_a_of_type_Ayzb = new ayzb(this);
    this.jdField_a_of_type_Ayzq = new ayzq();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getActivity().getSystemService("input_method"));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(36);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 257) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("HomeWorkConstants:homework_default_result_key");
      if (TextUtils.isEmpty(paramIntent)) {}
    }
    try
    {
      a(new JSONObject(paramIntent));
      a();
      return;
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void onDestroy()
  {
    this.jdField_b_of_type_Boolean = true;
    f();
    e();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment
 * JD-Core Version:    0.7.0.1
 */