package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aoep;
import aofu;
import bewa;
import bewc;
import bfbq;
import bfbr;
import bfbs;
import bfbt;
import bfbu;
import bfbv;
import bfbw;
import bfbx;
import bfby;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.mini.util.ColorUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.PresetWordFlowLayout;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopNickRuleFragment
  extends IphoneTitleBarFragment
{
  public static int a;
  public static String a;
  public static int b;
  public static String b;
  public static int c;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public FragmentActivity a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bfbq(this);
  private View jdField_a_of_type_AndroidViewView;
  public EditText a;
  public TextView a;
  private aofu jdField_a_of_type_Aofu = new bfbr(this);
  protected bewa a;
  public QQAppInterface a;
  public PresetWordFlowLayout a;
  protected ArrayList<String> a;
  private boolean jdField_a_of_type_Boolean;
  private EditText b;
  private String h = "";
  private String i = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "PARAM_UIN";
    jdField_b_of_type_JavaLangString = "PARAM_INTRO";
    jdField_c_of_type_JavaLangString = "PARAM_PRESET_WORDS";
    d = "";
    e = "close";
    f = "add";
    g = "none";
    jdField_a_of_type_Int = 15;
    jdField_b_of_type_Int = 10;
    jdField_c_of_type_Int = 600;
  }
  
  public TroopNickRuleFragment()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    int j;
    if (paramBoolean)
    {
      j = 1;
      ViewCompat.setImportantForAccessibility((View)localObject, j);
      j = 0;
      label20:
      if (j >= this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.getChildCount()) {
        return;
      }
      localObject = (bewc)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.getChildAt(j).getTag();
      if (localObject != null)
      {
        if (((bewc)localObject).b != null)
        {
          TextView localTextView = ((bewc)localObject).b;
          if (!paramBoolean) {
            break label118;
          }
          k = 1;
          label73:
          ViewCompat.setImportantForAccessibility(localTextView, k);
        }
        if (((bewc)localObject).jdField_a_of_type_AndroidWidgetTextView != null)
        {
          localObject = ((bewc)localObject).jdField_a_of_type_AndroidWidgetTextView;
          if (!paramBoolean) {
            break label123;
          }
        }
      }
    }
    label118:
    label123:
    for (int k = 1;; k = 2)
    {
      ViewCompat.setImportantForAccessibility((View)localObject, k);
      j += 1;
      break label20;
      j = 2;
      break;
      k = 2;
      break label73;
    }
  }
  
  private void b(EditText paramEditText)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
    if (localInputMethodManager.isActive())
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopNickRuleFragment", 2, String.format("hideInputMethod()", new Object[0]));
      }
      localInputMethodManager.hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
    }
  }
  
  private void d()
  {
    setTitle(getString(2131719700));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout = ((PresetWordFlowLayout)getActivity().findViewById(2131379570));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.jdField_b_of_type_Int = ViewUtils.dpToPx(12.0F);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.d = ViewUtils.dpToPx(12.0F);
    this.jdField_a_of_type_Bewa = new bewa();
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (bool) {
      this.jdField_a_of_type_Bewa.b();
    }
    this.jdField_a_of_type_Bewa.jdField_a_of_type_Bewb = new bfbs(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.setAdapter(this.jdField_a_of_type_Bewa);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131379567));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131379566));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new bfbt(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bfbu(this));
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundColor(ColorUtils.parseColor("#282828"));
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-1);
    }
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(getString(2131719698));
    this.rightViewText.setOnClickListener(new bfbv(this));
    ViewCompat.setImportantForAccessibility(this.mContentView, 2);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localIntent != null)
    {
      if (localIntent.getStringExtra(jdField_a_of_type_JavaLangString) == null) {
        break label196;
      }
      str = localIntent.getStringExtra(jdField_a_of_type_JavaLangString);
      this.h = str;
      if (localIntent.getStringExtra(jdField_b_of_type_JavaLangString) == null) {
        break label202;
      }
      str = localIntent.getStringExtra(jdField_b_of_type_JavaLangString);
      label64:
      this.i = str;
      if (!TextUtils.isEmpty(this.i)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.i);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      if (localIntent.getStringArrayListExtra(jdField_c_of_type_JavaLangString) != null) {
        this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra(jdField_c_of_type_JavaLangString);
      }
      if (localIntent.getStringExtra(d) == null) {
        break label208;
      }
    }
    label196:
    label202:
    label208:
    for (String str = localIntent.getStringExtra(d);; str = "")
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("dc00899", "Grp_set", "", "nickname rule", "nickname rule_exp", 0, 0, String.valueOf(this.h), str, "", "");
      f();
      return;
      str = "";
      break;
      str = "";
      break label64;
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_Bewa.a();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < jdField_a_of_type_Int) {
      this.jdField_a_of_type_Bewa.a(getString(2131719693));
    }
    for (this.jdField_a_of_type_Bewa.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Bewa.jdField_a_of_type_Boolean = false)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.jdField_a_of_type_Bewa.a(str);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout;
    if (this.jdField_a_of_type_Bewa.getCount() == 0) {}
    for (int j = 8;; j = 0)
    {
      ((PresetWordFlowLayout)localObject).setVisibility(j);
      this.jdField_a_of_type_Bewa.notifyDataSetChanged();
      return;
    }
  }
  
  private void g()
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("dc00899", "Grp_set", "", "nickname rule", "nickname rule_sub_failure", 0, 0, String.valueOf(this.h), "1", "", "");
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131694255, 0).a();
    }
    aoep localaoep;
    do
    {
      return;
      localaoep = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while (localaoep == null);
    this.i = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    localaoep.a(this.h, this.i, this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  RectF a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int j = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    if (ImmersiveUtils.isSupporImmersive() != 1) {}
    for (;;)
    {
      if (j > 0) {
        arrayOfInt[1] -= j;
      }
      RectF localRectF = new RectF();
      localRectF.left = arrayOfInt[0];
      localRectF.top = arrayOfInt[1];
      localRectF.right = (localRectF.left + paramView.getMeasuredWidth());
      localRectF.bottom = (localRectF.top + paramView.getMeasuredHeight());
      return localRectF;
      j = 0;
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379356);
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131373116));
      InputFilter.LengthFilter localLengthFilter = new InputFilter.LengthFilter(jdField_b_of_type_Int);
      bfbw localbfbw = new bfbw(this);
      this.jdField_b_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { localLengthFilter, localbfbw });
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(new bfbx(this));
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        this.jdField_b_of_type_AndroidWidgetEditText.setTextColor(-1);
        localView.setBackgroundDrawable(getResources().getDrawable(2130846219));
      }
      this.jdField_b_of_type_AndroidWidgetEditText.setOnEditorActionListener(new bfby(this));
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_AndroidWidgetEditText != null)
    {
      if (a(this.jdField_b_of_type_AndroidWidgetEditText).contains(paramFloat1, paramFloat2)) {
        return;
      }
      b(this.jdField_b_of_type_AndroidWidgetEditText);
      String str = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, str);
        f();
      }
      this.jdField_b_of_type_AndroidWidgetEditText.setText("");
    }
    b();
    a(true);
  }
  
  public void a(int paramInt)
  {
    int j = paramInt;
    if (this.jdField_a_of_type_Bewa.a()) {
      j = paramInt - 1;
    }
    if ((j >= 0) && (this.jdField_a_of_type_JavaUtilArrayList.size() > j))
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(j);
      f();
    }
  }
  
  void a(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      paramView = a(paramView);
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379356);
      if (localView != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(localView.getLayoutParams());
        if (localLayoutParams != null)
        {
          localLayoutParams.topMargin = ((int)paramView.top);
          localLayoutParams.leftMargin = ((int)paramView.left);
          localView.setLayoutParams(localLayoutParams);
          this.jdField_a_of_type_AndroidViewView.invalidate();
        }
      }
    }
  }
  
  void a(EditText paramEditText)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("input_method");
    if (QLog.isColorLevel()) {
      QLog.i("TroopNickRuleFragment", 2, String.format("showInputMethod()", new Object[0]));
    }
    localInputMethodManager.showSoftInput(paramEditText, 2);
  }
  
  public void a(bewc parambewc)
  {
    if (parambewc == null) {}
    while ((parambewc.jdField_a_of_type_AndroidWidgetTextView == null) || (parambewc.jdField_a_of_type_AndroidWidgetTextView.getParent() == null)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559974, null, false);
      a();
    }
    View localView = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().getDecorView();
    if ((localView instanceof ViewGroup))
    {
      if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      ((ViewGroup)localView).addView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    a((View)parambewc.jdField_a_of_type_AndroidWidgetTextView.getParent());
    if (this.jdField_b_of_type_AndroidWidgetEditText != null)
    {
      this.jdField_b_of_type_AndroidWidgetEditText.setHint(2131719693);
      this.jdField_b_of_type_AndroidWidgetEditText.requestFocus();
      a(this.jdField_b_of_type_AndroidWidgetEditText);
    }
    this.jdField_a_of_type_Boolean = true;
    a(false);
  }
  
  void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if ((this.jdField_a_of_type_AndroidViewView.getParent() != null) && ((this.jdField_a_of_type_AndroidViewView.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    }
  }
  
  public void c()
  {
    boolean bool = TextUtils.isEmpty(this.i);
    int j;
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      j = 1;
      if (!bool) {
        break label204;
      }
      if (j == 0) {
        break label197;
      }
      localObject = "4";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("dc00899", "Grp_set", "", "nickname rule", "nickname rule_sub_success", 0, 0, String.valueOf(this.h), (String)localObject, "", "");
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject != null)
      {
        TroopInfo localTroopInfo = ((TroopManager)localObject).b(this.h);
        if (localTroopInfo != null)
        {
          localTroopInfo.setGroupCardPrefix(this.jdField_a_of_type_JavaUtilArrayList);
          localTroopInfo.groupCardPrefixIntro = this.i;
          ((TroopManager)localObject).b(localTroopInfo);
        }
      }
      localObject = new Intent();
      ((Intent)localObject).putStringArrayListExtra(jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList);
      ((Intent)localObject).putExtra(jdField_b_of_type_JavaLangString, this.i);
      ((Intent)localObject).putExtra(jdField_a_of_type_JavaLangString, this.h);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, (Intent)localObject);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
      j = 0;
      break;
      label197:
      localObject = "2";
      continue;
      label204:
      if (j != 0) {
        localObject = "1";
      } else {
        localObject = "3";
      }
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131559973;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    b(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    d();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNickRuleFragment
 * JD-Core Version:    0.7.0.1
 */