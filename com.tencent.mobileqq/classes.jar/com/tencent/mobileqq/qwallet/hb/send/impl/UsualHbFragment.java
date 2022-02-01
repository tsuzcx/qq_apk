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
import com.tencent.mobileqq.qwallet.hb.aio.impl.QWalletRedPkgUtils;
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
  private static final List<Integer> r = new UsualHbFragment.1();
  private TextView o;
  private LinearLayout p;
  private HbSkinLogic q;
  
  private void l()
  {
    if (!i()) {
      return;
    }
    int i = QwUtils.a(this.c.getText().toString(), 1);
    String str = QwUtils.b(String.valueOf(g()));
    if (TextUtils.isEmpty(str))
    {
      QQToast.makeText(getActivity(), R.string.h, 0).show();
      return;
    }
    a(this.m, k(), i, str, "hongbao.wrap.go");
    Object localObject2 = this.l.getText().toString();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      if (TextUtils.isEmpty(this.l.getHint())) {
        localObject1 = getResources().getString(R.string.L);
      } else {
        localObject1 = this.l.getHint().toString();
      }
    }
    int j = k();
    localObject2 = this.f.getMapPacketExtra();
    ((Map)localObject2).put("channel", String.valueOf(j));
    ((Map)localObject2).put("type", "1");
    ((Map)localObject2).put("wishing", localObject1);
    ((Map)localObject2).put("bus_type", this.e.getString("bus_type"));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append("");
    ((Map)localObject2).put("total_num", ((StringBuilder)localObject1).toString());
    ((Map)localObject2).put("total_amount", str);
    if (512 == j) {
      ((Map)localObject2).put("feeds_sid", this.e.getString("feedsid"));
    }
    if (this.q.d())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(HbSkinInfo.d);
      ((Map)localObject2).put("skin_id", ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.q.e());
      ((Map)localObject2).put("skin_id", ((StringBuilder)localObject1).toString());
    }
    this.h.a((Map)localObject2);
    ReportUtils.a(this.g, "redpack.paybtn.click", null, this.m.panel_name);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    QLog.i("UsualHbFragment", 2, "init view...");
    this.q = this.f.getHbSkinLogic();
    this.b.setOnClickListener(this);
    this.o = ((TextView)this.a.findViewById(R.id.k));
    this.o.setOnClickListener(this);
    if (QWalletRedPkgUtils.a(this.m.recv_type)) {
      this.a.findViewById(R.id.bn).setVisibility(8);
    }
    paramBundle = (TextView)this.a.findViewById(R.id.cL);
    if (String.valueOf(2).equals(this.m.bus_type))
    {
      paramBundle.setText(R.string.G);
      return;
    }
    paramBundle.setText(R.string.H);
  }
  
  public void c()
  {
    super.c();
    if (r.contains(Integer.valueOf(this.i)))
    {
      Object localObject = this.e.getString("skin_id", "");
      int i;
      if (StringUtil.isEmpty((String)localObject)) {
        i = this.e.getInt("skin_id", -1);
      } else {
        i = QwUtils.a(localObject, -1);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init data skin id: ");
      ((StringBuilder)localObject).append(i);
      QLog.i("UsualHbFragment", 2, ((StringBuilder)localObject).toString());
      localObject = this.q;
      LinearLayout localLinearLayout = (LinearLayout)this.a.findViewById(R.id.N);
      this.p = localLinearLayout;
      ((HbSkinLogic)localObject).a(localLinearLayout);
      ((ViewGroup)this.p.getParent()).setVisibility(0);
      if (-1 != i) {
        this.q.a(i);
      }
      this.q.a(new UsualHbFragment.2(this));
      this.q.a(this.e);
    }
  }
  
  protected String d()
  {
    return HardCodeUtil.a(R.string.dl);
  }
  
  protected float g()
  {
    float f = QwUtils.a(this.d.getText().toString());
    if (QwUtils.a(this.m.bus_type, 1) == 1) {
      return QwUtils.a(this.c.getText().toString(), 0) * f;
    }
    return f;
  }
  
  public int j()
  {
    return R.layout.u;
  }
  
  public int k()
  {
    if ((r.contains(Integer.valueOf(this.i))) && (this.q.e() == -2)) {
      return 8;
    }
    return this.i;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.z)
    {
      l();
      return;
    }
    if (i == R.id.k)
    {
      a("hongbao.wrap.vip", "");
      if (512 == this.i)
      {
        paramView = new StringBuilder();
        paramView.append("https://h5.qzone.qq.com/redpacket/skin/index?_proxy=1&_wv=16777219&feedsid=");
        paramView.append(this.e.getString("feedsid"));
        a(paramView.toString());
        return;
      }
      a(((IIndividualRedPacket)((BaseQQAppInterface)this.f.getAppRuntime()).getRuntimeService(IIndividualRedPacket.class)).getMallURL(3));
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (r.contains(Integer.valueOf(this.i))) {
      this.q.a(this.p);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (r.contains(Integer.valueOf(this.i))) {
      this.q.c();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (String.valueOf(2).equals(this.m.bus_type))
      {
        a("hongbao.wrap.random", "");
        return;
      }
      a("hongbao.wrap.identical", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.UsualHbFragment
 * JD-Core Version:    0.7.0.1
 */