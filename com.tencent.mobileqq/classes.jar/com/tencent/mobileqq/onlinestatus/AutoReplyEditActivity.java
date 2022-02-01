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
import azan;
import azao;
import azap;
import azaq;
import azar;
import azas;
import azat;
import azau;
import azav;
import azaw;
import azay;
import azvz;
import bhdj;
import bkxz;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class AutoReplyEditActivity
  extends IphoneTitleBarFragment
  implements azvz
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new azan(this);
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
    paramView.setCallBack(new azaq(paramEditText, paramQQAppInterface, paramBaseActivity));
    paramView.disableGuide = true;
    paramView.disableMoreEmotionButton = true;
    paramView.hasBigEmotion = false;
    paramView.onlySysAndEmoji = true;
    paramView.disableAutoDownload = true;
    paramView.init(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new azar());
    paramView.mEmoticonTabs.setOverScrollMode(2);
    return paramView;
  }
  
  private void a()
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(getActivity(), 230).setMessage(getString(2131690264));
    localQQCustomDialog.setPositiveButton(2131694399, new azao(this));
    localQQCustomDialog.setNegativeButton(2131690697, new azap(this));
    localQQCustomDialog.show();
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
    setTitle(getString(2131690253));
    setLeftButton(2131690697, new azas(this));
    setRightButton(2131692403, new azat(this));
    ((SoftInputDetectView)this.mContentView.findViewById(2131368924)).setOnImStateChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText = ((AutoReplyText)localBundle.getParcelable("AutoReplyEditActivity:text"));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.mContentView.findViewById(2131366094));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131363104));
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(new azau(this));
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
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.mContentView, 2131366095, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
      if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())) {
        this.rightViewText.setEnabled(false);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new azav(this));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131366122));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131366125));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new azaw(this));
      if (!ThemeUtil.isDefaultTheme())
      {
        this.mContentView.findViewById(2131379227).setVisibility(8);
        this.mContentView.findViewById(2131363714).setVisibility(8);
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
    bkxz.b(this.jdField_a_of_type_AndroidWidgetEditText);
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
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690262));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837507);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690265));
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849890);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getActivity().getString(2131690260));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new azay(this));
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
    return 2131558422;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(16);
    paramActivity.getWindow().getDecorView().setBackgroundResource(2130838911);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity
 * JD-Core Version:    0.7.0.1
 */