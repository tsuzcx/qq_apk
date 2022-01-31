package com.tencent.mobileqq.onlinestatus;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import avzr;
import avzs;
import avzt;
import avzu;
import avzv;
import avzw;
import avzx;
import avzy;
import avzz;
import awaa;
import awac;
import awsb;
import bdcd;
import bdfq;
import bhoc;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.theme.ThemeUtil;

public class AutoReplyEditActivity
  extends IphoneTitleBarFragment
  implements awsb
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new avzr(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AutoReplyText jdField_a_of_type_ComTencentMobileqqDataAutoReplyText;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  private static EmoticonMainPanel a(@NonNull QQAppInterface paramQQAppInterface, @NonNull BaseActivity paramBaseActivity, @NonNull View paramView, int paramInt, @NonNull EditText paramEditText)
  {
    paramView = (EmoticonMainPanel)paramView.findViewById(paramInt);
    paramView.setCallBack(new avzu(paramEditText, paramQQAppInterface, paramBaseActivity));
    paramView.c = true;
    paramView.f = true;
    paramView.jdField_a_of_type_Boolean = false;
    paramView.jdField_b_of_type_Boolean = true;
    paramView.e = true;
    paramView.a(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new avzv());
    paramView.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setOverScrollMode(2);
    return paramView;
  }
  
  private void a()
  {
    bdfq localbdfq = bdcd.a(getActivity(), 230).setMessage(getString(2131690368));
    localbdfq.setPositiveButton(2131694951, new avzs(this));
    localbdfq.setNegativeButton(2131690648, new avzt(this));
    localbdfq.show();
  }
  
  public static void a(Activity paramActivity, int paramInt, AutoReplyText paramAutoReplyText)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("AutoReplyEditActivity:text", paramAutoReplyText);
    PublicFragmentActivity.a(paramActivity, localIntent, AutoReplyEditActivity.class, paramInt);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    setTitle(getString(2131690352));
    setLeftButton(2131690648, new avzw(this));
    setRightButton(2131692680, new avzx(this));
    ((SoftInputDetectView)this.mContentView.findViewById(2131368347)).setOnImStateChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText = ((AutoReplyText)localBundle.getParcelable("AutoReplyEditActivity:text"));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.mContentView.findViewById(2131365679));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131362936));
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(new avzy(this));
    if (this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.getTextId() == 2147483647) {
        this.c = false;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.mContentView, 2131365680, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
      if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())) {
        this.rightViewText.setEnabled(false);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new avzz(this));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131365707));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131365709));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new awaa(this));
      if (!ThemeUtil.isDefaultTheme())
      {
        this.mContentView.findViewById(2131378099).setVisibility(8);
        this.mContentView.findViewById(2131363396).setVisibility(8);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.getRawText());
      continue;
      this.c = true;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(false);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AutoReplyEditActivity.7(this), 0L);
      return;
    }
    bhoc.b(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (paramString != null)
    {
      j = paramString.length();
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        int k = paramString.charAt(i);
        if ((k != 32) && (k != 10) && (k != 13) && (k != 9)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void b()
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837506);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690366));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837507);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690369));
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(false);
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      AutoReplyEditActivity.8 local8 = new AutoReplyEditActivity.8(this);
      if (this.jdField_a_of_type_Boolean) {}
      for (long l = 500L;; l = 10L)
      {
        ((Handler)localObject).postDelayed(local8, l);
        return;
      }
    }
    this.jdField_b_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849245);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690364));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new awac(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
    ((ViewGroup.LayoutParams)localObject).height = -2;
    this.jdField_a_of_type_AndroidViewViewGroup.setMinimumHeight(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    b();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      b(false);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    b();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Boolean = false;
    this.c = false;
    this.jdField_b_of_type_Boolean = false;
    a(getArguments());
  }
  
  public int getContentLayoutId()
  {
    return 2131558419;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(16);
    paramActivity.getWindow().getDecorView().setBackgroundResource(2130838591);
  }
  
  public boolean onBackEvent()
  {
    if ((!getActivity().isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0))
    {
      b(false);
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity
 * JD-Core Version:    0.7.0.1
 */