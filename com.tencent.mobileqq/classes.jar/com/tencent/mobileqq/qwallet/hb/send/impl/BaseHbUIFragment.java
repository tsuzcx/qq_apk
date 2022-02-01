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
import com.tencent.mobileqq.qwallet.hb.aio.impl.QWalletRedPkgUtils;
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
  protected View a;
  protected Button b;
  protected EditText c;
  protected EditText d;
  protected EditText l;
  protected HbInfo.BundleInfo m = new HbInfo.BundleInfo();
  protected TextWatcher n = new BaseHbUIFragment.1(this);
  private DecimalFormat o = new DecimalFormat("0.00");
  
  protected void a(Bundle paramBundle)
  {
    HbInfo.a(paramBundle, this.m);
    this.c = ((EditText)this.a.findViewById(R.id.bb));
    paramBundle = this.c;
    paramBundle.addTextChangedListener(new NumWatcher(paramBundle));
    this.d = ((EditText)this.a.findViewById(R.id.b));
    this.d.addTextChangedListener(this.n);
    paramBundle = this.d;
    paramBundle.addTextChangedListener(new MoneyWatcher(paramBundle));
    this.b = ((Button)this.a.findViewById(R.id.z));
    this.l = ((EditText)this.a.findViewById(R.id.aX));
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("bundleInfo: ");
      paramBundle.append(this.m);
      QLog.i("BaseHbUIFragment", 2, paramBundle.toString());
    }
  }
  
  protected void c()
  {
    EditText localEditText = this.l;
    if (localEditText != null) {
      localEditText.setHint(HbBusiUtils.a(this.i, this.m, this.f.getConfigLogic(), d()));
    }
    e();
  }
  
  protected abstract String d();
  
  protected void e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recv_type: ");
    ((StringBuilder)localObject).append(this.m.recv_type);
    QLog.i("BaseHbUIFragment", 2, ((StringBuilder)localObject).toString());
    if (QWalletRedPkgUtils.a(this.m.recv_type))
    {
      this.c.setHint("填写个数");
      this.c.addTextChangedListener(this.n);
      return;
    }
    if (HbInfo.b.contains(this.m.recv_type))
    {
      this.c.setText("1");
      ((View)this.c.getParent()).setVisibility(8);
      return;
    }
    if (!TextUtils.isEmpty(this.m.people_num))
    {
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(R.string.al));
      localStringBuilder.append(this.m.people_num);
      localStringBuilder.append(HardCodeUtil.a(R.string.an));
      ((EditText)localObject).setHint(localStringBuilder.toString());
    }
    this.c.addTextChangedListener(this.n);
  }
  
  protected String f()
  {
    return HbBusiUtils.a(this.l);
  }
  
  protected float g()
  {
    return QwUtils.a(this.d.getText().toString());
  }
  
  public boolean h()
  {
    String str = this.c.getText().toString();
    float f = g();
    if ((QwUtils.a(str, 0) > 0) && (f > 0.0F))
    {
      this.b.setEnabled(true);
      this.b.setText(String.format(HardCodeUtil.a(R.string.am), new Object[] { this.o.format(f) }));
      return true;
    }
    this.b.setEnabled(false);
    this.b.setText(getString(R.string.I));
    return false;
  }
  
  protected boolean i()
  {
    if (QwUtils.a()) {
      return false;
    }
    if (QwUtils.a(this.d.getText().toString()) <= 0.0F)
    {
      QLog.d("BaseHbUIFragment", 2, "amount error, no input!");
      return false;
    }
    return true;
  }
  
  public abstract int j();
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    QLog.i("BaseHbUIFragment", 2, "oncreate view enter...");
    this.a = paramLayoutInflater.inflate(j(), null);
    a(getArguments());
    c();
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
 * JD-Core Version:    0.7.0.1
 */