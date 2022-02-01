package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ChooseItemView;
import com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.IWordChainBiz;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils.RspGroupWordsListInfo;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils.RspRecommendInfo;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.ShengpiziBizImpl;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.qqwallet.GetRecommendWords.CopyWriter;

public class ShengpiziHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private TextView A;
  private long B = 0L;
  private List<GetRecommendWords.CopyWriter> C = new CopyOnWriteArrayList();
  List<GetRecommendWordUtils.RspGroupWordsListInfo> o = new ArrayList();
  CharSequence p = "";
  String q = "";
  RelativeLayout r;
  private ShengpiziHbFragment.ShengpiziHbBundleInfo s = new ShengpiziHbFragment.ShengpiziHbBundleInfo();
  private GetRecommendWordUtils.RspRecommendInfo t;
  private ChooseItemView u;
  private ArrayList<String> v = new ArrayList();
  private IWordChainBiz w;
  private int x = 5;
  private EditText y;
  private LinearLayout z;
  
  private void a(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    this.u.setIsShow(false);
    paramTextView.setTextColor(Color.parseColor("#FF2151"));
    int i = ((Integer)paramTextView.getTag()).intValue();
    GetRecommendWordUtils.RspGroupWordsListInfo localRspGroupWordsListInfo = (GetRecommendWordUtils.RspGroupWordsListInfo)this.o.get(i);
    this.u.a(localRspGroupWordsListInfo.wordList, false, new ShengpiziHbFragment.3(this, paramTextView), new ShengpiziHbFragment.4(this), null);
    this.y.setFocusable(true);
    if (this.p.equals(paramTextView.getText())) {
      this.u.a(this.q, false);
    } else {
      this.u.c();
    }
    this.u.setClipToPadding(false);
    this.u.post(new ShengpiziHbFragment.5(this));
  }
  
  private void m()
  {
    if (!StringUtil.isEmpty(this.s.biz_params)) {
      try
      {
        String str = new JSONObject(this.s.biz_params).optString("subject", "");
        if (!TextUtils.isEmpty(str))
        {
          this.y.setText(str);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void n()
  {
    this.v.clear();
    int i = 0;
    while (i < this.o.size())
    {
      GetRecommendWordUtils.RspGroupWordsListInfo localRspGroupWordsListInfo = (GetRecommendWordUtils.RspGroupWordsListInfo)this.o.get(i);
      this.v.add(localRspGroupWordsListInfo.name);
      i += 1;
    }
  }
  
  private void o()
  {
    n();
    this.z.post(new ShengpiziHbFragment.2(this));
  }
  
  private void p()
  {
    TextView localTextView = this.A;
    if (localTextView != null) {
      localTextView.setTextColor(Color.parseColor("#898D9B"));
    }
  }
  
  private void q()
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
    Object localObject2 = f();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = (String)this.y.getHint();
    }
    a(this.s, this.i, i, str, "hongbao.wrap.go");
    localObject2 = this.f.getMapPacketExtra();
    ((Map)localObject2).put("channel", String.valueOf(this.i));
    ((Map)localObject2).put("type", "1");
    ((Map)localObject2).put("wishing", localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append("");
    ((Map)localObject2).put("total_num", ((StringBuilder)localObject1).toString());
    ((Map)localObject2).put("total_amount", str);
    if (this.s.skinId > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.s.skinId);
      ((StringBuilder)localObject1).append("");
      ((Map)localObject2).put("skin_id", ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("type", "shengpizi");
      ((Map)localObject2).put("client_extend", ((JSONObject)localObject1).toString());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.h.a((Map)localObject2);
    ReportUtils.a(this.g, "redpack.paybtn.click", null, this.s.panel_name);
  }
  
  private void r()
  {
    GetRecommendWordUtils.RspRecommendInfo localRspRecommendInfo = this.t;
    if ((localRspRecommendInfo == null) || (localRspRecommendInfo.a == null) || (this.t.a.size() <= 0) || (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.t.b) > 86400000L)) {
      GetRecommendWordUtils.a(this.g, 4, this.s.recv_type, new ShengpiziHbFragment.6(this));
    }
  }
  
  public String a(boolean paramBoolean)
  {
    try
    {
      if ((this.s != null) && (this.w != null))
      {
        String str = this.w.a(l(), paramBoolean);
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ShengPiZiHbFragment", 1, localThrowable, new Object[0]);
    }
    return "";
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    HbInfo.a(paramBundle, this.s);
    k();
    QLog.i("ShengPiZiHbFragment", 2, "init view...");
    this.y = ((EditText)this.a.findViewById(R.id.H));
    if (!TextUtils.isEmpty(this.s.hint)) {
      this.y.setHint(this.s.hint);
    }
    this.r = ((RelativeLayout)this.a.findViewById(R.id.aR));
    this.u = new ChooseItemView(getContext(), null);
    this.u.setStyle(1);
    this.u.setTextSizeInDp(15);
    this.u.setBackgroundResource(R.drawable.aq);
    this.r.addView(this.u);
    paramBundle = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
    paramBundle.width = -1;
    paramBundle.height = b();
    this.b.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.y.setFocusable(true);
    this.y.addTextChangedListener(this.n);
    this.c.addTextChangedListener(this.n);
    this.a.findViewById(R.id.aF).setOnClickListener(this);
    this.z = ((LinearLayout)this.a.findViewById(R.id.J));
  }
  
  public void c()
  {
    e();
    m();
    this.o = GetRecommendWordUtils.b();
    List localList = this.o;
    if ((localList != null) && (localList.size() > 0)) {
      o();
    }
    GetRecommendWordUtils.a(this.g, 4, new ShengpiziHbFragment.1(this));
  }
  
  protected String d()
  {
    return HardCodeUtil.a(R.string.cN);
  }
  
  protected void dj_()
  {
    super.dj_();
    this.w = new ShengpiziBizImpl();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NetConnInfoCenter.getServerTime());
    localStringBuilder.append("");
    ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "rarelyword.wrappacket.show", 0, 0, "", localStringBuilder.toString(), "", "");
  }
  
  public String f()
  {
    return this.y.getText().toString();
  }
  
  public boolean h()
  {
    super.h();
    return this.b.isEnabled();
  }
  
  public int j()
  {
    return R.layout.s;
  }
  
  public void k()
  {
    try
    {
      JSONObject localJSONObject = RedPacketManagerImpl.getHbPannelConfig(16);
      if (localJSONObject != null)
      {
        this.s.skinId = localJSONObject.optInt("skinId");
        this.s.hint = localJSONObject.optString("hint");
        this.s.expl_prefix_url = localJSONObject.optString("expl_prefix_url");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public List<GetRecommendWords.CopyWriter> l()
  {
    GetRecommendWordUtils.RspRecommendInfo localRspRecommendInfo = this.t;
    if (localRspRecommendInfo != null) {
      return localRspRecommendInfo.a;
    }
    return this.C;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.z)
    {
      q();
      return;
    }
    if (i == R.id.aF)
    {
      this.f.addHbUploadData("idiom.wrappacket.random");
      long l = System.currentTimeMillis();
      if (this.B + 100L > l) {
        return;
      }
      this.B = l;
      paramView = a(true);
      this.y.setText(paramView);
      paramView = this.y;
      paramView.setSelection(paramView.getText().length());
      r();
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
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ShengpiziHbFragment
 * JD-Core Version:    0.7.0.1
 */