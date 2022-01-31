package com.tencent.mobileqq.filemanager.activity;

import ajuo;
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
import aopa;
import aopb;
import aopc;
import aopd;
import aptv;
import bbev;
import bgos;
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
  private aopd jdField_a_of_type_Aopd;
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
  
  public View a(ViewGroup paramViewGroup, aopd paramaopd)
  {
    this.jdField_a_of_type_Aopd = paramaopd;
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560512, null).findViewById(2131378846);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aopd = null;
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  @TargetApi(11)
  public void b()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378849);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372170));
    this.jdField_a_of_type_AndroidWidgetTextView.setLongClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.addTextChangedListener(new aopa(this));
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextIsSelectable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setCustomSelectionActionModeCallback(new aopb(this));
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131378847));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370340));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694363);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new aopc(this));
    if (!bbev.d(BaseApplicationImpl.getContext())) {
      aptv.a(BaseApplicationImpl.getContext().getString(2131694607));
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
      aptv.a(BaseApplicationImpl.getContext().getString(2131694382));
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
      if (paramView.length() < 6)
      {
        aptv.a(BaseApplicationImpl.getContext().getString(2131694383));
        return;
      }
      if (!bbev.d(BaseApplicationImpl.getContext()))
      {
        aptv.a(BaseApplicationImpl.getContext().getString(2131694607));
        return;
      }
      ajuo localajuo = (ajuo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      localajuo.a().a(paramView);
      this.jdField_a_of_type_Long = localajuo.a().a(2);
    } while (this.jdField_a_of_type_Aopd == null);
    this.jdField_a_of_type_Aopd.a(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView
 * JD-Core Version:    0.7.0.1
 */