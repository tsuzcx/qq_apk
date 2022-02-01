package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.devicelib.DeviceLib;
import com.tencent.mobileqq.qwallet.widget.MyLinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class QQCustomDialogWtihInputAndChoose
  extends QQCustomDialogWtihForwardAvatar
  implements View.OnClickListener
{
  public static final Integer a;
  public static final Integer b;
  final float jdField_a_of_type_Float = 267.0F;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  protected View.OnClickListener a;
  protected View a;
  WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  MyLinearLayout jdField_a_of_type_ComTencentMobileqqQwalletWidgetMyLinearLayout;
  SoftReference<Context> jdField_a_of_type_JavaLangRefSoftReference;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  final float jdField_b_of_type_Float = 45.5F;
  boolean jdField_b_of_type_Boolean;
  final float jdField_c_of_type_Float = 39.0F;
  boolean jdField_c_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
    jdField_b_of_type_JavaLangInteger = Integer.valueOf(2);
  }
  
  public QQCustomDialogWtihInputAndChoose(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new QQCustomDialogWtihInputAndChoose.2(this);
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramContext);
    getWindow().setSoftInputMode(19);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqQwalletWidgetMyLinearLayout);
      this.jdField_b_of_type_Boolean = false;
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.y = 0;
      getWindow().setAttributes(localLayoutParams);
    }
  }
  
  public void a(int paramInt)
  {
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localEditText != null)
    {
      localEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new QQCustomDialogWtihInputAndChoose.3(this, paramInt));
    }
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletWidgetMyLinearLayout = ((MyLinearLayout)View.inflate(paramContext, 2131558996, null));
    this.jdField_a_of_type_ComTencentMobileqqQwalletWidgetMyLinearLayout.findViewById(2131370117).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQwalletWidgetMyLinearLayout.setDispatchKeyEventListener(new QQCustomDialogWtihInputAndChoose.4(this));
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
      paramString = this.jdField_a_of_type_AndroidWidgetEditText;
      paramString.setSelection(paramString.getText().length());
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      float f = getContext().getResources().getDisplayMetrics().density;
      LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqQwalletWidgetMyLinearLayout.findViewById(2131370113);
      localLinearLayout.removeAllViews();
      int i = 0;
      while (i < paramArrayList.size())
      {
        View localView = View.inflate(getContext(), 2131558997, null);
        localView.setTag(Integer.valueOf(i));
        localView.setClickable(true);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((TextView)localView.findViewById(2131370112)).setText((CharSequence)paramArrayList.get(i));
        localLinearLayout.addView(localView, new LinearLayout.LayoutParams(-1, (int)(45.5F * f)));
        i += 1;
      }
      if (paramArrayList.size() >= 5) {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(-1, (int)(f * 267.0F), 2, 32, -1);
      } else {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(-1, (int)((paramArrayList.size() * 45.5F + 39.0F + 2.0F) * f), 2, 32, -1);
      }
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 81;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    if (paramView.getId() == 2131368884)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletWidgetMyLinearLayout != null) {
        if (this.jdField_b_of_type_Boolean)
        {
          a();
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847537);
          this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130847537));
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QQCustomDialogWtihInputAndChoose.5(this), 200L);
        }
        else
        {
          Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getTag();
          if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2130848135))
          {
            InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847537);
            this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130847537));
            this.jdField_b_of_type_Boolean = false;
          }
          else
          {
            InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848135);
            this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130848135));
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QQCustomDialogWtihInputAndChoose.6(this), 200L);
          }
        }
      }
    }
    else if (paramView.getId() == 2131370117)
    {
      a();
    }
    else
    {
      a();
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    a();
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365640));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131368874));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368884));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    findViewById(2131377003).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new QQCustomDialogWtihInputAndChoose.1(this));
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if (localContext == null) {
      return;
    }
    DeviceLib.a(localContext, this.jdField_a_of_type_AndroidWidgetEditText);
    a(localContext);
  }
  
  public void setEditLint(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramString);
  }
  
  public QQCustomDialog setMessage(CharSequence paramCharSequence)
  {
    TextView localTextView = (TextView)findViewById(2131365620);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      localTextView.setText(paramCharSequence);
      localTextView.setContentDescription(paramCharSequence);
      localTextView.setVisibility(0);
      return this;
    }
    localTextView.setVisibility(8);
    return this;
  }
  
  public QQCustomDialog setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramInt);
    TextView localTextView = this.lBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getContext().getString(paramInt));
    localStringBuilder.append(getContext().getString(2131691115));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new QQCustomDialogWtihInputAndChoose.7(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialog setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setContentDescription(getContext().getString(paramInt));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new QQCustomDialogWtihInputAndChoose.8(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose
 * JD-Core Version:    0.7.0.1
 */