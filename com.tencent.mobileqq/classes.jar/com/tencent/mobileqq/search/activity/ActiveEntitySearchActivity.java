package com.tencent.mobileqq.search.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.LocationInterface;
import com.tencent.mobileqq.search.SearchInfoInterface;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateWordClickCallback;
import com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.ReportUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class ActiveEntitySearchActivity
  extends FragmentActivity
  implements TextWatcher, TextView.OnEditorActionListener, LocationInterface, SearchInfoInterface, AssociateSearchWordsFragment.AssociateWordClickCallback, SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  public static boolean a;
  public static boolean b;
  public int a;
  protected FragmentManager a;
  View jdField_a_of_type_AndroidViewView;
  protected Button a;
  protected ImageButton a;
  protected ImageView a;
  protected UnifySearchHandler a;
  UnifySearchObserver jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver = new ActiveEntitySearchActivity.6(this);
  protected UniteSearchHandler a;
  UniteSearchObserver jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new ActiveEntitySearchActivity.5(this);
  protected ActiveEntitySearchFragment a;
  protected AssociateSearchWordsFragment a;
  protected HotWordsForSubBussFragment a;
  SoftKeyboardStateHelper jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper;
  protected QuickPinyinEditText a;
  protected String a;
  public long[] a;
  public int b;
  protected String b;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int d = -1;
  private int e = -1;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = false;
  }
  
  public ActiveEntitySearchActivity()
  {
    this.jdField_b_of_type_Int = 1;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long[] paramArrayOfLong)
  {
    int j = 4;
    UniteSearchActivity localUniteSearchActivity;
    int i;
    if ((paramContext instanceof UniteSearchActivity))
    {
      localUniteSearchActivity = (UniteSearchActivity)paramContext;
      if (localUniteSearchActivity.a() == 1) {
        i = 3;
      }
    }
    for (;;)
    {
      a(paramContext, paramString1, paramString2, paramArrayOfLong, i);
      return;
      if (localUniteSearchActivity.a() == 3)
      {
        i = 6;
        continue;
        if ((paramContext instanceof PublicFragmentActivity))
        {
          i = 9;
        }
        else
        {
          i = j;
          if ((paramContext instanceof ActiveEntitySearchActivity))
          {
            i = j;
            if (((ActiveEntitySearchActivity)paramContext).jdField_a_of_type_Int == 9) {
              i = 9;
            }
          }
        }
      }
      else
      {
        i = 4;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long[] paramArrayOfLong, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, ActiveEntitySearchActivity.class);
    localIntent.putExtra("group_name_string", paramString2);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("fromType", -1);
    localIntent.putExtra("group_mask_long_array", paramArrayOfLong);
    localIntent.putExtra("from_type_for_report", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, long[] paramArrayOfLong, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, ActiveEntitySearchActivity.class);
    localIntent.putExtra("group_name_string", paramString);
    localIntent.putExtra("group_mask_long_array", paramArrayOfLong);
    localIntent.putExtra("fromType", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  private void b(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "showFragment  fragment=" + paramInt);
        }
        if (paramInt != this.d)
        {
          boolean bool = isFinishing();
          if (!bool) {}
        }
        else
        {
          return;
        }
        this.d = paramInt;
        FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
        switch (paramInt)
        {
        case 1: 
          this.e = this.d;
          if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("search_result") == null) {
            a(paramInt);
          }
          localFragmentTransaction.show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment);
          localFragmentTransaction.commitAllowingStateLoss();
          c(3);
          c(2);
          break;
        case 2: 
          if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("hot_words") != null) {
            break label166;
          }
        }
      }
      finally {}
      a(paramInt);
      label166:
      localObject.show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment);
      localObject.commitAllowingStateLoss();
      c(3);
      c(1);
      SearchUtils.a("sub_result", "exp_home", new String[] { "", SearchUtils.a(this.jdField_a_of_type_ArrayOfLong), "", "" });
      continue;
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("associated_words") == null) {
        a(paramInt);
      }
      localObject.show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment);
      localObject.commitAllowingStateLoss();
      c(2);
      c(1);
    }
  }
  
  private void c(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("hot_words") == null);
        localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment);
        localFragmentTransaction.commitAllowingStateLoss();
        return;
      } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("search_result") == null);
      localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      return;
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("associated_words") == null);
    localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment);
    localFragmentTransaction.commitAllowingStateLoss();
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(null);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)super.findViewById(2131366452));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getInputExtras(true).putInt("QUICK_SEARCH", 1);
    String str = (String)FunctionModuleConfigManager.b.get(FunctionModuleConfigManager.a(this.jdField_a_of_type_ArrayOfLong));
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_JavaLangString.length() > 50) {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.substring(0, 50);
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(this.jdField_a_of_type_JavaLangString.length());
        jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.jdField_a_of_type_Int = 50;
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131368600));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new ActiveEntitySearchActivity.2(this));
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363942));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131690800);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ActiveEntitySearchActivity.3(this));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369579));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ActiveEntitySearchActivity.4(this));
      this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper = new SoftKeyboardStateHelper(super.findViewById(2131377356));
      this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper.a(this);
      return;
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(HardCodeUtil.a(2131699854));
    }
  }
  
  public double a()
  {
    return UniteSearchActivity.a;
  }
  
  public int a()
  {
    return 3;
  }
  
  public Fragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment;
  }
  
  protected ActiveEntitySearchFragment a()
  {
    return ActiveEntitySearchFragment.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfLong, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
  }
  
  protected void a()
  {
    if (this.jdField_c_of_type_Int == 10)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler = ((UniteSearchHandler)this.app.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER));
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler = null;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler = ((UnifySearchHandler)this.app.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler = null;
  }
  
  void a(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    switch (paramInt)
    {
    default: 
    case 2: 
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment != null);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment = new HotWordsForSubBussFragment();
      Bundle localBundle = new Bundle();
      localBundle.putLongArray("group_masks", this.jdField_a_of_type_ArrayOfLong);
      localBundle.putInt("fromType", this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment.setArguments(localBundle);
      localFragmentTransaction.add(2131377608, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment, "hot_words");
      localFragmentTransaction.commitAllowingStateLoss();
      return;
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment == null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment = a();
      }
      localFragmentTransaction.add(2131377608, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment, "search_result");
      localFragmentTransaction.commitAllowingStateLoss();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = new AssociateSearchWordsFragment();
    }
    localFragmentTransaction.add(2131377608, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment, "associated_words");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(paramString);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler.a(paramString);
      return;
    }
    QLog.e("Q.uniteSearch.ActiveEntitySearchActivity", 2, "handler unll");
  }
  
  public void a(String paramString, int paramInt)
  {
    SearchUtils.a("sub_result", "clk_auto", new String[] { a(), SearchUtils.a(this.jdField_a_of_type_ArrayOfLong), paramString, "" + paramInt });
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "onAssociateWordClick keyword=" + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
      a(false);
      this.jdField_a_of_type_Int = 2;
      b();
    }
    UniteSearchReportController.a(null, new ReportModelDC02528().module("subweb_search").action("clk_thinkword_list").obj1(SearchUtils.a(this.jdField_a_of_type_ArrayOfLong)).ver1(a()).ver4(paramString).ver7("{experiment_id:" + UniteSearchReportController.jdField_b_of_type_JavaLangString + "}"));
  }
  
  public void a(DynamicTabSearch.SubHotWord paramSubHotWord)
  {
    paramSubHotWord = paramSubHotWord.search_word.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramSubHotWord))
    {
      this.jdField_a_of_type_JavaLangString = paramSubHotWord;
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramSubHotWord);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "onSubHotWordItemClick keyword=" + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramSubHotWord.length());
      a(false);
      this.jdField_a_of_type_Int = 8;
      this.jdField_b_of_type_Int = 2;
      b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
    }
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.a();
  }
  
  public long[] a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment.jdField_a_of_type_ArrayOfLong;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "正在输入拼音，不触发文本变动逻辑。 keyword=" + paramEditable);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "afterTextChanged keyword=" + paramEditable);
    }
    paramEditable = paramEditable.trim();
    this.jdField_a_of_type_JavaLangString = paramEditable;
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment.jdField_b_of_type_JavaLangString = paramEditable;
    if (TextUtils.isEmpty(paramEditable))
    {
      b(2);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    b(3);
    a(paramEditable);
  }
  
  public double b()
  {
    return UniteSearchActivity.b;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment == null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment = a();
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment.c();
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment.a(this.jdField_a_of_type_JavaLangString);
    b(1);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(false);
    ReportUtil.b(this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfLong, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "onHotWordClick keyword=" + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
      a(false);
      this.jdField_a_of_type_Int = 1;
      b();
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c()
  {
    a(true);
  }
  
  public void c(String paramString) {}
  
  protected void d()
  {
    if (this.jdField_c_of_type_Int == 10)
    {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
      return;
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver);
  }
  
  public void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(paramString);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(HardCodeUtil.a(2131699857));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if ((Build.MANUFACTURER.equalsIgnoreCase("huawei")) && (Settings.Secure.getInt(getContentResolver(), "display_notch_status", 0) == 1)) {
      this.mActNeedImmersive = false;
    }
    super.doOnCreate(paramBundle);
    QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnCreate start");
    super.setContentView(2131561727);
    View localView = super.findViewById(2131377356);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      localView.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377608);
    this.jdField_c_of_type_Int = getIntent().getIntExtra("fromType", -1);
    this.jdField_a_of_type_ArrayOfLong = getIntent().getLongArrayExtra("group_mask_long_array");
    this.jdField_a_of_type_Int = getIntent().getIntExtra("from_type_for_report", 4);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("group_name_string");
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("keyword");
    e();
    a();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = super.getSupportFragmentManager();
    if (paramBundle != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("search_result") != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment = ((ActiveEntitySearchFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("search_result"));
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("associated_words") != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = ((AssociateSearchWordsFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("associated_words"));
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("hot_words") != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment = ((HotWordsForSubBussFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("hot_words"));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment == null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment = a();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      b();
    }
    for (;;)
    {
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnCreate end");
      return true;
      b(2);
      new Handler(getMainLooper()).postDelayed(new ActiveEntitySearchActivity.1(this), 500L);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(null);
    }
    d();
    QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnDestroy");
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ReportUtil.a();
    ApngImage.pauseByTag(38);
    QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnPause");
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ReportUtil.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfLong, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    ApngImage.playByTag(38);
    QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnResume");
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 3)
    {
      bool1 = bool2;
      if (paramKeyEvent != null)
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 66) {}
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label80;
      }
      this.jdField_a_of_type_Int = 5;
      this.jdField_b_of_type_Int = 3;
      b();
    }
    for (;;)
    {
      c();
      bool1 = true;
      return bool1;
      label80:
      QQToast.a(getApplicationContext(), HardCodeUtil.a(2131713563), 0).a();
    }
  }
  
  public void onSoftKeyboardClosed()
  {
    if (this.d == 3) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(false);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if ((!jdField_a_of_type_Boolean) || (!isResume()) || (this.d == 3)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
    String str = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentActiveEntitySearchFragment.jdField_b_of_type_JavaLangString = str;
    if (TextUtils.isEmpty(str))
    {
      b(2);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    b(3);
    a(str);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, "onTextChanged keyword=" + paramCharSequence + " activity keyword=" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity
 * JD-Core Version:    0.7.0.1
 */