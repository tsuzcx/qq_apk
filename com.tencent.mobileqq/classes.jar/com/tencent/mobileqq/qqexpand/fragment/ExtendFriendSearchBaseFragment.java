package com.tencent.mobileqq.qqexpand.fragment;

import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
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
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.TagUtils;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendMultiLinesTagsView;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;

public abstract class ExtendFriendSearchBaseFragment
  extends PublicBaseFragment
  implements Handler.Callback, TextWatcher, View.OnClickListener, TextView.OnEditorActionListener, SoftKeyboardStateHelper.SoftKeyboardStateListener, BounceScrollView.OnScrollChangedListener
{
  private int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected BaseActivity a;
  protected QQAppInterface a;
  private ExtendFriendMultiLinesTagsView jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView;
  private SoftKeyboardStateHelper jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper;
  private QuickPinyinEditText jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private boolean jdField_a_of_type_Boolean = true;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ExtendFriendMultiLinesTagsView jdField_b_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView;
  
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
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.requestFocus();
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      a(true, 50L);
    }
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
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(12);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(11);
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(11)) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(11, paramLong);
      }
    }
    else if (!this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(12)) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(12, paramLong);
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSearchBaseFragment", 2, "showInputMethod");
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
    ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, 0);
  }
  
  private void b(int paramInt)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact == null))
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getBaseActivity(), false, getResources().getColor(paramInt));
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
      if (Build.VERSION.SDK_INT >= 19) {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(67108864);
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
    ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
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
      if ((this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) && (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)))
      {
        int i = getResources().getColor(2131166892);
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarMask(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
        return;
      }
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
    int i;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView.setSearchTags(paramArrayList);
    paramArrayList = this.jdField_a_of_type_AndroidViewViewGroup;
    if (i != 0) {
      j = 8;
    }
    paramArrayList.setVisibility(j);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_Int == 1) && (TextUtils.isEmpty(paramEditable))) {
      a(0);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
    if (localObject != null)
    {
      float f3 = ((QuickPinyinEditText)localObject).getWidth() - this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingLeft() - this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getPaddingRight();
      float f4 = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTextSize();
      float f2 = 18.0F;
      float f1 = f2;
      if (f4 > 1.0F)
      {
        f1 = f2;
        if (f3 > 1.0F) {
          f1 = f3 / f4;
        }
      }
      f1 = Math.max(f1, 12.0F);
      localObject = paramString;
      if (TagUtils.a(paramString) > f1)
      {
        int i = Math.max(0, (int)(f1 - 4.0F));
        int j = i;
        while (i < paramString.length())
        {
          if (!TextUtils.equals(String.valueOf(paramString.charAt(i - 1)), "、"))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString.substring(0, i));
            ((StringBuilder)localObject).append("…");
            if (TagUtils.a(((StringBuilder)localObject).toString()) > f1) {
              break;
            }
            j = i;
          }
          i += 1;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, j));
        ((StringBuilder)localObject).append("…");
        localObject = ((StringBuilder)localObject).toString();
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint((CharSequence)localObject);
    }
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    int j = 0;
    int i;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView.setSearchTags(paramArrayList);
    paramArrayList = this.jdField_b_of_type_AndroidViewViewGroup;
    if (i != 0) {
      j = 8;
    }
    paramArrayList.setVisibility(j);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 11)
    {
      if (i == 12) {
        c();
      }
    }
    else {
      b();
    }
    return false;
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
    case 1912930356: 
      if (this.jdField_a_of_type_Int == 1) {
        a(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
      return;
    case 1912930355: 
      if (this.jdField_a_of_type_Int == 1)
      {
        a(0);
        return;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      if (paramView != null)
      {
        paramView.finish();
        return;
      }
      break;
    case 1912930324: 
      a();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow();
    if (paramBundle != null)
    {
      paramBundle.setFormat(-3);
      paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = (ViewGroup)paramLayoutInflater.inflate(1912995845, null);
    paramViewGroup = paramLayoutInflater.findViewById(1912930367);
    if (paramViewGroup != null)
    {
      paramBundle = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
      paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramViewGroup.setLayoutParams(paramBundle);
      b(2131167114);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramLayoutInflater.findViewById(1912930359));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setInputType(524289);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(1912930356));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(1912930355));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(UITools.a);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLayoutInflater.findViewById(1912930357));
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramLayoutInflater.findViewById(1912930361));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(1912930325));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(1912930326));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView.setViewMargin(AIOUtils.b(10.0F, getResources()), AIOUtils.b(10.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView.setOnItemClickListener(new ExtendFriendSearchBaseFragment.1(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(1912930324));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(1912930351));
    this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView = ((ExtendFriendMultiLinesTagsView)paramLayoutInflater.findViewById(1912930352));
    this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView.setViewMargin(AIOUtils.b(10.0F, getResources()), AIOUtils.b(10.0F, getResources()));
    this.jdField_b_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendMultiLinesTagsView.setOnItemClickListener(new ExtendFriendSearchBaseFragment.2(this));
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(1912930344);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
      int i;
      if (bool) {
        i = 0;
      } else {
        i = 8;
      }
      paramViewGroup.setVisibility(i);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper = new SoftKeyboardStateHelper(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper.a(this);
    a(0);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(null);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66))) {
      return false;
    }
    paramTextView = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
    if (!TextUtils.isEmpty(paramTextView)) {
      c(paramTextView);
    }
    a(false, 50L);
    return true;
  }
  
  public void onFinish()
  {
    super.onFinish();
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localBaseActivity != null) {
      localBaseActivity.overridePendingTransition(0, 2130772377);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 1))
    {
      a(false);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new ExtendFriendSearchBaseFragment.3(this), 50L);
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
    QuickPinyinEditText localQuickPinyinEditText = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
    if (localQuickPinyinEditText != null) {
      localQuickPinyinEditText.removeTextChangedListener(this);
    }
    super.onViewStateRestored(paramBundle);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
    if (paramBundle != null) {
      paramBundle.addTextChangedListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchBaseFragment
 * JD-Core Version:    0.7.0.1
 */