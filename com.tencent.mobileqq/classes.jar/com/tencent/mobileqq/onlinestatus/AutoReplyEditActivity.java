package com.tencent.mobileqq.onlinestatus;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
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
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.onlinestatus.tempapi.IEmojiPanelApi;
import com.tencent.mobileqq.onlinestatus.view.SoftInputDetectView;
import com.tencent.mobileqq.onlinestatus.view.SoftInputDetectView.OnImStateChangedListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.util.InputMethodUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AutoReplyEditActivity
  extends QIphoneTitleBarFragment
  implements SoftInputDetectView.OnImStateChangedListener
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new AutoReplyEditActivity.1(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private AutoReplyText jdField_a_of_type_ComTencentMobileqqDataAutoReplyText;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  
  private void a()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getQBaseActivity(), 230).setMessage(getString(2131690250));
    localQQCustomDialog.setPositiveButton(2131694583, new AutoReplyEditActivity.10(this));
    localQQCustomDialog.setNegativeButton(2131690728, new AutoReplyEditActivity.11(this));
    localQQCustomDialog.show();
  }
  
  public static void a(Activity paramActivity, int paramInt, AutoReplyText paramAutoReplyText)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("AutoReplyEditActivity:text", paramAutoReplyText);
    QPublicFragmentActivity.startForResult(paramActivity, localIntent, AutoReplyEditActivity.class, paramInt);
  }
  
  private boolean a(String paramString)
  {
    if (paramString != null)
    {
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        int k = paramString.charAt(i);
        if ((k != 32) && (k != 10) && (k != 13) && (k != 9)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private void c()
  {
    if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130837594);
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(getQBaseActivity().getString(2131690251));
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130837593);
    this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(getQBaseActivity().getString(2131690248));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void c(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    a(getString(2131690239));
    a(2131690728, new AutoReplyEditActivity.2(this));
    c(2131692486, new AutoReplyEditActivity.3(this));
    ((SoftInputDetectView)this.b.findViewById(2131368888)).setOnImStateChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText = ((AutoReplyText)localBundle.getParcelable("AutoReplyEditActivity:text"));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.b.findViewById(2131366154));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.b.findViewById(2131363090));
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(new AutoReplyEditActivity.4(this));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText;
    if (paramBundle != null)
    {
      if (paramBundle.getTextId() == 2147483647) {
        this.jdField_d_of_type_Boolean = false;
      } else {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.getRawText());
      }
    }
    else {
      this.jdField_d_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_c_of_type_AndroidViewView = ((IEmojiPanelApi)QRoute.api(IEmojiPanelApi.class)).findAndInitEmojiPanel(this.jdField_a_of_type_MqqAppAppRuntime, getQBaseActivity(), this.b, 2131366155, this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())) {
      this.jdField_d_of_type_AndroidWidgetTextView.setEnabled(false);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new AutoReplyEditActivity.5(this));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.b.findViewById(2131366182));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.b.findViewById(2131366185));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new AutoReplyEditActivity.6(this));
    if (!QQTheme.e())
    {
      this.b.findViewById(2131379004).setVisibility(8);
      this.b.findViewById(2131363737).setVisibility(8);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d(false);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AutoReplyEditActivity.7(this), 0L);
      return;
    }
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(false);
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      AutoReplyEditActivity.8 local8 = new AutoReplyEditActivity.8(this);
      long l;
      if (this.jdField_a_of_type_Boolean) {
        l = 500L;
      } else {
        l = 10L;
      }
      ((Handler)localObject).postDelayed(local8, l);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850215);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getQBaseActivity().getString(2131690246));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new AutoReplyEditActivity.9(this));
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    ((ViewGroup.LayoutParams)localObject).height = -2;
    this.jdField_a_of_type_AndroidViewViewGroup.setMinimumHeight(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    c();
  }
  
  protected int a()
  {
    return 2131558450;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_MqqAppAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    c(getArguments());
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      d(false);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    c();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(16);
    paramActivity.getWindow().getDecorView().setBackgroundResource(2130838739);
  }
  
  public boolean onBackEvent()
  {
    if ((!getQBaseActivity().isFinishing()) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
    {
      d(false);
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity
 * JD-Core Version:    0.7.0.1
 */