package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.HbInfo.BundleInfo;
import com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ChooseItemView;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbBusiUtils;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class LingHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ChooseItemView jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  
  public LingHbFragment()
  {
    this.jdField_b_of_type_Int = 5;
  }
  
  private void e()
  {
    if (!b()) {
      return;
    }
    int i = QwUtils.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 1);
    String str = QwUtils.a(String.valueOf(QwUtils.a(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString())));
    if (TextUtils.isEmpty(str))
    {
      QQToast.a(getActivity(), R.string.h, 0).a();
      return;
    }
    Object localObject = c();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo, this.jdField_a_of_type_Int, i, str, "hongbao.wrap.go");
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getMapPacketExtra();
    localMap.put("channel", String.valueOf(this.jdField_a_of_type_Int));
    localMap.put("type", "1");
    localMap.put("wishing", localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("");
    localMap.put("total_num", ((StringBuilder)localObject).toString());
    localMap.put("total_amount", str);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplSendHbLogic.a(localMap);
    ReportUtils.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "redpack.paybtn.click", null, this.jdField_a_of_type_ComTencentMobileqqQwalletHbHbInfo$BundleInfo.panel_name);
  }
  
  protected String a()
  {
    int i;
    if (32 == this.jdField_a_of_type_Int) {
      i = R.string.bp;
    } else {
      i = R.string.bo;
    }
    return HardCodeUtil.a(i);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    QLog.i("LingHbFragment", 2, "init view...");
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView = new ChooseItemView(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity, new LingHbFragment.1(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.aJ));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    if (this.jdField_a_of_type_Int == 65536) {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.cx)).setText(R.string.i);
    }
  }
  
  public boolean a()
  {
    if ((super.a()) && (TextUtils.isEmpty(b()))) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    return this.jdField_a_of_type_AndroidWidgetButton.isEnabled();
  }
  
  public int b()
  {
    return R.layout.m;
  }
  
  public String b()
  {
    return this.c.getText().toString();
  }
  
  public void b()
  {
    super.b();
    d();
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new LingHbFragment.2(this));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.a(this.jdField_a_of_type_JavaUtilList, true, new LingHbFragment.3(this), new LingHbFragment.4(this), new LingHbFragment.5(this));
    this.c.setFocusable(true);
    this.c.setOnFocusChangeListener(new LingHbFragment.6(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplChooseItemView.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
  }
  
  public String c()
  {
    String str1 = b();
    if (65536 == this.jdField_a_of_type_Int)
    {
      if (HbBusiUtils.a(str1) < 4)
      {
        QQToast.a(getActivity(), R.string.af, 0).a();
        return null;
      }
      String str2 = HbBusiUtils.a(str1);
      if (str2.length() > 0)
      {
        QQToast.a(getActivity(), String.format(getString(R.string.ae), new Object[] { Character.valueOf(str2.charAt(0)) }), 0).a();
        return null;
      }
    }
    return str1;
  }
  
  public void d()
  {
    Object localObject1 = ((IQWalletConfigService)((QBaseActivity)getActivity()).getAppRuntime().getRuntimeService(IQWalletConfigService.class, "")).getConfig("hb_recommend");
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      Object localObject2 = ((JSONObject)localObject1).optJSONObject("control");
      if (localObject2 != null)
      {
        this.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("num_per_page", 5);
        if (this.jdField_b_of_type_Int <= 0) {
          this.jdField_b_of_type_Int = 5;
        }
      }
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      localObject1 = ((JSONObject)localObject1).optJSONArray("recommends");
      if (localObject1 != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject3 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject3 != null)
          {
            long l2 = QWalletTools.a(((JSONObject)localObject3).optString("begintime"), -1L);
            long l3 = QWalletTools.a(((JSONObject)localObject3).optString("endtime"), 9223372036854775807L);
            if ((l1 >= l2) && (l1 <= l3))
            {
              localObject2 = ((JSONObject)localObject3).optString("text");
              int j = ((JSONObject)localObject3).optInt("flag", 0);
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).length() <= 18))
              {
                int k = this.jdField_a_of_type_Int;
                if (k == 32)
                {
                  if ((j & 0x1) != 0)
                  {
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("ling txt = ");
                    ((StringBuilder)localObject3).append((String)localObject2);
                    QLog.i("LingHbFragment", 2, ((StringBuilder)localObject3).toString());
                    this.jdField_a_of_type_JavaUtilList.add(localObject2);
                  }
                }
                else if ((j & 0x2) != 0)
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("ling voice = ");
                  ((StringBuilder)localObject3).append((String)localObject2);
                  QLog.i("LingHbFragment", 2, ((StringBuilder)localObject3).toString());
                  this.jdField_a_of_type_JavaUtilList.add(localObject2);
                }
              }
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.u) {
      e();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      a("hongbao.wrap.hopngbaokey", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.LingHbFragment
 * JD-Core Version:    0.7.0.1
 */