package com.tencent.mobileqq.forward;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.devicelib.DeviceLib;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar;
import com.tencent.mobileqq.utils.SoftKeyboardHeight;
import com.tencent.mobileqq.utils.SoftKeyboardHeight.OnGetSoftHeightListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.MaxHeightRelativelayout;
import java.lang.ref.SoftReference;

public class ForwardNewVersionDialog
  extends QQCustomDialogWtihForwardAvatar
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private int jdField_a_of_type_Int = 7;
  private Resources jdField_a_of_type_AndroidContentResResources = null;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected ScrollView a;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
  private ForwardNewVersionDialog.ForwardWriteTogetherListener jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog$ForwardWriteTogetherListener;
  SoftKeyboardHeight.OnGetSoftHeightListener jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight$OnGetSoftHeightListener = new ForwardNewVersionDialog.1(this);
  private SoftKeyboardHeight jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight;
  private MaxHeightRelativelayout jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout;
  private SoftReference<Context> jdField_a_of_type_JavaLangRefSoftReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ForwardNewVersionDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131755842);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams != null) {
      localLayoutParams.gravity = 17;
    }
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramContext);
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    getWindow().setSoftInputMode(19);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(-1, SoftKeyboardHeight.a(0), 2, 32, -1);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 81;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755188;
    setContentView(2131559079);
  }
  
  private int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private void a(Context paramContext)
  {
    Object localObject = new ForwardNewVersionDialog.6(this);
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof QQAppInterface))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131299166);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(getContext(), 2131559200, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack((EmoticonCallback)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
      if (this.jdField_a_of_type_Int == 7) {}
      for (boolean bool = true;; bool = false)
      {
        ((EmoticonMainPanel)localObject).onlySysAndEmoji = bool;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.init((QQAppInterface)paramContext, 100003, getContext(), i, null, null, false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.hideAllTabs();
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_b_of_type_Int;
        return;
      }
    }
    QLog.e("Forward.NewVersion.Dialog", 1, "get QQAppInterface fail");
  }
  
  private boolean a()
  {
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    return ((localContext instanceof Activity)) && (((Activity)localContext).isFinishing());
  }
  
  private void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = -2;
      this.jdField_a_of_type_AndroidViewView.requestLayout();
    }
  }
  
  public ForwardNewVersionDialog a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramString);
    this.lBtn.setVisibility(0);
    this.lBtn.setContentDescription(paramString + getContext().getString(2131691194));
    this.lBtn.setOnClickListener(new ForwardNewVersionDialog.9(this, paramOnClickListener));
    return this;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getTag();
    if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2130840283))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840282);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130840282));
      b();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      }
    }
  }
  
  public void a(int paramInt)
  {
    setContentView(paramInt);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.addView(paramView);
  }
  
  public void a(ForwardNewVersionDialog.ForwardWriteTogetherListener paramForwardWriteTogetherListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardNewVersionDialog$ForwardWriteTogetherListener = paramForwardWriteTogetherListener;
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    this.title.setText(paramString1);
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramString2);
    a(paramString3, paramOnClickListener2);
    b(paramString4, paramOnClickListener1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public ForwardNewVersionDialog b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramString);
    this.rBtn.setContentDescription(paramString + getContext().getString(2131691194));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new ForwardNewVersionDialog.10(this, paramOnClickListener));
    return this;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ForwardNewVersionDialog.5(this, paramInt));
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setMaxHeight(AIOUtils.a(paramInt, getContext().getResources()));
  }
  
  public EditText getEditText()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  public String getInputValue()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
  }
  
  public void hideSoftInputFromWindow()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView.getId() == 2131366225) {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label117;
        }
        b();
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840282);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130840282));
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ForwardNewVersionDialog.7(this), 200L);
        localObject = getWindow().getAttributes();
        ((WindowManager.LayoutParams)localObject).y = 0;
        getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label117:
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2130840283))
      {
        InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840282);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130840282));
        this.jdField_a_of_type_Boolean = false;
      }
      else
      {
        InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840283);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130840283));
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setMinimumHeight(SoftKeyboardHeight.a(0));
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ForwardNewVersionDialog.8(this), 200L);
        continue;
        if (this.jdField_a_of_type_Boolean)
        {
          b();
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
          this.jdField_a_of_type_Boolean = false;
          localObject = getWindow().getAttributes();
          ((WindowManager.LayoutParams)localObject).y = 0;
          getWindow().setAttributes((WindowManager.LayoutParams)localObject);
        }
        InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onDestory();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight.a();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      this.jdField_a_of_type_Boolean = false;
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.y = 0;
      getWindow().setAttributes(localLayoutParams);
      b();
    }
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout = ((MaxHeightRelativelayout)findViewById(2131377207));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380828));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131369141));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366225));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369153));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365803);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.getCustomSizeEditableFactory(16));
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(2);
    b(this.jdField_a_of_type_AndroidContentResResources.getInteger(2131427338));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new ForwardNewVersionDialog.2(this));
    Object localObject = (Context)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if (localObject == null) {
      return;
    }
    DeviceLib.a((Context)localObject, this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight = new SoftKeyboardHeight(((ViewGroup)getWindow().getDecorView().findViewById(16908290)).getChildAt(0), this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getHeight(), this.jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight$OnGetSoftHeightListener);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight.a();
    this.jdField_b_of_type_Int = SoftKeyboardHeight.a(this.jdField_b_of_type_Int);
    setOnDismissListener(this);
    a((Context)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setDispatchKeyEventListener(new ForwardNewVersionDialog.3(this));
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131377552);
    if ((localObject instanceof ScrollView)) {
      this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)localObject);
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new ForwardNewVersionDialog.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog
 * JD-Core Version:    0.7.0.1
 */