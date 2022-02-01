package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Bundle;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.troop.widget.PresetWordFlowLayout;
import com.tencent.mobileqq.util.ColorUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopNickRuleFragment
  extends IphoneTitleBarFragment
{
  public static int a = 15;
  public static String a = "PARAM_UIN";
  public static int b = 10;
  public static String b = "PARAM_INTRO";
  public static int c = 600;
  public static String c = "PARAM_PRESET_WORDS";
  public static String d = "";
  public static String e = "close";
  public static String f = "add";
  public static String g = "none";
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new TroopNickRuleFragment.1(this);
  private View jdField_a_of_type_AndroidViewView = null;
  protected EditText a;
  protected TextView a;
  protected BaseActivity a;
  protected QQAppInterface a;
  protected PresetWordsListAdapter a;
  private TroopManagerBizObserver jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver = new TroopNickRuleFragment.2(this);
  protected PresetWordFlowLayout a;
  protected ArrayList<String> a;
  private boolean jdField_a_of_type_Boolean = false;
  private EditText b;
  private String h = "";
  private String i = "";
  
  public TroopNickRuleFragment()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_AndroidWidgetEditText = null;
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    if (paramBoolean) {
      j = 1;
    } else {
      j = 2;
    }
    ViewCompat.setImportantForAccessibility((View)localObject, j);
    int j = 0;
    while (j < this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.getChildCount())
    {
      localObject = (PresetWordsListAdapter.ViewHolder)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.getChildAt(j).getTag();
      if (localObject != null)
      {
        int k;
        if (((PresetWordsListAdapter.ViewHolder)localObject).b != null)
        {
          TextView localTextView = ((PresetWordsListAdapter.ViewHolder)localObject).b;
          if (paramBoolean) {
            k = 1;
          } else {
            k = 2;
          }
          ViewCompat.setImportantForAccessibility(localTextView, k);
        }
        if (((PresetWordsListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView != null)
        {
          localObject = ((PresetWordsListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView;
          if (paramBoolean) {
            k = 1;
          } else {
            k = 2;
          }
          ViewCompat.setImportantForAccessibility((View)localObject, k);
        }
      }
      j += 1;
    }
  }
  
  private void b(EditText paramEditText)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getBaseActivity().getSystemService("input_method");
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
    setTitle(getString(2131720016));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout = ((PresetWordFlowLayout)getBaseActivity().findViewById(2131379322));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.jdField_b_of_type_Int = ViewUtils.b(12.0F);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.d = ViewUtils.b(12.0F);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter = new PresetWordsListAdapter();
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter$OnItemEventListener = new TroopNickRuleFragment.3(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131379319));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131379318));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new TroopNickRuleFragment.4(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new TroopNickRuleFragment.5(this));
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundColor(ColorUtils.a("#282828"));
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-1);
    }
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(getString(2131720014));
    this.rightViewText.setOnClickListener(new TroopNickRuleFragment.6(this));
    ViewCompat.setImportantForAccessibility(this.mContentView, 2);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver);
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (localIntent != null)
    {
      Object localObject = localIntent.getStringExtra(jdField_a_of_type_JavaLangString);
      String str = "";
      if (localObject != null) {
        localObject = localIntent.getStringExtra(jdField_a_of_type_JavaLangString);
      } else {
        localObject = "";
      }
      this.h = ((String)localObject);
      if (localIntent.getStringExtra(jdField_b_of_type_JavaLangString) != null) {
        localObject = localIntent.getStringExtra(jdField_b_of_type_JavaLangString);
      } else {
        localObject = "";
      }
      this.i = ((String)localObject);
      if (!TextUtils.isEmpty(this.i)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.i);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetEditText;
      ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      if (localIntent.getStringArrayListExtra(c) != null) {
        this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra(c);
      }
      localObject = str;
      if (localIntent.getStringExtra(d) != null) {
        localObject = localIntent.getStringExtra(d);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_set", "", "nickname rule", "nickname rule_exp", 0, 0, String.valueOf(this.h), (String)localObject, "", "");
    }
    f();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.a();
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int m = jdField_a_of_type_Int;
    int j = 0;
    if (k < m)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.a(getString(2131720009));
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.jdField_a_of_type_Boolean = true;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.jdField_a_of_type_Boolean = false;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.a(str);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPresetWordFlowLayout;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.getCount() == 0) {
      j = 8;
    }
    ((PresetWordFlowLayout)localObject).setVisibility(j);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.notifyDataSetChanged();
  }
  
  private void g()
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_set", "", "nickname rule", "nickname rule_sub_failure", 0, 0, String.valueOf(this.h), "1", "", "");
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131694424, 0).a();
      return;
    }
    ITroopManagerBizHandler localITroopManagerBizHandler = (ITroopManagerBizHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
    if (localITroopManagerBizHandler != null)
    {
      this.i = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      localITroopManagerBizHandler.a(this.h, this.i, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  RectF a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int j = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      j = 0;
    }
    if (j > 0) {
      arrayOfInt[1] -= j;
    }
    RectF localRectF = new RectF();
    localRectF.left = arrayOfInt[0];
    localRectF.top = arrayOfInt[1];
    localRectF.right = (localRectF.left + paramView.getMeasuredWidth());
    localRectF.bottom = (localRectF.top + paramView.getMeasuredHeight());
    return localRectF;
  }
  
  void a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      localView = localView.findViewById(2131379110);
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131373021));
      InputFilter.LengthFilter localLengthFilter = new InputFilter.LengthFilter(jdField_b_of_type_Int);
      TroopNickRuleFragment.7 local7 = new TroopNickRuleFragment.7(this);
      this.jdField_b_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { localLengthFilter, local7 });
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(new TroopNickRuleFragment.8(this));
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        this.jdField_b_of_type_AndroidWidgetEditText.setTextColor(-1);
        localView.setBackgroundDrawable(getResources().getDrawable(2130846418));
      }
      this.jdField_b_of_type_AndroidWidgetEditText.setOnEditorActionListener(new TroopNickRuleFragment.9(this));
    }
  }
  
  void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Boolean = false;
    Object localObject = this.jdField_b_of_type_AndroidWidgetEditText;
    if (localObject != null)
    {
      if (a((View)localObject).contains(paramFloat1, paramFloat2)) {
        return;
      }
      b(this.jdField_b_of_type_AndroidWidgetEditText);
      localObject = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, localObject);
        f();
      }
      this.jdField_b_of_type_AndroidWidgetEditText.setText("");
    }
    b();
    a(true);
  }
  
  void a(int paramInt)
  {
    int j = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.a()) {
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
      View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379110);
      if (localView != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(localView.getLayoutParams());
        localLayoutParams.topMargin = ((int)paramView.top);
        localLayoutParams.leftMargin = ((int)paramView.left);
        localView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidViewView.invalidate();
      }
    }
  }
  
  void a(EditText paramEditText)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    if (QLog.isColorLevel()) {
      QLog.i("TroopNickRuleFragment", 2, String.format("showInputMethod()", new Object[0]));
    }
    localInputMethodManager.showSoftInput(paramEditText, 2);
  }
  
  void a(PresetWordsListAdapter.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {
      return;
    }
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getParent() != null)
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131559920, null, false);
        a();
      }
      View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView();
      if ((localView instanceof ViewGroup))
      {
        if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
          ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        ((ViewGroup)localView).addView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      }
      a((View)paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getParent());
      paramViewHolder = this.jdField_b_of_type_AndroidWidgetEditText;
      if (paramViewHolder != null)
      {
        paramViewHolder.setHint(2131720009);
        this.jdField_b_of_type_AndroidWidgetEditText.requestFocus();
        a(this.jdField_b_of_type_AndroidWidgetEditText);
      }
      this.jdField_a_of_type_Boolean = true;
      a(false);
    }
  }
  
  void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      if ((localView.getParent() != null) && ((this.jdField_a_of_type_AndroidViewView.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    }
  }
  
  void c()
  {
    boolean bool = TextUtils.isEmpty(this.i);
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    int j;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      j = 1;
    } else {
      j = 0;
    }
    if (bool)
    {
      if (j != 0) {
        localObject = "4";
      } else {
        localObject = "2";
      }
    }
    else if (j != 0) {
      localObject = "1";
    } else {
      localObject = "3";
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_set", "", "nickname rule", "nickname rule_sub_success", 0, 0, String.valueOf(this.h), (String)localObject, "", "");
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
    ((Intent)localObject).putStringArrayListExtra(c, this.jdField_a_of_type_JavaUtilArrayList);
    ((Intent)localObject).putExtra(jdField_b_of_type_JavaLangString, this.i);
    ((Intent)localObject).putExtra(jdField_a_of_type_JavaLangString, this.h);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, (Intent)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  protected int getContentLayoutId()
  {
    return 2131559919;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver);
    b(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    d();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNickRuleFragment
 * JD-Core Version:    0.7.0.1
 */