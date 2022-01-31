package com.tencent.mobileqq.filemanager.activity;

import ajum;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import aopf;
import aopg;
import aoph;
import aopi;
import aptx;
import bbfj;
import bgpj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Timer;

public class MPFileVerifyPwdView
  extends LinearLayout
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView = null;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aopi jdField_a_of_type_Aopi;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Timer jdField_a_of_type_JavaUtilTimer = new Timer();
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public MPFileVerifyPwdView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, aopi paramaopi)
  {
    this.jdField_a_of_type_Aopi = paramaopi;
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560511, null).findViewById(2131378851);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aopi = null;
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  @TargetApi(11)
  public void b()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378854);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372172));
    this.jdField_a_of_type_AndroidWidgetTextView.setLongClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.addTextChangedListener(new aopf(this));
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextIsSelectable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setCustomSelectionActionModeCallback(new aopg(this));
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131378852));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370339));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694364);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new aoph(this));
    if (!bbfj.d(BaseApplicationImpl.getContext())) {
      aptx.a(BaseApplicationImpl.getContext().getString(2131694608));
    }
  }
  
  public void c()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new MPFileVerifyPwdView.4(this));
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    if ((paramView == null) || (paramView.equals(""))) {
      aptx.a(BaseApplicationImpl.getContext().getString(2131694383));
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
      if (paramView.length() < 6)
      {
        aptx.a(BaseApplicationImpl.getContext().getString(2131694384));
        return;
      }
      if (!bbfj.d(BaseApplicationImpl.getContext()))
      {
        aptx.a(BaseApplicationImpl.getContext().getString(2131694608));
        return;
      }
      ajum localajum = (ajum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      localajum.a().a(paramView);
      this.jdField_a_of_type_Long = localajum.a().a(2);
    } while (this.jdField_a_of_type_Aopi == null);
    this.jdField_a_of_type_Aopi.a(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView
 * JD-Core Version:    0.7.0.1
 */