package com.tencent.mobileqq.extendfriend.fragment;

import aepi;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import aojh;
import aqeo;
import aqep;
import ayvq;
import ayvr;
import benm;
import bhtd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendMultiLinesTagsView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import mww;

public abstract class ExtendFriendSearchBaseFragment
  extends PublicBaseFragment
  implements Handler.Callback, TextWatcher, View.OnClickListener, TextView.OnEditorActionListener, ayvr, benm
{
  private int jdField_a_of_type_Int = -1;
  protected FragmentActivity a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ayvq jdField_a_of_type_Ayvq;
  private bhtd jdField_a_of_type_Bhtd;
  protected QQAppInterface a;
  private ExtendFriendMultiLinesTagsView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView;
  private QuickPinyinEditText jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private boolean jdField_a_of_type_Boolean = true;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ExtendFriendMultiLinesTagsView jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView;
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchBaseFragment", 2, String.format("switchToMode oldMode=%s newMode=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt) }));
    }
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        a(false, 50L);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.requestFocus();
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    a(true, 50L);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusableInTouchMode(paramBoolean);
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchBaseFragment", 2, String.format("toggleInputMethod open=%s delay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) }));
    }
    this.jdField_a_of_type_Bhtd.removeMessages(12);
    this.jdField_a_of_type_Bhtd.removeMessages(11);
    if (paramBoolean) {
      if (!this.jdField_a_of_type_Bhtd.hasMessages(11)) {
        this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(11, paramLong);
      }
    }
    while (this.jdField_a_of_type_Bhtd.hasMessages(12)) {
      return;
    }
    this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(12, paramLong);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchBaseFragment", 2, "showInputMethod");
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
    ((InputMethodManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, 0);
  }
  
  private void b(int paramInt)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact == null))
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getActivity(), false, getResources().getColor(paramInt));
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
      if (Build.VERSION.SDK_INT >= 19) {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().addFlags(67108864);
      }
      d();
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchBaseFragment", 2, "hideInputMethod");
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
    ((InputMethodManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
  }
  
  private void c(String paramString)
  {
    a(1);
    a(paramString);
  }
  
  private void d()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) && (ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app)))
      {
        int i = getResources().getColor(2131166756);
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarMask(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendSearchBaseFragment", 1, "showStatusBarMask fail.", localException);
    }
  }
  
  abstract void a();
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(false, 50L);
  }
  
  abstract void a(ViewGroup paramViewGroup);
  
  abstract void a(String paramString);
  
  public void a(ArrayList<String> paramArrayList)
  {
    int j = 0;
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setSearchTags(paramArrayList);
      paramArrayList = this.jdField_a_of_type_AndroidViewViewGroup;
      if (i != 0) {
        j = 8;
      }
      paramArrayList.setVisibility(j);
      return;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Int == 1) && (TextUtils.isEmpty(paramEditable))) {
        a(0);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void b(String paramString)
  {
    float f1;
    String str;
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null)
    {
      float f3 = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWidth() - this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingLeft() - this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingRight();
      float f4 = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTextSize();
      float f2 = 18.0F;
      f1 = f2;
      if (f4 > 1.0F)
      {
        f1 = f2;
        if (f3 > 1.0F) {
          f1 = f3 / f4;
        }
      }
      f1 = Math.max(f1, 12.0F);
      str = paramString;
      if (aojh.a(paramString) > f1)
      {
        i = Math.max(0, (int)(f1 - 4.0F));
        j = i;
        if (i < paramString.length()) {
          if (!TextUtils.equals(String.valueOf(paramString.charAt(i - 1)), "、")) {}
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (aojh.a(paramString.substring(0, i) + "…") > f1)
      {
        str = paramString.substring(0, j) + "…";
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(str);
        return;
      }
      j = i;
    }
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    int j = 0;
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setSearchTags(paramArrayList);
      paramArrayList = this.jdField_b_of_type_AndroidViewViewGroup;
      if (i != 0) {
        j = 8;
      }
      paramArrayList.setVisibility(j);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      c();
      continue;
      b();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      a(0);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131376245: 
      do
      {
        return;
        if (this.jdField_a_of_type_Int == 1)
        {
          a(0);
          return;
        }
      } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    case 2131367665: 
      a();
      return;
    }
    if (this.jdField_a_of_type_Int == 1) {
      a(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow();
    if (paramBundle != null)
    {
      paramBundle.setFormat(-3);
      paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
    }
    this.jdField_a_of_type_Bhtd = new bhtd(Looper.getMainLooper(), this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = (ViewGroup)paramLayoutInflater.inflate(2131560959, null);
    paramViewGroup = paramLayoutInflater.findViewById(2131377975);
    if (paramViewGroup != null)
    {
      paramBundle = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
      paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      paramViewGroup.setLayoutParams(paramBundle);
      b(2131166959);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramLayoutInflater.findViewById(2131376270));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setInputType(524289);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131376246));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(mww.a);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131376245));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(mww.a);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLayoutInflater.findViewById(2131376252));
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramLayoutInflater.findViewById(2131376286));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131367666));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(2131367674));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setViewMargin(aepi.a(10.0F, getResources()), aepi.a(10.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setOnItemClickListener(new aqeo(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131367665));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131375450));
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(2131375486));
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setViewMargin(aepi.a(10.0F, getResources()), aepi.a(10.0F, getResources()));
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendMultiLinesTagsView.setOnItemClickListener(new aqep(this));
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131371169);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
      if (!bool) {
        break label472;
      }
    }
    label472:
    for (int i = 0;; i = 8)
    {
      paramViewGroup.setVisibility(i);
      this.jdField_a_of_type_Ayvq = new ayvq(paramLayoutInflater);
      this.jdField_a_of_type_Ayvq.a(this);
      a(0);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Bhtd.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(null);
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
      paramTextView = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
      if (!TextUtils.isEmpty(paramTextView)) {
        c(paramTextView);
      }
      a(false, 50L);
      bool1 = true;
    }
    return bool1;
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 2130772324);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 1))
    {
      a(false);
      this.jdField_a_of_type_Bhtd.postDelayed(new ExtendFriendSearchBaseFragment.3(this), 50L);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onSoftKeyboardClosed()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(false);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
  }
  
  public void onStop()
  {
    super.onStop();
    c();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
    }
    super.onViewStateRestored(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchBaseFragment
 * JD-Core Version:    0.7.0.1
 */