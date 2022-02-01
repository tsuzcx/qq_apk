package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qwallet.temp.IIndividualRedPacket;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.HbInfo.BundleInfo;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinInfo;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinLogic;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.util.List;
import java.util.Map;

public class UsualHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private static final List<Integer> jdField_a_of_type_JavaUtilList = new UsualHbFragment.1();
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HbSkinLogic jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinLogic;
  
  private void d()
  {
    if (!b()) {
      return;
    }
    int i = QwUtils.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 1);
    String str = QwUtils.a(String.valueOf(a()));
    if (TextUtils.isEmpty(str))
    {
      QQToast.a(getActivity(), R.string.h, 0).a();
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo, c(), i, str, "hongbao.wrap.go");
    Object localObject2 = this.c.getText().toString();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      if (TextUtils.isEmpty(this.c.getHint())) {
        localObject1 = getResources().getString(R.string.L);
      } else {
        localObject1 = this.c.getHint().toString();
      }
    }
    int j = c();
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getMapPacketExtra();
    ((Map)localObject2).put("channel", String.valueOf(j));
    ((Map)localObject2).put("type", "1");
    ((Map)localObject2).put("wishing", localObject1);
    ((Map)localObject2).put("bus_type", this.jdField_a_of_type_AndroidOsBundle.getString("bus_type"));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append("");
    ((Map)localObject2).put("total_num", ((StringBuilder)localObject1).toString());
    ((Map)localObject2).put("total_amount", str);
    if (512 == j) {
      ((Map)localObject2).put("feeds_sid", this.jdField_a_of_type_AndroidOsBundle.getString("feedsid"));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinLogic.a())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(HbSkinInfo.c);
      ((Map)localObject2).put("skin_id", ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinLogic.a());
      ((Map)localObject2).put("skin_id", ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplSendHbLogic.a((Map)localObject2);
    ReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "redpack.paybtn.click", null, this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo.panel_name);
  }
  
  protected float a()
  {
    float f = QwUtils.a(this.b.getText().toString());
    if (QwUtils.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo.bus_type, 1) == 1) {
      return QwUtils.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 0) * f;
    }
    return f;
  }
  
  protected String a()
  {
    return HardCodeUtil.a(R.string.di);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    QLog.i("UsualHbFragment", 2, "init view...");
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinLogic = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getHbSkinLogic();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.f));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramBundle = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.cv);
    if (String.valueOf(2).equals(this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo.bus_type))
    {
      paramBundle.setText(R.string.G);
      return;
    }
    paramBundle.setText(R.string.H);
  }
  
  public int b()
  {
    return R.layout.r;
  }
  
  public void b()
  {
    super.b();
    if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(this.jdField_a_of_type_Int)))
    {
      Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("skin_id", "");
      int i;
      if (StringUtil.a((String)localObject)) {
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("skin_id", -1);
      } else {
        i = QwUtils.a(localObject, -1);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init data skin id: ");
      ((StringBuilder)localObject).append(i);
      QLog.i("UsualHbFragment", 2, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinLogic;
      LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.I);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = localLinearLayout;
      ((HbSkinLogic)localObject).a(localLinearLayout);
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent()).setVisibility(0);
      if (-1 != i) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinLogic.a(i);
      }
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinLogic.a(new UsualHbFragment.2(this));
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinLogic.a(this.jdField_a_of_type_AndroidOsBundle);
    }
  }
  
  public int c()
  {
    if ((jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(this.jdField_a_of_type_Int))) && (this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinLogic.a() == -2)) {
      return 8;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.u)
    {
      d();
      return;
    }
    if (i == R.id.f)
    {
      a("hongbao.wrap.vip", "");
      if (512 == this.jdField_a_of_type_Int)
      {
        paramView = new StringBuilder();
        paramView.append("https://h5.qzone.qq.com/redpacket/skin/index?_proxy=1&_wv=16777219&feedsid=");
        paramView.append(this.jdField_a_of_type_AndroidOsBundle.getString("feedsid"));
        a(paramView.toString());
        return;
      }
      a(((IIndividualRedPacket)((BaseQQAppInterface)this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getAppRuntime()).getRuntimeService(IIndividualRedPacket.class)).getMallURL(3));
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(this.jdField_a_of_type_Int))) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinLogic.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(this.jdField_a_of_type_Int))) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinLogic.c();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (String.valueOf(2).equals(this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo.bus_type))
      {
        a("hongbao.wrap.random", "");
        return;
      }
      a("hongbao.wrap.identical", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.UsualHbFragment
 * JD-Core Version:    0.7.0.1
 */