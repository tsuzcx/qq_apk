package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.HbInfo.BundleInfo;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbBusiUtils;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.MoneyWatcher;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.NumWatcher;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.text.DecimalFormat;
import java.util.List;

public abstract class BaseHbUIFragment
  extends BaseHbFragment
{
  protected TextWatcher a;
  protected View a;
  protected Button a;
  protected EditText a;
  protected HbInfo.BundleInfo a;
  private DecimalFormat a;
  protected EditText b;
  protected EditText c;
  
  public BaseHbUIFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo = new HbInfo.BundleInfo();
    this.jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
    this.jdField_a_of_type_AndroidTextTextWatcher = new BaseHbUIFragment.1(this);
  }
  
  protected float a()
  {
    return QwUtils.a(this.b.getText().toString());
  }
  
  protected abstract String a();
  
  protected void a(Bundle paramBundle)
  {
    HbInfo.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.aT));
    paramBundle = this.jdField_a_of_type_AndroidWidgetEditText;
    paramBundle.addTextChangedListener(new NumWatcher(paramBundle));
    this.b = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.b));
    this.b.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    paramBundle = this.b;
    paramBundle.addTextChangedListener(new MoneyWatcher(paramBundle));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.u));
    this.c = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.aP));
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("bundleInfo: ");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo);
      QLog.i("BaseHbUIFragment", 2, paramBundle.toString());
    }
  }
  
  public boolean a()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    float f = a();
    if ((QwUtils.a(str, 0) > 0) && (f > 0.0F))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(HardCodeUtil.a(R.string.al), new Object[] { this.jdField_a_of_type_JavaTextDecimalFormat.format(f) }));
      return true;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setText(getString(R.string.I));
    return false;
  }
  
  public abstract int b();
  
  protected String b()
  {
    return HbBusiUtils.a(this.c);
  }
  
  protected void b()
  {
    this.c.setHint(HbBusiUtils.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getConfigLogic(), a()));
    c();
  }
  
  protected boolean b()
  {
    if (QwUtils.a()) {
      return false;
    }
    if (QwUtils.a(this.b.getText().toString()) <= 0.0F)
    {
      QLog.d("BaseHbUIFragment", 2, "amount error, no input!");
      return false;
    }
    return true;
  }
  
  protected void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recv_type: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo.recv_type);
    QLog.i("BaseHbUIFragment", 2, ((StringBuilder)localObject).toString());
    if (HbInfo.b.contains(this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      ((View)this.jdField_a_of_type_AndroidWidgetEditText.getParent()).setVisibility(8);
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo.people_num))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetEditText;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(R.string.ak));
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo.people_num);
      localStringBuilder.append(HardCodeUtil.a(R.string.am));
      ((EditText)localObject).setHint(localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    QLog.i("BaseHbUIFragment", 2, "oncreate view enter...");
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(b(), null);
    a(getArguments());
    b();
    return this.jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
 * JD-Core Version:    0.7.0.1
 */