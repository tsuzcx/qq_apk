package com.tencent.mobileqq.filemanager.activity;

import allz;
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
import aqid;
import aqie;
import aqif;
import aqig;
import armz;
import bdee;
import biqi;
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
  private aqig jdField_a_of_type_Aqig;
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
  
  public View a(ViewGroup paramViewGroup, aqig paramaqig)
  {
    this.jdField_a_of_type_Aqig = paramaqig;
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560687, null).findViewById(2131379472);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aqig = null;
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  @TargetApi(11)
  public void b()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379475);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372496));
    this.jdField_a_of_type_AndroidWidgetTextView.setLongClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.addTextChangedListener(new aqid(this));
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextIsSelectable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setCustomSelectionActionModeCallback(new aqie(this));
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131379473));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370643));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694521);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new aqif(this));
    if (!bdee.d(BaseApplicationImpl.getContext())) {
      armz.a(BaseApplicationImpl.getContext().getString(2131694764));
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
      armz.a(BaseApplicationImpl.getContext().getString(2131694540));
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
      if (paramView.length() < 6)
      {
        armz.a(BaseApplicationImpl.getContext().getString(2131694541));
        return;
      }
      if (!bdee.d(BaseApplicationImpl.getContext()))
      {
        armz.a(BaseApplicationImpl.getContext().getString(2131694764));
        return;
      }
      allz localallz = (allz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      localallz.a().a(paramView);
      this.jdField_a_of_type_Long = localallz.a().a(2);
    } while (this.jdField_a_of_type_Aqig == null);
    this.jdField_a_of_type_Aqig.a(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView
 * JD-Core Version:    0.7.0.1
 */