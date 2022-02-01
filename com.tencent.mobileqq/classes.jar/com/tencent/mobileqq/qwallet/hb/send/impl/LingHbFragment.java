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
  private ChooseItemView o;
  private RelativeLayout p;
  private List<String> q = new ArrayList();
  private int r = 5;
  
  private void m()
  {
    if (!i()) {
      return;
    }
    int i = QwUtils.a(this.c.getText().toString(), 1);
    String str = QwUtils.b(String.valueOf(QwUtils.a(this.d.getText().toString())));
    if (TextUtils.isEmpty(str))
    {
      QQToast.makeText(getActivity(), R.string.h, 0).show();
      return;
    }
    Object localObject = l();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    a(this.m, this.i, i, str, "hongbao.wrap.go");
    Map localMap = this.f.getMapPacketExtra();
    localMap.put("channel", String.valueOf(this.i));
    localMap.put("type", "1");
    localMap.put("wishing", localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("");
    localMap.put("total_num", ((StringBuilder)localObject).toString());
    localMap.put("total_amount", str);
    this.h.a(localMap);
    ReportUtils.a(this.g, "redpack.paybtn.click", null, this.m.panel_name);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    QLog.i("LingHbFragment", 2, "init view...");
    this.o = new ChooseItemView(this.f, new LingHbFragment.1(this));
    this.p = ((RelativeLayout)this.a.findViewById(R.id.aR));
    this.b.setOnClickListener(this);
    this.l.addTextChangedListener(this.n);
    if (this.i == 65536) {
      ((TextView)this.a.findViewById(R.id.cN)).setText(R.string.i);
    }
  }
  
  public void c()
  {
    super.c();
    k();
    this.a.setOnClickListener(new LingHbFragment.2(this));
    this.o.a(this.q, true, new LingHbFragment.3(this), new LingHbFragment.4(this), new LingHbFragment.5(this));
    this.l.setFocusable(true);
    this.l.setOnFocusChangeListener(new LingHbFragment.6(this));
    this.p.addView(this.o);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
  }
  
  protected String d()
  {
    int i;
    if (32 == this.i) {
      i = R.string.bt;
    } else {
      i = R.string.bs;
    }
    return HardCodeUtil.a(i);
  }
  
  public String f()
  {
    return this.l.getText().toString();
  }
  
  public boolean h()
  {
    if ((super.h()) && (TextUtils.isEmpty(f()))) {
      this.b.setEnabled(false);
    }
    return this.b.isEnabled();
  }
  
  public int j()
  {
    return R.layout.p;
  }
  
  public void k()
  {
    Object localObject1 = ((IQWalletConfigService)((QBaseActivity)getActivity()).getAppRuntime().getRuntimeService(IQWalletConfigService.class, "")).getConfig("hb_recommend");
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      Object localObject2 = ((JSONObject)localObject1).optJSONObject("control");
      if (localObject2 != null)
      {
        this.r = ((JSONObject)localObject2).optInt("num_per_page", 5);
        if (this.r <= 0) {
          this.r = 5;
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
                int k = this.i;
                if (k == 32)
                {
                  if ((j & 0x1) != 0)
                  {
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("ling txt = ");
                    ((StringBuilder)localObject3).append((String)localObject2);
                    QLog.i("LingHbFragment", 2, ((StringBuilder)localObject3).toString());
                    this.q.add(localObject2);
                  }
                }
                else if ((j & 0x2) != 0)
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("ling voice = ");
                  ((StringBuilder)localObject3).append((String)localObject2);
                  QLog.i("LingHbFragment", 2, ((StringBuilder)localObject3).toString());
                  this.q.add(localObject2);
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
  
  public String l()
  {
    String str1 = f();
    if (65536 == this.i)
    {
      if (HbBusiUtils.a(str1) < 4)
      {
        QQToast.makeText(getActivity(), R.string.af, 0).show();
        return null;
      }
      String str2 = HbBusiUtils.b(str1);
      if (str2.length() > 0)
      {
        QQToast.makeText(getActivity(), String.format(getString(R.string.ae), new Object[] { Character.valueOf(str2.charAt(0)) }), 0).show();
        return null;
      }
    }
    return str1;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.z) {
      m();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.LingHbFragment
 * JD-Core Version:    0.7.0.1
 */